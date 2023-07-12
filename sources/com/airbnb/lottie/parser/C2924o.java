package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.o */
/* loaded from: classes9.dex */
public class C2924o implements ValueParser<Integer> {
    public static final C2924o INSTANCE = new C2924o();

    private C2924o() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(C2925p.g(jsonReader) * f));
    }
}
