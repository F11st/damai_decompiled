package com.airbnb.lottie.parser;

import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import tb.k5;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.i0 */
/* loaded from: classes17.dex */
class C2906i0 {
    private static JsonReader.C2911a a = JsonReader.C2911a.a("s", "e", "o", "nm", WXComponent.PROP_FS_MATCH_PARENT, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        k5 k5Var = null;
        k5 k5Var2 = null;
        k5 k5Var3 = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                k5Var = C2895d.f(jsonReader, c2821a, false);
            } else if (s == 1) {
                k5Var2 = C2895d.f(jsonReader, c2821a, false);
            } else if (s == 2) {
                k5Var3 = C2895d.f(jsonReader, c2821a, false);
            } else if (s == 3) {
                str = jsonReader.o();
            } else if (s == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.m());
            } else if (s != 5) {
                jsonReader.u();
            } else {
                z = jsonReader.k();
            }
        }
        return new ShapeTrimPath(str, type, k5Var, k5Var2, k5Var3, z);
    }
}
