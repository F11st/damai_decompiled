package com.alibaba.emas.publish.channel.mtop;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.k.b;
import java.io.Serializable;
import java.util.ArrayList;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import tb.gn;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class a {
    public PublishMtopResponse a(Serializable serializable, Context context, String str, boolean z) throws Exception {
        if (TextUtils.isEmpty(str)) {
            str = "600000@taobao_android_failure";
        }
        MtopBuilder build = Mtop.instance(z ? Mtop.Id.OPEN : Mtop.Id.INNER, context).build(serializable, str);
        build.reqMethod(MethodEnum.GET);
        MtopResponse syncRequest = build.syncRequest();
        Log.e("EPublish.Mtop", JSON.toJSONString(serializable));
        PublishMtopResponse publishMtopResponse = new PublishMtopResponse();
        publishMtopResponse.retCode = syncRequest.getRetCode();
        publishMtopResponse.retMsg = syncRequest.getRetMsg();
        if (syncRequest.isApiSuccess()) {
            try {
                publishMtopResponse.success = Boolean.TRUE;
                String str2 = new String(syncRequest.getBytedata());
                if (TextUtils.isEmpty(str2)) {
                    publishMtopResponse.clientRetCode = gn.b;
                    publishMtopResponse.clientRetMsg = gn.c;
                    return publishMtopResponse;
                }
                Log.e("EPublish.Mtop", str2);
                JSONObject parseObject = JSON.parseObject(str2);
                if (parseObject.containsKey("data")) {
                    JSONObject jSONObject = parseObject.getJSONObject("data");
                    if (jSONObject != null && jSONObject.containsKey("hasUpdate")) {
                        publishMtopResponse.hasUpdate = jSONObject.getBoolean("hasUpdate").booleanValue();
                    }
                    if (jSONObject != null && jSONObject.containsKey("updateInfo")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("updateInfo");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.size(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            PublishMtopUpdateInfo publishMtopUpdateInfo = new PublishMtopUpdateInfo();
                            if (jSONObject2.containsKey("productId")) {
                                publishMtopUpdateInfo.productId = jSONObject2.getLongValue("productId");
                            }
                            if (jSONObject2.containsKey("applicationId")) {
                                publishMtopUpdateInfo.applicationId = jSONObject2.getLongValue("applicationId");
                            }
                            if (jSONObject2.containsKey("batchId")) {
                                publishMtopUpdateInfo.batchId = jSONObject2.getLongValue("batchId");
                            }
                            if (jSONObject2.containsKey(b.l)) {
                                publishMtopUpdateInfo.biz = jSONObject2.getString(b.l);
                            }
                            if (jSONObject2.containsKey("payload")) {
                                publishMtopUpdateInfo.payload = jSONObject2.getJSONObject("payload");
                            }
                            arrayList.add(publishMtopUpdateInfo);
                        }
                        publishMtopResponse.updateInfo = arrayList;
                    } else {
                        publishMtopResponse.clientRetCode = gn.d;
                        publishMtopResponse.clientRetMsg = gn.e;
                    }
                    return publishMtopResponse;
                }
            } catch (Exception e) {
                publishMtopResponse.clientRetCode = gn.a;
                publishMtopResponse.clientRetMsg = e.getMessage();
                Log.e("EPublish.Mtop", "get mtop data exception", e);
            }
        } else {
            publishMtopResponse.success = Boolean.FALSE;
            publishMtopResponse.hasUpdate = false;
            Log.e("EPublish.Mtop", "invoke mtop api error, " + syncRequest.getRetMsg());
        }
        return publishMtopResponse;
    }
}
