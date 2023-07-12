package com.alibaba.android.ultron.trade.extplugin;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface IExtInitiator {
    void registerSubscriber(String str, ISubscriber iSubscriber);

    void registerSubscribers(Map<String, ISubscriber> map);
}
