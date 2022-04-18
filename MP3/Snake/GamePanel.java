import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class GamePanel extends JPanel implements ActionListener{
  static final int SCREEN_WIDTH = 600;
  static final int SCREEN_HEIGHT = 600;
  static final int UNIT_SIZE = 25;
  static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
  static final int DELAY = 75;
  static int colorHeadNum = 0;
  static int colorBodyNum = 0;
  final int x[] = new int[GAME_UNITS];
  final int y[] = new int[GAME_UNITS];
  int bodyParts = 6;
  int piecesEaten;
  int piecesX;
  int piecesY;
  char direction = 'R';
  boolean running = false;
  Timer timer;
  Random random;
  JButton restart = new JButton("Restart");
  JButton exit = new JButton("Exit");
  GamePanel() {
    random = new Random();
    this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
    this.setBackground(Color.black);
    this.setFocusable(true);
    this.addKeyListener(new MyKeyAdapter());
    this.add(restart);
    this.add(exit);
    restart.setVisible(false);
    restart.addActionListener(this);
    exit.setVisible(false);
    exit.addActionListener(this);
    startGame();
  }
  public void startGame() {
    newPiece();
    running = true;
    timer = new Timer(DELAY, this);
    timer.start();
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    draw(g);
  }
  public void draw(Graphics g) {
    if (running) {
      
      g.setColor(Color.magenta);
      g.fillOval(piecesX, piecesY, UNIT_SIZE, UNIT_SIZE);
      for (int i = 0; i < bodyParts; i++) {
        if (i==0) {
          changeHeadColor(g);
          g.fillRect(x[i], y[i],UNIT_SIZE,UNIT_SIZE);
        }
        else {
          changeBodyColor(g);
          g.fillRect(x[i], y[i],UNIT_SIZE,UNIT_SIZE);
        }
      }
      g.setColor(Color.red);
      g.setFont(new Font("Ink Free", Font.BOLD,40));
      FontMetrics metrics  = getFontMetrics(g.getFont());
      g.drawString("Score:" + piecesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score:" + piecesEaten))/2, g.getFont().getSize());
    }
    else {
      gameOver(g);
    }
  }
  public void newPiece() {
    piecesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
    piecesY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
  }
  public void move() {
    for (int i = bodyParts; i>0; i--) {
      x[i] = x[i-1];
      y[i] = y[i-1];
    }
    switch (direction) {
      case 'U':
        y[0] = y[0]- UNIT_SIZE;
        break;
      case 'D':
        y[0] = y[0] + UNIT_SIZE;
        break;
      case 'L':
        x[0] = x[0] - UNIT_SIZE;
        break;
      case 'R':
        x[0] = x[0] + UNIT_SIZE;
        break;
    }
  }
  public void checkPiece() {
    if ((x[0] == piecesX) && y[0] == piecesY) {
      bodyParts++;
      piecesEaten++;
      newPiece();
    }
  }
  public void checkCollisions() {
    for (int i = bodyParts; i > 0; i--) {
      if ((x[0] == x[i]) && (y[0] == y[i])) {
        running = false;
      }
    }
    if (x[0] < 0) {
      running = false;
    }
    if (x[0] > SCREEN_WIDTH) {
      running = false;
    }
    if (y[0] < 0) {
      running = false;
    }
    if (y[0] > SCREEN_HEIGHT) {
      running = false;
    }
    if (!running) {
      timer.stop();
    }
  }
  public void gameOver(Graphics g){
    restart.setVisible(true);
    restart.setBounds(250,400, 100, 50);
    exit.setVisible(true);
    exit.setBounds(250, 450, 100, 50);
    g.setColor(Color.red);
    g.setFont(new Font("Ink Free", Font.BOLD,40));
    FontMetrics metrics1  = getFontMetrics(g.getFont());
    g.drawString("Score:" + piecesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score:" + piecesEaten))/2, g.getFont().getSize());
    g.setColor(Color.red);
    g.setFont(new Font("Ink Free", Font.BOLD,75));
    FontMetrics metrics2  = getFontMetrics(g.getFont());
    g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
  }
  public static void setColorHead(int num){
    colorHeadNum = num;
  }
  public static void setColorBody(int num){
    colorBodyNum = num;
  }
  public void changeHeadColor(Graphics g){
    if(colorHeadNum == 0){
      g.setColor(Color.red);
    }
    if(colorHeadNum == 1){
      g.setColor(Color.magenta);
    }
    if(colorHeadNum == 2){
      g.setColor(Color.pink);
    }
    if(colorHeadNum==3){
      g.setColor(Color.green);
    }
  }
  public void changeBodyColor(Graphics g){
    if(colorBodyNum == 0){
      g.setColor(new Color (144,238,144));
    }
    if(colorBodyNum == 1){
      g.setColor(new Color(220,20,60));
    }
    if(colorBodyNum == 2){
      g.setColor(new Color(255, 102,255));
    }
    if(colorBodyNum == 3){
      g.setColor(new Color(102,255,255));
    }
  }
  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if (running) {
      move();
      checkPiece();
      checkCollisions();
    }
    repaint();
    if(o == restart){
      GUI.getSelected().goldCount(piecesEaten);
      GameFrame.delete();
      new GameFrame();
      }
    if(o==exit){
      GUI.getSelected().goldCount(piecesEaten);
      GameFrame.delete();
    }
  }
  public class MyKeyAdapter extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
      switch(e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          if (direction != 'R') {
            direction = 'L';
          }
          break;
        case KeyEvent.VK_RIGHT:
          if (direction != 'L') {
            direction = 'R';
          }
          break;
        case KeyEvent.VK_UP:
          if (direction != 'D') {
            direction = 'U';
          }
          break;
        case KeyEvent.VK_DOWN:
          if (direction != 'U') {
            direction = 'D';
          }
          break;
      }
    }
  }
}