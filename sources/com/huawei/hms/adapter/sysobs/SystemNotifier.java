package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i);

    void notifyObservers(int i);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}
