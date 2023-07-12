package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.eg1;
import tb.iq;
import tb.jb2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class d0 implements ValueParser<jb2> {
    public static final d0 INSTANCE = new d0();
    private static final JsonReader.a a = JsonReader.a.a(com.huawei.hms.opendevice.c.a, "v", "i", "o");

    private d0() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public jb2 parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.q() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.e();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                z = jsonReader.k();
            } else if (s == 1) {
                list = p.f(jsonReader, f);
            } else if (s == 2) {
                list2 = p.f(jsonReader, f);
            } else if (s != 3) {
                jsonReader.t();
                jsonReader.u();
            } else {
                list3 = p.f(jsonReader, f);
            }
        }
        jsonReader.g();
        if (jsonReader.q() == JsonReader.Token.END_ARRAY) {
            jsonReader.f();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new jb2(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new iq(eg1.a(list.get(i2), list3.get(i2)), eg1.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new iq(eg1.a(list.get(i3), list3.get(i3)), eg1.a(pointF3, list2.get(0)), pointF3));
            }
            return new jb2(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
