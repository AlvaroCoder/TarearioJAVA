
package libreria;


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;

public class TimerPane extends JFrame{
    JFrame frame_temp;
    String Str_h,Str_m,Str_s,text;
    JButton btn;
    JLabel hh,mm,ss,label_timer;
    JTextField field_hh,field_mm,field_ss;
    JFormattedTextField text_hh,text_mm,text_ss;
    
    class TimerFrame extends JFrame{
      final JButton btn_start,btn_pause;
        int hour,minutes,seconds,lap;
        String txt;
        Timer timer;
        Toolkit tool = Toolkit.getDefaultToolkit();
        TimerFrame(){
            super("Temporizador");
            this.timer = new Timer(1000, (ActionEvent e) -> {
                if(lap == 0){
                    timer.stop();
                    tool.beep();
                    label_timer.setText("ACABO :)");
                }else{
                    lap--;
                    hour = (lap/3600)%24;
                    minutes = (lap/60)%60;
                    seconds = lap%60;
                    Str_h = String.format("%02d", hour);
                    Str_m =String.format("%02d", minutes);
                    Str_s = String.format("%02d", seconds);
                     txt= Str_h +" : "+Str_m+" : "+Str_s;
                    label_timer.setText(txt);
                }
            });
            btn_start = new JButton("Empezar");
            btn_start.setBounds(420, 30, 50, 50);
            btn_start.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                   timer.start();
                }
                
            });
            
            btn_pause = new JButton("Pausa");
            btn_pause.setBounds(420, 90, 50, 80);
            btn_pause.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                }
                
            });
            label_timer = new JLabel();
            label_timer.setBounds(10, 30, 400, 150);
            label_timer.setBorder(BorderFactory.createBevelBorder(1));
            label_timer.setHorizontalAlignment(JTextField.CENTER);
            label_timer.setFont(new Font("Arial", Font.PLAIN,30));
            
            
            this.add(label_timer);
            this.add(btn_start);
            this.add(btn_pause);
            this.setSize(500, 250);
            this.setLayout(null);
            this.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        public void setHour(int h){
            this.hour = h;
        }
        public void setMinutes(int m){
            this.minutes  = m;
        }
        public void setSeconds(int s){
            this.seconds = s;
        }
        public void setTexto(int h,int m, int s){
            hour = h;
            minutes = m;
            seconds = s;
            lap = (seconds)+(minutes*60)+(hour*3600);//Esta en segundos
               
            Str_h = String.format("%02d", hour);
            Str_m =String.format("%02d", minutes);
            Str_s = String.format("%02d", seconds);
            txt= Str_h +" : "+Str_m+" : "+Str_s;
            label_timer.setText(txt);
        }
    }
    
   TimerPane() {
       super("Temporizador");
       
       TimerFrame fr = new TimerFrame();
       btn = new JButton("Empezar");
       btn.setBounds(10, 70, 400, 40);
       btn.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               if(text_hh.getText().trim().equals("00") && text_mm.getText().trim().equals("00") &&text_ss.getText().trim().equals("00")){
                   JOptionPane.showMessageDialog(null, "Complete los espacios","Error",JOptionPane.WARNING_MESSAGE);
               }else{
                   fr.setVisible(true);
                   int h = Integer.parseInt(text_hh.getText());
                   int m = Integer.parseInt(text_mm.getText());
                   int s = Integer.parseInt(text_ss.getText());
                   fr.setTexto(h,m,s);
                   System.out.println(h);
                   System.out.println(m);
                   System.out.println(s);
               }
           }
           
       });
       try{
            MaskFormatter mask1 = new MaskFormatter("##");
            text_hh = new JFormattedTextField(mask1);
            text_hh.setBounds(10, 20, 90, 40);
            text_hh.setValue("00");
       
            MaskFormatter mask2 = new MaskFormatter("##");
            text_mm = new JFormattedTextField(mask2);
            text_mm.setBounds(150, 20, 90, 40);
            text_mm.setValue("00");
       
            MaskFormatter mask3 = new MaskFormatter("##");
            text_ss = new JFormattedTextField(mask3);
            text_ss.setBounds(290, 20, 90, 40);
            text_ss.setValue("00");
       }catch(ParseException ex){
           JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
       
       hh = new JLabel("h :");
       hh.setBounds(110, 20, 30, 40);
       hh.setFont(new Font("Verdana",Font.PLAIN,15));
       
       mm = new JLabel("m :");
       mm.setBounds(245, 20, 30, 40);
       mm.setFont(new Font("Verdana",Font.PLAIN,15));
       
       ss = new JLabel("s");
       ss.setBounds(385, 20, 25, 40);
       ss.setFont(new Font("Verdana",Font.PLAIN,15));
       
       this.setLayout(null);
       this.add(text_hh);
       this.add(hh);
       this.add(text_mm);
       this.add(mm);
       this.add(text_ss);
       this.add(ss);
       this.add(btn);
       this.setSize(450, 180);
       this.setVisible(false);
       this.setResizable(false);
       this.setLocationRelativeTo(null);
   }
   public String getText_hh(){
   return text_hh.getText();
   }
   public String getText_mm(){
   return text_mm.getText();
   }
   public String getText_ss(){
   return text_ss.getText();
   }
}
