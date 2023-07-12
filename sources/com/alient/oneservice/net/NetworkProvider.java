package com.alient.oneservice.net;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface NetworkProvider {
    String getErrorMsg(String str, String str2);

    Map<String, String> signParams(String str, Map<String, String> map);
}
