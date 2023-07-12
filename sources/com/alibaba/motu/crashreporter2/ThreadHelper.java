package com.alibaba.motu.crashreporter2;

import android.os.Process;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ThreadHelper {
    private static Method READ_PROC_FILE;
    private static final int[] PROCESS_STATS_FORMAT_NAME = {4128};
    private static final int PID = Process.myPid();
    private static final File PROCESS_FILE = new File("/proc/" + Process.myPid() + "/task/");

    static {
        try {
            Method method = Process.class.getMethod("readProcFile", String.class, int[].class, String[].class, long[].class, float[].class);
            READ_PROC_FILE = method;
            method.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    private static String delNumberInString(String str) {
        char[] charArray;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') {
                sb.append(c);
                z = false;
            } else {
                if (!z) {
                    sb.append(Constants.Name.X);
                }
                z = true;
            }
        }
        return sb.toString();
    }

    public static String getThreads2String() {
        try {
            List<ThreadInfo> threadInfos = threadInfos();
            HashMap hashMap = new HashMap();
            for (ThreadInfo threadInfo : threadInfos) {
                String delNumberInString = delNumberInString(threadInfo.getThreadName());
                Integer num = (Integer) hashMap.get(delNumberInString);
                if (num == null) {
                    hashMap.put(delNumberInString, 1);
                } else {
                    hashMap.put(delNumberInString, Integer.valueOf(num.intValue() + 1));
                }
            }
            ArrayList arrayList = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.alibaba.motu.crashreporter2.ThreadHelper.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry.getValue());
                }
            });
            return arrayList.toString();
        } catch (Throwable unused) {
            return "exception";
        }
    }

    private static int getTid(String str) {
        if (str != null) {
            int lastIndexOf = str.lastIndexOf("\\.");
            if (lastIndexOf != -1) {
                str = str.substring(lastIndexOf + 1);
            }
            return Integer.valueOf(str).intValue();
        }
        return -1;
    }

    private static String loadThreadName(int i) {
        String[] strArr = new String[1];
        try {
            Method method = READ_PROC_FILE;
            method.invoke(null, "/proc/" + PID + "/task/" + i + "/comm", PROCESS_STATS_FORMAT_NAME, strArr, null, null);
        } catch (Exception unused) {
        }
        if (strArr[0].charAt(strArr[0].length() - 1) == '\n') {
            return strArr[0].substring(0, strArr[0].length() - 1);
        }
        return strArr[0];
    }

    private static List<ThreadInfo> threadInfos() {
        String[] list;
        ArrayList arrayList = new ArrayList();
        try {
            File file = PROCESS_FILE;
            if (file.isDirectory() && (list = file.list()) != null) {
                for (String str : list) {
                    int tid = getTid(str);
                    arrayList.add(new ThreadInfo(tid, tid != -1 ? loadThreadName(tid) : ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
