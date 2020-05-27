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

import java.util.ArrayList;

public class Dice {
    private int firstPlayer = 0; //find the player who plays first,
    private int numberOfRollTimes = 0; //count number of roll times
    private int firstDice, secondDice, totalDice; //dices' values
    private boolean allDiceUsed = false; //maximum 2 dice can be used for a turn
    private  ArrayList<Integer> rolls = new ArrayList<Integer>();
    private String selectedDice; //remember a value has just been selected is the total sum or not

    //reset dice values when new game
    public void resetDice() {
        numberOfRollTimes = 0;
        firstPlayer = 0;
        resetAllDiceUsed();
        rolls.clear();
    }

    //find first player to play's number (number 0 is the one who roll first)
    public void findFirstPlayer(int numberOfPlayers) {
        ++this.numberOfRollTimes;
        firstDice = getRandomDiceValue();
        if (firstDice == 6) { //stop when dice value is 6
            firstPlayer = numberOfRollTimes; //remember the rolling times that get the 6
            numberOfRollTimes = numberOfPlayers; //remember as all player has rolled
        } else {
            rolls.add(firstDice);
            firstPlayer = (firstDice > firstPlayer) ? firstDice : firstPlayer;
            if (numberOfRollTimes == numberOfPlayers) {
                firstPlayer = rolls.indexOf(firstPlayer) + 1;
            }
        }
    }

    //random a value from 1 to 6
    private int getRandomDiceValue() {
        return (int)Math.ceil(Math.random() * 6.0);
    }

    //get first player to play's number (number 0 is the one who roll first)
    public int getFirstPlayer() {
        return firstPlayer;
    }

    //get number of times rolling dices
    public int getNumberOfRollTimes() {
        return numberOfRollTimes;
    }

    //random 2 dices
    public void rollDice() {
        firstDice = getRandomDiceValue();
        secondDice = getRandomDiceValue();
        totalDice = firstDice + secondDice;
    }

    //get 1st dice value
    public int getFirstDice() {
        return firstDice;
    }

    //get 2nd dice value
    public int getSecondDice() {
        return secondDice;
    }

    //get total value of 2 dices
    public int getTotalDice() {
        return totalDice;
    }

    //select the total value of 2 dices to use
    public void setSelectedDice(String selectedDice) {
        this.selectedDice = selectedDice;
    }

    //select dice 1 or dice 2 values to use
    public String getSelectedDice() {
        return selectedDice;
    }

    //all dice has been used
    void setAllDiceUsed() {
        allDiceUsed = true;
    }

    //reset to one dice has been used
    void resetAllDiceUsed() {
        allDiceUsed = false;
    }

    //check if all dice has been used
    boolean getAllDiceUsed() {
        return allDiceUsed;
    }

}

