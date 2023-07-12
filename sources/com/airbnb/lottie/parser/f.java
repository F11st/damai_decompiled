package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class f implements ValueParser<Integer> {
    public static final f INSTANCE = new f();

    private f() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.q() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        double l = jsonReader.l();
        double l2 = jsonReader.l();
        double l3 = jsonReader.l();
        double l4 = jsonReader.q() == JsonReader.Token.NUMBER ? jsonReader.l() : 1.0d;
        if (z) {
            jsonReader.f();
        }
        if (l <= 1.0d && l2 <= 1.0d && l3 <= 1.0d) {
            l *= 255.0d;
            l2 *= 255.0d;
            l3 *= 255.0d;
            if (l4 <= 1.0d) {
                l4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) l4, (int) l, (int) l2, (int) l3));
    }
}
