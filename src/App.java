/**
 * Deze app is bedoel om student CRM system te simuleren.
 * <ul>
 *     <li>Een opsomming van alle studenten die een bepaald vak hebben gehaald.</li>
 *     <li>Een opsomming van alle vakken die  ́e ́en specifieke student heeft gehaald.</li>
 *     <li>Een opsomming van alle vakken die een student nog moet halen.</li>
 *     <li>Het gemiddelde van alle cijfers die studenten voor een bepaald vak hebbengehaald.</li>
 *     <li>De optelsom van alle cijfers die een (meegegeven) student voor alle vakkenheeft gehaald.</li>
 *     <li>De standaarddeviatie van alle cijfers die een student heeft gehaald.</li>
 *     <li>De variantie van alle cijfers die alle studenten voor een vak gehaald hebben.</li>
 *     <li>De docent wil weten of mannen beter of slechter scoren voor een specifiekvak dan vrouwen.</li>
 * </ul>
 * @author Joseph Nzi
 * @version %I% %G%
 * @since 1.0
 */




public class App {


    public static void main(String[] args) {

        IAdministratieMedewerker john = Factory.maakAdministratieMederwerker(Factory.loadStudentData());

        john.getOpsommingBehaald("security");
        john.getGemiddelCijferPerVak("python");
        john.getBehaalStudent("120223");
        john.getNietBehaalStudent("120228");
        john.getSumCijferPerStudent("120229");
        john.getGemiddelCijferPerStudent("120228");
        john.getStandaardeviatieEnVariatie("120224");
        john.checkBest("python");




    }
}
