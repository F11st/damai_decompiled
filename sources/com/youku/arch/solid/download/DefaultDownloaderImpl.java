package com.youku.arch.solid.download;

import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.api.QueueConfig;
import com.taobao.downloader.api.Request;
import com.taobao.downloader.api.RequestQueue;
import com.taobao.downloader.inner.IEnLoaderListener;
import com.taobao.downloader.inner.IRetryPolicy;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.util.TimeUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefaultDownloaderImpl implements IDownloader {
    private static final String DOWNLOADER_BIZ_ID = "solid";
    private RequestQueue mRequestQueue;
    private IRetryPolicy mRetryPolicy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.solid.download.DefaultDownloaderImpl$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority;

        static {
            int[] iArr = new int[DownloadTask.Priority.values().length];
            $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority = iArr;
            try {
                iArr[DownloadTask.Priority.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority[DownloadTask.Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority[DownloadTask.Priority.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class BatchStatus {
        private static transient /* synthetic */ IpChange $ipChange;
        private IDownloadListener listener;
        private int totalCount;
        private int finishCount = 0;
        private boolean isAllSuccess = true;
        private StringBuilder failedMsgBuilder = new StringBuilder();
        private long startTime = TimeUtil.getCurTimeStamp();

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public interface Callback {
            void onFail(DownloadItem downloadItem, String str, String str2);

            void onSuccess(DownloadItem downloadItem, String str, String str2, long j);
        }

        public BatchStatus(int i, @Nullable IDownloadListener iDownloadListener) {
            this.totalCount = i;
            this.listener = iDownloadListener;
        }

        public BatchableListener createListener(DownloadItem downloadItem, String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-155538462") ? (BatchableListener) ipChange.ipc$dispatch("-155538462", new Object[]{this, downloadItem, str}) : new BatchableListener(downloadItem, str, new Callback() { // from class: com.youku.arch.solid.download.DefaultDownloaderImpl.BatchStatus.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.arch.solid.download.DefaultDownloaderImpl.BatchStatus.Callback
                public void onFail(DownloadItem downloadItem2, String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2051557225")) {
                        ipChange2.ipc$dispatch("-2051557225", new Object[]{this, downloadItem2, str2, str3});
                    } else {
                        BatchStatus.this.finishOne(downloadItem2, str2, false, str3, null, 0L);
                    }
                }

                @Override // com.youku.arch.solid.download.DefaultDownloaderImpl.BatchStatus.Callback
                public void onSuccess(DownloadItem downloadItem2, String str2, String str3, long j) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-7336738")) {
                        ipChange2.ipc$dispatch("-7336738", new Object[]{this, downloadItem2, str2, str3, Long.valueOf(j)});
                    } else {
                        BatchStatus.this.finishOne(downloadItem2, str2, true, null, str3, j);
                    }
                }
            });
        }

        public synchronized void finishOne(DownloadItem downloadItem, String str, boolean z, String str2, String str3, long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-884196650")) {
                ipChange.ipc$dispatch("-884196650", new Object[]{this, downloadItem, str, Boolean.valueOf(z), str2, str3, Long.valueOf(j)});
                return;
            }
            IDownloadListener iDownloadListener = this.listener;
            if (iDownloadListener == null) {
                return;
            }
            this.finishCount++;
            if (z) {
                iDownloadListener.onLibSuccess(downloadItem, str3, j);
            } else {
                iDownloadListener.onLibError(downloadItem, str2);
                if (this.failedMsgBuilder.length() > 0) {
                    this.failedMsgBuilder.append("; ");
                }
                StringBuilder sb = this.failedMsgBuilder;
                sb.append("[error]");
                sb.append(str2);
                this.isAllSuccess = false;
            }
            if (this.finishCount != this.totalCount) {
                return;
            }
            if (this.isAllSuccess) {
                this.listener.onSuccess(TimeUtil.getCurTimeStamp() - this.startTime);
            } else {
                this.listener.onError();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class BatchableListener implements IEnLoaderListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private BatchStatus.Callback batchStatusCallback;
        private DownloadItem item;
        private String url;

        public BatchableListener(DownloadItem downloadItem, String str, BatchStatus.Callback callback) {
            this.item = downloadItem;
            this.url = str;
            this.batchStatusCallback = callback;
        }

        public void onCanceled() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-849564447")) {
                ipChange.ipc$dispatch("-849564447", new Object[]{this});
            }
        }

        public void onCompleted(boolean z, long j, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1845509889")) {
                ipChange.ipc$dispatch("-1845509889", new Object[]{this, Boolean.valueOf(z), Long.valueOf(j), str});
            } else {
                this.batchStatusCallback.onSuccess(this.item, this.url, str, j);
            }
        }

        public void onError(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "933378853")) {
                ipChange.ipc$dispatch("933378853", new Object[]{this, Integer.valueOf(i), str});
            } else {
                this.batchStatusCallback.onFail(this.item, this.url, str);
            }
        }

        public void onPaused(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1407179032")) {
                ipChange.ipc$dispatch("-1407179032", new Object[]{this, Boolean.valueOf(z)});
            }
        }

        public void onProgress(long j, long j2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1661800435")) {
                ipChange.ipc$dispatch("-1661800435", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            }
        }

        public void onStart() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2146608462")) {
                ipChange.ipc$dispatch("2146608462", new Object[]{this});
            }
        }
    }

    private Request.Priority convertPriority(DownloadTask.Priority priority) {
        int i = AnonymousClass2.$SwitchMap$com$youku$arch$solid$download$DownloadTask$Priority[priority.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return Request.Priority.LOW;
            }
            return Request.Priority.NORMAL;
        }
        return Request.Priority.HIGH;
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void download(DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        if (downloadTask.getDownloadCount() == 0) {
            return;
        }
        BatchStatus batchStatus = new BatchStatus(downloadTask.getDownloadCount(), iDownloadListener);
        for (DownloadItem downloadItem : downloadTask.getDownloadItems()) {
            Request.Build listener = new Request.Build().setUrl(downloadItem.getUrl()).setName(downloadItem.getName()).setCachePath(downloadItem.getPath()).setMd5(downloadItem.getMd5()).setBizId(DOWNLOADER_BIZ_ID).setUseCache(true).setPriority(convertPriority(downloadItem.getPriority())).setNetwork(Request.Network.MOBILE).setRetryPolicy(this.mRetryPolicy).setListener(batchStatus.createListener(downloadItem, downloadItem.getUrl()));
            iDownloadListener.onLibStart(downloadItem);
            this.mRequestQueue.add(listener.build());
        }
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void init() {
        RequestQueue requestQueue = new RequestQueue(Solid.getInstance().getApplication(), new QueueConfig.Build().setThreadPoolSize(Math.min(6, 10)).build());
        this.mRequestQueue = requestQueue;
        requestQueue.start();
        this.mRetryPolicy = new IRetryPolicy() { // from class: com.youku.arch.solid.download.DefaultDownloaderImpl.1
            private static transient /* synthetic */ IpChange $ipChange;

            public int getConnectTimeout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "12838830")) {
                    return ((Integer) ipChange.ipc$dispatch("12838830", new Object[]{this})).intValue();
                }
                return 15000;
            }

            public int getReadTimeout() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1722347264")) {
                    return ((Integer) ipChange.ipc$dispatch("-1722347264", new Object[]{this})).intValue();
                }
                return 15000;
            }

            public int getRetryCount() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "238529022")) {
                    return ((Integer) ipChange.ipc$dispatch("238529022", new Object[]{this})).intValue();
                }
                return 3;
            }
        };
        SLog.e("download", "default downloader init");
    }
}
