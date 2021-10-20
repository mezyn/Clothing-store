package facade;

public class Review {

    private String comment;
    private int grade;

    public Review(String comment, int grade){

        this.comment= comment;
        this.grade = grade;

    }

    @Override
    public String toString() {return  "Grade: " + this.grade +"." + this.comment ;}

    public String getItemComment() {
        return this.comment;
    }

    public double getItemGrade() { return this.grade; }




}


