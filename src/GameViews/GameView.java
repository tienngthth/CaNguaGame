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

package GameViews;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.xml.crypto.KeySelectorException;
import java.io.*;
import java.net.URL;

public class GameView {
    private MediaPlayer soundRegular, soundCapture, soundScore, soundGameOver, soundDice;
    private int[][] coordinate = new int[88][2];
    //From 0 - > 47: moving path. From 48 -> 63: home nest. From 64 -> 87: home path
    private boolean playSound = true;
    private KeySelectorException Exceptions;

    public GameView() throws IOException {
        setCoordinate();
        setMediaPlayer();
    }

    //set coordinate for all positions in game board
    private void setCoordinate() {
        int homeGap = 33;
        int regularGap = 40;
        setBlueCoordinate(homeGap , regularGap);
        setYellowCoordinate(homeGap , regularGap);
        setGreenCoordinate(homeGap , regularGap);
        setRedCoordinate(homeGap , regularGap);
    }

    //set coordinate for blue positions in game board
    private void setBlueCoordinate(int homeGap, int regularGap) {
        int[] firstVBlue = {210, 15};
        int[] firstHBlue = {175, 215};
        int[] homeArrivalBlue = {285, 15};
        int[] firstBlueHome = {285, 60};
        int[] firstNestBlue = {60, 60};

        setVerticallyUp(0,5, firstVBlue, regularGap);
        setHorizontallyUp(6,10, firstHBlue, regularGap);
        coordinate[47] = homeArrivalBlue;
        setNest(48, firstNestBlue,regularGap);
        setVerticallyUp(64, 69, firstBlueHome, homeGap);
    }

    //set coordinate for yellow positions in game board
    private void setYellowCoordinate(int homeGap, int regularGap) {
        int[] firstVYellow = {210, 355};
        int[] firstHYellow = {175, 355};
        int[] homeArrivalYellow = {10, 285};
        int[] firstYellowHome = {225, 285};
        int[] firstNestYellow = {60, 460};

        setVerticallyUp(17,22, firstVYellow, regularGap);
        setHorizontallyDown(16, 12, firstHYellow, regularGap);
        coordinate[11] = homeArrivalYellow;
        setNest(52, firstNestYellow, regularGap);
        setHorizontallyDown(75, 70, firstYellowHome, homeGap);
    }

    //set coordinate for green positions in game board
    private void setGreenCoordinate(int homeGap, int regularGap) {
        int[] firstVGreen = {355, 355};
        int[] firstHGreen = {555, 355};
        int[] homeArrivalGreen = {290, 555};
        int[] firstGreenHome = {290, 350};
        int[] firstNestGreen = {460, 460};

        setVerticallyDown(29,24, firstVGreen, regularGap);
        setHorizontallyDown(34,30, firstHGreen, regularGap);
        coordinate[23] = homeArrivalGreen;
        setNest(56, firstNestGreen, regularGap);
        setVerticallyDown(81,76, firstGreenHome, homeGap);
    }

    //set coordinate for red positions in game board
    private void setRedCoordinate(int homeGap, int regularGap) {
        int[] firstVRed = {355, 15};
        int[] firstHRed = {555, 215};
        int[] homeArrivalRed = {555, 285};
        int[] firstRedHome = {505, 285};
        int[] firstNestRed = {460, 60};

        setVerticallyDown(46,41, firstVRed, regularGap);
        setHorizontallyUp(36,40, firstHRed, regularGap);
        coordinate[35] = homeArrivalRed;
        setNest(60, firstNestRed, regularGap);
        setHorizontallyUp(82, 87, firstRedHome, homeGap);
    }

    //set coordinate for nest positions
    private void setNest(int firstPlace, int[] firstNest, int regularGap) {
        coordinate[firstPlace][0] = firstNest[0];
        coordinate[firstPlace][1] = firstNest[1];
        coordinate[firstPlace + 1][0] = firstNest[0];
        coordinate[firstPlace + 1][1] = firstNest[1] + regularGap;
        coordinate[firstPlace + 2][0] = firstNest[0] + regularGap;
        coordinate[firstPlace + 2][1] = firstNest[1] + regularGap;
        coordinate[firstPlace + 3][0] = firstNest[0] + regularGap;
        coordinate[firstPlace + 3][1] = firstNest[1];
    }

