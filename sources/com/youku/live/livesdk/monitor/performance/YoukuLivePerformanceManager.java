package com.youku.live.livesdk.monitor.performance;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class YoukuLivePerformanceManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_SIZE = 200;
    private static YoukuLivePerformanceManager mInstance;
    private volatile ConcurrentHashMap<String, YoukuLivePerformance> mPerformanceMap;

    public static long currentTimeMillis() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "107758063") ? ((Long) ipChange.ipc$dispatch("107758063", new Object[0])).longValue() : System.currentTimeMillis();
    }

    public static synchronized YoukuLivePerformanceManager getInstance() {
        synchronized (YoukuLivePerformanceManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1087048219")) {
                return (YoukuLivePerformanceManager) ipChange.ipc$dispatch("1087048219", new Object[0]);
            }
            if (mInstance == null) {
                mInstance = new YoukuLivePerformanceManager();
            }
            return mInstance;
        }
    }

    private ConcurrentHashMap<String, YoukuLivePerformance> getPerfMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298471968")) {
            return (ConcurrentHashMap) ipChange.ipc$dispatch("-1298471968", new Object[]{this});
        }
        if (this.mPerformanceMap == null) {
            synchronized (this) {
                if (this.mPerformanceMap == null) {
                    this.mPerformanceMap = new ConcurrentHashMap<>();
                }
            }
        }
        return this.mPerformanceMap;
    }

    public YoukuLivePerformance getPerfBySessionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216525604")) {
            return (YoukuLivePerformance) ipChange.ipc$dispatch("216525604", new Object[]{this, str});
        }
        if (str == null) {
            str = jn1.MUL;
        }
        YoukuLivePerformance youkuLivePerformance = getPerfMap().get(str);
        if (youkuLivePerformance == null) {
            if (getPerfMap().size() >= 200) {
                getPerfMap().clear();
            }
            YoukuLivePerformance youkuLivePerformance2 = new YoukuLivePerformance();
            getPerfMap().put(str, youkuLivePerformance2);
            return youkuLivePerformance2;
        }
        return youkuLivePerformance;
    }
}
