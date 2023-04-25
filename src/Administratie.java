import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;



public class Administratie implements IAdministratieMedewerker {
    private List<IStudent> students;



    public Administratie(List<IStudent> students) {
        this.students = students;
    }

    public List<IStudent> getStudents() {
        return students;
    }

    public void setStudents(List<IStudent> students) {
        this.students = students;
    }

    public void getBehaalStudent(String studentNr){
        if (getBehaaldeVakStudent(studentNr).isEmpty()){
            System.out.println("Invalide studentNr");
            return;
        }
        System.out.println("De student met de volgende nummer: "
                + studentNr + " heeft de volgende vakken behaald "
                + getBehaaldeVakStudent(studentNr));
    }
    public void getNietBehaalStudent(String studentNr){
        if (getNietBehaaldeVakStudent(studentNr).isEmpty()){
            System.out.println("Invalide studentNr");
            return;
        }
        System.out.println("De student met de volgende nummer: "
                + studentNr + " moet nog de volgende vakken halen "
                + getNietBehaaldeVakStudent(studentNr));
    }

    public void getOpsommingBehaald(String vak) {

        Map<String, Map<String, Double>> data = new HashMap<>();
        getBehaaldeVak(data, vak);
        if (data.isEmpty()){
            System.out.println("Invalide vak");
            return;
        }

        System.out.println("De volgende studenten hebben dit vak behaald "+data);
    }

    public void getStandaardeviatieEnVariatie(String studentNr){
        double standaarDeviatie = standaardeviatie(studentNr);
        if (standaarDeviatie ==0.0){
            System.out.println("Invalide studentNr");
            return;
        }
        System.out.println("Standaardeviatie van de student "
                +studentNr+" is "+ String.format("%.1f", standaarDeviatie)
                +" de variatie is "+String.format("%.1f", Math.pow(standaarDeviatie,2)));
    }
    public void getGemiddelCijferPerStudent(String studentNr) {
        double gemiddel = getGemiddelStudent(studentNr);
        if (gemiddel ==0.0){
            System.out.println("Invalide studentNr");
            return;
        }
        System.out.println("het gemmiddelde cijfer van de studentnummer "
                + studentNr + " is "
                + String.format("%.1f", gemiddel));
    }

    public void getSumCijferPerStudent(String stundent) {
        double sum = getSumCijferStudent(stundent);
        if (sum ==0.0){
            System.out.println("Invalide studentNr");
            return;
        }
        System.out.println("De sum van alle cijfer van de studentnummer "
                + stundent + " is "
                + String.format("%.1f", sum));
    }
    public void getGemiddelCijferPerVak(String vak) {
        double gemiddel = getGemiddelCijferVoorVak(vak);
        if (gemiddel ==0.0){
            System.out.println("Invalide vak");
            return;
        }
        System.out.println("het gemmiddelde cijfer voor het vak " + vak + " is " + String.format("%.1f", gemiddel));
    }

    public void  checkBest(String vak){
        double mannen = bestScoreManOfVrouw(vak,"m");
        double vrouwen = bestScoreManOfVrouw(vak,"f");
        if (mannen == 0.0 && vrouwen == 0.0){
            System.out.println("Invalide vak");
            return;
        }
        System.out.println("mannen scoren gemmideld "+ String.format("%.1f",mannen) +" voor het vak "+vak+" en vrouwen scoren gemmideld "+ String.format("%.1f",vrouwen) );
        if (mannen>vrouwen){
            System.out.println("In conclusie hebben mannen beter gescoorde dan vrouwen voor dit vak");
        }  else if (mannen<vrouwen){
            System.out.println("In conclusie hebben vrouwen beter gescoorde dan mannen voor dit vak");
        }else if (mannen==vrouwen) {
            System.out.println("In conclusie scoren mannen en vouwen even hoog");
        }else {
            System.out.println("Invalide vak gekozen!!");
        }
    }


    private void getBehaaldeVak(Map<String, Map<String, Double>> data, String modulecode) {
        //filter van op een specifieke vak met de modulecode de studenten die een cijfer hebben hoger of gelijk aan 5.5 en zet ze in een map
        this.students.stream()
                .map(student -> {
                    data.put(student.getStundentnummer(), student.getVakken().stream()
                            .filter(vak -> vak.getCijfer() >= PASS
                                    && vak.getModulcode().equalsIgnoreCase(modulecode)
                                    )
                            .collect(Collectors.toMap(IVak::getModulcode, IVak::getCijfer)));
                    data.entrySet().removeIf(ent -> ent.getValue().isEmpty());
                    return data;
                }).toList();

    }
    private List<Map<String,Double>> getBehaaldeVakStudent(String studentNr) {
        //filter op student met de studentnummer en de vakken die hij of zij behaald heeft.
        return this.students.stream()
                .filter(s->s.getStundentnummer().equalsIgnoreCase(studentNr))
                .map(IStudent::getBehaalde).collect(Collectors.toList());
    }

    private List<Map<String,Double>> getNietBehaaldeVakStudent(String studentNr) {
        //filter op student met de studentnummer en geeft de vakken die nog niet behaald zijn.
        return this.students.stream()
                .filter(s->s.getStundentnummer().equalsIgnoreCase(studentNr))
                .map(IStudent::getOnbehaalde).collect(Collectors.toList());
    }


    private double getGemiddelCijferVoorVak(String v) {
        //filter studentent cijfer voor een specifieke vak en zet ze in een lijst
        double gemiddel = 1.0;
        List<DoubleStream> collect = this.students.stream()
                .map(student -> student.getVakken().stream()
                        .filter(vak -> vak.getModulcode().equalsIgnoreCase(v))
                        .mapToDouble(IVak::getCijfer)).toList();
        //get gemiddel van alle cijfers van het lijst
        OptionalDouble average = collect.stream()
                .mapToDouble(DoubleStream::sum).average();
        if (average.isPresent()) {
            gemiddel = average.getAsDouble();
        }
        return gemiddel;
    }

    private double getGemiddelStudent(String studentNr){
        //filter op student met de studentnummer en geeft zijn of haar gemiddelde cijfer
        return this.students.stream()
                .filter(s->s.getStundentnummer().equalsIgnoreCase(studentNr))
                .mapToDouble(IStudent::getGemiddel).sum();
    }


    private double bestScoreManOfVrouw(String v, String geslacht) {
        //filter op een specifieke vak met de modulecode en geslacht een geeft de gemiddel terug.
        double gemiddel = 1.0;
        List<DoubleStream> collect = this.students.stream()
                .map(student -> student.getVakken().stream()
                        .filter(vak -> student.getGeslacht().equalsIgnoreCase(geslacht)
                                && vak.getModulcode().equalsIgnoreCase(v))
                        .mapToDouble(IVak::getCijfer)).toList();
        OptionalDouble average = collect.stream()
                .mapToDouble(DoubleStream::sum).average();
        if (average.isPresent()) {
            gemiddel = average.getAsDouble();
        }
        return gemiddel;
    }



    private double getSumCijferStudent(String studentNr) {
        //filter op student met de studentnummer en geeft de sum van alle cijfer die hij/zij heeft.
        return this.students.stream()
                .filter(s->s.getStundentnummer().equalsIgnoreCase(studentNr))
                .mapToDouble(IStudent::getSum).sum();
    }

    private double standaardeviatie(String studentNr) {

        //filter op student met de studentnummer en geeft de standaardeviatie en variatie van zijn/haar cijfers
        return this.students.stream()
                .filter(s->s.getStundentnummer().equalsIgnoreCase(studentNr))
                .mapToDouble(IStudent::getStandaardeviatie).sum();
    }

}
