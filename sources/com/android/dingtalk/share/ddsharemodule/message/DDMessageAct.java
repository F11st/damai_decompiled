package com.android.dingtalk.share.ddsharemodule.message;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.android.dingtalk.share.ddsharemodule.plugin.SignatureCheck;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DDMessageAct {
    private static final String TAG = "DDMessageAct";

    private static Intent initIntent(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse(str));
    }

    private static Intent initSendByAuthIntent() {
        return initIntent(ShareConstant.DD_SEND_AUTH_ACTIVITY_SCHEME);
    }

    private static Intent initSendDingIntent() {
        return initIntent(ShareConstant.DD_DING_ACTIVITY_SCHEME);
    }

    private static Intent initSendFriendIntent() {
        return initIntent(ShareConstant.DD_ENTER_ACTIVITY_SCHEME);
    }

    private static boolean send(Context context, String str, Bundle bundle, Intent intent) {
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String packageName = context.getPackageName();
        String mD5Signature = SignatureCheck.getMD5Signature(context, packageName);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_SDK_VERSION, 20160101);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME, packageName);
        intent.putExtra(ShareConstant.EXTRA_ACTION_TYPE, ShareConstant.OUT_SHARE_ACTION_TYPE);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_SIGNATURE, mD5Signature);
        intent.putExtra(ShareConstant.EXTRA_MESSAGE_APP_ID, str);
        try {
            context.startActivity(intent);
            Log.d(TAG, "send dd message, intent=" + intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            Log.e(TAG, "send v2 fail, target ActivityNotFound");
            return false;
        } catch (Exception e) {
            Log.e(TAG, "send v2 fail " + e.getMessage());
            return false;
        }
    }

    public static boolean sendDDAuth(Context context, String str, Bundle bundle) {
        if (context != null) {
            return send(context, str, bundle, initSendByAuthIntent());
        }
        Log.e(TAG, "send fail, invalid arguments");
        return false;
    }

    public static boolean sendDDFriend(Context context, String str, Bundle bundle) {
        if (context != null) {
            return send(context, str, bundle, initSendFriendIntent());
        }
        Log.e(TAG, "send fail, invalid arguments");
        return false;
    }

    public static boolean sendDing(Context context, String str, Bundle bundle) {
        if (context != null) {
            return send(context, str, bundle, initSendDingIntent());
        }
        Log.e(TAG, "send fail, invalid arguments");
        return false;
    }
}
