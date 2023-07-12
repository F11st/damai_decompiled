package tb;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PictureDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.monitor.procedure.ViewToken;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ey2 {
    private final View a;
    private View b;
    private View c;
    private final HashSet<Drawable> d = new HashSet<>();
    private boolean e = false;

    public ey2(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    public static boolean a(View view, View view2) {
        return ry2.d(view, view2) && view.getVisibility() == 0;
    }

    private void d(View view, View view2, List<dy2> list, List<dy2> list2) {
        View[] c;
        if (a(view, view2)) {
            if (i(view, view2)) {
                this.b = view;
            } else if (h(view, view2)) {
                this.c = view;
            } else {
                Object tag = view.getTag(ViewToken.APM_VIEW_TOKEN);
                if (tag instanceof String) {
                    if (ViewToken.APM_VIEW_IGNORE.equals(tag)) {
                        return;
                    }
                    if (ViewToken.APM_VIEW_VALID.equals(tag)) {
                        o(list, dy2.b(view, view2));
                        return;
                    } else if (ViewToken.APM_VIEW_INVALID.equals(tag)) {
                        o(list2, dy2.b(view, view2));
                        return;
                    }
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (l(viewGroup) && m(viewGroup)) {
                        o(list, dy2.b(view, view2));
                        return;
                    }
                    for (View view3 : ry2.c(viewGroup)) {
                        if (view3 == null) {
                            return;
                        }
                        d(view3, view2, list, list2);
                    }
                    return;
                }
                boolean[] zArr = new boolean[1];
                if (k(view, false, this.d, zArr)) {
                    o(list, dy2.b(view, view2));
                }
                this.e = zArr[0];
            }
        }
    }

    public static boolean h(View view, View view2) {
        if (jd0.u) {
            if (Boolean.TRUE.equals(view.getTag(ViewToken.VIEW_MANUAL_CALCULATE))) {
                return ry2.e(view, view2, 0.7f);
            }
            return false;
        }
        return false;
    }

    public static boolean i(View view, View view2) {
        return Boolean.TRUE.equals(view.getTag(ViewToken.APM_PAGE_ROOT_VIEW)) && view2 != view;
    }

    public static boolean j(Drawable drawable) {
        return (drawable instanceof BitmapDrawable) || (drawable instanceof NinePatchDrawable) || (drawable instanceof AnimationDrawable) || (drawable instanceof ShapeDrawable) || (drawable instanceof PictureDrawable);
    }

    public static boolean k(View view, boolean z, HashSet<Drawable> hashSet, boolean[] zArr) {
        if (zArr == null) {
            zArr = new boolean[1];
        }
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && (drawable instanceof DrawableWrapper)) {
                drawable = ((DrawableWrapper) drawable).getDrawable();
            }
            if (j(drawable) && !hashSet.contains(drawable)) {
                hashSet.add(drawable);
                return true;
            }
            Drawable background = view.getBackground();
            if (i >= 23 && !z && (background instanceof DrawableWrapper)) {
                background = ((DrawableWrapper) background).getDrawable();
            }
            if (!j(background) || hashSet.contains(background)) {
                return false;
            }
            hashSet.add(background);
            return true;
        } else if (view instanceof TextView) {
            if (view instanceof EditText) {
                zArr[0] = view.isFocusable();
                return true;
            } else if (z || !(view instanceof Button)) {
                return !TextUtils.isEmpty(((TextView) view).getText().toString());
            } else {
                return true;
            }
        } else if (z || !"com.taobao.android.dinamicx.view.DXNativeFastText".equals(view.getClass().getName())) {
            return z;
        } else {
            return true;
        }
    }

    public static boolean l(ViewGroup viewGroup) {
        return (viewGroup instanceof WebView) || k13.INSTANCE.isWebView(viewGroup);
    }

    public static boolean m(ViewGroup viewGroup) {
        if (viewGroup instanceof WebView) {
            return i60.INSTANCE.webViewProgress((WebView) viewGroup) == 100;
        }
        k13 k13Var = k13.INSTANCE;
        return k13Var.isWebView(viewGroup) && k13Var.webViewProgress(viewGroup) == 100;
    }

    private void o(List<dy2> list, dy2 dy2Var) {
        if (list != null) {
            list.add(dy2Var);
        }
    }

    public void b(List<dy2> list, List<dy2> list2) {
        this.d.clear();
        this.e = false;
        d(this.a, this.b, list, list2);
    }

    public List<dy2> c() {
        this.d.clear();
        this.e = false;
        ArrayList arrayList = new ArrayList();
        d(this.a, this.b, arrayList, null);
        return arrayList;
    }

    public View e() {
        return this.c;
    }

    public View f() {
        return this.b;
    }

    public boolean g() {
        return this.e;
    }

    public void n() {
        this.d.clear();
    }
}
