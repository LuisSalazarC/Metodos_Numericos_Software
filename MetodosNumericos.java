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
        
        
