package com.alipay.sdk.m.c0;

import com.alipay.sdk.m.g0.InterfaceC4195a;
import com.alipay.sdk.m.z.C4369b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c0.b */
/* loaded from: classes12.dex */
public final class C4166b {
    public File a;
    public InterfaceC4195a b;

    public C4166b(String str, InterfaceC4195a interfaceC4195a) {
        this.a = null;
        this.b = null;
        this.a = new File(str);
        this.b = interfaceC4195a;
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
            if (!this.b.logCollect(a(C4369b.a(this.a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new File(this.a, (String) arrayList.get(i)).delete();
            }
        }
    }

    public final void a() {
        new Thread(new RunnableC4167c(this)).start();
    }
}
