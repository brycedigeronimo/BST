import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Scanner scanner = new Scanner(System.in);
        int numProblems = scanner.nextInt();
        String[] phrases = {};
        String cmd = "";
        int number = 0;
        String string1 = scanner.nextLine();

        for(int i = 0; i < numProblems; i++) {
            string1 = scanner.nextLine();
            phrases = string1.split(" ");
            cmd = phrases[0];
            if(cmd.equals("insert") || cmd.equals("delete") || cmd.equals("find")) {
                number = Integer.parseInt(phrases[1]); //to prevent an array indexing error, define number inside this if statement
            }
            switch (cmd) {
                case "insert":
                    bst.insert(number);
                    break;
                case "delete":
                    bst.delete(bst.getRoot(), number);
                    break;
                case "find":
                    bst.find(number);
                    break;
                case "inorder":
                    bst.traverse("inorder", bst.getRoot());
                    System.out.println();
                    break;
                case "preorder":
                    bst.traverse("preorder", bst.getRoot());
                    System.out.println();
                    break;
                case "postorder":
                    bst.traverse("postorder", bst.getRoot());
                    System.out.println();
                    break;
                default:
                    System.out.println("Couldn't find command");
                    break;
            }

        }
        scanner.close();
    }

}

