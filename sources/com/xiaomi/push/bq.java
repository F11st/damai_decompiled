package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.manager.C7539a;
import com.xiaomi.push.al;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bq extends al.AbstractRunnableC7597a {
    private Context a;

    public bq(Context context) {
        this.a = context;
    }

    private boolean a() {
        return C7539a.a(this.a).m591a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a  reason: collision with other method in class */
    public String mo706a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                AbstractC7535b.c(this.a.getPackageName() + " begin upload event");
                C7539a.a(this.a).m593b();
            }
        } catch (Exception e) {
            AbstractC7535b.a(e);
        }
    }
}
