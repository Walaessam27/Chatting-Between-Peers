package Part2;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
public class TCP_Client extends javax.swing.JFrame {
    DatagramSocket datagsocket;
    String nameuser, pass;
    String IPLocal, IPremot;
    int PortLocal, Portremot;  
    InetAddress remot_IPAddress;
    byte[] S_buffer,R_buffer;
    DatagramPacket sendpacket;
    DatagramPacket receivepacket;
    boolean connection = false;
    boolean flaglog = false;
    boolean F1 = false;
    boolean F2 = false;
    DefaultListModel listmodel;
    DataInputStream dFServer,DIStream;
    DataOutputStream dTServer;
    Socket serverSocket;
    Read read;
    Th_Client threadC;
    public TCP_Client() {
        initComponents();
        textResult.setEditable(false);
        TextRemotIP.setEditable(false);
        TextRemotPort.setEditable(false);
        textwriting.setForeground(Color.GRAY);
        textwriting.setText("Please Enter the text here:");
        nameuser = "";
        IPLocal = "";PortLocal = 0;
        IPremot = "";Portremot = 0;
        R_buffer = new byte[50];
        receivepacket = new DatagramPacket(R_buffer, R_buffer.length);}
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Textusername = new javax.swing.JTextField();
        Blogin = new javax.swing.JButton();
        Blogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textwriting = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        TextSerIP = new javax.swing.JTextField();
        TextSerPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextLocalIP = new javax.swing.JTextField();
        TextLocalPort = new javax.swing.JTextField();
        TextRemotIP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextRemotPort = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Listonlineusers = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        send = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textResult = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        Textpassword = new javax.swing.JTextField();
        sendall = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 3, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username:");

        Textusername.setFont(new java.awt.Font("Segoe UI Light", 3, 12)); // NOI18N
        Textusername.setToolTipText("");
        Textusername.setPreferredSize(new java.awt.Dimension(7, 28));

