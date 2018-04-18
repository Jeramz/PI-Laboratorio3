/*
 Clase GestionMatriculasGUI: Menú para el usuario
  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package GestionDeMatriculasBinaryFile;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class BinaryFile {
    FileInputStream estudiantes,Fcursos;
    FileOutputStream foestudiantes=null;
    DataOutputStream doEstudiantes;
    
    FileOutputStream foCursos=null;
    DataOutputStream doCursos;
    
    DataInputStream diestudiantes=null;
    BufferedReader brEstudiantes;
    DataInputStream diCursos=null;
    BufferedReader brCursos;
    int i;
    
    public BinaryFile(){
        try{
        
        foCursos=new FileOutputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasBinaryFile\\cursos.hhg",true);
        doCursos=new DataOutputStream(foCursos);
        foestudiantes=new FileOutputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasBinaryFile\\estudiantes.hhg",true);
        doEstudiantes=new DataOutputStream(foestudiantes);
        
        Fcursos =new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasBinaryFile\\cursos.hhg");
        estudiantes=new FileInputStream("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculasBinaryFile\\estudiantes.hhg");
        
        diestudiantes=new DataInputStream(estudiantes);
        brEstudiantes=new BufferedReader(new InputStreamReader(diestudiantes));
        diCursos=new DataInputStream(Fcursos);
        brCursos=new BufferedReader(new InputStreamReader(diCursos));
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    public boolean yaExiste(String archivo,String objeto){
        boolean respuesta=false;
        String linea;
        
        try{
            if(archivo.equals("FCursos")){
                Fcursos.getChannel().position(0);
                brCursos= new BufferedReader(new InputStreamReader(Fcursos));
                while((linea=brCursos.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                    }
                }
                
            }
            if(archivo.equals("FEstudiantes")){
                estudiantes.getChannel().position(0);
                brEstudiantes= new BufferedReader(new InputStreamReader(estudiantes));
                while((linea=brEstudiantes.readLine())!= null){
                    if((objeto.equals(linea))){
                        respuesta=true;
                        linea="";
                }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
        return respuesta;
    }
    
    public void guardarCursos(ArrayList cursos){
        try{
            
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
            if(!(this.yaExiste("FCursos",curso.getCodigo()+"/"+curso.getNombre()+"/"+curso.getCreditos()))){
                doCursos.writeBytes(curso.getCodigo()+"/"+curso.getNombre()+"/"+curso.getCreditos());
                doCursos.writeBytes("\n");
            }
            
        }
        
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
        for(int j=0;j<curso.getArrayEstudiantes().size();j++){
            Estudiante estudiante= (Estudiante) curso.getArrayEstudiantes().get(j);
            
            if(!(this.yaExiste("FEstudiantes",estudiante.getCodigo()+"/"+estudiante.getNombre()+"/"+estudiante.getPlanEstudio()+"/"+curso.getNombre()+"/"+estudiante.getNotasEstudiante()))){
                doEstudiantes.writeBytes(estudiante.getCodigo()+"/"+estudiante.getNombre()+"/"+estudiante.getPlanEstudio()+"/"+curso.getNombre()+"/"+estudiante.getNotasEstudiante());
                doEstudiantes.writeBytes("\n");
            }
        }
        }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
    public void cargarDatos(Universidad miuniversidad){
        String linea;
        String cursos[]=new String[3];
        String estudiantes[]=new String[5];
        StringTokenizer tokenizerCursos,tokenizerNotas,tokenizerEstudiantes;
        int i=0;
        try{
        while((linea=brCursos.readLine())!= null){
            tokenizerCursos=new StringTokenizer(linea,"/");
            while (tokenizerCursos.hasMoreTokens()&&i<3) {
                cursos[i]=tokenizerCursos.nextToken();
                i++;
            }
            Curso curso=new Curso();
            curso.setCodigo(cursos[0]);
            curso.setNombre(cursos[1]);
            curso.setCreditos(Integer.parseInt(cursos[2]));
            try{
                miuniversidad.agregarCurso(curso);
                i=0;
            }catch(Exception e){
                e.printStackTrace();
            System.out.println("error"+e.getMessage());
            }
            
        }
        
        while((linea=brEstudiantes.readLine())!= null){
            tokenizerEstudiantes=new StringTokenizer(linea,"/");
            while (tokenizerEstudiantes.hasMoreTokens()&&i<5) {
                estudiantes[i]=tokenizerEstudiantes.nextToken();
                i++;
            }
                Estudiante estudiante=new Estudiante();
                estudiante.setCodigo(estudiantes[0]);
                estudiante.setNombre(estudiantes[1]);
                estudiante.setPlanEstudio(estudiantes[2]);
                estudiante.setNotasEstudiante(Double.parseDouble(estudiantes[4]));
                for(int j=0;j<miuniversidad.getArrayCurso().size();j++){
                    Curso curso=(Curso) miuniversidad.getArrayCurso().get(j);
                    if(estudiantes[3].equals(curso.getNombre())){
                        miuniversidad.matricularEstudianteCurso(curso, estudiante);
                        i=0;
                    }
                }
        }
                
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
    public void closeFiles(){
        try{
        doCursos.close();
        doEstudiantes.close();
        brCursos.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
}
