import java.util.Scanner;
public class TreeCompare {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        BST<Integer> bst1 = new BST<>();
        Scanner scanner = new Scanner(System.in);
        int numProblems = scanner.nextInt();
        String[] phrases = {};
        int number = 0;
        String string1 = scanner.nextLine();

        for(int i = 0; i < numProblems; i++) {
            string1 = scanner.nextLine();
            phrases = string1.split(" ");
            number = Integer.parseInt(phrases[1]);
            bst.insert(number);
        }
        numProblems = scanner.nextInt();
        string1 = scanner.nextLine();

        for(int i = 0; i < numProblems; i++) {
            string1 = scanner.nextLine();
            phrases = string1.split(" ");
            number = Integer.parseInt(phrases[1]);
            bst1.insert(number);
        }

        scanner.close();
        if (bst.compare(bst.getRoot(), bst1.getRoot())) {
            System.out.println("The trees have the same shape.");
        }
        else {
            System.out.println("The trees do not have the same shape.");
        }
    }



}
