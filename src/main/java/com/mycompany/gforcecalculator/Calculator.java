/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gforcecalculator;

/**
 *
 * @author ruzte
 */
public class Calculator {
    private double a, r, v, w;
    private double g    = 9.80665; /* gravity */
    private char[] prio = {'r', 'w', 'v', 'a'};

    public enum r_unit {
        R_UNIT_METERS,
        R_UNIT_FEET,
        R_UNIT_KM,
        R_UNIT_MILES
    }

    private double[] r_factor = { 1.0, 0.3048, 1000, 0.3048 * 5280.0 };

    public enum w_unit {
        W_UNIT_RAD, /* rad/sec */
        W_UNIT_DEG, /* deg/sec */
        W_UNIT_RPM  /* rot/min */
    }

    private double[] w_factor = { 1.0, Math.PI / 180.0, Math.PI / 30.0 };

    public enum v_unit {
        V_UNIT_M,   /* meters/sec */
        V_UNIT_FT,  /* feet/sec */
        V_UNIT_KPH, /* km/sec */
        V_UNIT_MPH  /* miles/hour */
    }

    private double[] v_factor = { 1.0, 0.3048, 1000.0 / 3600.0, 0.3048 * 5280.0 / 3600.0 };

    public enum a_unit {
        A_UNIT_M,  /* meters/second^2 */
        A_UNIT_FT, /* feet/second^2 */
        A_UNIT_G   /* gravity */
    }

    /* defaults */

    private r_unit cur_r_unit = r_unit.R_UNIT_METERS;
    private w_unit cur_w_unit = w_unit.W_UNIT_RAD;
    private v_unit cur_v_unit = v_unit.V_UNIT_M;
    private a_unit cur_a_unit = a_unit.A_UNIT_G;

    private double[] a_factor = { 1.0, 0.3048, g };

    private static final Calculator instance = new Calculator();

    private Calculator() {
        a = g;
        w = 1.0;

        calc("rv");

        set_leds();
    }

    public void set_unit(r_unit unit) {
        cur_r_unit = unit;
    }

    public void set_unit(w_unit unit) {
        cur_w_unit = unit;
    }

    public void set_unit(v_unit unit) {
        cur_v_unit = unit;
    }

    public void set_unit(a_unit unit) {
        cur_a_unit = unit;
    }

    private void calc(String what) {
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

    private void adjust_prio(char p) {
        int i;

        for (i = 0;i < 3;i++)
            if (prio[i] == p) break;

        for (int j = i;j < 3;j++)
            prio[j] = prio[j+1];

        prio[3] = p;
    }

    public void set_leds() {
        /*
         * TODO: implement this
         */
    }

    public void set(char c, double value) {
        switch(c) {
            case 'a': {
                a = value * a_factor[cur_a_unit.ordinal()];
                break;
            }
            case 'r': {
                r = value * r_factor[cur_r_unit.ordinal()];
                break;
            }
            case 'v': {
                v = value * v_factor[cur_v_unit.ordinal()];
                break;
            }
            case 'w': {
                w = value * w_factor[cur_w_unit.ordinal()];
                break;
            }
            default: throw new IllegalArgumentException(String.format("\"c\" (%c) does not match with {'a','r','v','w'}", c));
        }
        adjust_prio(c);
        calc(String.valueOf(prio[0]) + prio[1]);
        set_leds();
    }

    public double get(char c) {
        switch(c) {
            case 'a': return a / a_factor[cur_a_unit.ordinal()];
            case 'r': return r / r_factor[cur_r_unit.ordinal()];
            case 'v': return v / v_factor[cur_v_unit.ordinal()];
            case 'w': return w / w_factor[cur_w_unit.ordinal()];
            default: throw new IllegalArgumentException(String.format("\"c\" (%c) does not match with {'a','r','v','w'}", c));
        }
    }

    public static Calculator getInstance() {
        return instance;
    }
}
