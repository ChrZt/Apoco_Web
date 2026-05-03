/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model.entities;

/**
 *
 * @author Jimmy86gb
 */
public class Politician {

   private String name;
   private double  moneyToSteal;
   
   public Politician(String name, double moneyToSteal){
       this.name = name;
       this.moneyToSteal = moneyToSteal;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoneyToSteal(double moneyToSteal) {
        this.moneyToSteal = moneyToSteal;
    }
    
    public String getName() {
        return name;
    }

    public double getMoneyToSteal() {
        return moneyToSteal;
    }
   
}
