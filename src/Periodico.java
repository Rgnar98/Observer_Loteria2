import java.util.List;

public class Periodico implements ObserverLoteriaPrimitiva, ObserverJugador {
    private List<Integer> numbers;
    private int winners;
    private int n;


    public void Show(){
        System.out.println("Numero de la loteria: "+this.numbers.toString());
        System.out.println("Numero de ganadores: "+this.n);
    }

    @Override
    public void updateGanadores(int numbers_player) {
        this.winners = numbers_player;
        if(3 <= winners && winners <= 6)
            n++;


    }

    @Override
    public void updateNumeros(List<Integer> n) {
        this.numbers = n;
    }

}
