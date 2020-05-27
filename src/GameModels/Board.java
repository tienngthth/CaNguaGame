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

public class Board {
    private ArrayList<BlueHorse> blueHorsesList = new ArrayList<BlueHorse>();
    private ArrayList<YellowHorse> yellowHorsesList = new ArrayList<YellowHorse>();
    private ArrayList<GreenHorse> greenHorsesList = new ArrayList<GreenHorse>();
    private ArrayList<RedHorse> redHorsesList = new ArrayList<RedHorse>();
    private boolean[] horsesMovableStatus = new boolean[4]; //movable status of all 4 horses a this turn
    private String[] moveType = new String[4]; //all move types of all 4 horses a this turn
    private String[][] gameMap = new String[88][]; //All positions in the map, remember horse color and horse number for an occupied slot
    private String[][] capturedHorseInfo = new String[4][]; //information of the captured horses for a turn
    private String[] emptySpotOnMap = {"-1", "-1"}; //empty spot in a game map is saved as this

    Board() {
        createHorses();
        setUpBoard();
    }

    //create 4 array list of horses with 4 different colors
    private void createHorses() {
        for (int i = 0; i < 4; i++) {
            blueHorsesList.add(new BlueHorse(i));
            yellowHorsesList.add(new YellowHorse(i));
            greenHorsesList.add(new GreenHorse(i));
            redHorsesList.add(new RedHorse(i));
        }
    }

    //reset the board when new game
    public void resetBoard()    {
        for (int i = 0; i < 4; ++i) {
            blueHorsesList.get(i).resetHorse();
            yellowHorsesList.get(i).resetHorse();
            greenHorsesList.get(i).resetHorse();
            redHorsesList.get(i).resetHorse();
        }
        setUpBoard();
    }

    //set up game map when new game
    private void setUpBoard() {
        setMovingPathPositions();
        setNestPositions();
        setHomePositions();
    }

    //all moving path positions is now set to empty
    private void setMovingPathPositions() {
        for (int i = 0; i <= 47; ++i) {
            gameMap[i] = emptySpotOnMap;
        }
    }

    //all nest positions has a corresponding horse
    private void setNestPositions() {
        for (int i = 48; i <= 63; ++i) {
            if (i <= 51) {
                gameMap[i] = new String[]{"blue", Integer.toString(i)};
            } else if (i >= 52 && i <= 55) {
                gameMap[i] = new String[]{"yellow", Integer.toString(i)};
            } else if (i >= 56 && i <= 59) {
                gameMap[i] = new String[]{"green", Integer.toString(i)};
            } else {
                gameMap[i] = new String[]{"red", Integer.toString(i)};
            }
        }
    }

    //all home positions is now set to empty
    private void setHomePositions() {
        for (int i = 64; i <= 87; ++i) {
            gameMap[i] = emptySpotOnMap;
        }
    }

    //check if a player can move any horse with a dice value, dice value type is used to distinguish the total value which is invalid for some moves
    public boolean checkADice(String playerColor, int dice, String selectedValue) {
        if (playerColor.equals("blue")) {
            return checkHorsesMoves(dice, selectedValue, "blue");
        } else if (playerColor.equals("yellow")) {
            return checkHorsesMoves(dice, selectedValue, "yellow");
        } else if (playerColor.equals("green")) {
            return checkHorsesMoves(dice, selectedValue, "green");
        } else if (playerColor.equals("red")){
            return checkHorsesMoves(dice, selectedValue, "red");
        } else return false;
    }

    //go through each horse to check for valid move with the dice
    private boolean checkHorsesMoves(int dice, String selectedValue, String horseColor) {
        boolean haveMoves = false;
        ArrayList horseList;
        switch (horseColor) {
            case "blue":
                horseList = blueHorsesList;
                break;
            case "yellow":
                horseList = yellowHorsesList;
                break;
            case "green":
                horseList = greenHorsesList;
                break;
            case "red":
                horseList = redHorsesList;
                break;
            default:
                horseList = redHorsesList;
                break;
        }
        for (int i = 0; i < 4; ++i) {
            if (!checkHorse((Horse) horseList.get(i), dice, selectedValue, i, horseColor)) {
                setUnMovableHorse(i, (Horse) horseList.get(i));
            } else {
                setMovableHorse(i);
                haveMoves = true;
            }
        }
        return haveMoves;
    }

    //check a horse for valid move with the dice
    private boolean checkHorse(Horse horse, int dice, String selectedValue, int horseNumber, String horseColor) {
        moveType[horseNumber] = horse.checkMoveType(dice, selectedValue);
        if (moveType[horseNumber].equals("false")) {return false;}
        else {
            if (isBlock(horse, horseColor, horseNumber)) {
                moveType[horseNumber] = "false";
                return false;
            } else {return true;}
        }
    }

    //check if a potential move of a horse is block by another horse
    private boolean isBlock(Horse horse, String horseColor, int horseNumber) {
        int nextPos = horse.nextPos;
        int currentPos = horse.currentPos;
        if (!moveType[horseNumber].equals("leaveNest")) {
            if (moveType[horseNumber].equals("enterHomeMin3") || moveType[horseNumber].equals("enterHomeMax2") || moveType[horseNumber].equals("upperHome")) {
                currentPos = (currentPos < horse.homePos[0]) ? horse.homePos[0] - 1 : currentPos;}
            if (checkBlockOnPath(nextPos, currentPos)) {return true;}
        }
        return (checkNextPos(nextPos, horseColor, horseNumber));
    }

