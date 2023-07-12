package com.taobao.tao.log.utils;

import android.os.FileObserver;
import androidx.annotation.Nullable;
import com.taobao.tao.log.TLog;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogFileObserver extends FileObserver {
    private static final String TAG = "TLogFileObserver";
    private String logFileDir;

    public TLogFileObserver(String str) {
        super(str, 3904);
        this.logFileDir = str;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, @Nullable String str) {
        if (str != null) {
            try {
                if (str.contains(File.separator) || !str.endsWith(".tlog")) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 64) {
            TLog.loge(TAG, "", "The file had been moved: " + this.logFileDir + File.separator + str);
        } else if (i == 256) {
            TLog.loge(TAG, "", "The file had been created: " + this.logFileDir + File.separator + str);
        } else if (i == 512) {
            TLog.loge(TAG, "", "The file had been deleted: " + this.logFileDir + File.separator + str);
        } else if (i == 1024) {
            TLog.loge(TAG, "", "The log dir had been deleted: " + this.logFileDir);
        } else if (i != 2048) {
        } else {
            TLog.loge(TAG, "", "The log dir had been moved: " + this.logFileDir);
        }
    }
}
