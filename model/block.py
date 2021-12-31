
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

    def _check_if_contains_all_faces(self):
        return all(face in self.faces.keys() for face in ["north", "south", "east", "west", "up", "down"])

    def _sort_faces(self):
        for face_name, face_uv in self.faces.items():
            face_uv = sorted(face_uv, key=lambda point: point[0])
            face_uv = sorted(face_uv, key=lambda point: point[1])
            self.faces[face_name] = face_uv

    def get_tx(self):
        return self.faces["east"][0][0]

    def get_ty(self):
        return self.faces["up"][0][1]

