package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.opendevice.AbstractC5658c;
import java.io.IOException;
import tb.k5;
import tb.t12;
import tb.u5;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.b0 */
/* loaded from: classes17.dex */
public class C2892b0 {
    private static JsonReader.C2911a a = JsonReader.C2911a.a("nm", AbstractC5658c.a, "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t12 a(JsonReader jsonReader, C2821a c2821a) throws IOException {
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
                k5Var = C2895d.f(jsonReader, c2821a, false);
            } else if (s == 2) {
                k5Var2 = C2895d.f(jsonReader, c2821a, false);
            } else if (s == 3) {
                u5Var = C2893c.g(jsonReader, c2821a);
            } else if (s != 4) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new t12(str, k5Var, k5Var2, u5Var, z);
    }
}
