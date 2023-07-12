package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.responsive.R$styleable;
import com.alibaba.responsive.widget.size.OnResponsiveListener;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a32 {
    private View a;
    private int b;
    private int c = 6;
    private int d = 15;
    private String e;
    private int f;
    private int g;
    private OnResponsiveListener h;
    private x22 i;

    public a32(View view) {
        this.a = view;
    }

    private void a(Context context) {
        if (this.f == 0) {
            this.f = d32.a(context, this.c);
        }
        if (this.g == 0) {
            this.g = d32.a(context, this.d);
        }
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public void d(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.ResponsiveLayout, 0, 0);
            this.b = obtainStyledAttributes.getInt(R$styleable.ResponsiveLayout_layoutRatio, 0);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    public x22 e(int i, int i2) {
        if (this.i == null) {
            this.i = new x22();
        }
        int b = this.i.b();
        int d = this.i.d();
        this.i.a();
        x22 a = o41.a(d32.b(this.a), this.b, View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2), this.g, this.f, this.e, this.i);
        this.i = a;
        if (this.h != null && (d != a.d() || b != this.i.b())) {
            this.h.onResponsive(this.i);
        }
        return this.i;
    }

    public void f(int i) {
        this.f = i;
    }

    public void g(int i) {
        this.b = i;
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(OnResponsiveListener onResponsiveListener) {
        this.h = onResponsiveListener;
    }

    public void j(String str) {
        this.e = str;
    }
}
