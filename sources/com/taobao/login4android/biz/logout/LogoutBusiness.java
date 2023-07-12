package com.taobao.login4android.biz.logout;

import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.info.AlipayInfo;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.rpc.login.model.LogoutRequest;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.login4android.session.SessionManager;
import com.taobao.login4android.session.constants.SessionConstants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogoutBusiness {
    public void logout() {
        SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        logout(sessionManager.getLoginSite(), sessionManager.getSid(), sessionManager.getLoginToken(), sessionManager.getUserId());
    }

    public void logout(LogoutParam logoutParam) {
        if (logoutParam != null) {
            logout(logoutParam.site, logoutParam.sid, logoutParam.autologinToken, logoutParam.userid);
        }
    }

    public void logout(int i, String str, String str2, String str3) {
        logout(i, str, null, str2, str3);
    }

    public void logout(int i, String str, String str2, String str3, String str4) {
        try {
            LogoutRequest logoutRequest = new LogoutRequest();
            logoutRequest.apdid = AlipayInfo.getInstance().getApdid();
            logoutRequest.appKey = DataProviderFactory.getDataProvider().getAppkey();
            logoutRequest.deviceId = DataProviderFactory.getDataProvider().getDeviceId();
            logoutRequest.umidToken = AppInfo.getInstance().getUmidToken();
            logoutRequest.sid = str;
            try {
                Long.parseLong(str4);
                logoutRequest.userId = str4;
            } catch (Exception e) {
                e.printStackTrace();
            }
            logoutRequest.ttid = DataProviderFactory.getDataProvider().getTTID();
            RpcRequest rpcRequest = new RpcRequest();
            if (i == 4) {
                rpcRequest.API_NAME = ApiConstants.ApiName.OCEAN_LOGOUT;
                logoutRequest.autoLoginToken = str3;
            } else {
                rpcRequest.API_NAME = ApiConstants.ApiName.LOGOUT;
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put(SessionConstants.SUBSID, str2);
                }
                logoutRequest.attributes = hashMap;
            }
            logoutRequest.utdid = AppInfo.getInstance().getUtdid();
            rpcRequest.addParam("request", JSON.toJSONString(logoutRequest));
            rpcRequest.addParam("userId", str4);
            rpcRequest.NEED_SESSION = true;
            rpcRequest.NEED_ECODE = false;
            rpcRequest.requestSite = i;
            ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, null, str4);
            ((RpcService) ServiceFactory.getService(RpcService.class)).logout();
            ((RpcService) ServiceFactory.getService(RpcService.class)).setHeader("x-disastergrd", "");
        } catch (Exception e2) {
            LoginTLogAdapter.w("login.LogoutBusiness", "logout from server failed.", e2);
            e2.printStackTrace();
        }
    }
}
