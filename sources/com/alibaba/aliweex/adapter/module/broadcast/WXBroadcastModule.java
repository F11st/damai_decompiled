package com.alibaba.aliweex.adapter.module.broadcast;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weaver.broadcast.MessageCallback;
import com.taobao.weaver.broadcast.MessageChannel;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXBroadcastModule extends WXModule {
    private static final String CHANNEL_INSTANCE_ID = "instanceId";
    private static final String CHANNEL_KEY = "name";
    private static final String CHANNEL_MESSAGE = "message";
    private static final String MESSAGE = "message";
    private static final String RESULT = "result";
    private Map<String, MessageChannel> messageTokenChannels = new HashMap();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.module.broadcast.WXBroadcastModule$a */
    /* loaded from: classes15.dex */
    class C3057a implements MessageCallback {
        final /* synthetic */ JSCallback a;

        C3057a(WXBroadcastModule wXBroadcastModule, JSCallback jSCallback) {
            this.a = jSCallback;
        }
    }

    @JSMethod(uiThread = false)
    public void closeChannel(JSONObject jSONObject) {
        if (jSONObject == null || this.messageTokenChannels == null || !jSONObject.containsKey(CHANNEL_INSTANCE_ID)) {
            return;
        }
        MessageChannel remove = this.messageTokenChannels.remove(jSONObject.getString(CHANNEL_INSTANCE_ID));
        if (remove != null) {
            remove.close();
        }
    }

    @JSMethod(uiThread = false)
    public void createChannel(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null || jSONObject == null || TextUtils.isEmpty(jSONObject.getString("name")) || TextUtils.isEmpty(jSONObject.getString(CHANNEL_INSTANCE_ID))) {
            if (jSCallback2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", (Object) "-1");
                jSONObject2.put("message", (Object) "channel args error");
                jSCallback2.invoke(jSONObject2);
                return;
            }
            return;
        }
        synchronized (this) {
            if (this.messageTokenChannels == null) {
                this.messageTokenChannels = new HashMap();
            }
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString(CHANNEL_INSTANCE_ID);
            if (this.messageTokenChannels.get(string2) != null) {
                if (jSCallback2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result", (Object) "-1");
                    jSONObject3.put("message", (Object) "channel error token has been used");
                    jSCallback2.invoke(jSONObject3);
                }
                return;
            }
            this.messageTokenChannels.put(string2, new MessageChannel(this.mWXSDKInstance.getContext(), string, (MessageCallback) null));
            if (jSCallback != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", (Object) "0");
                jSONObject4.put("message", (Object) "channel create success");
                jSCallback.invoke(jSONObject4);
            }
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityDestroy() {
        Map<String, MessageChannel> map = this.messageTokenChannels;
        if (map != null) {
            for (Map.Entry<String, MessageChannel> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().close();
                }
            }
            this.messageTokenChannels.clear();
        }
        super.onActivityDestroy();
    }

    @JSMethod(uiThread = false)
    public void onMessage(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        if (this.messageTokenChannels == null) {
            return;
        }
        String string = jSONObject.getString(CHANNEL_INSTANCE_ID);
        if (TextUtils.isEmpty(string)) {
            if (jSCallback2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", (Object) "-1");
                jSONObject2.put("message", (Object) "channel token empty error");
                jSCallback2.invoke(jSONObject2);
                return;
            }
            return;
        }
        MessageChannel messageChannel = this.messageTokenChannels.get(string);
        if (messageChannel != null) {
            messageChannel.setCallback(new C3057a(this, jSCallback));
        } else if (jSCallback2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", (Object) "-1");
            jSONObject3.put("message", (Object) "channel token not exist");
            jSCallback2.invoke(jSONObject3);
        }
    }

    @JSMethod(uiThread = false)
    public void postMessage(JSONObject jSONObject, JSCallback jSCallback, JSCallback jSCallback2) {
        if (this.messageTokenChannels == null) {
            return;
        }
        if (TextUtils.isEmpty(jSONObject.getString(CHANNEL_INSTANCE_ID)) || !jSONObject.containsKey("message")) {
            if (jSCallback2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", (Object) "-1");
                jSONObject2.put("message", (Object) "post message args error");
                jSCallback2.invoke(jSONObject2);
                return;
            }
            return;
        }
        String string = jSONObject.getString(CHANNEL_INSTANCE_ID);
        Object obj = jSONObject.get("message");
        MessageChannel messageChannel = this.messageTokenChannels.get(string);
        if (messageChannel == null) {
            if (jSCallback2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("result", (Object) "-1");
                jSONObject3.put("message", (Object) "channel token not exist");
                jSCallback2.invoke(jSONObject3);
                return;
            }
            return;
        }
        messageChannel.postMessage(obj);
        if (jSCallback != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("result", (Object) "0");
            jSONObject4.put("message", (Object) "post message success");
            jSCallback.invoke(jSONObject4);
        }
    }
}