    //go through each position in the game map to check for blocking
    private boolean checkBlockOnPath(int nextPos, int currentPos) {
        if (nextPos < currentPos) { //in cases when the horse has to pass the end of the moving path (index 48) and continue moving
            for (int i = currentPos + 1; i < 48; ++i) {
                if (!gameMap[i][0].equals("-1")) {
                    return true;
                }
            }
            for (int i = 0; i < nextPos; ++i) {
                if (!gameMap[i][0].equals("-1")) {
                    return true;
                }
            }
        } else {
            for (int i = currentPos + 1; i < nextPos; ++i) {
                if (!gameMap[i][0].equals("-1")) {
                    return true;
                }
            }
        }
        return false;
    }

    //check for capture, block or not block at the next position of the horse
    private boolean checkNextPos(int nextPos, String horseColor, int horseCapturingNumber) {
        if (gameMap[nextPos][0].equals(horseColor)) {
            return true;
        } else if (!gameMap[nextPos][0].equals("-1")) {
            capturedHorseInfo[horseCapturingNumber] = gameMap[nextPos];
            moveType[horseCapturingNumber] = "capture";
        }
        return false;
    }

    //remember which horse has a valid move
    private void setMovableHorse(int horseNumber) {
        horsesMovableStatus[horseNumber] = true;
    }

    //remember which horse doesn't have a valid move
    private void setUnMovableHorse(int horseNumber, Horse horse) {
        horse.blockNextMove();
        horsesMovableStatus[horseNumber] = false;
    }

    //get next move type of a horse for this turn by its index
    public String getMoveType(int horseNumber) {
        return moveType[horseNumber];
    }

    //get all move types of all 4 horses for this turn
    public String[] getMoveType() {
        return moveType;
    }

    //get movable status of all 4 horses for this turn
    public boolean[] getHorsesMovableStatus() {
        return horsesMovableStatus;
    }

    //get the color of the captured horse
    public String getCapturedHorseColor(int capturingHorseNumber) {
        return capturedHorseInfo[capturingHorseNumber][0];
    }

    //get the number of the captured horse
    public int getCapturedHorseNumber(int capturingHorseNumber) {
        return Integer.valueOf(capturedHorseInfo[capturingHorseNumber][1]);
    }

    //get the nest position of the captured horse
    public int getCapturedHorseNest(int capturingHorseNumber) {
        String capturedHorseColor = capturedHorseInfo[capturingHorseNumber][0];
        int capturedHorseNumber = Integer.valueOf(capturedHorseInfo[capturingHorseNumber][1]);
        return getHorseInfo(capturedHorseColor, capturedHorseNumber, "getNest");
    }

    //move horse to a new place by color and move type
    public void moveHorseModelByColor(String horseColor, int horseNumber, String moveType) {
        switch(horseColor) {
            case ("blue"):
                moveHorseModel(moveType, blueHorsesList.get(horseNumber));
                break;
            case ("yellow"):
                moveHorseModel(moveType, yellowHorsesList.get(horseNumber));
                break;
            case ("green"):
                moveHorseModel(moveType, greenHorsesList.get(horseNumber));
                break;
            case ("red"):
                moveHorseModel(moveType, redHorsesList.get(horseNumber));
                break;
        }
    }

    //move horse to a new place move type
    private void moveHorseModel(String moveType, Horse horse) {
        switch(moveType) {
            case ("moveHorse"):
                gameMap[horse.nextPos] = new String[]{horse.color, String.valueOf(horse.horseNumber)};
                gameMap[horse.currentPos] = emptySpotOnMap;
                horse.moveHorse("moveHorse");
                break;
            case ("toNest"):
                horse.moveHorse("toNest");
                gameMap[horse.currentPos] = new String[]{horse.color, String.valueOf(horse.horseNumber)};
                break;
        }
    }

    //get a horse's position by color and information type
    public int getHorseInfo(String horseColor, int horseNumber, String information) {
        switch(horseColor) {
            case ("blue"):
                return getHorseInfo(information, blueHorsesList.get(horseNumber));
            case ("yellow"):
                return getHorseInfo(information, yellowHorsesList.get(horseNumber));
            case ("green"):
                return getHorseInfo(information, greenHorsesList.get(horseNumber));
            case ("red"):
                return getHorseInfo(information, redHorsesList.get(horseNumber));
            default:
                return -1;
        }
    }

    //get a horse's position by function
    private int getHorseInfo (String information, Horse horse) {
        switch(information) {
            case ("getNest"):
                return horse.inNestPos;
            case ("getNext"):
                return horse.nextPos;
            case ("getCurrent"):
                return horse.currentPos;
            case ("getStartPos"):
                return horse.startPos;
            case ("getEndPos"):
                return horse.homeArrivalPos;
            case ("distantToHome"):
                return horse.countDistantToHome();
            default:
                return -1;
        }
    }

    //check if any set of 4 horses has move the the highest home positions by a given horse color
    public boolean checkCompleteGame(String horseColor, int horseNumber) {
        switch(horseColor) {
            case ("blue"):
                return checkCompleteGame(blueHorsesList.get(horseNumber));
            case ("yellow"):
                return checkCompleteGame(yellowHorsesList.get(horseNumber));
            case ("green"):
                return checkCompleteGame(greenHorsesList.get(horseNumber));
            case ("red"):
                return checkCompleteGame(redHorsesList.get(horseNumber));
        }
        return false;
    }

    //check if any set of 4 horses has move the the highest home positions
    private boolean checkCompleteGame(Horse horse) {
        if (!(gameMap[horse.homePos[2]][0] == "-1") && !(gameMap[horse.homePos[3]][0] == "-1")
                && !(gameMap[horse.homePos[4]][0] == "-1") && !(gameMap[horse.homePos[5]][0] == "-1")) {
            return true;
        }

        return false;
    }
}