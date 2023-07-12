package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVApplication extends WVApiPlugin {
    private void getNotificationSettings(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        if (Build.VERSION.SDK_INT < 22) {
            wVResult.addData("status", "unknown");
            wVCallBackContext.success(wVResult);
        } else if (!WVUtils.isNotificationEnabled(this.mContext)) {
            wVResult.addData("status", "denied");
            wVCallBackContext.success(wVResult);
        } else {
            wVResult.addData("status", "authorized");
            wVCallBackContext.success(wVResult);
        }
    }

    private void openSettings(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            try {
                str2 = new JSONObject(str).optString("type", "");
            } catch (JSONException unused) {
                wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
                str2 = null;
            }
            if ("Notification".equals(str2)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    Intent intent = new Intent();
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("app_package", this.mContext.getPackageName());
                    intent.putExtra("app_uid", this.mContext.getApplicationInfo().uid);
                    Context context = this.mContext;
                    if (context != null) {
                        context.startActivity(intent);
                        wVCallBackContext.success();
                        return;
                    }
                }
                WVResult wVResult = new WVResult();
                wVResult.addData("msg", "fail to open Notification Settings");
                wVCallBackContext.error(wVResult);
                return;
            }
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            Context context2 = this.mContext;
            if (context2 != null) {
                intent2.setData(Uri.fromParts("package", context2.getPackageName(), null));
                this.mContext.startActivity(intent2);
                wVCallBackContext.success();
                return;
            }
            WVResult wVResult2 = new WVResult();
            wVResult2.addData("msg", "fail to open Application Settings");
            wVCallBackContext.error(wVResult2);
        } catch (Throwable unused2) {
            wVCallBackContext.error();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getNotificationSettings".equals(str)) {
            getNotificationSettings(wVCallBackContext, str2);
            return true;
        } else if ("openSettings".equals(str)) {
            openSettings(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }
}
