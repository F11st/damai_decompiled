package com.taobao.zcache.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.RVLLog;
import com.taobao.zcache.Environment;
import com.taobao.zcache.Error;
import com.taobao.zcache.IZCachePushService;
import com.taobao.zcache.PackRequest;
import com.taobao.zcache.PackUpdateFinishedCallback;
import com.taobao.zcache.PushMessageCallback;
import com.taobao.zcache.ResourceRequest;
import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.ResourceResponseCallback;
import com.taobao.zcache.ZCache;
import com.taobao.zcache.ZCacheConfig;
import com.taobao.zcache.config.ZCacheAdapterManager;
import com.taobao.zcache.core.IZCacheCore;
import com.taobao.zcache.core.NetworkUtils;
import com.taobao.zcache.network.DownloadFinishedCallback;
import com.taobao.zcache.network.DownloadRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class ZCacheCoreWrapper implements IZCacheCore {
    private static int initCount;
    private AssetManager assetManager;
    private String coreVersion;
    private String zcacheFolder;
    private int initState = -1;
    private final Lock lock = new ReentrantLock();
    private final HashMap<String, PackUpdateFinishedCallback[]> packUpdateListeners = new HashMap<>();
    private DownloadFactory downloadFactory = new DownloadFactory();

    public ZCacheCoreWrapper(Context context) {
        if (context == null) {
            new AndroidRuntimeException("ZCache Context cannot be null").printStackTrace();
            return;
        }
        this.assetManager = context.getAssets();
        this.zcacheFolder = context.getDir("zcache", 0).getAbsolutePath();
        setNetworkStatus(NetworkUtils.networkStatus());
        NetworkUtils.setListener(new NetworkUtils.NetworkListener() { // from class: com.taobao.zcache.core.ZCacheCoreWrapper.1
            @Override // com.taobao.zcache.core.NetworkUtils.NetworkListener
            public void onNetworkChanged(int i) {
                RVLLog.a(RVLLevel.Verbose, "ZCache/Info").f("NetworkStatus").a("status", Integer.valueOf(i)).d();
                ZCacheCoreWrapper.this.setNetworkStatus(i);
            }
        });
        loadSO();
    }

    private native void cleanNative();

    private native void clientActivedNative();

    private native void clientDeactivedNative();

    private void commitMonitor(String str, HashMap<String, String> hashMap, HashMap<String, Double> hashMap2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Monitor.commitMonitor(str, hashMap, hashMap2);
    }

    private native String getACacheRootPathNative(String str, String str2);

    private native String getCoreVersionNative();

    private native int getEnvNative();

    private Error getInvalidArgumentError() {
        return new Error(-1, "invalid argument");
    }

    private native String getLocaleNative();

    private native ResourceResponse getResourceNative(ResourceRequest resourceRequest);

    private native void getResourceNative(ResourceRequest resourceRequest, ResourceResponseCallback resourceResponseCallback);

    private Error getSoNotLoadedError() {
        return new Error(9993, "so not loaded");
    }

    private String initZCacheFolder() {
        return this.zcacheFolder;
    }

    private native void installPreloadNative(String str);

    private native boolean invokeDevNative(String str, String str2, IZCacheCore.DevCallback devCallback);

    private native boolean isInstalledNative(PackRequest packRequest);

    private native boolean isResourceInstalledNative(ResourceRequest resourceRequest);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSoLoaded() {
        if (this.initState == 0 && initCount <= 5) {
            loadSO();
        }
        return this.initState == 1;
    }

    private native void loadAppReaderNative(String str, IZCacheCore.AppReaderInfoCallback appReaderInfoCallback);

    private void loadSO() {
        if (this.lock.tryLock()) {
            try {
                System.loadLibrary("zcachecore");
                if (setProxyNative(this, this.assetManager)) {
                    this.initState = 1;
                } else {
                    RVLLog.a(RVLLevel.Error, "ZCache/Setup").f("loadSO").e(102, "Null proxy", new Object[0]).d();
                    this.initState = 0;
                }
            } finally {
                try {
                    initCount++;
                } finally {
                }
            }
            initCount++;
        }
    }

    private void onFirstUpdateQueueFinished(int i) {
        if (ZCacheAdapterManager.getInstance().getUpdateImpl() != null) {
            ZCacheAdapterManager.getInstance().getUpdateImpl().firstUpdateCount(i);
        }
    }

    private void onPackUpdated(String str) {
        PackUpdateFinishedCallback[] packUpdateFinishedCallbackArr;
        if (str == null) {
            return;
        }
        synchronized (this.packUpdateListeners) {
            packUpdateFinishedCallbackArr = this.packUpdateListeners.get(str);
        }
        if (packUpdateFinishedCallbackArr != null) {
            for (PackUpdateFinishedCallback packUpdateFinishedCallback : packUpdateFinishedCallbackArr) {
                packUpdateFinishedCallback.finish(str, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onPushMessageNative(long j, List<String> list);

    /* JADX INFO: Access modifiers changed from: private */
    public native void onSendRequestFinishedNative(long j, int i, Map<String, String> map, Error error, String str);

    private native void pauseAppNative(String str);

    private native void prefetchNative(List<String> list);

    private native void registerAcceptNative(String str, String str2, String str3);

    private native void removePackNative(PackRequest packRequest);

    private native void resumeAppNative(String str);

    private void sendRequest(DownloadRequest downloadRequest, final long j) {
        this.downloadFactory.sendRequest(downloadRequest, new DownloadFinishedCallback() { // from class: com.taobao.zcache.core.ZCacheCoreWrapper.2
            @Override // com.taobao.zcache.network.DownloadFinishedCallback
            public void onDownloadFinished(int i, Map<String, String> map, Error error, String str) {
                if (ZCacheCoreWrapper.this.isSoLoaded()) {
                    ZCacheCoreWrapper.this.onSendRequestFinishedNative(j, i, map, error, str);
                }
            }
        });
    }

    private native void setConfigNative(Map<String, String> map);

    private native void setDefaultConfigNative(ZCacheConfig zCacheConfig);

    private native void setEnvNative(int i);

    private native void setLocaleNative(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkStatus(int i) {
        if (isSoLoaded()) {
            setNetworkStatusNative(i);
        }
    }

    private native void setNetworkStatusNative(int i);

    private native boolean setProxyNative(ZCacheCoreWrapper zCacheCoreWrapper, AssetManager assetManager);

    private native void setupSubProcessNative();

    private native void setupWithHTTPNative(String str, String str2, int i, String str3, ZCacheConfig zCacheConfig, Map<String, String> map);

    private boolean subscribePushMessage(String str, final long j) {
        IZCachePushService pushService = ZCache.getPushService();
        if (pushService == null) {
            return false;
        }
        pushService.subscribePushMessage(str, new PushMessageCallback() { // from class: com.taobao.zcache.core.ZCacheCoreWrapper.3
            @Override // com.taobao.zcache.PushMessageCallback
            public void onPushMessage(List<String> list) {
                if (ZCacheCoreWrapper.this.isSoLoaded()) {
                    ZCacheCoreWrapper.this.onPushMessageNative(j, list);
                }
            }
        });
        return true;
    }

    private native void syncSubProcessConfigNative();

    private native void updatePackNative(PackRequest packRequest, PackUpdateFinishedCallback packUpdateFinishedCallback);

    private boolean verifySign(byte[] bArr, byte[] bArr2) {
        return RSAUtil.verifySign(bArr, bArr2);
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void clean() {
        if (isSoLoaded()) {
            cleanNative();
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore, com.taobao.zcache.IZCacheClientListener
    public void clientActived() {
        if (isSoLoaded()) {
            clientActivedNative();
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore, com.taobao.zcache.IZCacheClientListener
    public void clientDeactived() {
        if (isSoLoaded()) {
            clientDeactivedNative();
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public String getACacheRootPath(String str, String str2) {
        if (isSoLoaded()) {
            return getACacheRootPathNative(str, str2);
        }
        return null;
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public String getCoreVersion() {
        if (this.coreVersion == null) {
            this.coreVersion = getCoreVersionNative();
        }
        return this.coreVersion;
    }

    int getEnv() {
        if (isSoLoaded()) {
            return getEnvNative();
        }
        return -1;
    }

    String getLocale() {
        if (isSoLoaded()) {
            return getLocaleNative();
        }
        return null;
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public ResourceResponse getResource(ResourceRequest resourceRequest) {
        if (resourceRequest != null && isSoLoaded()) {
            return getResourceNative(resourceRequest);
        }
        return null;
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void installPreload(String str) {
        if (isSoLoaded()) {
            installPreloadNative(str);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public boolean invokeDev(String str, String str2, IZCacheCore.DevCallback devCallback) {
        if (isSoLoaded()) {
            return invokeDevNative(str, str2, devCallback);
        }
        if (devCallback != null) {
            devCallback.finish(false, "so not loaded");
            return true;
        }
        return false;
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public boolean isInstalled(PackRequest packRequest) {
        if (packRequest == null) {
            return false;
        }
        if (isSoLoaded()) {
            return isInstalledNative(packRequest);
        }
        packRequest.setError(getSoNotLoadedError());
        return false;
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public boolean isResourceInstalled(ResourceRequest resourceRequest) {
        if (resourceRequest != null && isSoLoaded()) {
            return isResourceInstalledNative(resourceRequest);
        }
        return false;
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void loadAppReader(String str, IZCacheCore.AppReaderInfoCallback appReaderInfoCallback) {
        if (isSoLoaded()) {
            loadAppReaderNative(str, appReaderInfoCallback);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void pauseApp(String str) {
        if (isSoLoaded()) {
            pauseAppNative(str);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void prefetch(List<String> list) {
        if (!isSoLoaded() || list == null) {
            return;
        }
        prefetchNative(list);
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void registerAccept(String str, String str2, String str3) {
        registerAcceptNative(str, str2, str3);
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void registerUpdateListener(@NonNull String str, @NonNull PackUpdateFinishedCallback packUpdateFinishedCallback) {
        if (str == null || packUpdateFinishedCallback == null) {
            return;
        }
        synchronized (this.packUpdateListeners) {
            PackUpdateFinishedCallback[] packUpdateFinishedCallbackArr = this.packUpdateListeners.get(str);
            if (packUpdateFinishedCallbackArr == null) {
                this.packUpdateListeners.put(str, new PackUpdateFinishedCallback[]{packUpdateFinishedCallback});
            } else if (!Arrays.asList(packUpdateFinishedCallbackArr).contains(packUpdateFinishedCallback)) {
                PackUpdateFinishedCallback[] packUpdateFinishedCallbackArr2 = (PackUpdateFinishedCallback[]) Arrays.copyOf(packUpdateFinishedCallbackArr, packUpdateFinishedCallbackArr.length + 1);
                packUpdateFinishedCallbackArr2[packUpdateFinishedCallbackArr.length] = packUpdateFinishedCallback;
                this.packUpdateListeners.put(str, packUpdateFinishedCallbackArr2);
            }
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void removePack(PackRequest packRequest) {
        if (isSoLoaded()) {
            removePackNative(packRequest);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void resumeApp(String str) {
        if (isSoLoaded()) {
            resumeAppNative(str);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void setConfig(Map<String, String> map) {
        if (!isSoLoaded() || map == null) {
            return;
        }
        setConfigNative(map);
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void setDefaultConfig(ZCacheConfig zCacheConfig) {
        if (isSoLoaded()) {
            setDefaultConfigNative(zCacheConfig);
        }
    }

    public void setDownloadFactory(DownloadFactory downloadFactory) {
        if (downloadFactory == null) {
            this.downloadFactory = new DownloadFactory();
        } else {
            this.downloadFactory = downloadFactory;
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void setEnv(Environment environment) {
        if (!isSoLoaded() || environment == null) {
            return;
        }
        setEnvNative(environment.value);
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void setLocale(String str) {
        if (isSoLoaded()) {
            setLocaleNative(str);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void setupSubProcess() {
        if (isSoLoaded()) {
            setupSubProcessNative();
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void setupWithHTTP(String str, String str2, Environment environment, String str3, ZCacheConfig zCacheConfig, Map<String, String> map) {
        if (isSoLoaded()) {
            if (environment == null) {
                environment = Environment.Release;
            }
            setupWithHTTPNative(str, str2, environment.value, str3, zCacheConfig, map);
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void syncSubProcessConfig() {
        if (isSoLoaded()) {
            syncSubProcessConfigNative();
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void updatePack(PackRequest packRequest, PackUpdateFinishedCallback packUpdateFinishedCallback) {
        if (packRequest == null) {
            if (packUpdateFinishedCallback != null) {
                packUpdateFinishedCallback.finish(null, getInvalidArgumentError());
            }
        } else if (isSoLoaded()) {
            updatePackNative(packRequest, packUpdateFinishedCallback);
        } else if (packUpdateFinishedCallback != null) {
            packUpdateFinishedCallback.finish(null, getSoNotLoadedError());
        }
    }

    @Override // com.taobao.zcache.core.IZCacheCore
    public void getResource(ResourceRequest resourceRequest, ResourceResponseCallback resourceResponseCallback) {
        if (resourceResponseCallback != null) {
            if (isSoLoaded()) {
                getResourceNative(resourceRequest, resourceResponseCallback);
            } else {
                resourceResponseCallback.finish(null);
            }
        }
    }
}
