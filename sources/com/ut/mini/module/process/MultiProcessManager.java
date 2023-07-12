package com.ut.mini.module.process;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MultiProcessManager {
    private static AbsMultiProcessAdapter multiProcessAdapter;

    public static AbsMultiProcessAdapter getMultiProcessAdapter() {
        return multiProcessAdapter;
    }

    public static void setMultiProcessAdapter(AbsMultiProcessAdapter absMultiProcessAdapter) {
        multiProcessAdapter = absMultiProcessAdapter;
    }
}
