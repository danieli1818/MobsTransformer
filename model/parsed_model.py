from anytree import Node


class ParsedModel:

    def __init__(self):
        self.groups_tree = Node(None)
        self.groups_blocks = {}
        self.texture_name = None
        self.animations = None

    def add_groups_tree(self, groups_tree):
        groups_tree.parent = self.groups_tree
        return self

    def add_blocks_to_group(self, group, blocks):
        if group not in self.groups_blocks:
            self.groups_blocks[group] = []
        self.groups_blocks[group].extend(blocks)
        return self

    def add_groups_blocks(self, groups_blocks):
        self.groups_blocks.update(groups_blocks)

    def set_texture(self, texture_name):
        self.texture_name = texture_name

    def set_animations(self, animations):
        self.animations = animations

    def dfs_child_first(self):
        stack = [group for group in self.groups_tree.children]
        stack.reverse()
        processed_groups = []
        while stack:
            node = stack[-1]
            if node in processed_groups:
                stack.pop(-1)
                yield node
            else:
                stack.extend(node.children)
                processed_groups.append(node)

    def dfs_root_first(self):
        stack = [group for group in self.groups_tree.children]
        stack.reverse()
        while stack:
            node = stack.pop(-1)
            yield node
            children_copy = [group for group in node.children]
            children_copy.reverse()
            stack.extend(children_copy)

    def bfs(self):
        queue = [self.groups_tree]
        while queue:
            node = queue.pop()
            yield node
            queue.extend(node.children)



