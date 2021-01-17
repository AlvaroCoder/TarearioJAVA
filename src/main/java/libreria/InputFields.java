
package libreria;

import javax.swing.JTextField;
import javax.swing.JTextArea;
public class InputFields {
    JTextField text1,text2;
    JTextArea area1;
    public JTextField InputName(){
        text1 = new JTextField("Nombre");
        text1.selectAll();
        text1.setBounds(100, 20, 150, 30);
        return text1;
    }
    public String Texto1(){
        String nombre = text1.getText();
        return nombre;
    }
    public JTextField InputDescription(){
        text2 = new JTextField("Nombre");
        text2.selectAll();
        text2.setBounds(100, 70, 150, 30);
        return text2;
    }
    public JTextArea AreaDescription(){
        area1 = new JTextArea();
        area1.setBounds(100, 70, 150, 50);
        return area1;
    }
    public String Texto2(){
        String nombre = text2.getText();
        return nombre;
    }
    public String Texto3(){
        String descripcion = area1.getText();
        return descripcion;
    }
    public void SetText1(String t){
        text1.setText(t);
    }
    public void SetText2(String t){
        text2.setText(t);
    }
    public void SetText3(String t){
        area1.setText(t);
    }
}
