package com.youku.arch.beast.messenger;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsException;
import com.youku.arch.beast.PcsManager;
import com.youku.arch.beast.messenger.Messenger;
import com.youku.util.Logger;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Deliver {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void delive(Messenger.Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436951706")) {
            ipChange.ipc$dispatch("-1436951706", new Object[]{message});
            return;
        }
        String formJSONString = message.formJSONString();
        Logger.d("beast", formJSONString);
        try {
            ACCSClient.getAccsClient("youku").sendData(new ACCSManager.AccsRequest(null, PcsManager.SERVICE_ID, formJSONString.getBytes(), null));
        } catch (AccsException e) {
            e.printStackTrace();
        }
    }
}
