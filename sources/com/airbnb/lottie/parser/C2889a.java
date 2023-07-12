package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import tb.aw2;
import tb.k5;
import tb.n5;
import tb.r5;
import tb.u71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.a */
/* loaded from: classes17.dex */
public class C2889a {
    private static final JsonReader.C2911a a = JsonReader.C2911a.a("k", Constants.Name.X, Constants.Name.Y);

    public static n5 a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.j()) {
                arrayList.add(C2934w.a(jsonReader, c2821a));
            }
            jsonReader.f();
            C2928r.b(arrayList);
        } else {
            arrayList.add(new u71(C2925p.e(jsonReader, aw2.e())));
        }
        return new n5(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, C2821a c2821a) throws IOException {
        jsonReader.e();
        n5 n5Var = null;
        k5 k5Var = null;
        k5 k5Var2 = null;
        boolean z = false;
        while (jsonReader.q() != JsonReader.Token.END_OBJECT) {
            int s = jsonReader.s(a);
            if (s == 0) {
                n5Var = a(jsonReader, c2821a);
            } else if (s != 1) {
                if (s != 2) {
                    jsonReader.t();
                    jsonReader.u();
                } else if (jsonReader.q() == JsonReader.Token.STRING) {
                    jsonReader.u();
                    z = true;
                } else {
                    k5Var2 = C2895d.e(jsonReader, c2821a);
                }
            } else if (jsonReader.q() == JsonReader.Token.STRING) {
                jsonReader.u();
                z = true;
            } else {
                k5Var = C2895d.e(jsonReader, c2821a);
            }
        }
        jsonReader.g();
        if (z) {
            c2821a.a("Lottie doesn't support expressions.");
        }
        return n5Var != null ? n5Var : new r5(k5Var, k5Var2);
    }
}
