
public class CreateReview { // we need to import the arraylist from item to be able to search for an ID.

    String ID; //attribute
    String comment; //attribute
    double rating; //attribute


    public CreateReview(String ID, String comment, double rating) {

        this.ID = ID;
        this.rating = rating;
        this.comment = comment;

    }

    public static CreateReview CreateReview() {


        System.out.println("To create a review for a item please enter ID of item:");

            String ID = UserInput.readLine("ID number: "); // I guess here we want to add an attribute for the ID: X ? ASK TA
            String comment = UserInput.readLine("What did you like or dislike about this item?: ");
            double rating = UserInput.readDouble("Grade values must be between 1 and 5.");

            if (rating > 1 || rating < 5){ // not done with the loop, temporary!
            System.out.println("Invalid number: Grade values must be between 1 and 5.");

        }


        CreateReview newCreateReviewItem = new CreateReview(ID, comment, rating);
        System.out.println("Your item review was registered successfully.");

        return newCreateReviewItem;

    }

}

