/*
 Clase AhorcadoGUI: Menú para el usuario
  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package Ahorcado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.UIManager.LookAndFeelInfo;
import java.lang.*;
import java.io.FileNotFoundException;

public class AhorcadoGUI extends JFrame{
    
    Container contenedor;
    JLabel lbTema,lbTeclado,lbIngresarLetra,lbImagen,lbOportunidades;
    JButton btA,btB,btC,btD,btE,btF,btG,btH,btI,btJ,btK,btL,btM,btN,btO,btP,btQ,btR,btS,btT,btU,btV,btW,btX,btY,btZ,btReiniciar,btIngresarLetra;
    JTextField tfIngresarLetra;
    JPanel panelTeclado,panelTemaPalabra,panelImagenOportunidad;
    ManejadorDeEventos manejador;
    JTextArea area,areaPalabra;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem itemInfo,itemRestart,itemExit;
    
    Ahorcado miJuego=new Ahorcado();
    String tema=miJuego.temaAzar();
    String palabraOculta;
    String palabraAux;
    
    //Constructor
    public AhorcadoGUI(){
        miJuego.setPalabra(miJuego.palabraAzar(tema));
        try{
        miJuego.cambiarEstadoImagen();
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la imagen del ahorcado :(\n\n Imagen no encontrada");
        }
        palabraOculta=miJuego.ocultarPalabra(miJuego.getPalabra());
        palabraAux=miJuego.getPalabra();
        //Inicializar Area Texto
        area=new JTextArea(5,10);
        areaPalabra=new JTextArea(0,10);
        areaPalabra.setText(palabraOculta);
        areaPalabra.setEditable(false);
        //Inicializar Labels
        lbTema=new JLabel();
        lbTema.setText("Tema: " + tema);
        lbTeclado=new JLabel("Teclado");
        lbIngresarLetra=new JLabel("Ingrese una letra");
        lbImagen=new JLabel();
        lbImagen.setIcon(miJuego.getImagenAhorcado());
        lbOportunidades=new JLabel();
        lbOportunidades.setText("Te quedan "+ Integer.toString(miJuego.getOportunidades()) + " oportunidades");
        //Inicializar Botones
        btA=new JButton("A");btA.setBackground(Color.cyan);btB=new JButton("B");btB.setBackground(Color.cyan);
        btC=new JButton("C");btC.setBackground(Color.cyan);btD=new JButton("D");btD.setBackground(Color.cyan);
        btE=new JButton("E");btE.setBackground(Color.cyan);btF=new JButton("F");btF.setBackground(Color.cyan);
        btG=new JButton("G");btG.setBackground(Color.cyan);btH=new JButton("H");btH.setBackground(Color.cyan);
        btI=new JButton("I");btI.setBackground(Color.cyan);btJ=new JButton("J");btJ.setBackground(Color.cyan);
        btK=new JButton("K");btK.setBackground(Color.cyan);btL=new JButton("L");btL.setBackground(Color.cyan);
        btM=new JButton("M");btM.setBackground(Color.cyan);btN=new JButton("N");btN.setBackground(Color.cyan);
        btO=new JButton("O");btO.setBackground(Color.cyan);btP=new JButton("P");btP.setBackground(Color.cyan);
        btQ=new JButton("Q");btQ.setBackground(Color.cyan);btR=new JButton("R");btR.setBackground(Color.cyan);
        btS=new JButton("S");btS.setBackground(Color.cyan);btT=new JButton("T");btT.setBackground(Color.cyan);
        btU=new JButton("U");btU.setBackground(Color.cyan);btV=new JButton("V");btV.setBackground(Color.cyan);
        btW=new JButton("W");btW.setBackground(Color.cyan);btX=new JButton("X");btX.setBackground(Color.cyan);
        btY=new JButton("Y");btY.setBackground(Color.cyan);btZ=new JButton("Z");btZ.setBackground(Color.cyan);
        btIngresarLetra=new JButton("Ingresar");btReiniciar=new JButton("Reiniciar");
        
        //Inicializar TextField
        tfIngresarLetra=new JTextField("");
        
        //Inicializar MenuBar
        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        //Inicializar Menu
        menu=new JMenu("Menu");
        menuBar.add(menu);
        //Inicializar Menu Item
        itemInfo=new JMenuItem("Información");
        itemRestart=new JMenuItem("Reiniciar");
        itemExit=new JMenuItem("cerrar");
        //Agregar MenuItems al Menu
        menu.add(itemInfo);
        menu.add(itemRestart);
        menu.add(itemExit);
        //Inicializar Manejador
        manejador = new ManejadorDeEventos();
        //Agregar Listeners
        btA.addActionListener(manejador);btG.addActionListener(manejador);btM.addActionListener(manejador);btR.addActionListener(manejador);btW.addActionListener(manejador);
        btB.addActionListener(manejador);btH.addActionListener(manejador);btN.addActionListener(manejador);btS.addActionListener(manejador);btX.addActionListener(manejador);
        btC.addActionListener(manejador);btI.addActionListener(manejador);btO.addActionListener(manejador);btT.addActionListener(manejador);btY.addActionListener(manejador);
        btD.addActionListener(manejador);btJ.addActionListener(manejador);btP.addActionListener(manejador);btU.addActionListener(manejador);btZ.addActionListener(manejador);
        btE.addActionListener(manejador);btK.addActionListener(manejador);btQ.addActionListener(manejador);btV.addActionListener(manejador);btF.addActionListener(manejador);
        btL.addActionListener(manejador);btIngresarLetra.addActionListener(manejador);
        btReiniciar.addActionListener(manejador);itemInfo.addActionListener(manejador);itemRestart.addActionListener(manejador);itemExit.addActionListener(manejador);
        
        btA.addMouseListener(manejador);btG.addMouseListener(manejador);btM.addMouseListener(manejador);btR.addMouseListener(manejador);btW.addMouseListener(manejador);
        btB.addMouseListener(manejador);btH.addMouseListener(manejador);btN.addMouseListener(manejador);btS.addMouseListener(manejador);btX.addMouseListener(manejador);
        btC.addMouseListener(manejador);btI.addMouseListener(manejador);btO.addMouseListener(manejador);btT.addMouseListener(manejador);btY.addMouseListener(manejador);
        btD.addMouseListener(manejador);btJ.addMouseListener(manejador);btP.addMouseListener(manejador);btU.addMouseListener(manejador);btZ.addMouseListener(manejador);
        btE.addMouseListener(manejador);btK.addMouseListener(manejador);btQ.addMouseListener(manejador);btV.addMouseListener(manejador);btF.addMouseListener(manejador);
        btL.addMouseListener(manejador);
        
        tfIngresarLetra.addKeyListener(manejador);
        //Inicializar Panels
        panelTeclado=new JPanel();
        panelTeclado.setLayout(new GridLayout(4,7));
        
        panelTemaPalabra=new JPanel();
        panelTemaPalabra.setLayout(new GridLayout(4,1));
        //Agregar A los Panels
        panelTeclado.add(btA);panelTeclado.add(btB);panelTeclado.add(btC);panelTeclado.add(btD);panelTeclado.add(btE);
        panelTeclado.add(btF);panelTeclado.add(btG);panelTeclado.add(btH);panelTeclado.add(btI);panelTeclado.add(btJ);
        panelTeclado.add(btK);panelTeclado.add(btL);panelTeclado.add(btM);panelTeclado.add(btN);panelTeclado.add(btO);
        panelTeclado.add(btP);panelTeclado.add(btQ);panelTeclado.add(btR);panelTeclado.add(btS);panelTeclado.add(btT);
        panelTeclado.add(btU);panelTeclado.add(btV);panelTeclado.add(btW);panelTeclado.add(btX);panelTeclado.add(btY);
        panelTeclado.add(btZ);
        
        panelTemaPalabra.add(lbTema);
        panelTemaPalabra.add(areaPalabra);
        panelTemaPalabra.add(lbIngresarLetra);
        panelTemaPalabra.add(tfIngresarLetra);
        panelTemaPalabra.add(btIngresarLetra);
        
        //Inicializar Contenedor
        contenedor = getContentPane(); //Crea el contenedor 
        contenedor.setLayout(new FlowLayout()); //Establece el administrador para el contenedor
        
        contenedor.add(panelTemaPalabra);
        contenedor.add(lbImagen);
        contenedor.add(lbOportunidades);
        contenedor.add(panelTeclado);
        contenedor.add(area);
        
        LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
	for (int i = 0; i < lista.length; i++) {
	    System.out.println(lista[i].getClassName());
	}
    }
    //Clase que maneja los eventos
     private class ManejadorDeEventos implements ActionListener, MouseListener, KeyListener{
         //Activa todos los botones
         public void enableButtons(){
            btA.setEnabled(true);btB.setEnabled(true);btC.setEnabled(true);btD.setEnabled(true);btE.setEnabled(true);btF.setEnabled(true);
            btG.setEnabled(true);btH.setEnabled(true);btI.setEnabled(true);btJ.setEnabled(true);btK.setEnabled(true);btL.setEnabled(true);
            btM.setEnabled(true);btN.setEnabled(true);btO.setEnabled(true);btP.setEnabled(true);btQ.setEnabled(true);btR.setEnabled(true);
            btS.setEnabled(true);btT.setEnabled(true);btU.setEnabled(true);btV.setEnabled(true);btW.setEnabled(true);btX.setEnabled(true);
            btY.setEnabled(true);btZ.setEnabled(true);btIngresarLetra.setEnabled(true);tfIngresarLetra.setEnabled(true);
            btA.setBackground(Color.cyan);btB.setBackground(Color.cyan);
            btC.setBackground(Color.cyan);btD.setBackground(Color.cyan);
            btE.setBackground(Color.cyan);btF.setBackground(Color.cyan);
            btG.setBackground(Color.cyan);btH.setBackground(Color.cyan);
            btI.setBackground(Color.cyan);btJ.setBackground(Color.cyan);
            btK.setBackground(Color.cyan);btL.setBackground(Color.cyan);
            btM.setBackground(Color.cyan);btN.setBackground(Color.cyan);
            btO.setBackground(Color.cyan);btP.setBackground(Color.cyan);
            btQ.setBackground(Color.cyan);btR.setBackground(Color.cyan);
            btS.setBackground(Color.cyan);btT.setBackground(Color.cyan);
            btU.setBackground(Color.cyan);btV.setBackground(Color.cyan);
            btW.setBackground(Color.cyan);btX.setBackground(Color.cyan);
            btY.setBackground(Color.cyan);btZ.setBackground(Color.cyan);
         }
         //Desactiva todos los botones
         public void disabledButtons(){
            btA.setEnabled(false);btB.setEnabled(false);btC.setEnabled(false);btD.setEnabled(false);btE.setEnabled(false);btF.setEnabled(false);
            btG.setEnabled(false);btH.setEnabled(false);btI.setEnabled(false);btJ.setEnabled(false);btK.setEnabled(false);btL.setEnabled(false);
            btM.setEnabled(false);btN.setEnabled(false);btO.setEnabled(false);btP.setEnabled(false);btQ.setEnabled(false);btR.setEnabled(false);
            btS.setEnabled(false);btT.setEnabled(false);btU.setEnabled(false);btV.setEnabled(false);btW.setEnabled(false);btX.setEnabled(false);
            btY.setEnabled(false);btZ.setEnabled(false);btIngresarLetra.setEnabled(false);tfIngresarLetra.setEnabled(false);
            
         }
         //Determina si el juego ha terminado 
         public void terminarJuego(){
             if(miJuego.Victoria()){
            JOptionPane.showMessageDialog(null, "¡Has Ganado!"
                                                + "\nTe sobraron " + miJuego.getOportunidades() + " oportunidades"
                                                + "\nUsaste " + (7-miJuego.getOportunidades()) + " oportunidades");
            this.disabledButtons();
        }
        if(miJuego.getOportunidades()==0){
            JOptionPane.showMessageDialog(null, "Derrota :("+ "\n La palabra era: " + palabraAux);
            this.disabledButtons();
        }
         }
         
//ActionListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(btIngresarLetra)){
            try{
            palabraOculta=miJuego.ingresarLetra(tfIngresarLetra.getText(), palabraAux);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
            }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                tfIngresarLetra.setText("");
                this.terminarJuego();
        }
        
        if(ae.getSource().equals(btA)){
                try{
                palabraOculta=miJuego.ingresarLetra("a", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btA.setEnabled(false);
                this.terminarJuego();
        }
        if(ae.getSource().equals(btB)){
                try{
                palabraOculta=miJuego.ingresarLetra("b", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btB.setEnabled(false);
                this.terminarJuego();
        }
        if(ae.getSource().equals(btC)){
                try{
                palabraOculta=miJuego.ingresarLetra("c", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btC.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btD)){
                try{
                palabraOculta=miJuego.ingresarLetra("d", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btD.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btE)){
                try{
                palabraOculta=miJuego.ingresarLetra("e", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btE.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btF)){
                try{
                palabraOculta=miJuego.ingresarLetra("f", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btF.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btG)){
                try{
                palabraOculta=miJuego.ingresarLetra("g", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btG.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btH)){
                try{
                palabraOculta=miJuego.ingresarLetra("h", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btH.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btI)){
                try{
                palabraOculta=miJuego.ingresarLetra("i", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btI.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btJ)){
                try{
                palabraOculta=miJuego.ingresarLetra("j", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btJ.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btK)){
                try{
                palabraOculta=miJuego.ingresarLetra("k", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btK.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btL)){
                try{
                palabraOculta=miJuego.ingresarLetra("l", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btL.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btM)){
                try{
                palabraOculta=miJuego.ingresarLetra("m", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btM.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btN)){
                try{
                palabraOculta=miJuego.ingresarLetra("n", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btN.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btO)){
                try{
                palabraOculta=miJuego.ingresarLetra("o", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btO.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btP)){
                try{
                palabraOculta=miJuego.ingresarLetra("p", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btP.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btQ)){
                try{
                palabraOculta=miJuego.ingresarLetra("q", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btQ.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btR)){
                try{
                palabraOculta=miJuego.ingresarLetra("r", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btR.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btS)){
                try{
                palabraOculta=miJuego.ingresarLetra("s", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btS.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btT)){
                try{
                palabraOculta=miJuego.ingresarLetra("t", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btT.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btU)){
                try{
                palabraOculta=miJuego.ingresarLetra("u", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btU.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btV)){
                try{
                palabraOculta=miJuego.ingresarLetra("v", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btV.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btW)){
                try{
                palabraOculta=miJuego.ingresarLetra("w", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btW.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btX)){
                try{
                palabraOculta=miJuego.ingresarLetra("x", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btX.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btY)){
                try{
                palabraOculta=miJuego.ingresarLetra("y", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btY.setEnabled(false);
                this.terminarJuego();
         }
        if(ae.getSource().equals(btZ)){
                try{
                palabraOculta=miJuego.ingresarLetra("z", palabraAux);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Debe ingresar una letra en minúsculas(a-z)");
                }
                if(!(miJuego.getPalabra().contains("-"))){
                    miJuego.setPalabra(miJuego.ocultarPalabra(miJuego.getPalabra()));
                }
                miJuego.actualizarPalabra(palabraOculta);
                areaPalabra.setText(miJuego.getPalabra());
                btZ.setEnabled(false);
                this.terminarJuego();
         }
        lbImagen.setIcon(miJuego.getImagenAhorcado());
        
        lbOportunidades.setText("Te quedan "+Integer.toString(miJuego.getOportunidades())+ " oportunidades");
        
        if(ae.getSource().equals(itemExit)){
            System.exit(0);
        }
        if(ae.getSource().equals(itemInfo)){
            JOptionPane.showMessageDialog(null, "Debe ingresar una letra, ya sea por medio del teclado virtual o fisico,\n"
                                              + "si la letra ingresada hace parte de la palabra, se revela las posiciones\n"
                                              + "en las que se encuentra. El juego se gana si se revela la palabra completa\n"
                                              + "Para ganar el juego, el jugador cuenta con 7 oportunidades"
                                              + "\n\nLos temas de las palabras son:" + miJuego.listarTemas());
        }
        if(ae.getSource().equals(itemRestart)){
            tema=miJuego.temaAzar();
            miJuego.setPalabra(miJuego.palabraAzar(tema));
            miJuego.restartOportunidades();
            lbOportunidades.setText("Te quedan "+ miJuego.getOportunidades() + " oportunidades");
            try{
                miJuego.cambiarEstadoImagen();
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la imagen del ahorcado :(\n\n Imagen no encontrada");
            }
            palabraOculta=miJuego.ocultarPalabra(miJuego.getPalabra());
            areaPalabra.setText(palabraOculta);
            palabraAux=miJuego.getPalabra();
            lbTema.setText("Tema: " + tema);
            lbImagen.setIcon(miJuego.getImagenAhorcado());
            this.enableButtons();   
        }
       }
       
    //Mouse Listener

    @Override
    public void mouseExited(MouseEvent me) {
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource().equals(btA)){
        if(!miJuego.getHeGanado()){
        btA.setBackground(Color.red);
        }
        }
        if(me.getSource().equals(btB)){
        if(!miJuego.getHeGanado()){
        btB.setBackground(Color.red);
        }
        }
        if(me.getSource().equals(btC)){
            if(!miJuego.getHeGanado()){
        btC.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btD)){
            if(!miJuego.getHeGanado()){
        btD.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btE)){
            if(!miJuego.getHeGanado()){
        btE.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btF)){
            if(!miJuego.getHeGanado()){
        btF.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btG)){
            if(!miJuego.getHeGanado()){
        btG.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btH)){
            if(!miJuego.getHeGanado()){
        btH.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btI)){
            if(!miJuego.getHeGanado()){
        btI.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btJ)){
            if(!miJuego.getHeGanado()){
        btJ.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btK)){
            if(!miJuego.getHeGanado()){
        btK.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btL)){
            if(!miJuego.getHeGanado()){
        btL.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btM)){
            if(!miJuego.getHeGanado()){
        btM.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btN)){
            if(!miJuego.getHeGanado()){
        btN.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btO)){
            if(!miJuego.getHeGanado()){
        btO.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btP)){
            if(!miJuego.getHeGanado()){
        btP.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btQ)){
            if(!miJuego.getHeGanado()){
        btQ.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btR)){
            if(!miJuego.getHeGanado()){
        btR.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btS)){
            if(!miJuego.getHeGanado()){
        btS.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btT)){
            if(!miJuego.getHeGanado()){
        btT.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btU)){
            if(!miJuego.getHeGanado()){
        btU.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btV)){
            if(!miJuego.getHeGanado()){
        btV.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btW)){
            if(!miJuego.getHeGanado()){
        btW.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btX)){
            if(!miJuego.getHeGanado()){
        btX.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btY)){
            if(!miJuego.getHeGanado()){
        btY.setBackground(Color.red);
            }
        }
        if(me.getSource().equals(btZ)){
            if(!miJuego.getHeGanado()){
        btZ.setBackground(Color.red);
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    @Override
    public void mousePressed(MouseEvent me) {
    }
    @Override
    public void mouseReleased(MouseEvent me){
    }
    
//---------------------------------------------------------------------------------------------------------------    
    //KeyListener

    @Override
    public void keyTyped(KeyEvent ke) {
        area.setText("KeyType "+ke.getKeyChar());
        if(tfIngresarLetra.getText().length()==1){
            ke.consume();
        }
    }
    @Override
    public void keyPressed(KeyEvent ke) {
    }
    @Override
    public void keyReleased(KeyEvent ke) {
    }        
}
     
    public static void main(String[] args) {
        LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
	for (int i = 0; i < lista.length; i++) {
	    System.out.println(lista[i].getClassName());
	}

      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
     } 
      catch(Exception e){
          System.out.println("Error...");
     }
        AhorcadoGUI miapp=new AhorcadoGUI();
        miapp.setSize(850, 530);
        miapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miapp.setVisible(true); 
    } 
}
