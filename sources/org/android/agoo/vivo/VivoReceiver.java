package org.android.agoo.vivo;

import android.content.Context;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import org.android.agoo.assist.AssistManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class VivoReceiver extends OpenClientPushMessageReceiver {
    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        AssistManager.reportToken(str);
    }
}
