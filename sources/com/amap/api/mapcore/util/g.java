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
/* loaded from: classes10.dex */
public final class g implements Handler.Callback {
    private Map<Integer, w> a = new Hashtable();
    private Handler b;
    private HandlerThread c;
    private c d;
    private boolean e;

    public g(Context context, c cVar, IGLSurfaceView iGLSurfaceView) {
        this.e = false;
        this.d = cVar;
        HandlerThread handlerThread = new HandlerThread("AMapMessageHandler");
        this.c = handlerThread;
        handlerThread.start();
        this.b = new Handler(this.c.getLooper(), this);
        this.e = false;
    }

    public void a(w wVar) {
        try {
            if (this.e || wVar == null) {
                return;
            }
            int i = wVar.a;
            if (i == 153) {
                Map<Integer, w> map = this.a;
                if (map == null || map.size() <= 0) {
                    return;
                }
                this.b.obtainMessage(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX).sendToTarget();
                return;
            }
            synchronized (this.a) {
                if (i < 33) {
                    this.a.put(Integer.valueOf(i), wVar);
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
        w wVar = (w) message.obj;
        int i = message.what;
        if (i == 1) {
            this.d.g(((Integer) wVar.b).intValue());
        } else if (i == 153) {
            synchronized (this.a) {
                Set<Integer> keySet = this.a.keySet();
                if (keySet.size() > 0) {
                    for (Integer num : keySet) {
                        w remove = this.a.remove(num);
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
