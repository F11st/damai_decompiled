package com.alipay.share.sdk.openapi.channel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APMessageAct {
    public static boolean send(Context context, String str, String str2, Bundle bundle) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(Constant.EXTRA_MESSAGE_SDK_VERSION, Constant.SDK_VERSION);
            intent.putExtra(Constant.EXTRA_MESSAGE_APP_PACKAGE_NAME, packageName);
            intent.putExtra(Constant.EXTRA_MESSAGE_CONTENT, str2);
            intent.putExtra("actionType", ShareConstant.OUT_SHARE_ACTION_TYPE);
            intent.putExtra(Constant.EXTRA_MESSAGE_CHECK_SUM, MMessageUtil.a(str2, packageName));
            intent.addFlags(268435456);
            try {
                context.startActivity(intent);
                Log.d("APSDK.APMessageAct", "send alipay message, intent=" + intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                Log.e("APSDK.APMessageAct", "send fail, target ActivityNotFound");
                return false;
            } catch (Exception e) {
                Log.e("APSDK.APMessageAct", "send fail " + e.getMessage());
                return false;
            }
        }
        Log.e("APSDK.APMessageAct", "send fail, invalid arguments");
        return false;
    }

    public static boolean sendToZFB(Context context, String str, Bundle bundle) {
        return send(context, "alipays://platformapi/startapp?appId=20000167&actionType=outShare", str, bundle);
    }
}
