package com.taobao.tao.log.godeye.memorydump.dump;

import android.os.Debug;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MemoryDump {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MemoryDumpCallBack {
        void dumpError();

        void dumpSuccess(String str);
    }

    public static synchronized void dumpHprof(String str, MemoryDumpCallBack memoryDumpCallBack) {
        synchronized (MemoryDump.class) {
            if (str == null) {
                return;
            }
            try {
                MemoryFileZip.deleteFile(str);
                Debug.dumpHprofData(str);
                if (memoryDumpCallBack != null) {
                    memoryDumpCallBack.dumpSuccess(str);
                }
            } catch (Throwable unused) {
                MemoryFileZip.deleteFile(str);
                if (memoryDumpCallBack != null) {
                    memoryDumpCallBack.dumpError();
                }
            }
        }
    }
}
