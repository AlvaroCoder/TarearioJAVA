
package libreria;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
interface CuerpoPanel{
        public JPanel Panel(int num,String name);
    }
public class Principal extends JPanel{
    
    
    Toolkit tool = Toolkit.getDefaultToolkit();
    
   static int Max_Row = 5,count = -1;
    String txt1,txt2,txt;
    final javax.swing.JButton btn;
    private javax.swing.JPanel[] panel = new JPanel[5];
    private javax.swing.JButton[] btnRemove = new JButton[5];
  //  private javax.swing.JButton[] btnStart = new JButton[5];
    
    static JPanel ContentPanel;
    static JLabel labelname,labeldescription,label;
    static JButton butn = new JButton("Borrar");
    static JLabel tarealabel = new JLabel();
    
    
    int num = 0;
    static InputFields input;
    //Constructor :)
   
    public JPanel Panel(int num,String name){
        JButton button = new JButton("Borrar");
        JLabel labeltarea = new JLabel(name);
        panel[num] = new javax.swing.JPanel();
        
        panel[num].add(labeltarea);
        panel[num].add(button);
        
        return panel[num];
    }
    
    Principal(){
       //Button :)
        btn = new JButton("Añadir");
        btn.setBounds(80, 150, 100, 30);
        btn.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(input.Texto1().trim().equals("")||input.Texto3().trim().equals("")){
                    tool.beep();
                    JOptionPane.showMessageDialog(null, "Por favor complete los espacios en blanco ","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    count++;
                    if(count >= Max_Row){
                        tool.beep(); //SONIDO DE ALERTA POR DEFECTO EL DE LA COMPU
                        JOptionPane.showMessageDialog(null,"No se pueden agregar mas columnas :(","Error",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    txt1 = input.Texto1();
                    txt2 = input.Texto3();
                    txt="Tarea N°"+Integer.toString(count+1)+": "+txt1+"    Descripcion: "+txt2;
                    label =new JLabel(txt);
                    label.setFont(new Font("Verdana",Font.PLAIN,12));
                    label.setBounds(0, 20, 370, 30);
                    panel[count] = new javax.swing.JPanel();
                    
                    //Boton de eliminar tarea 
                    btnRemove[count] = new javax.swing.JButton();
                    btnRemove[count].setFont(new Font("Verdana",Font.PLAIN,10));
                    btnRemove[count].setText("x");
                    btnRemove[count].setBounds(465, 20, 45, 30);
                    btnRemove[count].setBackground(Color.red);
                    btnRemove[count].setForeground(Color.WHITE);
                    btnRemove[count].addActionListener((ActionEvent e1) -> {
                        //Terminar
                        if (e1.getSource() == btnRemove[0]) {
                            try{
                                ContentPanel.remove(panel[0]);
                                ContentPanel.updateUI();
                                count--;
                            }catch(Exception ex){
                                tool.beep();
                                JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (e1.getSource() == btnRemove[1]) {
                            try{
                                ContentPanel.remove(panel[1]);
                                ContentPanel.updateUI();
                                count--;
                            }catch(Exception ex){
                                tool.beep();
                                JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (e1.getSource() == btnRemove[2]) {
                            try{
                                ContentPanel.remove(panel[2]);
                            ContentPanel.updateUI();
                            }catch(Exception ex){
                                tool.beep();
                                JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (e1.getSource() == btnRemove[3]) {
                            try{
                                ContentPanel.remove(panel[3]);
                            ContentPanel.updateUI();
                            }catch(Exception ex){
                                 tool.beep();
                                JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (e1.getSource() == btnRemove[4]) {
                            try{
                                ContentPanel.remove(panel[4]);
                            ContentPanel.updateUI();
                            }catch(Exception ex){
                                 tool.beep();
                                JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    
                    //Boton de empezar tarea
                  /*  btnStart[count] = new javax.swing.JButton();
                    btnStart[count].setFont(new Font("Verdana",Font.PLAIN,10));
                    btnStart[count].setLayout(null);
                    btnStart[count].setText("Empezar");
                    btnStart[count].setBounds(370,20,85,30);*/
                    
                    
                    panel[count].setLayout(null);      
                    panel[count].add(label);
               //     panel[count].add(btnStart[count]);
                    panel[count].add(btnRemove[count]);
                    
                    SwingUtilities.invokeLater(new Runnable(){
                        @Override
                        public void run(){
                            ContentPanel.add(panel[count]);
                            ContentPanel.revalidate();
                            ContentPanel.repaint();
                        }
                    });
                    input.SetText1("");
                    input.SetText3("");
                }
            }
            
        });
        
        //LABELS :)
        labelname = new JLabel();
        labeldescription = new JLabel();
        labelname.setText("Nombre:");
        labeldescription.setText("Descripcion:");
        labelname.setBounds(5, 20, 50, 30);
        labeldescription.setBounds(5, 70, 80, 30);
        
        input = new InputFields();
        
        //AGREGAMOS LOS LABELS :)
        this.add(labelname);
        this.add(labeldescription);
        this.add(input.InputName());
        this.add(input.AreaDescription());
        this.add(btn);
        this.setBounds(10, 20, 300, 200);
        this.setLayout(null);
       
        this.setVisible(true);
    }
    public static void main(String[]args){
        
       label = new JLabel();
       label.setBounds(10, 20, 50, 30);
       Principal panel = new Principal();
       
       ContentPanel= new JPanel();
       ContentPanel.setVisible(true);
       ContentPanel.setLayout(new GridLayout(5,1));
       ContentPanel.setBounds(20, 220, 560, 320);
     
       //Horario

        MainFrame frame = new MainFrame();
        frame.add(panel);
        frame.add(ContentPanel);
       
    }

    
}