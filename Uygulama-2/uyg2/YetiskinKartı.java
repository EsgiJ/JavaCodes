package uyg2;

public class YetiskinKartı extends Kart{

    public YetiskinKartı(int id, String Sahip, double Bakiye) {
        super(id, Sahip, Bakiye);
    }

    @Override
    public boolean odemeYap(double fiyat){
        if (getBakiye() >= fiyat){
            setBakiye(getBakiye() - fiyat);
            return true;
        }
        else{
            return false;
        }       
}
    
}
