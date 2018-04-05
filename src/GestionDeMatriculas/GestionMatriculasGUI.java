/*
 Clase GestionMatriculasGUI: Menú para el usuario
  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package GestionDeMatriculas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.UIManager.LookAndFeelInfo;
import java.lang.*;

public class GestionMatriculasGUI extends JFrame implements ActionListener{
    
    Container contenedor;
    JTabbedPane tabbedPane;
    JPanel panelCursos,panelAgregarCursos, panelEstudiante,panelNotasEstudiante, panelListarPromedioMejor,panelEstudiantes;
    JButton btAgregarCurso, btAgregarEstudiante, btMatricularEstudiante,btAgregarNotaEstudiante,btListarEstudiante,btPromedioCurso,btMejorEstudiante,btGuardarDatos;
    JLabel lbCodigoCurso,lbNombreCurso,lbCreditosCurso,lbCodigoEstudiante,lbNombreEstudiante,lbPlanEstudio,lbCodigoAgregarNota,lbNombreCursoNota,lbNotaEstudiante,lbSeleccionarCurso,lbSeleccionarCursoA;
    JTextField tfCodigoCurso,tfNombreCurso,tfCreditosCurso,tfCodigoEstudiante,tfNombreEstudiante,tfPlanEstudio,tfCodigoAgregarNota,tfNombreCursoNota,tfNotaEstudiante;
    JComboBox comboMatricularCursos,comboCursoA,comboCursoNota;
    JList listaEstudiantes;
    
    TextFile guardarDatos=new TextFile();
    Universidad miuniversidad=new Universidad();
    String listaCursos[];

    public GestionMatriculasGUI(){
        
        //Inicializar panels
        panelCursos=new JPanel();
        panelCursos.setLayout(new FlowLayout());
        
        panelAgregarCursos=new JPanel();
        panelAgregarCursos.setBorder(BorderFactory.createTitledBorder("Agregar Curso"));
        panelAgregarCursos.setLayout(new GridLayout(2,4));
        
        panelListarPromedioMejor=new JPanel();
        panelListarPromedioMejor.setBorder(BorderFactory.createTitledBorder("Escoja un curso y seleccione una acción"));
        panelListarPromedioMejor.setLayout(new GridLayout(2,3));
        
        panelEstudiante=new JPanel();
        panelEstudiante.setBorder(BorderFactory.createTitledBorder("Agregar Estudiante"));
        panelEstudiante.setLayout(new GridLayout(5,2));
        
        panelNotasEstudiante=new JPanel();
        panelNotasEstudiante.setBorder(BorderFactory.createTitledBorder("Agregar Nota Estudiante"));
        panelNotasEstudiante.setLayout(new GridLayout(4,2));
        
        panelEstudiantes=new JPanel();
        panelEstudiantes.setLayout(new FlowLayout());
        
        //TabbetPane
        JPanel topPanel = new JPanel();
	topPanel.setLayout( new FlowLayout() );
	getContentPane().add( topPanel );
	tabbedPane = new JTabbedPane();
	tabbedPane.addTab( "Cursos", panelCursos);
	tabbedPane.addTab( "Estudiante", panelEstudiantes);
	topPanel.add( tabbedPane, BorderLayout.CENTER );
        
        //Inicializar Botones
        btGuardarDatos=new JButton("Guardar Datos");
        btAgregarCurso=new JButton("Agregar");
        btMatricularEstudiante=new JButton("Matricular");
        btAgregarNotaEstudiante=new JButton("Agregar Nota");
        btListarEstudiante=new JButton("ListarEstudiantes");
        btPromedioCurso=new JButton("Promedio del Curso");
        btMejorEstudiante=new JButton("Mejor estudiante");
        
        btGuardarDatos.addActionListener(this);
        btAgregarCurso.addActionListener(this);
        btMatricularEstudiante.addActionListener(this);
        btAgregarNotaEstudiante.addActionListener(this);
        btListarEstudiante.addActionListener(this);
        btPromedioCurso.addActionListener(this);
        btMejorEstudiante.addActionListener(this);
        
        //Inicializar TextFields
        tfCodigoCurso=new JTextField(10);
        tfNombreCurso=new JTextField(10);
        tfCreditosCurso=new JTextField(10);
        tfCodigoEstudiante=new JTextField(10);
        tfNombreEstudiante=new JTextField(10);
        tfPlanEstudio=new JTextField(10);
        tfCodigoAgregarNota=new JTextField(10);
        tfNombreCursoNota=new JTextField(10);
        tfNotaEstudiante=new JTextField(10);
        
        //Inicializar Labels
        lbCodigoCurso=new JLabel("Codigo Curso");
        lbNombreCurso=new JLabel("Nombre Curso");
        lbCreditosCurso=new JLabel("CreditoCurso");
        lbCodigoEstudiante=new JLabel("Codigo Estudiante");
        lbNombreEstudiante=new JLabel("Nombre Estudiante");
        lbPlanEstudio=new JLabel("Plan Estudio");
        lbCodigoAgregarNota=new JLabel("Codigo Estudiante");
        lbNombreCursoNota=new JLabel("Seleccionar Curso");
        lbNotaEstudiante=new JLabel("Nota estudiante");
        lbSeleccionarCurso=new JLabel("Seleccionar un Curso");
        lbSeleccionarCursoA=new JLabel("Seleccionar un Curso");
        
        //Inicializar Combo
        listaCursos=new String[0];
        comboMatricularCursos=new JComboBox(listaCursos);
        comboCursoA=new JComboBox(listaCursos);
        comboCursoNota=new JComboBox(listaCursos);
     
        //Agregar a los Panels
        panelAgregarCursos.add(lbCodigoCurso);
        panelAgregarCursos.add(tfCodigoCurso);
        panelAgregarCursos.add(lbNombreCurso);
        panelAgregarCursos.add(tfNombreCurso);
        panelAgregarCursos.add(lbCreditosCurso);
        panelAgregarCursos.add(tfCreditosCurso);
        panelAgregarCursos.add(btAgregarCurso);
        panelAgregarCursos.add(btGuardarDatos);
        panelListarPromedioMejor.add(btListarEstudiante);
        panelListarPromedioMejor.add(btPromedioCurso);
        panelListarPromedioMejor.add(btMejorEstudiante);
        panelListarPromedioMejor.add(lbSeleccionarCursoA);
        panelListarPromedioMejor.add(comboCursoA);
        panelCursos.add(panelAgregarCursos);
        panelCursos.add(panelListarPromedioMejor);
        
        panelEstudiante.add(lbCodigoEstudiante);
        panelEstudiante.add(tfCodigoEstudiante);
        panelEstudiante.add(lbNombreEstudiante);
        panelEstudiante.add(tfNombreEstudiante);
        panelEstudiante.add(lbPlanEstudio);
        panelEstudiante.add(tfPlanEstudio);
        panelEstudiante.add(lbSeleccionarCurso);
        panelEstudiante.add(comboMatricularCursos);
        panelEstudiante.add(btAgregarNotaEstudiante);
        panelEstudiante.add(btMatricularEstudiante);
        
        panelNotasEstudiante.add(lbCodigoAgregarNota);
        panelNotasEstudiante.add(tfCodigoAgregarNota);
        panelNotasEstudiante.add(lbNombreCursoNota);
        panelNotasEstudiante.add(comboCursoNota);
        panelNotasEstudiante.add(lbNotaEstudiante);
        panelNotasEstudiante.add(tfNotaEstudiante);
        panelNotasEstudiante.add(btAgregarNotaEstudiante);
        
        panelEstudiantes.add(panelEstudiante);
        panelEstudiantes.add(panelNotasEstudiante);
       
        
        contenedor = getContentPane(); //Crea el contenedor 
        contenedor.setLayout(new FlowLayout()); //Establece el administrador para el contenedor
        contenedor.add(tabbedPane);
        
        
        
    }
    //Actualiza los elementos en el comboBox
    public void setcombo(String[] lista,JComboBox combo ){
        lista=new String[miuniversidad.numeroCursos()];
        for(int i=0;i<lista.length;i++){
            Curso curso=(Curso) miuniversidad.cursos.get(i);
            if(!(curso.getNombre().equals(combo.getItemAt(i)))){
            combo.addItem(curso.getNombre());
            miuniversidad.cursos.set(i, curso);
            }
        }
        
    }
    
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btGuardarDatos){
            guardarDatos.guardarCursos(miuniversidad.getArrayCurso(),miuniversidad.getArrayestudiantes(miuniversidad.getArrayCurso()));
            
        }
        if(e.getSource()==btAgregarCurso){
            try{
            String codigoCurso=tfCodigoCurso.getText();
            String nombreCurso=tfNombreCurso.getText();
            String CreditosCurso=tfCreditosCurso.getText();
            
            Curso curso=new Curso();
            curso.setCodigo(codigoCurso);
            curso.setNombre(nombreCurso);
            curso.setCreditos(Integer.parseInt(CreditosCurso));
       
            miuniversidad.agregarCurso(curso);
            this.setcombo(listaCursos, comboMatricularCursos);
            this.setcombo(listaCursos, comboCursoA);
            this.setcombo(listaCursos, comboCursoNota);
            
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "El valor ingresado en creditos es invalido, deben ser numeros");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Hay Campos que no se han llenado");
            }
            tfCodigoCurso.setText("");
            tfNombreCurso.setText("");
            tfCreditosCurso.setText("");
        }
        
        if(e.getSource()==btListarEstudiante){
            try{
            JOptionPane.showMessageDialog(null, miuniversidad.listarEstudiantesCurso(miuniversidad.getCurso(comboCursoA.getItemAt(comboCursoA.getSelectedIndex()).toString())));
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun curso");
            }
        }
        
        if(e.getSource()==btMatricularEstudiante){
            try{
            String codigo=tfCodigoEstudiante.getText();
            String nombre=tfNombreEstudiante.getText();
            String planEstudios=tfPlanEstudio.getText();
            
            Estudiante estudiante=new Estudiante();
            estudiante.setCodigo(codigo);
            estudiante.setNombre(nombre);
            estudiante.setPlanEstudio(planEstudios);
                    
            miuniversidad.matricularEstudianteCurso(miuniversidad.getCurso(comboMatricularCursos.getItemAt(comboMatricularCursos.getSelectedIndex()).toString()), estudiante);
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado un curso a matricular");
            }
            tfCodigoEstudiante.setText("");
            tfNombreEstudiante.setText("");
            tfPlanEstudio.setText("");
        }
        
        if(e.getSource()==btAgregarNotaEstudiante){
            try{
            String codigo=tfCodigoAgregarNota.getText();
            double nota=Double.parseDouble(tfNotaEstudiante.getText());
            
            miuniversidad.asignarNotaCurso(codigo,miuniversidad.getCurso(comboCursoA.getItemAt(comboCursoA.getSelectedIndex()).toString()) , nota);
            
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero en nota");
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun curso");
            }
            tfCodigoAgregarNota.setText("");
            tfNotaEstudiante.setText("");
        }
        
        if(e.getSource()==btPromedioCurso){
            try{
            JOptionPane.showMessageDialog(null,miuniversidad.promedioEstudianteCurso(miuniversidad.getCurso(comboCursoA.getItemAt(comboCursoA.getSelectedIndex()).toString())));
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun curso");
            }
        }
        
        if(e.getSource()==btMejorEstudiante){
            try{
            JOptionPane.showMessageDialog(null,miuniversidad.mejorEstudianteCurso(miuniversidad.getCurso(comboCursoA.getItemAt(comboCursoA.getSelectedIndex()).toString())));
            }
            catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun curso");
            }
        }
    }
    public static void main(String[] args) {
        GestionMatriculasGUI p=new GestionMatriculasGUI();
        p.setVisible(true);
        p.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        p.setSize(1000, 300);
    }
    
}
