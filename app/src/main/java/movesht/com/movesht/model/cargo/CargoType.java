package movesht.com.movesht.model.cargo;

import java.util.List;

import movesht.com.movesht.model.Image;

/**
 * Created by Admin on 30.03.2017.
 */

public class CargoType {
    private Image image;
    private String name;
    private String url_hdpi;
    private String url_mdpi;
    private String url_xhdpi;
    private String url_xxhdpi;
    private String url_xxxhdpi;
    private List<PodTypeCargo> mListExtra;

    public CargoType() {
    }

    public CargoType(Image image, String name) {
        this.image = image;
        this.name = name;
    }

    public CargoType(Image image, String name, List<PodTypeCargo> listExtra) {
        this.image = image;
        this.name = name;
        mListExtra = listExtra;
    }

    public String getUrl_hdpi() {
        return url_hdpi;
    }

    public void setUrl_hdpi(String url_hdpi) {
        this.url_hdpi = url_hdpi;
    }

    public String getUrl_mdpi() {
        return url_mdpi;
    }

    public void setUrl_mdpi(String url_mdpi) {
        this.url_mdpi = url_mdpi;
    }

    public String getUrl_xhdpi() {
        return url_xhdpi;
    }

    public void setUrl_xhdpi(String url_xhdpi) {
        this.url_xhdpi = url_xhdpi;
    }

    public String getUrl_xxhdpi() {
        return url_xxhdpi;
    }

    public void setUrl_xxhdpi(String url_xxhdpi) {
        this.url_xxhdpi = url_xxhdpi;
    }

    public String getUrl_xxxhdpi() {
        return url_xxxhdpi;
    }

    public void setUrl_xxxhdpi(String url_xxxhdpi) {
        this.url_xxxhdpi = url_xxxhdpi;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PodTypeCargo> getListExtra() {
        return mListExtra;
    }

    public void setListExtra(List<PodTypeCargo> listExtra) {
        mListExtra = listExtra;
    }

    public List<PodTypeCargo> getmListExtra() {

        return mListExtra;
    }

    public void setmListExtra(List<PodTypeCargo> mListExtra) {
        this.mListExtra = mListExtra;
    }

}