public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public BST(){
        root = null;
    }
    public Node<E> getRoot(){
        return root;
    }
    public void insert(E data){
        // if tree is empty, insert node as root
        if(root == null) {
            root = new Node(data);
            return;
        }
        //loop through entire tree until null node is found
        Node<E> currentNode = root;
        Node<E> node = new Node<>(data);
        while(true) {
            if(data.compareTo(currentNode.getData())<= 0) {
                //compareTo returns negative number if first value is less than the second, 0 if they are equal,
                // and 1 if first value is greater than second
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(node);
                    node.setParent(currentNode);
                    return;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
            else {
                if(currentNode.getRightChild() == null) {
                    currentNode.setRightChild(node);
                    node.setParent(currentNode);
                    return;
                }
                else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    public Node<E> find(E data){
        // Search the tree for a node whose data field is equal to data

        Node<E> currentNode = root;
        while(true) {
            if(currentNode.getData() == data) {
                return currentNode;
            }
            else if (data.compareTo(currentNode.getData())<= 0) {
                //compareTo returns negative number if first value is less than the second, 0 if they are equal,
                // and 1 if first value is greater than second
                if (currentNode.getLeftChild() == null) {
                    return null;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
            else {
                if(currentNode.getRightChild() == null) {
                    return null;
                }
                else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    public Node<E> delete(Node<E> node, E data) {
        // If said node has no children, simply remove it by setting its parent to point to null instead of it.
        // If said node has one child, delete it by making its parent point to its child.
        // If said node has two children, then replace it with its successor,
        // and remove the successor from its previous location in the tree.
        // The successor of a node is the left-most node in the node's right subtree.
        // If the value specified by delete does not exist in the tree, then the structure is left unchanged.
        // function uses findMin() to find the successor when there are two children

        if (root == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(node.getLeftChild(), data));
            return node;
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(node.getRightChild(), data));
            return node;
        }
        else {
            if (node.getLeftChild() != null && node.getRightChild() != null) {
                node.setData(getMin(node).getData());
                node.setRightChild(delete(node.getRightChild(), node.getData()));
                return node;
            }
            else if (node.getLeftChild() != null && node.getRightChild() == null) {
                if(node.getParent() == null) {
                    node.getLeftChild().setParent(null);
                    root = node.getLeftChild();
                    return node;
                }
                return node.getLeftChild();
            }
            else if (node.getLeftChild() == null && node.getRightChild() != null) {
                if(node.getParent() == null) {
                    node.getRightChild().setParent(null);
                    root = node.getRightChild();
                    return node;
                }
                return node.getRightChild();
            } else {
                if(node == root) {
                    root = null;
                }
                return null;
            }
        }
    }


    public void traverse(String order, Node<E> top) {
        if (top != null){
            switch (order) {
                case "preorder":
                    System.out.print(top.getData() + " ");
                    if(top.getLeftChild()!= null) {
                        traverse("preorder", top.getLeftChild());
                    }
                    if(top.getRightChild()!=null) {
                        traverse("preorder", top.getRightChild());
                    }
                    break;
                case "inorder":
                    if(top.getLeftChild()!= null) {
                        traverse("inorder", top.getLeftChild());
                    }
                    System.out.print(top.getData() + " ");
                    if(top.getRightChild()!=null) {
                        traverse("inorder", top.getRightChild());
                    }
                    break;
                case "postorder":
                    if(top.getLeftChild()!= null) {
                        traverse("postorder", top.getLeftChild());
                    }
                    if(top.getRightChild()!=null) {
                        traverse("postorder", top.getRightChild());
                    }
                    System.out.print(top.getData() + " ");
                    break;
                default:
                    System.out.println("Not a valid traversal");
                    break;
            }
        }
    }

    public Node<E> getMin(Node<E> top){
        // Return the min node(left-most node) of the right subtree
        if(top.getRightChild() == null) {
            return null;
        }
        Node<E> node = top.getRightChild();
        while(node.getLeftChild()!= null) {
            node = node.getLeftChild();
        }
        return node;
    }


    //  logic taken from https://stackoverflow.com/questions/741900/binary-trees-question-checking-for-similar-shape
    //  Check to see if trees have the same shape
    public boolean compare(Node<E> first, Node<E> second) {
        if(first == null && second == null) {
            return true;
        }
        else if(first == null && second != null || first != null && second == null) {
            return false;
        }
        else {
            return compare(first.getLeftChild(), second.getRightChild()) && compare(first.getRightChild(), second.getRightChild());
        }
    }
}


