import java.util.*;
  public class Question {
  private static String question;
  private String one;
  private String two;
  private String three;
  private String four;//choices
  private static boolean bruh = false;
  public Question(String q,String o, String tw, String th, String f, boolean b) {
    question = q;
    one = o;
    two = tw;
    three = th;
    four = f;
    bruh = b;
  }
  public Question(String q,String o, String tw, String th, String f) {
    question = q;
    one = o;
    two = tw;
    three = th;
    four = f;
  }
  public String getQuestion() {
    return question;
  }
  public boolean getBoolean() {
    return bruh;
  }
  public void setBoolean() {
    bruh = true;
  }
  public static String getQuestions(ArrayList<Question> a, int b){
    Question questionNum = null;
    questionNum = a.get(b);
    return questionNum.getQuestion();
  }
}