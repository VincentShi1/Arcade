import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.JTableHeader;

public class GUI implements ActionListener {
    JFrame main = new JFrame("J");
    JFrame registerF = new JFrame("Register");
    JFrame loginF = new JFrame("Log in");
    JFrame selection = new JFrame("Select Game");

    JPanel mainW = new JPanel();
    JPanel registerW = new JPanel();
    JPanel loginW = new JPanel();
    JPanel selectW = new JPanel();
    
    JLabel loginLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel registerLabel = new JLabel("Username:");
    JLabel passLabel = new JLabel("Password:");
    static JLabel goldLabel = new JLabel("Gold:" + Account.getGold());
  
    JTextField loginText = new JTextField(20);
    JPasswordField passwordText = new JPasswordField();
    JTextField registerText = new JTextField(20);
    JPasswordField passText = new JPasswordField();
  
    JButton login = new JButton("Log in");
    JButton register = new JButton("Register");
    JButton signIn = new JButton("Sign In");
    JButton signUp = new JButton("Sign Up");
    JButton logOut = new JButton("Log Out");
    JButton snake = new JButton();
    JButton trivia = new JButton();
    JButton shop = new JButton();
  
    String error = "";
    private static Account selected;
    ArrayList<Account> account = new ArrayList<Account>();

