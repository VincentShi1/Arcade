import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
public class Trivia implements ActionListener{
  static ArrayList<String> questions = new ArrayList<String>();
  static ArrayList<String> answers;
  JFrame trivia = new JFrame();
  JPanel triviaP = new JPanel();
  JLabel question = new JLabel();
  JTextField answer = new JTextField(5);
  private int correct;
  private static int answerChoice;
  
  public Trivia(){
    trivia.setSize(800,300);
    trivia.setVisible(true);
    trivia.setResizable(false);
    trivia.add(triviaP);

    triviaP.setSize(800,300);
    triviaP.setLayout(new GridLayout(0,1));
    triviaP.add(question);
    triviaP.add(answer);

    question.setHorizontalAlignment(SwingConstants.CENTER);

    answer.addActionListener(this);
    answer.setHorizontalAlignment(SwingConstants.CENTER);
    
    questions.add("<html>Where was the first permanent English settlement in the US? <br> A. New York City, New York, B. Kansas City, Kansas, C. Jamestown, Virginia, D. New Orleans, Lousiana</html>");
    questions.add("<html>In what year did Joseph Smith first organize the Mormon Church?<br> A. 1830, B. 1776, C. 2013, D. 1840</html>");
    questions.add("<html>What was Ronald Reagan before becoming president? <br>A. A general, B. An actor, C. A chef, D. A Twitch streamer</html>");
    questions.add("<html>What is the capital of New York?<br> A. Washington D.C, B. Buffalo, C. Albany, D. New York City</html>");
    questions.add("<html>Which company created Java? <br>A. Apple, B. Sun Microsystems, C. Microsoft, D. Oracle</html>");
    questions.add(("<html>What was the old name of Java?<br> A. Oak, B. Birch,  C. Coffee, D. Viper</html>"));
    questions.add(("<html>Budapest is the capital of which country? <br>A. The Czech Republic, B. Austria, C. Turkey, D. Hungary</html>"));
    questions.add(("<html>The city of Constantinople was renamed to...<br>A. Istanbul, B. Bucarest, C. Sofia, D. Berlin</html>"));
    questions.add(("<html>Who was the mastermind behind the unificatiion of Germany? <br>A. Vladimir Lenin, B. Otto von Bismarck, C. Wilhelm II, D. Nicholas II</html>"));
    questions.add(("<html>What was the Greek myth Achilles known for?<br> A. Being invincibile besides his heel, B. Completing 12 labors, C. Staying away from home for 20 years, D. Slaying Medusa</html>"));
    questions.add(("<html>According to Russian law, a homeless person must be where after 10 pm?<br> A. At a bar, B. In a homeless shelter, C. At home, D. A public facility</html>"));
    questions.add(("<html>What is the formula for force? <br>A. m*a, B. m*g, C. d/t, D. v/t</html>"));
    questions.add(("<html>What is the best selling videogame?<br> A. Super Mario Bros, B. GTAV, C. Minecraft, D. CS:GO</html>"));
    questions.add(("<html>When was the first iPhone created? <br>A. 2007, B. 2013, C. 2005, D. 1998</html>"));
    questions.add(("<html>Which one is a romance language?<br> A. Chinese, B. German, C. Arabic, D. Spanish</html>"));
    questions.add(("<html>How long has Switzerland been neutral?<br> A. 500 years, B. 300 years, C. 100 years, D. 600 years</html>"));
  questions.add(("How tall is Mr. Holmer? A. 5'2, B. 5'11, C. 6'1, D. 3'2"));
    questions.add(("<html>What year did BTHS begin admitting female students? <br>A. 1970, B. 1948, C. 1799, D. 1918</html>"));
    questions.add(("<html>What was the name of New York City before the British took control?<br> A. Neuark, B. New Amsterdam, C. Old York, D. New Haarlem</html>"));
    questions.add(("<html>What term is used for a religion that follows multiple deities?<br> A. Monotheism, B. Polytheism, C. Deism, D. Shintoism</html>"));

    answers = new ArrayList<String>() {
      {
      add("C");
      add("A");
      add("B");
      add("C");
      add("B");
      add("A");
      add("D");
      add("A");
      add("B");
      add("A");
      add("C");
      add("A");
      add("C");
      add("A");
      add("D");
      add("A");
      add("C");
      add("A");
      add("B");
      add("B");
      }
    };
    trivias(question, answer, answerChoice);
  }
  public void trivias(JLabel q, JTextField a, int questionNum) {
    if(questionNum<questions.size()){
        q.setText(questions.get(questionNum));
      }
    else{
      JOptionPane.showMessageDialog(trivia, "You finished the trivia, Your score is " + correct+"/20" , "Finish", JOptionPane.PLAIN_MESSAGE);
      Account.goldCount(correct/2);
      trivia.setVisible(false);
    }
  }
  public void checkAnswer(JTextField a ,int i){
    if (a.getText().toUpperCase().equals(answers.get(i))) {
        System.out.println("You got it right!");
        correct++;
      }
      else {
        JOptionPane.showMessageDialog(trivia,"Damn, better luck next time...", "Incorrect Answer", JOptionPane.ERROR_MESSAGE);
      }
  }

  public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if(o==answer){
      checkAnswer(answer, answerChoice);
      answer.setText("");
      answerChoice++;
      trivias(question, answer, answerChoice);
    }
  }
}