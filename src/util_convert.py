#!/usr/bin/python3
# coding: utf-8
import sys
import os


class UtilConverter:
    @staticmethod
    def read_file(file_name):
        # os.path.join(folder, file_name)
        with open(file_name) as file:
            result = file.read()
            file.close()
        return result

    @staticmethod
    def read_file_in_lines(file_name):
        # os.path.join(folder, file_name)
        with open(file_name) as file:
            result = file.readlines()
            file.close()
        return result

    @staticmethod
    def write_file_in_lines(file_path_name, file_content_new):
        with open(file_path_name, 'w') as file:
            file.writelines(file_content_new)
            file.close()

    def convert(self, file_path_name, file_path_name_dest):
        file_content = UtilConverter.read_file(file_path_name)
        if 'proto3' in file_content:
            print("The file is proto3 format.")
            return

        file_content_list = UtilConverter.read_file_in_lines(file_path_name)
        file_content_list_new = []

        # add 1st line
        if 'proto2' not in file_content:
            file_content_list_new.append('syntax = "proto3";')
            file_content_list_new.append('\n')

        for str_line in file_content_list:
            str_line1 = str_line.replace('proto2', 'proto3')
            str_line1 = str_line1.replace('required ', '')
            str_line1 = str_line1.replace('optional ', '')
            str_line1 = str_line1.replace('urn:com:skyscanner:flight:intl:booking:order:contract:commontype:v1.', '')
            # Todo: how to solve 'enum' ?
            file_content_list_new.append(str_line1)

        # file_content_new = None
        UtilConverter.write_file_in_lines(file_path_name_dest, file_content_list_new)


def main(argv):
    converter = UtilConverter()
    file_name_src = os.path.join(cur_dir, argv[1])
    file_name_dest = os.path.join(cur_dir, argv[2])
    # print(file_name_src)
    # print(file_name_dest)
    converter.convert(file_name_src, file_name_dest)


if __name__ == "__main__":
    main(sys.argv)

