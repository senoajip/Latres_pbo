package Konsepmvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerPraktikum {

    ModelPraktikum modelpraktikum;
    ViewPraktikum viewpraktikum;

    public ControllerPraktikum(ModelPraktikum modelpraktikum, ViewPraktikum viewpraktikum) {
        this.modelpraktikum = modelpraktikum;
        this.viewpraktikum = viewpraktikum;

        if (modelpraktikum.getBanyakData() != 0) {
            String datacontact[][] = modelpraktikum.readcontact();
            viewpraktikum.tabel.setModel((new JTable(datacontact, viewpraktikum.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewpraktikum.btnUpdatePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nama = viewpraktikum.getNama();
                String No = viewpraktikum.getNo();
                String Umur = viewpraktikum.getUmur();
                String Email = viewpraktikum.getEmail();
                modelpraktikum.update(Nama, No, Umur, Email);

                String data[][] = modelpraktikum.readcontact();
                viewpraktikum.tabel.setModel(new JTable(data, viewpraktikum.namaKolom).getModel());
            }
        });

        viewpraktikum.btnTambahPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                String Nama = viewpraktikum.getNama();
                String No = viewpraktikum.getNo();
                String Umur = viewpraktikum.getUmur();
                String Email = viewpraktikum.getEmail();
                modelpraktikum.insertcontact(Nama, No, Umur, Email);

                String datacontact[][] = modelpraktikum.readcontact();
                viewpraktikum.tabel.setModel(new JTable(datacontact, viewpraktikum.namaKolom).getModel());
            }
        });

        viewpraktikum.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewpraktikum.tabel.getSelectedRow(); 
                int kolom = viewpraktikum.tabel.getSelectedColumn();
                String dataterpilih = viewpraktikum.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelpraktikum.deletecontact(dataterpilih);
                    String datacontact[][] = modelpraktikum.readcontact();
                    viewpraktikum.tabel.setModel(new JTable(datacontact, viewpraktikum.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
