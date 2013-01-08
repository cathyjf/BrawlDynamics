/**
 * A basic Super Smash Bros. Brawl physics simulation Applet.
 * Copyright (C) 2009  Cathy Fitzpatrick <cathy@cathyjf.com>
 * Created in January 2009.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 **/

package dynamics;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  Cathy
 */
public class SimulationPanel extends javax.swing.JPanel {
    
    private int m_frame;
    private double m_angle;
    private int m_vx, m_vy;
    private int m_sx, m_sy;
    private int m_maxsx, m_maxsy;
    private long m_maxs;
    private Character m_character;
    private int m_launchForce;
    private Thread m_thread;
    private int m_delay;
    private boolean m_running = true;
    private Visualisation m_visual = new Visualisation();
    
    private static double V_WIDTH = 200000.0;
    private static double V_HEIGHT = 140000.0;
    
    static class Visualisation extends JPanel {
        private double m_x = 0, m_y = 0;
        public Visualisation() {
            setPosition(0, 0);
        }
        public void setPosition(int x, int y) {
            m_x = V_WIDTH / 2.0 + x ;
            m_y = V_HEIGHT - y;
            repaint();
        }
        public void paintComponent(Graphics g) {
            g.setColor(Color.RED);
            Dimension s = getSize();

            g.fillOval((int)(s.getWidth() * (m_x - 5.0) / V_WIDTH),
                    (int)(s.getHeight() * (m_y - 5.0) / V_HEIGHT) - 13, 10, 10);
        }
    }
    
    public void stopRunning() {
        m_running = false;
        m_thread.interrupt();
    }
    
    private void resetDisplay() {
        txtDataX.setText(null);
        txtDataY.setText(null);
        txtDataSx.setText(null);
        txtDataSy.setText(null);
        txtDataS.setText(null);
    }
    
