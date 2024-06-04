package socialDistanceShopSampleSolution;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * class to keep track of people inside and outside and left shop
 *@author Prof. M.Kuttel
 *@author Sihle Calana
 */
public class PeopleCounter {
	private AtomicInteger peopleOutSide; //counter for people arrived but not yet in the building
	private AtomicInteger peopleInside; //people inside the shop
	private AtomicInteger peopleLeft; //people left the shop
	private final int maxPeople; //maximum for lockdown rules

	/**
	 * Creates a counter of the people waiting the store,
	 * inside the store and those who have left.
	 * @param max
	 */
	PeopleCounter(int max) {
		peopleOutSide = new AtomicInteger(0);
		peopleInside = new AtomicInteger(0);
		peopleLeft = new AtomicInteger(0);
		maxPeople = max;
	}

	/**
	 * returns a count of those in the queue to get in
	 * @return int
	 */
	public int getWaiting() {
		return peopleOutSide.get();
	}

	/**
	 * returns a count of those shopping inside the store
	 * @return int
	 */
	public int getInside() {
		return peopleInside.get();
	}
	
	//getter
	public int getTotal() {
		return (getWaiting()+getInside()+getLeft());
	}

	/**
	 * Count of those who have left
	 * @return int
	 */
	public int getLeft() {
		return peopleLeft.get();
	}

	/**
	 * Maximum number of people allowed inside
	 * @return int
	 */
	public int getMax() {
		return maxPeople;
	}

	/**
	 * adds 1 to the number of people who have arrived
	 * outside the store
	 */
	public void personArrived() {
		peopleOutSide.incrementAndGet();
	}

	/**
	 * update counters for a person entering the shop
	 */
	public void personEntered(){
		peopleOutSide.decrementAndGet();
		peopleInside.incrementAndGet();
	}

	/**
	 * update counters for a person exiting the shop
	 */
	public void personLeft(){
		peopleInside.decrementAndGet();
		peopleLeft.incrementAndGet();
	}

	/**
	 * resets counters
	 */
	synchronized public void resetScore() {
		peopleInside.getAndSet(0);
		peopleOutSide.getAndSet(0);
		peopleLeft.getAndSet(0);
	}
}
