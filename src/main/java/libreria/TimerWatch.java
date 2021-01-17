
package libreria;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TimerWatch {
    JLabel timer_label;
    static Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    Toolkit tool = Toolkit.getDefaultToolkit();
    static int heigth,width ;
    JButton Cronometro,Temporizador;
    long hh = 0,mm = 0,ss = 0,ms = 0,lap = 0;
    String String_hh,String_mm,String_ss,String_ms;
    static JFrame fr;
    JLabel timerlabel;
    Timer timer = new Timer(1, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
                try{
                    lap = lap +1;
                    hh =(lap/360000)%24;
                    mm = (lap/6000)%60;
                    ss = (lap/100)%60;
                    ms = lap%100;
                
                    String_hh = String.format("%02d", hh);
                    String_mm = String.format("%02d", mm);
                    String_ss = String.format("%02d", ss);
                    String_ms = String.format("%02d", ms);
                    timer_label.setText(String_hh+"h : "+String_mm+"m : "+String_ss+"s : "+String_ms+"ms");
                }catch(Exception ex){
                    tool.beep();
                    timer.stop();
                    JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.WARNING_MESSAGE);
                }
        }
        
    });
    private JLabel labelTimer(){
        timer_label = new JLabel();
        String txt = "00h : 00m : 00s : 00ms";
        timer_label.setBounds(80, 80, 380, 120);
        timer_label.setBackground(Color.WHITE);
        timer_label.setHorizontalAlignment(JTextField.CENTER);
        timer_label.setFont(new Font("Verdana",Font.PLAIN,28));
        timer_label.setBorder(BorderFactory.createBevelBorder(1));
        timer_label.setText(txt);
        return timer_label;
    }
    private JButton btnStart(){
        JButton start = new JButton ("Empezar");
        start.setBounds(80, 230, 120, 50);
        start.setActionCommand("Start");
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                timer.start();
            }
        });
        
        return start;
    }
    private JButton btnPausa(){
        JButton pausa = new JButton("Pausa");
        pausa.setBounds(210, 230, 120, 50);
        pausa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                timer.stop();
            } 
        });
        
        return pausa;
    }
    private JButton btnRestart(){
        JButton reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(340, 230, 120, 50);
        reiniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(timer.isRunning()){
                    timer.stop();
                    lap = 0;
                    timer_label.setText("00h : 00m : 00s : 00ms");
                }else{
                    lap = 0;
                    timer_label.setText("00h : 00m : 00s : 00ms");
                }
            }
        });
        return reiniciar;
    }
    public JButton btn_Cronometro(){
        Cronometro  = new JButton("Cronometro");
        Cronometro.setFont(new Font("Arial",Font.PLAIN,10));
        Cronometro.setBounds(340, 110, 100, 30);
        Cronometro.setActionCommand("Cronometro");
        Cronometro.addActionListener(new TimerListener(fr));
        return Cronometro;
    }  
    public JButton btn_Temporizador(){
        Temporizador = new JButton("Temporizador");
        Temporizador.setFont(new Font("Arial",Font.PLAIN,10));
        Temporizador.setBounds(460, 110, 100, 30);
        Temporizador.setActionCommand("Temporizador");
        Temporizador.addActionListener(new TimerListener());
        return Temporizador;
    }
    TimerWatch(){
        width = (pantalla.width/5)*2;
        heigth = pantalla.height/2;
        fr = new JFrame("Cronometro");
        fr.setLayout(null);
        fr.setSize(width,heigth);
        fr.setLocationRelativeTo(Cronometro);
        fr.add(this.btnStart());
        fr.add(this.btnPausa());
        fr.add(this.btnRestart());
        fr.add(this.labelTimer());
        fr.setVisible(false);
        fr.setResizable(false);
        
        
    }
    //Aqui pruebo antes de unir :)
   /* public static void main(String[]args){
       TimerWatch timer = new TimerWatch();
        MainFrame frame = new MainFrame();
        frame.add(timer.btn_Cronometro());
        frame.add(timer.btn_Temporizador());
   }*/
}
