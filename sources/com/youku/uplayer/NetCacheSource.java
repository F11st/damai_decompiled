package com.youku.uplayer;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.youku.e.a;
import com.youku.player.util.c;
import com.youku.player.util.d;
import com.youku.player.util.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NetCacheSource {
    private static final int MSG_PRELOAD_FAIL = 3002;
    private static final int MSG_PRELOAD_SUCCESS = 3001;
    private static final int MSG_PRELOAD_TASK_NUM = 482;
    private static final String TAG = "NetCacheSource";
    private static String cachePath = null;
    private static String p2pPath = null;
    public static final long preload_size = 50;
    public static Map<String, Integer> sFeedVidMap = new HashMap();
    static WeakReference<NetCacheSource> wk;
    private Handler eventHandler;
    private int mNativeContext;
    private OnPreLoadDoneListener mOnPreLoadDoneListener;
    private int preLoadCachesize;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 3001) {
                if (NetCacheSource.this.mOnPreLoadDoneListener != null) {
                    NetCacheSource.this.mOnPreLoadDoneListener.onPreloadSuccess("");
                }
            } else if (i == 3002) {
                if (NetCacheSource.this.mOnPreLoadDoneListener != null) {
                    NetCacheSource.this.mOnPreLoadDoneListener.onPreloadFail("");
                }
            } else if (c.d) {
                Log.e(NetCacheSource.TAG, "Unknown message type " + message.what);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class NetCacheSourceInnerObject {
        private static NetCacheSource sNetCacheSource = new NetCacheSource();

        private NetCacheSourceInnerObject() {
        }
    }

    private NetCacheSource() {
        this.mNativeContext = 0;
        this.preLoadCachesize = 409600;
        Looper mainLooper = Looper.getMainLooper();
        initPlayerNative();
        if (mainLooper != null) {
            this.eventHandler = new EventHandler(mainLooper);
        }
        wk = new WeakReference<>(this);
        try {
            this.preLoadCachesize = Integer.parseInt(d.a().a("youku_player_config", "feedpreLoadCachesize", "400")) * 1024;
        } catch (Exception unused) {
            this.preLoadCachesize = 409600;
        }
    }

    public static native int addPreloadTask(String str, long j);

    public static native int addPreloadTask(String str, String str2);

    public static native void cleanCache();

    public static String getInitPath() {
        if (cachePath == null) {
            try {
                if (!"mounted".equals(Environment.getExternalStorageState()) || a.a.getExternalCacheDir() == null) {
                    Log.d(TAG, "not mounted");
                } else {
                    String absolutePath = a.a.getExternalCacheDir().getAbsolutePath();
                    Log.d(TAG, "getExternalCacheDir().getAbsolutePath():" + absolutePath);
                    cachePath = absolutePath + "/youku_video_cache";
                }
            } catch (Exception e) {
                Log.d(TAG, "getInitPath().Exception");
                e.printStackTrace();
            }
        }
        String str = cachePath;
        return str == null ? "" : str;
    }

    public static NetCacheSource getInstance() {
        return NetCacheSourceInnerObject.sNetCacheSource;
    }

    public static String getP2pCachePath() {
        if (p2pPath == null) {
            try {
                if (!"mounted".equals(Environment.getExternalStorageState()) || a.a.getExternalCacheDir() == null) {
                    Log.d(TAG, "not mounted");
                } else {
                    String absolutePath = a.a.getExternalCacheDir().getAbsolutePath();
                    Log.d(TAG, "getExternalCacheDir().getAbsolutePath():" + absolutePath);
                    p2pPath = absolutePath + "/youku_p2p_cache";
                }
            } catch (Exception e) {
                Log.d(TAG, "getP2pCachePath().Exception");
                e.printStackTrace();
            }
        }
        String str = p2pPath;
        return str == null ? "" : str;
    }

    public static String getPath() {
        return getInitPath() + "_preload";
    }

    private void initPlayerNative() {
        String str;
        long j = 0;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || a.a.getExternalCacheDir() == null) {
                str = "not mounted";
            } else {
                j = (long) (((g.a() * 0.04d) / 1024.0d) / 1024.0d);
                str = "size:" + j;
            }
            Log.d(TAG, str);
        } catch (Exception e) {
            Log.d(TAG, "initPlayer().Exception");
            e.printStackTrace();
        }
        try {
            native_preload_init(getInitPath(), j, getPath(), 50L);
        } catch (UnsatisfiedLinkError unused) {
            c.b(TAG, "re-loadLibrary");
            System.loadLibrary(AliMediaPlayer.ALIPLAYER);
            if (g.c()) {
                return;
            }
            System.loadLibrary(AliMediaPlayer.UPLAYER24);
            native_preload_init(getInitPath(), j, getPath(), 50L);
        }
    }

    private boolean isValidPreloadTaskNum(int i) {
        return i > 20 || i <= 0;
    }

    public static native void native_preload_init(String str, long j, String str2, long j2);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        NetCacheSource netCacheSource = (NetCacheSource) ((WeakReference) obj).get();
        Log.d(TAG, "postEventFromNative  mp--" + netCacheSource);
        if (netCacheSource == null || netCacheSource.mNativeContext == 0) {
            Log.d(TAG, "postEventFromNative  mp == null|| mp.mNativeContext == 0");
            return;
        }
        Handler handler = netCacheSource.eventHandler;
        if (handler == null) {
            Log.d(TAG, "postEventFromNative  mp.eventHandler == null");
            return;
        }
        netCacheSource.eventHandler.sendMessage(handler.obtainMessage(i, i2, i3, obj2));
    }

    private static void preLoadCallbackFromNative(int i, int i2, int i3, Object obj) {
        if (c.d) {
            c.a(TAG, "preLoadCallbackFromNative() called with: what = [" + i + "], arg1 = [" + i2 + "], arg2 = [" + i3 + "], obj = [" + obj + jn1.ARRAY_END_STR);
        }
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.arg1 = i;
        obtain.arg2 = i3;
        obtain.obj = obj;
        StaticEventHandler.getInstance().sendMessage(1, obtain);
    }

    @Deprecated
    public void addOnPreLoadExtraListener(OnPreLoadExtraListener onPreLoadExtraListener) {
        StaticEventHandler.getInstance().addOnPreLoadExtraListener(onPreLoadExtraListener);
    }

    public void addPreloadForFeed(String str, String str2, String str3) {
        sFeedVidMap.put(str, 1);
        if (TextUtils.isEmpty(str3)) {
            str3 = "preload_size=" + String.valueOf(this.preLoadCachesize);
        }
        addPreloadTask(str2, str3);
    }

    public void cacheUrlForFeeds(String str) {
        addPreloadTask(str, this.preLoadCachesize);
    }

    public native void native_preload_setup(Object obj);

    public native int preloadNetCacheSource(String str, int i);

    public native void preloadNetCacheSourceRelease();

    public void release() {
        Log.d(TAG, "netcache  release--");
        try {
            preloadNetCacheSourceRelease();
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void removeOnPreLoadExtraListener(OnPreLoadExtraListener onPreLoadExtraListener) {
        StaticEventHandler.getInstance().removeOnPreLoadExtraListener(onPreLoadExtraListener);
    }

    public void setOnPreLoadDoneListener(OnPreLoadDoneListener onPreLoadDoneListener) {
        this.mOnPreLoadDoneListener = onPreLoadDoneListener;
    }

    public void setPreloadTaskNum(int i) {
        if (isValidPreloadTaskNum(i)) {
            return;
        }
        setProperty(MSG_PRELOAD_TASK_NUM, i + "");
    }

    public native void setProperty(int i, String str);

    public void start(String str) {
        OnPreLoadDoneListener onPreLoadDoneListener;
        preloadNetCacheSourceRelease();
        native_preload_setup(wk);
        Log.d(TAG, "native_preload_setup this " + wk);
        if (preloadNetCacheSource(str, 0) >= 0 || (onPreLoadDoneListener = this.mOnPreLoadDoneListener) == null) {
            return;
        }
        onPreLoadDoneListener.onPreloadFail("");
    }
}
