/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDeMatriculas;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;

public class TextFile {
    File estudiantes,Fcursos,notas;
    FileWriter FWestudiantes=null;
    BufferedWriter bwEstudiantes;
    
    FileWriter FWCursos=null;
    BufferedWriter bwCursos;
    
    FileWriter FWnotas=null;
    BufferedWriter bwNotas;
    
    FileReader FRestudiantes=null;
    BufferedReader brEstudiantes;
    FileReader FRCursos=null;
    BufferedReader brCursos;
    FileReader FRnotas=null;
    BufferedReader brNotas;
    int i;
    
    public TextFile(){
        try{
        Fcursos =new File("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\cursos.txt");
        estudiantes=new File("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\estudiantes.txt");
        notas=new File("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\notas.txt");
        
        FWCursos=new FileWriter(Fcursos,true);
        bwCursos=new BufferedWriter(FWCursos);
        FWestudiantes=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\estudiantes.txt",true);
        bwEstudiantes=new BufferedWriter(FWestudiantes);
        FWnotas=new FileWriter("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\notas.txt",true);
        bwNotas=new BufferedWriter(FWnotas);
        
        FRestudiantes=new FileReader("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\estudiantes.txt");
        brEstudiantes=new BufferedReader(FRestudiantes);
        FRCursos=new FileReader("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\cursos.txt");
        brCursos=new BufferedReader(FRCursos);
        FRnotas=new FileReader("C:\\Users\\Jesús Ramírez\\Documents\\NetBeansProjects\\PI-Laboratorio3\\src\\GestionDeMatriculas\\notas.txt");
        brNotas=new BufferedReader(FRnotas);
        i=0;
        
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
            while((linea=brCursos.readLine())!= null){
                if((objeto.equals(linea))){
                    respuesta=true;
                    linea="";
                }
            }
            }
            if(archivo.equals("FEstudiantes")){
            while((linea=brEstudiantes.readLine())!= null){
                if((objeto.equals(linea))){
                    respuesta=true;
                    linea="";
                }
            }
            }
            if(archivo.equals("FNotas")){
            while((linea=brNotas.readLine())!= null){
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
    public void guardarnotas(ArrayList cursos, String nota, String codigo){
        try{
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
        for(int j=0;j<curso.getArrayEstudiantes().size();j++){
            
            Estudiante estudiante= (Estudiante) curso.getArrayEstudiantes().get(j);
            
            if(!(this.yaExiste("FEstudiantes",codigo+"/"+"/"+curso.getNombre()+"/"+nota))){
                bwEstudiantes.write(estudiante.getCodigo()+"/"+estudiante.getNombre()+"/"+estudiante.getPlanEstudio()+"/"+curso.getNombre()+"/"+estudiante.getNotasEstudiante());
                bwEstudiantes.newLine();
            }
        }
        }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
    public void guardarCursos(ArrayList cursos){
        try{
            
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
            if(!(this.yaExiste("FCursos",curso.getCodigo()+"/"+curso.getNombre()+"/"+curso.getCreditos()))){
                bwCursos.write(curso.getCodigo()+"/"+curso.getNombre()+"/"+curso.getCreditos());
                bwCursos.newLine();
            }
            
        }
        
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
        for(int j=0;j<curso.getArrayEstudiantes().size();j++){
            
            Estudiante estudiante= (Estudiante) curso.getArrayEstudiantes().get(j);
            
            if(!(this.yaExiste("FEstudiantes",estudiante.getCodigo()+"/"+estudiante.getNombre()+"/"+estudiante.getPlanEstudio()+"/"+curso.getNombre()+"/"+estudiante.getNotasEstudiante()))){
                bwEstudiantes.write(estudiante.getCodigo()+"/"+estudiante.getNombre()+"/"+estudiante.getPlanEstudio()+"/"+curso.getNombre()+"/"+estudiante.getNotasEstudiante());
                bwEstudiantes.newLine();
            }
        }
        }
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
    public void cargarDatos(){
        try{
        FRCursos=new FileReader("/home/invitado/Escritorio/laboratorio2/PI-Laboratorio2/src/GestionDeMatriculas/cursos.txt");
        BufferedReader br=new BufferedReader(FRCursos);
        for(int i=1;i<3;i++){
            br.readLine();
        }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
    public void closeFiles(){
        try{
        bwCursos.close();
        bwEstudiantes.close();
        bwEstudiantes.close();
        brCursos.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error"+e.getMessage());
        }
    }
    
}
