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
/* loaded from: classes10.dex */
public class e {
    public static final float LUMINANCE_TO_ALPHA_BLUE = 0.0722f;
    public static final float LUMINANCE_TO_ALPHA_GREEN = 0.7151f;
    public static final float LUMINANCE_TO_ALPHA_RED = 0.2127f;
    private static HashSet<String> j;
    private Canvas a;
    private float b;
    private SVG c;
    private h d;
    private Stack<h> e;
    private Stack<SVG.SvgContainer> f;
    private Stack<Matrix> g;
    private CSSParser.l h = null;
    int i = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
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
    /* loaded from: classes10.dex */
    public class b implements SVG.PathInterface {
        private float b;
        private float c;
        private boolean h;
        private List<c> a = new ArrayList();
        private c d = null;
        private boolean e = false;
        private boolean f = true;
        private int g = -1;

        b(SVG.p pVar) {
            if (pVar == null) {
                return;
            }
            pVar.c(this);
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
        }

        List<c> a() {
            return this.a;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            this.e = true;
            this.f = false;
            c cVar = this.d;
            e.m(cVar.a, cVar.b, f, f2, f3, z, z2, f4, f5, this);
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
            this.d = new c(e.this, f5, f6, f5 - f3, f6 - f4);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f, float f2) {
            this.d.a(f, f2);
            this.a.add(this.d);
            e eVar = e.this;
            c cVar = this.d;
            this.d = new c(eVar, f, f2, f - cVar.a, f2 - cVar.b);
            this.h = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f, float f2) {
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
            this.b = f;
            this.c = f2;
            this.d = new c(e.this, f, f2, 0.0f, 0.0f);
            this.g = this.a.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f, float f2, float f3, float f4) {
            this.d.a(f, f2);
            this.a.add(this.d);
            this.d = new c(e.this, f3, f4, f3 - f, f4 - f2);
            this.h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class c {
        float a;
        float b;
        float c;
        float d;
        boolean e = false;

        c(e eVar, float f, float f2, float f3, float f4) {
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

        void b(c cVar) {
            float f = cVar.c;
            float f2 = this.c;
            if (f == (-f2)) {
                float f3 = cVar.d;
                if (f3 == (-this.d)) {
                    this.e = true;
                    this.c = -f3;
                    this.d = cVar.c;
                    return;
                }
            }
            this.c = f2 + f;
            this.d += cVar.d;
        }

        public String toString() {
            return jn1.BRACKET_START_STR + this.a + "," + this.b + " " + this.c + "," + this.d + jn1.BRACKET_END_STR;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d implements SVG.PathInterface {
        Path a = new Path();
        float b;
        float c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(SVG.p pVar) {
            if (pVar == null) {
                return;
            }
            pVar.c(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path a() {
            return this.a;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            e.m(this.b, this.c, f, f2, f3, z, z2, f4, f5, this);
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
    /* renamed from: com.caverock.androidsvg.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0219e extends f {
        private Path d;

        C0219e(Path path, float f, float f2) {
            super(f, f2);
            this.d = path;
        }

        @Override // com.caverock.androidsvg.e.f, com.caverock.androidsvg.e.j
        public void b(String str) {
            if (e.this.i1()) {
                if (e.this.d.b) {
                    e.this.a.drawTextOnPath(str, this.d, this.a, this.b, e.this.d.d);
                }
                if (e.this.d.c) {
                    e.this.a.drawTextOnPath(str, this.d, this.a, this.b, e.this.d.e);
                }
            }
            this.a += e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class f extends j {
        float a;
        float b;

        f(float f, float f2) {
            super(e.this, null);
            this.a = f;
            this.b = f2;
        }

        @Override // com.caverock.androidsvg.e.j
        public void b(String str) {
            e.G("TextSequence render", new Object[0]);
            if (e.this.i1()) {
                if (e.this.d.b) {
                    e.this.a.drawText(str, this.a, this.b, e.this.d.d);
                }
                if (e.this.d.c) {
                    e.this.a.drawText(str, this.a, this.b, e.this.d.e);
                }
            }
            this.a += e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class g extends j {
        float a;
        float b;
        Path c;

        g(float f, float f2, Path path) {
            super(e.this, null);
            this.a = f;
            this.b = f2;
            this.c = path;
        }

        @Override // com.caverock.androidsvg.e.j
        public boolean a(SVG.l0 l0Var) {
            if (l0Var instanceof SVG.m0) {
                e.j1("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.e.j
        public void b(String str) {
            if (e.this.i1()) {
                Path path = new Path();
                e.this.d.d.getTextPath(str, 0, str.length(), this.a, this.b, path);
                this.c.addPath(path);
            }
            this.a += e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class i extends j {
        float a;
        float b;
        RectF c;

        i(float f, float f2) {
            super(e.this, null);
            this.c = new RectF();
            this.a = f;
            this.b = f2;
        }

        @Override // com.caverock.androidsvg.e.j
        public boolean a(SVG.l0 l0Var) {
            if (l0Var instanceof SVG.m0) {
                SVG.m0 m0Var = (SVG.m0) l0Var;
                SVG.c0 p = l0Var.a.p(m0Var.n);
                if (p == null) {
                    e.N("TextPath path reference '%s' not found", m0Var.n);
                    return false;
                }
                SVG.o oVar = (SVG.o) p;
                Path a = new d(oVar.o).a();
                Matrix matrix = oVar.n;
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

        @Override // com.caverock.androidsvg.e.j
        public void b(String str) {
            if (e.this.i1()) {
                Rect rect = new Rect();
                e.this.d.d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.a, this.b);
                this.c.union(rectF);
            }
            this.a += e.this.d.d.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public abstract class j {
        private j(e eVar) {
        }

        public boolean a(SVG.l0 l0Var) {
            return true;
        }

        public abstract void b(String str);

        /* synthetic */ j(e eVar, a aVar) {
            this(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Canvas canvas, float f2) {
        this.a = canvas;
        this.b = f2;
    }

    private void A(SVG.c0 c0Var) {
        Boolean bool;
        if ((c0Var instanceof SVG.a0) && (bool = ((SVG.a0) c0Var).d) != null) {
            this.d.h = bool.booleanValue();
        }
    }

    private void A0(SVG.l lVar) {
        G("Line render", new Object[0]);
        f1(this.d, lVar);
        if (I() && i1() && this.d.c) {
            Matrix matrix = lVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path i0 = i0(lVar);
            d1(lVar);
            x(lVar);
            u(lVar);
            boolean u0 = u0();
            K(i0);
            Q0(lVar);
            if (u0) {
                r0(lVar);
            }
        }
    }

    private static double B(double d2) {
        if (d2 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d2 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d2);
    }

    private void B0(SVG.o oVar) {
        G("Path render", new Object[0]);
        if (oVar.o == null) {
            return;
        }
        f1(this.d, oVar);
        if (I() && i1()) {
            h hVar = this.d;
            if (hVar.c || hVar.b) {
                Matrix matrix = oVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path a2 = new d(oVar.o).a();
                if (oVar.h == null) {
                    oVar.h = r(a2);
                }
                d1(oVar);
                x(oVar);
                u(oVar);
                boolean u0 = u0();
                if (this.d.b) {
                    a2.setFillType(c0());
                    J(oVar, a2);
                }
                if (this.d.c) {
                    K(a2);
                }
                Q0(oVar);
                if (u0) {
                    r0(oVar);
                }
            }
        }
    }

    private static int C(float f2) {
        int i2 = (int) (f2 * 256.0f);
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    private void C0(SVG.r rVar) {
        G("PolyLine render", new Object[0]);
        f1(this.d, rVar);
        if (I() && i1()) {
            h hVar = this.d;
            if (hVar.c || hVar.b) {
                Matrix matrix = rVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (rVar.o.length < 2) {
                    return;
                }
                Path j0 = j0(rVar);
                d1(rVar);
                j0.setFillType(c0());
                x(rVar);
                u(rVar);
                boolean u0 = u0();
                if (this.d.b) {
                    J(rVar, j0);
                }
                if (this.d.c) {
                    K(j0);
                }
                Q0(rVar);
                if (u0) {
                    r0(rVar);
                }
            }
        }
    }

    private void D() {
        this.a.restore();
        this.d = this.e.pop();
    }

    private void D0(SVG.s sVar) {
        G("Polygon render", new Object[0]);
        f1(this.d, sVar);
        if (I() && i1()) {
            h hVar = this.d;
            if (hVar.c || hVar.b) {
                Matrix matrix = sVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (sVar.o.length < 2) {
                    return;
                }
                Path j0 = j0(sVar);
                d1(sVar);
                x(sVar);
                u(sVar);
                boolean u0 = u0();
                if (this.d.b) {
                    J(sVar, j0);
                }
                if (this.d.c) {
                    K(j0);
                }
                Q0(sVar);
                if (u0) {
                    r0(sVar);
                }
            }
        }
    }

    private void E() {
        com.caverock.androidsvg.a.a(this.a, com.caverock.androidsvg.a.a);
        this.e.push(this.d);
        this.d = new h(this, this.d);
    }

    private void E0(SVG.t tVar) {
        G("Rect render", new Object[0]);
        SVG.Length length = tVar.q;
        if (length == null || tVar.r == null || length.isZero() || tVar.r.isZero()) {
            return;
        }
        f1(this.d, tVar);
        if (I() && i1()) {
            Matrix matrix = tVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path k0 = k0(tVar);
            d1(tVar);
            x(tVar);
            u(tVar);
            boolean u0 = u0();
            if (this.d.b) {
                J(tVar, k0);
            }
            if (this.d.c) {
                K(k0);
            }
            if (u0) {
                r0(tVar);
            }
        }
    }

    private static int F(int i2, float f2) {
        int i3 = 255;
        int round = Math.round(((i2 >> 24) & 255) * f2);
        if (round < 0) {
            i3 = 0;
        } else if (round <= 255) {
            i3 = round;
        }
        return (i2 & 16777215) | (i3 << 24);
    }

    private void F0(SVG.w wVar) {
        H0(wVar, n0(wVar.p, wVar.q, wVar.r, wVar.s), wVar.o, wVar.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(String str, Object... objArr) {
    }

    private void G0(SVG.w wVar, SVG.b bVar) {
        H0(wVar, bVar, wVar.o, wVar.n);
    }

    private void H(boolean z, SVG.b bVar, SVG.PaintReference paintReference) {
        SVG.c0 p = this.c.p(paintReference.href);
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
        } else if (p instanceof SVG.b0) {
            f0(z, bVar, (SVG.b0) p);
        } else if (p instanceof SVG.e0) {
            m0(z, bVar, (SVG.e0) p);
        } else if (p instanceof SVG.u) {
            Y0(z, (SVG.u) p);
        }
    }

    private void H0(SVG.w wVar, SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        G("Svg render", new Object[0]);
        if (bVar.c == 0.0f || bVar.d == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null && (preserveAspectRatio = wVar.n) == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        f1(this.d, wVar);
        if (I()) {
            h hVar = this.d;
            hVar.f = bVar;
            if (!hVar.a.overflow.booleanValue()) {
                SVG.b bVar3 = this.d.f;
                W0(bVar3.a, bVar3.b, bVar3.c, bVar3.d);
            }
            v(wVar, this.d.f);
            if (bVar2 != null) {
                this.a.concat(t(this.d.f, bVar2, preserveAspectRatio));
                this.d.g = wVar.o;
            } else {
                Canvas canvas = this.a;
                SVG.b bVar4 = this.d.f;
                canvas.translate(bVar4.a, bVar4.b);
            }
            boolean u0 = u0();
            h1();
            N0(wVar, true);
            if (u0) {
                r0(wVar);
            }
            d1(wVar);
        }
    }

    private boolean I() {
        Boolean bool = this.d.a.display;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void I0(SVG.c0 c0Var) {
        if (c0Var instanceof SVG.NotDirectlyRendered) {
            return;
        }
        a1();
        A(c0Var);
        if (c0Var instanceof SVG.w) {
            F0((SVG.w) c0Var);
        } else if (c0Var instanceof SVG.p0) {
            M0((SVG.p0) c0Var);
        } else if (c0Var instanceof SVG.g0) {
            J0((SVG.g0) c0Var);
        } else if (c0Var instanceof SVG.j) {
            y0((SVG.j) c0Var);
        } else if (c0Var instanceof SVG.k) {
            z0((SVG.k) c0Var);
        } else if (c0Var instanceof SVG.o) {
            B0((SVG.o) c0Var);
        } else if (c0Var instanceof SVG.t) {
            E0((SVG.t) c0Var);
        } else if (c0Var instanceof SVG.d) {
            w0((SVG.d) c0Var);
        } else if (c0Var instanceof SVG.g) {
            x0((SVG.g) c0Var);
        } else if (c0Var instanceof SVG.l) {
            A0((SVG.l) c0Var);
        } else if (c0Var instanceof SVG.s) {
            D0((SVG.s) c0Var);
        } else if (c0Var instanceof SVG.r) {
            C0((SVG.r) c0Var);
        } else if (c0Var instanceof SVG.k0) {
            L0((SVG.k0) c0Var);
        }
        Z0();
    }

    private void J(SVG.z zVar, Path path) {
        SVG.SvgPaint svgPaint = this.d.a.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.c0 p = this.c.p(((SVG.PaintReference) svgPaint).href);
            if (p instanceof SVG.q) {
                T(zVar, path, (SVG.q) p);
                return;
            }
        }
        this.a.drawPath(path, this.d.d);
    }

    private void J0(SVG.g0 g0Var) {
        G("Switch render", new Object[0]);
        f1(this.d, g0Var);
        if (I()) {
            Matrix matrix = g0Var.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            u(g0Var);
            boolean u0 = u0();
            S0(g0Var);
            if (u0) {
                r0(g0Var);
            }
            d1(g0Var);
        }
    }

    private void K(Path path) {
        h hVar = this.d;
        if (hVar.a.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
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
        this.a.drawPath(path, hVar.e);
    }

    private void K0(SVG.h0 h0Var, SVG.b bVar) {
        G("Symbol render", new Object[0]);
        if (bVar.c == 0.0f || bVar.d == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = h0Var.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        f1(this.d, h0Var);
        h hVar = this.d;
        hVar.f = bVar;
        if (!hVar.a.overflow.booleanValue()) {
            SVG.b bVar2 = this.d.f;
            W0(bVar2.a, bVar2.b, bVar2.c, bVar2.d);
        }
        SVG.b bVar3 = h0Var.o;
        if (bVar3 != null) {
            this.a.concat(t(this.d.f, bVar3, preserveAspectRatio));
            this.d.g = h0Var.o;
        } else {
            Canvas canvas = this.a;
            SVG.b bVar4 = this.d.f;
            canvas.translate(bVar4.a, bVar4.b);
        }
        boolean u0 = u0();
        N0(h0Var, true);
        if (u0) {
            r0(h0Var);
        }
        d1(h0Var);
    }

    private float L(float f2, float f3, float f4, float f5) {
        return (f2 * f4) + (f3 * f5);
    }

    private void L0(SVG.k0 k0Var) {
        G("Text render", new Object[0]);
        f1(this.d, k0Var);
        if (I()) {
            Matrix matrix = k0Var.r;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            List<SVG.Length> list = k0Var.n;
            float f2 = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : k0Var.n.get(0).floatValueX(this);
            List<SVG.Length> list2 = k0Var.o;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : k0Var.o.get(0).floatValueY(this);
            List<SVG.Length> list3 = k0Var.p;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : k0Var.p.get(0).floatValueX(this);
            List<SVG.Length> list4 = k0Var.q;
            if (list4 != null && list4.size() != 0) {
                f2 = k0Var.q.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float s = s(k0Var);
                if (W == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                floatValueX -= s;
            }
            if (k0Var.h == null) {
                i iVar = new i(floatValueX, floatValueY);
                M(k0Var, iVar);
                RectF rectF = iVar.c;
                k0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            d1(k0Var);
            x(k0Var);
            u(k0Var);
            boolean u0 = u0();
            M(k0Var, new f(floatValueX + floatValueX2, floatValueY + f2));
            if (u0) {
                r0(k0Var);
            }
        }
    }

    private void M(SVG.l0 l0Var, j jVar) {
        if (I()) {
            Iterator<SVG.c0> it = l0Var.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.c0 next = it.next();
                if (next instanceof SVG.o0) {
                    jVar.b(b1(((SVG.o0) next).c, z, !it.hasNext()));
                } else {
                    t0(next, jVar);
                }
                z = false;
            }
        }
    }

    private void M0(SVG.p0 p0Var) {
        G("Use render", new Object[0]);
        SVG.Length length = p0Var.r;
        if (length == null || !length.isZero()) {
            SVG.Length length2 = p0Var.s;
            if (length2 == null || !length2.isZero()) {
                f1(this.d, p0Var);
                if (I()) {
                    SVG.c0 p = p0Var.a.p(p0Var.o);
                    if (p == null) {
                        N("Use reference '%s' not found", p0Var.o);
                        return;
                    }
                    Matrix matrix = p0Var.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    SVG.Length length3 = p0Var.p;
                    float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
                    SVG.Length length4 = p0Var.q;
                    this.a.translate(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f);
                    u(p0Var);
                    boolean u0 = u0();
                    q0(p0Var);
                    if (p instanceof SVG.w) {
                        SVG.b n0 = n0(null, null, p0Var.r, p0Var.s);
                        a1();
                        G0((SVG.w) p, n0);
                        Z0();
                    } else if (p instanceof SVG.h0) {
                        SVG.Length length5 = p0Var.r;
                        if (length5 == null) {
                            length5 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Length length6 = p0Var.s;
                        if (length6 == null) {
                            length6 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.b n02 = n0(null, null, length5, length6);
                        a1();
                        K0((SVG.h0) p, n02);
                        Z0();
                    } else {
                        I0(p);
                    }
                    p0();
                    if (u0) {
                        r0(p0Var);
                    }
                    d1(p0Var);
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
        for (SVG.c0 c0Var : svgContainer.getChildren()) {
            I0(c0Var);
        }
        if (z) {
            p0();
        }
    }

    private void O(SVG.l0 l0Var, StringBuilder sb) {
        Iterator<SVG.c0> it = l0Var.i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.c0 next = it.next();
            if (next instanceof SVG.l0) {
                O((SVG.l0) next, sb);
            } else if (next instanceof SVG.o0) {
                sb.append(b1(((SVG.o0) next).c, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private void P(SVG.h hVar, String str) {
        SVG.c0 p = hVar.a.p(str);
        if (p == null) {
            j1("Gradient reference '%s' not found", str);
        } else if (!(p instanceof SVG.h)) {
            N("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (p == hVar) {
            N("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.h hVar2 = (SVG.h) p;
            if (hVar.i == null) {
                hVar.i = hVar2.i;
            }
            if (hVar.j == null) {
                hVar.j = hVar2.j;
            }
            if (hVar.k == null) {
                hVar.k = hVar2.k;
            }
            if (hVar.h.isEmpty()) {
                hVar.h = hVar2.h;
            }
            try {
                if (hVar instanceof SVG.b0) {
                    Q((SVG.b0) hVar, (SVG.b0) p);
                } else {
                    R((SVG.e0) hVar, (SVG.e0) p);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = hVar2.l;
            if (str2 != null) {
                P(hVar, str2);
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
    private void P0(com.caverock.androidsvg.SVG.m r12, com.caverock.androidsvg.e.c r13) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.e.P0(com.caverock.androidsvg.SVG$m, com.caverock.androidsvg.e$c):void");
    }

    private void Q(SVG.b0 b0Var, SVG.b0 b0Var2) {
        if (b0Var.m == null) {
            b0Var.m = b0Var2.m;
        }
        if (b0Var.n == null) {
            b0Var.n = b0Var2.n;
        }
        if (b0Var.o == null) {
            b0Var.o = b0Var2.o;
        }
        if (b0Var.p == null) {
            b0Var.p = b0Var2.p;
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
    private void Q0(com.caverock.androidsvg.SVG.i r10) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.e.Q0(com.caverock.androidsvg.SVG$i):void");
    }

    private void R(SVG.e0 e0Var, SVG.e0 e0Var2) {
        if (e0Var.m == null) {
            e0Var.m = e0Var2.m;
        }
        if (e0Var.n == null) {
            e0Var.n = e0Var2.n;
        }
        if (e0Var.o == null) {
            e0Var.o = e0Var2.o;
        }
        if (e0Var.p == null) {
            e0Var.p = e0Var2.p;
        }
        if (e0Var.q == null) {
            e0Var.q = e0Var2.q;
        }
    }

    private void R0(SVG.n nVar, SVG.z zVar, SVG.b bVar) {
        float f2;
        float f3;
        G("Mask render", new Object[0]);
        Boolean bool = nVar.n;
        boolean z = true;
        if (bool != null && bool.booleanValue()) {
            SVG.Length length = nVar.r;
            f2 = length != null ? length.floatValueX(this) : bVar.c;
            SVG.Length length2 = nVar.s;
            f3 = length2 != null ? length2.floatValueY(this) : bVar.d;
        } else {
            SVG.Length length3 = nVar.r;
            float floatValue = length3 != null ? length3.floatValue(this, 1.0f) : 1.2f;
            SVG.Length length4 = nVar.s;
            float floatValue2 = length4 != null ? length4.floatValue(this, 1.0f) : 1.2f;
            f2 = floatValue * bVar.c;
            f3 = floatValue2 * bVar.d;
        }
        if (f2 == 0.0f || f3 == 0.0f) {
            return;
        }
        a1();
        h U = U(nVar);
        this.d = U;
        U.a.opacity = Float.valueOf(1.0f);
        boolean u0 = u0();
        this.a.save();
        Boolean bool2 = nVar.o;
        if (bool2 != null && !bool2.booleanValue()) {
            z = false;
        }
        if (!z) {
            this.a.translate(bVar.a, bVar.b);
            this.a.scale(bVar.c, bVar.d);
        }
        N0(nVar, false);
        this.a.restore();
        if (u0) {
            s0(zVar, bVar);
        }
        Z0();
    }

    private void S(SVG.q qVar, String str) {
        SVG.c0 p = qVar.a.p(str);
        if (p == null) {
            j1("Pattern reference '%s' not found", str);
        } else if (!(p instanceof SVG.q)) {
            N("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (p == qVar) {
            N("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.q qVar2 = (SVG.q) p;
            if (qVar.p == null) {
                qVar.p = qVar2.p;
            }
            if (qVar.q == null) {
                qVar.q = qVar2.q;
            }
            if (qVar.r == null) {
                qVar.r = qVar2.r;
            }
            if (qVar.s == null) {
                qVar.s = qVar2.s;
            }
            if (qVar.t == null) {
                qVar.t = qVar2.t;
            }
            if (qVar.u == null) {
                qVar.u = qVar2.u;
            }
            if (qVar.v == null) {
                qVar.v = qVar2.v;
            }
            if (qVar.i.isEmpty()) {
                qVar.i = qVar2.i;
            }
            if (qVar.o == null) {
                qVar.o = qVar2.o;
            }
            if (qVar.n == null) {
                qVar.n = qVar2.n;
            }
            String str2 = qVar2.w;
            if (str2 != null) {
                S(qVar, str2);
            }
        }
    }

    private void S0(SVG.g0 g0Var) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVG.g();
        for (SVG.c0 c0Var : g0Var.getChildren()) {
            if (c0Var instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) c0Var;
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
                            I0(c0Var);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void T(SVG.z zVar, Path path, SVG.q qVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Boolean bool = qVar.p;
        boolean z = bool != null && bool.booleanValue();
        String str = qVar.w;
        if (str != null) {
            S(qVar, str);
        }
        if (z) {
            SVG.Length length = qVar.s;
            f2 = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = qVar.t;
            f4 = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = qVar.u;
            f5 = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = qVar.v;
            f3 = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = qVar.s;
            float floatValue = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = qVar.t;
            float floatValue2 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = qVar.u;
            float floatValue3 = length7 != null ? length7.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length8 = qVar.v;
            float floatValue4 = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            SVG.b bVar = zVar.h;
            float f7 = bVar.a;
            float f8 = bVar.c;
            f2 = (floatValue * f8) + f7;
            float f9 = bVar.b;
            float f10 = bVar.d;
            float f11 = floatValue3 * f8;
            f3 = floatValue4 * f10;
            f4 = (floatValue2 * f10) + f9;
            f5 = f11;
        }
        if (f5 == 0.0f || f3 == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = qVar.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        a1();
        this.a.clipPath(path);
        h hVar = new h(this);
        e1(hVar, SVG.Style.getDefaultStyle());
        hVar.a.overflow = Boolean.FALSE;
        this.d = V(qVar, hVar);
        SVG.b bVar2 = zVar.h;
        Matrix matrix = qVar.r;
        if (matrix != null) {
            this.a.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (qVar.r.invert(matrix2)) {
                SVG.b bVar3 = zVar.h;
                SVG.b bVar4 = zVar.h;
                SVG.b bVar5 = zVar.h;
                float[] fArr = {bVar3.a, bVar3.b, bVar3.b(), bVar4.b, bVar4.b(), zVar.h.c(), bVar5.a, bVar5.c()};
                matrix2.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    int i3 = i2 + 1;
                    if (fArr[i3] < rectF.top) {
                        rectF.top = fArr[i3];
                    }
                    if (fArr[i3] > rectF.bottom) {
                        rectF.bottom = fArr[i3];
                    }
                }
                float f12 = rectF.left;
                float f13 = rectF.top;
                bVar2 = new SVG.b(f12, f13, rectF.right - f12, rectF.bottom - f13);
            }
        }
        float floor = f2 + (((float) Math.floor((bVar2.a - f2) / f5)) * f5);
        float b2 = bVar2.b();
        float c2 = bVar2.c();
        SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f5, f3);
        boolean u0 = u0();
        for (float floor2 = f4 + (((float) Math.floor((bVar2.b - f4) / f3)) * f3); floor2 < c2; floor2 += f3) {
            float f14 = floor;
            while (f14 < b2) {
                bVar6.a = f14;
                bVar6.b = floor2;
                a1();
                if (this.d.a.overflow.booleanValue()) {
                    f6 = floor;
                } else {
                    f6 = floor;
                    W0(bVar6.a, bVar6.b, bVar6.c, bVar6.d);
                }
                SVG.b bVar7 = qVar.o;
                if (bVar7 != null) {
                    this.a.concat(t(bVar6, bVar7, preserveAspectRatio));
                } else {
                    Boolean bool2 = qVar.q;
                    boolean z2 = bool2 == null || bool2.booleanValue();
                    this.a.translate(f14, floor2);
                    if (!z2) {
                        Canvas canvas = this.a;
                        SVG.b bVar8 = zVar.h;
                        canvas.scale(bVar8.c, bVar8.d);
                    }
                }
                for (SVG.c0 c0Var : qVar.i) {
                    I0(c0Var);
                }
                Z0();
                f14 += f5;
                floor = f6;
            }
        }
        if (u0) {
            r0(qVar);
        }
        Z0();
    }

    private void T0(SVG.m0 m0Var) {
        G("TextPath render", new Object[0]);
        f1(this.d, m0Var);
        if (I() && i1()) {
            SVG.c0 p = m0Var.a.p(m0Var.n);
            if (p == null) {
                N("TextPath reference '%s' not found", m0Var.n);
                return;
            }
            SVG.o oVar = (SVG.o) p;
            Path a2 = new d(oVar.o).a();
            Matrix matrix = oVar.n;
            if (matrix != null) {
                a2.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(a2, false);
            SVG.Length length = m0Var.o;
            float floatValue = length != null ? length.floatValue(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float s = s(m0Var);
                if (W == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                floatValue -= s;
            }
            x((SVG.z) m0Var.getTextRoot());
            boolean u0 = u0();
            M(m0Var, new C0219e(a2, floatValue, 0.0f));
            if (u0) {
                r0(m0Var);
            }
        }
    }

    private h U(SVG.c0 c0Var) {
        h hVar = new h(this);
        e1(hVar, SVG.Style.getDefaultStyle());
        return V(c0Var, hVar);
    }

    private boolean U0() {
        return this.d.a.opacity.floatValue() < 1.0f || this.d.a.mask != null;
    }

    private h V(SVG.c0 c0Var, h hVar) {
        ArrayList<SVG.a0> arrayList = new ArrayList();
        while (true) {
            if (c0Var instanceof SVG.a0) {
                arrayList.add(0, (SVG.a0) c0Var);
            }
            SVG.SvgContainer svgContainer = c0Var.b;
            if (svgContainer == null) {
                break;
            }
            c0Var = (SVG.c0) svgContainer;
        }
        for (SVG.a0 a0Var : arrayList) {
            f1(hVar, a0Var);
        }
        h hVar2 = this.d;
        hVar.g = hVar2.g;
        hVar.f = hVar2.f;
        return hVar;
    }

    private void V0() {
        this.d = new h(this);
        this.e = new Stack<>();
        e1(this.d, SVG.Style.getDefaultStyle());
        h hVar = this.d;
        hVar.f = null;
        hVar.h = false;
        this.e.push(new h(this, hVar));
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

    private void W0(float f2, float f3, float f4, float f5) {
        float f6 = f4 + f2;
        float f7 = f5 + f3;
        SVG.c cVar = this.d.a.clip;
        if (cVar != null) {
            f2 += cVar.d.floatValueX(this);
            f3 += this.d.a.clip.a.floatValueY(this);
            f6 -= this.d.a.clip.b.floatValueX(this);
            f7 -= this.d.a.clip.c.floatValueY(this);
        }
        this.a.clipRect(f2, f3, f6, f7);
    }

    private Path.FillType X() {
        SVG.Style.FillRule fillRule = this.d.a.clipRule;
        if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    private void X0(h hVar, boolean z, SVG.SvgPaint svgPaint) {
        int i2;
        SVG.Style style = hVar.a;
        float floatValue = (z ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i2 = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i2 = hVar.a.color.colour;
        }
        int F = F(i2, floatValue);
        if (z) {
            hVar.d.setColor(F);
        } else {
            hVar.e.setColor(F);
        }
    }

    private void Y0(boolean z, SVG.u uVar) {
        if (z) {
            if (e0(uVar.e, 2147483648L)) {
                h hVar = this.d;
                SVG.Style style = hVar.a;
                SVG.SvgPaint svgPaint = uVar.e.solidColor;
                style.fill = svgPaint;
                hVar.b = svgPaint != null;
            }
            if (e0(uVar.e, Constants.RequestStrategy.LOCAL_FIRST)) {
                this.d.a.fillOpacity = uVar.e.solidOpacity;
            }
            if (e0(uVar.e, 6442450944L)) {
                h hVar2 = this.d;
                X0(hVar2, z, hVar2.a.fill);
                return;
            }
            return;
        }
        if (e0(uVar.e, 2147483648L)) {
            h hVar3 = this.d;
            SVG.Style style2 = hVar3.a;
            SVG.SvgPaint svgPaint2 = uVar.e.solidColor;
            style2.stroke = svgPaint2;
            hVar3.c = svgPaint2 != null;
        }
        if (e0(uVar.e, Constants.RequestStrategy.LOCAL_FIRST)) {
            this.d.a.strokeOpacity = uVar.e.solidOpacity;
        }
        if (e0(uVar.e, 6442450944L)) {
            h hVar4 = this.d;
            X0(hVar4, z, hVar4.a.stroke);
        }
    }

    private void Z0() {
        this.a.restore();
        this.d = this.e.pop();
    }

    private void a1() {
        this.a.save();
        this.e.push(this.d);
        this.d = new h(this, this.d);
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

    private void c1(h hVar, SVG.Style style) {
        boolean z = true;
        if (e0(style, 1L)) {
            hVar.a.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            hVar.b = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
            this.i |= 1;
        }
        if (e0(style, 4L)) {
            hVar.a.fillOpacity = style.fillOpacity;
            this.i |= 2;
        }
        if (e0(style, 5L)) {
            X0(hVar, true, hVar.a.fill);
        }
        if (e0(style, 8L)) {
            hVar.a.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            hVar.c = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : false;
            this.i |= 4;
        }
        if (e0(style, 16L)) {
            hVar.a.strokeOpacity = style.strokeOpacity;
            this.i |= 8;
        }
        if (e0(style, 24L)) {
            X0(hVar, false, hVar.a.stroke);
        }
    }

    private static synchronized void d0() {
        synchronized (e.class) {
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

    private void d1(SVG.z zVar) {
        if (zVar.b == null || zVar.h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.g.peek().invert(matrix)) {
            SVG.b bVar = zVar.h;
            SVG.b bVar2 = zVar.h;
            SVG.b bVar3 = zVar.h;
            float[] fArr = {bVar.a, bVar.b, bVar.b(), bVar2.b, bVar2.b(), zVar.h.c(), bVar3.a, bVar3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.z zVar2 = (SVG.z) this.f.peek();
            SVG.b bVar4 = zVar2.h;
            if (bVar4 == null) {
                zVar2.h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.d(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private boolean e0(SVG.Style style, long j2) {
        return (style.specifiedFlags & j2) != 0;
    }

    private void e1(h hVar, SVG.Style style) {
        if (e0(style, 4096L)) {
            hVar.a.color = style.color;
        }
        if (e0(style, 2048L)) {
            hVar.a.opacity = style.opacity;
        }
        if (e0(style, 1L)) {
            hVar.a.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            hVar.b = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 4L)) {
            hVar.a.fillOpacity = style.fillOpacity;
        }
        if (e0(style, 6149L)) {
            X0(hVar, true, hVar.a.fill);
        }
        if (e0(style, 2L)) {
            hVar.a.fillRule = style.fillRule;
        }
        if (e0(style, 8L)) {
            hVar.a.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            hVar.c = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 16L)) {
            hVar.a.strokeOpacity = style.strokeOpacity;
        }
        if (e0(style, 6168L)) {
            X0(hVar, false, hVar.a.stroke);
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_FILE)) {
            hVar.a.vectorEffect = style.vectorEffect;
        }
        if (e0(style, 32L)) {
            SVG.Style style2 = hVar.a;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            hVar.e.setStrokeWidth(length.floatValue(this));
        }
        if (e0(style, 64L)) {
            hVar.a.strokeLineCap = style.strokeLineCap;
            int i2 = a.b[style.strokeLineCap.ordinal()];
            if (i2 == 1) {
                hVar.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i2 == 2) {
                hVar.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i2 == 3) {
                hVar.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (e0(style, 128L)) {
            hVar.a.strokeLineJoin = style.strokeLineJoin;
            int i3 = a.c[style.strokeLineJoin.ordinal()];
            if (i3 == 1) {
                hVar.e.setStrokeJoin(Paint.Join.MITER);
            } else if (i3 == 2) {
                hVar.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i3 == 3) {
                hVar.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (e0(style, 256L)) {
            hVar.a.strokeMiterLimit = style.strokeMiterLimit;
            hVar.e.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (e0(style, 512L)) {
            hVar.a.strokeDashArray = style.strokeDashArray;
        }
        if (e0(style, 1024L)) {
            hVar.a.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (e0(style, 1536L)) {
            SVG.Length[] lengthArr = hVar.a.strokeDashArray;
            if (lengthArr == null) {
                hVar.e.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i4 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i4];
                float f2 = 0.0f;
                for (int i5 = 0; i5 < i4; i5++) {
                    fArr[i5] = hVar.a.strokeDashArray[i5 % length2].floatValue(this);
                    f2 += fArr[i5];
                }
                if (f2 == 0.0f) {
                    hVar.e.setPathEffect(null);
                } else {
                    float floatValue = hVar.a.strokeDashOffset.floatValue(this);
                    if (floatValue < 0.0f) {
                        floatValue = (floatValue % f2) + f2;
                    }
                    hVar.e.setPathEffect(new DashPathEffect(fArr, floatValue));
                }
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE)) {
            float Y = Y();
            hVar.a.fontSize = style.fontSize;
            hVar.d.setTextSize(style.fontSize.floatValue(this, Y));
            hVar.e.setTextSize(style.fontSize.floatValue(this, Y));
        }
        if (e0(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            hVar.a.fontFamily = style.fontFamily;
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.intValue() == -1 && hVar.a.fontWeight.intValue() > 100) {
                SVG.Style style3 = hVar.a;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && hVar.a.fontWeight.intValue() < 900) {
                SVG.Style style4 = hVar.a;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            } else {
                hVar.a.fontWeight = style.fontWeight;
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            hVar.a.fontStyle = style.fontStyle;
        }
        if (e0(style, 106496L)) {
            if (hVar.a.fontFamily != null && this.c != null) {
                SVG.g();
                for (String str : hVar.a.fontFamily) {
                    SVG.Style style5 = hVar.a;
                    typeface = z(str, style5.fontWeight, style5.fontStyle);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = hVar.a;
                typeface = z("serif", style6.fontWeight, style6.fontStyle);
            }
            hVar.d.setTypeface(typeface);
            hVar.e.setTypeface(typeface);
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            hVar.a.textDecoration = style.textDecoration;
            Paint paint = hVar.d;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = hVar.d;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            if (Build.VERSION.SDK_INT >= 17) {
                hVar.e.setStrikeThruText(style.textDecoration == textDecoration2);
                hVar.e.setUnderlineText(style.textDecoration == textDecoration4);
            }
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FILE)) {
            hVar.a.direction = style.direction;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            hVar.a.textAnchor = style.textAnchor;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            hVar.a.overflow = style.overflow;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            hVar.a.markerStart = style.markerStart;
        }
        if (e0(style, 4194304L)) {
            hVar.a.markerMid = style.markerMid;
        }
        if (e0(style, 8388608L)) {
            hVar.a.markerEnd = style.markerEnd;
        }
        if (e0(style, 16777216L)) {
            hVar.a.display = style.display;
        }
        if (e0(style, 33554432L)) {
            hVar.a.visibility = style.visibility;
        }
        if (e0(style, 1048576L)) {
            hVar.a.clip = style.clip;
        }
        if (e0(style, 268435456L)) {
            hVar.a.clipPath = style.clipPath;
        }
        if (e0(style, 536870912L)) {
            hVar.a.clipRule = style.clipRule;
        }
        if (e0(style, 1073741824L)) {
            hVar.a.mask = style.mask;
        }
        if (e0(style, 67108864L)) {
            hVar.a.stopColor = style.stopColor;
        }
        if (e0(style, 134217728L)) {
            hVar.a.stopOpacity = style.stopOpacity;
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FIRST)) {
            hVar.a.viewportFill = style.viewportFill;
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_SERIAL)) {
            hVar.a.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (e0(style, 137438953472L)) {
            hVar.a.imageRendering = style.imageRendering;
        }
    }

    private void f0(boolean z, SVG.b bVar, SVG.b0 b0Var) {
        float f2;
        float floatValue;
        float f3;
        float f4;
        String str = b0Var.l;
        if (str != null) {
            P(b0Var, str);
        }
        Boolean bool = b0Var.i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        h hVar = this.d;
        Paint paint = z ? hVar.d : hVar.e;
        if (z2) {
            SVG.b a0 = a0();
            SVG.Length length = b0Var.m;
            float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = b0Var.n;
            float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = b0Var.o;
            float floatValueX2 = length3 != null ? length3.floatValueX(this) : a0.c;
            SVG.Length length4 = b0Var.p;
            f4 = floatValueX2;
            f2 = floatValueX;
            f3 = floatValueY;
            floatValue = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = b0Var.m;
            float floatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = b0Var.n;
            float floatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = b0Var.o;
            float floatValue4 = length7 != null ? length7.floatValue(this, 1.0f) : 1.0f;
            SVG.Length length8 = b0Var.p;
            f2 = floatValue2;
            floatValue = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            f3 = floatValue3;
            f4 = floatValue4;
        }
        a1();
        this.d = U(b0Var);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(bVar.a, bVar.b);
            matrix.preScale(bVar.c, bVar.d);
        }
        Matrix matrix2 = b0Var.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = b0Var.h.size();
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
        float f5 = -1.0f;
        Iterator<SVG.c0> it = b0Var.h.iterator();
        while (it.hasNext()) {
            SVG.v vVar = (SVG.v) it.next();
            Float f6 = vVar.h;
            float floatValue5 = f6 != null ? f6.floatValue() : 0.0f;
            if (i2 != 0 && floatValue5 < f5) {
                fArr[i2] = f5;
            } else {
                fArr[i2] = floatValue5;
                f5 = floatValue5;
            }
            a1();
            f1(this.d, vVar);
            SVG.Style style = this.d.a;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i2] = F(colour.colour, style.stopOpacity.floatValue());
            i2++;
            Z0();
        }
        if ((f2 == f4 && f3 == floatValue) || size == 1) {
            Z0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = b0Var.k;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Z0();
        LinearGradient linearGradient = new LinearGradient(f2, f3, f4, floatValue, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(C(this.d.a.fillOpacity.floatValue()));
    }

    private void f1(h hVar, SVG.a0 a0Var) {
        boolean z = false;
        hVar.a.resetNonInheritingProperties(a0Var.b == null);
        SVG.Style style = a0Var.e;
        if (style != null) {
            e1(hVar, style);
        }
        this.i = 0;
        if (this.c.m()) {
            for (CSSParser.k kVar : this.c.d()) {
                if (CSSParser.l(this.h, kVar.a, a0Var)) {
                    SVG.Style style2 = kVar.b;
                    if (style2 != null && style2.important) {
                        z = true;
                    }
                    if (z) {
                        c1(hVar, style2);
                    } else {
                        e1(hVar, style2);
                    }
                }
            }
        }
        SVG.Style style3 = a0Var.f;
        if (style3 != null) {
            if (style3.important) {
                e1(hVar, style3);
            } else if (z) {
                g1(hVar, style3);
            } else {
                e1(hVar, style3);
            }
        }
    }

    private Path g0(SVG.d dVar) {
        SVG.Length length = dVar.o;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = dVar.p;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValue = dVar.q.floatValue(this);
        float f2 = floatValueX - floatValue;
        float f3 = floatValueY - floatValue;
        float f4 = floatValueX + floatValue;
        float f5 = floatValueY + floatValue;
        if (dVar.h == null) {
            float f6 = 2.0f * floatValue;
            dVar.h = new SVG.b(f2, f3, f6, f6);
        }
        float f7 = 0.5522848f * floatValue;
        Path path = new Path();
        path.moveTo(floatValueX, f3);
        float f8 = floatValueX + f7;
        float f9 = floatValueY - f7;
        path.cubicTo(f8, f3, f4, f9, f4, floatValueY);
        float f10 = floatValueY + f7;
        path.cubicTo(f4, f10, f8, f5, floatValueX, f5);
        float f11 = floatValueX - f7;
        path.cubicTo(f11, f5, f2, f10, f2, floatValueY);
        path.cubicTo(f2, f9, f11, f3, floatValueX, f3);
        path.close();
        return path;
    }

    private void g1(h hVar, SVG.Style style) {
        if (e0(style, 4096L)) {
            hVar.a.color = style.color;
        }
        if (e0(style, 2048L)) {
            hVar.a.opacity = style.opacity;
        }
        if (e0(style, 1L) && (this.i & 1) == 0) {
            hVar.a.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            hVar.b = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 4L) && (this.i & 2) == 0) {
            hVar.a.fillOpacity = style.fillOpacity;
        }
        if (e0(style, 6149L)) {
            X0(hVar, true, hVar.a.fill);
        }
        if (e0(style, 2L)) {
            hVar.a.fillRule = style.fillRule;
        }
        if (e0(style, 8L) && (this.i & 4) == 0) {
            hVar.a.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            hVar.c = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (e0(style, 16L) && (this.i & 8) == 0) {
            hVar.a.strokeOpacity = style.strokeOpacity;
        }
        if (e0(style, 6168L)) {
            X0(hVar, false, hVar.a.stroke);
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_FILE)) {
            hVar.a.vectorEffect = style.vectorEffect;
        }
        if (e0(style, 32L)) {
            SVG.Style style2 = hVar.a;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            hVar.e.setStrokeWidth(length.floatValue(this));
        }
        if (e0(style, 64L)) {
            hVar.a.strokeLineCap = style.strokeLineCap;
            int i2 = a.b[style.strokeLineCap.ordinal()];
            if (i2 == 1) {
                hVar.e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i2 == 2) {
                hVar.e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i2 == 3) {
                hVar.e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (e0(style, 128L)) {
            hVar.a.strokeLineJoin = style.strokeLineJoin;
            int i3 = a.c[style.strokeLineJoin.ordinal()];
            if (i3 == 1) {
                hVar.e.setStrokeJoin(Paint.Join.MITER);
            } else if (i3 == 2) {
                hVar.e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i3 == 3) {
                hVar.e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (e0(style, 256L)) {
            hVar.a.strokeMiterLimit = style.strokeMiterLimit;
            hVar.e.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (e0(style, 512L)) {
            hVar.a.strokeDashArray = style.strokeDashArray;
        }
        if (e0(style, 1024L)) {
            hVar.a.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (e0(style, 1536L)) {
            SVG.Length[] lengthArr = hVar.a.strokeDashArray;
            if (lengthArr == null) {
                hVar.e.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i4 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i4];
                float f2 = 0.0f;
                for (int i5 = 0; i5 < i4; i5++) {
                    fArr[i5] = hVar.a.strokeDashArray[i5 % length2].floatValue(this);
                    f2 += fArr[i5];
                }
                if (f2 == 0.0f) {
                    hVar.e.setPathEffect(null);
                } else {
                    float floatValue = hVar.a.strokeDashOffset.floatValue(this);
                    if (floatValue < 0.0f) {
                        floatValue = (floatValue % f2) + f2;
                    }
                    hVar.e.setPathEffect(new DashPathEffect(fArr, floatValue));
                }
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE)) {
            float Y = Y();
            hVar.a.fontSize = style.fontSize;
            hVar.d.setTextSize(style.fontSize.floatValue(this, Y));
            hVar.e.setTextSize(style.fontSize.floatValue(this, Y));
        }
        if (e0(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
            hVar.a.fontFamily = style.fontFamily;
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
            if (style.fontWeight.intValue() == -1 && hVar.a.fontWeight.intValue() > 100) {
                SVG.Style style3 = hVar.a;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && hVar.a.fontWeight.intValue() < 900) {
                SVG.Style style4 = hVar.a;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            } else {
                hVar.a.fontWeight = style.fontWeight;
            }
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)) {
            hVar.a.fontStyle = style.fontStyle;
        }
        if (e0(style, 106496L)) {
            if (hVar.a.fontFamily != null && this.c != null) {
                SVG.g();
                for (String str : hVar.a.fontFamily) {
                    SVG.Style style5 = hVar.a;
                    typeface = z(str, style5.fontWeight, style5.fontStyle);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = hVar.a;
                typeface = z("serif", style6.fontWeight, style6.fontStyle);
            }
            hVar.d.setTypeface(typeface);
            hVar.e.setTypeface(typeface);
        }
        if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
            hVar.a.textDecoration = style.textDecoration;
            Paint paint = hVar.d;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = hVar.d;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            if (Build.VERSION.SDK_INT >= 17) {
                hVar.e.setStrikeThruText(style.textDecoration == textDecoration2);
                hVar.e.setUnderlineText(style.textDecoration == textDecoration4);
            }
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FILE)) {
            hVar.a.direction = style.direction;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
            hVar.a.textAnchor = style.textAnchor;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
            hVar.a.overflow = style.overflow;
        }
        if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
            hVar.a.markerStart = style.markerStart;
        }
        if (e0(style, 4194304L)) {
            hVar.a.markerMid = style.markerMid;
        }
        if (e0(style, 8388608L)) {
            hVar.a.markerEnd = style.markerEnd;
        }
        if (e0(style, 16777216L)) {
            hVar.a.display = style.display;
        }
        if (e0(style, 33554432L)) {
            hVar.a.visibility = style.visibility;
        }
        if (e0(style, 1048576L)) {
            hVar.a.clip = style.clip;
        }
        if (e0(style, 268435456L)) {
            hVar.a.clipPath = style.clipPath;
        }
        if (e0(style, 536870912L)) {
            hVar.a.clipRule = style.clipRule;
        }
        if (e0(style, 1073741824L)) {
            hVar.a.mask = style.mask;
        }
        if (e0(style, 67108864L)) {
            hVar.a.stopColor = style.stopColor;
        }
        if (e0(style, 134217728L)) {
            hVar.a.stopOpacity = style.stopOpacity;
        }
        if (e0(style, Constants.RequestStrategy.REMOTE_FIRST)) {
            hVar.a.viewportFill = style.viewportFill;
        }
        if (e0(style, Constants.RequestStrategy.LOCAL_SERIAL)) {
            hVar.a.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (e0(style, 137438953472L)) {
            hVar.a.imageRendering = style.imageRendering;
        }
    }

    private void h(SVG.i iVar, Path path, Matrix matrix) {
        Path j0;
        f1(this.d, iVar);
        if (I() && i1()) {
            Matrix matrix2 = iVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (iVar instanceof SVG.t) {
                j0 = k0((SVG.t) iVar);
            } else if (iVar instanceof SVG.d) {
                j0 = g0((SVG.d) iVar);
            } else if (iVar instanceof SVG.g) {
                j0 = h0((SVG.g) iVar);
            } else if (!(iVar instanceof SVG.r)) {
                return;
            } else {
                j0 = j0((SVG.r) iVar);
            }
            u(iVar);
            path.setFillType(X());
            path.addPath(j0, matrix);
        }
    }

    private Path h0(SVG.g gVar) {
        SVG.Length length = gVar.o;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = gVar.p;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValueX2 = gVar.q.floatValueX(this);
        float floatValueY2 = gVar.r.floatValueY(this);
        float f2 = floatValueX - floatValueX2;
        float f3 = floatValueY - floatValueY2;
        float f4 = floatValueX + floatValueX2;
        float f5 = floatValueY + floatValueY2;
        if (gVar.h == null) {
            gVar.h = new SVG.b(f2, f3, floatValueX2 * 2.0f, 2.0f * floatValueY2);
        }
        float f6 = floatValueX2 * 0.5522848f;
        float f7 = 0.5522848f * floatValueY2;
        Path path = new Path();
        path.moveTo(floatValueX, f3);
        float f8 = floatValueX + f6;
        float f9 = floatValueY - f7;
        path.cubicTo(f8, f3, f4, f9, f4, floatValueY);
        float f10 = f7 + floatValueY;
        path.cubicTo(f4, f10, f8, f5, floatValueX, f5);
        float f11 = floatValueX - f6;
        path.cubicTo(f11, f5, f2, f10, f2, floatValueY);
        path.cubicTo(f2, f9, f11, f3, floatValueX, f3);
        path.close();
        return path;
    }

    private void h1() {
        int i2;
        SVG.Style style = this.d.a;
        SVG.SvgPaint svgPaint = style.viewportFill;
        if (svgPaint instanceof SVG.Colour) {
            i2 = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i2 = style.color.colour;
        }
        Float f2 = style.viewportFillOpacity;
        if (f2 != null) {
            i2 = F(i2, f2.floatValue());
        }
        this.a.drawColor(i2);
    }

    private void i(SVG.o oVar, Path path, Matrix matrix) {
        f1(this.d, oVar);
        if (I() && i1()) {
            Matrix matrix2 = oVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path a2 = new d(oVar.o).a();
            if (oVar.h == null) {
                oVar.h = r(a2);
            }
            u(oVar);
            path.setFillType(X());
            path.addPath(a2, matrix);
        }
    }

    private Path i0(SVG.l lVar) {
        SVG.Length length = lVar.o;
        float floatValueX = length == null ? 0.0f : length.floatValueX(this);
        SVG.Length length2 = lVar.p;
        float floatValueY = length2 == null ? 0.0f : length2.floatValueY(this);
        SVG.Length length3 = lVar.q;
        float floatValueX2 = length3 == null ? 0.0f : length3.floatValueX(this);
        SVG.Length length4 = lVar.r;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        if (lVar.h == null) {
            lVar.h = new SVG.b(Math.min(floatValueX, floatValueX2), Math.min(floatValueY, floatValueY2), Math.abs(floatValueX2 - floatValueX), Math.abs(floatValueY2 - floatValueY));
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

    private void j(SVG.c0 c0Var, boolean z, Path path, Matrix matrix) {
        if (I()) {
            E();
            if (c0Var instanceof SVG.p0) {
                if (z) {
                    l((SVG.p0) c0Var, path, matrix);
                } else {
                    N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (c0Var instanceof SVG.o) {
                i((SVG.o) c0Var, path, matrix);
            } else if (c0Var instanceof SVG.k0) {
                k((SVG.k0) c0Var, path, matrix);
            } else if (c0Var instanceof SVG.i) {
                h((SVG.i) c0Var, path, matrix);
            } else {
                N("Invalid %s element found in clipPath definition", c0Var.toString());
            }
            D();
        }
    }

    private Path j0(SVG.r rVar) {
        Path path = new Path();
        float[] fArr = rVar.o;
        path.moveTo(fArr[0], fArr[1]);
        int i2 = 2;
        while (true) {
            float[] fArr2 = rVar.o;
            if (i2 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i2], fArr2[i2 + 1]);
            i2 += 2;
        }
        if (rVar instanceof SVG.s) {
            path.close();
        }
        if (rVar.h == null) {
            rVar.h = r(path);
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j1(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    private void k(SVG.k0 k0Var, Path path, Matrix matrix) {
        f1(this.d, k0Var);
        if (I()) {
            Matrix matrix2 = k0Var.r;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.Length> list = k0Var.n;
            float f2 = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : k0Var.n.get(0).floatValueX(this);
            List<SVG.Length> list2 = k0Var.o;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : k0Var.o.get(0).floatValueY(this);
            List<SVG.Length> list3 = k0Var.p;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : k0Var.p.get(0).floatValueX(this);
            List<SVG.Length> list4 = k0Var.q;
            if (list4 != null && list4.size() != 0) {
                f2 = k0Var.q.get(0).floatValueY(this);
            }
            if (this.d.a.textAnchor != SVG.Style.TextAnchor.Start) {
                float s = s(k0Var);
                if (this.d.a.textAnchor == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                floatValueX -= s;
            }
            if (k0Var.h == null) {
                i iVar = new i(floatValueX, floatValueY);
                M(k0Var, iVar);
                RectF rectF = iVar.c;
                k0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            u(k0Var);
            Path path2 = new Path();
            M(k0Var, new g(floatValueX + floatValueX2, floatValueY + f2, path2));
            path.setFillType(X());
            path.addPath(path2, matrix);
        }
    }

    private Path k0(SVG.t tVar) {
        float floatValueX;
        float floatValueY;
        Path path;
        SVG.Length length = tVar.s;
        if (length == null && tVar.t == null) {
            floatValueX = 0.0f;
            floatValueY = 0.0f;
        } else {
            if (length == null) {
                floatValueX = tVar.t.floatValueY(this);
            } else if (tVar.t == null) {
                floatValueX = length.floatValueX(this);
            } else {
                floatValueX = length.floatValueX(this);
                floatValueY = tVar.t.floatValueY(this);
            }
            floatValueY = floatValueX;
        }
        float min = Math.min(floatValueX, tVar.q.floatValueX(this) / 2.0f);
        float min2 = Math.min(floatValueY, tVar.r.floatValueY(this) / 2.0f);
        SVG.Length length2 = tVar.o;
        float floatValueX2 = length2 != null ? length2.floatValueX(this) : 0.0f;
        SVG.Length length3 = tVar.p;
        float floatValueY2 = length3 != null ? length3.floatValueY(this) : 0.0f;
        float floatValueX3 = tVar.q.floatValueX(this);
        float floatValueY3 = tVar.r.floatValueY(this);
        if (tVar.h == null) {
            tVar.h = new SVG.b(floatValueX2, floatValueY2, floatValueX3, floatValueY3);
        }
        float f2 = floatValueX2 + floatValueX3;
        float f3 = floatValueY2 + floatValueY3;
        Path path2 = new Path();
        if (min != 0.0f && min2 != 0.0f) {
            float f4 = min * 0.5522848f;
            float f5 = 0.5522848f * min2;
            float f6 = floatValueY2 + min2;
            path2.moveTo(floatValueX2, f6);
            float f7 = f6 - f5;
            float f8 = floatValueX2 + min;
            float f9 = f8 - f4;
            path2.cubicTo(floatValueX2, f7, f9, floatValueY2, f8, floatValueY2);
            float f10 = f2 - min;
            path2.lineTo(f10, floatValueY2);
            float f11 = f10 + f4;
            path2.cubicTo(f11, floatValueY2, f2, f7, f2, f6);
            float f12 = f3 - min2;
            path2.lineTo(f2, f12);
            float f13 = f12 + f5;
            path = path2;
            path2.cubicTo(f2, f13, f11, f3, f10, f3);
            path.lineTo(f8, f3);
            path.cubicTo(f9, f3, floatValueX2, f13, floatValueX2, f12);
            path.lineTo(floatValueX2, f6);
        } else {
            path = path2;
            path.moveTo(floatValueX2, floatValueY2);
            path.lineTo(f2, floatValueY2);
            path.lineTo(f2, f3);
            path.lineTo(floatValueX2, f3);
            path.lineTo(floatValueX2, floatValueY2);
        }
        path.close();
        return path;
    }

    private void l(SVG.p0 p0Var, Path path, Matrix matrix) {
        f1(this.d, p0Var);
        if (I() && i1()) {
            Matrix matrix2 = p0Var.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.c0 p = p0Var.a.p(p0Var.o);
            if (p == null) {
                N("Use reference '%s' not found", p0Var.o);
                return;
            }
            u(p0Var);
            j(p, false, path, matrix);
        }
    }

    private Path l0(SVG.k0 k0Var) {
        List<SVG.Length> list = k0Var.n;
        float f2 = 0.0f;
        float floatValueX = (list == null || list.size() == 0) ? 0.0f : k0Var.n.get(0).floatValueX(this);
        List<SVG.Length> list2 = k0Var.o;
        float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : k0Var.o.get(0).floatValueY(this);
        List<SVG.Length> list3 = k0Var.p;
        float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : k0Var.p.get(0).floatValueX(this);
        List<SVG.Length> list4 = k0Var.q;
        if (list4 != null && list4.size() != 0) {
            f2 = k0Var.q.get(0).floatValueY(this);
        }
        if (this.d.a.textAnchor != SVG.Style.TextAnchor.Start) {
            float s = s(k0Var);
            if (this.d.a.textAnchor == SVG.Style.TextAnchor.Middle) {
                s /= 2.0f;
            }
            floatValueX -= s;
        }
        if (k0Var.h == null) {
            i iVar = new i(floatValueX, floatValueY);
            M(k0Var, iVar);
            RectF rectF = iVar.c;
            k0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
        }
        Path path = new Path();
        M(k0Var, new g(floatValueX + floatValueX2, floatValueY + f2, path));
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.PathInterface pathInterface) {
        if (f2 == f7 && f3 == f8) {
            return;
        }
        if (f4 != 0.0f && f5 != 0.0f) {
            float abs = Math.abs(f4);
            float abs2 = Math.abs(f5);
            double radians = Math.toRadians(f6 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d2 = (f2 - f7) / 2.0d;
            double d3 = (f3 - f8) / 2.0d;
            double d4 = (cos * d2) + (sin * d3);
            double d5 = ((-sin) * d2) + (d3 * cos);
            double d6 = abs * abs;
            double d7 = abs2 * abs2;
            double d8 = d4 * d4;
            double d9 = d5 * d5;
            double d10 = (d8 / d6) + (d9 / d7);
            if (d10 > 0.99999d) {
                double sqrt = Math.sqrt(d10) * 1.00001d;
                abs = (float) (abs * sqrt);
                abs2 = (float) (sqrt * abs2);
                d6 = abs * abs;
                d7 = abs2 * abs2;
            }
            double d11 = z == z2 ? -1.0d : 1.0d;
            double d12 = d6 * d7;
            double d13 = d6 * d9;
            double d14 = d7 * d8;
            double d15 = ((d12 - d13) - d14) / (d13 + d14);
            if (d15 < 0.0d) {
                d15 = 0.0d;
            }
            double sqrt2 = d11 * Math.sqrt(d15);
            double d16 = abs;
            double d17 = abs2;
            double d18 = ((d16 * d5) / d17) * sqrt2;
            float f9 = abs;
            float f10 = abs2;
            double d19 = sqrt2 * (-((d17 * d4) / d16));
            double d20 = ((f2 + f7) / 2.0d) + ((cos * d18) - (sin * d19));
            double d21 = ((f3 + f8) / 2.0d) + (sin * d18) + (cos * d19);
            double d22 = (d4 - d18) / d16;
            double d23 = (d5 - d19) / d17;
            double d24 = ((-d4) - d18) / d16;
            double d25 = ((-d5) - d19) / d17;
            double d26 = (d22 * d22) + (d23 * d23);
            double acos = (d23 < 0.0d ? -1.0d : 1.0d) * Math.acos(d22 / Math.sqrt(d26));
            double B = ((d22 * d25) - (d23 * d24) >= 0.0d ? 1.0d : -1.0d) * B(((d22 * d24) + (d23 * d25)) / Math.sqrt(d26 * ((d24 * d24) + (d25 * d25))));
            int i2 = (B > 0.0d ? 1 : (B == 0.0d ? 0 : -1));
            if (i2 == 0) {
                pathInterface.lineTo(f7, f8);
                return;
            }
            if (!z2 && i2 > 0) {
                B -= 6.283185307179586d;
            } else if (z2 && B < 0.0d) {
                B += 6.283185307179586d;
            }
            float[] n = n(acos % 6.283185307179586d, B % 6.283185307179586d);
            if (n == null || n.length == 0) {
                return;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(f9, f10);
            matrix.postRotate(f6);
            matrix.postTranslate((float) d20, (float) d21);
            matrix.mapPoints(n);
            n[n.length - 2] = f7;
            n[n.length - 1] = f8;
            for (int i3 = 0; i3 < n.length; i3 += 6) {
                pathInterface.cubicTo(n[i3], n[i3 + 1], n[i3 + 2], n[i3 + 3], n[i3 + 4], n[i3 + 5]);
            }
            return;
        }
        pathInterface.lineTo(f7, f8);
    }

    private void m0(boolean z, SVG.b bVar, SVG.e0 e0Var) {
        float f2;
        float floatValue;
        float f3;
        String str = e0Var.l;
        if (str != null) {
            P(e0Var, str);
        }
        Boolean bool = e0Var.i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        h hVar = this.d;
        Paint paint = z ? hVar.d : hVar.e;
        if (z2) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            SVG.Length length2 = e0Var.m;
            float floatValueX = length2 != null ? length2.floatValueX(this) : length.floatValueX(this);
            SVG.Length length3 = e0Var.n;
            float floatValueY = length3 != null ? length3.floatValueY(this) : length.floatValueY(this);
            SVG.Length length4 = e0Var.o;
            floatValue = length4 != null ? length4.floatValue(this) : length.floatValue(this);
            f2 = floatValueX;
            f3 = floatValueY;
        } else {
            SVG.Length length5 = e0Var.m;
            float floatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length6 = e0Var.n;
            float floatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length7 = e0Var.o;
            f2 = floatValue2;
            floatValue = length7 != null ? length7.floatValue(this, 1.0f) : 0.5f;
            f3 = floatValue3;
        }
        a1();
        this.d = U(e0Var);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(bVar.a, bVar.b);
            matrix.preScale(bVar.c, bVar.d);
        }
        Matrix matrix2 = e0Var.j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = e0Var.h.size();
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
        Iterator<SVG.c0> it = e0Var.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SVG.v vVar = (SVG.v) it.next();
            Float f5 = vVar.h;
            float floatValue4 = f5 != null ? f5.floatValue() : 0.0f;
            if (i2 != 0 && floatValue4 < f4) {
                fArr[i2] = f4;
            } else {
                fArr[i2] = floatValue4;
                f4 = floatValue4;
            }
            a1();
            f1(this.d, vVar);
            SVG.Style style = this.d.a;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i2] = F(colour.colour, style.stopOpacity.floatValue());
            i2++;
            Z0();
        }
        if (floatValue != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = e0Var.k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            Z0();
            RadialGradient radialGradient = new RadialGradient(f2, f3, floatValue, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(C(this.d.a.fillOpacity.floatValue()));
            return;
        }
        Z0();
        paint.setColor(iArr[size - 1]);
    }

    private static float[] n(double d2, double d3) {
        int ceil = (int) Math.ceil((Math.abs(d3) * 2.0d) / 3.141592653589793d);
        double d4 = d3 / ceil;
        double d5 = d4 / 2.0d;
        double sin = (Math.sin(d5) * 1.3333333333333333d) / (Math.cos(d5) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            double d6 = d2 + (i3 * d4);
            double cos = Math.cos(d6);
            double sin2 = Math.sin(d6);
            int i4 = i2 + 1;
            fArr[i2] = (float) (cos - (sin * sin2));
            int i5 = i4 + 1;
            fArr[i4] = (float) (sin2 + (cos * sin));
            d4 = d4;
            double d7 = d6 + d4;
            double cos2 = Math.cos(d7);
            double sin3 = Math.sin(d7);
            int i6 = i5 + 1;
            fArr[i5] = (float) ((sin * sin3) + cos2);
            int i7 = i6 + 1;
            fArr[i6] = (float) (sin3 - (sin * cos2));
            int i8 = i7 + 1;
            fArr[i7] = (float) cos2;
            i2 = i8 + 1;
            fArr[i8] = (float) sin3;
        }
        return fArr;
    }

    private SVG.b n0(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.b a0 = a0();
        return new SVG.b(floatValueX, floatValueY, length3 != null ? length3.floatValueX(this) : a0.c, length4 != null ? length4.floatValueY(this) : a0.d);
    }

    @TargetApi(19)
    private Path o(SVG.z zVar, SVG.b bVar) {
        Path o0;
        SVG.c0 p = zVar.a.p(this.d.a.clipPath);
        boolean z = false;
        if (p == null) {
            N("ClipPath reference '%s' not found", this.d.a.clipPath);
            return null;
        }
        SVG.e eVar = (SVG.e) p;
        this.e.push(this.d);
        this.d = U(eVar);
        Boolean bool = eVar.o;
        z = (bool == null || bool.booleanValue()) ? true : true;
        Matrix matrix = new Matrix();
        if (!z) {
            matrix.preTranslate(bVar.a, bVar.b);
            matrix.preScale(bVar.c, bVar.d);
        }
        Matrix matrix2 = eVar.n;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.c0 c0Var : eVar.i) {
            if ((c0Var instanceof SVG.z) && (o0 = o0((SVG.z) c0Var, true)) != null) {
                path.op(o0, Path.Op.UNION);
            }
        }
        if (this.d.a.clipPath != null) {
            if (eVar.h == null) {
                eVar.h = r(path);
            }
            Path o = o(eVar, eVar.h);
            if (o != null) {
                path.op(o, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.d = this.e.pop();
        return path;
    }

    @TargetApi(19)
    private Path o0(SVG.z zVar, boolean z) {
        Path l0;
        Path o;
        this.e.push(this.d);
        h hVar = new h(this, this.d);
        this.d = hVar;
        f1(hVar, zVar);
        if (I() && i1()) {
            if (zVar instanceof SVG.p0) {
                if (!z) {
                    N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
                SVG.p0 p0Var = (SVG.p0) zVar;
                SVG.c0 p = zVar.a.p(p0Var.o);
                if (p == null) {
                    N("Use reference '%s' not found", p0Var.o);
                    this.d = this.e.pop();
                    return null;
                } else if (!(p instanceof SVG.z)) {
                    this.d = this.e.pop();
                    return null;
                } else {
                    l0 = o0((SVG.z) p, false);
                    if (l0 == null) {
                        return null;
                    }
                    if (p0Var.h == null) {
                        p0Var.h = r(l0);
                    }
                    Matrix matrix = p0Var.n;
                    if (matrix != null) {
                        l0.transform(matrix);
                    }
                }
            } else if (zVar instanceof SVG.i) {
                SVG.i iVar = (SVG.i) zVar;
                if (zVar instanceof SVG.o) {
                    l0 = new d(((SVG.o) zVar).o).a();
                    if (zVar.h == null) {
                        zVar.h = r(l0);
                    }
                } else {
                    l0 = zVar instanceof SVG.t ? k0((SVG.t) zVar) : zVar instanceof SVG.d ? g0((SVG.d) zVar) : zVar instanceof SVG.g ? h0((SVG.g) zVar) : zVar instanceof SVG.r ? j0((SVG.r) zVar) : null;
                }
                if (l0 == null) {
                    return null;
                }
                if (iVar.h == null) {
                    iVar.h = r(l0);
                }
                Matrix matrix2 = iVar.n;
                if (matrix2 != null) {
                    l0.transform(matrix2);
                }
                l0.setFillType(X());
            } else if (!(zVar instanceof SVG.k0)) {
                N("Invalid %s element found in clipPath definition", zVar.a());
                return null;
            } else {
                SVG.k0 k0Var = (SVG.k0) zVar;
                l0 = l0(k0Var);
                if (l0 == null) {
                    return null;
                }
                Matrix matrix3 = k0Var.r;
                if (matrix3 != null) {
                    l0.transform(matrix3);
                }
                l0.setFillType(X());
            }
            if (this.d.a.clipPath != null && (o = o(zVar, zVar.h)) != null) {
                l0.op(o, Path.Op.INTERSECT);
            }
            this.d = this.e.pop();
            return l0;
        }
        this.d = this.e.pop();
        return null;
    }

    private List<c> p(SVG.l lVar) {
        SVG.Length length = lVar.o;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = lVar.p;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Length length3 = lVar.q;
        float floatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
        SVG.Length length4 = lVar.r;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f2 = floatValueX2 - floatValueX;
        float f3 = floatValueY2 - floatValueY;
        arrayList.add(new c(this, floatValueX, floatValueY, f2, f3));
        arrayList.add(new c(this, floatValueX2, floatValueY2, f2, f3));
        return arrayList;
    }

    private void p0() {
        this.f.pop();
        this.g.pop();
    }

    private List<c> q(SVG.r rVar) {
        int length = rVar.o.length;
        int i2 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = rVar.o;
        c cVar = new c(this, fArr[0], fArr[1], 0.0f, 0.0f);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < length) {
            float[] fArr2 = rVar.o;
            float f4 = fArr2[i2];
            float f5 = fArr2[i2 + 1];
            cVar.a(f4, f5);
            arrayList.add(cVar);
            i2 += 2;
            cVar = new c(this, f4, f5, f4 - cVar.a, f5 - cVar.b);
            f3 = f5;
            f2 = f4;
        }
        if (rVar instanceof SVG.s) {
            float[] fArr3 = rVar.o;
            if (f2 != fArr3[0] && f3 != fArr3[1]) {
                float f6 = fArr3[0];
                float f7 = fArr3[1];
                cVar.a(f6, f7);
                arrayList.add(cVar);
                c cVar2 = new c(this, f6, f7, f6 - cVar.a, f7 - cVar.b);
                cVar2.b((c) arrayList.get(0));
                arrayList.add(cVar2);
                arrayList.set(0, cVar2);
            }
        } else {
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void q0(SVG.SvgContainer svgContainer) {
        this.f.push(svgContainer);
        this.g.push(this.a.getMatrix());
    }

    private SVG.b r(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void r0(SVG.z zVar) {
        s0(zVar, zVar.h);
    }

    private float s(SVG.l0 l0Var) {
        k kVar = new k(this, null);
        M(l0Var, kVar);
        return kVar.a;
    }

    private void s0(SVG.z zVar, SVG.b bVar) {
        if (this.d.a.mask != null) {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.a.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.a.saveLayer(null, paint2, 31);
            SVG.n nVar = (SVG.n) this.c.p(this.d.a.mask);
            R0(nVar, zVar, bVar);
            this.a.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.a.saveLayer(null, paint3, 31);
            R0(nVar, zVar, bVar);
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
    private android.graphics.Matrix t(com.caverock.androidsvg.SVG.b r10, com.caverock.androidsvg.SVG.b r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
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
            int[] r6 = com.caverock.androidsvg.e.a.a
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
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.e.t(com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.SVG$b, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private void t0(SVG.c0 c0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        SVG.Style.TextAnchor W;
        if (jVar.a((SVG.l0) c0Var)) {
            if (c0Var instanceof SVG.m0) {
                a1();
                T0((SVG.m0) c0Var);
                Z0();
                return;
            }
            boolean z = true;
            if (c0Var instanceof SVG.j0) {
                G("TSpan render", new Object[0]);
                a1();
                SVG.j0 j0Var = (SVG.j0) c0Var;
                f1(this.d, j0Var);
                if (I()) {
                    List<SVG.Length> list = j0Var.n;
                    z = (list == null || list.size() <= 0) ? false : false;
                    boolean z2 = jVar instanceof f;
                    float f5 = 0.0f;
                    if (z2) {
                        float floatValueX = !z ? ((f) jVar).a : j0Var.n.get(0).floatValueX(this);
                        List<SVG.Length> list2 = j0Var.o;
                        f3 = (list2 == null || list2.size() == 0) ? ((f) jVar).b : j0Var.o.get(0).floatValueY(this);
                        List<SVG.Length> list3 = j0Var.p;
                        f4 = (list3 == null || list3.size() == 0) ? 0.0f : j0Var.p.get(0).floatValueX(this);
                        List<SVG.Length> list4 = j0Var.q;
                        if (list4 != null && list4.size() != 0) {
                            f5 = j0Var.q.get(0).floatValueY(this);
                        }
                        f2 = f5;
                        f5 = floatValueX;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    if (z && (W = W()) != SVG.Style.TextAnchor.Start) {
                        float s = s(j0Var);
                        if (W == SVG.Style.TextAnchor.Middle) {
                            s /= 2.0f;
                        }
                        f5 -= s;
                    }
                    x((SVG.z) j0Var.getTextRoot());
                    if (z2) {
                        f fVar = (f) jVar;
                        fVar.a = f5 + f4;
                        fVar.b = f3 + f2;
                    }
                    boolean u0 = u0();
                    M(j0Var, jVar);
                    if (u0) {
                        r0(j0Var);
                    }
                }
                Z0();
            } else if (c0Var instanceof SVG.i0) {
                a1();
                SVG.i0 i0Var = (SVG.i0) c0Var;
                f1(this.d, i0Var);
                if (I()) {
                    x((SVG.z) i0Var.getTextRoot());
                    SVG.c0 p = c0Var.a.p(i0Var.n);
                    if (p == null || !(p instanceof SVG.l0)) {
                        N("Tref reference '%s' not found", i0Var.n);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        O((SVG.l0) p, sb);
                        if (sb.length() > 0) {
                            jVar.b(sb.toString());
                        }
                    }
                }
                Z0();
            }
        }
    }

    private void u(SVG.z zVar) {
        v(zVar, zVar.h);
    }

    private boolean u0() {
        SVG.c0 p;
        if (U0()) {
            this.a.saveLayerAlpha(null, C(this.d.a.opacity.floatValue()), 31);
            this.e.push(this.d);
            h hVar = new h(this, this.d);
            this.d = hVar;
            String str = hVar.a.mask;
            if (str != null && ((p = this.c.p(str)) == null || !(p instanceof SVG.n))) {
                N("Mask reference '%s' not found", this.d.a.mask);
                this.d.a.mask = null;
            }
            return true;
        }
        return false;
    }

    private void v(SVG.z zVar, SVG.b bVar) {
        if (this.d.a.clipPath == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Path o = o(zVar, bVar);
            if (o != null) {
                this.a.clipPath(o);
                return;
            }
            return;
        }
        w(zVar, bVar);
    }

    private c v0(c cVar, c cVar2, c cVar3) {
        float L = L(cVar2.c, cVar2.d, cVar2.a - cVar.a, cVar2.b - cVar.b);
        if (L == 0.0f) {
            L = L(cVar2.c, cVar2.d, cVar3.a - cVar2.a, cVar3.b - cVar2.b);
        }
        int i2 = (L > 0.0f ? 1 : (L == 0.0f ? 0 : -1));
        if (i2 > 0) {
            return cVar2;
        }
        if (i2 != 0 || (cVar2.c <= 0.0f && cVar2.d < 0.0f)) {
            cVar2.c = -cVar2.c;
            cVar2.d = -cVar2.d;
            return cVar2;
        }
        return cVar2;
    }

    private void w(SVG.z zVar, SVG.b bVar) {
        SVG.c0 p = zVar.a.p(this.d.a.clipPath);
        if (p == null) {
            N("ClipPath reference '%s' not found", this.d.a.clipPath);
            return;
        }
        SVG.e eVar = (SVG.e) p;
        if (eVar.i.isEmpty()) {
            this.a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = eVar.o;
        boolean z = bool == null || bool.booleanValue();
        if ((zVar instanceof SVG.j) && !z) {
            j1("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", zVar.a());
            return;
        }
        E();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.a, bVar.b);
            matrix.preScale(bVar.c, bVar.d);
            this.a.concat(matrix);
        }
        Matrix matrix2 = eVar.n;
        if (matrix2 != null) {
            this.a.concat(matrix2);
        }
        this.d = U(eVar);
        u(eVar);
        Path path = new Path();
        for (SVG.c0 c0Var : eVar.i) {
            j(c0Var, true, path, new Matrix());
        }
        this.a.clipPath(path);
        D();
    }

    private void w0(SVG.d dVar) {
        G("Circle render", new Object[0]);
        SVG.Length length = dVar.q;
        if (length == null || length.isZero()) {
            return;
        }
        f1(this.d, dVar);
        if (I() && i1()) {
            Matrix matrix = dVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path g0 = g0(dVar);
            d1(dVar);
            x(dVar);
            u(dVar);
            boolean u0 = u0();
            if (this.d.b) {
                J(dVar, g0);
            }
            if (this.d.c) {
                K(g0);
            }
            if (u0) {
                r0(dVar);
            }
        }
    }

    private void x(SVG.z zVar) {
        SVG.SvgPaint svgPaint = this.d.a.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            H(true, zVar.h, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = this.d.a.stroke;
        if (svgPaint2 instanceof SVG.PaintReference) {
            H(false, zVar.h, (SVG.PaintReference) svgPaint2);
        }
    }

    private void x0(SVG.g gVar) {
        G("Ellipse render", new Object[0]);
        SVG.Length length = gVar.q;
        if (length == null || gVar.r == null || length.isZero() || gVar.r.isZero()) {
            return;
        }
        f1(this.d, gVar);
        if (I() && i1()) {
            Matrix matrix = gVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path h0 = h0(gVar);
            d1(gVar);
            x(gVar);
            u(gVar);
            boolean u0 = u0();
            if (this.d.b) {
                J(gVar, h0);
            }
            if (this.d.c) {
                K(h0);
            }
            if (u0) {
                r0(gVar);
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

    private void y0(SVG.j jVar) {
        G("Group render", new Object[0]);
        f1(this.d, jVar);
        if (I()) {
            Matrix matrix = jVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            u(jVar);
            boolean u0 = u0();
            N0(jVar, true);
            if (u0) {
                r0(jVar);
            }
            d1(jVar);
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
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.e.z(java.lang.String, java.lang.Integer, com.caverock.androidsvg.SVG$Style$FontStyle):android.graphics.Typeface");
    }

    private void z0(SVG.k kVar) {
        SVG.Length length;
        String str;
        G("Image render", new Object[0]);
        SVG.Length length2 = kVar.r;
        if (length2 == null || length2.isZero() || (length = kVar.s) == null || length.isZero() || (str = kVar.o) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = kVar.n;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        Bitmap y = y(str);
        if (y == null) {
            SVG.g();
            return;
        }
        SVG.b bVar = new SVG.b(0.0f, 0.0f, y.getWidth(), y.getHeight());
        f1(this.d, kVar);
        if (I() && i1()) {
            Matrix matrix = kVar.t;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            SVG.Length length3 = kVar.p;
            float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = kVar.q;
            this.d.f = new SVG.b(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f, kVar.r.floatValueX(this), kVar.s.floatValueX(this));
            if (!this.d.a.overflow.booleanValue()) {
                SVG.b bVar2 = this.d.f;
                W0(bVar2.a, bVar2.b, bVar2.c, bVar2.d);
            }
            kVar.h = this.d.f;
            d1(kVar);
            u(kVar);
            boolean u0 = u0();
            h1();
            this.a.save();
            this.a.concat(t(this.d.f, bVar, preserveAspectRatio));
            this.a.drawBitmap(y, 0.0f, 0.0f, new Paint(this.d.a.imageRendering != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.a.restore();
            if (u0) {
                r0(kVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(SVG svg, com.caverock.androidsvg.d dVar) {
        SVG.b bVar;
        PreserveAspectRatio preserveAspectRatio;
        Objects.requireNonNull(dVar, "renderOptions shouldn't be null");
        this.c = svg;
        SVG.w l = svg.l();
        if (l == null) {
            j1("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (dVar.e()) {
            SVG.a0 f2 = this.c.f(dVar.e);
            if (f2 == null || !(f2 instanceof SVG.q0)) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", dVar.e));
                return;
            }
            SVG.q0 q0Var = (SVG.q0) f2;
            bVar = q0Var.o;
            if (bVar == null) {
                Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", dVar.e));
                return;
            }
            preserveAspectRatio = q0Var.n;
        } else {
            bVar = dVar.f() ? dVar.d : l.o;
            preserveAspectRatio = dVar.c() ? dVar.b : l.n;
        }
        if (dVar.b()) {
            svg.a(dVar.a);
        }
        if (dVar.d()) {
            CSSParser.l lVar = new CSSParser.l();
            this.h = lVar;
            lVar.a = svg.f(dVar.c);
        }
        V0();
        A(l);
        a1();
        SVG.b bVar2 = new SVG.b(dVar.f);
        SVG.Length length = l.r;
        if (length != null) {
            bVar2.c = length.floatValue(this, bVar2.c);
        }
        SVG.Length length2 = l.s;
        if (length2 != null) {
            bVar2.d = length2.floatValue(this, bVar2.d);
        }
        H0(l, bVar2, bVar, preserveAspectRatio);
        Z0();
        if (dVar.b()) {
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
    public SVG.b a0() {
        h hVar = this.d;
        SVG.b bVar = hVar.g;
        return bVar != null ? bVar : hVar.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b0() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class k extends j {
        float a;

        private k() {
            super(e.this, null);
            this.a = 0.0f;
        }

        @Override // com.caverock.androidsvg.e.j
        public void b(String str) {
            this.a += e.this.d.d.measureText(str);
        }

        /* synthetic */ k(e eVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class h {
        SVG.Style a;
        boolean b;
        boolean c;
        Paint d;
        Paint e;
        SVG.b f;
        SVG.b g;
        boolean h;

        h(e eVar) {
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

        h(e eVar, h hVar) {
            this.b = hVar.b;
            this.c = hVar.c;
            this.d = new Paint(hVar.d);
            this.e = new Paint(hVar.e);
            SVG.b bVar = hVar.f;
            if (bVar != null) {
                this.f = new SVG.b(bVar);
            }
            SVG.b bVar2 = hVar.g;
            if (bVar2 != null) {
                this.g = new SVG.b(bVar2);
            }
            this.h = hVar.h;
            try {
                this.a = (SVG.Style) hVar.a.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
                this.a = SVG.Style.getDefaultStyle();
            }
        }
    }
}
