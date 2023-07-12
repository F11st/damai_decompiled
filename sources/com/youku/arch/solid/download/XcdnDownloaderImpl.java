package com.youku.arch.solid.download;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.arch.solid.util.FileUtil;
import com.youku.arch.solid.util.TimeUtil;
import com.youku.phone.xcdnengine.XcdnEngine;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class XcdnDownloaderImpl implements IDownloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "XcdnDownloader";
    private final String bizId;
    private XcdnEngine downloader;
    private volatile boolean hasXcdnInit = false;
    private final Map<Long, XcdnDownloadItemWrapper> downloadingItems = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class SolidXcdnListener implements XcdnEngine.Callback {
        private final long startTime;

        private SolidXcdnListener() {
            this.startTime = TimeUtil.getCurTimeStamp();
        }

        @Override // com.youku.phone.xcdnengine.XcdnEngine.Callback, com.youku.phone.xcdn.api.IXcdnCallback
        public void onEvent(long j, int i, int i2, String str) {
            XcdnDownloadItemWrapper xcdnDownloadItemWrapper;
            XcdnDownloadItemWrapper xcdnDownloadItemWrapper2;
            if (i == 8) {
                if (i2 == 32) {
                    if (XcdnDownloaderImpl.this.downloadingItems.containsKey(Long.valueOf(j)) && (xcdnDownloadItemWrapper2 = (XcdnDownloadItemWrapper) XcdnDownloaderImpl.this.downloadingItems.get(Long.valueOf(j))) != null && xcdnDownloadItemWrapper2.isValid()) {
                        DownloadItem downloadItem = xcdnDownloadItemWrapper2.item;
                        IDownloadListener iDownloadListener = xcdnDownloadItemWrapper2.listener;
                        String str2 = downloadItem.getPath() + File.separator + downloadItem.getName();
                        File file = new File(str2);
                        if (!file.exists() || file.length() <= 0) {
                            xcdnDownloadItemWrapper2.hasError.getAndSet(true);
                            iDownloadListener.onLibError(downloadItem, "Invalid: File is null or length is zero.");
                            if (xcdnDownloadItemWrapper2.remainingCount.decrementAndGet() == 0) {
                                iDownloadListener.onError();
                            }
                        } else if (!TextUtils.equals(FileUtil.computeFileMD5(file), downloadItem.getMd5())) {
                            xcdnDownloadItemWrapper2.hasError.getAndSet(true);
                            iDownloadListener.onLibError(downloadItem, "Invalid: check md5 failed.");
                            if (xcdnDownloadItemWrapper2.remainingCount.decrementAndGet() == 0) {
                                iDownloadListener.onError();
                            }
                        } else {
                            long j2 = -1;
                            String[] split = str.split(";");
                            int length = split.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                String[] split2 = split[i3].split(":");
                                if ("cost".equals(split2[0])) {
                                    j2 = Long.parseLong(split2[1]);
                                    break;
                                }
                                i3++;
                            }
                            iDownloadListener.onLibSuccess(downloadItem, str2, j2);
                            if (xcdnDownloadItemWrapper2.remainingCount.decrementAndGet() == 0) {
                                if (xcdnDownloadItemWrapper2.hasError.get()) {
                                    iDownloadListener.onError();
                                } else {
                                    iDownloadListener.onSuccess(TimeUtil.getCurTimeStamp() - this.startTime);
                                }
                            }
                            xcdnDownloadItemWrapper2.release();
                        }
                    }
                } else if (XcdnDownloaderImpl.this.downloadingItems.containsKey(Long.valueOf(j)) && (xcdnDownloadItemWrapper = (XcdnDownloadItemWrapper) XcdnDownloaderImpl.this.downloadingItems.get(Long.valueOf(j))) != null && xcdnDownloadItemWrapper.isValid()) {
                    xcdnDownloadItemWrapper.hasError.getAndSet(true);
                    DownloadItem downloadItem2 = xcdnDownloadItemWrapper.item;
                    IDownloadListener iDownloadListener2 = xcdnDownloadItemWrapper.listener;
                    iDownloadListener2.onLibError(downloadItem2, str);
                    if (xcdnDownloadItemWrapper.remainingCount.decrementAndGet() == 0) {
                        iDownloadListener2.onError();
                    }
                    xcdnDownloadItemWrapper.release();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class XcdnDownloadItemWrapper {
        private AtomicBoolean hasError;
        private DownloadItem item;
        private IDownloadListener listener;
        private AtomicInteger remainingCount;
        private long xcdnRet;

        public XcdnDownloadItemWrapper(long j, DownloadItem downloadItem, IDownloadListener iDownloadListener, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean) {
            this.xcdnRet = 0L;
            this.xcdnRet = j;
            this.item = downloadItem;
            this.listener = iDownloadListener;
            this.remainingCount = atomicInteger;
            this.hasError = atomicBoolean;
        }

        boolean isValid() {
            return (this.xcdnRet <= 0 || this.item == null || this.listener == null || this.remainingCount == null || this.hasError == null) ? false : true;
        }

        void release() {
            this.item = null;
            this.listener = null;
            this.remainingCount = null;
            this.hasError = null;
            XcdnDownloaderImpl.this.downloadingItems.remove(Long.valueOf(this.xcdnRet));
        }
    }

    public XcdnDownloaderImpl(String str) {
        this.bizId = str;
    }

    private void reportXcdnInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "969864388")) {
            ipChange.ipc$dispatch("969864388", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.hasXcdnInit) {
            hashMap.put(SolidMonitor.Params.SUCCESS, "1");
        } else {
            SLog.e(TAG, "xcdn init error");
            hashMap.put(SolidMonitor.Params.SUCCESS, "0");
        }
        Solid.getInstance().getMonitor().reportStageResult(SolidMonitor.Stage.PCDN_INIT, hashMap);
    }

    private void xcdnDownload(DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        XcdnDownloaderImpl xcdnDownloaderImpl = this;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1329716854")) {
            ipChange.ipc$dispatch("1329716854", new Object[]{xcdnDownloaderImpl, downloadTask, iDownloadListener});
            return;
        }
        AtomicInteger atomicInteger = new AtomicInteger(downloadTask.getDownloadCount());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (DownloadItem downloadItem : downloadTask.getDownloadItems()) {
            String url = downloadItem.getUrl();
            String path = downloadItem.getPath();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("md5", downloadItem.getMd5());
            hashMap.put("dwn_prio", downloadItem.getPriority().code + "");
            hashMap.put("biz_id", xcdnDownloaderImpl.bizId);
            if (downloadItem.getZipDownloadItem() != null) {
                hashMap.put("use_backup_storage", "1");
            }
            XcdnEngine xcdnEngine = xcdnDownloaderImpl.downloader;
            long xcdnDownload = xcdnEngine.xcdnDownload(url, path + "/" + downloadItem.getName(), hashMap, new SolidXcdnListener());
            if (xcdnDownload > 0) {
                xcdnDownloaderImpl.downloadingItems.put(Long.valueOf(xcdnDownload), new XcdnDownloadItemWrapper(xcdnDownload, downloadItem, iDownloadListener, atomicInteger, atomicBoolean));
                iDownloadListener.onLibStart(downloadItem);
            } else {
                atomicBoolean.getAndSet(true);
                iDownloadListener.onLibError(downloadItem, "xcdn task create failed");
            }
            xcdnDownloaderImpl = this;
        }
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void download(DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856215713")) {
            ipChange.ipc$dispatch("1856215713", new Object[]{this, downloadTask, iDownloadListener});
        } else if (this.hasXcdnInit) {
            xcdnDownload(downloadTask, iDownloadListener);
        }
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1060202739")) {
            ipChange.ipc$dispatch("-1060202739", new Object[]{this});
            return;
        }
        SLog.e("download", "xcdn downloader init");
        this.downloader = new XcdnEngine(Solid.getInstance().getApplication());
        this.hasXcdnInit = true;
        reportXcdnInit();
    }
}
