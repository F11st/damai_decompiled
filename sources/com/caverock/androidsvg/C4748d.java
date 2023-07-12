package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

/* compiled from: Taobao */
/* renamed from: com.caverock.androidsvg.d */
/* loaded from: classes10.dex */
public class C4748d {
    CSSParser.C4688m a;
    PreserveAspectRatio b;
    String c;
    SVG.C4693b d;
    String e;
    SVG.C4693b f;

    public C4748d() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public C4748d a(String str) {
        this.a = new CSSParser(CSSParser.Source.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        CSSParser.C4688m c4688m = this.a;
        return c4688m != null && c4688m.f() > 0;
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean d() {
        return this.c != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public C4748d h(float f, float f2, float f3, float f4) {
        this.f = new SVG.C4693b(f, f2, f3, f4);
        return this;
    }

    public C4748d(C4748d c4748d) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        if (c4748d == null) {
            return;
        }
        this.a = c4748d.a;
        this.b = c4748d.b;
        this.d = c4748d.d;
        this.e = c4748d.e;
        this.f = c4748d.f;
    }
}
