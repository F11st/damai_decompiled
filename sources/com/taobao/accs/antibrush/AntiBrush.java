package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ali.user.mobile.utils.UTConstans;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.MsgDistribute;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.concurrent.ScheduledFuture;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost;
    private static volatile boolean mIsInCheckCodeActivity;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver = null;
    private Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AntiReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                try {
                    String stringExtra = intent.getStringExtra(UTConstans.CustomEvent.UT_REG_RESULT);
                    ALog.e(AntiBrush.TAG, "anti onReceive result: " + stringExtra, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), stringExtra.equalsIgnoreCase("success"));
                } catch (Exception e) {
                    ALog.e(AntiBrush.TAG, "anti onReceive", e, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                }
            } catch (Throwable th) {
                AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                throw th;
            }
        }
    }

    public AntiBrush(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void handleantiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.e(TAG, "handleantiBrush return", "mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("Location", str);
            ALog.e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
        } catch (Throwable th) {
            ALog.e(TAG, "handleantiBrush", th, new Object[0]);
        }
    }

    public static void onResult(Context context, boolean z) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", 104);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z);
        MsgDistribute.getInstance().distribute(context, intent);
        ScheduledFuture<?> scheduledFuture = mTimeoutTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            mTimeoutTask = null;
        }
        String str = mHost;
        if (str != null) {
            UtilityImpl.storeCookie(context, CookieMgr.getCookieSec(str));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(3:15|16|(4:18|(1:20)(1:34)|21|(2:23|(9:25|(1:27)|28|(1:30)(1:33)|31|4|5|(1:9)|11))))|3|4|5|(2:7|9)|11|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
        r8 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkAntiBrush(java.net.URL r8, java.util.Map<java.lang.Integer, java.lang.String> r9) {
        /*
            r7 = this;
            r0 = 1
            java.lang.String r1 = "AntiBrush"
            r2 = 0
            if (r9 == 0) goto L88
            android.content.Context r3 = r7.mContext     // Catch: java.lang.Throwable -> L85
            boolean r3 = com.taobao.accs.utl.UtilityImpl.isForeground(r3)     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L88
            com.taobao.accs.base.TaoBaseService$ExtHeaderType r3 = com.taobao.accs.base.TaoBaseService.ExtHeaderType.TYPE_STATUS     // Catch: java.lang.Throwable -> L85
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L85
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.Object r3 = r9.get(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L85
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L26
            r3 = 0
            goto L2e
        L26:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L85
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L85
        L2e:
            r4 = 419(0x1a3, float:5.87E-43)
            if (r3 != r4) goto L88
            com.taobao.accs.base.TaoBaseService$ExtHeaderType r3 = com.taobao.accs.base.TaoBaseService.ExtHeaderType.TYPE_LOCATION     // Catch: java.lang.Throwable -> L85
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L85
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.Object r9 = r9.get(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L85
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L85
            if (r3 != 0) goto L88
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r3.<init>()     // Catch: java.lang.Throwable -> L85
            java.lang.String r4 = "start anti bursh location:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L85
            r3.append(r9)     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L85
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L85
            com.taobao.accs.utl.ALog.e(r1, r3, r4)     // Catch: java.lang.Throwable -> L85
            r7.handleantiBrush(r9)     // Catch: java.lang.Throwable -> L85
            java.util.concurrent.ScheduledFuture<?> r9 = com.taobao.accs.antibrush.AntiBrush.mTimeoutTask     // Catch: java.lang.Throwable -> L85
            r3 = 0
            if (r9 == 0) goto L6b
            r9.cancel(r0)     // Catch: java.lang.Throwable -> L85
            com.taobao.accs.antibrush.AntiBrush.mTimeoutTask = r3     // Catch: java.lang.Throwable -> L85
        L6b:
            com.taobao.accs.antibrush.AntiBrush$1 r9 = new com.taobao.accs.antibrush.AntiBrush$1     // Catch: java.lang.Throwable -> L85
            r9.<init>()     // Catch: java.lang.Throwable -> L85
            r4 = 60000(0xea60, double:2.9644E-319)
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L85
            java.util.concurrent.ScheduledFuture r9 = com.taobao.accs.common.ThreadPoolExecutorFactory.schedule(r9, r4, r6)     // Catch: java.lang.Throwable -> L85
            com.taobao.accs.antibrush.AntiBrush.mTimeoutTask = r9     // Catch: java.lang.Throwable -> L85
            if (r8 != 0) goto L7e
            goto L82
        L7e:
            java.lang.String r3 = r8.getHost()     // Catch: java.lang.Throwable -> L85
        L82:
            com.taobao.accs.antibrush.AntiBrush.mHost = r3     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r8 = move-exception
            r0 = 0
            goto Lab
        L88:
            r0 = 0
        L89:
            java.lang.String r8 = com.taobao.accs.client.GlobalClientInfo.mCookieSec     // Catch: java.lang.Throwable -> Laa
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Laa
            if (r8 != 0) goto Lb2
            java.lang.String r8 = com.taobao.accs.antibrush.AntiBrush.mHost     // Catch: java.lang.Throwable -> Laa
            java.lang.String r8 = com.taobao.accs.antibrush.CookieMgr.getCookieSec(r8)     // Catch: java.lang.Throwable -> Laa
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> Laa
            if (r8 == 0) goto Lb2
            java.lang.String r8 = "cookie invalid, clear"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Laa
            com.taobao.accs.utl.ALog.e(r1, r8, r9)     // Catch: java.lang.Throwable -> Laa
            android.content.Context r8 = r7.mContext     // Catch: java.lang.Throwable -> Laa
            com.taobao.accs.utl.UtilityImpl.clearCookie(r8)     // Catch: java.lang.Throwable -> Laa
            goto Lb2
        Laa:
            r8 = move-exception
        Lab:
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r2 = "checkAntiBrush error"
            com.taobao.accs.utl.ALog.e(r1, r2, r8, r9)
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.antibrush.AntiBrush.checkAntiBrush(java.net.URL, java.util.Map):boolean");
    }
}
