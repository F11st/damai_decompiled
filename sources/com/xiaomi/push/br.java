package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class br extends al.a {
    private Context a;

    public br(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m591a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e);
        }
    }
}
