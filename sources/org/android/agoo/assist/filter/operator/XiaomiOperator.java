package org.android.agoo.assist.filter.operator;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.taobao.accs.utl.ALog;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.android.agoo.assist.AssistCallback;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.assist.filter.Operator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class XiaomiOperator extends Operator {
    private static final String TAG = "XiaomiOperator";

    @Override // org.android.agoo.assist.filter.Operator
    public void onPayload(String str) {
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onRegister(AssistCallback assistCallback) {
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            assistCallback.onRegisterXiaomi(this.context, applicationInfo.metaData.getString(AssistConstant.META_DATA.XM_APP_ID).replace("appid=", ""), applicationInfo.metaData.getString(AssistConstant.META_DATA.XM_APP_KEY).replace("appkey=", ""));
        } catch (Exception e) {
            ALog.e(TAG, "onRegister", e, new Object[0]);
        }
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onToken(String str) {
        Intent intent = new Intent("com.taobao.android.mipush.token");
        intent.putExtra("token", str);
        this.context.sendBroadcast(intent);
    }

    @Override // org.android.agoo.assist.filter.Operator
    public String parseMsgFromIntent(Intent intent) {
        return ((MiPushMessage) intent.getSerializableExtra(PushMessageHelper.KEY_MESSAGE)).getContent();
    }
}
