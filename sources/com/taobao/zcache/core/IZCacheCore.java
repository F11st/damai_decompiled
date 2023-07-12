package com.taobao.zcache.core;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.zcache.Environment;
import com.taobao.zcache.Error;
import com.taobao.zcache.IZCacheClientListener;
import com.taobao.zcache.PackRequest;
import com.taobao.zcache.PackUpdateFinishedCallback;
import com.taobao.zcache.ResourceRequest;
import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.ResourceResponseCallback;
import com.taobao.zcache.ZCacheConfig;
import com.taobao.zcachecorewrapper.model.AppInfo;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public interface IZCacheCore extends IZCacheClientListener {

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes11.dex */
    public interface AppReaderInfoCallback {
        void finish(AppInfo appInfo, Error error);
    }

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes11.dex */
    public interface DevCallback {
        void finish(boolean z, String str);
    }

    void clean();

    @Override // com.taobao.zcache.IZCacheClientListener
    void clientActived();

    @Override // com.taobao.zcache.IZCacheClientListener
    void clientDeactived();

    String getACacheRootPath(String str, String str2);

    String getCoreVersion();

    ResourceResponse getResource(ResourceRequest resourceRequest);

    void getResource(ResourceRequest resourceRequest, ResourceResponseCallback resourceResponseCallback);

    void installPreload(String str);

    boolean invokeDev(String str, String str2, DevCallback devCallback);

    boolean isInstalled(PackRequest packRequest);

    boolean isResourceInstalled(ResourceRequest resourceRequest);

    void loadAppReader(String str, AppReaderInfoCallback appReaderInfoCallback);

    void pauseApp(String str);

    void prefetch(List<String> list);

    void registerAccept(String str, String str2, String str3);

    void registerUpdateListener(@NonNull String str, @NonNull PackUpdateFinishedCallback packUpdateFinishedCallback);

    void removePack(PackRequest packRequest);

    void resumeApp(String str);

    void setConfig(Map<String, String> map);

    void setDefaultConfig(ZCacheConfig zCacheConfig);

    void setEnv(Environment environment);

    void setLocale(String str);

    void setupSubProcess();

    void setupWithHTTP(String str, String str2, Environment environment, String str3, ZCacheConfig zCacheConfig, Map<String, String> map);

    void syncSubProcessConfig();

    void updatePack(PackRequest packRequest, PackUpdateFinishedCallback packUpdateFinishedCallback);
}
