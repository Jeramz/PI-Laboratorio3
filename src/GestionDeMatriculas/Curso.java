/*
  Clase Curso: le asigna valores al codigo, nombre y numero de  creditos de
  un estudiante y del mismo modo, los retorna. Matricula a un estudiante en el curso
  le asigna la nota a un estudiante, lista los estudiantes matriculados al curso
  retorna el promedio de notas de un curso, imprime al mejor estudiante del curso.

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package GestionDeMatriculas;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Curso {
    
    String codigo;
    String nombre;
    int numeroCreditos;
    Estudiante miEstudiante = new Estudiante();//objeto tipo estudiante
    ArrayList estudiantesCurso = new ArrayList();
    
    //Constructor
    public Curso(){
    }
    public ArrayList getArrayEstudiantes(){
        return estudiantesCurso;
    }
    //Retorna codigo curso
    public String getCodigo(){
        return codigo;
    }
    //asigna un valor al codigo del curso
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    //Retorna el numero del curso
    public String getNombre(){
        return nombre;
    }
    //asigna un valor al nombre del curso
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    //Retorna el numero de creditos
    public int getCreditos(){
        return numeroCreditos;
    }
    //asigna un valor al numero de creditos
    public void setCreditos(int creditos){
        this.numeroCreditos=creditos;
    }
    //le ingresa un objeto estudiante, agrega a un estudiante a un curso dado
    public void matricularEstudiante(Estudiante estudiante)throws MyException1{
        boolean existe=true;
        if(estudiante.getCodigo().isEmpty()||Double.toString(estudiante.getNotasEstudiante()).isEmpty()||estudiante.getNombre().isEmpty()){
        throw new MyException1("Hay Campos que no se han llenado");
    }else{
        for (int i=0; i< estudiantesCurso.size(); i++){
            Estudiante cursoA= (Estudiante) estudiantesCurso.get(i);
            if(estudiante.getCodigo().equals(cursoA.getCodigo())){
                javax.swing.JOptionPane.showMessageDialog(null, "                         EROR"
                                                              + "\n\nEl estudiante ya está matriculado en este curso");
                existe=false;
            }
        }
        if(existe){
            estudiantesCurso.add(estudiante);
        }
    }
    }
    //le ingresa un String (codigo del estudiante) y una nota, le asigna la nota a un estudiante dado
    public void AsignarNota(String codigoEstudiante, double nota){
        if(codigoEstudiante.isEmpty()||Double.toString(nota).isEmpty()){
                JOptionPane.showMessageDialog(null, "Hay campos que no se han llenado");
            }
        else{
            for(int i=0;i<estudiantesCurso.size();i++){
                Estudiante estudiante= (Estudiante) estudiantesCurso.get(i);
            
                if(estudiante.getCodigo().equals(codigoEstudiante)){
                
                    estudiante.setNotasEstudiante(nota);  
                    estudiantesCurso.set(i, estudiante);
                    JOptionPane.showMessageDialog(null, "La nota ha sido registrada con exito");
                    }
                }
            }
    }
    //retorna un String que lista los estudiantes matriculados a un curso
    public String listarEstudiantes(){
        String respuesta="";
        if(estudiantesCurso.isEmpty()){
            respuesta="No hay estudiantes matriculados";
        }else{
            for(int i=0; i<estudiantesCurso.size();i++){
                Estudiante estudiante=(Estudiante) estudiantesCurso.get(i);
                respuesta+=estudiante.getCodigo() + " " + 
                           estudiante.getNombre() + " " +
                           estudiante.getPlanEstudio() + " " + 
                           estudiante.getNotasEstudiante() + "\n";
            }
        }
        return respuesta;
    }
    //retorna el promedio de notas de los estudiantes de un curso dado
    public String promedioEstudiantes(){
        double nota=0;
        String respuesta="";
        for(int i=0;i<estudiantesCurso.size();i++){
            Estudiante estudiante=(Estudiante) estudiantesCurso.get(i);
            nota+=estudiante.getNotasEstudiante() / estudiantesCurso.size();
        }
        if(nota==0){
            respuesta="No hay estudiantes matriculados en este curso";
        }else{
            respuesta="El promedio de los estudiantes en el curso es de: " +Double.toString(nota);
        }
        return respuesta;
    }
    //retorna un String que imprime al estudiante con mejor nota
    public String mejorEstudiante(){
        String respuesta="";
        double mejorNota=0;
        for(int i=0;i<estudiantesCurso.size();i++){
            Estudiante estudiante=(Estudiante) estudiantesCurso.get(i);
            if(estudiante.getNotasEstudiante() > mejorNota){
                mejorNota=estudiante.getNotasEstudiante();
                respuesta="El mejor estudiante fue \n" + estudiante.getCodigo() + " " + estudiante.getNombre() + " con una nota de: " + mejorNota;
            }
        }
        if(respuesta.equals("")){
            respuesta="No hay estudiantes matriculados en este curso";
        }
        return respuesta;
    }
    public class MyException1 extends Exception{
        public MyException1(){
        }
        public MyException1(String mensaje){
            super(mensaje);
        }
    }
}

