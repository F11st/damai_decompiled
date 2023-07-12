package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;
import tb.aw2;
import tb.j5;
import tb.k5;
import tb.l5;
import tb.m5;
import tb.o5;
import tb.p5;
import tb.q5;
import tb.s5;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class d {
    private static <T> List<u71<T>> a(JsonReader jsonReader, float f, com.airbnb.lottie.a aVar, ValueParser<T> valueParser) throws IOException {
        return r.a(jsonReader, aVar, f, valueParser, false);
    }

    private static <T> List<u71<T>> b(JsonReader jsonReader, com.airbnb.lottie.a aVar, ValueParser<T> valueParser) throws IOException {
        return r.a(jsonReader, aVar, 1.0f, valueParser, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j5 c(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new j5(b(jsonReader, aVar, f.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s5 d(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new s5(b(jsonReader, aVar, h.INSTANCE));
    }

    public static k5 e(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return f(jsonReader, aVar, true);
    }

    public static k5 f(JsonReader jsonReader, com.airbnb.lottie.a aVar, boolean z) throws IOException {
        return new k5(a(jsonReader, z ? aw2.e() : 1.0f, aVar, i.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l5 g(JsonReader jsonReader, com.airbnb.lottie.a aVar, int i) throws IOException {
        return new l5(b(jsonReader, aVar, new l(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m5 h(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new m5(b(jsonReader, aVar, o.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o5 i(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new o5(r.a(jsonReader, aVar, aw2.e(), y.INSTANCE, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p5 j(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new p5(b(jsonReader, aVar, c0.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q5 k(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        return new q5(a(jsonReader, aw2.e(), aVar, d0.INSTANCE));
    }
}
