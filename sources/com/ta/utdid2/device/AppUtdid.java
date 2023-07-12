package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import com.ta.audid.Constants;
import com.ta.audid.Variables;
import com.ta.audid.device.AppUtdidDecoder;
import com.ta.audid.device.UtdidObj;
import com.ta.audid.upload.UtdidKeyFile;
import com.ta.audid.upload.UtdidUploadTask;
import com.ta.audid.utils.AppInfoUtils;
import com.ta.audid.utils.MutiProcessLock;
import com.ta.audid.utils.TaskExecutor;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.device.UTUtdid;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class AppUtdid {
    private static final String TAG = "AppUtdid";
    private String mUtdid = "";
    private static final AppUtdid mInstance = new AppUtdid();
    private static long mCollectDelayTime = 30000;

    private AppUtdid() {
    }

    public static AppUtdid getInstance() {
        return mInstance;
    }

    private String getV5Utdid() {
        final Context context = Variables.getInstance().getContext();
        if (context == null) {
            return "";
        }
        final String readAppUtdidFile = UtdidKeyFile.readAppUtdidFile();
        if (UTUtdid.isValidUtdid(readAppUtdidFile)) {
            UtdidLogger.d(TAG, "read utdid from V5AppFile");
            UTUtdid.setType(7);
            UTUtdid.startSyncThread(new UTUtdid.SyncUtdidRunnable() { // from class: com.ta.utdid2.device.AppUtdid.1
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UtdidObj decode = AppUtdidDecoder.decode(readAppUtdidFile);
                    String utdidFromSettings = UtdidKeyFile.getUtdidFromSettings(context);
                    if (!TextUtils.isEmpty(utdidFromSettings)) {
                        UtdidObj decode2 = AppUtdidDecoder.decode(utdidFromSettings);
                        if (!decode2.isValid() || decode2.getTimestamp() < decode.getTimestamp()) {
                            UtdidKeyFile.writeUtdidToSettings(context, readAppUtdidFile);
                        }
                    } else {
                        UtdidKeyFile.writeUtdidToSettings(context, readAppUtdidFile);
                    }
                    String readSdcardUtdidFile = UtdidKeyFile.readSdcardUtdidFile();
                    if (!TextUtils.isEmpty(readSdcardUtdidFile)) {
                        UtdidObj decode3 = AppUtdidDecoder.decode(readSdcardUtdidFile);
                        if (!decode3.isValid() || decode3.getTimestamp() < decode.getTimestamp()) {
                            UtdidKeyFile.writeSdcardUtdidFile(readAppUtdidFile);
                            return;
                        }
                        return;
                    }
                    UtdidKeyFile.writeSdcardUtdidFile(readAppUtdidFile);
                }
            });
            return readAppUtdidFile;
        }
        final String utdidFromSettings = UtdidKeyFile.getUtdidFromSettings(context);
        if (UTUtdid.isValidUtdid(utdidFromSettings)) {
            UtdidLogger.d(TAG, "read utdid from V5Settings");
            UTUtdid.setType(8);
            UTUtdid.startSyncThread(new UTUtdid.SyncUtdidRunnable() { // from class: com.ta.utdid2.device.AppUtdid.2
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UtdidKeyFile.writeAppUtdidFile(utdidFromSettings);
                    String readSdcardUtdidFile = UtdidKeyFile.readSdcardUtdidFile();
                    if (!TextUtils.isEmpty(readSdcardUtdidFile)) {
                        UtdidObj decode = AppUtdidDecoder.decode(utdidFromSettings);
                        UtdidObj decode2 = AppUtdidDecoder.decode(readSdcardUtdidFile);
                        if (!decode2.isValid() || decode2.getTimestamp() < decode.getTimestamp()) {
                            UtdidKeyFile.writeSdcardUtdidFile(utdidFromSettings);
                            return;
                        }
                        return;
                    }
                    UtdidKeyFile.writeSdcardUtdidFile(utdidFromSettings);
                }
            });
            return utdidFromSettings;
        }
        final String readSdcardUtdidFile = UtdidKeyFile.readSdcardUtdidFile();
        if (UTUtdid.isValidUtdid(readSdcardUtdidFile)) {
            UtdidLogger.d(TAG, "read utdid from V5Sdcard");
            UTUtdid.setType(9);
            UTUtdid.startSyncThread(new UTUtdid.SyncUtdidRunnable() { // from class: com.ta.utdid2.device.AppUtdid.3
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UtdidKeyFile.writeAppUtdidFile(readSdcardUtdidFile);
                    UtdidKeyFile.writeUtdidToSettings(context, readSdcardUtdidFile);
                }
            });
            return readSdcardUtdidFile;
        }
        return null;
    }

    public static void setCollectDelayTime(long j) {
        if (j >= 0) {
            mCollectDelayTime = j;
        }
    }

    private void uploadAppUtdid() {
        UtdidLogger.d();
        if (TextUtils.isEmpty(this.mUtdid)) {
            return;
        }
        try {
            final Context context = Variables.getInstance().getContext();
            if (AppInfoUtils.isMainProcess(context)) {
                TaskExecutor.getInstance().schedule(null, new Runnable() { // from class: com.ta.utdid2.device.AppUtdid.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!UtdidKeyFile.enableUpload(context)) {
                            UtdidLogger.d("", "unable upload!");
                        } else {
                            new UtdidUploadTask(context).run();
                        }
                    }
                }, mCollectDelayTime);
            }
        } catch (Throwable th) {
            UtdidLogger.d("", th);
        }
    }

    public synchronized String getCurrentAppUtdid() {
        return this.mUtdid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getUtdid(Context context) {
        if (!TextUtils.isEmpty(this.mUtdid)) {
            return this.mUtdid;
        }
        MutiProcessLock.lockUtdidFile();
        String v5Utdid = getV5Utdid();
        if (TextUtils.isEmpty(v5Utdid)) {
            v5Utdid = UTUtdid.instance(context).getValue();
        }
        if (TextUtils.isEmpty(v5Utdid)) {
            MutiProcessLock.releaseUtdidFile();
            return Constants.UTDID_INVALID;
        }
        this.mUtdid = v5Utdid;
        uploadAppUtdid();
        String str = this.mUtdid;
        MutiProcessLock.releaseUtdidFile();
        return str;
    }

    public synchronized String getUtdidCache() {
        if (TextUtils.isEmpty(this.mUtdid)) {
            return Constants.UTDID_INVALID;
        }
        return this.mUtdid;
    }
}
