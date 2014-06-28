import java.awt.event.*;
 import java.awt.*;
 import javax.swing.*;
 // ���� Ŭ���� ����
public class tes1 extends JFrame {
  private static int purchase = 0;
  WelcomePanel wPanel = new WelcomePanel();
  TypePanel tPanel = new TypePanel();
  ToppingPanel toPanel = new ToppingPanel();
  SizePanel sPanel = new SizePanel();
  Button button = new Button();
  // ���� ������ ����
 public tes1() {
   setSize(300, 200);
   setTitle("���� �ֹ�");
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
  } // WelcomPanel Ŭ���� ����
 class WelcomePanel extends JPanel {
   private JLabel message;
   public WelcomePanel() {
    message = new JLabel("�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�.");
    add(message);
   }
  } // TypePanel Ŭ���� ����
 class TypePanel extends JPanel {
   private ButtonGroup bg = new ButtonGroup();
   private JRadioButton combo, potato, bulgogi;
   public TypePanel() {
    setLayout(new GridLayout(3, 1));
    combo = new JRadioButton("�޺�", true);
    potato = new JRadioButton("��������");
    bulgogi = new JRadioButton("�Ұ��");
    bg = new ButtonGroup();
    bg.add(combo);
    bg.add(potato);
    bg.add(bulgogi);
    setBorder(BorderFactory.createTitledBorder("����"));
    add(combo);
    add(potato);
    add(bulgogi);
   }
  } // ToppingPanel ����
 class ToppingPanel extends JPanel {
   private ButtonGroup bg = new ButtonGroup();
   private JCheckBox pimeng, cheese, pepe, bacon;
   public ToppingPanel() {
    setLayout(new GridLayout(4, 1));
    pimeng = new JCheckBox("�Ǹ�");
    cheese = new JCheckBox("ġ��");
    pepe = new JCheckBox("����δ�");
    bacon = new JCheckBox("������");
    bg = new ButtonGroup();
    bg.add(pimeng);
    bg.add(cheese);
    bg.add(pepe);
    bg.add(bacon);
    setBorder(BorderFactory.createTitledBorder("�߰� ����"));
    add(pimeng);
    add(cheese);
    add(pepe);
    add(bacon);
   }
  } // SizePanel ����
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
    setBorder(BorderFactory.createTitledBorder("ũ��"));
    add(small);
    add(medium);
    add(large);
   }
  } // Button Ŭ���� ����
 class Button extends JPanel {
   private JButton ok, cancel;
   private JLabel message;
   public Button() {
    setLayout(new FlowLayout(FlowLayout.CENTER));
    ok = new JButton("�ֹ�");
    cancel = new JButton("���");
    message = new JLabel(Integer.toString(purchase) + "��");
    add(ok);
    add(cancel);
    add(message);
   }
  } // �̺�Ʈ �޼ҵ� ����
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
  } // ���� ��� TextField ������
 public void setResult() {
   button.message.setText(Integer.toString(purchase) + "��");
  } // ���� �޼ҵ�
 public static void main(String[] args) {
   new tes1();
  }
 }
