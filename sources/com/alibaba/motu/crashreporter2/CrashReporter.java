package com.alibaba.motu.crashreporter2;

import android.content.Context;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.motu.crashreporter.ICrashReportSendListener;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.alibaba.motu.crashreporter.Propertys;
import com.alibaba.motu.crashreporter.ReporterContext;
import com.alibaba.motu.crashreporter.async.AsyncThreadPool;
import com.alibaba.motu.crashreporter2.CatcherManager;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class CrashReporter {
    static final CrashReporter INSTANCE = new CrashReporter();
    public static final String _BUILD = "";
    public static final String _JAVA_VERSION = "";
    public static final String _MAGIC = "CrashSDK";
    public static final String _NATIVE_VERSION = "160509105620";
    public static final String _TARGET = "beta";
    public static final String _VERSION = "3.3.0.0";
    CatcherManager mCatcherManager;
    Configuration mConfiguration;
    Context mContext;
    LabFeatureManager mLabFeatureManager;
    public String mProcessName;
    ReportBuilder mReportBuilder;
    ReporterContext mReporterContext;
    RunningStateMonitor mRunningStateMonitor;
    SendManager mSendManager;
    StorageManager mStorageManager;
    AtomicBoolean initing = new AtomicBoolean(false);
    volatile boolean initSuccess = false;
    AtomicBoolean changing = new AtomicBoolean(false);
    volatile boolean enabled = false;
    AtomicBoolean scaning = new AtomicBoolean(false);
    AtomicBoolean sending = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class DefaultStartupStateAnalyzeCallback {
        DefaultStartupStateAnalyzeCallback() {
        }

        public void onComplete(int i) {
            int i2 = i & 1;
            int i3 = i & 16;
            if (i2 == 1 && i3 == 16) {
                if (!Utils.isServiceProcess(CrashReporter.this.mProcessName).booleanValue()) {
                    CrashReporter crashReporter = CrashReporter.this;
                    if (Utils.isUIProcess(crashReporter.mContext, crashReporter.mProcessName).booleanValue()) {
                        if (!AppUtils.isBackgroundRunning(CrashReporter.this.mContext).booleanValue() && !CrashReporter.this.mConfiguration.getBoolean(Configuration.enableUIProcessSafeGuard, false)) {
                            Utils.stopService(CrashReporter.this.mContext);
                            return;
                        }
                        throw new RuntimeException("ui process name:" + CrashReporter.this.mProcessName + " launching too fast and too many");
                    }
                    return;
                }
                throw new RuntimeException("service process name:" + CrashReporter.this.mProcessName + " launching too fast and too many");
            }
        }
    }

    private CrashReporter() {
    }

    public static CrashReporter getInstance() {
        return INSTANCE;
    }

    public void addNativeHeaderInfo(String str, String str2) {
        if (this.initSuccess && StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str2)) {
            this.mCatcherManager.addNativeHeaderInfo(str, str2);
        }
    }

    public void addSendLinster(ICrashReportSendListener iCrashReportSendListener) {
        if (this.initSuccess) {
            this.mSendManager.addListener(iCrashReportSendListener);
        }
    }

    public void addUncaughtExceptionLinster(CatcherManager.UncaughtExceptionLinster uncaughtExceptionLinster) {
        if (this.initSuccess) {
            this.mCatcherManager.addUncaughtExceptionLinster(uncaughtExceptionLinster);
        }
    }

    public void closeNativeSignalTerm() {
        if (this.initSuccess) {
            this.mCatcherManager.closeNativeSignalTerm();
        }
    }

    public void disable() {
        if (this.initSuccess && this.enabled) {
            if (this.changing.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mCatcherManager.disable();
                    this.mLabFeatureManager.disable();
                    this.enabled = false;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    LogUtil.d("CrashSDK disable complete elapsed time:" + (currentTimeMillis2 - currentTimeMillis) + "ms.");
                } finally {
                    this.changing.set(false);
                }
            }
        }
    }

    public void enable() {
        if (!this.initSuccess || this.enabled) {
            return;
        }
        if (this.changing.compareAndSet(false, true)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.mCatcherManager.enable();
                this.mLabFeatureManager.enable();
                this.enabled = true;
                long currentTimeMillis2 = System.currentTimeMillis();
                LogUtil.d("CrashSDK enable complete elapsed time:" + (currentTimeMillis2 - currentTimeMillis) + "ms.");
            } finally {
                this.changing.set(false);
            }
        }
    }

    public List<CatcherManager.UncaughtExceptionLinster> getAllUncaughtExceptionLinster() {
        if (this.initSuccess) {
            return this.mCatcherManager.getAllUncaughtExceptionLinster();
        }
        return null;
    }

    public String getProperty(String str) {
        if (this.initSuccess) {
            return this.mReporterContext.getProperty(str);
        }
        return null;
    }

    public String getPropertyAndSet(String str) {
        if (this.initSuccess) {
            return this.mReporterContext.getPropertyAndSet(str);
        }
        return null;
    }

    public void initialize(Context context, String str, String str2, String str3, String str4, Configuration configuration) {
        long currentTimeMillis;
        if (this.initing.compareAndSet(false, true)) {
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e) {
                LogUtil.e("initialize", e);
            }
            if (context != null) {
                if (!StringUtils.isBlank(str)) {
                    if (!StringUtils.isBlank(str2)) {
                        Context applicationContext = context.getApplicationContext();
                        this.mContext = applicationContext;
                        if (applicationContext == null) {
                            this.mContext = context;
                        }
                        if (configuration == null) {
                            this.mConfiguration = Configuration.getInstance();
                        } else {
                            this.mConfiguration = configuration;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ReporterContext reporterContext = new ReporterContext(this.mContext);
                        this.mReporterContext = reporterContext;
                        reporterContext.setProperty(new Propertys.Property(Constants.STARTUP_TIME, String.valueOf(currentTimeMillis)));
                        this.mReporterContext.setProperty(new Propertys.Property(Constants.APP_ID, str, true));
                        this.mReporterContext.setProperty(new Propertys.Property(Constants.APP_KEY, str2, true));
                        this.mReporterContext.setProperty(new Propertys.Property(Constants.APP_VERSION, StringUtils.defaultString(str3, "DEFAULT")));
                        this.mReporterContext.setProperty(new Propertys.Property(Constants.CHANNEL, str4, true));
                        String myProcessNameByCmdline = AppUtils.getMyProcessNameByCmdline();
                        this.mProcessName = myProcessNameByCmdline;
                        if (StringUtils.isBlank(myProcessNameByCmdline)) {
                            this.mProcessName = AppUtils.getMyProcessNameByAppProcessInfo(context);
                        }
                        String defaultString = StringUtils.defaultString(this.mProcessName, "DEFAULT");
                        this.mProcessName = defaultString;
                        this.mReporterContext.setProperty(new Propertys.Property("PROCESS_NAME", defaultString, true));
                        LogUtil.d("CrashSDK ReporterContext initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
                        long currentTimeMillis3 = System.currentTimeMillis();
                        this.mStorageManager = new StorageManager(context, this.mProcessName);
                        LogUtil.d("CrashSDK StorageManager initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
                        long currentTimeMillis4 = System.currentTimeMillis();
                        this.mReportBuilder = new ReportBuilder(this.mContext, this.mReporterContext, this.mConfiguration, this.mStorageManager);
                        LogUtil.d("CrashSDK ReportBuilder initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis4) + "ms.");
                        long currentTimeMillis5 = System.currentTimeMillis();
                        this.mSendManager = new SendManager(this.mContext, this.mReporterContext, this.mConfiguration, this.mReportBuilder);
                        LogUtil.d("CrashSDK SendManager initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis5) + "ms.");
                        long currentTimeMillis6 = System.currentTimeMillis();
                        this.mRunningStateMonitor = new RunningStateMonitor(context, str, str2, str3, this.mProcessName, currentTimeMillis, this.mStorageManager, new DefaultStartupStateAnalyzeCallback());
                        AsyncThreadPool asyncThreadPool = MotuCrashReporter.getInstance().asyncTaskThread;
                        AsyncThreadPool.start(this.mRunningStateMonitor);
                        LogUtil.d("CrashSDK RunningStateMonitor initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis6) + "ms.");
                        long currentTimeMillis7 = System.currentTimeMillis();
                        this.mCatcherManager = new CatcherManager(context, this.mProcessName, this.mReporterContext, this.mConfiguration, this.mStorageManager, this.mReportBuilder, this.mSendManager);
                        LogUtil.d("CrashSDK CatcherManager initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis7) + "ms.");
                        long currentTimeMillis8 = System.currentTimeMillis();
                        this.mLabFeatureManager = new LabFeatureManager(this.mContext, this.mConfiguration, this.mCatcherManager);
                        LogUtil.d("CrashSDK LabFeatureManager initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis8) + "ms.");
                        LogUtil.d("CrashSDK initialize complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                        this.initSuccess = true;
                        long currentTimeMillis9 = System.currentTimeMillis();
                        scanAll();
                        sendAll();
                        LogUtil.d("CrashSDK doBefore complete elapsed time:" + (System.currentTimeMillis() - currentTimeMillis9) + "ms.");
                        return;
                    }
                    throw new IllegalArgumentException("appKey");
                }
                throw new IllegalArgumentException("appId can't empty");
            }
            throw new NullPointerException(WPKFactory.INIT_KEY_CONTEXT);
        }
    }

    public void refreshAppVersion(String str) {
        if (this.initSuccess && StringUtils.isNotBlank(str)) {
            setProperty(new Propertys.Property(Constants.APP_VERSION, str));
            this.mCatcherManager.refreshNativeInfo();
        }
    }

    public void refreshCountry(String str) {
        if (this.initSuccess && StringUtils.isNotBlank(str)) {
            setProperty(new Propertys.Property(Constants.COUNTRY, str));
        }
    }

    public void registerLifeCallbacks(Context context) {
        this.mCatcherManager.registerLifeCallbacks(context);
    }

    public void removeSendLinster(ICrashReportSendListener iCrashReportSendListener) {
        if (this.initSuccess) {
            this.mSendManager.removeListener(iCrashReportSendListener);
        }
    }

    public void scanAll() {
        if (this.initSuccess) {
            if (this.scaning.compareAndSet(false, true)) {
                try {
                    try {
                        this.mCatcherManager.doScan();
                    } catch (Exception e) {
                        LogUtil.e("scan all", e);
                    }
                } finally {
                    this.scaning.set(false);
                }
            }
        }
    }

    public void sendAll() {
        if (this.initSuccess) {
            if (this.sending.compareAndSet(false, true)) {
                try {
                    try {
                        this.mSendManager.sendAllReport();
                    } catch (Exception e) {
                        LogUtil.e("send all", e);
                    }
                } finally {
                    this.sending.set(false);
                }
            }
        }
    }

    public void setProperty(Propertys.Property property) {
        if (this.initSuccess) {
            this.mReporterContext.setProperty(property);
        }
    }
}
