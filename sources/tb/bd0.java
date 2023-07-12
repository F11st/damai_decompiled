package tb;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bd0 {
    public static final int[] STATE_CHECKED = {16842912};

    public static StateListDrawable a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912, -16842910}, drawable3);
        stateListDrawable.addState(new int[]{-16842912, -16842910}, drawable4);
        stateListDrawable.addState(new int[]{16842912}, drawable);
        stateListDrawable.addState(new int[]{-16842912}, drawable2);
        return stateListDrawable;
    }

    public static StateListDrawable b(Drawable drawable, Drawable drawable2, int[] iArr) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(iArr, drawable);
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static GradientDrawable c(int i, int i2, int i3, int i4, int i5, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(i, i2);
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setColor(i4);
        gradientDrawable.setSize(i5, i6);
        return gradientDrawable;
    }
}
