package co.edu.udistrital.model.entities;

/**
 * Clase que representa el hampon con su nombre, edad y dinero a robar
 *
 * @author fdp24
 */
public class Thug {

    private String name;
    private int age;
    private double stolenMoney;

    /**
     * Contructor de la clase Thug
     *
     * @param name Nombre del hampon
     * @param age Edad del hampon
     * @param stolenMoney Dinero robado por el hampon
     */
    public Thug(String name, int age, double stolenMoney) {
        this.name = name;
        this.age = age;
        this.stolenMoney = stolenMoney;
    }

    /**
     * Getter del nombre
     *
     * @return el nombre del hampon
     */
    public String getName() {
        return name;
    }

    /**
     * Setter del nombre
     *
     * @param name el nuevo nombre del hampon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * El getter del la edad
     *
     * @return la edad del hampon
     */
    public int getAge() {
        return age;
    }

    /**
     * El setter de la edad
     *
     * @param age la nueva edad del hampon
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * El getter del dinero robado
     *
     * @return el dinero robado por el hampon
     */
    public double getStolenMoney() {
        return stolenMoney;
    }

    /**
     * El setter del dinero robado
     *
     * @param stolenMoney el nuevo monto robado por el hampon
     */
    public void setStolenMoney(double stolenMoney) {
        this.stolenMoney = stolenMoney;
    }

}
