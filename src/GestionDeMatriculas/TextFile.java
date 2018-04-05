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
    FileWriter FWestudiantes=null;
    FileWriter FWCursos=null;
    FileWriter FWnotas=null;
    
    FileReader FRestudiantes=null;
    FileReader FRCursos=null;
    FileReader FRnotas=null;
    
    public TextFile(){
    }
    public void guardarCursos(ArrayList cursos, ArrayList estudiantes){
        try{
        FWCursos=new FileWriter("/home/invitado/Escritorio/laboratorio2/PI-Laboratorio2/src/GestionDeMatriculas/cursos.txt",true);
        BufferedWriter bw=new BufferedWriter(FWCursos);
        bw.write("Codigo/nombre/creditos");
        bw.newLine();
        bw.newLine();
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
            
            bw.write(curso.getCodigo()+"/"+curso.getNombre()+"/"+curso.getCreditos());
            bw.newLine();
        }
        bw.close();
        
        FWestudiantes=new FileWriter("/home/invitado/Escritorio/laboratorio2/PI-Laboratorio2/src/GestionDeMatriculas/estudiantes.txt",true);
        BufferedWriter bw1=new BufferedWriter(FWestudiantes);
        bw1.write("Codigo/nombre/plan");
        bw1.newLine();
        bw1.newLine();
        for(int i=0;i<estudiantes.size();i++){
            Estudiante estudiante= (Estudiante) estudiantes.get(i);
            
            bw1.write(estudiante.getCodigo()+"/"+estudiante.getNombre()+"/"+estudiante.getPlanEstudio());
            bw1.newLine();
        }
        bw1.close();
        /*
        FWnotas=new FileWriter("/home/invitado/Escritorio/laboratorio2/PI-Laboratorio2/src/GestionDeMatriculas/notas.txt",true);
        BufferedWriter bw2=new BufferedWriter(FWnotas);
        bw1.write("Codigo/nombre/creditos");
        bw1.newLine();
        bw1.newLine();
        for(int i=0;i<cursos.size();i++){
            Curso curso= (Curso) cursos.get(i);
            
            bw.write(curso.getCodigo()+"/"+curso.getNombre()+"/"+curso.getCreditos());
            bw.newLine();
        }
        bw.close();
        */
        
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
    
}
