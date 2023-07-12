package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import tb.k5;
import tb.n5;
import tb.p5;
import tb.r5;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.c */
/* loaded from: classes17.dex */
public class C2893c {
    private static final JsonReader.C2911a a = JsonReader.C2911a.a("a", "p", "s", "rz", UploadQueueMgr.MSGTYPE_REALTIME, "o", "so", "eo", "sk", "sa");
    private static final JsonReader.C2911a b = JsonReader.C2911a.a("k");

    private static boolean a(n5 n5Var) {
        return n5Var == null || (n5Var.isStatic() && n5Var.getKeyframes().get(0).b.equals(0.0f, 0.0f));
    }

    private static boolean b(AnimatableValue<PointF, PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof r5) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).b.equals(0.0f, 0.0f));
    }

    private static boolean c(k5 k5Var) {
        return k5Var == null || (k5Var.isStatic() && k5Var.getKeyframes().get(0).b.floatValue() == 0.0f);
    }

    private static boolean d(p5 p5Var) {
        return p5Var == null || (p5Var.isStatic() && p5Var.getKeyframes().get(0).b.a(1.0f, 1.0f));
    }

    private static boolean e(k5 k5Var) {
        return k5Var == null || (k5Var.isStatic() && k5Var.getKeyframes().get(0).b.floatValue() == 0.0f);
    }

    private static boolean f(k5 k5Var) {
        return k5Var == null || (k5Var.isStatic() && k5Var.getKeyframes().get(0).b.floatValue() == 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static tb.u5 g(com.airbnb.lottie.parser.moshi.JsonReader r27, com.airbnb.lottie.C2821a r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.C2893c.g(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.a):tb.u5");
    }
}
