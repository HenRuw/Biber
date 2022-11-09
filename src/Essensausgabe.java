/**
 * Beschreiben Sie hier die Klasse Essensausgabe.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Essensausgabe {
    private final Stack<Teller> tellerstapel;
    private final Queue<Biber> biberschlange;

    /**
     * Konstruktor für Objekte der Klasse Essensausgabe
     */
    public Essensausgabe() {
        tellerstapel = new Stack<>();
        biberschlange = new Queue<>();

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

        System.out.println(programm.passtZusammen(programm.getTellerstapel(), programm.getBiberschlange()));
    }

    public void biberHinzufuegen(Biber neuerBiber) {
        biberschlange.enqueue(neuerBiber);
    }

    public void tellerHinzufuegen(Teller neuerTeller) {
        tellerstapel.push(neuerTeller);
    }

    public boolean passtZusammen(Stack<Teller> stapel, Queue<Biber> schlange) {
        Queue<Biber> copyBiber = new Queue<>();
        Stack<Teller> copyTeller = new Stack<>();
        boolean passt = true;
        while (!schlange.isEmpty()) {
            if (stapel.isEmpty()) {
                passt = false;
                break;
            }
            if (schlange.front().getIsGross() != stapel.top().getIsFlacherTeller()) {
                passt = false;
            }
            copyTeller.push(stapel.top());
            copyBiber.enqueue(schlange.front());

            stapel.pop();
            schlange.dequeue();
        }

        //Reset Queues
        while (!stapel.isEmpty()) {
            copyTeller.push(stapel.top());
            stapel.pop();
        }
        while (!schlange.isEmpty()) {
            copyBiber.enqueue(schlange.front());
            schlange.dequeue();
        }
        while (!copyBiber.isEmpty()) {
            schlange.enqueue(copyBiber.front());
            copyBiber.dequeue();
        }
        while (!copyTeller.isEmpty()) {
            stapel.push(copyTeller.top());
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

}