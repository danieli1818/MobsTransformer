

class KeyFrame:

    def __init__(self, x=0, y=0, z=0, rx=0, ry=0, rz=0):
        self.x = x
        self.y = y
        self.z = z
        self.rx = rx
        self.ry = ry
        self.rz = rz

    def __str__(self):
        return f"[{self.x}, {self.y}, {self.z}], [{self.rx}, {self.ry}, {self.rz}]"



