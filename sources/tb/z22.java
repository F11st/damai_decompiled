package tb;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.pictures.responsive.R$styleable;
import com.alibaba.pictures.responsive.size.OnResponsiveListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class z22 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C10010a Companion = new C10010a(null);
    @NotNull
    private final View a;
    private int b;
    private final int c;
    private final int d;
    @Nullable
    private String e;
    private int f;
    private int g;
    @Nullable
    private OnResponsiveListener h;
    @Nullable
    private y22 i;

    /* compiled from: Taobao */
    /* renamed from: tb.z22$a */
    /* loaded from: classes7.dex */
    public static final class C10010a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C10010a() {
        }

        public /* synthetic */ C10010a(k50 k50Var) {
            this();
        }
    }

    public z22(@NotNull View view) {
        b41.i(view, "view");
        this.a = view;
        this.c = 6;
        this.d = 15;
    }

    private final void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1825118825")) {
            ipChange.ipc$dispatch("-1825118825", new Object[]{this, context});
            return;
        }
        if (this.f == 0) {
            this.f = e32.a(context, this.c);
        }
        if (this.g == 0) {
            this.g = e32.a(context, this.d);
        }
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "811662680") ? ((Integer) ipChange.ipc$dispatch("811662680", new Object[]{this})).intValue() : this.f;
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2048069256") ? ((Integer) ipChange.ipc$dispatch("-2048069256", new Object[]{this})).intValue() : this.g;
    }

    public final void d(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379498426")) {
            ipChange.ipc$dispatch("-379498426", new Object[]{this, context, attributeSet});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.OneResponsiveLayout, 0, 0);
            b41.h(obtainStyledAttributes, "context.theme.obtainStyl…neResponsiveLayout, 0, 0)");
            this.b = obtainStyledAttributes.getInt(R$styleable.OneResponsiveLayout_rc, 0);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    @NotNull
    public final y22 e(int i, int i2) {
        OnResponsiveListener onResponsiveListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "788773690")) {
            return (y22) ipChange.ipc$dispatch("788773690", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (this.i == null) {
            this.i = new y22();
        }
        y22 y22Var = this.i;
        if (y22Var != null) {
            int b = y22Var.b();
            int d = y22Var.d();
            y22 y22Var2 = this.i;
            if (y22Var2 != null) {
                y22Var2.a();
            }
            y22 a = n41.INSTANCE.a(e32.c(this.a), this.b, View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2), c(), b(), this.e, this.i);
            if ((d != a.d() || b != a.b()) && (onResponsiveListener = this.h) != null) {
                onResponsiveListener.onResponsive(a);
            }
            wt2 wt2Var = wt2.INSTANCE;
            this.i = a;
        }
        y22 y22Var3 = this.i;
        b41.f(y22Var3);
        return y22Var3;
    }

    public final void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696810678")) {
            ipChange.ipc$dispatch("-696810678", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.f = i;
        }
    }

    public final void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340602335")) {
            ipChange.ipc$dispatch("-340602335", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    public final void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1708523562")) {
            ipChange.ipc$dispatch("1708523562", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.g = i;
        }
    }

    public final void i(@Nullable OnResponsiveListener onResponsiveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599397842")) {
            ipChange.ipc$dispatch("-1599397842", new Object[]{this, onResponsiveListener});
        } else {
            this.h = onResponsiveListener;
        }
    }

    public final void j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934754782")) {
            ipChange.ipc$dispatch("-934754782", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }
}
