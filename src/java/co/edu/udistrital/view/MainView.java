/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.view;

import java.util.Scanner;

/**
 *
 * @author Jimmy86gb
 */
public class MainView {
    private Scanner sc;
    
    public MainView(){
        sc = new Scanner(System.in);
    }
    public String readData(String msg){
        showMsg(msg);
        String option = sc.nextLine();
        return option;
    }
    public void showMsg(String msg){
        System.out.println(msg);
    }
}
