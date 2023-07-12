package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.o5;
import tb.wi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.e */
/* loaded from: classes17.dex */
public class C2897e {
    private static JsonReader.C2911a a = JsonReader.C2911a.a("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static wi a(JsonReader jsonReader, C2821a c2821a, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        o5 o5Var = null;
        boolean z2 = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                animatableValue = C2889a.b(jsonReader, c2821a);
            } else if (s == 2) {
                o5Var = C2895d.i(jsonReader, c2821a);
            } else if (s == 3) {
                z2 = jsonReader.k();
            } else if (s != 4) {
                jsonReader.t();
                jsonReader.u();
            } else {
                z = jsonReader.m() == 3;
            }
        }
        return new wi(str, animatableValue, o5Var, z, z2);
    }
}
