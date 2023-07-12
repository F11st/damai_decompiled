package com.alibaba.poplayer.layermanager;

import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.config.ConfigItem;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class c extends PopRequest.a {
    final int e;

    public c(PopRequest.a aVar, ConfigItem configItem) {
        if (aVar != null) {
            this.b = aVar.b;
            this.d = aVar.d;
            this.c = aVar.c;
            this.a = aVar.a;
        } else {
            this.b = configItem.enqueue;
            this.d = configItem.exclusive;
            this.c = configItem.forcePopRespectingPriority;
            this.a = configItem.priority;
        }
        this.e = configItem.level;
    }
}
