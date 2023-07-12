package tb;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ky2 {
    public static String a(View view) {
        if (view != null) {
            return "" + view.hashCode();
        }
        throw new IllegalArgumentException();
    }

    public static String b(View view, View view2) {
        if (view2 != null && view != null) {
            int[] b = ry2.b(view2, view);
            int max = Math.max(0, b[0]);
            int min = Math.min(ry2.screenWidth, b[0] + view2.getWidth());
            int max2 = Math.max(0, b[1]);
            int min2 = Math.min(ry2.screenHeight, b[1] + view2.getHeight());
            return JSMethod.NOT_SET + max2 + JSMethod.NOT_SET + min + JSMethod.NOT_SET + min2 + JSMethod.NOT_SET + max;
        }
        throw new IllegalArgumentException();
    }

    public static String c(View view, View view2) {
        if (view2 != null && view != null) {
            StringBuilder sb = new StringBuilder();
            while (view2 != null && view2 != view) {
                sb.append(view2.getClass().getSimpleName());
                if (!(view2.getParent() instanceof View)) {
                    break;
                }
                view2 = (View) view2.getParent();
            }
            return sb.toString();
        }
        throw new IllegalArgumentException();
    }

    public static String d(View view) {
        if (view != null) {
            return g(view);
        }
        throw new IllegalArgumentException();
    }

    public static String e(View view) {
        if (view != null) {
            return view.getClass().getSimpleName();
        }
        throw new IllegalArgumentException();
    }

    private static boolean f(Drawable drawable) {
        return (drawable == null || drawable.getClass().getSimpleName().equals("BorderDrawable") || (drawable instanceof ColorDrawable)) ? false : true;
    }

    private static String g(View view) {
        StringBuilder sb = new StringBuilder();
        Drawable background = view.getBackground();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && (background instanceof DrawableWrapper)) {
            background = ((DrawableWrapper) background).getDrawable();
        }
        if (f(background)) {
            sb.append(background.getClass().getSimpleName());
        }
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (i >= 23 && (drawable instanceof DrawableWrapper)) {
                drawable = ((DrawableWrapper) drawable).getDrawable();
            }
            if (f(drawable)) {
                sb.append(drawable.getClass().getSimpleName());
            }
        }
        return sb.toString();
    }
}
