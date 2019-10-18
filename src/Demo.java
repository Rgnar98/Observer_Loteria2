import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        LoteriaPrimitiva loteria = new LoteriaPrimitiva();
        Periodico periodico = new Periodico();
        Random r = new Random(32);

        List<Jugador> jugadores = new ArrayList<Jugador>();
        for(int i=0; i<100000; i++){
            List<Integer> numbers = new ArrayList<>();
            for(int x = 0; x < 6; x++) {
                numbers.add(x, r.nextInt(48) + 1);
            }
            Jugador jugador= new Jugador("Jugador"+i,numbers);
            jugadores.add(jugador);
        }

        loteria.registerObserver(periodico);

        for(Jugador j:jugadores)
            loteria.registerObserver(j);
        for(Jugador j:jugadores)
            j.registerObserver(periodico);

        loteria.nuevoSorteo();
        periodico.Show();

        loteria.removeObserver(periodico);

        for(Jugador j:jugadores)
            loteria.removeObserver(j);
        for(Jugador j:jugadores)
            j.removeObserver(periodico);

    }
}
