package com.alibaba.poplayer.trigger;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tb.dt1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c implements Handler.Callback {
    public static final String KEY_EVENT = "event";
    public static final String KEY_RETRY_TIME = "retryTime";
    public static final int RETRY_LIMIT = 3;
    public static final int TYPE_NEW_EVENT = 2048;
    public static final int TYPE_SAME_EVENT = 1024;
    public b a;
    private final Handler b = new Handler(Looper.getMainLooper(), this);

    public c(b bVar) {
        this.a = bVar;
    }

    public void a(Event event, long j, int i) {
        dt1.b("EventDispatchManager.dispatchEvent:event:{%s},delay:{%s},type:{%s}.", event.toString(), Long.valueOf(j), Integer.valueOf(i));
        if (j < 0) {
            j = 0;
        }
        i = (i == 2048 && i == 1024) ? 2048 : 2048;
        try {
            Message message = new Message();
            message.what = i;
            Bundle bundle = new Bundle();
            bundle.putParcelable("event", event);
            bundle.putInt(KEY_RETRY_TIME, 0);
            message.setData(bundle);
            this.b.sendMessageDelayed(message, j);
        } catch (Throwable th) {
            dt1.c("DispatchManager.dispatchEvent.error.", th);
        }
    }

    public void b(int i) {
        if (i != 2048 && i != 1024) {
            this.b.removeCallbacksAndMessages(null);
        } else {
            this.b.removeMessages(i);
        }
        dt1.b("DispatchManager.removeNotStartedEventsByType:type-{%s}", Integer.valueOf(i));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            Event event = (Event) message.getData().get("event");
            dt1.b("DispatchManager.handleMessage,event {%s}.", event.toString());
            int i = message.getData().getInt(KEY_RETRY_TIME);
            if (!this.a.a.o()) {
                this.a.a(event);
                return true;
            }
            if (i < 3) {
                Bundle data = message.getData();
                data.putInt(KEY_RETRY_TIME, i + 1);
                Message message2 = new Message();
                message2.setData(data);
                this.b.sendMessageDelayed(message2, 300L);
                dt1.b("DispatchManager.handleMessage.isUpdatingConfig,event {%s} retry after 300ms.", event.toString());
            } else {
                dt1.b("DispatchManager.handleMessage.isUpdatingConfig,event {%s} retryTime{%s} >= LimitTime {%s} .And dropped event.", event.toString(), Integer.valueOf(i), 3);
            }
            return true;
        } catch (Throwable th) {
            dt1.c("DispatchManager.handleMessage.error.", th);
            return false;
        }
    }
}
