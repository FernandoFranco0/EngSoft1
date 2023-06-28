package StrategyObserver.Observer;

public interface Subject {
	public String registerObserver(ObserverBehavior o);
	public void removeObserver(ObserverBehavior o);
	public void notifyObservers();
}
