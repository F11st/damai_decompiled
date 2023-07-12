package com.taobao.zcache.network;

import com.taobao.zcache.Error;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DownloadFinishedCallback {
    void onDownloadFinished(int i, Map<String, String> map, Error error, String str);
}
