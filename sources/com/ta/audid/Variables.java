package com.ta.audid;

import android.content.Context;
import com.ta.audid.utils.UtdidLogger;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Variables {
    private static final Variables mInstance = new Variables();
    private Context mContext = null;
    private volatile boolean bInit = false;
    private long mDeltaTime = 0;

    private Variables() {
    }

    public static Variables getInstance() {
        return mInstance;
    }

    public Context getContext() {
        return this.mContext;
    }

    public long getCurrentTimeMillis() {
        return System.currentTimeMillis() + this.mDeltaTime;
    }

    public String getCurrentTimeMillisString() {
        return "" + getCurrentTimeMillis();
    }

    public synchronized void init() {
        if (!this.bInit) {
            this.bInit = true;
        }
    }

    public synchronized void initContext(Context context) {
        if (this.mContext == null) {
            if (context == null) {
                return;
            }
            if (context.getApplicationContext() != null) {
                this.mContext = context.getApplicationContext();
            } else {
                this.mContext = context;
            }
        }
    }

    public void setDebug(boolean z) {
        UtdidLogger.setDebug(z);
    }

    public void setSystemTime(long j) {
        this.mDeltaTime = j - System.currentTimeMillis();
    }
}
