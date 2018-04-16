/*
  Clase Universidad: Agrega un curso dado, retorna un curso dado, lista los estudiantes matriculados a 
  un curso dado, matricula a un estudiante en un curso dado, asigna la nota a un estudiante en un curso 
  dado retorna el promedio de los estudiantes de un curso, retorna al mejor estudiante de un curso dado

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package GestionDeMatriculasTextFile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Universidad {
    Curso micurso=new Curso();//objeto tipo curso
    ArrayList cursos=new ArrayList();//ArrayList que almacena objetos del tipo curso
//Constructor
public Universidad(){
}
public ArrayList getArrayCurso(){
    return cursos;
}
public ArrayList getArrayestudiantes(ArrayList cursos){
    ArrayList respuesta=new ArrayList();
    for (int i=0; i< cursos.size(); i++){
        Curso curso= (Curso) cursos.get(i);
        for(int j=0;j<curso.getArrayEstudiantes().size();j++){
            
            respuesta.add(curso.getArrayEstudiantes().get(j)); 

            }
    }
    return respuesta;
}
//Agrega un curso al ArrayList
public void agregarCurso(Curso curso)throws MyException{
    boolean existe=true;
    if(curso.getCodigo().isEmpty()||Integer.toString(curso.getCreditos()).isEmpty()||curso.getNombre().isEmpty()){
        throw new MyException("Hay Campos que no se han llenado");
    }else{
        for (int i=0; i< cursos.size(); i++){
            Curso cursoA= (Curso) cursos.get(i);
            if(curso.getNombre().equals(cursoA.getNombre())){
                JOptionPane.showMessageDialog(null, "Ya existe un curso con el mismo nombre");
                existe=false;
            }
        }
        if(existe){
            cursos.add(curso);
        }
    }
    
}
//le entra un String (nombre del curso) y retorna el objeto curso si se encuentra en el ArrayList
public Curso getCurso(String nombre){
    Curso respuesta=new Curso();
    for (int i=0; i< cursos.size(); i++){
            Curso curso= (Curso) cursos.get(i);
            if(curso.getNombre().equals(nombre)){
            cursos.set(i, curso); 
            respuesta=(Curso)cursos.get(i);
            }
        }
    return respuesta;
}
//le ingresa un objeto curso, retorna un String con la lista de estudiantes que hacen parte de este
public String listarEstudiantesCurso(Curso curso){
    return curso.listarEstudiantes();
}
//le entra un objeto curso y un objeto estudiante, matricula al estudiante en el curso dado
public void matricularEstudianteCurso(Curso curso, Estudiante estudiante){
    try{
    curso.matricularEstudiante(estudiante);
    }
    catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Hay Campos que no se han llenado");
    }
}
//le entra un String (codigo), un objeto curso y una nota, le asigna una nota a un estudiante en un determinado curso
public void asignarNotaCurso(String codigo, Curso curso, double nota){
    
            curso.AsignarNota(codigo, nota);
        
}
//le entra un objeto curso, retorna el promedio de notas de el curso dado
public String promedioEstudianteCurso(Curso curso){
    return curso.promedioEstudiantes();
}
//le entra un curso, retorna un String (estudiante con la mejor nota del curso)
public String mejorEstudianteCurso(Curso curso){
    return curso.mejorEstudiante();
}
//Retorna el numero de cursos matriculados
public int numeroCursos(){
    int respuesta=0;
    for (int i=0; i< cursos.size(); i++){
        respuesta+=1;
    }
    return respuesta;
}
public class MyException extends Exception{
        public MyException(){
        }
        public MyException(String mensaje){
            super(mensaje);
        }
    }
}

