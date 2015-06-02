
package pt.psantos.phd.polarity.propagation.app;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFileChooser;

/**
 * Graphical user interface.
 * 
 * @since 0.6.0
 * @version 0.6.0
 * @author PSantos
 */
public class Gui extends javax.swing.JFrame {

    private File seedWordsFile;
    private File graphFile;
    private File outpFile;
    /** Graph type: directd or undirected */
    private boolean undirectedGraph;
    
    /**
     * Creates new form
     */
    public Gui() {
        initComponents();

        // Graph type
        graphTypeComboBox.addItem("Directed"); // index 0
        graphTypeComboBox.addItem("Undirected"); // index 1
        graphTypeComboBox.setSelectedIndex(1);
        
        // Outup type (screen or file)
        outputRadioGroup.add(outputScreenRadioButton);
        outputRadioGroup.add(outputFileRadioButton);

        redirectSystemStreams();
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                updateStatusMsg(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateStatusMsg(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    /**
     * Update the status Area. 
     * @param txt text to write.
     * @see #updateStatusMsgln(java.lang.String) 
     */
    private void updateStatusMsg(String txt) {
        statusTextArea.append(txt);
    }

    /**
     * Update the status Area. Adds a new line at the end of the {@text} passed
     * as parameter.
     * @param txt text to write.
     * @see #updateStatusMsg(java.lang.String) 
     */
    private void updateStatusMsgln(String txt) {
        updateStatusMsg(txt + "\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        outputRadioGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        seedWordsLbl = new javax.swing.JLabel();
        openSeedWordsFileBtt = new javax.swing.JButton();
        seedWordsFileTxtFld = new javax.swing.JTextField();
        seedWordsLabel = new javax.swing.JLabel();
        initialGraphFileLbl = new javax.swing.JLabel();
        graphFileTxtFld = new javax.swing.JTextField();
        openGraphFileBtt = new javax.swing.JButton();
        initialGraphStatsLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        outputScreenRadioButton = new javax.swing.JRadioButton();
        outputFileRadioButton = new javax.swing.JRadioButton();
        outputFileTxtFld = new javax.swing.JTextField();
        outputFileBtt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();
        graphTypeComboBox = new javax.swing.JComboBox();
        graphTypeLabel = new javax.swing.JLabel();
        applyAlgorithmBtt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        filesEncodingTxtFld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Polarity Propagation 0.6.0");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input"));

        openSeedWordsFileBtt.setText("Open File");
        openSeedWordsFileBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSeedWordsFileBttActionPerformed(evt);
            }
        });

        seedWordsLabel.setText("Seed Words file (One word by line. Line format: <word>,<polarity> . Examples: good,1 | normal,0 | bad,-1):");

        initialGraphFileLbl.setText("Graph file:");