  public GUI(){
    ImageIcon logo = new ImageIcon("27375109.png");
    Image image = logo.getImage(); // transform it 
    Image newimg = image.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    logo = new ImageIcon(newimg);  // transform it back

    ImageIcon sna = new ImageIcon("Snake.png");
    Image image2 = sna.getImage(); // transform it 
    Image newimg2 = image2.getScaledInstance(130, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    sna = new ImageIcon(newimg2);  // transform it back

    ImageIcon brain = new ImageIcon("Brain.png");
    Image image3 = brain.getImage(); // transform it 
    Image newimg3 = image3.getScaledInstance(130, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    brain = new ImageIcon(newimg3);  // transform it back

    ImageIcon shopImg = new ImageIcon("Shop.png");
    Image image4 = shopImg.getImage(); // transform it 
    Image newimg4 = image4.getScaledInstance(100, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
     shopImg= new ImageIcon(newimg4);  // transform it back
    
    JLabel title = new JLabel("", logo, JLabel.CENTER);
    main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // what happen after JFrame were closed
    main.setSize(500, 400); // size
    main.setLocationRelativeTo(null); // make the JFrame set at the center
    main.setResizable(false);
    main.setVisible(true); // make it visible
    main.add(mainW, BorderLayout.CENTER);

    registerF.setSize(350, 275);
    registerF.setResizable(false);
    registerF.setLocationRelativeTo(null);
    registerF.add(registerW);

    loginF.setSize(350, 275);
    loginF.setResizable(false);
    loginF.setLocationRelativeTo(null);
    loginF.add(loginW);

    selection.setSize(500,500);
    selection.setResizable(false);
    selection.setLocationRelativeTo(null);
    selection.add(selectW);
 
    mainW.setBackground(Color.GRAY);
    mainW.setPreferredSize(new Dimension(400,400));
    mainW.add(title); 
    mainW.add(login);
    mainW.add(register);

    registerW.setLayout(null);

    loginW.setLayout(null);

    selectW.setLayout(null);
    selectW.setPreferredSize(new Dimension(400,400));
    selectW.setBackground(Color.WHITE);
    selectW.add(snake);
    selectW.add(goldLabel);
    selectW.add(trivia);
    selectW.add(shop);
    selectW.add(logOut);

    title.setBounds(170, 60, 150, 150);

    login.setBounds(170, 245, 100, 45);
    login.setFocusable(false);
    login.addActionListener(this);
    
    register.setBounds(170, 180, 100, 45);
    register.setFocusable(false);
    register.addActionListener(this);

    logOut.setBounds(50, 50, 100, 30);
    logOut.setFocusable(false);
    logOut.addActionListener(this);

    snake.setBounds(90,100,130,80);
    snake.setIcon(sna);
    snake.setFocusable(false);
    snake.addActionListener(this);

    trivia.setBounds(250, 100, 130,80);
    trivia.setIcon(brain);
    trivia.setFocusable(false);
    trivia.addActionListener(this);

    shop.setBounds(300,250, 105, 75);
    shop.setIcon(shopImg);
    shop.setFocusable(false);
    shop.addActionListener(this);

    goldLabel.setBounds(350, 10, 80, 50);
  }


  public void makeRegister(){
    
    registerLabel.setBounds(10, 20, 80, 25);
    registerW.add(registerLabel);

    registerText.setBounds(110, 20, 165, 25);
    registerW.add(registerText);

    passLabel.setBounds(10, 60, 80, 25);
    registerW.add(passLabel);

    passText.setBounds(110, 60, 165, 25);
    registerW.add(passText);

    signUp.setFocusable(false);
    signUp.setBounds(10, 200, 100, 25);
    signUp.addActionListener(this);
    registerW.add(signUp);

    }

    public void makeLogin(){

    loginLabel.setBounds(10, 20, 80, 25);
    loginW.add(loginLabel);

    loginText.setBounds(110, 20, 165, 25);
    loginW.add(loginText);

    passwordLabel.setBounds(10, 60, 80, 25);
    loginW.add(passwordLabel);

    passwordText.setBounds(110, 60, 165, 25);
    loginW.add(passwordText);
      
    signIn.setFocusable(false);
    signIn.setBounds(10, 200, 100, 25);
    signIn.addActionListener(this);
    loginW.add(signIn);
  }

  public static void updateGold(){
    goldLabel.setText("Gold:" + selected.getGold());
  }
  public void addAccount(Account a){
    account.add(account.size(), a);
  }
  public static Account getSelected(){
    return selected;
  }

  public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if(o == login){
      System.out.println("test");
      loginW.removeAll();
      loginText.setText("");
      passwordText.setText("");
      makeLogin();
      loginF.setVisible(true);
      }
    else if(o == register){
      System.out.println("trest");
      registerText.setText("");
      passText.setText("");
      makeRegister();
      registerF.setVisible(true);
      }
    else if(o==signUp){
      error = Account.checkInput(registerText.getText(), String.valueOf(passText.getPassword()));
      for(Account i : account){
        if(i!=null && i.getUser().equals(registerText.getText())){
          error = "Username taken";
        }
      }
      if(error.length()!=0){
        JOptionPane.showMessageDialog(registerF, error, "Error",JOptionPane.ERROR_MESSAGE);
        }
      else{
        if(account.size()<1){
        account.add(new Account(registerText.getText(), String.valueOf(passText.getPassword())));
        registerF.setVisible(false);
        }
        else{
          account.add(account.size(),new Account(registerText.getText(), String.valueOf(passText.getPassword())));
          registerF.setVisible(false);
        }
      }
      System.out.println("a");
    }
    else if(o==signIn){
      boolean found = false;
      String passInput = String.valueOf(passwordText.getPassword());
      for(int i = 0; i<account.size(); i++){
        Account a = account.get(i);
        if(a.getUser().equals(loginText.getText())&& a.isPassword(passInput)){
          System.out.println("Loggin");
          selected = a;
          found = true;
          loginF.setVisible(false);
          main.setVisible(false);
          selection.setVisible(true);
        }
      }
      if(!found){
          JOptionPane.showMessageDialog(loginF, "Please insert the correct username or password", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    else if(o==logOut){
      selection.setVisible(false);
      selected = null;
      main.setVisible(true);
    }
    else if(o==snake){
      new GameFrame();
    }
    else if(o == trivia){
      new Trivia();
    }
    else if(o==shop){
      new Shop();
    }
  }
}