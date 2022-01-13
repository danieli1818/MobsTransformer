
import os

ROOT_PATH = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def create_folder(name, path=ROOT_PATH):
    os.mkdir(os.path.join(path, name))


def delete_folder(name, path=ROOT_PATH):
    os.rmdir(os.path.join(path, name))
