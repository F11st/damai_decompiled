package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
import java.util.ArrayList;
import tb.lb2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class f0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "hd", AdvanceSetting.NETWORK_TYPE);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static lb2 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                z = jsonReader.k();
            } else if (s != 2) {
                jsonReader.u();
            } else {
                jsonReader.c();
                while (jsonReader.j()) {
                    ContentModel a2 = g.a(jsonReader, aVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.f();
            }
        }
        return new lb2(str, arrayList, z);
    }
}
