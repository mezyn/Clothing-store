
public class Review {

    String ID; //attribute
    String comment; //attribute
    double grade; //attribute

    public Review(String ID, String comment, double grade){

        this.ID = ID;
        this.grade = grade;
        this.comment= comment; //Should it be set as null? -M
    }
    @Override
    public String toString() {
        return  "<" + this.ID + ">: <" + this.grade + ">. <" + this.comment + ">";
    }


    public String getID() {return ID;}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }



}


