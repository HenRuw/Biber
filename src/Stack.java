
/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
 * </p>
 * <p>
 * Generische Klasse Stack<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse Stack (Warteschlange) verwalten beliebige
 * Objekte vom Typ ContentType nach dem First-In-First-Out-Prinzip, d.h., das
 * zuerst abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden haben
 * eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten Objekte.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule, Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_02 2014-02-21
 */
public class Stack<ContentType> {

    /* --------- Anfang der privaten inneren Klasse -------------- */

    private class StackNode {

        private ContentType content = null;
        private StackNode nextNode = null;

        /**
         * Ein neues Objekt vom Typ StackNode<ContentType> wird erschaffen.
         * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
         *
         * @param pContent das Inhaltselement des Knotens vom Typ ContentType
         */
        public StackNode(ContentType pContent) {
            content = pContent;
            nextNode = null;
        }

        /**
         * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
         * gesetzt.
         *
         * @param pNext der Nachfolger des Knotens
         */
        public void setNext(StackNode pNext) {
            nextNode = pNext;
        }

        /**
         * Liefert das naechste Element des aktuellen Knotens.
         *
         * @return das Objekt vom Typ StackNode, auf das der aktuelle Verweis zeigt
         */
        public StackNode getNext() {
            return nextNode;
        }

        /**
         * Liefert das Inhaltsobjekt des Knotens vom Typ ContentType.
         *
         * @return das Inhaltsobjekt des Knotens
         */
        public ContentType getContent() {
            return content;
        }

    }

    /* ----------- Ende der privaten inneren Klasse -------------- */

    private StackNode head;

    /**
     * Eine leere Schlange wird erzeugt.
     * Objekte, die in dieser Schlange verwaltet werden, muessen vom Typ
     * ContentType sein.
     */
    public Stack() {
        head = null;
    }

    /**
     * Die Anfrage liefert den Wert true, wenn die Schlange keine Objekte enthaelt,
     * sonst liefert sie den Wert false.
     *
     * @return true, falls die Schlange leer ist, sonst false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Das Objekt pContentType wird an die Schlange angehaengt.
     * Falls pContentType gleich null ist, bleibt die Schlange unveraendert.
     *
     * @param pContent
     *            das anzuhaengende Objekt vom Typ ContentType
     */
    public void push(ContentType pContent) {
        if (pContent != null) {
            StackNode newNode = new StackNode(pContent);
            if (this.isEmpty()) {
                head = newNode;
            } else {
                newNode.setNext(head);
                head = newNode;
            }
        }
    }

    /**
     * Das erste Objekt wird aus der Schlange entfernt.
     * Falls die Schlange leer ist, wird sie nicht veraendert.
     */
    public void pop() {
        if (!this.isEmpty()) {
            head = head.getNext();
            if (this.isEmpty()) {
                head = null;
            }
        }
    }

    /**
     * Die Anfrage liefert das erste Objekt der Schlange.
     * Die Schlange bleibt unveraendert.
     * Falls die Schlange leer ist, wird null zurueckgegeben.
     *
     * @return das erste Objekt der Schlange vom Typ ContentType oder null,
     *         falls die Schlange leer ist
     */
    public ContentType top() {
        if (this.isEmpty()) {
            return null;
        } else {
            return head.getContent();
        }
    }
}

