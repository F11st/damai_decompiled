package com.taobao.agoo;

import android.content.Context;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.utl.ALog;
import org.android.agoo.message.MessageReceiverService;

/* loaded from: classes8.dex */
public class TaobaoMessageIntentReceiverService extends MessageReceiverService {
    @Override // org.android.agoo.message.MessageReceiverService
    public String getIntentServiceClassName(Context context) {
        ALog.w("Taobao", "getPackage Name=" + context.getPackageName(), new Object[0]);
        return AdapterGlobalClientInfo.getAgooCustomServiceName(context.getPackageName());
    }
}
