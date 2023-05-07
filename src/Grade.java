class Grade {
    private int grade;
    private double total;
    private static final int LIMIT = 20;
    private static final int BONUS = 10;

    public Grade(int inG, double inT){
        grade = inG;

        if(inT > LIMIT){
            total = total + BONUS;
        }
        else {
            total = inT;
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double inT) {
        if (inT > LIMIT) {
            total = inT + BONUS;
        } else {
            total = inT;
        }

    }

    public String toString(){
        return "Grade: " + grade + "    " + "total hours" + " " + total;
    }

}