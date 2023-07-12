package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.a62;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class c0 implements ValueParser<a62> {
    public static final c0 INSTANCE = new c0();

    private c0() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public a62 parse(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.q() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        float l = (float) jsonReader.l();
        float l2 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.u();
        }
        if (z) {
            jsonReader.f();
        }
        return new a62((l / 100.0f) * f, (l2 / 100.0f) * f);
    }
}
