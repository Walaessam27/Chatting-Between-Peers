package Part2;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
public class TCP_Server extends javax.swing.JFrame {
     private ServerSocket servsocket;
    private final HashMap HClient = new HashMap();
    boolean F1=false;
    public TCP_Server() {
        initComponents();
        Joinedusers.setEditable(false);}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        serverPort = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Joinedusers = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        onlineuserList = new javax.swing.JList<>();
        status = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TCP Server");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        start.setFont(new java.awt.Font("Segoe UI Light", 3, 12)); // NOI18N
        start.setText("Start Listening");
        start.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        serverPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverPortActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Port :");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Joinedusers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Joinedusers.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jScrollPane1.setViewportView(Joinedusers);

        onlineuserList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        onlineuserList.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jScrollPane2.setViewportView(onlineuserList);

        status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Status :");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 3, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TCP Server");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void serverPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverPortActionPerformed
       
    }//GEN-LAST:event_serverPortActionPerformed
    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        int numport;
        try {
            if (!serverPort.getText().isEmpty()) {
                numport = Integer.parseInt(serverPort.getText());
                servsocket = new ServerSocket(numport);
                StyledDocument std = Joinedusers.getStyledDocument();
                Style st = Joinedusers.addStyle("", null);
                StyleConstants.setForeground(st, Color.BLUE);
                StyleConstants.setBackground(st, Color.white);
                String str = "Listening port is: " + numport + "\n";
                std.insertString(std.getLength(), str, st);
                new Clinet_Thread(servsocket).start(); 
                status.setText("Server Address is: 192.168.37.1" +", Server port is: "+numport); }
        } catch (NumberFormatException e) {
        } catch (IOException | BadLocationException ex) {
            JOptionPane.showMessageDialog(null, "port number is used");}
    }//GEN-LAST:event_startActionPerformed
    private class Clinet_Thread extends Thread {
        private final ServerSocket socket;
        public Clinet_Thread(ServerSocket socket) {
            this.socket = socket; }
        public void run() {
            while (true){
                try {
                    Socket clientSocket = socket.accept();
                    String username = new DataInputStream(clientSocket.getInputStream()).readUTF();
                    DataOutputStream dataOutOfClient = new DataOutputStream(clientSocket.getOutputStream());
                    if (HClient.containsKey(username)) {
                        dataOutOfClient.writeUTF("founded");
                    } else {
                        HClient.put(username, clientSocket);
                        addTextToArea(username, true);
                        dataOutOfClient.writeUTF("accept");
                        new endToEndList().start();
                        new ReadMessage(clientSocket, username).start(); }
                } catch (IOException ex) {
                    Logger.getLogger(Clinet_Thread.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadLocationException ex) {
                    Logger.getLogger(TCP_Server.class.getName()).log(Level.SEVERE, null, ex);  }}}}
    class ReadMessage extends Thread {
        Socket soc;
        String userID;
        ReadMessage(Socket s, String username) {
            this.soc = s;
            this.userID = username;}
        public void run() {
            while (!HClient.isEmpty() && HClient.containsKey(userID)) {
                try {
                    String input = new DataInputStream(soc.getInputStream()).readUTF();
                    if (input.contains("logout")) {
                        new DataOutputStream(((Socket) HClient.get(userID)).getOutputStream()).writeUTF("logout");////////
                        HClient.remove(userID);
                        addTextToArea(userID, false);
                        new endToEndList().start();}
                } catch (IOException | BadLocationException ex) {
                    HClient.remove(userID);
                    try {
                        addTextToArea(userID, false);
                    } catch (BadLocationException ex1) {
                        Logger.getLogger(TCP_Server.class.getName()).log(Level.SEVERE, null, ex1);}
                    new endToEndList().start();
                    ex.printStackTrace();}}}}
    private class endToEndList extends Thread {
        DefaultListModel listm;
        public endToEndList() {
            listm = new DefaultListModel();
            onlineuserList.setModel(listm);}
        public void run() {
            try {
                String str = new String();
                Set k = HClient.keySet();
                Iterator itr = k.iterator();
                listm.clear();
                while (itr.hasNext()) {
                    String keyuser = (String) itr.next();
                    str += keyuser + "," + String.valueOf(((Socket) HClient.get(keyuser)).getPort()) + ","+ ((Socket) HClient.get(keyuser)).getInetAddress().getHostAddress() + "&?";
                    String newuser = ((Socket) HClient.get(keyuser)).getInetAddress().getHostAddress() + "," + String.valueOf(((Socket) HClient.get(keyuser)).getPort());
                    listm.addElement(newuser); }
                if (str.length() != 0) {
                    str = str.substring(0, str.length() - 2); }
                itr = k.iterator();
                while (itr.hasNext()) {
                    String key = (String) itr.next();
                    try {
                        new DataOutputStream(((Socket) HClient.get(key)).getOutputStream()).writeUTF("add to list" + str);
                    } catch (IOException ex) {
                        HClient.remove(key);
                        addTextToArea(key, false);}}
            } catch (BadLocationException ex) { }}}
    public void addTextToArea(String username, boolean color) throws BadLocationException {
        if (color) {
            StyledDocument std = Joinedusers.getStyledDocument();
            Style st = Joinedusers.addStyle("", null);
            StyleConstants.setForeground(st, Color.BLUE);
            StyleConstants.setBackground(st, Color.white);
            String str = username + " log in" + "\n";
            std.insertString(std.getLength(), str, st);
        } else {
            StyledDocument std = Joinedusers.getStyledDocument();
            Style st = Joinedusers.addStyle("", null);
            StyleConstants.setForeground(st, Color.RED);
            StyleConstants.setBackground(st, Color.white);
            String str = username + " log out" + "\n";
            std.insertString(std.getLength(), str, st);}}
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TCP_Server().setVisible(true); }}); }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Joinedusers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> onlineuserList;
    private javax.swing.JTextField serverPort;
    private javax.swing.JButton start;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables

}
