package tb;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.taobao.monitor.impl.data.calculator.ICalculator;
import com.taobao.monitor.procedure.ViewToken;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ig implements ICalculator {
    private final View a;
    private View b;
    private View c;
    private final HashSet<Drawable> d = new HashSet<>();
    private boolean e = false;
    private boolean f = false;

    public ig(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    private float a(View view, List<dy2> list, View view2) {
        View view3;
        if (ey2.a(view, view2)) {
            if (view.getHeight() < ry2.screenHeight / 20) {
                return 1.0f;
            }
            if (view instanceof ViewStub) {
                return 0.0f;
            }
            if (ey2.i(view, view2)) {
                this.b = view;
                this.f = true;
                return 0.0f;
            } else if (ey2.h(view, view2)) {
                this.c = view;
                return 0.0f;
            } else {
                Object tag = view.getTag(ViewToken.APM_VIEW_TOKEN);
                if (tag instanceof String) {
                    if (ViewToken.APM_VIEW_VALID.equals(tag)) {
                        return 1.0f;
                    }
                    if (ViewToken.APM_VIEW_IGNORE.equals(tag) || ViewToken.APM_VIEW_INVALID.equals(tag)) {
                        return 0.0f;
                    }
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (ey2.l(viewGroup)) {
                        return ey2.m(viewGroup) ? 1.0f : 0.0f;
                    }
                    View[] c = ry2.c(viewGroup);
                    int length = c.length;
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < length && (view3 = c[i3]) != null; i3++) {
                        i++;
                        ArrayList arrayList = new ArrayList();
                        if (a(view3, arrayList, view2) > 0.8f) {
                            i2++;
                            list.add(dy2.a(view3, view2));
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((dy2) it.next()).c();
                            }
                        } else {
                            list.addAll(arrayList);
                        }
                    }
                    if (view.getHeight() >= ry2.screenHeight / 8 || !(((viewGroup instanceof LinearLayout) || (viewGroup instanceof RelativeLayout)) && i == i2 && i != 0)) {
                        float a = new c91(d80.a(30)).a(viewGroup, list, view2);
                        if (a > 0.8f) {
                            return 1.0f;
                        }
                        return a;
                    }
                    return 1.0f;
                }
                boolean[] zArr = new boolean[1];
                float f = ey2.k(view, true, this.d, zArr) ? 1.0f : 0.0f;
                this.e = zArr[0];
                return f;
            }
        }
        return 0.0f;
    }

    @Override // com.taobao.monitor.impl.data.calculator.ICalculator
    public ff calculate() {
        ArrayList arrayList = new ArrayList();
        float a = a(this.a, arrayList, this.b);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((dy2) it.next()).c();
        }
        this.d.clear();
        return new ff(ig.class, a, this.e, this.c, this.f ? this.b : null);
    }
}
