package com.taobao.android.tlog.protocol.model.request;

import android.text.TextUtils;
import com.ali.user.mobile.ui.WebConstant;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import com.taobao.android.tlog.protocol.model.request.base.LogRequestBase;
import com.taobao.android.tlog.protocol.utils.RandomIdUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApplyTokenRequest extends LogRequestBase {
    public FileInfo[] fileInfos;
    public String uploadId;
    private String TAG = "TLOG.Protocol.ApplyTokenRequestInfo";
    private String requestType = "REQUEST";

    public RequestResult build(String str) throws Exception {
        String randomId = RandomIdUtils.getRandomId();
        String randomId2 = !TextUtils.isEmpty(str) ? str : RandomIdUtils.getRandomId();
        JSONObject buildRequestHeader = BuilderHelper.buildRequestHeader(this, randomId, randomId2);
        JSONObject jSONObject = new JSONObject();
        String str2 = this.uploadId;
        if (str2 != null) {
            jSONObject.put("uploadId", (Object) str2);
        }
        String str3 = this.tokenType;
        if (str3 != null) {
            jSONObject.put(WebConstant.WEB_LOGIN_TOKEN_TYPE, (Object) str3);
        }
        UploadTokenInfo uploadTokenInfo = this.tokenInfo;
        if (uploadTokenInfo != null) {
            jSONObject.put("tokenInfo", (Object) uploadTokenInfo);
        }
        FileInfo[] fileInfoArr = this.fileInfos;
        if (fileInfoArr != null) {
            jSONObject.put("fileInfos", (Object) BuilderHelper.buildFileInfos(fileInfoArr));
        }
        return BuilderHelper.buildRequestResult(jSONObject, buildRequestHeader, this.requestType, randomId, randomId2, this.uploadId);
    }

    public RequestResult build() throws Exception {
        return build(RandomIdUtils.getRandomId());
    }
}
