package cn.damai.baseview.abcpullrefresh.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import cn.damai.uikit.R$bool;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$dimen;
import cn.damai.uikit.R$integer;
import cn.damai.uikit.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ae2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SmoothProgressDrawable extends Drawable implements Animatable {
    private static transient /* synthetic */ IpChange $ipChange;
    private int[] A;
    private float[] B;
    private final Runnable C;
    private final Rect a;
    private Callbacks b;
    private Interpolator c;
    private Rect d;
    private Paint e;
    private int[] f;
    private int g;
    private boolean h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private float x;
    private Drawable y;
    private boolean z;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Callbacks {
        void onStart();

        void onStop();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class a {
        private static transient /* synthetic */ IpChange $ipChange;
        private Interpolator a;
        private int b;
        private int[] c;
        private float d;
        private float e;
        private float f;
        private boolean g;
        private boolean h;
        private float i;
        private int j;
        private boolean k;
        private boolean l;
        private boolean m;
        private Drawable n;
        private Callbacks o;

        public a(Context context) {
            g(context);
        }

        private void g(Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-148201447")) {
                ipChange.ipc$dispatch("-148201447", new Object[]{this, context});
                return;
            }
            Resources resources = context.getResources();
            this.a = new AccelerateInterpolator();
            this.b = resources.getInteger(R$integer.spb_default_sections_count);
            this.c = new int[]{resources.getColor(R$color.spb_default_color)};
            float parseFloat = Float.parseFloat(resources.getString(R$string.spb_default_speed));
            this.d = parseFloat;
            this.e = parseFloat;
            this.f = parseFloat;
            this.g = resources.getBoolean(R$bool.spb_default_reversed);
            this.j = resources.getDimensionPixelSize(R$dimen.spb_default_stroke_separator_length);
            this.i = resources.getDimensionPixelOffset(R$dimen.spb_default_stroke_width);
            this.k = resources.getBoolean(R$bool.spb_default_progressiveStart_activated);
            this.m = false;
        }

        public a a(Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-678451930")) {
                return (a) ipChange.ipc$dispatch("-678451930", new Object[]{this, drawable});
            }
            this.n = drawable;
            return this;
        }

        public SmoothProgressDrawable b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1955616095")) {
                return (SmoothProgressDrawable) ipChange.ipc$dispatch("1955616095", new Object[]{this});
            }
            if (this.l) {
                this.n = ae2.a(this.c, this.i);
            }
            return new SmoothProgressDrawable(this.a, this.b, this.j, this.c, this.i, this.d, this.e, this.f, this.g, this.h, this.o, this.k, this.n, this.m);
        }

        public a c(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "353344906")) {
                return (a) ipChange.ipc$dispatch("353344906", new Object[]{this, Integer.valueOf(i)});
            }
            this.c = new int[]{i};
            return this;
        }

        public a d(int[] iArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1843731508")) {
                return (a) ipChange.ipc$dispatch("-1843731508", new Object[]{this, iArr});
            }
            if (iArr != null && iArr.length != 0) {
                this.c = iArr;
                return this;
            }
            throw new IllegalArgumentException("Your color array must not be empty");
        }

        public a e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1671186139")) {
                return (a) ipChange.ipc$dispatch("-1671186139", new Object[]{this});
            }
            this.l = true;
            return this;
        }

        public a f(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1771160827")) {
                return (a) ipChange.ipc$dispatch("1771160827", new Object[]{this, Boolean.valueOf(z)});
            }
            this.m = z;
            return this;
        }

        public a h(Interpolator interpolator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1228825160")) {
                return (a) ipChange.ipc$dispatch("-1228825160", new Object[]{this, interpolator});
            }
            if (interpolator != null) {
                this.a = interpolator;
                return this;
            }
            throw new IllegalArgumentException("Interpolator can't be null");
        }

        public a i(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1017445538")) {
                return (a) ipChange.ipc$dispatch("1017445538", new Object[]{this, Boolean.valueOf(z)});
            }
            this.h = z;
            return this;
        }

        public a j(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "454671735")) {
                return (a) ipChange.ipc$dispatch("454671735", new Object[]{this, Boolean.valueOf(z)});
            }
            this.k = z;
            return this;
        }

        public a k(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-321028908")) {
                return (a) ipChange.ipc$dispatch("-321028908", new Object[]{this, Float.valueOf(f)});
            }
            if (f >= 0.0f) {
                this.e = f;
                return this;
            }
            throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
        }

        public a l(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-15250522")) {
                return (a) ipChange.ipc$dispatch("-15250522", new Object[]{this, Float.valueOf(f)});
            }
            if (f >= 0.0f) {
                this.f = f;
                return this;
            }
            throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
        }

        public a m(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1986525538")) {
                return (a) ipChange.ipc$dispatch("1986525538", new Object[]{this, Boolean.valueOf(z)});
            }
            this.g = z;
            return this;
        }

        public a n(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1159182120")) {
                return (a) ipChange.ipc$dispatch("1159182120", new Object[]{this, Integer.valueOf(i)});
            }
            if (i > 0) {
                this.b = i;
                return this;
            }
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }

        public a o(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-174863534")) {
                return (a) ipChange.ipc$dispatch("-174863534", new Object[]{this, Integer.valueOf(i)});
            }
            if (i >= 0) {
                this.j = i;
                return this;
            }
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }

        public a p(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1169916651")) {
                return (a) ipChange.ipc$dispatch("1169916651", new Object[]{this, Float.valueOf(f)});
            }
            if (f >= 0.0f) {
                this.d = f;
                return this;
            }
            throw new IllegalArgumentException("Speed must be >= 0");
        }

        public a q(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-80765742")) {
                return (a) ipChange.ipc$dispatch("-80765742", new Object[]{this, Float.valueOf(f)});
            }
            if (f >= 0.0f) {
                this.i = f;
                return this;
            }
            throw new IllegalArgumentException("The width must be >= 0");
        }
    }

    private void A(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484551799")) {
            ipChange.ipc$dispatch("-1484551799", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        k(i);
        this.i = 0.0f;
        this.t = false;
        this.j = 0.0f;
        this.v = 0;
        this.w = 0;
        this.g = i;
    }

    private void k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "858060826")) {
            ipChange.ipc$dispatch("858060826", new Object[]{this, Integer.valueOf(i)});
        } else if (i < 0 || i >= this.f.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", Integer.valueOf(i)));
        }
    }

    private int l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58478852")) {
            return ((Integer) ipChange.ipc$dispatch("-58478852", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = i - 1;
        return i2 < 0 ? this.f.length - 1 : i2;
    }

    private void m(Canvas canvas, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292378157")) {
            ipChange.ipc$dispatch("1292378157", new Object[]{this, canvas, Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        int save = canvas.save();
        canvas.clipRect(f, (int) ((canvas.getHeight() - this.x) / 2.0f), f2, (int) ((canvas.getHeight() + this.x) / 2.0f));
        this.y.draw(canvas);
        canvas.restoreToCount(save);
    }

    private void n(Canvas canvas, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649855745")) {
            ipChange.ipc$dispatch("-1649855745", new Object[]{this, canvas, Float.valueOf(f), Float.valueOf(f2)});
        } else if (this.y == null) {
        } else {
            this.a.top = (int) ((canvas.getHeight() - this.x) / 2.0f);
            this.a.bottom = (int) ((canvas.getHeight() + this.x) / 2.0f);
            Rect rect = this.a;
            rect.left = 0;
            rect.right = this.r ? canvas.getWidth() / 2 : canvas.getWidth();
            this.y.setBounds(this.a);
            if (!isRunning()) {
                if (this.r) {
                    canvas.save();
                    canvas.translate(canvas.getWidth() / 2, 0.0f);
                    m(canvas, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.a));
                    canvas.scale(-1.0f, 1.0f);
                    m(canvas, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.a));
                    canvas.restore();
                    return;
                }
                m(canvas, 0.0f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.a));
            } else if (u() || v()) {
                if (f > f2) {
                    f2 = f;
                    f = f2;
                }
                if (f > 0.0f) {
                    if (this.r) {
                        canvas.save();
                        canvas.translate(canvas.getWidth() / 2, 0.0f);
                        if (this.p) {
                            m(canvas, 0.0f, f);
                            canvas.scale(-1.0f, 1.0f);
                            m(canvas, 0.0f, f);
                        } else {
                            m(canvas, (canvas.getWidth() / 2) - f, canvas.getWidth() / 2);
                            canvas.scale(-1.0f, 1.0f);
                            m(canvas, (canvas.getWidth() / 2) - f, canvas.getWidth() / 2);
                        }
                        canvas.restore();
                    } else {
                        m(canvas, 0.0f, f);
                    }
                }
                if (f2 <= canvas.getWidth()) {
                    if (this.r) {
                        canvas.save();
                        canvas.translate(canvas.getWidth() / 2, 0.0f);
                        if (this.p) {
                            m(canvas, f2, canvas.getWidth() / 2);
                            canvas.scale(-1.0f, 1.0f);
                            m(canvas, f2, canvas.getWidth() / 2);
                        } else {
                            m(canvas, 0.0f, (canvas.getWidth() / 2) - f2);
                            canvas.scale(-1.0f, 1.0f);
                            m(canvas, 0.0f, (canvas.getWidth() / 2) - f2);
                        }
                        canvas.restore();
                        return;
                    }
                    m(canvas, f2, canvas.getWidth());
                }
            }
        }
    }

    private void o(Canvas canvas) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1808783919")) {
            ipChange.ipc$dispatch("1808783919", new Object[]{this, canvas});
            return;
        }
        float f = 1.0f / this.l;
        int i4 = this.g;
        float[] fArr = this.B;
        fArr[0] = 0.0f;
        fArr[fArr.length - 1] = 1.0f;
        int i5 = i4 - 1;
        if (i5 < 0) {
            i5 += this.f.length;
        }
        this.A[0] = this.f[i5];
        while (i3 < this.l) {
            float interpolation = this.c.getInterpolation((i3 * f) + this.i);
            i3++;
            this.B[i3] = interpolation;
            int[] iArr = this.A;
            int[] iArr2 = this.f;
            iArr[i3] = iArr2[i4];
            i4 = (i4 + 1) % iArr2.length;
        }
        int[] iArr3 = this.A;
        iArr3[iArr3.length - 1] = this.f[i4];
        if (this.p && this.r) {
            Rect rect = this.d;
            i = Math.abs(rect.left - rect.right) / 2;
        } else {
            i = this.d.left;
        }
        float f2 = i;
        if (!this.r) {
            i2 = this.d.right;
        } else if (this.p) {
            i2 = this.d.left;
        } else {
            Rect rect2 = this.d;
            i2 = Math.abs(rect2.left - rect2.right) / 2;
        }
        this.e.setShader(new LinearGradient(f2, this.d.centerY() - (this.x / 2.0f), i2, this.d.centerY() + (this.x / 2.0f), this.A, this.B, this.r ? Shader.TileMode.MIRROR : Shader.TileMode.CLAMP));
    }

    private void p(Canvas canvas, int i, float f, float f2, float f3, float f4, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1585884179")) {
            ipChange.ipc$dispatch("1585884179", new Object[]{this, canvas, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)});
            return;
        }
        this.e.setColor(this.f[i2]);
        if (!this.r) {
            canvas.drawLine(f, f2, f3, f4, this.e);
        } else if (this.p) {
            float f5 = i;
            canvas.drawLine(f5 + f, f2, f5 + f3, f4, this.e);
            canvas.drawLine(f5 - f, f2, f5 - f3, f4, this.e);
        } else {
            canvas.drawLine(f, f2, f3, f4, this.e);
            float f6 = i * 2;
            canvas.drawLine(f6 - f, f2, f6 - f3, f4, this.e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void q(android.graphics.Canvas r24) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.baseview.abcpullrefresh.smoothprogressbar.SmoothProgressDrawable.q(android.graphics.Canvas):void");
    }

    private int t(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453987936")) {
            return ((Integer) ipChange.ipc$dispatch("-1453987936", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = i + 1;
        if (i2 >= this.f.length) {
            return 0;
        }
        return i2;
    }

    public void B(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510585590")) {
            ipChange.ipc$dispatch("1510585590", new Object[]{this, drawable});
        } else if (this.y == drawable) {
        } else {
            this.y = drawable;
            invalidateSelf();
        }
    }

    public void C(Callbacks callbacks) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1304762996")) {
            ipChange.ipc$dispatch("-1304762996", new Object[]{this, callbacks});
        } else {
            this.b = callbacks;
        }
    }

    public void D(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387935322")) {
            ipChange.ipc$dispatch("387935322", new Object[]{this, Integer.valueOf(i)});
        } else {
            E(new int[]{i});
        }
    }

    public void E(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261878236")) {
            ipChange.ipc$dispatch("1261878236", new Object[]{this, iArr});
        } else if (iArr != null && iArr.length != 0) {
            this.g = 0;
            this.f = iArr;
            z();
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
    }

    public void F(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401172818")) {
            ipChange.ipc$dispatch("-1401172818", new Object[]{this, interpolator});
        } else if (interpolator != null) {
            this.c = interpolator;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
    }

    public void G(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-996983720")) {
            ipChange.ipc$dispatch("-996983720", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.r == z) {
        } else {
            this.r = z;
            invalidateSelf();
        }
    }

    public void H(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888261826")) {
            ipChange.ipc$dispatch("1888261826", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.u = z;
        }
    }

    public void I(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-878452700")) {
            ipChange.ipc$dispatch("-878452700", new Object[]{this, Float.valueOf(f)});
        } else if (f >= 0.0f) {
            this.n = f;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
    }

    public void J(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987030372")) {
            ipChange.ipc$dispatch("-987030372", new Object[]{this, Float.valueOf(f)});
        } else if (f >= 0.0f) {
            this.o = f;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
    }

    public void K(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-422269480")) {
            ipChange.ipc$dispatch("-422269480", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.p == z) {
        } else {
            this.p = z;
            invalidateSelf();
        }
    }

    public void L(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579840904")) {
            ipChange.ipc$dispatch("-579840904", new Object[]{this, Integer.valueOf(i)});
        } else if (i > 0) {
            this.l = i;
            float f = 1.0f / i;
            this.s = f;
            this.i %= f;
            z();
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
    }

    public void M(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673141218")) {
            ipChange.ipc$dispatch("1673141218", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= 0) {
            this.k = i;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
    }

    public void N(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059463163")) {
            ipChange.ipc$dispatch("1059463163", new Object[]{this, Float.valueOf(f)});
        } else if (f >= 0.0f) {
            this.m = f;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
    }

    public void O(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133216738")) {
            ipChange.ipc$dispatch("1133216738", new Object[]{this, Float.valueOf(f)});
        } else if (f >= 0.0f) {
            this.e.setStrokeWidth(f);
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
    }

    public void P(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736336658")) {
            ipChange.ipc$dispatch("1736336658", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.z == z) {
        } else {
            this.z = z;
            z();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187534303")) {
            ipChange.ipc$dispatch("1187534303", new Object[]{this, canvas});
            return;
        }
        Rect bounds = getBounds();
        this.d = bounds;
        canvas.clipRect(bounds);
        if (this.q) {
            this.g = l(this.g);
            this.q = false;
            if (u()) {
                int i = this.v + 1;
                this.v = i;
                if (i > this.l) {
                    stop();
                    return;
                }
            }
            int i2 = this.w;
            if (i2 < this.l) {
                this.w = i2 + 1;
            }
        }
        if (this.z) {
            o(canvas);
        }
        q(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445921208")) {
            return ((Integer) ipChange.ipc$dispatch("-1445921208", new Object[]{this})).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1776247983") ? ((Boolean) ipChange.ipc$dispatch("1776247983", new Object[]{this})).booleanValue() : this.h;
    }

    public int[] r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1564756918") ? (int[]) ipChange.ipc$dispatch("-1564756918", new Object[]{this}) : this.f;
    }

    public float s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1115254658") ? ((Float) ipChange.ipc$dispatch("1115254658", new Object[]{this})).floatValue() : this.x;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2021555521")) {
            ipChange.ipc$dispatch("-2021555521", new Object[]{this, runnable, Long.valueOf(j)});
            return;
        }
        this.h = true;
        super.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108324053")) {
            ipChange.ipc$dispatch("2108324053", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.e.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746536759")) {
            ipChange.ipc$dispatch("-746536759", new Object[]{this, colorFilter});
        } else {
            this.e.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1128853538")) {
            ipChange.ipc$dispatch("-1128853538", new Object[]{this});
            return;
        }
        if (this.u) {
            A(0);
        }
        if (isRunning()) {
            return;
        }
        Callbacks callbacks = this.b;
        if (callbacks != null) {
            callbacks.onStart();
        }
        scheduleSelf(this.C, SystemClock.uptimeMillis() + 16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084760776")) {
            ipChange.ipc$dispatch("1084760776", new Object[]{this});
        } else if (isRunning()) {
            Callbacks callbacks = this.b;
            if (callbacks != null) {
                callbacks.onStop();
            }
            this.h = false;
            unscheduleSelf(this.C);
        }
    }

    public boolean u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "201104575") ? ((Boolean) ipChange.ipc$dispatch("201104575", new Object[]{this})).booleanValue() : this.t;
    }

    public boolean v() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-930147708") ? ((Boolean) ipChange.ipc$dispatch("-930147708", new Object[]{this})).booleanValue() : this.w < this.l;
    }

    public void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101596563")) {
            ipChange.ipc$dispatch("1101596563", new Object[]{this});
        } else {
            x(0);
        }
    }

    public void x(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210215472")) {
            ipChange.ipc$dispatch("-210215472", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        A(i);
        start();
    }

    public void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "879616115")) {
            ipChange.ipc$dispatch("879616115", new Object[]{this});
            return;
        }
        this.t = true;
        this.v = 0;
    }

    protected void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-248219396")) {
            ipChange.ipc$dispatch("-248219396", new Object[]{this});
        } else if (this.z) {
            int i = this.l;
            this.A = new int[i + 2];
            this.B = new float[i + 2];
        } else {
            this.e.setShader(null);
            this.A = null;
            this.B = null;
        }
    }

    private SmoothProgressDrawable(Interpolator interpolator, int i, int i2, int[] iArr, float f, float f2, float f3, float f4, boolean z, boolean z2, Callbacks callbacks, boolean z3, Drawable drawable, boolean z4) {
        this.a = new Rect();
        this.C = new Runnable() { // from class: cn.damai.baseview.abcpullrefresh.smoothprogressbar.SmoothProgressDrawable.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-41246168")) {
                    ipChange.ipc$dispatch("-41246168", new Object[]{this});
                    return;
                }
                if (SmoothProgressDrawable.this.u()) {
                    SmoothProgressDrawable.this.j += SmoothProgressDrawable.this.o * 0.01f;
                    SmoothProgressDrawable.this.i += SmoothProgressDrawable.this.o * 0.01f;
                    if (SmoothProgressDrawable.this.j >= 1.0f) {
                        SmoothProgressDrawable.this.stop();
                    }
                } else if (SmoothProgressDrawable.this.v()) {
                    SmoothProgressDrawable.this.i += SmoothProgressDrawable.this.n * 0.01f;
                } else {
                    SmoothProgressDrawable.this.i += SmoothProgressDrawable.this.m * 0.01f;
                }
                if (SmoothProgressDrawable.this.i >= SmoothProgressDrawable.this.s) {
                    SmoothProgressDrawable.this.q = true;
                    SmoothProgressDrawable.this.i -= SmoothProgressDrawable.this.s;
                }
                if (SmoothProgressDrawable.this.isRunning()) {
                    SmoothProgressDrawable smoothProgressDrawable = SmoothProgressDrawable.this;
                    smoothProgressDrawable.scheduleSelf(smoothProgressDrawable.C, SystemClock.uptimeMillis() + 16);
                }
                SmoothProgressDrawable.this.invalidateSelf();
            }
        };
        this.h = false;
        this.c = interpolator;
        this.l = i;
        this.v = 0;
        this.w = i;
        this.k = i2;
        this.m = f2;
        this.n = f3;
        this.o = f4;
        this.p = z;
        this.f = iArr;
        this.g = 0;
        this.r = z2;
        this.t = false;
        this.y = drawable;
        this.x = f;
        this.s = 1.0f / i;
        Paint paint = new Paint();
        this.e = paint;
        paint.setStrokeWidth(f);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setDither(false);
        this.e.setAntiAlias(false);
        this.u = z3;
        this.b = callbacks;
        this.z = z4;
        z();
    }
}
