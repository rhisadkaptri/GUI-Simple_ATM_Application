package uas; // package dari class Application.java

// mengimpor kelas
import javax.swing.*; // sebagai syarat penggunaan komponen yang ada dalam system java
import javax.swing.JOptionPane; // untuk membuat dialog seperti message, inputan, dll
import java.awt.event.ActionEvent; // untuk proses deklarasi dari class event yang berisi komponen
import java.awt.event.ActionListener; // untuk proses deklarasi dari class event yang berisi komponen

// deklarasi kelas
public class Application extends javax.swing.JFrame{ // Inheritance dan Encapsulation

    int masukan; // deklarasi variabel masukan
    double hasil,saldo; // deklarasi variabel hasil dan saldo
    String answer; //  deklarasi variabel answer

        public Application() {
            // mendaftarkan listener
            btnCekSaldo.addActionListener(new ActionListener() { //  // ketika di klik Cek Saldo akan muncul message yang beirisi :
                @Override
                public void actionPerformed(ActionEvent e) { // deklarasi ulang metode actionPerformed (overriding)
                    JOptionPane.showMessageDialog(rootPane, "Saldo Anda Saat Ini :" + saldo);
                    // Option pane muncul seperti warning, disini kita akan memunculkan Saldo kita saat ini
                    hasil = saldo;
                    saldo = hasil;
                    answer = String.format(" %,.2f ", saldo); // saldo akan dimulculkan dengan 2 angka dibelakang koma
                    jtxtTampil.setText(answer); // menampilkan saldo
                }
            });
            // mendaftarkan listener
            btnSimpan.addActionListener(new ActionListener() { // ketika di klik Setor Tunai akan muncul Inputan :
                @Override
                public void actionPerformed(ActionEvent e) { // deklarasi ulang metode actionPerformed (overriding)
                    masukan = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nominal : ")); // masukkan nominal yang mau di setor
                    JOptionPane.showMessageDialog(rootPane,"Saldo Anda Saat Ini :"+ (saldo + masukan)); // kemudian akan muncul jumlah saldo keseluruhan
                    hasil = saldo + masukan; // rumus dari seluruh saldo
                    saldo = hasil;
                    answer = String.format(" %,.2f ",saldo);
                    jtxtTampil.setText(answer); // menampilkan saldo
                }
            });
            btnTransfer.addActionListener(new ActionListener() { // ketika di klik Transfer akan muncul Inputan :
                @Override
                public void actionPerformed(ActionEvent e) { // deklarasi ulang metode actionPerformed (overriding)
                    String nama2=JOptionPane.showInputDialog("Silahkan Masukkan No Rekening : "); // memasukkan no rekening yang ingin di transfer
                    String nama3=JOptionPane.showInputDialog("Silahkan Masukkan Nama Penerima : "); // memasukkan nama penerima
                    masukan = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nominal : ")); // memasukkan jumlah nominal yang ingin di transfer

                    try { // fungsi try untuk mengurung eksekusi yang menampilkan eror
                        if (saldo <= masukan) { // jika saldo lebih kecil dari nominal yang ingin di transfer, maka akan muncul :
                            JOptionPane.showMessageDialog(rootPane, "Maaf Saldo anda tidak cukup !"); // sebuah warning
                            JOptionPane.showMessageDialog(rootPane, "Tambahkan Saldo Rekening Anda Terlebih Dahulu!"); // sebuh warning
                            System.exit(0); // maka akan langsung keluar
                        }
                        else if (saldo >= masukan) { // jika saldo lebih besar dari nominal yang ingin di transfer, maka :
                        }
                    }
                    catch (Exception ex) { // fungsi catch
                    }
                    hasil = saldo - masukan; // saldo akan berkurang sebanyak yang sudah di transfer
                    saldo = hasil;
                    answer = String.format(" %,.2f ", hasil);
                    jtxtTampil.setText(answer); // menampilkan hasil dari saldo yang sudah berkurang
                    // kemudian akan di tampilkan pesan warning jumlah saldo sekarang dan Berhasil transfer ke (nama penerima)
                    JOptionPane.showMessageDialog(rootPane,"Saldo Anda Saat Ini : "+ saldo+ "\n"+ "Berhasil transfer kepada "+nama3+" sebesar : "+ masukan);
                }
            });
            btnAmbil.addActionListener(new ActionListener() { // ketika di klik penarikan akan muncul Inputan :
                @Override
                public void actionPerformed(ActionEvent e) { // deklarasi ulang metode actionPerformed (overriding)
                    masukan = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nominal : ")); // nominal yang mau di ambil
                    hasil = saldo - masukan; // saldo akan berkurang sebanyak yang sudah di ambil
                    saldo=hasil;
                    answer = String.format(" %,.2f ", hasil);
                    jtxtTampil.setText(answer); // menampilkan hasil dari saldo yang sudah berkurang
                    // kemudian akan di tampilkan pesan warning jumlah saldo sekarang
                    JOptionPane.showMessageDialog(rootPane,"Saldo Anda Saat Ini :"+ saldo+ "\n");
                }
            });
            btnKeluar.addActionListener(new ActionListener() { // ketika di klik keluar
                @Override
                public void actionPerformed(ActionEvent e) { // deklarasi ulang metode actionPerformed (overriding)
                    System.exit(0); // maka akan langsung keluar dari aplikasi gui nya
                }
            });
            btnHapus.addActionListener(new ActionListener() { // ketika di klik hapus
                @Override
                public void actionPerformed(ActionEvent e) { // deklarasi ulang metode actionPerformed (overriding)
                    jtxtTampil.setText(""); // maka akan mengapus inputan yang ada di teks field jTxtTampil
                }
            });
        }

    public static void main(String[] args) { // Metode main
        JFrame frame = new JFrame("Application");
        frame.setContentPane(new Application().AppPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // pernyataan untuk mendesain interface grafis (form aplikasi)
    private JPanel AppPanel;
    private JButton btnCekSaldo;
    private JButton btnSimpan;
    private JButton btnTransfer;
    private JTextPane SELAMATDATANGDIATMTextPane;
    private JTextPane PILIHTRANSAKSIYANGANDATextPane;
    private JButton btnAmbil;
    private JButton btnKeluar;
    private JTextField jtxtTampil;
    private JButton btnHapus;
}
