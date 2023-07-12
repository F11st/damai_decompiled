package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.b.c */
/* loaded from: classes11.dex */
public class C7082c implements Serializable {
    public final HashMap<String, String> a;

    public C7082c(Bundle bundle) {
        this.a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.a.get("time") + ", name=" + this.a.get("interface_name") + '}';
    }

    public C7082c(HashMap<String, String> hashMap) {
        this.a = new HashMap<>(hashMap);
    }
}
