package com.youku.arch.solid.download;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.Solid;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.util.TimeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SystemDownloadImp implements IDownloader {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isFocusPriorityGroup;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SystemDownloadEvent {
        final AtomicBoolean hasError;
        final IDownloadListener listener;
        final long startTime;
        final AtomicInteger totalRemainingCount;

        private SystemDownloadEvent(int i, IDownloadListener iDownloadListener) {
            this.hasError = new AtomicBoolean(false);
            this.startTime = TimeUtil.getCurTimeStamp();
            this.listener = iDownloadListener;
            this.totalRemainingCount = new AtomicInteger(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface SystemDownloadListener {
        void onFinish();
    }

    public SystemDownloadImp() {
        this.isFocusPriorityGroup = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00fe, code lost:
        if (r10 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0100, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013f, code lost:
        if (r10 != null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132 A[Catch: IOException -> 0x0142, TRY_ENTER, TryCatch #6 {IOException -> 0x0142, blocks: (B:24:0x00f5, B:26:0x0100, B:43:0x0132, B:45:0x0137, B:47:0x013c), top: B:75:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0137 A[Catch: IOException -> 0x0142, TryCatch #6 {IOException -> 0x0142, blocks: (B:24:0x00f5, B:26:0x0100, B:43:0x0132, B:45:0x0137, B:47:0x013c), top: B:75:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013c A[Catch: IOException -> 0x0142, TRY_LEAVE, TryCatch #6 {IOException -> 0x0142, blocks: (B:24:0x00f5, B:26:0x0100, B:43:0x0132, B:45:0x0137, B:47:0x013c), top: B:75:0x004d }] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean downloadSo(com.youku.arch.solid.download.DownloadItem r17, com.youku.arch.solid.download.IDownloadListener r18) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.solid.download.SystemDownloadImp.downloadSo(com.youku.arch.solid.download.DownloadItem, com.youku.arch.solid.download.IDownloadListener):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadSoList(List<DownloadItem> list, final SystemDownloadEvent systemDownloadEvent, final SystemDownloadListener systemDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550000609")) {
            ipChange.ipc$dispatch("-1550000609", new Object[]{this, list, systemDownloadEvent, systemDownloadListener});
        } else if (list == null || list.isEmpty()) {
            if (systemDownloadListener != null) {
                systemDownloadListener.onFinish();
            }
        } else {
            final AtomicInteger atomicInteger = new AtomicInteger(list.size());
            for (final DownloadItem downloadItem : list) {
                Solid.getInstance().executeTask(new Runnable() { // from class: com.youku.arch.solid.download.SystemDownloadImp.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        SystemDownloadListener systemDownloadListener2;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-644349027")) {
                            ipChange2.ipc$dispatch("-644349027", new Object[]{this});
                            return;
                        }
                        if (!SystemDownloadImp.this.downloadSo(downloadItem, systemDownloadEvent.listener)) {
                            systemDownloadEvent.hasError.getAndSet(true);
                        }
                        if (systemDownloadEvent.totalRemainingCount.decrementAndGet() == 0) {
                            if (systemDownloadEvent.hasError.get()) {
                                systemDownloadEvent.listener.onError();
                            } else {
                                systemDownloadEvent.listener.onSuccess(TimeUtil.getCurTimeStamp() - systemDownloadEvent.startTime);
                            }
                        }
                        if (atomicInteger.decrementAndGet() != 0 || (systemDownloadListener2 = systemDownloadListener) == null) {
                            return;
                        }
                        systemDownloadListener2.onFinish();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DownloadItem> getDownloadItemListWithPriority(List<DownloadItem> list, DownloadTask.Priority priority) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526544495")) {
            return (List) ipChange.ipc$dispatch("-1526544495", new Object[]{this, list, priority});
        }
        ArrayList arrayList = new ArrayList();
        if (priority != null && list != null && !list.isEmpty()) {
            for (DownloadItem downloadItem : list) {
                if (downloadItem.getPriority() == priority) {
                    arrayList.add(downloadItem);
                }
            }
        }
        return arrayList;
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void download(final DownloadTask downloadTask, IDownloadListener iDownloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1331851434")) {
            ipChange.ipc$dispatch("1331851434", new Object[]{this, downloadTask, iDownloadListener});
            return;
        }
        final SystemDownloadEvent systemDownloadEvent = new SystemDownloadEvent(downloadTask.getDownloadCount(), iDownloadListener);
        if (this.isFocusPriorityGroup) {
            final LinkedList linkedList = new LinkedList(Arrays.asList(DownloadTask.Priority.values()));
            downloadSoList(getDownloadItemListWithPriority(downloadTask.getDownloadItems(), (DownloadTask.Priority) linkedList.pollLast()), systemDownloadEvent, new SystemDownloadListener() { // from class: com.youku.arch.solid.download.SystemDownloadImp.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.arch.solid.download.SystemDownloadImp.SystemDownloadListener
                public void onFinish() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1741202927")) {
                        ipChange2.ipc$dispatch("1741202927", new Object[]{this});
                    } else if (linkedList.size() > 0) {
                        SystemDownloadImp systemDownloadImp = SystemDownloadImp.this;
                        systemDownloadImp.downloadSoList(systemDownloadImp.getDownloadItemListWithPriority(downloadTask.getDownloadItems(), (DownloadTask.Priority) linkedList.pollLast()), systemDownloadEvent, this);
                    }
                }
            });
            return;
        }
        List<DownloadItem> downloadItems = downloadTask.getDownloadItems();
        Collections.sort(downloadItems);
        downloadSoList(downloadItems, systemDownloadEvent, null);
    }

    @Override // com.youku.arch.solid.download.IDownloader
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193703908")) {
            ipChange.ipc$dispatch("193703908", new Object[]{this});
        }
    }

    public SystemDownloadImp(boolean z) {
        this.isFocusPriorityGroup = false;
        this.isFocusPriorityGroup = z;
    }
}
