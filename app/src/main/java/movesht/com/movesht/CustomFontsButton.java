package movesht.com.movesht;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import movesht.com.movesht.util.FontsUtil;

public class CustomFontsButton extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {

    @Override
    public void onClick(View v) {
    }

    public CustomFontsButton(Context context) {
        super(context);
    }

    public CustomFontsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomFontsButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontView);
            int fontId = a.getInt(R.styleable.FontView_fontName, -1);
            if (fontId<0) {
                fontId = a.getInt(R.styleable.FontView_fontId, 1000);
            }
            Typeface myTypeface = FontsUtil.get(getContext(), fontId);
//            LogUtil.error("fontId="+fontId);
            setTypeface(myTypeface);
            a.recycle();
        } else {
            //set font by default
            setTypeface(FontsUtil.getDefaultFont(getContext()));
        }
    }

}
