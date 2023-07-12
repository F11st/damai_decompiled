package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.ao;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ap extends Handler {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, Looper looper) {
        super(looper);
        this.a = aoVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ao.AbstractC7600b abstractC7600b = (ao.AbstractC7600b) message.obj;
        int i = message.what;
        if (i == 0) {
            abstractC7600b.a();
        } else if (i == 1) {
            abstractC7600b.mo765c();
        }
        super.handleMessage(message);
    }
}
