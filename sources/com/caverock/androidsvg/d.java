package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d {
    CSSParser.m a;
    PreserveAspectRatio b;
    String c;
    SVG.b d;
    String e;
    SVG.b f;

    public d() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public d a(String str) {
        this.a = new CSSParser(CSSParser.Source.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        CSSParser.m mVar = this.a;
        return mVar != null && mVar.f() > 0;
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

    public d h(float f, float f2, float f3, float f4) {
        this.f = new SVG.b(f, f2, f3, f4);
        return this;
    }

    public d(d dVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        if (dVar == null) {
            return;
        }
        this.a = dVar.a;
        this.b = dVar.b;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f = dVar.f;
    }
}
