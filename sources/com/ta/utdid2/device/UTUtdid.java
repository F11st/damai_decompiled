package com.ta.utdid2.device;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.google.common.primitives.SignedBytes;
import com.ta.audid.Variables;
import com.ta.audid.utils.FileUtils;
import com.ta.audid.utils.MutiProcessLock;
import com.ta.audid.utils.RC4;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.android.utils.Base64;
import com.ta.utdid2.android.utils.IntUtils;
import com.ta.utdid2.android.utils.PhoneInfoUtils;
import com.ta.utdid2.android.utils.StringUtils;
import com.ta.utdid2.core.persistent.PersistentConfiguration;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import tb.km1;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class UTUtdid {
    private static final String S_GLOBAL_DIR = ".UTSystemConfig";
    private static final String S_GLOBAL_PERSISTENT_CONFIG_DIR;
    private static final String S_GLOBAL_PERSISTENT_CONFIG_KEY = "Alvin2";
    private static final String S_UTDID_DIR;
    private static final String TAG = "UTUtdid";
    private static final int TYPE_CREATE = 6;
    private static final int TYPE_DEFAULT = 0;
    private static final int TYPE_DIR = 4;
    private static final int TYPE_ECDID = 5;
    private static final int TYPE_MYSP = 3;
    private static final int TYPE_OLD = 1;
    static final int TYPE_SERVER_APP = 7;
    static final int TYPE_SERVER_SDCARD = 9;
    static final int TYPE_SERVER_SETTINGS = 8;
    private static final int TYPE_SETTINGS = 2;
    private static final String UM_SETTINGS_STORAGE_NEW = "mqBRboGZkQPcAkyk";
    private static final String UM_SETTINGS_STORAGE_OLD = "dxCRMxhQkdGePGnp";
    private static final int U_SIZE = 18;
    private static String mExtendFactor;
    private static UTUtdid mInstance;
    private static int mType;
    private Context mContext;
    private PersistentConfiguration mPersistentConfiguration;
    private static Pattern mPattern = Pattern.compile("[^0-9a-zA-Z=/+]+");
    private static final Object CREATE_LOCK = new Object();
    private String mUtdid = null;
    private boolean mInvalidUtdidDir = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface SyncUtdidRunnable {
        void syncUtdid();
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(S_GLOBAL_DIR);
        String str = File.separator;
        sb.append(str);
        sb.append("Global");
        S_GLOBAL_PERSISTENT_CONFIG_DIR = sb.toString();
        S_UTDID_DIR = ".7934039a" + str + ".u";
        mType = 0;
        mExtendFactor = "";
    }

    private UTUtdid(Context context) {
        this.mContext = null;
        this.mPersistentConfiguration = null;
        this.mContext = context;
        Variables.getInstance().initContext(context);
        this.mPersistentConfiguration = new PersistentConfiguration(context, S_GLOBAL_PERSISTENT_CONFIG_DIR, S_GLOBAL_PERSISTENT_CONFIG_KEY);
    }

    private static String calcHmac(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, km1.OP_CREATE_JSON, -80, -68, -78, -117, 53, 30, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(RC4.rc4(bArr2), mac.getAlgorithm()));
        return Base64.encodeToString(mac.doFinal(bArr), 2);
    }

    private byte[] generateUtdid() throws Exception {
        String str;
        UtdidLogger.d(TAG, "generateUtdid");
        Log.d(TAG, "generateUtdid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = IntUtils.getBytes(currentTimeMillis);
        byte[] bytes2 = IntUtils.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = mExtendFactor + PhoneInfoUtils.getImei(this.mContext);
        } catch (Exception unused) {
            str = mExtendFactor + new Random().nextInt();
        }
        byteArrayOutputStream.write(IntUtils.getBytes(StringUtils.hashCode(str)), 0, 4);
        byteArrayOutputStream.write(IntUtils.getBytes(StringUtils.hashCode(calcHmac(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getType() {
        return mType;
    }

    private String getUtdidFromNewSettings() {
        if (PhoneInfoUtils.isPrivacyMode()) {
            return "";
        }
        try {
            return Settings.System.getString(this.mContext.getContentResolver(), UM_SETTINGS_STORAGE_NEW);
        } catch (Exception unused) {
            return "";
        }
    }

    private String getUtdidFromOldSettings() {
        if (PhoneInfoUtils.isPrivacyMode()) {
            return "";
        }
        String str = null;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), UM_SETTINGS_STORAGE_OLD);
        } catch (Exception unused) {
        }
        try {
            if (!StringUtils.isEmpty(str)) {
                UTUtdidHelper2 uTUtdidHelper2 = new UTUtdidHelper2();
                String dePackWithBase64 = uTUtdidHelper2.dePackWithBase64(str);
                if (isValidUtdid(dePackWithBase64)) {
                    UtdidLogger.d(TAG, "OldSettings_1", dePackWithBase64);
                    saveUtdidToNewSettings(dePackWithBase64);
                    return dePackWithBase64;
                }
                String dePack = uTUtdidHelper2.dePack(str);
                if (isValidUtdid(dePack)) {
                    UtdidLogger.d(TAG, "OldSettings_2", dePack);
                    saveUtdidToNewSettings(dePack);
                    return dePack;
                }
                String dePack2 = new UTUtdidHelper().dePack(str);
                if (isValidUtdid(dePack2)) {
                    UtdidLogger.d(TAG, "OldSettings_3", dePack2);
                    saveUtdidToNewSettings(dePack2);
                    return dePack2;
                }
            }
        } catch (Throwable th) {
            UtdidLogger.se(TAG, th, new Object[0]);
        }
        return "";
    }

    private String getValueForUpdate() {
        String readUtdid = readUtdid();
        if (isValidUtdid(readUtdid)) {
            if (!TextUtils.isEmpty(readUtdid) && readUtdid.endsWith(org.apache.commons.lang3.StringUtils.LF)) {
                this.mUtdid = readUtdid.substring(0, readUtdid.length() - 1);
            } else {
                this.mUtdid = readUtdid;
            }
            return this.mUtdid;
        }
        try {
            byte[] generateUtdid = generateUtdid();
            if (generateUtdid != null) {
                String encodeToString = Base64.encodeToString(generateUtdid, 2);
                this.mUtdid = encodeToString;
                mType = 6;
                writeNewUtdidAsync(encodeToString);
                return this.mUtdid;
            }
            return null;
        } catch (Exception e) {
            UtdidLogger.e("", e, new Object[0]);
            return null;
        }
    }

    public static UTUtdid instance(Context context) {
        if (context != null && mInstance == null) {
            synchronized (CREATE_LOCK) {
                if (mInstance == null) {
                    mInstance = new UTUtdid(context);
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtdid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith(org.apache.commons.lang3.StringUtils.LF)) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !mPattern.matcher(str).find();
        }
        return false;
    }

    private static boolean mkUtdidDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            UtdidLogger.sd(TAG, "mkUtdidDir path", str, "mkdirs success", Boolean.valueOf(mkdirs));
            return mkdirs;
        }
        UtdidLogger.sd(TAG, "path is exits", str);
        return true;
    }

    private String readUtdid() {
        String utdidFromNewSettings = getUtdidFromNewSettings();
        if (isValidUtdid(utdidFromNewSettings)) {
            mType = 2;
            UtdidLogger.d(TAG, "utdid type", 2);
            writeSpFromSettingsAsync(utdidFromNewSettings);
            return utdidFromNewSettings;
        }
        String utdidFromOldSettings = getUtdidFromOldSettings();
        if (isValidUtdid(utdidFromOldSettings)) {
            mType = 2;
            UtdidLogger.d(TAG, "utdid type", 2);
            writeSpFromSettingsAsync(utdidFromOldSettings);
            return utdidFromOldSettings;
        }
        final String utdidFromSp = this.mPersistentConfiguration.getUtdidFromSp();
        if (isValidUtdid(utdidFromSp)) {
            int typeFromSp = this.mPersistentConfiguration.getTypeFromSp();
            if (typeFromSp == 0) {
                mType = 1;
            } else {
                mType = typeFromSp;
            }
            UtdidLogger.d(TAG, "get utdid from sp. type", Integer.valueOf(mType));
            startSyncThread(new SyncUtdidRunnable() { // from class: com.ta.utdid2.device.UTUtdid.3
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UTUtdid.this.saveUtdidToNewSettings(utdidFromSp);
                    String utdidFromMySp = UTUtdid.this.mPersistentConfiguration.getUtdidFromMySp();
                    if (!UTUtdid.isValidUtdid(utdidFromMySp) && UTUtdid.this.mPersistentConfiguration.copySPToMySP()) {
                        utdidFromMySp = utdidFromSp;
                    }
                    String readUtdidDir = UTUtdid.this.readUtdidDir();
                    if (UTUtdid.isValidUtdid(utdidFromMySp) && !utdidFromMySp.equals(readUtdidDir)) {
                        UTUtdid.this.writeUtdidDir(utdidFromMySp);
                    }
                    if (UTUtdid.isValidUtdid(EcdidUtils.readUtdidFromEcdid())) {
                        EcdidUtils.sendMessage2();
                    } else {
                        EcdidUtils.writeEcdidUtdidFile(utdidFromSp);
                    }
                }
            });
            return utdidFromSp;
        }
        final String utdidFromMySp = this.mPersistentConfiguration.getUtdidFromMySp();
        if (isValidUtdid(utdidFromMySp)) {
            mType = 3;
            UtdidLogger.d(TAG, "utdid type", 3);
            this.mPersistentConfiguration.copyMySPToSP(mType);
            startSyncThread(new SyncUtdidRunnable() { // from class: com.ta.utdid2.device.UTUtdid.4
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UTUtdid.this.saveUtdidToNewSettings(utdidFromMySp);
                    String readUtdidDir = UTUtdid.this.readUtdidDir();
                    if (UTUtdid.isValidUtdid(utdidFromMySp) && !utdidFromMySp.equals(readUtdidDir)) {
                        UTUtdid.this.writeUtdidDir(utdidFromMySp);
                    }
                    if (UTUtdid.isValidUtdid(EcdidUtils.readUtdidFromEcdid())) {
                        EcdidUtils.sendMessage2();
                    } else {
                        EcdidUtils.writeEcdidUtdidFile(utdidFromMySp);
                    }
                }
            });
            return utdidFromMySp;
        }
        final String readUtdidDir = readUtdidDir();
        if (isValidUtdid(readUtdidDir)) {
            mType = 4;
            UtdidLogger.d(TAG, "utdid type", 4);
            this.mPersistentConfiguration.writeUtdidToSp(readUtdidDir, mType);
            startSyncThread(new SyncUtdidRunnable() { // from class: com.ta.utdid2.device.UTUtdid.5
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UTUtdid.this.saveUtdidToNewSettings(readUtdidDir);
                    UTUtdid.this.mPersistentConfiguration.copySPToMySP();
                    if (UTUtdid.isValidUtdid(EcdidUtils.readUtdidFromEcdid())) {
                        EcdidUtils.sendMessage2();
                    } else {
                        EcdidUtils.writeEcdidUtdidFile(readUtdidDir);
                    }
                }
            });
            return readUtdidDir;
        }
        final String readUtdidFromEcdid = EcdidUtils.readUtdidFromEcdid();
        if (isValidUtdid(readUtdidFromEcdid)) {
            mType = 5;
            UtdidLogger.d(TAG, "utdid type", 5);
            this.mPersistentConfiguration.writeUtdidToSp(readUtdidFromEcdid, mType);
            startSyncThread(new SyncUtdidRunnable() { // from class: com.ta.utdid2.device.UTUtdid.6
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UTUtdid.this.saveUtdidToNewSettings(readUtdidFromEcdid);
                    UTUtdid.this.mPersistentConfiguration.copySPToMySP();
                    UTUtdid.this.writeUtdidDir(readUtdidFromEcdid);
                    EcdidUtils.sendMessage2();
                }
            });
            return readUtdidFromEcdid;
        }
        UtdidLogger.d(TAG, "read utdid is null");
        Log.d(TAG, "read utdid is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readUtdidDir() {
        UtdidLogger.d(TAG, "readUtdidDir");
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = new byte[18];
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(S_UTDID_DIR);
        sb.append(str);
        sb.append(IRequestConst.U);
        String sb2 = sb.toString();
        for (int i = 0; i < 18; i++) {
            String str2 = sb2 + i;
            UtdidLogger.sd(TAG, "uDir", str2);
            if (!FileUtils.checkFileExistOnly(str2)) {
                UtdidLogger.sd(TAG, "checkFileExistOnly", Boolean.FALSE);
                return null;
            }
            bArr[i] = readUtdidSubDir(str2);
            UtdidLogger.sd(TAG, "readUtdidDir", Byte.valueOf(bArr[i]), "mInvalidUtdidDir", Boolean.valueOf(this.mInvalidUtdidDir));
            if (this.mInvalidUtdidDir) {
                return null;
            }
        }
        String encodeToString = Base64.encodeToString(bArr, 2);
        UtdidLogger.d(TAG, "readUtdidDir", encodeToString, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return encodeToString;
    }

    private byte readUtdidSubDir(String str) {
        int i;
        StringBuilder sb = new StringBuilder(str);
        byte b = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            sb.append(File.separator);
            sb.append("1");
            if (FileUtils.checkFileExistOnly(sb.toString())) {
                i = (b << 1) | 1;
            } else {
                int length = sb.length();
                sb.replace(length - 1, length, "0");
                i = b << 1;
            }
            b = (byte) i;
        }
        String sb2 = sb.toString();
        UtdidLogger.sd(TAG, "readUtdidDir", sb2);
        if (FileUtils.checkFileExistOnly(sb2)) {
            UtdidLogger.sd(TAG, "readUtdidDir b", Byte.valueOf(b));
            return b;
        }
        UtdidLogger.sd(TAG, "readUtdidDir false");
        this.mInvalidUtdidDir = true;
        return (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveUtdidToNewSettings(String str) {
        if (!PhoneInfoUtils.isPrivacyMode() && isValidUtdid(str)) {
            try {
                Settings.System.putString(this.mContext.getContentResolver(), UM_SETTINGS_STORAGE_NEW, str);
            } catch (Exception unused) {
            }
        }
    }

    public static void setExtendFactor(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        mExtendFactor = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setType(int i) {
        mType = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startSyncThread(final SyncUtdidRunnable syncUtdidRunnable) {
        new Thread("UtdidSyncThread") { // from class: com.ta.utdid2.device.UTUtdid.7
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    UtdidLogger.d("startSyncThread", new Object[0]);
                } catch (Throwable unused) {
                }
                if (!MutiProcessLock.trylockSyncUtdid()) {
                    MutiProcessLock.releaseSyncUtdid();
                    return;
                }
                syncUtdidRunnable.syncUtdid();
                MutiProcessLock.releaseSyncUtdid();
            }
        }.start();
    }

    private void writeNewUtdidAsync(final String str) {
        if (isValidUtdid(str)) {
            mType = 6;
            UtdidLogger.d(TAG, "utdid type:", 6);
            this.mPersistentConfiguration.writeUtdidToSp(str, mType);
            startSyncThread(new SyncUtdidRunnable() { // from class: com.ta.utdid2.device.UTUtdid.1
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    UTUtdid.this.saveUtdidToNewSettings(str);
                    UTUtdid.this.mPersistentConfiguration.copySPToMySP();
                    UTUtdid.this.writeUtdidDir(str);
                    EcdidUtils.writeEcdidUtdidFile(str);
                }
            });
        }
    }

    private void writeSpFromSettingsAsync(final String str) {
        if (isValidUtdid(str)) {
            startSyncThread(new SyncUtdidRunnable() { // from class: com.ta.utdid2.device.UTUtdid.2
                @Override // com.ta.utdid2.device.UTUtdid.SyncUtdidRunnable
                public void syncUtdid() {
                    if (str.equals(UTUtdid.this.mPersistentConfiguration.getUtdidFromSp())) {
                        return;
                    }
                    UTUtdid.this.mPersistentConfiguration.updateUtdidToSp(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeUtdidDir(String str) {
        byte[] decode;
        boolean z;
        UtdidLogger.d(TAG, "writeUtdidDir", str);
        long currentTimeMillis = System.currentTimeMillis();
        if (isValidUtdid(str) && (decode = Base64.decode(str, 2)) != null && decode.length == 18) {
            String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + S_UTDID_DIR;
            try {
                UtdidLogger.se(TAG, "delete baseDir", str2);
                FileUtils.delete(str2);
                UtdidLogger.se(TAG, "delete baseDir success");
                try {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 18; i++) {
                        sb.delete(0, sb.length());
                        sb.append(str2);
                        sb.append(File.separator);
                        sb.append(IRequestConst.U);
                        sb.append(i);
                        byte b = decode[i];
                        for (int i2 = 0; i2 < 8; i2++) {
                            sb.append(File.separator);
                            sb.append((int) ((byte) (((byte) (b >> (7 - i2))) & 1)));
                        }
                        String sb2 = sb.toString();
                        UtdidLogger.sd(TAG, "mk dir", sb2);
                        if (!mkUtdidDir(sb2)) {
                            UtdidLogger.d(TAG, "writeUtdidDir success", Boolean.FALSE);
                            return;
                        }
                        String valueOf = String.valueOf((int) b);
                        UtdidLogger.sd(TAG, "writeUtdidDir content", valueOf);
                        FileUtils.saveFile(sb2 + "/success", valueOf);
                    }
                    z = true;
                } catch (Exception e) {
                    UtdidLogger.se(TAG, e, new Object[0]);
                    z = false;
                }
                UtdidLogger.d(TAG, "writeUtdidDir success", Boolean.valueOf(z), "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th) {
                UtdidLogger.se(TAG, "delete baseDir fail");
                UtdidLogger.se(TAG, th, new Object[0]);
            }
        }
    }

    public synchronized String getValue() {
        String str = this.mUtdid;
        if (str != null) {
            return str;
        }
        return getValueForUpdate();
    }
}
