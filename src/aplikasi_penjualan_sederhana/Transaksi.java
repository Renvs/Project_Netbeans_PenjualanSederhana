/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi_penjualan_sederhana;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi extends javax.swing.JFrame {

    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public Transaksi() {
        initComponents();
        k.connect();
        refreshTable();
        refreshCombo();
    }
    
    class transaksi extends Transaksi{
        int id_transaksi, id_barang, harga, jumlah_beli, total_harga;
        String nama_pelanggan, tanggal, nama_barang;
        
        public transaksi(){
            this.nama_pelanggan = text_nama_pelanggan.getText();
            String combo = combo_id_barang.getSelectedItem().toString();
            String[] arr = combo.split(":");
            this.id_barang = Integer.parseInt(arr[0].trim());
            try{
                Date date = text_tanggal.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal = dateformat.format(date);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            this.nama_barang = arr[1].trim();
            this.harga = Integer.parseInt(arr[2].trim());
            this.jumlah_beli = Integer.parseInt(text_jumlah_beli.getText().trim());
            this.total_harga = this.harga*this.jumlah_beli;
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Barang");
        model.addColumn("Tanggal");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        tabel_transaksi.setModel(model);
        
        try{
            this.stat = k.getCon().prepareStatement("SELECT * FROM transaksi");
            this.rs = this.stat.executeQuery();
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            
        }
        
        text_id_transaksi.setText("");
        text_nama_pelanggan.setText("");
        text_jumlah_beli.setText("");
        text_total_bayar.setText("");
    }
    
    public void refreshCombo(){
        try{
            this.stat = k.getCon().prepareStatement("SELECT * FROM barang WHERE status='Tersedia'");
            this.rs = this.stat.executeQuery();
            while(rs.next()){
                combo_id_barang.addItem(rs.getString("id_barang")+" : "+rs.getString("nama_barang")+" : "+rs.getString("harga"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        input_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tabel_log = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        text_nama_pelanggan = new javax.swing.JTextField();
        text_id_transaksi = new javax.swing.JTextField();
        text_total_bayar = new javax.swing.JTextField();
        text_jumlah_beli = new javax.swing.JTextField();
        cetakLaporan_btn = new javax.swing.JButton();
        combo_id_barang = new javax.swing.JComboBox<>();
        lihatBarang_btn = new javax.swing.JButton();
        text_tanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logout_btn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        logout_btn.setForeground(new java.awt.Color(51, 51, 51));
        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        delete_btn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        delete_btn.setForeground(new java.awt.Color(51, 51, 51));
        delete_btn.setText("DELETE");
        delete_btn.setToolTipText("");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        update_btn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        update_btn.setForeground(new java.awt.Color(51, 51, 51));
        update_btn.setText("UPDATE");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        input_btn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        input_btn.setForeground(new java.awt.Color(51, 51, 51));
        input_btn.setText("INPUT");
        input_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel1.setText("NAMA PELANGGAN");

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel5.setText("ID BARANG");

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel6.setText("JUMLAH BELI");

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel2.setText("ID TRANSAKSI");

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel4.setText("TANGGAL");

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel7.setText("TOTAL BAYAR");

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        jLabel3.setText("TRANSAKSI");

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_transaksiMouseClicked(evt);
            }
        });
        tabel_log.setViewportView(tabel_transaksi);

        text_nama_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nama_pelangganActionPerformed(evt);
            }
        });

        text_id_transaksi.setEditable(false);
        text_id_transaksi.setEnabled(false);

        text_total_bayar.setEditable(false);
        text_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_total_bayarActionPerformed(evt);
            }
        });

        cetakLaporan_btn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cetakLaporan_btn.setForeground(new java.awt.Color(51, 51, 51));
        cetakLaporan_btn.setText("CETAK LAPORAN");
        cetakLaporan_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakLaporan_btnActionPerformed(evt);
            }
        });

        combo_id_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_id_barangActionPerformed(evt);
            }
        });

        lihatBarang_btn.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lihatBarang_btn.setText("LIHAT BARANG");
        lihatBarang_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatBarang_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tabel_log, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(input_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update_btn)
                            .addGap(131, 131, 131)
                            .addComponent(delete_btn))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(194, 194, 194)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logout_btn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(text_id_transaksi)
                                .addComponent(text_nama_pelanggan)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(combo_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lihatBarang_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(text_jumlah_beli)
                                        .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(1, 1, 1))))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cetakLaporan_btn)
                .addGap(214, 214, 214))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(logout_btn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combo_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lihatBarang_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(text_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(text_jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_btn)
                    .addComponent(update_btn)
                    .addComponent(delete_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabel_log, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cetakLaporan_btn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void cetakLaporan_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakLaporan_btnActionPerformed
        try{
            String namafile   = "D:\\Lukman\\SMKN 4\\DPKK\\PBTGM\\Coding\\lib\\cetakLaporan.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(namafile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, k.getCon());
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cetakLaporan_btnActionPerformed

    private void text_nama_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nama_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nama_pelangganActionPerformed

    private void text_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_total_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_total_bayarActionPerformed

    private void input_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_btnActionPerformed
        try{
            transaksi tr = new transaksi();
            text_total_bayar.setText(""+tr.total_harga);
            this.stat =k.getCon().prepareStatement("INSERT INTO transaksi VALUES(?,?,?,?,?,?,?,?)");
            this.stat.setInt(1, 0);
            this.stat.setString(2, tr.nama_pelanggan);
            this.stat.setInt(3, tr.id_barang);
            this.stat.setString(4, tr.tanggal);
            this.stat.setString(5, tr.nama_barang);
            this.stat.setInt(6, tr.harga);
            this.stat.setInt(7, tr.jumlah_beli);
            this.stat.setInt(8, tr.total_harga);
            
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Tanggal: "+tr.tanggal+
                    "\nNama Pelanggan: "+tr.nama_pelanggan+
                    "\nPembelian: "+tr.jumlah_beli+" "+tr.nama_barang+
                    "\nTotal Bayar: "+tr.total_harga+"\n",
                    "Tambahkan Transaksi?",
                    JOptionPane.YES_NO_OPTION);
            if(pilihan == JOptionPane.YES_OPTION){
                this.stat.executeUpdate();
                refreshTable();
            } else if(pilihan == JOptionPane.NO_OPTION){
                refreshTable();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_input_btnActionPerformed

    private void tabel_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_transaksiMouseClicked
        text_id_transaksi.setText(model.getValueAt(tabel_transaksi.getSelectedRow(), 0) .toString());
        text_nama_pelanggan.setText(model.getValueAt(tabel_transaksi.getSelectedRow(), 1) .toString());
        text_jumlah_beli.setText(model.getValueAt(tabel_transaksi.getSelectedRow(), 6) .toString());
        text_total_bayar.setText(model.getValueAt(tabel_transaksi.getSelectedRow(), 7) .toString());
    }//GEN-LAST:event_tabel_transaksiMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        try{
            transaksi tr = new transaksi();
            tr.id_transaksi = Integer.parseInt(text_id_transaksi.getText());
            this.stat = k.getCon().prepareStatement("UPDATE transaksi SET nama_pelanggan=?, id_barang=?, tanggal=?, nama_barang=?, harga=?, jumlah_beli=?, total_harga=? WHERE id_transaksi=? ");
            this.stat.setString(1, tr.nama_pelanggan);
            this.stat.setInt(2, tr.id_barang);
            this.stat.setString(3, tr.tanggal);
            this.stat.setString(4, tr.nama_barang);
            this.stat.setInt(5, tr.harga);
            this.stat.setInt(6, tr.jumlah_beli);
            this.stat.setInt(7, tr.total_harga);
            this.stat.setInt(8, tr.id_transaksi);
            refreshTable();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try{
            transaksi tr = new transaksi();
            tr.id_transaksi = Integer.parseInt(text_id_transaksi.getText());
            this.stat = k.getCon().prepareStatement("DELETE FROM transaksi WHERE id_transaksi=?");
            this.stat.setInt(1, tr.id_transaksi);
            this.stat.executeUpdate();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void lihatBarang_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatBarang_btnActionPerformed
        Barang bar = new Barang();
        bar.setVisible(true);
        this.setVisible(false);
        bar.input_btn.setEnabled(true);
        bar.delete_btn.setEnabled(true);
        bar.update_btn.setEnabled(true);
        bar.menuRegister_btn.setEnabled(true);
    }//GEN-LAST:event_lihatBarang_btnActionPerformed

    private void combo_id_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_id_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_id_barangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cetakLaporan_btn;
    private javax.swing.JComboBox<String> combo_id_barang;
    public javax.swing.JButton delete_btn;
    public javax.swing.JButton input_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton lihatBarang_btn;
    private javax.swing.JButton logout_btn;
    private javax.swing.JScrollPane tabel_log;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JTextField text_id_transaksi;
    private javax.swing.JTextField text_jumlah_beli;
    private javax.swing.JTextField text_nama_pelanggan;
    private com.toedter.calendar.JDateChooser text_tanggal;
    private javax.swing.JTextField text_total_bayar;
    public javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
