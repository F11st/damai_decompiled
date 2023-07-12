package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.youku.uplayer.AliMediaPlayer;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.g */
/* loaded from: classes10.dex */
public final class C4553g implements Handler.Callback {
    private Map<Integer, C4644w> a = new Hashtable();
    private Handler b;
    private HandlerThread c;
    private C4491c d;
    private boolean e;

    public C4553g(Context context, C4491c c4491c, IGLSurfaceView iGLSurfaceView) {
        this.e = false;
        this.d = c4491c;
        HandlerThread handlerThread = new HandlerThread("AMapMessageHandler");
        this.c = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.c.getLooper(), this);
        this.e = false;
    }

    public void a(C4644w c4644w) {
        try {
            if (this.e || c4644w == null) {
                return;
            }
            int i = c4644w.a;
            if (i == 153) {
                Map<Integer, C4644w> map = this.a;
                if (map == null || map.size() <= 0) {
                    return;
                }
                this.b.obtainMessage(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX).sendToTarget();
                return;
            }
            synchronized (this.a) {
                if (i < 33) {
                    this.a.put(Integer.valueOf(i), c4644w);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.e || message == null) {
            return false;
        }
        C4644w c4644w = (C4644w) message.obj;
        int i = message.what;
        if (i == 1) {
            this.d.g(((Integer) c4644w.b).intValue());
        } else if (i == 153) {
            synchronized (this.a) {
                Set<Integer> keySet = this.a.keySet();
                if (keySet.size() > 0) {
                    for (Integer num : keySet) {
                        C4644w remove = this.a.remove(num);
                        this.b.obtainMessage(remove.a, remove).sendToTarget();
                    }
                }
            }
        }
        return false;
    }

    public void a() {
        this.e = true;
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
