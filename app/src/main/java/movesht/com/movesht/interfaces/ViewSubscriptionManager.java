package movesht.com.movesht.interfaces;

import android.view.View;

public interface ViewSubscriptionManager extends SubscriptionManager{
    View.OnClickListener onClickListener();
    View getRootView();
}