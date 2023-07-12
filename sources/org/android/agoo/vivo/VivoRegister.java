package org.android.agoo.vivo;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.android.agoo.assist.common.AssistConstant;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes2.dex */
public class VivoRegister {
    public static final String TAG = "VivoRegister";
    private static Context mContext;
    private static VivoBadgeReceiver vivoBadgeReceiver;

    public static void register(final Context context) {
        if (context == null) {
            return;
        }
        try {
            mContext = context.getApplicationContext();
            if (!UtilityImpl.isMainProcess(context)) {
                ALog.i(TAG, "not in main process, return", new Object[0]);
            } else if (PushClient.getInstance(context).isSupport()) {
                ALog.d(TAG, "register start", new Object[0]);
                BaseNotifyClickActivity.addNotifyListener(new VivoMsgParseImpl());
                PushClient.getInstance(context).initialize();
                PushClient.getInstance(context).turnOnPush(new IPushActionListener() { // from class: org.android.agoo.vivo.VivoRegister.1
                    @Override // com.vivo.push.IPushActionListener
                    public void onStateChanged(int i) {
                        ALog.d(VivoRegister.TAG, "turnOnPush", "state", Integer.valueOf(i));
                        if (i == 0) {
                            String regId = PushClient.getInstance(context).getRegId();
                            if (TextUtils.isEmpty(regId)) {
                                return;
                            }
                            NotifManager notifManager = new NotifManager();
                            notifManager.init(context.getApplicationContext());
                            notifManager.reportThirdPushToken(regId, AssistConstant.TOKEN_TYPE_VIVO, "1.1.5", true);
                        }
                    }
                });
                vivoBadgeReceiver = new VivoBadgeReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(VivoBadgeReceiver.ACTION_MPM_MESSAGE_BOX_UNREAD);
                LocalBroadcastManager.getInstance(context).registerReceiver(vivoBadgeReceiver, intentFilter);
            } else {
                ALog.e(TAG, "this device is not support vivo push", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "register", th, new Object[0]);
        }
    }

    public static void unregister() {
        ALog.i(TAG, MiPushClient.COMMAND_UNREGISTER, new Object[0]);
        if (vivoBadgeReceiver != null) {
            LocalBroadcastManager.getInstance(mContext).unregisterReceiver(vivoBadgeReceiver);
        }
        PushClient.getInstance(mContext).turnOffPush(new IPushActionListener() { // from class: org.android.agoo.vivo.VivoRegister.2
            @Override // com.vivo.push.IPushActionListener
            public void onStateChanged(int i) {
                ALog.d(VivoRegister.TAG, "turnOffPush", "state", Integer.valueOf(i));
            }
        });
    }
}
