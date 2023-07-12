package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.manager.C7539a;
import com.xiaomi.push.al;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class br extends al.AbstractRunnableC7597a {
    private Context a;

    public br(Context context) {
        this.a = context;
    }

    private boolean a() {
        return C7539a.a(this.a).m591a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                C7539a.a(this.a).c();
                AbstractC7535b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            AbstractC7535b.d("fail to send perf data. " + e);
        }
    }
}
