package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.i */
/* loaded from: classes9.dex */
public class C2905i implements ValueParser<Float> {
    public static final C2905i INSTANCE = new C2905i();

    private C2905i() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Float parse(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(C2925p.g(jsonReader) * f);
    }
}
