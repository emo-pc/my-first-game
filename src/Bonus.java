import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Bonus {
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
    static int score=0;
    static int lives=3;
    static double[] explosionX=new double[50];
    static double[] explosionY=new double[50];
    static int[] explosionTimer=new int[50];
    static boolean[] isExplosion=new boolean[50];
    static int remainingEnemy=6;
    static int random_number;
    static int heart_random;
    static int numOfHearts=6;
    static boolean[] isHeart=new boolean[6];
    static double[] heartX=new double[6];
    static double[] heartY=new double[6];
    static boolean isPaused=false;
    static boolean restart=true;
    static int userCooldown=10;
    static int cooldownTimer=userCooldown;
    static double[] enemyX=new double[6];
    static double[] enemyY=new double[6];
    static boolean[] isEnemy=new boolean[6];
    static String[] enemyType=new String[6];
    static int numOfEnemyBullets=50;
    static boolean[] isEnemyBullet=new boolean[50];
    static double[] enemyBulletX=new double[50];
    static double[] enemyBulletY=new double[50];
    static String[] bulletType=new String[50];
    static int numOfEnemies=6;
    static int duckSpeed=15;
    static int duckRandom=10;
    static int duckBulletRandom;
    static int shieldSpeed=15;
    static boolean target=false;
    static int shieldRandom;
    static int shieldCooldown=-1;
    static int shieldYspeed=10;
    static int bananiniSpeed=20;
    static double[] bananiniRelease=new double[50];
    static double turtleAngle;
    static double turtleAngularSpeed;
    static double turtleLinearSpeed;
    static double turtleCenterX;
    static double turtleCenterY;
    static double[] turretleReleaseX=new double[50];
    static double[] turretleReleaseY=new double[50];
    static double[] bulletAngleS=new double[50];
    static double escapeX=0;
    static double escapeY=0;
    static double beetleAngle=0;
    static double beetleSpdX=1;
    static double beetleAngularSpd=0.05;
    static double speedX;
    static double[] beetleBulVel=new double[50];
    static double goblinAngle=0;
    static double[] goblinReleaseX=new double[50];
    static double[] goblinReleaseY=new double[50];
    static boolean[] goblinBulDir=new boolean[50];






    static final int CANVAS_WIDTH = 1200;
    static final int CANVAS_HEIGHT = 1600;

    public static void main(String[] args) {
        //setting the canvas
        StdDraw.setCanvasSize(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        StdDraw.setXscale(0, CANVAS_WIDTH);
        StdDraw.setYscale(0, CANVAS_HEIGHT);
        StdDraw.setTitle("2042: Interceptor");
        StdDraw.enableDoubleBuffering();
        while (true){
            //menu or play
            if (!isGame){
                menu();
                menuSettings();
            }
            else {
                if (!isPaused) {
                    //win
                    if (remainingEnemy==0){
                        //displaying victory
                        StdDraw.picture(CANVAS_WIDTH/2,CANVAS_HEIGHT/2,"assets/background.png",1200,1600);
                        StdDraw.picture(600,1050,"assets/victory.png",800,350);
                        StdDraw.setFont(new Font("SansSerif",Font.ITALIC,25));
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.text(600,855,"Score: "+score);
                        //moving the cursor
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
                        //restart or quit
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
                        //displaying game over
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
                        //restart or quit
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
                    //gameplay
                    else {
                        if (StdDraw.isKeyPressed(KeyEvent.VK_P)) {
                            isPaused = true;
                        }
                        //setting score and background
                        StdDraw.picture(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, "assets/background.png", 1200, 1600);
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.setFont(new Font("SansSerif", Font.ITALIC, 15));
                        StdDraw.text(80, 1570, "Score: " + score);
                        //heart section
                        for (int i = 0; i < lives; i++) {
                            StdDraw.picture(1170 - 60 * i, 1550, "assets/heart.png", 60, 60);
                        }
                        StdDraw.picture(locX, locY, "assets/interceptor.png", 120, 120);
                        //player movement
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

    public static void startEnemy(){
        for (int i=0;i<numOfEnemies;i++){
            isEnemy[i]=true;
        }
        enemyType[0]="Duck";
        enemyX[0]=95;
        enemyY[0]=random.nextInt(95,950);
        enemyType[1]="Shield";
        enemyX[1]=600;
        enemyY[1]=1400;
        enemyType[2]="Bananini";
        enemyX[2]=150;
        enemyY[2]=1500;
        enemyType[3]="Turretle";
        enemyX[3]=1100;
        enemyY[3]=1500;
        enemyType[4]="BeetleJuice";
        enemyX[4]=random.nextInt(150,1050);
        enemyY[4]=random.nextInt(1200,1400);
        enemyType[5]="Goblin";
        enemyX[5]=600;
        enemyY[5]=1300;
    }
    public static void enemyAnimation(){
        for (int i=0;i<numOfEnemies;i++){
            if (isEnemy[i]){
                //villain 1 random movement
                if (enemyType[i].equals("Duck")){
                    duckRandom=random.nextInt(0,101);
                    int duckRandom2=random.nextInt(0,101);
                    if (duckRandom2<50){
                        enemyX[i]+=duckSpeed;
                    }
                    if (enemyX[i]>190){
                        enemyX[i]-=30;
                    }
                    if (enemyX[i]<75){
                        enemyX[i]+=30;
                    }
                    if (enemyY[i]>600){
                        if (duckRandom<44) {
                            enemyY[i]+=duckSpeed;
                        }
                        else enemyY[i]-=duckSpeed;
                    }
                    else {
                        if (duckRandom<56){
                            enemyY[i]+=duckSpeed;
                        }
                        else enemyY[i]-=duckSpeed;
                    }
                    if (enemyY[i]>950||enemyY[i]<45){
                        if (enemyY[i]>950){
                            enemyY[i]-=30;
                        }
                        else enemyY[i]+=30;
                    }
                    StdDraw.picture(enemyX[i],enemyY[i],"assets/snoopDuck.png",170,200);
                }
                //villain 2 zigzag movement
                else if (enemyType[i].equals("Shield")) {
                    if (!target){
                        enemyX[i]+=shieldSpeed;
                        if (enemyX[i]>1120||enemyX[i]<80){
                            shieldSpeed*=-1;
                        }
                        enemyY[i]-=shieldYspeed;
                        if (enemyY[i]<1300||enemyY[i]>1400){
                            shieldYspeed*=-1;
                        }

                    }
                    StdDraw.picture(enemyX[i],enemyY[i],"assets/shield.png",250,400);

                }
                //villain 3 parabola movement
                else if (enemyType[i].equals("Bananini")){
                    enemyX[i]+=bananiniSpeed;
                    enemyY[i]=Math.pow(enemyX[i]-900,2)/750+750;
                    if (enemyX[i]>1050||enemyX[i]<150){
                        bananiniSpeed*=-1;
                    }
                    StdDraw.picture(enemyX[i],enemyY[i],"assets/bananini.png",175,150);
                }
                //villain 4 circular movement
                else if (enemyType[i].equals("Turretle")){
                    turtleAngle+=turtleAngularSpeed;
                    turtleCenterX+=turtleLinearSpeed;
                    enemyX[i]=turtleCenterX+100*Math.cos(turtleAngle);
                    enemyY[i]=turtleCenterY+100*Math.sin(turtleAngle);
                    StdDraw.picture(enemyX[i],enemyY[i],"assets/turretle.png",200,200);
                    if (turtleCenterX>1090||turtleCenterX<110){
                        turtleLinearSpeed*=-1;
                        turtleAngularSpeed*=-1;
                    }
                }
                //villain 5 circular+bullet dodging movement
                else if (enemyType[i].equals("BeetleJuice")){
                    beetleAngle+=beetleAngularSpd;
                    enemyX[i]+=beetleSpdX;
                    //bullet dodge
                    for (int a=0;a<numOfBullets;a++){
                        double horizontalDist=enemyX[i]-bulletX[a];
                        double verticalDist=enemyY[i]-bulletY[a];
                        double totalDistance=Math.sqrt(horizontalDist*horizontalDist+verticalDist*verticalDist);
                        if (totalDistance<200){
                            double force=(200-totalDistance)/200;
                            escapeX+=(horizontalDist/totalDistance)*force*11;
                            escapeY+=(verticalDist/totalDistance)*force*8;
                        }
                    }
                    escapeX*=0.92;
                    escapeY*=0.92;
                    enemyX[i]+=Math.cos(beetleAngle)*8+escapeX;
                    enemyY[i]+=Math.sin(beetleAngle)*8+escapeY;
                    if (enemyX[i]<100||enemyX[i]>1100){
                        beetleAngle=Math.PI-beetleAngle;
                        beetleSpdX*=-1;
                        beetleAngularSpd*=-1;
                        if (enemyX[i]>1100){
                            enemyX[i]-=30;
                        }
                        if (enemyX[i]<100){
                            enemyX[i]+=30;
                        }
                    }
                    if (enemyY[i]<900||enemyY[i]>1550){
                        beetleAngle*=-1;
                        if (enemyY[i]>1550) {
                            enemyY[i] -= 30;
                        }
                        if (enemyY[i]<900){
                            enemyY[i]+=50;
                        }
                    }
                    StdDraw.picture(enemyX[i],enemyY[i],"assets/beetleShip.png",200,200);
                }
                //villain 6 infinity symbol movement
                else if (enemyType[i].equals("Goblin")){
                    goblinAngle+=0.03;
                    enemyX[i]=600+450*Math.sin(goblinAngle);
                    enemyY[i]=1300+150*Math.sin(2*goblinAngle);
                    StdDraw.picture(enemyX[i],enemyY[i],"assets/greenGoblin.png",180,180);
                }
            }
        }
    }
    public static void enemyFireBullet(){
        for (int i=0;i<numOfEnemies;i++){
            if (isEnemy[i]){
                //villain 1 random bullet
                if (enemyType[i].equals("Duck")){
                    duckBulletRandom=random.nextInt(0,1001);
                    if (duckBulletRandom<13){
                        for (int a=0;a<numOfEnemyBullets;a++){
                            if (!isEnemyBullet[a]){
                                isEnemyBullet[a]=true;
                                bulletType[a]="duck";
                                enemyBulletX[a]=110;
                                enemyBulletY[a]=enemyY[i]+50;
                                break;
                            }
                        }
                    }
                }
                //villain 2 subsequently 4 bullet
                else if (enemyType[i].equals("Shield")){
                    if (shieldCooldown==-1){
                        shieldRandom=random.nextInt(0,1001);
                        if (shieldRandom<11) {
                            target = true;
                            shieldCooldown+=1;
                        }
                    }
                    else {
                            if (shieldCooldown%5==0){
                                for (int k=0;k<numOfEnemyBullets;k++){
                                    if (!isEnemyBullet[k]){
                                        bulletType[k]="shield";
                                        isEnemyBullet[k]=true;
                                        enemyBulletX[k]=enemyX[1];
                                        enemyBulletY[k]=enemyY[1]-100;
                                        break;
                                    }
                                }
                            }
                            shieldCooldown+=1;
                            if (shieldCooldown>15){
                                shieldCooldown=-1;
                                target=false;
                            }

                    }

                }
                //villain 3 sinusoidal bullet
                else if (enemyType[i].equals("Bananini")){
                    int bananaRandom=random.nextInt(0,1001);
                    if (bananaRandom<13) {
                        for (int k = 0; k < numOfEnemyBullets; k++) {
                            if (!isEnemyBullet[k]) {
                                bulletType[k] = "bananini";
                                isEnemyBullet[k] = true;
                                enemyBulletX[k] = enemyX[i];
                                enemyBulletY[k] = enemyY[i] - 30;
                                bananiniRelease[k]=enemyX[i];
                                break;
                            }
                        }
                    }
                }
                //villain 4 circular bullet
                else if (enemyType[i].equals("Turretle")){
                    int turtleRandom=random.nextInt(0,1001);
                    if (turtleRandom<8){
                        for (int k=0;k<numOfEnemyBullets;k++){
                            if (!isEnemyBullet[k]){
                                bulletType[k]="turretle";
                                isEnemyBullet[k]=true;
                                enemyBulletX[k]=enemyX[i];
                                enemyBulletY[k]=enemyY[i]-90;
                                turretleReleaseX[k]=enemyX[i];
                                turretleReleaseY[k]=enemyY[i]-80;
                                break;
                            }
                        }
                    }
                }
                //villain 5 player approaching bullet
                else if (enemyType[i].equals("BeetleJuice")){
                    int beetleRandom=random.nextInt(0,1001);
                    if (beetleRandom>996){
                        for (int k=0;k<numOfEnemyBullets;k++){
                            if (!isEnemyBullet[k]){
                                bulletType[k]="beetlejuice";
                                isEnemyBullet[k]=true;
                                enemyBulletX[k]=enemyX[i];
                                enemyBulletY[k]=enemyY[i]-90;
                                beetleBulVel[k]=3;
                                break;
                            }
                        }
                    }
                }
                //villain 6 y=x^3 bullet
                else if (enemyType[i].equals("Goblin")){
                    int goblinRandom=random.nextInt(0,1001);
                    if (goblinRandom<7){
                        for (int k=0;k<numOfEnemyBullets;k++){
                            if (!isEnemyBullet[k]){
                                isEnemyBullet[k]=true;
                                bulletType[k]="goblin";
                                enemyBulletX[k]=enemyX[i];
                                enemyBulletY[k]=enemyY[i]-50;
                                goblinReleaseX[k]=enemyX[i];
                                goblinReleaseY[k]=enemyY[i];
                                if (enemyX[i]>=600){
                                    goblinBulDir[k]=true;
                                }
                                else goblinBulDir[k]=false;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void enemyBulletAnimation(){
        for (int i=0;i<numOfEnemyBullets;i++){
            if (isEnemyBullet[i]){
                //random bullet
                if (bulletType[i].equals("duck")){
                    enemyBulletX[i]+=bulletSpeed;
                    int randomY=random.nextInt(0,11);
                    if (randomY<5){
                        enemyBulletY[i]+=10;
                    }
                    else enemyBulletY[i]-=10;
                    if (enemyBulletX[i]>1250){
                        isEnemyBullet[i]=false;
                    }
                    StdDraw.picture(enemyBulletX[i],enemyBulletY[i],"assets/duckBullet.png",300,135);
                }
                //subsequently 4 bullet
                else if (bulletType[i].equals("shield")){
                    enemyBulletY[i]-=bulletSpeed;
                    if (enemyBulletY[i]<-50){
                        isEnemyBullet[i]=false;
                    }
                    StdDraw.picture(enemyBulletX[i],enemyBulletY[i],"assets/shieldBullet.png",20,75);
                }
                //sinusoidal bullet
                else if (bulletType[i].equals("bananini")){
                    enemyBulletY[i] -= bulletSpeed;
                    enemyBulletX[i] = bananiniRelease[i]+100*Math.sin(enemyBulletY[i]);
                    if (enemyBulletY[i]<-50){
                        isEnemyBullet[i]=false;
                    }
                    StdDraw.picture(enemyBulletX[i], enemyBulletY[i], "assets/bananaBullet.png", 160, 160);
                }
                //circular bullet
                else if (bulletType[i].equals("turretle")){
                    bulletAngleS[i]+=0.25;
                    turretleReleaseY[i]-=15;
                    enemyBulletX[i]=turretleReleaseX[i]+80*Math.cos(bulletAngleS[i]);
                    enemyBulletY[i]=turretleReleaseY[i]+80*Math.sin(bulletAngleS[i]);
                    StdDraw.picture(enemyBulletX[i],enemyBulletY[i],"assets/turtleBullet.png",100,100);
                    if (enemyBulletY[i]<-80){
                        isEnemyBullet[i]=false;
                    }
                }
                //approaching bullet
                else if (bulletType[i].equals("beetlejuice")){
                    beetleBulVel[i]+=1.0;
                    if (locX>enemyBulletX[i]){
                        speedX=11;
                    }
                    else speedX=-11;
                    enemyBulletX[i]+=speedX;
                    enemyBulletY[i]-=beetleBulVel[i];
                    StdDraw.picture(enemyBulletX[i],enemyBulletY[i],"assets/beetleBullet.png",80,140);
                    if (enemyBulletY[i]<-30){
                        isEnemyBullet[i]=false;
                    }
                }
                //y=x^3 bullet
                else if (bulletType[i].equals("goblin")){
                    if (goblinBulDir[i]) {
                        enemyBulletX[i]-=10;
                        enemyBulletY[i]=goblinReleaseY[i]-0.00002*(Math.pow(-enemyBulletX[i]+goblinReleaseX[i]-300,3)+Math.pow(300,3));
                    }
                    else {
                        enemyBulletX[i]+=10;
                        enemyBulletY[i]=goblinReleaseY[i]-0.00002*(Math.pow(enemyBulletX[i]-goblinReleaseX[i]-300,3)+Math.pow(300,3));
                    }
                    StdDraw.picture(enemyBulletX[i],enemyBulletY[i],"goblinBullet.png",80,140);
                    if (enemyBulletY[i]<-30||enemyBulletX[i]>1230||enemyBulletX[i]<-30){
                        isEnemyBullet[i]=false;
                    }
                }
            }
        }
    }

    public static void menu(){
        StdDraw.picture(CANVAS_WIDTH/2.0,CANVAS_HEIGHT/2.0,"assets/background.png",1200,1600);
        StdDraw.picture(600,1050,"assets/title.png",800,350);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setFont(new Font("SansSerif",Font.HANGING_BASELINE,10));
        int fps=1000/pause;
        StdDraw.text(600, 150, "Move: [←][↑][↓][→]");
        StdDraw.text(600, 125, "Shoot: [Space]");
        StdDraw.text(600, 100, "Press [ENTER] to start");
        StdDraw.text(600, 75, "FPS: A/D  Speed: Q/E");
        StdDraw.text(600,50,"Bullet Speed: [1]/[2]  Shot Cooldown: [3]/[4]");
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setFont(new Font("SansSerif",Font.BOLD,24));
        StdDraw.text(600,700,"> Start Game <");
        StdDraw.setFont(new Font("SansSerif",Font.TRUETYPE_FONT,13));
        StdDraw.text(600,635,"FPS: ∽"+fps+" | Speed: "+gameSpeed);
        StdDraw.text(600,580,"Bullet Speed: "+bulletSpeed+" | Shot Cooldown: "+userCooldown+"ms");
        StdDraw.picture(locX, locY,"assets/interceptor.png",120,120);
        allyBulletAnimation();

    }
    public static void menuSettings(){
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
        else if (StdDraw.isKeyPressed(KeyEvent.VK_E)&&gameSpeed>=10){
            gameSpeed-=0.5;
        }


        if (StdDraw.isKeyPressed(KeyEvent.VK_A)&&pause>1000/70){
            pause-=1;
        }
        else if (StdDraw.isKeyPressed(KeyEvent.VK_D)&&pause<1000/12){
            pause+=1;
        }


        if (StdDraw.isKeyPressed(KeyEvent.VK_1)&&bulletSpeed<70){
            bulletSpeed+=1;
        }
        else if (StdDraw.isKeyPressed(KeyEvent.VK_2)&&bulletSpeed>20){
            bulletSpeed-=1;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_3)&&userCooldown<20){
            userCooldown+=1;
        }
        else if (StdDraw.isKeyPressed(KeyEvent.VK_4)&&userCooldown>4){
            userCooldown-=1;
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
        if (cooldownTimer>=userCooldown){
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
        if (cooldownTimer<userCooldown){
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
    public static void collisions(){
        //bullet-enemy collision
        for (int i=0;i<numOfBullets;i++){
            if (isBullet[i]){
                for (int a=0;a<numOfEnemies;a++){
                    if (!isBullet[i]){
                        break;
                    }
                    if (isEnemy[a]){
                        if (enemyType[a].equals("Duck")) {
                            if (remainingEnemy==1) {
                                if (Math.abs(bulletX[i] - enemyX[a]) < 95 && Math.abs(bulletY[i] - enemyY[a]) < 125){
                                    isBullet[i] = false;
                                    isEnemy[a] = false;
                                    score += 30;
                                    remainingEnemy -= 1;
                                    heart_random = random.nextInt(0, 4);
                                    //heart drop
                                    if (heart_random == 1) {
                                        for (int k = 0; k < 6; k++) {
                                            if (!isHeart[k]){
                                                isHeart[k] = true;
                                                heartX[k] = enemyX[a];
                                                heartY[k] = enemyY[a];
                                                break;
                                            }
                                        }
                                    }
                                    //explosion
                                    for (int b = 0; b < 50; b++) {
                                        if (!isExplosion[b]) {
                                            isExplosion[b] = true;
                                            explosionX[b] = enemyX[a];
                                            explosionY[b] = enemyY[a];
                                            explosionTimer[b] = 0;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        else if (enemyType[a].equals("Shield")){
                            if (Math.abs(bulletX[i] - enemyX[a]) < 60 && Math.abs(bulletY[i] - enemyY[a]) < 200) {
                                isBullet[i] = false;
                                isEnemy[a] = false;
                                score += 30;
                                remainingEnemy -= 1;
                                heart_random = random.nextInt(0, 4);
                                //heart drop
                                if (heart_random == 1) {
                                    for (int k = 0; k < 6; k++) {
                                        if (!isHeart[k]) {
                                            isHeart[k] = true;
                                            heartX[k] = enemyX[a];
                                            heartY[k] = enemyY[a];
                                            break;
                                        }
                                    }
                                }
                                //explosion
                                for (int b = 0; b < 50; b++) {
                                    if (!isExplosion[b]) {
                                        isExplosion[b] = true;
                                        explosionX[b] = enemyX[a];
                                        explosionY[b] = enemyY[a];
                                        explosionTimer[b] = 0;
                                        break;
                                    }
                                }
                            }
                        }
                        else if (enemyType[a].equals("Bananini")){
                            if (Math.abs(enemyX[a]-bulletX[i])<100&&Math.abs(enemyY[a]-bulletY[i])<75){
                                isBullet[i]=false;
                                isEnemy[a]=false;
                                score+=30;
                                remainingEnemy-=1;
                                //explosion
                                for (int b = 0; b < 50; b++) {
                                    if (!isExplosion[b]) {
                                        isExplosion[b] = true;
                                        explosionX[b] = enemyX[a];
                                        explosionY[b] = enemyY[a];
                                        explosionTimer[b] = 0;
                                        break;
                                    }
                                }

                            }
                        }
                        else if (enemyType[a].equals("Turretle")){
                            if (Math.abs(enemyX[a]-bulletX[i])<110&&Math.abs(enemyY[a]-bulletY[i])<140){
                                isBullet[i]=false;
                                isEnemy[a]=false;
                                score+=30;
                                remainingEnemy-=1;
                                //explosion
                                for (int b = 0; b < 50; b++) {
                                    if (!isExplosion[b]) {
                                        isExplosion[b] = true;
                                        explosionX[b] = enemyX[a];
                                        explosionY[b] = enemyY[a];
                                        explosionTimer[b] = 0;
                                        break;
                                    }
                                }

                            }
                        }
                        else if (enemyType[a].equals("BeetleJuice")){
                            if (Math.abs(enemyX[a]-bulletX[i])<50&&Math.abs(enemyY[a]-bulletY[i])<75){
                                isEnemy[a]=false;
                                isBullet[i]=false;
                                score+=30;
                                remainingEnemy-=1;
                                //explosion
                                for (int b = 0; b < 50; b++) {
                                    if (!isExplosion[b]) {
                                        isExplosion[b] = true;
                                        explosionX[b] = enemyX[a];
                                        explosionY[b] = enemyY[a];
                                        explosionTimer[b] = 0;
                                        break;
                                    }
                                }
                            }
                        }
                        else if (enemyType[a].equals("Goblin")){
                            if (Math.abs(enemyX[a]-bulletX[i])<90&&Math.abs(enemyY[a]-bulletY[i])<90){
                                isEnemy[a]=false;
                                isBullet[i]=false;
                                score+=30;
                                remainingEnemy-=1;
                                //explosion
                                for (int b = 0; b < 50; b++) {
                                    if (!isExplosion[b]) {
                                        isExplosion[b] = true;
                                        explosionX[b] = enemyX[a];
                                        explosionY[b] = enemyY[a];
                                        explosionTimer[b] = 0;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    else continue;
                }
            }
            else continue;
        }
        for (int i=0;i<numOfEnemyBullets;i++){
            if (isEnemyBullet[i]){
                //bullet-villain 1 bullet collision
                if (bulletType[i].equals("duck")){
                    for (int a=0;a<numOfBullets;a++){
                        if (isBullet[a]){
                            if (Math.abs(bulletX[a]-enemyBulletX[i])<112&&Math.abs(bulletY[a]-enemyBulletY[i])<50){
                                isEnemyBullet[i]=false;
                                isBullet[a]=false;
                                //explosion
                                for (int b=0;b<50;b++){
                                    if (!isExplosion[b]){
                                        isExplosion[b]=true;
                                        explosionX[b]=enemyBulletX[i];
                                        explosionY[b]=enemyBulletY[i];
                                        explosionTimer[b]=0;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                //enemy bullet-player collision
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
        //player-enemy collision
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
        for (int i=0;i<50;i++){
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
    public static void gameStart(){
        turtleAngle=0;
        turtleCenterX=900;
        turtleCenterY=1400;
        turtleAngularSpeed=-0.1;
        turtleLinearSpeed=-2.0;
        locX=600.0;
        locY=250.0;
        lives=3;
        score=0;
        remainingEnemy=6;
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
        for (int i=0;i<50;i++){
            if (isExplosion[i]){
                isExplosion[i]=false;
            }
        }
        startEnemy();
        cooldownTimer=10;
        shieldCooldown=-1;
        target=false;
    }

}
