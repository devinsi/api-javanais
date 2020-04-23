package com.ocr.yohann;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class Main {


     public static void traduireJavanais(String chaine){
         String chaineATraduire = chaine;
         String chaineTraduite = "";
         String voyelle = "aàâeéèêëiïîoôùüuy";
         String consolle = " bcdfghjklmnpqrstvwxzç" ;
        for (int j=0; j<chaineATraduire.length(); j++) {
            for(int i=0; i<voyelle.length(); i++) {
                if (    chaineATraduire.charAt(j) == chaineATraduire.charAt(0) && chaineATraduire.charAt(j) == voyelle.charAt(i)){
                    chaineTraduite =  chaineTraduite + "av";
                }
                if (chaineATraduire.charAt(j) == voyelle.charAt(i) && chaineATraduire.charAt(j) != chaineATraduire.charAt(0)) {
                    for (int z = 0; z < consolle.length(); z++) {
                        if (chaineATraduire.charAt(j - 1) == consolle.charAt(z)) {
                            chaineTraduite =  chaineTraduite + "av";
                        }
                    }
                }
            }
            chaineTraduite +=  chaineATraduire.charAt(j);
        }
        System.out.println("************************************************************");
        System.out.println(chaineTraduite);
        System.out.println("************************************************************");
    }
    public static void traduireFrancais(String chaine){
        String chaineFrancais = chaine;
        String chaineTrad = "";

        if(chaineFrancais.matches("(.*)av(.*)")  ){
            chaineTrad = chaineFrancais.replace("av", "");
        }if(chaineFrancais.matches("((.*)(av){2,}(.*))")) {
            chaineTrad = chaineFrancais.replace("avavav", "1/-");
            chaineTrad = chaineFrancais.replace("avav", "1/-");
            if(chaineTrad.matches("(.*)av(.*)")) {
                chaineTrad = chaineTrad.replace("av", "");
            }if(chaineTrad.matches("(.*)1(.*)")) {
                chaineTrad = chaineTrad.replace("1/-", "av");
            }
        }
        System.out.println("************************************************************");
        System.out.println( chaineTrad);
        System.out.println("************************************************************");
    }

    public static void main(String [] args) throws IOException, NumberFormatException {
        Scanner entreeInt = new Scanner(System.in);
        BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Souhaitez-vous faire une traduction :");
        System.out.println(" 1/ du français au javanais : entrez 1  + \"enter\" \n 2/ du javanais au français : entrez 2 + \"enter\"" );
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
