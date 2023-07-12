package com.youku.css.setter;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.youku.css.R;
import com.youku.css.dto.Css;
import com.youku.css.util.ColorUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ImageViewCssSetter {
    ImageViewCssSetter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resetCss(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        CssSetter.resetColor(imageView, R.id.tag_css_color);
        imageView.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCss(ImageView imageView, Css css) {
        if (imageView == null || css == null) {
            return;
        }
        int parseColorSafely = ColorUtil.parseColorSafely(css.color);
        if (parseColorSafely != 0) {
            CssSetter.saveColor(imageView, R.id.tag_css_color, parseColorSafely);
            imageView.setColorFilter(parseColorSafely, PorterDuff.Mode.SRC_IN);
            return;
        }
        resetCss(imageView);
    }
}
