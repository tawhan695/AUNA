
package auna;
import java.sql.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class AUNA extends javax.swing.JFrame {
   Connection con = connect();
    ResultSet rs  =null;
    Statement stm =null;
    
    public AUNA() {
        initComponents();
        M();
    }
    void M(){
        M1.hide();M2.hide();M3.hide();M4.hide();M5.hide();M6.hide();
        F2.hide();F3.hide();F5.hide();F6.hide();F8.hide();F9.hide();
        F11.hide();F12.hide();F14.hide();F15.hide();F17.hide();F18.hide();
        F19.hide(); F20.hide();
    }
    
    public static Connection connect(){
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:tawhan", "auna","123");
           
            if (con !=null) {
                System.out.println("Connected "+con.getSchema());
              
            }else System.out.println("not connection");
          return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    //ลูกค้า
    
    
     void Show_Table_Customer(){
       
         String sql ="SELECT CUSTOMER.*,CUSTOMER_ADDRESS.ADDRESS,CUSTOMER_NPHONE.NUMBERPHONE,RELATIVE_NPHONE.RELATIVE_NPHONE \n" +
"FROM CUSTOMER INNER JOIN CUSTOMER_ADDRESS ON(CUSTOMER.ID=CUSTOMER_ADDRESS.ID)\n" +
"INNER JOIN CUSTOMER_NPHONE ON(CUSTOMER.ID=CUSTOMER_NPHONE.ID)\n" +
"INNER JOIN RELATIVE_NPHONE ON(CUSTOMER.ID=RELATIVE_NPHONE.ID)";
         
         try {
             rs =con.createStatement().executeQuery(sql);
             
              TableCustomer.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
         }
         
         
   }
     //ค่าใช่จ่าย
     void Show_Table_Expenses(){
         
         String sql ="SELECT * FROM EXPENSES";
         
         try {
              rs =con.createStatement().executeQuery(sql);
             
              EX1.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
         }
     }
      //รายการค่าใช่จ่าย
     void Show_Table_Expenses_Item(){
         
         String sql ="SELECT EXPENSE_ITEM_CODE,EXPENSE_ITEM_PRICE,EXPENSE_ITEM_DATE_PAY,EXPENSE_ITEM_FINE,EXPENSE_ITEM_RCODE,EXPENSE_ITEM_CCODE,EXPENSE_ITEM_RNUMBER,EXPENSE_ITEM_RE_NUMBER FROM EXPENSE_ITEM";
         
         try {
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
         }
     }
     //จอง
     void Show_Table_Booking(){
         
         String sql ="SELECT * FROM BOOKING";
         
         try {
              rs =con.createStatement().executeQuery(sql);
           
             
              Table_BOOKING.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
         }
     }
     //เช่า
     void Show_Table_Rent(){
         
         String sql ="SELECT * FROM RENT";
         
         try {
              rs =con.createStatement().executeQuery(sql);
             
              T_E.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
         }
     }
     //ห้องพัก
     void Show_Table_Room(){
         
         String sql ="SELECT ROOM.ROOM_NUMBER,ROOM.ROOM_STATUS,ROOM_TYPE.ROOM_TYPE_NAME,ROOM_TYPE.ROOM_PRICE\n" +
"FROM ROOM INNER JOIN ROOM_TYPE ON(ROOM.ROOM_TYPE_CODE=ROOM_TYPE.ROOM_TYPE_CODE)";
         
         try {
              rs =con.createStatement().executeQuery(sql);
             
              TABLE_ROOM.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
         }
     }
        void ID_BOOKING_2(){
          ArrayList arr = new ArrayList();
        

        try {
            Connection con = connect();
            String sql = "select BOOKING_CODE FROM BOOKING";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                arr.add(rs);
            }
            Random ran = new Random();
            int id = ran.nextInt(100000000);
            int number = 100000000;
            int idnumber;
            idnumber = id + number;
            String ID = "X".concat(Integer.toString(idnumber));
            arr.add(ID);
            int i1 = 0;

            String ID2 = null;
            while (rs.next()) {
                if (rs.getString(i1).equals(arr.get(0))) {
                    do {
                        int id2 = ran.nextInt(100000000);
                        int number2 = 100000000;
                        int idnumber2;
                        idnumber2 = id + number2;
                        ID2 = "X".concat(Integer.toString(idnumber2));
                    } while (ID2.equals(arr.get(0)));
                    BI1.setText(ID2);

                } else {
                    BI1.setText(ID);
                }
            }

            BI1.setText(ID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
     }
        
         void ID_EX(){
          ArrayList arr = new ArrayList();
        

        try {
            Connection con = connect();
            String sql = "select BOOKING_CODE FROM BOOKING";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                arr.add(rs);
            }
            Random ran = new Random();
            int id = ran.nextInt(100000000);
            int number = 100000000;
            int idnumber;
            idnumber = id + number;
            String ID = "E".concat(Integer.toString(idnumber));
            arr.add(ID);
            int i1 = 0;

            String ID2 = null;
            while (rs.next()) {
                if (rs.getString(i1).equals(arr.get(0))) {
                    do {
                        int id2 = ran.nextInt(100000000);
                        int number2 = 100000000;
                        int idnumber2;
                        idnumber2 = id + number2;
                        ID2 = "E".concat(Integer.toString(idnumber2));
                    } while (ID2.equals(arr.get(0)));
                    I1.setText(ID2);

                } else {
                    I1.setText(ID);
                }
            }

            I1.setText(ID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
     }
     void ID_BOOKING(){
          ArrayList arr = new ArrayList();
        

        try {
            Connection con = connect();
            String sql = "select BOOKING_CODE FROM BOOKING";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                arr.add(rs);
            }
            Random ran = new Random();
            int id = ran.nextInt(100000000);
            int number = 100000000;
            int idnumber;
            idnumber = id + number;
            String ID = "B".concat(Integer.toString(idnumber));
            arr.add(ID);
            int i1 = 0;

            String ID2 = null;
            while (rs.next()) {
                if (rs.getString(i1).equals(arr.get(0))) {
                    do {
                        int id2 = ran.nextInt(100000000);
                        int number2 = 100000000;
                        int idnumber2;
                        idnumber2 = id + number2;
                        ID2 = "B".concat(Integer.toString(idnumber2));
                    } while (ID2.equals(arr.get(0)));
                    O1.setText(ID2);

                } else {
                    O1.setText(ID);
                }
            }

            O1.setText(ID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
     }
     
     
     
        void ID_RENT(){
          ArrayList arr = new ArrayList();
        

        try {
            Connection con = connect();
            String sql = "select RENT_CODE FROM RENT";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                arr.add(rs);
            }
            Random ran = new Random();
            int id = ran.nextInt(100000000);
            int number = 100000000;
            int idnumber;
            idnumber = id + number;
            String ID = "R".concat(Integer.toString(idnumber));
            arr.add(ID);
            int i1 = 0;

            String ID2 = null;
            while (rs.next()) {
                if (rs.getString(i1).equals(arr.get(0))) {
                    do {
                        int id2 = ran.nextInt(100000000);
                        int number2 = 100000000;
                        int idnumber2;
                        idnumber2 = id + number2;
                        ID2 = "R".concat(Integer.toString(idnumber2));
                    } while (ID2.equals(arr.get(0)));
                    Q1.setText(ID2);

                } else {
                    Q1.setText(ID);
                }
            }

            Q1.setText(ID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
     }
     void ran() {
        ArrayList arr = new ArrayList();
        

        try {
            Connection con = connect();
            String sql = "select ID FROM CUSTOMER";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                arr.add(rs);
            }
            Random ran = new Random();
            int id = ran.nextInt(100000000);
            int number = 100000000;
            int idnumber;
            idnumber = id + number;
            String ID = "C".concat(Integer.toString(idnumber));
            arr.add(ID);
            int i1 = 0;

            String ID2 = null;
            while (rs.next()) {
                if (rs.getString(i1).equals(arr.get(0))) {
                    do {
                        int id2 = ran.nextInt(100000000);
                        int number2 = 100000000;
                        int idnumber2;
                        idnumber2 = id + number2;
                        ID2 = "C".concat(Integer.toString(idnumber2));
                    } while (ID2.equals(arr.get(0)));
                    Z1.setText(ID2);

                } else {
                    Z1.setText(ID);
                }
            }

            Z1.setText(ID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
    }
     //สร้างหมายเลขห้อง
      void randomNUMBER_Room() {
        ArrayList arr = new ArrayList();
        int num=0;

        try {
            Connection con = connect();
            String sql = "select ROOM_NUMBER FROM ROOM";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                arr.add(rs);
            }
             num =arr.size();
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
          System.out.println("num ="+num);
         String NUMROOOM ="";
            int H=1;
             if (num>99) {
                 int sum=num+H; 
                NUMROOOM ="A"+sum;      
            } if (num>10) {
                 int sum=num+H;
                NUMROOOM ="A0"+sum;       
            }else if (num<10) {
                 int sum=num+H;
                NUMROOOM ="A00"+sum;       
            }
             if (num==0){
                NUMROOOM ="A001";
            }
             System.out.println(""+NUMROOOM);
           ZZ1.setText(NUMROOOM);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HOME = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        L3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        L1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        L2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        L5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        L6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        L4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        M1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCustomer = new javax.swing.JTable();
        F1 = new javax.swing.JPanel();
        Add_Customer = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Edit_Customer = new javax.swing.JButton();
        address2 = new javax.swing.JButton();
        Add_phone = new javax.swing.JButton();
        F2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Z9 = new javax.swing.JTextField();
        Z1 = new javax.swing.JTextField();
        Z3 = new javax.swing.JTextField();
        Z4 = new javax.swing.JTextField();
        Z5 = new javax.swing.JTextField();
        Z8 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Z2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Z6 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        Z7 = new datechooser.beans.DateChooserCombo();
        jLabel13 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        No2 = new javax.swing.JButton();
        OK1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        F3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        U9 = new javax.swing.JTextField();
        U1 = new javax.swing.JTextField();
        U3 = new javax.swing.JTextField();
        U4 = new javax.swing.JTextField();
        U5 = new javax.swing.JTextField();
        U8 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        U01 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        U6 = new javax.swing.JTextArea();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        No = new javax.swing.JButton();
        OK2 = new javax.swing.JButton();
        U2 = new javax.swing.JComboBox<>();
        jLabel101 = new javax.swing.JLabel();
        Udate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        F19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        nn2 = new javax.swing.JTextField();
        nn1 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        No1 = new javax.swing.JButton();
        OK13 = new javax.swing.JButton();
        CCC1 = new javax.swing.JComboBox<>();
        jLabel154 = new javax.swing.JLabel();
        F20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        A55 = new javax.swing.JTextArea();
        jLabel160 = new javax.swing.JLabel();
        No15 = new javax.swing.JButton();
        OK14 = new javax.swing.JButton();
        E55 = new javax.swing.JComboBox<>();
        jLabel165 = new javax.swing.JLabel();
        M2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLE_ROOM = new javax.swing.JTable();
        F4 = new javax.swing.JPanel();
        Add_Customer1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Edit_Customer2 = new javax.swing.JButton();
        F5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        ZZ1 = new javax.swing.JTextField();
        ZZ4 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        ZZ2 = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        No3 = new javax.swing.JButton();
        OK3 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        ZZ3 = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        F6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        C1 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        C2 = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        No4 = new javax.swing.JButton();
        OK5 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        C3 = new javax.swing.JComboBox<>();
        C5 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        M3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        F7 = new javax.swing.JPanel();
        Add_Customer2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Edit_Customer3 = new javax.swing.JButton();
        F8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        J2 = new javax.swing.JTextField();
        J3 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        No5 = new javax.swing.JButton();
        OK4 = new javax.swing.JButton();
        J1 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        F9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        K2 = new javax.swing.JTextField();
        K3 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        No6 = new javax.swing.JButton();
        OK6 = new javax.swing.JButton();
        K1 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        EX1 = new javax.swing.JTable();
        M4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        F10 = new javax.swing.JPanel();
        Add_Customer3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Edit_Customer4 = new javax.swing.JButton();
        No7 = new javax.swing.JButton();
        F11 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        O2 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        OK7 = new javax.swing.JButton();
        O1 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        BI1 = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        ROOM3 = new javax.swing.JComboBox<>();
        CUS = new javax.swing.JComboBox<>();
        No13 = new javax.swing.JButton();
        dateCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel86 = new javax.swing.JLabel();
        F12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        No8 = new javax.swing.JButton();
        OK8 = new javax.swing.JButton();
        A_ID_CUD = new javax.swing.JTextField();
        A_BI = new javax.swing.JTextField();
        A_PRICE = new javax.swing.JTextField();
        A_Booking = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        A_IDROOM = new javax.swing.JTextField();
        A_date = new datechooser.beans.DateChooserCombo();
        jLabel100 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Table_BOOKING = new javax.swing.JTable();
        M5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        F13 = new javax.swing.JPanel();
        Add_Customer4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Edit_Customer5 = new javax.swing.JButton();
        F14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        No9 = new javax.swing.JButton();
        OK9 = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        Q2 = new javax.swing.JComboBox<>();
        Q3 = new javax.swing.JTextField();
        Q4 = new datechooser.beans.DateChooserCombo();
        Q7 = new javax.swing.JTextField();
        Q1 = new javax.swing.JTextField();
        Q5 = new javax.swing.JComboBox<>();
        Q6 = new javax.swing.JComboBox<>();
        jLabel107 = new javax.swing.JLabel();
        F15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        No10 = new javax.swing.JButton();
        OK10 = new javax.swing.JButton();
        W5 = new javax.swing.JTextField();
        W7 = new javax.swing.JTextField();
        W1 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        W6 = new javax.swing.JTextField();
        W4 = new datechooser.beans.DateChooserCombo();
        jLabel113 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        W3 = new javax.swing.JTextField();
        W2 = new javax.swing.JComboBox<>();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Table_RENT = new javax.swing.JTable();
        M6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        F16 = new javax.swing.JPanel();
        Add_Customer5 = new javax.swing.JButton();
        Edit_Customer6 = new javax.swing.JButton();
        No14 = new javax.swing.JButton();
        F17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        No11 = new javax.swing.JButton();
        OK11 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        LL3 = new javax.swing.JTextField();
        I3 = new datechooser.beans.DateChooserCombo();
        I1 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        I9 = new javax.swing.JTextField();
        LL1 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        LL2 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        I23 = new javax.swing.JCheckBox();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        I4 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        I7 = new javax.swing.JComboBox<>();
        I8 = new javax.swing.JComboBox<>();
        I80 = new javax.swing.JComboBox<>();
        jLabel130 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        T_E = new javax.swing.JTable();
        F18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        No12 = new javax.swing.JButton();
        OK12 = new javax.swing.JButton();
        jLabel129 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        Z57 = new javax.swing.JTextField();
        dateChooserCombo7 = new datechooser.beans.DateChooserCombo();
        Z60 = new javax.swing.JTextField();
        Z61 = new javax.swing.JTextField();
        Z62 = new javax.swing.JTextField();
        Z63 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        Z64 = new javax.swing.JTextField();
        Z65 = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        Z66 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HOME.setBackground(new java.awt.Color(255, 255, 255));
        HOME.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("JasmineUPC", 2, 60)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Home_104px_2.png"))); // NOI18N
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 120, 100));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("JasmineUPC", 3, 60)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ระบบบริหารจัดการ");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 380, 100));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("JasmineUPC", 3, 60)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("หอพักอันนา");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 270, 80));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("JasmineUPC", 3, 60)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("หอพักอันนา");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 270, 80));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

        HOME.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 190));

        L3.setBackground(new java.awt.Color(204, 204, 204));
        L3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L3MouseClicked(evt);
            }
        });
        L3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_Money_Bag_Bitcoin_104px_3.png"))); // NOI18N
        L3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 123, 114));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 153, 255));
        jLabel24.setText("จัดการข้อมูลค่าใช้จ่าย");
        L3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 260, 60));

        HOME.add(L3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 280, 260));

        L1.setBackground(new java.awt.Color(204, 204, 204));
        L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L1MouseClicked(evt);
            }
        });
        L1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i2/icons8_User_Account_104px_3.png"))); // NOI18N
        L1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 123, 114));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 153, 255));
        jLabel26.setText("จัดการข้อมูลลูกค้า");
        L1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, 60));

        HOME.add(L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 300, 260));

        L2.setBackground(new java.awt.Color(204, 204, 204));
        L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L2MouseClicked(evt);
            }
        });
        L2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i2/icons8_Home_104px_3.png"))); // NOI18N
        L2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 123, 114));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 153, 255));
        jLabel28.setText("จัดการข้อมูลห้องพัก");
        L2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 240, 60));

        HOME.add(L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 280, 260));

        L5.setBackground(new java.awt.Color(204, 204, 204));
        L5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L5MouseClicked(evt);
            }
        });
        L5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i2/icons8_Work_in_Bed_104px.png"))); // NOI18N
        L5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 123, 114));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 153, 255));
        jLabel30.setText("เช่าหอพัก");
        L5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 130, 60));

        HOME.add(L5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 280, 260));

        L6.setBackground(new java.awt.Color(204, 204, 204));
        L6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L6MouseClicked(evt);
            }
        });
        L6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i2/icons8_Donate_104px_1.png"))); // NOI18N
        L6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 123, 114));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 153, 255));
        jLabel32.setText("รายการค่าใช้จ่าย");
        L6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 210, 60));

        HOME.add(L6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 280, 260));

        L4.setBackground(new java.awt.Color(204, 204, 204));
        L4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L4MouseClicked(evt);
            }
        });
        L4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i2/icons8_Room_104px_2.png"))); // NOI18N
        L4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, 114));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 153, 255));
        jLabel34.setText("จองหอพัก");
        L4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 150, 60));

        HOME.add(L4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 300, 260));

        getContentPane().add(HOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

        M1.setBackground(new java.awt.Color(255, 255, 255));
        M1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_User_Account_104px_4.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 150, 120));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Back_52px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 100));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("JasmineUPC", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ย้อนกลับ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 50));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("จัดการข้อมูลลูกค้า");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 310, 60));

        M1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 130));

        TableCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableCustomer);

        M1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1090, 690));

        F1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_Customer.setBackground(new java.awt.Color(0, 102, 255));
        Add_Customer.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        Add_Customer.setForeground(new java.awt.Color(255, 255, 255));
        Add_Customer.setText("เพิ่มข้อมุลลูกค้า");
        Add_Customer.setBorder(null);
        Add_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_CustomerMouseClicked(evt);
            }
        });
        F1.add(Add_Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 270, 80));

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ลบข้อมูล");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        F1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 270, 80));

        Edit_Customer.setBackground(new java.awt.Color(0, 102, 255));
        Edit_Customer.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        Edit_Customer.setForeground(new java.awt.Color(255, 255, 255));
        Edit_Customer.setText("แก้ไขข้อมูล");
        Edit_Customer.setBorder(null);
        Edit_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_CustomerMouseClicked(evt);
            }
        });
        F1.add(Edit_Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 270, 80));

        address2.setBackground(new java.awt.Color(0, 102, 255));
        address2.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        address2.setForeground(new java.awt.Color(255, 255, 255));
        address2.setText("เพิ่มที่อยู่ลูกค้า");
        address2.setBorder(null);
        address2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                address2MouseClicked(evt);
            }
        });
        F1.add(address2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 270, 80));

        Add_phone.setBackground(new java.awt.Color(0, 102, 255));
        Add_phone.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
        Add_phone.setForeground(new java.awt.Color(255, 255, 255));
        Add_phone.setText("เพิ่มเบอร์โทรลูกค้า");
        Add_phone.setBorder(null);
        Add_phone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_phoneMouseClicked(evt);
            }
        });
        F1.add(Add_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 270, 80));

        M1.add(F1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

        F2.setBackground(new java.awt.Color(255, 255, 255));
        F2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Z9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Z9KeyTyped(evt);
            }
        });
        jPanel1.add(Z9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 190, 30));

        Z1.setEnabled(false);
        Z1.setSelectionStart(10);
        jPanel1.add(Z1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 120, 30));

        Z3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Z3KeyTyped(evt);
            }
        });
        jPanel1.add(Z3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, 30));

        Z4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Z4KeyTyped(evt);
            }
        });
        jPanel1.add(Z4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 30));

        Z5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Z5KeyTyped(evt);
            }
        });
        jPanel1.add(Z5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 190, 30));

        Z8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Z8KeyTyped(evt);
            }
        });
        jPanel1.add(Z8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 190, 30));

        jLabel3.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("คำนำหน้าชื่อ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        Z2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "นาย", "นางสาว", "นาง" }));
        jPanel1.add(Z2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 30));

        jLabel4.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("รหัสลูกค้า");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, 30));

        jLabel5.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("ชื่อ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 20, 30));

        jLabel6.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("นามสกุล");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 50, 30));

        Z6.setColumns(20);
        Z6.setRows(5);
        Z6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Z6KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(Z6);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, -1));

        jLabel7.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("เลขบัตรประชาชน");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 30));

        Z7.setCalendarPreferredSize(new java.awt.Dimension(500, 300));
        Z7.setFormat(2);
        Z7.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        try {
            Z7.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2018, 4, 26),
                new java.util.GregorianCalendar(2018, 4, 26))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    Z7.setLocale(new java.util.Locale("th", "", ""));
    jPanel1.add(Z7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 190, 30));

    jLabel13.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(0, 102, 255));
    jLabel13.setText("ที่อยู่");
    jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 30, 30));

    jLabel56.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel56.setForeground(new java.awt.Color(0, 102, 255));
    jLabel56.setText("วันเดือนปีเกิด");
    jPanel1.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, 30));

    jLabel57.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel57.setForeground(new java.awt.Color(0, 102, 255));
    jLabel57.setText("เบอรโทรศัพท์ญาติ");
    jPanel1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, 30));

    jLabel58.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel58.setForeground(new java.awt.Color(0, 102, 255));
    jLabel58.setText("เบอรโทรศัพท์ลูกค้า");
    jPanel1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 120, 30));

    No2.setBackground(new java.awt.Color(0, 102, 255));
    No2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No2.setForeground(new java.awt.Color(255, 255, 255));
    No2.setText("ยกเลิก");
    No2.setBorder(null);
    No2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No2MouseClicked(evt);
        }
    });
    jPanel1.add(No2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 130, 50));

    OK1.setBackground(new java.awt.Color(0, 102, 255));
    OK1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK1.setForeground(new java.awt.Color(255, 255, 255));
    OK1.setText("บันทึก");
    OK1.setBorder(null);
    OK1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK1MouseClicked(evt);
        }
    });
    jPanel1.add(OK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 130, 50));

    jButton1.setText("เปลี่ยน");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton1MouseClicked(evt);
        }
    });
    jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 70, -1));

    F2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 102, 255));
    jLabel1.setText("เพิ่มลูกค้า");
    F2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 100, 40));

    M1.add(F2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F3.setBackground(new java.awt.Color(255, 255, 255));
    F3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel8.add(U9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 190, 30));
    jPanel8.add(U1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 190, 30));
    jPanel8.add(U3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, 30));
    jPanel8.add(U4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 30));
    jPanel8.add(U5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, 30));
    jPanel8.add(U8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 190, 30));

    jLabel59.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel59.setForeground(new java.awt.Color(0, 102, 255));
    jLabel59.setText("คำนำหน้าชื่อ");
    jPanel8.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

    U01.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
    jPanel8.add(U01, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 190, 30));

    jLabel60.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel60.setForeground(new java.awt.Color(0, 102, 255));
    jLabel60.setText("รหัสลูกค้า");
    jPanel8.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, 30));

    jLabel61.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel61.setForeground(new java.awt.Color(0, 102, 255));
    jLabel61.setText("ชื่อ");
    jPanel8.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 20, 30));

    jLabel62.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel62.setForeground(new java.awt.Color(0, 102, 255));
    jLabel62.setText("เพศ");
    jPanel8.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 30, 30));

    U6.setColumns(20);
    U6.setRows(5);
    jScrollPane3.setViewportView(U6);

    jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 190, 60));

    jLabel63.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel63.setForeground(new java.awt.Color(0, 102, 255));
    jLabel63.setText("เลขบัตรประชาชน");
    jPanel8.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 30));

    jLabel64.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel64.setForeground(new java.awt.Color(0, 102, 255));
    jLabel64.setText("ที่อยู่");
    jPanel8.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 30, 30));

    jLabel65.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel65.setForeground(new java.awt.Color(0, 102, 255));
    jLabel65.setText("วันเดือนปีเกิด");
    jPanel8.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 80, 30));

    jLabel66.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel66.setForeground(new java.awt.Color(0, 102, 255));
    jLabel66.setText("เบอรโทรศัพท์ญาติ");
    jPanel8.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 120, 30));

    jLabel67.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel67.setForeground(new java.awt.Color(0, 102, 255));
    jLabel67.setText("เบอรโทรศัพท์ลูกค้า");
    jPanel8.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 120, 30));

    No.setBackground(new java.awt.Color(0, 102, 255));
    No.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No.setForeground(new java.awt.Color(255, 255, 255));
    No.setText("ยกเลิก");
    No.setBorder(null);
    No.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            NoMouseClicked(evt);
        }
    });
    jPanel8.add(No, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 130, 50));

    OK2.setBackground(new java.awt.Color(0, 102, 255));
    OK2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK2.setForeground(new java.awt.Color(255, 255, 255));
    OK2.setText("บันทึก");
    OK2.setBorder(null);
    OK2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK2MouseClicked(evt);
        }
    });
    jPanel8.add(OK2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 130, 50));

    U2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "นาย", "นางสาว", "นาง", " " }));
    jPanel8.add(U2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 30));

    jLabel101.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel101.setForeground(new java.awt.Color(0, 102, 255));
    jLabel101.setText("นามสกุล");
    jPanel8.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 50, 30));
    jPanel8.add(Udate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 190, 30));

    F3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 102, 255));
    jLabel2.setText("แก้ไขข้อมูล");
    F3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 100, 40));

    M1.add(F3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F19.setBackground(new java.awt.Color(255, 255, 255));
    F19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel20.add(nn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 190, 30));
    jPanel20.add(nn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, 30));

    jLabel102.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel102.setForeground(new java.awt.Color(0, 102, 255));
    jLabel102.setText("รหัสลูกค้า");
    jPanel20.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 60, 30));

    jLabel151.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel151.setForeground(new java.awt.Color(0, 102, 255));
    jLabel151.setText("เบอรโทรศัพท์ญาติ");
    jPanel20.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 30));

    jLabel152.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel152.setForeground(new java.awt.Color(0, 102, 255));
    jLabel152.setText("เบอรโทรศัพท์ลูกค้า");
    jPanel20.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, 30));

    No1.setBackground(new java.awt.Color(0, 102, 255));
    No1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No1.setForeground(new java.awt.Color(255, 255, 255));
    No1.setText("ยกเลิก");
    No1.setBorder(null);
    No1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No1MouseClicked(evt);
        }
    });
    jPanel20.add(No1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 130, 50));

    OK13.setBackground(new java.awt.Color(0, 102, 255));
    OK13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK13.setForeground(new java.awt.Color(255, 255, 255));
    OK13.setText("บันทึก");
    OK13.setBorder(null);
    OK13.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK13MouseClicked(evt);
        }
    });
    jPanel20.add(OK13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 130, 50));

    jPanel20.add(CCC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 40));

    F19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel154.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel154.setForeground(new java.awt.Color(0, 102, 255));
    jLabel154.setText("เพิ่มเบอร์โทร");
    F19.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 130, 40));

    M1.add(F19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F20.setBackground(new java.awt.Color(255, 255, 255));
    F20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel156.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel156.setForeground(new java.awt.Color(0, 102, 255));
    jLabel156.setText("รหัสลูกค้า");
    jPanel21.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 60, 30));

    A55.setColumns(20);
    A55.setRows(5);
    jScrollPane10.setViewportView(A55);

    jPanel21.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 190, 110));

    jLabel160.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel160.setForeground(new java.awt.Color(0, 102, 255));
    jLabel160.setText("ที่อยู่");
    jPanel21.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 30, 30));

    No15.setBackground(new java.awt.Color(0, 102, 255));
    No15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No15.setForeground(new java.awt.Color(255, 255, 255));
    No15.setText("ยกเลิก");
    No15.setBorder(null);
    No15.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No15MouseClicked(evt);
        }
    });
    jPanel21.add(No15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 130, 50));

    OK14.setBackground(new java.awt.Color(0, 102, 255));
    OK14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK14.setForeground(new java.awt.Color(255, 255, 255));
    OK14.setText("บันทึก");
    OK14.setBorder(null);
    OK14.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK14MouseClicked(evt);
        }
    });
    jPanel21.add(OK14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 130, 50));

    jPanel21.add(E55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 190, 30));

    F20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel165.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel165.setForeground(new java.awt.Color(0, 102, 255));
    jLabel165.setText("เพิ่มที่อยู่");
    F20.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 100, 40));

    M1.add(F20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    getContentPane().add(M1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

    M2.setBackground(new java.awt.Color(255, 255, 255));
    M2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel3.setBackground(new java.awt.Color(0, 102, 255));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
    jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel35MouseClicked(evt);
        }
    });
    jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

    jLabel12.setBackground(new java.awt.Color(255, 255, 255));
    jLabel12.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 255, 255));
    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_Home_104px_4.png"))); // NOI18N
    jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 150, 120));

    jLabel14.setBackground(new java.awt.Color(255, 255, 255));
    jLabel14.setFont(new java.awt.Font("JasmineUPC", 3, 18)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 255, 255));
    jLabel14.setText("ย้อนกลับ");
    jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 50));

    jLabel15.setBackground(new java.awt.Color(255, 255, 255));
    jLabel15.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("จัดการข้อมูลห้องพัก");
    jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 330, 60));

    jLabel55.setBackground(new java.awt.Color(255, 255, 255));
    jLabel55.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel55.setForeground(new java.awt.Color(255, 255, 255));
    jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Back_52px.png"))); // NOI18N
    jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel55MouseClicked(evt);
        }
    });
    jPanel3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 100));

    M2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 130));

    TABLE_ROOM.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane4.setViewportView(TABLE_ROOM);

    M2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1090, 690));

    F4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    Add_Customer1.setBackground(new java.awt.Color(0, 102, 255));
    Add_Customer1.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Add_Customer1.setForeground(new java.awt.Color(255, 255, 255));
    Add_Customer1.setText("เพิ่มห้องพัก");
    Add_Customer1.setBorder(null);
    Add_Customer1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Add_Customer1MouseClicked(evt);
        }
    });
    F4.add(Add_Customer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 270, 80));

    jButton3.setBackground(new java.awt.Color(255, 153, 153));
    jButton3.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    jButton3.setForeground(new java.awt.Color(255, 255, 255));
    jButton3.setText("ลบข้อมูล");
    jButton3.setBorder(null);
    jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton3MouseClicked(evt);
        }
    });
    F4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 270, 80));

    Edit_Customer2.setBackground(new java.awt.Color(0, 102, 255));
    Edit_Customer2.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Edit_Customer2.setForeground(new java.awt.Color(255, 255, 255));
    Edit_Customer2.setText("แก้ไขข้อมูลห้องพัก");
    Edit_Customer2.setBorder(null);
    Edit_Customer2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Edit_Customer2MouseClicked(evt);
        }
    });
    F4.add(Edit_Customer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 270, 80));

    M2.add(F4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F5.setBackground(new java.awt.Color(255, 255, 255));
    F5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    ZZ1.setEnabled(false);
    ZZ1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ZZ1ActionPerformed(evt);
        }
    });
    jPanel9.add(ZZ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 30));
    jPanel9.add(ZZ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));

    jLabel68.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel68.setForeground(new java.awt.Color(0, 102, 255));
    jLabel68.setText("สถานห้อง");
    jPanel9.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 60, 30));

    ZZ2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ว่าง", "ไม่ว่าง" }));
    jPanel9.add(ZZ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));

    jLabel69.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel69.setForeground(new java.awt.Color(0, 102, 255));
    jLabel69.setText("หมายเลขห้อง");
    jPanel9.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

    jLabel70.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel70.setForeground(new java.awt.Color(0, 102, 255));
    jLabel70.setText("ราคาห้องพัก");
    jPanel9.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 80, 30));

    No3.setBackground(new java.awt.Color(0, 102, 255));
    No3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No3.setForeground(new java.awt.Color(255, 255, 255));
    No3.setText("ยกเลิก");
    No3.setBorder(null);
    No3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No3MouseClicked(evt);
        }
    });
    jPanel9.add(No3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK3.setBackground(new java.awt.Color(0, 102, 255));
    OK3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK3.setForeground(new java.awt.Color(255, 255, 255));
    OK3.setText("บันทึก");
    OK3.setBorder(null);
    OK3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK3MouseClicked(evt);
        }
    });
    jPanel9.add(OK3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    jLabel88.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel88.setForeground(new java.awt.Color(0, 102, 255));
    jLabel88.setText("ประเภทห้องพัก");
    jPanel9.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));

    ZZ3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "บ้าน", "ตึก" }));
    jPanel9.add(ZZ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 30));

    F5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel77.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel77.setForeground(new java.awt.Color(0, 102, 255));
    jLabel77.setText("เพิ่มห้องพัก");
    F5.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 100, 40));

    M2.add(F5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F6.setBackground(new java.awt.Color(255, 255, 255));
    F6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel12.add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 190, 30));

    jLabel71.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel71.setForeground(new java.awt.Color(0, 102, 255));
    jLabel71.setText("สถานห้อง");
    jPanel12.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 60, 30));

    C2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ว่าง", "ไม่ว่าง" }));
    jPanel12.add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 190, 30));

    jLabel72.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel72.setForeground(new java.awt.Color(0, 102, 255));
    jLabel72.setText("หมายเลขห้อง");
    jPanel12.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 80, 30));

    jLabel73.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel73.setForeground(new java.awt.Color(0, 102, 255));
    jLabel73.setText("ราคาห้องพัก");
    jPanel12.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 80, 30));

    No4.setBackground(new java.awt.Color(0, 102, 255));
    No4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No4.setForeground(new java.awt.Color(255, 255, 255));
    No4.setText("ยกเลิก");
    No4.setBorder(null);
    No4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No4MouseClicked(evt);
        }
    });
    jPanel12.add(No4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK5.setBackground(new java.awt.Color(0, 102, 255));
    OK5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK5.setForeground(new java.awt.Color(255, 255, 255));
    OK5.setText("บันทึก");
    OK5.setBorder(null);
    OK5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK5MouseClicked(evt);
        }
    });
    jPanel12.add(OK5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    jLabel89.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel89.setForeground(new java.awt.Color(0, 102, 255));
    jLabel89.setText("ชื่อประเภทห้องพัก");
    jPanel12.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

    C3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "บ้าน", "ตึก" }));
    jPanel12.add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 190, 30));
    jPanel12.add(C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 190, 30));

    F6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel90.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel90.setForeground(new java.awt.Color(0, 102, 255));
    jLabel90.setText("แก้ไขข้อมูลห้องพัก");
    F6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 180, 40));

    M2.add(F6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    getContentPane().add(M2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

    M3.setBackground(new java.awt.Color(255, 255, 255));
    M3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel4.setBackground(new java.awt.Color(0, 102, 255));
    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
    jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel36MouseClicked(evt);
        }
    });
    jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

    jLabel16.setBackground(new java.awt.Color(255, 255, 255));
    jLabel16.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(255, 255, 255));
    jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_Money_Bag_Bitcoin_104px_2.png"))); // NOI18N
    jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 120, 120));

    jLabel37.setBackground(new java.awt.Color(255, 255, 255));
    jLabel37.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel37.setForeground(new java.awt.Color(255, 255, 255));
    jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Back_52px.png"))); // NOI18N
    jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel37MouseClicked(evt);
        }
    });
    jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 100));

    jLabel38.setBackground(new java.awt.Color(255, 255, 255));
    jLabel38.setFont(new java.awt.Font("JasmineUPC", 3, 18)); // NOI18N
    jLabel38.setForeground(new java.awt.Color(255, 255, 255));
    jLabel38.setText("ย้อนกลับ");
    jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 50));

    jLabel39.setBackground(new java.awt.Color(255, 255, 255));
    jLabel39.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel39.setForeground(new java.awt.Color(255, 255, 255));
    jLabel39.setText("จัดการข้อมูลค่าใช้จ่าย");
    jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 360, 60));

    M3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 130));

    F7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    Add_Customer2.setBackground(new java.awt.Color(0, 102, 255));
    Add_Customer2.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Add_Customer2.setForeground(new java.awt.Color(255, 255, 255));
    Add_Customer2.setText("เพิ่มค่าใช้จ่าย");
    Add_Customer2.setBorder(null);
    Add_Customer2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Add_Customer2MouseClicked(evt);
        }
    });
    F7.add(Add_Customer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 270, 80));

    jButton4.setBackground(new java.awt.Color(255, 153, 153));
    jButton4.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    jButton4.setForeground(new java.awt.Color(255, 255, 255));
    jButton4.setText("ลบข้อมูล");
    jButton4.setBorder(null);
    jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton4MouseClicked(evt);
        }
    });
    F7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, 270, 80));

    Edit_Customer3.setBackground(new java.awt.Color(0, 102, 255));
    Edit_Customer3.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Edit_Customer3.setForeground(new java.awt.Color(255, 255, 255));
    Edit_Customer3.setText("แก้ไขข้อมูลค่าใช้จ่าย");
    Edit_Customer3.setBorder(null);
    Edit_Customer3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Edit_Customer3MouseClicked(evt);
        }
    });
    F7.add(Edit_Customer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 270, 80));

    M3.add(F7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F8.setBackground(new java.awt.Color(255, 255, 255));
    F8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel11.add(J2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));
    jPanel11.add(J3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 30));

    jLabel74.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel74.setForeground(new java.awt.Color(0, 102, 255));
    jLabel74.setText("ชื่อค่าใช้จ่าย");
    jPanel11.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));

    jLabel75.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel75.setForeground(new java.awt.Color(0, 102, 255));
    jLabel75.setText("รหัสค่าใช้จ่าย");
    jPanel11.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

    jLabel76.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel76.setForeground(new java.awt.Color(0, 102, 255));
    jLabel76.setText("ราคาต่อหน่วย");
    jPanel11.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 30));

    No5.setBackground(new java.awt.Color(0, 102, 255));
    No5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No5.setForeground(new java.awt.Color(255, 255, 255));
    No5.setText("ยกเลิก");
    No5.setBorder(null);
    No5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No5MouseClicked(evt);
        }
    });
    jPanel11.add(No5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK4.setBackground(new java.awt.Color(0, 102, 255));
    OK4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK4.setForeground(new java.awt.Color(255, 255, 255));
    OK4.setText("บันทึก");
    OK4.setBorder(null);
    OK4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK4MouseClicked(evt);
        }
    });
    jPanel11.add(OK4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));
    jPanel11.add(J1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 30));

    F8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel78.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel78.setForeground(new java.awt.Color(0, 102, 255));
    jLabel78.setText("เพิ่มค่าใช้จ่าย");
    F8.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 100, 40));

    M3.add(F8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    F9.setBackground(new java.awt.Color(255, 255, 255));
    F9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel13.add(K2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));
    jPanel13.add(K3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 30));

    jLabel79.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel79.setForeground(new java.awt.Color(0, 102, 255));
    jLabel79.setText("ชื่อค่าใช้จ่าย");
    jPanel13.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 30));

    jLabel80.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel80.setForeground(new java.awt.Color(0, 102, 255));
    jLabel80.setText("รหัสค่าใช้จ่าย");
    jPanel13.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 80, 30));

    jLabel81.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel81.setForeground(new java.awt.Color(0, 102, 255));
    jLabel81.setText("ราคาต่อหน่วย");
    jPanel13.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 90, 30));

    No6.setBackground(new java.awt.Color(0, 102, 255));
    No6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No6.setForeground(new java.awt.Color(255, 255, 255));
    No6.setText("ยกเลิก");
    No6.setBorder(null);
    No6.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No6MouseClicked(evt);
        }
    });
    jPanel13.add(No6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK6.setBackground(new java.awt.Color(0, 102, 255));
    OK6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK6.setForeground(new java.awt.Color(255, 255, 255));
    OK6.setText("บันทึก");
    OK6.setBorder(null);
    OK6.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK6MouseClicked(evt);
        }
    });
    jPanel13.add(OK6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    K1.setEnabled(false);
    jPanel13.add(K1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 30));

    F9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, 630));

    jLabel82.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel82.setForeground(new java.awt.Color(0, 102, 255));
    jLabel82.setText("แก้ไขข้อมูลค่าใช้จ่าย");
    F9.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 190, 40));

    M3.add(F9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 380, 690));

    EX1.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane5.setViewportView(EX1);

    M3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 150, 1090, 690));

    getContentPane().add(M3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

    M4.setBackground(new java.awt.Color(255, 255, 255));
    M4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel5.setBackground(new java.awt.Color(0, 102, 255));
    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
    jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel40MouseClicked(evt);
        }
    });
    jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

    jLabel41.setBackground(new java.awt.Color(255, 255, 255));
    jLabel41.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel41.setForeground(new java.awt.Color(255, 255, 255));
    jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_Room_104px_3.png"))); // NOI18N
    jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 150, 120));

    jLabel42.setBackground(new java.awt.Color(255, 255, 255));
    jLabel42.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel42.setForeground(new java.awt.Color(255, 255, 255));
    jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Back_52px.png"))); // NOI18N
    jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel42MouseClicked(evt);
        }
    });
    jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 100));

    jLabel43.setBackground(new java.awt.Color(255, 255, 255));
    jLabel43.setFont(new java.awt.Font("JasmineUPC", 3, 18)); // NOI18N
    jLabel43.setForeground(new java.awt.Color(255, 255, 255));
    jLabel43.setText("ย้อนกลับ");
    jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 50));

    jLabel44.setBackground(new java.awt.Color(255, 255, 255));
    jLabel44.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel44.setForeground(new java.awt.Color(255, 255, 255));
    jLabel44.setText("จองห้องพัก");
    jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 210, 60));

    M4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 130));

    F10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    Add_Customer3.setBackground(new java.awt.Color(0, 102, 255));
    Add_Customer3.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Add_Customer3.setForeground(new java.awt.Color(255, 255, 255));
    Add_Customer3.setText("เพิ่มการจองห้องพัก");
    Add_Customer3.setBorder(null);
    Add_Customer3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Add_Customer3MouseClicked(evt);
        }
    });
    F10.add(Add_Customer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 80));

    jButton5.setBackground(new java.awt.Color(255, 153, 153));
    jButton5.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    jButton5.setForeground(new java.awt.Color(255, 255, 255));
    jButton5.setText("ลบข้อมูล");
    jButton5.setBorder(null);
    jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton5MouseClicked(evt);
        }
    });
    F10.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 270, 80));

    Edit_Customer4.setBackground(new java.awt.Color(0, 102, 255));
    Edit_Customer4.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Edit_Customer4.setForeground(new java.awt.Color(255, 255, 255));
    Edit_Customer4.setText("แก้ไขข้อมูลการจอง");
    Edit_Customer4.setBorder(null);
    Edit_Customer4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Edit_Customer4MouseClicked(evt);
        }
    });
    F10.add(Edit_Customer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 270, 80));

    No7.setBackground(new java.awt.Color(153, 153, 255));
    No7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No7.setForeground(new java.awt.Color(255, 255, 255));
    No7.setText("ปลิ้นใบเสร้จ");
    No7.setBorder(null);
    No7.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No7MouseClicked(evt);
        }
    });
    F10.add(No7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 270, 70));

    M4.add(F10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 350, 690));

    F11.setBackground(new java.awt.Color(255, 255, 255));
    F11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel14.add(O2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 190, 30));

    jLabel83.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel83.setForeground(new java.awt.Color(0, 102, 255));
    jLabel83.setText("ค่ามัดจำ");
    jPanel14.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 60, 30));

    jLabel84.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel84.setForeground(new java.awt.Color(0, 102, 255));
    jLabel84.setText("รหัสการจอง");
    jPanel14.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 30));

    jLabel85.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel85.setForeground(new java.awt.Color(0, 102, 255));
    jLabel85.setText("ว/ด/ป ที่จอง");
    jPanel14.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, 30));

    OK7.setBackground(new java.awt.Color(0, 102, 255));
    OK7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK7.setForeground(new java.awt.Color(255, 255, 255));
    OK7.setText("จอง");
    OK7.setBorder(null);
    OK7.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK7MouseClicked(evt);
        }
    });
    jPanel14.add(OK7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    O1.setEnabled(false);
    jPanel14.add(O1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, 30));

    jLabel95.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel95.setForeground(new java.awt.Color(0, 102, 255));
    jLabel95.setText("รหัสลูกค้า");
    jPanel14.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

    BI1.setEnabled(false);
    BI1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BI1ActionPerformed(evt);
        }
    });
    jPanel14.add(BI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 190, 30));

    jLabel96.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel96.setForeground(new java.awt.Color(0, 102, 255));
    jLabel96.setText("หมายเลขห้อง");
    jPanel14.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

    jLabel97.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel97.setForeground(new java.awt.Color(0, 102, 255));
    jLabel97.setText("เลขที่ใบเสร็จ");
    jPanel14.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 80, 30));

    jPanel14.add(ROOM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 190, 40));

    jPanel14.add(CUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 76, 190, 40));

    No13.setBackground(new java.awt.Color(0, 102, 255));
    No13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No13.setForeground(new java.awt.Color(255, 255, 255));
    No13.setText("ยกเลิก");
    No13.setBorder(null);
    No13.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No13MouseClicked(evt);
        }
    });
    jPanel14.add(No13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));
    jPanel14.add(dateCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 190, 30));

    F11.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 350, 630));

    jLabel86.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel86.setForeground(new java.awt.Color(0, 102, 255));
    jLabel86.setText("เพิ่มการจองห้องพัก");
    F11.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 180, 40));

    M4.add(F11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 350, 690));

    F12.setBackground(new java.awt.Color(255, 255, 255));
    F12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    No8.setBackground(new java.awt.Color(0, 102, 255));
    No8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No8.setForeground(new java.awt.Color(255, 255, 255));
    No8.setText("ยกเลิก");
    No8.setBorder(null);
    No8.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No8MouseClicked(evt);
        }
    });
    jPanel15.add(No8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 130, 50));

    OK8.setBackground(new java.awt.Color(0, 102, 255));
    OK8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK8.setForeground(new java.awt.Color(255, 255, 255));
    OK8.setText("บันทึก");
    OK8.setBorder(null);
    OK8.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK8MouseClicked(evt);
        }
    });
    jPanel15.add(OK8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 130, 50));
    jPanel15.add(A_ID_CUD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 190, 30));
    jPanel15.add(A_BI, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 190, 30));
    jPanel15.add(A_PRICE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 30));
    jPanel15.add(A_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, 30));

    jLabel98.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel98.setForeground(new java.awt.Color(0, 102, 255));
    jLabel98.setText("เลขที่ใบเสร็จ");
    jPanel15.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 80, 30));

    jLabel87.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel87.setForeground(new java.awt.Color(0, 102, 255));
    jLabel87.setText("รหัสการจอง");
    jPanel15.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 30));

    jLabel92.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel92.setForeground(new java.awt.Color(0, 102, 255));
    jLabel92.setText("ค่ามัดจำ");
    jPanel15.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 60, 30));

    jLabel99.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel99.setForeground(new java.awt.Color(0, 102, 255));
    jLabel99.setText("รหัสลูกค้า");
    jPanel15.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

    jLabel93.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel93.setForeground(new java.awt.Color(0, 102, 255));
    jLabel93.setText("ว/ด/ป ที่จอง");
    jPanel15.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, 30));
    jPanel15.add(A_IDROOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));
    jPanel15.add(A_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));

    jLabel100.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel100.setForeground(new java.awt.Color(0, 102, 255));
    jLabel100.setText("หมายเลขห้อง");
    jPanel15.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

    F12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 340, 630));

    jLabel94.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel94.setForeground(new java.awt.Color(0, 102, 255));
    jLabel94.setText("แก้ไขข้อมูลการจอง");
    F12.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 190, 40));

    M4.add(F12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 350, 690));

    Table_BOOKING.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane6.setViewportView(Table_BOOKING);

    M4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1120, 690));

    getContentPane().add(M4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

    M5.setBackground(new java.awt.Color(255, 255, 255));
    M5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel6.setBackground(new java.awt.Color(0, 102, 255));
    jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
    jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel45MouseClicked(evt);
        }
    });
    jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

    jLabel46.setBackground(new java.awt.Color(255, 255, 255));
    jLabel46.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel46.setForeground(new java.awt.Color(255, 255, 255));
    jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_Insomnia_104px.png"))); // NOI18N
    jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 150, 90));

    jLabel47.setBackground(new java.awt.Color(255, 255, 255));
    jLabel47.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel47.setForeground(new java.awt.Color(255, 255, 255));
    jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Back_52px.png"))); // NOI18N
    jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel47MouseClicked(evt);
        }
    });
    jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 100));

    jLabel48.setBackground(new java.awt.Color(255, 255, 255));
    jLabel48.setFont(new java.awt.Font("JasmineUPC", 3, 18)); // NOI18N
    jLabel48.setForeground(new java.awt.Color(255, 255, 255));
    jLabel48.setText("ย้อนกลับ");
    jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 50));

    jLabel49.setBackground(new java.awt.Color(255, 255, 255));
    jLabel49.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel49.setForeground(new java.awt.Color(255, 255, 255));
    jLabel49.setText("เช่าห้องพัก");
    jPanel6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 190, 60));

    M5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 130));

    F13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    Add_Customer4.setBackground(new java.awt.Color(0, 102, 255));
    Add_Customer4.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Add_Customer4.setForeground(new java.awt.Color(255, 255, 255));
    Add_Customer4.setText("เพิ่มการเช่าห้องพัก");
    Add_Customer4.setBorder(null);
    Add_Customer4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Add_Customer4MouseClicked(evt);
        }
    });
    F13.add(Add_Customer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 80));

    jButton6.setBackground(new java.awt.Color(255, 153, 153));
    jButton6.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    jButton6.setForeground(new java.awt.Color(255, 255, 255));
    jButton6.setText("ลบข้อมูล");
    jButton6.setBorder(null);
    jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton6MouseClicked(evt);
        }
    });
    F13.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 270, 80));

    Edit_Customer5.setBackground(new java.awt.Color(0, 102, 255));
    Edit_Customer5.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Edit_Customer5.setForeground(new java.awt.Color(255, 255, 255));
    Edit_Customer5.setText("แก้ไขข้อมูลห้องพัก");
    Edit_Customer5.setBorder(null);
    Edit_Customer5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Edit_Customer5MouseClicked(evt);
        }
    });
    F13.add(Edit_Customer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 270, 80));

    M5.add(F13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 350, 690));

    F14.setBackground(new java.awt.Color(255, 255, 255));
    F14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    No9.setBackground(new java.awt.Color(0, 102, 255));
    No9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No9.setForeground(new java.awt.Color(255, 255, 255));
    No9.setText("ยกเลิก");
    No9.setBorder(null);
    No9.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No9MouseClicked(evt);
        }
    });
    jPanel16.add(No9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK9.setBackground(new java.awt.Color(0, 102, 255));
    OK9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK9.setForeground(new java.awt.Color(255, 255, 255));
    OK9.setText("บันทึก");
    OK9.setBorder(null);
    OK9.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK9MouseClicked(evt);
        }
    });
    jPanel16.add(OK9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    jLabel116.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel116.setForeground(new java.awt.Color(0, 102, 255));
    jLabel116.setText("เลขที่สัญญาเช่า");
    jPanel16.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 30));

    jLabel117.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel117.setForeground(new java.awt.Color(0, 102, 255));
    jLabel117.setText("รหัสลูกค้า");
    jPanel16.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

    jLabel118.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel118.setForeground(new java.awt.Color(0, 102, 255));
    jLabel118.setText("หมายเลขห้อง");
    jPanel16.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

    jLabel119.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel119.setForeground(new java.awt.Color(0, 102, 255));
    jLabel119.setText("รหัสการจอง");
    jPanel16.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

    jLabel120.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel120.setForeground(new java.awt.Color(0, 102, 255));
    jLabel120.setText("ว/ด/ป ที่เช่าพัก");
    jPanel16.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));

    jLabel121.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel121.setForeground(new java.awt.Color(0, 102, 255));
    jLabel121.setText("ค่าประกัน");
    jPanel16.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, 30));

    jLabel122.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel122.setForeground(new java.awt.Color(0, 102, 255));
    jLabel122.setText("สถาณะสัญญาเช่า");
    jPanel16.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 110, 30));

    Q2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 เทอม", "2 เทอม", "3 เทอม", "4 เทอม", "5 เทอม", "6 เทอม", "7 เทอม", "8 เทอม", "9 เทอม", "10 เทอม" }));
    jPanel16.add(Q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 190, 30));
    jPanel16.add(Q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 190, 30));
    jPanel16.add(Q4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));
    jPanel16.add(Q7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 30));
    jPanel16.add(Q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, 30));

    jPanel16.add(Q5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, 40));

    jPanel16.add(Q6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 190, 40));

    F14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 350, 630));

    jLabel107.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel107.setForeground(new java.awt.Color(0, 102, 255));
    jLabel107.setText("เพิ่มการเช่าห้องพัก");
    F14.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 180, 40));

    M5.add(F14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 350, 690));

    F15.setBackground(new java.awt.Color(255, 255, 255));
    F15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    No10.setBackground(new java.awt.Color(0, 102, 255));
    No10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No10.setForeground(new java.awt.Color(255, 255, 255));
    No10.setText("ยกเลิก");
    No10.setBorder(null);
    No10.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No10MouseClicked(evt);
        }
    });
    jPanel17.add(No10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 130, 50));

    OK10.setBackground(new java.awt.Color(0, 102, 255));
    OK10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK10.setForeground(new java.awt.Color(255, 255, 255));
    OK10.setText("บันทึก");
    OK10.setBorder(null);
    OK10.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK10MouseClicked(evt);
        }
    });
    jPanel17.add(OK10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 130, 50));
    jPanel17.add(W5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 190, 30));
    jPanel17.add(W7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 30));
    jPanel17.add(W1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, 30));

    jLabel108.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel108.setForeground(new java.awt.Color(0, 102, 255));
    jLabel108.setText("สถาณะสัญญาเช่า");
    jPanel17.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 110, 30));

    jLabel109.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel109.setForeground(new java.awt.Color(0, 102, 255));
    jLabel109.setText("เลขที่สัญญาเช่า");
    jPanel17.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 30));

    jLabel110.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel110.setForeground(new java.awt.Color(0, 102, 255));
    jLabel110.setText("รหัสการจอง");
    jPanel17.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));

    jLabel111.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel111.setForeground(new java.awt.Color(0, 102, 255));
    jLabel111.setText("รหัสลูกค้า");
    jPanel17.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

    jLabel112.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel112.setForeground(new java.awt.Color(0, 102, 255));
    jLabel112.setText("ว/ด/ป ที่เช่าพัก");
    jPanel17.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));
    jPanel17.add(W6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));
    jPanel17.add(W4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));

    jLabel113.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel113.setForeground(new java.awt.Color(0, 102, 255));
    jLabel113.setText("หมายเลขห้อง");
    jPanel17.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

    jLabel115.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel115.setForeground(new java.awt.Color(0, 102, 255));
    jLabel115.setText("ค่าประกัน");
    jPanel17.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, 30));
    jPanel17.add(W3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 190, 30));

    W2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 เทอม", "2 เทอม", "3 เทอม", "4 เทอม", "5 เทอม", "6 เทอม", "7 เทอม", "8 เทอม", "9 เทอม", "10 เทอม" }));
    jPanel17.add(W2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 190, 30));

    F15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 350, 630));

    jLabel114.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel114.setForeground(new java.awt.Color(0, 102, 255));
    jLabel114.setText("แก้ไขข้อมูลการเช่า");
    F15.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 190, 40));

    M5.add(F15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 350, 690));

    Table_RENT.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane7.setViewportView(Table_RENT);

    M5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 150, 1120, 690));

    getContentPane().add(M5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

    M6.setBackground(new java.awt.Color(255, 255, 255));
    M6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel7.setBackground(new java.awt.Color(0, 102, 255));
    jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Shutdown_52px.png"))); // NOI18N
    jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel50MouseClicked(evt);
        }
    });
    jPanel7.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 60, 60));

    jLabel51.setBackground(new java.awt.Color(255, 255, 255));
    jLabel51.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel51.setForeground(new java.awt.Color(255, 255, 255));
    jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i3/icons8_Donate_104px_2.png"))); // NOI18N
    jPanel7.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 150, 120));

    jLabel52.setBackground(new java.awt.Color(255, 255, 255));
    jLabel52.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel52.setForeground(new java.awt.Color(255, 255, 255));
    jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auna/i1/icons8_Back_52px.png"))); // NOI18N
    jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel52MouseClicked(evt);
        }
    });
    jPanel7.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 100));

    jLabel53.setBackground(new java.awt.Color(255, 255, 255));
    jLabel53.setFont(new java.awt.Font("JasmineUPC", 3, 18)); // NOI18N
    jLabel53.setForeground(new java.awt.Color(255, 255, 255));
    jLabel53.setText("ย้อนกลับ");
    jPanel7.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 50));

    jLabel54.setBackground(new java.awt.Color(255, 255, 255));
    jLabel54.setFont(new java.awt.Font("JasmineUPC", 3, 48)); // NOI18N
    jLabel54.setForeground(new java.awt.Color(255, 255, 255));
    jLabel54.setText("รายการค่าใช้จ่าย");
    jPanel7.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 280, 60));

    M6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 130));

    F16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    Add_Customer5.setBackground(new java.awt.Color(0, 102, 255));
    Add_Customer5.setFont(new java.awt.Font("JasmineUPC", 1, 36)); // NOI18N
    Add_Customer5.setForeground(new java.awt.Color(255, 255, 255));
    Add_Customer5.setText("เพิ่มรายการค่าใช้จ่าย");
    Add_Customer5.setBorder(null);
    Add_Customer5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Add_Customer5MouseClicked(evt);
        }
    });
    F16.add(Add_Customer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 80));

    Edit_Customer6.setBackground(new java.awt.Color(0, 102, 255));
    Edit_Customer6.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
    Edit_Customer6.setForeground(new java.awt.Color(255, 255, 255));
    Edit_Customer6.setText("แก้ไขข้อมูลรายการค่าใช้จ่าย");
    Edit_Customer6.setBorder(null);
    Edit_Customer6.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            Edit_Customer6MouseClicked(evt);
        }
    });
    F16.add(Edit_Customer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 270, 80));

    No14.setBackground(new java.awt.Color(153, 153, 255));
    No14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No14.setForeground(new java.awt.Color(255, 255, 255));
    No14.setText("ปลิ้นใบเสร้จ");
    No14.setBorder(null);
    No14.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No14MouseClicked(evt);
        }
    });
    F16.add(No14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 270, 70));

    M6.add(F16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 140, 350, 700));

    F17.setBackground(new java.awt.Color(255, 255, 255));
    F17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    No11.setBackground(new java.awt.Color(0, 102, 255));
    No11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No11.setForeground(new java.awt.Color(255, 255, 255));
    No11.setText("ยกเลิก");
    No11.setBorder(null);
    No11.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No11MouseClicked(evt);
        }
    });
    jPanel18.add(No11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK11.setBackground(new java.awt.Color(0, 102, 255));
    OK11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK11.setForeground(new java.awt.Color(255, 255, 255));
    OK11.setText("บันทึก");
    OK11.setBorder(null);
    OK11.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK11MouseClicked(evt);
        }
    });
    jPanel18.add(OK11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    jLabel123.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel123.setForeground(new java.awt.Color(0, 102, 255));
    jLabel123.setText("รหัสรายการค่าใช้จ่าย");
    jPanel18.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, 30));

    jLabel124.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel124.setForeground(new java.awt.Color(0, 102, 255));
    jLabel124.setText("รหัสลูกค้า");
    jPanel18.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

    jLabel125.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel125.setForeground(new java.awt.Color(0, 102, 255));
    jLabel125.setText("หมายเลขห้อง");
    jPanel18.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

    jLabel126.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel126.setForeground(new java.awt.Color(0, 102, 255));
    jLabel126.setText("เลขที่สัญญาเช่า");
    jPanel18.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

    jLabel127.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel127.setForeground(new java.awt.Color(0, 102, 255));
    jLabel127.setText("ว/ด/ป ที่ชำระ");
    jPanel18.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));

    jLabel128.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel128.setForeground(new java.awt.Color(0, 102, 255));
    jLabel128.setText("ค่าอินเตอร์เน็ต");
    jPanel18.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 90, 30));
    jPanel18.add(LL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 90, 30));

    I3.setCalendarPreferredSize(new java.awt.Dimension(500, 400));
    jPanel18.add(I3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));
    jPanel18.add(I1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 190, 30));

    jLabel131.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel131.setForeground(new java.awt.Color(0, 102, 255));
    jLabel131.setText("ค่าปรับ");
    jPanel18.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 60, 30));
    jPanel18.add(I9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 190, 30));
    jPanel18.add(LL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 90, 30));

    jLabel134.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel134.setForeground(new java.awt.Color(0, 102, 255));
    jLabel134.setText("หน่วย");
    jPanel18.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 40, 30));
    jPanel18.add(LL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 90, 30));

    jLabel137.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel137.setForeground(new java.awt.Color(0, 102, 255));
    jLabel137.setText("ค่าไฟ");
    jPanel18.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 50, 30));

    I23.setText("จ่ายค่าหอรายเทอม");
    I23.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            I23ActionPerformed(evt);
        }
    });
    jPanel18.add(I23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 190, -1));

    jLabel138.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel138.setForeground(new java.awt.Color(0, 102, 255));
    jLabel138.setText("ค่าน้ำ");
    jPanel18.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 50, 30));

    jLabel139.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel139.setForeground(new java.awt.Color(0, 102, 255));
    jLabel139.setText("หน่วย");
    jPanel18.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 40, 30));

    jLabel140.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel140.setForeground(new java.awt.Color(0, 102, 255));
    jLabel140.setText("หน่วย");
    jPanel18.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 40, 30));
    jPanel18.add(I4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 190, -1));

    jLabel135.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel135.setForeground(new java.awt.Color(0, 102, 255));
    jLabel135.setText("เลขที่ใบเสร็จ");
    jPanel18.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 30));

    I7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            I7ActionPerformed(evt);
        }
    });
    jPanel18.add(I7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 190, 30));

    jPanel18.add(I8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));

    jPanel18.add(I80, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 30));

    F17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 350, 640));

    jLabel130.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel130.setForeground(new java.awt.Color(0, 102, 255));
    jLabel130.setText("เพิ่มรายการค่าใช้จ่าย");
    F17.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 200, 40));

    M6.add(F17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 140, 350, 700));

    T_E.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane8.setViewportView(T_E);

    M6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1120, 700));

    F18.setBackground(new java.awt.Color(255, 255, 255));
    F18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    No12.setBackground(new java.awt.Color(0, 102, 255));
    No12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    No12.setForeground(new java.awt.Color(255, 255, 255));
    No12.setText("ยกเลิก");
    No12.setBorder(null);
    No12.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            No12MouseClicked(evt);
        }
    });
    jPanel19.add(No12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, 130, 50));

    OK12.setBackground(new java.awt.Color(0, 102, 255));
    OK12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    OK12.setForeground(new java.awt.Color(255, 255, 255));
    OK12.setText("บันทึก");
    OK12.setBorder(null);
    OK12.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            OK12MouseClicked(evt);
        }
    });
    jPanel19.add(OK12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 130, 50));

    jLabel129.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel129.setForeground(new java.awt.Color(0, 102, 255));
    jLabel129.setText("รหัสรายการค่าใช้จ่าย");
    jPanel19.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 130, 30));

    jLabel132.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel132.setForeground(new java.awt.Color(0, 102, 255));
    jLabel132.setText("รหัสลูกค้า");
    jPanel19.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 70, 30));

    jLabel133.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel133.setForeground(new java.awt.Color(0, 102, 255));
    jLabel133.setText("หมายเลขห้อง");
    jPanel19.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 30));

    jLabel141.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel141.setForeground(new java.awt.Color(0, 102, 255));
    jLabel141.setText("เลขที่สัญญาเช่า");
    jPanel19.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

    jLabel142.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel142.setForeground(new java.awt.Color(0, 102, 255));
    jLabel142.setText("ว/ด/ป ที่ชำระ");
    jPanel19.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 30));

    jLabel143.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel143.setForeground(new java.awt.Color(0, 102, 255));
    jLabel143.setText("ค่าอินเตอร์เน็ต");
    jPanel19.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 90, 30));
    jPanel19.add(Z57, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 90, 30));
    jPanel19.add(dateChooserCombo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 30));
    jPanel19.add(Z60, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 30));
    jPanel19.add(Z61, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 30));
    jPanel19.add(Z62, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 190, 30));
    jPanel19.add(Z63, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 190, 30));

    jLabel144.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel144.setForeground(new java.awt.Color(0, 102, 255));
    jLabel144.setText("เลขที่ใบเสร็จ");
    jPanel19.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 30));
    jPanel19.add(Z64, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 190, 30));
    jPanel19.add(Z65, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 90, 30));

    jLabel145.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel145.setForeground(new java.awt.Color(0, 102, 255));
    jLabel145.setText("หน่วย");
    jPanel19.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 40, 30));
    jPanel19.add(Z66, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 90, 30));

    jLabel146.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel146.setForeground(new java.awt.Color(0, 102, 255));
    jLabel146.setText("ค่าไฟ");
    jPanel19.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 50, 30));

    jCheckBox2.setText("จ่ายค่าหอรายเทอม");
    jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox2ActionPerformed(evt);
        }
    });
    jPanel19.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 190, -1));

    jLabel147.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel147.setForeground(new java.awt.Color(0, 102, 255));
    jLabel147.setText("ค่าน้ำ");
    jPanel19.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 50, 30));

    jLabel148.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel148.setForeground(new java.awt.Color(0, 102, 255));
    jLabel148.setText("หน่วย");
    jPanel19.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 40, 30));

    jLabel149.setFont(new java.awt.Font("JasmineUPC", 1, 18)); // NOI18N
    jLabel149.setForeground(new java.awt.Color(0, 102, 255));
    jLabel149.setText("หน่วย");
    jPanel19.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 40, 30));

    F18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 350, 630));

    jLabel150.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
    jLabel150.setForeground(new java.awt.Color(0, 102, 255));
    jLabel150.setText("แก้ไขข้อมุลรายการค่าใช้จ่าย");
    F18.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 4, 200, 40));

    M6.add(F18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 140, 350, 700));

    getContentPane().add(M6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 850));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1MouseClicked
        M1.show();
        HOME.hide();
        
        Show_Table_Customer();
    }//GEN-LAST:event_L1MouseClicked

    private void L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2MouseClicked
     ///ห้องพีก
        Show_Table_Room();
        M2.show();
       HOME.hide();
    }//GEN-LAST:event_L2MouseClicked

    private void L3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3MouseClicked
       Show_Table_Expenses();
        M3.show();
       HOME.hide();
    }//GEN-LAST:event_L3MouseClicked

    private void L4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L4MouseClicked
     Show_Table_Booking();
        
        M4.show();
      HOME.hide();
      
    }//GEN-LAST:event_L4MouseClicked

    private void L5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L5MouseClicked
        Show_Table_Rent();
        M5.show();
        HOME.hide();
    }//GEN-LAST:event_L5MouseClicked

    private void L6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L6MouseClicked
  Show_Table_Rent();
        M6.show();
       HOME.hide();
    }//GEN-LAST:event_L6MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        M();
        HOME.show();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
         M();
        HOME.show();
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        M();
        HOME.show();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
         M();
        HOME.show();
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        M();
        HOME.show();
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
          M();
        HOME.show();
    }//GEN-LAST:event_jLabel52MouseClicked

    private void Add_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_CustomerMouseClicked
       ran();
        F2.show();
        F1.hide();
        
    }//GEN-LAST:event_Add_CustomerMouseClicked
 int select = 0;
    private void Edit_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_CustomerMouseClicked
        //แก้ไขข้อมูล ลูกค้า
        select = TableCustomer.getSelectedRow();
        //        Cutomer_Update c=new Cutomer_Update();
        
         System.out.println(select);
         U1.setText(TableCustomer.getValueAt(select, 0).toString());      
         U2.setSelectedItem(TableCustomer.getValueAt(select, 1).toString());
         U3.setText(TableCustomer.getValueAt(select, 2).toString());
         U4.setText(TableCustomer.getValueAt(select, 3).toString());
         U01.setSelectedItem(TableCustomer.getValueAt(select, 4));
         U5.setText(TableCustomer.getValueAt(select, 5).toString());
        
          Udate.setText(TableCustomer.getValueAt(select, 6).toString().substring(0, 11));
        // U7.setText(daay);
          U6.setText(TableCustomer.getValueAt(select, 8).toString());
         //c.yyy.setText("");
         //.parse((String)Table_Customer.getValueAt(select, 6).toString();
         
         U8.setText(TableCustomer.getValueAt(select, 9).toString());
         U9.setText(TableCustomer.getValueAt(select, 10).toString());
        
