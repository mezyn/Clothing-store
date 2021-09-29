
public class CreateReview { // we need to import the arraylist from item to be able to search for an ID.

    String Id; //attribute
    String comment; //attribute
    double rating; //attribute

    //constructor
    public CreateReview(String Id, String notation, double ranking) {

        this.Id = Id;
        this.rating = ranking;
        this.comment = notation;
    }

    public static CreateReview reviewer() {

        System.out.println("To create a review for a item please enter ID of item:");

            String Id = UserInput.readLine("ID number: "); // I guess here we want to add an attribute for the ID: X ? ASK TA
            String notation = UserInput.readLine("What did you like or dislike about this item?: ");
            double ranking = UserInput.readDouble("Enter a grade: ");


                CreateReview newReview = new CreateReview(Id, notation, ranking);

                System.out.println("Your item review was registered successfully.");

                System.out.println("ID: " + Id + " Comment: " + notation + " Grade: " + ranking);

                System.out.println("Returning to Item Menu....");
                Review.ReviewMenu();

                return newReview;


    }

}

/* I think that we need to add the double grade and String notation for an item here aswell.
    So that we can use setter in review to change the attributes in this file, so we will just leave them empty
     until we set the attributes from createReview file. Not sure if this is the best way? // Carl */