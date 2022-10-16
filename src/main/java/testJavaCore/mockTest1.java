package testJavaCore;
/**
 * MOCK TEST JAVA 1
 * Stavljamo test na lokaciju: https://drive.google.com/drive/folders/1rLfz7gEpb9I0d42yq21Ogpq8J4LQG-xp
 * Vreme trajanja: 1h
 * Ime klase neka vase ime i prezime.
 */
import java.util.Arrays;

public class mockTest1 {

        /**
         * Implementirati metodu koja vraca motorno vozilo koje odgovara kategoriji.
         * @param kategorija vozacka kategorija
         * A -> "motor"
         * a -> "motor"
         * b -> "automobil"
         * c -> "kamion"
         * d -> "autobus"
         * e -> "kamionSaPrikolicom"
         * @return motorno vozilo koje odgovara kategoriji
         */
        public static String vozackaKategorija(String kategorija) {


            if(kategorija.equalsIgnoreCase("A")){
                kategorija = "motor";
            } else if (kategorija.equals("b")) {
                kategorija = "automobil";
            } else if (kategorija.equals("c")) {
                kategorija = "kamion";
            }else if (kategorija.equals("d")) {
                kategorija = "autobus";
            } else if (kategorija.equals("e")) {
                kategorija = "kamionSaPrikolicom";
            }

            return kategorija;
        }

        /**
         * Implementirati metodu tako da racuna sumu elemenata stepenovih na dati index u nizu.
         * @param niz ulazni parametar niz
         * {1, 2, 3, 4, 5} -> 1^0 + 2^1 + 3^2 + 4^3 + 5^4
         * {} -> 0
         * {999} -> 999^0
         * @return suma
         */
       public static int sumaStepenaIndexaNiza(int[] niz) {

            int[] sqrNiz = new int[niz.length];

            for (int i = 0,  j = 0, k=0; i < niz.length; i++, j++, k++){
                sqrNiz[k] = (int) Math.pow(niz[i], j);
            }

            int sumNiz = 0;

            for (int i = 0, j = i + 1; i <sqrNiz.length; i++, j++){
                sumNiz = sqrNiz[i] + sqrNiz[j];
                i++;
            }


            return sumNiz;
        }

        /**
         * Implementirati metodu koja trazi razliku niza a-b, odnosno, metodu koja vraca
         * sve elemente koji se nalaze u prvom skupu, a ne nalaze se u skupu b.
         * @param a niz a
         * @param b niz b
         * ({1, 2, 3}, {2, 3, 4, 10}) -> {1}
         * ({7, 5, -1}, {9, 5, 6, 3, 2}) -> {-1, 7}
         * ({1, 2, 3}, {}) -> {1, 2, 3}
         *
         * @return razlika nizova a-b
         */
        public static int[] razlikaNizova(int[] a, int[] b) {


            int[] c = new int[a.length];
            int k = 0;

            for(int i = 0, j = 0; i < a.length; i++, j++){
                if(a[i] != b[j]){
                    c[k] = a[i];
                    k++;
                }
            }

            int[] cCut =  new int[k];
            for (int i = 0; i < k; i++) {
                cCut[i] = c[i];
            }

            return cCut;
        }


        public static void main(String[] args) {
            // Testovi idu ovde. Pozeljno je dodati i sopstvene pozive sa drugim parametrima.
            System.out.println(vozackaKategorija("A"));
            System.out.println(sumaStepenaIndexaNiza(new int[]{1, 2, 3, 4, 5}));
            System.out.println(Arrays.toString(razlikaNizova(new int[]{7, 5, -1}, new int[]{9, 5, 6, 3, 2})));




        }
    }