//        
        
        F3.show();
        F1.hide();
        
    }//GEN-LAST:event_Edit_CustomerMouseClicked

    private void OK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK1MouseClicked
       //เพิ่มลูกค้า 
         String sDate = "2013-08-03";
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       String  ID =Z1.getText();
       String  Tn =Z2.getSelectedItem().toString();
       String  Fn =Z3.getText();
       String  Ln =Z4.getText();
       String  Card =Z5.getText();
       String  address =Z6.getText();
       String  date =Z7.getText();
       String  phone =Z8.getText();
       String  Rphone =Z9.getText();
       
       //หาอายุ
       String Year = date.substring(8, date.length());
        int Y = Integer.valueOf(Year.trim());
        int Y2 = 2018 - Y;
        String Year2 = Integer.toString(Y2);
       //หาเพศ
       String sex = null;
        if (Tn.equals("นาย")) {
            sex = "M";
        }
        if (Tn.equals("นางสาว")) {
            sex = "F";
        }
        if (Tn.equals("นาง")) {
            sex = "F";
        }
         //ตารางลูกค้า
        try {
            Connection con = connect();
            String sql = "insert into customer(ID,TNAME,NAME,LNAME,SEX,CARD_ID,BIRTHDAY,AGE)values ('" + ID+ "','" +Tn+ "','" + Fn+ "','" + Ln+ "','" + sex + "'," + Card + ",'"+date+"',"+Year2+")";//เพศ   
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        //บันทึกเบอร์โทร์\ ถ้ามีแค่เบอร์เดียว
         try {
            Connection con = connect();
             String sql = "insert into \"CUSTOMER_NPHONE\" (ID, NUMBERPHONE) values('"+ID+"','"+phone.trim()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
         //บันทึกเบอร์โทรญาติ
         try {
            Connection con = connect();
             String sql = "insert into \"RELATIVE_NPHONE\" (ID, RELATIVE_NPHONE) values('"+ID+"','"+Rphone.trim()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        
        //บันทึกที่อยู่
         try {
            Connection con = connect();
            String sql = "insert into \"CUSTOMER_ADDRESS\" (ID, ADDRESS) values('"+ID+"','"+address+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
         Show_Table_Customer();
        F1.show();
        F2.hide();
       
    }//GEN-LAST:event_OK1MouseClicked

    private void No2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No2MouseClicked
       F2.hide();
       F1.show();
    }//GEN-LAST:event_No2MouseClicked

    private void OK2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK2MouseClicked
        //แก้ไขข้อมูลลูกค้า
        String ID=U1.getText();
        try {
            String sql="UPDATE CUSTOMER_NPHONE SET NUMBERPHONE='"+U8.getText()+"'"
                    + "WHERE ID='"+ID+"'";
            stm=con.createStatement();
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error เบอร์โทร \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql="UPDATE CUSTOMER_ADDRESS SET ADDRESS='"+U6.getText()+"'"
                    + "WHERE ID='"+ID+"'";
            stm=con.createStatement();
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error ที่อยู่\n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        try {
            String sql="UPDATE RELATIVE_NPHONE SET RELATIVE_NPHONE='"+U9.getText()+"'"
                    + "WHERE ID='"+ID+"'";
            stm=con.createStatement();
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error เบอร์โทรลูกค้า\n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
     try {
            String Tn=U2.getSelectedItem().toString();
            String sex = null;
        if (Tn.equals("นาย")) {
            sex = "M";
        }
        if (Tn.equals("นางสาว")) {
            sex = "F";
        }
        if (Tn.equals("นาง")) {
            sex = "F";
        }//0000-00-00
        String DDD =Udate.getText().substring(5, 7);
        String Y =Udate.getText().substring(0, 4);
        String D =Udate.getText().substring(8, 10);
        
        int YYYY =Integer.parseInt(Y);
        int YY =2018-YYYY;
        //
    
        String DaTe = null;
        if(DDD.equals("01")){
            DaTe="ม.ค.";
        }if(DDD.equals("02")){
             DaTe="ก.พ.";
        }if(DDD.equals("03")){
             DaTe="มี.ค.";
        }if(DDD.equals("04")){
             DaTe="เม.ย";
        }if(DDD.equals("05")){
             DaTe="พ.ค.";
        }if(DDD.equals("06")){
             DaTe="มิ.ย.";
        }if(DDD.equals("07")){
             DaTe="ก.ค.";
        }if(DDD.equals("08")){
             DaTe="ส.ค.";
        }if(DDD.equals("09")){
             DaTe="ก.ย.";
        }if(DDD.equals("10")){
             DaTe="ต.ค.";
        }if(DDD.equals("11")){
             DaTe="พ.ย.";
        }if(DDD.equals("12")){
             DaTe="ธ.ค.";
        }
        String Date1 =D+" "+DaTe+" "+Y;
        System.out.println(""+U2.getSelectedItem().toString());
         System.out.println(""+U1.getText());
         System.out.println(""+U3.getText());
         System.out.println(""+U4.getText());
         System.out.println(""+U01.getSelectedItem().toString());
         System.out.println(""+U5.getText());
         System.out.println(""+U6.getText());
            String sql="UPDATE CUSTOMER SET CUSTOMER.TNAME='"+U2.getSelectedItem().toString()+"',\n" +
"                    CUSTOMER.NAME='"+U3.getText()+"',\n" +
"                    CUSTOMER.LNAME ='"+U4.getText()+"',\n" +
"                    CUSTOMER.SEX='"+U01.getSelectedItem().toString()+"',\n" +
"                    CUSTOMER.CARD_ID="+U5.getText()+",\n" +
"                    CUSTOMER.BIRTHDAY='"+Date1+"',\n" +
"                    AGE=20\n" +
"                    WHERE ID='"+ID+"'";
            stm=con.createStatement();
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error ลูกค้า \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
                 
        Show_Table_Customer();
        F3.hide();
       F1.show();
    }//GEN-LAST:event_OK2MouseClicked

    private void NoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoMouseClicked
        F3.hide();
       F1.show();
    }//GEN-LAST:event_NoMouseClicked

    private void Add_Customer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Customer1MouseClicked
       randomNUMBER_Room();
        F4.hide();
        F5.show();
    }//GEN-LAST:event_Add_Customer1MouseClicked

    private void No3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No3MouseClicked
      F4.show();
      F5.hide();
    }//GEN-LAST:event_No3MouseClicked

    private void OK3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK3MouseClicked
      //เพิ่มห้อง
      String R_id=ZZ1.getText();
      String Status = ZZ2.getSelectedItem().toString();
      String type =ZZ3.getSelectedItem().toString();
       String Pirce =ZZ4.getText();
      int TTT=0;
      if(type.equals("บ้าน")){
          TTT=1;
      }
      if(type.equals("ตึก")){
          TTT=2;
      }
        System.out.println(""+R_id+"  "+Status+"   "+TTT+"  ");
       try {
            Connection con = connect();
             String sql = "insert into \"ROOM\" (ROOM_NUMBER, ROOM_STATUS,ROOM_TYPE_CODE) values('"+R_id+"','"+Status+"',"+TTT+")";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
      
        Show_Table_Room();
        
        F4.show();
       F5.hide();
    }//GEN-LAST:event_OK3MouseClicked

    private void Edit_Customer2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_Customer2MouseClicked
       int s =TABLE_ROOM.getSelectedRow();
       C1.setText(TABLE_ROOM.getValueAt(s, 0).toString());
       C2.setSelectedItem(TABLE_ROOM.getValueAt(s, 1).toString());
       C3.setSelectedItem(TABLE_ROOM.getValueAt(s, 2).toString());
      // C4.setText(string);
       C5.setText(TABLE_ROOM.getValueAt(s, 3).toString());
        
        
        F4.hide();
       F6.show();
    }//GEN-LAST:event_Edit_Customer2MouseClicked

    private void No4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No4MouseClicked
        F4.show();
        F6.hide();
    }//GEN-LAST:event_No4MouseClicked

    private void OK5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK5MouseClicked
       //บันทึกห้องพัก
      String type =C3.getSelectedItem().toString();
      int TTT=0;
      if(type.equals("บ้าน")){
          TTT=1;
      }
      if(type.equals("ตึก")){
          TTT=2;
      }
        try {
            Connection con = connect();
             String sql = "UPDATE ROOM SET ROOM_STATUS = '"+C2.getSelectedItem().toString()+"',ROOM_TYPE_CODE="+TTT+"\n" +
"WHERE ROOM_NUMBER ='"+ C1.getText()+"'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("อัพ++++++++++++++++++++++++++++++++++++++++++++++++++");
         try {
            Connection con = connect();
             String sql = "UPDATE ROOM_TYPE SET ROOM_TYPE.ROOM_PRICE='"+C5.getText()+"' WHERE ROOM_TYPE_CODE ="+TTT+"";
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Room();
        F4.show();
        F6.hide();
    }//GEN-LAST:event_OK5MouseClicked

    private void Add_Customer2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Customer2MouseClicked
       Show_Table_Expenses();
        F8.show();
       F7.hide();
    }//GEN-LAST:event_Add_Customer2MouseClicked

    private void Edit_Customer3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_Customer3MouseClicked
      int s =EX1.getSelectedRow();
      String i =EX1.getValueAt(s, 0).toString();
      String i2 =EX1.getValueAt(s, 1).toString();
      String i3 =EX1.getValueAt(s, 2).toString();
        
        K1.setText(i);
        K2.setText(i2);
        K3.setText(i3);
        F9.show();
       F7.hide();
    }//GEN-LAST:event_Edit_Customer3MouseClicked

    private void No5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No5MouseClicked
        F8.hide();
        F7.show();
    }//GEN-LAST:event_No5MouseClicked

    private void OK4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK4MouseClicked
         
        try {
            Connection con = connect();
             String sql = "insert into \"EXPENSES\" (EXPENSES_CODE,EXPENSES_NAME,EXPENSES_PRICE) values('"+J1.getText()+"','"+J2.getText()+"',"+J3.getText()+")";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
       Show_Table_Expenses();
        
        F8.hide();
      F7.show();
    }//GEN-LAST:event_OK4MouseClicked

    private void No6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No6MouseClicked
       F9.hide();
       F7.show();
    }//GEN-LAST:event_No6MouseClicked

    private void OK6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK6MouseClicked
       
        try {
            Connection con = connect();
             String sql = "UPDATE EXPENSES SET EXPENSES_NAME ='"+K2.getText()+"' ,EXPENSES_PRICE ="+K3.getText()+"WHERE EXPENSES_CODE ="+K1.getText()+"";
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Expenses();
        F9.hide();
       F7.show();
    }//GEN-LAST:event_OK6MouseClicked

    private void Add_Customer3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Customer3MouseClicked
     ArrayList arr=new ArrayList();
      ArrayList arr2=new ArrayList();
        
        try {
            Connection con = connect();
            String sql = "select * FROM CUSTOMER";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
               arr.add(rs.getString(1));
               String rr =(String) arr.get(i);
                System.out.println(""+rr);
              CUS.addItem(rr);  
              i++;
            }
            
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
        
          try {
            Connection con = connect();
            String sql = "select * FROM ROOM";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
                
               arr2.add(rs.getString(1));
               String rr =(String) arr2.get(i);
                System.out.println(""+rr);
              ROOM3.addItem(rr);  
              i++;
            }
            
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
        ID_BOOKING();
        ID_BOOKING_2();
        
        F10.hide();
      F11.show();
    }//GEN-LAST:event_Add_Customer3MouseClicked

    private void Edit_Customer4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_Customer4MouseClicked
       int s =Table_BOOKING.getSelectedRow();
       A_Booking.setText(Table_BOOKING.getValueAt(s, 0).toString());
       A_PRICE.setText(Table_BOOKING.getValueAt(s, 1).toString());
       A_IDROOM.setText(Table_BOOKING.getValueAt(s, 3).toString());
       A_ID_CUD.setText(Table_BOOKING.getValueAt(s, 4).toString());
       A_BI.setText(Table_BOOKING.getValueAt(s, 5).toString()); 
        
        F10.hide();
      F12.show();
    }//GEN-LAST:event_Edit_Customer4MouseClicked

    private void No7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No7MouseClicked
     
        //ปริ้นใบเสร็จ
        MessageFormat header =new MessageFormat("ใบเสร็จ การจอง");
        try {
            Table_BOOKING.print(JTable.PrintMode.FIT_WIDTH,header,null);
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_No7MouseClicked

    private void OK7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK7MouseClicked
       //จองงง
       try {
            Connection con = connect();
             String sql = "insert into RECEIPT(RECEIPT_NUMBER,RECEIPT_DATE) VALUES('"+BI1.getText()+"','"+dateCombo1.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
       
       try {
            Connection con = connect();
             String sql = "insert into \"BOOKING\" (BOOKING_CODE ,BOOKING_DEPOSIT,BOOKING_DATE,ROOM_NUMBER,ROOM_CUSTOMER_ID,ROOM_RECEIPT_NUMBER) "
                                          + "values('"+O1.getText()+"',"+O2.getText()+",'"+dateCombo1.getText()+"','"+ROOM3.getSelectedItem()+"','"+CUS.getSelectedItem()+"','"+BI1.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
       Show_Table_Booking();
        F10.show();
      F11.hide();
    }//GEN-LAST:event_OK7MouseClicked

    private void No8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No8MouseClicked
        F10.show();
      F12.hide();
    }//GEN-LAST:event_No8MouseClicked

    private void OK8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK8MouseClicked
      /****/
         try {
            Connection con = connect();
             String sql = "UPDATE  RECEIPT SET RECEIPT_DATE ='"+A_date.getText()+"'  WHERE  RECEIPT_NUMBER='"+A_BI.getText()+"' ";
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error 123123:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
         try {
            Connection con = connect();
             String sql = "UPDATE  BOOKING SET BOOKING_CODE ='"+A_Booking.getText()+"',BOOKING_DEPOSIT ='"+A_PRICE.getText()+"',BOOKING_DATE='"+A_date.getText()+"',ROOM_NUMBER ='"+A_IDROOM.getText()+"',ROOM_CUSTOMER_ID='"+A_ID_CUD.getText()+"',ROOM_RECEIPT_NUMBER='"+A_BI.getText()+"' "
                     + " WHERE  ROOM_RECEIPT_NUMBER='"+A_BI.getText()+"' ";
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Booking();
        F12.hide();
       F10.show();
    }//GEN-LAST:event_OK8MouseClicked

    private void No9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No9MouseClicked
        F14.hide();
       F13.show();
    }//GEN-LAST:event_No9MouseClicked

    private void OK9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK9MouseClicked
       
        //****9999
        try {
            Connection con = connect();
             String sql = "insert into RENT(RENT_CODE,RENT_STATUS,RENT_LNSURANCE,RENT_DATE_IN,RENT_CUSTOMER_ID,RENT_ROOM_NUMBER,RENT_BOOKING_CODE) "
                     + "VALUES('"+Q1.getText()+"','"+Q2.getSelectedItem()+"',"+Q3.getText()+",'"+Q4.getText()+"','"+Q5.getSelectedItem()+"','"+Q6.getSelectedItem()+"','"+Q7.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Rent();
        F14.hide();
       F13.show();
               
            
    }//GEN-LAST:event_OK9MouseClicked

    private void Add_Customer4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Customer4MouseClicked
        ArrayList arr=new ArrayList();
      ArrayList arr2=new ArrayList();
        
        try {
            Connection con = connect();
            String sql = "select * FROM CUSTOMER";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
               arr.add(rs.getString(1));
               String rr =(String) arr.get(i);
                System.out.println(""+rr);
              Q5.addItem(rr);  
              i++;
            }
            
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }try {
            Connection con = connect();
            String sql = "select * FROM ROOM";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
                
               arr2.add(rs.getString(1));
               String rr =(String) arr2.get(i);
                System.out.println(""+rr);
              Q6.addItem(rr);  
              i++;
            }
            
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }
        
       
        
        ID_RENT();
        
        F14.show();
       F13.hide();
    }//GEN-LAST:event_Add_Customer4MouseClicked

    private void Edit_Customer5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_Customer5MouseClicked
       int i =Table_RENT.getSelectedRow();
        System.out.println(i);
           W1.setText(Table_RENT.getValueAt(i, 0).toString());
        W2.setSelectedItem(Table_RENT.getValueAt(i, 1));
        W3.setText(Table_RENT.getValueAt(i, 2).toString());
        W4.setText(Table_RENT.getValueAt(i, 3).toString());
        W5.setText(Table_RENT.getValueAt(i, 4).toString());
        W6.setText(Table_RENT.getValueAt(i, 5).toString());
        try {
            W7.setText(Table_RENT.getValueAt(i, 6).toString());
        } catch (Exception e) {
        }
        F15.show();
       F13.hide();
    }//GEN-LAST:event_Edit_Customer5MouseClicked

    private void No10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No10MouseClicked
      F15.hide();
      F13.show();
    }//GEN-LAST:event_No10MouseClicked

    private void OK10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK10MouseClicked
     
         try {
            Connection con = connect();
             String sql = "UPDATE RENT SET RENT_CODE='"+W1.getText()+"' ,RENT_STATUS ='"+W2.getSelectedItem()+"',RENT_LNSURANCE ="+W3.getText()+",RENT_DATE_IN ='"+W4.getText()+"',RENT_CUSTOMER_ID ='"+W5.getText()+"',RENT_ROOM_NUMBER ='"+W6.getText()+"',RENT_BOOKING_CODE ='"+W7.getText()+"'"
                     + " WHERE  RENT_CODE='"+W1.getText()+"' ";
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        
        Show_Table_Rent();
        
        F15.hide();
      F13.show();
    }//GEN-LAST:event_OK10MouseClicked

    private void Add_Customer5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Customer5MouseClicked
           ArrayList arr3 = new ArrayList();
        

        try {
            Connection con = connect();
            String sql = "select BOOKING_CODE FROM BOOKING";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                arr3.add(rs);
            }
            Random ran = new Random();
            int id = ran.nextInt(100000000);
            int number = 100000000;
            int idnumber;
            idnumber = id + number;
            String ID = "E".concat(Integer.toString(idnumber));
            arr3.add(ID);
            int i1 = 0;

            String ID2 = null;
            while (rs.next()) {
                if (rs.getString(i1).equals(arr3.get(0))) {
                    do {
                        int id2 = ran.nextInt(100000000);
                        int number2 = 100000000;
                        int idnumber2;
                        idnumber2 = id + number2;
                        ID2 = "E".concat(Integer.toString(idnumber2));
                    } while (ID2.equals(arr3.get(0)));
                    I9.setText(ID2);

                } else {
                    I9.setText(ID);
                }
            }

            I9.setText(ID);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error :"+ ex,null,JOptionPane.WARNING_MESSAGE);
        }        
        /******************/
        ArrayList arr=new ArrayList();
      ArrayList arr2=new ArrayList();
        
        try {
            Connection con = connect();
            String sql = "select * FROM CUSTOMER";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
               arr.add(rs.getString(1));
               String rr =(String) arr.get(i);
                System.out.println(""+rr);
              I7.addItem(rr);  
              i++;
            }
        }catch(Exception e){
            
        }
        ID_EX();
        
        F17.show();
       F16.hide();
    }//GEN-LAST:event_Add_Customer5MouseClicked

    private void No11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No11MouseClicked
           F17.hide();
       F16.show();
    }//GEN-LAST:event_No11MouseClicked

    private void OK11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK11MouseClicked
    
      
        
        
        
        
        
        int Water=Integer.parseInt(LL1.getText())*10;
     int Fi=Integer.parseInt(LL2.getText())*10;
     int net=Integer.parseInt(LL3.getText())*300;
     int P=Integer.parseInt(I4.getText());
     int I5=1;
     int sum =Water+Fi+net+P+17000;
     
     
         try {
            Connection con = connect();
             String sql = "insert into RECEIPT(RECEIPT_NUMBER,RECEIPT_DATE) VALUES('"+I9.getText()+"','"+I3.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("บันทึกแล้ว");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
    
   Show_Table_Rent();
    
        F17.hide();
       F16.show();
    }//GEN-LAST:event_OK11MouseClicked

    private void I23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_I23ActionPerformed

    private void No12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No12MouseClicked
        F18.hide();
       F16.show();
    }//GEN-LAST:event_No12MouseClicked

    private void OK12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK12MouseClicked
       F18.hide();
       F16.show();
    }//GEN-LAST:event_OK12MouseClicked

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void Z3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Z3KeyTyped
       Z3.setSelectionStart(49);
       
    }//GEN-LAST:event_Z3KeyTyped

    private void Z4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Z4KeyTyped
       Z4.setSelectionStart(49);
    }//GEN-LAST:event_Z4KeyTyped

    private void Z8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Z8KeyTyped
       Z8.setSelectionStart(9);
    }//GEN-LAST:event_Z8KeyTyped

    private void Z9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Z9KeyTyped
      Z9.setSelectionStart(9);
    }//GEN-LAST:event_Z9KeyTyped

    private void Z5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Z5KeyTyped
       Z5.setSelectionStart(12);
    }//GEN-LAST:event_Z5KeyTyped

    private void Z6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Z6KeyTyped
      Z6.setSelectionStart(149);
    }//GEN-LAST:event_Z6KeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       ran();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int s =TableCustomer.getSelectedRow();
        String ID =TableCustomer.getValueAt(s, 0).toString();
        System.out.println(ID);
        String sql1="DELETE FROM CUSTOMER_NPHONE\n" +
