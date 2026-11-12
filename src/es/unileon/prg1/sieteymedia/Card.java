package es.unileon.prg1.sieteymedia;

public class Card {
    private int number;
    private Palos palo;

    // primera carta (As de Oros)
    public Card() {
        this.number = 1;
        this.palo = Palos.OROS;
    }

    // entero: 0=OROS, 1=COPAS, 2=ESPADAS, 3=BASTOS)
    public Card(int number, int palo) {
        this.number = number;
        // Convertimos el entero 
        this.palo = Palos.values()[palo];
    }


    public int getNumber() {
        return this.number;
    }

    public Palos getPalo() {
        return this.palo;
    }

    // Devuelve los puntos 
    public float getPoints() {
        if (this.number >= 1 && this.number <= 7) {
            return this.number;
        } else {
            // Las cartas 10, 11 y 12 valen medio punto
            return 0.5f;
        }
    }

    // Compara si dos cartas son iguales
    public boolean equals(Card otra) {
        if (otra == null) {
            return false;
        }
        return (this.number == otra.getNumber()) && (this.palo == otra.getPalo());
    }

    @Override
    public String toString() {
        return this.number + " de " + this.palo;
    }

    //  MÉTODOS MATRICES

    // Devuelve la carta siguiente 
    public Card next() {
        int nextNumber = this.number;
        int nextPalo = this.palo.ordinal(); // 0=OROS, 1=COPAS, 2=ESPADAS, 3=BASTOS

        if (nextNumber < 7) {
            nextNumber++;
        } else if (nextNumber == 7) {
            nextNumber = 10; //  del 7 se salta al 10
        } else if (nextNumber < 12) {
            nextNumber++;
        } else {
            // Si es el Rey 12, volvemos al 1 y pasamos al siguiente palo
            nextNumber = 1;
            nextPalo++;
            // Si nos pasamos de 3, volvemos a 0
            if (nextPalo > 3) {
                nextPalo = 0;
            }
        }
        return new Card(nextNumber, nextPalo);
    }

    // Calcula la posición de la carta usando un bucle FOR
    public int getPositionFor() {
        Card actual = new Card(); // Empieza en el As de Oros (posición 0)
        int pos = 0;

        for (int i = 0; i < 40; i++) {
            if (actual.equals(this)) {
                pos = i;
            }
            actual = actual.next();
        }
        return pos;
    }

    // Calcula la posición de la carta usando un bucle WHILE
    public int getPositionWhile() {
        Card actual = new Card(); // Empieza en el As de Oros (posición 0)
        int pos = 0;

        while (!actual.equals(this)) {
            actual = actual.next();
            pos++;
        }
        return pos;
    }

    // Devuelve las 40 cartas de la baraja ordenadas 
    public String toStringAll() {
        String resultado = "";
        Card actual = new Card(); // As de Oros

        for (int i = 0; i < 40; i++) {
            resultado = resultado + actual.toString() + "\n";
            actual = actual.next();
        }
        return resultado;
    }

    // Devuelve todas las cartas desde el As de Oros hasta la actual (sin incluirla)
    public String toStringUpToThis() {
        String resultado = "";
        Card actual = new Card(); // As de Oros

        while (!actual.equals(this)) {
            resultado = resultado + actual.toString() + "\n";
            actual = actual.next();
        }
        return resultado;
    }
}