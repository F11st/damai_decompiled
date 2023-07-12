package com.taobao.zcachecorewrapper;

import com.taobao.zcachecorewrapper.model.AppInfo;
import com.taobao.zcachecorewrapper.model.Error;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IZCacheCore {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface AppInfoCallback {
        void onReceive(AppInfo appInfo, Error error);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface UpdateCallback {
        void finish(String str, Error error);
    }
}
