package com.caverock.androidsvg;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.youku.arch.v3.data.Constants;
import com.youku.css.constraint.CssConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.caverock.androidsvg.e */
/* loaded from: classes10.dex */
public class C4749e {
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static HashSet<String> j;
    private Canvas a;
    private float b;
    private SVG c;
    private C4757h d;
    private Stack<C4757h> e;
    private Stack<SVG.SvgContainer> f;
    private Stack<Matrix> g;
    private CSSParser.C4687l h = null;
    int i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$a */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C4750a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            c = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            b = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            a = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$b */
    /* loaded from: classes10.dex */
    public class C4751b implements SVG.PathInterface {
        private float b;
        private float c;
        private boolean h;
        private List<C4752c> a = new ArrayList();
        private C4752c d = null;
        private boolean e = false;
        private boolean f = true;
        private int g = -1;

        C4751b(SVG.C4721p c4721p) {
            if (c4721p == null) {
                return;
            }
            c4721p.c(this);
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            C4752c c4752c = this.d;
            if (c4752c != null) {
                this.a.add(c4752c);
            }
        }

        List<C4752c> a() {
            return this.a;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.e = true;
            this.f = false;
            C4752c c4752c = this.d;
            C4749e.m(c4752c.a, c4752c.b, f, f2, f3, z, z2, f4, f5, this);
            this.f = true;
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.a.add(this.d);
            lineTo(this.b, this.c);
            this.h = true;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            if (this.f || this.e) {
                this.d.a(f, f2);
                this.a.add(this.d);
                this.e = false;
            }
            this.d = new C4752c(C4749e.this, f5, f6, f5 - f3, f6 - f4);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.d.a(f, f2);
            this.a.add(this.d);
            C4749e c4749e = C4749e.this;
            C4752c c4752c = this.d;
            this.d = new C4752c(c4749e, f, f2, f - c4752c.a, f2 - c4752c.b);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            C4752c c4752c = this.d;
            if (c4752c != null) {
                this.a.add(c4752c);
            }
            this.b = f;
            this.c = f2;
            this.d = new C4752c(C4749e.this, f, f2, 0.0f, 0.0f);
            this.g = this.a.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.d.a(f, f2);
            this.a.add(this.d);
            this.d = new C4752c(C4749e.this, f3, f4, f3 - f, f4 - f2);
            this.h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$c */
    /* loaded from: classes10.dex */
    public class C4752c {
        float a;
        float b;
        float c;
        float d;
        boolean e = false;

        C4752c(C4749e c4749e, float f, float f2, float f3, float f4) {
            this.c = 0.0f;
            this.d = 0.0f;
            this.a = f;
            this.b = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.c = (float) (f3 / sqrt);
                this.d = (float) (f4 / sqrt);
            }
        }

        void a(float f, float f2) {
            float f3 = f - this.a;
            float f4 = f2 - this.b;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                f3 = (float) (f3 / sqrt);
                f4 = (float) (f4 / sqrt);
            }
            float f5 = this.c;
            if (f3 == (-f5) && f4 == (-this.d)) {
                this.e = true;
                this.c = -f4;
                this.d = f3;
                return;
            }
            this.c = f5 + f3;
            this.d += f4;
        }

        void b(C4752c c4752c) {
            float f = c4752c.c;
            float f2 = this.c;
            if (f == (-f2)) {
                float f3 = c4752c.d;
                if (f3 == (-this.d)) {
                    this.e = true;
                    this.c = -f3;
                    this.d = c4752c.c;
                    return;
                }
            }
            this.c = f2 + f;
            this.d += c4752c.d;
        }

