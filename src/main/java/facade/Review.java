package facade;

public class Review {

    private String ID;
    private String comment;
    private double grade;


    //public Review(){}

    public Review(String ID, String comment, double grade){

        this.ID = ID;
        this.comment= comment; //Should it be set as null? -M
        this.grade = grade;

    }


    @Override
    public String toString() {return  "Grade: " + this.grade +". " + this.comment ;}



    public String getID() {return ID;}

    public String getItemComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    } // Don't need this?

    public void setGrade(double grade) {
        this.grade = grade;
    } // Don't need this?

    public double getItemGrade() { return grade; }

    public String addComment(){
        return comment;}



}


