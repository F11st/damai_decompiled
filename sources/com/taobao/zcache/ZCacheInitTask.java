package com.taobao.zcache;

import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVAppParams;
import android.taobao.windvane.config.WVAppParamsManager;
import android.taobao.windvane.packageapp.WVPackageAppWebViewClientFilter;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import com.taobao.tao.Globals;
import com.taobao.zcache.global.ZCacheGlobal;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCacheInitTask {
    private static ZCacheInitTask Instance;
    private AtomicBoolean inited = new AtomicBoolean(false);

    public static ZCacheInitTask getInstance() {
        if (Instance == null) {
            synchronized (ZCacheInitTask.class) {
                if (Instance == null) {
                    Instance = new ZCacheInitTask();
                }
            }
        }
        return Instance;
    }

    public void init() {
        if (!this.inited.get() && WVAppParamsManager.getInstance().isParamsSet() && this.inited.compareAndSet(false, true)) {
            TaoLog.i("ZCache", "未初始化ZCache so，需要先初始化");
            try {
                if (GlobalConfig.context == null) {
                    GlobalConfig.context = Globals.getApplication();
                }
                ZCacheGlobal.instance().setContext(GlobalConfig.context);
                if (!CommonUtils.isMainProcess(GlobalConfig.context)) {
                    ZCacheSDK.initSub();
                    return;
                }
                WVAppParams params = WVAppParamsManager.getInstance().getParams();
                ZCacheParams zCacheParams = new ZCacheParams();
                if (!TextUtils.isEmpty(params.appKey)) {
                    zCacheParams.appKey = params.appKey;
                    if (!TextUtils.isEmpty(params.appVersion)) {
                        zCacheParams.appVersion = params.appVersion;
                        zCacheParams.context = GlobalConfig.context;
                        zCacheParams.env = GlobalConfig.env.getKey();
                        ZCacheSDK.init(zCacheParams);
                        WVEventService.getInstance().addEventListener(WVPackageAppWebViewClientFilter.getInstance(), WVEventService.WV_FORWARD_EVENT);
                        Log.e("ZCache", "init: ZCache初始化成功，WVPackageAppWebViewClientFilter注册成功");
                        return;
                    }
                    throw new AndroidRuntimeException("appVersion cannot empty, par ams is set = [" + WVAppParamsManager.getInstance().isParamsSet() + jn1.ARRAY_END_STR);
                }
                throw new AndroidRuntimeException("appKey cannot empty, params is set = [" + WVAppParamsManager.getInstance().isParamsSet() + jn1.ARRAY_END_STR);
            } catch (Throwable th) {
                this.inited.set(false);
                th.printStackTrace();
            }
        }
    }
}
