package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class r {
    static JsonReader.a a = JsonReader.a.a("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<u71<T>> a(JsonReader jsonReader, com.airbnb.lottie.a aVar, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.q() == JsonReader.Token.STRING) {
            aVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.e();
        while (jsonReader.j()) {
            if (jsonReader.s(a) != 0) {
                jsonReader.u();
            } else if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.q() == JsonReader.Token.NUMBER) {
                    arrayList.add(q.c(jsonReader, aVar, f, valueParser, false, z));
                } else {
                    while (jsonReader.j()) {
                        arrayList.add(q.c(jsonReader, aVar, f, valueParser, true, z));
                    }
                }
                jsonReader.f();
            } else {
                arrayList.add(q.c(jsonReader, aVar, f, valueParser, false, z));
            }
        }
        jsonReader.g();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends u71<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            u71<T> u71Var = list.get(i2);
            i2++;
            u71<T> u71Var2 = list.get(i2);
            u71Var.h = Float.valueOf(u71Var2.g);
            if (u71Var.c == null && (t = u71Var2.b) != null) {
                u71Var.c = t;
                if (u71Var instanceof com.airbnb.lottie.animation.keyframe.f) {
                    ((com.airbnb.lottie.animation.keyframe.f) u71Var).i();
                }
            }
        }
        u71<T> u71Var3 = list.get(i);
        if ((u71Var3.b == null || u71Var3.c == null) && list.size() > 1) {
            list.remove(u71Var3);
        }
    }
}
