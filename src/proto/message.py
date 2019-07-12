import os

from src.class_template import CLASS_VALIDATOR, PROTO_IMPORT_NAMESPACE
from src.proto.constaints import VARIABLE_BASIC_TYPE_LIST
from src.proto.variable import Variable
from src.util_file import UtilFile


class Message:
    name = ""
    # value = None  # Variable
    list_line = []  # list<string>
    list_variable = []  # list<Variable>
    line_title = ""
    file_content = ''

    def __init__(self):
        self.name = ""
        # self.value = None
        self.list_line = []
        self.list_variable = []
        self.line_title = ''
        self.file_content = ''

    def parse(self):
        # title
        str = self.line_title.strip()
        str = str.replace('message ', '')
        str = str.replace(' {', '')
        self.name = str

        # variable
        for str_line in self.list_line:
            var0 = Variable()
            var0.parse(str_line)

            self.list_variable.append(var0)
            pass
        pass

    def generate(self)->str:
        file_content = CLASS_VALIDATOR
        file_content = file_content.replace('~proto_class_name~', self.name)
        validator_class_name = '{0}Validator'.format(self.name)
        file_content = file_content.replace('~validator_class_name~', validator_class_name)

        call_function = ''
        validate_functions = ''

        for variable in self.list_variable:
            # if validation exist
            if not variable.is_validation_exist():
                continue
            function = variable.generate()
            validate_functions = validate_functions + function
            call_function = '{0}        {1}(listStr);\n'.format(call_function, variable.function_name)

        import_other_proto_class = ''  # self.generate_other_proto_import()

        file_content = file_content.replace('~call_validate_function~', call_function)
        file_content = file_content.replace('~function_validate~', validate_functions)
        file_content = file_content.replace('~import_other_proto_class~', import_other_proto_class)

        # print(file_content)
        self.file_content = file_content
        return file_content

    def generate_other_proto_import(self):
        content = ''
        for variable in self.list_variable:
            if variable.str_type not in VARIABLE_BASIC_TYPE_LIST:
                content = '{0}{1}{2};'.format(content, PROTO_IMPORT_NAMESPACE, variable.str_type)
        print(content)
        return content

    def write_file(self, dest_path):
        validator_class_name = '{0}Validator.java'.format(self.name)
        file_name_dest = os.path.join(dest_path, validator_class_name)
        UtilFile.write_file(file_name_dest, self.file_content)
        pass

