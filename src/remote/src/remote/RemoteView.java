/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RemoteView.java
 *
 * Created on Jul 27, 2010, 11:40:30 AM
 */

package remote;

/**
 *
 * @author Dani
 */
public class RemoteView extends javax.swing.JFrame {
    RemoteController controller;
    /** Creates new form RemoteView */
    public RemoteView(RemoteController controller) {
        initComponents();
        setVisible(true);
        this.controller = controller;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        info = new javax.swing.JPanel();
        robotNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nameChooser = new javax.swing.JList();
        robotIPLabel = new javax.swing.JLabel();
        ipTextField = new javax.swing.JTextField();
        Build = new javax.swing.JPanel();
        typePanel = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        typeChooser = new javax.swing.JComboBox();
        configureButton = new javax.swing.JButton();
        compileButton = new javax.swing.JButton();
        installButton = new javax.swing.JButton();
        Controller = new javax.swing.JPanel();
        restartButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        File = new javax.swing.JPanel();
        fileNamePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remote");
        getContentPane().setLayout(new java.awt.GridLayout(2, 2));

        info.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        info.setPreferredSize(new java.awt.Dimension(150, 150));
        info.setLayout(new java.awt.GridLayout(2, 2));

        robotNameLabel.setText("Robot Name:");
        info.add(robotNameLabel);

        nameChooser.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "marvin", "slarti", "trillian", "zaphod" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        nameChooser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(nameChooser);

        info.add(jScrollPane1);

        robotIPLabel.setText("Robot IP:");
        info.add(robotIPLabel);

        ipTextField.setMaximumSize(new java.awt.Dimension(2, 2));
        ipTextField.setMinimumSize(new java.awt.Dimension(2, 2));
        ipTextField.setPreferredSize(new java.awt.Dimension(7, 7));
        ipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTextFieldActionPerformed(evt);
            }
        });
        info.add(ipTextField);

        getContentPane().add(info);

        Build.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Build.setPreferredSize(new java.awt.Dimension(150, 150));
        Build.setLayout(new java.awt.GridLayout(0, 1));

        typePanel.setLayout(new java.awt.GridLayout(1, 0));

        typeLabel.setText("Type:");
        typePanel.add(typeLabel);

        typeChooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cross", "straight", "webots" }));
        typeChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeChooserActionPerformed(evt);
            }
        });
        typePanel.add(typeChooser);

        Build.add(typePanel);

        configureButton.setText("Configure man");
        configureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configureButtonActionPerformed(evt);
            }
        });
        Build.add(configureButton);

        compileButton.setText("Compile man");
        compileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileButtonActionPerformed(evt);
            }
        });
        Build.add(compileButton);

        installButton.setText("Install man");
        installButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installButtonActionPerformed(evt);
            }
        });
        Build.add(installButton);

        getContentPane().add(Build);

        Controller.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Controller.setPreferredSize(new java.awt.Dimension(150, 150));
        Controller.setLayout(new java.awt.GridLayout(0, 1));

        restartButton.setText("Restart NaoQi");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        Controller.add(restartButton);

        stopButton.setText("Stop NaoQi");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        Controller.add(stopButton);

        getContentPane().add(Controller);

        File.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        File.setPreferredSize(new java.awt.Dimension(150, 150));
        File.setLayout(new java.awt.GridLayout(0, 1));

        fileNamePanel.setLayout(new java.awt.GridLayout(1, 0));
        File.add(fileNamePanel);

        getContentPane().add(File);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configureButtonActionPerformed
        controller.configure((String)typeChooser.getSelectedItem(),
                            (String)nameChooser.getSelectedValue(),
                            (String)ipTextField.getText());
    }//GEN-LAST:event_configureButtonActionPerformed

    private void compileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileButtonActionPerformed
        controller.compile((String)typeChooser.getSelectedItem());
    }//GEN-LAST:event_compileButtonActionPerformed

    private void ipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTextFieldActionPerformed

    private void typeChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeChooserActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        controller.stopNaoQi(ipTextField.getText());
    }//GEN-LAST:event_stopButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        controller.restartNaoQi(ipTextField.getText());
    }//GEN-LAST:event_restartButtonActionPerformed

    private void installButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installButtonActionPerformed
        controller.install((String)typeChooser.getSelectedItem());
    }//GEN-LAST:event_installButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Build;
    private javax.swing.JPanel Controller;
    private javax.swing.JPanel File;
    private javax.swing.JButton compileButton;
    private javax.swing.JButton configureButton;
    private javax.swing.JPanel fileNamePanel;
    private javax.swing.JPanel info;
    private javax.swing.JButton installButton;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList nameChooser;
    private javax.swing.JButton restartButton;
    private javax.swing.JLabel robotIPLabel;
    private javax.swing.JLabel robotNameLabel;
    private javax.swing.JButton stopButton;
    private javax.swing.JComboBox typeChooser;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JPanel typePanel;
    // End of variables declaration//GEN-END:variables

}
