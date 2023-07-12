package com.alibaba.motu.crashreporter2;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import java.io.File;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class RunningStateMonitor implements Runnable {
    public static final int STARTUP_STATE_CRASH_TOO_MANY = 16;
    public static final int STARTUP_STATE_NORMAL = 0;
    public static final int STARTUP_STATE_STARTUP_TOO_FAST = 1;
    Context mContext;
    CrashReporter.DefaultStartupStateAnalyzeCallback mDefaultStartupStateAnalyzeCallback;
    RunningState mLastRunningState;
    File mMonitorFile;
    RunningState mRunningState;
    StorageManager mStorageManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class RunningState {
        String mAppId;
        String mAppKey;
        String mAppVersion;
        int mContinuousStartCount;
        int mContinuousStartCount1Hour;
        int mContinuousStartCount1Minute;
        int mContinuousStartCount24Hour;
        int mContinuousStartCount5Minute;
        long mElapsedRealtime;
        int mPid;
        String mProcessName;
        long mStartupTime;
        long mTimestamp;
        int mTotalStartCount;
        long mUptimeMillis;

        RunningState() {
        }

        void deserialize(String str) {
            String[] split = str.split(",");
            this.mAppId = split[0];
            this.mAppKey = split[1];
            this.mAppVersion = split[2];
            this.mStartupTime = Long.parseLong(split[3]);
            this.mUptimeMillis = Long.parseLong(split[4]);
            this.mElapsedRealtime = Long.parseLong(split[5]);
            this.mTimestamp = Long.parseLong(split[6]);
            this.mPid = Integer.parseInt(split[7]);
            this.mProcessName = split[8];
            this.mTotalStartCount = Integer.parseInt(split[9]);
            this.mContinuousStartCount = Integer.parseInt(split[10]);
            this.mContinuousStartCount24Hour = Integer.parseInt(split[11]);
            this.mContinuousStartCount1Hour = Integer.parseInt(split[12]);
            this.mContinuousStartCount1Minute = Integer.parseInt(split[13]);
            this.mContinuousStartCount5Minute = Integer.parseInt(split[14]);
        }

        String serialize() {
            return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.mAppId, this.mAppKey, this.mAppVersion, Long.valueOf(this.mStartupTime), Long.valueOf(this.mUptimeMillis), Long.valueOf(this.mElapsedRealtime), Long.valueOf(this.mTimestamp), Integer.valueOf(this.mPid), this.mProcessName, Integer.valueOf(this.mTotalStartCount), Integer.valueOf(this.mContinuousStartCount), Integer.valueOf(this.mContinuousStartCount24Hour), Integer.valueOf(this.mContinuousStartCount1Hour), Integer.valueOf(this.mContinuousStartCount1Minute), Integer.valueOf(this.mContinuousStartCount5Minute));
        }

        RunningState(Context context, String str, String str2, String str3, String str4, long j) {
            this.mAppId = str;
            this.mAppKey = str2;
            this.mAppVersion = str3;
            this.mStartupTime = j;
            this.mUptimeMillis = SystemClock.uptimeMillis();
            this.mElapsedRealtime = SystemClock.elapsedRealtime();
            this.mTimestamp = System.currentTimeMillis();
            this.mPid = Process.myPid();
            this.mProcessName = str4;
            this.mTotalStartCount = 1;
            this.mContinuousStartCount = 1;
            this.mContinuousStartCount24Hour = 1;
            this.mContinuousStartCount1Hour = 1;
            this.mContinuousStartCount1Minute = 1;
            this.mContinuousStartCount5Minute = 1;
        }
    }

    public RunningStateMonitor(Context context, String str, String str2, String str3, String str4, long j, StorageManager storageManager, CrashReporter.DefaultStartupStateAnalyzeCallback defaultStartupStateAnalyzeCallback) {
        this.mContext = context;
        this.mStorageManager = storageManager;
        this.mRunningState = new RunningState(context, str, str2, str3, str4, j);
        this.mDefaultStartupStateAnalyzeCallback = defaultStartupStateAnalyzeCallback;
    }

    private void analyzeStartupState() {
        RunningState runningState = this.mRunningState;
        int i = (runningState.mContinuousStartCount1Minute >= 3 || runningState.mContinuousStartCount5Minute >= 10) ? 16 : 0;
        RunningState runningState2 = this.mLastRunningState;
        if (runningState2 != null && runningState.mElapsedRealtime - runningState2.mElapsedRealtime < 30000) {
            i |= 1;
        }
        CrashReporter.DefaultStartupStateAnalyzeCallback defaultStartupStateAnalyzeCallback = this.mDefaultStartupStateAnalyzeCallback;
        if (defaultStartupStateAnalyzeCallback != null) {
            defaultStartupStateAnalyzeCallback.onComplete(i);
        }
    }

    private synchronized void flushRunningState() {
        AppUtils.writeFile(this.mMonitorFile, this.mRunningState.serialize());
    }

    public void refreshAppVersion(String str) {
        if (!StringUtils.isNotBlank(str) || str.equals(this.mRunningState.mAppVersion)) {
            return;
        }
        this.mRunningState.mAppVersion = str;
        flushRunningState();
    }

    @Override // java.lang.Runnable
    public void run() {
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile("STARTUP_MONITOR");
        this.mMonitorFile = processTombstoneFile;
        if (processTombstoneFile.exists()) {
            try {
                String readLineAndDel = AppUtils.readLineAndDel(this.mMonitorFile);
                if (StringUtils.isNotBlank(readLineAndDel)) {
                    RunningState runningState = new RunningState();
                    try {
                        runningState.deserialize(readLineAndDel);
                        this.mLastRunningState = runningState;
                    } catch (Exception e) {
                        LogUtil.e("lastRunningState deserialize", e);
                    }
                }
            } catch (Exception unused) {
            }
        }
        RunningState runningState2 = this.mLastRunningState;
        if (runningState2 != null) {
            RunningState runningState3 = this.mRunningState;
            long j = runningState3.mElapsedRealtime;
            long j2 = runningState2.mElapsedRealtime;
            boolean z = j < j2;
            runningState3.mTotalStartCount += runningState2.mTotalStartCount;
            if (!z) {
                runningState3.mContinuousStartCount += runningState2.mContinuousStartCount;
                if (j / DateUtils.MILLIS_PER_MINUTE == j2 / DateUtils.MILLIS_PER_MINUTE) {
                    runningState3.mContinuousStartCount1Minute += runningState2.mContinuousStartCount1Minute;
                    runningState3.mContinuousStartCount5Minute += runningState2.mContinuousStartCount5Minute;
                    runningState3.mContinuousStartCount1Hour += runningState2.mContinuousStartCount1Hour;
                    runningState3.mContinuousStartCount24Hour += runningState2.mContinuousStartCount24Hour;
                } else if (j / 300000 == j2 / 300000) {
                    runningState3.mContinuousStartCount5Minute += runningState2.mContinuousStartCount5Minute;
                    runningState3.mContinuousStartCount1Hour += runningState2.mContinuousStartCount1Hour;
                    runningState3.mContinuousStartCount24Hour += runningState2.mContinuousStartCount24Hour;
                } else if (j / DateUtils.MILLIS_PER_HOUR == j2 / DateUtils.MILLIS_PER_HOUR) {
                    runningState3.mContinuousStartCount1Hour += runningState2.mContinuousStartCount1Hour;
                    runningState3.mContinuousStartCount24Hour += runningState2.mContinuousStartCount24Hour;
                } else if (j / 86400000 == j2 / 86400000) {
                    runningState3.mContinuousStartCount24Hour += runningState2.mContinuousStartCount24Hour;
                }
            }
        }
        flushRunningState();
        analyzeStartupState();
    }
}
