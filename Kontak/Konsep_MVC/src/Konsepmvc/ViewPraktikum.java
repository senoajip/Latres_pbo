
package Konsepmvc;
 
import java.awt.Color;
import static java.awt.SystemColor.window;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewPraktikum extends JFrame 
{
    
    JLabel lNama = new JLabel("Nama : ");
    JTextField tfNama = new JTextField();
    JLabel lNo = new JLabel ("No HP  : ");
    JTextField tfNo = new JTextField();
    JLabel lUmur = new JLabel ("Umur : ");
    JTextField tfUmur = new JTextField();
    JLabel lEmail = new JLabel ("Email : ");
    JTextField tfEmail = new JTextField();
    
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnUpdatePanel = new JButton("Update");
      
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;  //buat scroll
    Object namaKolom[] = {"Nama","No","Umur","Email"}; //membuat kolom dalam array
        
    public ViewPraktikum(){
            
        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel); 
        scrollPane = new JScrollPane(tabel);

            
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 500);
        //TABEL
        add(scrollPane);
        scrollPane.setBounds(20, 145, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);    
        add(lNama);
        lNama.setBounds(5, 5, 90, 20);
        add(tfNama);
        tfNama.setBounds(110, 5, 120, 20);

        add(lNo);
        lNo.setBounds(5, 30, 90, 20);
        add(tfNo);
        tfNo.setBounds(110, 30, 120, 20);

        add(lUmur);
        lUmur.setBounds(5, 55, 90, 20);
        add(tfUmur);
        tfUmur.setBounds(110, 55, 120, 20);

        add(lEmail);
        lEmail.setBounds(5, 80, 90, 20);
        add(tfEmail);
        tfEmail.setBounds(110, 80, 120, 20);

        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 105, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);
        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(230, 105, 90, 20);
        
}
        public String getNama()
        {
            return tfNama.getText();
        }
        
        public String getNo()
        {
            return tfNo.getText();
        }
        
        public String getUmur()
        {
            return tfUmur.getText();
        }

        public String getEmail()
        {
            return tfEmail.getText();
        }
}

