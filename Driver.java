import Model.MyFarm;

/**
 * This class represents the Driver of the program, which is responsible for starting and
 * ending the program. As the driver of the program, it contains the main method.
 */
public class Driver {

    /**
     * Starts and ends the program.
     * @param args arguments passed into the main function
     */
    public static void main(String[] args) {
        while(true) {
            boolean gameOver = false;
            MyFarmGUI myFarmGUI = new MyFarmGUI();
            MyFarm myFarm = new MyFarm();
            Controller controller = new Controller(myFarmGUI, myFarm);

            while(!gameOver) {
                // check if game over conditions are already met
                int gameChecker = myFarm.checkIfGameOver();
                if(gameChecker == 1 || gameChecker == 2) {
                    // end the game
                    gameOver = true;
                    myFarmGUI.displayGameOver(gameChecker);
                    myFarmGUI.setVisible(false);
                }
            }

            int gameChoice = myFarmGUI.getPlayAgainChoice();
            if(gameChoice == 1) { // clicking No yields an integer value of 1
                // terminate the program if player no longer wants to play
                System.exit(0);
            }
        }
    }
}
