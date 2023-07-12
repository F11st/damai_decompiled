package com.uc.webview.export.cyclone.update;

import android.content.Context;
import android.text.TextUtils;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.ErrorCode;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.cyclone.update.UrlDownloader;
import com.uc.webview.export.cyclone.update.Utils;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateServiceImpl implements UpdateService, Utils.LogHelper {
    private static final long DOWNLOAD_RETRY_DELAY_MILLIS = 180000;
    private static final long DOWNLOAD_RETRY_MAX_MILLIS = 1800000;
    private static final String TAG = "UpdateService";
    public static final /* synthetic */ int a = 0;
    private static final Set<Integer> sPendingTasks = Collections.synchronizedSet(new HashSet());
    private UpdateService.EventCallback mCallback;
    private Context mContext;
    private File mDownloadFile;
    private IUrlDownloader mDownloader;
    private DownloaderClient mDownloaderClient;
    private boolean mIsCore;
    private File mRootDir;
    private String mUrl;
    private final Map<String, Object> mOptions = new HashMap();
    private int mRealPercent = 0;
    private long mTotalWaitMillis = 0;
    private long mRetryWaitMillis = DOWNLOAD_RETRY_DELAY_MILLIS;
    private long mRetryMaxWaitMillis = 1800000;
    private long mStartDelayMillis = 0;
    private long mTotalSize = 0;
    private long mLastModified = 0;
    private String mCheckedFile = null;
    private Throwable mException = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class DownloaderClient implements UrlDownloader.Client {
        private final IUrlDownloader mDownloader;

        public DownloaderClient(IUrlDownloader iUrlDownloader) {
            this.mDownloader = iUrlDownloader;
        }

        @Override // com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public void onCheck() {
            UpdateServiceImpl.this.onEvent(8, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public void onException(Throwable th) {
            UpdateServiceImpl.this.mException = th;
            this.mDownloader.stop();
            UpdateServiceImpl.this.onEvent(5, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.IUrlDownloader.Client
        public void onFailed(String str, Throwable th) {
            try {
                UpdateServiceImpl.sPendingTasks.remove(Integer.valueOf(UpdateServiceImpl.this.mUrl.hashCode()));
            } catch (Throwable unused) {
                UpdateServiceImpl.this.printLog("onFailed remove record failed", th);
            }
            this.mDownloader.delete();
            UpdateServiceImpl.this.mException = th;
            UpdateServiceImpl.this.onStat(Utils.StatKey.UCM_FAILED_DOWNLOAD);
            UpdateServiceImpl.this.onEvent(4, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public void onFileDeleted() {
            UpdateServiceImpl.this.onEvent(13, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public void onFileExists(File file) {
            UpdateServiceImpl.this.mDownloadFile = file;
            UpdateServiceImpl.this.onDownloadFinished();
        }

        @Override // com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public boolean onHeaderReceived(Throwable th) {
            return true;
        }

        @Override // com.uc.webview.export.cyclone.update.IUrlDownloader.Client
        public void onProgressChanged(int i) {
            if (i <= UpdateServiceImpl.this.mRealPercent) {
                return;
            }
            UpdateServiceImpl.this.mRealPercent = i;
            UpdateServiceImpl.this.onEvent(7, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public void onRecovered() {
            UpdateServiceImpl.this.onEvent(6, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.IUrlDownloader.Client
        public void onStart() {
            UpdateServiceImpl.this.onEvent(10, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.IUrlDownloader.Client
        public void onSuccess(String str, long j, long j2) {
            UpdateServiceImpl.this.mDownloadFile = new File(str);
            UpdateServiceImpl.this.mTotalSize = j;
            UpdateServiceImpl.this.mLastModified = j2;
            UpdateServiceImpl.this.onDownloadFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class InternalDownloaderClient extends DownloaderClient {
        private final UrlDownloader mDownloader;

        public InternalDownloaderClient(UrlDownloader urlDownloader) {
            super(urlDownloader);
            this.mDownloader = urlDownloader;
        }

        @Override // com.uc.webview.export.cyclone.update.UpdateServiceImpl.DownloaderClient, com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public void onException(Throwable th) {
            UpdateServiceImpl.this.mException = th;
            if (th != null) {
                UpdateServiceImpl.this.onStat(Utils.StatKey.UCM_LAST_EXCEPTION, String.valueOf(th.getClass().getName().hashCode()));
            }
            UpdateServiceImpl.this.mTotalWaitMillis += UpdateServiceImpl.this.mRetryWaitMillis;
            if (UpdateServiceImpl.this.mTotalWaitMillis < UpdateServiceImpl.this.mRetryMaxWaitMillis) {
                UpdateServiceImpl.this.onEvent(12, new Object[0]);
                this.mDownloader.start(UpdateServiceImpl.this.mRetryWaitMillis);
                return;
            }
            try {
                UpdateServiceImpl.sPendingTasks.remove(Integer.valueOf(UpdateServiceImpl.this.mUrl.hashCode()));
            } catch (Throwable unused) {
                UpdateServiceImpl.this.printLog("onException remove record failed", th);
            }
            UpdateServiceImpl.this.onStat(Utils.StatKey.UCM_EXCEPTION_DOWNLOAD);
            String message = th != null ? th.getMessage() : "";
            UpdateServiceImpl.this.mException = new RuntimeException("Download aborted because of up to 10 retries. Last exception is: " + message);
            UpdateServiceImpl.this.onEvent(15, new Object[0]);
            UpdateServiceImpl.this.onEvent(5, new Object[0]);
        }

        @Override // com.uc.webview.export.cyclone.update.UpdateServiceImpl.DownloaderClient, com.uc.webview.export.cyclone.update.UrlDownloader.Client
        public boolean onHeaderReceived(Throwable th) {
            UpdateServiceImpl.this.onEvent(14, th);
            if (th == null) {
                try {
                    UpdateServiceImpl.this.mTotalSize = this.mDownloader.getTotalSize();
                    UpdateServiceImpl.this.mLastModified = this.mDownloader.getLastModified();
                    File extractDir = UpdateServiceImpl.this.getExtractDir();
                    if (UpdateFlagMarker.isFinished(extractDir, UpdateServiceImpl.this.mCheckedFile)) {
                        UpdateServiceImpl.this.printLog("onHeaderReceived file exists");
                        UpdateServiceImpl.this.onEvent(9, new Object[0]);
                        this.mDownloader.stop();
                        return false;
                    }
                    if (extractDir.exists()) {
                        UpdateServiceImpl.this.onEvent(6, new Object[0]);
                    }
                    UpdateServiceImpl.this.onStat(Utils.StatKey.UCM_PERCENT, String.valueOf(this.mDownloader.getCurrentPercent()));
                    UpdateServiceImpl.this.onEvent(7, new Object[0]);
                } catch (Throwable th2) {
                    th = th2;
                    UpdateServiceImpl.this.printLog("onHeaderReceived failed", th);
                }
            }
            if (th != null) {
                UpdateServiceImpl.this.mException = th;
                this.mDownloader.stop();
                UpdateServiceImpl.this.onEvent(5, new Object[0]);
                return false;
            }
            return true;
        }
    }

    private UpdateServiceImpl() {
    }

    @Constant
    public static UpdateService create() {
        return new UpdateServiceImpl();
    }

    private void handleConfigs(Map<String, Object> map) {
        String str = (String) map.get("url");
        this.mUrl = str;
        if (!TextUtils.isEmpty(str)) {
            int hashCode = this.mUrl.hashCode();
            Set<Integer> set = sPendingTasks;
            if (!set.contains(Integer.valueOf(hashCode))) {
                set.add(Integer.valueOf(hashCode));
                Context context = (Context) map.get(UpdateService.OPTION_CONTEXT);
                this.mContext = context;
                if (context != null) {
                    File file = (File) map.get(UpdateService.OPTION_ROOT_DIR);
                    this.mRootDir = file;
                    if (file != null) {
                        String str2 = (String) map.get(UpdateService.OPTION_CHECK_FILE);
                        if (str2 != null) {
                            this.mCheckedFile = str2;
                        }
                        Boolean bool = (Boolean) map.get(UpdateService.OPTION_UPDATE_CORE);
                        if (bool != null) {
                            this.mIsCore = bool.booleanValue();
                        }
                        Long l = (Long) map.get(UpdateService.OPTION_RETRY_WAIT_MILLIS);
                        if (l != null) {
                            this.mRetryWaitMillis = l.longValue();
                        }
                        Long l2 = (Long) map.get(UpdateService.OPTION_RETRY_MAX_MILLIS);
                        if (l2 != null) {
                            this.mRetryMaxWaitMillis = l2.longValue();
                        }
                        Long l3 = (Long) map.get(UpdateService.OPTION_DELAY_START_MILLIS);
                        if (l3 != null) {
                            this.mStartDelayMillis = l3.longValue();
                        }
                        this.mDownloader = (IUrlDownloader) map.get(UpdateService.OPTION_DOWNLOADER_DELEGATE);
                        return;
                    }
                    throw new RuntimeException("Download root dir is empty");
                }
                throw new RuntimeException("Context is null");
            }
            throw new UCKnownException((int) ErrorCode.UCM_UPD_DUPLICATE_TASK, "Duplicate UpdateService:" + this.mUrl);
        }
        throw new RuntimeException("Download url is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadFinished() {
        try {
            onEvent(7, new Object[0]);
            File extractDir = getExtractDir();
            if (extractDir != null) {
                UpdateFlagMarker updateFlagMarker = new UpdateFlagMarker(extractDir, this.mCheckedFile);
                updateFlagMarker.markStart();
                onEvent(11, new Object[0]);
                updateFlagMarker.markFinished();
                this.mDownloader.delete();
                Object[] objArr = new Object[1];
                objArr[0] = this.mIsCore ? Utils.StatKey.UCM_SUCCESS : Utils.StatKey.UCM_SUCCESS_NOT_CORE_DOWNLAOD;
                onStat(objArr);
                onEvent(7, new Object[0]);
                onEvent(3, new Object[0]);
                return;
            }
            throw new RuntimeException("Get extract dir failed");
        } catch (Throwable th) {
            printLog("onDownloadFinished failed", th);
            this.mException = th;
            onStat(Utils.StatKey.UCM_EXCEPTION_UPDATE);
            onStat(Utils.StatKey.UCM_LAST_EXCEPTION, String.valueOf(th.getClass().getName().hashCode()));
            onEvent(5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object onEvent(int i, Object... objArr) {
        UpdateService.EventCallback eventCallback = this.mCallback;
        if (eventCallback != null) {
            return eventCallback.onCalled(i, this, objArr);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStat(Object... objArr) {
        onEvent(2, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printLog(String str) {
        printLog(str, null);
    }

    private void startDownload() {
        if (this.mDownloader != null) {
            printLog("startDownload maybe use IUrlDownloader to delegate for " + this.mUrl);
            DownloaderClient downloaderClient = new DownloaderClient(this.mDownloader);
            if (this.mDownloader.start(this.mUrl, Utils.getDownloadDir(this.mContext, this.mUrl).getAbsolutePath(), downloaderClient)) {
                printLog("startDownload use IUrlDownloader to delegate");
                this.mDownloaderClient = downloaderClient;
                return;
            }
        }
        UrlDownloader urlDownloader = new UrlDownloader(this.mContext, this.mUrl, this);
        InternalDownloaderClient internalDownloaderClient = new InternalDownloaderClient(urlDownloader);
        this.mDownloaderClient = internalDownloaderClient;
        this.mDownloader = urlDownloader;
        urlDownloader.setClient(internalDownloaderClient).setCheckLastModified((Boolean) this.mOptions.get(UpdateService.OPTION_CHECK_LAST_MODIFIED)).setConnectTimeOut((Integer) this.mOptions.get(UpdateService.OPTION_CONNECT_TIME_OUT)).setReadTimeOut((Integer) this.mOptions.get(UpdateService.OPTION_READ_TIME_OUT)).start(this.mStartDelayMillis);
        printLog("startDownload use internal UrlDownloader for " + this.mUrl);
    }

    protected void finalize() throws Throwable {
        try {
            sPendingTasks.remove(Integer.valueOf(this.mUrl.hashCode()));
        } catch (Throwable unused) {
        }
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public File getDownloadDir() {
        return Utils.getDownloadDir(this.mContext, this.mUrl);
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public File getDownloadFile() {
        return this.mDownloadFile;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public long getDownloadLastModified() {
        return this.mLastModified;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public long getDownloadTotalSize() {
        return this.mTotalSize;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public Throwable getException() {
        return this.mException;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public File getExtractDir() {
        long j = this.mTotalSize;
        if (j <= 0) {
            return null;
        }
        return Utils.getExtractDir(this.mRootDir, this.mUrl, j, this.mLastModified);
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public int getPercent() {
        return this.mRealPercent;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.uc.webview.export.cyclone.update.Utils.LogHelper
    public void print(String str, String str2, Throwable th) {
        onEvent(1, str, str2, th);
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public void restart() {
        printLog("restart url=" + this.mUrl);
        IUrlDownloader iUrlDownloader = this.mDownloader;
        if (iUrlDownloader != null) {
            iUrlDownloader.stop();
            startDownload();
            return;
        }
        throw new RuntimeException("No running Downloader, can not restart");
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public UpdateService setCallback(UpdateService.EventCallback eventCallback) {
        this.mCallback = eventCallback;
        return this;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public UpdateService setup(String str, Object obj) {
        this.mOptions.put(str, obj);
        return this;
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public void start() {
        handleConfigs(this.mOptions);
        startDownload();
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public void stop() {
        IUrlDownloader iUrlDownloader = this.mDownloader;
        if (iUrlDownloader != null) {
            iUrlDownloader.stop();
        }
    }

    @Override // com.uc.webview.export.cyclone.update.UpdateService
    public void stopWith(Runnable runnable) {
        printLog("stopWith");
        IUrlDownloader iUrlDownloader = this.mDownloader;
        if (iUrlDownloader != null) {
            if (iUrlDownloader instanceof UrlDownloader) {
                ((UrlDownloader) iUrlDownloader).stopWith(runnable);
                return;
            }
            iUrlDownloader.stop();
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printLog(String str, Throwable th) {
        print(TAG, str + ", this:" + this, th);
    }
}