        public String toString() {
            return jn1.BRACKET_START_STR + this.a + "," + this.b + " " + this.c + "," + this.d + jn1.BRACKET_END_STR;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$d */
    /* loaded from: classes10.dex */
    public static class C4753d implements SVG.PathInterface {
        Path a = new Path();
        float b;
        float c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4753d(SVG.C4721p c4721p) {
            if (c4721p == null) {
                return;
            }
            c4721p.c(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path a() {
            return this.a;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            C4749e.m(this.b, this.c, f, f2, f3, z, z2, f4, f5, this);
            this.b = f4;
            this.c = f5;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.a.close();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
            this.a.cubicTo(f, f2, f3, f4, f5, f6);
            this.b = f5;
            this.c = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.a.lineTo(f, f2);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            this.a.moveTo(f, f2);
            this.b = f;
            this.c = f2;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.a.quadTo(f, f2, f3, f4);
            this.b = f3;
            this.c = f4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$e */
    /* loaded from: classes10.dex */
    public class C4754e extends C4755f {
        private Path d;

        C4754e(Path path, float f, float f2) {
            super(f, f2);
            this.d = path;
        }

        @Override // com.caverock.androidsvg.C4749e.C4755f, com.caverock.androidsvg.C4749e.AbstractC4759j
        public void b(String str) {
            if (C4749e.this.i1()) {
                if (C4749e.this.d.b) {
                    C4749e.this.a.drawTextOnPath(str, this.d, this.a, this.b, C4749e.this.d.d);
                }
                if (C4749e.this.d.c) {
                    C4749e.this.a.drawTextOnPath(str, this.d, this.a, this.b, C4749e.this.d.e);
                }
            }
            this.a += C4749e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$f */
    /* loaded from: classes10.dex */
    public class C4755f extends AbstractC4759j {
        float a;
        float b;

        C4755f(float f, float f2) {
            super(C4749e.this, null);
            this.a = f;
            this.b = f2;
        }

        @Override // com.caverock.androidsvg.C4749e.AbstractC4759j
        public void b(String str) {
            C4749e.G("TextSequence render", new Object[0]);
            if (C4749e.this.i1()) {
                if (C4749e.this.d.b) {
                    C4749e.this.a.drawText(str, this.a, this.b, C4749e.this.d.d);
                }
                if (C4749e.this.d.c) {
                    C4749e.this.a.drawText(str, this.a, this.b, C4749e.this.d.e);
                }
            }
            this.a += C4749e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$g */
    /* loaded from: classes10.dex */
    public class C4756g extends AbstractC4759j {
        float a;
        float b;
        Path c;

        C4756g(float f, float f2, Path path) {
            super(C4749e.this, null);
            this.a = f;
            this.b = f2;
            this.c = path;
        }

        @Override // com.caverock.androidsvg.C4749e.AbstractC4759j
        public boolean a(SVG.AbstractC4714l0 abstractC4714l0) {
            if (abstractC4714l0 instanceof SVG.C4716m0) {
                C4749e.j1("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.C4749e.AbstractC4759j
        public void b(String str) {
            if (C4749e.this.i1()) {
                Path path = new Path();
                C4749e.this.d.d.getTextPath(str, 0, str.length(), this.a, this.b, path);
                this.c.addPath(path);
            }
            this.a += C4749e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$i */
    /* loaded from: classes10.dex */
    public class C4758i extends AbstractC4759j {
        float a;
        float b;
        RectF c;

        C4758i(float f, float f2) {
            super(C4749e.this, null);
            this.c = new RectF();
            this.a = f;
            this.b = f2;
        }

        @Override // com.caverock.androidsvg.C4749e.AbstractC4759j
        public boolean a(SVG.AbstractC4714l0 abstractC4714l0) {
            if (abstractC4714l0 instanceof SVG.C4716m0) {
                SVG.C4716m0 c4716m0 = (SVG.C4716m0) abstractC4714l0;
                SVG.C4696c0 p = abstractC4714l0.a.p(c4716m0.n);
                if (p == null) {
                    C4749e.N("TextPath path reference '%s' not found", c4716m0.n);
                    return false;
                }
                SVG.C4719o c4719o = (SVG.C4719o) p;
                Path a = new C4753d(c4719o.o).a();
                Matrix matrix = c4719o.n;
                if (matrix != null) {
                    a.transform(matrix);
                }
                RectF rectF = new RectF();
                a.computeBounds(rectF, true);
                this.c.union(rectF);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.C4749e.AbstractC4759j
        public void b(String str) {
            if (C4749e.this.i1()) {
                Rect rect = new Rect();
                C4749e.this.d.d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.a, this.b);
                this.c.union(rectF);
            }
            this.a += C4749e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$j */
    /* loaded from: classes10.dex */
    public abstract class AbstractC4759j {
        private AbstractC4759j(C4749e c4749e) {
        }

        public boolean a(SVG.AbstractC4714l0 abstractC4714l0) {
            return true;
        }

        public abstract void b(String str);

        /* synthetic */ AbstractC4759j(C4749e c4749e, C4750a c4750a) {
            this(c4749e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4749e(Canvas canvas, float f) {
        this.a = canvas;
        this.b = f;
    }

    private void A(SVG.C4696c0 c4696c0) {
        Boolean bool;
        if ((c4696c0 instanceof SVG.AbstractC4692a0) && (bool = ((SVG.AbstractC4692a0) c4696c0).d) != null) {
            this.d.h = bool.booleanValue();
        }
    }

    private void A0(SVG.C4713l c4713l) {
        G("Line render", new Object[0]);
        f1(this.d, c4713l);
        if (I() && i1() && this.d.c) {
            Matrix matrix = c4713l.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path i0 = i0(c4713l);
            d1(c4713l);
            x(c4713l);
            u(c4713l);
            boolean u0 = u0();
            K(i0);
            Q0(c4713l);
            if (u0) {
                r0(c4713l);
            }
        }
    }

    private static double B(double d) {
        if (d < -1.0d) {
            return 3.141592653589793d;
        }
        if (d > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d);
    }

    private void B0(SVG.C4719o c4719o) {
        G("Path render", new Object[0]);
        if (c4719o.o == null) {
            return;
        }
        f1(this.d, c4719o);
        if (I() && i1()) {
            C4757h c4757h = this.d;
            if (c4757h.c || c4757h.b) {
                Matrix matrix = c4719o.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path a = new C4753d(c4719o.o).a();
                if (c4719o.h == null) {
                    c4719o.h = r(a);
                }
                d1(c4719o);
                x(c4719o);
                u(c4719o);
                boolean u0 = u0();
                if (this.d.b) {
                    a.setFillType(c0());
                    J(c4719o, a);
                }
                if (this.d.c) {
                    K(a);
                }
                Q0(c4719o);
                if (u0) {
                    r0(c4719o);
                }
            }
        }
    }

    private static int C(float f) {
        int i = (int) (f * 256.0f);
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    private void C0(SVG.C4725r c4725r) {
        G("PolyLine render", new Object[0]);
        f1(this.d, c4725r);
        if (I() && i1()) {
            C4757h c4757h = this.d;
            if (c4757h.c || c4757h.b) {
                Matrix matrix = c4725r.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (c4725r.o.length < 2) {
                    return;
                }
                Path j0 = j0(c4725r);
                d1(c4725r);
                j0.setFillType(c0());
                x(c4725r);
                u(c4725r);
                boolean u0 = u0();
                if (this.d.b) {
                    J(c4725r, j0);
                }
                if (this.d.c) {
                    K(j0);
                }
                Q0(c4725r);
                if (u0) {
                    r0(c4725r);
                }
            }
        }
    }

    private void D() {
        this.a.restore();
        this.d = this.e.pop();
    }

    private void D0(SVG.C4726s c4726s) {
        G("Polygon render", new Object[0]);
        f1(this.d, c4726s);
        if (I() && i1()) {
            C4757h c4757h = this.d;
            if (c4757h.c || c4757h.b) {
                Matrix matrix = c4726s.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (c4726s.o.length < 2) {
                    return;
                }
                Path j0 = j0(c4726s);
                d1(c4726s);
                x(c4726s);
                u(c4726s);
                boolean u0 = u0();
                if (this.d.b) {
                    J(c4726s, j0);
                }
                if (this.d.c) {
                    K(j0);
                }
                Q0(c4726s);
                if (u0) {
                    r0(c4726s);
                }
            }
        }
    }

    private void E() {
        C4745a.a(this.a, C4745a.a);
        this.e.push(this.d);
        this.d = new C4757h(this, this.d);
    }

    private void E0(SVG.C4727t c4727t) {
        G("Rect render", new Object[0]);
        SVG.Length length = c4727t.q;
        if (length == null || c4727t.r == null || length.isZero() || c4727t.r.isZero()) {
            return;
        }
        f1(this.d, c4727t);
        if (I() && i1()) {
            Matrix matrix = c4727t.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path k0 = k0(c4727t);
            d1(c4727t);
            x(c4727t);
            u(c4727t);
            boolean u0 = u0();
            if (this.d.b) {
                J(c4727t, k0);
            }
            if (this.d.c) {
                K(k0);
            }
            if (u0) {
                r0(c4727t);
            }
        }
    }

    private static int F(int i, float f) {
        int i2 = 255;
        int round = Math.round(((i >> 24) & 255) * f);
        if (round < 0) {
            i2 = 0;
        } else if (round <= 255) {
            i2 = round;
        }
        return (i & 16777215) | (i2 << 24);
    }

    private void F0(SVG.C4730w c4730w) {
        H0(c4730w, n0(c4730w.p, c4730w.q, c4730w.r, c4730w.s), c4730w.o, c4730w.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(String str, Object... objArr) {
    }

    private void G0(SVG.C4730w c4730w, SVG.C4693b c4693b) {
        H0(c4730w, c4693b, c4730w.o, c4730w.n);
    }

    private void H(boolean z, SVG.C4693b c4693b, SVG.PaintReference paintReference) {
        SVG.C4696c0 p = this.c.p(paintReference.href);
        if (p == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = paintReference.href;
            N("%s reference '%s' not found", objArr);
            SVG.SvgPaint svgPaint = paintReference.fallback;
            if (svgPaint != null) {
                X0(this.d, z, svgPaint);
            } else if (z) {
                this.d.b = false;
            } else {
                this.d.c = false;
            }
        } else if (p instanceof SVG.C4694b0) {
            f0(z, c4693b, (SVG.C4694b0) p);
        } else if (p instanceof SVG.C4700e0) {
            m0(z, c4693b, (SVG.C4700e0) p);
        } else if (p instanceof SVG.C4728u) {
            Y0(z, (SVG.C4728u) p);
        }
    }

    private void H0(SVG.C4730w c4730w, SVG.C4693b c4693b, SVG.C4693b c4693b2, PreserveAspectRatio preserveAspectRatio) {
        G("Svg render", new Object[0]);
        if (c4693b.c == 0.0f || c4693b.d == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null && (preserveAspectRatio = c4730w.n) == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        f1(this.d, c4730w);
        if (I()) {
            C4757h c4757h = this.d;
            c4757h.f = c4693b;
            if (!c4757h.a.overflow.booleanValue()) {
                SVG.C4693b c4693b3 = this.d.f;
                W0(c4693b3.a, c4693b3.b, c4693b3.c, c4693b3.d);
            }
            v(c4730w, this.d.f);
            if (c4693b2 != null) {
                this.a.concat(t(this.d.f, c4693b2, preserveAspectRatio));
                this.d.g = c4730w.o;
            } else {
                Canvas canvas = this.a;
                SVG.C4693b c4693b4 = this.d.f;
                canvas.translate(c4693b4.a, c4693b4.b);
            }
            boolean u0 = u0();
            h1();
            N0(c4730w, true);
            if (u0) {
                r0(c4730w);
            }
            d1(c4730w);
        }
    }

    private boolean I() {
        Boolean bool = this.d.a.display;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void I0(SVG.C4696c0 c4696c0) {
        if (c4696c0 instanceof SVG.NotDirectlyRendered) {
            return;
        }
        a1();
        A(c4696c0);
        if (c4696c0 instanceof SVG.C4730w) {
            F0((SVG.C4730w) c4696c0);
        } else if (c4696c0 instanceof SVG.C4722p0) {
            M0((SVG.C4722p0) c4696c0);
        } else if (c4696c0 instanceof SVG.C4704g0) {
            J0((SVG.C4704g0) c4696c0);
        } else if (c4696c0 instanceof SVG.C4709j) {
            y0((SVG.C4709j) c4696c0);
        } else if (c4696c0 instanceof SVG.C4711k) {
            z0((SVG.C4711k) c4696c0);
        } else if (c4696c0 instanceof SVG.C4719o) {
            B0((SVG.C4719o) c4696c0);
        } else if (c4696c0 instanceof SVG.C4727t) {
            E0((SVG.C4727t) c4696c0);
        } else if (c4696c0 instanceof SVG.C4697d) {
            w0((SVG.C4697d) c4696c0);
        } else if (c4696c0 instanceof SVG.C4703g) {
            x0((SVG.C4703g) c4696c0);
        } else if (c4696c0 instanceof SVG.C4713l) {
            A0((SVG.C4713l) c4696c0);
        } else if (c4696c0 instanceof SVG.C4726s) {
            D0((SVG.C4726s) c4696c0);
        } else if (c4696c0 instanceof SVG.C4725r) {
            C0((SVG.C4725r) c4696c0);
        } else if (c4696c0 instanceof SVG.C4712k0) {
            L0((SVG.C4712k0) c4696c0);
        }
        Z0();
    }

    private void J(SVG.AbstractC4733z abstractC4733z, Path path) {
        SVG.SvgPaint svgPaint = this.d.a.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.C4696c0 p = this.c.p(((SVG.PaintReference) svgPaint).href);
            if (p instanceof SVG.C4723q) {
                T(abstractC4733z, path, (SVG.C4723q) p);
                return;
            }
        }
        this.a.drawPath(path, this.d.d);
    }

    private void J0(SVG.C4704g0 c4704g0) {
        G("Switch render", new Object[0]);
        f1(this.d, c4704g0);
        if (I()) {
            Matrix matrix = c4704g0.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            u(c4704g0);
            boolean u0 = u0();
            S0(c4704g0);
            if (u0) {
                r0(c4704g0);
            }
            d1(c4704g0);
        }
    }

    private void K(Path path) {
        C4757h c4757h = this.d;
        if (c4757h.a.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.a.setMatrix(new Matrix());
            Shader shader = this.d.e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.a.drawPath(path2, this.d.e);
            this.a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.a.drawPath(path, c4757h.e);
    }

    private void K0(SVG.C4706h0 c4706h0, SVG.C4693b c4693b) {
        G("Symbol render", new Object[0]);
        if (c4693b.c == 0.0f || c4693b.d == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = c4706h0.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        f1(this.d, c4706h0);
        C4757h c4757h = this.d;
        c4757h.f = c4693b;
        if (!c4757h.a.overflow.booleanValue()) {
            SVG.C4693b c4693b2 = this.d.f;
            W0(c4693b2.a, c4693b2.b, c4693b2.c, c4693b2.d);
        }
        SVG.C4693b c4693b3 = c4706h0.o;
        if (c4693b3 != null) {
            this.a.concat(t(this.d.f, c4693b3, preserveAspectRatio));
            this.d.g = c4706h0.o;
        } else {
            Canvas canvas = this.a;
            SVG.C4693b c4693b4 = this.d.f;
            canvas.translate(c4693b4.a, c4693b4.b);
        }
        boolean u0 = u0();
        N0(c4706h0, true);
        if (u0) {
            r0(c4706h0);
        }
        d1(c4706h0);
    }

    private float L(float f, float f2, float f3, float f4) {
        return (f * f3) + (f2 * f4);
    }

    private void L0(SVG.C4712k0 c4712k0) {
        G("Text render", new Object[0]);
        f1(this.d, c4712k0);
        if (I()) {
            Matrix matrix = c4712k0.r;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            List<SVG.Length> list = c4712k0.n;
            float f = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : c4712k0.n.get(0).floatValueX(this);
            List<SVG.Length> list2 = c4712k0.o;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : c4712k0.o.get(0).floatValueY(this);
            List<SVG.Length> list3 = c4712k0.p;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : c4712k0.p.get(0).floatValueX(this);
            List<SVG.Length> list4 = c4712k0.q;
            if (list4 != null && list4.size() != 0) {
                f = c4712k0.q.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float s = s(c4712k0);
                if (W == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                floatValueX -= s;
            }
            if (c4712k0.h == null) {
                C4758i c4758i = new C4758i(floatValueX, floatValueY);
                M(c4712k0, c4758i);
                RectF rectF = c4758i.c;
                c4712k0.h = new SVG.C4693b(rectF.left, rectF.top, rectF.width(), c4758i.c.height());
            }
            d1(c4712k0);
            x(c4712k0);
            u(c4712k0);
            boolean u0 = u0();
            M(c4712k0, new C4755f(floatValueX + floatValueX2, floatValueY + f));
            if (u0) {
                r0(c4712k0);
            }
        }
    }

    private void M(SVG.AbstractC4714l0 abstractC4714l0, AbstractC4759j abstractC4759j) {
        if (I()) {
            Iterator<SVG.C4696c0> it = abstractC4714l0.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.C4696c0 next = it.next();
                if (next instanceof SVG.C4720o0) {
                    abstractC4759j.b(b1(((SVG.C4720o0) next).c, z, !it.hasNext()));
                } else {
                    t0(next, abstractC4759j);
                }
                z = false;
            }
        }
    }

    private void M0(SVG.C4722p0 c4722p0) {
        G("Use render", new Object[0]);
        SVG.Length length = c4722p0.r;
        if (length == null || !length.isZero()) {
            SVG.Length length2 = c4722p0.s;
            if (length2 == null || !length2.isZero()) {
                f1(this.d, c4722p0);
                if (I()) {
                    SVG.C4696c0 p = c4722p0.a.p(c4722p0.o);
                    if (p == null) {
                        N("Use reference '%s' not found", c4722p0.o);
                        return;
                    }
                    Matrix matrix = c4722p0.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    SVG.Length length3 = c4722p0.p;
                    float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
                    SVG.Length length4 = c4722p0.q;
                    this.a.translate(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f);
                    u(c4722p0);
                    boolean u0 = u0();
                    q0(c4722p0);
                    if (p instanceof SVG.C4730w) {
                        SVG.C4693b n0 = n0(null, null, c4722p0.r, c4722p0.s);
                        a1();
                        G0((SVG.C4730w) p, n0);
                        Z0();
                    } else if (p instanceof SVG.C4706h0) {
                        SVG.Length length5 = c4722p0.r;
                        if (length5 == null) {
                            length5 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Length length6 = c4722p0.s;
                        if (length6 == null) {
                            length6 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.C4693b n02 = n0(null, null, length5, length6);
                        a1();
                        K0((SVG.C4706h0) p, n02);
                        Z0();
                    } else {
                        I0(p);
                    }
                    p0();
                    if (u0) {
                        r0(c4722p0);
                    }
                    d1(c4722p0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    private void N0(SVG.SvgContainer svgContainer, boolean z) {
        if (z) {
            q0(svgContainer);
        }
        for (SVG.C4696c0 c4696c0 : svgContainer.getChildren()) {
            I0(c4696c0);
        }
        if (z) {
            p0();
        }
    }

    private void O(SVG.AbstractC4714l0 abstractC4714l0, StringBuilder sb) {
        Iterator<SVG.C4696c0> it = abstractC4714l0.i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.C4696c0 next = it.next();
            if (next instanceof SVG.AbstractC4714l0) {
                O((SVG.AbstractC4714l0) next, sb);
            } else if (next instanceof SVG.C4720o0) {
                sb.append(b1(((SVG.C4720o0) next).c, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private void P(SVG.AbstractC4705h abstractC4705h, String str) {
        SVG.C4696c0 p = abstractC4705h.a.p(str);
        if (p == null) {
            j1("Gradient reference '%s' not found", str);
        } else if (!(p instanceof SVG.AbstractC4705h)) {
            N("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (p == abstractC4705h) {
            N("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.AbstractC4705h abstractC4705h2 = (SVG.AbstractC4705h) p;
            if (abstractC4705h.i == null) {
                abstractC4705h.i = abstractC4705h2.i;
            }
            if (abstractC4705h.j == null) {
                abstractC4705h.j = abstractC4705h2.j;
            }
            if (abstractC4705h.k == null) {
                abstractC4705h.k = abstractC4705h2.k;
            }
            if (abstractC4705h.h.isEmpty()) {
                abstractC4705h.h = abstractC4705h2.h;
            }
            try {
                if (abstractC4705h instanceof SVG.C4694b0) {
                    Q((SVG.C4694b0) abstractC4705h, (SVG.C4694b0) p);
                } else {
                    R((SVG.C4700e0) abstractC4705h, (SVG.C4700e0) p);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = abstractC4705h2.l;
            if (str2 != null) {
                P(abstractC4705h, str2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0104, code lost:
        if (r7 != 8) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void P0(com.caverock.androidsvg.SVG.C4715m r12, com.caverock.androidsvg.C4749e.C4752c r13) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.C4749e.P0(com.caverock.androidsvg.SVG$m, com.caverock.androidsvg.e$c):void");
    }

    private void Q(SVG.C4694b0 c4694b0, SVG.C4694b0 c4694b02) {
        if (c4694b0.m == null) {
            c4694b0.m = c4694b02.m;
        }
        if (c4694b0.n == null) {
            c4694b0.n = c4694b02.n;
        }
        if (c4694b0.o == null) {
            c4694b0.o = c4694b02.o;
        }
        if (c4694b0.p == null) {
            c4694b0.p = c4694b02.p;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Q0(com.caverock.androidsvg.SVG.AbstractC4707i r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.C4749e.Q0(com.caverock.androidsvg.SVG$i):void");
    }

    private void R(SVG.C4700e0 c4700e0, SVG.C4700e0 c4700e02) {
        if (c4700e0.m == null) {
            c4700e0.m = c4700e02.m;
        }
        if (c4700e0.n == null) {
            c4700e0.n = c4700e02.n;
        }
        if (c4700e0.o == null) {
            c4700e0.o = c4700e02.o;
        }
        if (c4700e0.p == null) {
            c4700e0.p = c4700e02.p;
        }
        if (c4700e0.q == null) {
            c4700e0.q = c4700e02.q;
        }
    }

    private void R0(SVG.C4717n c4717n, SVG.AbstractC4733z abstractC4733z, SVG.C4693b c4693b) {
        float f;
        float f2;
        G("Mask render", new Object[0]);
        Boolean bool = c4717n.n;
        boolean z = true;
        if (bool != null && bool.booleanValue()) {
            SVG.Length length = c4717n.r;
            f = length != null ? length.floatValueX(this) : c4693b.c;
            SVG.Length length2 = c4717n.s;
            f2 = length2 != null ? length2.floatValueY(this) : c4693b.d;
        } else {
            SVG.Length length3 = c4717n.r;
            float floatValue = length3 != null ? length3.floatValue(this, 1.0f) : 1.2f;
            SVG.Length length4 = c4717n.s;
            float floatValue2 = length4 != null ? length4.floatValue(this, 1.0f) : 1.2f;
            f = floatValue * c4693b.c;
            f2 = floatValue2 * c4693b.d;
        }
        if (f == 0.0f || f2 == 0.0f) {
            return;
        }
        a1();
        C4757h U = U(c4717n);
        this.d = U;
        U.a.opacity = Float.valueOf(1.0f);
        boolean u0 = u0();
        this.a.save();
        Boolean bool2 = c4717n.o;
        if (bool2 != null && !bool2.booleanValue()) {
            z = false;
        }
        if (!z) {
            this.a.translate(c4693b.a, c4693b.b);
            this.a.scale(c4693b.c, c4693b.d);
        }
        N0(c4717n, false);
        this.a.restore();
        if (u0) {
            s0(abstractC4733z, c4693b);
        }
        Z0();
    }

    private void S(SVG.C4723q c4723q, String str) {
        SVG.C4696c0 p = c4723q.a.p(str);
        if (p == null) {
            j1("Pattern reference '%s' not found", str);
        } else if (!(p instanceof SVG.C4723q)) {
            N("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (p == c4723q) {
            N("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.C4723q c4723q2 = (SVG.C4723q) p;
            if (c4723q.p == null) {
                c4723q.p = c4723q2.p;
            }
            if (c4723q.q == null) {
                c4723q.q = c4723q2.q;
            }
            if (c4723q.r == null) {
                c4723q.r = c4723q2.r;
            }
            if (c4723q.s == null) {
                c4723q.s = c4723q2.s;
            }
            if (c4723q.t == null) {
                c4723q.t = c4723q2.t;
            }
            if (c4723q.u == null) {
                c4723q.u = c4723q2.u;
            }
            if (c4723q.v == null) {
                c4723q.v = c4723q2.v;
            }
            if (c4723q.i.isEmpty()) {
                c4723q.i = c4723q2.i;
            }
            if (c4723q.o == null) {
                c4723q.o = c4723q2.o;
            }
            if (c4723q.n == null) {
                c4723q.n = c4723q2.n;
            }
            String str2 = c4723q2.w;
            if (str2 != null) {
                S(c4723q, str2);
            }
        }
    }

    private void S0(SVG.C4704g0 c4704g0) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVG.g();
        for (SVG.C4696c0 c4696c0 : c4704g0.getChildren()) {
            if (c4696c0 instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) c4696c0;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (j == null) {
                            d0();
                        }
                        if (!requiredFeatures.isEmpty() && j.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> requiredFormats = svgConditional.getRequiredFormats();
                    if (requiredFormats != null) {
                        requiredFormats.isEmpty();
                    } else {
                        Set<String> requiredFonts = svgConditional.getRequiredFonts();
                        if (requiredFonts != null) {
                            requiredFonts.isEmpty();
                        } else {
                            I0(c4696c0);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void T(SVG.AbstractC4733z abstractC4733z, Path path, SVG.C4723q c4723q) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Boolean bool = c4723q.p;
        boolean z = bool != null && bool.booleanValue();
        String str = c4723q.w;
        if (str != null) {
            S(c4723q, str);
        }
        if (z) {
            SVG.Length length = c4723q.s;
            f = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = c4723q.t;
            f3 = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = c4723q.u;
            f4 = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = c4723q.v;
            f2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = c4723q.s;
            float floatValue = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = c4723q.t;
            float floatValue2 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = c4723q.u;
            float floatValue3 = length7 != null ? length7.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length8 = c4723q.v;
            float floatValue4 = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            SVG.C4693b c4693b = abstractC4733z.h;
            float f6 = c4693b.a;
            float f7 = c4693b.c;
            f = (floatValue * f7) + f6;
            float f8 = c4693b.b;
            float f9 = c4693b.d;
            float f10 = floatValue3 * f7;
            f2 = floatValue4 * f9;
            f3 = (floatValue2 * f9) + f8;
            f4 = f10;
        }
        if (f4 == 0.0f || f2 == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = c4723q.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        a1();
        this.a.clipPath(path);
        C4757h c4757h = new C4757h(this);
        e1(c4757h, SVG.Style.getDefaultStyle());
        c4757h.a.overflow = Boolean.FALSE;
        this.d = V(c4723q, c4757h);
        SVG.C4693b c4693b2 = abstractC4733z.h;
        Matrix matrix = c4723q.r;
        if (matrix != null) {
            this.a.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (c4723q.r.invert(matrix2)) {
                SVG.C4693b c4693b3 = abstractC4733z.h;
                SVG.C4693b c4693b4 = abstractC4733z.h;
                SVG.C4693b c4693b5 = abstractC4733z.h;
                float[] fArr = {c4693b3.a, c4693b3.b, c4693b3.b(), c4693b4.b, c4693b4.b(), abstractC4733z.h.c(), c4693b5.a, c4693b5.c()};
                matrix2.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i = 2; i <= 6; i += 2) {
                    if (fArr[i] < rectF.left) {
                        rectF.left = fArr[i];
                    }
                    if (fArr[i] > rectF.right) {
                        rectF.right = fArr[i];
                    }
                    int i2 = i + 1;
                    if (fArr[i2] < rectF.top) {
                        rectF.top = fArr[i2];
                    }
                    if (fArr[i2] > rectF.bottom) {
                        rectF.bottom = fArr[i2];
                    }
                }
                float f11 = rectF.left;
                float f12 = rectF.top;
                c4693b2 = new SVG.C4693b(f11, f12, rectF.right - f11, rectF.bottom - f12);
            }
        }
        float floor = f + (((float) Math.floor((c4693b2.a - f) / f4)) * f4);
        float b = c4693b2.b();
        float c = c4693b2.c();
        SVG.C4693b c4693b6 = new SVG.C4693b(0.0f, 0.0f, f4, f2);
        boolean u0 = u0();
        for (float floor2 = f3 + (((float) Math.floor((c4693b2.b - f3) / f2)) * f2); floor2 < c; floor2 += f2) {
            float f13 = floor;
            while (f13 < b) {
                c4693b6.a = f13;
                c4693b6.b = floor2;
                a1();
                if (this.d.a.overflow.booleanValue()) {
                    f5 = floor;
                } else {
                    f5 = floor;
                    W0(c4693b6.a, c4693b6.b, c4693b6.c, c4693b6.d);
                }
                SVG.C4693b c4693b7 = c4723q.o;
                if (c4693b7 != null) {
                    this.a.concat(t(c4693b6, c4693b7, preserveAspectRatio));
                } else {
                    Boolean bool2 = c4723q.q;
                    boolean z2 = bool2 == null || bool2.booleanValue();
                    this.a.translate(f13, floor2);
                    if (!z2) {
                        Canvas canvas = this.a;
                        SVG.C4693b c4693b8 = abstractC4733z.h;
                        canvas.scale(c4693b8.c, c4693b8.d);
                    }
                }
                for (SVG.C4696c0 c4696c0 : c4723q.i) {
                    I0(c4696c0);
                }
                Z0();
                f13 += f4;
                floor = f5;
            }
        }
        if (u0) {
            r0(c4723q);
        }
        Z0();
    }

    private void T0(SVG.C4716m0 c4716m0) {
        G("TextPath render", new Object[0]);
        f1(this.d, c4716m0);
        if (I() && i1()) {
            SVG.C4696c0 p = c4716m0.a.p(c4716m0.n);
            if (p == null) {
                N("TextPath reference '%s' not found", c4716m0.n);
                return;
            }
            SVG.C4719o c4719o = (SVG.C4719o) p;
            Path a = new C4753d(c4719o.o).a();
            Matrix matrix = c4719o.n;
            if (matrix != null) {
                a.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(a, false);
            SVG.Length length = c4716m0.o;
            float floatValue = length != null ? length.floatValue(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float s = s(c4716m0);
                if (W == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                floatValue -= s;
            }
            x((SVG.AbstractC4733z) c4716m0.getTextRoot());
            boolean u0 = u0();
            M(c4716m0, new C4754e(a, floatValue, 0.0f));
            if (u0) {
                r0(c4716m0);
            }
        }
    }

    private C4757h U(SVG.C4696c0 c4696c0) {
        C4757h c4757h = new C4757h(this);
        e1(c4757h, SVG.Style.getDefaultStyle());
        return V(c4696c0, c4757h);
    }

    private boolean U0() {
        return this.d.a.opacity.floatValue() < 1.0f || this.d.a.mask != null;
    }

    private C4757h V(SVG.C4696c0 c4696c0, C4757h c4757h) {
        ArrayList<SVG.AbstractC4692a0> arrayList = new ArrayList();
        while (true) {
            if (c4696c0 instanceof SVG.AbstractC4692a0) {
                arrayList.add(0, (SVG.AbstractC4692a0) c4696c0);
            }
            SVG.SvgContainer svgContainer = c4696c0.b;
            if (svgContainer == null) {
                break;
            }
            c4696c0 = (SVG.C4696c0) svgContainer;
        }
        for (SVG.AbstractC4692a0 abstractC4692a0 : arrayList) {
            f1(c4757h, abstractC4692a0);
        }
        C4757h c4757h2 = this.d;
        c4757h.g = c4757h2.g;
        c4757h.f = c4757h2.f;
        return c4757h;
    }

    private void V0() {
        this.d = new C4757h(this);
        this.e = new Stack<>();
        e1(this.d, SVG.Style.getDefaultStyle());
        C4757h c4757h = this.d;
        c4757h.f = null;
        c4757h.h = false;
        this.e.push(new C4757h(this, c4757h));
        this.g = new Stack<>();
        this.f = new Stack<>();
    }

    private SVG.Style.TextAnchor W() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.d.a;
        if (style.direction != SVG.Style.TextDirection.LTR && (textAnchor = style.textAnchor) != SVG.Style.TextAnchor.Middle) {
            SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
            return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
        }
        return style.textAnchor;
    }

    private void W0(float f, float f2, float f3, float f4) {
        float f5 = f3 + f;
        float f6 = f4 + f2;
        SVG.C4695c c4695c = this.d.a.clip;
        if (c4695c != null) {
            f += c4695c.d.floatValueX(this);
            f2 += this.d.a.clip.a.floatValueY(this);
            f5 -= this.d.a.clip.b.floatValueX(this);
            f6 -= this.d.a.clip.c.floatValueY(this);
        }
        this.a.clipRect(f, f2, f5, f6);
    }

    private Path.FillType X() {
        SVG.Style.FillRule fillRule = this.d.a.clipRule;
        if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void X0(C4757h c4757h, boolean z, SVG.SvgPaint svgPaint) {
        int i;
        SVG.Style style = c4757h.a;
        float floatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i = c4757h.a.color.colour;
        }
        int F = F(i, floatValue);
        if (z) {
            c4757h.d.setColor(F);
        } else {
            c4757h.e.setColor(F);
        }
    }

    private void Y0(boolean z, SVG.C4728u c4728u) {
        if (z) {
            if (e0(c4728u.e, 2147483648L)) {
                C4757h c4757h = this.d;
                SVG.Style style = c4757h.a;
                SVG.SvgPaint svgPaint = c4728u.e.solidColor;
                style.fill = svgPaint;
                c4757h.b = svgPaint != null;
            }
            if (e0(c4728u.e, Constants.RequestStrategy.LOCAL_FIRST)) {
                this.d.a.fillOpacity = c4728u.e.solidOpacity;
            }
            if (e0(c4728u.e, 6442450944L)) {
                C4757h c4757h2 = this.d;
                X0(c4757h2, z, c4757h2.a.fill);
                return;
            }
            return;
        }
        if (e0(c4728u.e, 2147483648L)) {
            C4757h c4757h3 = this.d;
            SVG.Style style2 = c4757h3.a;
            SVG.SvgPaint svgPaint2 = c4728u.e.solidColor;
            style2.stroke = svgPaint2;
            c4757h3.c = svgPaint2 != null;
        }
        if (e0(c4728u.e, Constants.RequestStrategy.LOCAL_FIRST)) {
            this.d.a.strokeOpacity = c4728u.e.solidOpacity;
        }
        if (e0(c4728u.e, 6442450944L)) {
            C4757h c4757h4 = this.d;
            X0(c4757h4, z, c4757h4.a.stroke);
        }
    }

    private void Z0() {
        this.a.restore();
        this.d = this.e.pop();
    }

    private void a1() {
        this.a.save();
        this.e.push(this.d);
        this.d = new C4757h(this, this.d);
    }

    private String b1(String str, boolean z, boolean z2) {
        if (this.d.h) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        if (str.contains(StringUtils.LF)) {
            str = str.replaceAll("\\n", "");
        }
        if (str.contains("\t")) {
            str = str.replaceAll("\\t", " ");
        }
        if (z) {
            str = str.replaceAll("^\\s+", "");
        }
        if (z2) {
            str = str.replaceAll("\\s+$", "");
        }
        return str.replaceAll("\\s{2,}", " ");
    }

    private Path.FillType c0() {
        SVG.Style.FillRule fillRule = this.d.a.fillRule;
        if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void c1(C4757h c4757h, SVG.Style style) {
        boolean z = true;
        if (e0(style, 1L)) {
            c4757h.a.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            c4757h.b = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
            this.i |= 1;
        }
        if (e0(style, 4L)) {
            c4757h.a.fillOpacity = style.fillOpacity;
            this.i |= 2;
        }
        if (e0(style, 5L)) {
            X0(c4757h, true, c4757h.a.fill);
        }
        if (e0(style, 8L)) {
            c4757h.a.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            c4757h.c = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : false;
            this.i |= 4;
        }
        if (e0(style, 16L)) {
            c4757h.a.strokeOpacity = style.strokeOpacity;
            this.i |= 8;
        }
        if (e0(style, 24L)) {
            X0(c4757h, false, c4757h.a.stroke);
        }
    }

    private static synchronized void d0() {
        synchronized (C4749e.class) {
            HashSet<String> hashSet = new HashSet<>();
            j = hashSet;
            hashSet.add("Structure");
            j.add("BasicStructure");
            j.add("ConditionalProcessing");
            j.add(BizTime.IMAGE);
            j.add("Style");
            j.add("ViewportAttribute");
            j.add("Shape");
            j.add("BasicText");
            j.add("PaintAttribute");
            j.add("BasicPaintAttribute");
            j.add("OpacityAttribute");
            j.add("BasicGraphicsAttribute");
            j.add("Marker");
            j.add("Gradient");
            j.add("Pattern");
            j.add("Clip");
            j.add("BasicClip");
            j.add("Mask");
            j.add(CssConst.CssScenes.VIEW);
        }
    }

    private void d1(SVG.AbstractC4733z abstractC4733z) {
        if (abstractC4733z.b == null || abstractC4733z.h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.g.peek().invert(matrix)) {
            SVG.C4693b c4693b = abstractC4733z.h;
            SVG.C4693b c4693b2 = abstractC4733z.h;
            SVG.C4693b c4693b3 = abstractC4733z.h;
            float[] fArr = {c4693b.a, c4693b.b, c4693b.b(), c4693b2.b, c4693b2.b(), abstractC4733z.h.c(), c4693b3.a, c4693b3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i = 2; i <= 6; i += 2) {
                if (fArr[i] < rectF.left) {
                    rectF.left = fArr[i];
                }
                if (fArr[i] > rectF.right) {
                    rectF.right = fArr[i];
                }
                int i2 = i + 1;
                if (fArr[i2] < rectF.top) {
                    rectF.top = fArr[i2];
                }
                if (fArr[i2] > rectF.bottom) {
                    rectF.bottom = fArr[i2];
                }
            }
            SVG.AbstractC4733z abstractC4733z2 = (SVG.AbstractC4733z) this.f.peek();
            SVG.C4693b c4693b4 = abstractC4733z2.h;
            if (c4693b4 == null) {
                abstractC4733z2.h = SVG.C4693b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                c4693b4.d(SVG.C4693b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private boolean e0(SVG.Style style, long j2) {
        return (style.specifiedFlags & j2) != 0;
    }

    private void e1(C4757h c4757h, SVG.Style style) {
        if (e0(style, 4096L)) {
            c4757h.a.color = style.color;
        }
        if (e0(style, 2048L)) {
            c4757h.a.opacity = style.opacity;
        }
        if (e0(style, 1L)) {
            c4757h.a.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            c4757h.b = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 4L)) {
            c4757h.a.fillOpacity = style.fillOpacity;
        }
        if (e0(style, 6149L)) {
            X0(c4757h, true, c4757h.a.fill);
        }
        if (e0(style, 2L)) {
            c4757h.a.fillRule = style.fillRule;
        }
        if (e0(style, 8L)) {
            c4757h.a.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            c4757h.c = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 16L)) {
            c4757h.a.strokeOpacity = style.strokeOpacity;
        }
        if (e0(style, 6168L)) {
            X0(c4757h, false, c4757h.a.stroke);
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_FILE)) {
            c4757h.a.vectorEffect = style.vectorEffect;
        }
        if (e0(style, 32L)) {
            SVG.Style style2 = c4757h.a;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            c4757h.e.setStrokeWidth(length.floatValue(this));
        }
        if (e0(style, 64L)) {
            c4757h.a.strokeLineCap = style.strokeLineCap;
            int i = C4750a.b[style.strokeLineCap.ordinal()];
            if (i == 1) {
                c4757h.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                c4757h.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                c4757h.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (e0(style, 128L)) {
            c4757h.a.strokeLineJoin = style.strokeLineJoin;
            int i2 = C4750a.c[style.strokeLineJoin.ordinal()];
            if (i2 == 1) {
                c4757h.e.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                c4757h.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                c4757h.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (e0(style, 256L)) {
            c4757h.a.strokeMiterLimit = style.strokeMiterLimit;
            c4757h.e.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (e0(style, 512L)) {
            c4757h.a.strokeDashArray = style.strokeDashArray;
        }
        if (e0(style, 1024L)) {
            c4757h.a.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (e0(style, 1536L)) {
            SVG.Length[] lengthArr = c4757h.a.strokeDashArray;
            if (lengthArr == null) {
                c4757h.e.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i3 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    fArr[i4] = c4757h.a.strokeDashArray[i4 % length2].floatValue(this);
                    f += fArr[i4];
                }
                if (f == 0.0f) {
                    c4757h.e.setPathEffect(null);
                } else {
                    float floatValue = c4757h.a.strokeDashOffset.floatValue(this);
                    if (floatValue < 0.0f) {
                        floatValue = (floatValue % f) + f;
                    }
                    c4757h.e.setPathEffect(new DashPathEffect(fArr, floatValue));
                }
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE)) {
            float Y = Y();
            c4757h.a.fontSize = style.fontSize;
            c4757h.d.setTextSize(style.fontSize.floatValue(this, Y));
            c4757h.e.setTextSize(style.fontSize.floatValue(this, Y));
        }
        if (e0(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            c4757h.a.fontFamily = style.fontFamily;
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.intValue() == -1 && c4757h.a.fontWeight.intValue() > 100) {
                SVG.Style style3 = c4757h.a;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && c4757h.a.fontWeight.intValue() < 900) {
                SVG.Style style4 = c4757h.a;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            } else {
                c4757h.a.fontWeight = style.fontWeight;
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            c4757h.a.fontStyle = style.fontStyle;
        }
        if (e0(style, 106496L)) {
            if (c4757h.a.fontFamily != null && this.c != null) {
                SVG.g();
                for (String str : c4757h.a.fontFamily) {
                    SVG.Style style5 = c4757h.a;
                    typeface = z(str, style5.fontWeight, style5.fontStyle);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = c4757h.a;
                typeface = z("serif", style6.fontWeight, style6.fontStyle);
            }
            c4757h.d.setTypeface(typeface);
            c4757h.e.setTypeface(typeface);
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            c4757h.a.textDecoration = style.textDecoration;
            Paint paint = c4757h.d;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = c4757h.d;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            if (Build.VERSION.SDK_INT >= 17) {
                c4757h.e.setStrikeThruText(style.textDecoration == textDecoration2);
                c4757h.e.setUnderlineText(style.textDecoration == textDecoration4);
            }
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FILE)) {
            c4757h.a.direction = style.direction;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            c4757h.a.textAnchor = style.textAnchor;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            c4757h.a.overflow = style.overflow;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            c4757h.a.markerStart = style.markerStart;
        }
        if (e0(style, 4194304L)) {
            c4757h.a.markerMid = style.markerMid;
        }
        if (e0(style, 8388608L)) {
            c4757h.a.markerEnd = style.markerEnd;
        }
        if (e0(style, 16777216L)) {
            c4757h.a.display = style.display;
        }
        if (e0(style, 33554432L)) {
            c4757h.a.visibility = style.visibility;
        }
        if (e0(style, 1048576L)) {
            c4757h.a.clip = style.clip;
        }
        if (e0(style, 268435456L)) {
            c4757h.a.clipPath = style.clipPath;
        }
        if (e0(style, 536870912L)) {
            c4757h.a.clipRule = style.clipRule;
        }
        if (e0(style, 1073741824L)) {
            c4757h.a.mask = style.mask;
        }
        if (e0(style, 67108864L)) {
            c4757h.a.stopColor = style.stopColor;
        }
        if (e0(style, 134217728L)) {
            c4757h.a.stopOpacity = style.stopOpacity;
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FIRST)) {
            c4757h.a.viewportFill = style.viewportFill;
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_SERIAL)) {
            c4757h.a.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (e0(style, 137438953472L)) {
            c4757h.a.imageRendering = style.imageRendering;
        }
    }

    private void f0(boolean z, SVG.C4693b c4693b, SVG.C4694b0 c4694b0) {
        float f;
        float floatValue;
        float f2;
        float f3;
        String str = c4694b0.l;
        if (str != null) {
            P(c4694b0, str);
        }
        Boolean bool = c4694b0.i;
        int i = 0;
        boolean z2 = bool != null && bool.booleanValue();
        C4757h c4757h = this.d;
        Paint paint = z ? c4757h.d : c4757h.e;
        if (z2) {
            SVG.C4693b a0 = a0();
            SVG.Length length = c4694b0.m;
            float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = c4694b0.n;
            float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = c4694b0.o;
            float floatValueX2 = length3 != null ? length3.floatValueX(this) : a0.c;
            SVG.Length length4 = c4694b0.p;
            f3 = floatValueX2;
            f = floatValueX;
            f2 = floatValueY;
            floatValue = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = c4694b0.m;
            float floatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = c4694b0.n;
            float floatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = c4694b0.o;
            float floatValue4 = length7 != null ? length7.floatValue(this, 1.0f) : 1.0f;
            SVG.Length length8 = c4694b0.p;
            f = floatValue2;
            floatValue = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            f2 = floatValue3;
            f3 = floatValue4;
        }
        a1();
        this.d = U(c4694b0);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(c4693b.a, c4693b.b);
            matrix.preScale(c4693b.c, c4693b.d);
        }
        Matrix matrix2 = c4694b0.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = c4694b0.h.size();
        if (size == 0) {
            Z0();
            if (z) {
                this.d.b = false;
                return;
            } else {
                this.d.c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f4 = -1.0f;
        Iterator<SVG.C4696c0> it = c4694b0.h.iterator();
        while (it.hasNext()) {
            SVG.C4729v c4729v = (SVG.C4729v) it.next();
            Float f5 = c4729v.h;
            float floatValue5 = f5 != null ? f5.floatValue() : 0.0f;
            if (i != 0 && floatValue5 < f4) {
                fArr[i] = f4;
            } else {
                fArr[i] = floatValue5;
                f4 = floatValue5;
            }
            a1();
            f1(this.d, c4729v);
            SVG.Style style = this.d.a;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i] = F(colour.colour, style.stopOpacity.floatValue());
            i++;
            Z0();
        }
        if ((f == f3 && f2 == floatValue) || size == 1) {
            Z0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = c4694b0.k;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Z0();
        LinearGradient linearGradient = new LinearGradient(f, f2, f3, floatValue, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(C(this.d.a.fillOpacity.floatValue()));
    }

    private void f1(C4757h c4757h, SVG.AbstractC4692a0 abstractC4692a0) {
        boolean z = false;
        c4757h.a.resetNonInheritingProperties(abstractC4692a0.b == null);
        SVG.Style style = abstractC4692a0.e;
        if (style != null) {
            e1(c4757h, style);
        }
        this.i = 0;
        if (this.c.m()) {
            for (CSSParser.C4686k c4686k : this.c.d()) {
                if (CSSParser.l(this.h, c4686k.a, abstractC4692a0)) {
                    SVG.Style style2 = c4686k.b;
                    if (style2 != null && style2.important) {
                        z = true;
                    }
                    if (z) {
                        c1(c4757h, style2);
                    } else {
                        e1(c4757h, style2);
                    }
                }
            }
        }
        SVG.Style style3 = abstractC4692a0.f;
        if (style3 != null) {
            if (style3.important) {
                e1(c4757h, style3);
            } else if (z) {
                g1(c4757h, style3);
            } else {
                e1(c4757h, style3);
            }
        }
    }

    private Path g0(SVG.C4697d c4697d) {
        SVG.Length length = c4697d.o;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = c4697d.p;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValue = c4697d.q.floatValue(this);
        float f = floatValueX - floatValue;
        float f2 = floatValueY - floatValue;
        float f3 = floatValueX + floatValue;
        float f4 = floatValueY + floatValue;
        if (c4697d.h == null) {
            float f5 = 2.0f * floatValue;
            c4697d.h = new SVG.C4693b(f, f2, f5, f5);
        }
        float f6 = 0.5522848f * floatValue;
        Path path = new Path();
        path.moveTo(floatValueX, f2);
        float f7 = floatValueX + f6;
        float f8 = floatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, floatValueY);
        float f9 = floatValueY + f6;
        path.cubicTo(f3, f9, f7, f4, floatValueX, f4);
        float f10 = floatValueX - f6;
        path.cubicTo(f10, f4, f, f9, f, floatValueY);
        path.cubicTo(f, f8, f10, f2, floatValueX, f2);
        path.close();
        return path;
    }

    private void g1(C4757h c4757h, SVG.Style style) {
        if (e0(style, 4096L)) {
            c4757h.a.color = style.color;
        }
        if (e0(style, 2048L)) {
            c4757h.a.opacity = style.opacity;
        }
        if (e0(style, 1L) && (this.i & 1) == 0) {
            c4757h.a.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            c4757h.b = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 4L) && (this.i & 2) == 0) {
            c4757h.a.fillOpacity = style.fillOpacity;
        }
        if (e0(style, 6149L)) {
            X0(c4757h, true, c4757h.a.fill);
        }
        if (e0(style, 2L)) {
            c4757h.a.fillRule = style.fillRule;
        }
        if (e0(style, 8L) && (this.i & 4) == 0) {
            c4757h.a.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            c4757h.c = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 16L) && (this.i & 8) == 0) {
            c4757h.a.strokeOpacity = style.strokeOpacity;
        }
        if (e0(style, 6168L)) {
            X0(c4757h, false, c4757h.a.stroke);
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_FILE)) {
            c4757h.a.vectorEffect = style.vectorEffect;
        }
        if (e0(style, 32L)) {
            SVG.Style style2 = c4757h.a;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            c4757h.e.setStrokeWidth(length.floatValue(this));
        }
        if (e0(style, 64L)) {
            c4757h.a.strokeLineCap = style.strokeLineCap;
            int i = C4750a.b[style.strokeLineCap.ordinal()];
            if (i == 1) {
                c4757h.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                c4757h.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                c4757h.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (e0(style, 128L)) {
            c4757h.a.strokeLineJoin = style.strokeLineJoin;
            int i2 = C4750a.c[style.strokeLineJoin.ordinal()];
            if (i2 == 1) {
                c4757h.e.setStrokeJoin(Paint.Join.MITER);
            } else if (i2 == 2) {
                c4757h.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i2 == 3) {
                c4757h.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (e0(style, 256L)) {
            c4757h.a.strokeMiterLimit = style.strokeMiterLimit;
            c4757h.e.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (e0(style, 512L)) {
            c4757h.a.strokeDashArray = style.strokeDashArray;
        }
        if (e0(style, 1024L)) {
            c4757h.a.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (e0(style, 1536L)) {
            SVG.Length[] lengthArr = c4757h.a.strokeDashArray;
            if (lengthArr == null) {
                c4757h.e.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i3 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i3];
                float f = 0.0f;
                for (int i4 = 0; i4 < i3; i4++) {
                    fArr[i4] = c4757h.a.strokeDashArray[i4 % length2].floatValue(this);
                    f += fArr[i4];
                }
                if (f == 0.0f) {
                    c4757h.e.setPathEffect(null);
                } else {
                    float floatValue = c4757h.a.strokeDashOffset.floatValue(this);
                    if (floatValue < 0.0f) {
                        floatValue = (floatValue % f) + f;
                    }
                    c4757h.e.setPathEffect(new DashPathEffect(fArr, floatValue));
                }
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE)) {
            float Y = Y();
            c4757h.a.fontSize = style.fontSize;
            c4757h.d.setTextSize(style.fontSize.floatValue(this, Y));
            c4757h.e.setTextSize(style.fontSize.floatValue(this, Y));
        }
        if (e0(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            c4757h.a.fontFamily = style.fontFamily;
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.intValue() == -1 && c4757h.a.fontWeight.intValue() > 100) {
                SVG.Style style3 = c4757h.a;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && c4757h.a.fontWeight.intValue() < 900) {
                SVG.Style style4 = c4757h.a;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            } else {
                c4757h.a.fontWeight = style.fontWeight;
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            c4757h.a.fontStyle = style.fontStyle;
        }
        if (e0(style, 106496L)) {
            if (c4757h.a.fontFamily != null && this.c != null) {
                SVG.g();
                for (String str : c4757h.a.fontFamily) {
                    SVG.Style style5 = c4757h.a;
                    typeface = z(str, style5.fontWeight, style5.fontStyle);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = c4757h.a;
                typeface = z("serif", style6.fontWeight, style6.fontStyle);
            }
            c4757h.d.setTypeface(typeface);
            c4757h.e.setTypeface(typeface);
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            c4757h.a.textDecoration = style.textDecoration;
            Paint paint = c4757h.d;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = c4757h.d;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            if (Build.VERSION.SDK_INT >= 17) {
                c4757h.e.setStrikeThruText(style.textDecoration == textDecoration2);
                c4757h.e.setUnderlineText(style.textDecoration == textDecoration4);
            }
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FILE)) {
            c4757h.a.direction = style.direction;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            c4757h.a.textAnchor = style.textAnchor;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            c4757h.a.overflow = style.overflow;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            c4757h.a.markerStart = style.markerStart;
        }
        if (e0(style, 4194304L)) {
            c4757h.a.markerMid = style.markerMid;
        }
        if (e0(style, 8388608L)) {
            c4757h.a.markerEnd = style.markerEnd;
        }
        if (e0(style, 16777216L)) {
            c4757h.a.display = style.display;
        }
        if (e0(style, 33554432L)) {
            c4757h.a.visibility = style.visibility;
        }
        if (e0(style, 1048576L)) {
            c4757h.a.clip = style.clip;
        }
        if (e0(style, 268435456L)) {
            c4757h.a.clipPath = style.clipPath;
        }
        if (e0(style, 536870912L)) {
            c4757h.a.clipRule = style.clipRule;
        }
        if (e0(style, 1073741824L)) {
            c4757h.a.mask = style.mask;
        }
        if (e0(style, 67108864L)) {
            c4757h.a.stopColor = style.stopColor;
        }
        if (e0(style, 134217728L)) {
            c4757h.a.stopOpacity = style.stopOpacity;
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FIRST)) {
            c4757h.a.viewportFill = style.viewportFill;
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_SERIAL)) {
            c4757h.a.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (e0(style, 137438953472L)) {
            c4757h.a.imageRendering = style.imageRendering;
        }
    }

    private void h(SVG.AbstractC4707i abstractC4707i, Path path, Matrix matrix) {
        Path j0;
        f1(this.d, abstractC4707i);
        if (I() && i1()) {
            Matrix matrix2 = abstractC4707i.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (abstractC4707i instanceof SVG.C4727t) {
                j0 = k0((SVG.C4727t) abstractC4707i);
            } else if (abstractC4707i instanceof SVG.C4697d) {
                j0 = g0((SVG.C4697d) abstractC4707i);
            } else if (abstractC4707i instanceof SVG.C4703g) {
                j0 = h0((SVG.C4703g) abstractC4707i);
            } else if (!(abstractC4707i instanceof SVG.C4725r)) {
                return;
            } else {
                j0 = j0((SVG.C4725r) abstractC4707i);
            }
            u(abstractC4707i);
            path.setFillType(X());
            path.addPath(j0, matrix);
        }
    }

    private Path h0(SVG.C4703g c4703g) {
        SVG.Length length = c4703g.o;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = c4703g.p;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValueX2 = c4703g.q.floatValueX(this);
        float floatValueY2 = c4703g.r.floatValueY(this);
        float f = floatValueX - floatValueX2;
        float f2 = floatValueY - floatValueY2;
        float f3 = floatValueX + floatValueX2;
        float f4 = floatValueY + floatValueY2;
        if (c4703g.h == null) {
            c4703g.h = new SVG.C4693b(f, f2, floatValueX2 * 2.0f, 2.0f * floatValueY2);
        }
        float f5 = floatValueX2 * 0.5522848f;
        float f6 = 0.5522848f * floatValueY2;
        Path path = new Path();
        path.moveTo(floatValueX, f2);
        float f7 = floatValueX + f5;
        float f8 = floatValueY - f6;
        path.cubicTo(f7, f2, f3, f8, f3, floatValueY);
        float f9 = f6 + floatValueY;
        path.cubicTo(f3, f9, f7, f4, floatValueX, f4);
        float f10 = floatValueX - f5;
        path.cubicTo(f10, f4, f, f9, f, floatValueY);
        path.cubicTo(f, f8, f10, f2, floatValueX, f2);
        path.close();
        return path;
    }

    private void h1() {
        int i;
        SVG.Style style = this.d.a;
        SVG.SvgPaint svgPaint = style.viewportFill;
        if (svgPaint instanceof SVG.Colour) {
            i = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i = style.color.colour;
        }
        Float f = style.viewportFillOpacity;
        if (f != null) {
            i = F(i, f.floatValue());
        }
        this.a.drawColor(i);
    }

    private void i(SVG.C4719o c4719o, Path path, Matrix matrix) {
        f1(this.d, c4719o);
        if (I() && i1()) {
            Matrix matrix2 = c4719o.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path a = new C4753d(c4719o.o).a();
            if (c4719o.h == null) {
                c4719o.h = r(a);
            }
            u(c4719o);
            path.setFillType(X());
            path.addPath(a, matrix);
        }
    }

    private Path i0(SVG.C4713l c4713l) {
        SVG.Length length = c4713l.o;
        float floatValueX = length == null ? 0.0f : length.floatValueX(this);
        SVG.Length length2 = c4713l.p;
        float floatValueY = length2 == null ? 0.0f : length2.floatValueY(this);
        SVG.Length length3 = c4713l.q;
        float floatValueX2 = length3 == null ? 0.0f : length3.floatValueX(this);
        SVG.Length length4 = c4713l.r;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        if (c4713l.h == null) {
            c4713l.h = new SVG.C4693b(Math.min(floatValueX, floatValueX2), Math.min(floatValueY, floatValueY2), Math.abs(floatValueX2 - floatValueX), Math.abs(floatValueY2 - floatValueY));
        }
        Path path = new Path();
        path.moveTo(floatValueX, floatValueY);
        path.lineTo(floatValueX2, floatValueY2);
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i1() {
        Boolean bool = this.d.a.visibility;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void j(SVG.C4696c0 c4696c0, boolean z, Path path, Matrix matrix) {
        if (I()) {
            E();
            if (c4696c0 instanceof SVG.C4722p0) {
                if (z) {
                    l((SVG.C4722p0) c4696c0, path, matrix);
                } else {
                    N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (c4696c0 instanceof SVG.C4719o) {
                i((SVG.C4719o) c4696c0, path, matrix);
            } else if (c4696c0 instanceof SVG.C4712k0) {
                k((SVG.C4712k0) c4696c0, path, matrix);
            } else if (c4696c0 instanceof SVG.AbstractC4707i) {
                h((SVG.AbstractC4707i) c4696c0, path, matrix);
            } else {
                N("Invalid %s element found in clipPath definition", c4696c0.toString());
            }
            D();
        }
    }

    private Path j0(SVG.C4725r c4725r) {
        Path path = new Path();
        float[] fArr = c4725r.o;
        path.moveTo(fArr[0], fArr[1]);
        int i = 2;
        while (true) {
            float[] fArr2 = c4725r.o;
            if (i >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i], fArr2[i + 1]);
            i += 2;
        }
        if (c4725r instanceof SVG.C4726s) {
            path.close();
        }
        if (c4725r.h == null) {
            c4725r.h = r(path);
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j1(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    private void k(SVG.C4712k0 c4712k0, Path path, Matrix matrix) {
        f1(this.d, c4712k0);
        if (I()) {
            Matrix matrix2 = c4712k0.r;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.Length> list = c4712k0.n;
            float f = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : c4712k0.n.get(0).floatValueX(this);
            List<SVG.Length> list2 = c4712k0.o;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : c4712k0.o.get(0).floatValueY(this);
            List<SVG.Length> list3 = c4712k0.p;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : c4712k0.p.get(0).floatValueX(this);
            List<SVG.Length> list4 = c4712k0.q;
            if (list4 != null && list4.size() != 0) {
                f = c4712k0.q.get(0).floatValueY(this);
            }
            if (this.d.a.textAnchor != SVG.Style.TextAnchor.Start) {
                float s = s(c4712k0);
                if (this.d.a.textAnchor == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                floatValueX -= s;
            }
            if (c4712k0.h == null) {
                C4758i c4758i = new C4758i(floatValueX, floatValueY);
                M(c4712k0, c4758i);
                RectF rectF = c4758i.c;
                c4712k0.h = new SVG.C4693b(rectF.left, rectF.top, rectF.width(), c4758i.c.height());
            }
            u(c4712k0);
            Path path2 = new Path();
            M(c4712k0, new C4756g(floatValueX + floatValueX2, floatValueY + f, path2));
            path.setFillType(X());
            path.addPath(path2, matrix);
        }
    }

    private Path k0(SVG.C4727t c4727t) {
        float floatValueX;
        float floatValueY;
        Path path;
        SVG.Length length = c4727t.s;
        if (length == null && c4727t.t == null) {
            floatValueX = 0.0f;
            floatValueY = 0.0f;
        } else {
            if (length == null) {
                floatValueX = c4727t.t.floatValueY(this);
            } else if (c4727t.t == null) {
                floatValueX = length.floatValueX(this);
            } else {
                floatValueX = length.floatValueX(this);
                floatValueY = c4727t.t.floatValueY(this);
            }
            floatValueY = floatValueX;
        }
        float min = Math.min(floatValueX, c4727t.q.floatValueX(this) / 2.0f);
        float min2 = Math.min(floatValueY, c4727t.r.floatValueY(this) / 2.0f);
        SVG.Length length2 = c4727t.o;
        float floatValueX2 = length2 != null ? length2.floatValueX(this) : 0.0f;
        SVG.Length length3 = c4727t.p;
        float floatValueY2 = length3 != null ? length3.floatValueY(this) : 0.0f;
        float floatValueX3 = c4727t.q.floatValueX(this);
        float floatValueY3 = c4727t.r.floatValueY(this);
        if (c4727t.h == null) {
            c4727t.h = new SVG.C4693b(floatValueX2, floatValueY2, floatValueX3, floatValueY3);
        }
        float f = floatValueX2 + floatValueX3;
        float f2 = floatValueY2 + floatValueY3;
        Path path2 = new Path();
        if (min != 0.0f && min2 != 0.0f) {
            float f3 = min * 0.5522848f;
            float f4 = 0.5522848f * min2;
            float f5 = floatValueY2 + min2;
            path2.moveTo(floatValueX2, f5);
            float f6 = f5 - f4;
            float f7 = floatValueX2 + min;
            float f8 = f7 - f3;
            path2.cubicTo(floatValueX2, f6, f8, floatValueY2, f7, floatValueY2);
            float f9 = f - min;
            path2.lineTo(f9, floatValueY2);
            float f10 = f9 + f3;
            path2.cubicTo(f10, floatValueY2, f, f6, f, f5);
            float f11 = f2 - min2;
            path2.lineTo(f, f11);
            float f12 = f11 + f4;
            path = path2;
            path2.cubicTo(f, f12, f10, f2, f9, f2);
            path.lineTo(f7, f2);
            path.cubicTo(f8, f2, floatValueX2, f12, floatValueX2, f11);
            path.lineTo(floatValueX2, f5);
        } else {
            path = path2;
            path.moveTo(floatValueX2, floatValueY2);
            path.lineTo(f, floatValueY2);
            path.lineTo(f, f2);
            path.lineTo(floatValueX2, f2);
            path.lineTo(floatValueX2, floatValueY2);
        }
        path.close();
        return path;
    }

    private void l(SVG.C4722p0 c4722p0, Path path, Matrix matrix) {
        f1(this.d, c4722p0);
        if (I() && i1()) {
            Matrix matrix2 = c4722p0.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.C4696c0 p = c4722p0.a.p(c4722p0.o);
            if (p == null) {
                N("Use reference '%s' not found", c4722p0.o);
                return;
            }
            u(c4722p0);
            j(p, false, path, matrix);
        }
    }

    private Path l0(SVG.C4712k0 c4712k0) {
        List<SVG.Length> list = c4712k0.n;
        float f = 0.0f;
        float floatValueX = (list == null || list.size() == 0) ? 0.0f : c4712k0.n.get(0).floatValueX(this);
        List<SVG.Length> list2 = c4712k0.o;
        float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : c4712k0.o.get(0).floatValueY(this);
        List<SVG.Length> list3 = c4712k0.p;
        float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : c4712k0.p.get(0).floatValueX(this);
        List<SVG.Length> list4 = c4712k0.q;
        if (list4 != null && list4.size() != 0) {
            f = c4712k0.q.get(0).floatValueY(this);
        }
        if (this.d.a.textAnchor != SVG.Style.TextAnchor.Start) {
            float s = s(c4712k0);
            if (this.d.a.textAnchor == SVG.Style.TextAnchor.Middle) {
                s /= 2.0f;
            }
            floatValueX -= s;
        }
        if (c4712k0.h == null) {
            C4758i c4758i = new C4758i(floatValueX, floatValueY);
            M(c4712k0, c4758i);
            RectF rectF = c4758i.c;
            c4712k0.h = new SVG.C4693b(rectF.left, rectF.top, rectF.width(), c4758i.c.height());
        }
        Path path = new Path();
        M(c4712k0, new C4756g(floatValueX + floatValueX2, floatValueY + f, path));
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, float f6, float f7, SVG.PathInterface pathInterface) {
        if (f == f6 && f2 == f7) {
            return;
        }
        if (f3 != 0.0f && f4 != 0.0f) {
            float abs = Math.abs(f3);
            float abs2 = Math.abs(f4);
            double radians = Math.toRadians(f5 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d = (f - f6) / 2.0d;
            double d2 = (f2 - f7) / 2.0d;
            double d3 = (cos * d) + (sin * d2);
            double d4 = ((-sin) * d) + (d2 * cos);
            double d5 = abs * abs;
            double d6 = abs2 * abs2;
            double d7 = d3 * d3;
            double d8 = d4 * d4;
            double d9 = (d7 / d5) + (d8 / d6);
            if (d9 > 0.99999d) {
                double sqrt = Math.sqrt(d9) * 1.00001d;
                abs = (float) (abs * sqrt);
                abs2 = (float) (sqrt * abs2);
                d5 = abs * abs;
                d6 = abs2 * abs2;
            }
            double d10 = z == z2 ? -1.0d : 1.0d;
            double d11 = d5 * d6;
            double d12 = d5 * d8;
            double d13 = d6 * d7;
            double d14 = ((d11 - d12) - d13) / (d12 + d13);
            if (d14 < 0.0d) {
                d14 = 0.0d;
            }
            double sqrt2 = d10 * Math.sqrt(d14);
            double d15 = abs;
            double d16 = abs2;
            double d17 = ((d15 * d4) / d16) * sqrt2;
            float f8 = abs;
            float f9 = abs2;
            double d18 = sqrt2 * (-((d16 * d3) / d15));
            double d19 = ((f + f6) / 2.0d) + ((cos * d17) - (sin * d18));
            double d20 = ((f2 + f7) / 2.0d) + (sin * d17) + (cos * d18);
            double d21 = (d3 - d17) / d15;
            double d22 = (d4 - d18) / d16;
            double d23 = ((-d3) - d17) / d15;
            double d24 = ((-d4) - d18) / d16;
            double d25 = (d21 * d21) + (d22 * d22);
            double acos = (d22 < 0.0d ? -1.0d : 1.0d) * Math.acos(d21 / Math.sqrt(d25));
            double B = ((d21 * d24) - (d22 * d23) >= 0.0d ? 1.0d : -1.0d) * B(((d21 * d23) + (d22 * d24)) / Math.sqrt(d25 * ((d23 * d23) + (d24 * d24))));
            int i = (B > 0.0d ? 1 : (B == 0.0d ? 0 : -1));
            if (i == 0) {
                pathInterface.lineTo(f6, f7);
                return;
            }
            if (!z2 && i > 0) {
                B -= 6.283185307179586d;
            } else if (z2 && B < 0.0d) {
                B += 6.283185307179586d;
            }
            float[] n = n(acos % 6.283185307179586d, B % 6.283185307179586d);
            if (n == null || n.length == 0) {
                return;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f8, f9);
            matrix.postRotate(f5);
            matrix.postTranslate((float) d19, (float) d20);
            matrix.mapPoints(n);
            n[n.length - 2] = f6;
            n[n.length - 1] = f7;
            for (int i2 = 0; i2 < n.length; i2 += 6) {
                pathInterface.cubicTo(n[i2], n[i2 + 1], n[i2 + 2], n[i2 + 3], n[i2 + 4], n[i2 + 5]);
            }
            return;
        }
        pathInterface.lineTo(f6, f7);
    }

    private void m0(boolean z, SVG.C4693b c4693b, SVG.C4700e0 c4700e0) {
        float f;
        float floatValue;
        float f2;
        String str = c4700e0.l;
        if (str != null) {
            P(c4700e0, str);
        }
        Boolean bool = c4700e0.i;
        int i = 0;
        boolean z2 = bool != null && bool.booleanValue();
        C4757h c4757h = this.d;
        Paint paint = z ? c4757h.d : c4757h.e;
        if (z2) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            SVG.Length length2 = c4700e0.m;
            float floatValueX = length2 != null ? length2.floatValueX(this) : length.floatValueX(this);
            SVG.Length length3 = c4700e0.n;
            float floatValueY = length3 != null ? length3.floatValueY(this) : length.floatValueY(this);
            SVG.Length length4 = c4700e0.o;
            floatValue = length4 != null ? length4.floatValue(this) : length.floatValue(this);
            f = floatValueX;
            f2 = floatValueY;
        } else {
            SVG.Length length5 = c4700e0.m;
            float floatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length6 = c4700e0.n;
            float floatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length7 = c4700e0.o;
            f = floatValue2;
            floatValue = length7 != null ? length7.floatValue(this, 1.0f) : 0.5f;
            f2 = floatValue3;
        }
        a1();
        this.d = U(c4700e0);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(c4693b.a, c4693b.b);
            matrix.preScale(c4693b.c, c4693b.d);
        }
        Matrix matrix2 = c4700e0.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = c4700e0.h.size();
        if (size == 0) {
            Z0();
            if (z) {
                this.d.b = false;
                return;
            } else {
                this.d.c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f3 = -1.0f;
        Iterator<SVG.C4696c0> it = c4700e0.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SVG.C4729v c4729v = (SVG.C4729v) it.next();
            Float f4 = c4729v.h;
            float floatValue4 = f4 != null ? f4.floatValue() : 0.0f;
            if (i != 0 && floatValue4 < f3) {
                fArr[i] = f3;
            } else {
                fArr[i] = floatValue4;
                f3 = floatValue4;
            }
            a1();
            f1(this.d, c4729v);
            SVG.Style style = this.d.a;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i] = F(colour.colour, style.stopOpacity.floatValue());
            i++;
            Z0();
        }
        if (floatValue != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = c4700e0.k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            Z0();
            RadialGradient radialGradient = new RadialGradient(f, f2, floatValue, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(C(this.d.a.fillOpacity.floatValue()));
            return;
        }
        Z0();
        paint.setColor(iArr[size - 1]);
    }

    private static float[] n(double d, double d2) {
        int ceil = (int) Math.ceil((Math.abs(d2) * 2.0d) / 3.141592653589793d);
        double d3 = d2 / ceil;
        double d4 = d3 / 2.0d;
        double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i = 0;
        for (int i2 = 0; i2 < ceil; i2++) {
            double d5 = d + (i2 * d3);
            double cos = Math.cos(d5);
            double sin2 = Math.sin(d5);
            int i3 = i + 1;
            fArr[i] = (float) (cos - (sin * sin2));
            int i4 = i3 + 1;
            fArr[i3] = (float) (sin2 + (cos * sin));
            d3 = d3;
            double d6 = d5 + d3;
            double cos2 = Math.cos(d6);
            double sin3 = Math.sin(d6);
            int i5 = i4 + 1;
            fArr[i4] = (float) ((sin * sin3) + cos2);
            int i6 = i5 + 1;
            fArr[i5] = (float) (sin3 - (sin * cos2));
            int i7 = i6 + 1;
            fArr[i6] = (float) cos2;
            i = i7 + 1;
            fArr[i7] = (float) sin3;
        }
        return fArr;
    }

    private SVG.C4693b n0(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.C4693b a0 = a0();
        return new SVG.C4693b(floatValueX, floatValueY, length3 != null ? length3.floatValueX(this) : a0.c, length4 != null ? length4.floatValueY(this) : a0.d);
    }

    @TargetApi(19)
    private Path o(SVG.AbstractC4733z abstractC4733z, SVG.C4693b c4693b) {
        Path o0;
        SVG.C4696c0 p = abstractC4733z.a.p(this.d.a.clipPath);
        boolean z = false;
        if (p == null) {
            N("ClipPath reference '%s' not found", this.d.a.clipPath);
            return null;
        }
        SVG.C4699e c4699e = (SVG.C4699e) p;
        this.e.push(this.d);
        this.d = U(c4699e);
        Boolean bool = c4699e.o;
        z = (bool == null || bool.booleanValue()) ? true : true;
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(c4693b.a, c4693b.b);
            matrix.preScale(c4693b.c, c4693b.d);
        }
        Matrix matrix2 = c4699e.n;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.C4696c0 c4696c0 : c4699e.i) {
            if ((c4696c0 instanceof SVG.AbstractC4733z) && (o0 = o0((SVG.AbstractC4733z) c4696c0, true)) != null) {
                path.op(o0, Path.Op.UNION);
            }
        }
        if (this.d.a.clipPath != null) {
            if (c4699e.h == null) {
                c4699e.h = r(path);
            }
            Path o = o(c4699e, c4699e.h);
            if (o != null) {
                path.op(o, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.d = this.e.pop();
        return path;
    }

    @TargetApi(19)
    private Path o0(SVG.AbstractC4733z abstractC4733z, boolean z) {
        Path l0;
        Path o;
        this.e.push(this.d);
        C4757h c4757h = new C4757h(this, this.d);
        this.d = c4757h;
        f1(c4757h, abstractC4733z);
        if (I() && i1()) {
            if (abstractC4733z instanceof SVG.C4722p0) {
                if (!z) {
                    N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
                SVG.C4722p0 c4722p0 = (SVG.C4722p0) abstractC4733z;
                SVG.C4696c0 p = abstractC4733z.a.p(c4722p0.o);
                if (p == null) {
                    N("Use reference '%s' not found", c4722p0.o);
                    this.d = this.e.pop();
                    return null;
                } else if (!(p instanceof SVG.AbstractC4733z)) {
                    this.d = this.e.pop();
                    return null;
                } else {
                    l0 = o0((SVG.AbstractC4733z) p, false);
                    if (l0 == null) {
                        return null;
                    }
                    if (c4722p0.h == null) {
                        c4722p0.h = r(l0);
                    }
                    Matrix matrix = c4722p0.n;
                    if (matrix != null) {
                        l0.transform(matrix);
                    }
                }
            } else if (abstractC4733z instanceof SVG.AbstractC4707i) {
                SVG.AbstractC4707i abstractC4707i = (SVG.AbstractC4707i) abstractC4733z;
                if (abstractC4733z instanceof SVG.C4719o) {
                    l0 = new C4753d(((SVG.C4719o) abstractC4733z).o).a();
                    if (abstractC4733z.h == null) {
                        abstractC4733z.h = r(l0);
                    }
                } else {
                    l0 = abstractC4733z instanceof SVG.C4727t ? k0((SVG.C4727t) abstractC4733z) : abstractC4733z instanceof SVG.C4697d ? g0((SVG.C4697d) abstractC4733z) : abstractC4733z instanceof SVG.C4703g ? h0((SVG.C4703g) abstractC4733z) : abstractC4733z instanceof SVG.C4725r ? j0((SVG.C4725r) abstractC4733z) : null;
                }
                if (l0 == null) {
                    return null;
                }
                if (abstractC4707i.h == null) {
                    abstractC4707i.h = r(l0);
                }
                Matrix matrix2 = abstractC4707i.n;
                if (matrix2 != null) {
                    l0.transform(matrix2);
                }
                l0.setFillType(X());
            } else if (!(abstractC4733z instanceof SVG.C4712k0)) {
                N("Invalid %s element found in clipPath definition", abstractC4733z.a());
                return null;
            } else {
                SVG.C4712k0 c4712k0 = (SVG.C4712k0) abstractC4733z;
                l0 = l0(c4712k0);
                if (l0 == null) {
                    return null;
                }
                Matrix matrix3 = c4712k0.r;
                if (matrix3 != null) {
                    l0.transform(matrix3);
                }
                l0.setFillType(X());
            }
            if (this.d.a.clipPath != null && (o = o(abstractC4733z, abstractC4733z.h)) != null) {
                l0.op(o, Path.Op.INTERSECT);
            }
            this.d = this.e.pop();
            return l0;
        }
        this.d = this.e.pop();
        return null;
    }

    private List<C4752c> p(SVG.C4713l c4713l) {
        SVG.Length length = c4713l.o;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = c4713l.p;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Length length3 = c4713l.q;
        float floatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
        SVG.Length length4 = c4713l.r;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f = floatValueX2 - floatValueX;
        float f2 = floatValueY2 - floatValueY;
        arrayList.add(new C4752c(this, floatValueX, floatValueY, f, f2));
        arrayList.add(new C4752c(this, floatValueX2, floatValueY2, f, f2));
        return arrayList;
    }

    private void p0() {
        this.f.pop();
        this.g.pop();
    }

    private List<C4752c> q(SVG.C4725r c4725r) {
        int length = c4725r.o.length;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = c4725r.o;
        C4752c c4752c = new C4752c(this, fArr[0], fArr[1], 0.0f, 0.0f);
        float f = 0.0f;
        float f2 = 0.0f;
        while (i < length) {
            float[] fArr2 = c4725r.o;
            float f3 = fArr2[i];
            float f4 = fArr2[i + 1];
            c4752c.a(f3, f4);
            arrayList.add(c4752c);
            i += 2;
            c4752c = new C4752c(this, f3, f4, f3 - c4752c.a, f4 - c4752c.b);
            f2 = f4;
            f = f3;
        }
        if (c4725r instanceof SVG.C4726s) {
            float[] fArr3 = c4725r.o;
            if (f != fArr3[0] && f2 != fArr3[1]) {
                float f5 = fArr3[0];
                float f6 = fArr3[1];
                c4752c.a(f5, f6);
                arrayList.add(c4752c);
                C4752c c4752c2 = new C4752c(this, f5, f6, f5 - c4752c.a, f6 - c4752c.b);
                c4752c2.b((C4752c) arrayList.get(0));
                arrayList.add(c4752c2);
                arrayList.set(0, c4752c2);
            }
        } else {
            arrayList.add(c4752c);
        }
        return arrayList;
    }

    private void q0(SVG.SvgContainer svgContainer) {
        this.f.push(svgContainer);
        this.g.push(this.a.getMatrix());
    }

    private SVG.C4693b r(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.C4693b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void r0(SVG.AbstractC4733z abstractC4733z) {
        s0(abstractC4733z, abstractC4733z.h);
    }

    private float s(SVG.AbstractC4714l0 abstractC4714l0) {
        C4760k c4760k = new C4760k(this, null);
        M(abstractC4714l0, c4760k);
        return c4760k.a;
    }

    private void s0(SVG.AbstractC4733z abstractC4733z, SVG.C4693b c4693b) {
        if (this.d.a.mask != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.a.saveLayer(null, paint2, 31);
            SVG.C4717n c4717n = (SVG.C4717n) this.c.p(this.d.a.mask);
            R0(c4717n, abstractC4733z, c4693b);
            this.a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.a.saveLayer(null, paint3, 31);
            R0(c4717n, abstractC4733z, c4693b);
            this.a.restore();
            this.a.restore();
        }
        Z0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
        if (r12 != 8) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Matrix t(com.caverock.androidsvg.SVG.C4693b r10, com.caverock.androidsvg.SVG.C4693b r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L9b
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r12.a()
            if (r1 != 0) goto Lf
            goto L9b
        Lf:
            float r1 = r10.c
            float r2 = r11.c
            float r1 = r1 / r2
            float r2 = r10.d
            float r3 = r11.d
            float r2 = r2 / r3
            float r3 = r11.a
            float r3 = -r3
            float r4 = r11.b
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.STRETCH
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L35
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L35:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r12.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.slice
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r10.c
            float r2 = r2 / r1
            float r5 = r10.d
            float r5 = r5 / r1
            int[] r6 = com.caverock.androidsvg.C4749e.C4750a.a
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r12.a()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L62;
                case 2: goto L62;
                case 3: goto L62;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L67
        L5e:
            float r7 = r11.c
            float r7 = r7 - r2
            goto L66
        L62:
            float r7 = r11.c
            float r7 = r7 - r2
            float r7 = r7 / r8
        L66:
            float r3 = r3 - r7
        L67:
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L89
            r2 = 3
            if (r12 == r2) goto L85
            r2 = 5
            if (r12 == r2) goto L89
            r2 = 6
            if (r12 == r2) goto L85
            r2 = 7
            if (r12 == r2) goto L89
            r2 = 8
            if (r12 == r2) goto L85
            goto L8e
        L85:
            float r11 = r11.d
            float r11 = r11 - r5
            goto L8d
        L89:
            float r11 = r11.d
            float r11 = r11 - r5
            float r11 = r11 / r8
        L8d:
            float r4 = r4 - r11
        L8e:
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.C4749e.t(com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private void t0(SVG.C4696c0 c4696c0, AbstractC4759j abstractC4759j) {
        float f;
        float f2;
        float f3;
        SVG.Style.TextAnchor W;
        if (abstractC4759j.a((SVG.AbstractC4714l0) c4696c0)) {
            if (c4696c0 instanceof SVG.C4716m0) {
                a1();
                T0((SVG.C4716m0) c4696c0);
                Z0();
                return;
            }
            boolean z = true;
            if (c4696c0 instanceof SVG.C4710j0) {
                G("TSpan render", new Object[0]);
                a1();
                SVG.C4710j0 c4710j0 = (SVG.C4710j0) c4696c0;
                f1(this.d, c4710j0);
                if (I()) {
                    List<SVG.Length> list = c4710j0.n;
                    z = (list == null || list.size() <= 0) ? false : false;
                    boolean z2 = abstractC4759j instanceof C4755f;
                    float f4 = 0.0f;
                    if (z2) {
                        float floatValueX = !z ? ((C4755f) abstractC4759j).a : c4710j0.n.get(0).floatValueX(this);
                        List<SVG.Length> list2 = c4710j0.o;
                        f2 = (list2 == null || list2.size() == 0) ? ((C4755f) abstractC4759j).b : c4710j0.o.get(0).floatValueY(this);
                        List<SVG.Length> list3 = c4710j0.p;
                        f3 = (list3 == null || list3.size() == 0) ? 0.0f : c4710j0.p.get(0).floatValueX(this);
                        List<SVG.Length> list4 = c4710j0.q;
                        if (list4 != null && list4.size() != 0) {
                            f4 = c4710j0.q.get(0).floatValueY(this);
                        }
                        f = f4;
                        f4 = floatValueX;
                    } else {
                        f = 0.0f;
                        f2 = 0.0f;
                        f3 = 0.0f;
                    }
                    if (z && (W = W()) != SVG.Style.TextAnchor.Start) {
                        float s = s(c4710j0);
                        if (W == SVG.Style.TextAnchor.Middle) {
                            s /= 2.0f;
                        }
                        f4 -= s;
                    }
                    x((SVG.AbstractC4733z) c4710j0.getTextRoot());
                    if (z2) {
                        C4755f c4755f = (C4755f) abstractC4759j;
                        c4755f.a = f4 + f3;
                        c4755f.b = f2 + f;
                    }
                    boolean u0 = u0();
                    M(c4710j0, abstractC4759j);
                    if (u0) {
                        r0(c4710j0);
                    }
                }
                Z0();
            } else if (c4696c0 instanceof SVG.C4708i0) {
                a1();
                SVG.C4708i0 c4708i0 = (SVG.C4708i0) c4696c0;
                f1(this.d, c4708i0);
                if (I()) {
                    x((SVG.AbstractC4733z) c4708i0.getTextRoot());
                    SVG.C4696c0 p = c4696c0.a.p(c4708i0.n);
                    if (p == null || !(p instanceof SVG.AbstractC4714l0)) {
                        N("Tref reference '%s' not found", c4708i0.n);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        O((SVG.AbstractC4714l0) p, sb);
                        if (sb.length() > 0) {
                            abstractC4759j.b(sb.toString());
                        }
                    }
                }
                Z0();
            }
        }
    }

    private void u(SVG.AbstractC4733z abstractC4733z) {
        v(abstractC4733z, abstractC4733z.h);
    }

    private boolean u0() {
        SVG.C4696c0 p;
        if (U0()) {
            this.a.saveLayerAlpha(null, C(this.d.a.opacity.floatValue()), 31);
            this.e.push(this.d);
            C4757h c4757h = new C4757h(this, this.d);
            this.d = c4757h;
            String str = c4757h.a.mask;
            if (str != null && ((p = this.c.p(str)) == null || !(p instanceof SVG.C4717n))) {
                N("Mask reference '%s' not found", this.d.a.mask);
                this.d.a.mask = null;
            }
            return true;
        }
        return false;
    }

    private void v(SVG.AbstractC4733z abstractC4733z, SVG.C4693b c4693b) {
        if (this.d.a.clipPath == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Path o = o(abstractC4733z, c4693b);
            if (o != null) {
                this.a.clipPath(o);
                return;
            }
            return;
        }
        w(abstractC4733z, c4693b);
    }

    private C4752c v0(C4752c c4752c, C4752c c4752c2, C4752c c4752c3) {
        float L = L(c4752c2.c, c4752c2.d, c4752c2.a - c4752c.a, c4752c2.b - c4752c.b);
        if (L == 0.0f) {
            L = L(c4752c2.c, c4752c2.d, c4752c3.a - c4752c2.a, c4752c3.b - c4752c2.b);
        }
        int i = (L > 0.0f ? 1 : (L == 0.0f ? 0 : -1));
        if (i > 0) {
            return c4752c2;
        }
        if (i != 0 || (c4752c2.c <= 0.0f && c4752c2.d < 0.0f)) {
            c4752c2.c = -c4752c2.c;
            c4752c2.d = -c4752c2.d;
            return c4752c2;
        }
        return c4752c2;
    }

    private void w(SVG.AbstractC4733z abstractC4733z, SVG.C4693b c4693b) {
        SVG.C4696c0 p = abstractC4733z.a.p(this.d.a.clipPath);
        if (p == null) {
            N("ClipPath reference '%s' not found", this.d.a.clipPath);
            return;
        }
        SVG.C4699e c4699e = (SVG.C4699e) p;
        if (c4699e.i.isEmpty()) {
            this.a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = c4699e.o;
        boolean z = bool == null || bool.booleanValue();
        if ((abstractC4733z instanceof SVG.C4709j) && !z) {
            j1("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", abstractC4733z.a());
            return;
        }
        E();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(c4693b.a, c4693b.b);
            matrix.preScale(c4693b.c, c4693b.d);
            this.a.concat(matrix);
        }
        Matrix matrix2 = c4699e.n;
        if (matrix2 != null) {
            this.a.concat(matrix2);
        }
        this.d = U(c4699e);
        u(c4699e);
        Path path = new Path();
        for (SVG.C4696c0 c4696c0 : c4699e.i) {
            j(c4696c0, true, path, new Matrix());
        }
        this.a.clipPath(path);
        D();
    }

    private void w0(SVG.C4697d c4697d) {
        G("Circle render", new Object[0]);
        SVG.Length length = c4697d.q;
        if (length == null || length.isZero()) {
            return;
        }
        f1(this.d, c4697d);
        if (I() && i1()) {
            Matrix matrix = c4697d.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path g0 = g0(c4697d);
            d1(c4697d);
            x(c4697d);
            u(c4697d);
            boolean u0 = u0();
            if (this.d.b) {
                J(c4697d, g0);
            }
            if (this.d.c) {
                K(g0);
            }
            if (u0) {
                r0(c4697d);
            }
        }
    }

    private void x(SVG.AbstractC4733z abstractC4733z) {
        SVG.SvgPaint svgPaint = this.d.a.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            H(true, abstractC4733z.h, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = this.d.a.stroke;
        if (svgPaint2 instanceof SVG.PaintReference) {
            H(false, abstractC4733z.h, (SVG.PaintReference) svgPaint2);
        }
    }

    private void x0(SVG.C4703g c4703g) {
        G("Ellipse render", new Object[0]);
        SVG.Length length = c4703g.q;
        if (length == null || c4703g.r == null || length.isZero() || c4703g.r.isZero()) {
            return;
        }
        f1(this.d, c4703g);
        if (I() && i1()) {
            Matrix matrix = c4703g.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path h0 = h0(c4703g);
            d1(c4703g);
            x(c4703g);
            u(c4703g);
            boolean u0 = u0();
            if (this.d.b) {
                J(c4703g, h0);
            }
            if (this.d.c) {
                K(h0);
            }
            if (u0) {
                r0(c4703g);
            }
        }
    }

    private Bitmap y(String str) {
        int indexOf;
        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
            try {
                byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception e) {
                Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e);
                return null;
            }
        }
        return null;
    }

    private void y0(SVG.C4709j c4709j) {
        G("Group render", new Object[0]);
        f1(this.d, c4709j);
        if (I()) {
            Matrix matrix = c4709j.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            u(c4709j);
            boolean u0 = u0();
            N0(c4709j, true);
            if (u0) {
                r0(c4709j);
            }
            d1(c4709j);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        if (r6.equals("monospace") == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Typeface z(java.lang.String r6, java.lang.Integer r7, com.caverock.androidsvg.SVG.Style.FontStyle r8) {
        /*
            r5 = this;
            com.caverock.androidsvg.SVG$Style$FontStyle r0 = com.caverock.androidsvg.SVG.Style.FontStyle.Italic
            r1 = 1
            r2 = 0
            if (r8 != r0) goto L8
            r8 = 1
            goto L9
        L8:
            r8 = 0
        L9:
            int r7 = r7.intValue()
            r0 = 500(0x1f4, float:7.0E-43)
            r3 = 3
            r4 = 2
            if (r7 <= r0) goto L19
            if (r8 == 0) goto L17
            r7 = 3
            goto L1e
        L17:
            r7 = 1
            goto L1e
        L19:
            if (r8 == 0) goto L1d
            r7 = 2
            goto L1e
        L1d:
            r7 = 0
        L1e:
            r6.hashCode()
            r8 = -1
            int r0 = r6.hashCode()
            switch(r0) {
                case -1536685117: goto L55;
                case -1431958525: goto L4c;
                case -1081737434: goto L41;
                case 109326717: goto L36;
                case 1126973893: goto L2b;
                default: goto L29;
            }
        L29:
            r1 = -1
            goto L5f
        L2b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L34
            goto L29
        L34:
            r1 = 4
            goto L5f
        L36:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L3f
            goto L29
        L3f:
            r1 = 3
            goto L5f
        L41:
            java.lang.String r0 = "fantasy"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L4a
            goto L29
        L4a:
            r1 = 2
            goto L5f
        L4c:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L5f
            goto L29
        L55:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L5e
            goto L29
        L5e:
            r1 = 0
        L5f:
            switch(r1) {
                case 0: goto L80;
                case 1: goto L79;
                case 2: goto L72;
                case 3: goto L6b;
                case 4: goto L64;
                default: goto L62;
            }
        L62:
            r6 = 0
            goto L86
        L64:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L6b:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L72:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L79:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L80:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L86:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.C4749e.z(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    private void z0(SVG.C4711k c4711k) {
        SVG.Length length;
        String str;
        G("Image render", new Object[0]);
        SVG.Length length2 = c4711k.r;
        if (length2 == null || length2.isZero() || (length = c4711k.s) == null || length.isZero() || (str = c4711k.o) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = c4711k.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        Bitmap y = y(str);
        if (y == null) {
            SVG.g();
            return;
        }
        SVG.C4693b c4693b = new SVG.C4693b(0.0f, 0.0f, y.getWidth(), y.getHeight());
        f1(this.d, c4711k);
        if (I() && i1()) {
            Matrix matrix = c4711k.t;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            SVG.Length length3 = c4711k.p;
            float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = c4711k.q;
            this.d.f = new SVG.C4693b(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f, c4711k.r.floatValueX(this), c4711k.s.floatValueX(this));
            if (!this.d.a.overflow.booleanValue()) {
                SVG.C4693b c4693b2 = this.d.f;
                W0(c4693b2.a, c4693b2.b, c4693b2.c, c4693b2.d);
            }
            c4711k.h = this.d.f;
            d1(c4711k);
            u(c4711k);
            boolean u0 = u0();
            h1();
            this.a.save();
            this.a.concat(t(this.d.f, c4693b, preserveAspectRatio));
            this.a.drawBitmap(y, 0.0f, 0.0f, new Paint(this.d.a.imageRendering != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.a.restore();
            if (u0) {
                r0(c4711k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(SVG svg, C4748d c4748d) {
        SVG.C4693b c4693b;
        PreserveAspectRatio preserveAspectRatio;
        Objects.requireNonNull(c4748d, "renderOptions shouldn't be null");
        this.c = svg;
        SVG.C4730w l = svg.l();
        if (l == null) {
            j1("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (c4748d.e()) {
            SVG.AbstractC4692a0 f = this.c.f(c4748d.e);
            if (f == null || !(f instanceof SVG.C4724q0)) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", c4748d.e));
                return;
            }
            SVG.C4724q0 c4724q0 = (SVG.C4724q0) f;
            c4693b = c4724q0.o;
            if (c4693b == null) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", c4748d.e));
                return;
            }
            preserveAspectRatio = c4724q0.n;
        } else {
            c4693b = c4748d.f() ? c4748d.d : l.o;
            preserveAspectRatio = c4748d.c() ? c4748d.b : l.n;
        }
        if (c4748d.b()) {
            svg.a(c4748d.a);
        }
        if (c4748d.d()) {
            CSSParser.C4687l c4687l = new CSSParser.C4687l();
            this.h = c4687l;
            c4687l.a = svg.f(c4748d.c);
        }
        V0();
        A(l);
        a1();
        SVG.C4693b c4693b2 = new SVG.C4693b(c4748d.f);
        SVG.Length length = l.r;
        if (length != null) {
            c4693b2.c = length.floatValue(this, c4693b2.c);
        }
        SVG.Length length2 = l.s;
        if (length2 != null) {
            c4693b2.d = length2.floatValue(this, c4693b2.d);
        }
        H0(l, c4693b2, c4693b, preserveAspectRatio);
        Z0();
        if (c4748d.b()) {
            svg.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float Y() {
        return this.d.d.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float Z() {
        return this.d.d.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG.C4693b a0() {
        C4757h c4757h = this.d;
        SVG.C4693b c4693b = c4757h.g;
        return c4693b != null ? c4693b : c4757h.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b0() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$k */
    /* loaded from: classes10.dex */
    public class C4760k extends AbstractC4759j {
        float a;

        private C4760k() {
            super(C4749e.this, null);
            this.a = 0.0f;
        }

        @Override // com.caverock.androidsvg.C4749e.AbstractC4759j
        public void b(String str) {
            this.a += C4749e.this.d.d.measureText(str);
        }

        /* synthetic */ C4760k(C4749e c4749e, C4750a c4750a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.e$h */
    /* loaded from: classes10.dex */
    public class C4757h {
        SVG.Style a;
        boolean b;
        boolean c;
        Paint d;
        Paint e;
        SVG.C4693b f;
        SVG.C4693b g;
        boolean h;

        C4757h(C4749e c4749e) {
            Paint paint = new Paint();
            this.d = paint;
            paint.setFlags(193);
            int i = Build.VERSION.SDK_INT;
            if (i >= 14) {
                this.d.setHinting(0);
            }
            this.d.setStyle(Paint.Style.FILL);
            this.d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setFlags(193);
            if (i >= 14) {
                this.e.setHinting(0);
            }
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setTypeface(Typeface.DEFAULT);
            this.a = SVG.Style.getDefaultStyle();
        }

        C4757h(C4749e c4749e, C4757h c4757h) {
            this.b = c4757h.b;
            this.c = c4757h.c;
            this.d = new Paint(c4757h.d);
            this.e = new Paint(c4757h.e);
            SVG.C4693b c4693b = c4757h.f;
            if (c4693b != null) {
                this.f = new SVG.C4693b(c4693b);
            }
            SVG.C4693b c4693b2 = c4757h.g;
            if (c4693b2 != null) {
                this.g = new SVG.C4693b(c4693b2);
            }
            this.h = c4757h.h;
            try {
                this.a = (SVG.Style) c4757h.a.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
                this.a = SVG.Style.getDefaultStyle();
            }
        }
    }
}
