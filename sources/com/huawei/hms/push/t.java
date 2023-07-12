package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class t extends Handler {
    public WeakReference<a> a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void handleMessage(Message message);
    }

    public t(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.a.get();
        if (aVar != null) {
            aVar.handleMessage(message);
        }
    }
}
