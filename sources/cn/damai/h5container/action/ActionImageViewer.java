package cn.damai.h5container.action;

import android.content.Context;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import tb.qa;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionImageViewer extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionImageViewer(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-546182907")) {
            return ((Boolean) ipChange.ipc$dispatch("-546182907", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        JSONArray jSONArray = this.jsonObject.getJSONArray("images");
        if (jSONArray != null && jSONArray.size() != 0) {
            String[] strArr = (String[]) jSONArray.toArray(new String[jSONArray.size()]);
            String param = getParam(UCCore.LEGACY_EVENT_INIT);
            if (param != null) {
                try {
                    i = Integer.parseInt(param);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("images", strArr);
            bundle.putInt("location", i);
            bundle.putInt("type", 2);
            DMNav.from(this.contextReference).withExtras(bundle).toUri(NavUri.b(qa.XFLUSH_NAME).e("gallery"));
            wVCallBackContext.success();
            return true;
        }
        wVCallBackContext.error("images error.");
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1291654003") ? (String) ipChange.ipc$dispatch("1291654003", new Object[]{this}) : "imageViewer";
    }
}
