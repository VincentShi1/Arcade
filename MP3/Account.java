import java.awt.*;
import java.util.*;

public class Account{
  private String username;
  private String password;
  private static int gold;

  public Account(String username, String password){
    this.username = username;
    this.password = password;
    gold = 0;
  }

  public Account(String username, String password, int g){
    this.username = username;
    this.password = password;
    goldCount(g);
  }

  public String getUser(){
    return username;
  }
  
  public String getPass(){
    return password;
  }

  public static int getGold(){
    return gold;
  }

  public boolean isPassword(String pass)
    {
        return pass.equals(password);
    }

  public static String checkUsername(String username){
    String check = "";
    if(username.length()<1){
      check = "Please insert a username\n";
    }
    return check;
  }
  
  public static String checkPassword(String password){
    String check = "";
    if(password.length()<1){
      check = "Please insert a password\n";
    }
    else if(password.length()<3){
      check = "Please insert a longer password\n";
    }
    return check;
  }

  public static String checkInput(String username, String password){
    return checkUsername(username)+checkPassword(password);
  }

  public static void goldCount(int score){
    gold += score;
    GUI.updateGold();
    System.out.println(gold);
  }

}