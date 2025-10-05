/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gforcecalculator;

import javax.swing.JTextField;

/**
 *
 * @author ruzte
 */
//işlemleri obje yaptım daha kolay olsun diye
public class Calculation {

    private JTextField value;
    private final String name;

    public Calculation(String name){
        this.name = name;
    }
    public void setValue(JTextField v){
        value = v;
    }
    public JTextField getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
}
