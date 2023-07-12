package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import tb.j5;
import tb.k5;
import tb.t5;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class b {
    private static JsonReader.a a = JsonReader.a.a("a");
    private static JsonReader.a b = JsonReader.a.a("fc", IRequestConst.SC, "sw", "t");

    public static t5 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        jsonReader.e();
        t5 t5Var = null;
        while (jsonReader.j()) {
            if (jsonReader.s(a) != 0) {
                jsonReader.t();
                jsonReader.u();
            } else {
                t5Var = b(jsonReader, aVar);
            }
        }
        jsonReader.g();
        return t5Var == null ? new t5(null, null, null, null) : t5Var;
    }

    private static t5 b(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        jsonReader.e();
        j5 j5Var = null;
        j5 j5Var2 = null;
        k5 k5Var = null;
        k5 k5Var2 = null;
        while (jsonReader.j()) {
            int s = jsonReader.s(b);
            if (s == 0) {
                j5Var = d.c(jsonReader, aVar);
            } else if (s == 1) {
                j5Var2 = d.c(jsonReader, aVar);
            } else if (s == 2) {
                k5Var = d.e(jsonReader, aVar);
            } else if (s != 3) {
                jsonReader.t();
                jsonReader.u();
            } else {
                k5Var2 = d.e(jsonReader, aVar);
            }
        }
        jsonReader.g();
        return new t5(j5Var, j5Var2, k5Var, k5Var2);
    }
}
