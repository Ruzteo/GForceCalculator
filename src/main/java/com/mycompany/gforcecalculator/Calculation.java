/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gforcecalculator;

/**
 *
 * @author ruzte
 */
public class Calculation {
    private int priority;
    private int value = 0;  
    private String name;
    
    public Calculation(int priority, String name){
        this.priority = priority;
        this.name = name; 
    }
    public int getValue(){
        return value; 
    }
    public void setValue(int newValue){
        priority = newValue;
       
    }
    public String getName(){
        return name; 
    }
    
    
}
