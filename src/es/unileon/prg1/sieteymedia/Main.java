package es.unileon.prg1.sieteymedia;
public class Main {
    public static void main(String[] args) {
       
        Card asOros = new Card(); // 1 de OROS
        Card sotaOros = new Card(10, 0); // 10 de OROS

        System.out.println("Primera carta: " + asOros);
        System.out.println("Siguiente al As de Oros: " + asOros.next());
        System.out.println("Posición de la Sota de Oros (con while): " + sotaOros.getPositionWhile());

       
        SieteymediaCards mano = new SieteymediaCards();
        mano.add(asOros);
        mano.add(sotaOros);

        System.out.println("\n Mano del jugador");
        System.out.print(mano.toString());
        System.out.println("Puntos totales: " + mano.getPoints());
    }
}