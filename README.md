RMIT University Vietnam Course: INTE2512 Object-Oriented Programming
Semester: 2019C
Assessment: Final Assignment 
Student Name: Tien Nguyen, Khoi Vu, Triet Bui, Phu Nguyen
Student ID: s3694551


1. INTRODUCTION 
This is a software that creates a Horse Chess Game based on the requirement of Final Assignment for INTE2512. Our group utilise multiple knowledge from class to create the game such as MVC model, Scene Builder,...

2. FEATURES
1. Display graphics
●    Our game is able to fully display the Game Board and Horses with dividing colour (Blue, Yellow, Red, Green)
●    Game UI also includes a lower pane that displays player's names, player's score, two rolling dice, game's status and additional buttons for various functions like GameSound, Quit Game, Language Changing and Roll Dice.
●    Animation of Horses moving and dice rolling were also added and they were able to play smoothly.    
●    Multiple pane for multiple aspect of the game:
○    Start of the game: A pane for choosing amount of player and machine, inserting name and choosing colour
○    End of the game: A pane that display the Winner and the player with the highest score, along with buttons for player 
○    To Restart the game, Play Again or Quit the game.
2. Moving Horse
●    The horses on the board can move one step at a time till they reach their destination in each turn
●    They each have their own Nest Position at the start of the game, if they happen to be captured, they will return to their respective nest positions
●    Horses can only leave their nest when one of the roll dice give a 6
●    Horse can capture other horse by having the number of moves that lead them exactly to opponent’s horse
●    If horse 1 in in midst of horse 2’s move set, then horse 2 will be unable to move forward until horse 1 move. Or if they are in different colour, horse 2 can capture horse 1
●    Horses have their path set in accordance to their colour, contain of a start point and an end point (also home arrival point). They cannot go pass home arrival. If they manage to go in home arrival, the horse will then start to move up the home positions.
●    Players can choose a dice, then horses with possible move will have a pointer pointing at them as signal. 
●    In a match, maximum two horses can commit a move since the player can choose value from two dices and assign them to each horse
3. Rolling Dice
●    Our game acquires two dice that roll with the signal from a 'Roll' button. The result of the dice is then displayed with a merge option. The players can then choose between these 3 options and know which horses are possible to initiate such move. When the player successfully chooses the value and the horse, the value will then be passed to the horse to conduct the action.
4. Language
●    Players have the full option to choose between two languages: Vietnamese and English. A button is programmed to allow players to change the language at a whim.
5. GameSound
●    Our game includes multiple sounds effects for events occurring during the game match, we included sounds for:
○    Horses moving out of the Nest
○    Horses moving with each position
○    Horses capturing other horses
○    Horses moving into Home positions
○    Rolling dice sound effect
6. Play Again, New Game or Quit
●    With this game, we give the players three options after match is over:
○    Play Again: This will keep the player information such as name and score from the previous match onto the new math.
○    New Game: This brings players back to the starting pane for starting with new player sets
○    Quit: Quit the platform
○    After the match end, players will have two options to keep playing or exit the game. If the player chooses to keep playing, then, they will have the option to choose between Play Again and New Game.

