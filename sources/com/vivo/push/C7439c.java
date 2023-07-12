package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import com.vivo.push.util.C7523p;
import java.util.concurrent.atomic.AtomicInteger;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.c */
/* loaded from: classes11.dex */
public final class C7439c implements Handler.Callback {
    final /* synthetic */ ServiceConnectionC7412b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7439c(ServiceConnectionC7412b serviceConnectionC7412b) {
        this.a = serviceConnectionC7412b;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            C7523p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            C7523p.a("AidlManager", "In connect, bind core service time out");
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
            C7523p.b("AidlManager", "unknow msg what [" + message.what + jn1.ARRAY_END_STR);
        }
        return true;
    }
}
