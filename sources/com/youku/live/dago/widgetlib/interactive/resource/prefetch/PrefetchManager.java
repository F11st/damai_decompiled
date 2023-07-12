package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import android.net.Uri;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.jq1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PrefetchManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "PrefetchManager";
    private static volatile PrefetchManager sInstance;
    private Map<String, ConfigFetcher> mConfigFetchers = new HashMap();
    private ResourcesDownloader mDownloader = new ResourcesDownloader();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ResourceDownloadListener implements DownloadListener {
        Config mConfig;
        ResourceEntity mEntity;
        OnResourcesGetListener mListener;

        public ResourceDownloadListener(Config config, ResourceEntity resourceEntity, OnResourcesGetListener onResourcesGetListener) {
            this.mEntity = resourceEntity;
            this.mListener = onResourcesGetListener;
            this.mConfig = config;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            Log.d(PrefetchManager.TAG, "download error " + this.mConfig.getNamespace() + ", errorCode:" + i + ", msg:" + str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            String findKeyFromUrl = this.mConfig.findKeyFromUrl(str);
            Log.d(PrefetchManager.TAG, "download finish for " + findKeyFromUrl + ", namespace:" + this.mConfig.getNamespace() + ", filepath:" + str2);
            AfterDownloadProcessor.ProcessedResource process = AfterDownloadProcessor.process(this.mConfig, findKeyFromUrl, str2);
            ResourceEntity resourceEntity = new ResourceEntity();
            String str3 = (process == null || process.getProcessedFilePath() == null || process.getProcessedFilePath().length <= 0) ? "" : process.getProcessedFilePath()[0];
            resourceEntity.resourceList.add(new ResourceEntity.Resource(findKeyFromUrl, str3, Uri.parse(str)));
            ResourceEntity resourceEntity2 = this.mEntity;
            if (resourceEntity2 != null) {
                resourceEntity2.resourceList.add(new ResourceEntity.Resource(findKeyFromUrl, str3, Uri.parse(str)));
            }
            ResourcesCacheManager.putCache(this.mConfig.getNamespace(), findKeyFromUrl, resourceEntity);
            OnResourcesGetListener onResourcesGetListener = this.mListener;
            if (onResourcesGetListener != null) {
                onResourcesGetListener.onResourceGet(resourceEntity);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
            Log.d(PrefetchManager.TAG, "download " + this.mConfig.getNamespace() + ", progress:" + i);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            ResourceEntity resourceEntity;
            OnResourcesGetListener onResourcesGetListener = this.mListener;
            if (onResourcesGetListener == null || (resourceEntity = this.mEntity) == null) {
                return;
            }
            onResourcesGetListener.onBatchResoucesFinish(resourceEntity);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
        }
    }

    private PrefetchManager() {
    }

    public static PrefetchManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581884255")) {
            return (PrefetchManager) ipChange.ipc$dispatch("-1581884255", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (PrefetchManager.class) {
                if (sInstance == null) {
                    sInstance = new PrefetchManager();
                }
            }
        }
        return sInstance;
    }

    public static ResourceEntity.Resource getResourceConfig(String str, String str2) {
        Config onFetchingStart;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859554927")) {
            return (ResourceEntity.Resource) ipChange.ipc$dispatch("859554927", new Object[]{str, str2});
        }
        if (getInstance().mConfigFetchers == null || getInstance().mConfigFetchers.get(str) == null || (onFetchingStart = getInstance().mConfigFetchers.get(str).onFetchingStart()) == null) {
            return null;
        }
        return onFetchingStart.getResourceWithKey(str2);
    }

    private static boolean hasContent(Config config, ResourceEntity resourceEntity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1644997156") ? ((Boolean) ipChange.ipc$dispatch("-1644997156", new Object[]{config, resourceEntity})).booleanValue() : hasContent(resourceEntity) && config != null && config.getConfigItems() != null && config.getConfigItems().size() == resourceEntity.resourceList.size();
    }

    public static void loadResources(String str, OnResourcesGetListener onResourcesGetListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159594509")) {
            ipChange.ipc$dispatch("1159594509", new Object[]{str, onResourcesGetListener});
        } else {
            loadResources(str, null, onResourcesGetListener);
        }
    }

    public static void registerConfigFetcher(String str, ConfigFetcher configFetcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011389629")) {
            ipChange.ipc$dispatch("2011389629", new Object[]{str, configFetcher});
        } else {
            registerConfigFetcher(str, configFetcher, false);
        }
    }

    public static void loadResources(String str, String str2, OnResourcesGetListener onResourcesGetListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-950700777")) {
            ipChange.ipc$dispatch("-950700777", new Object[]{str, str2, onResourcesGetListener});
            return;
        }
        ResourceEntity findCache = ResourcesCacheManager.findCache(str, str2);
        if (!hasContent(findCache)) {
            Config config = null;
            if (getInstance().mConfigFetchers != null && getInstance().mConfigFetchers.get(str) != null) {
                config = getInstance().mConfigFetchers.get(str).onFetchingStart();
            }
            if (config != null) {
                ResourceEntity resourceEntity = new ResourceEntity();
                if (str2 != null) {
                    getInstance().mDownloader.download(str, str2, new ResourceDownloadListener(config, resourceEntity, onResourcesGetListener), true);
                    return;
                } else {
                    getInstance().mDownloader.batchDownload(config, new ResourceDownloadListener(config, resourceEntity, onResourcesGetListener), true);
                    return;
                }
            }
            return;
        }
        onResourcesGetListener.onResourceGet(findCache);
        onResourcesGetListener.onBatchResoucesFinish(findCache);
    }

    public static void registerConfigFetcher(String str, ConfigFetcher configFetcher, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071385161")) {
            ipChange.ipc$dispatch("-2071385161", new Object[]{str, configFetcher, Boolean.valueOf(z)});
            return;
        }
        getInstance().mConfigFetchers.put(str, configFetcher);
        if (hasContent(ResourcesCacheManager.findCache(str, null))) {
            return;
        }
        getInstance().mDownloader.batchDownload(configFetcher.onFetchingStart(), new ResourceDownloadListener(configFetcher.onFetchingStart(), null, null), false);
    }

    private static boolean hasContent(ResourceEntity resourceEntity) {
        List<ResourceEntity.Resource> list;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-815695748") ? ((Boolean) ipChange.ipc$dispatch("-815695748", new Object[]{resourceEntity})).booleanValue() : (resourceEntity == null || (list = resourceEntity.resourceList) == null || list.size() <= 0) ? false : true;
    }

    public static Config getResourceConfig(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377036462")) {
            return (Config) ipChange.ipc$dispatch("377036462", new Object[]{str});
        }
        if (getInstance().mConfigFetchers == null || getInstance().mConfigFetchers.get(str) == null) {
            return null;
        }
        return getInstance().mConfigFetchers.get(str).onFetchingStart();
    }
}
