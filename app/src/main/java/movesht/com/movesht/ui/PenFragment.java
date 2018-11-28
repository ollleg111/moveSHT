package movesht.com.movesht.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import net.yslibrary.android.keyboardvisibilityevent.Unregistrar;

import butterknife.BindView;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.BackEventInterface;
import movesht.com.movesht.util.LogUtil;

public class PenFragment extends BaseFragment implements BackEventInterface {

    @BindView(R.id.img_cancel)
    protected ImageView img_cancel;
    @BindView(R.id.btn_back)
    protected ImageView imgBack;
    @BindView(R.id.img_textSize)
    protected ImageView img_textSize;
    @BindView(R.id.btn_ok)
    protected ImageView img_ok;
    @BindView(R.id.ed_aboutMe)
    protected EditText edAboutMe;
    @BindView(R.id.img_color)
    protected ImageView img_color;
    @BindView(R.id.btn_textStyle)
    protected CustomFontsTextView btn_textStyle;
    @BindView(R.id.img_styleOne)
    protected ImageView img_styleOne;
    @BindView(R.id.img_styleTwo)
    protected ImageView img_styleTwo;
    @BindView(R.id.img_styleThree)
    protected ImageView img_styleThree;
    @BindView(R.id.img_styleFour)
    protected ImageView img_styleFour;
    @BindView(R.id.img_div)
    protected ImageView img_div;
    @BindView(R.id.btn_number)
    protected CustomFontsTextView btn_number;
    @BindView(R.id.img_add)
    protected ImageView img_add;
    @BindView(R.id.img_strokeOne)
    protected ImageView img_strokeOne;
    @BindView(R.id.img_strokeTwo)
    protected ImageView img_strokeTwo;
    @BindView(R.id.img_strokeThree)
    protected ImageView img_strokeThree;
    @BindView(R.id.img_strokeFour)
    protected ImageView img_strokeFour;

    Unregistrar mUnregistrar;
    Boolean keyStatus;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_styleOne.setOnClickListener(this);
        img_styleTwo.setOnClickListener(this);
        img_styleThree.setOnClickListener(this);
//        img_styleOne.getParent().requestDisallowInterceptTouchEvent(true);
//        img_styleTwo.getParent().getParent().requestDisallowInterceptTouchEvent(true);
        edAboutMe.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                LogUtil.info(this, "onLongClick");
                edAboutMe.setSelection(0,5);
//                edAboutMe.setSelected(true);
                return true;
            }
        });

        LogUtil.info(this, "OnViewCreated");
        img_cancel.setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mUnregistrar = KeyboardVisibilityEvent.registerEventListener(this.getAct(), new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                updateKeyboardStatusText(isOpen);
            }
        });

        updateKeyboardStatusText(KeyboardVisibilityEvent.isKeyboardVisible(this.getAct()));
    }

    private void updateKeyboardStatusText(boolean isOpen) {
        keyStatus=isOpen;
        String s = "false";
        if(isOpen){
            s="true";
        }
        LogUtil.info(this, s);
    }

    public static PenFragment newInstance() {
        PenFragment fragment = new PenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_pen;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }


    @Override
    public void onClick(View v) {
        LogUtil.info(this, "onClick");
        switch (v.getId()) {

            case R.id.img_cancel:
                onBack();
                break;
            case R.id.img_styleOne:
                Spannable text = new SpannableString(edAboutMe.getText());
                text.setSpan(new StyleSpan(Typeface.BOLD), edAboutMe.getSelectionStart(), edAboutMe.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                edAboutMe.setText(text);
                break;
            case R.id.img_styleTwo:
                Spannable text1 = new SpannableString(edAboutMe.getText());
                text1.setSpan(new StyleSpan(Typeface.ITALIC), edAboutMe.getSelectionStart(), edAboutMe.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                edAboutMe.setText(text1);
                break;
            case R.id.img_styleThree:
                Spannable text2 = new SpannableString(edAboutMe.getText());
                text2.setSpan(new UnderlineSpan(), edAboutMe.getSelectionStart(), edAboutMe.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                edAboutMe.setText(text2);
                break;
        }
    }

    @Override
    public void onBackEvent() {}

    @Override
    public boolean isEndingPressed() {
        if (keyStatus) {
            LogUtil.info(this, "onBack true");
        } else {
            LogUtil.info(this, "onBack false");
        }
        return true;
    }
}

