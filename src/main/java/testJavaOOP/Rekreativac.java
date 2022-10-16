package testJavaOOP;

import java.util.ArrayList;

public class Rekreativac extends Planinar{

    private double tezinaOpreme;

    public Rekreativac(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, double tezinaOpreme) {
        super(id, ime, prezime, planine, maxUspon);
        this.tezinaOpreme = tezinaOpreme;
    }

    public double getTezinaOpreme() {
        return tezinaOpreme;
    }

    public void setTezinaOpreme(double tezinaOpreme) {
        this.tezinaOpreme = tezinaOpreme;
    }

    @Override
    public boolean uspesanUspon(Planina p) {

        int maxNerf = ((int)tezinaOpreme) * 50;

        if(p.getVisina() <= (getMaxUspon() - maxNerf)){
            getPlanine().add(p);
            return true;
        }
        return false;
    }

    @Override
    public double clanarina() {
        return 1000.0 - (20.0 * getPlanine().size());
    }

}
