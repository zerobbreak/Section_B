import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Project {

    private String name;
    private int max;
    private Student [] sArr = new Student[50];
    private int sCount;
    private Grade [] gArr = new Grade[5]; //Grades 8, 9, 10, 11, 12

    public Project(String inN, String inC, int inM){
        name = inN;
        max = inM;

        try{
            Scanner sc = new Scanner(new File("C:\\Users\\uthac\\IdeaProjects\\Section B\\Students.txt"));

            while(sc.hasNext()){
                String line = sc.nextLine();
                String [] studentData = line.split(",");
                String interest = studentData[2];

                if((inC.equals("Indoor") && (interest.equals("Indoor"))) || (inC.equals("Outdoor") && (interest.equals("Outdoor")))
                        || (inC.equals("Both") && (interest.equals("Both")))){
                    sArr[sCount] = new Student(studentData[0], Integer.parseInt(studentData[1]), studentData[2], Double.parseDouble(studentData[3]));
                    sCount++;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String result = "Name:\t" + name + "\n";
        result += "Maximum:\t" + max + "\n\n";
        for (int i = 0; i < sCount; i++) {
            result += sArr[i].toString() + "\n";
        }
        return result;
    }

    public void sort(){
        for(int i = 0; i < sCount - 1; i++){
            for(int j = i + 1; j < sCount; j++){
                if(sArr[j].getGrade() < sArr[i].getGrade()){
                    Student temp = sArr[i];
                    sArr[i] = sArr[j];
                    sArr[j] = temp;
                }
            }
        }
    }

    private void deleteStudent(int inP){
        for(int i = inP; i < sCount; i++){
            sArr[i] = sArr[i+1];
        }
        sCount--;
    }

    public String correctNumbers(){
        int amountToDelete = sCount - max;
        String deletedList = "Students removed:\n";
        if(sCount > max) {
            for (int i = 0; i < amountToDelete; i++) {
                int item = (int) (Math.random() * sCount);
                deletedList += sArr[item] + "\n";
                deleteStudent(item);
            }

        }

        return deletedList + "\nRemaining students:\n" + toString();

    }

    public void createGradeArray(String inH){
        String[] gradeData = inH.split(";");
        for (int i = 0; i < gradeData.length; i += 2){
            int grade = Integer.parseInt(gradeData[i]);
            double total = Double.parseDouble(gradeData[i + 1]);
            gArr[grade - 8] = new Grade(grade, total);
        }
    }

    public String CreateGradeArray(String inH){
        int grade;
        double hours;

        Scanner scLine = new Scanner(inH).useDelimiter(";");
        while (scLine.hasNext()){
            grade = scLine.nextInt();
            hours = scLine.nextDouble();
            gArr[grade - 8] = new Grade(grade, hours);
        }
        scLine.close();
        return displayAllGradeArray();
    }

    private String displayAllGradeArray(){
        String temp = "\nGrade Totals:\n";
        for (int i = 0; i < 5; i++){
            temp += gArr[i] + "\n";
        }
        return temp;
    }
}

