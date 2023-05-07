import java.util.Scanner;

public class ProjectUI {

    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Project pr = new Project("Collect old clothes", "Indoor", 12);
        System.out.println(pr.toString());

        pr.sort();
        System.out.println(pr);

        System.out.println(pr.correctNumbers());

        System.out.println(pr.CreateGradeArray("9;53;12;13;8;72;11;90;10;34"));
    }
}
