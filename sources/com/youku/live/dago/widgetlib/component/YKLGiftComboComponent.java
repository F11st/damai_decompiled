package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftComboSendInfo;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton;
import com.youku.live.dago.widgetlib.protocol.YKLGiftComboProtocol;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;
import java.util.Map;
import tb.tx0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLGiftComboComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoGiftComboComponent";
    private float height;
    private YKLGiftComboProtocol mGiftComboProtocol;
    private GiftComboSendInfo mGiftInfoBean;
    private Map<String, String> spm;
    private float width;

    public YKLGiftComboComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        this.mGiftComboProtocol = null;
        this.mGiftInfoBean = new GiftComboSendInfo();
    }

    private void UTComponentExpose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-904785395")) {
            ipChange.ipc$dispatch("-904785395", new Object[]{this});
        } else if (this.mGiftInfoBean == null) {
        } else {
            Log.d("UT_REPORT", "board COMBO click");
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.spm);
            String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
            hashMap.put("spm", valueOf + ".liwu.lianji");
            hashMap.put("title", this.mGiftInfoBean.name);
            hashMap.put("liwuid", this.mGiftInfoBean.id);
            ((IUserTracker) Dsl.getService(IUserTracker.class)).trackCustom("page_youkulive", 2201, "liwu-lianji", "", "", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UTSendClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940384942")) {
            ipChange.ipc$dispatch("1940384942", new Object[]{this});
        } else if (this.mGiftInfoBean == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.spm);
            String valueOf = String.valueOf(hashMap.get(tx0.VALUE_MODEL_DEFAULT));
            hashMap.put("spm", valueOf + ".liwu.lianji");
            hashMap.put("comboComponent", "1");
            hashMap.put("title", this.mGiftInfoBean.name);
            hashMap.put("liwuid", this.mGiftInfoBean.id);
            hashMap.put("mubiaotitle", this.mGiftInfoBean.anchorName);
            hashMap.put("mubiaoid", this.mGiftInfoBean.anchorId);
            ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click("page_youkulive", "liwu-lianji", hashMap);
        }
    }

    private YKLGiftComboProtocol getAdapter(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-262303763") ? (YKLGiftComboProtocol) ipChange.ipc$dispatch("-262303763", new Object[]{this, context}) : (YKLGiftComboProtocol) YKLAdapterFactory.getInstance().createInterface(YKLGiftComboComponent.class, context);
    }

    private void initAttrs() {
        JSONObject parseObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824396061")) {
            ipChange.ipc$dispatch("1824396061", new Object[]{this});
            return;
        }
        YKLGiftComboProtocol yKLGiftComboProtocol = this.mGiftComboProtocol;
        if (yKLGiftComboProtocol != null) {
            yKLGiftComboProtocol.setCallback(new RoundGiftButton.Listener() { // from class: com.youku.live.dago.widgetlib.component.YKLGiftComboComponent.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton.Listener
                public void onCombSend() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "393885760")) {
                        ipChange2.ipc$dispatch("393885760", new Object[]{this});
                    } else if (YKLGiftComboComponent.this.mGiftInfoBean != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(GiftNumBean.KEY_NUM, YKLGiftComboComponent.this.mGiftInfoBean.num);
                        hashMap.put("giftId", YKLGiftComboComponent.this.mGiftInfoBean.id);
                        hashMap.put("anchorId", YKLGiftComboComponent.this.mGiftInfoBean.anchorId);
                        hashMap.put("anchorIcon", YKLGiftComboComponent.this.mGiftInfoBean.anchorIcon);
                        hashMap.put("anchorName", YKLGiftComboComponent.this.mGiftInfoBean.anchorName);
                        YKLGiftComboComponent.this.UTSendClick();
                        YKLGiftComboComponent.this.onSendGiftCallback(hashMap);
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton.Listener
                public void onCountDownEnd() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1506439167")) {
                        ipChange2.ipc$dispatch("1506439167", new Object[]{this});
                    } else {
                        YKLGiftComboComponent.this.onCountdownEnd();
                    }
                }
            });
            if (getBasicComponentData() == null || getBasicComponentData().getAttrs() == null) {
                return;
            }
            this.spm = JSON.parseObject((String) getBasicComponentData().getAttrs().get("spm"));
            Object obj = getBasicComponentData().getAttrs().get("giftinfo");
            if (obj != null && (parseObject = JSON.parseObject(String.valueOf(obj))) != null) {
                this.mGiftInfoBean.id = parseObject.getString("id");
                this.mGiftInfoBean.name = parseObject.getString("name");
                this.mGiftInfoBean.icon = parseObject.getString(RemoteMessageConst.Notification.ICON);
                this.mGiftInfoBean.coins = parseObject.getString("coins");
                this.mGiftInfoBean.num = parseObject.getString(GiftNumBean.KEY_NUM);
                this.mGiftInfoBean.numName = parseObject.getString("numName");
                this.mGiftInfoBean.anchorId = parseObject.getString("anchorId");
                this.mGiftInfoBean.anchorName = parseObject.getString("anchorName");
                this.mGiftInfoBean.anchorIcon = parseObject.getString("anchorIcon");
            }
            int parse2Int = ParseUtils.parse2Int((String) getBasicComponentData().getAttrs().get("continuetime"));
            int parse2Int2 = ParseUtils.parse2Int((String) getBasicComponentData().getAttrs().get("countdownTime"));
            this.mGiftComboProtocol.setGiftInfo(this.mGiftInfoBean);
            this.mGiftComboProtocol.setComboInterval(parse2Int);
            this.mGiftComboProtocol.setCountdownTime(parse2Int2);
            UTComponentExpose();
            this.mGiftComboProtocol.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCountdownEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825109074")) {
            ipChange.ipc$dispatch("1825109074", new Object[]{this});
        } else {
            fireEvent("closecallback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendGiftCallback(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4426246")) {
            ipChange.ipc$dispatch("4426246", new Object[]{this, map});
        } else {
            fireEvent("sendgiftcallback", map);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037559733")) {
            return (View) ipChange.ipc$dispatch("1037559733", new Object[]{this, context});
        }
        this.mGiftComboProtocol = getAdapter(context);
        initAttrs();
        return this.mGiftComboProtocol.getView();
    }

    @WXComponentProp(name = "countdownTime")
    public void setCountdownTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1036279561")) {
            ipChange.ipc$dispatch("1036279561", new Object[]{this, str});
        } else if (this.mGiftComboProtocol == null || TextUtils.isEmpty(str)) {
        } else {
            this.mGiftComboProtocol.setCountdownTime(ParseUtils.parse2Int(str));
        }
    }

    @WXComponentProp(name = "continuetime")
    public void setCountdownTotoalTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677109224")) {
            ipChange.ipc$dispatch("1677109224", new Object[]{this, str});
        } else if (this.mGiftComboProtocol == null || TextUtils.isEmpty(str)) {
        } else {
            this.mGiftComboProtocol.setCountdownTime(ParseUtils.parse2Int(str));
        }
    }

    @WXComponentProp(name = "giftinfo")
    public void setGiftInfo(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267085526")) {
            ipChange.ipc$dispatch("1267085526", new Object[]{this, map});
        } else if (map != null) {
            GiftComboSendInfo giftComboSendInfo = new GiftComboSendInfo();
            this.mGiftInfoBean = giftComboSendInfo;
            giftComboSendInfo.id = map.get("id") == null ? "" : String.valueOf(map.get("id"));
            this.mGiftInfoBean.name = map.get("name") == null ? "" : String.valueOf(map.get("name"));
            this.mGiftInfoBean.icon = map.get(RemoteMessageConst.Notification.ICON) == null ? "" : String.valueOf(map.get(RemoteMessageConst.Notification.ICON));
            this.mGiftInfoBean.coins = map.get("coins") == null ? "" : String.valueOf(map.get("coins"));
            this.mGiftInfoBean.num = map.get(GiftNumBean.KEY_NUM) == null ? "" : String.valueOf(map.get(GiftNumBean.KEY_NUM));
            this.mGiftInfoBean.numName = map.get("numName") == null ? "" : String.valueOf(map.get("numName"));
            this.mGiftInfoBean.anchorId = map.get("anchorId") == null ? "" : String.valueOf(map.get("anchorId"));
            this.mGiftInfoBean.anchorName = map.get("anchorName") == null ? "" : String.valueOf(map.get("anchorName"));
            this.mGiftInfoBean.anchorIcon = map.get("anchorIcon") != null ? String.valueOf(map.get("anchorIcon")) : "";
            this.mGiftComboProtocol.setGiftInfo(this.mGiftInfoBean);
        }
    }

    @WXComponentProp(name = "spm")
    public void setSpm(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102169400")) {
            ipChange.ipc$dispatch("1102169400", new Object[]{this, map});
        } else {
            this.spm = map;
        }
    }

    private YKLGiftComboProtocol getAdapter(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "351949111") ? (YKLGiftComboProtocol) ipChange.ipc$dispatch("351949111", new Object[]{this, context, str}) : (YKLGiftComboProtocol) YKLAdapterFactory.getInstance().createInterface(YKLGiftComboComponent.class, context, str, false);
    }

    public YKLGiftComboComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mGiftComboProtocol = null;
        this.mGiftInfoBean = new GiftComboSendInfo();
    }

    public YKLGiftComboComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mGiftComboProtocol = null;
        this.mGiftInfoBean = new GiftComboSendInfo();
    }

    public YKLGiftComboComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        this.mGiftComboProtocol = null;
        this.mGiftInfoBean = new GiftComboSendInfo();
    }
}
