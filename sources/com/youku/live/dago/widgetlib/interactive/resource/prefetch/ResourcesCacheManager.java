package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.utils.ContextUtil;
import java.io.File;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ResourcesCacheManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String DATA_FILE_DIR;
    private static String PREFETCH_DIR;

    private static void ensureStorage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-876001715")) {
            ipChange.ipc$dispatch("-876001715", new Object[0]);
        } else if (DATA_FILE_DIR == null || PREFETCH_DIR == null) {
            DATA_FILE_DIR = ContextUtil.getApplicationContext().getFilesDir().getAbsolutePath();
            PREFETCH_DIR = DATA_FILE_DIR + File.separatorChar + "prefetched_contents";
        }
    }

    public static ResourceEntity findCache(String str, String str2) {
        List<ResourceEntity.Resource> configItems;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619473650")) {
            return (ResourceEntity) ipChange.ipc$dispatch("1619473650", new Object[]{str, str2});
        }
        ensureStorage();
        String str3 = getStorePath() + File.separatorChar + str;
        ResourceEntity resourceEntity = new ResourceEntity();
        long currentTimeMillis = System.currentTimeMillis();
        if (str2 != null) {
            File file = new File(str3, str2);
            if (file.exists()) {
                ResourceEntity.Resource resourceConfig = PrefetchManager.getResourceConfig(str, str2);
                if (resourceConfig != null) {
                    long j = resourceConfig.outdated;
                    if (j != 0 && j < currentTimeMillis) {
                        return null;
                    }
                }
                resourceEntity.resourceList.add(getResultResource(str2, file.getAbsolutePath(), resourceConfig));
            }
        } else {
            Config resourceConfig2 = PrefetchManager.getResourceConfig(str);
            if (resourceConfig2 != null && (configItems = resourceConfig2.getConfigItems()) != null && configItems.size() > 0) {
                for (ResourceEntity.Resource resource : configItems) {
                    if (resource != null) {
                        long j2 = resource.outdated;
                        if (j2 == 0 || j2 >= currentTimeMillis) {
                            File file2 = new File(str3, resource.key);
                            if (file2.exists()) {
                                resourceEntity.resourceList.add(getResultResource(resource.key, file2.getAbsolutePath(), resource));
                            }
                        }
                    }
                }
            }
        }
        return resourceEntity;
    }

    private static ResourceEntity.Resource getResultResource(String str, String str2, ResourceEntity.Resource resource) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826500333")) {
            return (ResourceEntity.Resource) ipChange.ipc$dispatch("826500333", new Object[]{str, str2, resource});
        }
        ensureStorage();
        if (resource == null) {
            return new ResourceEntity.Resource(str, str2, null, -1L);
        }
        return new ResourceEntity.Resource(resource.key, str2, resource.uri, resource.outdated);
    }

    public static String getStorePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "840096272")) {
            return (String) ipChange.ipc$dispatch("840096272", new Object[0]);
        }
        ensureStorage();
        return PREFETCH_DIR;
    }

    public static void putCache(String str, String str2, ResourceEntity resourceEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654859954")) {
            ipChange.ipc$dispatch("654859954", new Object[]{str, str2, resourceEntity});
        } else {
            ensureStorage();
        }
    }
}
