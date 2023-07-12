package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import tb.k5;
import tb.m80;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class z {
    private static final JsonReader.a a = JsonReader.a.a("nm", "sy", "pt", "p", UploadQueueMgr.MSGTYPE_REALTIME, m80.OR_PREFIX, "os", "ir", "is", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        k5 k5Var = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        k5 k5Var2 = null;
        k5 k5Var3 = null;
        k5 k5Var4 = null;
        k5 k5Var5 = null;
        k5 k5Var6 = null;
        boolean z = false;
        while (jsonReader.j()) {
            switch (jsonReader.s(a)) {
                case 0:
                    str = jsonReader.o();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.m());
                    break;
                case 2:
                    k5Var = d.f(jsonReader, aVar, false);
                    break;
                case 3:
                    animatableValue = a.b(jsonReader, aVar);
                    break;
                case 4:
                    k5Var2 = d.f(jsonReader, aVar, false);
                    break;
                case 5:
                    k5Var4 = d.e(jsonReader, aVar);
                    break;
                case 6:
                    k5Var6 = d.f(jsonReader, aVar, false);
                    break;
                case 7:
                    k5Var3 = d.e(jsonReader, aVar);
                    break;
                case 8:
                    k5Var5 = d.f(jsonReader, aVar, false);
                    break;
                case 9:
                    z = jsonReader.k();
                    break;
                default:
                    jsonReader.t();
                    jsonReader.u();
                    break;
            }
        }
        return new PolystarShape(str, type, k5Var, animatableValue, k5Var2, k5Var3, k5Var4, k5Var5, k5Var6, z);
    }
}
