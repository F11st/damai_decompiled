package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.ali.user.open.core.Site;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LFFilePathUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ACTIVE_MEDAL_FILE_NAME = "ActiveMedal";
    private static final String ACTIVE_MEDAL_SIGN_FILE_NAME = "ActiveMedalSign";
    private static final String ALL_MEDAL_FILE_NAME = "AllMedal";
    private static final String ALL_MEDAL_SIGN_FILE_NAME = "AllMedalSign";
    private static final String ANCHOR_REPORT_SET_NAME = "AnchorReport";
    private static final String ENTER_EFFECTES_FILE_NAME = "EnterEffects";
    private static final String EnterEffect_DIR_NAME = "EnterEffect";
    private static final String FANS_WALL_DIR_NAME = "fans_wall";
    private static final String FANS_WALL_SHOW_DIR_NAME = "LaifengShow";
    private static final String GIFTS_DIR_NAME = "gifts";
    private static final String GIFT_RESOURCES_NAME = "Resources";
    private static final String GIFT_ZIP_RESOURCES_NAME = "ZipResources";
    private static final String GOLD_MASTER_MEDAL_FILE_NAME = "GoldMasterMedal";
    private static final String GOLD_MASTER_MEDAL_SIGN_FILE_NAME = "GoldMasterMedalSign";
    private static final String HEAD_DIR_NAME = "head";
    private static final String IMAGE_DIR_NAME = "image";
    private static final String LAIFENG_LOG_DIR_NAME = "LaifengLog";
    private static final String LEVEL_NAME = "levelSource";
    private static final String MEDAL_DIR_NAME = "Medal2";
    private static final String PRAISE_DIR_NAME = "praise";
    private static final String PRIZE_DIR_NAME = "prize";
    private static final String REPLAY_IM_FILE_NAME = "ReplayFiles";
    private static final String SCREEN_SHOT_DIR_NAME = "screenShot";
    private static final String SDPATH_SIGNGOLD = "download";
    private static final String SKIN_DIR_NAME = "skin";
    private static final String SOPCAST_DIR_NAME = "sopcast";
    private static final String SPLASH_DIR_NAME = "splash";
    private static final String SPLASH_SET_NAME = "advert";
    private static final String TAG = "LFFilePathUtils";
    private static final String UGCCOMPRESS_RESOURCES_NAME = "UgcCompressFile";
    private static final String UPDATE_DIR_NAME = "update";
    public static final String PATH_SD_CARD = AppContextUtils.getApp().getFilesDir().getAbsolutePath();
    private static String mLogFileName = null;
    private static final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private static LFFilePathUtils mInstance = null;
    private static final Object mMutex = new Object();
    private static String CustomMainDirName = null;
    private static String mSDParentPath = Site.LAIFENG_NEW;
    private String KEY_GIFT_SIGN = "gift_sign";
    private String KEY_GIFT_CONFIG_SIGN = "gift_config_sign";
    private String KEY_GIFT_CONFIG_DATA = "gift_config_data";
    private String KEY_RED_PACK_SIGN = "red_pack_sign";
    private String KEY_RED_PACK_CONFIG_SIGN = "red_pack_config_sign";
    private String KEY_RED_PACK_CONFIG_DATA = "red_pack_config_data";
    private String PK_THEME_RESOURCE = "pk_theme_resource";
    private String CustomMainDir = null;
    private String CustomImageDir = null;
    private String CustomUpdateDir = null;
    private String CustomHeadDir = null;
    private String CustomGiftsDir = null;
    private String CustomGiftResourcesDir = null;
    private String CustomGiftZipResourcesDir = null;
    private String CustomUGCCompressResourcesDir = null;
    private String CustomSplashsDir = null;
    private String CustomPrizeDir = null;
    private String CustomAnchorReportDir = null;
    private String CustomLevelResourcesDir = null;
    private String CustomLogDir = null;
    private String CustomPkThemeResourceDir = null;
    private String CustomReplayImDir = null;
    private String CustomImageDirName = null;
    private String CustomUpdateDirName = null;
    private String CustomHeadDirName = null;
    private String CustomGiftsDirName = null;
    private String CustomGiftResourcesDirName = null;
    private String CustomGiftZipResourcesDirName = null;
    private String CustomUGCCompressResourcesDirName = null;
    private String CustomSplashDirName = null;
    private String CustomPrizeDirName = null;
    private String CustomAnchorReportDirName = null;
    private String CustomLevelResourcesDirName = null;
    private String CustomFansWallDirName = null;
    private String CustomLogDirName = null;
    private String CustomPKThemeResource = null;

    private LFFilePathUtils() {
    }

    public static void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431772125")) {
            ipChange.ipc$dispatch("-431772125", new Object[0]);
            return;
        }
        try {
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("data", 0);
            openFileOutput.write("".getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized String getActiveMasterMedalJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "179697558")) {
                return (String) ipChange.ipc$dispatch("179697558", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), ACTIVE_MEDAL_FILE_NAME));
        }
    }

    public static synchronized String getAllMedalJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1079561119")) {
                return (String) ipChange.ipc$dispatch("1079561119", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), ALL_MEDAL_FILE_NAME));
        }
    }

    private static Context getApplicationContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1020423485") ? (Context) ipChange.ipc$dispatch("1020423485", new Object[0]) : AppContextUtils.getApp();
    }

    public static File getCameraPhotoFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190621040")) {
            return (File) ipChange.ipc$dispatch("-1190621040", new Object[0]);
        }
        File file = new File(getFansWallShowDirName());
        return new File(file, "lf_photo_" + System.currentTimeMillis() + ".jpg");
    }

    public static synchronized String getEnterEffectsJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-518921389")) {
                return (String) ipChange.ipc$dispatch("-518921389", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(EnterEffect_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), ENTER_EFFECTES_FILE_NAME));
        }
    }

    public static int getExifOrientation(String str) {
        int attributeInt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693535485")) {
            return ((Integer) ipChange.ipc$dispatch("-1693535485", new Object[]{str})).intValue();
        }
        ExifInterface exifInterface = null;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) == -1) {
            return 0;
        }
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt != 8) {
                    return 0;
                }
                return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
            }
            return 90;
        }
        return 180;
    }

    public static synchronized String getFansWallShowDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1099881237")) {
                return (String) ipChange.ipc$dispatch("-1099881237", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append(FANS_WALL_SHOW_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getGoldMasterMedalJsonDataFromSd() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "305045564")) {
                return (String) ipChange.ipc$dispatch("305045564", new Object[0]);
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(CustomMainDirName);
            sb.append(str);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), GOLD_MASTER_MEDAL_FILE_NAME));
        }
    }

    public static String getHistory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-245001842")) {
            return (String) ipChange.ipc$dispatch("-245001842", new Object[0]);
        }
        try {
            FileInputStream openFileInput = getApplicationContext().openFileInput("history");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static LFFilePathUtils getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227001971")) {
            return (LFFilePathUtils) ipChange.ipc$dispatch("-1227001971", new Object[0]);
        }
        if (mInstance == null) {
            synchronized (mMutex) {
                if (mInstance == null) {
                    mInstance = new LFFilePathUtils();
                }
            }
        }
        return mInstance;
    }

    private synchronized String getLevelResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978791349")) {
            return (String) ipChange.ipc$dispatch("-1978791349", new Object[]{this});
        }
        if (this.CustomLevelResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + LEVEL_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomLevelResourcesDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomLevelResourcesDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomLevelResourcesDir = path2;
        return path2;
    }

    private synchronized String getLogDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95490646")) {
            return (String) ipChange.ipc$dispatch("-95490646", new Object[]{this});
        }
        if (this.CustomLogDirName == null) {
            file = new File(getMainDirPath(), LAIFENG_LOG_DIR_NAME);
        } else {
            file = new File(getMainDirPath(), this.CustomLogDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomLogDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomLogDir = path2;
        return path2;
    }

    public static synchronized String getMedalSignDataFromSd(int i) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2012257110")) {
                return (String) ipChange.ipc$dispatch("-2012257110", new Object[]{Integer.valueOf(i)});
            }
            if (TextUtils.isEmpty(CustomMainDirName)) {
                CustomMainDirName = Site.LAIFENG_NEW;
            }
            String str = i == 1 ? GOLD_MASTER_MEDAL_SIGN_FILE_NAME : i == 2 ? ACTIVE_MEDAL_SIGN_FILE_NAME : ALL_MEDAL_SIGN_FILE_NAME;
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str2 = File.separator;
            sb.append(str2);
            sb.append(CustomMainDirName);
            sb.append(str2);
            sb.append(MEDAL_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return FileUtils.readFromFile(new File(file.getAbsolutePath(), str));
        }
    }

    public static final int getOrientationFromContentUri(ContentResolver contentResolver, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382965435")) {
            return ((Integer) ipChange.ipc$dispatch("1382965435", new Object[]{contentResolver, uri})).intValue();
        }
        if ("content".equals(uri.getScheme())) {
            Cursor query = contentResolver.query(uri, new String[]{"orientation"}, null, null, null);
            if (query != null) {
                int i = query.moveToFirst() ? query.getInt(query.getColumnIndexOrThrow("orientation")) : 0;
                query.close();
                return i;
            }
            return 0;
        } else if ("file".equals(uri.getScheme())) {
            return getExifOrientation(uri.getPath());
        } else {
            return 0;
        }
    }

    public static String getPath(Activity activity, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154397718")) {
            return (String) ipChange.ipc$dispatch("-154397718", new Object[]{activity, uri});
        }
        Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        activity.startManagingCursor(managedQuery);
        int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
        managedQuery.moveToFirst();
        String string = managedQuery.getString(columnIndexOrThrow);
        try {
            managedQuery.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }

    public static synchronized String getPraiseDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-178444970")) {
                return (String) ipChange.ipc$dispatch("-178444970", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append("praise");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getScreenShotDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1773317236")) {
                return (String) ipChange.ipc$dispatch("-1773317236", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append(SCREEN_SHOT_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getSignGoldDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493369675")) {
                return (String) ipChange.ipc$dispatch("-493369675", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append("download");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getSkinDirName() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1172773771")) {
                return (String) ipChange.ipc$dispatch("-1172773771", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append("skin");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    public static synchronized String getSopcastDirPath() {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1134682171")) {
                return (String) ipChange.ipc$dispatch("1134682171", new Object[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(PATH_SD_CARD);
            String str = File.separator;
            sb.append(str);
            sb.append(mSDParentPath);
            sb.append(str);
            sb.append(SOPCAST_DIR_NAME);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String loadAnchorReportJsonDataFromSd(java.lang.String r5, java.lang.String r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils.$ipChange
            java.lang.String r1 = "1463777848"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r6
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L1a:
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L28
            r0.mkdirs()
        L28:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            java.lang.String r1 = ""
            r5.<init>(r1)
            java.io.File r1 = new java.io.File
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "AnchorReport_"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.<init>(r0, r6)
            boolean r6 = r1.exists()
            if (r6 == 0) goto L90
            r6 = 0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
        L5f:
            java.lang.String r6 = r0.readLine()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L83
            if (r6 == 0) goto L69
            r5.append(r6)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L83
            goto L5f
        L69:
            r0.close()     // Catch: java.io.IOException -> L7e
            goto L90
        L6d:
            r6 = move-exception
            goto L75
        L6f:
            r5 = move-exception
            goto L85
        L71:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L75:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L90
            r0.close()     // Catch: java.io.IOException -> L7e
            goto L90
        L7e:
            r6 = move-exception
            r6.printStackTrace()
            goto L90
        L83:
            r5 = move-exception
            r6 = r0
        L85:
            if (r6 == 0) goto L8f
            r6.close()     // Catch: java.io.IOException -> L8b
            goto L8f
        L8b:
            r6 = move-exception
            r6.printStackTrace()
        L8f:
            throw r5
        L90:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils.loadAnchorReportJsonDataFromSd(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readAdvertJsonDataFromSd(java.lang.String r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils.$ipChange
            java.lang.String r1 = "-2095589315"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L17:
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 != 0) goto L25
            r0.mkdirs()
        L25:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            java.lang.String r1 = ""
            r5.<init>(r1)
            java.io.File r1 = new java.io.File
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r2 = "advert"
            r1.<init>(r0, r2)
            boolean r0 = r1.exists()
            if (r0 == 0) goto L7d
            r0 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
        L4d:
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L70
            if (r0 == 0) goto L57
            r5.append(r0)     // Catch: java.lang.Exception -> L5b java.lang.Throwable -> L70
            goto L4d
        L57:
            r2.close()     // Catch: java.io.IOException -> L6b
            goto L7d
        L5b:
            r0 = move-exception
            goto L62
        L5d:
            r5 = move-exception
            goto L72
        L5f:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L62:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L70
            if (r2 == 0) goto L7d
            r2.close()     // Catch: java.io.IOException -> L6b
            goto L7d
        L6b:
            r0 = move-exception
            r0.printStackTrace()
            goto L7d
        L70:
            r5 = move-exception
            r0 = r2
        L72:
            if (r0 == 0) goto L7c
            r0.close()     // Catch: java.io.IOException -> L78
            goto L7c
        L78:
            r0 = move-exception
            r0.printStackTrace()
        L7c:
            throw r5
        L7d:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils.readAdvertJsonDataFromSd(java.lang.String):java.lang.String");
    }

    public static String[] readData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447481185")) {
            return (String[]) ipChange.ipc$dispatch("-447481185", new Object[0]);
        }
        try {
            FileInputStream openFileInput = getApplicationContext().openFileInput("data");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return new String(byteArrayOutputStream.toByteArray()).split(",");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    private String[] readkey() {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Closeable closeable;
        ?? r0 = "key";
        IpChange ipChange = $ipChange;
        ?? r2 = "594003520";
        if (AndroidInstantRuntime.support(ipChange, "594003520")) {
            return (String[]) ipChange.ipc$dispatch("594003520", new Object[]{this});
        }
        String[] strArr = null;
        try {
            try {
                mLock.readLock().lock();
                if (getApplicationContext().getFileStreamPath("key").exists()) {
                    r0 = getApplicationContext().openFileInput("key");
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (IOException e) {
                        e = e;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        r2 = 0;
                        th = th2;
                        FileUtils.closeQuietly(r0);
                        FileUtils.closeQuietly(r2);
                        mLock.readLock().unlock();
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = r0.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        strArr = new String(byteArrayOutputStream.toByteArray()).split(",");
                        closeable = r0;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        FileUtils.closeQuietly(r0);
                        FileUtils.closeQuietly(byteArrayOutputStream);
                        mLock.readLock().unlock();
                        return null;
                    }
                } else {
                    closeable = null;
                    byteArrayOutputStream = null;
                }
                FileUtils.closeQuietly(closeable);
                FileUtils.closeQuietly(byteArrayOutputStream);
                mLock.readLock().unlock();
                return strArr;
            } catch (IOException e3) {
                e = e3;
                r0 = 0;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                r0 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static synchronized boolean saveActiveMedalJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "106170998")) {
                return ((Boolean) ipChange.ipc$dispatch("106170998", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), ACTIVE_MEDAL_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static boolean saveAdvertJsonDataToSd(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179851737")) {
            return ((Boolean) ipChange.ipc$dispatch("1179851737", new Object[]{str, str2})).booleanValue();
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getAbsolutePath(), SPLASH_SET_NAME), false);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(str2.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static synchronized boolean saveAllMedalJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1207426445")) {
                return ((Boolean) ipChange.ipc$dispatch("1207426445", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), ALL_MEDAL_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static boolean saveAnchorReportJsonDataToSd(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251429234")) {
            return ((Boolean) ipChange.ipc$dispatch("-1251429234", new Object[]{str, str2, str3})).booleanValue();
        }
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(absolutePath, "AnchorReport_" + str2), false);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(str3.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static synchronized boolean saveEnterEffectsJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1986600999")) {
                return ((Boolean) ipChange.ipc$dispatch("-1986600999", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(EnterEffect_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), ENTER_EFFECTES_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static synchronized boolean saveGoldMasterMedalJsonDataToSd(String str) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-856939438")) {
                return ((Boolean) ipChange.ipc$dispatch("-856939438", new Object[]{str})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), GOLD_MASTER_MEDAL_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static synchronized boolean saveMedalSignDataToSd(String str, int i) {
        synchronized (LFFilePathUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1848016208")) {
                return ((Boolean) ipChange.ipc$dispatch("1848016208", new Object[]{str, Integer.valueOf(i)})).booleanValue();
            } else if (TextUtils.isEmpty(str)) {
                return false;
            } else {
                if (TextUtils.isEmpty(CustomMainDirName)) {
                    CustomMainDirName = Site.LAIFENG_NEW;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(PATH_SD_CARD);
                String str2 = File.separator;
                sb.append(str2);
                sb.append(CustomMainDirName);
                sb.append(str2);
                sb.append(MEDAL_DIR_NAME);
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getAbsolutePath(), i == 1 ? GOLD_MASTER_MEDAL_SIGN_FILE_NAME : i == 2 ? ACTIVE_MEDAL_SIGN_FILE_NAME : ALL_MEDAL_SIGN_FILE_NAME);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                        return FileUtils.write2File(file2, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        }
    }

    public static void updateHistory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396453689")) {
            ipChange.ipc$dispatch("396453689", new Object[]{str});
            return;
        }
        try {
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("history", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void writeData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "825216419")) {
            ipChange.ipc$dispatch("825216419", new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21});
            return;
        }
        try {
            FileOutputStream openFileOutput = getApplicationContext().openFileOutput("data", 0);
            openFileOutput.write((str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6 + "," + str7 + "," + str8 + "," + str9 + "," + str10 + "," + str11 + "," + str12 + "," + str13 + "," + str14 + "," + str15 + "," + str16 + "," + str17 + "," + str18 + "," + str19 + "," + str20 + "," + str21).getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String UriToPath(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156262745")) {
            return (String) ipChange.ipc$dispatch("-156262745", new Object[]{this, uri});
        }
        Cursor query = getApplicationContext().getContentResolver().query(uri, null, null, null, null);
        String str = "";
        if (query != null) {
            query.moveToFirst();
            str = query.getString(1);
            query.close();
        }
        return str;
    }

    public synchronized void createSZLMFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511535056")) {
            ipChange.ipc$dispatch("-511535056", new Object[]{this});
            return;
        }
        try {
            new File(getMainDirPath() + File.separator + "szlm.txt").createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized String getAnchorReportDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168952893")) {
            return (String) ipChange.ipc$dispatch("-168952893", new Object[]{this});
        }
        if (this.CustomAnchorReportDirName == null) {
            file = new File(getMainDirPath() + File.separator + ANCHOR_REPORT_SET_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomAnchorReportDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomAnchorReportDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomAnchorReportDir = path2;
        return path2;
    }

    public synchronized String getAnchorlevelDirPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348633825")) {
            return (String) ipChange.ipc$dispatch("-1348633825", new Object[]{this});
        }
        File file = new File(getLevelResourcesDirPath() + File.separator + "AnchorLevel");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public synchronized String getClientInfoFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "474675569")) {
            return (String) ipChange.ipc$dispatch("474675569", new Object[]{this});
        }
        return "";
    }

    public String getCustomPrizeDir() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-38311576") ? (String) ipChange.ipc$dispatch("-38311576", new Object[]{this}) : this.CustomPrizeDir;
    }

    public String getCustomPrizeDirName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1058652653") ? (String) ipChange.ipc$dispatch("-1058652653", new Object[]{this}) : this.CustomPrizeDirName;
    }

    public String getCustomSplashDirName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1142250278") ? (String) ipChange.ipc$dispatch("-1142250278", new Object[]{this}) : this.CustomSplashDirName;
    }

    public String getCustomSplashsDir() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "179891406") ? (String) ipChange.ipc$dispatch("179891406", new Object[]{this}) : this.CustomSplashsDir;
    }

    public synchronized String getFansWallDirPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1904787778")) {
            return (String) ipChange.ipc$dispatch("1904787778", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_SD_CARD);
        String str = File.separator;
        sb.append(str);
        sb.append(mSDParentPath);
        sb.append(str);
        sb.append(FANS_WALL_DIR_NAME);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public synchronized String getGiftResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698713543")) {
            return (String) ipChange.ipc$dispatch("-698713543", new Object[]{this});
        }
        if (this.CustomGiftResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + GIFT_RESOURCES_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomGiftResourcesDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomGiftResourcesDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomGiftResourcesDir = path2;
        return path2;
    }

    public synchronized String getGiftZipResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39007320")) {
            return (String) ipChange.ipc$dispatch("39007320", new Object[]{this});
        }
        if (this.CustomGiftZipResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + GIFT_ZIP_RESOURCES_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomGiftZipResourcesDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomGiftZipResourcesDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomGiftZipResourcesDir = path2;
        return path2;
    }

    public synchronized String getGiftsDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646250997")) {
            return (String) ipChange.ipc$dispatch("-1646250997", new Object[]{this});
        }
        if (this.CustomGiftsDirName == null) {
            file = new File(getMainDirPath(), GIFTS_DIR_NAME);
        } else {
            file = new File(getMainDirPath(), this.CustomGiftsDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomGiftsDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomGiftsDir = path2;
        return path2;
    }

    public synchronized String getHeadDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388436276")) {
            return (String) ipChange.ipc$dispatch("-388436276", new Object[]{this});
        }
        if (this.CustomHeadDirName == null) {
            file = new File(getMainDirPath() + File.separator + HEAD_DIR_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomHeadDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomHeadDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomHeadDir = path2;
        return path2;
    }

    public synchronized String getImageDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173915405")) {
            return (String) ipChange.ipc$dispatch("-1173915405", new Object[]{this});
        }
        if (this.CustomImageDirName == null) {
            file = new File(getMainDirPath() + File.separator + "image");
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomImageDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomImageDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomImageDir = path2;
        return path2;
    }

    public synchronized String getLogFilePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704280545")) {
            return (String) ipChange.ipc$dispatch("-1704280545", new Object[]{this});
        }
        if (TextUtils.isEmpty(mLogFileName)) {
            String logDirPath = getLogDirPath();
            mLogFileName = new File(logDirPath, "log_" + System.currentTimeMillis() + ".txt").getAbsolutePath();
        }
        return mLogFileName;
    }

    public synchronized String getMainDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "22779731")) {
            return (String) ipChange.ipc$dispatch("22779731", new Object[]{this});
        }
        if (CustomMainDirName == null) {
            file = new File(PATH_SD_CARD + File.separator + mSDParentPath);
        } else {
            file = new File(PATH_SD_CARD + File.separator + CustomMainDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomMainDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomMainDir = path2;
        return path2;
    }

    public synchronized String getPkThemeresourcePath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708674341")) {
            return (String) ipChange.ipc$dispatch("-1708674341", new Object[]{this});
        }
        if (this.CustomPKThemeResource == null) {
            file = new File(getMainDirPath() + File.separator + this.PK_THEME_RESOURCE);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomPKThemeResource);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomPkThemeResourceDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomPkThemeResourceDir = path2;
        return path2;
    }

    public synchronized String getPrizeDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-231181348")) {
            return (String) ipChange.ipc$dispatch("-231181348", new Object[]{this});
        }
        if (this.CustomPrizeDirName == null) {
            file = new File(getMainDirPath() + File.separator + PRIZE_DIR_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomPrizeDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomPrizeDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomPrizeDir = path2;
        return path2;
    }

    public synchronized String getReplayFilesPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654504305")) {
            return (String) ipChange.ipc$dispatch("-654504305", new Object[]{this});
        }
        String str = REPLAY_IM_FILE_NAME;
        if (!TextUtils.isEmpty(this.CustomReplayImDir)) {
            str = this.CustomReplayImDir;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_SD_CARD);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(mSDParentPath);
        sb.append(str2);
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public String getSecretKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797906103")) {
            return (String) ipChange.ipc$dispatch("-797906103", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[0];
    }

    public synchronized String getSplashDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586660315")) {
            return (String) ipChange.ipc$dispatch("-586660315", new Object[]{this});
        }
        if (this.CustomSplashDirName == null) {
            file = new File(getMainDirPath() + File.separator + SPLASH_DIR_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomSplashDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomSplashsDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomSplashsDir = path2;
        return path2;
    }

    public String getThirdLoginType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-49188776")) {
            return (String) ipChange.ipc$dispatch("-49188776", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[2];
    }

    public String getToken() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875577907")) {
            return (String) ipChange.ipc$dispatch("875577907", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[1];
    }

    public synchronized String getUGCCompressResourcesDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156223642")) {
            return (String) ipChange.ipc$dispatch("1156223642", new Object[]{this});
        }
        if (this.CustomUGCCompressResourcesDirName == null) {
            file = new File(getMainDirPath() + File.separator + UGCCOMPRESS_RESOURCES_NAME);
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomUGCCompressResourcesDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomUGCCompressResourcesDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomUGCCompressResourcesDir = path2;
        return path2;
    }

    public synchronized String getUpdateDirPath() {
        File file;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008135037")) {
            return (String) ipChange.ipc$dispatch("-2008135037", new Object[]{this});
        }
        if (this.CustomUpdateDirName == null) {
            file = new File(getMainDirPath() + File.separator + "update");
        } else {
            file = new File(getMainDirPath() + File.separator + this.CustomUpdateDirName);
        }
        if (file.exists() && file.isDirectory()) {
            String path = file.getPath();
            this.CustomUpdateDir = path;
            return path;
        }
        file.mkdirs();
        String path2 = file.getPath();
        this.CustomUpdateDir = path2;
        return path2;
    }

    public synchronized String getUserlevelDirPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37292939")) {
            return (String) ipChange.ipc$dispatch("-37292939", new Object[]{this});
        }
        File file = new File(getLevelResourcesDirPath() + File.separator + "UserLevel");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public String getYKTK() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271505253")) {
            return (String) ipChange.ipc$dispatch("1271505253", new Object[]{this});
        }
        String[] readkey = readkey();
        return (readkey == null || readkey.length != 4) ? "" : readkey[3];
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r0.isDirectory() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isSZLMFileExist() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils.$ipChange     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "-1257035755"
            boolean r1 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)     // Catch: java.lang.Throwable -> L40
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1f
            java.lang.String r1 = "-1257035755"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L40
            r2[r3] = r5     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)     // Catch: java.lang.Throwable -> L40
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L40
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L40
            monitor-exit(r5)
            return r0
        L1f:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L40
            java.lang.String r1 = r5.getMainDirPath()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L40
            java.lang.String r4 = "szlm.txt"
            r0.<init>(r1, r4)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L40
            boolean r1 = r0.exists()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L40
            if (r1 == 0) goto L37
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L40
            if (r0 != 0) goto L37
            goto L38
        L37:
            r2 = 0
        L38:
            monitor-exit(r5)
            return r2
        L3a:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L40
            monitor-exit(r5)
            return r3
        L40:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.LFFilePathUtils.isSZLMFileExist():boolean");
    }

    public synchronized String readGiftConfigSign() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894900395")) {
            return (String) ipChange.ipc$dispatch("-894900395", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "GiftSign.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized String readGiftData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142308448")) {
            return (String) ipChange.ipc$dispatch("-142308448", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "GiftConfig.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized String readRedPackConfigSign() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031232985")) {
            return (String) ipChange.ipc$dispatch("1031232985", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "RedPackSign.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized String readRedPackData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778332964")) {
            return (String) ipChange.ipc$dispatch("1778332964", new Object[]{this});
        }
        String str = "";
        File file = new File(getGiftsDirPath() + File.separator + "RedPackConfig.json");
        if (file.exists()) {
            str = FileUtils.readFromFile(file);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return str;
    }

    public synchronized void saveGiftConfigSign(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081512338")) {
            ipChange.ipc$dispatch("-2081512338", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "GiftSign.json"), str);
    }

    public synchronized void saveGiftData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297528765")) {
            ipChange.ipc$dispatch("-1297528765", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "GiftConfig.json"), str);
    }

    public synchronized void saveRedPackConfigSign(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644928936")) {
            ipChange.ipc$dispatch("-644928936", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "RedPackSign.json"), str);
    }

    public synchronized void saveRedPackData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722008659")) {
            ipChange.ipc$dispatch("-722008659", new Object[]{this, str});
            return;
        }
        FileUtils.write2File(new File(getGiftsDirPath() + File.separator + "RedPackConfig.json"), str);
    }

    public void setCustomAnchorReportDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12109374")) {
            ipChange.ipc$dispatch("12109374", new Object[]{this, str});
        } else {
            this.CustomAnchorReportDirName = str;
        }
    }

    public void setCustomGiftsDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582013404")) {
            ipChange.ipc$dispatch("582013404", new Object[]{this, str});
        } else {
            this.CustomGiftsDirName = str;
        }
    }

    public void setCustomHeadDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700684117")) {
            ipChange.ipc$dispatch("1700684117", new Object[]{this, str});
        } else {
            this.CustomHeadDirName = str;
        }
    }

    public void setCustomImageDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955452428")) {
            ipChange.ipc$dispatch("-1955452428", new Object[]{this, str});
        } else {
            this.CustomImageDirName = str;
        }
    }

    public void setCustomLevelResourcesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493648522")) {
            ipChange.ipc$dispatch("-493648522", new Object[]{this, str});
        } else {
            this.CustomLevelResourcesDirName = str;
        }
    }

    public void setCustomMainDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563478446")) {
            ipChange.ipc$dispatch("1563478446", new Object[]{this, str});
        } else {
            CustomMainDirName = str;
        }
    }

    public void setCustomPrizeDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304765578")) {
            ipChange.ipc$dispatch("-304765578", new Object[]{this, str});
        } else {
            this.CustomPrizeDir = str;
        }
    }

    public void setCustomPrizeDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499499563")) {
            ipChange.ipc$dispatch("1499499563", new Object[]{this, str});
        } else {
            this.CustomPrizeDirName = str;
        }
    }

    public void setCustomReplayFilesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752595561")) {
            ipChange.ipc$dispatch("1752595561", new Object[]{this, str});
        } else {
            this.CustomReplayImDir = str;
        }
    }

    public void setCustomSplashDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624669148")) {
            ipChange.ipc$dispatch("624669148", new Object[]{this, str});
        } else {
            this.CustomSplashDirName = str;
        }
    }

    public void setCustomSplashsDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109871568")) {
            ipChange.ipc$dispatch("109871568", new Object[]{this, str});
        } else {
            this.CustomSplashsDir = str;
        }
    }

    public void setCustomUpdateDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491374274")) {
            ipChange.ipc$dispatch("-491374274", new Object[]{this, str});
        } else {
            this.CustomUpdateDirName = str;
        }
    }

    public void setGiftResourcesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427642143")) {
            ipChange.ipc$dispatch("427642143", new Object[]{this, str});
        } else {
            this.CustomGiftResourcesDirName = str;
        }
    }

    public void setGiftZipResourcesDirName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884952712")) {
            ipChange.ipc$dispatch("-884952712", new Object[]{this, str});
        } else {
            this.CustomGiftZipResourcesDirName = str;
        }
    }

    public void writekey(String str, String str2, String str3, int i) {
        Lock writeLock;
        IpChange ipChange = $ipChange;
        try {
            if (AndroidInstantRuntime.support(ipChange, "1172102101")) {
                ipChange.ipc$dispatch("1172102101", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
                return;
            }
            try {
                ReadWriteLock readWriteLock = mLock;
                readWriteLock.writeLock().lock();
                FileOutputStream openFileOutput = getApplicationContext().openFileOutput("key", 0);
                str3 = (str3 == null || str3.isEmpty()) ? "" : "";
                openFileOutput.write((str + "," + str2 + "," + i + "," + str3).getBytes());
                openFileOutput.close();
                writeLock = readWriteLock.writeLock();
            } catch (IOException e) {
                e.printStackTrace();
                writeLock = mLock.writeLock();
            }
            writeLock.unlock();
        } catch (Throwable th) {
            mLock.writeLock().unlock();
            throw th;
        }
    }
}
