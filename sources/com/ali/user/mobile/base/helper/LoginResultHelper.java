package com.ali.user.mobile.base.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginResultHelper {
    public static final String TAG = "Login.LoginResultHelper";

    public static void gotoH5PlaceHolder(Context context, LoginReturnData loginReturnData, LoginParam loginParam) {
        if (context == null || TextUtils.isEmpty(loginReturnData.h5Url)) {
            return;
        }
        if (loginParam == null) {
            loginParam = new LoginParam();
        }
        loginParam.scene = loginReturnData.scene;
        loginParam.token = loginReturnData.token;
        loginParam.loginSite = loginReturnData.site;
        loginParam.isFromRegister = false;
        loginParam.isFoundPassword = false;
        loginParam.h5QueryString = null;
        Map<String, String> map = loginReturnData.extMap;
        if (map != null) {
            if (loginParam.externParams == null) {
                loginParam.externParams = map;
            } else {
                loginParam.externParams = new HashMap();
                for (Map.Entry<String, String> entry : loginReturnData.extMap.entrySet()) {
                    loginParam.externParams.put(entry.getKey(), entry.getValue());
                }
            }
        }
        UrlParam urlParam = new UrlParam();
        urlParam.url = loginReturnData.h5Url;
        urlParam.token = loginReturnData.token;
        urlParam.scene = loginReturnData.scene;
        urlParam.requestCode = 257;
        urlParam.loginParam = loginParam;
        if (ServiceFactory.getService(NavigatorService.class) != null) {
            if (context instanceof Activity) {
                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).startWebViewForResult((Activity) context, urlParam);
                return;
            } else {
                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(context, urlParam);
                return;
            }
        }
        TLogAdapter.e(TAG, "NavigationService is null!");
    }
}
