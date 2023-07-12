package com.taobao.android.tlog.protocol.model.request;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.android.tlog.protocol.builder.UploadDataBuilder;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.request.base.FileInfo;
import com.taobao.android.tlog.protocol.model.request.base.LogRequestBase;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BuilderHelper {
    public static JSONArray buildFileInfos(FileInfo[] fileInfoArr) {
        JSONArray jSONArray = new JSONArray();
        for (FileInfo fileInfo : fileInfoArr) {
            JSONObject jSONObject = new JSONObject();
            String str = fileInfo.fileName;
            if (str != null) {
                jSONObject.put("fileName", (Object) str);
            }
            String str2 = fileInfo.absolutePath;
            if (str2 != null) {
                jSONObject.put("absolutePath", (Object) str2);
            }
            Long l = fileInfo.lastModified;
            if (l != null) {
                jSONObject.put("lastModified", (Object) l);
            }
            Long l2 = fileInfo.contentLength;
            if (l2 != null) {
                jSONObject.put("contentLength", (Object) l2);
            }
            String str3 = fileInfo.contentType;
            if (str3 != null) {
                jSONObject.put("contentType", (Object) str3);
            }
            String str4 = fileInfo.contentMD5;
            if (str4 != null) {
                jSONObject.put("contentMD5", (Object) str4);
            }
            String str5 = fileInfo.contentEncoding;
            if (str5 != null) {
                jSONObject.put("contentEncoding", (Object) str5);
            }
            jSONArray.add(jSONObject);
        }
        return jSONArray;
    }

    public static JSONObject buildRequestHeader(LogRequestBase logRequestBase, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.appKeyName, (Object) logRequestBase.appKey);
        jSONObject.put(Constants.appIdName, (Object) logRequestBase.appId);
        jSONObject.put(Constants.deviceIdName, (Object) logRequestBase.utdid);
        jSONObject.put(Constants.sessionIdName, (Object) str2);
        jSONObject.put(Constants.requestIdName, (Object) str);
        jSONObject.put(Constants.opCodeName, (Object) logRequestBase.opCode);
        return jSONObject;
    }

    public static RequestResult buildRequestResult(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3, String str4) throws Exception {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", (Object) str);
        jSONObject3.put("version", (Object) Constants.version);
        jSONObject3.put("headers", (Object) jSONObject2);
        jSONObject3.put("data", (Object) jSONObject);
        String buildLogUploadContent = UploadDataBuilder.buildLogUploadContent(jSONObject3.toString());
        RequestResult requestResult = new RequestResult();
        requestResult.content = buildLogUploadContent;
        requestResult.requestId = str2;
        requestResult.sessionId = str3;
        requestResult.uploadId = str4;
        return requestResult;
    }
}
