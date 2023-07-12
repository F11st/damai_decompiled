package com.taobao.android.launcher.statistics;

import android.content.Context;
import com.alibaba.ha.bizerrorreporter.BizErrorBuilder;
import com.alibaba.motu.crashreportadapter.AdapterExceptionModule;
import com.alibaba.motu.crashreportadapter.module.AggregationType;
import com.alibaba.motu.crashreportadapter.module.BusinessType;
import com.taobao.android.launcher.statistics.LazyExecutor;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MotuCrash {
    public static void reportCrash(Context context, String str, Throwable th) {
        String str2;
        AdapterExceptionModule adapterExceptionModule = new AdapterExceptionModule();
        adapterExceptionModule.businessType = BusinessType.LAUNCHER_ERROR;
        adapterExceptionModule.aggregationType = AggregationType.CONTENT;
        adapterExceptionModule.exceptionId = String.valueOf(str);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(str));
        sb.append("：");
        if (th != null) {
            str2 = th.getMessage() + "，" + th.getCause();
        } else {
            str2 = "nothing";
        }
        sb.append(str2);
        adapterExceptionModule.exceptionCode = sb.toString();
        adapterExceptionModule.exceptionDetail = "https://launcher.taobao.com/exception/" + str;
        adapterExceptionModule.throwable = th;
        adapterExceptionModule.thread = Thread.currentThread();
        adapterExceptionModule.exceptionVersion = BizErrorBuilder._VERSION;
        HashMap hashMap = new HashMap(2);
        hashMap.put("name", str);
        hashMap.put("launch", "next launch");
        adapterExceptionModule.exceptionArgs = hashMap;
        LazyExecutor.Motu.ADAPTER_HANDLER.adapter(context, adapterExceptionModule);
    }
}
