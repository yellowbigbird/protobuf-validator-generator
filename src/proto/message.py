from src.class_template import CLASS_VALIDATOR
from src.proto.variable import Variable


class Message:
    name = ""
    # value = None  # Variable
    list_line = []  # list<string>
    list_variable = []  # list<Variable>
    line_title = ""

    def __init__(self):
        self.name = ""
        # self.value = None
        self.list_line = []
        self.list_variable = []
        self.line_title = ""

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
        validator_class_name = self.name + 'Validator'
        file_content = file_content.replace('~validator_class_name~', validator_class_name)

        call_function = ''
        validate_functions = ''

        for variable in self.list_variable:
            function = variable.generate()
            validate_functions = validate_functions + function
            call_function = call_function + '        ' + variable.function_name + '(listStr);\n'
            pass

        file_content = file_content.replace('~call_validate_function~', call_function)
        file_content = file_content.replace('~function_validate~', validate_functions)

        print(file_content)
        return file_content

