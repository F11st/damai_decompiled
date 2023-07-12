package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseService extends Service {
    private HandlerC7553a a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.mipush.sdk.BaseService$a */
    /* loaded from: classes11.dex */
    public static class HandlerC7553a extends Handler {
        private WeakReference<BaseService> a;

        public HandlerC7553a(WeakReference<BaseService> weakReference) {
            this.a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            AbstractC7535b.c("TimeoutHandler " + baseService.toString() + " kill self");
            if (!baseService.mo606a()) {
                baseService.stopSelf();
                return;
            }
            AbstractC7535b.c("TimeoutHandler has job");
            sendEmptyMessageDelayed(1001, 1000L);
        }
    }

    /* renamed from: a */
    protected abstract boolean mo606a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (this.a == null) {
            this.a = new HandlerC7553a(new WeakReference(this));
        }
        this.a.a();
    }
}
