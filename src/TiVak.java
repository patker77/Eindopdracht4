
public class TiVak implements IVak {



    private String modulcode;
    private double cijfer;
    private int jaar;

    public TiVak(String modulcode, double cijfer, int jaar) {
        this.modulcode = modulcode;
        setCijfer(cijfer);
        setJaar(jaar);

    }

    public String getModulcode() {
        return modulcode;
    }

    public void setModulcode(String modulcode) {
        this.modulcode = modulcode;
    }


    private boolean isVoorValideCijfer(double cijfer) {

            if (cijfer >= 1.0 && cijfer < 10.0) {
                return true;
            } else {
                System.out.println("Invalide cijfer , het cijfer moet tussen 1 en 10 zijn");
                return false;
            }
    }

        private boolean isValidestudiejaar( int studieJaar){
            if (!(studieJaar < 1 || studieJaar > 4)) {
                return true;
            } else {
                System.out.println("Invalide jaar , het studiejaar moet tussen 1 en 4 zijn");
                return false;
            }
        }




    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        if(isVoorValideCijfer(cijfer)){
            this.cijfer = cijfer;
        }
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int studieJaar) {
        if(isValidestudiejaar(studieJaar)) {
            this.jaar = studieJaar;
        }
    }


}
