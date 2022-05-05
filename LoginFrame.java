import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoginFrame extends JFrame {
    public boolean start;
    JLabel userLabel1;
    JTextField userField1;
    JLabel userLabel2;
    JTextField userField2;
    JButton Login,Cancel;
    Dimension screenSize;
    public LoginFrame() {
        URL classUrl = this.getClass().getResource("");
        Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl); // Make the mouse transparent
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imageCursor, new Point(0, 0), "cursor"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/img/menu/mouse.png").getImage(), new Point(0, 0), null));
        // give an icon to mouse

        userLabel1 = new JLabel("Player1");
        userLabel1.setFont(new Font("微软雅黑",Font.BOLD,18));
        userLabel1.setBounds(20, 220, 80, 30);
        this.add(userLabel1);

        userField1 = new JTextField();
        userField1.setBounds(100, 220, 100, 30);
        userField1.setBorder(BorderFactory.createLoweredBevelBorder());
        userField1.setOpaque(false);
        this.add(userField1);

        userLabel2 = new JLabel("Player2");
        userLabel2.setFont(new Font("微软雅黑",Font.BOLD,18));
        userLabel2.setBounds(220, 220, 80, 30);
        this.add(userLabel2);

        userField2 = new JTextField();
        userField2.setBounds(300, 220, 100, 30);
        userField2.setBorder(BorderFactory.createLoweredBevelBorder());
        userField2.setOpaque(false);
        this.add(userField2);

        Login = new JButton("Login");
        Login.setBounds(45,350,100,36);

        Login.addActionListener(new ActionListener() {//ActionListener alt /

            @Override
            public void actionPerformed(ActionEvent e) {
                start=true;
            }
        });
        this.add(Login);

        Cancel = new JButton("Exit");
        Cancel.setBounds(155,350,100,36);
        this.add(Cancel);
        Cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });


        LoginPanel panel = new LoginPanel();
        this.add(panel);

        this.setIconImage(new ImageIcon("src/img/temp/��־��.png").getImage());//logo
        setUndecorated(true);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        this.setLocationRelativeTo(null);//位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        this.setVisible(true);
    }

    public boolean getStart(){
        return start;
    }

    class LoginPanel extends JPanel{
        //背景图片变量
        Image background;
        public LoginPanel() {
            try {
                background = ImageIO.read(new File("src/img/menu/SHOOT.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(background, 0, 0, screenSize.width, screenSize.height, null);
        }
    }
}