package cn.damai.ultron.net;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.ultron.net.api.UltronAdjustOrder;
import cn.damai.ultron.net.api.UltronBuildOrder;
import cn.damai.ultron.net.api.UltronCreateOrder;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DMQueryKey {
    private static transient /* synthetic */ IpChange $ipChange;
    private String addressId;
    private String domain;
    private boolean hasSourceIntKey;
    private String latitude;
    private String lifeBizType;
    private String longitude;
    private String mAdjustApiName;
    private String mBuildApiName;
    private String mSubmitApiName;
    private String poiId;
    private int sourceInt;
    private String storeId;

    public DMQueryKey() {
        this.hasSourceIntKey = false;
        setDomain();
    }

    public static Map<String, String> getRequestParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027610947")) {
            return (Map) ipChange.ipc$dispatch("-2027610947", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coupon", "true");
        hashMap.put("coVersion", "2.0");
        return hashMap;
    }

    private void setDomain() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232533885")) {
            ipChange.ipc$dispatch("232533885", new Object[]{this});
        } else if (AppConfig.g() == AppConfig.EnvMode.test) {
            this.domain = "daliy-mtop.damai.cn";
            this.mBuildApiName = "mtop.trade.order.build";
            this.mAdjustApiName = "mtop.trade.order.adjust";
            this.mSubmitApiName = "mtop.trade.order.create";
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            this.domain = "pre-mtop.damai.cn";
            this.mBuildApiName = UltronBuildOrder.API_NAME_PRE;
            this.mAdjustApiName = UltronAdjustOrder.API_NAME_PRE;
            this.mSubmitApiName = UltronCreateOrder.API_NAME_PRE;
        } else if (AppConfig.g() == AppConfig.EnvMode.online) {
            this.domain = "mtop.damai.cn";
            this.mBuildApiName = "mtop.trade.order.build";
            this.mAdjustApiName = "mtop.trade.order.adjust";
            this.mSubmitApiName = "mtop.trade.order.create";
        }
    }

    public String getAddressId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "884461394") ? (String) ipChange.ipc$dispatch("884461394", new Object[]{this}) : this.addressId;
    }

    public String getAdjustApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1911537369") ? (String) ipChange.ipc$dispatch("1911537369", new Object[]{this}) : !TextUtils.isEmpty(this.mAdjustApiName) ? this.mAdjustApiName : "mtop.trade.order.adjust";
    }

    public String getAdjustVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-215693204") ? (String) ipChange.ipc$dispatch("-215693204", new Object[]{this}) : UltronAdjustOrder.VERSION;
    }

    public String getBuildApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1996647446") ? (String) ipChange.ipc$dispatch("-1996647446", new Object[]{this}) : !TextUtils.isEmpty(this.mBuildApiName) ? this.mBuildApiName : "mtop.trade.order.build";
    }

    public String getBuildVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "171089277") ? (String) ipChange.ipc$dispatch("171089277", new Object[]{this}) : "4.0";
    }

    public String getCreateApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2001328460") ? (String) ipChange.ipc$dispatch("2001328460", new Object[]{this}) : !TextUtils.isEmpty(this.mSubmitApiName) ? this.mSubmitApiName : "mtop.trade.order.create";
    }

    public String getCreateVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-125902113") ? (String) ipChange.ipc$dispatch("-125902113", new Object[]{this}) : "4.0";
    }

    public String getDomain() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "48126135") ? (String) ipChange.ipc$dispatch("48126135", new Object[]{this}) : this.domain;
    }

    public String getLatitude() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1857512031") ? (String) ipChange.ipc$dispatch("1857512031", new Object[]{this}) : this.latitude;
    }

    public String getLifeBizType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "278769780") ? (String) ipChange.ipc$dispatch("278769780", new Object[]{this}) : this.lifeBizType;
    }

    public String getLongitude() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1523556562") ? (String) ipChange.ipc$dispatch("1523556562", new Object[]{this}) : this.longitude;
    }

    public String getPoiId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2114843352") ? (String) ipChange.ipc$dispatch("-2114843352", new Object[]{this}) : this.poiId;
    }

    public int getSourceInt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1828962500") ? ((Integer) ipChange.ipc$dispatch("-1828962500", new Object[]{this})).intValue() : this.sourceInt;
    }

    public String getStoreId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1103618687") ? (String) ipChange.ipc$dispatch("1103618687", new Object[]{this}) : this.storeId;
    }

    public boolean isHasSourceIntKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "757385228") ? ((Boolean) ipChange.ipc$dispatch("757385228", new Object[]{this})).booleanValue() : this.hasSourceIntKey;
    }

    public void setAddressId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316705436")) {
            ipChange.ipc$dispatch("-316705436", new Object[]{this, str});
        } else {
            this.addressId = str;
        }
    }

    public DMQueryKey(Map<String, String> map) {
        this.hasSourceIntKey = false;
        try {
            setDomain();
            String str = map.get(Request.K_EXPARAMS);
            JSONObject parseObject = str != null ? JSON.parseObject(str) : new JSONObject();
            parseObject.putAll(getRequestParams());
            map.put(Request.K_EXPARAMS, parseObject.toJSONString());
            if (parseObject.containsKey("source_int")) {
                this.hasSourceIntKey = true;
                this.sourceInt = parseObject.getIntValue("source_int");
            }
            if (parseObject.containsKey("wdk_addressId")) {
                this.addressId = parseObject.getString("wdk_addressId");
            }
            if (parseObject.containsKey("wdksgll")) {
                String string = parseObject.getString("wdksgll");
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(",");
                    this.longitude = split[0];
                    this.latitude = split[1];
                }
            }
            if (parseObject.containsKey("poiId")) {
                this.poiId = parseObject.getString("poiId");
            }
            if (parseObject.containsKey("life_order_location")) {
                JSONObject jSONObject = parseObject.getJSONObject("life_order_location");
                this.longitude = jSONObject.getString("longitude");
                this.latitude = jSONObject.getString("latitude");
                this.addressId = jSONObject.getString("addressId");
                this.poiId = jSONObject.getString("poiId");
            }
            this.storeId = map.get("storeId");
            if (parseObject.containsKey("life_biz_type")) {
                this.lifeBizType = parseObject.getString("life_biz_type");
            }
        } catch (Throwable unused) {
        }
    }
}
