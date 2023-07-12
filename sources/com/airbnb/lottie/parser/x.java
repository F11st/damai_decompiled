package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class x implements ValueParser<PointF> {
    public static final x INSTANCE = new x();

    private x() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        return p.e(jsonReader, f);
    }
}
