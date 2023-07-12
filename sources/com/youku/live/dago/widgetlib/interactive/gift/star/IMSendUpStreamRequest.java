package com.youku.live.dago.widgetlib.interactive.gift.star;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class IMSendUpStreamRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private ICallback mCallback;
    private List<String> mSendIMUpStreamSids = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface ICallback {
        void onFailed();

        void onSuccess(int i);
    }

    public boolean isSpecifySid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178164952")) {
            return ((Boolean) ipChange.ipc$dispatch("-178164952", new Object[]{this, str})).booleanValue();
        }
        if (this.mSendIMUpStreamSids.contains(str)) {
            this.mSendIMUpStreamSids.remove(str);
            return true;
        }
        return false;
    }

    public void sendStar(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007691574")) {
            ipChange.ipc$dispatch("1007691574", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("roomId", str);
        hashMap.put(GiftNumBean.KEY_NUM, i + "");
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop("mtop.youku.laifeng.interaction.star.use", "1.0", hashMap, true, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.IMSendUpStreamRequest.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1441866558")) {
                        ipChange2.ipc$dispatch("1441866558", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null || !iNetResponse.isSuccess()) {
                        if (IMSendUpStreamRequest.this.mCallback != null) {
                            IMSendUpStreamRequest.this.mCallback.onFailed();
                        }
                    } else {
                        String source = iNetResponse.getSource();
                        if (TextUtils.isEmpty(source)) {
                            IMSendUpStreamRequest.this.mCallback.onFailed();
                            return;
                        }
                        JSONObject parseObject = JSON.parseObject(source);
                        if (parseObject == null || !parseObject.containsKey("data")) {
                            return;
                        }
                        JSONObject jSONObject = parseObject.getJSONObject("data");
                        if (jSONObject == null) {
                            IMSendUpStreamRequest.this.mCallback.onFailed();
                            return;
                        }
                        int intValue = jSONObject.getIntValue("left");
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "star left = " + intValue);
                        IMSendUpStreamRequest.this.mCallback.onSuccess(intValue);
                    }
                }
            });
        }
    }

    public void setCallback(ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-943593615")) {
            ipChange.ipc$dispatch("-943593615", new Object[]{this, iCallback});
        } else {
            this.mCallback = iCallback;
        }
    }
}
