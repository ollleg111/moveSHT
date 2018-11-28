package movesht.com.movesht.interfaces;

import rx.Subscription;

public interface SubscriptionManager {
    void createSubscripion();
    void addSubscription(Subscription subscription);
    void unsubscribe(Subscription subscription);
    void unsubscribeAndDestroy();
}
