/**
 * Created by Acer on 11/06/2017.
 */
import javax.activation.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUIdetailpeminjaman extends JFrame implements ActionListener
{
    public static String driver;
    public static Connection con;
    public static Statement st;
    private static JTextField tfIDP;
    private static JTextField tfIDB;
    private static JTextField tfIDPem;
    private static JButton btnInsert;
    private static JButton btnUpdate;
    private static JButton btnDelete;
    public String JJ11, JJ12,id_detail_peminjaman, id_buku, id_peminjaman;

    public GUIdetailpeminjaman()
    {
        setContentPane(new JLabel(new ImageIcon("src/book.jpg")));
        JLabel lbJJ11       = new JLabel ("Data");
        JLabel lbJJ12       = new JLabel ("Detail Peminjaman Buku Perpustakaan");
        JLabel lbIDP        = new JLabel ("ID detail ");
        JLabel lbIDB        = new JLabel ("ID Buku");
        JLabel lbIDPem      = new JLabel ("ID Peminjaman");

        tfIDP       = new JTextField (15);
        tfIDB       = new JTextField (15);
        tfIDPem     = new JTextField (15);

        btnInsert   = new JButton ("Insert");
        btnUpdate   = new JButton ("Update");
        btnDelete   = new JButton ("Delete");

        setLayout(null);
        Dimension sizelbJJ11       = lbJJ11.getPreferredSize();
        Dimension sizelbJJ12       = lbJJ12.getPreferredSize();
        Dimension sizelbIDP        = lbIDP.getPreferredSize();
        Dimension sizelbIDB        = lbIDB.getPreferredSize();
        Dimension sizelbIDPem      = lbIDPem.getPreferredSize();

        Dimension sizetfIDP        = tfIDP.getPreferredSize();
        Dimension sizetfIDB        = tfIDB.getPreferredSize();
        Dimension sizetfIDPem      = tfIDPem.getPreferredSize();

        Dimension sizebtnInsert    = btnInsert.getPreferredSize();
        Dimension sizebtnUpdate    = btnUpdate.getPreferredSize();
        Dimension sizebtnDelete    = btnDelete.getPreferredSize();

        lbJJ11.setBounds(220,10, sizelbJJ11.width, sizelbJJ11.height);
        lbJJ12.setBounds(130,40, sizelbJJ12.width, sizelbJJ12.height);
        lbIDP.setBounds(10,80, sizelbIDP.width, sizelbIDP.height);
        lbIDB.setBounds(10,120, sizelbIDB.width, sizelbIDB.height);
        lbIDPem.setBounds(10,160, sizelbIDPem.width, sizelbIDPem.height);

        tfIDP.setBounds(150,80, sizetfIDP.width, sizetfIDP.height);
        tfIDB.setBounds(150,120, sizetfIDB.width, sizetfIDB.height);
        tfIDPem.setBounds(150,160, sizetfIDPem.width, sizetfIDPem.height);

        btnInsert.setBounds(120,200, sizebtnInsert.width, sizebtnInsert.height);
        btnUpdate.setBounds(195,200, sizebtnUpdate.width, sizebtnUpdate.height);
        btnDelete.setBounds(280,200, sizebtnDelete.width, sizebtnDelete.height);

        add(lbJJ11);
        add(lbJJ12);
        add(lbIDP);
        add(tfIDP);
        add(lbIDB);
        add(tfIDB);
        add(lbIDPem);
        add(tfIDPem);

        add(btnInsert);
        add(btnUpdate);
        add(btnDelete);

        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        setSize(450,300);
        setTitle("Perpustakaan Teknologi Informasi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String args []) throws Exception
    {
        GUIdetailpeminjaman s = new GUIdetailpeminjaman ();
        s.setVisible(true);
    }

    public void insert() throws Exception
    {
        id_detail_peminjaman  = tfIDP.getText();
        id_buku               = tfIDB.getText();
        id_peminjaman         = tfIDPem.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("INSERT INTO tb_detail_peminjaman  VALUES('"+id_detail_peminjaman+"','"+id_buku+"','"+id_peminjaman+"')");
        System.out.println("1 row inserted");
    }

    public void update() throws Exception
    {
        id_detail_peminjaman  = tfIDP.getText();
        id_buku               = tfIDB.getText();
        id_peminjaman         = tfIDPem.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("UPDATE tb_detail_peminjaman SET id_buku  = '"+id_buku+"', id_peminjaman = '"+id_peminjaman+"', WHERE id_detail_peminjaman = '"+id_detail_peminjaman+"')");
        System.out.println("1 row updated");
    }

    public void delete() throws Exception
    {
        id_detail_peminjaman  = tfIDP.getText();
        id_buku               = tfIDB.getText();
        id_peminjaman         = tfIDPem.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("DELETE FROM tb_detail_peminjaman WHERE id_detail_peminjaman = '"+id_detail_peminjaman+"'" );
        System.out.println("1 row deleted");
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== btnInsert)
        {
            try
            {
                this.insert();
            }
            catch (Exception es)
            {
                JOptionPane.showMessageDialog(null, "Maaf! Input Error");
            }
        }
        else if(e.getSource()== btnUpdate)
        {
            try
            {
                this.update();
            }
            catch (Exception es)
            {
                JOptionPane.showMessageDialog(null, "Maaf! Input Error");
            }
        }

        else if(e.getSource()== btnDelete)
        {
            try
            {
                this.delete();
            }
            catch (Exception es)
            {
                JOptionPane.showMessageDialog(null, "Maaf! Input Error");
            }
        }
    }
}

