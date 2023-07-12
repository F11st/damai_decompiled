package com.alipay.sdk.m.c0;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class b {
    public File a;
    public com.alipay.sdk.m.g0.a b;

    public b(String str, com.alipay.sdk.m.g0.a aVar) {
        this.a = null;
        this.b = null;
        this.a = new File(str);
        this.b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        File file = this.a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.a.isDirectory() && this.a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.b.logCollect(a(com.alipay.sdk.m.z.b.a(this.a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new File(this.a, (String) arrayList.get(i)).delete();
            }
        }
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
