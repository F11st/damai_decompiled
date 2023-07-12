package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.login4android.constants.LoginConstants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class HeartbeatManager {
    private static final int DEFAULT_HB_TIME = 270;
    private static final String TAG = "HeartbeatManager";
    private static final long UPGRADE_TIME = 7199000;
    protected static volatile HeartbeatManager sInstance;
    private static final int[] values = {270, 360, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH};
    protected Context mContext;
    private boolean mSmartHbEnabled;
    private int nowLevel;
    private long setLevelTime;
    private boolean justUpgrade = false;
    private int[] upgradeFailTimes = {0, 0, 0};

    /* JADX INFO: Access modifiers changed from: protected */
    public HeartbeatManager(Context context) {
        this.mSmartHbEnabled = true;
        try {
            this.mContext = context;
            this.nowLevel = 0;
            this.setLevelTime = System.currentTimeMillis();
            this.mSmartHbEnabled = OrangeAdapter.isSmartHb();
        } catch (Throwable th) {
            ALog.e(TAG, TAG, th, new Object[0]);
        }
    }

    public static HeartbeatManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (HeartbeatManager.class) {
                if (sInstance == null) {
                    if (Build.VERSION.SDK_INT >= 21 && isJobServiceExist(context)) {
                        ALog.i(TAG, "hb use job", new Object[0]);
                        sInstance = new JobHeartBeatMgt(context);
                    } else {
                        ALog.i(TAG, "hb use alarm", new Object[0]);
                        sInstance = new AlarmHeartBeatMgr(context);
                    }
                }
            }
        }
        return sInstance;
    }

    private static boolean isJobServiceExist(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0).isEnabled();
        } catch (Throwable th) {
            ALog.e(TAG, "isJobServiceExist", th, new Object[0]);
            return false;
        }
    }

    public int getInterval() {
        int i = this.mSmartHbEnabled ? values[this.nowLevel] : 270;
        this.mSmartHbEnabled = OrangeAdapter.isSmartHb();
        return i;
    }

    public void onHeartbeatSucc() {
        ALog.d(TAG, "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.setLevelTime > UPGRADE_TIME) {
            int i = this.nowLevel;
            if (i >= values.length - 1 || this.upgradeFailTimes[i] > 2) {
                return;
            }
            ALog.d(TAG, LoginConstants.LOGIN_UPGRADE, new Object[0]);
            this.nowLevel++;
            this.justUpgrade = true;
            this.setLevelTime = System.currentTimeMillis();
            return;
        }
        this.justUpgrade = false;
        this.upgradeFailTimes[this.nowLevel] = 0;
    }

    public void onNetworkFail() {
        this.setLevelTime = -1L;
        ALog.d(TAG, "onNetworkFail", new Object[0]);
    }

    public void onNetworkTimeout() {
        this.setLevelTime = -1L;
        if (this.justUpgrade) {
            int[] iArr = this.upgradeFailTimes;
            int i = this.nowLevel;
            iArr[i] = iArr[i] + 1;
        }
        int i2 = this.nowLevel;
        this.nowLevel = i2 > 0 ? i2 - 1 : 0;
        ALog.d(TAG, "onNetworkTimeout", new Object[0]);
    }

    public void resetLevel() {
        this.nowLevel = 0;
        this.setLevelTime = System.currentTimeMillis();
        ALog.d(TAG, "resetLevel", new Object[0]);
    }

    public synchronized void set() {
        try {
            if (this.setLevelTime < 0) {
                this.setLevelTime = System.currentTimeMillis();
            }
            int interval = getInterval();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "set " + interval, new Object[0]);
            }
            setInner(interval);
        } catch (Throwable th) {
            ALog.e(TAG, "set", th, new Object[0]);
        }
    }

    protected abstract void setInner(int i);
}
