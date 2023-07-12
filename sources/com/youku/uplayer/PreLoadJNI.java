package com.youku.uplayer;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.e.C7901a;
import com.youku.player.util.C8063c;
import com.youku.player.util.C8070g;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PreLoadJNI {
    private static final int MSG_PRELOAD_FAIL = 1;
    private static final int MSG_PRELOAD_SUCCESS = 0;
    private static final String TAG = "PreLoadJNI";
    private static PreLoadJNI preLoadJNI;
    private Handler eventHandler = new Handler() { // from class: com.youku.uplayer.PreLoadJNI.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                if (PreLoadJNI.this.mOnPreLoadDoneListener != null) {
                    PreLoadJNI.this.mOnPreLoadDoneListener.onPreloadSuccess("");
                }
            } else if (i == 1) {
                if (PreLoadJNI.this.mOnPreLoadDoneListener != null) {
                    PreLoadJNI.this.mOnPreLoadDoneListener.onPreloadFail("");
                }
            } else {
                String str = PreLoadJNI.TAG;
                C8063c.b(str, "Unknown message type " + message.what);
            }
        }
    };
    private OnPreLoadDoneListener mOnPreLoadDoneListener;

    public static PreLoadJNI getInstance() {
        if (preLoadJNI == null) {
            preLoadJNI = new PreLoadJNI();
        }
        return preLoadJNI;
    }

    private static void initPlayerNative() {
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || C7901a.a.getExternalCacheDir() == null) {
                C8063c.a(TAG, "not mounted");
            } else {
                String absolutePath = C7901a.a.getExternalCacheDir().getAbsolutePath();
                String str = TAG;
                C8063c.a(str, "getExternalCacheDir().getAbsolutePath():" + absolutePath);
                C8063c.a(str, "size:" + ((long) (((((double) C8070g.a()) * 0.02d) / 1024.0d) / 1024.0d)));
            }
        } catch (Exception e) {
            C8063c.a(TAG, "initPlayer().Exception");
            e.printStackTrace();
        }
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        Handler handler;
        PreLoadJNI preLoadJNI2 = (PreLoadJNI) ((WeakReference) obj).get();
        if (preLoadJNI2 == null || (handler = preLoadJNI2.eventHandler) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(i, i2, i3, obj2);
        int i4 = obtainMessage.what;
        if (i4 == 0) {
            OnPreLoadDoneListener onPreLoadDoneListener = preLoadJNI2.mOnPreLoadDoneListener;
            if (onPreLoadDoneListener != null) {
                onPreLoadDoneListener.onPreloadSuccess("");
            }
        } else if (i4 == 1) {
            OnPreLoadDoneListener onPreLoadDoneListener2 = preLoadJNI2.mOnPreLoadDoneListener;
            if (onPreLoadDoneListener2 != null) {
                onPreLoadDoneListener2.onPreloadFail("");
            }
        } else {
            String str = TAG;
            C8063c.b(str, "Unknown message type " + obtainMessage.what);
        }
    }

    public static void release() {
        preLoadJNI = null;
    }

    public static void start(String str) {
        try {
            Thread.sleep(DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        postEventFromNative(new WeakReference(getInstance()), 0, 1, 0, null);
    }

    public void setOnPreLoadDoneListener(OnPreLoadDoneListener onPreLoadDoneListener) {
        this.mOnPreLoadDoneListener = onPreLoadDoneListener;
    }
}
