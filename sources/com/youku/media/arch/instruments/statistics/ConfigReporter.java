package com.youku.media.arch.instruments.statistics;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ConfigReporter {
    public static final int BIT_APS_LOC = 1610612736;
    public static final int BIT_APS_RMT = 1073741824;
    public static final int BIT_CACHE = 268435456;
    public static final int BIT_CACHE_MAP = 33554432;
    public static final int BIT_CONFIG = 8388608;
    public static final int BIT_GETTER_IMP = 67108864;
    public static final int BIT_INIT = Integer.MIN_VALUE;
    public static final int BIT_NAMESPACE = 16777216;
    public static final int BIT_ORANGE = 536870912;
    public static final int BIT_REAL = 134217728;
    public static final int BIT_RESULT = 4194304;
    public static final int CFG_ROUTE_MASK = 532676608;
    public static final int CFG_ROUTE_SHIFT = 22;
    public static final int INIT_ROUTE_MASK = -536870912;
    public static final int INIT_ROUTE_SHIFT = 29;
    public static final int INSTANCE_ROUTE_MASK = 503316480;
    public static final int INSTANCE_ROUTE_SHIFT = 25;
    private static ConfigReporter sInstance;
    private int mRoute = 0;

    private ConfigReporter() {
    }

    public static ConfigReporter getInstance() {
        if (sInstance == null) {
            synchronized (ConfigReporter.class) {
                if (sInstance == null) {
                    sInstance = new ConfigReporter();
                }
            }
        }
        return sInstance;
    }

    public void clear(int i) {
        this.mRoute = (~i) & this.mRoute;
    }

    public void commitBit(int i) {
        this.mRoute = i | this.mRoute;
    }

    public void commitConfigFetchRoute(int i) {
        commitWithMask(i, 0, CFG_ROUTE_MASK);
    }

    public void commitInitRoute(int i) {
        commitWithMask(i, 0, INIT_ROUTE_MASK);
    }

    public void commitWithMask(int i, int i2, int i3) {
        clear(i3);
        this.mRoute = ((i << i2) & i3) | this.mRoute;
    }

    public String getRoute() {
        String str = "|";
        for (int i = 31; i >= 0; i--) {
            str = (str + "" + (((this.mRoute & (1 << i)) >> i) & 1)) + "|";
        }
        return str;
    }
}
