package es.unileon.prg1.sieteymedia;

public class SieteymediaCards {
    
    private final int MAX_CARDS = 14;
    private Card cards[];
    private int next;

    // reserva memoria para 14 cartas y pone el contador a 0
    public SieteymediaCards() {
        this.cards = new Card[MAX_CARDS];
        this.next = 0;
    }

    // Añade una carta al array si aún queda hueco
    public boolean add(Card card) {
        if (this.next < MAX_CARDS) {
            this.cards[this.next] = card;
            this.next++;
            return true;
        }
        return false; // llena
    }

    // Suma los puntos de todas las cartas que hay actualmente en la mano
    public float getPoints() {
        float total = 0.0f;
        // Solo recorremos hasta 'next' las cartas válidas, para evitar NullPointerException
        for (int i = 0; i < this.next; i++) {
            total = total + this.cards[i].getPoints(); // no recursivo
        }
        return total;
    }

    // Muestra todas las cartas que tiene el jugador en la mano
    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < this.next; i++) {
            salida = salida + this.cards[i].toString() + "\n";
        }
        return salida;
    }
}