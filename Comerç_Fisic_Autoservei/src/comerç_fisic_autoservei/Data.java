/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comerç_fisic_autoservei;

/**
 *
 * @author lluis_000
 */
public class Data {
    private int any;
    private int mes;
    private int dia;
    private int hora;
    private int minuts;
    private int segons;
    
    /**
     * pre: cap numero es negatiu, dia <=31, hora <=23, minuts & segons <=60 i tot >= 0
     * @param any
     * @param mes
     * @param dia
     * @param hora
     * @param minuts
     * @param segons
     */
    public Data(int any, int mes, int dia, int hora, int minuts, int segons){
        this.any=any;
        this.mes=mes;
        this.dia=dia;
        this.hora=hora;
        this.minuts=minuts;
        this.segons=segons;
    }
    
    public void restar(Data d){
        this.any-=d.any;
        this.mes-=d.mes;
        this.hora-=d.hora;
        this.minuts-=d.minuts;
        this.segons-=d.segons;
        
        if(this.mes<0){this.mes+=12; this.any--;}
        else if(this.dia<0){
            this.mes--;
            if(mes%2!=0){//si el mes es imparell llavors te 31 dies
                this.dia+=31;
            }
            else if(mes%2==0){
                if(mes==2){
                    if((any/100)%4==0){this.dia+=29;}//any bisiest
                    else{this.dia+=28;}
                }  
                else{this.dia+=30;}
            }
        }
        else if(this.hora<0){this.hora+=24; this.dia--;}
        else if(this.minuts<0){this.minuts+=60;this.hora--;}
        else if(this.segons<0){this.segons+=60;this.minuts--;}
    }
    
    /**
     *
     * @param d
     */
    public void sumar(Data d){
        this.any+=d.any;
        this.mes+=d.mes;
        this.hora+=d.hora;
        this.minuts+=d.minuts;
        this.segons+=d.segons; 
        
        if(this.mes>12){this.mes-=12; this.any++;}
        else if(this.dia>28){
            if(mes%2==0){
                if(mes==2){
                    if((any/100)%4==0 && this.dia>28){this.dia-=29;this.mes++;}//any bisiest
                    else{this.dia-=28; this.mes++;}
                }
                else{
                    if(this.dia>31){this.dia-=30;this.mes++;}  
                }
            }
            else{//si el mes es imparell llavors te 31 dies
                if(this.dia>31){this.dia-=31;this.mes++;}
            }
        }
        else if(this.hora>23){this.hora-=24; this.dia++;}
        else if(this.minuts>59){this.minuts-=60;this.hora++;}
        else if(this.segons>59){this.segons-=60;this.minuts++;}
        
    }
    
}
