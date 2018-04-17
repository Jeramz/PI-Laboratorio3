/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeMatriculasObjectFile;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Ramírez
 */
public class ObjectFile {
    ObjectOutputStream outputCursos,outputEstudiantes;
    ObjectInputStream inputCursos,inputEstudiantes;
    
    public void openFiles(){
        try // open file
      {
         outputCursos = new ObjectOutputStream( new FileOutputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasObjectFile\\cursos.txt",true));
         outputEstudiantes = new ObjectOutputStream( new FileOutputStream( "C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasObjectFile\\estudiantes.txt" ,true));
         
         inputCursos = new ObjectInputStream(new FileInputStream( "C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasObjectFile\\cursos.txt" ) );
         inputEstudiantes = new ObjectInputStream(new FileInputStream( "C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasObjectFile\\estudiantes.txt" ) );
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error opening file." );
      } // end catch
    }
    
    public void addRecords(Universidad miuniversidad){
        Curso curso;
        Estudiante estudiante;
        int i=0;  
        
      try {
            for (i=0; i<miuniversidad.getArrayCurso().size(); i++){
                curso = (Curso)miuniversidad.getArrayCurso().get(i);
                outputCursos.writeObject(curso); 
            }
                
         } // end try
         catch ( IOException ioException )
         {
            System.err.println( "Error writing to file." );
            return;
         } // end catch
         catch ( NoSuchElementException elementException )
         {
            System.err.println( "Invalid input. Please try again." );
             // discard input so user can try again
         } // end catch
         finally{
          try {
              outputCursos.reset();
              outputCursos.flush();
          } catch (IOException ex) {
              Logger.getLogger(ObjectFile.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
    
    public void readRecords(Universidad miuniversidad){
        Curso curso;
        
        try // input the values from the file
      { 
         while ( true )
         {
            curso = ( Curso ) inputCursos.readObject();
            try{
            miuniversidad.agregarCurso(curso);
            }catch(Exception e){
                
            }
         } // end while
      } // end try
      catch ( EOFException endOfFileException )
      {
         return; // end of file was reached
      } // end catch
      catch ( ClassNotFoundException classNotFoundException )
      {
         System.err.println( "Unable to create object." );
      } // end catch
      catch ( IOException ioException )
      {
         System.err.println( "Error during reading from file." );
      }
    }
    
    public void closeFiles(){
        try // close file
      {
         if ( outputCursos != null )
            outputCursos.close();
            System.out.println("Archivo cerrado");
         if (inputCursos!=null)
             inputCursos.close();
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error closing file." );
         System.exit( 1 );
      } // end catch
   }
    
}
