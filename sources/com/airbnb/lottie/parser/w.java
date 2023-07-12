package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import tb.aw2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.animation.keyframe.f a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new com.airbnb.lottie.animation.keyframe.f(aVar, q.c(jsonReader, aVar, aw2.e(), x.INSTANCE, jsonReader.q() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
