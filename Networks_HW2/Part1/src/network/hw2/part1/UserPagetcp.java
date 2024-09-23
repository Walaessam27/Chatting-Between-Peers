
package network.hw2.part1;

import java.awt.Color;
import java.awt.Component;
import java.io.*;
import java.net.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;




/**
 *
 * @author admin
 */
public class UserPagetcp extends javax.swing.JFrame {
     InetSocketAddress IPAddress;
     String msg;
    String data;
    int PORT;
    byte [] sendBytes=new byte[1024];
    public String username="";
    String msgFromSender;
    String []all= new String[16];
    String IP;
    int f=-1;
    String port;
    int startIndex ;
    int endIndex;
    ArrayList <String> colors=new ArrayList<>();
    int senderPort; 
    int  remotePort ;
    String  remoteIP;
    InetAddress localAddress;
    InetAddress remotaddress;
    public  String name,RIP , RPort , textx;
     String domainNameOfSender;
    DatagramSocket socket = null;
    DefaultListModel model = new DefaultListModel();
     Socket clientSocket;
   
        String threadName;
        boolean loggedIn ;
  


    public UserPagetcp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        sendmsgsto1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TcpPort = new javax.swing.JTextField();
        TcpIP = new javax.swing.JTextField();
        lIP = new javax.swing.JTextField();
        rIP = new javax.swing.JTextField();
        lPort = new javax.swing.JTextField();
        rPort = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        text9 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SendMessages = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        MessageArea = new javax.swing.JTextPane();
        Logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UserPage");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Local IP:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 90, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("Tcp server Port:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setText("Local Port:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 110, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setText("Status:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 60, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setText("Remote Port:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 130, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Tcp server IP:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("Remote IP:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 110, 20));

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eathernet:169.245.49.50" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 250, 50));

