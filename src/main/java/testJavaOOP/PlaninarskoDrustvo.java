package testJavaOOP;

import java.util.ArrayList;
import java.util.Collections;

public class PlaninarskoDrustvo {

    private ArrayList<Planinar> planinari;


    public PlaninarskoDrustvo(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    public ArrayList<Planinar> getPlaninari() {
        return planinari;
    }

    public void setPlaninari(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    public void izbaciPlaninara(int id) {
        for (Planinar p : planinari) {
            if (p.getId() == id) {
                planinari.remove(p);
            }
        }
    }

    public int najuspesnijiPlaninar() {

        int najuspesniji = 0;
        double max = Double.MIN_VALUE;

        for (Planinar p : planinari) {
            if (p.totalM() > max) {
                max = p.totalM();
                najuspesniji = p.getId();
            }
            if (planinari.size() == 0) {
                najuspesniji = 0;
            }
        }
        return najuspesniji;
    }

    public double prosecnaClanarinaPlaninara() {

        double sum = 0.;
        for (Planinar p : planinari) {
            sum += p.clanarina();
        }
        return sum / planinari.size();
    }

    public boolean popniSeNaPlaninu(Planina planina) {

        boolean greenLight = false;

        boolean groupSize = false;

        for (Planinar a : planinari) {
            if (planinari.size() > 0) {
                groupSize = true;
            }
        }

        boolean alpinista = false;

        for (Planinar b : planinari) {
                if (b instanceof Alpinista && ((Alpinista) b).getGodineIskustva() > 5) {
                    alpinista = true;
                }
            }

        boolean uspon = false;
            int i = 0;

        for (Planinar c : planinari) {
                if (c.uspesanUspon(planina) == true) {
                    i++;
                }
        }

        if (i > ((planinari.size() / 3) * 2)) {
                uspon = true;
        }

        if (groupSize == true && alpinista == true && uspon == true) {
                greenLight = true;
        }

        return greenLight;

        }

        public void sortPlaninariPoClanarini(){
        Collections.reverse(planinari);
        }


    public static void main(String[] args) {

        ArrayList<Planinar> p1 = new ArrayList<>();
        ArrayList<Planina> planine = new ArrayList<>();
        ArrayList<Planina> planine2 = new ArrayList<>();
        ArrayList<Planina> planine3 = new ArrayList<>();


        Planina prva = new Planina("Bobotov kuk", 2856);
        Planina druga = new Planina("Midzor", 2650);
        Planina treca = new Planina("Djeravica", 2960);
        Planina cetvrta = new Planina("Triglav", 3260);

        Alpinista a1 = new Alpinista(12, "John", "Doe",planine, 4000., 6 );

        System.out.println(a1.uspesanUspon(prva));
        System.out.println(a1.getPlanine());
        System.out.println(a1.uspesanUspon(druga));
        System.out.println(a1.getPlanine());
        System.out.println(a1.uspesanUspon(treca));
        System.out.println(a1.getPlanine());
        System.out.println(a1.uspesanUspon(cetvrta));
        System.out.println(a1.getPlanine());

        Planinar b1 = new Rekreativac(7, "Jane", "Doe", planine2, 3200., 10.3);

        System.out.println(b1.uspesanUspon(prva));
        System.out.println(b1.getPlanine());
        System.out.println(b1.uspesanUspon(druga));
        System.out.println(b1.getPlanine());
        System.out.println(b1.uspesanUspon(treca));
        System.out.println(b1.getPlanine());
        System.out.println(b1.uspesanUspon(cetvrta));
        System.out.println(b1.getPlanine());

        Planinar c1 = new Rekreativac(4, "Bob", "Doe", planine3, 3500., 7.6);

        System.out.println(c1.uspesanUspon(prva));
        System.out.println(c1.getPlanine());
        System.out.println(c1.uspesanUspon(druga));
        System.out.println(c1.getPlanine());
        System.out.println(c1.uspesanUspon(treca));
        System.out.println(c1.getPlanine());
        System.out.println(c1.uspesanUspon(cetvrta));
        System.out.println(c1.getPlanine());

        p1.add(a1);
        p1.add(b1);
        p1.add(c1);

        PlaninarskoDrustvo planinarskoDrustvo = new PlaninarskoDrustvo(p1);

        System.out.println(planinarskoDrustvo.najuspesnijiPlaninar());
        System.out.println(planinarskoDrustvo.getPlaninari());
        System.out.println(planinarskoDrustvo.prosecnaClanarinaPlaninara());
        System.out.println(planinarskoDrustvo.popniSeNaPlaninu(prva));
        System.out.println(a1.clanarina());
        System.out.println(b1.clanarina());

    }


    }