    /** Creates new form SimulationPanel */
    public SimulationPanel() {
        m_thread = new Thread(new Runnable() {
            public void run() {
                while (m_running) {
                    try {
                        synchronized (m_thread) {
                            m_thread.wait();
                        }
                    } catch (InterruptedException e) {
                    }
                    if (!m_running) {
                        return;
                    }
                    // Run the simulation.
                    synchronized (m_thread) {
                        do {
                            ++m_frame;
                            int v[] = Dynamics.getVelocity(m_launchForce,
                                    m_angle,
                                    m_character.getFallAcceleration(),
                                    m_character.getTopFallSpeed(), m_frame);
                            m_vx = v[0];
                            m_vy = v[1];
                            m_sx += m_vx;
                            m_sy += m_vy;
                            System.out.println("Frame " + m_frame + ": y = " + m_sy);
                            if (m_sy < 0) {
                                m_sy = 0;
                            }
                            if (Math.abs(m_sx) > Math.abs(m_maxsx)) {
                                m_maxsx = m_sx;
                            }
                            if (Math.abs(m_sy) > Math.abs(m_maxsy)) {
                                m_maxsy = m_sy;
                            }
                            long s = (long)(Math.pow((double)m_sx, 2.0)
                                    + Math.pow((double)m_sy, 2.0));
                            if (s > m_maxs) {
                                m_maxs = s;
                            } else {
                                s = m_maxs;
                            }
                            final long s2 = s;
                            final int vx = m_vx, vy = m_vy, sx = m_maxsx, sy = m_maxsy;
                            try {
                                java.awt.EventQueue.invokeAndWait(new Runnable() {
                                    public void run() {
                                        txtDataX.setText(String.valueOf(vx));
                                        txtDataY.setText(String.valueOf(vy));
                                        txtDataSx.setText(String.valueOf(sx));
                                        txtDataSy.setText(String.valueOf(sy));
                                        txtDataS.setText(
                                                String.valueOf(
                                                (int)Math.sqrt(s2)));
                                        m_visual.setPosition(m_sx, m_sy);
                                        repaint();
                                    }
                                });
                            } catch (Exception e) {
                            }
                            try {
                                m_thread.wait(m_delay);
                            } catch (InterruptedException e2) {

                            }
                        } while (m_sy > 0);
                    }
                }
            }
        });
        m_thread.start();
        initComponents();
        cboCharacter.removeAllItems();
        Collection<String> c = Character.getCharacterList();
        ArrayList<String> list = new ArrayList<String>(c);
        Collections.sort(list);
        for (String i : list) {
            cboCharacter.addItem(i);
        }
        resetDisplay();
        panel.add(m_visual);
        m_visual.setVisible(true);
        m_visual.setLocation(1, 1);
        m_visual.setSize(panel.getPreferredSize());
        panel.repaint();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLaunchForce = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAngle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboCharacter = new javax.swing.JComboBox();
        cmdPlay = new javax.swing.JButton();
        txtVx = new javax.swing.JLabel();
        txtVy = new javax.swing.JLabel();
        txtDataX = new javax.swing.JLabel();
        txtDataY = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataSx = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDataSy = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDataS = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.layout.GroupLayout panelLayout = new org.jdesktop.layout.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 467, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 244, Short.MAX_VALUE)
        );

        jLabel1.setText("Launch force:");

        txtLaunchForce.setText("4000");
        txtLaunchForce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLaunchForceActionPerformed(evt);
            }
        });

        jLabel2.setText("Launch angle (°):");
        jLabel2.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jLabel2AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        txtAngle.setText("30");

        jLabel3.setText("Frames per second:");

        txtRate.setText("20");

        jLabel4.setText("Character:");

        cboCharacter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmdPlay.setText("Play");
        cmdPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPlayActionPerformed(evt);
                jButton2ActionPerformed(evt);
            }
        });

        txtVx.setText("x velocity:");

        txtVy.setText("y velocity:");

        txtDataX.setText("x");

        txtDataY.setText("y");

        jLabel5.setText("max x position:");

        txtDataSx.setText("x");

        jLabel7.setText("max y position:");

        txtDataSy.setText("y");

        jLabel6.setText("max distance:");

        txtDataS.setText("s");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel4)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(txtAngle)
                                .add(txtLaunchForce, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                            .add(cboCharacter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(27, 27, 27)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtVy, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtVx)
                                    .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtDataS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(txtDataSy, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(txtDataX, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                    .add(txtDataSx, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(txtDataY, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .add(34, 34, 34))
                    .add(panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cmdPlay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtLaunchForce, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtDataX)
                    .add(txtVx, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtVy)
                            .add(txtDataY))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(txtDataSx))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(txtDataSy)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtAngle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(jLabel4)
                                .add(4, 4, 4))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cboCharacter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel6)
                        .add(txtDataS))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtRate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cmdPlay)
                .add(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtLaunchForceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLaunchForceActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtLaunchForceActionPerformed

    private void jLabel2AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jLabel2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2AncestorMoved

    private void cmdPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPlayActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cmdPlayActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ilf, iangle;
        double drate;
        try {
            ilf = Integer.valueOf(txtLaunchForce.getText());
            iangle = Integer.valueOf(txtAngle.getText());
            drate = Double.valueOf(txtRate.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please confirm that all of the fields contain only numbers.");
            return;
        }
        
        if (ilf <= 0) {
            JOptionPane.showMessageDialog(this,
                    "The launch force must be bigger than zero.");
            return;
        }
        
        if ((iangle < 0) || (iangle > 180)) {
            JOptionPane.showMessageDialog(this,
                    "The launch angle must be between 0 and 180 degrees.");
            return;
        }
        
        synchronized (m_thread) {
            m_frame = 0;
            m_sx = m_sy = m_vx = m_vy = 0;
            m_maxsx = m_maxsy = 0;
            m_maxs = 0;
            m_angle = ((double)iangle) / 180.0 * Math.PI;
            m_launchForce = ilf;
            m_delay = (int)(1.0 / drate * 1000);
            m_character = Character.getCharacter(
                    (String)cboCharacter.getSelectedItem());
            resetDisplay();
            m_thread.notify();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCharacter;
    private javax.swing.JButton cmdPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtAngle;
    private javax.swing.JLabel txtDataS;
    private javax.swing.JLabel txtDataSx;
    private javax.swing.JLabel txtDataSy;
    private javax.swing.JLabel txtDataX;
    private javax.swing.JLabel txtDataY;
    private javax.swing.JTextField txtLaunchForce;
    private javax.swing.JTextField txtRate;
    private javax.swing.JLabel txtVx;
    private javax.swing.JLabel txtVy;
    // End of variables declaration//GEN-END:variables
    
}
