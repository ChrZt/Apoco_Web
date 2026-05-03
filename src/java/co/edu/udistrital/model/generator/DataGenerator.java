/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.model.generator;

import co.edu.udistrital.model.structures.SimpleList;
import co.edu.udistrital.model.entities.*;
import java.util.Random;

/**
 *
 * @author Jimmy86gb
 */
public class DataGenerator {
    
    public static SimpleList<Politician> generatePoliticians(double size){
        SimpleList<Politician> listP = new SimpleList<>();
        Random ran = new Random();
        double minMoney = 1000;
        double maxMoney = 5000000;

        for(int i = 0; i < size; i++){
            String name = "Politico Corrupto No." + (i+1);
            double ranMoney = minMoney +(maxMoney - minMoney) * ran.nextDouble();
            ranMoney = Math.round(ranMoney * 100) / 100;
            listP.add(new Politician(name, ranMoney));
        }
        return listP;
    } 
}
