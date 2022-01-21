import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tubes extends JFrame{

    private JTextField harga;
    private JTextField jumlah;
    private JTextField totalHarga;
    private JComboBox nama;
    private JTextField totalBayar;
    private JTextField kembalian;
    private JButton bayar;
    private JPanel mainPanel;
    private JButton batal;
    private JButton hitung;
    private int sum;
    private int hasil;

    public void hitung(){
        int JumlahBarang=Integer.parseInt(jumlah.getText());
        int HargaBarang=Integer.parseInt(harga.getText());
        hasil = HargaBarang*JumlahBarang;
        sum += hasil;
        totalHarga.setText((sum+""));
        harga.setText("");
        jumlah.setText("");
        nama.setSelectedIndex(0);
    }

    public void hapus(){
        harga.setText("");
        jumlah.setText("");
        totalHarga.setText("");
        totalBayar.setText("");
        kembalian.setText("");
        nama.setSelectedIndex(0);
    }


    public Tubes(){
        nama.addItem("Pilih Barang");
        nama.addItem("SAPU");
        nama.addItem("KAIN PEL");
        nama.addItem("SABUN");
        nama.addItem("SHAMPOO");
        nama.addItem("SIKAT");
        nama.addItem("EMBER");
        setContentPane(mainPanel);
        setTitle("APLIKASI KASIR TOKO");
        setSize(700,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        bayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int JumlahBayar=Integer.parseInt(totalBayar.getText());
                int JumlahHarga=Integer.parseInt(totalHarga.getText());
                if (JumlahBayar>=JumlahHarga){
                    kembalian.setText(Integer.toString(JumlahBayar-JumlahHarga));
                }
                else {
                    kembalian.setText("Uang Anda Kurang");
                }
            }
        });


        nama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaBarang=(String)nama.getSelectedItem();
                switch (namaBarang){
                    case "SAPU":
                        harga.setText("15000");
                        break;
                    case "KAIN PEL":
                        harga.setText("20000");
                        break;
                    case "SABUN":
                        harga.setText("2000");
                        break;
                    case "SHAMPOO":
                        harga.setText("5000");
                        break;
                    case "SIKAT":
                        harga.setText("7000");
                        break;
                    case "EMBER":
                        harga.setText("10000");
                        break;
                }
            }
        });
        batal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapus();
            }
        });
        hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitung();
            }
        });
    }

    public static void main(String[] args){
        Tubes myFrame = new Tubes();
    }
}
