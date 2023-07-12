package org.android.agoo.assist.filter.operator;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.accs.utl.ALog;
import org.android.agoo.assist.AssistCallback;
import org.android.agoo.assist.filter.Operator;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.vivo.VivoBadgeReceiver;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class VivoOperator extends Operator {
    private static final String TAG = "VivoOperator";

    @Override // org.android.agoo.assist.filter.Operator
    public void onPayload(String str) {
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onRegister(AssistCallback assistCallback) {
        assistCallback.onRegisterVivo(this.context);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VivoBadgeReceiver.ACTION_MPM_MESSAGE_BOX_UNREAD);
            LocalBroadcastManager.getInstance(this.context).registerReceiver(new VivoBadgeReceiver(), intentFilter);
        } catch (Throwable th) {
            ALog.e(TAG, "onRegister err", th, new Object[0]);
        }
    }

    @Override // org.android.agoo.assist.filter.Operator
    public void onToken(String str) {
    }

    @Override // org.android.agoo.assist.filter.Operator
    public String parseMsgFromIntent(Intent intent) {
        return intent.getStringExtra(AgooConstants.MESSAGE_VIVO_PAYLOAD);
    }
}
