/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2019C
  Assessment: Final Project
  Created date: 13/01/2019
  By: Tien Nguyen(s3757934), Khoi Vu(s3694615), Triet Bui(s3694551), Phu Tran(S3811248)
  Last modified: 13/01/2019
  Acknowledgement:
 Board was taken from ”https://shopee.vn/p-i.35663200.1769005829?deep_and_deferred=1&pid=partnerize_int&af_click_lookback=7d&is_retargeting=true&af_reengagement_window=7d&af_installpostback=false&af_sub3=4687861501623739831&af_sub4=XRa36szqZmw92oQJcjAXDmhPcCN1e0G2n7WgUWv1dxIxkbPN&af_sub2=SHOPEE&clickid=1011l7zTwX9I&af_siteid=1101l66717&utm_source=1101l66717&utm_medium=affiliates&utm_term=4687861501623739831&utm_content=XRa36szqZmw92oQJcjAXDmhPcCN1e0G2n7WgUWv1dxIxkbPN”

Next Icon was taken from “https://www.hiclipart.com/free-transparent-background-png-clipart-mtqjr”

Horse Icon was taken from “https://www.iconfinder.com/icons/2376340/chess_game_game_piece_knight_icon”

Sound Icon was taken from “https://www.shutterstock.com/image-vector/sound-icon-vector-trendy-flat-style-744676912?id=744676912&irgwc=1&utm_medium=Affiliate&utm_campaign=Freepik+Company%2C+S.L.&utm_source=39422&utm_term=5e1daf7fcb8c5.5e1daf7fcb8c6”

Music Off Icon was taken from “https://thenounproject.com/term/music-off/496513/”

Notification Icon was taken from “https://www.sap-business-one-tips.com/pre-requisite-alert-management/”

Exit Icon was taken from https://www.pngrepo.com/svg/65414/door-exit

Globe Icon was taken from “https://www.shutterstock.com/es/search/internet%20icons%20blue”

Pointing Icon was taken from “https://www.iconfinder.com/icons/1529746/direction_finger_hand_pointing_icon?fbclid=IwAR3kZJVLIxl8OZcNn29gJfDkWCidSb5c32iJ4VImKfrJ3bZfITFyUo1v8iU”

Dice was taken from “https://www.iconsdb.com/white-icons/dice-icon.html”

Dice Individual; faces was taken from https://icon2.cleanpng.com/20180215/kue/kisspng-dominoes-dice-free-content-clip-art-dice-images-free-5a85bd3d0ca920.9263202615187141730519.jpg

*/

package GameModels;

import java.util.Arrays;

public class GameModel {
    private Dice dice = new Dice();
    private Board gameMap = new Board();
    private String turn = "none"; //initially turn
    private String currentTurn = "none"; //initially current turn
    private Player[] player = new Player[4];
    private int numberOfPlayer, noOfHumanPlayer, numberOfMoves;

    public GameModel() {
        //create 4 players
        for (int i = 0; i < 4; ++i) {
            player[i] = new Player();
        }
    }

    //set number of human player
    public void setNoOfHumanPlayer(int humanPlayer) {
        this.noOfHumanPlayer = humanPlayer;
    }

    //set total number of players
    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    //reset game model when restart game
    public void restartGame() {
        resetGameModel();
    }

    //reset game model when new game
    public void newGame() {
        resetGameModel();
        for (int i = 0; i < 4; ++i) {
            player[i].resetPlayer();
        }
    }

    //reset game model
    private void resetGameModel() {
        numberOfMoves = 1;
        gameMap.resetBoard();
        turn = "none";
        currentTurn = "none";
        dice.resetDice();
    }

    //set information for new player
    public void setPlayerInfo(String name, String color, int playerNumber, int labelNumber) {
        player[playerNumber].setInfo(name, color, labelNumber);
    }

    //set player's type
    public void setPlayerType(int playerNumber, int labelOrder) {
        if (labelOrder <= noOfHumanPlayer) {
            player[playerNumber].setPlayerType("human");
        } else {
            player[playerNumber].setPlayerType("machine");
        }
    }

    //get total number of players
    public int getNumberOfPlayer() {return numberOfPlayer;}

    //get number of times dices have been rolled
    public int getNumberOfRollTimes() {
        return dice.getNumberOfRollTimes();
    }

    //find first player to play
    public void findFirstPlayer() {
        dice.findFirstPlayer(numberOfPlayer);
        if (getNumberOfRollTimes() == numberOfPlayer) { //if all player has rolled, set the turn to player with highest dice's value
            setFirstTurn();
        }
    }

