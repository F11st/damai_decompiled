package com.youku.live.messagechannel.message;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.callback.IMCDispatchMsgCallback;
import com.youku.live.messagechannel.utils.MyLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCMessageDispatcher {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "com.youku.live.messagechannel.message.MCMessageDispatcher";
    private static Map<Long, Map<String, IMCDispatchMsgCallback>> dispatchers = new ConcurrentHashMap();

    public static Map<String, IMCDispatchMsgCallback> getDispatcher(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-401371371") ? (Map) ipChange.ipc$dispatch("-401371371", new Object[]{Long.valueOf(j)}) : dispatchers.get(Long.valueOf(j));
    }

    public static void registerDispatcher(long j, String str, IMCDispatchMsgCallback iMCDispatchMsgCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598447423")) {
            ipChange.ipc$dispatch("1598447423", new Object[]{Long.valueOf(j), str, iMCDispatchMsgCallback});
            return;
        }
        Map<String, IMCDispatchMsgCallback> map = dispatchers.get(Long.valueOf(j));
        if (map == null) {
            Map<Long, Map<String, IMCDispatchMsgCallback>> map2 = dispatchers;
            Long valueOf = Long.valueOf(j);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            map2.put(valueOf, concurrentHashMap);
            map = concurrentHashMap;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put(str, iMCDispatchMsgCallback);
        MyLog.d(TAG, "Register new dispatcher:", iMCDispatchMsgCallback.toString(), " appId:", Long.valueOf(j), " channelId:", str);
    }

    public static void unregisterDispatcher(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1827424616")) {
            ipChange.ipc$dispatch("1827424616", new Object[]{Long.valueOf(j), str});
            return;
        }
        Map<String, IMCDispatchMsgCallback> map = dispatchers.get(Long.valueOf(j));
        if (map == null || !map.containsKey(str)) {
            return;
        }
        MyLog.d(TAG, "Unregister dispatcher:", map.remove(str).toString(), " appId:", Long.valueOf(j), " channelId:", str);
    }
}
