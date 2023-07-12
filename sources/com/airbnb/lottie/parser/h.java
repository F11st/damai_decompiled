package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class h implements ValueParser<DocumentData> {
    public static final h INSTANCE = new h();
    private static final JsonReader.a a = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", IRequestConst.SC, "sw", "of");

    private h() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.e();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f5 = 0.0f;
        boolean z = true;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    str2 = jsonReader.o();
                    break;
                case 2:
                    f2 = (float) jsonReader.l();
                    break;
                case 3:
                    int m = jsonReader.m();
                    justification2 = DocumentData.Justification.CENTER;
                    if (m <= justification2.ordinal() && m >= 0) {
                        justification2 = DocumentData.Justification.values()[m];
                        break;
                    }
                    break;
                case 4:
                    i = jsonReader.m();
                    break;
                case 5:
                    f3 = (float) jsonReader.l();
                    break;
                case 6:
                    f4 = (float) jsonReader.l();
                    break;
                case 7:
                    i2 = p.d(jsonReader);
                    break;
                case 8:
                    i3 = p.d(jsonReader);
                    break;
                case 9:
                    f5 = (float) jsonReader.l();
                    break;
                case 10:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        jsonReader.g();
        return new DocumentData(str, str2, f2, justification2, i, f3, f4, i2, i3, f5, z);
    }
}
