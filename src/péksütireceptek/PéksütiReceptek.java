package péksütireceptek;

import java.util.Scanner;

public class PéksütiReceptek {

    private static final Scanner sc = new Scanner(System.in);
    private static final String receptek[] = {"Kakaos csiga", "Vizes Zsemle", "Ropogos kifli", "Kuglof"};

    public static void main(String[] args) {
        foProgram();

    }

    /*Fő program*/
    private static void foProgram() {
        kiir("\t ---------------------");
        ugras("");
        kiir("\t /Peksutemeny receptek/");
        ugras("");
        kiir("\t ---------------------");
        ugras("");
        diszites();
        ugras("");
        tombMegjelenitese();
        ugras("");
        diszites();
        ugras("");
        kivalasztas();
        ugras("");
    }

    /*Hozzávalók a receptekhez*/
    private static void kakaoscsiga(int adag) {
        int liszt = 500;
        int tej = 250;
        int osszL = adag * liszt;
        int osszT = adag * tej;

//        kiir(adag + " adaghoz " + osszL + "g lisztre és " + osszT + "ml tejre lesz szüksége");
        ugras("");
        ugras("Összetevők: " + adag + " adaghoz");
        ugras(osszL + " g liszt");
        ugras(osszT + " ml tej");

    }

    private static void zsemle(int adag) {
        int liszt = 400;
        int viz = 250;
        int olaj = 50;

        int osszO = adag * olaj;
        int osszL = adag * liszt;
        int osszV = adag * viz;
//        kiir(adag + " adaghoz " + osszL + "g lisztre és " + osszV + "ml vízre és " + osszO + " ml olajra lesz szüksége");
        ugras("");
        ugras("Összetevők: " + adag + " adaghoz");
        ugras(osszL + " g liszt");
        ugras(osszV + " ml tej");
        ugras(osszO + " ml olaj");

    }

    private static void kifli(int adag) {
        int liszt = 300;
        int tej = 75;
        int viz = 60;

        int osszV = adag * viz;
        int osszL = adag * liszt;
        int osszT = adag * tej;
//        kiir(adag + " adaghoz " + osszL + "g lisztre és " + osszT + "ml tejre és " + osszV + "ml vizre lesz szüksége");
        ugras("");
        ugras("Összetevők: " + adag + " adaghoz");
        ugras(osszL + " g liszt");
        ugras(osszT + " ml tej");
        ugras(osszV + " ml viz");

    }

    private static void kuglof(int adag) {
        int liszt = 200;
        int tej = 100;
        int olaj = 100;

        int osszO = adag * olaj;
        int osszL = adag * liszt;
        int osszT = adag * tej;
//        kiir(adag + " adaghoz " + osszL + "g lisztre és " + osszT + "ml tejre es " + osszO + "ml olajra lesz szüksége");
        ugras("");
        ugras("Összetevők: " + adag + " adaghoz");
        ugras(osszL + " g liszt");
        ugras(osszT + " ml tej");
        ugras(osszO + " ml olaj");

    }

    /*Megjelenítések*/
    private static void kiir(String str) {
        System.out.printf(str);
    }

    private static void ugras(String str) {
        System.out.println(str);
    }

    private static void diszites() {
        for (int i = 0; i < 63; i++) {
            System.out.print("#");
        }

    }

    private static void tombMegjelenitese() {

        int index = 0;
        kiir("Pek receptek: ");
        while (index < receptek.length) {
            kiir(receptek[index] + ", ");
            index++;
        }
    }

    /*Kiválasztás és annak fokozása*/
    private static int adagokBekeres() {
        ugras("");
        diszites();
        ugras("");
        kiir("Kerem adja meg hogy mennyi adagot szeretne csinalni: ");
        int adag = sc.nextInt();
        while (adag < 1 || adag > 30) {
            ugras("30 feletti valamint 0 és azalatti értékbe nem lehet számólni ");
            diszites();
            ugras("");
            kiir("Kerem adjon meg egy új értéket 1 és 30 között: ");
            adag = sc.nextInt();
            ugras("");

        }
        return adag;
    }

    private static int[] kivalasztas() {
        int db = receptek.length;
        int[] szamok = new int[db];
        kiir("Kerem adjon egy szamot 0-3-ig: ");
        int keresett = sc.nextInt();
        int i = 0;
        while (szamok[i] < 0 || szamok[i] > 3) {
            ugras("Nem jó számot adott meg. ");
            kiir("Kerem adjon egy szamot 0-3-ig: ");
            keresett = sc.nextInt();

        }
        while (szamok[i] != keresett) {
            i++;
            int szam = i;
            szamok[i] += szam;

        }

        adagokMegadasa(i, szamok);

        return szamok;
    }

    private static void adagokMegadasa(int i, int[] szamok) {
        kiir("A kivalasztott peksutemeny: " + receptek[i]);
        switch (szamok[i]) {
            case 0: {
                int adag = adagokBekeres();
                kakaoscsiga(adag);
                break;
            }
            case 1: {
                int adag = adagokBekeres();
                zsemle(adag);
                break;
            }
            case 2: {
                int adag = adagokBekeres();
                kifli(adag);
                break;
            }
            case 3: {
                int adag = adagokBekeres();
                kuglof(adag);
                break;
            }
            default:
                break;
        }
    }

}
