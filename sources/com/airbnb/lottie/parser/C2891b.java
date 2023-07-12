package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import tb.j5;
import tb.k5;
import tb.t5;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.b */
/* loaded from: classes17.dex */
public class C2891b {
    private static JsonReader.C2911a a = JsonReader.C2911a.a("a");
    private static JsonReader.C2911a b = JsonReader.C2911a.a("fc", IRequestConst.SC, "sw", "t");

    public static t5 a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        jsonReader.e();
        t5 t5Var = null;
        while (jsonReader.j()) {
            if (jsonReader.s(a) != 0) {
                jsonReader.t();
                jsonReader.u();
            } else {
                t5Var = b(jsonReader, c2821a);
            }
        }
        jsonReader.g();
        return t5Var == null ? new t5(null, null, null, null) : t5Var;
    }

    private static t5 b(JsonReader jsonReader, C2821a c2821a) throws IOException {
        jsonReader.e();
        j5 j5Var = null;
        j5 j5Var2 = null;
        k5 k5Var = null;
        k5 k5Var2 = null;
        while (jsonReader.j()) {
            int s = jsonReader.s(b);
            if (s == 0) {
                j5Var = C2895d.c(jsonReader, c2821a);
            } else if (s == 1) {
                j5Var2 = C2895d.c(jsonReader, c2821a);
            } else if (s == 2) {
                k5Var = C2895d.e(jsonReader, c2821a);
            } else if (s != 3) {
                jsonReader.t();
                jsonReader.u();
            } else {
                k5Var2 = C2895d.e(jsonReader, c2821a);
            }
        }
        jsonReader.g();
        return new t5(j5Var, j5Var2, k5Var, k5Var2);
    }
}
