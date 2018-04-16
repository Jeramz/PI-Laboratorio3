/*
  Clase Estudiante: le asigna valores al codigo, nombre, plan de estudio y calificación de 
  un estudiante y del mismo modo, los retorna.

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package GestionDeMatriculasBinaryFile;

public class Estudiante {
    
    String codigo;
    String nombre;
    String planEstudio;
    double calificacion;
    //Constructor
    public Estudiante(){
    }
    //le asigna un valor a codigo
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    //Retorna el codigo del estudiante
    public String getCodigo(){
        return codigo;
    }
    //le asigna un valor al nombre del estudiante
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    //Retorna el nombre del estudiante
    public String getNombre(){
        return nombre;
    }
    //le asigna un valor al plan de estudio
    public void setPlanEstudio(String planEstudio){
        this.planEstudio=planEstudio;
    }
    //Retorna el plan de estudio
    public String getPlanEstudio(){
        return planEstudio;
    }
    //le asina un valor a la nota del estudiante
    public void setNotasEstudiante(double nota){
        calificacion=nota;
    }
    //Retorna la nota del estudiante
    public double getNotasEstudiante(){
        return calificacion;
    }
}
