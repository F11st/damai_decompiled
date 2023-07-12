package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.animation.keyframe.C2852f;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.aw2;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.w */
/* loaded from: classes17.dex */
class C2934w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static C2852f a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new C2852f(c2821a, C2927q.c(jsonReader, c2821a, aw2.e(), C2935x.INSTANCE, jsonReader.q() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
