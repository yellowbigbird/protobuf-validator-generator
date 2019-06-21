import os
import sys

from resource import res_dir
from src.proto.message import Message
from src.util_file import UtilFile


class Generator:
    list_message = []

    def convert(self, file_path_name, file_path_name_dest):
        file_content = UtilFile.read_file(file_path_name)
        # print(file_content)
        if 'proto3' not in file_content:
            print("The file is not proto3 format.")
            return

        # parse
        file_content_list = UtilFile.read_file_in_lines(file_path_name)
        self.parse_proto(file_content_list)

        # generate
        for msg in self.list_message:
            msg.generate()
            msg.write_file(file_path_name_dest)
        pass

    def parse_proto(self, file_content_list):
        msg = Message()
        is_msg_started = False

        for str_line in file_content_list:
            str_line = str_line.strip()

            # remove content
            if str_line.find('//', 0, 2) == 0:
                continue

            # fine msg start
            if "message " in str_line and "{" in str_line:
                is_msg_started = True
                msg.line_title = str_line
                continue

            if str_line.find('}', 0, 2) == 0:
                # msg end
                is_msg_started = False
                # add to msg list
                self.list_message.append(msg)
                # create new msg
                msg = Message()

            if str_line in ['\n', '']:
                continue

            if is_msg_started:
                msg.list_line.append(str_line)
                continue

        for msg in self.list_message:
            msg.parse()
        pass

    # def generate_class(self, msg):
    #     pass

    # def generate_method(self):
    #     pass


def main(argv):
    converter = Generator()
    file_name_src = os.path.join(res_dir, argv[1])
    file_name_dest = os.path.join(res_dir, argv[2])
    # # print(file_name_src)
    # # print(file_name_dest)
    converter.convert(file_name_src, file_name_dest)


if __name__ == "__main__":
    main(sys.argv)