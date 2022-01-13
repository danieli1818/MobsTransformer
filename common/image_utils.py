

from PIL import Image


def open_image(image_path: str):
    try:
        return Image.open(image_path)
    except IOError:
        return None


def crop_image(image: Image, top_left_point: tuple, bottom_right_point: tuple):
    return image.crop([top_left_point[0], top_left_point[1], bottom_right_point[0], bottom_right_point[1]])


def paste_image(image_to_paste: Image, image_to_paste_to: Image, top_left_point: tuple):
    return image_to_paste_to.paste(image_to_paste, [top_left_point[0], top_left_point[1],
                                                    top_left_point[0] + image_to_paste.size[0],
                                                    top_left_point[1] + image_to_paste.size[1]])


def create_empty_image(size: tuple):
    return Image.new("RGBA", size)


def save_image(image: Image, filename: str):
    image.save(filename)
