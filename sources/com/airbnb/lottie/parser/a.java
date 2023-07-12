package com.airbnb.lottie.parser;

import android.graphics.PointF;
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
/* loaded from: classes17.dex */
public class a {
    private static final JsonReader.a a = JsonReader.a.a("k", Constants.Name.X, Constants.Name.Y);

    public static n5 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.j()) {
                arrayList.add(w.a(jsonReader, aVar));
            }
            jsonReader.f();
            r.b(arrayList);
        } else {
            arrayList.add(new u71(p.e(jsonReader, aw2.e())));
        }
        return new n5(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        jsonReader.e();
        n5 n5Var = null;
        k5 k5Var = null;
        k5 k5Var2 = null;
        boolean z = false;
        while (jsonReader.q() != JsonReader.Token.END_OBJECT) {
            int s = jsonReader.s(a);
            if (s == 0) {
                n5Var = a(jsonReader, aVar);
            } else if (s != 1) {
                if (s != 2) {
                    jsonReader.t();
                    jsonReader.u();
                } else if (jsonReader.q() == JsonReader.Token.STRING) {
                    jsonReader.u();
                    z = true;
                } else {
                    k5Var2 = d.e(jsonReader, aVar);
                }
            } else if (jsonReader.q() == JsonReader.Token.STRING) {
                jsonReader.u();
                z = true;
            } else {
                k5Var = d.e(jsonReader, aVar);
            }
        }
        jsonReader.g();
        if (z) {
            aVar.a("Lottie doesn't support expressions.");
        }
        return n5Var != null ? n5Var : new r5(k5Var, k5Var2);
    }
}
