package com.taobao.tao.log;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.TLogSecret;
import com.taobao.tao.log.godeye.GodeyeConfig;
import com.taobao.tao.log.godeye.GodeyeInitializer;
import com.taobao.tao.log.message.MessageInfo;
import com.taobao.tao.log.message.MessageSender;
import com.taobao.tao.log.monitor.DefaultTLogMonitorImpl;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.statistics.DefaultTLogStatistics;
import com.taobao.tao.log.statistics.ITLogStatistics;
import com.taobao.tao.log.statistics.TLogStatisticsManager;
import com.taobao.tao.log.task.CommandManager;
import com.taobao.tao.log.task.HeapDumpReplyTask;
import com.taobao.tao.log.task.MethodTraceReplyTask;
import com.taobao.tao.log.task.PullTask;
import com.taobao.tao.log.task.StartUpRequestTask;
import com.taobao.tao.log.upload.LogUploader;
import com.taobao.tao.log.uploader.service.TLogFileUploader;
import com.taobao.tao.log.utils.TLogFileObserver;
import com.taobao.tao.log.utils.TLogMultiProcessTool;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogInitializer {
    public static final int INIT_END = 2;
    public static final int INIT_ING = 1;
    public static final int INIT_NO = 0;
    private static final String NAMEPREFIX = "TAOBAO";
    private static final String TAG = "TLOG";
    public static final String TLOG_DIR = "tlog_v";
    public String accsServiceId;
    public String accsTag;
    private String appId;
    private String appVersion;
    private String appkey;
    private Application application;
    private String authCode;
    private Context context;
    private boolean debugByUsr;
    private TLogFileObserver fileObserver;
    private int fileSizeRate;
    public Map<String, TLogFileUploader> fileUploaderMap;
    private ITLogStatistics iTLogStatistics;
    private boolean isDebug;
    private boolean isVersionUpdate;
    public File logDir;
    private LogLevel logLevel;
    private long logMaxSize;
    private LogUploader logUploader;
    private volatile int mInitState;
    private boolean mInitSync;
    private OnTrackTLogListener mOnTrackTLogListener;
    private String mRandomSecret;
    public String messageHostName;
    private MessageSender messageSender;
    private String namePrefix;
    public String ossBucketName;
    private String packageName;
    private String processName;
    private boolean storeLogOnInternal;
    private TLogMonitor tLogMonitor;
    private long tlogBuffersize;
    private int tlogFileVersion;
    private boolean tlogScanUpload;
    private String ttid;
    private boolean useZstd;
    private String userNick;
    private int utConfigRate;
    private String utdid;
    private int zstdLevel;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SingletonHolder {
        private static final TLogInitializer INSTANCE = new TLogInitializer();

        private SingletonHolder() {
        }
    }

    public static TLogInitializer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static ITLogController getTLogControler() {
        return TLogController.getInstance();
    }

    public static String getUTDID() {
        return getInstance().utdid;
    }

    private void godeyeInit() {
        GodeyeInitializer.getInstance().registGodEyeReponse(OpCode.METHOD_TRACE_DUMP, new MethodTraceReplyTask());
        GodeyeInitializer.getInstance().registGodEyeReponse(OpCode.HEAP_DUMP, new HeapDumpReplyTask());
        GodeyeConfig godeyeConfig = new GodeyeConfig();
        godeyeConfig.appVersion = getInstance().getAppVersion();
        godeyeConfig.packageTag = null;
        godeyeConfig.utdid = getUTDID();
        godeyeConfig.appId = getInstance().getAppId();
        godeyeConfig.processName = getInstance().getProcessName();
        if (getInstance().getApplication() != null) {
            GodeyeInitializer.getInstance().init(getInstance().getApplication(), godeyeConfig);
        }
    }

    private boolean isAPKDebug(Context context) {
        if (this.debugByUsr) {
            return this.isDebug;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @TargetApi(8)
    public TLogInitializer builder(Context context, LogLevel logLevel, String str, String str2, String str3, String str4) {
        if (this.mInitState != 0) {
            return this;
        }
        this.isDebug = isAPKDebug(context);
        this.logLevel = logLevel;
        this.context = context;
        this.appkey = str3;
        this.appVersion = str4;
        if (TextUtils.isEmpty(str2)) {
            str2 = NAMEPREFIX;
        }
        this.namePrefix = str2;
        this.namePrefix = str2.replaceAll("[:*?<>|\"\\\\/]", "-");
        if (this.storeLogOnInternal) {
            this.logDir = context.getDir("tlog_v9", 0);
        } else {
            File file = null;
            try {
                file = context.getExternalFilesDir("tlog_v9");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (file == null) {
                file = context.getDir("tlog_v9", 0);
            }
            this.logDir = file;
        }
        return this;
    }

    public TLogInitializer changeRsaPublishKey(String str) {
        if (str != null) {
            TLogSecret.getInstance().setRsapublickey(str);
        }
        return this;
    }

    public TLogInitializer enableZstd(boolean z) {
        this.useZstd = z;
        return this;
    }

    public String getAppId() {
        if (this.appId == null) {
            this.appId = this.appkey + "@android";
        }
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public Application getApplication() {
        return this.application;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public long getBuffersize() {
        return this.tlogBuffersize;
    }

    public Context getContext() {
        return this.context;
    }

    public String getFileDir() {
        return this.logDir.getAbsolutePath();
    }

    public int getInitState() {
        return this.mInitState;
    }

    public String getLogCacheDir(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + TLOG_DIR + this.tlogFileVersion;
    }

    public long getLogMaxSize() {
        return this.logMaxSize;
    }

    public LogUploader getLogUploader() {
        return this.logUploader;
    }

    public MessageSender getMessageSender() {
        return this.messageSender;
    }

    public String getNameprefix() {
        return this.namePrefix;
    }

    public OnTrackTLogListener getOnTrackTLogListener() {
        return this.mOnTrackTLogListener;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getSecurityKey() {
        return this.mRandomSecret;
    }

    public int getTLogFileVersion() {
        return this.tlogFileVersion;
    }

    public ITLogStatistics getTLogStatistics() {
        if (this.iTLogStatistics == null) {
            this.iTLogStatistics = new DefaultTLogStatistics();
        }
        return this.iTLogStatistics;
    }

    public String getTtid() {
        return this.ttid;
    }

    public String getUserNick() {
        return this.userNick;
    }

    public int getZstdLevel() {
        return this.zstdLevel;
    }

    public TLogMonitor gettLogMonitor() {
        if (this.tLogMonitor == null) {
            this.tLogMonitor = new DefaultTLogMonitorImpl();
        }
        return this.tLogMonitor;
    }

    public TLogInitializer init() {
        if (this.mInitState != 0) {
            return this;
        }
        this.mInitState = 1;
        try {
            TLogMultiProcessTool.registerMultiProcessReceiver(this.context);
            TLogFileObserver tLogFileObserver = new TLogFileObserver(this.logDir.getAbsolutePath());
            this.fileObserver = tLogFileObserver;
            tLogFileObserver.startWatching();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            if (defaultSharedPreferences.contains(TLogConstant.REMOTE_DEBUGER_LOG_VERSION)) {
                String string = defaultSharedPreferences.getString(TLogConstant.REMOTE_DEBUGER_LOG_VERSION, null);
                if (string != null && string.equals(this.appVersion)) {
                    this.isVersionUpdate = false;
                } else {
                    this.isVersionUpdate = true;
                }
            } else {
                this.isVersionUpdate = true;
            }
            if (defaultSharedPreferences.contains(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL) && !this.isVersionUpdate) {
                this.logLevel = TLogUtils.convertLogLevel(defaultSharedPreferences.getString(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL, "ERROR"));
                TLogController.getInstance().updateLogLevel(this.logLevel);
            }
            if (defaultSharedPreferences.contains(TLogConstant.REMOTE_DEBUGER_LOG_MODULE) && !this.isVersionUpdate) {
                TLogController.getInstance().addModuleFilter(TLogUtils.makeModule(defaultSharedPreferences.getString(TLogConstant.REMOTE_DEBUGER_LOG_MODULE, null)));
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_IS_DEBUG)) {
                this.isDebug = defaultSharedPreferences.getBoolean(TLogConstant.TLOG_IS_DEBUG, false);
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_CONFIG_LOG_FILE_SIZE)) {
                long j = defaultSharedPreferences.getLong(TLogConstant.TLOG_CONFIG_LOG_FILE_SIZE, 52428800L);
                if (j >= 0) {
                    this.logMaxSize = j * 1048576;
                }
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_STATISTICS_SAMPLE)) {
                this.utConfigRate = defaultSharedPreferences.getInt(TLogConstant.TLOG_STATISTICS_SAMPLE, 4000);
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_FILE_STATISTICS_SAMPLE)) {
                this.fileSizeRate = defaultSharedPreferences.getInt(TLogConstant.TLOG_FILE_STATISTICS_SAMPLE, 50);
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_BUFFER_SIZE)) {
                long j2 = defaultSharedPreferences.getLong(TLogConstant.TLOG_BUFFER_SIZE, 600L);
                this.tlogBuffersize = j2;
                if (j2 < 300 || j2 > 3000) {
                    this.tlogBuffersize = 600L;
                }
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_SCAN_UPLOAD)) {
                this.tlogScanUpload = defaultSharedPreferences.getBoolean(TLogConstant.TLOG_SCAN_UPLOAD, true);
            }
            if (defaultSharedPreferences.contains(TLogConstant.TLOG_USE_ZSTD)) {
                this.useZstd = defaultSharedPreferences.getBoolean(TLogConstant.TLOG_USE_ZSTD, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TLogStatisticsManager.init(this.context, this.utConfigRate, this.fileSizeRate);
        TLogNative.appenderOpen(this.logLevel.getIndex(), getLogCacheDir(this.context), this.logDir.getAbsolutePath(), this.namePrefix, this.appkey, this.logMaxSize, this.tlogBuffersize, this.useZstd, this.zstdLevel);
        if (TLogNative.isSoOpen()) {
            try {
                TLogNative.setConsoleLogOpen(false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        TLogController.getInstance().updateLogLevel(this.logLevel);
        CommandManager.getInstance().init();
        this.mInitState = 2;
        String format = String.format("tlog init end! fileVersion = %d, logLevel=%s, tlogBuffersize=%d, logMaxSize=%d, isDebug=%b, utConfigRate=%d, fileSizeRate=%d, tlogScanUpload=%b", Integer.valueOf(this.tlogFileVersion), this.logLevel.getName(), Long.valueOf(this.tlogBuffersize), Long.valueOf(this.logMaxSize), Boolean.valueOf(this.isDebug), Integer.valueOf(this.utConfigRate), Integer.valueOf(this.fileSizeRate), Boolean.valueOf(this.tlogScanUpload));
        TLog.loge("TLOG", UCCore.LEGACY_EVENT_INIT, format);
        Log.e("TLOG", format);
        if (!this.mInitSync) {
            TLogController.getInstance().updateAsyncConfig();
        }
        godeyeInit();
        TLogStatisticsManager.statisticsFile(this.context);
        return this;
    }

    public boolean isDebugable() {
        return this.isDebug;
    }

    public boolean isInitSync() {
        return this.mInitSync;
    }

    public boolean isScanUploadEnable() {
        return this.tlogScanUpload;
    }

    public boolean isUseZstd() {
        return this.useZstd;
    }

    public TLogInitializer setAppId(String str) {
        this.appId = str;
        return this;
    }

    public TLogInitializer setAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public TLogInitializer setApplication(Application application) {
        this.application = application;
        return this;
    }

    public TLogInitializer setAuthCode(String str) {
        this.authCode = str;
        return this;
    }

    public TLogInitializer setBufferSize(int i) {
        this.tlogBuffersize = i;
        return this;
    }

    public TLogInitializer setDebugMode(boolean z) {
        this.debugByUsr = true;
        this.isDebug = z;
        return this;
    }

    public TLogInitializer setDefaultFileRate(int i) {
        this.fileSizeRate = i;
        return this;
    }

    public TLogInitializer setDefaultUTRate(int i) {
        this.utConfigRate = i;
        return this;
    }

    public TLogInitializer setInitSync(boolean z) {
        this.mInitSync = z;
        return this;
    }

    public TLogInitializer setLogMaxSize(long j) {
        this.logMaxSize = j;
        return this;
    }

    public TLogInitializer setLogUploader(LogUploader logUploader) {
        this.logUploader = logUploader;
        return this;
    }

    public TLogInitializer setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
        if (messageSender != null) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.context = this.context;
            messageInfo.appKey = getInstance().getAppkey();
            messageInfo.accsServiceId = this.accsServiceId;
            this.messageSender.init(messageInfo);
            StartUpRequestTask.execute();
            PullTask.getInstance().start();
        }
        return this;
    }

    public void setOnTrackTLogListener(OnTrackTLogListener onTrackTLogListener) {
        this.mOnTrackTLogListener = onTrackTLogListener;
    }

    public TLogInitializer setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public TLogInitializer setProcessName(String str) {
        this.processName = str;
        return this;
    }

    public TLogInitializer setSecurityKey(String str) {
        this.mRandomSecret = str;
        return this;
    }

    public TLogInitializer setTLogStatistics(ITLogStatistics iTLogStatistics) {
        this.iTLogStatistics = iTLogStatistics;
        return this;
    }

    public TLogInitializer setTLogUserDefineUploader(String str, TLogFileUploader tLogFileUploader) {
        try {
            this.fileUploaderMap.put(str, tLogFileUploader);
        } catch (Exception e) {
            Log.e("TLOG", "regist tlog user define uploader error", e);
        }
        return this;
    }

    public TLogInitializer setTTid(String str) {
        this.ttid = str;
        return this;
    }

    public TLogInitializer setTaoBaoMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
        if (messageSender != null) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.context = this.context;
            messageInfo.appKey = getInstance().getAppkey();
            messageInfo.accsServiceId = this.accsServiceId;
            this.messageSender.init(messageInfo);
        }
        return this;
    }

    public TLogInitializer setUserNick(String str) {
        this.userNick = str;
        return this;
    }

    public TLogInitializer setUtdid(String str) {
        this.utdid = str;
        return this;
    }

    public TLogInitializer setZstdLevel(int i) {
        this.zstdLevel = i;
        return this;
    }

    public TLogInitializer settLogMonitor(TLogMonitor tLogMonitor) {
        this.tLogMonitor = tLogMonitor;
        return this;
    }

    public TLogInitializer startUpAndPull() {
        if (this.messageSender != null) {
            StartUpRequestTask.execute();
            PullTask.getInstance().start();
        }
        return this;
    }

    public void startUpSampling(Integer num) {
        StartUpRequestTask.updateSample(num);
    }

    public void updateLogLevel(String str) {
        try {
            this.logLevel = TLogUtils.convertLogLevel(str);
            TLogController.getInstance().setLogLevel(this.logLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TLogInitializer useDataStoreLog(boolean z) {
        this.storeLogOnInternal = z;
        return this;
    }

    private TLogInitializer() {
        this.isDebug = false;
        this.packageName = "";
        this.appVersion = "";
        this.utdid = "bbbbbbbbbbbbbbbbb";
        this.ttid = "-";
        this.userNick = "";
        this.logLevel = LogLevel.E;
        this.debugByUsr = false;
        this.mInitSync = false;
        this.mInitState = 0;
        this.ossBucketName = "motu-debug-log";
        this.messageHostName = "adash.emas-ha.cn";
        this.accsServiceId = "ha-remote-debug";
        this.accsTag = null;
        this.fileUploaderMap = new ConcurrentHashMap();
        this.logUploader = null;
        this.messageSender = null;
        this.tLogMonitor = null;
        this.isVersionUpdate = false;
        this.authCode = "";
        this.storeLogOnInternal = false;
        this.logMaxSize = 52428800L;
        this.tlogFileVersion = 9;
        this.utConfigRate = 4000;
        this.fileSizeRate = 50;
        this.tlogBuffersize = 600L;
        this.tlogScanUpload = true;
        this.useZstd = true;
        this.zstdLevel = 7;
    }
}