8. Machine playing
●    In addition to human being the controller of the horses and dices, we implemented a machine to the player in our stead.
●    We are able to have 1 to even 4 machine players joining a match. We can even observe machines play by themselves.
9. Updating the score of the game    
●    In each move, our program always checking for any scenarios that would end up affecting the score of the players:
○    Capture: If a piece happens to capture another piece, the system will then check for which colours do the capturing and the captured pieces belong to. Then, we will access the respective players and change their score. +2 for the 
○    Home: If a horse is moving up a position in their home positions, the player’s score will increment by 1.
○    Arrival to Home: If a horse reaches the home arrival and is able to move into the position inside the home positions, their score will equivalent to that of the respective location.
10. Tracking of players’ name and score
●    From the starting Pane where players can choose their names and colour, our system will be able to track their name, colour, and score throughout the whole match. By choosing the colour initially, the player will have highlights and horses of the same colour assigned to them. The colour is coded to uniquely assigned to one player; they will represent the player’s progress in the match. When the match end, their score will be attained and compared to find the player with the highest score.
11. Quit Game mid-match
●    Per the requirement of this project, players will be able to quit the game during the match. There is a pane of notification to ensure the player is serious about this choice. If the player still decides to quit in the notification, the platform will exit.
12. Updating status of the game
●    The events in the game are recorded by text next to the dice roll so that players can easily follow the game status. In this aspect, we will cover the following events:
○    The turn belongs to which player
○    The dice roll by players and which move did they choose.
○    Which horse of which player leave their nest
○    Which horse of which player   reaches home positions
○    Horse of which player capture horse of which player
13. Application Flow
a.    Starting Flow
●    The players will be able to adjust how many human and machine players there is
●    They can also choose the initial language
●    After that, they will have the option to set up their name and choose their colour
●    Their name is checked to make sure that it is valid
●    The colour for the players can’t be duplicated if one player chooses a colour, other players can’t choose that one anymore.
b.    Game Flow
●    Set up Order of play
○    Each player will roll one dice and the player with the highest dice first will be the one to move first. If a player gains a six, that player will automatically become the first player since six is the highest value
○    The order is counter-clockwise from the first player
●    Main Game
○    Each player will be able to roll dice and receive values from the dice. 
○    The horse can only leave their nest if the player manages to roll a six (that is not a result of merge option)
○    Then, the player can choose which horse will be moved out of the nest first, there are 4 options for the player to choose from.
○    They will have option to see which pieces can move based on the chosen move. There will be pieces that is currently in the nest or blocked by other horses which lead them to be unavailable in some cases.
○    After choosing both the horse and the move, the chosen horse will proceed based on the chosen move (this process is also animated)
○    There are special scenarios where horses can capture, be captured (go back to their nest), go to home position, going up the home positions.
○    In cases where the player can’t use any dice, the game will move to the next player automatically, 
○    A turn is only finished after a move is done
○    The control is then set to the next player
●    Endgame Condition
○    The game will continue until a player manages to get all of their pieces to the 3th, 4th, 5th, 6th of the home position 
c.    End Flow
●    Player will have option of Quit Game or Play Again

