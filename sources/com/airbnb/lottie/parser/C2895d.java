package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
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
/* renamed from: com.airbnb.lottie.parser.d */
/* loaded from: classes17.dex */
public class C2895d {
    private static <T> List<u71<T>> a(JsonReader jsonReader, float f, C2821a c2821a, ValueParser<T> valueParser) throws IOException {
        return C2928r.a(jsonReader, c2821a, f, valueParser, false);
    }

    private static <T> List<u71<T>> b(JsonReader jsonReader, C2821a c2821a, ValueParser<T> valueParser) throws IOException {
        return C2928r.a(jsonReader, c2821a, 1.0f, valueParser, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j5 c(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new j5(b(jsonReader, c2821a, C2899f.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s5 d(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new s5(b(jsonReader, c2821a, C2903h.INSTANCE));
    }

    public static k5 e(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return f(jsonReader, c2821a, true);
    }

    public static k5 f(JsonReader jsonReader, C2821a c2821a, boolean z) throws IOException {
        return new k5(a(jsonReader, z ? aw2.e() : 1.0f, c2821a, C2905i.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l5 g(JsonReader jsonReader, C2821a c2821a, int i) throws IOException {
        return new l5(b(jsonReader, c2821a, new C2909l(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m5 h(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new m5(b(jsonReader, c2821a, C2924o.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o5 i(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new o5(C2928r.a(jsonReader, c2821a, aw2.e(), C2936y.INSTANCE, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p5 j(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new p5(b(jsonReader, c2821a, C2894c0.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q5 k(JsonReader jsonReader, C2821a c2821a) throws IOException {
        return new q5(a(jsonReader, aw2.e(), c2821a, C2896d0.INSTANCE));
    }
}
