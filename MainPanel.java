import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class MainPanel extends JPanel {//创建的MainPanel类，在MainFrame中调用
    Image background;
    public MainPanel() {
        try {
            background = ImageIO.read(new File("src/moon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0,1200,730, null);
    }
}