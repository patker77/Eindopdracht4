/**
 * Deze app is interface voor administratie medewerker.
 *
 * @author Joseph Nzi
 * @version %I% %G%
 * @see Administratie
 * @since 1.0
 */
public interface IVak {
    /**
     * Methode om een de student naam te krijgen
     * @see #setModulcode(String Module)
     * @see #getCijfer
     * @see #getJaar
     * @return de vak modulecode
     */
    String getModulcode();
    /**
     * Methode om een de student naam te krijgen
     * @param modulcode is het vak module
     * @see #getModulcode
     * @see #setJaar(int Jaar)
     * @see #setCijfer(double Cijfer)
     */
    void setModulcode(String modulcode);
    /**
     * Methode om een de student naam te krijgen
     * @see #setCijfer(double Cijfer)
     * @see #getModulcode
     * @see #getJaar
     * @return cijfer behaald
     */
    double getCijfer();
    /**
     * Methode om een de student naam te krijgen
     * @param cijfer is het cijfer behaald
     * @see #getModulcode
     * @see #setModulcode(String Module)
     * @see #setJaar(int Jaar)
     */
    void setCijfer(double cijfer);
    /**
     * Methode om een de student naam te krijgen
     * @see #setJaar(int Jaar)
     * @see #getCijfer
     * @see #getModulcode
     * @return het studiejaar
     */
    int getJaar();
    /**
     * Methode om een de student naam te krijgen
     * @param studieJaar is het studiejaar
     * @see #setModulcode(String Module)
     * @see #setCijfer(double Cijfer)
     */
    void setJaar(int studieJaar);

}
