package android.taobao.windvane.jsbridge.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: android.taobao.windvane.jsbridge.utils.DeviceInfo.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    public static final int DEVICEINFO_UNKNOWN = -1;

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (bArr[i] >= 48 && bArr[i] <= 57) {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= 48 && bArr[i2] <= 57) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public static int getCPUMaxFreqKHz() {
        int i = -1;
        for (int i2 = 0; i2 < getNumberOfCPUCores(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (bArr[i3] >= 48 && bArr[i3] <= 57 && i3 < 128) {
                            i3++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (valueOf.intValue() > i) {
                            i = valueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (i == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
            if (parseFileForValue > i) {
                i = parseFileForValue;
            }
            fileInputStream2.close();
        }
        return i;
    }

    private static ArrayList<Long> getCpuTime() {
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", UploadQueueMgr.MSGTYPE_REALTIME);
            while (true) {
                String readLine = randomAccessFile.readLine();
                if (readLine == null || !readLine.startsWith("cpu")) {
                    break;
                }
                String[] split = readLine.split("\\s+");
                long parseLong = Long.parseLong(split[4]);
                arrayList.add(Long.valueOf(Long.parseLong(split[1]) + Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[5]) + Long.parseLong(split[7])));
                arrayList.add(Long.valueOf(parseLong));
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static long getFreeMemorySize(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static float getProcessCpuRate() {
        ArrayList<Long> cpuTime = getCpuTime();
        if (cpuTime != null && cpuTime.size() >= 2) {
            float longValue = (float) cpuTime.get(0).longValue();
            float longValue2 = (float) cpuTime.get(1).longValue();
            try {
                Thread.sleep(360L);
            } catch (Exception unused) {
            }
            ArrayList<Long> cpuTime2 = getCpuTime();
            if (cpuTime2 != null && cpuTime2.size() >= 2) {
                float longValue3 = (float) cpuTime2.get(0).longValue();
                return ((longValue3 - ((float) cpuTime2.get(1).longValue())) - (longValue - longValue2)) / (longValue3 - longValue);
            }
        }
        return 0.0f;
    }

    @TargetApi(16)
    public static long getTotalMemory(Context context) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        long j = -1;
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            j = parseFileForValue("MemTotal", fileInputStream) * 1024;
            fileInputStream.close();
        } catch (IOException unused) {
        }
        return j;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        }
                    }
                    continue;
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    public long getTotalMemory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.contains("MemTotal")) {
                        str = readLine.split(":")[1].trim();
                    }
                } else {
                    bufferedReader.close();
                    return Long.parseLong(str.split(" ")[0].trim());
                }
            }
        } catch (IOException unused) {
            return 0L;
        }
    }
}
