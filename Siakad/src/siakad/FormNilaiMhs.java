/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package siakad;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ACER
 */
public class FormNilaiMhs extends javax.swing.JFrame {

    DefaultTableModel tabel1;
    Object[] list_mhs = new Object[9];
    int x = 0; //ini untuk nomor urut ascending
    DBConnection dbconn = new DBConnection();
    Connection con = (Connection) dbconn.getConnection();
    
    public FormNilaiMhs() throws SQLException {
        initComponents();
        
        tabel1 = new DefaultTableModel();
        tabel.setModel(tabel1);//tabel nama tabel GUI
        //siapkan array yang akan dimasukkan ke tabel 
        tabel1.addColumn("No"); tabel1.addColumn("Nim");
        tabel1.addColumn("No"); tabel1.addColumn("Uts 35%");
        tabel1.addColumn("Uas 35%"); tabel1.addColumn("Tugas 30%");
        tabel1.addColumn("N. Akhir"); tabel1.addColumn("N. Huruf");
        tabel1.addColumn("Predikat"); //tambahan
        
        setResizable(false); //tidak bisa diperbesar
        
        //tidak bisa diketik
        nUTS1.setEditable(false); nUAS1.setEditable(false); nTugas1.setEditable(false);
        nUTS2.setEditable(false); nUAS2.setEditable(false); nTugas2.setEditable(false);
        
        //tidak bisa diklik
        simpan.setEnabled(false);
        update.setEnabled(false);
        Hapus.setEnabled(false);
        proses1.setEnabled(false);
        
        tampilkanDiTabel();
    }
    
    public ArrayList[] getMhsList() throws SQLException{
        //tujuan mendapatkan data dari database dan disimpan di arratList
        String queryCount = "SELECT COUNT(*) AS c FROM mhs";
        Statement st;
        ResultSet rsCount, rs;
        st = con.createStatement();
        rsCount = st.executeQuery(queryCount);
        int sizeTable = 0;
        while(rsCount.next()){
            sizeTable =rsCount.getInt("c");
            //panggil alias c dari querycount
        }
        ArrayList[] mhsList = new ArrayList[sizeTable];
        //membuat array dengan size sebanyak data di database.
        
        String query = "SELECT * FROM mhs";
        rs = st.executeQuery(query);
        int x=0;
        while(rs.next()){
            mhsList[x] = new ArrayList<>();
            mhsList[x].add(rs.getString("nim")); mhsList[x].add(rs.getString("nama"));
            mhsList[x].add(rs.getString("nilai_uts")); mhsList[x].add(rs.getString("nilai_uas"));
            mhsList[x].add(rs.getString("nilai_tugas")); mhsList[x].add(rs.getString("nilai_akhir"));
            mhsList[x].add(rs.getString("nilai_huruf")); mhsList[x].add(rs.getString("predikat"));
            x++;
        }
        return mhsList;
    }
    public void tampilkanDiTabel() throws SQLException{
        ArrayList[] list = getMhsList();
        //sebelum lanjut, buat fungsi getMhsList dulu
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        
        Object[] row = new Object[9];
        for(int i=0; i<list.length; i++){
            row[0] = i+1;
            row[0] = list[i].get(0); row[2] = list[i].get(1);
            row[3] = list[i].get(2); row[4] = list[i].get(3);
            row[5] = list[i].get(4); row[6] = list[i].get(5);
            row[7] = list[i].get(6); row[8] = list[i].get(7);
            
            model.addRow(row);
        }
    }
    
