class Student{
    private final String fullName;
    private final int grade;
    private final String interest;
    private final double hours;

    public Student(String inFn, int inG, String inI, double inH){
        fullName = inFn;
        grade = inG;
        interest = inI;
        hours = inH;
    }

    //    @Override
    public int compareTo(Student other) {
        // compare by grade first
        int cmp = Integer.compare(this.grade, other.grade);
        if (cmp != 0) {
            return cmp;
        }
        // if grades are equal, compare by name
        return this.fullName.compareTo(other.fullName);
    }
    public int getGrade(){
        return grade;
    }

    public String getInterest(){
        return interest;
    }

    public double getHours() {
        return hours;
    }

    public String toString(){
        return alterName() + "   " + grade + "   " + interest + "   " + hours;
    }

    private String alterName(){
        String [] nameParts = fullName.split(" ");
        String surname = nameParts[nameParts.length - 1];
        String initial = String.valueOf(nameParts[0].charAt(0));
        return surname + ", " + initial;
    }
}