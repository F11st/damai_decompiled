package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.test;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.format.Formatter;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DeviceUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Context getAppContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2023266163") ? (Context) ipChange.ipc$dispatch("2023266163", new Object[0]) : AppContextUtils.getApp();
    }

    public static String getAvailMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918851409")) {
            return (String) ipChange.ipc$dispatch("-918851409", new Object[0]);
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(getAppContext(), memoryInfo.availMem);
    }

    public static String getAvailableExternalMemorySize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1789040555")) {
            return (String) ipChange.ipc$dispatch("-1789040555", new Object[0]);
        }
        if (isExternalStorageAvailable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return Formatter.formatFileSize(getAppContext(), statFs.getAvailableBlocks() * statFs.getBlockSize());
        }
        return "-1";
    }

    public static String getAvailableInternalMemorySize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444517831")) {
            return (String) ipChange.ipc$dispatch("1444517831", new Object[0]);
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Formatter.formatFileSize(getAppContext(), statFs.getAvailableBlocks() * statFs.getBlockSize());
    }

    public static float getCpuUsed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290152148")) {
            return ((Float) ipChange.ipc$dispatch("-1290152148", new Object[0])).floatValue();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", UploadQueueMgr.MSGTYPE_REALTIME);
            String[] split = randomAccessFile.readLine().split(" ");
            long parseLong = Long.parseLong(split[5]);
            long parseLong2 = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            try {
                Thread.sleep(360L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            randomAccessFile.seek(0L);
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            String[] split2 = readLine.split(" ");
            long parseLong3 = Long.parseLong(split2[5]);
            long parseLong4 = Long.parseLong(split2[2]) + Long.parseLong(split2[3]) + Long.parseLong(split2[4]) + Long.parseLong(split2[6]) + Long.parseLong(split2[7]) + Long.parseLong(split2[8]);
            return ((float) (parseLong4 - parseLong2)) / ((float) ((parseLong4 + parseLong3) - (parseLong2 + parseLong)));
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public static float getProcessMemeryInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1529833149")) {
            return ((Float) ipChange.ipc$dispatch("1529833149", new Object[0])).floatValue();
        }
        ActivityManager activityManager = (ActivityManager) getAppContext().getApplicationContext().getSystemService("activity");
        if (activityManager != null) {
            return activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPrivateDirty() / 1024.0f;
        }
        return 0.0f;
    }

    public static String getTotalExternalMemorySize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400076432")) {
            return (String) ipChange.ipc$dispatch("400076432", new Object[0]);
        }
        if (isExternalStorageAvailable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return Formatter.formatFileSize(getAppContext(), statFs.getBlockCount() * statFs.getBlockSize());
        }
        return "-1";
    }

    public static String getTotalInternalMemorySize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661332478")) {
            return (String) ipChange.ipc$dispatch("-661332478", new Object[0]);
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Formatter.formatFileSize(getAppContext(), statFs.getBlockCount() * statFs.getBlockSize());
    }

    public static String getTotalMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600877372")) {
            return (String) ipChange.ipc$dispatch("-600877372", new Object[0]);
        }
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            for (String str : split) {
                ((ILog) Dsl.getService(ILog.class)).e(readLine, str + "\t");
            }
            j = Integer.valueOf(split[1]).intValue() * 1024;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Formatter.formatFileSize(getAppContext(), j);
    }

    public static boolean isExternalStorageAvailable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1809098828") ? ((Boolean) ipChange.ipc$dispatch("1809098828", new Object[0])).booleanValue() : Environment.getExternalStorageState().equals("mounted");
    }
}
