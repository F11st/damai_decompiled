package com.youku.uplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.youku.player.util.C8063c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StaticEventHandler {
    public static final int MSG_KIND_PRELOAD = 1;
    public static final int MSG_KIND_TURBO = 2;
    private ConcurrentHashMap<Integer, WeakReference<OnPreLoadExtraListener>> mOnPreLoadExtraListeners;
    private ConcurrentHashMap<Integer, WeakReference<OnTurboStatusListener>> mOnTurboStatusListeners;
    private Handler sEventHandler;
    private HandlerThread sEventThread;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class StaticEventHolder {
        private static StaticEventHandler S_STATIC_EVENT_HOLDER = new StaticEventHandler();

        private StaticEventHolder() {
        }
    }

    private StaticEventHandler() {
        initEnv();
    }

    public static StaticEventHandler getInstance() {
        return StaticEventHolder.S_STATIC_EVENT_HOLDER;
    }

    public void addOnPreLoadExtraListener(OnPreLoadExtraListener onPreLoadExtraListener) {
        if (onPreLoadExtraListener == null) {
            return;
        }
        if (this.mOnPreLoadExtraListeners == null) {
            synchronized (this) {
                if (this.mOnPreLoadExtraListeners == null) {
                    this.mOnPreLoadExtraListeners = new ConcurrentHashMap<>(4);
                }
            }
        }
        this.mOnPreLoadExtraListeners.put(Integer.valueOf(System.identityHashCode(onPreLoadExtraListener)), new WeakReference<>(onPreLoadExtraListener));
    }

    public void addOnTurboStatusListener(OnTurboStatusListener onTurboStatusListener) {
        if (onTurboStatusListener == null) {
            return;
        }
        if (this.mOnTurboStatusListeners == null) {
            synchronized (this) {
                if (this.mOnTurboStatusListeners == null) {
                    this.mOnTurboStatusListeners = new ConcurrentHashMap<>(4);
                }
            }
        }
        this.mOnTurboStatusListeners.put(Integer.valueOf(System.identityHashCode(onTurboStatusListener)), new WeakReference<>(onTurboStatusListener));
    }

    protected void initEnv() {
        if (this.sEventThread == null) {
            HandlerThread handlerThread = new HandlerThread("StaticEventHandler");
            this.sEventThread = handlerThread;
            handlerThread.start();
            this.sEventHandler = new Handler(this.sEventThread.getLooper()) { // from class: com.youku.uplayer.StaticEventHandler.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message == null) {
                        return;
                    }
                    int i = message.what;
                    int i2 = i % 10;
                    if (i2 == 1) {
                        StaticEventHandler.this.notifyPreloadStatusChanged(i / 10, message.obj);
                    } else if (i2 == 2) {
                        StaticEventHandler.this.notifyTurboStatusChanged(i / 10, message.arg1, message.obj);
                    } else if (C8063c.d) {
                        C8063c.a("StaticEventHandler", "No handler deal with status[" + message.what + jn1.ARRAY_END_STR + " ErrorCode[" + message.what + "] params[" + message.obj + jn1.ARRAY_END_STR);
                    }
                }
            };
        }
    }

    protected void notifyPreloadStatusChanged(int i, Object obj) {
        if (obj != null) {
            try {
                if (this.mOnPreLoadExtraListeners == null) {
                    return;
                }
                if (C8063c.d) {
                    C8063c.a("StaticEventHandler", "notifyPreloadStatusChanged with status[" + i + jn1.ARRAY_END_STR + " params[" + obj + jn1.ARRAY_END_STR);
                }
                String str = (String) obj;
                for (Map.Entry<Integer, WeakReference<OnPreLoadExtraListener>> entry : this.mOnPreLoadExtraListeners.entrySet()) {
                    OnPreLoadExtraListener onPreLoadExtraListener = entry.getValue() != null ? entry.getValue().get() : null;
                    if (onPreLoadExtraListener != null && (onPreLoadExtraListener.isListenAllPreloadStatus() || str.equals(onPreLoadExtraListener.getPreloadUrl()))) {
                        onPreLoadExtraListener.onPreloadStatucChanged(i, str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void notifyTurboStatusChanged(int i, int i2, Object obj) {
        if (obj != null) {
            try {
                if (this.mOnTurboStatusListeners == null) {
                    return;
                }
                if (C8063c.d) {
                    C8063c.a("StaticEventHandler", "notifyTurboStatusChanged with status[" + i + jn1.ARRAY_END_STR + " ErrorCode[" + i2 + "] params[" + obj + jn1.ARRAY_END_STR);
                }
                String str = (String) obj;
                for (Map.Entry<Integer, WeakReference<OnTurboStatusListener>> entry : this.mOnTurboStatusListeners.entrySet()) {
                    OnTurboStatusListener onTurboStatusListener = entry.getValue() != null ? entry.getValue().get() : null;
                    if (onTurboStatusListener != null && onTurboStatusListener.needObserverUrl(str)) {
                        onTurboStatusListener.onStatusChanged(i, i2, str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeOnPreLoadExtraListener(OnPreLoadExtraListener onPreLoadExtraListener) {
        ConcurrentHashMap<Integer, WeakReference<OnPreLoadExtraListener>> concurrentHashMap = this.mOnPreLoadExtraListeners;
        if (concurrentHashMap == null || onPreLoadExtraListener == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(System.identityHashCode(onPreLoadExtraListener)));
    }

    public void removeOnTurboStatusListener(OnTurboStatusListener onTurboStatusListener) {
        ConcurrentHashMap<Integer, WeakReference<OnTurboStatusListener>> concurrentHashMap = this.mOnTurboStatusListeners;
        if (concurrentHashMap == null || onTurboStatusListener == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(System.identityHashCode(onTurboStatusListener)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessage(int i, Message message) {
        Handler handler = this.sEventHandler;
        if (handler != null) {
            message.what = (message.what * 10) + i;
            handler.sendMessage(message);
        }
    }
}
