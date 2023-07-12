package com.huawei.agconnect;

import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class AGCRoutePolicy {
    private final int route;
    public static final AGCRoutePolicy UNKNOWN = new AGCRoutePolicy(0);
    public static final AGCRoutePolicy CHINA = new AGCRoutePolicy(1);
    public static final AGCRoutePolicy GERMANY = new AGCRoutePolicy(2);
    public static final AGCRoutePolicy RUSSIA = new AGCRoutePolicy(3);
    public static final AGCRoutePolicy SINGAPORE = new AGCRoutePolicy(4);

    private AGCRoutePolicy(int i) {
        this.route = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && AGCRoutePolicy.class == obj.getClass() && this.route == ((AGCRoutePolicy) obj).route;
    }

    public String getRouteName() {
        int i = this.route;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "SG" : "RU" : "DE" : "CN";
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.route));
    }
}
