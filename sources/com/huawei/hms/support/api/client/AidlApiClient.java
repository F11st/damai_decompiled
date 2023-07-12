package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.d;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface AidlApiClient extends ApiClient {
    List<String> getApiNameList();

    d getService();
}
