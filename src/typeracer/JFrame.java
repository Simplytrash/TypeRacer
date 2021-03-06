/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 53874
 */
public class JFrame extends javax.swing.JFrame {

    private Profile profile;
    private String[] words = {"welcome", "hello", "and", "monkey", "you", "peace", "morning", "gleaming", "it", "sun", "brings", "sorrow", "show", "gold", "car", "love", "gun", "moon", "mouse", "keyboard", "computer", "monitor", "phone", "usb", "charger", "laptop", "too", "under", "must", "way", "over", "on", "change", "if", "great", "right", "left", "plan", "when", "here", "each", "which", "look", "we", "nation", "country", "continent", "human", "competition", "married", "sweet", "come", "lingers", "scent", "sell", "buy", "temptation"};
    private boolean started = false;
    private int seconds = 30;
    private int index = 0;
    private int correctWordsTyped = 0;
    private Map<Integer, Character> inaccurate = new HashMap<>();
    
    /**
     * Creates new form JFrame
     */
    public JFrame(Profile prof) {
        profile = prof; // Register profile
        initComponents();
        txtField.disable(); // Disable text field
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtField = new javax.swing.JTextField();
        count = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        txtField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtField.setForeground(new java.awt.Color(255, 255, 255));
        txtField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldActionPerformed(evt);
            }
        });
        txtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldKeyPressed(evt);
            }
        });

        count.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count.setText("Type Racer");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addToCart.png"))); // NOI18N
        jButton1.setText("Start");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("30s");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtField)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(count)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (started) { // Check if it hasn't started
            return; // Dont run the code below
        }
        
        StringBuilder stringBuilder = new StringBuilder(); // Register string builder
        
        for (int i = 0; i < 8; i++) { // loop through code below 8 times
            stringBuilder.append(words[ThreadLocalRandom.current().nextInt(words.length)]).append(" "); // Add a word to the stringbuilder
        }
        
        txtField.setText(stringBuilder.toString()); // SEt text to full stringbuilder
        started = true; // Set started to true
        jButton1.disable(); // Disable button
        
        Timer timer = new Timer(); // Register timer
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                seconds--; // Minus 1 from seconds
                jLabel1.setText(seconds + "s"); // Set text
                
                if (seconds <= 0) { // If seconds is 0 do code below
                    cancel(); // Cancel task
                    started = false; // Set started to false
                    
                    setVisible(false); // Close frame
                    new ResultsFrame(profile, correctWordsTyped, index, inaccurate.size()).setVisible(true); // open new frame
                }
            }
        }, 0, 1000); // Run task every second
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void txtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldActionPerformed

    }//GEN-LAST:event_txtFieldActionPerformed

    private void txtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldKeyPressed

    }//GEN-LAST:event_txtFieldKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (!started) { // If its not started dont do code below
            return;
        }
        
        char firstKey = txtField.getText().charAt(0); // Find the first character in string
        
        if (firstKey != evt.getKeyChar()) { // If its incorrect do code below
            inaccurate.put(index, firstKey); // Add to the inaccuracy counter
            return;
        }
        
        if (evt.getKeyChar() == ' ') { // Check if the character typed is a space
            correctWordsTyped++; // Add to the correct counter
            txtField.setText(txtField.getText() + words[ThreadLocalRandom.current().nextInt(words.length)] + " "); // Add 1 more word to the list
        }
        
        index++; // Add 1 to the index
        
        String subString = txtField.getText().substring(1); // Take one off string
        txtField.setText(subString); // Set text
    }//GEN-LAST:event_jButton1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel count;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}
