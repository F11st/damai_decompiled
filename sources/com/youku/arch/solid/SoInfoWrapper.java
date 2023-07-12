package com.youku.arch.solid;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.download.DownloadTask;
import com.youku.arch.solid.model.CompressInfo;
import com.youku.arch.solid.model.SoInfo;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class SoInfoWrapper implements ZipDownloadItem {
    private static transient /* synthetic */ IpChange $ipChange;
    private SoGroupWrapper belongGroup;
    private volatile boolean hasDrive;
    private File localFile;
    private final DownloadTask.Priority priority;
    private final SoInfo soInfo;
    private volatile Status status = Status.WAIT_TO_DOWNLOAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoInfoWrapper(SoInfo soInfo) {
        this.soInfo = soInfo;
        this.priority = DownloadTask.Priority.getPriorityWithCode(soInfo.priority);
    }

    CompressInfo compressInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "230872695") ? (CompressInfo) ipChange.ipc$dispatch("230872695", new Object[]{this}) : this.soInfo.compressInfo;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public void downloadFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795853393")) {
            ipChange.ipc$dispatch("-1795853393", new Object[]{this});
        } else {
            updateStatus(Status.DOWNLOAD_FAIL);
        }
    }

    public SoGroupWrapper getBelongGroup() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1802311715") ? (SoGroupWrapper) ipChange.ipc$dispatch("1802311715", new Object[]{this}) : this.belongGroup;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipMd5() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-828352098") ? (String) ipChange.ipc$dispatch("-828352098", new Object[]{this}) : compressInfo().md5;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164809183")) {
            return (String) ipChange.ipc$dispatch("-164809183", new Object[]{this});
        }
        return soFileName() + ".zip";
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public DownloadTask.Priority getZipPriority(boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-520982366") ? (DownloadTask.Priority) ipChange.ipc$dispatch("-520982366", new Object[]{this, Boolean.valueOf(z)}) : priority(z);
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public String getZipUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "811210511") ? (String) ipChange.ipc$dispatch("811210511", new Object[]{this}) : compressInfo().url;
    }

    boolean isAutoDownload() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474536968") ? ((Boolean) ipChange.ipc$dispatch("-474536968", new Object[]{this})).booleanValue() : this.soInfo.isAutoDownload;
    }

    String libName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1138506181") ? (String) ipChange.ipc$dispatch("-1138506181", new Object[]{this}) : this.soInfo.libName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File localFile() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1857516287") ? (File) ipChange.ipc$dispatch("1857516287", new Object[]{this}) : this.localFile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String md5() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1354830345") ? (String) ipChange.ipc$dispatch("1354830345", new Object[]{this}) : this.soInfo.md5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needDownload() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388023493")) {
            return ((Boolean) ipChange.ipc$dispatch("-1388023493", new Object[]{this})).booleanValue();
        }
        if (this.status == Status.DOWNLOAD_FAIL) {
            return true;
        }
        if (this.status == Status.WAIT_TO_DOWNLOAD) {
            return isAutoDownload() || this.hasDrive;
        }
        return false;
    }

    @Override // com.youku.arch.solid.ZipDownloadItem
    public boolean needDownloadZip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1466463274") ? ((Boolean) ipChange.ipc$dispatch("-1466463274", new Object[]{this})).booleanValue() : compressInfo() != null && status() == Status.WAIT_TO_DOWNLOAD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadTask.Priority priority(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407760023")) {
            return (DownloadTask.Priority) ipChange.ipc$dispatch("407760023", new Object[]{this, Boolean.valueOf(z)});
        }
        if (this.status == Status.DOWNLOAD_FAIL) {
            return DownloadTask.Priority.IMPERATIVE;
        }
        if (z) {
            return this.priority;
        }
        return DownloadTask.Priority.IMPERATIVE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBelongGroup(SoGroupWrapper soGroupWrapper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109599985")) {
            ipChange.ipc$dispatch("109599985", new Object[]{this, soGroupWrapper});
        } else if (this.belongGroup != null || soGroupWrapper == null) {
        } else {
            this.belongGroup = soGroupWrapper;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrive() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671470611")) {
            ipChange.ipc$dispatch("-1671470611", new Object[]{this});
        } else {
            this.hasDrive = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocalFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241995961")) {
            ipChange.ipc$dispatch("-241995961", new Object[]{this, file});
        } else {
            this.localFile = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String soFileName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "151879982") ? (String) ipChange.ipc$dispatch("151879982", new Object[]{this}) : this.soInfo.soName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status status() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "921898073") ? (Status) ipChange.ipc$dispatch("921898073", new Object[]{this}) : this.status;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142505865")) {
            return (String) ipChange.ipc$dispatch("-142505865", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n\t\tSoInfo{\n\t\"compressInfo.url\": ");
        CompressInfo compressInfo = this.soInfo.compressInfo;
        sb.append(compressInfo == null ? "null" : compressInfo.url);
        sb.append("\n\t\"compressInfo.md5\": ");
        CompressInfo compressInfo2 = this.soInfo.compressInfo;
        sb.append(compressInfo2 != null ? compressInfo2.md5 : "null");
        sb.append("\n\t\t\t\"md5\": \"");
        sb.append(this.soInfo.md5);
        sb.append("\"");
        sb.append(",\n\t\t\t\"url\": \"");
        sb.append(this.soInfo.url);
        sb.append("\"");
        sb.append(",\n\t\t\t\"libName\": \"");
        sb.append(this.soInfo.libName);
        sb.append("\"");
        sb.append(",\n\t\t\t\"soName\": \"");
        sb.append(this.soInfo.soName);
        sb.append("\"");
        sb.append(",\n\t\t\t\"status\": ");
        sb.append(this.status);
        sb.append("\n\t\t}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateStatus(Status status) {
        SoGroupWrapper soGroupWrapper;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-80796756")) {
            ipChange.ipc$dispatch("-80796756", new Object[]{this, status});
            return;
        }
        this.status = status;
        if (status != Status.DOWNLOADED || (soGroupWrapper = this.belongGroup) == null) {
            return;
        }
        soGroupWrapper.onSoDownloaded();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String url() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1300574342") ? (String) ipChange.ipc$dispatch("-1300574342", new Object[]{this}) : this.soInfo.url;
    }
}
