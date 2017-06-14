/**
 * Created by HP on 6/11/2017.
 */


import javax.activation.DataSource;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUImember extends JFrame implements ActionListener
{
    public static String driver;
    public static Connection con;
    public static Statement st;
    private static JTextField tfID;
    private static JTextField tfNama;
    private static JTextField tfAlamat;
    private static JTextField tfHP;
    private static JTextField tfCari;
    private static JButton btnInsert;
    private static JButton btnUpdate;
    private static JButton btnDelete;
    private static JButton btnCari;
    private static JButton btnCheck;

    public String JJ3, JJ4,id_member, nama_member,alamat_member, hp_member;

    public GUImember()
    {
        setContentPane(new JLabel(new ImageIcon("src/book.jpg")));
        JLabel lbJJ3       = new JLabel ("Data");
        JLabel lbJJ4       = new JLabel ("Member Perpustakaan");
        JLabel lbID        = new JLabel ("ID");
        JLabel lbNama      = new JLabel ("Nama ");
        JLabel lbAlamat    = new JLabel ("Alamat");
        JLabel lbHP        = new JLabel ("No. HP");

        lbJJ3.setFont(new java.awt.Font("Footlight MT Light",10,25));

        tfID          = new JTextField (30);
        tfNama        = new JTextField (30);
        tfAlamat      = new JTextField (30);
        tfHP          = new JTextField (30);
        tfCari        = new JTextField (10);

        btnInsert     = new JButton ("Insert");
        btnUpdate     = new JButton ("Update");
        btnDelete     = new JButton ("Delete");
        btnCari       = new JButton ("Find");
        btnCheck      = new JButton ("Check");

        setLayout(null);
        Dimension sizelbJJ3       = lbJJ3.getPreferredSize();
        Dimension sizelbJJ4       = lbJJ4.getPreferredSize();
        Dimension sizelbID        = lbID.getPreferredSize();
        Dimension sizelbNama      = lbNama.getPreferredSize();
        Dimension sizelbAlamat    = lbAlamat.getPreferredSize();
        Dimension sizelbHP        = lbHP.getPreferredSize();

        Dimension sizetfID        = tfID.getPreferredSize();
        Dimension sizetfNama      = tfNama.getPreferredSize();
        Dimension sizetfAlamat    = tfAlamat.getPreferredSize();
        Dimension sizetfHP        = tfHP.getPreferredSize();
        Dimension sizetfCari      = tfCari.getPreferredSize();

        Dimension sizebtnInsert   = btnInsert.getPreferredSize();
        Dimension sizebtnUpdate   = btnUpdate.getPreferredSize();
        Dimension sizebtnDelete   = btnDelete.getPreferredSize();
        Dimension sizebtnCari     = btnCari.getPreferredSize();
        Dimension sizebtnCheck    = btnCheck.getPreferredSize();

        lbJJ3.setBounds(220,10, sizelbJJ3.width, sizelbJJ3.height);
        lbJJ4.setBounds(175,40, sizelbJJ4.width, sizelbJJ4.height);
        lbID.setBounds(10,80, sizelbID.width, sizelbID.height);
        lbNama.setBounds(10,120, sizelbNama.width, sizelbNama.height);
        lbAlamat.setBounds(10,160, sizelbAlamat.width, sizelbAlamat.height);
        lbHP.setBounds(10,200, sizelbHP.width, sizelbHP.height);

        tfID.setBounds(100,80, sizetfID.width, sizetfID.height);
        tfNama.setBounds(100,120, sizetfNama.width, sizetfNama.height);
        tfAlamat.setBounds(100,160, sizetfAlamat.width, sizetfAlamat.height);
        tfHP.setBounds(100,200, sizetfHP.width, sizetfHP.height);
        tfCari.setBounds(180,300, sizetfCari.width, sizetfCari.height);

        btnInsert.setBounds(100,250, sizebtnInsert.width, sizebtnInsert.height);
        btnUpdate.setBounds(220,250, sizebtnUpdate.width, sizebtnUpdate.height);
        btnDelete.setBounds(345,250, sizebtnDelete.width, sizebtnDelete.height);
        btnCari.setBounds(100,300, sizebtnCari.width, sizebtnCari.height);
        btnCheck.setBounds(440,250, sizebtnCheck.width, sizebtnCheck.height);

        add(lbJJ3);
        add(lbJJ4);
        add(lbID);
        add(tfID);
        add(lbNama);
        add(tfNama);
        add(lbAlamat);
        add(tfAlamat);
        add(lbHP);
        add(tfHP);
        add(tfCari);

        add(btnInsert);
        add(btnUpdate);
        add(btnDelete);
        add(btnCari);
        add(btnCheck);

        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCari.addActionListener(this);
        btnCheck.addActionListener(this);

        setSize(550,450);
        setTitle("Perpustakaan Teknologi Informasi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String args []) throws Exception
    {
        GUImember s = new GUImember ();
        s.setVisible(true);
    }

    public void insert() throws Exception
    {
        id_member      = tfID.getText();
        nama_member    = tfNama.getText();
        alamat_member  = tfAlamat.getText();
        hp_member      = tfHP.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("INSERT INTO tb_member  VALUES('"+id_member+"','"+nama_member+"','"+alamat_member+"','"+hp_member+"')");
        System.out.println("1 row inserted");
    }

    public void update() throws Exception
    {
        id_member      = tfID.getText();
        nama_member    = tfNama.getText();
        alamat_member  = tfAlamat.getText();
        hp_member      = tfHP.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();

        st.executeUpdate("UPDATE tb_member SET nama_member = '"+nama_member+"',alamat_member  = '"+alamat_member+"', hp_member = '"+hp_member+"' WHERE id_member = '"+id_member+"'");
        System.out.println("1 row updated");
    }

    public void delete() throws Exception
    {
        id_member      = tfID.getText();
        nama_member    = tfNama.getText();
        alamat_member  = tfAlamat.getText();
        hp_member      = tfHP.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();

        st.executeUpdate("DELETE FROM tb_member WHERE id_member = '"+id_member+"'" );
        System.out.println("1 row deleted");
    }

    public void cari () throws Exception
    {
        JPanel panel = new JPanel();
        GridLayout gl = new GridLayout(7,2);
        panel.setLayout(gl);
        String Cari = tfCari.getText();
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        Statement st = con.createStatement();
        String sql= "SELECT * FROM tb_member WHERE id_member LIKE '"+Cari+"' ";
        System.out.println("1 row searched");
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            tfID.setText(rs.getString(1));
            tfNama.setText(rs.getString(2));
            tfAlamat.setText(rs.getString(3));
            tfHP.setText(rs.getString(4));

        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== btnInsert)
        {
            try{
                this.insert();
                JOptionPane.showMessageDialog(rootPane, "data berhasil ditambah!" );
            }
            catch (Exception es){
                JOptionPane.showMessageDialog(null, "Maaf! Input Error");
            }
        }
        else if(e.getSource()== btnUpdate)
        {
            try
            {
                this.update();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil di update!" );
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
                JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus!" );
            }
            catch (Exception es)
            {
                JOptionPane.showMessageDialog(null, "Maaf! Input Error");
            }
        }
        else if(e.getSource()== btnCari)
        {
            try
            {
                this.cari();
            }
            catch (Exception es)
            {
                JOptionPane.showMessageDialog(null, "Maaf! Input Error");
            }
        }
        else if(e.getSource()== btnCheck)
        {
            btnCheck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new datamember();
                }
            });
        }
    }


}