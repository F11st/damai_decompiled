package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ConfigFetcher;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.OnResourcesGetListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceOrangeUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceUTUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.jq1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLPrefetchManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "yklresouce";
    private static volatile YKLPrefetchManager sInstance;
    private Map<String, ConfigFetcher> mConfigFetchers = new HashMap();
    public YKLResourcesDownloader mDownloader = new YKLResourcesDownloader();

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
            ResourceUTUtils.downloadFileResult("", str, false);
            Log.d(YKLPrefetchManager.TAG, "download error " + this.mConfig.getNamespace() + ", errorCode:" + i + ", msg:" + str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            String subStringFileName = FileUtils.subStringFileName(str2);
            ResourceUTUtils.downloadFileResult(subStringFileName, str, true);
            Log.d(YKLPrefetchManager.TAG, "download finish thread id = " + Thread.currentThread().getName());
            Log.d(YKLPrefetchManager.TAG, "download finish for " + subStringFileName + ", namespace:" + this.mConfig.getNamespace());
            AfterDownloadProcessor.process(this.mConfig, subStringFileName, str2);
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
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

    private YKLPrefetchManager() {
    }

    private List<ResourceEntity.Resource> getDownloadResource(Config config, ResourceEntity resourceEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872031169")) {
            return (List) ipChange.ipc$dispatch("-872031169", new Object[]{this, config, resourceEntity});
        }
        if (!hasContent(null, config, resourceEntity)) {
            ArrayList arrayList = (config == null || config.getConfigItems() == null) ? null : (ArrayList) ((ArrayList) config.getConfigItems()).clone();
            if (arrayList != null) {
                Log.d(TAG, "config download resource size = " + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResourceEntity.Resource resource = (ResourceEntity.Resource) it.next();
                    if (resource != null && resourceEntity != null && resourceEntity.resourceList != null) {
                        Log.d(TAG, "config download entity size = " + resourceEntity.resourceList.size());
                        for (ResourceEntity.Resource resource2 : resourceEntity.resourceList) {
                            if (resource2 != null && resource.key.equals(resource2.key)) {
                                it.remove();
                            }
                        }
                    }
                }
                Log.d(TAG, "get download resource size = " + arrayList.size());
                return arrayList;
            }
        }
        return null;
    }

    public static YKLPrefetchManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1846905701")) {
            return (YKLPrefetchManager) ipChange.ipc$dispatch("-1846905701", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (YKLPrefetchManager.class) {
                if (sInstance == null) {
                    sInstance = new YKLPrefetchManager();
                }
            }
        }
        return sInstance;
    }

    public ResourceEntity.Resource getResourceConfig(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638122386")) {
            return (ResourceEntity.Resource) ipChange.ipc$dispatch("-638122386", new Object[]{this, str, str2});
        }
        if (getInstance().mConfigFetchers.get(str) == null || getInstance().mConfigFetchers.get(str).onFetchingStart() == null) {
            return null;
        }
        return getInstance().mConfigFetchers.get(str).onFetchingStart().getResourceWithKey(str2);
    }

    public boolean hasContent(String str, Config config, ResourceEntity resourceEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482135431")) {
            return ((Boolean) ipChange.ipc$dispatch("482135431", new Object[]{this, str, config, resourceEntity})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return hasContent(resourceEntity) && config != null && config.getConfigItems() != null && config.getConfigItems().size() <= resourceEntity.resourceList.size();
        }
        return hasContent(resourceEntity);
    }

    public void loadResources(String str, OnResourcesGetListener onResourcesGetListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428081996")) {
            ipChange.ipc$dispatch("1428081996", new Object[]{this, str, onResourcesGetListener});
        } else {
            loadResources(str, null, onResourcesGetListener);
        }
    }

    public void registerConfigFetcher(String str, ConfigFetcher configFetcher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218935198")) {
            ipChange.ipc$dispatch("218935198", new Object[]{this, str, configFetcher});
        } else {
            registerConfigFetcher(str, configFetcher, false);
        }
    }

    public void loadResources(String str, List<YKLDownloadBean> list, YKLDownloadListener yKLDownloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434233550")) {
            ipChange.ipc$dispatch("-1434233550", new Object[]{this, str, list, yKLDownloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d("ykl-download", "is download in 4G = " + z);
        getInstance().mDownloader.download(str, list, yKLDownloadListener, z);
    }

    public void registerConfigFetcher(String str, ConfigFetcher configFetcher, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802897674")) {
            ipChange.ipc$dispatch("-1802897674", new Object[]{this, str, configFetcher, Boolean.valueOf(z)});
        } else if (configFetcher == null) {
        } else {
            this.mConfigFetchers.put(str, configFetcher);
            if (hasContent(null, configFetcher.onFetchingStart(), YKLResourcesCacheManager.findCache(str, null))) {
                return;
            }
            this.mDownloader.batchDownload(configFetcher.onFetchingStart(), new ResourceDownloadListener(configFetcher.onFetchingStart(), null, null), ResourceOrangeUtils.isBatchDownLoadIn4G());
        }
    }

    public Config getResourceConfig(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601435919")) {
            return (Config) ipChange.ipc$dispatch("1601435919", new Object[]{this, str});
        }
        if (getInstance().mConfigFetchers.get(str) != null) {
            return getInstance().mConfigFetchers.get(str).onFetchingStart();
        }
        return null;
    }

    public boolean hasContent(ResourceEntity resourceEntity) {
        List<ResourceEntity.Resource> list;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1829292835") ? ((Boolean) ipChange.ipc$dispatch("-1829292835", new Object[]{this, resourceEntity})).booleanValue() : (resourceEntity == null || (list = resourceEntity.resourceList) == null || list.size() <= 0) ? false : true;
    }

    public void loadResources(String str, String str2, OnResourcesGetListener onResourcesGetListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882747242")) {
            ipChange.ipc$dispatch("-1882747242", new Object[]{this, str, str2, onResourcesGetListener});
            return;
        }
        ResourceEntity findCache = YKLResourcesCacheManager.findCache(str, str2);
        Config config = null;
        if (getInstance().mConfigFetchers != null && getInstance().mConfigFetchers.get(str) != null) {
            config = getInstance().mConfigFetchers.get(str).onFetchingStart();
        }
        if (!hasContent(str2, config, findCache)) {
            ResourceEntity resourceEntity = new ResourceEntity();
            if (str2 != null) {
                if (ResourceOrangeUtils.isDownLoadResource()) {
                    getInstance().mDownloader.download(str, str2, new ResourceDownloadListener(config, resourceEntity, onResourcesGetListener), ResourceOrangeUtils.isDownLoadIn4G());
                    return;
                } else {
                    Log.d(TAG, "orange forbid download key");
                    return;
                }
            }
            Log.d(TAG, "prepare batch");
            if (ResourceOrangeUtils.isBatchDownLoadResource()) {
                Log.d(TAG, "batch download");
                getInstance().mDownloader.batchDownload(str, getDownloadResource(config, resourceEntity), new ResourceDownloadListener(config, resourceEntity, onResourcesGetListener), ResourceOrangeUtils.isBatchDownLoadIn4G());
                return;
            }
            Log.d(TAG, "orange forbid batch download");
            return;
        }
        Log.d(TAG, "already has file");
        onResourcesGetListener.onResourceGet(findCache);
        onResourcesGetListener.onBatchResoucesFinish(findCache);
    }
}
