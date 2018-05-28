
package GUI;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



public class Home extends javax.swing.JFrame {
    private Connection con=null;
    private ResultSet rs=null;// s2
    private PreparedStatement pst=null; //โชว์ข้อมูล s1
    public Home() {
        con=SQL.connect();
        initComponents();
        
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
        Show_data_Customer();
        //**
         Cutomer_add c=new Cutomer_add();
        
         update1.hide();
    
    }
     public void Show_data_Customer(){
           SQL S=new SQL();  
        try {
            Connection con =S.connect();
            String sql="SELECT CUSTOMER.*,CUSTOMER_ADDRESS.ADDRESS,CUSTOMER_NPHONE.NUMBERPHONE,RELATIVE_NPHONE.RELATIVE_NPHONE \n" +
"FROM CUSTOMER INNER JOIN CUSTOMER_ADDRESS ON(CUSTOMER.ID=CUSTOMER_ADDRESS.ID)\n" +
"INNER JOIN CUSTOMER_NPHONE ON(CUSTOMER.ID=CUSTOMER_NPHONE.ID)\n" +
"INNER JOIN RELATIVE_NPHONE ON(CUSTOMER.ID=RELATIVE_NPHONE.ID)";
             ResultSet rs =con.createStatement().executeQuery(sql);
             int row=0;
           while (rs.next()) {                
                 Table_Customer.setValueAt(rs.getString(1), row, 0);//รหัส
                 Table_Customer.setValueAt(rs.getString(2), row, 1);//นาย
                 Table_Customer.setValueAt(rs.getString(3), row, 2);//ชื่อ
                 Table_Customer.setValueAt(rs.getString(4), row, 3);//นามสกุล
                 Table_Customer.setValueAt(rs.getString(5), row, 4);//เพศ
                 Table_Customer.setValueAt(rs.getString(6), row, 5);//เลขปปช
                 Table_Customer.setValueAt(rs.getString(7).substring(0, 9), row, 6);//ที่อยู่
                 Table_Customer.setValueAt(rs.getString(8), row, 7);//วันเดือนปีเกิด
                 Table_Customer.setValueAt(rs.getString(9), row, 8);//อายุ
                 Table_Customer.setValueAt(rs.getString(10), row, 9);//เบอร์
                 Table_Customer.setValueAt(rs.getString(11), row, 10);//เบอรญาติ
              row++;
           }
           
        }catch(Exception e){
            System.out.println(e);
        }
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        T01 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        T2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        T3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        T4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Customer = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        T5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        T6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        update1 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("หอพักอันนา");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 270, 50));

        jLabel3.setFont(new java.awt.Font("JasmineUPC", 3, 55)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ระบบบริหารจัดการ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 370, 66));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 50, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 220));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Room_104px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 153, 255));
        jLabel5.setText("จองห้องพัก");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 230, 200));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Rent_104px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setText("เช่าห้องพัก");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Home_104px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 255));
        jLabel9.setText("ข้อมูลห้องพัก");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_User_Account_104px_1.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 153, 255));
        jLabel11.setText("ข้อมูลลูกค้า");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Money_Bag_104px.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 153, 255));
        jLabel15.setText("ชำระค่าหอพัก");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Coins_104px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setText("ข้อมูลค่าใช้จ่าย");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, -1, -1));

        Home.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T01.setBackground(new java.awt.Color(255, 255, 255));
        T01.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("หอพักอันนา");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 140, 30));

        jLabel17.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("ระบบบริหารจัดการ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Left_104px.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 90));

        jLabel20.setFont(new java.awt.Font("JasmineUPC", 1, 54)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("จองห้องพัก");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 220, 60));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 50));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Room_104px_1.png"))); // NOI18N
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 100));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ย้อนกลับ");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        jPanel8.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 140));

        T01.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T01.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        getContentPane().add(T01, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T2.setBackground(new java.awt.Color(255, 255, 255));
        T2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("หอพักอันนา");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 140, 30));

        jLabel37.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("ระบบบริหารจัดการ");
        jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Left_104px.png"))); // NOI18N
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 90));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 50));

        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("ย้อนกลับ");
        jPanel3.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, -1));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Rent_104px_1.png"))); // NOI18N
        jPanel3.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 100));

        jLabel73.setFont(new java.awt.Font("JasmineUPC", 1, 54)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("เช่าห้องพัก");
        jPanel3.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 220, 60));

        jPanel15.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 140));

        T2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        jPanel16.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        getContentPane().add(T2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T3.setBackground(new java.awt.Color(255, 255, 255));
        T3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ระบบบริหารจัดการ");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Left_104px.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 90));

        jLabel33.setFont(new java.awt.Font("JasmineUPC", 1, 54)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("ข้อมูลห้องพัก");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 240, 60));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 50));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Home_104px_1.png"))); // NOI18N
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 100));

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("ย้อนกลับ");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        jLabel66.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("หอพักอันนา");
        jPanel5.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 140, 30));

        T3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 140));

        getContentPane().add(T3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T4.setBackground(new java.awt.Color(255, 255, 255));
        T4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("JasmineUPC", 1, 24))); // NOI18N
        T4.setForeground(new java.awt.Color(0, 102, 255));
        T4.setMaximumSize(new java.awt.Dimension(100, 100));
        T4.setMinimumSize(new java.awt.Dimension(115, 180));
        T4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("ระบบบริหารจัดการ");
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Left_104px.png"))); // NOI18N
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 90));

        jLabel40.setFont(new java.awt.Font("JasmineUPC", 1, 54)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("ข้อมูลลูกค้า");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 220, 60));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 50));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_User_Account_104px_2.png"))); // NOI18N
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 100));

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("ย้อนกลับ");
        jPanel6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        jLabel67.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("หอพักอันนา");
        jPanel6.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 140, 30));

        T4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 140));

        Table_Customer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Table_Customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "รหัสลูกค้า", "คำนำหน้า", "ชื่อ", "นามสกุล", "เพศ", "เลขบัตรประชาชน", "วันเดือนปีเกิด", "อายุ", "ที่อยู่", "เบอร์โทรศัพท์", "เบอร์โทรศัพท์ญาติ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Customer.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Table_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_CustomerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_Customer);
        if (Table_Customer.getColumnModel().getColumnCount() > 0) {
            Table_Customer.getColumnModel().getColumn(0).setResizable(false);
            Table_Customer.getColumnModel().getColumn(0).setPreferredWidth(60);
            Table_Customer.getColumnModel().getColumn(1).setResizable(false);
            Table_Customer.getColumnModel().getColumn(1).setPreferredWidth(30);
            Table_Customer.getColumnModel().getColumn(2).setResizable(false);
            Table_Customer.getColumnModel().getColumn(2).setPreferredWidth(100);
            Table_Customer.getColumnModel().getColumn(3).setResizable(false);
            Table_Customer.getColumnModel().getColumn(3).setPreferredWidth(100);
            Table_Customer.getColumnModel().getColumn(4).setResizable(false);
            Table_Customer.getColumnModel().getColumn(4).setPreferredWidth(10);
            Table_Customer.getColumnModel().getColumn(5).setResizable(false);
            Table_Customer.getColumnModel().getColumn(5).setPreferredWidth(90);
            Table_Customer.getColumnModel().getColumn(6).setResizable(false);
            Table_Customer.getColumnModel().getColumn(6).setPreferredWidth(62);
            Table_Customer.getColumnModel().getColumn(7).setResizable(false);
            Table_Customer.getColumnModel().getColumn(7).setPreferredWidth(10);
            Table_Customer.getColumnModel().getColumn(8).setResizable(false);
            Table_Customer.getColumnModel().getColumn(8).setPreferredWidth(150);
            Table_Customer.getColumnModel().getColumn(9).setResizable(false);
            Table_Customer.getColumnModel().getColumn(10).setResizable(false);
        }

        T4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1110, 560));

        jPanel14.setBackground(new java.awt.Color(0, 102, 255));
        jPanel14.setForeground(new java.awt.Color(0, 102, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ลบข้อมูลลูกค้า");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 120, 28));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic/icons8_Trash_Can_45px.png"))); // NOI18N
        jPanel14.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 60));

        T4.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 190, 60));

        jPanel26.setBackground(new java.awt.Color(0, 102, 255));
        jPanel26.setForeground(new java.awt.Color(0, 102, 255));
        jPanel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel26MouseClicked(evt);
            }
        });
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("เพิ่มข้อมูลลูกค้า");
        jPanel26.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 28));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic/icons8_Add_User_Male_45px_2.png"))); // NOI18N
        jPanel26.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 60));

        T4.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 200, 60));

        jPanel27.setBackground(new java.awt.Color(0, 102, 255));
        jPanel27.setForeground(new java.awt.Color(0, 102, 255));
        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
        });
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("แก้ไขข้อมูลลูกค้า");
        jPanel27.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 28));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic/icons8_Available_Updates_45px.png"))); // NOI18N
        jPanel27.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 60));

        T4.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 200, 60));

        getContentPane().add(T4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T5.setBackground(new java.awt.Color(255, 255, 255));
        T5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("หอพพักอันนา");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 140, 30));

        jLabel45.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("ระบบบริหารจัดการ");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Left_104px.png"))); // NOI18N
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 90));

        jLabel47.setFont(new java.awt.Font("JasmineUPC", 1, 54)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("ข้อมูลค่าใช้จ่าย");
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 270, 60));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel7.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 50));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Coins_104px_1.png"))); // NOI18N
        jPanel7.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 100));

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("ย้อนกลับ");
        jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        T5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 140));

        getContentPane().add(T5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        T6.setBackground(new java.awt.Color(255, 255, 255));
        T6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(0, 102, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("ระบบบริหารจัดการ");
        jPanel13.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 170, 40));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Left_104px.png"))); // NOI18N
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 90));

        jLabel54.setFont(new java.awt.Font("JasmineUPC", 1, 54)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("ชำระค่าหอพัก");
        jPanel13.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 250, 60));

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Registry_Editor_52px.png"))); // NOI18N
        jPanel13.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 50));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Money_Bag_104px_1.png"))); // NOI18N
        jPanel13.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 110, 100));

        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("ย้อนกลับ");
        jPanel13.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 30, 40));

        jLabel68.setFont(new java.awt.Font("JasmineUPC", 3, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("หอพักอันนา");
        jPanel13.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 140, 30));

        T6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 140));

        getContentPane().add(T6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 800));

        update1.setBackground(new java.awt.Color(255, 255, 255));
        update1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                update1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        update1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(0, 102, 255));
        jPanel29.setForeground(new java.awt.Color(0, 51, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icon/icons8_Delete_26px_1.png"))); // NOI18N
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });
        jPanel29.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 40));

        jLabel75.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("แก้ไขข้อมูลลูกค้า");
        jPanel29.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 20));

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ic/icons8_Available_Updates_45px.png"))); // NOI18N
        jPanel29.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 40));

        update1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 60));

        getContentPane().add(update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 480, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
           Home.hide();
           T01.show();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
      System.exit(0);
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
      System.exit(0);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
         Home.hide();
         T2.show();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel72MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        Home.show();
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
         Home.show();
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
         Home.show();
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
         Home.show();
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
          Home.hide();
         T3.show();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
          Home.hide();
         T5.show();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
         Home.hide();
         T6.show();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
          Home.show();
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
           Home.show();
        T01.hide();
        T2.hide();
        T3.hide();
        T4.hide();
        T5.hide();
        T6.hide();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Home.hide();
         T4.show();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel74MouseClicked

    private void update1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_update1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_update1AncestorAdded

    private void jPanel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel26MouseClicked
      Cutomer_add c=new Cutomer_add();
     c.setVisible(true);
    }//GEN-LAST:event_jPanel26MouseClicked

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
      C_update c= new C_update();
        c.setVisible(true);
