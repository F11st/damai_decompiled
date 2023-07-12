package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.o5;
import tb.wi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class e {
    private static JsonReader.a a = JsonReader.a.a("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static wi a(JsonReader jsonReader, com.airbnb.lottie.a aVar, int i) throws IOException {
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
                animatableValue = a.b(jsonReader, aVar);
            } else if (s == 2) {
                o5Var = d.i(jsonReader, aVar);
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
