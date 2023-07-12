package com.ali.ha.datahub;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface BizSubscriber {
    void onBizDataReadyStage();

    void onStage(String str, String str2, long j);

    void pub(String str, HashMap<String, String> hashMap);

    void pubAB(String str, HashMap<String, String> hashMap);

    void setMainBiz(String str, String str2);
}
