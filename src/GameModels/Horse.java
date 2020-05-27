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

public class Horse {
    protected String color;
    protected int currentPos, nextPos, startPos, homeArrivalPos, horseNumber, inNestPos;
    protected int[] homePos = new int[6]; //All 6 Home Positions

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public void setHomeArrivalPos(int endPos) {
        this.homeArrivalPos = endPos;
    }

    public void setHomePos(int[] homePos) {
        this.homePos = homePos;
    }

    public void setNestPos(int horseNumber, int nestPosList[]) { //Each nest has 4 position for 4 pieces, by giving each horse a horseNumber, we can set it nest Position
        switch (horseNumber) {
            case 0:
                inNestPos = nestPosList[0];
                currentPos = inNestPos;
                break;
            case 1:
                inNestPos = nestPosList[1];
                currentPos = inNestPos;
                break;
            case 2:
                inNestPos = nestPosList[2];
                currentPos = inNestPos;
                break;
            case 3:
                inNestPos = nestPosList[3];
                currentPos = inNestPos;
                break;
        }
    }

    public void setHorseNumber(int horseNumber) {
        this.horseNumber = horseNumber;
    }

    //set next move to -1 when the horse is blocked
    public void blockNextMove() {
        nextPos = -1;
    }

    //check if there is any valid move and return move type
    public String checkMoveType(int dice, String selectedValue) {
        if (checkLeaveNest(dice) && !selectedValue.equals("total")) {
            return "leaveNest";
        } else if (checkEnterHome(dice) && !selectedValue.equals("total") && ((nextPos == homePos[0]) || (nextPos == homePos[1]))) {
            return "enterHomeMax2";
        } else if (checkEnterHome(dice) && !selectedValue.equals("total")) {
            return "enterHomeMin3";
        } else if (checkUpperHome(dice) && !selectedValue.equals("total")) {
            return "upperHome";
        } else if (checkRegularMove(dice) && nextPos == homeArrivalPos) {
            return "toHomeArrival";
        } else if (checkRegularMove(dice) && currentPos == startPos) {
            return "moveOutStartPos";
        } else if (checkRegularMove(dice)) {
            return "regular";
        } else {
            return "false";
        }
    }

    //check if the host move 1 steps forward inside home field with the dice value
    public boolean checkUpperHome(int diceResult) {
        if (findIndex(homePos, currentPos) != -1 && currentPos != homePos[5]) { //In circumstance that a horse is at one of the Home Positions except the top one
            if (diceResult == currentPos - homePos[0] + 2) { //Only allow horse to move if the diceResult indicate the next Position in order
                nextPos = homePos[diceResult - 1];
                return true;
            } else {return false;}
        } else {return false;}
    }

    //Method to find a value inside an array -> Used in homeMove()
    public int findIndex(int homePos[], int t) {
        int i = 0;
        while (i < homePos.length) {
            if (homePos[i] == t) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1; //If no index found -> return -1, else -> return an integer
    }

    //check for regular move with the dice value
    public boolean checkRegularMove(int diceResult) {
        if (currentPos == inNestPos || findIndex(homePos, currentPos) != -1 || currentPos == homeArrivalPos) {return false;}
        int tempPos = getNextRegularMovePos(diceResult);
        if (currentPos < homeArrivalPos && tempPos > homeArrivalPos) {return false;}
        else {
            nextPos = tempPos;
            return true;
        }
    }

    //find the next regular move position with the dice value
    private int getNextRegularMovePos(int diceResult) { //find Next Position
        int tempPos;
        if ((currentPos + diceResult) > 47) {
            tempPos = currentPos + diceResult - 48;
        } else { tempPos = currentPos + diceResult;}
        return tempPos;
    }

    //check if the horse can enter home with the dice value
    public boolean checkEnterHome(int diceResult) {
        if (currentPos == homeArrivalPos) {//In circumstance that a horse is at the Home Arrival
            switch (diceResult) {
                case 1:
                    nextPos = homePos[0];
                    return true;
                case 2:
                    nextPos = homePos[1];
                    return true;
                case 3:
                    nextPos = homePos[2];
                    return true;
                case 4:
                    nextPos = homePos[3];
                    return true;
                case 5:
                    nextPos = homePos[4];
                    return true;
                case 6:
                    nextPos = homePos[5];
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    //check if the horse can leave nest with the dice value
    public boolean checkLeaveNest(int dice) {
        if ((dice == 6) && (currentPos == inNestPos)) {
            nextPos = startPos;
            return true;
        } else {return false;}
    }

    //move to horse to a new place in the board
    public void moveHorse(String moveType) {
        switch (moveType) {
            case "toNest":
                currentPos = inNestPos;
                break;
            case "moveHorse":
                currentPos = nextPos;
                break;
        }
    }

    //count the distant from the current position to the home arrival position
    public int countDistantToHome() {
        if (currentPos > homeArrivalPos) {
            return 47 - currentPos + homeArrivalPos + 1;
        } else {
            return homeArrivalPos - currentPos;
        }
    }
}

