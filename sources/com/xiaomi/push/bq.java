package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bq extends al.a {
    private Context a;

    public bq(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m591a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo706a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).m593b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
