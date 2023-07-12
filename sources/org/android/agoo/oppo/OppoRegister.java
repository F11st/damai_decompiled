package org.android.agoo.oppo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class OppoRegister {
    private static final String OPPO_TOKEN = "OPPO_TOKEN";
    public static final String TAG = "OppoPush";
    private static Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class OppoMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
        private static final String TAG = "OppoMsgParseImpl";

        @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
        public String getMsgSource() {
            return "oppo";
        }

        @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
        public String parseMsgFromIntent(Intent intent) {
            String str = null;
            if (intent == null) {
                ALog.e(TAG, "parseMsgFromIntent null", new Object[0]);
                return null;
            }
            try {
                str = intent.getStringExtra(AgooConstants.MESSAGE_OPPO_PAYLOAD);
                ALog.i(TAG, "parseMsgFromIntent", "msg", str);
                return str;
            } catch (Throwable th) {
                ALog.e(TAG, "parseMsgFromIntent", th, new Object[0]);
                return str;
            }
        }
    }

    public static void register(Context context, String str, String str2) {
        try {
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (!UtilityImpl.isMainProcess(applicationContext)) {
                ALog.i(TAG, "not in main process, return", new Object[0]);
                return;
            }
            Context context2 = mContext;
            HeytapPushManager.init(context2, (context2.getApplicationInfo().flags & 2) != 0);
            if (HeytapPushManager.isSupportPush(mContext)) {
                BaseNotifyClickActivity.addNotifyListener(new OppoMsgParseImpl());
                ALog.i(TAG, "register oppo begin ", new Object[0]);
                HeytapPushManager.register(mContext, str, str2, new ICallBackResultService() { // from class: org.android.agoo.oppo.OppoRegister.1
                    @Override // com.heytap.msp.push.callback.ICallBackResultService
                    public void onError(int i, String str3) {
                    }

                    @Override // com.heytap.msp.push.callback.ICallBackResultService
                    public void onGetNotificationStatus(int i, int i2) {
                        ALog.i(OppoRegister.TAG, "onGetNotificationStatus", new Object[0]);
                    }

                    @Override // com.heytap.msp.push.callback.ICallBackResultService
                    public void onGetPushStatus(int i, int i2) {
                        ALog.i(OppoRegister.TAG, "onGetPushStatus", new Object[0]);
                    }

                    @Override // com.heytap.msp.push.callback.ICallBackResultService
                    public void onRegister(int i, String str3) {
                        ALog.i(OppoRegister.TAG, "onRegister regid=" + str3, new Object[0]);
                        OppoRegister.reportToken(OppoRegister.mContext, str3);
                    }

                    @Override // com.heytap.msp.push.callback.ICallBackResultService
                    public void onSetPushTime(int i, String str3) {
                        ALog.i(OppoRegister.TAG, "onSetPushTime", new Object[0]);
                    }

                    @Override // com.heytap.msp.push.callback.ICallBackResultService
                    public void onUnRegister(int i) {
                        ALog.e(OppoRegister.TAG, "onUnRegister code=" + i, new Object[0]);
                    }
                });
                return;
            }
            ALog.i(TAG, "not support oppo push", new Object[0]);
        } catch (Throwable th) {
            ALog.e(TAG, "register error", th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportToken(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        NotifManager notifManager = new NotifManager();
        notifManager.init(context.getApplicationContext());
        notifManager.reportThirdPushToken(str, "OPPO_TOKEN", true);
    }
}
