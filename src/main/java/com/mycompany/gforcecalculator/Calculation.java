/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gforcecalculator;

/**
 *
 * @author ruzte
 */
//işlemleri obje yaptım daha kolay olsun diye
public class Calculation {

    private int value = 0;  
    private final String name;
    
    public Calculation(String name){
        this.name = name; 
    }
    public int getValue(){
        return value; 
    }
    public void setValue(int newValue){
        value = newValue;
       
    }
    public String getName(){
        return name; 
    }
    
    
}