"WHERE ID='"+ID+"'";
        try {
            stm =con.createStatement();
            stm.execute(sql1);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error เบอร์โทรลูกค้า\n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        
           try {
                 String sql2="DELETE FROM CUSTOMER_ADDRESS\n" +
"WHERE ID='"+ID+"'";
            stm =con.createStatement();
            stm.execute(sql2);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
           
           try {
                 String sql3="DELETE FROM RELATIVE_NPHONE\n" +
"WHERE ID='"+ID+"'";
            stm =con.createStatement();
            stm.execute(sql3);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
           try {
                 String sql4="DELETE FROM CUSTOMER\n" +
"WHERE ID='"+ID+"'";
            stm =con.createStatement();
            stm.execute(sql4);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Customer();
    }//GEN-LAST:event_jButton2MouseClicked

    private void ZZ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZZ1ActionPerformed
       randomNUMBER_Room();
    }//GEN-LAST:event_ZZ1ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
      int s =TABLE_ROOM.getSelectedRow();
      String id =TABLE_ROOM.getValueAt(s, 0).toString();
      String TYPE =TABLE_ROOM.getValueAt(s, 2).toString();
      
    
         try {
                 String sql4="DELETE FROM ROOM\n" +
"WHERE ROOM_NUMBER='"+id+"'";
            stm =con.createStatement();
            stm.execute(sql4);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Room();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        int s =EX1.getSelectedRow();
        String i=EX1.getValueAt(s, 0).toString();
        
        
        try {
                 String sql4="DELETE FROM EXPENSES\n" +
"WHERE EXPENSES_CODE="+i+"";
            stm =con.createStatement();
            stm.execute(sql4);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        Show_Table_Expenses();
    }//GEN-LAST:event_jButton4MouseClicked

    private void BI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BI1ActionPerformed

    private void No13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_No13MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        int s =Table_BOOKING.getSelectedRow();
        String i=Table_BOOKING.getValueAt(s, 0).toString();
        
         try {
                 String sql4="DELETE FROM BOOKING\n" +
"WHERE BOOKING_CODE='"+i+"'";
            stm =con.createStatement();
            stm.execute(sql4);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
        
        Show_Table_Booking();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
       int y =Table_RENT.getSelectedRow();
        String i=Table_RENT.getValueAt(y, 0).toString();
        
         try {
                 String sql4="DELETE FROM RENT\n" +
"WHERE RENT_CODE='"+i+"'";
            stm =con.createStatement();
            stm.execute(sql4);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error \n:"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
       Show_Table_Rent();
    }//GEN-LAST:event_jButton6MouseClicked

    private void I7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I7ActionPerformed
           ArrayList arr=new ArrayList();
               ArrayList arr2=new ArrayList();
               I80.setSelectedItem(null);
                I8.setSelectedItem(null);

        try {
            Connection con = connect();
            String sql = "select RENT.RENT_CODE, RENT_ROOM_NUMBER FROM RENT WHERE RENT_CUSTOMER_ID ='"+I7.getSelectedItem()+"'";
            ResultSet rs = con.createStatement().executeQuery(sql);
          
            while (rs.next()) {
              
              I80.addItem(rs.getString(1).toString());  
              I8.addItem(rs.getString(2).toString());
             
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_I7ActionPerformed

    private void No14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No14MouseClicked
        //
        MessageFormat h =new MessageFormat("ใบเสร็จ");
        try {
            T_E.print(JTable.PrintMode.FIT_WIDTH,h,null);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_No14MouseClicked

    private void Edit_Customer6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_Customer6MouseClicked
        F18.show();
        F16.hide();
    }//GEN-LAST:event_Edit_Customer6MouseClicked

    private void address2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_address2MouseClicked
          ArrayList arr = new ArrayList();
        try {
            Connection con = connect();
            String sql = "select * FROM CUSTOMER";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
               arr.add(rs.getString(1));
               String rr =(String) arr.get(i);
                System.out.println(""+rr);
             E55.addItem(rr);  
              i++;
            }
        }catch(Exception e){
            
        }
        F1.hide();
        F20.show();
    }//GEN-LAST:event_address2MouseClicked

    private void Add_phoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_phoneMouseClicked
         ArrayList arr = new ArrayList();
        try {
            Connection con = connect();
            String sql = "select * FROM CUSTOMER";
            ResultSet rs = con.createStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
               arr.add(rs.getString(1));
               String rr =(String) arr.get(i);
                System.out.println(""+rr);
             CCC1.addItem(rr);  
              i++;
            }
        }catch(Exception e){
            
        }
        F1.hide();
        F19.show();
    }//GEN-LAST:event_Add_phoneMouseClicked

    private void No15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No15MouseClicked
         F20.hide();
         F1.show();
    }//GEN-LAST:event_No15MouseClicked

    private void OK14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK14MouseClicked
        //บันทึกที่อยู่
         try {
            Connection con = connect();
            String sql = "insert into \"CUSTOMER_ADDRESS\" (ID, ADDRESS) values('"+E55.getSelectedItem()+"','"+A55.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
         Show_Table_Customer();
         F20.hide();
         F1.show();
    }//GEN-LAST:event_OK14MouseClicked

    private void OK13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK13MouseClicked
      try {
            Connection con = connect();
             String sql = "insert into \"CUSTOMER_NPHONE\" (ID, NUMBERPHONE) values('"+CCC1.getSelectedItem()+"','"+nn1.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
           //  JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
         //บันทึกเบอร์โทรญาติ
         try {
            Connection con = connect();
             String sql = "insert into \"RELATIVE_NPHONE\" (ID, RELATIVE_NPHONE) values('"+CCC1.getSelectedItem()+"','"+nn2.getText()+"')";
            ResultSet rs = con.createStatement().executeQuery(sql);
        } catch (Exception e) {
           //  JOptionPane.showMessageDialog(null,"Error :"+ e,null,JOptionPane.WARNING_MESSAGE);
        }
         JOptionPane.showMessageDialog(null,"บันทึกแล้ว:");
         Show_Table_Customer();
         F19.hide();
         F1.show();
    }//GEN-LAST:event_OK13MouseClicked
      
    private void No1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_No1MouseClicked
         F19.hide();
         F1.show();
    }//GEN-LAST:event_No1MouseClicked
      int xx,yy;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {    /**
     * @param args the command line arguments
     */
    
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
            java.util.logging.Logger.getLogger(AUNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AUNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AUNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AUNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AUNA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea A55;
    private javax.swing.JTextField A_BI;
    private javax.swing.JTextField A_Booking;
    private javax.swing.JTextField A_IDROOM;
    private javax.swing.JTextField A_ID_CUD;
    private javax.swing.JTextField A_PRICE;
    private datechooser.beans.DateChooserCombo A_date;
    private javax.swing.JButton Add_Customer;
    private javax.swing.JButton Add_Customer1;
    private javax.swing.JButton Add_Customer2;
    private javax.swing.JButton Add_Customer3;
    private javax.swing.JButton Add_Customer4;
    private javax.swing.JButton Add_Customer5;
    private javax.swing.JButton Add_phone;
    private javax.swing.JTextField BI1;
    private javax.swing.JTextField C1;
    private javax.swing.JComboBox<String> C2;
    private javax.swing.JComboBox<String> C3;
    private javax.swing.JTextField C5;
    private javax.swing.JComboBox<String> CCC1;
    private javax.swing.JComboBox<String> CUS;
    private javax.swing.JComboBox<String> E55;
    private javax.swing.JTable EX1;
    private javax.swing.JButton Edit_Customer;
    private javax.swing.JButton Edit_Customer2;
    private javax.swing.JButton Edit_Customer3;
    private javax.swing.JButton Edit_Customer4;
    private javax.swing.JButton Edit_Customer5;
    private javax.swing.JButton Edit_Customer6;
    private javax.swing.JPanel F1;
    private javax.swing.JPanel F10;
    private javax.swing.JPanel F11;
    private javax.swing.JPanel F12;
    private javax.swing.JPanel F13;
    private javax.swing.JPanel F14;
    private javax.swing.JPanel F15;
    private javax.swing.JPanel F16;
    private javax.swing.JPanel F17;
    private javax.swing.JPanel F18;
    private javax.swing.JPanel F19;
    private javax.swing.JPanel F2;
    private javax.swing.JPanel F20;
    private javax.swing.JPanel F3;
    private javax.swing.JPanel F4;
    private javax.swing.JPanel F5;
    private javax.swing.JPanel F6;
    private javax.swing.JPanel F7;
    private javax.swing.JPanel F8;
    private javax.swing.JPanel F9;
    private javax.swing.JPanel HOME;
    private javax.swing.JTextField I1;
    private javax.swing.JCheckBox I23;
    private datechooser.beans.DateChooserCombo I3;
    private javax.swing.JTextField I4;
    private javax.swing.JComboBox<String> I7;
    private javax.swing.JComboBox<String> I8;
    private javax.swing.JComboBox<String> I80;
    private javax.swing.JTextField I9;
    private javax.swing.JTextField J1;
    private javax.swing.JTextField J2;
    private javax.swing.JTextField J3;
    private javax.swing.JTextField K1;
    private javax.swing.JTextField K2;
    private javax.swing.JTextField K3;
    private javax.swing.JPanel L1;
    private javax.swing.JPanel L2;
    private javax.swing.JPanel L3;
    private javax.swing.JPanel L4;
    private javax.swing.JPanel L5;
    private javax.swing.JPanel L6;
    private javax.swing.JTextField LL1;
    private javax.swing.JTextField LL2;
    private javax.swing.JTextField LL3;
    private javax.swing.JPanel M1;
    private javax.swing.JPanel M2;
    private javax.swing.JPanel M3;
    private javax.swing.JPanel M4;
    private javax.swing.JPanel M5;
    private javax.swing.JPanel M6;
    private javax.swing.JButton No;
    private javax.swing.JButton No1;
    private javax.swing.JButton No10;
    private javax.swing.JButton No11;
    private javax.swing.JButton No12;
    private javax.swing.JButton No13;
    private javax.swing.JButton No14;
    private javax.swing.JButton No15;
    private javax.swing.JButton No2;
    private javax.swing.JButton No3;
    private javax.swing.JButton No4;
    private javax.swing.JButton No5;
    private javax.swing.JButton No6;
    private javax.swing.JButton No7;
    private javax.swing.JButton No8;
    private javax.swing.JButton No9;
    private javax.swing.JTextField O1;
    private javax.swing.JTextField O2;
    private javax.swing.JButton OK1;
    private javax.swing.JButton OK10;
    private javax.swing.JButton OK11;
    private javax.swing.JButton OK12;
    private javax.swing.JButton OK13;
    private javax.swing.JButton OK14;
    private javax.swing.JButton OK2;
    private javax.swing.JButton OK3;
    private javax.swing.JButton OK4;
    private javax.swing.JButton OK5;
    private javax.swing.JButton OK6;
    private javax.swing.JButton OK7;
    private javax.swing.JButton OK8;
    private javax.swing.JButton OK9;
    private javax.swing.JTextField Q1;
    private javax.swing.JComboBox<String> Q2;
    private javax.swing.JTextField Q3;
    private datechooser.beans.DateChooserCombo Q4;
    private javax.swing.JComboBox<String> Q5;
    private javax.swing.JComboBox<String> Q6;
    private javax.swing.JTextField Q7;
    private javax.swing.JComboBox<String> ROOM3;
    private javax.swing.JTable TABLE_ROOM;
    private javax.swing.JTable T_E;
    private javax.swing.JTable TableCustomer;
    private javax.swing.JTable Table_BOOKING;
    private javax.swing.JTable Table_RENT;
    private javax.swing.JComboBox<String> U01;
    private javax.swing.JTextField U1;
    private javax.swing.JComboBox<String> U2;
    private javax.swing.JTextField U3;
    private javax.swing.JTextField U4;
    private javax.swing.JTextField U5;
    private javax.swing.JTextArea U6;
    private javax.swing.JTextField U8;
    private javax.swing.JTextField U9;
    private javax.swing.JTextField Udate;
    private javax.swing.JTextField W1;
    private javax.swing.JComboBox<String> W2;
    private javax.swing.JTextField W3;
    private datechooser.beans.DateChooserCombo W4;
    private javax.swing.JTextField W5;
    private javax.swing.JTextField W6;
    private javax.swing.JTextField W7;
    private javax.swing.JTextField Z1;
    private javax.swing.JComboBox<String> Z2;
    private javax.swing.JTextField Z3;
    private javax.swing.JTextField Z4;
    private javax.swing.JTextField Z5;
    private javax.swing.JTextField Z57;
    private javax.swing.JTextArea Z6;
    private javax.swing.JTextField Z60;
    private javax.swing.JTextField Z61;
    private javax.swing.JTextField Z62;
    private javax.swing.JTextField Z63;
    private javax.swing.JTextField Z64;
    private javax.swing.JTextField Z65;
    private javax.swing.JTextField Z66;
    private datechooser.beans.DateChooserCombo Z7;
    private javax.swing.JTextField Z8;
    private javax.swing.JTextField Z9;
    private javax.swing.JTextField ZZ1;
    private javax.swing.JComboBox<String> ZZ2;
    private javax.swing.JComboBox<String> ZZ3;
    private javax.swing.JTextField ZZ4;
    private javax.swing.JButton address2;
    private datechooser.beans.DateChooserCombo dateChooserCombo7;
    private datechooser.beans.DateChooserCombo dateCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel165;
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
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
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
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField nn1;
    private javax.swing.JTextField nn2;
    // End of variables declaration//GEN-END:variables
}
