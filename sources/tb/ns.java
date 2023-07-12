package tb;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ns extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_ROUND = 1;
    private Paint a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private int[] m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private RectF r;

    /* compiled from: Taobao */
    /* renamed from: tb.ns$b */
    /* loaded from: classes8.dex */
    public static class C9481b {
        private static transient /* synthetic */ IpChange $ipChange;
        private int e;
        private int f;
        private int[] g;
        private int a = 1;
        private int b = 12;
        private int c = Color.parseColor("#4d000000");
        private int d = 18;
        private boolean h = false;
        private boolean j = false;
        private boolean k = false;
        private boolean i = false;
        private int l = -1;
        private int m = -1;

        public C9481b() {
            this.e = 0;
            this.f = 0;
            this.e = 0;
            this.f = 0;
            this.g = r1;
            int[] iArr = {0};
        }

        public ns a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1140439682") ? (ns) ipChange.ipc$dispatch("1140439682", new Object[]{this}) : new ns(this.a, this.g, this.b, this.c, this.d, this.e, this.f, this.j, this.i, this.k, this.h, this.m, this.l);
        }

        public C9481b b(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-223377797")) {
                return (C9481b) ipChange.ipc$dispatch("-223377797", new Object[]{this, Integer.valueOf(i)});
            }
            this.g[0] = i;
            return this;
        }

        public C9481b c(int[] iArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "944433640")) {
                return (C9481b) ipChange.ipc$dispatch("944433640", new Object[]{this, iArr});
            }
            this.g = iArr;
            return this;
        }

        public C9481b d(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1909133396")) {
                return (C9481b) ipChange.ipc$dispatch("1909133396", new Object[]{this, Integer.valueOf(i)});
            }
            this.e = i;
            return this;
        }

        public C9481b e(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-21485709")) {
                return (C9481b) ipChange.ipc$dispatch("-21485709", new Object[]{this, Integer.valueOf(i)});
            }
            this.f = i;
            return this;
        }

        public C9481b f(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "26640278")) {
                return (C9481b) ipChange.ipc$dispatch("26640278", new Object[]{this, Integer.valueOf(i)});
            }
            this.c = i;
            return this;
        }

        public C9481b g(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "932663853")) {
                return (C9481b) ipChange.ipc$dispatch("932663853", new Object[]{this, Integer.valueOf(i)});
            }
            this.d = i;
            return this;
        }

        public C9481b h(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-488094312")) {
                return (C9481b) ipChange.ipc$dispatch("-488094312", new Object[]{this, Integer.valueOf(i)});
            }
            this.a = i;
            return this;
        }

        public C9481b i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1099985882")) {
                return (C9481b) ipChange.ipc$dispatch("-1099985882", new Object[]{this, Integer.valueOf(i)});
            }
            this.b = i;
            return this;
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592344510")) {
            ipChange.ipc$dispatch("-592344510", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        ns a = new C9481b().i(i).f(i2).g(i3).d(i4).e(i5).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a);
    }

    public static void b(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1182781183")) {
            ipChange.ipc$dispatch("-1182781183", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
            return;
        }
        ns a = new C9481b().b(i).i(i2).f(i3).g(i4).d(i5).e(i6).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a);
    }

    public static void c(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988518434")) {
            ipChange.ipc$dispatch("1988518434", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
            return;
        }
        ns a = new C9481b().h(i).b(i2).i(i3).f(i4).g(i5).d(i6).e(i7).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a);
    }

    public static void d(View view, int[] iArr, int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480890828")) {
            ipChange.ipc$dispatch("-480890828", new Object[]{view, iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        ns a = new C9481b().c(iArr).i(i).f(i2).g(i3).d(i4).e(i5).a();
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, a);
    }

    private void e(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-508305213")) {
            ipChange.ipc$dispatch("-508305213", new Object[]{this, rectF});
            return;
        }
        int[] iArr = this.m;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.b.setColor(iArr[0]);
            } else {
                this.b.setShader(new LinearGradient(rectF.left, rectF.height() / 2.0f, rectF.right, rectF.height() / 2.0f, this.m, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        this.h = rectF.centerX();
        this.i = rectF.centerY();
        this.j = Math.min(rectF.width(), rectF.height()) / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898026192")) {
            ipChange.ipc$dispatch("1898026192", new Object[]{this, canvas});
        } else if (this.f == 1) {
            RectF rectF = this.r;
            int i = this.g;
            canvas.drawRoundRect(rectF, i, i, this.a);
            RectF rectF2 = this.r;
            int i2 = this.g;
            canvas.drawRoundRect(rectF2, i2, i2, this.b);
        } else {
            canvas.drawCircle(this.h, this.i, this.j, this.a);
            canvas.drawCircle(this.h, this.i, this.j, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334981897")) {
            return ((Integer) ipChange.ipc$dispatch("-1334981897", new Object[]{this})).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-520496570")) {
            ipChange.ipc$dispatch("-520496570", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130196966")) {
            ipChange.ipc$dispatch("-130196966", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.setBounds(i, i2, i3, i4);
        if (this.e < 0) {
            this.e = this.c;
        }
        if (this.d < 0) {
            this.d = this.c;
        }
        if (!this.p) {
            i = (i + this.e) - this.k;
        }
        if (!this.o) {
            i2 = (i2 + this.d) - this.l;
        }
        if (!this.q) {
            i3 = (i3 - this.e) - this.k;
        }
        if (!this.n) {
            i4 = (i4 - this.d) - this.l;
        }
        RectF rectF = new RectF(i, i2, i3, i4);
        this.r = rectF;
        e(rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "974496184")) {
            ipChange.ipc$dispatch("974496184", new Object[]{this, colorFilter});
        } else {
            this.a.setColorFilter(colorFilter);
        }
    }

    private ns(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2, boolean z3, boolean z4, int i7, int i8) {
        this.f = i;
        this.m = iArr;
        this.g = i2;
        this.c = i4;
        this.k = i5;
        this.l = i6;
        this.n = z4;
        this.p = z;
        this.q = z3;
        this.o = z2;
        this.e = i7;
        this.d = i8;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(0);
        this.a.setAntiAlias(true);
        this.a.setShadowLayer(i4, i5, i6, i3);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.r = new RectF();
    }
}