//ข้อมูลลูกค้าแก้ไข
 
//        Cutomer_Update c=new Cutomer_Update();
         int select = Table_Customer.getSelectedRow();
         System.out.println(select);
         c.id2.setText(Table_Customer.getValueAt(select, 0).toString());      
         c.C_sex.setSelectedItem(Table_Customer.getValueAt(select, 1).toString());
         c.id3.setText(Table_Customer.getValueAt(select, 2).toString());
         c.id4.setText(Table_Customer.getValueAt(select, 3).toString());
         c.C_sex.setSelectedItem(Table_Customer.getValueAt(select, 4));
         c.id6.setText(Table_Customer.getValueAt(select, 5).toString());
         c.TArea1.setText(Table_Customer.getValueAt(select, 8).toString());
         String daay = Table_Customer.getValueAt(select, 6).toString().substring(0, 2);
         
         c.yyy.setText("");
         //.parse((String)Table_Customer.getValueAt(select, 6).toString();
         
         c.id7.setText(Table_Customer.getValueAt(select, 9).toString());
         c.id8.setText(Table_Customer.getValueAt(select, 10).toString());
        
//        
//        
        
     
       
    }//GEN-LAST:event_jPanel27MouseClicked

    private void Table_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_CustomerMouseClicked
//      Cutomer_Update c =new  Cutomer_Update();
//        int select = Table_Customer.getSelectedRow();
//        System.out.print(select);
//         c.Custome_ID.setText(Table_Customer.getValueAt(select, 0).toString());
//        System.out.println(Table_Customer.getValueAt(select, 0).toString());
//       //  c.Tname.setToolTipText(Table_Customer.getValueAt(select, 1).toString());
//         System.out.println(Table_Customer.getValueAt(select, 1).toString());
//        
    }//GEN-LAST:event_Table_CustomerMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Home;
    private javax.swing.JPanel T01;
    private javax.swing.JPanel T2;
    private javax.swing.JPanel T3;
    private javax.swing.JPanel T4;
    private javax.swing.JPanel T5;
    private javax.swing.JPanel T6;
    public javax.swing.JTable Table_Customer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel update1;
    // End of variables declaration//GEN-END:variables
}
