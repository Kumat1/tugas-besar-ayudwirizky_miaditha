import javax.swing.*;
import java.awt.*;

import static java.awt.Color.black;

/**
 * Created by HP on 5/13/2017.
 */
public class BubbleShooter extends JFrame {

    public BubbleShooter(){
        JPanel panel = (JPanel) this.getContentPane();
        // panel.setLayout(new GridLayout(2,0));
        BorderLayout borderLayout = new BorderLayout();
        panel.setLayout(borderLayout);
        panel.setBackground(black);

        this.pack();
        this.setMinimumSize(this.getPreferredSize());
        this.setVisible(true);
        // menentukan dua frame yang muncul bersamaan
        // null relatif ke tengah tergantung pada laptop
        this.setLocationRelativeTo(null);
        this.setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        // Keluar dari aplikasi jika aplikasi ditutup
        this.setDefaultCloseOperation((WindowConstants.EXIT_ON_CLOSE));
        // memberi judul aplikasi
        this.setTitle("Bubble Shooter");
    }

    public static void main(String[] args) {
        BubbleShooter bubbleshooter = new BubbleShooter();
    }
}
