
package libreria;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TimerListener implements ActionListener{
    JFrame frame;
    JLabel label ;
    TimerPane panel = new TimerPane();
    TimerListener(){
    
    }
    TimerListener(JFrame fr){
        this.frame = fr;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if("Cronometro".equals(e.getActionCommand())){
           this.frame.setVisible(true);
       }else if("Temporizador".equals(e.getActionCommand())){
           panel.setVisible(true);
       }
    }
    
}
