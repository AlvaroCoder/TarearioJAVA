
package libreria;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class MainFrame extends JFrame implements WindowListener{
    Toolkit tool = Toolkit.getDefaultToolkit();
    int hh,mm,ss,tarde;
    String hhs,mms,sss,am,pm;
    LocalTime time ;
    JLabel TimeLabel;
    JPanel panel;
    public JLabel MainLabel(){
        tarde = 12;
        am = "a.m";
        pm = "p.m";
        time = LocalTime.now();
        hh = time.getHour();
        mm = time.getMinute();
        ss = time.getSecond();
        
        hhs = String.format("%02d", hh);
        mms = String.format("%02d", mm);
        sss = String.format("%02d", ss);
        
        TimeLabel = new JLabel();
        TimeLabel.setBounds(350,50,200,50);
        
        TimeLabel.setBorder(BorderFactory.createBevelBorder(1));
        TimeLabel.setFont(new Font("Verdana",Font.PLAIN,15));
        TimeLabel.setText("     "+hhs+"h: "+mms+"m: "+sss+"s "+(hh>=tarde?pm:am));
        return TimeLabel;
    }
  
    MainFrame(){
        TimerWatch t = new TimerWatch();
        
        this.addWindowListener(this);
        this.setTitle("Tareario ");
        this.setLayout(null);
        //Agregamos los componentes
        this.add(this.MainLabel());
        this.add(t.btn_Cronometro());
        this.add(t.btn_Temporizador());
        
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    Timer timer = new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                time = LocalTime.now();
                hh = time.getHour();
                mm = time.getMinute();
                ss = time.getSecond();
                
                hhs = String.format("%02d", hh);
                mms = String.format("%02d", mm);
                sss = String.format("%02d", ss);
                TimeLabel.setText("     "+hhs+"h: "+mms+"m: "+sss+"s "+(hh>=tarde?pm:am));
            }
        
        });
    @Override
    public void windowOpened(WindowEvent e) {
       timer.start();
    }

   @Override
    public void windowClosing(WindowEvent e) {
        tool.beep();
        final int option = JOptionPane.showConfirmDialog(null,"Estas seguro de salir","Salir",JOptionPane.YES_NO_OPTION);
        if(option == 0){
            timer.stop();
            this.dispose();           
        }else if(option ==1){
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
      
    }

    @Override
    public void windowIconified(WindowEvent e) {
   
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
   
    }

    @Override
    public void windowActivated(WindowEvent e) {
     }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    /*public static void main(String[]args){
        MainFrame frame = new MainFrame();
        
    }*/
}