        sendmsgsto1.setBackground(new java.awt.Color(153, 0, 153));
        sendmsgsto1.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        sendmsgsto1.setForeground(new java.awt.Color(255, 255, 255));
        sendmsgsto1.setText("Send");
        sendmsgsto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendmsgsto1MSGActionPerformed(evt);
            }
        });
        jPanel1.add(sendmsgsto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 240, 40));

        jPanel2.setBackground(new java.awt.Color(214, 223, 223));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(TcpPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 110, 30));
        jPanel2.add(TcpIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 110, 30));
        jPanel2.add(lIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 120, 30));
        jPanel2.add(rIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 120, 30));
        jPanel2.add(lPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 120, 30));
        jPanel2.add(rPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 120, 30));

        jButton1.setBackground(new java.awt.Color(153, 0, 153));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 110, 40));

        jButton2.setBackground(new java.awt.Color(153, 0, 153));
        jButton2.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 120, 40));

        Login.setBackground(new java.awt.Color(153, 0, 153));
        Login.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel2.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 100, 30));

        password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 150, 30));

        text9.setEditable(false);
        jPanel2.add(text9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 490, 30));

        SendMessages.setColumns(20);
        SendMessages.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        SendMessages.setForeground(new java.awt.Color(0, 0, 51));
        SendMessages.setRows(5);
        jScrollPane1.setViewportView(SendMessages);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 430, 110));

        MessageArea.setEditable(false);
        MessageArea.setBackground(new java.awt.Color(255, 255, 255));
        MessageArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(MessageArea);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 430, 190));

        Logout.setBackground(new java.awt.Color(153, 0, 153));
        Logout.setFont(new java.awt.Font("Tw Cen MT", 3, 16)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel2.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 100, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, -1));

        userText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel2.add(userText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        if (userText.getText().equals("")|| lPort.getText().equals("") || lIP.getText().equals(""))
        JOptionPane.showMessageDialog(null, "Please Enter a valid UserName & Port Number ");
           
        else{
            try {
               
                    String y = "";
                    username= userText.getText();
                    port = lPort.getText();
                    IP = lIP.getText();
                    
                    senderPort = Integer.parseInt(port);
                    
                    localAddress = InetAddress.getByName(lIP.getText());
                    SocketAddress socketAddress=new InetSocketAddress(localAddress, senderPort);
                    socket = new DatagramSocket(senderPort);
                    socket.setBroadcast(true);
                     String xx = username;
                    
                    this.beginServering();
                    int x=this.beginClient();
                     loggedIn = true;
                    if(x!=-1){
                        text9.setText("Logged in as "+username+" with Ip Address: "+IP+"  Port Address:"+port);
                       
                    }
                     
                    
                    
                
            } catch (IOException ex) {
                Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        username = "";
        userText.setText(username);
        lPort.setText("");
        lIP.setText("");
        rIP.setText("");
        rPort.setText("");
        MessageArea.setText("");
        text9.setText("logged out ");
        try {
            loggedIn= false;
            endClient();
        } catch (IOException ex) {
            Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void sendmsgsto1MSGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendmsgsto1MSGActionPerformed
        // TODO add your handling code here:

                      f=1;
             if (username.equals(""))
             JOptionPane.showMessageDialog(null, "You Must Log in First");
        else
        {
            if (rPort.getText().equals("") || rIP.getText().equals("") || lPort.getText().equals("") || lIP.getText().equals("") )
            {
             JOptionPane.showMessageDialog(null, "Please make sure to fill all the information before sending :)");
            }
            else
            {
                msgFromSender = SendMessages.getText();
                
                try {
                    send();
                } catch (IOException ex) {
                    Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_sendmsgsto1MSGActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
             f=3;
             
             
             /*int start = MessageArea.getSelectionStart();
             int end = MessageArea.getSelectionEnd();
             Element root = MessageArea.getDocument().getDefaultRootElement();
             int startLine = root.getElementIndex(start);
             int endLine = root.getElementIndex(end);
             if (startLine != endLine) {
             try {
             Document doc = MessageArea.getDocument();
             
             Element line = root.getElement(startLine);
             int startLineEnd = line.getEndOffset() - 1;
             int len = end - startLineEnd;
             doc.remove(startLineEnd, len);
             } catch (BadLocationException e) {
             e.printStackTrace();
             }
             } else {
             MessageArea.replaceSelection("");
             }*/
//deleteSelectedParagraph(MessageArea);
send();
deleteSelectedLines(MessageArea);
JOptionPane.showMessageDialog(this, "Tha message deleted");
// TODO add your handling code here:
         } catch (IOException ex) {
             Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

  
    
    public void deleteSelectedLines(JTextPane textPane) {
    StyledDocument doc = textPane.getStyledDocument();
    startIndex = textPane.getSelectionStart();
    endIndex = textPane.getSelectionEnd();

    try {
        doc.remove(startIndex, endIndex - startIndex);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         f=2;
       MessageArea.setText("");
         try {
             send();
         } catch (IOException ex) {
             Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
         }
        // msgFromSender="All";
        JOptionPane.showMessageDialog(this, "Tha chat deleted");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    
    
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JButton Logout;
    private javax.swing.JTextPane MessageArea;
    private javax.swing.JTextArea SendMessages;
    private javax.swing.JTextField TcpIP;
    private javax.swing.JTextField TcpPort;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField lIP;
    private javax.swing.JTextField lPort;
    private javax.swing.JTextField password;
    private javax.swing.JTextField rIP;
    private javax.swing.JTextField rPort;
    private javax.swing.JButton sendmsgsto1;
    private javax.swing.JTextField text9;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables


    
    public void send() throws IOException{
		    InetAddress remoteAddress = InetAddress.getByName(rIP.getText());
		    (new Thread() {
		        @Override
                        
		        public void run() {
                            try {
                               
                                LocalDateTime now = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                                String formattedTime = now.format(formatter);
                                String A="" ;
                                if(f==1)
                                 A = ("1/"+username+" "+ ": "+msgFromSender+" "+formattedTime+"\n");
                                else if(f==2) A="2/All";
                                else if(f==3) A="3/"+startIndex+"/"+(endIndex-startIndex);
                                byte data[] = A.getBytes();
                                   // System.out.println("here "A);
                                 System.out.println("here "+A);
                                
                                
                                int remotePort = Integer.parseInt(rPort.getText());
                                DatagramPacket packet = new DatagramPacket(data, data.length, remoteAddress, remotePort);
                                socket.send(packet);
                                if(f==1)
                                sendAppendString( "Me : "+ msgFromSender+" "+formattedTime+"\n");
                                
                                
                                
                                SendMessages.setText("");
                                text9.setText("Msg sent to user "+ userText.getText() +" with ip address: "+rIP.getText()+" and Port address : "+rPort.getText());
                            } catch (BadLocationException ex) {
                                Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                            }
                             
		           
		        }}).start();
		    }
    
        public void beginServering() throws IOException {
        
        (new Thread() {
            @SuppressWarnings("resource")
            @Override
            public void run() {
                DatagramPacket packetR ;
                String temp;
                while (true) {
                    try {
                        packetR = new DatagramPacket(new byte[2048], 2048);
                        socket.receive(packetR);
                        String address = packetR.getAddress().toString();
                        System.out.println(packetR.getPort());

                        temp = new String(packetR.getData());
                        String port = Integer.toString(packetR.getPort());
                     
                       String [] select=temp.split("/");
                    
                        if(select[0].equals("1"))
                         appendString(select[1] + "\n");
                        else if(select[0].equals("2"))
                                 MessageArea.setText("");
                           
                         else if(select[0].equals("3")){
                              StyledDocument doc = MessageArea.getStyledDocument();
                           int si=Integer.parseInt(select[1].trim());
                         int ei=Integer.parseInt(select[2].trim());

    try {
        doc.remove(si, ei);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
                            }
                        
                       
                        text9.setText("Recieved From Ip address: " + address + " and Port address: " + port);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BadLocationException ex) {
                        Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    public int beginClient() throws IOException {
        
        int port = Integer.parseInt(TcpPort.getText());
        String ip = TcpIP.getText();
              String sentence;
                    String response;
                    clientSocket = new Socket(ip, port);
                    DataOutputStream outToServer
                            = new DataOutputStream(clientSocket.getOutputStream());
                    BufferedReader inFromServer
                            = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    sentence = "1/"+IP+","+this.port;
                    String USERinfo=userText.getText()+","+password.getText();
                    outToServer.writeBytes(sentence +","+USERinfo+'\n');
                    response = inFromServer.readLine();
                    
               
                   if(response.equals("NO")){
                       JOptionPane.showMessageDialog(this, "Wrong username or password");
                       clientSocket.close();
                      return -1;
                   }
                
               
                    
               
                        JOptionPane.showMessageDialog(this, "You logged successfully");
                          response = inFromServer.readLine();
                          //addUser( userText.getText()+": "+ lIP.getText()+", "+lPort.getText());
                             addUser(response );
                             
                          //clientSocket.close();
                         
                          
                   
              
        
        (new Thread() {
            @SuppressWarnings("resource")
            @Override
            public void run() {
                while (loggedIn){
                    
                    try {
                        this.sleep(1000);
                        
                        Socket clientSocket = new Socket(ip, port);
                        DataOutputStream outToServer
                                = new DataOutputStream(clientSocket.getOutputStream());
                        BufferedReader inFromServer
                                = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        String sentence = "";
                        outToServer.writeBytes(sentence + '\n');
                        String response = inFromServer.readLine();
                        System.out.println(response+"ffffffffffffffffffffffffffff");
                        update(response);
                        
                        clientSocket.close();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(UserPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                             
            }
                
            } }).start();
              
		  return 0;}      
    
    
    
    
       public void endClient() throws IOException {
        
        int port = Integer.parseInt(TcpPort.getText());
        String ip = TcpIP.getText();
        
           
                    String sentence;
                    String response;
                    
                    Socket clientSocket = new Socket(ip, port);
                    DataOutputStream outToServer
                            = new DataOutputStream(clientSocket.getOutputStream());
                    BufferedReader inFromServer
                            = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    sentence = "-1/"+IP+","+this.port;
                    outToServer.writeBytes(sentence + '\n');
                    response = inFromServer.readLine();
                    clearUser();
                    clientSocket.close();
                
                
                model.clear();
                
                
                
		 }       
    
   public void sendAppendString(String str) throws BadLocationException
{
     StyledDocument doc = (StyledDocument) MessageArea.getDocument();
     Style style = MessageArea.addStyle("I'm a Style", null);
     StyleConstants.setForeground(style, Color.RED);
     doc.insertString(doc.getLength(), str, style);
 } 
   
    public void appendString(String str) throws BadLocationException
{
     StyledDocument doc = (StyledDocument) MessageArea.getDocument();
     Style style = MessageArea.addStyle("I'm a Style", null);
     StyleConstants.setForeground(style, Color.GREEN);
     doc.insertString(doc.getLength(), str.trim()+"\n", style);
 } 
    
    private void addUser(String response) {
        colors.clear();
        String[] users = response.split("/");
        for (String u  : users){
            String [] more=u.split("&");
            model.addElement(more[0]);
                        System.out.println(more[0]);
              colors.add(more[1]);

            
        }
            }
    
 
  
   public void update (String S){
         if(loggedIn){
         String[] users = S.split("/");
        model.clear();
       colors.clear();
        for (String u  : users){
            
            String [] more=u.split("&");
            System.out.println(u);
            model.addElement(more[0]);
             colors.add(more[1]);
            
        }}
     }

    private void clearUser() {
        model.clear();
        
    }
    
    private class ColorfulListCellRenderer extends DefaultListCellRenderer {
        
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            component.setForeground(Color.decode(colors.get(index)));
            return component;
        }
   
}
}
