package controller;

public interface ISubject {
     void registerObserver(IObserver observer);
     void removeObserver(IObserver observer,int index);
     void notifiyObserver();
}
