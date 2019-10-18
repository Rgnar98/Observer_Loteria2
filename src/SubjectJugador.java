public interface SubjectJugador {
    void registerObserver(ObserverJugador o);
    void removeObserver(ObserverJugador o);
    void notifyObservers();
}
