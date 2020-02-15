package metodosnumericos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Container.*;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.math.RoundingMode;
public class MetodosNumericos extends JFrame {	
    
    JLabel valVerdadero, valAproximado, dec, eRel, eAbs, relativo, absoluto; //Variables
    JTextField verd, aprox, deci, resAbs, resRel ;
    JButton cmdAceptar, cmdLimpiar;
    JButton truncar, redondear, acep;
    FlowLayout layout;
    Container container;
    private double valorverdadero;
    private double valoraproximado;
    private double valresultanteabsoluto;
    private double valresultanterelativo;
    private int numdec;
    private int cantDeci;
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "TEMA 1:INTRODUCCIÓN A LOS MÉTODOS NUMÉRICOS");
        MetodosNumericos ventana = new MetodosNumericos("Errores"); }
    
    public MetodosNumericos(String titulo) {
        super(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Creacion de ventana
        setSize(400, 180);

        ManejadorEventos manejador = new ManejadorEventos();

        valVerdadero = new JLabel("   Introduzca valor verdadero:");
        valAproximado = new JLabel("   Introduzca valor aproximado:");

        verd = new JTextField();
        JTextField resAbs = verd;
        
        aprox = new JTextField();
        JTextField resRel = aprox;
              
        cmdAceptar = new JButton("Aceptar");
        cmdAceptar.addActionListener(manejador);
        cmdLimpiar = new JButton("Limpiar");
        cmdLimpiar.addActionListener(manejador);

        JPanel panelDatos = new JPanel();
        GridLayout gl = new GridLayout(3, 2, 0, 5);
        panelDatos.setLayout(gl); 

        panelDatos.add(valVerdadero);
        panelDatos.add(verd);
        panelDatos.add(valAproximado);
        panelDatos.add(aprox);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(cmdAceptar);
        panelBotones.add(cmdLimpiar);

        Container cp = getContentPane();
        cp.add(panelDatos, BorderLayout.CENTER);
        cp.add(panelBotones, BorderLayout.SOUTH);

        setVisible(true); } //hacemos visible la ventana
        
        public class TruncarRedondear extends JFrame {

        public TruncarRedondear() {
            super("¿Qué acción desea realizar?");

            ManejadorEventos manejador2 = new ManejadorEventos();
            
            Container contenedor = getContentPane();
            contenedor.setLayout(new FlowLayout());

            truncar = new JButton("Truncar resultado");
            contenedor.add(truncar);
            truncar.addActionListener(manejador2);
            
            redondear = new JButton("Redondear resultado");
            contenedor.add(redondear);
            redondear.addActionListener(manejador2);

            setSize(350, 80);
            setVisible(true);
        }
    }
       
    public class ManejadorEventos implements ActionListener {

        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == cmdAceptar) {
                valorverdadero=Double.parseDouble(verd.getText());
                valoraproximado=Double.parseDouble(aprox.getText());
                valresultanteabsoluto=(valorverdadero-valoraproximado);
                if (valresultanteabsoluto<0){
                    valresultanteabsoluto=valresultanteabsoluto*-1;
                }
                valresultanterelativo=((valorverdadero-valoraproximado)/valorverdadero);
              TruncarRedondear tr = new TruncarRedondear();
            }

            if (evento.getSource() == cmdLimpiar) {
                verd.setText("");
                aprox.setText("");
            }
            if (evento.getSource() == cmdLimpiar) {
                verd.setText("");
                aprox.setText("");
            }
               if (evento.getSource() == truncar) {
              numdec=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de decimales"));
             //truncar valor absoluto
              int multiplicador=1;
              for (int i=0; i<numdec;i++){
                 multiplicador=multiplicador*10;
             }    
                //truncar valor relativo
    double decimal2=valresultanterelativo%1;
    double entero2=valresultanterelativo-(valresultanterelativo%1);
    valresultanterelativo=valresultanterelativo-decimal2;
    decimal2=decimal2*multiplicador;
    decimal2=decimal2-(decimal2%1);
    decimal2=decimal2/multiplicador;
    valresultanterelativo=(valresultanterelativo+decimal2);
    if (valresultanterelativo<0){
        valresultanterelativo=valresultanterelativo*-1;
    }
    JOptionPane.showMessageDialog(null, "Error absoluto: "+valresultanteabsoluto+"\n"
                                                                +"Error relativo: "+valresultanterelativo);
                                                                }
      if (evento.getSource() == redondear){
                  numdec=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de decimales"));
                  //redondear valor absoluto
                  BigDecimal red=new BigDecimal(valresultanteabsoluto);
                  red=red.setScale(numdec, RoundingMode.HALF_EVEN);
                  valresultanteabsoluto=red.doubleValue();
                  
                  //redondear valor relativo
                  BigDecimal red2=new BigDecimal(valresultanterelativo);
                  red2=red2.setScale(numdec, RoundingMode.HALF_EVEN);
                  valresultanteabsoluto=red2.doubleValue();
                    JOptionPane.showMessageDialog(null, "Error absoluto: "+valresultanteabsoluto+"\n"
                                                                +"Error relativo: "+valresultanterelativo);
             }
        }
    }
}//fin de la clase
     
