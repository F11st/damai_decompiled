package com.alibaba.motu.crashreporter2;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MemReader {
    private static final int PID = Process.myPid();
    private static final String[] CORES = {"FDSize", "VmPeak", "VmSize", "VmHWM", "VmRSS", "VmData", "VmStk", "VmExe", "VmLib", "VmSwap", "Threads"};

    private static boolean inCores(String str) {
        for (String str2 : CORES) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String readMemContent() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + PID + "/status")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (inCores(readLine)) {
                        String replace = readLine.replace("\t", "").replace(" ", "");
                        sb.append(" ,");
                        sb.append(replace);
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }
}
