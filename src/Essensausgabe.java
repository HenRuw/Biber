/**
 * Beschreiben Sie hier die Klasse Essensausgabe.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Essensausgabe
{
    private Stack<Teller> tellerstapel;
    private Queue<Biber> biberschlange;

    /**
     * Konstruktor für Objekte der Klasse Essensausgabe
     */
    public Essensausgabe()
    {
        tellerstapel = new Stack<Teller>();
        biberschlange = new Queue<Biber>();

    }

    public void biberHinzufuegen(Biber neuerBiber){
        biberschlange.enqueue(neuerBiber);
    }
    public void tellerHinzufuegen(Teller neuerTeller){
        tellerstapel.push(neuerTeller);
    }

    public boolean passtZusammen(Stack<Teller> stapel, Queue<Biber> schlange) {
        if (stapel.top().getFlacherTeller() == schlange.front().getGroesse()){
         return true;
        }
        return false;
    }

    public Stack<Teller> getTellerstapel() {
        return tellerstapel;
    }

    public Queue<Biber> getBiberschlange() {
        return biberschlange;
    }

    public static void main(String[] args) {
        Essensausgabe programm = new Essensausgabe();
        programm.biberHinzufuegen(new Biber(false));
        programm.biberHinzufuegen(new Biber(true));
        programm.biberHinzufuegen(new Biber(true));
        programm.biberHinzufuegen(new Biber(false));
        programm.biberHinzufuegen(new Biber(true));

        programm.tellerHinzufuegen(new Teller(false));
        programm.tellerHinzufuegen(new Teller(true));
        programm.tellerHinzufuegen(new Teller(true));
        programm.tellerHinzufuegen(new Teller(false));
        programm.tellerHinzufuegen(new Teller(true));

        System.out.println(programm.passtZusammen(programm.getTellerstapel(), programm.getBiberschlange()));;
    }

}