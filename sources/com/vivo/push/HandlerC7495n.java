package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C7523p;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.n */
/* loaded from: classes11.dex */
final class HandlerC7495n extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC7495n(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof AbstractRunnableC7491l) {
            AbstractRunnableC7491l abstractRunnableC7491l = (AbstractRunnableC7491l) obj;
            C7523p.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(abstractRunnableC7491l)));
            abstractRunnableC7491l.run();
        }
    }
}