    public void kosongkanTextField(){
        nim.setText(""); nama.setText("");
        nUTS.setText(""); nUAS.setText(""); nTugas.setText("");
        nUTS1.setText(""); nUAS1.setText(""); nTugas1.setText("");
        nUTS2.setText(""); nUAS2.setText(""); nTugas2.setText("");
    }
    public void prosesHitungNilai(){
        try {
            String ni = nim.getText();
            String na = nama.getText();
            Double ts = Double.parseDouble(nUTS.getText());
            Double as = Double.parseDouble(nUAS.getText());
            Double tgs = Double.parseDouble(nTugas.getText());

            Mhs m = new Mhs(ni, na, ts, as, tgs);
            nUTS1.setText(""+m.uts()); nUAS1.setText(""+m.uas());
            //m.uts() kan double, sedangkan textfield itu String
            //maka diberi " agar terdetek String
            nTugas1.setText(""+m.tugas());
            nUTS2.setText(""+m.nilaiAkhir()); 
            nUAS2.setText(""+m.getNilHuruf(m.nilaiAkhir()));
            nTugas2.setText(""+m.getPredikat(m.getNilHuruf(m.nilaiAkhir())));
            simpan.setEnabled(true);
        }catch(NumberFormatException e){
            //jika ada textfield yang belum terisi
            JOptionPane.showMessageDialog(null, "Inputan anda kosong", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void kosongkanTabel(){
        DefaultTableModel model = (DefaultTableModel)this.tabel.getModel();
        model.setRowCount(0);
    }
    public void terpilih(int index) throws SQLException{
        ArrayList[] list = getMhsList();
        nim.setText((String) list[index].get(0));
        nama.setText((String) list[index].get(1));
        nUTS.setText((String) list[index].get(2).toString());
        nUAS.setText((String) list[index].get(3).toString());
        nTugas.setText((String) list[index].get(4).toString());
        
        proses.setEnabled(false);
        simpan.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nUTS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nUAS = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nTugas = new javax.swing.JTextField();
        proses = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        tambahLain = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        proses1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        nUTS1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nUAS1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nTugas1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nUTS2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nUAS2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        nTugas2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FormNilaiMahasiswa");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Niai Mahasiswa");

        jLabel2.setText("NIM");

        jLabel3.setText("Nama");

        jLabel4.setText("Nilai UTS");

        jLabel5.setText("NIlai UAS");

        jLabel6.setText("Nilai Tugas");

        proses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_intelligence_50px.png"))); // NOI18N
        proses.setText("Proses");
        proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesActionPerformed(evt);
            }
        });

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_downloading_updates_50px_2.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        tambahLain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_add_50px.png"))); // NOI18N
        tambahLain.setText("Tambah Lain");
        tambahLain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahLainActionPerformed(evt);
            }
        });

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_export_50px.png"))); // NOI18N
        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        proses1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_intelligence_50px.png"))); // NOI18N
        proses1.setText("Proses");
        proses1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proses1ActionPerformed(evt);
            }
        });

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_refresh_50px.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_trash_50px_1.png"))); // NOI18N
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        jLabel7.setText("UTS 35%");

        jLabel8.setText("UAS 35%");

        jLabel9.setText("Tugas 30%");

        jLabel10.setText("NIlai Akhir");

        jLabel11.setText("Nilai Huruf");

        jLabel12.setText("Predikat");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIMahasiswaIcon/icons8_export_50px.png"))); // NOI18N
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(289, 289, 289))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(proses1)
                                .addGap(63, 63, 63)
                                .addComponent(update)
                                .addGap(18, 18, 18)
                                .addComponent(Hapus))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(proses)
                                .addGap(18, 18, 18)
                                .addComponent(simpan)
                                .addGap(18, 18, 18)
                                .addComponent(tambahLain)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keluar)
                            .addComponent(cetak))))
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nUTS2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nUAS2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proses)
                    .addComponent(simpan)
                    .addComponent(tambahLain)
                    .addComponent(keluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proses1)
                    .addComponent(update)
                    .addComponent(Hapus)
                    .addComponent(cetak))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(nTugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nUTS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(nUAS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO mhs(nim,nama,nilai_uts,nilai_uas,nilai_tugas,nilai_akhir,nilai_huruf,predikat) values(?,?,?,?,?,?,?,?) ");
            ps.setString(1, nim.getText()); ps.setString(2, nama.getText());
            ps.setString(3, nUTS.getText()); ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText()); ps.setString(6, nUTS2.getText()); 
            ps.setString(7, nUAS2.getText()); ps.setString(8, nTugas2.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data tersimpan");
        } catch (SQLException ex) {
            Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data tidak tersimpan");
        }
        try {
            kosongkanTextField();
            kosongkanTabel();
            tampilkanDiTabel();
        } catch (SQLException ex) {
            Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesActionPerformed
        prosesHitungNilai();
    }//GEN-LAST:event_prosesActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void proses1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proses1ActionPerformed
        prosesHitungNilai();
        update.setEnabled(true);
        simpan.setEnabled(false);
    }//GEN-LAST:event_proses1ActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int index = tabel.getSelectedRow();
        try {
            terpilih(index);
        } catch (SQLException ex) {
            Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
        proses1.setEnabled(true);
        Hapus.setEnabled(true);
    }//GEN-LAST:event_tabelMouseClicked

    private void tambahLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahLainActionPerformed
        kosongkanTextField();
        proses.setEnabled(true);
        
        nUTS1.setEditable(false); nUAS1.setEditable(false); nTugas1.setEditable(false);
        nUTS2.setEditable(false);nTugas2.setEditable(false); nUAS2.setEditable(false);
        
        simpan.setEnabled(false); update.setEnabled(false);
        Hapus.setEnabled(false); proses1.setEnabled(false);
    }//GEN-LAST:event_tambahLainActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String updateQuery = null;
        PreparedStatement ps = null;
        
        updateQuery = "UPDATE mhs SET nim=?, nama=?, nilai_uts=?, nilai_uas=?, nilai_tugas=?, nilai_akhir=?, nilai_huruf=?, predikat=? WHERE nim=?";
        
        try {
            ps = (PreparedStatement) con.prepareStatement(updateQuery);
            ps.setString(1, nim.getText()); ps.setString(2, nama.getText());
            ps.setString(3, nUTS.getText()); ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText()); 
            ps.setString(6, nUTS2.getText()); ps.setString(7, nUAS2.getText());
            ps.setString(8, nTugas2.getText());
            ps.setString(9, nim.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diUpdate");
        } catch (SQLException ex) {
            Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diUpdate");
        }
        
        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM mhs WHERE nim=?");
            ps.setString(1, nim.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
        
        kosongkanTextField();
        kosongkanTabel();
        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_HapusActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        JasperReport reports;
        
        String path = ".\\src\\siakad\\reportMhs.jasper";
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, con);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cetakActionPerformed

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
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormNilaiMhs().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormNilaiMhs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nTugas;
    private javax.swing.JTextField nTugas1;
    private javax.swing.JTextField nTugas2;
    private javax.swing.JTextField nUAS;
    private javax.swing.JTextField nUAS1;
    private javax.swing.JTextField nUAS2;
    private javax.swing.JTextField nUTS;
    private javax.swing.JTextField nUTS1;
    private javax.swing.JTextField nUTS2;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JButton proses;
    private javax.swing.JButton proses1;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambahLain;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
