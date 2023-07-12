package com.youku.arch.solid.download;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.edge.pcdn.PcdnManager;
import com.edge.pcdn.UniversalDownloader;
import com.ut.device.UTDevice;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.FileUtil;
import com.youku.arch.solid.util.TimeUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PcdnDownloaderImpl implements IDownloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String PCDN_INIT_ID = "200000010057aad98651336b6f1bf864c1dd694e87754f3be4";
    private static final String PCDN_PARAM_BIZ_ID = "biz_id";
    private static final String PCDN_PARAM_MD5 = "md5";
    private static final String PCDN_PARAM_PRIORITY = "dwn_prio";
    private static final String PCDN_PARAM_UTDID = "utdid";
    private static final String TAG = "PcdnDownloader";
    private final String bizId;
    private UniversalDownloader downloader;
    private volatile boolean hasPcdnInit = false;
    private final Map<Long, PcdnDownloadItemWrapper> downloadingItems = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class PcdnDownloadItemWrapper {
        private static transient /* synthetic */ IpChange $ipChange;
        private AtomicBoolean hasError;
        private DownloadItem item;
        private IDownloadListener listener;
        private long pcdnRet;
        private AtomicInteger remainingCount;

        public PcdnDownloadItemWrapper(long j, DownloadItem downloadItem, IDownloadListener iDownloadListener, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean) {
            this.pcdnRet = 0L;
            this.pcdnRet = j;
            this.item = downloadItem;
            this.listener = iDownloadListener;
            this.remainingCount = atomicInteger;
            this.hasError = atomicBoolean;
        }

        boolean isValid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-320454048") ? ((Boolean) ipChange.ipc$dispatch("-320454048", new Object[]{this})).booleanValue() : (this.pcdnRet <= 0 || this.item == null || this.listener == null || this.remainingCount == null || this.hasError == null) ? false : true;
        }

        void release() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "376963879")) {
                ipChange.ipc$dispatch("376963879", new Object[]{this});
                return;
            }
            this.item = null;
            this.listener = null;
            this.remainingCount = null;
            this.hasError = null;
            PcdnDownloaderImpl.this.downloadingItems.remove(Long.valueOf(this.pcdnRet));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class SolidPcdnListener implements com.edge.pcdn.IDownloadListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private final long startTime;

        private SolidPcdnListener() {
            this.startTime = TimeUtil.getCurTimeStamp();
        }

        public void onDownloadCompleted(long j, long j2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-876163863")) {
                ipChange.ipc$dispatch("-876163863", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            } else if (PcdnDownloaderImpl.this.downloadingItems.containsKey(Long.valueOf(j))) {
                PcdnDownloaderImpl.this.downloader.release(j);
                PcdnDownloadItemWrapper pcdnDownloadItemWrapper = (PcdnDownloadItemWrapper) PcdnDownloaderImpl.this.downloadingItems.get(Long.valueOf(j));
                if (pcdnDownloadItemWrapper == null || !pcdnDownloadItemWrapper.isValid()) {
                    return;
                }
                DownloadItem downloadItem = pcdnDownloadItemWrapper.item;
                IDownloadListener iDownloadListener = pcdnDownloadItemWrapper.listener;
                String str = downloadItem.getPath() + File.separator + downloadItem.getName();
                File file = new File(str);
                if (!file.exists() || file.length() <= 0) {
                    pcdnDownloadItemWrapper.hasError.getAndSet(true);
                    iDownloadListener.onLibError(downloadItem, "Invalid: File is null or length is zero.");
                    if (pcdnDownloadItemWrapper.remainingCount.decrementAndGet() == 0) {
                        iDownloadListener.onError();
                    }
                } else if (!TextUtils.equals(FileUtil.computeFileMD5(file), downloadItem.getMd5())) {
                    pcdnDownloadItemWrapper.hasError.getAndSet(true);
                    iDownloadListener.onLibError(downloadItem, "Invalid: check md5 failed.");
                    if (pcdnDownloadItemWrapper.remainingCount.decrementAndGet() == 0) {
                        iDownloadListener.onError();
                    }
                } else {
                    iDownloadListener.onLibSuccess(downloadItem, str, j2);
                    if (pcdnDownloadItemWrapper.remainingCount.decrementAndGet() == 0) {
                        if (pcdnDownloadItemWrapper.hasError.get()) {
                            iDownloadListener.onError();
                        } else {
                            iDownloadListener.onSuccess(TimeUtil.getCurTimeStamp() - this.startTime);
                        }
                    }
                    pcdnDownloadItemWrapper.release();
                }
            }
        }

        public void onDownloadError(long j, int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-694943723")) {
                ipChange.ipc$dispatch("-694943723", new Object[]{this, Long.valueOf(j), Integer.valueOf(i), str});
            } else if (PcdnDownloaderImpl.this.downloadingItems.containsKey(Long.valueOf(j))) {
                PcdnDownloaderImpl.this.downloader.release(j);
                PcdnDownloadItemWrapper pcdnDownloadItemWrapper = (PcdnDownloadItemWrapper) PcdnDownloaderImpl.this.downloadingItems.get(Long.valueOf(j));
                if (pcdnDownloadItemWrapper == null || !pcdnDownloadItemWrapper.isValid()) {
                    return;
                }
                pcdnDownloadItemWrapper.hasError.getAndSet(true);
                DownloadItem downloadItem = pcdnDownloadItemWrapper.item;
                IDownloadListener iDownloadListener = pcdnDownloadItemWrapper.listener;
                iDownloadListener.onLibError(downloadItem, str);
                if (pcdnDownloadItemWrapper.remainingCount.decrementAndGet() == 0) {
                    iDownloadListener.onError();
                }
                pcdnDownloadItemWrapper.release();
            }
        }

        public void onProgresss(long j, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1997104325")) {
                ipChange.ipc$dispatch("1997104325", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
            }
        }
    }

    public PcdnDownloaderImpl(String str) {
        this.bizId = str;
    }

    private void pcdnDownload(DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        PcdnDownloaderImpl pcdnDownloaderImpl = this;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129684342")) {
            ipChange.ipc$dispatch("129684342", new Object[]{pcdnDownloaderImpl, downloadTask, iDownloadListener});
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(downloadTask.getDownloadCount());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (DownloadItem downloadItem : downloadTask.getDownloadItems()) {
            String url = downloadItem.getUrl();
            String path = downloadItem.getPath();
            long createDownloadTask = pcdnDownloaderImpl.downloader.createDownloadTask(url, downloadItem.getName(), path, "md5=" + downloadItem.getMd5() + "&dwn_prio=" + downloadItem.getPriority().code + "&biz_id=" + pcdnDownloaderImpl.bizId);
            if (createDownloadTask > 0) {
                pcdnDownloaderImpl.downloadingItems.put(Long.valueOf(createDownloadTask), new PcdnDownloadItemWrapper(createDownloadTask, downloadItem, iDownloadListener, atomicInteger, atomicBoolean));
                iDownloadListener.onLibStart(downloadItem);
            } else {
                atomicBoolean.getAndSet(true);
                iDownloadListener.onLibError(downloadItem, "pcdn task create failed");
            }
            pcdnDownloaderImpl = this;
        }
    }

    private void reportPcdnInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011924028")) {
            ipChange.ipc$dispatch("-2011924028", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        String version = PcdnManager.getVersion("down");
        if (TextUtils.isEmpty(version)) {
            version = "unKnow";
        }
        if (this.hasPcdnInit) {
            hashMap.put(SolidMonitor.Params.SUCCESS, "1");
        } else {
            SLog.e(TAG, "pcdn init error");
            hashMap.put(SolidMonitor.Params.SUCCESS, "0");
        }
        hashMap.put(SolidMonitor.Params.PCDN_VERSION, version);
        Solid.getInstance().getMonitor().reportStageResult(SolidMonitor.Stage.PCDN_INIT, hashMap);
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void download(DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387634841")) {
            ipChange.ipc$dispatch("387634841", new Object[]{this, downloadTask, iDownloadListener});
        } else if (this.hasPcdnInit) {
            pcdnDownload(downloadTask, iDownloadListener);
        }
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977689621")) {
            ipChange.ipc$dispatch("977689621", new Object[]{this});
            return;
        }
        SLog.e("download", "pcdn downloader init");
        this.downloader = new UniversalDownloader(Solid.getInstance().getApplication());
        StringBuilder sb = new StringBuilder();
        sb.append("utdid=");
        sb.append(UTDevice.getUtdid(Solid.getInstance().getApplication()));
        this.hasPcdnInit = this.downloader.init(PCDN_INIT_ID, sb.toString()) == 0;
        reportPcdnInit();
        this.downloader.setListener(new SolidPcdnListener());
    }
}
