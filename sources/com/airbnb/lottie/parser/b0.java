package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.k5;
import tb.t12;
import tb.u5;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class b0 {
    private static JsonReader.a a = JsonReader.a.a("nm", com.huawei.hms.opendevice.c.a, "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t12 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        String str = null;
        k5 k5Var = null;
        k5 k5Var2 = null;
        u5 u5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                k5Var = d.f(jsonReader, aVar, false);
            } else if (s == 2) {
                k5Var2 = d.f(jsonReader, aVar, false);
            } else if (s == 3) {
                u5Var = c.g(jsonReader, aVar);
            } else if (s != 4) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new t12(str, k5Var, k5Var2, u5Var, z);
    }
}
