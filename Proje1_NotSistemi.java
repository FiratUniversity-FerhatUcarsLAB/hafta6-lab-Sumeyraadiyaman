//AD-SOYAD: SÜMEYRA ADIYAMAN
//ÖĞRENCİ NO: 250541012
//TESLİM TARİHİ: 14.11.2025


package Proje1_NotSistemi;

import java.util.Scanner;
public class Proje1_NotSistemi {


    public static double calculateAverage(int vize_notu ,int final_notu ,int odev_notu){
        double ortalama = vize_notu * 0.3 + final_notu * 0.4 + odev_notu * 0.3;

        return ortalama;
    }
    public static boolean isPassingGrade(double ortalama){

        if(ortalama >= 50){
            return true;
        }else{
            return false;
        }
    }

    public static char getLetterGrade(double ortalama){
        char harf_notu;
        if(ortalama >= 90 && ortalama <= 100){
            harf_notu = 'A';
        }else if (ortalama >= 80 && ortalama < 90) {
            harf_notu = 'B';
        }else if (ortalama >= 70 && ortalama < 80) {
            harf_notu = 'C';
        }else if (ortalama >= 60 && ortalama < 70) {
            harf_notu = 'D';
        } else{//60'dan küçük ise
            harf_notu = 'F';
        }
        return harf_notu;
    }

    public static boolean isHonorList(double ortalama , int vize_notu , int final_notu , int odev_notu) {
        if (ortalama >= 85 && vize_notu >= 70 && final_notu >= 70 && odev_notu >= 70) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasRetakeRight(double ortalama){
        if(ortalama>=40 && ortalama < 50){
            return true;
        }//tekrar if içine girmediği için else yazmamıza gerek yok
        return false;

    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Vize notunu giriniz: ");
        int vize_notu , final_notu , odev_notu;
        vize_notu = input.nextInt();

        System.out.print("Final notunu giriniz: ");
        final_notu = input.nextInt();

        System.out.print("Ödev notunu giriniz: ");
        odev_notu = input.nextInt();


        System.out.println("=== ÖĞRENCİ NOT RAPORU ===");
        System.out.println("Vize notunuz: " + vize_notu);
        System.out.println("Final notunuz: " + final_notu);
        System.out.println("Ödev notunuz: " + odev_notu);
        System.out.println("-------------------------------");

        double ortalama = calculateAverage(vize_notu,final_notu,odev_notu);

        System.out.println("Ortalamanız: " + ortalama);
        System.out.println("Harf notunuz: " + getLetterGrade(ortalama));
        if(isPassingGrade(ortalama)){
            System.out.println("Durum: GEÇTİ ");
        }else{
            System.out.println("Durum: KALDI ");
        }

        System.out.println("Onur Listesi: " + (isHonorList(
                ortalama , vize_notu , final_notu , odev_notu) ? "EVET" : "HAYIR"));

        System.out.println("Bütünleme: " + (hasRetakeRight(ortalama) ? "VAR" : "YOK"));

        input.close();


    }

}
