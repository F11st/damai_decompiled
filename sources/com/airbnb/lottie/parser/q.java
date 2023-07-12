package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.common.Constants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import tb.aw2;
import tb.eg1;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class q {
    private static SparseArrayCompat<WeakReference<Interpolator>> b;
    private static final Interpolator a = new LinearInterpolator();
    static JsonReader.a c = JsonReader.a.a("t", "s", "e", "o", "i", "h", "to", IRequestConst.TI);
    static JsonReader.a d = JsonReader.a.a(Constants.Name.X, Constants.Name.Y);

    q() {
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = g().get(i);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = eg1.c(pointF.x, -1.0f, 1.0f);
        pointF.y = eg1.c(pointF.y, -100.0f, 100.0f);
        pointF2.x = eg1.c(pointF2.x, -1.0f, 1.0f);
        float c2 = eg1.c(pointF2.y, -100.0f, 100.0f);
        pointF2.y = c2;
        int i = aw2.i(pointF.x, pointF.y, pointF2.x, c2);
        WeakReference<Interpolator> a2 = a(i);
        Interpolator interpolator = a2 != null ? a2.get() : null;
        if (a2 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                h(i, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> u71<T> c(JsonReader jsonReader, com.airbnb.lottie.a aVar, float f, ValueParser<T> valueParser, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return e(aVar, jsonReader, f, valueParser);
        }
        if (z) {
            return d(aVar, jsonReader, f, valueParser);
        }
        return f(jsonReader, f, valueParser);
    }

    private static <T> u71<T> d(com.airbnb.lottie.a aVar, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t;
        jsonReader.e();
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (jsonReader.j()) {
            switch (jsonReader.s(c)) {
                case 0:
                    f2 = (float) jsonReader.l();
                    break;
                case 1:
                    t3 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointF = p.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF2 = p.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.m() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = p.e(jsonReader, f);
                    break;
                case 7:
                    pointF4 = p.e(jsonReader, f);
                    break;
                default:
                    jsonReader.u();
                    break;
            }
        }
        jsonReader.g();
        if (z) {
            interpolator2 = a;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = b(pointF, pointF2);
            } else {
                interpolator = a;
            }
            interpolator2 = interpolator;
            t = t2;
        }
        u71<T> u71Var = new u71<>(aVar, t3, t, interpolator2, f2, null);
        u71Var.o = pointF3;
        u71Var.p = pointF4;
        return u71Var;
    }

    private static <T> u71<T> e(com.airbnb.lottie.a aVar, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        Interpolator b2;
        Interpolator b3;
        T t;
        PointF pointF;
        u71<T> u71Var;
        PointF pointF2;
        float f2;
        PointF pointF3;
        jsonReader.e();
        PointF pointF4 = null;
        boolean z = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t2 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f3 = 0.0f;
        PointF pointF11 = null;
        T t3 = null;
        while (jsonReader.j()) {
            switch (jsonReader.s(c)) {
                case 0:
                    pointF2 = pointF4;
                    f3 = (float) jsonReader.l();
                    break;
                case 1:
                    pointF2 = pointF4;
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    pointF2 = pointF4;
                    t3 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointF2 = pointF4;
                    f2 = f3;
                    PointF pointF12 = pointF11;
                    if (jsonReader.q() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.e();
                        float f4 = 0.0f;
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        while (jsonReader.j()) {
                            int s = jsonReader.s(d);
                            if (s == 0) {
                                JsonReader.Token q = jsonReader.q();
                                JsonReader.Token token = JsonReader.Token.NUMBER;
                                if (q == token) {
                                    f6 = (float) jsonReader.l();
                                    f4 = f6;
                                } else {
                                    jsonReader.c();
                                    f4 = (float) jsonReader.l();
                                    f6 = jsonReader.q() == token ? (float) jsonReader.l() : f4;
                                    jsonReader.f();
                                }
                            } else if (s != 1) {
                                jsonReader.u();
                            } else {
                                JsonReader.Token q2 = jsonReader.q();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (q2 == token2) {
                                    f7 = (float) jsonReader.l();
                                    f5 = f7;
                                } else {
                                    jsonReader.c();
                                    f5 = (float) jsonReader.l();
                                    f7 = jsonReader.q() == token2 ? (float) jsonReader.l() : f5;
                                    jsonReader.f();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f4, f5);
                        PointF pointF14 = new PointF(f6, f7);
                        jsonReader.g();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f3 = f2;
                        break;
                    } else {
                        pointF5 = p.e(jsonReader, f);
                        f3 = f2;
                        pointF11 = pointF12;
                        break;
                    }
                case 4:
                    if (jsonReader.q() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.e();
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        while (jsonReader.j()) {
                            PointF pointF15 = pointF11;
                            int s2 = jsonReader.s(d);
                            if (s2 != 0) {
                                pointF3 = pointF4;
                                if (s2 != 1) {
                                    jsonReader.u();
                                } else {
                                    JsonReader.Token q3 = jsonReader.q();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (q3 == token3) {
                                        f11 = (float) jsonReader.l();
                                        f3 = f3;
                                        f9 = f11;
                                    } else {
                                        float f12 = f3;
                                        jsonReader.c();
                                        float l = (float) jsonReader.l();
                                        float l2 = jsonReader.q() == token3 ? (float) jsonReader.l() : l;
                                        jsonReader.f();
                                        f3 = f12;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f11 = l2;
                                        f9 = l;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f13 = f3;
                                JsonReader.Token q4 = jsonReader.q();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (q4 == token4) {
                                    f10 = (float) jsonReader.l();
                                    f3 = f13;
                                    f8 = f10;
                                } else {
                                    jsonReader.c();
                                    f8 = (float) jsonReader.l();
                                    f10 = jsonReader.q() == token4 ? (float) jsonReader.l() : f8;
                                    jsonReader.f();
                                    f3 = f13;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f2 = f3;
                        PointF pointF16 = new PointF(f8, f9);
                        PointF pointF17 = new PointF(f10, f11);
                        jsonReader.g();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f3 = f2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = p.e(jsonReader, f);
                        break;
                    }
                case 5:
                    if (jsonReader.m() == 1) {
                        z = true;
                    } else {
                        z = false;
                        continue;
                    }
                case 6:
                    pointF11 = p.e(jsonReader, f);
                    continue;
                case 7:
                    pointF4 = p.e(jsonReader, f);
                    continue;
                default:
                    pointF2 = pointF4;
                    jsonReader.u();
                    break;
            }
            pointF4 = pointF2;
        }
        PointF pointF18 = pointF4;
        float f14 = f3;
        PointF pointF19 = pointF11;
        jsonReader.g();
        if (z) {
            interpolator = a;
            t = t2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                b2 = b(pointF7, pointF9);
                b3 = b(pointF8, pointF10);
                t = t3;
                interpolator = null;
                if (b2 == null && b3 != null) {
                    pointF = pointF19;
                    u71Var = new u71<>(aVar, t2, t, b2, b3, f14, null);
                } else {
                    pointF = pointF19;
                    u71Var = new u71<>(aVar, t2, t, interpolator, f14, null);
                }
                u71Var.o = pointF;
                u71Var.p = pointF18;
                return u71Var;
            } else {
                interpolator = a;
            }
            t = t3;
        }
        b2 = null;
        b3 = null;
        if (b2 == null) {
        }
        pointF = pointF19;
        u71Var = new u71<>(aVar, t2, t, interpolator, f14, null);
        u71Var.o = pointF;
        u71Var.p = pointF18;
        return u71Var;
    }

    private static <T> u71<T> f(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new u71<>(valueParser.parse(jsonReader, f));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (b == null) {
            b = new SparseArrayCompat<>();
        }
        return b;
    }

    private static void h(int i, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            b.put(i, weakReference);
        }
    }
}
