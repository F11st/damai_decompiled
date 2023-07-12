package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ConfigFetcher;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.OnResourcesGetListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.fileprocessor.AfterDownloadProcessor;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.utils.ContextUtil;
import com.youku.live.dago.widgetlib.interactive.resource.utils.DateUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.HttpUtils;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceUTUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLResourceManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LIVE_GROUP_NAME = "YKLive";
    private static volatile YKLResourceManager sInstance;
    private String TAG = "YKLResouceManager";
    private String mAppId = "youku";
    private boolean mHasInited = false;
    private Map<String, Config> mConfigMap = new HashMap();

    public YKLResourceManager() {
        init(this.mAppId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Config getConfig(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "477289194")) {
            return (Config) ipChange.ipc$dispatch("477289194", new Object[]{this, str});
        }
        if (!this.mConfigMap.containsKey(str)) {
            this.mConfigMap.put(str, new Config(str, new ArrayList()));
        }
        return this.mConfigMap.get(str);
    }

    public static YKLResourceManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1455688123")) {
            return (YKLResourceManager) ipChange.ipc$dispatch("1455688123", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (YKLResourceManager.class) {
                if (sInstance == null) {
                    sInstance = new YKLResourceManager();
                }
            }
        }
        return sInstance;
    }

    private void init(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580523382")) {
            ipChange.ipc$dispatch("-580523382", new Object[]{this, str});
            return;
        }
        Log.d(this.TAG, "resource init");
        if (this.mHasInited) {
            Log.d(this.TAG, "has inited , return");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mAppId = str;
            AfterDownloadProcessor.registerNamespaceProcessor(str, new YKLProcessor());
            YKLPrefetchManager.getInstance().registerConfigFetcher(str, new ConfigFetcher() { // from class: com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.ConfigFetcher
                public Config onFetchingStart() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-385023420") ? (Config) ipChange2.ipc$dispatch("-385023420", new Object[]{this}) : YKLResourceManager.this.getConfig(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadResource(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1040679856")) {
            ipChange.ipc$dispatch("-1040679856", new Object[]{this, str, str2});
        } else {
            YKLPrefetchManager.getInstance().loadResources(str, str2, new OnResourcesGetListener() { // from class: com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.OnResourcesGetListener
                public void onBatchResoucesFinish(ResourceEntity resourceEntity) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "438704867")) {
                        ipChange2.ipc$dispatch("438704867", new Object[]{this, resourceEntity});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.resource.prefetch.OnResourcesGetListener
                public void onResourceGet(ResourceEntity resourceEntity) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1235946541")) {
                        ipChange2.ipc$dispatch("-1235946541", new Object[]{this, resourceEntity});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResourceEntity.Resource parseResource(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "668002242")) {
            return (ResourceEntity.Resource) ipChange.ipc$dispatch("668002242", new Object[]{this, jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id");
        Uri parse = Uri.parse(jSONObject.optString("url"));
        long stringToLong = DateUtils.stringToLong(jSONObject.optString("invalidTime"));
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new ResourceEntity.Resource(optString, "", parse, stringToLong);
    }

    private List<ResourceEntity.Resource> parseResourceGroup(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ResourceEntity.Resource parseResource;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773032059")) {
            return (List) ipChange.ipc$dispatch("773032059", new Object[]{this, jSONObject});
        }
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("result")) != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null && (parseResource = parseResource(jSONObject2)) != null) {
                        arrayList.add(parseResource);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public List<String> getResourcePath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718454388")) {
            return (List) ipChange.ipc$dispatch("-718454388", new Object[]{this, str});
        }
        if (!this.mHasInited) {
            Log.d(this.TAG, "you should init first");
            return null;
        }
        ResourceEntity findCache = YKLResourcesCacheManager.findCache(this.mAppId, str);
        if (YKLPrefetchManager.getInstance().hasContent(str, YKLPrefetchManager.getInstance().getResourceConfig(this.mAppId), findCache)) {
            Log.d(this.TAG, "has entity");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < findCache.resourceList.size(); i++) {
                String str2 = findCache.resourceList.get(i).path;
                if (!TextUtils.isEmpty(str2)) {
                    File file = new File(str2);
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            String str3 = this.TAG;
                            Log.d(str3, "has entity file exist, length = " + listFiles.length);
                            arrayList.add(findCache.resourceList.get(i).path);
                        } else {
                            FileUtils.deleteFolder(file.getAbsolutePath());
                        }
                    }
                }
            }
            return arrayList;
        }
        reloadResouce(str);
        return null;
    }

    public List<String> getResourcesPath(String str, String str2, boolean z, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400061681")) {
            return (List) ipChange.ipc$dispatch("-1400061681", new Object[]{this, str, str2, Boolean.valueOf(z), str3, str4});
        }
        String cacheResourcePath = YKLResourcesCacheManager.getCacheResourcePath(str, str3 + "_tag");
        Log.d("xxtt", " ========= : " + cacheResourcePath);
        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "getResourcesPath =  " + cacheResourcePath);
        if (YKLResourcesCacheManager.checkPathValid(cacheResourcePath)) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(cacheResourcePath)) {
                File file = new File(cacheResourcePath);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "has entity file exist, length =  " + listFiles.length);
                        arrayList.add(cacheResourcePath);
                    } else {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "FileUtils.deleteFolder(file.getAbsolutePath()); ");
                        FileUtils.deleteFolder(file.getAbsolutePath());
                    }
                } else {
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "!!!!!!!file.exists() && file.isDirectory() ");
                }
            }
            if (arrayList.size() == 0) {
                ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "pathList.size() == 0 ");
                return null;
            }
            return arrayList;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", " !!!! YKLResourcesCacheManager.checkPathValid(path)");
        return null;
    }

    public void reloadResouce(String str, String str2, boolean z, String str3, String str4, YKLDownloadListener yKLDownloadListener, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777267516")) {
            ipChange.ipc$dispatch("1777267516", new Object[]{this, str, str2, Boolean.valueOf(z), str3, str4, yKLDownloadListener, Boolean.valueOf(z2)});
            return;
        }
        ArrayList arrayList = new ArrayList();
        YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
        yKLDownloadBean.url = str2;
        yKLDownloadBean.isZip = z;
        yKLDownloadBean.type = str3;
        yKLDownloadBean.fileName = str4 + "_tag";
        arrayList.add(yKLDownloadBean);
        YKLPrefetchManager.getInstance().loadResources(str, arrayList, yKLDownloadListener, z2);
    }

    public void reloadResouce(String str, List<YKLDownloadBean> list, YKLDownloadListener yKLDownloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1107173543")) {
            ipChange.ipc$dispatch("-1107173543", new Object[]{this, str, list, yKLDownloadListener, Boolean.valueOf(z)});
        } else {
            YKLPrefetchManager.getInstance().loadResources(str, list, yKLDownloadListener, z);
        }
    }

    private void reloadResouce(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360264341")) {
            ipChange.ipc$dispatch("360264341", new Object[]{this, str});
            return;
        }
        ResourceEntity.Resource resourceConfig = YKLPrefetchManager.getInstance().getResourceConfig(this.mAppId, str);
        if (resourceConfig != null && resourceConfig.uri != null) {
            loadResource(this.mAppId, str);
            return;
        }
        Log.d(this.TAG, "no resource , get from server.");
        HttpUtils.getResourceById(ContextUtil.getApplicationContext(), this.mAppId, str, new MtopCallback.MtopFinishListener() { // from class: com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
            public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "633144939")) {
                    ipChange2.ipc$dispatch("633144939", new Object[]{this, mtopFinishEvent, obj});
                    return;
                }
                MtopResponse mtopResponse = mtopFinishEvent.mtopResponse;
                if (mtopResponse.isApiSuccess()) {
                    ResourceUTUtils.getResourceById(str, true);
                    ResourceEntity.Resource parseResource = YKLResourceManager.this.parseResource(mtopResponse.getDataJsonObject());
                    if (parseResource != null) {
                        YKLPrefetchManager.getInstance().getResourceConfig(YKLResourceManager.this.mAppId).getConfigItems().add(parseResource);
                        YKLResourceManager yKLResourceManager = YKLResourceManager.this;
                        yKLResourceManager.loadResource(yKLResourceManager.mAppId, str);
                        return;
                    }
                    ResourceUTUtils.getResourceById(str, false);
                }
            }
        });
    }
}
