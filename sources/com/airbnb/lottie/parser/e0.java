package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.IOException;
import java.util.Collections;
import tb.j5;
import tb.kb2;
import tb.m5;
import tb.u71;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class e0 {
    private static final JsonReader.a a = JsonReader.a.a("nm", com.huawei.hms.opendevice.c.a, "o", "fillEnabled", UploadQueueMgr.MSGTYPE_REALTIME, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static kb2 a(JsonReader jsonReader, com.airbnb.lottie.a aVar) throws IOException {
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
                j5Var = d.c(jsonReader, aVar);
            } else if (s == 2) {
                m5Var = d.h(jsonReader, aVar);
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
