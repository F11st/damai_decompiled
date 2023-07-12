package android.taobao.windvane.packageapp;

import android.app.Application;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo;
import android.taobao.windvane.packageapp.zipapp.data.ZipAppTypeEnum;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.taobao.windvane.util.TaoLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ZipAppFileManager {
    private static ZipAppFileManager zipAppFileManager;
    private String TAG = "PackageApp-ZipAppFileManager";
    private ZipDegradeDecider mDecider;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ZipDegradeDecider {
        boolean needDegrade();
    }

    private boolean deleteDir(String str, String str2) {
        File[] listFiles;
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        if (!str2.equals(file2.getName())) {
                            FileAccesser.deleteFile(file2);
                        }
                    } else {
                        file2.delete();
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getFileAbsolutePath(ZipAppInfo zipAppInfo, boolean z) {
        String str = "";
        if (GlobalConfig.context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(z ? ZipAppConstants.ZIPAPP_ROOT_TMP_DIR : ZipAppConstants.ZIPAPP_ROOT_APPS_DIR);
        if (zipAppInfo.genMidPath(z) != null) {
            str = str2 + zipAppInfo.genMidPath(z);
        }
        sb.append(str);
        return sb.toString();
    }

    public static ZipAppFileManager getInstance() {
        if (zipAppFileManager == null) {
            synchronized (ZipAppFileManager.class) {
                if (zipAppFileManager == null) {
                    zipAppFileManager = new ZipAppFileManager();
                }
            }
        }
        return zipAppFileManager;
    }

    private boolean saveFile(String str, byte[] bArr) {
        try {
            return FileAccesser.write(str, ByteBuffer.wrap(bArr));
        } catch (Exception e) {
            String str2 = this.TAG;
            TaoLog.e(str2, "write file:[" + str + "]  exception:" + e.getMessage());
            return false;
        }
    }

    public boolean clearAppsDir() {
        return FileAccesser.deleteFile(new File(getFileAbsolutePath(null, false, true)), false);
    }

    public boolean clearTmpDir(String str, boolean z) {
        return FileAccesser.deleteFile(new File(getFileAbsolutePath(str, true, true)), z);
    }

    public boolean clearZCacheDir() {
        return FileAccesser.deleteFile(new File(getFileAbsolutePath(null, false, false)), false);
    }

    public boolean copyZipApp(ZipAppInfo zipAppInfo) {
        String zipRootDir = getZipRootDir(zipAppInfo, true);
        return FileManager.copyDir(zipRootDir, getFileAbsolutePath(zipAppInfo.name + "/" + zipAppInfo.v, false, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType()));
    }

    public boolean createZipAppInitDir() {
        Application application = GlobalConfig.context;
        if (application == null) {
            return false;
        }
        File createFolder = FileManager.createFolder(application, ZipAppConstants.ZIPAPP_ROOT_APPS_DIR);
        String str = this.TAG;
        TaoLog.d(str, "createDir: dir[" + createFolder.getAbsolutePath() + "]:" + createFolder.exists());
        if (createFolder.exists()) {
            File createFolder2 = FileManager.createFolder(GlobalConfig.context, ZipAppConstants.ZIPAPP_ROOT_TMP_DIR);
            String str2 = this.TAG;
            TaoLog.d(str2, "createDir: dir[" + createFolder2.getAbsolutePath() + "]:" + createFolder2.exists());
            return createFolder2.exists();
        }
        return false;
    }

    public boolean deleteHisZipApp(ZipAppInfo zipAppInfo) {
        return deleteDir(getFileAbsolutePath(zipAppInfo.name, false, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType()), zipAppInfo.v);
    }

    public boolean deleteZipApp(ZipAppInfo zipAppInfo, boolean z) {
        File file = new File(getFileAbsolutePath(zipAppInfo.name, z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType()));
        if (file.exists()) {
            return FileAccesser.deleteFile(file);
        }
        return true;
    }

    public String getDownLoadPath() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_DOWNLOAD__DIR;
    }

    public String getGlobalConfigPath(boolean z) {
        return getFileAbsolutePath(ZipAppConstants.H5_APPS_NAME, z, true);
    }

    public String getNewRootDir(ZipAppInfo zipAppInfo) {
        return getFileAbsolutePath(zipAppInfo.genMidPath(true), false, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType());
    }

    public String getNewZipResAbsolutePath(ZipAppInfo zipAppInfo, String str, boolean z) {
        return getFileAbsolutePath(zipAppInfo.genMidPath(true) + File.separator + str, z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType());
    }

    public InputStream getPreloadInputStream(String str) {
        try {
            return GlobalConfig.context.getResources().getAssets().open(str);
        } catch (FileNotFoundException unused) {
            TaoLog.i(this.TAG, "preload package not exists");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String getRootPath() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_ROOT_DIR;
    }

    public String getRootPathApps() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_ROOT_APPS_DIR;
    }

    public String getRootPathTmp() {
        if (GlobalConfig.context == null) {
            return "";
        }
        return GlobalConfig.context.getFilesDir().getAbsolutePath() + File.separator + ZipAppConstants.ZIPAPP_ROOT_TMP_DIR;
    }

    public String getZcacheConfigPath(boolean z) {
        return getFileAbsolutePath(ZipAppConstants.H5_ZCACHE_MAP, z, false);
    }

    public String getZipResAbsolutePath(ZipAppInfo zipAppInfo, String str, boolean z) {
        return getFileAbsolutePath(zipAppInfo.genMidPath(z) + File.separator + str, z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType());
    }

    public String getZipRootDir(ZipAppInfo zipAppInfo, boolean z) {
        return getFileAbsolutePath(zipAppInfo.genMidPath(z), z, ZipAppTypeEnum.ZIP_APP_TYPE_PACKAGEAPP == zipAppInfo.getAppType());
    }

    public String readFile(String str) {
        try {
            if (!FileAccesser.exists(str)) {
                String str2 = this.TAG;
                TaoLog.i(str2, "file[" + str + "] not found");
                return null;
            }
            byte[] read = FileAccesser.read(str);
            if (read != null && read.length >= 1) {
                return new String(read, ZipAppConstants.DEFAULT_ENCODING);
            }
            String str3 = this.TAG;
            TaoLog.w(str3, "readConfig:[" + str + "] data is null");
            return null;
        } catch (Exception e) {
            String str4 = this.TAG;
            TaoLog.e(str4, "readFile:[" + str + "] exception:" + e.getMessage());
            return null;
        }
    }

    public String readGlobalConfig(boolean z) {
        return readFile(getGlobalConfigPath(z));
    }

    public String readZcacheConfig(boolean z) {
        return readFile(getZcacheConfigPath(z));
    }

    public String readZipAppRes(ZipAppInfo zipAppInfo, String str, boolean z) {
        return readFile(getZipResAbsolutePath(zipAppInfo, str, z));
    }

    public byte[] readZipAppResByte(ZipAppInfo zipAppInfo, String str, boolean z) {
        return FileAccesser.read(getZipResAbsolutePath(zipAppInfo, str, z));
    }

    public synchronized boolean saveGlobalConfig(byte[] bArr, boolean z) {
        return saveFile(getGlobalConfigPath(z), bArr);
    }

    public boolean saveZcacheConfig(byte[] bArr, boolean z) {
        return saveFile(getZcacheConfigPath(z), bArr);
    }

    public boolean saveZipAppRes(ZipAppInfo zipAppInfo, String str, byte[] bArr, boolean z) {
        return saveFile(getZipResAbsolutePath(zipAppInfo, str, z), bArr);
    }

    public void setZipDegradeDecider(ZipDegradeDecider zipDegradeDecider) {
        this.mDecider = zipDegradeDecider;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x000b, B:5:0x0014, B:8:0x001c, B:11:0x0023, B:15:0x003f, B:17:0x0045, B:12:0x0032), top: B:26:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String unZipToTmp(android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 1
            java.lang.String r1 = r5.getZipRootDir(r6, r0)
            android.taobao.windvane.file.FileAccesser.deleteFile(r1)
            java.lang.String r1 = ""
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L5f
            r3.<init>(r7)     // Catch: java.lang.Exception -> L5f
            android.taobao.windvane.packageapp.ZipAppFileManager$ZipDegradeDecider r4 = r5.mDecider     // Catch: java.lang.Exception -> L5f
            if (r4 == 0) goto L19
            boolean r4 = r4.needDegrade()     // Catch: java.lang.Exception -> L5f
            goto L1a
        L19:
            r4 = 0
        L1a:
            if (r4 != 0) goto L32
            android.taobao.windvane.config.WVCommonConfigData r4 = android.taobao.windvane.config.WVCommonConfig.commonConfig     // Catch: java.lang.Exception -> L5f
            boolean r4 = r4.needZipDegrade     // Catch: java.lang.Exception -> L5f
            if (r4 == 0) goto L23
            goto L32
        L23:
            r3.setReadOnly()     // Catch: java.lang.Exception -> L5f
            java.lang.String r4 = r5.getZipRootDir(r6, r0)     // Catch: java.lang.Exception -> L5f
            java.lang.String r1 = android.taobao.windvane.file.FileManager.unZipByFilePath(r7, r4)     // Catch: java.lang.Exception -> L5f
            r3.setWritable(r0)     // Catch: java.lang.Exception -> L5f
            goto L3f
        L32:
            java.lang.String r0 = r5.getZipRootDir(r6, r0)     // Catch: java.lang.Exception -> L5f
            boolean r0 = android.taobao.windvane.file.FileManager.unzip(r7, r0)     // Catch: java.lang.Exception -> L5f
            if (r0 == 0) goto L3f
            java.lang.String r1 = "success"
        L3f:
            boolean r0 = r3.exists()     // Catch: java.lang.Exception -> L5f
            if (r0 == 0) goto L84
            r3.delete()     // Catch: java.lang.Exception -> L5f
            java.lang.String r0 = r5.TAG     // Catch: java.lang.Exception -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5f
            r3.<init>()     // Catch: java.lang.Exception -> L5f
            java.lang.String r4 = "Delete temp file:"
            r3.append(r4)     // Catch: java.lang.Exception -> L5f
            r3.append(r7)     // Catch: java.lang.Exception -> L5f
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Exception -> L5f
            android.taobao.windvane.util.TaoLog.d(r0, r7)     // Catch: java.lang.Exception -> L5f
            goto L84
        L5f:
            r7 = move-exception
            java.lang.String r0 = r5.TAG
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "unZipToTemp"
            android.taobao.windvane.util.TaoLog.w(r0, r3, r7, r2)
            android.taobao.windvane.config.WVCommonConfigData r0 = android.taobao.windvane.config.WVCommonConfig.commonConfig
            boolean r0 = r0.needZipDegrade
            if (r0 == 0) goto L72
            r0 = -1
            goto L73
        L72:
            r0 = -2
        L73:
            android.taobao.windvane.monitor.WVPackageMonitorInterface r2 = android.taobao.windvane.monitor.WVMonitorService.getPackageMonitorInterface()
            java.lang.String r7 = r7.getMessage()
            java.lang.String r6 = r6.getZipUrl()
            java.lang.String r3 = "UnzipError"
            r2.commitFail(r3, r0, r7, r6)
        L84:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.packageapp.ZipAppFileManager.unZipToTmp(android.taobao.windvane.packageapp.zipapp.data.ZipAppInfo, java.lang.String):java.lang.String");
    }

    private String getFileAbsolutePath(String str, boolean z) {
        String str2 = "";
        if (GlobalConfig.context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str3 = File.separator;
        sb.append(str3);
        sb.append(z ? ZipAppConstants.ZIPAPP_ROOT_TMP_DIR : ZipAppConstants.ZIPAPP_ROOT_APPS_DIR);
        if (str != null) {
            str2 = str3 + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    private String getFileAbsolutePath(String str, boolean z, boolean z2) {
        String str2;
        String str3 = "";
        if (GlobalConfig.context == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(GlobalConfig.context.getFilesDir().getAbsolutePath());
        String str4 = File.separator;
        sb.append(str4);
        if (z) {
            str2 = ZipAppConstants.ZIPAPP_ROOT_TMP_DIR;
        } else {
            str2 = z2 ? ZipAppConstants.ZIPAPP_ROOT_APPS_DIR : ZipAppConstants.ZIPAPP_ROOT_ZCACHE_DIR;
        }
        sb.append(str2);
        if (str != null) {
            str3 = str4 + str;
        }
        sb.append(str3);
        return sb.toString();
    }
}
