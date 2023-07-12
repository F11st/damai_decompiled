package org.android.agoo.assist.filter.operator;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.youku.vpm.data.ExtrasInfo;
import org.android.agoo.assist.AssistCallback;
import org.android.agoo.assist.filter.Operator;
import org.android.agoo.huawei.HuaWeiRegister;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HuaweiOperator extends Operator {
    private static final String TAG = "HuaweiOperator";

    @Override // org.android.agoo.assist.filter.Operator
    public void onPayload(String str) {
        if (HuaWeiRegister.isChannelRegister) {
            Intent intent = new Intent();
            intent.setAction("org.agoo.android.intent.action.PING_V4");
            intent.setClassName("com.taobao.taobao", AdapterUtilityImpl.channelService);
            intent.putExtra("source", "huawei-bundle");
            this.context.startService(intent);
        }
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onRegister(AssistCallback assistCallback) {
        try {
            assistCallback.onRegisterHuawei(this.context, this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128).metaData.getString("com.huawei.hms.client.appid").replace("appid=", ""));
        } catch (Exception e) {
            ALog.e(TAG, "onRegister", e, new Object[0]);
        }
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onToken(String str) {
    }

    @Override // org.android.agoo.assist.filter.Operator
    public String parseMsgFromIntent(Intent intent) {
        return intent.getStringExtra(ExtrasInfo.EXTRAS);
    }
}