    public int findFirstPlayerToPlayNumber() {
        return findNextPlayerToRoll(dice.getFirstPlayer());
    }

    //set player with highest roll dice to the first turn
    public int setFirstTurn() {
        int firstPlayerToPlayerNumber = findNextPlayerToRoll(dice.getFirstPlayer());
        turn = player[firstPlayerToPlayerNumber].getPlayerColor();
        setPrepareTurn();
        return firstPlayerToPlayerNumber;
    }

    //find next player to roll
    public int findNextPlayerToRoll(int count) {
        int firstPlayerToRoll = findFirstPlayerToRoll();
        for (int i = 1; i < count; ++i) {
            firstPlayerToRoll = (firstPlayerToRoll == 3) ? 0 : firstPlayerToRoll + 1;
            while (player[firstPlayerToRoll].getPlayerColor().equals("none")) {
                firstPlayerToRoll = (firstPlayerToRoll == 3) ? 0 : firstPlayerToRoll + 1;
            }
        }
        return firstPlayerToRoll;
    }

    //find the first player to roll number
    public int findFirstPlayerToRoll() {
        int firstPlayerToRoll = 0;
        for (int i = 0; i < 4; ++i) {
            if (!player[i].getPlayerColor().equals("none")) { //player that is not active has "none" as its color
                firstPlayerToRoll = i;
                break;
            }
        }
        return firstPlayerToRoll;
    }

    //shift the order to play 1 turn sooner, wait for the player to officially press roll to start first turn.
    private void setPrepareTurn() {
        switch (turn) {
            case "blue":
                turn = "red";
                break;
            case "yellow":
                turn = "blue";
                break;
            case "green":
                turn = "yellow";
                break;
            case "red":
                turn = "green";
                break;
        }
        currentTurn = turn;
    }

    //move to next turn
    public void setNextTurn() {
        findNextTurn(); //find player's color that is next to current player in the board
        while (!validTurn()) { //check if that color is active
            //dice.setFirstDice(); //set a temporary dice value for
            findNextTurn();
        }
    }

    //find player's color that is next to current player in the board
    private void findNextTurn() {
        if (dice.getFirstDice() != dice.getSecondDice()) {
            if (currentTurn.equals("blue")) {
                turn = "yellow";
            } else if (currentTurn.equals("yellow")) {
                turn = "green";
            } else if (currentTurn.equals("green")) {
                turn = "red";
            } else if (currentTurn.equals("red")) {
                turn = "blue";
            }
            currentTurn = turn;
        } else {
            turn = currentTurn;
        }
    }

    //check if that color is active
    private boolean validTurn() {
        for (int i = 0; i < 4; ++i) {
            if (turn.equals(player[i].getPlayerColor())) {
                return true;
            }
        }
        return false;
    }

    //get player's type by player number
    public String getPlayerType(int playerNumber) {
        return player[playerNumber].getPlayerType();
    }

    //get player's type of this turn
    public String getPlayerType() { return player[getPlayerNumber()].getPlayerType(); }

    //random 2 dices' values
    public void rollDice() {
        dice.rollDice();
    }

    //reset number of moves after done moving
    public void resetNumberOfMoves() {numberOfMoves = 1;}

    //get number of moves of a horse
    public int getNumberOfMoves() {return numberOfMoves;}

    //set number of moves of a horse
    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    //set number of moves to -1 when stop moving
    public void stopMoving() {
        numberOfMoves = -1;
    }

    //get player's color
    public String getPlayerColor(int playerNumber) {
        return player[playerNumber].getPlayerColor();
    }

    //get player's name
    public String getPlayerName(int playerNumber) {
        return player[playerNumber].getPlayerName();
    }

    //get player's score as text
    public String getScore(int playerNumber) {
        return player[playerNumber].getScore();
    }

    //get score value
    public int getIntScore(int playerNumber) {
        return player[playerNumber].getIntScore();
    }

    //get player's label number
    public int getPlayerScoreLabelNum(int playerNumber) {
        return player[playerNumber].getScoreLabelNum();
    }

    //player gains score for enter home
    public void updateScoreEnterHome(int horseNumber, int playerNumber) {
        int scoreAtHome = (((getNextMove(horseNumber) % 64) + 1) % 6);
        if (scoreAtHome == 0) {
            scoreAtHome = 6;
        }
        player[playerNumber].setScore(scoreAtHome);
    }

    //player gains/loses scores
    public void updateScoreForHomeAndCaptureMove(int playerNumber, String scoreType) {
        player[playerNumber].updateScore(scoreType);
    }

    //find next player's type
    public String getNextPlayerType() {
        int nextPlayerNumber = getNextPlayerNumber();
        return player[nextPlayerNumber].getPlayerType();
    }

