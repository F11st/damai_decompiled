package com.taobao.zcache;

import androidx.annotation.Nullable;
import com.taobao.zcache.core.IZCacheCore;
import com.taobao.zcache.core.ZCacheCoreProxy;
import com.taobao.zcache.model.ZCacheResourceResponse;
import com.taobao.zcachecorewrapper.IZCacheCore;
import com.taobao.zcachecorewrapper.model.AppInfo;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCacheManager {
    private static ZCacheManager INSTANCE;

    private ZCacheManager() {
    }

    public static ZCacheManager instance() {
        if (INSTANCE == null) {
            synchronized (ZCacheManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ZCacheManager();
                }
            }
        }
        return INSTANCE;
    }

    public void getAppPath(String str, final IZCacheCore.AppInfoCallback appInfoCallback) {
        com.taobao.zcache.core.IZCacheCore core = ZCacheCoreProxy.core();
        if (core == null) {
            return;
        }
        core.loadAppReader(str, new IZCacheCore.AppReaderInfoCallback() { // from class: com.taobao.zcache.ZCacheManager.1
            @Override // com.taobao.zcache.core.IZCacheCore.AppReaderInfoCallback
            public void finish(AppInfo appInfo, Error error) {
                IZCacheCore.AppInfoCallback appInfoCallback2 = appInfoCallback;
                if (appInfoCallback2 != null) {
                    appInfoCallback2.onReceive(appInfo, new com.taobao.zcachecorewrapper.model.Error(error));
                }
            }
        });
    }

    @Deprecated
    public String getMiniAppFilePath(String str, String str2) {
        return ZCache.getACacheRootPath(str, str2);
    }

    @Deprecated
    public String getSeesionID() {
        return "";
    }

    @Deprecated
    public ZCacheResourceResponse getZCacheResource(String str) {
        return getZCacheResource(str, new HashMap());
    }

    @Deprecated
    public void initApps(Set<String> set) {
    }

    @Deprecated
    public void installPreload(String str) {
        ZCache.installPreload(str);
    }

    @Deprecated
    public void invokeZCacheDev(String str, String str2, IZCacheCore.DevCallback devCallback) {
    }

    @Deprecated
    public boolean isAppInstall(String str) {
        return ZCache.isPackInstalled(new PackRequest(str));
    }

    @Deprecated
    public boolean isResourceInstalled(String str) {
        return ZCache.isResourceInstalled(str);
    }

    @Deprecated
    public void onBackground() {
    }

    @Deprecated
    public void onForeground() {
    }

    public void pauseApp(String str) {
        com.taobao.zcache.core.IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.pauseApp(str);
        }
    }

    @Deprecated
    public void receiveZConfigUpdateMessage(List<String> list, long j) {
    }

    @Deprecated
    public void removeAZCache(String str) {
        ZCache.removeACache(str, null);
    }

    @Deprecated
    public void removeAllZCache() {
        ZCache.clean();
    }

    public void resumeApp(String str) {
        com.taobao.zcache.core.IZCacheCore core = ZCacheCoreProxy.core();
        if (core != null) {
            core.resumeApp(str);
        }
    }

    @Deprecated
    public void startUpdateQueue() {
    }

    @Deprecated
    public void syncSubProcessConfig() {
        ZCache.syncSubProcessConfig();
    }

    @Deprecated
    public void update(Set<String> set, int i) {
    }

    @Deprecated
    public void updatePack(String str, String str2, int i, final IZCacheCore.UpdateCallback updateCallback) {
        ZCache.updatePack(new PackRequest(str, str2), new PackUpdateFinishedCallback() { // from class: com.taobao.zcache.ZCacheManager.2
            @Override // com.taobao.zcache.PackUpdateFinishedCallback
            public void finish(String str3, Error error) {
                IZCacheCore.UpdateCallback updateCallback2 = updateCallback;
                if (updateCallback2 != null) {
                    updateCallback2.finish(str3, new com.taobao.zcachecorewrapper.model.Error(error));
                }
            }
        });
    }

    @Deprecated
    public ZCacheResourceResponse getZCacheResource(String str, @Nullable Map<String, String> map) {
        ResourceResponse resource = ZCache.getResource(new ResourceRequest(str, map));
        ZCacheResourceResponse zCacheResourceResponse = new ZCacheResourceResponse();
        if (resource == null) {
            zCacheResourceResponse.isSuccess = false;
            zCacheResourceResponse.status = 0;
            zCacheResourceResponse.zcacheInfo = ZCacheResourceResponse.ZCACHE_NO_RESPONSE;
        } else {
            Map<String, String> header = resource.getHeader();
            zCacheResourceResponse.headers = header;
            if (header != null && header.containsKey("X-ZCache-Info")) {
                zCacheResourceResponse.zcacheInfo = zCacheResourceResponse.headers.get("X-ZCache-Info");
            } else {
                zCacheResourceResponse.zcacheInfo = ZCacheResourceResponse.ZCACHE_NO_HEADER;
            }
            if (resource.getError() == null) {
                zCacheResourceResponse.inputStream = new ByteArrayInputStream(resource.getData());
                zCacheResourceResponse.isSuccess = true;
                zCacheResourceResponse.status = 2;
            } else {
                zCacheResourceResponse.isSuccess = false;
                zCacheResourceResponse.status = 1;
            }
        }
        return zCacheResourceResponse;
    }
}
