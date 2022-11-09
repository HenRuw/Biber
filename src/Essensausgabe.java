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
        Queue<Biber> copyBiber = new Queue<>();
        Stack<Teller> copyTeller = new Stack<>();
        boolean passt = true;
        while (!biberschlange.isEmpty()){
            if (tellerstapel.isEmpty()){
                passt = false;
                break;
            }
            if (biberschlange.front().getIsGross() != tellerstapel.top().getIsFlacherTeller()){
                passt = false;
            }
            copyTeller.push(tellerstapel.top());
            copyBiber.enqueue(biberschlange.front());

            tellerstapel.pop();
            biberschlange.dequeue();
        }

        //Reset Queues
        while (!tellerstapel.isEmpty()){
            copyTeller.push(tellerstapel.top());
            tellerstapel.pop();
        }
        while (!biberschlange.isEmpty()){
            copyBiber.enqueue(biberschlange.front());
            biberschlange.dequeue();
        }
        while (!copyBiber.isEmpty()){
            biberschlange.enqueue(copyBiber.front());
            copyBiber.dequeue();
        }
        while (!copyTeller.isEmpty()){
            tellerstapel.push(copyTeller.top());
            copyTeller.pop();
        }

        return passt;
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

        System.out.println(programm.passtZusammen(programm.getTellerstapel(), programm.getBiberschlange()));;
    }

}