//Name:Emre Ezgü
//ID:2024400144


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main {
    //required variables
    static Random random=new Random();
    static double gameSpeed=20.0;
    static int pause=50;
    static boolean isGame=false;
    static double locX=600.0;
    static double locY =250.0;
    static int numOfBullets=100;
    static double[] bulletX=new double[numOfBullets];
    static double[] bulletY=new double[numOfBullets];
    static boolean[] isBullet=new boolean[numOfBullets];
    static double bulletSpeed=25.0;
    static int numOfEnemies=6;
    static double[] enemyX=new double[6];
    static double[] enemyY=new double[6];
    static boolean[] isEnemy=new boolean[6];
    static double enemySpeedL1 =5.0;
    static double enemySpeedL2=5.0;
    static int score=0;
    static int lives=3;
    static double[] explosionX=new double[6];
    static double[] explosionY=new double[6];
    static int[] explosionTimer=new int[6];
    static boolean[] isExplosion=new boolean[6];
    static int remainingEnemy=6;
    static int numOfEnemyBullets=50;
    static boolean[] isEnemyBullet=new boolean[50];
    static double[] enemyBulletX=new double[50];
    static double[] enemyBulletY=new double[50];
    static int random_number;
    static int heart_random;
    static int numOfHearts=6;
    static boolean[] isHeart=new boolean[6];
    static double[] heartX=new double[6];
    static double[] heartY=new double[6];
    static boolean isPaused=false;
    static boolean restart=true;
    static int cooldownTimer=10;
    static boolean[] isLayer1=new boolean[6];



    static final int CANVAS_WIDTH = 1200;
    static final int CANVAS_HEIGHT = 1600;

    public static void main(String[] args) {
        //at first setting the canvas
        StdDraw.setCanvasSize(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        StdDraw.setXscale(0, CANVAS_WIDTH);
        StdDraw.setYscale(0, CANVAS_HEIGHT);
        StdDraw.setTitle("2042: Interceptor");
        StdDraw.enableDoubleBuffering();
        while (true){
            //in the menu or is it game started
            if (!isGame){
                menu();
                menuSettings();
            }
            else {
                //pause or not
                if (!isPaused) {
                    //win
                    if (score==180){
                        //victory screen
                        StdDraw.picture(CANVAS_WIDTH/2,CANVAS_HEIGHT/2,"assets/background.png",1200,1600);
                        StdDraw.picture(600,1050,"assets/victory.png",800,350);
                        StdDraw.setFont(new Font("SansSerif",Font.ITALIC,25));
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.text(600,855,"Score: "+score);
                        //move cursor
                        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
                            restart=false;
                        }
                        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
                            restart=true;
                        }
                        if (restart){
                            StdDraw.setFont(new Font("SansSerif",Font.BOLD,30));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,740,"> Restart <");
                            StdDraw.setFont(new Font("SansSerif",Font.LAYOUT_NO_START_CONTEXT,25));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,660,"End Game");
                        }
                        else {
                            StdDraw.setFont(new Font("SansSerif",Font.LAYOUT_NO_START_CONTEXT,25));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,740,"Restart");
                            StdDraw.setFont(new Font("SansSerif",Font.BOLD,30));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,660,"> End Game <");
                        }
                        //restart the game or quit
                        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
                            if (restart){
                                gameStart();
                            }
                            else {
                                StdDraw.close();
                                break;
                            }
                        }

                    }
                    //lose
                    else if (lives==0) {
                        //game over screen
                        StdDraw.picture(CANVAS_WIDTH/2,CANVAS_HEIGHT/2,"assets/background.png",1200,1600);
                        StdDraw.picture(600,1050,"assets/gameOver.png",800,350);
                        StdDraw.setFont(new Font("SansSerif",Font.ITALIC,25));
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.text(600,850,"Score: "+score);
                        //move cursor
                        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
                            restart=false;
                        }
                        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
                            restart=true;
                        }
                        if (restart){
                            StdDraw.setFont(new Font("SansSerif",Font.BOLD,30));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,740,"> Restart <");
                            StdDraw.setFont(new Font("SansSerif",Font.LAYOUT_NO_START_CONTEXT,25));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,660,"End Game");
                        }
                        else {
                            StdDraw.setFont(new Font("SansSerif",Font.LAYOUT_NO_START_CONTEXT,25));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,740,"Restart");
                            StdDraw.setFont(new Font("SansSerif",Font.BOLD,30));
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.text(600,660,"> End Game <");
                        }
                        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
                            if (restart){
                                gameStart();
                            }
                            else {
                                StdDraw.close();
                                break;
                            }
                        }

                    }
                    //playing game
                    else {
                        //pause
                        if (StdDraw.isKeyPressed(KeyEvent.VK_P)) {
                            isPaused = true;
                        }
                        //setting screen and score
                        StdDraw.picture(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, "assets/background.png", 1200, 1600);
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.setFont(new Font("SansSerif", Font.ITALIC, 15));
                        StdDraw.text(80, 1570, "Score: " + score);
                        //heart section
                        for (int i = 0; i < lives; i++) {
                            StdDraw.picture(1170 - 60 * i, 1550, "assets/heart.png", 60, 60);
                        }
                        //picture enemy and player
                        StdDraw.picture(locX, locY, "assets/interceptor.png", 120, 120);
                        enemyPicture();
                        //move player
                        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && locX > 60) {
                            locX -= gameSpeed;
                        }
                        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && locX < 1140) {
                            locX += gameSpeed;
                        }
                        if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && locY < 1540) {
                            locY += gameSpeed;
                        }
                        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && locY > 60) {
                            locY -= gameSpeed;
                        }
                        //displaying animations
                        enemyAnimation();
                        enemyFireBullet();
                        enemyBulletAnimation();
                        if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
                            allyFireBullet();
                        }
                        shotCooldown();
                        collisions();
                        explosionAnimation();
                        allyBulletAnimation();
                        heartAnimation();
                    }
                }
                //pause
                else {
                    StdDraw.picture(CANVAS_WIDTH/2.0,CANVAS_HEIGHT/2.0,"assets/background.png",1200,1600);
                    StdDraw.picture(600,1050,"assets/paused.png",800,350);
                    if (StdDraw.isKeyPressed(KeyEvent.VK_P)){
                        isPaused=false;
                    }


                }
            }
            StdDraw.show();
            StdDraw.pause(pause);
        }

    }
    public static void menu(){
        //drawing menu
        StdDraw.picture(CANVAS_WIDTH/2.0,CANVAS_HEIGHT/2.0,"assets/background.png",1200,1600);
        StdDraw.picture(600,1050,"assets/title.png",800,350);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setFont(new Font("SansSerif",Font.HANGING_BASELINE,10));
        int fps=1000/pause;
        StdDraw.text(600, 150, "Move: [←][↑][↓][→]");
        StdDraw.text(600, 125, "Shoot: [Space]");
        StdDraw.text(600, 100, "Press [ENTER] to start");
        StdDraw.text(600, 75, "FPS: A/D  Speed: Q/E");
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setFont(new Font("SansSerif",Font.BOLD,24));
        StdDraw.text(600,700,"> Start Game <");
        StdDraw.setFont(new Font("SansSerif",Font.TRUETYPE_FONT,13));
        StdDraw.text(600,635,"FPS: ∽"+fps+" | Speed: "+gameSpeed);
        StdDraw.picture(locX, locY,"assets/interceptor.png",120,120);
        allyBulletAnimation();

    }
    public static void menuSettings(){
        //settings
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)&&locX>60){
            locX-=gameSpeed;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)&&locX<1140){
            locX+=gameSpeed;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)&&locY<1540){
            locY+=gameSpeed;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)&&locY>60){
            locY-=gameSpeed;
        }


        if (StdDraw.isKeyPressed(KeyEvent.VK_Q)&&gameSpeed<=50){
            gameSpeed+=0.5;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_E)&&gameSpeed>=10){
            gameSpeed-=0.5;
        }


        if (StdDraw.isKeyPressed(KeyEvent.VK_A)&&pause>1000/70){
            pause-=1;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)&&pause<1000/12){
            pause+=1;
        }


        if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
            allyFireBullet();
        }
        shotCooldown();
        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)){
            isGame=true;
            gameStart();
        }

    }
    public static void allyFireBullet(){
        if (cooldownTimer>=10){
            for (int i=0;i<numOfBullets;i++){
                if (!isBullet[i]) {
                    isBullet[i] = true;
                    bulletX[i] = locX;
                    bulletY[i] = locY + 50;
                    break;
                }
            }
            cooldownTimer=0;
        }
    }
    public static void shotCooldown(){
        if (cooldownTimer<10){
            cooldownTimer+=1;
        }
    }
    public static void allyBulletAnimation(){
        for (int i=0;i<numOfBullets;i++){
            if (isBullet[i]){
                bulletY[i]+=bulletSpeed;
                if (bulletY[i]>1600){
                    isBullet[i]=false;
                    continue;
                }
                StdDraw.picture(bulletX[i],bulletY[i],"assets/bullet.png",20,75);
            }
        }
    }
    public static void startEnemy(){
        enemySpeedL1=5;
        enemySpeedL2=5;
        for (int i=0;i<6;i++){
            isEnemy[i]=true;
            //enemyDir[i]=1;
            if (i<3){
                enemyX[i]=200+i*300;
                enemyY[i]=1400;
                isLayer1[i]=true;
            }
            else {
                enemyX[i]=200+(i-3)*300;
                enemyY[i]=1200;
                isLayer1[i]=false;

            }
        }
    }
    public static void enemyAnimation(){
        for (int i=0;i<6;i++){
            if (isEnemy[i]){
                if (isLayer1[i]){
                    enemyX[i]+=enemySpeedL1;
                    if (enemyX[i]>1100||enemyX[i]<100){
                        enemySpeedL1*=-1;
                    }
                }
                else {
                    enemyX[i]+=enemySpeedL2;
                    if (enemyX[i]>1100||enemyX[i]<100){
                        enemySpeedL2*=-1;
                    }
                }
            }
        }
    }
    public static void enemyPicture(){
        for (int i=0;i<6;i++){
            if (isEnemy[i]){
                StdDraw.picture(enemyX[i],enemyY[i],"assets/enemyFighter.png",200,100);
            }
        }
    }
    public static void collisions(){
        //bullet-enemy collision
        for (int i=0;i<numOfBullets;i++){
            if (isBullet[i]){
                for (int a=0;a<numOfEnemies;a++){
                    if (!isBullet[i]){
                        break;
                    }
                    if (isEnemy[a]){
                        if (Math.abs(bulletX[i]-enemyX[a])<105&&Math.abs(bulletY[i]-enemyY[a])<70){
                            isBullet[i]=false;
                            isEnemy[a]=false;
                            score+=30;
                            remainingEnemy-=1;
                            heart_random=random.nextInt(0,4);
                            //heart drop
                            if (heart_random==1){
                                for (int k=0;k<6;k++){
                                    if (!isHeart[k]){
                                        isHeart[k]=true;
                                        heartX[k]=enemyX[a];
                                        heartY[k]=enemyY[a];
                                        break;
                                    }
                                }
                            }
                            //collision
                            for (int b=0;b<6;b++){
                                if (!isExplosion[b]){
                                    isExplosion[b]=true;
                                    explosionX[b]=enemyX[a];
                                    explosionY[b]=enemyY[a];
                                    explosionTimer[b]=0;
                                    break;
                                }
                            }
                        }
                    }
                    else continue;
                }
            }
            else continue;
        }
        //enemy bullet-player collision
        for (int i=0;i<numOfEnemyBullets;i++){
            if (isEnemyBullet[i]){
                if (Math.abs(locX-enemyBulletX[i])<80&&Math.abs(locY-enemyBulletY[i])<90){
                    isEnemyBullet[i] = false;
                    lives -= 1;
                }
            }
        }
        //heart-player collision
        for (int i=0;i<numOfHearts;i++){
            if (isHeart[i]){
                if (Math.abs(locX-heartX[i])<80&&Math.abs(locY-heartY[i])<80){
                    isHeart[i]=false;
                    lives+=1;
                }
            }
        }
        //enemy-player collision
        for (int i=0;i<6;i++){
            if (isEnemy[i]){
                if (Math.abs(locX-enemyX[i])<160&&Math.abs(locY-enemyY[i])<110){
                    isEnemy[i]=false;
                    lives-=1;
                    score+=30;
                    remainingEnemy-=1;
                }
            }
        }
    }
    public static void heartAnimation(){
        for (int i=0;i<6;i++){
            if (isHeart[i]){
                heartY[i]-=gameSpeed;
                StdDraw.picture(heartX[i],heartY[i],"assets/heart.png",40,40);
                if (heartY[i]<-20){
                    isHeart[i]=false;
                }
            }
        }
    }

    public static void explosionAnimation(){
        for (int i=0;i<6;i++){
            if (isExplosion[i]){
                explosionTimer[i]+=1;
                if (explosionTimer[i]<5){
                    StdDraw.picture(explosionX[i],explosionY[i],"assets/explosionSmall.png",80,80);
                }
                else if (explosionTimer[i]<15&&explosionTimer[i]>=5){
                    StdDraw.picture(explosionX[i],explosionY[i],"assets/explosionBig.png",120,120);
                }
                else {
                    isExplosion[i]=false;
                }
            }
        }
    }
    public static void enemyFireBullet(){
        for (int i=0;i<6;i++){
            if (isEnemy[i]){
                random_number=random.nextInt(0,35);
                if (random_number==5){
                    for (int a=0;a<numOfEnemyBullets;a++){
                        if (!isEnemyBullet[a]){
                            isEnemyBullet[a]=true;
                            enemyBulletX[a]=enemyX[i];
                            enemyBulletY[a]=enemyY[i]-50;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void enemyBulletAnimation(){
        for (int i=0;i<numOfEnemyBullets;i++){
            if (isEnemyBullet[i]){
                enemyBulletY[i]-=bulletSpeed;
                if (enemyBulletY[i]<50){
                    isEnemyBullet[i]=false;
                }
                StdDraw.picture(enemyBulletX[i],enemyBulletY[i],"assets/enemyBullet.png",20,75);
            }
        }
    }
    public static void gameStart(){
        locX=600.0;
        locY=250.0;
        lives=3;
        score=0;
        for (int i=0;i<50;i++){
            if (isBullet[i]){
                isBullet[i]=false;
            }
        }
        for (int i=0;i<numOfEnemyBullets;i++){
            if (isEnemyBullet[i]){
                isEnemyBullet[i]=false;
            }
        }
        for (int i=0;i<numOfHearts;i++){
            if (isHeart[i]){
                isHeart[i]=false;
            }
        }
        for (int i=0;i<6;i++){
            if (isExplosion[i]){
                isExplosion[i]=false;
            }
        }
        startEnemy();
        cooldownTimer=10;
    }
}

