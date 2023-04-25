import java.util.List;
import java.util.Map;


/**
 * Deze app is interface voor een student.
 * <ul>
 *     <li>Een opsomming van alle vakken die  een specifieke student heeft gehaald.</li>
 *     <li>Een opsomming van alle vakken die een student nog moet halen.</li>
 *     <li>Het gemiddelde van alle cijfers die studenten hebbengehaald.</li>
 *     <li>De optelsom van alle cijfers die een (meegegeven) student voor alle vakkenheeft gehaald.</li>
 *     <li>De standaarddeviatie van alle cijfers die een student heeft gehaald.</li>
 *     <li>De variantie van alle cijfers die alle studenten voor een vak gehaald hebben.</li>
 * </ul>
 * @author Joseph Nzi
 * @version %I% %G%
 * @see TiStudent
 * @since 1.0
 */

public interface IStudent {

    /**
     * Methode om een de student naam te krijgen
     * @see #setStundentnummer(String StudentNumer)
     * @see #getNaam
     * @see #getStudierichting
     * @see #getGeslacht
     * @see #getKlas
     * @return de studentnummer
     */
    double PASS =5.5;
    String getStundentnummer();

    /**
     * Methode om een de studentnummer te zetten
     * @param stundentnummer is het student nummer van de student
     * @see #getStundentnummer
     * @see #setStudierichting(String Studierichting)
     * @see #setKlas(String Klas)
     * @see #setNaam(String Naam)
     * @see #setGeslacht(String Geslacht)
     */
    void setStundentnummer(String stundentnummer);
    /**
     * Methode om een de student naam te krijgen
     * @see #setNaam(String Naam)
     * @see #getStundentnummer
     * @see #getGeslacht
     * @see #getStudierichting
     * @see #getKlas
     * @return de student naam
     */
    String getNaam();
    /**
     * Methode om een de studentnummer te zetten
     * @param naam is de student naam
     * @see #getNaam
     * @see #setStudierichting(String Studierichting)
     * @see #setKlas(String Klas)
     * @see #setNaam(String Naam)
     * @see #setStundentnummer(String StudentNummer)
     * @see #setGeslacht(String Geslacht)
     */
    void setNaam(String naam);
    /**
     * Methode om een de student geslacht te krijgen
     * @see #setGeslacht(String Geslacht)
     * @see #getNaam
     * @see #getKlas
     * @see #getStundentnummer
     * @see #getStudierichting
     * @return de student naam
     */
    String getGeslacht();
    /**
     * Methode om een de studentnummer te zetten
     * @param geslacht is de student geslacht
     * @see #getGeslacht
     * @see #setStudierichting(String Studierichting)
     * @see #setKlas(String Klas)
     * @see #setNaam(String Naam)
     * @see #setStundentnummer(String StudentNummer)
     */
    void setGeslacht(String geslacht);
    /**
     * Methode om een de student klas te krijgen
     * @see #setKlas(String Klas)
     * @see #getNaam
     * @see #getGeslacht
     * @see #getStudierichting
     * @see #getStundentnummer()
     * @return de student klas
     */
    String getKlas();
    /**
     * Methode om een de studentnummer te zetten
     * @param klas is de student groep
     * @see #getKlas
     * @see #setStudierichting(String Studierichting)
     * @see #setNaam(String Naam)
     * @see #setGeslacht(String Geslacht)
     * @see #setStundentnummer(String StudentNummer)
     */
    void setKlas(String klas);
    /**
     * Methode om een de student studierichting te krijgen
     * @see #setStudierichting(String Studierichting)
     * @see #getNaam
     * @see #getKlas
     * @see #getGeslacht
     * @see #getStundentnummer
     * @return de student geslacht
     */
    String getStudierichting();
    /**
     * Methode om een de student studierichting te zetten
     * @param studierichting is de studenten studierichting
     * @see #getStudierichting
     * @see #setNaam(String Naam)
     * @see #setKlas(String Klas)
     * @see #setGeslacht(String Geslacht)
     * @see #setStundentnummer(String StudentNummer)
     */
    void setStudierichting(String studierichting);
    /**
     * Methode om een list van student te krijgen
     * @return een vakken lijst
     * @see #setVakken(IVak Vakken)
     */
    List<IVak> getVakken();
    /**
     * Methode om een list van vakken te zetten
     * @param vak is een vakken pakket
     * @see #getVakken
     */
    void setVakken(IVak vak);
    /**
     * Methode om een opsomming van vakken die behaald zijn.
     * @see #getOnbehaalde
     * @return een map met de vak module en het cijfer
     */
     Map<String, Double> getBehaalde();

    /**
     * Methode om de som van alle cijfers te bereken
     * @see #getStandaardeviatie
     * @see #getGemiddel
     * @return de som van alle cijfers
     */
    double getSum();

    /**
     * Methode om een de standaardeviatie en variatie van de student cijfers te verkrijgen
     * @see #getSum
     * @see #getGemiddel
     * @return de standaardeviatie terug
     */
    double getStandaardeviatie();

    /**
     * Methode om een opsomming van vakken die nog niet behaald zijn.
     * @see #getGemiddel
     * @see #getSum
     * @return het gemiddel van alle cijfer behaald
     */
    Map<String, Double> getOnbehaalde();
    /**
     * Methode om een gemiddel van alle cijfer te bereken
     * @see #getSum
     * @see #getStandaardeviatie
     * @return de de gemiddel van alle cijfer
     */
    double getGemiddel();

}
