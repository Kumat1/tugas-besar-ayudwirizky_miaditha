/**
 * Created by HP on 6/11/2017.
 */


import javax.activation.DataSource;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUIbuku extends JFrame implements ActionListener
{
    public static String driver;
    public static Connection con;
    public static Statement st;
    private static JTextField tfID;
    private static JTextField tfJudul;
    private static JTextField tfIsbn;
    private static JTextField tfPengarang;
    private static JTextField tfPenerbit;
    private static JTextField tfTahun;
    private static JTextField tfCari;
    private static JButton btnInsert;
    private static JButton btnUpdate;
    private static JButton btnDelete;
    private static JButton btnCari;
    private static JButton btnCheck;

    public String JJ1, JJ2,id_buku, judul_buku,isbn, pengarang, penerbit,tahun_buku;

    public GUIbuku()
    {
        setContentPane(new JLabel(new ImageIcon("src/book.jpg")));
        JLabel lbJJ1       = new JLabel ("Data");
        JLabel lbJJ2       = new JLabel ("Buku Perpustakaan");
        JLabel lbID        = new JLabel ("ID");
        JLabel lbJudul     = new JLabel ("Judul Buku");
        JLabel lbIsbn      = new JLabel ("ISBN");
        JLabel lbPengarang = new JLabel ("Pengarang");
        JLabel lbPenerbit  = new JLabel ("Penerbit");
        JLabel lbTahun     = new JLabel ("Tahun Terbit");

        lbJJ1.setFont(new java.awt.Font("Footlight MT Light",10,25));


        tfID        = new JTextField (30);
        tfJudul     = new JTextField (30);
        tfIsbn      = new JTextField (30);
        tfPengarang = new JTextField (30);
        tfPenerbit  = new JTextField (30);
        tfTahun     = new JTextField (30);
        tfCari		= new JTextField (10);

        btnInsert   = new JButton ("Insert");
        btnUpdate   = new JButton ("Update");
        btnDelete   = new JButton ("Delete");
        btnCari		= new JButton ("Find");
        btnCheck    = new JButton("Check");

        setLayout(null);
        Dimension sizelbJJ1       = lbJJ1.getPreferredSize();
        Dimension sizelbJJ2       = lbJJ2.getPreferredSize();
        Dimension sizelbID        = lbID.getPreferredSize();
        Dimension sizelbJudul     = lbJudul.getPreferredSize();
        Dimension sizelbIsbn      = lbIsbn.getPreferredSize();
        Dimension sizelbPengarang = lbPengarang.getPreferredSize();
        Dimension sizelbPenerbit  = lbPenerbit.getPreferredSize();
        Dimension sizelbTahun     = lbTahun.getPreferredSize();

        Dimension sizetfID        = tfID.getPreferredSize();
        Dimension sizetfJudul     = tfJudul.getPreferredSize();
        Dimension sizetfIsbn      = tfIsbn.getPreferredSize();
        Dimension sizetfPengarang = tfPengarang.getPreferredSize();
        Dimension sizetfPenerbit  = tfPenerbit.getPreferredSize();
        Dimension sizetfTahun     = tfTahun.getPreferredSize();
        Dimension sizetfCari      = tfCari.getPreferredSize();

        Dimension sizebtnInsert   = btnInsert.getPreferredSize();
        Dimension sizebtnUpdate   = btnUpdate.getPreferredSize();
        Dimension sizebtnDelete   = btnDelete.getPreferredSize();
        Dimension sizebtnCari     = btnCari.getPreferredSize();
        Dimension sizebtnCheck     = btnCheck.getPreferredSize();

        lbJJ1.setBounds(210,5, sizelbJJ1.width, sizelbJJ1.height);
        lbJJ2.setBounds(170,25, sizelbJJ2.width, sizelbJJ2.height);
        lbID.setBounds(10,50, sizelbID.width, sizelbID.height);
        lbJudul.setBounds(10,90, sizelbJudul.width, sizelbJudul.height);
        lbIsbn.setBounds(10,130, sizelbIsbn.width, sizelbIsbn.height);
        lbPengarang.setBounds(10,170, sizelbPengarang.width, sizelbPengarang.height);
        lbPenerbit.setBounds(10,210, sizelbPenerbit.width, sizelbPenerbit.height);
        lbTahun.setBounds(10,250, sizelbTahun.width, sizelbTahun.height);


        tfID.setBounds(100,50, sizetfID.width, sizetfID.height);
        tfJudul.setBounds(100,90, sizetfJudul.width, sizetfJudul.height);
        tfIsbn.setBounds(100,130, sizetfIsbn.width, sizetfIsbn.height);
        tfPengarang.setBounds(100,170, sizetfPengarang.width, sizetfPengarang.height);
        tfPenerbit.setBounds(100,210, sizetfPenerbit.width, sizetfPenerbit.height);
        tfTahun.setBounds(100,250, sizetfTahun.width, sizetfTahun.height);
        tfCari.setBounds(200,350, sizetfCari.width, sizetfCari.height);

        btnInsert.setBounds(100,290, sizebtnInsert.width, sizebtnInsert.height);
        btnUpdate.setBounds(195,290, sizebtnUpdate.width, sizebtnUpdate.height);
        btnDelete.setBounds(300,290, sizebtnDelete.width, sizebtnDelete.height);
        btnCari.setBounds(100,350, sizebtnDelete.width, sizebtnDelete.height);
        btnCheck.setBounds(390,290, sizebtnCheck.width, sizebtnCheck.height);

        add(lbJJ1);
        add(lbJJ2);
        add(lbID);
        add(tfID);
        add(lbJudul);
        add(tfJudul);
        add(lbIsbn);
        add(tfIsbn);
        add(lbPengarang);
        add(tfPengarang);
        add(lbPenerbit);
        add(tfPenerbit);
        add(lbTahun);
        add(tfTahun);
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

        setSize(500,500);
        setTitle("Perpustakaan Teknologi Informasi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String args []) throws Exception
    {
        GUIbuku s = new GUIbuku ();
        s.setVisible(true);
    }

    public void insert() throws Exception
    {
        id_buku       = tfID.getText();
        judul_buku    = tfJudul.getText();
        isbn          = tfIsbn.getText();
        pengarang     = tfPengarang.getText();
        penerbit      = tfPenerbit.getText();
        tahun_buku    = tfTahun.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("INSERT INTO tb_buku  VALUES('"+id_buku+"','"+judul_buku+"','"+isbn+"','"+pengarang+"','"+penerbit+"','"+tahun_buku+"')");
        System.out.println("1 row inserted");
    }

    public void update() throws Exception
    {
        id_buku       = tfID.getText();
        judul_buku    = tfJudul.getText();
        isbn          = tfIsbn.getText();
        pengarang     = tfPengarang.getText();
        penerbit      = tfPenerbit.getText();
        tahun_buku    = tfTahun.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("UPDATE tb_buku SET judul_buku  = '"+judul_buku+"', isbn = '"+isbn+"', pengarang = '"+pengarang+"', penerbit = '"+penerbit+"', tahun_buku = '"+tahun_buku+"' WHERE id_buku = '"+id_buku+"'");
        System.out.println("1 row updated");
    }

    public void delete() throws Exception
    {
        id_buku = tfID.getText();
        judul_buku = tfJudul.getText();
        isbn = tfIsbn.getText();
        pengarang = tfPengarang.getText();
        penerbit = tfPenerbit.getText();
        tahun_buku = tfTahun.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("DELETE FROM tb_buku WHERE id_buku = '"+id_buku+"'" );
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
        String sql= "SELECT * FROM tb_buku WHERE id_buku LIKE '"+Cari+"' ";
        System.out.println("1 row searched");
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            tfID.setText(rs.getString(1));
            tfJudul.setText(rs.getString(2));
            tfIsbn.setText(rs.getString(3));
            tfPengarang.setText(rs.getString(4));
            tfPenerbit.setText(rs.getString(5));
            tfTahun.setText(rs.getString(6));


        }

        else {
            JOptionPane.showMessageDialog(panel, "ID " + Cari + " Tidak ditemukan");
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== btnInsert)
        {
            try
            {
                this.insert();
                JOptionPane.showMessageDialog(rootPane, "data berhasil ditambah!" );
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
                    new databuku();
                }
            });
        }

    }

}







