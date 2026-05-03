package co.edu.udistrital.model.entities;

/**
 * Clase que representa a un politico corrupto con su dinero a robar
 */
public class Politician {

   private String name;
   private double  moneyToSteal;
   
    /**
     * Constructor para crear un politico nuevo
     * @param name el nombre del politico
     * @param moneyToSteal la cantidad de dinero que esta dispuesto a robar
     */
    public Politician(String name, double moneyToSteal){
       this.name = name;
       this.moneyToSteal = moneyToSteal;
   }

    /**
     * Cambia el nombre del politico
     * @param name el nuevo nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Cambia la cantidad de dinero a robar
     * @param moneyToSteal el nuevo monto de dinero
     */
    public void setMoneyToSteal(double moneyToSteal) {
        this.moneyToSteal = moneyToSteal;
    }
    
    /**
     * Devuelve el nombre del politico
     * @return el nombre en texto
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve la cantidad de dinero a robar del politico
     * @return el dinero a robar
     */
    public double getMoneyToSteal() {
        return moneyToSteal;
    }
   
}