    //set coordinate for a vertical moving path
    private void setVerticallyUp(int firstPlace, int lastPlace, int[] firstValue, int gap) {
        for (int i = 0; i <= Math.abs(lastPlace - firstPlace); ++i) {
            coordinate[i + firstPlace][0] = firstValue[0];
            coordinate[i + firstPlace][1] = firstValue[1] + i*gap;
        }
    }

    //set coordinate for a vertical moving path
    private void setVerticallyDown(int firstPlace, int lastPlace, int[] firstValue, int gap) {
        for (int i = 0; i <= Math.abs(lastPlace - firstPlace); ++i) {
            coordinate[firstPlace - i][0] = firstValue[0];
            coordinate[firstPlace - i][1] = firstValue[1] + i*gap;
        }
    }

    //set coordinate for a horizontal moving path
    private void setHorizontallyUp(int firstPlace, int lastPlace, int[] firstValue, int gap) {
        for (int i = 0; i <= Math.abs(lastPlace - firstPlace); ++i) {
            coordinate[i + firstPlace][0] = firstValue[0] - i * gap;
            coordinate[i + firstPlace][1] = firstValue[1];
        }
    }

    //set coordinate for a horizontal moving path
    private void setHorizontallyDown(int firstPlace, int lastPlace, int[] firstValue, int gap) {
        for (int i = 0; i <= Math.abs(lastPlace - firstPlace); ++i) {
            coordinate[firstPlace - i][0] = firstValue[0] - i * gap;
            coordinate[firstPlace - i][1] = firstValue[1];
        }
    }

    //set music for game
    private void setMediaPlayer() {
        Media sound1 = new Media(setSound("GameSound/capturePiece.wav"));
        soundCapture = new MediaPlayer(sound1);
        Media sound2 = new Media(setSound("GameSound/regularMove.wav"));
        soundRegular = new MediaPlayer(sound2);
        Media sound3 = new Media(setSound("GameSound/homeScore.wav"));
        soundScore = new MediaPlayer(sound3);
        Media sound5 = new Media(setSound("GameSound/gameOver.mp3"));
        soundGameOver = new MediaPlayer(sound5);
        Media sound6 = new Media(setSound("GameSound/diceRolling.wav"));
        soundDice = new MediaPlayer(sound6);
    }

    private String setSound (String soundFile) {
        URL res = getClass().getResource("/" + soundFile);
        if (res.getProtocol().equals("jar")) {
            return getClass().getClassLoader().getResource(soundFile).toExternalForm();
        } else {
            return new File("src/" + soundFile).toURI().toString();
        }
    }

    //turn off sound
    public void soundOff(Button musicOffBtn, Button musicOnBtn) {
        musicOffBtn.setVisible(false);
        musicOnBtn.setVisible(true);
        playSound = false;
    }

    //turn on sound
    public void soundOn(Button musicOffBtn, Button musicOnBtn) {
        musicOnBtn.setVisible(false);
        musicOffBtn.setVisible(true);
        playSound = true;
    }

    //turn to set up 2
    public void toSetUp2(VBox setUp1, VBox setUp2, HBox player3Color, HBox player4Color, int numberOfPlayers) {
        setVisiblePlayer34(player3Color, player4Color, numberOfPlayers);
        setUp1.setVisible(false);
        setUp2.setVisible(true);
    }

    //set visibility status for player 3 and 4 components
    private void setVisiblePlayer34(HBox component1, HBox component2, int numberOfPlayer) {
        if (numberOfPlayer == 2) {
            setVisiblePlayer34Boxes(component1, component2, false, false);
        } else if (numberOfPlayer == 4) {
            setVisiblePlayer34Boxes(component1, component2, true, true);
        } else {
            setVisiblePlayer34Boxes(component1, component2, true, false);
        }
    }

    //set visibility status for player 3 and 4 components
    private void setVisiblePlayer34Boxes(HBox component1, HBox component2, boolean status1, boolean status2) {
        component1.setVisible(status1);
        component2.setVisible(status2);
    }

