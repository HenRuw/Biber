
public class Biber
{
    private boolean gross;

    /**
     * Konstruktor für Objekte der Klasse Biber.
     * @param pGroesse klein oder gross
     */
    public Biber(boolean pGross)
    {
        gross = pGross;
    }

    /**
     * @return groesse klein oder gross
     */
    public boolean getGroesse()
    {
        return gross;
    }
}