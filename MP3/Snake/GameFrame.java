import javax.swing.*;
public class GameFrame{
  private static JFrame frame;
  GameFrame() {
    frame = new JFrame();
    frame.add(new GamePanel());
    frame.setTitle("Snake");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.toFront();
    frame.setAlwaysOnTop(true);
  }
  public static void delete(){
    frame.setVisible(false);
  }
}