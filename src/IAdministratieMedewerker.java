import java.util.List;

/**
 * Deze app is interface voor administratie medewerker.
 * <ul>
 *     <li>Een opsomming van alle studenten die een bepaald vak hebben gehaald.</li>
 *     <li>Een opsomming van alle vakken die  een specifieke student heeft gehaald.</li>
 *     <li>Een opsomming van alle vakken die een student nog moet halen.</li>
 *     <li>Het gemiddelde van alle cijfers die studenten voor een bepaald vak hebbengehaald.</li>
 *     <li>De optelsom van alle cijfers die een (meegegeven) student voor alle vakkenheeft gehaald.</li>
 *     <li>De standaarddeviatie van alle cijfers die een student heeft gehaald.</li>
 *     <li>De variantie van alle cijfers die alle studenten voor een vak gehaald hebben.</li>
 *     <li>De docent wil weten of mannen beter of slechter scoren voor een specifiekvak dan vrouwen.</li>
 * </ul>
 * @author Joseph Nzi
 * @version %I% %G%
 * @see Administratie
 * @since 1.0
 */
public interface IAdministratieMedewerker {
    Double PASS = 5.5;

    /**
     * Methode om een list van student te krijgen
     * @return een student list
     * @see #setStudents(List Studenten)
     */
    List<IStudent> getStudents();

    /**
     * Methode om een list van student te maken
     * @param students list van studenten
     * @see #getStudents
     */
    void setStudents(List<IStudent> students);


    /**
     * Methode om een opsomming van alle studenten die een bepaald vak hebben gehaald te zien.
     * @param vak is de de modulcode van het vak
     * @see #checkBest(String Vak)
     * @see #getGemiddelCijferPerVak(String Vak)
     */
    void getOpsommingBehaald(String vak);
    /**
     * Methode om te weten of mannen beter of slechter scoren voor een specifiekvak dan vrouwen.
     * @param vak is de de modulcode van het vak
     * @see #getOpsommingBehaald(String Vak)
     * @see #getGemiddelCijferPerVak(String Vak)
     */
    void  checkBest(String vak);

    /**
     * Methode om een opsomming van alle vakken die een specifieke student moet nog behalen.
     * @param student is het student nummer van de student
     * @see #getNietBehaalStudent(String Student)
     * @see #getSumCijferPerStudent(String Student)
     * @see #getGemiddelCijferPerStudent(String Student)
     * @see #getStandaardeviatieEnVariatie(String Student)
     */
    void getNietBehaalStudent(String student);
    /**
     * Methode om een de standaardeviatie en variatie van de student cijfers
     * @param student is het student nummer van de student
     * @see #getNietBehaalStudent(String Student)
     * @see #getSumCijferPerStudent(String Student)
     * @see #getGemiddelCijferPerStudent(String Student)
     * @see #getStandaardeviatieEnVariatie(String Student)
     */

    void getStandaardeviatieEnVariatie(String student);
    /**
     * Methode om een opsomming van alle vakken die een student heeft behaald.
     * @param student is de de modulcode van het vak
     * @see #checkBest(String Vak)
     * @see #getGemiddelCijferPerVak(String Vak)
     */

     void getBehaalStudent(String student);
    /**
     * Methode om het gemiddelde van alle cijfers die studenten hebbengehaald.
     * @param vak is de de modulcode van het vak
     * @see #getOpsommingBehaald(String Vak)
     * @see #checkBest(String Vak)
     */
    void getGemiddelCijferPerVak(String vak);

    /**
     * Methode om het gemiddelde van alle cijfers die studenten voor een bepaald vak hebbengehaald.
     * @param student is het student nummer van de student
     * @see #getBehaalStudent(String Student)
     * @see #getNietBehaalStudent(String Student)
     * @see #getSumCijferPerStudent(String Student)
     * @see #getStandaardeviatieEnVariatie(String Student)
     */
    void getGemiddelCijferPerStudent(String student);

    /**
     * Methode om de optelsom van alle cijfers die een (meegegeven) student voor alle vakkenheeft gehaald.
     * @param student is het student nummer van de student
     * @see #getBehaalStudent(String Student)
     * @see #getNietBehaalStudent(String Student)
     * @see #getGemiddelCijferPerStudent(String Student)
     * @see #getStandaardeviatieEnVariatie(String Student)
     */

     void getSumCijferPerStudent(String student);


}
