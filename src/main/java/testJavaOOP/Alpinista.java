package testJavaOOP;

import java.util.ArrayList;

public class Alpinista extends Planinar{

    public Alpinista(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, int godineIskustva) {
        super(id, ime, prezime, planine, maxUspon);
        this.godineIskustva = godineIskustva;
    }

    private int godineIskustva;

    public Alpinista(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon) {
        super(id, ime, prezime, planine, maxUspon);
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }

    @Override
    public boolean uspesanUspon(Planina p) {
        if(this.getMaxUspon() >= p.getVisina()){
            getPlanine().add(p);
            return true;
        }
        return false;
    }

    @Override
    public double clanarina() {

        int count = 0;
        for(Planina p  : getPlanine()){
            if(p.getVisina() > 2000){
                count++;
            }
        }
        return 1500 - (50.0 * count);
    }


}
