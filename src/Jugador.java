import java.util.ArrayList;
import java.util.List;

public class Jugador implements ObserverLoteriaPrimitiva, SubjectJugador {
    private String name;
    private List<Integer> numbers;
    private ObserverJugador observerJugador;
    private int numequals;


    public Jugador(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
        this.numequals = 0;
    }

    public int numeroAciertos(List<Integer> winners){
        int equals = 0;
        for(int i=0; i<winners.size(); i++){
            if(this.numbers.get(i).equals(winners.get(i))){
                equals++;
            }
        }
        return equals;
    }

    @Override
    public void updateNumeros(List<Integer> winners) {
        int equals = numeroAciertos(winners);
        this.numequals = equals;
        if(equals==3)
            System.out.println("You win 100€ (3 matches)");
        else if(equals==4)
            System.out.println("You win 500€ (4 matches)");
        else if(equals==5)
            System.out.println("You win 750€ (5 matches)");
        else if (equals==6)
            System.out.println("You win 1000€ (6 matches)");
        else
            System.out.println("You win 0€, sorry (less than 3 matches)");

        notifyObservers();
    }

    @Override
    public void registerObserver(ObserverJugador o) {
        this.observerJugador = o;
    }

    @Override
    public void removeObserver(ObserverJugador o) {
        this.observerJugador = null;
    }

    @Override
    public void notifyObservers() {
        observerJugador.updateGanadores(numequals);
    }
}
