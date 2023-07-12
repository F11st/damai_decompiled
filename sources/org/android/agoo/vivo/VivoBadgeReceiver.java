package org.android.agoo.vivo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.taobao.accs.utl.ALog;
import com.vivo.push.PushClientConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class VivoBadgeReceiver extends BroadcastReceiver {
    public static final String ACTION_MPM_MESSAGE_BOX_UNREAD = "msg.action.ACTION_MPM_MESSAGE_BOX_UNREAD";
    public static final String EXTRA_KEY_TIP_NUMBER = "tipNumber";
    public static final String EXTRA_KEY_TIP_TYPE = "tipType";
    public static final int FLAG_RECEIVER_INCLUDE_BACKGROUND = 16777216;
    private static final String TAG = VivoBadgeReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String str = TAG;
            ALog.d(str, "onReceive badge broadcast", new Object[0]);
            int intExtra = intent.getIntExtra(EXTRA_KEY_TIP_TYPE, -1);
            int intExtra2 = intent.getIntExtra(EXTRA_KEY_TIP_NUMBER, 0);
            Intent intent2 = new Intent();
            intent2.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent2.putExtra("packageName", context.getPackageName());
            intent2.putExtra(PushClientConstants.TAG_CLASS_NAME, "com.taobao.tao.welcome.Welcome");
            if (intExtra2 > 0 && intExtra == 0) {
                ALog.d(str, "onReceive badge tipNum ", Integer.valueOf(intExtra2));
                intent2.putExtra("notificationNum", intExtra2);
            } else {
                ALog.d(str, "onReceive badge reset ", new Object[0]);
                intent2.putExtra("notificationNum", 0);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                intent2.addFlags(16777216);
            }
            context.sendBroadcast(intent2);
        } catch (Exception e) {
            ALog.e(TAG, "onReceive badge error ", e, new Object[0]);
            e.printStackTrace();
        }
    }
}
