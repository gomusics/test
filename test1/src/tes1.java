import java.awt.event.*;
 import java.awt.*;
 import javax.swing.*;
 // 피자 클래스 정의
public class tes1 extends JFrame {
  private static int purchase = 0;
  WelcomePanel wPanel = new WelcomePanel();
  TypePanel tPanel = new TypePanel();
  ToppingPanel toPanel = new ToppingPanel();
  SizePanel sPanel = new SizePanel();
  Button button = new Button();
  // 피자 생성자 정의
 public tes1() {
   setSize(300, 200);
   setTitle("피자 주문");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  add(wPanel, BorderLayout.NORTH);
   add(tPanel, BorderLayout.WEST);
   add(toPanel, BorderLayout.CENTER);
   add(sPanel, BorderLayout.EAST);
   add(button, BorderLayout.SOUTH);

  myActionListener m = new myActionListener();
   button.ok.addActionListener(m);
   button.cancel.addActionListener(m);

  setVisible(true);
  } // WelcomPanel 클래스 정의
 class WelcomePanel extends JPanel {
   private JLabel message;
   public WelcomePanel() {
    message = new JLabel("자바 피자에 오신것을 환영합니다.");
    add(message);
   }
  } // TypePanel 클래스 정의
 class TypePanel extends JPanel {
   private ButtonGroup bg = new ButtonGroup();
   private JRadioButton combo, potato, bulgogi;
   public TypePanel() {
    setLayout(new GridLayout(3, 1));
    combo = new JRadioButton("콤보", true);
    potato = new JRadioButton("포테이토");
    bulgogi = new JRadioButton("불고기");
    bg = new ButtonGroup();
    bg.add(combo);
    bg.add(potato);
    bg.add(bulgogi);
    setBorder(BorderFactory.createTitledBorder("종류"));
    add(combo);
    add(potato);
    add(bulgogi);
   }
  } // ToppingPanel 정의
 class ToppingPanel extends JPanel {
   private ButtonGroup bg = new ButtonGroup();
   private JCheckBox pimeng, cheese, pepe, bacon;
   public ToppingPanel() {
    setLayout(new GridLayout(4, 1));
    pimeng = new JCheckBox("피망");
    cheese = new JCheckBox("치즈");
    pepe = new JCheckBox("페페로니");
    bacon = new JCheckBox("베이컨");
    bg = new ButtonGroup();
    bg.add(pimeng);
    bg.add(cheese);
    bg.add(pepe);
    bg.add(bacon);
    setBorder(BorderFactory.createTitledBorder("추가 토핑"));
    add(pimeng);
    add(cheese);
    add(pepe);
    add(bacon);
   }
  } // SizePanel 정의
 class SizePanel extends JPanel {
   private ButtonGroup bg = new ButtonGroup();
   private JRadioButton small, medium, large;
   public SizePanel() {
    setLayout(new GridLayout(3, 1));
    small = new JRadioButton("Small", true);
    medium = new JRadioButton("Medium");
    large = new JRadioButton("Large");
    bg = new ButtonGroup();
    bg.add(small);
    bg.add(medium);
    bg.add(large);
    setBorder(BorderFactory.createTitledBorder("크기"));
    add(small);
    add(medium);
    add(large);
   }
  } // Button 클래스 정의
 class Button extends JPanel {
   private JButton ok, cancel;
   private JLabel message;
   public Button() {
    setLayout(new FlowLayout(FlowLayout.CENTER));
    ok = new JButton("주문");
    cancel = new JButton("취소");
    message = new JLabel(Integer.toString(purchase) + "원");
    add(ok);
    add(cancel);
    add(message);
   }
  } // 이벤트 메소드 정의
 public class myActionListener implements ActionListener {
   public myActionListener() {
   }
   public void actionPerformed(ActionEvent e) {
    if(e.getSource() == button.ok) {
     if(tPanel.combo.isSelected()) {
      purchase += 10000;
      setResult();
     }
     if(tPanel.potato.isSelected()) {
      purchase += 12000;
      setResult();
     }
     if(tPanel.bulgogi.isSelected()) {
      purchase += 14000;
      setResult();
     }
     if(toPanel.pimeng.isSelected()) {
      purchase += 300;
      setResult();
     }
     if(toPanel.cheese.isSelected()) {
      purchase += 700;
      setResult();
     }
     if(toPanel.pepe.isSelected()) {
      purchase += 500;
      setResult();
     }
     if(toPanel.bacon.isSelected()) {
      purchase += 1000;
      setResult();
     }
     if(sPanel.small.isSelected()) {
      purchase += 0;
      setResult();
     }
     if(sPanel.medium.isSelected()) {
      purchase += 2000;
      setResult();
     }
     if(sPanel.large.isSelected()) {
      purchase += 4000;
      setResult();
     }
    } else if(e.getSource() == button.cancel) {
     purchase = 0;
     setResult();
    }
   }
  } // 가격 출력 TextField 설정자
 public void setResult() {
   button.message.setText(Integer.toString(purchase) + "원");
  } // 메인 메소드
 public static void main(String[] args) {
   new tes1();
  }
 }
