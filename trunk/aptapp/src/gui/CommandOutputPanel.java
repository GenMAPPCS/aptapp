package gui;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

/*
 * CommandOutputPanel.java
 *
 * Created on Jun 11, 2010, 1:29:17 PM
 */
/**
 * Panel for displaying the output generated by the apt-probeset-summarize command
 * @author Anurag Sharma
 */
public class CommandOutputPanel extends javax.swing.JPanel {

    /** Creates new form CommandOutputPanel */
    public CommandOutputPanel() {
        initComponents();
        customInit();
    }

    /**
     * Performs initialization
     */
    private void customInit() {
    }

    /**
     *
     * @return the Editor pane where the output text is displayed
     */
    public JEditorPane getOutputPane() {
        return outputPane;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        outputPane = new javax.swing.JEditorPane();

        setBackground(new java.awt.Color(200, 190, 250));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setHorizontalScrollBar(null);

        outputPane.setBackground(new java.awt.Color(0, 0, 0));
        outputPane.setEditable(false);
        outputPane.setForeground(new java.awt.Color(255, 255, 255));
        outputPane.setToolTipText("Output of APT");
        jScrollPane1.setViewportView(outputPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane outputPane;
    // End of variables declaration//GEN-END:variables

    /**
     * independently tests this class
     * @param args
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.add(new CommandOutputPanel());
        f.setVisible(true);

    }
}