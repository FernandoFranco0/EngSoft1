package StrategyObserver.Observer;

public interface Subject {
	public void registerObserver(ObserverBehavior o);
	public void removeObserver(ObserverBehavior o);
	public void notifyObservers();
}