        Blogin.setFont(new java.awt.Font("Segoe UI Light", 3, 13)); // NOI18N
        Blogin.setText("Log in");
        Blogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Blogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloginActionPerformed(evt);
            }
        });

        Blogout.setFont(new java.awt.Font("Segoe UI Light", 3, 13)); // NOI18N
        Blogout.setText("Log out");
        Blogout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Blogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlogoutActionPerformed(evt);
            }
        });

        textwriting.setColumns(20);
        textwriting.setFont(new java.awt.Font("Segoe UI Light", 3, 10)); // NOI18N
        textwriting.setLineWrap(true);
        textwriting.setRows(5);
        textwriting.setWrapStyleWord(true);
        textwriting.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textwriting.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textwritingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textwritingFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(textwriting);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("TCPServer Port:");

        TextSerIP.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TextSerIP.setToolTipText("");
        TextSerIP.setPreferredSize(new java.awt.Dimension(7, 28));
        TextSerIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSerIPActionPerformed(evt);
            }
        });

        TextSerPort.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TextSerPort.setToolTipText("");
        TextSerPort.setPreferredSize(new java.awt.Dimension(7, 28));
        TextSerPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSerPortActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("TCPServer IP:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Local Port:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Local IP:");

        TextLocalIP.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TextLocalIP.setToolTipText("");
        TextLocalIP.setPreferredSize(new java.awt.Dimension(7, 28));
        TextLocalIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextLocalIPActionPerformed(evt);
            }
        });

        TextLocalPort.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TextLocalPort.setToolTipText("");
        TextLocalPort.setPreferredSize(new java.awt.Dimension(7, 28));
        TextLocalPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextLocalPortActionPerformed(evt);
            }
        });

        TextRemotIP.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TextRemotIP.setToolTipText("");
        TextRemotIP.setPreferredSize(new java.awt.Dimension(7, 28));
        TextRemotIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextRemotIPActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Remote IP:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Remote Port:");

        TextRemotPort.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        TextRemotPort.setToolTipText("");
        TextRemotPort.setPreferredSize(new java.awt.Dimension(7, 28));
        TextRemotPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextRemotPortActionPerformed(evt);
            }
        });

        Listonlineusers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Listonlineusers.setFont(new java.awt.Font("Segoe UI Light", 3, 10)); // NOI18N
        Listonlineusers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListonlineusersValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(Listonlineusers);

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Online Users:");

        send.setFont(new java.awt.Font("Segoe UI Light", 3, 13)); // NOI18N
        send.setText("Send");
        send.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 2, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Status:");

        status.setFont(new java.awt.Font("Segoe UI Light", 3, 10)); // NOI18N
        status.setToolTipText("");
        status.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        status.setPreferredSize(new java.awt.Dimension(7, 28));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textResult.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textResult.setFont(new java.awt.Font("Segoe UI Light", 3, 10)); // NOI18N
        textResult.setFocusCycleRoot(false);
        jScrollPane4.setViewportView(textResult);

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 3, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Password:");

        Textpassword.setFont(new java.awt.Font("Segoe UI Light", 3, 12)); // NOI18N
        Textpassword.setToolTipText("");
        Textpassword.setPreferredSize(new java.awt.Dimension(7, 28));

        sendall.setFont(new java.awt.Font("Segoe UI Light", 3, 13)); // NOI18N
        sendall.setText("Send All");
        sendall.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sendall.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sendall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendallActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 3, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TCP Client");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(Textusername, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4)
                                            .addComponent(Textpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Blogout, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Blogin, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TextLocalPort, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TextRemotIP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TextRemotPort, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TextLocalIP, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TextSerIP, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                            .addComponent(TextSerPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sendall, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Textusername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Blogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Blogout)
                            .addComponent(Textpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextSerIP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextSerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextLocalIP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextLocalPort, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextRemotIP, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TextRemotPort, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sendall, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void BloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloginActionPerformed
        nameuser = Textusername.getText();
        pass = Textpassword.getText();
        FileReader fread;
        try {
           fread=new FileReader("C:\\Users\\DELL\\Desktop\\Study\\Year4 Sem1\\Computer Networks 1\\HW2\\Networks_HW2Part2\\src\\newfile.txt");
           BufferedReader br=new BufferedReader(fread);
    	   String readline =br.readLine();
    	   ArrayList<String[]> arrlist=new ArrayList<>();
    	   while(readline!=null){
           String[] str=readline.split(" ");
           arrlist.add(str);
    	   readline=br.readLine();}    
           for(int i=0;i<arrlist.size();i++){
           if(arrlist.get(i)[0].equalsIgnoreCase(nameuser)&& arrlist.get(i)[1].equals(pass)){
                JOptionPane.showMessageDialog(rootPane, "Logged in");
                flaglog=true; } }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex); }
        if (flaglog) {
            String TcpIP = TextSerIP.getText();
            int TcpPort = Integer.valueOf(TextSerPort.getText().trim());
            String localIP = TextLocalIP.getText();
            PortLocal = Integer.valueOf(TextLocalPort.getText().trim());
            connection = true;
            IPLocal = TextLocalIP.getText();
            PortLocal = Integer.parseInt(TextLocalPort.getText());
            try {
                datagsocket = new DatagramSocket(PortLocal);
            } catch (SocketException ex) {
                Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);}
            try {
                serverSocket = new Socket(InetAddress.getByName(TcpIP), TcpPort, InetAddress.getByName(localIP), PortLocal);
                dFServer = new DataInputStream(serverSocket.getInputStream());
                dTServer = new DataOutputStream(serverSocket.getOutputStream());
                dTServer.writeUTF(nameuser);
                String s;          
                DIStream = new DataInputStream(serverSocket.getInputStream());
                s = DIStream.readUTF();
                if (s.equals("founded")) {
                    JOptionPane.showMessageDialog(null, "You are already logged in!\n", "ERROR", JOptionPane.ERROR_MESSAGE); }
                else if (s.equals("accept")) {
                    listmodel = new DefaultListModel();
                    Listonlineusers.setModel(listmodel);
                    read = new Read(nameuser);
                    read.start();}
                F2 = true;
                threadC = new Th_Client(this);
                threadC.start();
                F1 = true;
                JOptionPane.showMessageDialog(null, "You are logged in successfully!!");
                flaglog = true;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "The local port is used, PLease choose another one.");} } 
        else {JOptionPane.showMessageDialog(null, "Invalid login information, either user name or password.");}
    }//GEN-LAST:event_BloginActionPerformed
    class Read extends Thread {
        String name;
        public Read(String userName) {this.name = userName;}
        public void run() {
            while (F2) {
                try {
                    String inputData = dFServer.readUTF();
                    if (inputData.equals("logout")) {break;}
                    if (inputData.contains("add to list")) {
                        inputData = inputData.substring(11);
                        listmodel.clear();
                        StringTokenizer st = new StringTokenizer(inputData, "&?");
                        while (st.hasMoreTokens()) {
                            String line = st.nextToken();
                            String[] tokens = line.split(",");
                            if (!tokens[0].equals(name)) {
                                String element = new String(tokens[2] + "," + tokens[1]);
                                listmodel.addElement(element);}}}
                } catch (IOException ex) { }}}}
    private void TextSerIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSerIPActionPerformed
     
    }//GEN-LAST:event_TextSerIPActionPerformed

    private void TextSerPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSerPortActionPerformed
  
    }//GEN-LAST:event_TextSerPortActionPerformed

    private void TextLocalIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextLocalIPActionPerformed
       
    }//GEN-LAST:event_TextLocalIPActionPerformed

    private void TextLocalPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextLocalPortActionPerformed
     
    }//GEN-LAST:event_TextLocalPortActionPerformed

    private void TextRemotIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextRemotIPActionPerformed
        
    }//GEN-LAST:event_TextRemotIPActionPerformed

    private void TextRemotPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextRemotPortActionPerformed

    }//GEN-LAST:event_TextRemotPortActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        try {
            if (!connection){
                JOptionPane.showMessageDialog(null, "You must Log in at first before sending.");}
           else if (TextRemotIP.getText().equals("") || TextRemotPort.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You must select a reciever.");}
            else if (textwriting.getText().equals("") || textwriting.getText().equals("Please Enter the text here:")) {
                JOptionPane.showMessageDialog(null, "You must write a message.");} 
            else {
                nameuser = Textusername.getText();
                IPremot = TextRemotIP.getText();
                Portremot = Integer.parseInt(TextRemotPort.getText());
                remot_IPAddress = InetAddress.getByName(IPremot);
                String msg = textwriting.getText();
                textwriting.setText("");
                StyledDocument std = textResult.getStyledDocument();
                Style st = textResult.addStyle("", null);
                StyleConstants.setForeground(st, Color.RED);
                StyleConstants.setBackground(st, Color.white);
                String str = "ME: " + msg + " From " + PortLocal + "\n";
                std.insertString(std.getLength(), str, st);
                msg = nameuser + ": " + msg;
                S_buffer = msg.getBytes();
                sendpacket = new DatagramPacket(S_buffer, S_buffer.length, remot_IPAddress, Portremot);
                datagsocket.send(sendpacket);}
        } catch (UnknownHostException ex) {
            Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | BadLocationException ex) {
            Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_sendActionPerformed
    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
       
    }//GEN-LAST:event_statusActionPerformed
    private void textwritingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textwritingFocusGained
        if (textwriting.getText().equals("Please Enter the text here:")) {
            textwriting.setText("");}
    }//GEN-LAST:event_textwritingFocusGained
    private void textwritingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textwritingFocusLost
        if (textwriting.getText().isEmpty()) {
             textwriting.setText("Please Enter the text here:");}
    }//GEN-LAST:event_textwritingFocusLost
    private void BlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlogoutActionPerformed
        if (flaglog) {
            JOptionPane.showMessageDialog(null, "You are logged out successfully, Thank you!!");
            flaglog = false;
            F1 = false;
            F2 = false;
            try {
                String localIp1 = TextLocalIP.getText();
                int localPort1 = Integer.parseInt(TextLocalPort.getText());
                InetAddress remot_IPAddress1 = InetAddress.getByName(localIp1);
                String msg = "logout";
                S_buffer = msg.getBytes();
                sendpacket = new DatagramPacket(S_buffer, S_buffer.length, remot_IPAddress1, localPort1);
                datagsocket.send(sendpacket);
            } catch (IOException ex) {
                Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);}
            String s = "logout";
            try {
                dTServer.writeUTF(s);
            } catch (IOException ex) {
                Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);}
            listmodel.clear();
            try {
                datagsocket.close();
                serverSocket.close();
                DIStream.close();
                dFServer.close();
                dTServer.close();
                textwriting.setText("");
                TextLocalIP.setText("");
                TextLocalPort.setText("");
                TextRemotIP.setText("");
                TextRemotPort.setText("");
                TextSerIP.setText("");
                TextSerPort.setText("");
                Textpassword.setText("");
                Textusername.setText("");
                status.setText("");
                textResult.setText("");
            } catch (IOException ex) {
                Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);}}
        else {JOptionPane.showMessageDialog(null, "You are already logged out, Please log in again.");}
    }//GEN-LAST:event_BlogoutActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   
    }//GEN-LAST:event_formWindowClosing
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
   
    }//GEN-LAST:event_formWindowClosed
    private void ListonlineusersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListonlineusersValueChanged
        try {
            int i = Listonlineusers.getModel().getSize();
            if (!evt.getValueIsAdjusting() && i != 0) {
                String s = (Listonlineusers.getSelectedValue().toString());
                String[] tokens = s.split(",");
                TextRemotIP.setText(tokens[0]);
                TextRemotPort.setText(tokens[1]);}
        } catch (Exception ex) {}
    }//GEN-LAST:event_ListonlineusersValueChanged

    private void sendallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendallActionPerformed
       try {
            if (!connection){
                JOptionPane.showMessageDialog(null, "You must Log in at first before sending.");}
            else if (textwriting.getText().equals("") || textwriting.getText().equals("Please Enter the text here:")) {
                JOptionPane.showMessageDialog(null, "You must write a message.");} 
            else {
                TextRemotIP.setText("");
                TextRemotPort.setText("");
                for(int i=0;i< Listonlineusers.getModel().getSize() ;i++){
                String h=Listonlineusers.getModel().getElementAt(i);
                String[] tokens = h.split(",");
                IPremot=tokens[0];
                Portremot=Integer.valueOf(tokens[1]);
               nameuser = Textusername.getText();
               remot_IPAddress = InetAddress.getByName(IPremot);
                String msg = textwriting.getText();
                
                StyledDocument std = textResult.getStyledDocument();
                Style st = textResult.addStyle("", null);
                StyleConstants.setForeground(st, Color.RED);
                StyleConstants.setBackground(st, Color.white);
                String str = "ME: " + msg + " From " + PortLocal + "\n";
                std.insertString(std.getLength(), str, st);
                msg = nameuser + ": " + msg;
                S_buffer = msg.getBytes();
                sendpacket = new DatagramPacket(S_buffer, S_buffer.length, remot_IPAddress, Portremot);
                datagsocket.send(sendpacket);}textwriting.setText("");}
       } catch (UnknownHostException ex) {
           Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IOException | BadLocationException ex) {
      Logger.getLogger(TCP_Client.class.getName()).log(Level.SEVERE, null, ex); }    
    }//GEN-LAST:event_sendallActionPerformed
    void receive() {
        try {
            if (F1) {
                StyledDocument doc = textResult.getStyledDocument();
                Style style = textResult.addStyle("", null);
                datagsocket.receive(receivepacket);
                String msg = new String(R_buffer, 0, receivepacket.getLength());
                if (msg.equals("logout")) {return;}
                InetAddress SAddressIP = receivepacket.getAddress();
                int i = receivepacket.getPort();
                StyleConstants.setForeground(style, Color.BLUE);
                StyleConstants.setBackground(style, Color.white);
                String str = msg + " From " + i + "\n";
                doc.insertString(doc.getLength(), str, style);
                String str1 = SAddressIP.getHostAddress();
                status.setText("Received From IP= " + str1 + ", port: " + i);}
        } catch (IOException | BadLocationException ex) { }}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TCP_Client().setVisible(true);});}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Blogin;
    private javax.swing.JButton Blogout;
    private javax.swing.JList<String> Listonlineusers;
    private javax.swing.JTextField TextLocalIP;
    private javax.swing.JTextField TextLocalPort;
    private javax.swing.JTextField TextRemotIP;
    private javax.swing.JTextField TextRemotPort;
    private javax.swing.JTextField TextSerIP;
    private javax.swing.JTextField TextSerPort;
    private javax.swing.JTextField Textpassword;
    private javax.swing.JTextField Textusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton send;
    private javax.swing.JButton sendall;
    private javax.swing.JTextField status;
    private javax.swing.JTextPane textResult;
    private javax.swing.JTextArea textwriting;
    // End of variables declaration//GEN-END:variables

}
