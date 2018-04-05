/*
  Clase Carro: Crea un objeto de tipo carro, le asigna valores a Placa, modelo, marca
  color y precio. De la misma forma, También retorna dichos valores

  Autor: Jesus Ramirez-1731388  Samuel Velasco-1731295 Andrés Felipe-1730534
  email: jesus.zuluaga@correounivalle.edu.co - samuel.velasco@correounivalle.edu.co - andres.lopez@correounivalle.edu.co
  fecha: 21 Marzo 2018
 */
package concesionario;

public class Carro {
    
    String placa,modelo,marca,color;
    double precio;
    
    public Carro(){
    }
    //Retorna el numero de placa
    public String getPlaca(){
        return placa;
    }
    //asigna un valor a placa
    public void setPlaca(String placa){
        this.placa=placa;
    }
    //Retorna el modelo del carro
    public String getModelo(){
        return modelo;
    }
    //asigna un valor al modelo del carro
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    //Retorna la marca del carro
    public String getMarca(){
        return marca;
    }
    //asigna un valor a la marca del carro
    public void setMarca(String marca){
        this.marca=marca;
    }
    //Retorna el color del carro
    public String getColor(){
        return color;
    }
    //Asigna un valor a color del carro
    public void setColor(String color){
        this.color=color;
    }
    //Retorna el precio del carro
    public double getPrecio(){
        return precio;
    }
    //Asigna un valor al precio del carro
    public void setPrecio(double precio){
        this.precio=precio;
    }
    
}

