/*
 Clase ConcesionarioGUI: Menú para el usuario
  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package concesionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.UIManager.LookAndFeelInfo;
import java.lang.*;


public class Concesionario extends JFrame implements ActionListener{
    
    Carro carro=new Carro();
    ArrayList carros =new ArrayList();
    Container contenedor;
    JPanel panelInfo, panelPrecio, panelModelo;
    JTextField tfCodigo, tfPlaca, tfModelo, tfPrecio, tfMarca, tfColor, tfBuscaModelo, tfPrecioDesde, tfPrecioHasta;
    JLabel lbCodigo, lbPlaca, lbModelo, lbPrecio, lbMarca, lbColor, lbBuscaModelo, lbPrecioDesde, lbPrecioHasta,lbiconoCarro;
    JButton btGuardar, btBuscarModelo, btBuscarPrecio;
    JTextArea miArea= new JTextArea(20,50);
    //Constructor
    public Concesionario(){
        super("Concesionario A&P");
        miArea.setEditable(false);
        
        ImageIcon img=new ImageIcon(getClass().getResource("cuchau.jpeg"));
        //Inicializa los panels
        panelInfo=new JPanel();
        panelInfo.setBorder(BorderFactory.createTitledBorder("Informacion Vehiculos"));
        panelInfo.setLayout(new GridLayout(4,3));
        
        panelPrecio=new JPanel();
        panelPrecio.setBorder(BorderFactory.createTitledBorder("Busqueda por precio"));
        panelPrecio.setLayout(new GridLayout(1,4));
        
        panelModelo=new JPanel();
        panelModelo.setBorder(BorderFactory.createTitledBorder("Busqueda por modelo"));
        panelModelo.setLayout(new GridLayout(1,3));
        
        //Inicializa los TextFields
        tfCodigo=new JTextField(10);
        tfPlaca=new JTextField(6);
        tfModelo=new JTextField(10);
        tfPrecio=new JTextField(15);
        tfMarca=new JTextField(10);
        tfColor=new JTextField(10);
        tfBuscaModelo=new JTextField(20);
        tfPrecioDesde=new JTextField(15);
        tfPrecioHasta=new JTextField(15);
        //Inicializa los labels
        lbCodigo=new JLabel("Codigo:");
        lbPlaca=new JLabel("Placa:");
        lbModelo=new JLabel("Modelo:");
        lbPrecio=new JLabel("Precio:");
        lbMarca=new JLabel("Marca:");
        lbColor=new JLabel("Color:");
        lbBuscaModelo=new JLabel("Modelo:");
        lbPrecioDesde=new JLabel("Desde:");
        lbPrecioHasta=new JLabel("Hasta:");
        lbiconoCarro=new JLabel(img);
        //Inicializa Buttons
        btGuardar=new JButton("Guardar");
        btBuscarModelo=new JButton("Buscar");
        btBuscarPrecio=new JButton("Buscar");
        //Agrega ActionListener a los botones
        btGuardar.addActionListener(this);
        btBuscarModelo.addActionListener(this);
        btBuscarPrecio.addActionListener(this);
        //Agrega a los panels
        panelInfo.add(lbCodigo);
        panelInfo.add(tfCodigo);
        panelInfo.add(lbModelo);
        panelInfo.add(tfModelo);
        panelInfo.add(lbMarca);
        panelInfo.add(tfMarca);
        panelInfo.add(lbColor);
        panelInfo.add(tfColor);
        panelInfo.add(lbPlaca);
        panelInfo.add(tfPlaca);
        panelInfo.add(lbPrecio);
        panelInfo.add(tfPrecio);
        panelInfo.add(btGuardar);
        
        panelModelo.add(lbBuscaModelo);
        panelModelo.add(tfBuscaModelo);
        panelModelo.add(btBuscarModelo);
        
        panelPrecio.add(lbPrecioDesde);
        panelPrecio.add(tfPrecioDesde);
        panelPrecio.add(lbPrecioHasta);
        panelPrecio.add(tfPrecioHasta);
        panelPrecio.add(btBuscarPrecio);
        
        contenedor = getContentPane(); //Crea el contenedor 
        contenedor.setLayout(new FlowLayout()); //Establece el administrador para el contenedor
        
        contenedor.add(panelInfo);
        contenedor.add(panelModelo);
        contenedor.add(panelPrecio);
        contenedor.add(lbiconoCarro);
        contenedor.add(miArea);
        
        LookAndFeelInfo[] lista = UIManager.getInstalledLookAndFeels();
	for (int i = 0; i < lista.length; i++) {
	    System.out.println(lista[i].getClassName());
	}
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btGuardar){
            try{
            String codigo=tfCodigo.getText();
            String modelo=tfModelo.getText();
            String marca=tfMarca.getText();
            String color=tfColor.getText();
            String placa=tfPlaca.getText();
            for(int i=0;i<carros.size();i++){
                Carro miCarro=(Carro)carros.get(i);
                if(placa.equals(miCarro.getPlaca())){
                    JOptionPane.showMessageDialog(null, "El numero de placa ingresado no es valido");
                    break;
                }
            }
            
            double precio=Double.parseDouble(tfPrecio.getText());
            if(codigo.equals("") || modelo.equals("") || marca.equals("") || color.equals("") || placa.equals("")){
                JOptionPane.showMessageDialog(null, "no se han llenado todos los campos");
            }else{
       
            Carro nuevoCarro=new Carro();
            nuevoCarro.setColor(color);
            nuevoCarro.setMarca(marca);
            nuevoCarro.setModelo(modelo);
            nuevoCarro.setPlaca(placa);
            nuevoCarro.setPrecio(precio);
       
            carros.add(nuevoCarro);
            }
            }
            
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "El tipo de dato ingresado en precio no es valido");
            }
       
            tfCodigo.setText("");
            tfModelo.setText("");
            tfMarca.setText("");
            tfColor.setText("");
            tfPlaca.setText("");
            tfPrecio.setText("");
        }
        
        if(e.getSource()==btBuscarModelo){
            miArea.setText("");
            String modelo=tfBuscaModelo.getText();
            String respuesta="";
            for(int i=0;i<carros.size();i++){
                try{
                    Carro miCarro=(Carro)carros.get(i);
                    if(miCarro.getModelo().equals(modelo)){
                        respuesta+=miCarro.getModelo() + " " + miCarro.getMarca()+ " " + miCarro.getPlaca() + " " + miCarro.getColor() +" "+ miCarro.getPrecio() + "\n";
                    }
                }
                catch(ArrayIndexOutOfBoundsException arrayError){
                JOptionPane.showMessageDialog(null, "Ocurrió un error");
                }
                
            }
            if(respuesta==""){
                JOptionPane.showMessageDialog(null, "No se encuentra el modelo del auto");
            }
            tfBuscaModelo.setText("");
            miArea.append(respuesta);
        }
        
        if(e.getSource()==btBuscarPrecio){
            miArea.setText("");
            try{
            double precioDesde=Double.parseDouble(tfPrecioDesde.getText());
            double precioHasta=Double.parseDouble(tfPrecioHasta.getText());
            
            String respuesta="";
            
            for(int i=0;i<carros.size();i++){
                Carro miCarro=(Carro)carros.get(i);
                if(miCarro.getPrecio()>=precioDesde && miCarro.getPrecio()<=precioHasta){
                    respuesta+=miCarro.getModelo() + " " + miCarro.getMarca()+ " " + miCarro.getPlaca() + " " + miCarro.getColor() + " " + miCarro.getPrecio() + "\n";
                }
            }
            if(respuesta==""){
                respuesta="No se encuentran autos en ese rango de precio";
            }
            miArea.append(respuesta);
        }
            catch(NumberFormatException ErrorNumero){
                tfPrecioDesde.setText("");
                tfPrecioHasta.setText("");
                JOptionPane.showMessageDialog(null, "Debe ingresar numeros (1-9)");
            }
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
        Concesionario miconcesionario= new Concesionario();
        miconcesionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miconcesionario.setSize(1050,700);
        miconcesionario.setVisible(true);
    }
    
}
