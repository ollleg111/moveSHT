package movesht.com.movesht.model;

import movesht.com.movesht.R;

/**
 * Created by owner on 31.03.17.
 */

public class Image {
    private int resId = R.drawable.ic_animals_black;
    private String url;

    public Image(int resId) {
        this.resId = resId;
    }

    public Image(String url) {
        this.url = url;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
