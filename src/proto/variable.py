from src.class_template import FUNCTION_TEMPLATE, VALIDATION_TEMPLATE_NO_PARAM, VALIDATION_TEMPLATE_WITH_PARAM, \
    VALIDATION_TEMPLATE_OTHER_CLASS, VALIDATION_TEMPLATE_CHECK_HAS
from src.proto.constaints import VALIDATION_NO_PARAM_LIST, VARIABLE_BASIC_TYPE_LIST


class Variable:
    name = ""
    proto_name = ''
    str_type = ''
    str_order = ''
    function_name = ''
    list_validation = []  # string

    def __init__(self):
        self.name = ""
        self.proto_name = ''
        self.str_type = ""
        self.str_order = ''
        self.function_name = ''
        self.list_validation = []

    def parse(self, str_line):
        # split 2 part
        list_content = str_line.split('//')
        if len(list_content) > 1:
            # string validation
            self.parse_validation(list_content[1])
        str = list_content[0]
        str = str.strip()
        str = str.replace(';', '')
        listEqual = str.split('=')

        strLeft = listEqual[0]
        strLeft = strLeft.strip()
        listLeft = strLeft.split(' ')
        if len(listLeft) < 2:
            return
        self.str_type = listLeft[0]
        self.name = listLeft[1]
        self.proto_name = self.convert_proto_name(self.name)

        if len(listEqual) < 2:
            return
        self.str_order = listEqual[1]
        pass

    def parse_validation(self, str_validation):
        str_validation = str_validation.strip()
        if str_validation.find('validate') < 0:
            return
        str_list = str_validation.replace('validate', '')
        str_list = str_list.replace('[', '')
        str_list = str_list.replace(']', '')
        str_list = str_list.strip()
        list_str = str_list.split(',')
        if len(list_str) < 1:
            return
        for str1 in list_str:
            self.list_validation.append(str1.strip())
        pass

    def generate(self)->str:
        content = FUNCTION_TEMPLATE
        self.function_name = 'validate{0}'.format(self.proto_name)
        content = content.replace('~function_name~', self.function_name)
        content = content.replace('~name~', self.name)
        proto_get_function = 'get{0}'.format(self.proto_name)
        content = content.replace('~proto_get_function~', proto_get_function)

        check_call = ''
        for validation in self.list_validation:
            check_call = check_call + self.generate_single_validation(validation)

        # is basic type, add get summary
        if self.str_type not in VARIABLE_BASIC_TYPE_LIST:
            check_call = check_call + '\n' + self.generate_single_class_validation()
        content = content.replace('~check_call~', check_call)

        # print(content)
        return content

    def generate_single_validation(self, validation):
        content = VALIDATION_TEMPLATE_NO_PARAM if validation in VALIDATION_NO_PARAM_LIST \
            else VALIDATION_TEMPLATE_WITH_PARAM

        # get param
        validation = validation.strip()
        temp = validation.replace(')', '')
        list1 = temp.split('(')
        name = list1[0]
        param = list1[1] if len(list1)>1 else ''

        # is basic type
        if self.str_type not in VARIABLE_BASIC_TYPE_LIST and name == 'null':
            content = VALIDATION_TEMPLATE_CHECK_HAS
            name = 'has'
            content = content.replace('~proto_name~', self.proto_name)

        content = content.replace('~FULL_VALIDATION~', validation)
        content = content.replace('~CHECK_NAME~', name.title())
        content = content.replace('~PARAM~', param)

        # print(content)
        return content

    def generate_single_class_validation(self):
        content = VALIDATION_TEMPLATE_OTHER_CLASS
        other_validator_name = '{0}Validator'.format(self.str_type)
        content = content.replace('~OTHER_VALIDATOR_NAME~', other_validator_name)
        # print(content)
        return content

    @staticmethod
    def convert_proto_name(name):
        list_name = name.split('_')
        converted = ''
        for str1 in list_name:
            converted += str1.title()
        return converted

