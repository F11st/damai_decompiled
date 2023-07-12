package io.flutter.stat;

import io.flutter.stat.ICoreStat;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StatServices {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CATEGORY = "core";
    public static final String EVENTCATEGORY = "flutter";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class InnerClass {
        private static final StatServices SINGLETON = new StatServices();

        private InnerClass() {
        }
    }

    public static void WaStat(String str, HashMap<String, String> hashMap) {
        WaStat(CATEGORY, EVENTCATEGORY, str, hashMap);
    }

    public static StatServices getInstance() {
        return InnerClass.SINGLETON;
    }

    public static int getNumberLength(long j) {
        if (j < 100000) {
            if (j < 100) {
                return j < 10 ? 1 : 2;
            } else if (j < 1000) {
                return 3;
            } else {
                return j < 10000 ? 4 : 5;
            }
        } else if (j < 10000000) {
            return j < 1000000 ? 6 : 7;
        } else if (j < 100000000) {
            return 8;
        } else {
            return j < 1000000000 ? 9 : 10;
        }
    }

    public static void WaStat(String str, String str2, String str3, HashMap<String, String> hashMap) {
        ICoreStat.CustomStat customStat = ICoreStat.CustomStat.getInstance();
        if (customStat == null || hashMap.size() <= 0) {
            return;
        }
        customStat.WaStat(new ICoreStat.WaData(str, str2, str3, hashMap, null));
    }
}
