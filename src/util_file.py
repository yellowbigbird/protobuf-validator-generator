# import sys
# import os


class UtilFile:
    @staticmethod
    def read_file(file_name):
        # os.path.join(folder, file_name)
        with open(file_name) as file:
            result = file.read()
            # file.close()
        return result

    @staticmethod
    def write_file(file_path_name, file_content_new):
        with open(file_path_name, 'w') as file:
            file.write(file_content_new)
            # file.close()

    @staticmethod
    def read_file_in_lines(file_name):
        # os.path.join(folder, file_name)
        with open(file_name) as file:
            result = file.readlines()
            # file.close()
        return result

    @staticmethod
    def write_file_in_lines(file_path_name, file_content_new):
        with open(file_path_name, 'w') as file:
            file.writelines(file_content_new)
            # file.close()