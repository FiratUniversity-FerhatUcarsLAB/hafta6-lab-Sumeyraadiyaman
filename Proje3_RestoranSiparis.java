//AD-SOYAD: SÜMEYRA ADIYAMAN
//ÖĞRENCİ NO: 250541012
//TESLİM TARİHİ: 26.11.2025
//PROJE ADI: AKILLI RESTORAN SİPARİŞ SİSTEMİ

import java.util.Scanner;

public class Proje3_RestoranSiparis {

    static double getMainDishPrice(int secim){
        switch(secim){
            case 1: return 85;  // Izgara Tavuk
            case 2: return 120; // Adana Kebap
            case 3: return 110; // Levrek
            case 4: return 65;  // Mantı
            default: return 0;
        }
    }

    static double getAppetizerPrice(int secim){
        switch(secim){
            case 1: return 25; // Çorba
            case 2: return 45; // Humus
            case 3: return 55; // Sigara Böreği
            default: return 0;
        }
    }

    static double getDrinkPrice(int secim){
        switch(secim){
            case 1: return 15; // Kola
            case 2: return 12; // Ayran
            case 3: return 35; // Meyve Suyu
            case 4: return 25; // Limonata
            default: return 0;
        }
    }

    static double getDessertPrice(int secim){
        switch(secim){
            case 1: return 65; // Künefe
            case 2: return 55; // Baklava
            case 3: return 35; // Sütlaç
            default: return 0;
        }
    }

    static boolean isComboOrder(boolean anaVar, boolean icecekVar, boolean tatliVar){
        return (anaVar && icecekVar && tatliVar);
    }

    static boolean isHappyHour(int saat){
        return (saat >= 14 && saat <= 17);
    }

    static boolean haftaIci(int gun){
        return (gun >= 1 && gun <= 5);
    }

    static String gunIsmi(int gun){
        return switch(gun){
            case 1 -> "Pazartesi";
            case 2 -> "Salı";
            case 3 -> "Çarşamba";
            case 4 -> "Perşembe";
            case 5 -> "Cuma";
            case 6 -> "Cumartesi";
            case 7 -> "Pazar";
            default -> "";
        };
    }

    static double calculateServiceTip(double tutar){
        return tutar * 0.10;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--------------------- MENÜ ---------------------");
        System.out.println();
        System.out.println("ANA YEMEKLER (1=Izgara Tavuk ,2=Adana Kebap ,3=Levrek ,4=Mantı)");
        System.out.println("BAŞLANGIÇLAR (1=Çorba ,2=Humus ,3=Sigara Böreği)");
        System.out.println("İÇECEKLER (1=Kola ,2=Ayran ,3=Meyve Suyu ,4=Limonata)");
        System.out.println("TATLILAR (1=Künefe ,2=Baklava ,3=Sütlaç)");
        System.out.println();
        System.out.println("------------------------------------------------");

        // Kullanıcıdan Seçimlerini Al
        System.out.print("ANA YEMEK SEÇİNİZ (0 = istemiyorum): ");
        int anaYemek = input.nextInt();

        System.out.print("BAŞLANGIÇ SEÇİNİZ (0 = istemiyorum): ");
        int baslangic = input.nextInt();

        System.out.print("İÇECEK SEÇİNİZ (0 = istemiyorum): ");
        int icecek = input.nextInt();

        System.out.print("TATLI SEÇİNİZ (0 = istemiyorum): ");
        int tatli = input.nextInt();

        double anaFiyat = getMainDishPrice(anaYemek);
        double baslangicFiyat = getAppetizerPrice(baslangic);
        double icecekFiyat = getDrinkPrice(icecek);
        double tatliFiyat = getDessertPrice(tatli);

        double toplam = anaFiyat + baslangicFiyat + icecekFiyat + tatliFiyat;

        boolean combo = isComboOrder(anaYemek > 0, icecek > 0, tatli > 0);

        System.out.print("Saat giriniz (0-23): ");
        int saat = input.nextInt();

        System.out.print("Öğrenci misiniz? (evet/hayır): ");
        String ogrenciCevap = input.next();
        boolean ogrenci = ogrenciCevap.equalsIgnoreCase("evet");

        System.out.print("Günü giriniz (Pzrts=1 , Salı=2 , Çrşmb=3 , Prşmb=4 , Cuma=5 , Ctesi=6 , Pazar=7): ");
        int gun = input.nextInt();

        //Ayrı ayrı indirimleri hesapla
        double comboIndirim = combo ? toplam * 0.15 : 0;
        double toplamSonraCombo = toplam - comboIndirim;

        double fazlaTutarIndirim = (toplam > 200) ? toplamSonraCombo * 0.10 : 0;
        double toplamSonraFazla = toplamSonraCombo - fazlaTutarIndirim;

        double happyHourIndirim = isHappyHour(saat) ? icecekFiyat * 0.20 : 0;
        double toplamSonraHappy = toplamSonraFazla - happyHourIndirim;

        double ogrenciIndirim = (ogrenci && haftaIci(gun)) ? toplamSonraHappy * 0.10 : 0;
        double indirimliTutar = toplamSonraHappy - ogrenciIndirim;

        double bahsis = calculateServiceTip(indirimliTutar);

        // Seçilen ürünleri yazdır
        String anaYemekSatir = switch(anaYemek){
            case 1 -> "Izgara Tavuk(85 TL)";
            case 2 -> "Adana(120 TL)";
            case 3 -> "Levrek(110 TL)";
            case 4 -> "Mantı(65 TL)";
            default -> "";
        };
        String baslangicSatir = switch(baslangic){
            case 1 -> "Çorba(25 TL)";
            case 2 -> "Humus(45 TL)";
            case 3 -> "Sigara Böreği(55 TL)";
            default -> "";
        };
        String icecekSatir = switch(icecek){
            case 1 -> "Kola(15 TL)";
            case 2 -> "Ayran(12 TL)";
            case 3 -> "Meyve Suyu(35 TL)";
            case 4 -> "Limonata(25 TL)";
            default -> "";
        };
        String tatliSatir = switch(tatli){
            case 1 -> "Künefe(65 TL)";
            case 2 -> "Baklava(55 TL)";
            case 3 -> "Sütlaç(35 TL)";
            default -> "";
        };


        System.out.println();
        System.out.println(
                (anaYemekSatir.isEmpty()?"":anaYemekSatir+"+") +
                        (baslangicSatir.isEmpty()?"":baslangicSatir+"+") +
                        (icecekSatir.isEmpty()?"":icecekSatir+"+") +
                        (tatliSatir.isEmpty()?"":tatliSatir)
        );

        System.out.printf("Saat=%d, %s, %s%n", saat, ogrenci?"Öğrenci":"Normal", gunIsmi(gun));
        System.out.printf("Ara toplam: %.2fTL%n", toplam);
        if(combo) System.out.printf("Combo -15%%: -%.2fTL%n", comboIndirim);
        if(toplam > 200) System.out.printf("200₺ üzeri -10%%: -%.2fTL%n", fazlaTutarIndirim);
        if(isHappyHour(saat)) System.out.printf("Happy Hour (içecek) -20%%: -%.2fTL%n", happyHourIndirim);
        if(ogrenci && haftaIci(gun)) System.out.printf("Öğrenci -10%%: -%.2fTL%n", ogrenciIndirim);
        System.out.printf("Toplam: %.2fTL%n", indirimliTutar);
        System.out.printf("Bahşiş önerisi: %.2fTL%n", bahsis);

        input.close();
    }
}

