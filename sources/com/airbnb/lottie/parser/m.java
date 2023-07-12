package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import java.util.Collections;
import tb.l5;
import tb.m5;
import tb.o5;
import tb.tu0;
import tb.u71;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class m {
    private static final JsonReader.a a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", UploadQueueMgr.MSGTYPE_REALTIME, "hd");
    private static final JsonReader.a b = JsonReader.a.a("p", "k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static tu0 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        m5 m5Var = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        l5 l5Var = null;
        o5 o5Var = null;
        o5 o5Var2 = null;
        boolean z = false;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.e();
                    while (jsonReader.j()) {
                        int s = jsonReader.s(b);
                        if (s == 0) {
                            i = jsonReader.m();
                        } else if (s != 1) {
                            jsonReader.t();
                            jsonReader.u();
                        } else {
                            l5Var = d.g(jsonReader, aVar, i);
                        }
                    }
                    jsonReader.g();
                    break;
                case 2:
                    m5Var = d.h(jsonReader, aVar);
                    break;
                case 3:
                    gradientType = jsonReader.m() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    o5Var = d.i(jsonReader, aVar);
                    break;
                case 5:
                    o5Var2 = d.i(jsonReader, aVar);
                    break;
                case 6:
                    fillType = jsonReader.m() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        return new tu0(str, gradientType, fillType, l5Var, m5Var == null ? new m5(Collections.singletonList(new u71(100))) : m5Var, o5Var, o5Var2, null, null, z);
    }
}
