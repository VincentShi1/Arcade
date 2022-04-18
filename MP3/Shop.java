import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.JTableHeader;

public class Shop implements ActionListener{
  JFrame shop = new JFrame("shop");
  JPanel shops = new JPanel();
  JButton color1 = new JButton("Snake: Red body");
  JButton color2 = new JButton("Snake: Pink body");
  JButton color3 = new JButton("Snake: Cyan body");
  JButton color4 = new JButton("Snake: Magenta head");
  JButton color5 = new JButton("Snake: Pink Head");
  JButton color6 = new JButton("Snake: Green head");
  JButton exit = new JButton("Exit");
  JLabel text = new JLabel("Shop");
  JLabel redBodyMoney = new JLabel("5 gold");
  JLabel pinkBodyMoney = new JLabel("5 gold");
  JLabel cyanBodyMoney = new JLabel("5 gold");
  JLabel magentaHeadMoney = new JLabel("5 gold");
  JLabel pinkHeadMoney = new JLabel("5 gold");
  JLabel greenHeadMoney = new JLabel("5 gold");
  public Shop(){
    shop.setSize(500,500);
    shop.setLocationRelativeTo(null);
    shop.setResizable(false);
    shop.add(shops);
    shop.setVisible(true);

    shops.setPreferredSize(new Dimension(500,500));
    shops.setLayout(null);
    shops.add(color1);
    shops.add(color2);
    shops.add(color3);
    shops.add(color4);
    shops.add(color5);
    shops.add(color6);
    shops.add(redBodyMoney);
    shops.add(pinkBodyMoney);
    shops.add(cyanBodyMoney);
    shops.add(magentaHeadMoney);
    shops.add(pinkHeadMoney);
    shops.add(greenHeadMoney);
    shops.add(exit);

    color1.setBounds(80, 100, 200, 20);
    color1.setFocusable(false);
    color1.addActionListener(this);

    color2.setBounds(80, 150, 200, 20);
    color2.setFocusable(false);
    color2.addActionListener(this);

    color3.setBounds(80, 200, 200, 20);
    color3.setFocusable(false);
    color3.addActionListener(this);

    color4.setBounds(80, 250, 200, 20);
    color4.setFocusable(false);
    color4.addActionListener(this);

    color5.setBounds(80, 300, 200, 20);
    color5.setFocusable(false);
    color5.addActionListener(this);

    color6.setBounds(80, 350, 200, 20);
    color6.setFocusable(false);
    color6.addActionListener(this);
    
    exit.setBounds(220,400,90,20);
    exit.setFocusable(false);
    exit.addActionListener(this);

    text.setBounds(150,50,70,70);
    redBodyMoney.setBounds(285,85, 50,50); 
    pinkBodyMoney.setBounds(285,135,50,50);
    cyanBodyMoney.setBounds(285,185,50,50);
    magentaHeadMoney.setBounds(285,235, 50,50); 
    pinkHeadMoney.setBounds(285,285,50,50);
    greenHeadMoney.setBounds(285,335,50,50);
  }
    public void actionPerformed(ActionEvent e){
    Object o = e.getSource();
    if(o == color1){
      if(GUI.getSelected().getGold()<5){
        JOptionPane.showMessageDialog(shop, "You do not have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
      }
      else{
        color1.setEnabled(false);
        GamePanel.setColorBody(1);
        Account.goldCount(-5);
        System.out.println("red");
      }
    }
    else if(o == color2){
      if(GUI.getSelected().getGold()<5){
        JOptionPane.showMessageDialog(shop, "You do not have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
      }
      else{
        GamePanel.setColorBody(2);
        Account.goldCount(-5);
        System.out.println("pink");
        color2.setEnabled(false);
      }
    }
    else if(o==color3){
      if(GUI.getSelected().getGold()<5){
        JOptionPane.showMessageDialog(shop, "You do not have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
      }
      else{
        GamePanel.setColorBody(3);
        Account.goldCount(-5);
        System.out.println("cyan");
        color3.setEnabled(false);
      }
    }
    else if(o==color4){
      if(GUI.getSelected().getGold()<5){
        JOptionPane.showMessageDialog(shop, "You do not have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
      }
      else{
        GamePanel.setColorHead(1);
        Account.goldCount(-5);
        System.out.println("magenta");
        color4.setEnabled(false);
      }
    }
    else if(o==color5){
      if(GUI.getSelected().getGold()<5){
        JOptionPane.showMessageDialog(shop, "You do not have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
      }
      else{
        GamePanel.setColorHead(2);
        Account.goldCount(-5);
        System.out.println("pink");
        color5.setEnabled(false);
      }
    }
    else if(o==color6){
      if(GUI.getSelected().getGold()<5){
        JOptionPane.showMessageDialog(shop, "You do not have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
      }
      else{
        GamePanel.setColorHead(3);
        Account.goldCount(-5);
        System.out.println("green");
        color6.setEnabled(false);
      }
    }
    else if(o == exit){
      shop.setVisible(false);
    }
  }
}