    //find next player's number
    public int getNextPlayerNumber() {
        if (dice.getFirstDice() != dice.getSecondDice()) {
            int nextPlayerNumber = (getPlayerNumber() == 3) ? 0 : getPlayerNumber() + 1;
            while (player[nextPlayerNumber].getPlayerColor().equals("none")) {
                nextPlayerNumber = (nextPlayerNumber == 3) ? 0 : nextPlayerNumber + 1;
            }
            return nextPlayerNumber;
        } else {
            return getPlayerNumber();
        }
    }

    public int getPlayerNumber() {
        return getPlayerNumber(currentTurn);
    }

    //find player number according to player color
    public int getPlayerNumber(String horseColor) {
        if (horseColor.equals("blue")) {return 0;}
        else if (horseColor.equals("yellow")) {return 1;}
        else if (horseColor.equals("green")) {return 2;}
        else if (horseColor.equals("red")) {return 3;}
        else {return -1;}
    }

    public void setNextTurn(String turn) {
        this.turn = turn;
    }

    public String getTurn() {
        return this.turn;
    }

    //get value of the first dice
    public int getFirstDice() {
        return dice.getFirstDice();
    }

    //get value of the second dice
    public int getSecondDice() {
        return dice.getSecondDice();
    }

    //get total value of 2 dices
    public int getTotalDice() {
        return dice.getTotalDice();
    }

    //check if the dice has any valid move
    public boolean checkADice(int dice, String selectedValue) {
        return (gameMap.checkADice(turn, dice, selectedValue));
    }

    //select the total value of 2 dices to use
    public void setSelectedDice(String selectedDice) {
        dice.setSelectedDice(selectedDice);
    }

    //select dice 1 or dice 2 values to use
    public String getSelectedDice() {
        return dice.getSelectedDice();
    }

    //all dice has been used
    public void setAllDiceUsed() {
        dice.setAllDiceUsed();
    }

    //reset to one dice has been used
    public void resetAllDiceUsed() {
        dice.resetAllDiceUsed();
    }

    //check if all dice has been used
    public boolean getAllDiceUsed() {
        return dice.getAllDiceUsed();
    }

    //get next position of a horse
    public int getNextMove(int horseNumber) {
        return gameMap.getHorseInfo(turn, horseNumber, "getNext");
    }

    //get current position of a horse
    public int getCurrentPos(int horseNumber) {
        return gameMap.getHorseInfo(turn, horseNumber, "getCurrent");
    }

    //get distant form current position to home arrival position of a horse
    public int distantFromHomeArrival(int horseNumber) {
        return gameMap.getHorseInfo(turn, horseNumber, "distantToHome");
    }

    //get movable status of all 4 horses for this turn
    public boolean[] getHorsesMovableStatus() {
        return gameMap.getHorsesMovableStatus();
    }

    //move horse to a new place by color and move type
    public void moveHorse(String horseColor, int horseNumber, String moveType) {
        gameMap.moveHorseModelByColor(horseColor, horseNumber, moveType);
    }

    //get next move type of a horse for this turn by its index
    public String getMoveType(int horseNumber) {
        return gameMap.getMoveType(horseNumber);
    }

    //get all move types of all 4 horses for this turn
    public String[] getMoveType() {
        return gameMap.getMoveType();
    }

    //get the color of the captured horse
    public String getCapturedHorseColor(int capturingHorseNumber) {
        return gameMap.getCapturedHorseColor(capturingHorseNumber);
    }

    //get the number of the captured horse
    public int getCapturedHorseNumber(int capturingHorseNumber) {
        return gameMap.getCapturedHorseNumber(capturingHorseNumber);
    }

    //get the nest position of the captured horse
    public int getCapturedHorseNest(int capturingHorseNumber) {
        return gameMap.getCapturedHorseNest(capturingHorseNumber);
    }

    //check if any set of 4 horses has move the the highest home positions by a given horse color
    public boolean checkCompleteGame(String horseColor, int horseNumber) {
        return gameMap.checkCompleteGame(horseColor, horseNumber);
    }

    public int findHighestScore() {
        //Getting the score from the player (player[i] -> "i" might need to be changed after discuss with Team
        int blueScore = getIntScore(0);
        int yellowScore = getIntScore(1);
        int greenScore = getIntScore(2);
        int redScore =  getIntScore(3);

        //Adding the scores into an array and find the highest score
        int[] scoreList = {blueScore, yellowScore, greenScore, redScore};
        Arrays.sort(scoreList);
        return scoreList[3];
    }
}
