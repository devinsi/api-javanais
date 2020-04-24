package com.ocr.yohann;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class Main {

    private static String chaineTraduite = "";
    private static String chaineAv = "av";

     public static void traduireJavanais(String chaineFrancaise){

         String voyelle = "aàâeéèêëiïîoôùüuy";
         String consolle = " bcdfghjklmnpqrstvwxzç" ;
         for (int j=0; j<chaineFrancaise.length(); j++) {
            for(int i=0; i<voyelle.length(); i++) {
                if (    chaineFrancaise.charAt(j) == chaineFrancaise.charAt(0) && chaineFrancaise.charAt(j) == voyelle.charAt(i)){
                    chaineTraduite =  chaineTraduite + chaineAv;
                }
                if (chaineFrancaise.charAt(j) == voyelle.charAt(i) && chaineFrancaise.charAt(j) != chaineFrancaise.charAt(0)) {
                    for (int z=0; z<consolle.length(); z++) {
                        if (chaineFrancaise.charAt(j - 1) == consolle.charAt(z)) {
                            chaineTraduite =  chaineTraduite + chaineAv;
                        }
                    }
                }
            }
            chaineTraduite +=  chaineFrancaise.charAt(j);
        }
        System.out.println("************************************************************");
        System.out.println(chaineTraduite);
        System.out.println("************************************************************");
    }
    public static void traduireFrancais(String chaineJavanaise){

        if(chaineJavanaise.matches("(.*)chaineAv(.*)")  ){
            chaineTraduite = chaineJavanaise.replace(chaineAv, "");
        }if(chaineJavanaise.matches("((.*)(av){2,}(.*))")) {
            chaineTraduite = chaineJavanaise.replace("avavav", "1/-");
            chaineTraduite = chaineJavanaise.replace("avav", "1/-");
            if(chaineTraduite.matches("(.*)av(.*)")) {
                chaineTraduite = chaineTraduite.replace(chaineAv, "");
            }if(chaineTraduite.matches("(.*)1/-(.*)")) {
                chaineTraduite = chaineTraduite.replace("1/-", "av");
            }
        }
        System.out.println("************************************************************");
        System.out.println( chaineTraduite);
        System.out.println("************************************************************");
    }

    public static void main(String [] args) throws IOException, NumberFormatException {
        Scanner entreeInt = new Scanner(System.in);
        BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Souhaitez-vous faire une traduction :");
        System.out.println(" 1/ du français au javanais : entrez 1  + \"entrer\" \n 2/ du javanais au français : entrez 2 + \"entrer\"" );
        int valeur = entreeInt.nextInt();
        String chaine;
        switch (valeur){
            case 1 :
                System.out.println("veuillez entrer la phrase à traduire en javanais");
                chaine = entree.readLine();
                traduireJavanais(chaine);
                break;
            case 2 :
                System.out.println("veuillez entrer la phrase à traduire en français");
                chaine = entree.readLine();
                traduireFrancais(chaine);
                break;
        }
    }

}
