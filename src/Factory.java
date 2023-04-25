
import java.util.ArrayList;
import java.util.List;

/**
 * Factory is een een class die gebruik wordt om ander classen te intansieren.
 * <ul>
 *     <li>Maak 5 studenten aan en voeg een vakkenpakket met cijfer toe</li>
 *     <li>Maak een administratie mederwerker aan die data over de studenten zal verkrijgen</li>
 *
 * </ul>
 * @author Joseph Nzi
 * @version %I% %G%
 * @see #loadStudentData()
 * @see #loadVakken(List Vakken)
 * @see #maakAdministratieMederwerker(List Student)
 * @see #maakStudent(String StudentenNR, String Naam, String Geslacht, String Klas, String Studierichting)
 * @see #maakVak(String Modulcode, double Cijfer, int Jaar)
 * @since 1.0
 */
public class Factory {
    /*  ===========================================================================================================
        *                                                                                                         *
        *                                           LOAD STUDENT DATA                                             *
        ===========================================================================================================
    */
    public static List<IStudent> loadStudentData(){
        /**
         * Methode student aan te maken met hun vakken
         * @return een student
         * @see #loadVakken(List Vakken)
         * @see #maakStudent(String StudentenNR, String Naam, String Geslacht, String Klas, String Studierichting)
         */

        IStudent joseph = Factory.maakStudent("120228","Joseph","m","th1","ti");
        IStudent anne = Factory.maakStudent("120227","Anne","f","th1","ti");
        IStudent tom = Factory.maakStudent("120229","Tom","m","th1","ti");
        IStudent christin = Factory.maakStudent("120223","Christin","f","th1","ti");
        IStudent kim = Factory.maakStudent("120224","Kim","m","th1","ti");

        ArrayList<IStudent> student = new ArrayList<>(List.of(
                joseph,anne,tom,christin,kim));
        loadVakken(student);
        return student;

    }

    /*  ===========================================================================================================
        *                                                                                                         *
        *                                           LOAD VAKKEN  DATA                                             *
        ===========================================================================================================
       */

    /**
     * Methode om een list van vakken te maken voor een student
     * @param student is list van studenten
     * @return een list van vakken
     * @see TiStudent#setVakken(IVak Vak)
     * @see #maakVak(String Modulcode, double Cijfer, int Jaar)
     */
     private  static void loadVakken(List<IStudent> student){
         student.get(0).setVakken(Factory.maakVak("tes1",5.3,1));
         student.get(0).setVakken(Factory.maakVak("python",7.3,1));
         student.get(0).setVakken(Factory.maakVak("security",6.3,1));
         student.get(0).setVakken(Factory.maakVak("programmeer",9.6,1));
         student.get(0).setVakken(Factory.maakVak("llc",7.8,1));

         student.get(1).setVakken(Factory.maakVak("tes1",7.5,1));
         student.get(1).setVakken(Factory.maakVak("python",6.3,1));
         student.get(1).setVakken(Factory.maakVak("security",8.3,1));
         student.get(1).setVakken(Factory.maakVak("programmeer",8.6,1));
         student.get(1).setVakken(Factory.maakVak("llc",4.8,1));

         student.get(2).setVakken(Factory.maakVak("tes1",2.3,1));
         student.get(2).setVakken(Factory.maakVak("python",5.5,1));
         student.get(2).setVakken(Factory.maakVak("security",7.3,1));
         student.get(2).setVakken(Factory.maakVak("programmeer",4.6,1));
         student.get(2).setVakken(Factory.maakVak("llc",5.8,1));

         student.get(3).setVakken(Factory.maakVak("tes1",9.3,1));
         student.get(3).setVakken(Factory.maakVak("python",7.3,1));
         student.get(3).setVakken(Factory.maakVak("security",8.3,1));
         student.get(3).setVakken(Factory.maakVak("programmeer",4.2,1));
         student.get(3).setVakken(Factory.maakVak("llc",6.8,1));

         student.get(4).setVakken(Factory.maakVak("tes1",7.5,1));
         student.get(4).setVakken(Factory.maakVak("python",6.7,1));
         student.get(4).setVakken(Factory.maakVak("security",4.5,1));
         student.get(4).setVakken(Factory.maakVak("programmeer",5.6,1));
         student.get(4).setVakken(Factory.maakVak("llc",8.3,1));
    }

    /*  =========================================================================
       *                                                                        *
       *               VAKKEN,STUDENT,ADMINISTRATIE INSTANCIEREN                *
       ==========================================================================
      */

    /**
     * Methode om een student te intancieren
     * @param stundentnummer is de student nummer
     * @param naam is de student naam
     * @param geslacht is de student geslacht
     * @param klas is de student klas
     * @param studierichting is de student richting
     * @return een student
     * @see TiStudent
     */
    private static IStudent maakStudent(String stundentnummer, String naam, String geslacht, String klas, String studierichting){
        return new TiStudent(stundentnummer, naam, geslacht, klas, studierichting);
    }

    /**
     * Methode om een vak te intancieren
     * @param modulcode is het vak modulcode
     * @param cijfer is het behaalde cijfer
     * @param jaar is het studiejaar
     * @return een een vak
     * @see TiVak
     */
    private static IVak maakVak(String modulcode, double cijfer, int jaar){
        return new TiVak(modulcode, cijfer, jaar);
    }

    /**
     * Methode om een adminitratie medewerker te intancieren
     * @param students is een list van studenten
     * @return een een administratie medewerker
     * @see Administratie
     */
    public static IAdministratieMedewerker maakAdministratieMederwerker(List<IStudent> students){
        return new Administratie(students);
    }

}