    //disable enter name for machine players
    public void setDisableNameTextField(TextField name1, TextField name2, TextField name3, TextField name4, int numberOfHumanPlayers) {
        if (numberOfHumanPlayers == 0) {
            setDisableNames(name1, name2, name3, name4,true, true, true, true);
        } else if (numberOfHumanPlayers == 1) {
            setDisableNames(name1, name2, name3, name4,false, true, true, true);
        } else if (numberOfHumanPlayers == 2) {
            setDisableNames(name1, name2, name3, name4,false, false, true, true);
        } else if (numberOfHumanPlayers == 3) {
            setDisableNames(name1, name2, name3, name4,false, false, false, true);
        } else {
            setDisableNames(name1, name2, name3, name4,false, false, false, false);
        }
    }

    //disable enter name for machine players
    private void setDisableNames(TextField name1, TextField name2, TextField name3, TextField name4, boolean status1, boolean status2, boolean status3, boolean status4) {
        name1.setDisable(status1);
        name2.setDisable(status2);
        name3.setDisable(status3);
        name4.setDisable(status4);
    }

    //move back to set up 1
    public void toSetUp1(VBox setUp1, VBox setUp2) {
        setUp1.setVisible(true);
        setUp2.setVisible(false);
    }

    //unselect other buttons when 1 button of that color is selected
    public void selectAColor(RadioButton selectedBtn, RadioButton nonSelectedBtn1, RadioButton nonSelectedBtn2, RadioButton nonSelectedBtn3) {
        nonSelectedBtn1.setSelected(false);
        nonSelectedBtn2.setSelected(false);
        nonSelectedBtn3.setSelected(false);
        selectedBtn.setSelected(true);
    }

    //back to in-game interface when restart game
    public void restartGame(StackPane endGamePane, ImageView dice2Image, Button dice1, Button dice2, Button diceTotal, StackPane playAgainPane) {
        playAgainPane.setVisible(false);
        endGamePane.setVisible(false);
        resetDiceImg(dice2Image, dice1, dice2, diceTotal);
    }

    //reset dice img to unknown values
    public void resetDiceImg(ImageView dice2Image, Button dice1, Button dice2, Button diceTotal) {
        dice2Image.setVisible(false);
        dice1.setText("?");
        dice2.setText("?");
        diceTotal.setText("?");
    }

    //bring blue horses to nest
    public void setHorseBlue(ImageView horse1,ImageView horse2, ImageView horse3, ImageView horse4, ImageView pointing1, ImageView pointing2, ImageView pointing3, ImageView pointing4, boolean status) {
        moveHorse(horse1, 48, pointing1);
        moveHorse(horse2, 49, pointing2);
        moveHorse(horse3, 50, pointing3);
        moveHorse(horse4, 51, pointing4);
        setVisibleHorses(horse1, horse2, horse3, horse4, status);
    }

    //bring yellow horses to nest
    public void setHorseYellow(ImageView horse1,ImageView horse2, ImageView horse3, ImageView horse4, ImageView pointing1,ImageView pointing2, ImageView pointing3, ImageView pointing4, boolean status) {
        moveHorse(horse1, 52, pointing1);
        moveHorse(horse2, 53, pointing2);
        moveHorse(horse3, 54, pointing3);
        moveHorse(horse4, 55, pointing4);
        setVisibleHorses(horse1, horse2, horse3, horse4, status);
    }

    //bring green horses to nest
    public void setHorseGreen(ImageView horse1,ImageView horse2, ImageView horse3, ImageView horse4, ImageView pointing1,ImageView pointing2, ImageView pointing3, ImageView pointing4, boolean status ) {
        moveHorse(horse1, 56, pointing1);
        moveHorse(horse2, 57, pointing2);
        moveHorse(horse3, 58, pointing3);
        moveHorse(horse4, 59, pointing4);
        setVisibleHorses(horse1, horse2, horse3, horse4, status);
    }

    //bring red horses to nest
    public void setHorseRed(ImageView horse1,ImageView horse2, ImageView horse3, ImageView horse4, ImageView pointing1,ImageView pointing2, ImageView pointing3, ImageView pointing4, boolean status) {
        moveHorse(horse1, 60, pointing1);
        moveHorse(horse2, 61, pointing2);
        moveHorse(horse3, 62, pointing3);
        moveHorse(horse4, 63, pointing4);
        setVisibleHorses(horse1, horse2, horse3, horse4, status);
    }

