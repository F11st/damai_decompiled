package com.taobao.android.tlog.protocol.model.request;

import android.text.TextUtils;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.base.RemoteFileInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.base.LogRequestBase;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplyUploadCompleteRequest extends LogRequestBase {
    public RemoteFileInfo[] remoteFileInfos;
    private String requestType = "REQUEST";
    public String uploadId;

    private JSONObject buildData(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        String str3 = this.uploadId;
        if (str3 != null) {
            jSONObject.put("uploadId", (Object) str3);
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("errorCode", (Object) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(hh1.DIMEN_MESSAGE, (Object) str2);
        }
        RemoteFileInfo[] remoteFileInfoArr = this.remoteFileInfos;
        if (remoteFileInfoArr != null) {
            jSONObject.put("remoteFileInfos", (Object) remoteFileInfoArr);
        }
        String str4 = this.tokenType;
        if (str4 != null) {
            jSONObject.put(WebConstant.WEB_LOGIN_TOKEN_TYPE, (Object) str4);
        }
        UploadTokenInfo uploadTokenInfo = this.tokenInfo;
        if (uploadTokenInfo != null) {
            jSONObject.put("tokenInfo", (Object) uploadTokenInfo);
        }
        return jSONObject;
    }

    public RequestResult build() throws Exception {
        return build(null, null);
    }

    public RequestResult build(String str, String str2) throws Exception {
        String randomId = RandomIdUtils.getRandomId();
        String randomId2 = RandomIdUtils.getRandomId();
        String randomId3 = RandomIdUtils.getRandomId();
        return BuilderHelper.buildRequestResult(buildData(str, str2), BuilderHelper.buildRequestHeader(this, randomId, randomId2), this.requestType, randomId, randomId2, randomId3);
    }
}
