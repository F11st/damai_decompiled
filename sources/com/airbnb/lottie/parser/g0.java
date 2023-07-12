package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.mb2;
import tb.q5;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class g0 {
    static JsonReader.a a = JsonReader.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static mb2 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
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
                q5Var = d.k(jsonReader, aVar);
            } else if (s != 3) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new mb2(str, i, q5Var, z);
    }
}
