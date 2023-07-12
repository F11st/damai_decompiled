package com.taobao.android.tlog.protocol.model.request;

import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.base.LogRequestBase;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;
import com.taobao.weex.devtools.debug.WXDebugConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StartupRequest extends LogRequestBase {
    public String appVersion;
    public String brand;
    public Long clientTime;
    public String deviceModel;
    public String geo;
    public String ip;
    public String osPlatform;
    public String osVersion;
    private String TAG = "TLOG.Protocol.StartupRequest";
    private String requestType = "REQUEST";

    public RequestResult build() throws Exception {
        String randomId = RandomIdUtils.getRandomId();
        String randomId2 = RandomIdUtils.getRandomId();
        String randomId3 = RandomIdUtils.getRandomId();
        JSONObject buildRequestHeader = BuilderHelper.buildRequestHeader(this, randomId, randomId2);
        JSONObject jSONObject = new JSONObject();
        String str = this.appVersion;
        if (str != null) {
            jSONObject.put("appVersion", (Object) str);
        }
        String str2 = this.deviceModel;
        if (str2 != null) {
            jSONObject.put(WXDebugConstants.ENV_DEVICE_MODEL, (Object) str2);
        }
        String str3 = this.user;
        if (str3 != null) {
            jSONObject.put("userNick", (Object) str3);
        }
        String str4 = this.osPlatform;
        if (str4 != null) {
            jSONObject.put("osPlatform", (Object) str4);
        }
        String str5 = this.osVersion;
        if (str5 != null) {
            jSONObject.put("osVersion", (Object) str5);
        }
        String str6 = this.geo;
        if (str6 != null) {
            jSONObject.put("geo", (Object) str6);
        }
        Long l = this.clientTime;
        if (l != null) {
            jSONObject.put("clientTime", (Object) l);
        }
        String str7 = this.brand;
        if (str7 != null) {
            jSONObject.put("brand", (Object) str7);
        }
        String str8 = this.ip;
        if (str8 != null) {
            jSONObject.put(TbAuthConstants.IP, (Object) str8);
        }
        String str9 = this.tokenType;
        if (str9 != null) {
            jSONObject.put(WebConstant.WEB_LOGIN_TOKEN_TYPE, (Object) str9);
        }
        UploadTokenInfo uploadTokenInfo = this.tokenInfo;
        if (uploadTokenInfo != null) {
            jSONObject.put("tokenInfo", (Object) uploadTokenInfo);
        }
        return BuilderHelper.buildRequestResult(jSONObject, buildRequestHeader, this.requestType, randomId, randomId2, randomId3);
    }
}
