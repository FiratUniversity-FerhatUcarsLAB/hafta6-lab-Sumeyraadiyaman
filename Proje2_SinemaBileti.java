//AD-SOYAD: SÜMEYRA ADIYAMAN
//ÖĞRENCİ NO: 250541012
//TESLİM TARİHİ: 25.11.2025
//PROJE ADI: SİNEMA BİLETİ FİYATLANDIRMA SİSTEMİ



import java.util.Scanner;

public class Proje2_SinemaBileti {
    public static boolean isWeekend(int gun){
        //Pazartesi:1 , Salı:2 , Çarşamba:3 , Perşembe:4 , Cuma:5 , Cumartesi:6 , Pazar:7 olarak adlandırılacak

        //Hafta sonu olup olmadığının kontrolünü yapıyoruz
        return  gun ==6 || gun ==7;
    }

    //Matine kontrolü yapıyoruz (12.00 öncesi olup olmadığını kontrol ediyoruz)
    public static boolean isMatinee(int saat){
        return saat < 12;
    }

    //Fiyat Hesaplama işlemlerini yapıyoruz
    public static double calculateBasePrice(int gun,int saat){
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if(weekend && matinee){
            return 55;
        }else if(weekend && !matinee){
            return 85;
        }else if(!weekend && matinee){
            return 45;
        }else{
            return 65;
        }

    }

    //İndirim oranı hesaplama işlem yapıyoruz
    public static double calculateDiscount(int yas,int meslek,int gun){
        //Önce yaş indirimlerini hesaplıyoruz
        double indirim = 0.0;
        if (yas<12){
            return indirim = 0.25;
        }else if (yas >= 65){
            return indirim =  0.30;
        }
        //Meslek indirimleri hesaplıyoruz
        //Öğrenci:1 , Öğretmen:2 , Diğer:3

        switch (meslek) {
            case 1://Öğrenci
                if (gun >= 1 && gun <= 4) {
                    return indirim = 0.20;
                } else return indirim = 0.15;

            case 2://Öğretmen
                if (gun == 3) {
                    return indirim = 0.35;
                } else return indirim = 0.0;

            case 3://Diğer
        } return indirim;

        }

    //Film formatı ekstraları hesaplanır
    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 1:
                return 0.0; //2D
            case 2:
                return 25; // 3D
            case 3:
                return 35; // IMAX
            case 4:
                return 50; // 4DX
            default:
                return 0;
        }
    }

    //Son fiyat hesaplama
        public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru){
            double temelFiyat = calculateBasePrice(gun , saat);
            double indirimOrani = calculateDiscount(yas, meslek, gun);
            double ekstraFiyatlar = getFormatExtra(filmTuru);
            double indirimliFiyat = temelFiyat *(1 - indirimOrani);
            return indirimliFiyat + ekstraFiyatlar;
        }

        //Bilet bilgisi yazdırma
        public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru){
            double sonFiyat = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);
            double temelFiyat = calculateBasePrice(gun , saat);
            double indirimOrani = calculateDiscount(yas, meslek, gun);
            double ekstraFiyatlar = getFormatExtra(filmTuru);
            double indirimliFiyat = temelFiyat * (1 - indirimOrani);

            String gunIsimlendirme = "";
            switch (gun) {
                case 1: gunIsimlendirme = "Pazartesi"; break;
                case 2: gunIsimlendirme = "Salı"; break;
                case 3: gunIsimlendirme = "Çarşamba"; break;
                case 4: gunIsimlendirme = "Perşembe"; break;
                case 5: gunIsimlendirme = "Cuma"; break;
                case 6: gunIsimlendirme = "Cumartesi"; break;
                case 7: gunIsimlendirme = "Pazar"; break;

            }

            String meslekIsimlendirme = "";
            switch (meslek) {
                case 1: meslekIsimlendirme = "Öğrenci"; break;
                case 2: meslekIsimlendirme = "Öğretmen"; break;
                case 3: meslekIsimlendirme = "Diğer"; break;
            }

            String filmIsimlendirme = "";
            switch (filmTuru) {
            case 1: filmIsimlendirme = "2D"; break;
            case 2: filmIsimlendirme = "3D"; break;
            case 3: filmIsimlendirme = "IMAX"; break;
            case 4: filmIsimlendirme = "4DX"; break;
            }

            System.out.println("------------ BİLET BİLGİSİ ------------");
            System.out.println("Gün: " + gunIsimlendirme );
            System.out.println("Saat: " + saat);
            System.out.println("Yaş: " + yas);
            System.out.println("Meslek: " + meslekIsimlendirme );
            System.out.println("Film Türü: " + filmIsimlendirme + " + " + ekstraFiyatlar +"TL");
            System.out.println("Temel Fiyat: " + temelFiyat + "TL");
            System.out.println("İndirim Oranı: %" + (indirimOrani * 100) + " = " + indirimliFiyat + " TL");
            System.out.println("Toplam Fiyat: " + sonFiyat + "TL");
        }

        public static void main (String[] args){
            Scanner scan = new Scanner(System.in);

            System.out.println("Gün Seçiniz (Pzrts=1 , Salı=2 , Çrşmb=3 , Prşmb=4 , Cuma=5 , Ctesi=6 , Pazar=7): ");
            int gun = scan.nextInt();

            System.out.println("Saat Giriniz(00 - 23): ");
            int saat = scan.nextInt();

            System.out.println("Yaşınızı Giriniz: ");
            int yas = scan.nextInt();

            System.out.println("Meslek Seçiniz(1=Öğrenci , 2=Öğretmen , 3= Diğer ): ");
            int meslek = scan.nextInt();

            System.out.println("Film Türü Seçiniz(1=2D , 2=3D , 3=IMAX , 4=4DX ): ");

            int filmTuru = scan.nextInt();

            generateTicketInfo(gun, saat, yas, meslek, filmTuru);


            scan.close();
        }

     }


