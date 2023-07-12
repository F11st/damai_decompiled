package com.youku.live.dago.widgetlib.ailpchat;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PMTopicIdManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile PMTopicIdManager sInstance;
    private Map<String, Integer> mTopicIdMap = new HashMap();

    public static PMTopicIdManager getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "253761519")) {
            return (PMTopicIdManager) ipChange.ipc$dispatch("253761519", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (PMTopicIdManager.class) {
                if (sInstance == null) {
                    sInstance = new PMTopicIdManager();
                }
            }
        }
        return sInstance;
    }

    public int getTopicSubscribeCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "986898270")) {
            return ((Integer) ipChange.ipc$dispatch("986898270", new Object[]{this, str})).intValue();
        }
        if (this.mTopicIdMap.containsKey(str)) {
            return this.mTopicIdMap.get(str).intValue();
        }
        return 0;
    }

    public void notifySubscribe(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423550092")) {
            ipChange.ipc$dispatch("-423550092", new Object[]{this, str});
        } else if (this.mTopicIdMap.containsKey(str)) {
            this.mTopicIdMap.put(str, Integer.valueOf(this.mTopicIdMap.get(str).intValue() + 1));
        } else {
            this.mTopicIdMap.put(str, 1);
        }
    }

    public void notifyUnsubscribe(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1735867533")) {
            ipChange.ipc$dispatch("1735867533", new Object[]{this, str});
        } else if (this.mTopicIdMap.containsKey(str)) {
            int intValue = this.mTopicIdMap.get(str).intValue() - 1;
            this.mTopicIdMap.put(str, Integer.valueOf(intValue >= 0 ? intValue : 0));
        } else {
            this.mTopicIdMap.put(str, 0);
        }
    }

    public void setTopicIdSubscribeCount(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999391641")) {
            ipChange.ipc$dispatch("-1999391641", new Object[]{this, str, Integer.valueOf(i)});
        } else {
            this.mTopicIdMap.put(str, Integer.valueOf(i));
        }
    }
}
