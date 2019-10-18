import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoteriaPrimitiva implements SubjectLoteria {
    private List<ObserverLoteriaPrimitiva> observers;
    private List<Integer> numbers;

    public LoteriaPrimitiva() {
        this.observers = new ArrayList<>();
        this.numbers = new ArrayList<>();
    }

    public void nuevoSorteo(){
        Random r = new Random(32);
        for (int i=0; i<6;i++)
            this.numbers.add(i, r.nextInt(48)+1);

        notifyObservers();


    }

    @Override
    public void registerObserver(ObserverLoteriaPrimitiva o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(ObserverLoteriaPrimitiva o) {
        int i = observers.indexOf(o);
        if(i>=0)
            observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        for (ObserverLoteriaPrimitiva observer : observers) {
            observer.updateNumeros(this.numbers);
        }
    }
}
