package org.android.agoo.huawei;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import org.android.agoo.assist.AssistManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HuaweiRcvService extends HmsMessageService {
    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        AssistManager.reportMessage(remoteMessage.getData());
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        AssistManager.reportToken(str);
    }
}
