package anetwork.channel.interceptor;

import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;
import tb.he;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Callback {
    void onDataReceiveSize(int i, int i2, he heVar);

    void onFinish(DefaultFinishEvent defaultFinishEvent);

    void onResponseCode(int i, Map<String, List<String>> map);
}
