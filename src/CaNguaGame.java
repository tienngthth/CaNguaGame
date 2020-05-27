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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CaNguaGame extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (new FXMLLoader(getClass().getResource("GameViews/GameView.fxml"))).load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ca Ngua Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}