3. MOVING HORSE’S ALGORITHM PSEUDOCODE
{
In GameController
Function checkPlayer(){
If the the currentTurn belongs to “human” player{
Enable the horses of the currentTurn player
Call function displayPossibleDices()
}else{
Call function MachinePlayerStartTurn();
}
}
Function displayPossibleDices ( checkDice){
Get totalDiceValue, firstDiceValue and secondDiceValue from GameModel
Call function displayPossibleThreeDices to check for possible moves for all value
}
Function displayPossibleThreeDices(checkDice, dice1Value, dice2Value, totalDice){
Set boolean haveMove = false
If dice 1 have moves 
Set True to haveMove
If dice 2 have moves
Set True to haveMove
If total dice  have moves
Set True to haveMove
If haveMove is false
Finish the turn
}
Function firstDiceSelected(Action Event e){
Check the moveType from model.checkADice with argument “one”
Display the possible moves
Select dice 1 

}
Function secondDiceSelected(Action Event e){
Check the moveType from model.checkADice with argument “two”
Display the possible moves
Select dice 2
}
Function totalDiceSelected (Action Event e){
Check the moveType from model.checkADice with argument “total”
Display the possible moves
Select the total dice
}

Function machinePlayerStartTurn(){
if(
Horse can’t go into home 3 -4-5-6
Horse can’t capturing other horses 
Horse can’t go to homeArrival
Horse can’t go into home position 1-2
Horse is out of starPosition
Horse can’t leave nest
Horse can’t move regularly
){
End the turn of the current Machine Player
}else if (The game is still continue){
Call function checkSecondMove()
}
}
Function checkSecondMove(){
If the total dice value is not select{
Call function moveHorseFinalTime
}else{
End the turn of the current Machine Player
}
}
Function moveHorseFinalTime(){
Reset number of moves
Get the moveType
if(
Horse can’t go into home 3 -4-5-6
Horse can’t capturing other horses 
Horse can’t go to homeArrival
Horse can’t go into home position 1-2
Horse is out of starPosition
Horse can’t leave nest
Horse can’t move regularly
){
Call Function findFathestMoveHorse
If there is a horse horse that is closest to the homeArrival and move regularly{
Move the horse
}
}
If the turn is still belong to the player
Finish the turn of the current machine player
}
Function findFarthestMoveHorse(moveType, requiredMoveType){
Set int farthestMoveHorse = -1;
Loop 4 time{
If any horse’s moveType == requiredMoveType{
If farthestMoveHorse == -1{
Set the horseNumber to farthestMoveHorse
}else if the current horse is closer to the homeArrival than the farthestMoveHorse’s{
Set the horseNumber to farthestMoveHorse
}
}
}
Return farthestMoveHorse
}
Function checkEnterHome(enterType) {
If second dice value > first dice value{
Select second dice
If there’s no moveType possile for second Dice{
Select the first dice
Return value from checkMove();
}else{
}
}else{
Return value from checkValidMove2Dices

}
}
Function checkLeaveNest(){
If two dice don’t give value 6{
Return false
}else{
Call checkValidMove2Dices() for “leaveNest”;
}
}
Function checkValidMove2Dices(requiredMoveType){
Select first Dice
If there’s no moveType possible for first Dice{
SelectSecondDice
Return value from function checkMove()
}
Return true
}
Function checkValidMove3Dices(requiredMoveType){
Select first Dice
If there’s no moveType possible for first Dice{
Select second Dice
If there’s no moveType possible for second Dice{
Select total dice calue
Return value from function checkMove()
}
Return true
}
Function checkMove(allMoveType, requiredMoveType){
Loop 4 time{
If there’s possible moveType == requiredMoveType{
Move the horse based on moveHorse()
Return true
}
}
}
Function moveHorse(horseColor, horseNumber, playerNumber, horse, pointing){
If the currentTurn is equal to horseColor{
Get horse’s moveType
If moveType == “regular” or “homeArrival” or   “moveOutStartPos” or “leaveNest”{
Call function regularMove()
}else if moveType == “capture”{
Call function captureHorse()
}else if moveType == “enterHomeMax2” or “enterHomeMin3”{
Call function enterHome()
}else if moveType == “upperHome”{
Call function upperHome()
}
}
}
Function moveHorsePreparation()  {
Set number of horse’s move to 1 
Set false to the pointing of the horse
Set horses of the currentTurn to able to move and Disable other horses from moving 
Disable roll and dice buttons from pressing
}
Function regularMove( horse, pointing, newPosition, currentPos, horseColor, horseNumber, moveType){
Call function moveHorsePreparation()
Play animation horse moving to newPosition
If moveType is not != ‘leaveNest’ {
Update number of moves
Update the movement onto the Game Status
}else{
Update the leaving nest event onto the Game Status
}
Pass “moveHorse” into moveType
Call function moveHorseByColor() from GameModel
Finish the turn of the player. 
}
Function enterHome(horse, pointing, newPosition, currentPos, horseColor, horseNumber, moveType){
Call function moveHorsePreparation()
Play animation of horse going into a home position from the home arrival
Pass “moveHorse” into moveType
Call function moveHorseByColor() from GameModel. 
Check for condition of game completion
}
Function upperHome(horse, pointing, newPosition, currentPos, horseColor, horseNumber, moveType){
Call function moveHorsePreparation()
Play animation of horse going up the home positions
Pass “moveHorse” into moveType
Call function moveHorseByColor() from GameModel
Check for condition of game completion
}
Function captureHorse(horse1, pointing1, horseNumber, currentPosOfCapturingHorse, playerNumber, horseColor) {
Call function moveHorsePreparation() 
Pass “moveHorse” into moveType
Call function moveHorseByColor() from GameModel to move capturing horse
Get color of capturedHorse
If captureHorseColor == “blue”
Call function captureHorseOperation for blue horse
If captureHorseColor == “yellow”
Call function captureHorseOperation for yellow horse
If captureHorseColor == “green”
Call function captureHorseOperation for green horse
If captureHorseColor == “red”
Call function captureHorseOperation for red horse
}
Function captureHorseOperation (horse1, horsePointing1, horseNumber, horseCaptured1, pointing1, horseCaptured2, pointing2, horseCaptured3, pointing3, horseCaptured4, pointing4, capturedHorseColor, capturingHorseCurrentPos, playerNumber){
Get capturedPosition from the next move of the capturing horse from GameModel
Get the nestPosition of the captured horse from GameModel
Get the horseNumber of the captured horse
Get color of capturedHorse
If capturedHorseNumber == 0
Play captured horse animation with horseCaptured1
If capturedHorseNumber == 1
Play captured horse animation with horseCaptured2
If capturedHorseNumber == 2
Play captured horse animation with horseCaptured3
If capturedHorseNumber == 3
Play captured horse animation with horseCaptured4
Call function moveHorseByColor() with capturedHorseColor and capturedHorseNumber  from GameModel with argument MoveType = “toNest” 

}
}

{
In gameMap
Function moveHorseModelByColor(horseColor, horseNumber, moveType){
Case (moveType){
“blue”
Call function moveHorseModel() with blueHorseList(horseNumber)
“yellow”
Call function moveHorseModel() with yellowHorseList(horseNumber)
“red”
Call function moveHorseModel() with redHorseList(horseNumber)
“green”
Call function moveHorseModel() with greenHorseList(horseNumber)
}
}

Function moveHorseModel(moveType, horse){
Case moveType == “moveHorse”
Pass the color and the horseNumber into the next position in gameMap 
Set the current position in the gameMap to be empty
Set the currentPos of the horse to be nextPos of the horse
Case moveType == “toNest”
Pass the color and the horseNumber into its own nest position in gameMap 
Set the currentPos of the horse to be nestPos of the horse
}
Function checkADice(playerColor, dice, selectedValue){
If playerColor== “blue”{
Return boolean value checkMovesOfHorse for blue horse
}else If playerColor== “yellow”{
Return boolean  value from  checkMovesOfHorse for yellow horse
}else If playerColor== “green”{
Return boolean  value from  checkMovesOfHorse for green horse
}else If playerColor== “red”{
Call function checkMovesOfHorse for red horse
}else{return false}
}
Function checkMovesOfHorse (){
Set boolean value haveMove = false
Loop that run 4 times{
If function checkHorse() returns false{ 
Set the horse to be unmoveable
}else{
Set the horse to be moveable
Set haveMove to be true
}
}
Return value of haveMove
}
Function checkHorse(horse, dice, selectedValue, horseNumber, horseColor){
Get moveType from function checkMoveType of the horse based on the dice value and the chosen dice (“one”, “two” or “total”)
If moveType == “false”{
Return false
}else{
if horse is blocked {
moveType = "false";
Return false
}else{return true}
}
}



3. INSTALLATION
After opening the project file, choose the CaNguaGame.java file in folder "src" and click Run. Make sure the VM Option in Run Configuration is in accordance to the following 
“--module-path /Users/s3694551/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media”
4. KNOWN BUGS
No Networking Game at the moment

.5. ACKNOWLEDGEMENT
Board was taken from ”https://shopee.vn/p-i.35663200.1769005829?deep_and_deferred=1&pid=partnerize_int&af_click_lookback=7d&is_retargeting=true&af_reengagement_window=7d&af_installpostback=false&af_sub3=4687861501623739831&af_sub4=XRa36szqZmw92oQJcjAXDmhPcCN1e0G2n7WgUWv1dxIxkbPN&af_sub2=SHOPEE&clickid=1011l7zTwX9I&af_siteid=1101l66717&utm_source=1101l66717&utm_medium=affiliates&utm_term=4687861501623739831&utm_content=XRa36szqZmw92oQJcjAXDmhPcCN1e0G2n7WgUWv1dxIxkbPN”

Next Icon was taken from “https://www.hiclipart.com/free-transparent-background-png-clipart-mtqjr”

Horse Icon was taken from “https://www.iconfinder.com/icons/2376340/chess_game_game_piece_knight_icon”

GameSound Icon was taken from “https://www.shutterstock.com/image-vector/sound-icon-vector-trendy-flat-style-744676912?id=744676912&irgwc=1&utm_medium=Affiliate&utm_campaign=Freepik+Company%2C+S.L.&utm_source=39422&utm_term=5e1daf7fcb8c5.5e1daf7fcb8c6”

Music Off Icon was taken from “https://thenounproject.com/term/music-off/496513/”

Notification Icon was taken from “https://www.sap-business-one-tips.com/pre-requisite-alert-management/”

Exit Icon was taken from https://www.pngrepo.com/svg/65414/door-exit

Globe Icon was taken from “https://www.shutterstock.com/es/search/internet%20icons%20blue”

Pointing Icon was taken from “https://www.iconfinder.com/icons/1529746/direction_finger_hand_pointing_icon?fbclid=IwAR3kZJVLIxl8OZcNn29gJfDkWCidSb5c32iJ4VImKfrJ3bZfITFyUo1v8iU”

Dice was taken from “https://www.iconsdb.com/white-icons/dice-icon.html”

Dice Individua; faces was taken from https://icon2.cleanpng.com/20180215/kue/kisspng-dominoes-dice-free-content-clip-art-dice-images-free-5a85bd3d0ca920.9263202615187141730519.jpg

