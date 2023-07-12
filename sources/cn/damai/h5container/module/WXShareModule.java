package cn.damai.h5container.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.share.ShareManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.JSCallback;
import com.tencent.open.SocialConstants;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXShareModule extends WXBridgeModel {
    private static transient /* synthetic */ IpChange $ipChange;

    private void addReportIcon(LinearLayout linearLayout, int i, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133066779")) {
            ipChange.ipc$dispatch("2133066779", new Object[]{this, linearLayout, Integer.valueOf(i), str, Integer.valueOf(i2)});
        } else {
            linearLayout.addView(ShareManager.E().F(this.contextReference, i, str, i2));
        }
    }

    public void share(String str, JSCallback jSCallback) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721766355")) {
            ipChange.ipc$dispatch("-721766355", new Object[]{this, str, jSCallback});
            return;
        }
        try {
            this.jsonObject = JSON.parseObject(str);
            Log.d("WXBridgeModel", "params :" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", getParam("title"));
        bundle.putString("message", getParam(SocialConstants.PARAM_COMMENT));
        bundle.putString("imageurl", getParam("image"));
        bundle.putString("producturl", getParam("url"));
        bundle.putString("fromWhere", "H5");
        bundle.putString("sinaSharePath", getParam("sinaSharePath"));
        LinearLayout linearLayout = new LinearLayout(this.contextReference);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        if (!wh2.j(getParam("plugins")) && (jSONArray = this.jsonObject.getJSONArray("plugins")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null && jSONObject2.getString("type") != null && "report".equals(jSONObject2.getString("type")) && (jSONObject = jSONObject2.getJSONObject("typeInfo")) != null) {
                    addReportIcon(linearLayout, jSONObject.getInteger("type").intValue(), jSONObject.getString("targetId"), jSONObject.getInteger("targetType").intValue());
                }
            }
        }
        ShareManager E = ShareManager.E();
        Context context = this.contextReference;
        E.T((Activity) context, bundle, ((Activity) context).findViewById(R$id.refreshLayout));
        ShareManager.E().e0(linearLayout);
        ShareManager.E().l0();
    }
}
