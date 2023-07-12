package com.huawei.hms.api;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ProtocolNegotiate {
    private static ProtocolNegotiate b = new ProtocolNegotiate();
    private int a = 1;

    public static ProtocolNegotiate getInstance() {
        return b;
    }

    public int getVersion() {
        return this.a;
    }

    public int negotiate(List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            if (!list.contains(2)) {
                this.a = list.get(list.size() - 1).intValue();
            } else {
                this.a = 2;
            }
            return this.a;
        }
        this.a = 1;
        return 1;
    }
}
