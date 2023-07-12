package com.alimm.xadsdk.base.expose;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alimm.xadsdk.base.core.AdThreadPoolExecutor;
import com.alimm.xadsdk.base.utils.FileUtils;
import com.alimm.xadsdk.base.utils.LogUtils;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OfflineExposeCache {
    private static final String FILE_NAME = "offline_exposure_v2.dat";
    private static final String TAG = "OfflineExposeCache";
    private Context mContext;
    private String mOfflineFilePath;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IReadListener {
        void onRead(@NonNull OfflineExposeInfo offlineExposeInfo);
    }

    public OfflineExposeCache(@NonNull Context context) {
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "OfflineExposeCache: context = " + context);
        }
        this.mContext = context;
    }

    private void ensureOfflineFilePath() {
        if (!TextUtils.isEmpty(this.mOfflineFilePath) || this.mContext == null) {
            return;
        }
        if (LogUtils.DEBUG) {
            LogUtils.d(TAG, "init OfflineFilePath");
        }
        File externalFilesDir = this.mContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            this.mOfflineFilePath = FileUtils.joinPath(externalFilesDir.getAbsolutePath(), FILE_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toRead(@NonNull IReadListener iReadListener) {
        try {
            ensureOfflineFilePath();
            for (String str : FileUtils.readLines(this.mOfflineFilePath)) {
                if (LogUtils.DEBUG) {
                    LogUtils.d(TAG, "toRead " + str);
                }
                OfflineExposeInfo offlineExposeInfo = (OfflineExposeInfo) JSON.parseObject(str, OfflineExposeInfo.class);
                if (offlineExposeInfo != null) {
                    iReadListener.onRead(offlineExposeInfo);
                }
            }
        } catch (Exception e) {
            LogUtils.d(TAG, "toRead exception.", e);
        }
        FileUtils.delete(this.mOfflineFilePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toSave(@NonNull OfflineExposeInfo offlineExposeInfo) {
        try {
            ensureOfflineFilePath();
            String jSONString = JSON.toJSONString(offlineExposeInfo);
            FileUtils.writeLine(this.mOfflineFilePath, true, jSONString);
            if (LogUtils.DEBUG) {
                LogUtils.d(TAG, "toSave " + jSONString);
            }
        } catch (Exception e) {
            LogUtils.d(TAG, "toSave exception.", e);
        }
    }

    public void read(final IReadListener iReadListener) {
        if (iReadListener != null) {
            AdThreadPoolExecutor.post(new Runnable() { // from class: com.alimm.xadsdk.base.expose.OfflineExposeCache.2
                @Override // java.lang.Runnable
                public void run() {
                    OfflineExposeCache.this.toRead(iReadListener);
                }
            });
        }
    }

    public void save(final OfflineExposeInfo offlineExposeInfo) {
        if (offlineExposeInfo != null) {
            AdThreadPoolExecutor.post(new Runnable() { // from class: com.alimm.xadsdk.base.expose.OfflineExposeCache.1
                @Override // java.lang.Runnable
                public void run() {
                    OfflineExposeCache.this.toSave(offlineExposeInfo);
                }
            });
        }
    }
}
