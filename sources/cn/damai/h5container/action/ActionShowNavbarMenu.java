package cn.damai.h5container.action;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import cn.damai.h5container.DMH5Activity;
import cn.damai.h5container.H5MainActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionShowNavbarMenu extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionShowNavbarMenu(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467627982")) {
            return ((Boolean) ipChange.ipc$dispatch("467627982", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        if (wh2.j(getParam("share"))) {
            wVCallBackContext.error("ActionShowNavbarMenu param share is empty.");
            Context context = this.contextReference;
            if (context instanceof H5MainActivity) {
                ((H5MainActivity) context).hideShareMenu();
            } else if (context instanceof DMH5Activity) {
                ((DMH5Activity) context).hideShareMenu();
            }
            return true;
        }
        try {
            JSONObject parseObject = JSON.parseObject(getParam("share"));
            if (wh2.j(parseObject.getString("title")) || wh2.j(parseObject.getString("url"))) {
                wVCallBackContext.error("ActionShowNavbarMenu param share is empty.");
                Context context2 = this.contextReference;
                if (context2 instanceof H5MainActivity) {
                    ((H5MainActivity) context2).hideShareMenu();
                } else if (context2 instanceof DMH5Activity) {
                    ((DMH5Activity) context2).hideShareMenu();
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Context context3 = this.contextReference;
        if (context3 instanceof H5MainActivity) {
            ((H5MainActivity) context3).showShareMenu(this.jsonObject);
        } else if (context3 instanceof DMH5Activity) {
            ((DMH5Activity) context3).showShareMenu(this.jsonObject);
        } else {
            wVCallBackContext.error("ActionShowNavbarMenu context error.");
            return true;
        }
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1282829564") ? (String) ipChange.ipc$dispatch("1282829564", new Object[]{this}) : "showNavbarMenu";
    }
}
