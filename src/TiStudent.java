import java.util.*;
import java.util.stream.Collectors;

public class TiStudent implements IStudent{

    private String stundentnummer;
    private String naam;
    private String geslacht;
    private String klas;
    private String studierichting;
    private List<IVak> vakken = new ArrayList<>();


    public TiStudent(String stundentnummer, String naam, String geslacht, String klas, String studierichting) {
        this.stundentnummer = stundentnummer;
        this.naam = naam;
        this.geslacht = geslacht;
        this.klas = klas;
        this.studierichting = studierichting;
    }

    public String getStundentnummer() {
        return stundentnummer;
    }

    public void setStundentnummer(String stundentnummer) {
        this.stundentnummer = stundentnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getKlas() {
        return klas;
    }

    public void setKlas(String klas) {
        this.klas = klas;
    }

    public String getStudierichting() {
        return studierichting;
    }

    public void setStudierichting(String studierichting) {
        this.studierichting = studierichting;
    }



    public Map<String,Double> getBehaalde() {

        return vakken.stream()
                .filter(vak1 -> vak1.getCijfer()>=PASS)
                        .collect(Collectors.toMap(IVak::getModulcode, IVak::getCijfer));
    }


    public Map<String, Double> getOnbehaalde() {

        return vakken.stream()
                .filter(vak1 -> vak1.getCijfer()<5.5)
                .collect(Collectors.toMap(IVak::getModulcode, IVak::getCijfer));
    }

    public double getGemiddel() {
        return vakken.stream()
                .mapToDouble(IVak::getCijfer)
                .summaryStatistics()
                .getAverage();
    }

    public double getSum() {
        return vakken.stream()
                .mapToDouble(IVak::getCijfer)
                .summaryStatistics()
                .getSum();
    }
    public double getStandaardeviatie(){
        double standaarDeviatie = 0.0;
        List<Double> cijfers = vakken.stream()
                .map(IVak::getCijfer).toList();
        int lengte = cijfers.size();
        double sum = getSum();
        double mean = sum/lengte;
        for (double cijfer : cijfers
        ) {
           standaarDeviatie += Math.pow(cijfer - mean, 2);
        }
        return Math.sqrt(standaarDeviatie/lengte);
    }

    public List<IVak> getVakken() {
        return vakken;
    }

    public void setVakken( IVak vak) {
        this.vakken.add(vak);
    }
}
