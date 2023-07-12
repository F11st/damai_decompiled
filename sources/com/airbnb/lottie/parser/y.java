package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class y implements ValueParser<PointF> {
    public static final y INSTANCE = new y();

    private y() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token q = jsonReader.q();
        if (q == JsonReader.Token.BEGIN_ARRAY) {
            return p.e(jsonReader, f);
        }
        if (q == JsonReader.Token.BEGIN_OBJECT) {
            return p.e(jsonReader, f);
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