    //set visibility for horse of a color
    public void setVisibleHorses(ImageView horse1, ImageView horse2, ImageView horse3, ImageView horse4, boolean status) {
        horse1.setVisible(status);
        horse2.setVisible(status);
        horse3.setVisible(status);
        horse4.setVisible(status);
    }

    //display set up 1 when starting to create new game
    public void createNewGame(StackPane setUpInterface, VBox setUp1, VBox setUp2, StackPane endGamePane, StackPane playAgainPane) {
        playAgainPane.setVisible(false);
        endGamePane.setVisible(false);
        toSetUp1(setUp1, setUp2);
        setUpInterface.setVisible(true);
    }

    //alert message when players' colors or names is invalid
    public void alertSetUp2(Label alertMessage) {
        alertMessage.setVisible(true);
    }

    //get in to in-game interface
    public void startNewGame(StackPane setUpInterface, HBox score3, HBox score4, int numberOfPlayer, Label alertMessage, ImageView dice2Image, Button dice1, Button dice2, Button diceTotal) {
        resetDiceImg(dice2Image, dice1, dice2, diceTotal);
        alertMessage.setVisible(false);
        setVisiblePlayer34(score3, score4, numberOfPlayer);
        setUpInterface.setVisible(false);
    }

    //set color to player name and score's labels
    public void setPlayerScoreNameColor(Label playerName, Label playerScore, String playerColor, String name) {
        playerName.setText(name);
        playerScore.setText("0");
        if (playerColor.equals("blue")) {
            playerName.setStyle("-fx-text-fill : blue;");
            playerScore.setStyle("-fx-text-fill : blue;");
        } else if (playerColor.equals("yellow")) {
            playerName.setStyle("-fx-text-fill : yellow;");
            playerScore.setStyle("-fx-text-fill : yellow;");
        } else if (playerColor.equals("green")) {
            playerName.setStyle("-fx-text-fill : green;");
            playerScore.setStyle("-fx-text-fill : green;");
        } else if (playerColor.equals("red")) {
            playerName.setStyle("-fx-text-fill : red;");
            playerScore.setStyle("-fx-text-fill : red;");
        }
    }

    //disable dices and roll dice button after roll dice
    public void setDisableDices(Button firstDiceBtn, Button secondDiceBtn, Button totalDiceBtn, Button rollDice) {
        disableDiceBtn(firstDiceBtn, secondDiceBtn, totalDiceBtn, true);
        rollDice.setDisable(true);
    }

    //set disability status for dice buttons
    public void disableDiceBtn(Button firstDiceBtn, Button secondDiceBtn, Button totalDiceBtn, Boolean status) {
        firstDiceBtn.setDisable(status);
        secondDiceBtn.setDisable(status);
        totalDiceBtn.setDisable(status);
    }

    //set visible pointings for horses having moves
    public void setVisiblePointings(ImageView pointing1, ImageView pointing2, ImageView pointing3, ImageView pointing4, boolean status1, boolean status2, boolean status3, boolean status4) {
        pointing1.setVisible(status1);
        pointing2.setVisible(status2);
        pointing3.setVisible(status3);
        pointing4.setVisible(status4);
    }

    //set dice value image
    public void setDiceImage(int diceValue, ImageView dice) {
        switch (diceValue) {
            case 0:
                dice.setImage(new Image("GameImages/dice.png"));
                break;
            case 1:
                dice.setImage(new Image("GameImages/dice1.jpg"));
                break;
            case 2:
                dice.setImage(new Image("GameImages/dice2.jpg"));
                break;
            case 3:
                dice.setImage(new Image("GameImages/dice3.jpg"));
                break;
            case 4:
                dice.setImage(new Image("GameImages/dice4.jpg"));
                break;
            case 5:
                dice.setImage(new Image("GameImages/dice5.jpg"));
                break;
            case 6:
                dice.setImage(new Image("GameImages/dice6.jpg"));
                break;
        }
    }

