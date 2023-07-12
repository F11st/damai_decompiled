package android.taobao.windvane.extra.uc;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UCCoreStartup {
    private static final boolean ENABLE_ANDROID_LOG = false;
    private static final boolean ENABLE_PREPROCESS = true;
    private static final String TAG = "UCCoreStartup";
    private static final AtomicBoolean sPreprocessAtomic = new AtomicBoolean(false);
    private static UCCoreStartup sUCCoreStartup;

    private void asyncPreprocess() {
        WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.extra.uc.UCCoreStartup.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UCCoreStartup.printAndroidLogE("asyncPreprocess");
                    UCCore.preInitCore(10, GlobalConfig.context, null);
                } catch (Throwable th) {
                    TaoLog.e(UCCoreStartup.TAG, "asyncPreprocess fail " + th.getMessage());
                }
            }
        });
    }

    public static UCCoreStartup getInstance() {
        if (sUCCoreStartup == null) {
            synchronized (WVThreadPool.class) {
                if (sUCCoreStartup == null) {
                    printAndroidLogE("UCCoreStartup instance enable preprocess true");
                    sUCCoreStartup = new UCCoreStartup();
                }
            }
        }
        return sUCCoreStartup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printAndroidLogE(String str) {
        TaoLog.e(TAG, str);
    }

    public static void statsPrint(String str) {
    }

    public static void statsRecordTime(int i) {
    }

    public static void statsStart() {
    }

    public static String ucCore7ZFilePath(Context context) {
        return ucCore7ZFilePath(context.getApplicationInfo().nativeLibraryDir);
    }

    public static String ucCoreRootDirPath(Context context, String str) {
        return UCCore.getExtractDirPath(context, ucCore7ZFilePath(str));
    }

    public static String ucCoreSoDirPath(Context context) {
        return ucCoreSoDirPath(context, context.getApplicationInfo().nativeLibraryDir);
    }

    public void initPreprocess() {
        if (sPreprocessAtomic.compareAndSet(false, true)) {
            try {
                asyncPreprocess();
            } catch (Throwable th) {
                TaoLog.e(TAG, "initPreprocess fail " + th.getMessage());
            }
        }
    }

    public void preDecompress(Context context, String str) {
        printAndroidLogE("preDecompress " + context + AVFSCacheConstants.COMMA_SEP + str);
    }

    public void preInitUCCore(Context context, String str) {
        printAndroidLogE("preInitUCCore " + context + AVFSCacheConstants.COMMA_SEP + str);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TaoLog.i(TAG, "trying to init uc core");
            if (GlobalConfig.context == null && (context instanceof Application)) {
                GlobalConfig.context = (Application) context;
            }
            WVCommonConfig.getInstance().init();
            Class.forName("android.taobao.windvane.extra.uc.WVUCWebView");
        } catch (Throwable th) {
            TaoLog.e(TAG, "failed to load WVUCWebView " + th.getMessage());
        }
        printAndroidLogE("initU4Core elapse: " + Long.toString(System.currentTimeMillis() - currentTimeMillis));
    }

    public void preloadClass(ClassLoader classLoader) {
        printAndroidLogE("preloadClass " + classLoader);
        try {
            UCCore.preInitCore(2, GlobalConfig.context, null);
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadClass fail " + th.getMessage());
        }
    }

    public void preloadIcu(Context context, String str) {
        printAndroidLogE("preloadIcu " + context + AVFSCacheConstants.COMMA_SEP + str);
        try {
            UCCore.preInitCore(9, context, new Object[]{ucCoreRootDirPath(context, str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadIcu fail " + th.getMessage());
        }
    }

    public void preloadIo(Context context, String str) {
        printAndroidLogE("preloadIo " + context + AVFSCacheConstants.COMMA_SEP + str);
        try {
            UCCore.preInitCore(1, context, new Object[]{ucCore7ZFilePath(str)});
            UCCore.preInitCore(6, context, new Object[]{ucCore7ZFilePath(str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadIo fail " + th.getMessage());
        }
    }

    public void preloadPak(Context context, String str) {
        printAndroidLogE("preloadPak " + context + AVFSCacheConstants.COMMA_SEP + str);
        try {
            UCCore.preInitCore(8, context, new Object[]{ucCoreRootDirPath(context, str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadPak fail " + th.getMessage());
        }
    }

    public void preloadSo(Context context, String str) {
        printAndroidLogE("preloadSo " + context + AVFSCacheConstants.COMMA_SEP + str);
        StringBuilder sb = new StringBuilder();
        sb.append("preloadSo inject: ");
        sb.append(GlobalConfig.getInstance().getInjectCode());
        printAndroidLogE(sb.toString());
        try {
            UCCore.preInitCore(5, context, new Object[]{ucCoreRootDirPath(context, str)});
        } catch (Throwable th) {
            TaoLog.e(TAG, "preloadSo fail " + th.getMessage());
        }
    }

    public static String ucCore7ZFilePath(String str) {
        return new File(str, "libkernelu4_7z_uc.so").getAbsolutePath();
    }

    public static String ucCoreSoDirPath(Context context, String str) {
        return new File(UCCore.getExtractDirPath(context, ucCore7ZFilePath(str)), SolidMonitor.CHECK_TYPE_LIB).getAbsolutePath();
    }
}
