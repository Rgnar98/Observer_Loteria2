import java.util.List;

public interface SubjectLoteria{
    void registerObserver(ObserverLoteriaPrimitiva o);
    void removeObserver(ObserverLoteriaPrimitiva o);
    void notifyObservers();
}
