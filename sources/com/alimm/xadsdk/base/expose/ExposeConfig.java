package com.alimm.xadsdk.base.expose;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.net.INetAdapter;
import com.alimm.xadsdk.base.utils.LogUtils;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ExposeConfig {
    private static final int DEFAULT_MAX_RETRY_TIMES = 3;
    private static final long DEFAULT_PERIOD_MINUTES = 5;
    private static final List<String> DEFAULT_SUPPORT_RETRY_TYPES = Arrays.asList(MonitorType.IMPRESSION, "click");
    private static final String TAG = "ExposeConfig";
    private INetAdapter mNetAdapter;
    private int mEventId = 2201;
    private boolean mOfflineEnabled = true;
    private boolean mRetryEnabled = false;
    private int mMaxRetryTimes = 3;
    private long mPeriodMinutes = 5;
    private List<String> mSupportRetryTypes = DEFAULT_SUPPORT_RETRY_TYPES;

    public int getMaxRetryTimes() {
        return this.mMaxRetryTimes;
    }

    public INetAdapter getNetAdapter() {
        return this.mNetAdapter;
    }

    public long getPeriodMinutes() {
        return this.mPeriodMinutes;
    }

    public List<String> getSupportRetryTypes() {
        return this.mSupportRetryTypes;
    }

    public int getUtEventId() {
        return this.mEventId;
    }

    public boolean isOfflineEnabled() {
        return this.mOfflineEnabled;
    }

    public boolean isRetryEnabled() {
        return this.mRetryEnabled;
    }

    public ExposeConfig setMaxRetryTimes(int i) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setMaxRetryTimes: maxRetryTimes = " + i);
        }
        this.mMaxRetryTimes = i;
        return this;
    }

    public ExposeConfig setNetAdapter(@NonNull INetAdapter iNetAdapter) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setNetAdapter: netAdapter = " + iNetAdapter);
        }
        this.mNetAdapter = iNetAdapter;
        return this;
    }

    public ExposeConfig setOfflineEnabled(boolean z) {
        this.mOfflineEnabled = z;
        return this;
    }

    public ExposeConfig setPeriodMinutes(long j) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setPeriodMinutes: periodMinutes = " + j);
        }
        this.mPeriodMinutes = j;
        return this;
    }

    public ExposeConfig setRetryEnabled(boolean z) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setRetryEnabled: retryEnabled = " + z);
        }
        this.mRetryEnabled = z;
        return this;
    }

    public ExposeConfig setSupportRetryTypes(List<String> list) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setSupportRetryTypes: supportRetryTypes = " + list);
        }
        this.mSupportRetryTypes = list;
        return this;
    }

    public ExposeConfig setUtEventId(int i) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "setUtEventId: eventId = " + i);
        }
        this.mEventId = i;
        return this;
    }
}
