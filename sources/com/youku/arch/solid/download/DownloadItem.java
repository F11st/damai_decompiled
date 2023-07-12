package com.youku.arch.solid.download;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.solid.ZipDownloadItem;
import com.youku.arch.solid.download.DownloadTask;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DownloadItem implements Comparable<DownloadItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String md5;
    private String name;
    private String path;
    private DownloadTask.Priority priority;
    private String url;
    private ZipDownloadItem zipDownloadItem;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Builder {
        private ZipDownloadItem degradeDownloadItems;
        private String md5;
        private String name;
        private String path;
        private DownloadTask.Priority priority;
        private String url;

        public DownloadItem build() {
            String str = this.url;
            if (str != null && !str.isEmpty()) {
                String str2 = this.path;
                if (str2 != null && !str2.isEmpty()) {
                    String str3 = this.name;
                    if (str3 != null && !str3.isEmpty()) {
                        DownloadItem downloadItem = new DownloadItem();
                        downloadItem.url = this.url;
                        downloadItem.md5 = this.md5;
                        downloadItem.path = this.path;
                        downloadItem.name = this.name;
                        downloadItem.priority = this.priority;
                        downloadItem.zipDownloadItem = this.degradeDownloadItems;
                        return downloadItem;
                    }
                    throw new RuntimeException("DownloadRequest.name cann't be null or empty string.");
                }
                throw new RuntimeException("DownloadRequest.path cann't be null or empty string.");
            }
            throw new RuntimeException("DownloadRequest.url cann't be null or empty string.");
        }

        public Builder setMd5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setPath(String str) {
            this.path = str;
            return this;
        }

        public Builder setPriority(DownloadTask.Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setZipDownloadItem(ZipDownloadItem zipDownloadItem) {
            this.degradeDownloadItems = zipDownloadItem;
            return this;
        }
    }

    public String getMd5() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2090955302") ? (String) ipChange.ipc$dispatch("-2090955302", new Object[]{this}) : this.md5;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-650802843") ? (String) ipChange.ipc$dispatch("-650802843", new Object[]{this}) : this.name;
    }

    public String getPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1532255745") ? (String) ipChange.ipc$dispatch("-1532255745", new Object[]{this}) : this.path;
    }

    public DownloadTask.Priority getPriority() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1989213590") ? (DownloadTask.Priority) ipChange.ipc$dispatch("1989213590", new Object[]{this}) : this.priority;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-451392693") ? (String) ipChange.ipc$dispatch("-451392693", new Object[]{this}) : this.url;
    }

    public ZipDownloadItem getZipDownloadItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2070792886") ? (ZipDownloadItem) ipChange.ipc$dispatch("-2070792886", new Object[]{this}) : this.zipDownloadItem;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DownloadItem downloadItem) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-31205499") ? ((Integer) ipChange.ipc$dispatch("-31205499", new Object[]{this, downloadItem})).intValue() : downloadItem.priority.code - this.priority.code;
    }
}
