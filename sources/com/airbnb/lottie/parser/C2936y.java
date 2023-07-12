package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.y */
/* loaded from: classes9.dex */
public class C2936y implements ValueParser<PointF> {
    public static final C2936y INSTANCE = new C2936y();

    private C2936y() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token q = jsonReader.q();
        if (q == JsonReader.Token.BEGIN_ARRAY) {
            return C2925p.e(jsonReader, f);
        }
        if (q == JsonReader.Token.BEGIN_OBJECT) {
            return C2925p.e(jsonReader, f);
        }
        if (q == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.l()) * f, ((float) jsonReader.l()) * f);
            while (jsonReader.j()) {
                jsonReader.u();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + q);
    }
}
