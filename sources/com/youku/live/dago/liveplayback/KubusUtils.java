package com.youku.live.dago.liveplayback;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.kubus.Event;
import com.youku.kubus.Response;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class KubusUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> T request(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1125676919") ? (T) ipChange.ipc$dispatch("-1125676919", new Object[]{alixPlayerContext, str}) : (T) request(alixPlayerContext, new Event(str));
    }

    public static boolean requestBoolean(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138644381")) {
            return ((Boolean) ipChange.ipc$dispatch("-1138644381", new Object[]{alixPlayerContext, str})).booleanValue();
        }
        Event event = new Event(str);
        try {
            try {
                Response request = alixPlayerContext.getEventBus().request(event, null);
                if (request.code == 200) {
                    return ((Boolean) request.body).booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            alixPlayerContext.getEventBus().release(event);
        }
    }

    public static int requestInt(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589245291")) {
            return ((Integer) ipChange.ipc$dispatch("589245291", new Object[]{alixPlayerContext, str})).intValue();
        }
        Event event = new Event(str);
        try {
            try {
                Response request = alixPlayerContext.getEventBus().request(event, null);
                if (request.code == 200) {
                    return ((Integer) request.body).intValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            alixPlayerContext.getEventBus().release(event);
            return -1;
        } finally {
            alixPlayerContext.getEventBus().release(event);
        }
    }

    public static Map requestMap(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2123370464")) {
            return (Map) ipChange.ipc$dispatch("-2123370464", new Object[]{alixPlayerContext, str});
        }
        Event event = new Event(str);
        try {
            try {
                Response request = alixPlayerContext.getEventBus().request(event, null);
                if (request.code == 200) {
                    return (Map) request.body;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } finally {
            alixPlayerContext.getEventBus().release(event);
        }
    }

    public static <T> T request(AlixPlayerContext alixPlayerContext, Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067304387")) {
            return (T) ipChange.ipc$dispatch("-2067304387", new Object[]{alixPlayerContext, event});
        }
        try {
            try {
                Response request = alixPlayerContext.getEventBus().request(event, null);
                if (request.code == 200) {
                    return (T) request.body;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } finally {
            alixPlayerContext.getEventBus().release(event);
        }
    }

    public static boolean requestBoolean(AlixPlayerContext alixPlayerContext, Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962860349")) {
            return ((Boolean) ipChange.ipc$dispatch("-1962860349", new Object[]{alixPlayerContext, event})).booleanValue();
        }
        try {
            try {
                Response request = alixPlayerContext.getEventBus().request(event, null);
                if (request.code == 200) {
                    return ((Boolean) request.body).booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            alixPlayerContext.getEventBus().release(event);
        }
    }
}
