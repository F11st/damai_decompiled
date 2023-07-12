package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.x */
/* loaded from: classes9.dex */
public class C2935x implements ValueParser<PointF> {
    public static final C2935x INSTANCE = new C2935x();

    private C2935x() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        return C2925p.e(jsonReader, f);
    }
}
