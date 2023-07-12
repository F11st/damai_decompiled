package com.taobao.android.launcher.common;

import com.alibaba.analytics.core.sync.UploadQueueMgr;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Switches {
    private static final String SWITCH_FILE_DIR = "/data/local/tmp/";

    public static long getLong(String str, long j) {
        File file = new File(SWITCH_FILE_DIR, str);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
                long parseLong = Long.parseLong(randomAccessFile.readLine());
                randomAccessFile.close();
                return parseLong;
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
                return j;
            }
        }
        return j;
    }

    public static boolean isSwitchOn(String str) {
        return new File(SWITCH_FILE_DIR, str).exists();
    }
}
