package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.basic.GXText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ar0 {
    @NotNull
    public static final ar0 INSTANCE = new ar0();

    private ar0() {
    }

    private final CharSequence b(os0 os0Var, String str, View view, pq0 pq0Var, qs0 qs0Var, JSONObject jSONObject) {
        CharSequence b;
        JSONObject d = qs0Var.d(jSONObject);
        Object obj = d == null ? null : d.get("value");
        if (!(obj instanceof String) || (b = fr0.INSTANCE.b(view, qs0Var, jSONObject, (String) obj)) == null) {
            Object c = c(os0Var, str, view, pq0Var, qs0Var, jSONObject);
            if (c != null) {
                if (c instanceof CharSequence) {
                    return (CharSequence) c;
                }
                return c.toString();
            } else if (obj != null) {
                return obj.toString();
            } else {
                return null;
            }
        }
        return b;
    }

    private final Object c(os0 os0Var, String str, View view, pq0 pq0Var, qs0 qs0Var, JSONObject jSONObject) {
        Object obj;
        GXTemplateEngine.GXIDataListener b;
        CharSequence onTextProcess;
        GXTemplateEngine.h p = os0Var.p();
        if ((p == null ? null : p.b()) != null) {
            JSONObject d = qs0Var.d(jSONObject);
            GXTemplateEngine.j jVar = new GXTemplateEngine.j();
            jVar.m((d == null || (obj = d.get("value")) == null) ? null : obj.toString());
            jVar.g(view);
            jVar.e(str);
            jVar.f(os0Var.r());
            jVar.k(pq0Var);
            jVar.l(d);
            jVar.d(Integer.valueOf(os0Var.h()));
            jVar.j(qs0Var.h(jSONObject));
            GXTemplateEngine.h p2 = os0Var.p();
            if (p2 != null && (b = p2.b()) != null && (onTextProcess = b.onTextProcess(jVar)) != null) {
                return onTextProcess;
            }
        }
        return null;
    }

    @Nullable
    public final ld2<k80> a(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull qs0 qs0Var, @NotNull js0 js0Var, @NotNull JSONObject jSONObject) {
        k80 d;
        k80 a;
        k80 c;
        k80 b;
        ld2<k80> ld2Var;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(qs0Var, "gxTemplateNode");
        b41.i(js0Var, "gxStretchNode");
        b41.i(jSONObject, "templateData");
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        ld2<k80> ld2Var2 = null;
        if ((qs0Var.z() || qs0Var.w()) && qr0Var.C()) {
            Context e = os0Var.e();
            String j = qs0Var.j();
            if (qs0Var.e() == null) {
                return null;
            }
            pq0 b2 = qs0Var.b();
            br0 a2 = b2.a();
            ls0 b3 = b2.b();
            l81 h = qr0Var.h();
            if (h == null && (h = qr0Var.i()) == null) {
                throw new IllegalArgumentException("to fit content for text, but layout is null");
            }
            l81 l81Var = h;
            or0 or0Var = or0.INSTANCE;
            GXText b4 = or0Var.b(e);
            b4.setTextStyle(b2);
            CharSequence b5 = b(os0Var, j, b4, b2, qs0Var, jSONObject);
            if (b5 == null) {
                or0Var.d(b4);
                return null;
            }
            b4.setText(b5);
            Integer y = b3.y();
            float e2 = l81Var.e();
            float d2 = l81Var.d();
            ld2<k80> V = a2.V();
            k80 a3 = V == null ? null : V.a();
            if (qr0Var.h() == null && (a3 instanceof k80.c)) {
                k80.c cVar = (k80.c) a3;
                if (!(d2 == cVar.b())) {
                    d2 = cVar.b();
                }
            }
            if (y != null && y.intValue() != 1) {
                if (y.intValue() == 0) {
                    b4.setFontLines(y);
                    if (e2 == 0.0f) {
                        GXRegisterCenter.b d3 = GXRegisterCenter.Companion.a().d();
                        if (!(d3 != null && d3.g())) {
                            throw new IllegalArgumentException("If lines = 0 or lines > 1, you must set text width");
                        }
                    } else if (e2 > 0.0f) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec((int) e2, Integer.MIN_VALUE), 0);
                        ld2Var2 = new ld2<>(new k80.c(e2), new k80.c(b4.getMeasuredHeight()));
                    }
                } else if (y.intValue() > 1) {
                    b4.setFontLines(y);
                    if (e2 == 0.0f) {
                        GXRegisterCenter.b d4 = GXRegisterCenter.Companion.a().d();
                        if (!(d4 != null && d4.g())) {
                            throw new IllegalArgumentException("If lines = 0 or lines > 1, you must set text width");
                        }
                    } else if (e2 > 0.0f) {
                        b4.measure(View.MeasureSpec.makeMeasureSpec((int) e2, Integer.MIN_VALUE), 0);
                        ld2Var2 = new ld2<>(new k80.c(b4.getMeasuredWidth()), new k80.c(b4.getMeasuredHeight()));
                    }
                }
            } else {
                b4.setSingleLine(true);
                b4.measure(0, 0);
                float measuredWidth = b4.getMeasuredWidth();
                float measuredHeight = b4.getMeasuredHeight();
                ld2<k80> V2 = b2.a().V();
                boolean z = (V2 != null ? V2.b() : null) == null || (V2.b() instanceof k80.a) || (V2.b() instanceof k80.d);
                ld2<k80> I = b2.a().I();
                boolean z2 = (I == null || ((I.b() instanceof k80.a) && (I.b() instanceof k80.d))) ? false : true;
                if (z && z2) {
                    if (measuredWidth < e2) {
                        measuredWidth = e2;
                    }
                    e2 = 0.0f;
                }
                lz1<k80> N = a2.N();
                if (d2 == ((N != null && (d = N.d()) != null) ? d.b() : 0.0f) + ((N != null && (a = N.a()) != null) ? a.b() : 0.0f)) {
                    d2 = 0.0f;
                }
                if (!(d2 == 0.0f)) {
                    measuredHeight = d2;
                }
                float b6 = ((N == null || (c = N.c()) == null) ? 0.0f : c.b()) + ((N == null || (b = N.b()) == null) ? 0.0f : b.b());
                if (e2 == 0.0f) {
                    ld2Var = new ld2<>(new k80.c(measuredWidth), new k80.c(measuredHeight));
                } else {
                    if (e2 == b6) {
                        ld2Var = new ld2<>(new k80.c(measuredWidth), new k80.c(measuredHeight));
                    } else if (measuredWidth >= e2) {
                        ld2Var2 = new ld2<>(new k80.c(e2), new k80.c(measuredHeight));
                    } else {
                        ld2Var = new ld2<>(new k80.c(measuredWidth), new k80.c(measuredHeight));
                    }
                }
                ld2Var2 = ld2Var;
            }
            or0Var.d(b4);
            return ld2Var2;
        }
        return null;
    }
}
