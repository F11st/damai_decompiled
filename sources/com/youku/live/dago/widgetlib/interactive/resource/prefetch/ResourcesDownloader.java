package com.youku.live.dago.widgetlib.interactive.resource.prefetch;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import java.io.File;
import java.util.ArrayList;
import tb.jq1;
import tb.l41;
import tb.qc0;
import tb.sc0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ResourcesDownloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ResourcesDownloader";

    private jq1 getParams(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625514321")) {
            return (jq1) ipChange.ipc$dispatch("625514321", new Object[]{this, str, Boolean.valueOf(z)});
        }
        jq1 jq1Var = new jq1();
        jq1Var.c = z ? 7 : 1;
        jq1Var.b = 10;
        jq1Var.d = 0;
        jq1Var.f = getStorePath() + File.separatorChar + str;
        jq1Var.l = z ? 5 : 2;
        return jq1Var;
    }

    private String getStorePath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-659241626") ? (String) ipChange.ipc$dispatch("-659241626", new Object[]{this}) : ResourcesCacheManager.getStorePath();
    }

    public void batchDownload(Config config, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564617238")) {
            ipChange.ipc$dispatch("-1564617238", new Object[]{this, config, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "batch_download for " + config.getNamespace());
        qc0 qc0Var = new qc0();
        qc0Var.b = getParams(config.getNamespace(), z);
        if (config.getConfigItems() != null) {
            ArrayList arrayList = new ArrayList();
            for (ResourceEntity.Resource resource : config.getConfigItems()) {
                l41 l41Var = new l41();
                l41Var.a = resource.uri.toString();
                l41Var.d = resource.uri.getLastPathSegment();
                arrayList.add(l41Var);
            }
            qc0Var.a = arrayList;
        }
        sc0.c().b(qc0Var, downloadListener);
    }

    public void download(String str, String str2, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025350482")) {
            ipChange.ipc$dispatch("2025350482", new Object[]{this, str, str2, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "download for " + str + ", key:" + str2);
        ResourceEntity.Resource resourceConfig = PrefetchManager.getResourceConfig(str, str2);
        if (resourceConfig != null) {
            qc0 qc0Var = new qc0();
            qc0Var.a = new ArrayList();
            l41 l41Var = new l41();
            l41Var.a = resourceConfig.uri.toString();
            l41Var.d = resourceConfig.uri.getLastPathSegment();
            qc0Var.a.add(l41Var);
            qc0Var.b = getParams(str, z);
            sc0.c().b(qc0Var, downloadListener);
        }
    }
}
