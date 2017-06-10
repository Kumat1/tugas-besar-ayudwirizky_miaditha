/**
 * Created by HP on 6/11/2017.
 */

import javax.activation.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class FormMainMenu extends JFrame implements ActionListener //implements manggil interface actionlistener
{
    private static JButton btnBuku;
    private static JButton btnMember;
    private static JButton btnPeminjaman;
    private static JButton btnKaryawan;
    private static JButton btnPengembalian;
    public String JJ1, JJ2;

    public FormMainMenu ()
    {
        setContentPane(new JLabel(new ImageIcon("src/book.jpg")));
        JLabel lbJJ1       = new JLabel ("Main Menu");
        JLabel lbJJ2       = new JLabel ("Sistem Informasi Perpustakaan");

        btnBuku            = new JButton ("Buku");
        btnMember   	   = new JButton ("Member");
        btnPeminjaman      = new JButton ("Peminjaman");
        btnKaryawan        = new JButton ("Karyawan");
        btnPengembalian    = new JButton ("Pengembalian");

        setLayout(null);
        Dimension sizelbJJ1       = lbJJ1.getPreferredSize();
        Dimension sizelbJJ2       = lbJJ2.getPreferredSize();

        Dimension sizebtnBuku         = btnBuku.getPreferredSize();
        Dimension sizebtnMember       = btnMember.getPreferredSize();
        Dimension sizebtnPeminjaman   = btnPeminjaman.getPreferredSize();
        Dimension sizebtnKaryawan     = btnKaryawan.getPreferredSize();
        Dimension sizebtnPengembalian = btnPengembalian.getPreferredSize();

        lbJJ1.setBounds(200,10, sizelbJJ1.width, sizelbJJ1.height);
        lbJJ2.setBounds(140,35, sizelbJJ2.width, sizelbJJ2.height);

        btnBuku.setBounds(70,100, sizebtnBuku.width, sizebtnBuku.height);
        btnMember.setBounds(180,100, sizebtnMember.width, sizebtnMember.height);
        btnPeminjaman.setBounds(100,150, sizebtnPeminjaman.width, sizebtnPeminjaman.height);
        btnKaryawan.setBounds(300,100, sizebtnKaryawan.width, sizebtnKaryawan.height);
        btnPengembalian.setBounds(250,150, sizebtnPengembalian.width, sizebtnPengembalian.height);

        add(lbJJ1);
        add(lbJJ2);

        add(btnBuku);
        add(btnMember);
        add(btnPeminjaman);
        add(btnKaryawan);
        add(btnPengembalian);

        btnBuku.addActionListener(this);
        btnMember.addActionListener(this);
        btnPeminjaman.addActionListener(this);
        btnKaryawan.addActionListener(this);
        btnPengembalian.addActionListener(this);

        setLocationRelativeTo(this);
        setSize(530,280);
        setTitle("Perpustakaan Teknologi Informasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String args []) throws Exception
    {
        FormMainMenu s = new FormMainMenu ();
        s.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== btnBuku)
        {
            try
            {
                //form di close - dispose();
                new GUIbuku ().setVisible(true);
            }
            catch (Exception es)
            {
                es.printStackTrace();
            }
        }
        else if(e.getSource()== btnMember)
        {
            try
            {
                //form di close - dispose();
                new GUImember ().setVisible(true);
            }
            catch (Exception es)
            {
                es.printStackTrace();
            }
        }

        else if(e.getSource()== btnPeminjaman)
        {
            try
            {
                //form di close - dispose();
                new GUIpeminjaman ().setVisible(true); //panggil form guipeminjaman
            }
            catch (Exception es)
            {
                es.printStackTrace();
            }
        }
        else if(e.getSource()== btnKaryawan)
        {
            try
            {
                //form di close - dispose();
                new GUIkaryawan ().setVisible(true);
            }
            catch (Exception es)
            {
                es.printStackTrace();
            }
        }
        else if(e.getSource()== btnPengembalian)
        {
            try
            {
                //form di close - dispose();
                new GUIpengembalian ().setVisible(true);
            }
            catch (Exception es)
            {
                es.printStackTrace();
            }
        }
    }
}