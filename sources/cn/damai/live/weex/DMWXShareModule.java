package cn.damai.live.weex;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.fission.bean.FissionParam;
import cn.damai.commonbusiness.fission.util.FissionUtil;
import cn.damai.commonbusiness.share.ShareManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import tb.m61;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMWXShareModule extends WXModule implements Destroyable {
    private static transient /* synthetic */ IpChange $ipChange;

    private void addReportIcon(Context context, LinearLayout linearLayout, int i, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098364545")) {
            ipChange.ipc$dispatch("1098364545", new Object[]{this, context, linearLayout, Integer.valueOf(i), str, Integer.valueOf(i2)});
        } else {
            linearLayout.addView(ShareManager.E().F(context, i, str, i2));
        }
    }

    private FissionParam getFissionParam(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123059407")) {
            return (FissionParam) ipChange.ipc$dispatch("-123059407", new Object[]{this, jSONObject});
        }
        try {
            return (FissionParam) m61.a(jSONObject.toJSONString(), FissionParam.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getParam(JSONObject jSONObject, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1821554721") ? (String) ipChange.ipc$dispatch("-1821554721", new Object[]{this, jSONObject, str}) : (jSONObject == null || jSONObject.get(str) == null) ? "" : jSONObject.get(str).toString();
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632164832")) {
            ipChange.ipc$dispatch("632164832", new Object[]{this});
        }
    }

    @JSMethod
    public boolean fissionShare(JSONObject jSONObject, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975540174")) {
            return ((Boolean) ipChange.ipc$dispatch("-975540174", new Object[]{this, jSONObject, jSCallback})).booleanValue();
        }
        FissionParam fissionParam = getFissionParam(jSONObject);
        if (fissionParam != null) {
            new FissionUtil().h(this.mWXSDKInstance.getUIContext(), fissionParam);
        }
        return true;
    }

    @JSMethod
    public void share(JSONObject jSONObject, JSCallback jSCallback) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309244723")) {
            ipChange.ipc$dispatch("309244723", new Object[]{this, jSONObject, jSCallback});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", getParam(jSONObject, "titleText"));
        bundle.putString("message", getParam(jSONObject, "descText"));
        bundle.putString("imageurl", getParam(jSONObject, "thumbnailUrl"));
        bundle.putString("producturl", getParam(jSONObject, "url"));
        bundle.putString("fromWhere", "");
        bundle.putString("sinaSharePath", getParam(jSONObject, "sinaSharePath"));
        Context context = this.mWXSDKInstance.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        if (!wh2.j(getParam(jSONObject, "plugins")) && (jSONArray = jSONObject.getJSONArray("plugins")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (jSONObject3 != null && jSONObject3.getString("type") != null && "report".equals(jSONObject3.getString("type")) && (jSONObject2 = jSONObject3.getJSONObject("typeInfo")) != null) {
                    addReportIcon(context, linearLayout, jSONObject2.getInteger("type").intValue(), jSONObject2.getString("targetId"), jSONObject2.getInteger("targetType").intValue());
                }
            }
        }
        ShareManager.E().T((Activity) context, bundle, this.mWXSDKInstance.getRootView());
        ShareManager.E().e0(linearLayout);
        ShareManager.E().l0();
    }
}
