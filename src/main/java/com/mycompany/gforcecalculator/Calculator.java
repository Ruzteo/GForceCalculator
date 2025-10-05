/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gforcecalculator;

import java.util.ArrayList;

/**
 *
 * @author ruzte
 */
public class Calculator {
    private static double a, r, v, w;
    private static ArrayList<Character> prio = new ArrayList<>();

    private static void calc(String what) {
        /*
         * TODO: r_text and w_text implementation, aswell as set_spec
         */
        switch(what) {
            case "rw":
            case "wr": {
                r = v * v / a;
                w = a / v;
                break;
            }
            case "rv":
            case "vr": {
                r = a / (w * w);
                v = a / w;
                break;
            }
            case "ar":
            case "ra": {
                a = v * w;
                r = v / w;
                break;
            }
            case "vw":
            case "wv": {
                v = Math.sqrt(a * r);
                w = Math.sqrt(a / r);
                break;
            }
            case "aw":
            case "wa": {
                a = v * v / r;
                w = v / r;
                break;
            }
            case "av":
            case "va": {
                a = w * w * r;
                v = w * r;
                break;
            }
           default: throw new IllegalArgumentException("\"what\" is not correct");
        }
    }

    private static void adjust_prio(char p) {
        int i;

        for (i = 0;i < 3;i++)
            if (prio.get(i) == p) break;

        for (int j = i;j < 3;j++)
            prio.set(j, prio.get(j+1));

        prio.set(3, p);
    }

    public static double calculate(double radious, double Avelocity, double TVelocity, double Cacceleration){
        return 1;
    }
}
