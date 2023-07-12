package com.tencent.open.b;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        Context a = com.tencent.open.utils.g.a();
        if (a == null) {
            return;
        }
        a.deleteDatabase("sdk_report.db");
    }

    public static void a(String str) {
    }

    public static void a(String str, List<Serializable> list) {
    }

    public static List<Serializable> b(String str) {
        return Collections.synchronizedList(new ArrayList());
    }
}
