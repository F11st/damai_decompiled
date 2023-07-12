package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.huawei.hms.opendevice.AbstractC5658c;
import java.io.IOException;
import java.util.Collections;
import tb.j5;
import tb.kb2;
import tb.m5;
import tb.u71;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.parser.e0 */
/* loaded from: classes17.dex */
public class C2898e0 {
    private static final JsonReader.C2911a a = JsonReader.C2911a.a("nm", AbstractC5658c.a, "o", "fillEnabled", UploadQueueMgr.MSGTYPE_REALTIME, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kb2 a(JsonReader jsonReader, C2821a c2821a) throws IOException {
        m5 m5Var = null;
        String str = null;
        j5 j5Var = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.j()) {
            int s = jsonReader.s(a);
            if (s == 0) {
                str = jsonReader.o();
            } else if (s == 1) {
                j5Var = C2895d.c(jsonReader, c2821a);
            } else if (s == 2) {
                m5Var = C2895d.h(jsonReader, c2821a);
            } else if (s == 3) {
                z = jsonReader.k();
            } else if (s == 4) {
                i = jsonReader.m();
            } else if (s != 5) {
                jsonReader.t();
                jsonReader.u();
            } else {
                z2 = jsonReader.k();
            }
        }
        return new kb2(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, j5Var, m5Var == null ? new m5(Collections.singletonList(new u71(100))) : m5Var, z2);
    }
}
