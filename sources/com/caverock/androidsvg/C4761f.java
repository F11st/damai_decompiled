package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.caverock.androidsvg.C4749e;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.caverock.androidsvg.f */
/* loaded from: classes10.dex */
public class C4761f {
    private SVG a;
    private float b;
    private Picture c;
    private Map<String, SVG.AbstractC4692a0> d;
    private List<C4768g> e;
    private List<CSSParser.C4686k> f;

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$a */
    /* loaded from: classes10.dex */
    public static class C4762a extends C4768g {
    }

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$b */
    /* loaded from: classes10.dex */
    public static class C4763b extends C4768g {
    }

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$c */
    /* loaded from: classes10.dex */
    public static class C4764c extends C4768g {
        private Path c;

        public Path e() {
            return this.c;
        }

        public void f(Path path) {
            this.c = path;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$d */
    /* loaded from: classes10.dex */
    public static class C4765d extends C4768g {
        private float[] c;

        public float[] e() {
            return this.c;
        }

        public void f(float[] fArr) {
            this.c = fArr;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$e */
    /* loaded from: classes10.dex */
    public static class C4766e extends C4765d {
    }

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$f */
    /* loaded from: classes10.dex */
    public static class C4767f extends C4768g {
    }

    /* compiled from: Taobao */
    /* renamed from: com.caverock.androidsvg.f$g */
    /* loaded from: classes10.dex */
    public static class C4768g {
        private String a;
        private RectF b;

        public RectF a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }

        public void c(RectF rectF) {
            this.b = rectF;
        }

        public void d(String str) {
            this.a = str;
        }
    }

    public C4761f(SVG svg) {
        SVG.C4730w l;
        List<SVG.C4696c0> children;
        this.a = svg;
        if (svg == null || svg.l() == null || (children = (l = this.a.l()).getChildren()) == null || children.isEmpty()) {
            return;
        }
        this.d = new HashMap((int) (children.size() / 0.75f));
        t(l);
        this.c = f();
        d();
        this.f = new ArrayList();
        List<CSSParser.C4686k> k = k();
        if (k == null || k.isEmpty()) {
            return;
        }
        this.f.addAll(k);
    }

    private C4768g b(SVG.C4697d c4697d) {
        if (c4697d.h == null) {
            return null;
        }
        C4762a c4762a = new C4762a();
        RectF rectF = new RectF();
        SVG.C4693b c4693b = c4697d.h;
        float f = c4693b.a;
        float f2 = c4693b.b;
        rectF.set(f, f2, c4693b.c + f, c4693b.d + f2);
        p(rectF, c4697d.n);
        c4762a.d(c4697d.c);
        c4762a.c(rectF);
        return c4762a;
    }

    private C4768g c(SVG.C4703g c4703g) {
        if (c4703g.h == null) {
            return null;
        }
        C4763b c4763b = new C4763b();
        RectF rectF = new RectF();
        SVG.C4693b c4693b = c4703g.h;
        float f = c4693b.a;
        float f2 = c4693b.b;
        rectF.set(f, f2, c4693b.c + f, c4693b.d + f2);
        p(rectF, c4703g.n);
        c4763b.d(c4703g.c);
        c4763b.c(rectF);
        return c4763b;
    }

    private void d() {
        Map<String, SVG.AbstractC4692a0> map;
        if (this.a == null || (map = this.d) == null || map.isEmpty()) {
            return;
        }
        List<C4768g> list = this.e;
        if (list == null) {
            this.e = new ArrayList();
        } else {
            list.clear();
        }
        for (Map.Entry<String, SVG.AbstractC4692a0> entry : this.d.entrySet()) {
            SVG.AbstractC4692a0 value = entry.getValue();
            if (value instanceof SVG.C4727t) {
                this.e.add(i((SVG.C4727t) value));
            }
            if (value instanceof SVG.C4697d) {
                this.e.add(b((SVG.C4697d) value));
            }
            if (value instanceof SVG.C4703g) {
                this.e.add(c((SVG.C4703g) value));
            }
            if (value instanceof SVG.C4719o) {
                this.e.add(e((SVG.C4719o) value));
            }
            if (value instanceof SVG.C4726s) {
                this.e.add(h((SVG.C4726s) value));
            }
            if (value instanceof SVG.C4725r) {
                this.e.add(g((SVG.C4725r) value));
            }
        }
    }

    private C4768g e(SVG.C4719o c4719o) {
        if (c4719o.h == null) {
            return null;
        }
        C4764c c4764c = new C4764c();
        RectF rectF = new RectF();
        SVG.C4693b c4693b = c4719o.h;
        float f = c4693b.a;
        float f2 = c4693b.b;
        rectF.set(f, f2, c4693b.c + f, c4693b.d + f2);
        p(rectF, c4719o.n);
        c4764c.d(c4719o.c);
        c4764c.c(rectF);
        c4764c.f(new C4749e.C4753d(c4719o.o).a());
        return c4764c;
    }

    private Picture f() {
        return this.a.o(new C4748d());
    }

    private C4768g g(SVG.C4725r c4725r) {
        if (c4725r.h == null) {
            return null;
        }
        C4765d c4765d = new C4765d();
        RectF rectF = new RectF();
        SVG.C4693b c4693b = c4725r.h;
        float f = c4693b.a;
        float f2 = c4693b.b;
        rectF.set(f, f2, c4693b.c + f, c4693b.d + f2);
        c4765d.c(p(rectF, c4725r.n));
        c4765d.f(q(c4725r.o, c4725r.n));
        c4765d.d(c4725r.c);
        return c4765d;
    }

    private C4768g h(SVG.C4726s c4726s) {
        if (c4726s.h == null) {
            return null;
        }
        C4766e c4766e = new C4766e();
        RectF rectF = new RectF();
        SVG.C4693b c4693b = c4726s.h;
        float f = c4693b.a;
        float f2 = c4693b.b;
        rectF.set(f, f2, c4693b.c + f, c4693b.d + f2);
        c4766e.c(p(rectF, c4726s.n));
        c4766e.f(q(c4726s.o, c4726s.n));
        c4766e.d(c4726s.c);
        return c4766e;
    }

    private C4768g i(SVG.C4727t c4727t) {
        if (c4727t.h == null) {
            return null;
        }
        C4767f c4767f = new C4767f();
        RectF rectF = new RectF();
        SVG.C4693b c4693b = c4727t.h;
        float f = c4693b.a;
        float f2 = c4693b.b;
        rectF.set(f, f2, c4693b.c + f, c4693b.d + f2);
        p(rectF, c4727t.n);
        c4767f.d(c4727t.c);
        c4767f.c(rectF);
        return c4767f;
    }

    private void j() {
        SVG svg = this.a;
        if (svg != null) {
            svg.b();
        }
    }

    private List<CSSParser.C4686k> k() {
        SVG svg = this.a;
        if (svg != null) {
            return svg.d();
        }
        return null;
    }

    private RectF p(RectF rectF, @Nullable Matrix matrix) {
        if (matrix != null) {
            try {
                matrix.mapRect(rectF);
                return rectF;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rectF;
    }

    private float[] q(float[] fArr, @Nullable Matrix matrix) {
        if (matrix != null && fArr != null) {
            try {
                if (fArr.length > 0) {
                    float[] fArr2 = new float[fArr.length];
                    for (int i = 0; i < fArr.length; i++) {
                        fArr2[i] = fArr[i];
                    }
                    matrix.mapPoints(fArr2);
                    return fArr2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fArr;
    }

    private void t(SVG.SvgContainer svgContainer) {
        if (svgContainer == null) {
            return;
        }
        SVG.AbstractC4692a0 abstractC4692a0 = (SVG.AbstractC4692a0) svgContainer;
        if (!TextUtils.isEmpty(abstractC4692a0.c)) {
            this.d.put(abstractC4692a0.c, abstractC4692a0);
        }
        List<SVG.C4696c0> children = svgContainer.getChildren();
        if (children == null || children.isEmpty()) {
            return;
        }
        for (int i = 0; i < children.size(); i++) {
            SVG.C4696c0 c4696c0 = children.get(i);
            if (c4696c0 instanceof SVG.AbstractC4692a0) {
                SVG.AbstractC4692a0 abstractC4692a02 = (SVG.AbstractC4692a0) c4696c0;
                if (!TextUtils.isEmpty(abstractC4692a02.c)) {
                    this.d.put(abstractC4692a02.c, abstractC4692a02);
                }
                if (c4696c0 instanceof SVG.SvgContainer) {
                    t((SVG.SvgContainer) c4696c0);
                }
            }
        }
    }

    public void a(List<CSSParser.C4686k> list) {
        if (list == null) {
            return;
        }
        CSSParser.C4688m c4688m = new CSSParser.C4688m();
        for (CSSParser.C4686k c4686k : list) {
            c4688m.a(c4686k);
        }
        SVG svg = this.a;
        if (svg != null) {
            svg.a(c4688m);
        }
    }

    public List<C4768g> l() {
        return this.e;
    }

    public Picture m() {
        return this.c;
    }

    public Set<String> n() {
        Map<String, SVG.AbstractC4692a0> map = this.d;
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    public float o() {
        return this.b;
    }

    public Picture r(C4748d c4748d) {
        SVG svg = this.a;
        if (svg != null) {
            return svg.o(c4748d);
        }
        return null;
    }

    public void s() {
        j();
        a(this.f);
    }

    public void u(float f) {
        this.b = f;
    }
}
