package org.android.agoo.intent;

import android.content.Context;
import android.content.Intent;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class IntentUtil {
    public static final String AGOO_COMMAND = "command";
    private static final String INTENT_FROM_AGOO_COMMAND = ".intent.action.COMMAND";
    private static final String INTENT_FROM_STARTACTIVITY_COMMAND = ".intent.action.startActivity.COMMAND";
    private static final String INTENT_FROM_THIRDPUSH_COMMAND = ".intent.thirdPush.action.COMMAND";
    private static final String TAG = "IntentUtil";

    public static final Intent createActivityIntent(Context context, String str, Intent intent) {
        Intent intent2;
        Intent intent3 = null;
        try {
            intent2 = new Intent();
        } catch (Throwable th) {
            th = th;
        }
        try {
            intent2.setAction(context.getPackageName() + INTENT_FROM_STARTACTIVITY_COMMAND);
            intent2.setPackage(context.getPackageName());
            intent2.setClassName(context, "com.taobao.agoo.AgooStartActivityService");
            intent2.putExtra("command", str);
            intent2.putExtras(intent.getExtras());
            return intent2;
        } catch (Throwable th2) {
            th = th2;
            intent3 = intent2;
            ALog.w(TAG, "createComandIntent", th, new Object[0]);
            return intent3;
        }
    }

    public static final Intent createComandIntent(Context context, String str) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent();
        } catch (Throwable th) {
            th = th;
        }
        try {
            intent.setAction(context.getPackageName() + INTENT_FROM_AGOO_COMMAND);
            intent.setPackage(context.getPackageName());
            intent.putExtra("command", str);
            return intent;
        } catch (Throwable th2) {
            th = th2;
            intent2 = intent;
            ALog.e(TAG, "createComandIntent", th, new Object[0]);
            return intent2;
        }
    }

    public static final Intent createThirdpushComandIntent(Context context, String str) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent();
        } catch (Throwable th) {
            th = th;
        }
        try {
            intent.setAction(getThirdPushCommand(context));
            intent.setPackage(context.getPackageName());
            intent.putExtra("command", str);
            return intent;
        } catch (Throwable th2) {
            th = th2;
            intent2 = intent;
            ALog.w(TAG, "createComandIntent", th, new Object[0]);
            return intent2;
        }
    }

    public static final String getAgooCommand(Context context) {
        if (context != null) {
            try {
                return context.getPackageName() + INTENT_FROM_AGOO_COMMAND;
            } catch (Throwable th) {
                ALog.w(TAG, "getAgooCommand", th, new Object[0]);
                return null;
            }
        }
        return null;
    }

    public static final String getThirdPushCommand(Context context) {
        if (context != null) {
            try {
                return context.getPackageName() + INTENT_FROM_THIRDPUSH_COMMAND;
            } catch (Throwable th) {
                ALog.w(TAG, "getAgooCommand", th, new Object[0]);
                return null;
            }
        }
        return null;
    }
}
