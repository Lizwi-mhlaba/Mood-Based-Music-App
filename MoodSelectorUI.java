// Source code is decompiled from a .class file using FernFlower decompiler.
package com.moodifyx;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MoodSelectorUI extends JFrame {
   private final MoodRepository repository = new MoodRepository();

   public MoodSelectorUI() {
      this.setTitle("Moodifyx");
      this.setSize(600, 400);
      this.setDefaultCloseOperation(3);
      this.setLocationRelativeTo((Component)null);
      this.setupUI();
      this.setVisible(true);
   }

   private void setupUI() {
      ImageIcon var1 = new ImageIcon("src/assets/background.jpg");
      JLabel var2 = new JLabel(var1);
      var2.setLayout(new BorderLayout());
      Set var3 = this.repository.getAllMoods();
      JComboBox var4 = new JComboBox((String[])var3.toArray(new String[9]));
      JButton var5 = new JButton("Recommend Music");
      JPanel var6 = new JPanel();
      var6.setOpaque(false);
      var6.add(new JLabel("Select Your Mood"));
      var6.add(var4);
      var6.add(var5);
      var2.add(var6, "South");
      var6.add(var2);
      var5.addActionListener((var2x) -> {
         String var3 = (String)var4.getSelectedItem();

         while(true) {
            while(true) {
               List var4x = this.repository.getSongsForMood(var3);
               Song var5 = (Song)var4x.get(ThreadLocalRandom.current().nextInt(var4x.size()));
               SongPlayer.play(var5.getFilePath());
               Object[] var6 = new Object[]{" Another Song", "Change Mood", "Stop Music and Exit"};
               int var7 = JOptionPane.showOptionDialog((Component)null, "Now playing : " + var5.getTitle() + "\nMood : " + var3, "Your Mood Music", 1, 3, (Icon)null, var6, var6[0]);
               SongPlayer.stop();
               if (var7 != 0) {
                  if (var7 == 1) {
                     return;
                  }

                  System.exit(0);
               }
            }
         }
      });
      JPanel var7 = new JPanel();
      var7.add(new JLabel("Select Your Mood: "));
      var7.add(var4);
      var7.add(var5);
      var7.add(var7);
   }
}