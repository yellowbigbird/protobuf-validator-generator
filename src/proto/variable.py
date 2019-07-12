from src.class_template import FUNCTION_TEMPLATE, VALIDATION_TEMPLATE_NO_PARAM, VALIDATION_TEMPLATE_WITH_PARAM, \
    VALIDATION_TEMPLATE_OTHER_CLASS, VALIDATION_TEMPLATE_CHECK_HAS
from src.proto.constaints import VALIDATION_NO_PARAM_LIST, VARIABLE_BASIC_TYPE_LIST, VALIDATION_ALL_TO_CHECK_METHOD_MAP, \
    VARIABLE_TYPE_MAP


class Variable:
    name = ""
    proto_name = ''
    str_type = ''
    str_type_2nd = '' # string in 'repeated string xxx'
    str_order = ''
    function_name = ''
    list_validation = []  # string

    def __init__(self):
        self.name = ""
        self.proto_name = ''
        self.str_type = ""
        self.str_type_2nd = ''
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
        str = str.strip()  # remove space
        str = str.replace(';', '')  # remove ';'
        listEqual = str.split('=')

        strLeft = listEqual[0]
        strLeft = strLeft.strip()
        listLeft = strLeft.split(' ')
        if len(listLeft) < 2:
            return
        self.str_type = listLeft[0]
        if len(listLeft) <3:
            self.name = listLeft[1]
        else:
            # repeated string xxx
            self.name = listLeft[2]
            self.str_type_2nd = listLeft[1] # string in 'repeated string xxx'
        self.proto_name = self.convert_proto_name(self.name)

        if len(listEqual) < 2:
            return
        self.str_order = listEqual[1]
        pass

    def parse_validation(self, str_validation):
        str_validation = str_validation.strip()
        if str_validation.find('validate') < 0:
            return
        str_list = str_validation.replace('validate[', '')  # remove '['
        str_list = str_list.strip()
        str_list = str_list[0:len(str_list)-1]  # remove last ']'
        # print(str_list)

        str_list = str_list.strip()
        list_str = str_list.split(',')
        if len(list_str) < 1:
            return
        for str1 in list_str:
            self.list_validation.append(str1.strip())
        pass

    def is_validation_exist(self):
        return len(self.list_validation)>0

    def generate(self)->str:
        # if no validation, return empty
        if not self.is_validation_exist():
            print(self.name + ' no validation.')
            return ''

        content = FUNCTION_TEMPLATE
        self.function_name = 'validate{0}'.format(self.proto_name)
        content = content.replace('~function_name~', self.function_name)
        content = content.replace('~name~', self.name)

        # if list or map
        if self.str_type in VARIABLE_TYPE_MAP:
            proto_get_function = 'get{0}{1}'.format(self.proto_name, VARIABLE_TYPE_MAP[self.str_type])
            # print(proto_get_function)
        else:
            proto_get_function = 'get{0}'.format(self.proto_name)

        if proto_get_function == 'getLegReferences':
            print(proto_get_function)

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

        if validation in VALIDATION_NO_PARAM_LIST:
            content = VALIDATION_TEMPLATE_NO_PARAM
            # print(validation + " no parama.")
        else:
            content = VALIDATION_TEMPLATE_WITH_PARAM
            # print(validation + " has parama.")

        # get param
        validation = validation.strip()
        temp = validation.replace(')', '')
        list1 = temp.split('(')
        name = list1[0]
        param = list1[1] if len(list1)>1 else ''

        if name not in VALIDATION_ALL_TO_CHECK_METHOD_MAP:
            print("Error: " + name + " not valid.")

        # is basic type, only class var can checkHas
        if self.str_type not in VARIABLE_BASIC_TYPE_LIST and name == 'has':
            # print('found has')
            content = VALIDATION_TEMPLATE_CHECK_HAS
            name = 'has'
            content = content.replace('~proto_name~', self.proto_name)

        content = content.replace('~FULL_VALIDATION~', validation)
        content = content.replace('~CHECK_NAME~', VALIDATION_ALL_TO_CHECK_METHOD_MAP[name])
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

