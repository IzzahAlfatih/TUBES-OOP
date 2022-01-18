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


    public Tubes(){
        nama.addItem("Pilih Barang");
        nama.addItem("TELEVISI");
        nama.addItem("KOMPUTER");
        nama.addItem("LAPTOP");
        nama.addItem("DISPENSER");
        nama.addItem("KOMPOR");
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
                    case "TELEVISI":
                        harga.setText("3000000");
                        break;
                    case "KOMPUTER":
                        harga.setText("4000000");
                        break;
                    case "LAPTOP":
                        harga.setText("5000000");
                        break;
                    case "DISPENSER":
                        harga.setText("1000000");
                        break;
                    case "KOMPOR":
                        harga.setText("500000");
                        break;
                }
            }
        });
        batal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                harga.setText("");
                jumlah.setText("");
                totalHarga.setText("");
                totalBayar.setText("");
                kembalian.setText("");
                nama.setSelectedIndex(0);
            }
        });
        hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int JumlahBarang=Integer.parseInt(jumlah.getText());
                int HargaBarang=Integer.parseInt(harga.getText());
                totalHarga.setText(Integer.toString(HargaBarang*JumlahBarang));
            }
        });
    }

    public static void main(String[] args){
        Tubes myFrame = new Tubes();
    }
}
