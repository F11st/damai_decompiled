package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class by extends al.a {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo706a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        cn cnVar;
        cn cnVar2;
        Context context;
        com.xiaomi.channel.commonutils.logger.b.c("exec== mUploadJob");
        cnVar = this.a.f144a;
        if (cnVar != null) {
            cnVar2 = this.a.f144a;
            context = this.a.f141a;
            cnVar2.a(context);
            this.a.b("upload_time");
        }
    }
}