        openGraphFileBtt.setText("Open File");
        openGraphFileBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openGraphFileBttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphFileTxtFld, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seedWordsFileTxtFld, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(initialGraphStatsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openGraphFileBtt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seedWordsLabel)
                            .addComponent(initialGraphFileLbl))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(seedWordsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(openSeedWordsFileBtt)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(seedWordsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seedWordsFileTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openSeedWordsFileBtt)
                    .addComponent(seedWordsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(initialGraphFileLbl)
                .addGap(5, 5, 5)
                .addComponent(graphFileTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openGraphFileBtt)
                    .addComponent(initialGraphStatsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        outputScreenRadioButton.setSelected(true);
        outputScreenRadioButton.setText("screen");
        outputScreenRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputScreenRadioButtonActionPerformed(evt);
            }
        });

        outputFileRadioButton.setText("file");
        outputFileRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileRadioButtonActionPerformed(evt);
            }
        });

        outputFileTxtFld.setEnabled(false);

        outputFileBtt.setText("Choose");
        outputFileBtt.setEnabled(false);
        outputFileBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileBttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(outputScreenRadioButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(outputFileRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(outputFileTxtFld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputFileBtt)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputScreenRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputFileRadioButton)
                    .addComponent(outputFileTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFileBtt))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        statusTextArea.setColumns(20);
        statusTextArea.setRows(5);
        jScrollPane1.setViewportView(statusTextArea);

        graphTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphTypeComboBoxActionPerformed(evt);
            }
        });

        graphTypeLabel.setText("Graph Type:");

        applyAlgorithmBtt.setText("Run Algorithm");
        applyAlgorithmBtt.setEnabled(false);
        applyAlgorithmBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyAlgorithmBttActionPerformed(evt);
            }
        });

        jLabel1.setText("Files Encoding:");

        filesEncodingTxtFld.setText("utf-8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(graphTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graphTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filesEncodingTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(applyAlgorithmBtt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graphTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(graphTypeLabel)
                    .addComponent(jLabel1)
                    .addComponent(filesEncodingTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyAlgorithmBtt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openSeedWordsFileBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSeedWordsFileBttActionPerformed

        int returnVal = jFileChooser1.showOpenDialog(this);
        //System.out.println("Out: " + returnVal);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            seedWordsFile = jFileChooser1.getSelectedFile();
            seedWordsFileTxtFld.setText(seedWordsFile.getAbsolutePath());
            updateStatusMsgln("Opened file: " + seedWordsFile.getAbsolutePath());
                    
            CommandLine.setSeedWordsFile(seedWordsFile);
            if(CommandLine.hasTheRequiredArgs()) {
                applyAlgorithmBtt.setEnabled(true);
            }
        } else {
            updateStatusMsg("Open file cancelled by user");
        }
    }//GEN-LAST:event_openSeedWordsFileBttActionPerformed

    private void openGraphFileBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openGraphFileBttActionPerformed
        int returnVal = jFileChooser1.showOpenDialog(this);
        //System.out.println("Out: " + returnVal);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            graphFile = jFileChooser1.getSelectedFile();
            graphFileTxtFld.setText(graphFile.getAbsolutePath());
            updateStatusMsgln("Opened file: " + graphFile.getAbsolutePath());
            
            CommandLine.setGraphFile(graphFile);
            if (CommandLine.hasTheRequiredArgs()) {
                applyAlgorithmBtt.setEnabled(true);
            }
        } else {
            updateStatusMsg("Open file cancelled by user");
        }
    }//GEN-LAST:event_openGraphFileBttActionPerformed

    private void applyAlgorithmBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyAlgorithmBttActionPerformed
        try {
            // Do not check the arguments of the main method
            CommandLine.setCheckMainArgs(false);
            
            if(!filesEncodingTxtFld.getText().isEmpty()) {
                CommandLine.setEncoding(filesEncodingTxtFld.getText());
            }
                    
            // Run the application with arguments already set
            CommandLine.main(new String[0]);
        } catch (Exception ex) {
            updateStatusMsg(ex.toString());
        }
    }//GEN-LAST:event_applyAlgorithmBttActionPerformed

    private void outputFileRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFileRadioButtonActionPerformed
        outputFileTxtFld.setEnabled(true);
        outputFileBtt.setEnabled(true);
        
        // If the output file name is not yet set
        if(outputFileTxtFld.getText() == null || outputFileTxtFld.getText().isEmpty()) {
            // Set a default out file
            this.outpFile = new File("dic.csv");
            outputFileTxtFld.setText(this.outpFile.getAbsolutePath());
            CommandLine.setOutpFile(this.outpFile);
        }
    }//GEN-LAST:event_outputFileRadioButtonActionPerformed

    private void outputScreenRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputScreenRadioButtonActionPerformed
        outputFileTxtFld.setEnabled(false);
        outputFileBtt.setEnabled(false);
        
        CommandLine.setOutpFile(null);
    }//GEN-LAST:event_outputScreenRadioButtonActionPerformed

    private void outputFileBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFileBttActionPerformed
        int returnVal = jFileChooser1.showOpenDialog(this);
        //System.out.println("Out: " + returnVal);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            outpFile = jFileChooser1.getSelectedFile();
            outputFileTxtFld.setText(outpFile.getAbsolutePath());
            updateStatusMsgln("Opened file: " + outpFile.getAbsolutePath());
            
            CommandLine.setOutpFile(outpFile);
            if (CommandLine.hasTheRequiredArgs()) {
                applyAlgorithmBtt.setEnabled(true);
            }
        } else {
            updateStatusMsg("Open file cancelled by user");
        }
    }//GEN-LAST:event_outputFileBttActionPerformed

    private void graphTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphTypeComboBoxActionPerformed
       this.undirectedGraph = graphTypeComboBox.getSelectedItem().toString().toLowerCase().startsWith("undir");
       CommandLine.setUndirectedGraph(undirectedGraph);
    }//GEN-LAST:event_graphTypeComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyAlgorithmBtt;
    private javax.swing.JTextField filesEncodingTxtFld;
    private javax.swing.JTextField graphFileTxtFld;
    private javax.swing.JComboBox graphTypeComboBox;
    private javax.swing.JLabel graphTypeLabel;
    private javax.swing.JLabel initialGraphFileLbl;
    private javax.swing.JLabel initialGraphStatsLbl;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openGraphFileBtt;
    private javax.swing.JButton openSeedWordsFileBtt;
    private javax.swing.JButton outputFileBtt;
    private javax.swing.JRadioButton outputFileRadioButton;
    private javax.swing.JTextField outputFileTxtFld;
    private javax.swing.ButtonGroup outputRadioGroup;
    private javax.swing.JRadioButton outputScreenRadioButton;
    private javax.swing.JTextField seedWordsFileTxtFld;
    private javax.swing.JLabel seedWordsLabel;
    private javax.swing.JLabel seedWordsLbl;
    private javax.swing.JTextArea statusTextArea;
    // End of variables declaration//GEN-END:variables

}
