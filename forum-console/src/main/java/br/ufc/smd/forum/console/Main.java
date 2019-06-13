/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console;

import br.ufc.smd.forum.console.database.UserTable;
import java.util.Scanner;

/**
 *
 * @author davitabosa
 */
public class Main {
    public static void main(String[] args){
        User r = new User("ad", "o", "ii", false);
        Scanner s = new Scanner(System.in);
        printMenuPrincipal();
        int selected = s.nextInt();
        switch(selected){
            case 1:
                break;
            case 2:
                println("CADASTRO");
                println("Digite seu login:");
                String login = s.nextLine();
                println("Digite sua senha:");
                String senha = s.nextLine();
                
                User u = new User("", login, senha, false);
                UserTable userTable = new UserTable();
                userTable.create(u);
                println("Cadastrado com sucesso.");
                break;
            case 3:
                break;
        }
        println("FIM DA APLICACAO");
        
    }
    
    public static void printMenuPrincipal(){
        println("FORUM");
        println("[1] Login");
        println("[2] Cadastro");
        println("[3] Sair");
    }
    
    public static void println(Object txt){
        System.out.println(txt.toString());
    }
}
