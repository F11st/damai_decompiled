package com.ali.user.open.tbauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.AuthOption;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.tbauth.context.TbAuthContext;
import com.ali.user.open.tbauth.ui.R;
import com.ali.user.open.tbauth.ui.TbAuthWebViewActivity;
import com.alibaba.security.biometrics.service.common.ABLogRecorderKeys;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import tb.uj2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class TbAuthComponent {
    public static final TbAuthComponent INSTANCE = new TbAuthComponent();
    private static final String OAUTH_API = "taobao.oauth.code.create";
    private static final String TAG = "TbAuthComponent";

    private TbAuthComponent() {
    }

    private String getIbbCode() {
        if (TbAuthContext.isBind) {
            boolean z = TbAuthContext.needSession;
            return ABLogRecorderKeys.EventIdEndUploadImg5;
        }
        return "";
    }

    public void showH5Login(Activity activity) {
        SDKLogger.d(TAG, "open H5 login");
        HashMap hashMap = new HashMap();
        hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_H5", hashMap);
        Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
        intent.putExtra("url", ConfigManager.LOGIN_HOST + ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey() + "&sdkTraceId=" + TbAuthContext.traceId);
        intent.putExtra("title", activity.getString(R.string.member_sdk_authorize_title));
        activity.startActivityForResult(intent, RequestCode.OPEN_H5_LOGIN);
    }

    public void showLogin(Activity activity) {
        SDKLogger.d(TAG, "showLogin");
        AuthOption authOption = KernelContext.sOneTimeAuthOption;
        AuthOption authOption2 = AuthOption.H5ONLY;
        if (authOption == authOption2) {
            showH5Login(activity);
        } else if (!TbAuthContext.h5Only && KernelContext.authOption != authOption2) {
            Intent intent = new Intent();
            intent.setAction(uj2.ACTION_CUSTOM);
            intent.setPackage("com.taobao.taobao");
            StringBuilder sb = new StringBuilder("tbopen://m.taobao.com/getway/oauth?");
            sb.append("&appkey=");
            sb.append(((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
            sb.append("&pluginName=");
            sb.append(OAUTH_API);
            sb.append("&apkSign=");
            sb.append("&sign=");
            if (!TextUtils.isEmpty(getIbbCode())) {
                if (!TextUtils.isEmpty(TbAuthContext.sIBB)) {
                    sb.append("&IBB=");
                    sb.append(TbAuthContext.sIBB);
                }
                if (!TextUtils.isEmpty(TbAuthContext.sSceneCode)) {
                    sb.append("&sceneCode=");
                    sb.append(TbAuthContext.sSceneCode);
                } else {
                    sb.append("&BaiChuanIBB4Bind=");
                    sb.append(getIbbCode());
                }
            } else {
                if (!TextUtils.isEmpty(TbAuthContext.sIBB)) {
                    sb.append("&IBB=");
                    sb.append(TbAuthContext.sIBB);
                }
                if (!TextUtils.isEmpty(TbAuthContext.sSceneCode)) {
                    sb.append("&sceneCode=");
                    sb.append(TbAuthContext.sSceneCode);
                } else {
                    sb.append("&sceneCode=10000");
                }
            }
            if (!TextUtils.isEmpty(TbAuthContext.authorizeToken)) {
                sb.append("&authorizeToken=");
                sb.append(TbAuthContext.authorizeToken);
            }
            sb.append("&sdkTraceId=" + TbAuthContext.traceId);
            intent.setData(Uri.parse(sb.toString()));
            if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, TbAuthContext.traceId);
                    ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_TaobaoOauth", "Page_TaobaoOauth_Native", hashMap);
                    activity.startActivityForResult(intent, RequestCode.OPEN_TAOBAO);
                    return;
                } catch (Throwable th) {
                    SDKLogger.d(TAG, "startActivityForResult fail == " + th.getMessage());
                    showH5Login(activity);
                    return;
                }
            }
            showH5Login(activity);
        } else {
            showH5Login(activity);
        }
    }
}
