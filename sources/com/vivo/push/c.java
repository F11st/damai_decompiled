package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class c implements Handler.Callback {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.a.f;
            if (atomicInteger.get() == 2) {
                this.a.a(1);
            }
        } else if (i == 2) {
            atomicInteger2 = this.a.f;
            if (atomicInteger2.get() == 4) {
                this.a.f();
            }
            this.a.a(1);
        } else {
            com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + jn1.ARRAY_END_STR);
        }
        return true;
    }
}
