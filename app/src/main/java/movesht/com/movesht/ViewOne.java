package movesht.com.movesht;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Admin on 10.03.2017.
 */

public class ViewOne extends LinearLayout{

    @BindView(R.id.tv_home)
    protected TextView tvHome;
    @BindView(R.id.btn_one)
    protected TextView btnOne;
    @BindView(R.id.btn_two)
    protected TextView btnTwo;
    @BindView(R.id.btn_three)
    protected TextView btnThree;

    public ViewOne(Context context) {
        super(context);
    }

    public ViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
