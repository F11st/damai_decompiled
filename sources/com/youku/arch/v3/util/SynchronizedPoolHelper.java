package com.youku.arch.v3.util;

import android.util.SparseArray;
import androidx.core.util.Pools;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SynchronizedPoolHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String TAG = "OneArch.SynchronizedPoolHelper";
    private static final boolean enable = true;
    private static final Pools.SynchronizedPool<HashMap<String, String>> sHashMapSSPool = new Pools.SynchronizedPool<>(200);
    private static final Pools.SynchronizedPool<HashMap<String, Object>> sHashMapSOPool = new Pools.SynchronizedPool<>(200);
    private static final Pools.SynchronizedPool<SparseArray<String>> sSparseArraySPool = new Pools.SynchronizedPool<>(200);
    private static final Pools.SynchronizedPool<StringBuilder> sStringBuilderPool = new Pools.SynchronizedPool<>(200);

    public static HashMap<String, Object> obtainHashMapSO() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1782151315")) {
            return (HashMap) ipChange.ipc$dispatch("-1782151315", new Object[0]);
        }
        HashMap<String, Object> acquire = sHashMapSOPool.acquire();
        return acquire != null ? acquire : new HashMap<>();
    }

    public static HashMap<String, String> obtainHashMapSS() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344441879")) {
            return (HashMap) ipChange.ipc$dispatch("-1344441879", new Object[0]);
        }
        HashMap<String, String> acquire = sHashMapSSPool.acquire();
        return acquire != null ? acquire : new HashMap<>();
    }

    public static SparseArray<String> obtainSparseArrayS() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1879025949")) {
            return (SparseArray) ipChange.ipc$dispatch("1879025949", new Object[0]);
        }
        SparseArray<String> acquire = sSparseArraySPool.acquire();
        return acquire != null ? acquire : new SparseArray<>();
    }

    public static StringBuilder obtainStringBuilder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773301467")) {
            return (StringBuilder) ipChange.ipc$dispatch("-1773301467", new Object[0]);
        }
        StringBuilder acquire = sStringBuilderPool.acquire();
        return acquire != null ? acquire : new StringBuilder();
    }

    public static void recycleHashMapSO(HashMap<String, Object> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133806801")) {
            ipChange.ipc$dispatch("-1133806801", new Object[]{hashMap});
            return;
        }
        hashMap.clear();
        sHashMapSOPool.release(hashMap);
    }

    public static void recycleHashMapSS(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-449716173")) {
            ipChange.ipc$dispatch("-449716173", new Object[]{hashMap});
            return;
        }
        hashMap.clear();
        sHashMapSSPool.release(hashMap);
    }

    public static void recycleSparseArrayS(SparseArray<String> sparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483434235")) {
            ipChange.ipc$dispatch("-1483434235", new Object[]{sparseArray});
            return;
        }
        sparseArray.clear();
        sSparseArraySPool.release(sparseArray);
    }

    public static void recycleStringBuilder(StringBuilder sb) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211258073")) {
            ipChange.ipc$dispatch("-1211258073", new Object[]{sb});
            return;
        }
        sb.setLength(0);
        sStringBuilderPool.release(sb);
    }
}
