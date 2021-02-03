import java.util.Scanner;

public class DirectoriesApp {

    public static void main(String[] args) {
        DirectoriesTree directoriesTree = new DirectoriesTree();
        directoriesTree.displayAllFilesFromRoot();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println(directoriesTree.exists(name));
    }
}
