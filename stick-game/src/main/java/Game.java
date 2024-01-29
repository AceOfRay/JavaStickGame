
import java.util.Scanner;

public class Game {
    private Player Player1;
    private Player Player2;
    private boolean turn;
    private Pile sticks;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Input Player 1's Name: ");
        String name1 = scanner.nextLine();
        this.Player1 = new Player(name1);

        System.out.println("Please Input Player 2's Name: ");
        String name2 = scanner.nextLine();
        this.Player2 = new Player(name2);

        System.out.println("Please Input The Number of Sticks in The Pile: ");
        String sticks = scanner.nextLine();
        this.sticks = new Pile(Integer.valueOf(sticks));
        this.turn = true;
        this.promptPlayer();
    }

    public boolean checkGame() {
        if (this.sticks.getSticks() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void endGame() {
        String winner = "";
        if (turn == true) {
            winner = this.Player1.getPlayerName();
        } else {
            winner = this.Player2.getPlayerName();
        }
        System.out.println("Game Over, Winner is: " + winner);
    }

    public void setTurn() {
        this.turn = !this.turn;
    }

    public void promptPlayer() {
        System.out.println("");
        System.out.println("");
        System.out.println("Current Number of Sticks in the pile is " + String.valueOf(this.sticks.getSticks()));
        System.out.println("It is " + getCurrentPlayerName() + "'s turn");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of sticks to remove from the pile: ");
        String numOfSticksToRemove = scanner.nextLine();
        int num = Integer.valueOf(numOfSticksToRemove);
        

        // ask player to put in the number of sticks
        if (checkStickInputValid(num)) {
            this.sticks.removeSticks(num);
            if (checkGame() == true) {
                this.setTurn();
                endGame();
                scanner.close();
            } else {
                this.setTurn();
                promptPlayer();
            }
      
            
        } else {
            this.invalidStickNumError();
            this.promptPlayer();
        }

    }

    public boolean checkStickInputValid(int inputNum) {
        if (inputNum > 3 || inputNum < 1) {
            return false;
        } else {
            return true;
        }
    }

    public void invalidStickNumError() {
        System.out.println("You input an invalid number. Valid numbers are 1-3. Please Try Again");
    }

    public String getCurrentPlayerName() {
        if (turn == true) {
            return Player1.getPlayerName();
        } else {
            return Player2.getPlayerName();
        }
    }

}
