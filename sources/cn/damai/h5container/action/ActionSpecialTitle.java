package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import cn.damai.h5container.DMH5Activity;
import cn.damai.h5container.H5MainActivity;
import cn.damai.h5container.WebViewUtil;
import cn.damai.weex.WeexActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionSpecialTitle extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionSpecialTitle(Context context) {
        super(context);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618080383")) {
            return ((Boolean) ipChange.ipc$dispatch("-618080383", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String param = getParam("title");
        if (TextUtils.isEmpty(param)) {
            wVCallBackContext.error("empty title");
            return false;
        }
        String subStr = WebViewUtil.subStr(param, 15);
        Context context = this.contextReference;
        if (context instanceof H5MainActivity) {
            ((H5MainActivity) context).setTitleContent(subStr);
        } else if (context instanceof DMH5Activity) {
            ((DMH5Activity) context).setTitleContent(subStr);
        } else if (context instanceof WeexActivity) {
            ((WeexActivity) context).setTitleContent(subStr);
        } else if (context instanceof Activity) {
            ((Activity) context).setTitle(subStr);
        }
        wVCallBackContext.success();
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1171353327") ? (String) ipChange.ipc$dispatch("1171353327", new Object[]{this}) : "setSpecialTitle";
    }
}