    //move horse animation
    public int moveHorseOneByOne(ImageView horse, int newPosition, ImageView point, int currentPos) {
        point.setTranslateX(coordinate[newPosition][0] - 20);
        point.setTranslateY(coordinate[newPosition][1] - 20);
        if (newPosition > currentPos) {
            int i;
            for (i = 0; i < newPosition - currentPos; ++i) {
                incrementMoveHorse(horse, currentPos, i);
            }
            return i - 1;
        } else {
            return moveHorseFromPosition0(currentPos, horse, newPosition);
        }
    }

    //move horse from the start of moving path (index 0)
    private int moveHorseFromPosition0(int currentPos, ImageView horse, int newPosition) {
        PauseTransition pause;
        int i, j;
        for (i = 0; i < 47 - currentPos; ++i) {
            incrementMoveHorse(horse, currentPos, i);
        }
        for (j = 0; j <= newPosition; ++j) {
            pause = new PauseTransition(Duration.millis(300 * (i + j)));
            TranslateTransition ttr = new TranslateTransition(Duration.millis(250), horse);
            ttr.setToX(coordinate[0 + j][0]);
            ttr.setToY(coordinate[0 + j][1]);
            pause.setOnFinished(e -> {
                ttr.play();
                playRegularMoveSound();
            });
            pause.play();
        }
        return i + j - 1;
    }

    //move horse after waiting moveNum*300 millis to have a smooth animation
    private void incrementMoveHorse(ImageView horse, int currentPos, int moveNumber) {
        PauseTransition pause;
        pause = new PauseTransition(Duration.millis(300 * moveNumber));
        TranslateTransition tt = new TranslateTransition(Duration.millis(250), horse);
        tt.setToX(coordinate[currentPos + moveNumber + 1][0]);
        tt.setToY(coordinate[currentPos + moveNumber + 1][1]);
        tt.setOnFinished(e -> playRegularMoveSound());
        pause.setOnFinished(e -> {
            tt.play();
        });
        pause.play();
    }

    //regular move sound
    public void playRegularMoveSound() {
        if (playSound) {
            soundRegular.seek(Duration.seconds(0));
            soundRegular.play();
        }
    }

    //rolling dice sound
    public void playSoundDice() {
        if (playSound) {
            soundDice.seek(Duration.seconds(0));
            soundDice.play();
        }
    }

