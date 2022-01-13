import copy


class Block:

    def __init__(self, x, y, z, ox, oy, oz, axis, angle, rx, ry, rz, t, faces):
        self.x = x
        self.y = y
        self.z = z
        self.ox = ox
        self.oy = oy
        self.oz = oz
        self.axis = axis
        self.angle = angle
        self.rx = rx
        self.ry = ry
        self.rz = rz
        self.t = t
        self.faces = faces
        if not self._check_if_contains_all_faces():
            raise Exception("Error not all faces of the block has texture!")
        self._sort_faces()
        self.bx = x
        self.by = y
        self.bz = z

    def _check_if_contains_all_faces(self):
        return all(face in self.faces.keys() for face in ["north", "south", "east", "west", "up", "down"])

    def _sort_faces(self):
        for face_name, face_uv in self.faces.items():
            point_1 = face_uv[0]
            point_2 = face_uv[1]
            top_left_point = (min(point_1[0], point_2[0]), min(point_1[1], point_2[1]))
            bottom_right_point = (max(point_1[0], point_2[0]), max(point_1[1], point_2[1]))
            face_uv = (top_left_point, bottom_right_point)
            self.faces[face_name] = face_uv

    def get_tx(self):
        return self.faces["east"][0][0]

    def get_ty(self):
        return self.faces["up"][0][1]

    def get_faces(self):
        return self.faces.copy()

    def __copy__(self):
        return Block(self.x, self.y, self.z, self.ox, self.oy, self.oz
                     , self.axis, self.angle, self.rx, self.ry, self.rz, self.t, self.faces)

    def __deepcopy__(self, memo):
        return Block(self.x, self.y, self.z, self.ox, self.oy, self.oz
                     , self.axis, self.angle, self.rx, self.ry, self.rz, self.t, copy.deepcopy(self.faces, memo))

    def set_texture_size(self, bx: int, by: int, bz: int):
        self.bx = bx
        self.by = by
        self.bz = bz

    def set_texture(self, tx, ty, texture_size):
        self.t = texture_size
        self.faces["east"] = ((tx, ty + self.bz), (tx + self.bz, ty + self.bz + self.by))
        self.faces["up"] = ((tx + self.bz, ty), (tx + self.bz + self.bx, ty + self.bz))
        self.faces["down"] = ((tx + self.bz + self.bx, ty), (tx + self.bz + 2 * self.bx, ty + self.bz))
        self.faces["north"] = ((tx + self.bz, ty + self.bz), (tx + self.bz + self.bx, ty + self.bz + self.by))
        self.faces["west"] = ((tx + self.bz + self.bx, ty + self.bz)
                              , (tx + self.bz + 2 * self.bx, ty + self.bz + self.by))
        self.faces["south"] = ((tx + self.bz + 2 * self.bx, ty + self.bz)
                               , (tx + 2 * self.bz + 2 * self.bx, ty + self.bz + self.by))
