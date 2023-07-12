package android.taobao.windvane.extra.core;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.extra.uc.WVCoreSettings;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.file.NotEnoughSpace;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.CoreEventCallback;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import androidx.annotation.Nullable;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVCore {
    public static final int DOWNLOAD = 0;
    public static final int INNER_ASSET = 2;
    public static final int INNER_LIB = 1;
    public static final String TAG = "WVCore";
    private static WVCore instance;
    private CoreDownLoadBack coreDownLoadBack;
    private boolean open4GDownload = false;
    private int usedWebMulti = 0;
    private int usedGpuMulti = 0;
    private boolean shouldDownload = true;
    private boolean isUCSDKSupport = false;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface CoreDownLoadBack {
        void initError();

        void progress(int i);
    }

    private boolean checkRemoteIsolateOpen() {
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        return (Arrays.asList(wVCommonConfigData.brandBlacks).contains(Build.getBRAND()) || Arrays.asList(wVCommonConfigData.modelBlacks).contains(Build.getMODEL()) || Arrays.asList(wVCommonConfigData.systemBlacks).contains(Build.VERSION.getRELEASE())) ? false : true;
    }

    public static WVCore getInstance() {
        if (instance == null) {
            synchronized (WVCore.class) {
                if (instance == null) {
                    instance = new WVCore();
                }
            }
        }
        return instance;
    }

    private String getUcSoPath(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    String ucSoPath = getUcSoPath(file.getPath());
                    if (ucSoPath.endsWith("libwebviewuc.so")) {
                        return ucSoPath;
                    }
                } else if (file.getName().endsWith("libwebviewuc.so")) {
                    return file.getPath();
                }
            }
            return "";
        }
        return "";
    }

    public boolean checkIsolateIfOpen(Context context) {
        String str;
        boolean z;
        boolean checkRemoteIsolateOpen = checkRemoteIsolateOpen();
        File createFolder = FileManager.createFolder(context, "UCPolicy");
        byte[] read = FileAccesser.read(createFolder.getPath() + File.separator + "isolate");
        if (read != null) {
            try {
                str = new String(read, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split.length == 2) {
                    if (System.currentTimeMillis() - Long.valueOf(split[1]).longValue() > WVCommonConfig.commonConfig.recoverMultiInterval) {
                        updateIsolatePolicy(context, true);
                    }
                    z = false;
                    String str2 = TAG;
                    TaoLog.e(str2, "isolate policy: remote=[" + checkRemoteIsolateOpen + "], local=[" + z + jn1.ARRAY_END_STR);
                    return checkRemoteIsolateOpen && z;
                }
            }
        }
        z = true;
        String str22 = TAG;
        TaoLog.e(str22, "isolate policy: remote=[" + checkRemoteIsolateOpen + "], local=[" + z + jn1.ARRAY_END_STR);
        if (checkRemoteIsolateOpen) {
            return false;
        }
    }

    public CoreDownLoadBack getCoreDownLoadBack() {
        return this.coreDownLoadBack;
    }

    public int getUsedGpuMulti() {
        return this.usedGpuMulti;
    }

    public int getUsedWebMulti() {
        return this.usedWebMulti;
    }

    public String getV8SoPath() {
        int i = WVUCWebView.INNER_FLAG;
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            Application application = GlobalConfig.context;
            sb.append(UCCore.getExtractDirPath(application, GlobalConfig.context.getApplicationInfo().nativeLibraryDir + "/libkernelu4_7z_uc.so"));
            sb.append("/lib/libwebviewuc.so");
            String sb2 = sb.toString();
            String str = TAG;
            TaoLog.i(str, "get v8 path by inner lib so, path=[" + sb2 + jn1.ARRAY_END_STR);
            return sb2;
        } else if (i != 2) {
            String ucSoPath = getUcSoPath(UCCore.getExtractDirPathByUrl(GlobalConfig.context, WVUCWebView.UC_CORE_URL));
            String str2 = TAG;
            TaoLog.i(str2, "get v8 path by download so, path=[" + ucSoPath + jn1.ARRAY_END_STR);
            return ucSoPath;
        } else {
            String ucSoPath2 = getUcSoPath(GlobalConfig.getInstance().getUcLibDir());
            String str3 = TAG;
            TaoLog.i(str3, "get v8 path by inner asset so, path=[" + ucSoPath2 + jn1.ARRAY_END_STR);
            return ucSoPath2;
        }
    }

    public void initUCCore(Context context, String[] strArr, @Nullable String str, @Nullable CoreEventCallback coreEventCallback) {
        if (context instanceof Application) {
            GlobalConfig.context = (Application) context;
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                GlobalConfig.getInstance().setUc7ZPath(str);
            }
            if (coreEventCallback != null) {
                WVCoreSettings.getInstance().setCoreEventCallback(coreEventCallback);
            }
            if (strArr != null) {
                GlobalConfig.getInstance().setUcsdkappkeySec(strArr);
            }
            WVUCWebView.initUCCore(context);
            return;
        }
        new AndroidRuntimeException("cannot init uccore for context is not application").printStackTrace();
    }

    public boolean isOpen4GDownload() {
        return this.open4GDownload || GlobalConfig.getInstance().isOpen4GDownload();
    }

    public boolean isShouldDownload() {
        return this.shouldDownload;
    }

    public boolean isUCSupport() {
        return this.isUCSDKSupport && WebView.getCoreType() == 3;
    }

    public void setCoreDownLoadBack(CoreDownLoadBack coreDownLoadBack) {
        this.coreDownLoadBack = coreDownLoadBack;
    }

    public void setOpen4GDownload(boolean z) {
        this.open4GDownload = z;
    }

    public void setShouldDownload(boolean z) {
        this.shouldDownload = z;
    }

    public void setUCSupport(boolean z) {
        this.isUCSDKSupport = z;
    }

    public void setUsedGpuMulti(int i) {
        this.usedGpuMulti = i;
    }

    public void setUsedWebMulti(int i) {
        this.usedWebMulti = i;
    }

    public void startDownload() {
        UCCore.startDownload();
    }

    public void updateIsolatePolicy(Context context, boolean z) {
        String str;
        File createFolder = FileManager.createFolder(context, "UCPolicy");
        try {
            String str2 = createFolder.getPath() + File.separator + "isolate";
            if (z) {
                str = "";
            } else {
                str = "false," + System.currentTimeMillis();
            }
            FileAccesser.write(str2, ByteBuffer.wrap(str.getBytes()));
        } catch (NotEnoughSpace e) {
            e.printStackTrace();
        }
    }
}
