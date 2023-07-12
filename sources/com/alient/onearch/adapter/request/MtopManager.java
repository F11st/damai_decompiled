package com.alient.onearch.adapter.request;

import android.content.Context;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import mtopsdk.common.log.TLogAdapterImpl;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class MtopManager {
    private static volatile boolean inited;
    private static Mtop mtopInstance;

    public static synchronized Mtop getMtopInstance() {
        Mtop mtop;
        synchronized (MtopManager.class) {
            if (!inited) {
                init(AppInfoProviderProxy.getAppContext(), AppInfoProviderProxy.getVersionName(), AppInfoProviderProxy.getTTID());
            }
            mtop = mtopInstance;
        }
        return mtop;
    }

    public static void init(Context context, String str, String str2) {
        initImpl(context, str, str2);
    }

    private static void initImpl(Context context, String str, String str2) {
        TBSdkLog.setLogAdapter(new TLogAdapterImpl());
        MtopSetting.setAppKeyIndex(Mtop.Id.INNER, 0, 2);
        MtopSetting.setAppVersion(Mtop.Id.INNER, str);
        mtopInstance = Mtop.instance(Mtop.Id.INNER, context, str2).registerTtid(str2);
        inited = true;
    }

    public static void setMtopInstance(Mtop mtop) {
        mtopInstance = mtop;
        inited = true;
    }
}
