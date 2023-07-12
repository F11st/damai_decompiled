package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.mb2;
import tb.q5;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.g0 */
/* loaded from: classes17.dex */
class C2902g0 {
    static JsonReader.C2911a a = JsonReader.C2911a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static mb2 a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        int i = 0;
        String str = null;
        q5 q5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                i = jsonReader.m();
            } else if (s == 2) {
                q5Var = C2895d.k(jsonReader, c2821a);
            } else if (s != 3) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new mb2(str, i, q5Var, z);
    }
}
