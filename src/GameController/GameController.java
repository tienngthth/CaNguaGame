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

package GameController;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import GameViews.GameView;
import GameModels.GameModel;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameController {
    private GameView view = new GameView();
    private GameModel model = new GameModel();

    @FXML
    private Button soundOffBtn, soundOnBtn, toVNBtn, continueBtn, quitGameBtn, quitGameBtn1, rollDiceBtn;
    @FXML
    private Button restartBtn, newGameBtn, firstDiceBtn, secondDiceBtn, totalDiceBtn, playAgainBtn;
    @FXML
    private RadioButton red1Btn, red2Btn, red3Btn, red4Btn, blue1Btn, blue2Btn, blue3Btn, blue4Btn;
    @FXML
    private RadioButton yellow1Btn, yellow2Btn, yellow3Btn, yellow4Btn, green1Btn, green2Btn, green3Btn, green4Btn;
    @FXML
    private ChoiceBox englishLanguageBox, vietnameseLanguageBox;
    @FXML
    private Slider humanPlayers, machinePlayers;
    @FXML
    private TextField name1, name2, name3, name4;
    @FXML
    private StackPane confirmQuitBox, setUpInterface, endGamePane, playAgainPane;
    @FXML
    private VBox setUp1, setUp2, actionBox, capturedBox;
    @FXML
    private HBox player3Color, player4Color, score3, score4;
    @FXML
    private ImageView horseBlue1, horseBlue2, horseBlue3, horseBlue4, pointBlue1, pointBlue2, pointBlue3, pointBlue4;
    @FXML
    private ImageView horseYellow1, horseYellow2, horseYellow3, horseYellow4, pointYellow1, pointYellow2, pointYellow3, pointYellow4;
    @FXML
    private ImageView horseGreen1, horseGreen2, horseGreen3, horseGreen4, pointGreen1, pointGreen2, pointGreen3, pointGreen4;
    @FXML
    private ImageView horseRed1, horseRed2, horseRed3, horseRed4, pointRed1, pointRed2, pointRed3, pointRed4, dice1Img, dice2Img;
    @FXML
    private Label player1Name, player2Name, player3Name, player4Name, machineLabel, humanLabel, completePlayerNoti, highestScoreNoti;
    @FXML
    private Label player1Score, player2Score, player3Score, player4Score, completePlayer, highestScorePlayer, diceUsedValue, capturedHorseLabel;
    @FXML
    private Label scoreLabel, diceLabel, setUp2AlertMessage, setUp2Notice, setUp1Notice, colorLabel, nameLabel, regularMoveLabel, capturedLabel;
    @FXML
    private Label confirmQuitMessage, languageLabel, congratulationNoti, playerTurnName, turnLabel, diceUsed, leaveNestLabel, enterHomeLabel, upperHomeLabel;

    public GameController() throws IOException {
    }

    //turn on sound
    public void playSound(ActionEvent event) {view.soundOn(soundOffBtn, soundOnBtn);}

    //turn off sound
    public void muteSound(ActionEvent event) {view.soundOff(soundOffBtn, soundOnBtn);}

    //move to set up 2
    public void toSetUp2(ActionEvent event) {
        int numberOfMachinePlayers = (int)machinePlayers.getValue();
        int numberOfHumanPlayers = (int)humanPlayers.getValue();
        model.setNumberOfPlayer(numberOfHumanPlayers + numberOfMachinePlayers);
        model.setNoOfHumanPlayer(numberOfHumanPlayers);
        if (model.getNumberOfPlayer() >= 2 && model.getNumberOfPlayer() <= 4) {
            view.toSetUp2(setUp1, setUp2, player3Color, player4Color, model.getNumberOfPlayer());
            view.setDisableNameTextField(name1, name2, name3, name4, numberOfHumanPlayers);
        }
    }

    //move back to set up2
    public void toSetUp1(ActionEvent event) {
        view.toSetUp1(setUp1, setUp2);
    }

    //unselect other buttons when 1 button of color red is selected
    public void selectAColorRed(ActionEvent event) {
        selectAColor(red1Btn, red2Btn, red3Btn, red4Btn);
    }

    //unselect other buttons when 1 button of color blue is selected
    public void selectAColorBlue(ActionEvent event) {
        selectAColor(blue1Btn, blue2Btn, blue3Btn, blue4Btn);
    }

    //unselect other buttons when 1 button of color green is selected
    public void selectAColorGreen(ActionEvent event) {
        selectAColor(green1Btn, green2Btn, green3Btn, green4Btn);
    }

    //unselect other buttons when 1 button of color yellow is selected
    public void selectAColorYellow(ActionEvent event) {
        selectAColor(yellow1Btn, yellow2Btn, yellow3Btn, yellow4Btn);
    }

    //unselect other buttons when 1 button of that color is selected
    private void selectAColor(RadioButton Btn1, RadioButton Btn2, RadioButton Btn3, RadioButton Btn4) {
        if(Btn1.isArmed()) { view.selectAColor(Btn1, Btn2, Btn3, Btn4);
        } else if (Btn2.isArmed()) { view.selectAColor(Btn2, Btn1, Btn3, Btn4);
        } else if (Btn3.isArmed()) { view.selectAColor(Btn3, Btn1, Btn2, Btn4);
        } else { view.selectAColor(Btn4, Btn1, Btn2, Btn3); }
    }

    //restart a game with the same number of players, names, scores, player types, reset everything else
    public void restartGame(ActionEvent event) {
        view.restartGame(endGamePane, dice2Img, firstDiceBtn, secondDiceBtn, totalDiceBtn, playAgainPane);
        model.restartGame();
        setUpBoard();
        if (model.getPlayerType(model.findFirstPlayerToRoll()).equals("machine")) { //start automatically roll dice if every player is machine
            rollDice(new ActionEvent());
        }
    }

    //bring horses back to nest positions
    private void setUpBoard() {
        rollDiceBtn.setDisable(false);
        actionBox.setVisible(false);
        playerTurnName.setText(model.getPlayerName(model.findFirstPlayerToRoll()));
        view.setHorseBlue(horseBlue1, horseBlue2, horseBlue3, horseBlue4, pointBlue1, pointBlue2, pointBlue3, pointBlue4, false);
        view.setHorseYellow(horseYellow1, horseYellow2, horseYellow3, horseYellow4, pointYellow1, pointYellow2, pointYellow3, pointYellow4, false);
        view.setHorseGreen(horseGreen1, horseGreen2, horseGreen3, horseGreen4, pointGreen1, pointGreen2, pointGreen3, pointGreen4, false);
        view.setHorseRed(horseRed1, horseRed2, horseRed3, horseRed4, pointRed1, pointRed2, pointRed3, pointRed4, false);
        setVisibleHorses();
    }

    //set visibility for active/in-active horses
    private void setVisibleHorses() {
        for (int i = 0; i < 4; ++i) {
            if (model.getPlayerColor(i).equals("blue")) {
                view.setVisibleHorses(horseBlue1, horseBlue2, horseBlue3, horseBlue4, true);
            } else if (model.getPlayerColor(i).equals("yellow")) {
                view.setVisibleHorses(horseYellow1, horseYellow2, horseYellow3, horseYellow4, true);
            } else if (model.getPlayerColor(i).equals("green")) {
                view.setVisibleHorses(horseGreen1, horseGreen2, horseGreen3, horseGreen4, true);
            } else if (model.getPlayerColor(i).equals("red")) {
                view.setVisibleHorses(horseRed1, horseRed2, horseRed3, horseRed4, true);
            }
        }
    }

    //create new game from set up 1, reset everything, every set up
    public void newGame(ActionEvent event) {
        view.createNewGame(setUpInterface, setUp1, setUp2, endGamePane, playAgainPane);
        model.newGame();
    }

    //done setting up in set up 1 and set up 2, validate and set information to start game
    public void startGame(ActionEvent event) {
       if (validatePlayersName()) {
            if (validateColorSet()) {
                setUpGame();
                if (model.getPlayerType(model.findFirstPlayerToRoll()).equals("machine")) { //start automatically roll dice if blue player are machine
                    rollDice(new ActionEvent());
                }
            } else {
                view.alertSetUp2(setUp2AlertMessage); //invalid message
            }
        }
    }

    //validate input names
    private boolean validatePlayersName() {
        String firstName = name1.getText();
        String secondName = name2.getText();
        String thirdName = name3.getText();
        String fourthName = name4.getText();
        return validateName(firstName, secondName) && validateName(firstName, thirdName) && validateName(firstName, fourthName)
                && validateName(secondName, thirdName) && validateName(secondName, fourthName) && validateName(thirdName, fourthName);
    }

    //validate 2 names each time, names has to be distinguish and has less than 10 characters
    private boolean validateName(String name1, String name2) {
        return (name1.length() <= 10) && (name2.length() <= 10) && !name1.equals(name2);
    }

    //check if all active players' colors are selected
    private boolean validateColorSet() {
        if (model.getNumberOfPlayer() == 2) {
            return validAColorSet(red1Btn, blue1Btn, green1Btn, yellow1Btn)
                    && validAColorSet(red2Btn, blue2Btn, green2Btn, yellow2Btn);
        } else if (model.getNumberOfPlayer() == 3) {
            return validAColorSet(red1Btn, blue1Btn, green1Btn, yellow1Btn)
                    && validAColorSet(red2Btn, blue2Btn, green2Btn, yellow2Btn)
                    && validAColorSet(red3Btn, blue3Btn, green3Btn, yellow3Btn);
        } else {
            return validAColorSet(red1Btn, blue1Btn, green1Btn, yellow1Btn)
                    && validAColorSet(red2Btn, blue2Btn, green2Btn, yellow2Btn)
                    && validAColorSet(red3Btn, blue3Btn, green3Btn, yellow3Btn)
                    && validAColorSet(red4Btn, blue4Btn, green4Btn, yellow4Btn);
        }
    }

    //check if one color among 4 choices has been selected
    private boolean validAColorSet(RadioButton color1, RadioButton color2, RadioButton color3, RadioButton color4) {
        return (color1.isSelected() || color2.isSelected() || color3.isSelected() || color4.isSelected());
    }

    //set up new game with new players' information
    private void setUpGame() {
        view.startNewGame(setUpInterface, score3, score4, model.getNumberOfPlayer(), setUp2AlertMessage, dice2Img, firstDiceBtn, secondDiceBtn, totalDiceBtn);
        setNewPlayers();
        setUpBoard();
    }

    //set new players' information
    private void setNewPlayers() {
        setPlayer(name1, player1Name, red1Btn, blue1Btn, green1Btn, yellow1Btn, player1Score, 1);
        setPlayer(name2, player2Name, red2Btn, blue2Btn, green2Btn, yellow2Btn, player2Score, 2);
        setPlayer(name3, player3Name, red3Btn, blue3Btn, green3Btn, yellow3Btn, player3Score, 3);
        setPlayer(name4, player4Name, red4Btn, blue4Btn, green4Btn, yellow4Btn, player4Score, 4);
    }

    //set a player's information according to his color, player number is from 0 - 4 according to blue, yellow, green, red
    private void setPlayer(TextField name, Label playerName, RadioButton red, RadioButton blue, RadioButton green, RadioButton yellow, Label playerScore, int labelOrder) {
       if (blue.isSelected()) {
           setPlayerInfo(name, "blue", 0, labelOrder);
           view.setPlayerScoreNameColor(playerName, playerScore, "blue", name.getText());
        } else if (yellow.isSelected()) {
           setPlayerInfo(name, "yellow", 1, labelOrder);
           view.setPlayerScoreNameColor(playerName, playerScore, "yellow", name.getText());
        } else if (green.isSelected()) {
           setPlayerInfo(name, "green", 2, labelOrder);
           view.setPlayerScoreNameColor(playerName, playerScore, "green", name.getText());
        } else if (red.isSelected()) {
           setPlayerInfo(name, "red", 3, labelOrder);
           view.setPlayerScoreNameColor(playerName, playerScore, "red", name.getText());
        }
    }

    //set a player's information
    private void setPlayerInfo(TextField name, String playerColor, int playerNumber, int labelOrder) {
        model.setPlayerInfo(name.getText(), playerColor, playerNumber, labelOrder);
        model.setPlayerType(playerNumber, labelOrder);
        if (model.getPlayerType(playerNumber).equals("machine")) {
            disableHorse(playerColor, true); //disable horses of machine players
        }
    }

    //roll dice(s) and start a turn
    public void rollDice(ActionEvent event) {
        view.setDisableDices(firstDiceBtn, secondDiceBtn, totalDiceBtn, rollDiceBtn);
        if (model.getNumberOfRollTimes() < model.getNumberOfPlayer()) { //first rolls to find first player
            findFirstPlayer();
        } else {
            model.setNextTurn();
            startTurn();
        }
        view.playSoundDice();
    }

    //find first player
    public void findFirstPlayer() {
        model.findFirstPlayer();
        rollFirstDice(model.getFirstDice());
        rollFirstDice(model.getFirstDice()).setOnFinished(e ->  {
            rollDiceBtn.setDisable(false);
            if (model.getNumberOfRollTimes() == model.getNumberOfPlayer()) {
                playerTurnName.setText(model.getPlayerName(model.findFirstPlayerToPlayNumber()));
                if (model.getPlayerType(model.findFirstPlayerToPlayNumber()).equals("machine")) {
                    rollDice(new ActionEvent());
                }
            } else if ((model.getNumberOfRollTimes() < model.getNumberOfPlayer())) {
                playerTurnName.setText(model.getPlayerName(model.findNextPlayerToRoll(model.getNumberOfRollTimes() + 1)));
                if (model.getPlayerType(model.findNextPlayerToRoll(model.getNumberOfRollTimes() + 1)).equals("machine")) {
                    rollDice(new ActionEvent());
                }
            }
        });
    }

    //start a turn
    public void startTurn() {
        dimPointings();
        rollDice();
    }

    //dim all pointings when start a new turn
    private void dimPointings() {
        view.setVisiblePointings(pointBlue1, pointBlue2, pointBlue3, pointBlue4, false, false, false, false);
        view.setVisiblePointings(pointYellow1, pointYellow2, pointYellow3, pointYellow4, false, false, false, false);
        view.setVisiblePointings(pointGreen1, pointGreen2, pointGreen3, pointGreen4, false, false, false, false);
        view.setVisiblePointings(pointRed1, pointRed2, pointRed3, pointRed4, false, false, false, false);
    }

    //roll dice animation
    private void rollDice()
    {
        model.rollDice();
        int dice1Value = model.getFirstDice();
        int dice2Value = model.getSecondDice();
        dice2Img.setVisible(true);
        rollSecondDice(dice2Value);
        rollFirstDice(dice1Value);
        rollFirstDice(dice1Value).setOnFinished(e -> {
            totalDiceBtn.setText(Integer.toString(dice1Value + dice2Value));
            checkPlayer(); //check player after animation stops
            });
    }

    //roll first dice
    private RotateTransition rollFirstDice(int diceValue) {
        return getRotateTransition(diceValue, dice1Img, firstDiceBtn);
    }

    //roll second dice
    private RotateTransition rollSecondDice(int diceValue) {
        return getRotateTransition(diceValue, dice2Img, secondDiceBtn);
    }

    //roll a dice and set image value to that dice
    private RotateTransition getRotateTransition(int diceValue, ImageView dice, Button diceBtn) {
        view.setDiceImage(0, dice);
        RotateTransition rt = new RotateTransition(Duration.millis(1500), dice);
        rollADice(rt);
        rt.setOnFinished(e -> {
            view.setDiceImage(diceValue, dice);
            diceBtn.setText(Integer.toString(diceValue));
        } );
        return rt;
    }

    //roll dice animation
    private void rollADice(RotateTransition rt) {
        rt.setAxis(Rotate.Y_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setByAngle(10);
        rt.setCycleCount(1);
        rt.play();
    }

    //check if a player is human or machine
    private void checkPlayer() {
        if (model.getPlayerType().equals("human")) {
            disableHorse(model.getTurn(), false); //enable horse if player is human
            displayPossibleDices(new boolean[]{true, true, true});
        } else {
            machinePlayerStartTurn();
        }
    }

    //display possible dices
    private void displayPossibleDices(boolean[] checkDice) {
        displayPossibleThreeDices(checkDice, model.getFirstDice(), model.getSecondDice(), model.getTotalDice());
    }

    //check 3 dices and display the dice that has possible moves
    private void displayPossibleThreeDices(boolean[] checkDice, int dice1Value, int dice2Value, int totalDice) {
        boolean haveMove = false;
        if (checkFirstDice(dice1Value, checkDice[0])) {
            haveMove = true;
        }
        if (checkSecondDice(dice2Value, checkDice[1])) {
            haveMove = true;
        }
        if (checkTotalDice(totalDice, checkDice[2])) {
            haveMove = true;
        }
        if (!haveMove) {doneTurn();} //done turn if there is no possible moves
    }

    //check if with the 1st dice value, is there any possible moves
    private boolean checkFirstDice(int firstDice, boolean checkDice) {
        if (checkDice && model.checkADice(firstDice, "one")) {
            diceUsedValue.setText(Integer.toString(model.getFirstDice()));
            model.setSelectedDice("one");
            firstDiceBtn.setDisable(false);
            return true;
        } else {
            firstDiceBtn.setDisable(true);
            return false;
        }
    }

    //check if with the 2nd dice value, is there any possible moves
    private boolean checkSecondDice(int secondDice,  boolean checkDice) {
        if (checkDice && model.checkADice(secondDice, "two")) {
            diceUsedValue.setText(Integer.toString(model.getSecondDice()));
            model.setSelectedDice("two");
            secondDiceBtn.setDisable(false);
            return true;
        } else {
            secondDiceBtn.setDisable(true);
            return false;
        }
    }

    //check if with the total value of 2 dices, is there any possible moves
    private boolean checkTotalDice(int totalDice,  boolean checkDice) {
        if (checkDice && model.checkADice(totalDice, "total")) {
            diceUsedValue.setText(Integer.toString(model.getTotalDice()));
            model.setSelectedDice("total");
            totalDiceBtn.setDisable(false);
            return true;
        }
        return false;
    }

    //check 1st dice value for moves
    public void firstDiceSelected(ActionEvent event) {
        diceUsedValue.setText(Integer.toString(model.getFirstDice()));
        dimPointings();
        model.checkADice(model.getFirstDice(), "one");
        displayPossibleMoves();
        model.setSelectedDice("one");
    }

    //check 2nd dice value for moves
    public void secondDiceSelected(ActionEvent event) {
        diceUsedValue.setText(Integer.toString(model.getSecondDice()));
        dimPointings();
        model.checkADice(model.getSecondDice(), "two");
        displayPossibleMoves();
        model.setSelectedDice("two");
    }

    //check total value of 2 dices for moves
    public void totalDiceSelected(ActionEvent event) {
        diceUsedValue.setText(Integer.toString(model.getTotalDice()));
        dimPointings();
        model.checkADice(model.getTotalDice(), "total");
        displayPossibleMoves();
        model.setSelectedDice("total");
    }

    //display all possible moves by a dice value of horses in this turn
    private void displayPossibleMoves() {
        if (model.getTurn().equals("blue")) {
            displayPossibleMoves(pointBlue1, pointBlue2, pointBlue3, pointBlue4);
        } else if (model.getTurn().equals("yellow")) {
            displayPossibleMoves(pointYellow1, pointYellow2, pointYellow3, pointYellow4);
        } else if (model.getTurn().equals("green")) {
            displayPossibleMoves(pointGreen1, pointGreen2, pointGreen3, pointGreen4);
        } else if (model.getTurn().equals("red")) {
            displayPossibleMoves(pointRed1, pointRed2, pointRed3, pointRed4);
        }
    }

    //display all possible moves of a dice
    private void displayPossibleMoves(ImageView pointing1, ImageView pointing2, ImageView pointing3, ImageView pointing4) {
        boolean status[] = model.getHorsesMovableStatus();
        view.setVisiblePointings(pointing1, pointing2, pointing3, pointing4, status[0], status[1], status[2], status[3]);
        view.setVisiblePointings(pointing1, pointing2, pointing3, pointing4, status[0], status[1], status[2], status[3]);
        view.setVisiblePointings(pointing1, pointing2, pointing3, pointing4, status[0], status[1], status[2], status[3]);
        view.setVisiblePointings(pointing1, pointing2, pointing3, pointing4, status[0], status[1], status[2], status[3]);
    }

    public void moveFirstBlue(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("blue", 0, 0, horseBlue1, pointBlue1);
        }
    }

    public void moveSecondBlue(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("blue", 1, 0, horseBlue2, pointBlue2);
        }
    }

    public void moveThirdBlue(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("blue", 2, 0, horseBlue3, pointBlue3);
        }
    }

    public void moveFourthBlue(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("blue", 3, 0, horseBlue4, pointBlue4);
        }
    }

    public void moveFirstYellow(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("yellow", 0, 1, horseYellow1, pointYellow1);
        }
    }

    public void moveSecondYellow(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("yellow", 1, 1, horseYellow2, pointYellow2);
        }
    }

    public void moveThirdYellow(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("yellow", 2, 1, horseYellow3, pointYellow3);
        }
    }

    public void moveFourthYellow(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("yellow", 3, 1, horseYellow4, pointYellow4);
        }
    }

    public void moveFirstGreen(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("green", 0, 2, horseGreen1, pointGreen1);
        }
    }

    public void moveSecondGreen(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("green", 1, 2, horseGreen2, pointGreen2);
        }
    }

    public void moveThirdGreen(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("green", 2, 2, horseGreen3, pointGreen3);
        }
    }

    public void moveFourthGreen(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("green", 3, 2, horseGreen4, pointGreen4);
        }
    }

    public void moveFirstRed(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("red", 0, 3, horseRed1, pointRed1);
        }
    }

    public void moveSecondRed(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("red", 1, 3, horseRed2, pointRed2);
        }
    }

    public void moveThirdRed(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("red", 2, 3, horseRed3, pointRed3);
        }
    }

    public void moveFourthRed(MouseEvent event) {
        if (event.isStillSincePress()) {
            moveHorse("red", 3, 3, horseRed4, pointRed4);
        }
    }

    //check priority move: enter home min 3, capture, home arrival, enter home max 2, out of start pos,  leave nest,  farthest
    private void machinePlayerStartTurn() {
        if (!checkEnterHome("enterHomeMin3") && !moveTheFarthest("capture")
                && !checkValidMove3Dices("toHomeArrival") && !checkEnterHome("enterHomeMax2")
                && !checkValidMove3Dices("moveOutStartPos") && !checkLeaveNest()
                && !checkValidMove2Dices("upperHome") && !moveTheFarthest("regular")) {
                machineDoneTurn();
        } else if (model.getNumberOfMoves() != -1) { //check if game has stopped or still continue
            checkSecondMove();
        }
    }

    //done turn after horse completed moving
    private void machineDoneTurn() { //wait until moving completed
        PauseTransition pause = new PauseTransition(Duration.millis(300 * (model.getNumberOfMoves() + 1)));
        pause.setOnFinished(e -> {doneTurn();});
        pause.play();
    }

    //check for 2nd valid move of this machine turn after horse completed 1st move
    private void checkSecondMove() {
        if (!model.getSelectedDice().equals("total")) {
            //wait until the 1st move has completed
            PauseTransition pause = new PauseTransition(Duration.millis(300 * (model.getNumberOfMoves() + 1)));
            pause.setOnFinished(e -> {
                moveHorseFinalTime();
            });
            pause.play();
        } else {
            machineDoneTurn();
        }
    }

    //check for 2nd valid move of this machine turn
    private void moveHorseFinalTime() {
        model.resetNumberOfMoves();
        checkTheDiceLeft();
        String[] moveType = model.getMoveType();
        //check for the same priority as 1st move
        if (!checkMove(moveType, "enterHomeMin3") && !checkMove(moveType, "capture") && !checkMove(moveType, "toHomeArrival") && !checkMove(moveType, "enterHomeMax2") && !checkMove(moveType, "moveOutStartPos")  && !checkMove(moveType, "leaveNest") && !checkMove(moveType, "upperHome")) {
            int farthestMoveHorse = findFarthestMoveHorse(model.getMoveType(), "regular");
            if (farthestMoveHorse != -1) {
                moveHorseByColor(model.getTurn(), model.getPlayerNumber(), farthestMoveHorse);
            }
        }
        if (model.getNumberOfMoves() != -1)  //check if game has stopped or still continue
        {machineDoneTurn();}
    }

    //check the dice left for the valid moves
    private void checkTheDiceLeft() {
        if (model.getSelectedDice().equals("one")) {
            secondDiceSelected(new ActionEvent());
        } else if (model.getSelectedDice().equals("two")) {
            firstDiceSelected(new ActionEvent());
        }
    }

    //check for horses having valid moves that is closest to home arrival
    private boolean moveTheFarthest(String requiredMoveType) {
        firstDiceSelected(new ActionEvent());
        int farthestMoveHorseDice1 = findFarthestMoveHorse(model.getMoveType(), requiredMoveType);
        secondDiceSelected(new ActionEvent());
        int farthestMoveHorseDice2 = findFarthestMoveHorse(model.getMoveType(), requiredMoveType);
        totalDiceSelected(new ActionEvent());
        int farthestMoveHorse = findFarthestMoveHorse(model.getMoveType(), requiredMoveType);

        if (farthestMoveHorseDice1 == -1 && farthestMoveHorseDice2 == -1) {return false;}
        else if (farthestMoveHorseDice1 == -1) {
            farthestMoveHorse = farthestMoveHorseDice2;
            secondDiceSelected(new ActionEvent());
        } else if (farthestMoveHorseDice2 == -1) {
            farthestMoveHorse = farthestMoveHorseDice1;
            firstDiceSelected(new ActionEvent());
        } else if (model.distantFromHomeArrival(farthestMoveHorseDice1) < model.distantFromHomeArrival(farthestMoveHorseDice2)) {
            if (farthestMoveHorse != farthestMoveHorseDice1) {
                farthestMoveHorse = farthestMoveHorseDice1;
                firstDiceSelected(new ActionEvent());
            }
        } else if (model.distantFromHomeArrival(farthestMoveHorseDice2) < model.distantFromHomeArrival(farthestMoveHorseDice1)) {
            if (farthestMoveHorse != farthestMoveHorseDice2) {
                farthestMoveHorse = farthestMoveHorseDice2;
                secondDiceSelected(new ActionEvent());
            }
        } else if (model.distantFromHomeArrival(farthestMoveHorseDice1) == model.distantFromHomeArrival(farthestMoveHorseDice2)) {
            if (model.getFirstDice() > model.getSecondDice() && farthestMoveHorse != farthestMoveHorseDice1) {
                farthestMoveHorse = farthestMoveHorseDice1;
                firstDiceSelected(new ActionEvent());
            } else if (model.getFirstDice() <= model.getSecondDice() && farthestMoveHorse != farthestMoveHorseDice1) {
                farthestMoveHorse = farthestMoveHorseDice2;
                secondDiceSelected(new ActionEvent());
            }
        }

        moveHorseByColor(model.getTurn(), model.getPlayerNumber(), farthestMoveHorse);
        return true;
    }

    //find horse that is closest to home arrival
    private int findFarthestMoveHorse(String[] moveType, String requiredMoveType) {
        int farthestMoveHorse  = -1;
        for (int i = 0; i < 4; ++i) {
            if (moveType[i].equals(requiredMoveType)) {
                if (farthestMoveHorse == -1) { farthestMoveHorse = i;}
                else if (model.distantFromHomeArrival(i) < model.distantFromHomeArrival(farthestMoveHorse)) {
                    farthestMoveHorse = i;
                }
            }
        }
        return farthestMoveHorse;
    }

    //check if a horse can enter home
    private boolean checkEnterHome(String enterType) {
        if (model.getSecondDice() > model.getFirstDice()) { //if 2nd dice is greater than 1st dice, check 2nd dice first so that the horse can move higher
            secondDiceSelected(new ActionEvent());
            if (!checkMove(model.getMoveType(), enterType)) {
                firstDiceSelected(new ActionEvent());
                return checkMove(model.getMoveType(), enterType);
            } else {
                return true;
            }
        } else { //if 1st dice is greater than 2nd dice, check 2nd dice first so that the horse can move higher
            return checkValidMove2Dices(enterType);
        }
    }

    //check if a horse can leave nest
    private boolean checkLeaveNest() {
        if (model.getFirstDice() != 6 && model.getSecondDice() != 6) {return false;}
        else {
            return checkValidMove2Dices("leaveNest");
        }
    }

    //check if a horse can enter home, leave nest that don't use total value of 2 dices
    private boolean checkValidMove2Dices(String requiredMoveType) {
        firstDiceSelected(new ActionEvent());
        if (!checkMove(model.getMoveType(), requiredMoveType)) {
            secondDiceSelected(new ActionEvent());
            return checkMove(model.getMoveType(), requiredMoveType);
        }
        return true;
    }

    //check if a horse have regular move, capture move, .. that use both 1st dice, 2nd dice and total dice value
    private boolean checkValidMove3Dices(String requiredMoveType) {
         firstDiceSelected(new ActionEvent());
         if (!checkMove(model.getMoveType(), requiredMoveType)) {
             secondDiceSelected(new ActionEvent());
             if (!checkMove(model.getMoveType(), requiredMoveType)) {
                 totalDiceSelected(new ActionEvent());
                 return checkMove(model.getMoveType(), requiredMoveType);
             }
         }
         return true;
     }

    //check if any horse has the required move type
    private boolean checkMove(String[] allMoveTypes, String requiredMoveType) {
         int horseNumber = 0;
         for (; horseNumber < 4; ++horseNumber) {
             if (allMoveTypes[horseNumber].equals(requiredMoveType)) {
                 moveHorseByColor(model.getTurn(), model.getPlayerNumber(), horseNumber);
                 return true;
             }
         }
         return false;
     }

    //move horse by its color
    private void moveHorseByColor(String horseColor, int playerNumber, int horseNumber) {
        switch (horseColor) {
            case "blue":
                moveHorseByIndex(horseColor, playerNumber, horseNumber, horseBlue1, pointBlue1, horseBlue2, pointBlue2, horseBlue3, pointBlue3, horseBlue4, pointBlue4);
                break;
            case "yellow":
                moveHorseByIndex(horseColor, playerNumber, horseNumber, horseYellow1, pointYellow1, horseYellow2, pointYellow2, horseYellow3, pointYellow3, horseYellow4, pointYellow4);
                break;
            case "green":
                moveHorseByIndex(horseColor, playerNumber, horseNumber, horseGreen1, pointGreen1, horseGreen2, pointGreen2, horseGreen3, pointGreen4, horseGreen4, pointGreen4);
                break;
            case "red":
                moveHorseByIndex(horseColor, playerNumber, horseNumber, horseRed1, pointRed1, horseRed2, pointRed2, horseRed3, pointRed3, horseRed4, pointRed4);
                break;
        }
    }

    //move horse by its index
    private void moveHorseByIndex(String horseColor, int playerNumber, int horseNumber, ImageView horse1, ImageView pointing1, ImageView horse2, ImageView pointing2, ImageView horse3, ImageView pointing3, ImageView horse4, ImageView pointing4) {
        switch (horseNumber) {
            case 0:
                moveHorse(horseColor, horseNumber, playerNumber, horse1, pointing1);
                break;
            case 1:
                moveHorse(horseColor, horseNumber, playerNumber, horse2, pointing2);
                break;
            case 2:
                moveHorse(horseColor, horseNumber, playerNumber, horse3, pointing3);
                break;
            case 3:
                moveHorse(horseColor, horseNumber, playerNumber, horse4, pointing4);
                break;
        }
    }

    //move a horse
    public void moveHorse(String horseColor, int horseNumber, int playerNumber, ImageView horse, ImageView pointing) {
        if (model.getTurn().equals(horseColor)) {
            String moveType = model.getMoveType(horseNumber);
            if (moveType.equals("regular") || moveType.equals("toHomeArrival") || moveType.equals("moveOutStartPos") || moveType.equals("leaveNest")) {
                regularMove(horse, pointing, model.getNextMove(horseNumber), model.getCurrentPos(horseNumber), horseColor, horseNumber, moveType);
            } else if (moveType.equals("capture")) {
                captureHorse(horse, pointing, horseNumber, model.getCurrentPos(horseNumber), playerNumber, horseColor);
            } else if (moveType.equals("enterHomeMax2") || moveType.equals("enterHomeMin3")) {
                enterHome(horse, pointing, horseNumber, playerNumber, horseColor);
            } else if (moveType.equals("upperHome")) {
                upperHome(horse, pointing, horseNumber, playerNumber, horseColor);
            }
        }
    }

    //prepare before move horse
    private void moveHorsePreparation(){
        model.resetNumberOfMoves();
        dimPointings();
        disableHorse(model.getTurn(), true); //disable other horses while a horse is moving
        view.disableDiceBtn(firstDiceBtn, secondDiceBtn, totalDiceBtn, true);
    }

    //set disability horses status
    public void disableHorse(String horseColor, Boolean status) {
        switch (horseColor) {
            case "blue":
                view.disableHorse(horseBlue1, horseBlue2, horseBlue3, horseBlue4, status);
                break;
            case "yellow":
                view.disableHorse(horseYellow1, horseYellow2, horseYellow3, horseYellow4, status);
                break;
            case "green":
                view.disableHorse(horseGreen1, horseGreen2, horseGreen3, horseGreen4, status);
                break;
            case "red":
                view.disableHorse(horseRed1, horseRed2, horseRed3, horseRed4, status);
                break;
        }
    }

    //count number of moves from current position to next position of a horse
    private int countMove(int horseNumber) {
        int nextPos = model.getNextMove(horseNumber);
        int currentPos = model.getCurrentPos(horseNumber);
        if (currentPos > 47) { return 1;}
        else if (nextPos > currentPos) {
            return nextPos - currentPos;
        } else {
            return 47 - currentPos + nextPos + 1;
        }
    }

    //move horse to a new empty position
    public void regularMove(ImageView horse, ImageView pointing, int newPosition, int currentPos, String horseColor, int horseNumber, String moveType) {
        moveHorsePreparation();
        view.regularMove(horse, newPosition, pointing, currentPos);
        if (!moveType.equals("leaveNest")) {
            model.setNumberOfMoves(countMove(horseNumber));
            view.updateRegularMove(actionBox, enterHomeLabel, leaveNestLabel, regularMoveLabel, upperHomeLabel, capturedBox);
        } else {
            view.updateLeaveNest(actionBox, enterHomeLabel, leaveNestLabel, regularMoveLabel, upperHomeLabel, capturedBox);
        }
        model.moveHorse(horseColor, horseNumber, "moveHorse");
        doneMove();
    }

    //move horse to enter a home position from home arrival
    private void enterHome(ImageView horse, ImageView pointing, int horseNumber, int playerNumber, String horseColor) {
        moveHorsePreparation();
        updateScoreForPlayers("enterHome", horseNumber, playerNumber);
        moveToHomePos(horse, pointing, horseNumber);
        view.updateEnterHome(actionBox, enterHomeLabel, leaveNestLabel, regularMoveLabel, upperHomeLabel, capturedBox);
        model.moveHorse(horseColor, horseNumber, "moveHorse");
        checkForCompleteGame(horseColor, horseNumber, playerNumber);
    }

    //move horse to higher home position
    private void upperHome(ImageView horse, ImageView pointing, int horseNumber, int playerNumber, String horseColor) {
        moveHorsePreparation();
        updateScoreForPlayers("upperHome", horseNumber, playerNumber);
        moveToHomePos(horse, pointing, horseNumber);
        view.updateUpperHome(actionBox, enterHomeLabel, leaveNestLabel, regularMoveLabel, upperHomeLabel, capturedBox);
        model.moveHorse(horseColor, horseNumber, "moveHorse");
        checkForCompleteGame(horseColor, horseNumber, playerNumber);
    }

    //move horse to a home position
    private void moveToHomePos(ImageView horse, ImageView pointing, int horseNumber) {
        view.moveHome(horse, model.getNextMove(horseNumber), pointing);
    }

    //update score for players
    public void updateScoreForPlayers(String scoreType, int horseNumber, int playerNumber) {
        if ((scoreType.equals("captured")) || (scoreType.equals("capturing")) || (scoreType.equals("upperHome"))) {
            model.updateScoreForHomeAndCaptureMove(playerNumber, scoreType);
        } else if (scoreType.equals("enterHome")) {
            model.updateScoreEnterHome(horseNumber, playerNumber);
        }
        setScore(model.getPlayerScoreLabelNum(playerNumber), model.getScore(playerNumber));
    }

    //display updated score
    private void setScore(int labelNumber, String score) {
        switch (labelNumber) {
            case 1:
                player1Score.setText(score);
                break;
            case 2:
                player2Score.setText(score);
                break;
            case 3:
                player3Score.setText(score);
                break;
            case 4:
                player4Score.setText(score);
                break;
        }
    }

    //capturing another horse
    public void captureHorse(ImageView horse1, ImageView pointing1, int horseNumber, int currentPosOfCapturingHorse, int playerNumber, String horseColor) {
        moveHorsePreparation();
        model.setNumberOfMoves(countMove(horseNumber));
        model.moveHorse(horseColor, horseNumber, "moveHorse");
        String capturedHorseColor = model.getCapturedHorseColor(horseNumber);
        if (capturedHorseColor.equals("blue")) {
            captureBlueHorse(horse1, pointing1, horseNumber, currentPosOfCapturingHorse, playerNumber);
        } else if (capturedHorseColor.equals("yellow")) {
            captureYellowHorse(horse1, pointing1, horseNumber, currentPosOfCapturingHorse, playerNumber);
        } else if (capturedHorseColor.equals("green")) {
            captureGreenHorse(horse1, pointing1, horseNumber, currentPosOfCapturingHorse, playerNumber);
        } else if (capturedHorseColor.equals(("red"))) {
            captureRedHorse(horse1, pointing1, horseNumber, currentPosOfCapturingHorse, playerNumber);
        }
        doneMove();
    }

    //a blue horse is captured
    private void captureBlueHorse(ImageView horse1, ImageView pointing1, int horseNumber, int currentPosOfCapturingHorse, int playerNumber) {
        captureHorse(horse1, pointing1, horseNumber, horseBlue1, pointBlue1, horseBlue2, pointBlue2, horseBlue3, pointBlue3, horseBlue4, pointBlue4, "blue", currentPosOfCapturingHorse, playerNumber);
    }

    //a yellow horse is captured
    private void captureYellowHorse(ImageView horse1, ImageView pointing1, int horseNumber, int currentPosOfCapturingHorse, int playerNumber) {
        captureHorse(horse1, pointing1, horseNumber, horseYellow1, pointYellow1, horseYellow2, pointYellow2, horseYellow3, pointYellow3, horseYellow4, pointYellow4, "yellow", currentPosOfCapturingHorse, playerNumber);
    }

    //a green horse is captured
    private void captureGreenHorse(ImageView horse1, ImageView pointing1, int horseNumber, int currentPosOfCapturingHorse, int playerNumber) {
        captureHorse(horse1, pointing1, horseNumber, horseGreen1, pointGreen1, horseGreen2, pointGreen2, horseGreen3, pointGreen3, horseGreen4, pointGreen4, "green", currentPosOfCapturingHorse, playerNumber);
    }

    //a red horse is captured
    private void captureRedHorse(ImageView horse1, ImageView pointing1, int horseNumber, int currentPosOfCapturingHorse, int playerNumber) {
        captureHorse(horse1, pointing1, horseNumber, horseRed1, pointRed1, horseRed2, pointRed2, horseRed3, pointRed3, horseRed4, pointRed4, "red", currentPosOfCapturingHorse, playerNumber);
    }

    //move horse animation
    private void captureHorse(ImageView horse1, ImageView horsePointing1, int horseNumber, ImageView horseCaptured1, ImageView pointing1, ImageView horseCaptured2, ImageView pointing2, ImageView horseCaptured3, ImageView pointing3, ImageView horseCaptured4, ImageView pointing4, String capturedHorseColor, int capturingHorseCurrentPos, int playerNumber) {
        int capturePosition = model.getNextMove(horseNumber);
        int capturedHorseNest = model.getCapturedHorseNest(horseNumber);
        int capturedHorseNumber = model.getCapturedHorseNumber(horseNumber);
        capturedHorseLabel.setText(model.getPlayerName(model.getPlayerNumber(capturedHorseColor)));
        view.updateCaptured(actionBox, enterHomeLabel, leaveNestLabel, regularMoveLabel, upperHomeLabel, capturedBox);
        if (capturedHorseNumber == 0) {
            view.captureHorse(horse1, horsePointing1, horseCaptured1, pointing1, capturePosition, capturedHorseNest, capturingHorseCurrentPos);
        } else if (capturedHorseNumber == 1) {
            view.captureHorse(horse1, horsePointing1, horseCaptured2, pointing2, capturePosition, capturedHorseNest, capturingHorseCurrentPos);
        } else if (capturedHorseNumber == 2) {
            view.captureHorse(horse1, horsePointing1, horseCaptured3, pointing3, capturePosition, capturedHorseNest, capturingHorseCurrentPos);
        } else if (capturedHorseNumber == 3) {
            view.captureHorse(horse1, horsePointing1, horseCaptured4, pointing4, capturePosition, capturedHorseNest, capturingHorseCurrentPos);
        }
        model.moveHorse(capturedHorseColor, capturedHorseNumber, "toNest");
        //wait until moving completed
        PauseTransition pause = new PauseTransition(Duration.millis(300 * (model.getNumberOfMoves() + 1)));
        pause.setOnFinished(e -> {
            updateScoreForPlayers("captured", capturedHorseNumber, model.getPlayerNumber(capturedHorseColor));
            updateScoreForPlayers( "capturing", horseNumber, playerNumber);
        });
        pause.play();
    }

    //check if game has complete
    public void checkForCompleteGame(String horseColor, int horseNumber, int playerNumber) {
        if (model.checkCompleteGame(horseColor, horseNumber)) {
            model.stopMoving();
            PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
            pause.setOnFinished(e -> {
                endGame(model.getPlayerName(playerNumber));
            });
            pause.play();
        } else {
            doneMove();
        }
    }

    //end game
    private void endGame(String winner) {
        String nameOfHighestScorePlayer = getPlayerWithHighestScore();
        view.endGame(winner, completePlayer, highestScorePlayer, nameOfHighestScorePlayer, endGamePane);
    }

    //get highest score player name
    private String getPlayerWithHighestScore() {
        int compareCount = 0;//Counting the matching player's score with the highest score
        int highestScore = model.findHighestScore();
        String nameOfHighestScorePlayer = null;

        //Checking for all score of all player
        for (int i = 0; i < 4; i++) {
            if (highestScore == model.getIntScore(i) && (compareCount == 0)) { //If there's a first match
                nameOfHighestScorePlayer = model.getPlayerName(i);
                compareCount++;
            } else if (highestScore == model.getIntScore(i)) { //If there's more than one match
                nameOfHighestScorePlayer += " & " + model.getPlayerName(i);; //Adding all the names together
            }
        }
        return nameOfHighestScorePlayer;
    }

    //done a move
    private void doneMove() {
        if (model.getPlayerType().equals("human")) { //wait until moving completed
            PauseTransition pause = new PauseTransition(Duration.millis(300 * (model.getNumberOfMoves() + 1)));
            pause.setOnFinished(e -> {
                if (model.getAllDiceUsed() || model.getSelectedDice().equals("total")) {
                    displayPossibleDices(new boolean[]{false, false, false});
                } else {
                    disableHorse(model.getTurn(), false);
                    model.setAllDiceUsed();
                    if (model.getSelectedDice().equals("one")) {
                        displayPossibleDices(new boolean[]{false, true, false});
                    } else if (model.getSelectedDice().equals("two")) {
                        displayPossibleDices(new boolean[]{true, false, false});
                    }
                }
            });
            pause.play();
        }
    }

    //done a turn
    private void doneTurn() {
        if (model.getNumberOfMoves() != -1) {
            actionBox.setVisible(false);
            playerTurnName.setText(model.getPlayerName(model.getNextPlayerNumber()));
            model.resetNumberOfMoves();
            model.resetAllDiceUsed();
            if (model.getNextPlayerType().equals("machine")) { //if next player is machine, automatically roll dice
                rollDice(new ActionEvent());
            } else {
                rollDiceBtn.setDisable(false);
                model.setNextTurn("none"); //set to preparation state
            }
        }
    }

    //back to end game interface
    public void continueGame(ActionEvent event) {view.continueGame(confirmQuitBox);}

    //display confirm box
    public void confirmQuitGame(ActionEvent event) {
        view.confirmQuitGame(confirmQuitBox);
    }

    public void playAgain(ActionEvent event) {
        playAgainPane.setVisible(true);
    }

    public void toEndGame(ActionEvent event) {
        playAgainPane.setVisible(false);
    }

    //quit game
    public void quitGame(ActionEvent event) {
        Platform.exit();
    }

    //change language to Vietnamese
    public void toVietnamese(ActionEvent event) {
        view.toVietnamese(toVNBtn, vietnameseLanguageBox, englishLanguageBox);
        Locale.setDefault(new Locale("vi", "VN"));
        changeLanguage();
    }

    //change language to English
    public void toEnglish(ActionEvent event) {
        view.toEnglish(toVNBtn, vietnameseLanguageBox, englishLanguageBox);
        Locale.setDefault(new Locale("en", "US"));
        changeLanguage();
    }

    //change language
    private void changeLanguage() {
        ResourceBundle bundle = ResourceBundle.getBundle("GameBundle");
        languageLabel.setText(bundle.getString("language"));
        scoreLabel.setText(bundle.getString("score"));
        colorLabel.setText(bundle.getString("color"));
        nameLabel.setText(bundle.getString("name"));
        machineLabel.setText(bundle.getString("machine"));
        humanLabel.setText(bundle.getString("humans"));
        name1.setText(bundle.getString("name1"));
        name2.setText(bundle.getString("name2"));
        name3.setText(bundle.getString("name3"));
        name4.setText(bundle.getString("name4"));
        diceLabel.setText(bundle.getString("dice"));
        continueBtn.setText(bundle.getString("continue"));
        quitGameBtn.setText(bundle.getString("quit"));
        quitGameBtn1.setText(bundle.getString("quit"));
        restartBtn.setText(bundle.getString("restart"));
        newGameBtn.setText(bundle.getString("newGame"));
        rollDiceBtn.setText(bundle.getString("roll"));
        confirmQuitMessage.setText(bundle.getString("quittingAlert"));
        setUp2AlertMessage.setText(bundle.getString("setUp2Alert"));
        setUp2Notice.setText(bundle.getString("setUp2Notice"));
        setUp1Notice.setText(bundle.getString("setUp1Notice"));
        completePlayerNoti.setText(bundle.getString("completeGameAnnounce"));
        highestScoreNoti.setText(bundle.getString("playerHighestScoreAnnounce"));
        congratulationNoti.setText(bundle.getString("congratulation"));
        turnLabel.setText(bundle.getString("turn"));
        diceUsed.setText(bundle.getString("diceUsed"));
        leaveNestLabel.setText(bundle.getString("leaveNest"));
        upperHomeLabel.setText(bundle.getString("upperHome"));
        enterHomeLabel.setText(bundle.getString("enterHome"));
        regularMoveLabel.setText(bundle.getString("regular"));
        capturedLabel.setText(bundle.getString("capture"));
        playAgainBtn.setText(bundle.getString("playAgain"));
    }
}
