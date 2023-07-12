package tb;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.alibaba.android.ultron.vfw.R$id;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ny2 {
    public static final int DINAMICX_3_CUSTOM_INPUT_KEY = R$id.dinamic_x_3_view_params_key;

    public static View a(Context context) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, 0));
        view.setTag(R$id.TAG_ULTRON_VIEW_ZERO_HEIGHT, "ZeroHeightView");
        return view;
    }

    public static GradientDrawable b(@ColorInt int i, float f, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f2, f2, f2, f2});
        return gradientDrawable;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return context.getResources().getConfiguration().orientation == 1 ? com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) : com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }
}
