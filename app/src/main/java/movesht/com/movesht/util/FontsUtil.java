package movesht.com.movesht.util;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

public class FontsUtil {
    private static final String TAG = FontsUtil.class.getSimpleName();
    private static final Hashtable<Font, Typeface> cache = new Hashtable<>();


    /* @"Audiowide-Regular",
     @"Coustard-Regular",
     @"Coustard-Black",
     @"FjallaOne-Regular",
     @"JockeyOne-Regular",
     @"Judson-Bold",
     @"Lato-Regular",
     @"Monoton-Regular",
     @"MontserratAlternates-Regular",
     @"Orbitron-Medium",
     @"Oswald-Regular",
     @"Quantico-Regular",
     @"Raleway-Bold",
     @"Raleway-BoldItalic",
     @"Righteous-Regular",
     @"Rubik-Black",
     @"RussoOne-Regular",
     @"OstrichSans-Bold",
     @"OstrichSans-Medium"*/
    public enum Font {
        ArimoBold(1, "Arimo-Bold_0", "Arimo-Bold_0"),
        ArimoBoldItalic(2, "Arimo-BoldItalic_0", "Arimo-BoldItalic_0"),
        ArimoItalic(3, "Arimo-Italic_0", "Arimo-Italic_0"),
        BebasNeueBold(4, "BebasNeueBold", "BebasNeueBold"),
        BebasNeueBook(5,"BebasNeueBook", "BebasNeueBook"),
        BebasNeueLight(6, "BebasNeueLight", "BebasNeueLight"),
        BebasNeueRegular(8, "BebasNeueRegular", "BebasNeueRegular"),
        BebasNeueThin(9, "BebasNeueThin", "BebasNeueThin"),

        ArimoRegular(1000, "Arimo-Regular_0", "Arimo-Regular_0");

        private final int id;
        private final String fontName;
        private final String fontAssets;

        Font(final int id, String fontName, String fontAssets) {
            this.id = id;
            this.fontName = fontName;
            this.fontAssets = fontAssets;
        }

        public String getFontName() {
            return fontName;
        }

        public String getFontAssets() {
            return fontAssets;
        }

        public int getId() {
            return id;
        }

        public static Font getFontById(int id) {
            for (Font currFont : values()) {
                if (currFont.getId() == id) {
                    return currFont;
                }
            }
            return ArimoRegular;
        }
    }

    public static Typeface getDefaultFont(Context c) {
        return get(c, Font.ArimoRegular);
    }


    public static Typeface get(Context c, Font font) {
        synchronized (cache) {
            if (!cache.containsKey(font)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), font.getFontAssets());
                    cache.put(font, t);
                } catch (Exception e) {
                    return null;
                }
            }
            return cache.get(font);
        }
    }

    public static Typeface get(Context c, int id) {
        Font font = Font.getFontById(id);
        synchronized (cache) {
            if (!cache.containsKey(font)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), font.getFontAssets()+".ttf");
                    cache.put(font, t);
                } catch (Exception e) {
                    return null;
                }
            }
            return cache.get(font);
        }
    }
}