    //move horse animation straight to new position
    public void moveHorse(ImageView horse, int newPosition, ImageView point) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(500), horse);
        tt.setToX(coordinate[newPosition][0]);
        tt.setToY(coordinate[newPosition][1]);
        tt.play();
        point.setTranslateX(coordinate[newPosition][0] - 20);
        point.setTranslateY(coordinate[newPosition][1] - 20);
    }

    //animation for regular move
    public void regularMove(ImageView horse, int newPosition, ImageView point, int currentPos) {
        if (currentPos > 47) {//leave nest
            moveHorse(horse, newPosition, point);
            playRegularMoveSound();
        } else {
            moveHorseOneByOne(horse, newPosition, point, currentPos);
        }
    }

    //capture horse animation
    public void captureHorse(ImageView horse, ImageView pointing1, ImageView capturedHorse, ImageView pointing2, int newPosition, int nest, int currentPosOfCapturingHorse) {
        if (currentPosOfCapturingHorse > 47) { //leave nest
            captureHorse(horse, pointing1, capturedHorse, pointing2, newPosition, nest);
        }
        else {
            int i = moveHorseOneByOne(horse, newPosition, pointing1, currentPosOfCapturingHorse);
            PauseTransition pause = new PauseTransition(Duration.millis(300*i));
            pause.setOnFinished(
                    e -> {
                        captureHorse(horse, pointing1, capturedHorse, pointing2, newPosition, nest);
                    });
            pause.play();
        }
    }

    //capture a horse after leaving nest
    private void captureHorse(ImageView horse, ImageView pointing1, ImageView capturedHorse, ImageView pointing2, int newPosition, int nest) {
        moveHorse(capturedHorse, nest, pointing2);
        moveHorse(horse, newPosition, pointing1);
        if (playSound) {
            soundCapture.seek(Duration.seconds(0));
            soundCapture.play();
        }
    }

    //move horse to a home position
    public void moveHome(ImageView horse, int newPlace, ImageView point) {
        moveHorse(horse, newPlace, point);
        if (playSound) {
            soundScore.seek(Duration.seconds(0));
            soundScore.play();
        }
    }

    //set disability status for horses
    public void disableHorse(ImageView horse1, ImageView horse2, ImageView horse3, ImageView horse4, Boolean status) {
        horse1.setDisable(status);
        horse2.setDisable(status);
        horse3.setDisable(status);
        horse4.setDisable(status);
    }

    //end game, display winners
    public void endGame(String winner, Label completePlayer, Label highestScorePlayer, String nameOfHighestScorePlayer, StackPane endGamePane) {
        completePlayer.setText(winner);
        highestScorePlayer.setText(nameOfHighestScorePlayer);
        endGamePane.setVisible(true);
        if (playSound) {
            soundGameOver.seek(Duration.seconds(0));
            soundGameOver.play();
        }
    }

    public void updateRegularMove(VBox actionBox, Label enterHomeLabel, Label leaveNestLabel, Label regularMoveLabel, Label upperHomeLabel, VBox capturedBox) {
        updateGameStatus(actionBox, regularMoveLabel, enterHomeLabel, leaveNestLabel, upperHomeLabel, capturedBox);
    }

    public void updateEnterHome(VBox actionBox, Label enterHomeLabel, Label leaveNestLabel, Label regularMoveLabel, Label upperHomeLabel, VBox capturedBox) {
        updateGameStatus(actionBox, enterHomeLabel, regularMoveLabel, leaveNestLabel, upperHomeLabel, capturedBox);
    }

    public void updateLeaveNest(VBox actionBox, Label enterHomeLabel, Label leaveNestLabel, Label regularMoveLabel, Label upperHomeLabel, VBox capturedBox) {
        updateGameStatus(actionBox, leaveNestLabel, enterHomeLabel, regularMoveLabel, upperHomeLabel, capturedBox);
    }

    public void updateUpperHome(VBox actionBox, Label enterHomeLabel, Label leaveNestLabel, Label regularMoveLabel, Label upperHomeLabel, VBox capturedBox) {
        updateGameStatus(actionBox, upperHomeLabel, leaveNestLabel, enterHomeLabel, regularMoveLabel, capturedBox);
    }

    public void updateCaptured(VBox actionBox, Label enterHomeLabel, Label leaveNestLabel, Label regularMoveLabel, Label upperHomeLabel, VBox capturedBox) {
        actionBox.setVisible(true);
        capturedBox.setVisible(true);
        enterHomeLabel.setVisible(false);
        leaveNestLabel.setVisible(false);
        regularMoveLabel.setVisible(false);
        upperHomeLabel.setVisible(false);
    }

    public void updateGameStatus(VBox actionBox, Label correctMoveType, Label moveType2, Label moveType3, Label moveType4, VBox moveType5) {
        actionBox.setVisible(true);
        correctMoveType.setVisible(true);
        moveType2.setVisible(false);
        moveType3.setVisible(false);
        moveType4.setVisible(false);
        moveType5.setVisible(false);
    }

    //back to end game interface box
    public void continueGame(StackPane confirmQuitBox) {
        confirmQuitBox.setVisible(false);
    }

    //display confirm box
    public void confirmQuitGame(StackPane confirmQuitBox) {
        confirmQuitBox.setVisible(true);
    }

    //change language to Vietnamese
    public void toVietnamese(Button toVNBtn, ChoiceBox vietnameseLanguageBox, ChoiceBox englishLanguageBox) {
        toVNBtn.setVisible(false);
        vietnameseLanguageBox.setVisible(true);
        englishLanguageBox.setValue("English");
        englishLanguageBox.setVisible(false);
    }

    //change language to English
    public void toEnglish(Button toVNBtn, ChoiceBox vietnameseLanguageBox, ChoiceBox englishLanguageBox) {
        toVNBtn.setVisible(true);
        vietnameseLanguageBox.setVisible(false);
        vietnameseLanguageBox.setValue("Tiếng Việt");
        englishLanguageBox.setVisible(true);
    }
}

