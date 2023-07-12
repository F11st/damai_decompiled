package com.tencent.open.miniapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MiniApp extends BaseApi {
    public static final int MINIAPP_CONTEXT_NULL = -6;
    public static final int MINIAPP_ID_EMPTY = -1;
    public static final int MINIAPP_ID_NOT_DIGIT = -4;
    public static final int MINIAPP_SHOULD_DOWNLOAD = -2;
    public static final String MINIAPP_SRC_ID = "21";
    public static final int MINIAPP_SRC_ID_NOT_DIGIT = -3;
    public static final int MINIAPP_SUCCESS = 0;
    public static final String MINIAPP_TYPE_NORMAL = "mini_program_or_game";
    public static final int MINIAPP_UNKNOWN_TYPE = -5;
    public static final String MINIAPP_VERSION_RELEASE = "release";
    public static final int MINIAPP_VERSION_WRONG = -7;
    public static final String MINIAPP_VERSION_DEVELOP = "develop";
    public static final String MINIAPP_VERSION_TRIAL = "trial";
    public static final List<String> OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = Arrays.asList(MINIAPP_VERSION_DEVELOP, MINIAPP_VERSION_TRIAL, "release");

    public MiniApp(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3, String str4, String str5) {
        if (a.a("openSDK_LOG.MiniApp", null)) {
            return -5;
        }
        if (activity == null) {
            SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
            return -6;
        } else if (!MINIAPP_TYPE_NORMAL.equals(str)) {
            SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
            return -5;
        } else if (TextUtils.isEmpty(str2)) {
            SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
            return -1;
        } else {
            for (int i = 0; i < str2.length(); i++) {
                if (!Character.isDigit(str2.charAt(i))) {
                    SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
                    return -4;
                }
            }
            if (str4 == null) {
                str4 = "";
            }
            if (!OPEN_CONNECT_DEMO_MINI_APP_VERSIONS.contains(str5)) {
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
                return -7;
            } else if (m.e(activity)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setPackage("com.tencent.mobileqq");
                intent.setData(Uri.parse(String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", str, str2, m.k(k.a((Context) activity)), m.k(this.c.getAppId()), str3, m.k(str4), m.k(str5), m.k(this.c.getOpenId()))));
                intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                activity.startActivity(intent);
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
                return 0;
            } else {
                try {
                    new TDialog(activity, "", a(""), null, this.c).show();
                } catch (RuntimeException e) {
                    SLog.e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e.getMessage());
                }
                SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
                return -2;
            }
        }
    }

    public MiniApp(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public MiniApp(QQToken qQToken) {
        super(qQToken);
    }
}
