package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import tb.k5;
import tb.m80;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.z */
/* loaded from: classes17.dex */
public class C2937z {
    private static final JsonReader.C2911a a = JsonReader.C2911a.a("nm", "sy", "pt", "p", UploadQueueMgr.MSGTYPE_REALTIME, m80.OR_PREFIX, "os", "ir", "is", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, C2821a c2821a) throws IOException {
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
                    k5Var = C2895d.f(jsonReader, c2821a, false);
                    break;
                case 3:
                    animatableValue = C2889a.b(jsonReader, c2821a);
                    break;
                case 4:
                    k5Var2 = C2895d.f(jsonReader, c2821a, false);
                    break;
                case 5:
                    k5Var4 = C2895d.e(jsonReader, c2821a);
                    break;
                case 6:
                    k5Var6 = C2895d.f(jsonReader, c2821a, false);
                    break;
                case 7:
                    k5Var3 = C2895d.e(jsonReader, c2821a);
                    break;
                case 8:
                    k5Var5 = C2895d.f(jsonReader, c2821a, false);
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
