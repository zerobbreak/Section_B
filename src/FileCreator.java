import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {

    public static void main(String[] args) {
        String fileName = "Students.txt";
        String fileContent = "Annie Morris,11,Outdoor,2\n" +
                "Lonnie Heriot,11,Indoor,3.5\n" +
                "Morris Scotty,10,Indoor,1\n" +
                "Lucius McNabb,10,Outdoor,8.5\n" +
                "Gerhard Leaby,10,Indoor,3\n" +
                "Hayden Haley,10,Outdoor,1.5\n" +
                "Carl Rabey,10,Indoor,4\n" +
                "Mary Gibbs,8,Outdoor,0\n" +
                "Myron Rhoan,8,Outdoor,3.5\n" +
                "Francisco Pettie,8,Indoor,2.5\n" +
                "Bertrand Delaney,9,Indoor,3\n" +
                "Mattie Rules,11,Outdoor,10\n" +
                "Seth Maler,8,Both,0\n" +
                "Justin Doyle,9,Both,4\n" +
                "Bessie Monahan,12,Indoor,5";

        try{
            FileWriter writer = new FileWriter(fileName);
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
