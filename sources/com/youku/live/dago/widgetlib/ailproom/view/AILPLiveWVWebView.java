package com.youku.live.dago.widgetlib.ailproom.view;

import android.content.Context;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.taobao.windvane.webview.WVWebView;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPLiveWVWebView extends WVWebView implements AILPMClientProtocol.MsgReceiver {
    private static transient /* synthetic */ IpChange $ipChange;
    private AILPLivePenetrateFrameLayout mLivePenetrateFrameLayout;
    public AILPMClientProtocol.YKLMClientGetterProtocol mYKLMClientGetterProtocol;

    public AILPLiveWVWebView(Context context, AILPLivePenetrateFrameLayout aILPLivePenetrateFrameLayout) {
        super(context);
        this.mLivePenetrateFrameLayout = aILPLivePenetrateFrameLayout;
    }

    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658504059")) {
            ipChange.ipc$dispatch("1658504059", new Object[]{this});
            return;
        }
        AILPLivePenetrateFrameLayout aILPLivePenetrateFrameLayout = this.mLivePenetrateFrameLayout;
        if (aILPLivePenetrateFrameLayout != null) {
            ViewParent parent = aILPLivePenetrateFrameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mLivePenetrateFrameLayout);
                this.mLivePenetrateFrameLayout.destroy();
                this.mLivePenetrateFrameLayout = null;
                removeAllViews();
                destroy();
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPMClientProtocol.MsgReceiver
    public void onReceive(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950376621")) {
            ipChange.ipc$dispatch("-1950376621", new Object[]{this, map});
            return;
        }
        String str = (String) map.get("data");
        try {
            int optInt = new JSONObject(str).optInt("code");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", str);
            WVStandardEventCenter.postNotificationToJS(this, "msg.sub" + optInt, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void register(String str) {
        AILPMClientProtocol protocol;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "986396251")) {
            ipChange.ipc$dispatch("986396251", new Object[]{this, str});
            return;
        }
        AILPMClientProtocol.YKLMClientGetterProtocol yKLMClientGetterProtocol = this.mYKLMClientGetterProtocol;
        if (yKLMClientGetterProtocol == null || (protocol = yKLMClientGetterProtocol.getProtocol()) == null) {
            return;
        }
        protocol.register("34567", null, this);
    }

    public void setPenetrateAlpha(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "801475048")) {
            ipChange.ipc$dispatch("801475048", new Object[]{this, str});
            return;
        }
        try {
            this.mLivePenetrateFrameLayout.setPenetrateAlpha((int) (Float.parseFloat(str) * 255.0f));
        } catch (Exception unused) {
        }
    }

    public void unregister(String str) {
        AILPMClientProtocol protocol;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23777630")) {
            ipChange.ipc$dispatch("-23777630", new Object[]{this, str});
            return;
        }
        AILPMClientProtocol.YKLMClientGetterProtocol yKLMClientGetterProtocol = this.mYKLMClientGetterProtocol;
        if (yKLMClientGetterProtocol == null || (protocol = yKLMClientGetterProtocol.getProtocol()) == null) {
            return;
        }
        protocol.unregister("34567");
    }
}
