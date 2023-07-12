package com.youku.live.dago.widgetlib.ailpchat;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class MessageDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<String> names = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchReceiveMessage(ChatMessage chatMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1398775363")) {
            ipChange.ipc$dispatch("1398775363", new Object[]{this, chatMessage});
        }
    }
}
