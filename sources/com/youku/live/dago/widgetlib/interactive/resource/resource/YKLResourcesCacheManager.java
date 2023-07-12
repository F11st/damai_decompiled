package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.utils.ContextUtil;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLResourcesCacheManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String DATA_FILE_DIR;
    private static String PREFETCH_DIR;

    public static boolean checkPathValid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497979232")) {
            return ((Boolean) ipChange.ipc$dispatch("-1497979232", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        if (!file.exists()) {
            Log.d("ykl-download", "file not exist path =  " + str);
        } else if (file.isDirectory() && file.list() != null) {
            if (file.list().length != 0) {
                return true;
            }
            Log.d("ykl-download", "file is empty, path = " + str);
            FileUtils.deleteDirectory(file.getAbsolutePath());
        }
        return false;
    }

    public static List<YKLDownloadBean> checkResourceList(String str, List<YKLDownloadBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756689609")) {
            return (List) ipChange.ipc$dispatch("-756689609", new Object[]{str, list});
        }
        ensureStorage();
        ArrayList arrayList = new ArrayList();
        String str2 = getStorePath() + File.separatorChar + str;
        if (list != null && list.size() > 0) {
            for (YKLDownloadBean yKLDownloadBean : list) {
                if (yKLDownloadBean != null && !TextUtils.isEmpty(yKLDownloadBean.fileName)) {
                    ((ILog) Dsl.getService(ILog.class)).i("ykl-download", "DOWNLOAD, url = " + yKLDownloadBean.url);
                    File file = new File(str2, yKLDownloadBean.fileName);
                    if (!file.exists()) {
                        ((ILog) Dsl.getService(ILog.class)).d("ykl-download", "no cache, url = " + yKLDownloadBean.url);
                        arrayList.add(yKLDownloadBean);
                    } else if (file.isDirectory()) {
                        if (file.list() != null) {
                            if (file.list().length == 0) {
                                ((ILog) Dsl.getService(ILog.class)).d("ykl-download", "no cache, url = " + yKLDownloadBean.url);
                                FileUtils.deleteDirectory(file.getAbsolutePath());
                                arrayList.add(yKLDownloadBean);
                            } else {
                                ((ILog) Dsl.getService(ILog.class)).e("ykl-download", "FILE EXIST ");
                            }
                        }
                    } else if (!file.isDirectory()) {
                        ((ILog) Dsl.getService(ILog.class)).d("ykl-download", "Normal, file = " + file.getAbsolutePath());
                        arrayList.add(yKLDownloadBean);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void ensureStorage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1998043764")) {
            ipChange.ipc$dispatch("-1998043764", new Object[0]);
        } else if (DATA_FILE_DIR == null || PREFETCH_DIR == null) {
            DATA_FILE_DIR = ContextUtil.getApplicationContext().getFilesDir().getAbsolutePath();
            PREFETCH_DIR = DATA_FILE_DIR + File.separatorChar + "prefetched_contents";
            StringBuilder sb = new StringBuilder();
            sb.append("PREFETCH_DIR =  ");
            sb.append(PREFETCH_DIR);
            ((ILog) Dsl.getService(ILog.class)).d("liulei-download", sb.toString());
        }
    }

    public static ResourceEntity findCache(String str, String str2) {
        ArrayList arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325139539")) {
            return (ResourceEntity) ipChange.ipc$dispatch("325139539", new Object[]{str, str2});
        }
        ensureStorage();
        String str3 = getStorePath() + File.separatorChar + str;
        ResourceEntity resourceEntity = new ResourceEntity();
        long currentTimeMillis = System.currentTimeMillis();
        if (str2 != null) {
            File file = new File(str3, str2);
            if (file.exists()) {
                ResourceEntity.Resource resourceConfig = YKLPrefetchManager.getInstance().getResourceConfig(str, str2);
                if (resourceConfig != null) {
                    long j = resourceConfig.outdated;
                    if (j != 0 && j < currentTimeMillis) {
                        Log.d("YKLResouceManager", "outdat file , return");
                        return null;
                    }
                }
                Log.d("YKLResouceManager", "find cache has resource , key = " + str2 + "   path = " + file.getAbsolutePath());
                resourceEntity.resourceList.add(getResultResource(str2, file.getAbsolutePath(), resourceConfig));
            }
        } else {
            Config resourceConfig2 = YKLPrefetchManager.getInstance().getResourceConfig(str);
            if (resourceConfig2 != null && (arrayList = (ArrayList) ((ArrayList) resourceConfig2.getConfigItems()).clone()) != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResourceEntity.Resource resource = (ResourceEntity.Resource) it.next();
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

    public static String getCacheResourcePath(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760258954")) {
            return (String) ipChange.ipc$dispatch("1760258954", new Object[]{str, str2});
        }
        ensureStorage();
        return new File(getStorePath() + File.separatorChar + str, str2).getAbsolutePath();
    }

    private static ResourceEntity.Resource getResultResource(String str, String str2, ResourceEntity.Resource resource) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2004374414")) {
            return (ResourceEntity.Resource) ipChange.ipc$dispatch("2004374414", new Object[]{str, str2, resource});
        }
        ensureStorage();
        if (resource == null) {
            return new ResourceEntity.Resource(str, str2, null, -1L);
        }
        return new ResourceEntity.Resource(resource.key, str2, resource.uri, resource.outdated);
    }

    public static String getStorePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18971471")) {
            return (String) ipChange.ipc$dispatch("18971471", new Object[0]);
        }
        ensureStorage();
        return PREFETCH_DIR;
    }

    public static void putCache(String str, String str2, ResourceEntity resourceEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639474157")) {
            ipChange.ipc$dispatch("-639474157", new Object[]{str, str2, resourceEntity});
        } else {
            ensureStorage();
        }
    }
}
