package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.taobao.weex.ui.component.WXComponent;
import java.io.IOException;
import java.util.ArrayList;
import tb.cp0;
import tb.lb2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class j {
    private static final JsonReader.a a = JsonReader.a.a("ch", "size", WXComponent.PROP_FS_WRAP_CONTENT, "style", "fFamily", "data");
    private static final JsonReader.a b = JsonReader.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cp0 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.e();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        char c = 0;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                c = jsonReader.o().charAt(0);
            } else if (s == 1) {
                d = jsonReader.l();
            } else if (s == 2) {
                d2 = jsonReader.l();
            } else if (s == 3) {
                str = jsonReader.o();
            } else if (s == 4) {
                str2 = jsonReader.o();
            } else if (s != 5) {
                jsonReader.t();
                jsonReader.u();
            } else {
                jsonReader.e();
                while (jsonReader.j()) {
                    if (jsonReader.s(b) != 0) {
                        jsonReader.t();
                        jsonReader.u();
                    } else {
                        jsonReader.c();
                        while (jsonReader.j()) {
                            arrayList.add((lb2) g.a(jsonReader, aVar));
                        }
                        jsonReader.f();
                    }
                }
                jsonReader.g();
            }
        }
        jsonReader.g();
        return new cp0(arrayList, c, d, d2, str, str2);
    }
}
