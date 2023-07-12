package com.ta.audid.upload;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.audid.Variables;
import com.ta.audid.permission.PermissionUtils;
import com.ta.audid.utils.FileUtils;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.android.utils.PhoneInfoUtils;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class UtdidKeyFile {
    private static final String AUDID_FILE_DIR = ".UTSystemConfig" + File.separator + "Global";
    private static final String AUDID_FILE_NAME = "cec06585501c9775";
    private static final String AUDID_NOT_UPLOAD = "3c9b584e65e6c983";
    private static final String UTDID_FILE_APPUTDID = "4635b664f789000d";
    private static final String UTDID_FILE_DIR = ".7934039a7252be16";
    private static final String UTDID_FILE_ECDID_UTDID = "d48d3759078396c6";
    private static final String UTDID_FILE_LOCK = "9983c160aa044115";
    private static final String UTDID_FILE_SYNCUTDIDLOCK = "a325712a39bd320a";
    private static final String UTDID_FILE_UTDID = "7934039a7252be16";

    public static boolean enableUpload(Context context) {
        try {
            return !context.getFileStreamPath(AUDID_NOT_UPLOAD).exists();
        } catch (Exception unused) {
            return true;
        }
    }

    private static String getAppUtdidFilePath() {
        Context context = Variables.getInstance().getContext();
        String str = getUtdidAppRootFileDir(context) + File.separator + UTDID_FILE_APPUTDID;
        UtdidLogger.sd("", str);
        return str;
    }

    private static String getAudidFilePath() {
        if (PermissionUtils.checkStoragePermissionGranted(Variables.getInstance().getContext())) {
            return getUtdidSdcardRootFileDir() + File.separator + AUDID_FILE_NAME;
        }
        return null;
    }

    public static String getEcdidUtdidPath() {
        Context context = Variables.getInstance().getContext();
        return getUtdidAppRootFileDir(context) + File.separator + UTDID_FILE_ECDID_UTDID;
    }

    public static String getFileLockPath() {
        Context context = Variables.getInstance().getContext();
        return getUtdidAppRootFileDir(context) + File.separator + UTDID_FILE_LOCK;
    }

    private static String getSdcardUtdidFilePath() {
        if (PermissionUtils.checkStoragePermissionGranted(Variables.getInstance().getContext())) {
            return getUtdidSdcardRootFileDir() + File.separator + UTDID_FILE_UTDID;
        }
        return null;
    }

    public static String getSyncUtdidFileLockPath() {
        Context context = Variables.getInstance().getContext();
        return getUtdidAppRootFileDir(context) + File.separator + UTDID_FILE_SYNCUTDIDLOCK;
    }

    private static String getUtdidAppRootFileDir(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + File.separator + UTDID_FILE_DIR;
        UtdidLogger.sd("", "UtdidAppRoot dir:" + str);
        FileUtils.isDirExist(str);
        return str;
    }

    public static String getUtdidFromSettings(Context context) {
        if (PhoneInfoUtils.isPrivacyMode()) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), UTDID_FILE_UTDID);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getUtdidSdcardRootFileDir() {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + AUDID_FILE_DIR;
        UtdidLogger.sd("", "SdcardRoot dir:" + str);
        FileUtils.isDirExist(str);
        return str;
    }

    public static String readAppUtdidFile() {
        try {
            return FileUtils.readFile(getAppUtdidFilePath());
        } catch (Exception unused) {
            return null;
        }
    }

    public static String readAudidFile() {
        try {
            String audidFilePath = getAudidFilePath();
            if (!TextUtils.isEmpty(audidFilePath)) {
                String readFile = FileUtils.readFile(audidFilePath);
                if (!TextUtils.isEmpty(readFile) && readFile.length() != 32) {
                    if (readFile.length() != 36) {
                        return null;
                    }
                }
                return readFile;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String readSdcardUtdidFile() {
        try {
            String sdcardUtdidFilePath = getSdcardUtdidFilePath();
            if (TextUtils.isEmpty(sdcardUtdidFilePath)) {
                return null;
            }
            return FileUtils.readFile(sdcardUtdidFilePath);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void writeAppUtdidFile(String str) {
        try {
            UtdidLogger.d();
            FileUtils.saveFile(getAppUtdidFilePath(), str);
        } catch (Throwable unused) {
        }
    }

    public static void writeAudidFile(String str) {
        try {
            UtdidLogger.sd("", "audid:" + str);
            String audidFilePath = getAudidFilePath();
            if (TextUtils.isEmpty(audidFilePath)) {
                return;
            }
            if (TextUtils.isEmpty(str) || str.length() == 32 || str.length() == 36) {
                FileUtils.saveFile(audidFilePath, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void writeSdcardUtdidFile(String str) {
        try {
            String sdcardUtdidFilePath = getSdcardUtdidFilePath();
            if (TextUtils.isEmpty(sdcardUtdidFilePath)) {
                return;
            }
            FileUtils.saveFile(sdcardUtdidFilePath, str);
        } catch (Exception unused) {
        }
    }

    public static void writeUtdidToSettings(Context context, String str) {
        if (PhoneInfoUtils.isPrivacyMode()) {
            return;
        }
        String str2 = null;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), UTDID_FILE_UTDID);
        } catch (Exception unused) {
        }
        if (str.equals(str2)) {
            return;
        }
        try {
            Settings.System.putString(context.getContentResolver(), UTDID_FILE_UTDID, str);
        } catch (Exception unused2) {
        }
    }
}
