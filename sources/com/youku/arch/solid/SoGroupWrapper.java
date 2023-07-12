package com.youku.arch.solid;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.lifecycle.OnSoGroupStatusChangeListener;
import com.youku.arch.solid.lifecycle.SolidResponse;
import com.youku.arch.solid.log.SLog;
import com.youku.arch.solid.model.CompressInfo;
import com.youku.arch.solid.model.SoGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SoGroupWrapper implements ZipDownloadItem {
    private static transient /* synthetic */ IpChange $ipChange;
    private final SoGroup soGroup;
    private volatile Status status = Status.WAIT_TO_DOWNLOAD;
    private final List<SoInfoWrapper> soItemList = new ArrayList();
    private final AtomicInteger completeCount = new AtomicInteger(0);
    private final List<OnSoGroupStatusChangeListener> listeners = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoGroupWrapper(SoGroup soGroup) {
        this.soGroup = soGroup;
    }

    private boolean existDownloadedSo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929248446")) {
            return ((Boolean) ipChange.ipc$dispatch("1929248446", new Object[]{this})).booleanValue();
        }
        for (SoInfoWrapper soInfoWrapper : getSoInfoList()) {
            if (soInfoWrapper.status() == Status.DOWNLOADED) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnSoGroupReadyListener(OnSoGroupStatusChangeListener onSoGroupStatusChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-661873053")) {
            ipChange.ipc$dispatch("-661873053", new Object[]{this, onSoGroupStatusChangeListener});
        } else if (onSoGroupStatusChangeListener == null) {
        } else {
            synchronized (this.listeners) {
                if (this.status == Status.DOWNLOADED) {
                    notifySoGroupReady(onSoGroupStatusChangeListener);
                } else {
                    this.listeners.add(onSoGroupStatusChangeListener);
                }
            }
        }
    }

    CompressInfo compressInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-550029736") ? (CompressInfo) ipChange.ipc$dispatch("-550029736", new Object[]{this}) : this.soGroup.compressInfo;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public void downloadFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-288880496")) {
            ipChange.ipc$dispatch("-288880496", new Object[]{this});
        } else {
            updateStatus(Status.DOWNLOAD_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SoInfoWrapper> getSoInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-914322383") ? (List) ipChange.ipc$dispatch("-914322383", new Object[]{this}) : this.soItemList;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipMd5() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1681412287") ? (String) ipChange.ipc$dispatch("1681412287", new Object[]{this}) : compressInfo().md5;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "328475424")) {
            return (String) ipChange.ipc$dispatch("328475424", new Object[]{this});
        }
        return name() + ".zip";
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public DownloadTask.Priority getZipPriority(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611831135")) {
            return (DownloadTask.Priority) ipChange.ipc$dispatch("-611831135", new Object[]{this, Boolean.valueOf(z)});
        }
        if (this.status == Status.DOWNLOAD_FAIL) {
            return DownloadTask.Priority.IMPERATIVE;
        }
        if (z) {
            return DownloadTask.Priority.getPriorityWithCode(this.soGroup.priority);
        }
        return DownloadTask.Priority.IMPERATIVE;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-973992400") ? (String) ipChange.ipc$dispatch("-973992400", new Object[]{this}) : compressInfo().url;
    }

    boolean isAutoDownload() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "322438297") ? ((Boolean) ipChange.ipc$dispatch("322438297", new Object[]{this})).booleanValue() : this.soGroup.isAutoDownload;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void linkSoInfo(SoInfoWrapper soInfoWrapper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799962657")) {
            ipChange.ipc$dispatch("1799962657", new Object[]{this, soInfoWrapper});
        } else if (soInfoWrapper == null) {
        } else {
            this.soItemList.add(soInfoWrapper);
            soInfoWrapper.setBelongGroup(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String name() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1954800469") ? (String) ipChange.ipc$dispatch("1954800469", new Object[]{this}) : this.soGroup.name;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public boolean needDownloadZip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1764933461") ? ((Boolean) ipChange.ipc$dispatch("1764933461", new Object[]{this})).booleanValue() : (compressInfo() == null || status() != Status.WAIT_TO_DOWNLOAD || existDownloadedSo()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifySoGroupReady(final OnSoGroupStatusChangeListener onSoGroupStatusChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409474608")) {
            ipChange.ipc$dispatch("-409474608", new Object[]{this, onSoGroupStatusChangeListener});
            return;
        }
        final SolidResponse solidResponse = new SolidResponse();
        solidResponse.groupName = new String(this.soGroup.name.getBytes());
        solidResponse.status = this.status;
        Solid.getInstance().executeTask(new Runnable() { // from class: com.youku.arch.solid.SoGroupWrapper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-741384548")) {
                    ipChange2.ipc$dispatch("-741384548", new Object[]{this});
                } else {
                    onSoGroupStatusChangeListener.onResponse(solidResponse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSoDownloaded() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120436340")) {
            ipChange.ipc$dispatch("1120436340", new Object[]{this});
        } else if (this.completeCount.incrementAndGet() == this.soItemList.size()) {
            updateStatus(Status.DOWNLOADED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status status() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1769362042") ? (Status) ipChange.ipc$dispatch("1769362042", new Object[]{this}) : this.status;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601022262")) {
            return (String) ipChange.ipc$dispatch("1601022262", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n.\nSoGroup{\n\t\"compressInfo.url\": ");
        CompressInfo compressInfo = this.soGroup.compressInfo;
        sb.append(compressInfo == null ? "null" : compressInfo.url);
        sb.append("\n\t\"compressInfo.md5\": ");
        CompressInfo compressInfo2 = this.soGroup.compressInfo;
        sb.append(compressInfo2 != null ? compressInfo2.md5 : "null");
        sb.append("\n\t\"isAutoDownload\": ");
        sb.append(this.soGroup.isAutoDownload);
        sb.append(",\n\t\"name\": \"");
        sb.append(this.soGroup.name);
        sb.append("\"");
        sb.append(",\n\t\"priority\": ");
        sb.append(this.soGroup.priority);
        sb.append(",\n\t\"soItemList\": ");
        sb.append(this.soItemList);
        sb.append("\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateStatus(Status status) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972889195")) {
            ipChange.ipc$dispatch("1972889195", new Object[]{this, status});
            return;
        }
        this.status = status;
        if (status == Status.DOWNLOADED) {
            synchronized (this.listeners) {
                for (OnSoGroupStatusChangeListener onSoGroupStatusChangeListener : this.listeners) {
                    notifySoGroupReady(onSoGroupStatusChangeListener);
                }
            }
            SLog.e("SoGroup", "group success : " + this.soGroup.name);
        }
    }
}
