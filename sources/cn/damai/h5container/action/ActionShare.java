package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.share.ShareManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import tb.nb2;
import tb.rz0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionShare extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    private String imageModeUrl;
    private String mProducturl;

    public ActionShare(Context context) {
        super(context);
        this.mProducturl = "";
        this.imageModeUrl = "";
    }

    private void addCopyLink(LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653457712")) {
            ipChange.ipc$dispatch("653457712", new Object[]{this, linearLayout});
        } else if (TextUtils.isEmpty(this.mProducturl) || !this.mProducturl.startsWith("http")) {
        } else {
            linearLayout.addView(nb2.c(this.contextReference, this.mProducturl));
        }
    }

    private void addReportIcon(LinearLayout linearLayout, int i, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125510596")) {
            ipChange.ipc$dispatch("125510596", new Object[]{this, linearLayout, Integer.valueOf(i), str, Integer.valueOf(i2)});
        } else {
            linearLayout.addView(ShareManager.E().F(this.contextReference, i, str, i2));
        }
    }

    private void mock() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-400422023")) {
            ipChange.ipc$dispatch("-400422023", new Object[]{this});
            return;
        }
        this.jsonObject.put("image", (Object) "http://liangcang-material.alicdn.com/prod/upload/67650c4449844aafa63caf831e851c5f.webp.jpg");
        this.jsonObject.put(SocialConstants.PARAM_COMMENT, (Object) "剧本杀福利来袭！多重优惠买一赠一！~");
        this.jsonObject.put("title", (Object) "title -> 剧本杀买一赠一！~");
        this.jsonObject.put("url", (Object) "https://t.taopiaopiao.com/yep/page/m/jubenshaM1Z10203?prev_page=LCJBSguodu20220614&sqm=dianying.DM.hlw.a2o71-27128526.hlw_a2o71_27128526&spm=a2o71.27128526.777037.custome-link&bizpass_share_code=");
        this.jsonObject.put("biggerPosterUrl", (Object) "https://img.alicdn.com/imgextra/i2/2251059038/O1CN01lKwyVK2GdSDoti1Ij_!!2251059038.jpg");
        this.jsonObject.put("hideCopyLink", (Object) "true");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) rz0.ARG_COPY);
        jSONArray.add(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", (Object) "report");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", (Object) 1);
        jSONObject3.put("targetId", (Object) 1);
        jSONObject3.put("targetType", (Object) 1);
        jSONObject2.put("typeInfo", (Object) jSONObject3);
        jSONArray.add(jSONObject2);
        this.jsonObject.put("plugins", (Object) jSONArray);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "995976279")) {
            return ((Boolean) ipChange.ipc$dispatch("995976279", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        Bundle bundle = new Bundle();
        this.mProducturl = getParam("url");
        this.imageModeUrl = getParam("biggerPosterUrl");
        bundle.putString("title", getParam("title"));
        bundle.putString("message", getParam(SocialConstants.PARAM_COMMENT));
        bundle.putString("imageurl", getParam("image"));
        bundle.putString("producturl", this.mProducturl);
        bundle.putBoolean("hideCopyLink", true);
        bundle.putString("imageModeUrl", this.imageModeUrl);
        bundle.putString("fromWhere", "H5");
        bundle.putString("sinaSharePath", getParam("sinaSharePath"));
        LinearLayout linearLayout = new LinearLayout(this.contextReference);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        if (!wh2.j(getParam("plugins")) && (jSONArray = this.jsonObject.getJSONArray("plugins")) != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null && jSONObject.getString("type") != null) {
                    if ("report".equals(jSONObject.getString("type"))) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("typeInfo");
                        if (jSONObject2 != null) {
                            addReportIcon(linearLayout, jSONObject2.getInteger("type").intValue(), jSONObject2.getString("targetId"), jSONObject2.getInteger("targetType").intValue());
                        }
                    } else if (rz0.ARG_COPY.equals(jSONObject.getString("type"))) {
                        addCopyLink(linearLayout);
                    }
                }
            }
        }
        ShareManager g0 = ShareManager.E().g0(!TextUtils.isEmpty(this.imageModeUrl));
        Context context = this.contextReference;
        g0.T((Activity) context, bundle, ((Activity) context).getWindow().getDecorView());
        if (linearLayout.getChildCount() > 0) {
            ShareManager.E().e0(linearLayout);
        } else {
            ShareManager.E().L();
        }
        ShareManager.E().l0();
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1792834491") ? (String) ipChange.ipc$dispatch("-1792834491", new Object[]{this}) : "share";
    }
}
