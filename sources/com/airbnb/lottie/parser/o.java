package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class o implements ValueParser<Integer> {
    public static final o INSTANCE = new o();

    private o() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f));
    }
}
