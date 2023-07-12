package com.alibaba.poplayer.layermanager;

import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.config.ConfigItem;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.c */
/* loaded from: classes8.dex */
final class C3658c extends PopRequest.C3655a {
    final int e;

    public C3658c(PopRequest.C3655a c3655a, ConfigItem configItem) {
        if (c3655a != null) {
            this.b = c3655a.b;
            this.d = c3655a.d;
            this.c = c3655a.c;
            this.a = c3655a.a;
        } else {
            this.b = configItem.enqueue;
            this.d = configItem.exclusive;
            this.c = configItem.forcePopRespectingPriority;
            this.a = configItem.priority;
        }
        this.e = configItem.level;
    }
}
