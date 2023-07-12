package com.taobao.login4android.biz.getWapCookies;

import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.log.ApiReferer;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.mobile.rpc.RpcRequest;
import com.ali.user.mobile.service.RpcService;
import com.ali.user.mobile.service.ServiceFactory;
import com.alibaba.fastjson.JSON;
import com.taobao.login4android.biz.getAlipayCookies.mtop.GetThirdCookiesResponseData;
import com.taobao.login4android.biz.getWapCookies.mtop.GetWapLoginCookiesResponseData;
import com.taobao.login4android.session.SessionManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GetWapLoginCookiesBusiness {
    public GetThirdCookiesResponseData getAlipayCookies() {
        SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        if (sessionManager.checkSessionValid()) {
            try {
                RpcRequest rpcRequest = new RpcRequest();
                rpcRequest.API_NAME = ApiConstants.ApiName.GET_ALIPAY_COOKIES;
                rpcRequest.VERSION = "1.0";
                rpcRequest.NEED_SESSION = true;
                rpcRequest.NEED_ECODE = true;
                rpcRequest.addParam("umidToken", AppInfo.getInstance().getUmidToken());
                rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
                return (GetThirdCookiesResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, GetThirdCookiesResponseData.class, sessionManager.getUserId());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public String[] getWapCookies(String str, boolean z) {
        String[] strArr;
        SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
        if (sessionManager.checkSessionValid()) {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.API_NAME = ApiConstants.ApiName.GET_WAP_LOGIN_COOKIES;
            rpcRequest.VERSION = "1.0";
            rpcRequest.NEED_SESSION = true;
            rpcRequest.NEED_ECODE = true;
            rpcRequest.addParam("apiReferer", str);
            rpcRequest.requestSite = DataProviderFactory.getDataProvider().getSite();
            try {
                GetWapLoginCookiesResponseData getWapLoginCookiesResponseData = (GetWapLoginCookiesResponseData) ((RpcService) ServiceFactory.getService(RpcService.class)).post(rpcRequest, GetWapLoginCookiesResponseData.class, sessionManager.getUserId());
                if (getWapLoginCookiesResponseData == null || (strArr = getWapLoginCookiesResponseData.result) == null) {
                    return null;
                }
                if (z && strArr == null) {
                    ApiReferer.Refer refer = new ApiReferer.Refer();
                    refer.eventName = "refreshCookiesFailed";
                    SessionManager.getInstance(DataProviderFactory.getApplicationContext()).appendEventTrace(JSON.toJSONString(refer));
                }
                return strArr;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
