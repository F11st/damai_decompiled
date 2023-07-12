package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import tb.k5;
import tb.o5;
import tb.oz1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class a0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "p", "s", UploadQueueMgr.MSGTYPE_REALTIME, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static oz1 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        o5 o5Var = null;
        k5 k5Var = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                animatableValue = a.b(jsonReader, aVar);
            } else if (s == 2) {
                o5Var = d.i(jsonReader, aVar);
            } else if (s == 3) {
                k5Var = d.e(jsonReader, aVar);
            } else if (s != 4) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new oz1(str, animatableValue, o5Var, k5Var, z);
    }
}
