package com.taobao.android.dinamic.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DinamicLogThread extends HandlerThread {
    private static HandlerThread handlerThread;
    private static boolean isInited;
    public static a threadHandler;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Runnable)) {
                    ((Runnable) obj).run();
                }
            } catch (Throwable unused) {
            }
            super.handleMessage(message);
        }
    }

    private DinamicLogThread(String str) {
        super(str);
    }

    public static boolean checkInit() {
        return isInited;
    }

    public static synchronized void init(String str) {
        synchronized (DinamicLogThread.class) {
            if (!isInited) {
                DinamicLogThread dinamicLogThread = new DinamicLogThread(str);
                handlerThread = dinamicLogThread;
                Looper looper = null;
                try {
                    dinamicLogThread.start();
                } catch (Throwable unused) {
                }
                try {
                    looper = handlerThread.getLooper();
                } catch (Throwable unused2) {
                }
                threadHandler = new a(looper);
                isInited = true;
            }
        }
    }
}
