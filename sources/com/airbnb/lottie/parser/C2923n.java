package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.model.content.C2871a;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tb.k5;
import tb.l5;
import tb.m5;
import tb.m80;
import tb.o5;
import tb.u71;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.n */
/* loaded from: classes17.dex */
public class C2923n {
    private static JsonReader.C2911a a = JsonReader.C2911a.a("nm", "g", "o", "t", "s", "e", WXComponent.PROP_FS_WRAP_CONTENT, m80.LOWER_PREFIX, "lj", "ml", "hd", "d");
    private static final JsonReader.C2911a b = JsonReader.C2911a.a("p", "k");
    private static final JsonReader.C2911a c = JsonReader.C2911a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C2871a a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        l5 l5Var;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        l5 l5Var2 = null;
        o5 o5Var = null;
        o5 o5Var2 = null;
        k5 k5Var = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        k5 k5Var2 = null;
        boolean z = false;
        m5 m5Var = null;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int s = jsonReader.s(b);
                        if (s != 0) {
                            l5Var = l5Var2;
                            if (s != 1) {
                                jsonReader.t();
                                jsonReader.u();
                            } else {
                                l5Var2 = C2895d.g(jsonReader, c2821a, i);
                            }
                        } else {
                            l5Var = l5Var2;
                            i = jsonReader.m();
                        }
                        l5Var2 = l5Var;
                    }
                    jsonReader.g();
                    break;
                case 2:
                    m5Var = C2895d.h(jsonReader, c2821a);
                    break;
                case 3:
                    gradientType = jsonReader.m() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    o5Var = C2895d.i(jsonReader, c2821a);
                    break;
                case 5:
                    o5Var2 = C2895d.i(jsonReader, c2821a);
                    break;
                case 6:
                    k5Var = C2895d.e(jsonReader, c2821a);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    break;
                case 9:
                    f = (float) jsonReader.l();
                    break;
                case 10:
                    z = jsonReader.k();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        jsonReader.e();
                        String str2 = null;
                        k5 k5Var3 = null;
                        while (jsonReader.j()) {
                            int s2 = jsonReader.s(c);
                            if (s2 != 0) {
                                k5 k5Var4 = k5Var2;
                                if (s2 != 1) {
                                    jsonReader.t();
                                    jsonReader.u();
                                } else {
                                    k5Var3 = C2895d.e(jsonReader, c2821a);
                                }
                                k5Var2 = k5Var4;
                            } else {
                                str2 = jsonReader.o();
                            }
                        }
                        k5 k5Var5 = k5Var2;
                        jsonReader.g();
                        if (str2.equals("o")) {
                            k5Var2 = k5Var3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                c2821a.t(true);
                                arrayList.add(k5Var3);
                            }
                            k5Var2 = k5Var5;
                        }
                    }
                    k5 k5Var6 = k5Var2;
                    jsonReader.f();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    k5Var2 = k5Var6;
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        if (m5Var == null) {
            m5Var = new m5(Collections.singletonList(new u71(100)));
        }
        return new C2871a(str, gradientType, l5Var2, m5Var, o5Var, o5Var2, k5Var, lineCapType, lineJoinType, f, arrayList, k5Var2, z);
    }
}
