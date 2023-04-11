public class Story {

    GameScreen gs;

    // String variables to hold the next position values and the historic text.
    String nextPosition1, nextPosition2, nextPositionInterst, historic;

    public Story(GameScreen gs){
        this.gs = gs;
    }

    // Method to select the next position based on the user's choice.
    public void selectPosition(String position){
        switch (position){
            case "wolf": wolf(); break;
            case "hunter": hunter(); break;
        }
    }

    public void showAllButtons(){
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.interst.setVisibility(View.INVISIBLE);
    }

    // Method that displays the game story when the user chooses the "wolf" option.
    public void wolf(){
        // Changes the game image to the wolf.
        gs.image.setImageResource(R.drawable.wolf);

        // Saves the current game text to the historic variable.
        historic = gs.textCenter.getText().toString();
        gs.historic.setText(historic);

        // Sets the game text to the wolf story.
        gs.textCenter.setText("I am a dire wolf, hunter of prey, deadly predator.");

        // Sets the game button texts.
        gs.button1.setText("I am a hunter, riding on horseback, stabbing wolves.");
        gs.button2.setText("Option 2 Text.");
        gs.interst.setText("This button is invisible due to the function showAllButton.");

        // Sets the next position variables.
        nextPosition1 = "hunter";
        nextPosition2 = "option2";
        nextPositionInterst = "option2"; // This button will display the interstitial ad before changing the position.

        // Calls the showAllButtons method to display all the game buttons.
        showAllButtons();
        // The buttons below replace the function above.
        // gs.button1.setVisibility(View.VISIBLE);
        // gs.button2.setVisibility(View.VISIBLE);
        // gs.interst.setVisibility(View.INVISIBLE);
    }

    // Method that displays the game story when the user chooses the "hunter" option.
    public void hunter(){
        // Changes the game image to the horsefly.
        gs.image.setImageResource(R.drawable.fly);

        // Saves the current game text to the historic variable.
        historic = gs.textCenter.getText().toString();
        gs.historic.setText(historic);

        // Sets the game text to the horsefly story.
        gs.textCenter.setText("I am a horsefly, biting horses, toppling hunters.");

        // Sets the game button texts.
        gs.button1.setText("I am a spider, consuming flies, with eight legs.");
        gs.button2.setText("This button is invisible now.");
        gs.interst.setText("Option 2 Text.");

        // Sets the next position variables.
        nextPosition1 = "spider";
        nextPosition2 = "option2"; // This button is invisible now.
        nextPositionInterst = "option2"; // This button will display the interstitial ad before changing the position.

        // Displays the game buttons individually.
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.interst.setVisibility(View.VISIBLE);

        // The showAllButtons method is commented out for this story path.
        // showAllButtons();
    }
}
