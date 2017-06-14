/**
 * Created by Acer on 11/06/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUIkaryawan extends JFrame implements ActionListener
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
    public String JJ7, JJ8, id_karyawan, nama_karyawan , alamat_karyawan, hp_karyawan;

    public GUIkaryawan()
    {
        setContentPane(new JLabel(new ImageIcon("src/book.jpg")));
        JLabel lbJJ7       = new JLabel ("Data");
        JLabel lbJJ8       = new JLabel ("Karyawan Perpustakaan");
        JLabel lbID        = new JLabel ("ID");
        JLabel lbNama      = new JLabel ("Nama ");
        JLabel lbAlamat    = new JLabel ("Alamat");
        JLabel lbHP        = new JLabel ("No. HP");

        tfID          = new JTextField (25);
        tfNama        = new JTextField (25);
        tfAlamat      = new JTextField (25);
        tfHP          = new JTextField (25);
        tfCari        = new JTextField (10);

        btnInsert     = new JButton ("Insert");
        btnUpdate     = new JButton ("Update");
        btnDelete     = new JButton ("Delete");
        btnCari	      = new JButton ("Find");

        setLayout(null);
        Dimension sizelbJJ7       = lbJJ7.getPreferredSize();
        Dimension sizelbJJ8       = lbJJ8.getPreferredSize();
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

        lbJJ7.setBounds(210,10, sizelbJJ7.width, sizelbJJ7.height);
        lbJJ8.setBounds(160,40, sizelbJJ8.width, sizelbJJ8.height);
        lbID.setBounds(10,80, sizelbID.width, sizelbID.height);
        lbNama.setBounds(10,120, sizelbNama.width, sizelbNama.height);
        lbAlamat.setBounds(10,160, sizelbAlamat.width, sizelbAlamat.height);
        lbHP.setBounds(10,200, sizelbHP.width, sizelbHP.height);

        tfID.setBounds(100,80, sizetfID.width, sizetfID.height);
        tfNama.setBounds(100,120, sizetfNama.width, sizetfNama.height);
        tfAlamat.setBounds(100,160, sizetfAlamat.width, sizetfAlamat.height);
        tfHP.setBounds(100,200, sizetfHP.width, sizetfHP.height);
        tfCari.setBounds(170,300, sizetfCari.width, sizetfCari.height);

        btnInsert.setBounds(100,240, sizebtnInsert.width, sizebtnInsert.height);
        btnUpdate.setBounds(195,240, sizebtnUpdate.width, sizebtnUpdate.height);
        btnDelete.setBounds(300,240, sizebtnDelete.width, sizebtnDelete.height);
        btnCari.setBounds(100,300, sizebtnCari.width, sizebtnCari.height);

        add(lbJJ7);
        add(lbJJ8);
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

        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnCari.addActionListener(this);
        setSize(450,400);
        setTitle("Perpustakaan Teknologi Informasi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String args []) throws Exception
    {
        GUIkaryawan s = new GUIkaryawan ();
        s.setVisible(true);
    }

    public void insert() throws Exception
    {
        id_karyawan      = tfID.getText();
        nama_karyawan    = tfNama.getText();
        alamat_karyawan  = tfAlamat.getText();
        hp_karyawan      = tfHP.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();
        st.executeUpdate("INSERT INTO tb_karyawan  VALUES('"+id_karyawan+"','"+nama_karyawan+"','"+alamat_karyawan+"','"+hp_karyawan+"')");
        System.out.println("1 row inserted");
    }

    public void update() throws Exception
    {
        id_karyawan      = tfID.getText();
        nama_karyawan    = tfNama.getText();
        alamat_karyawan  = tfAlamat.getText();
        hp_karyawan      = tfHP.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();

        st.executeUpdate("UPDATE tb_karyawan SET nama_karyawan = '"+nama_karyawan+"',alamat_karyawan  = '"+alamat_karyawan+"', hp_karyawan = '"+hp_karyawan+"' WHERE id_karyawan = '"+id_karyawan+"'");
        System.out.println("1 row updated");
    }

    public void delete() throws Exception
    {
        id_karyawan      = tfID.getText();
        nama_karyawan    = tfNama.getText();
        alamat_karyawan  = tfAlamat.getText();
        hp_karyawan      = tfHP.getText();

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan","root","");
        st = con.createStatement();

        st.executeUpdate("DELETE FROM tb_karyawan WHERE id_karyawan = '"+id_karyawan+"'" );
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
        String sql= "SELECT * FROM tb_karyawan WHERE id_karyawan LIKE '"+Cari+"' ";
        System.out.println("1 row searched");
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            tfID.setText(rs.getString(1));
            tfNama.setText(rs.getString(2));
            tfAlamat.setText(rs.getString(3));
            tfHP.setText(rs.getString(4));


        }

        else {
            JOptionPane.showMessageDialog(panel, "ID " + Cari + " Tidak ditemukan");
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== btnInsert)
        {
            try{
                this.insert();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil ditambah!" );
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
    }


}
