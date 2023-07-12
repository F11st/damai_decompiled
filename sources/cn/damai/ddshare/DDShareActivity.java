package cn.damai.ddshare;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.android.dingtalk.share.ddsharemodule.DDShareApiFactory;
import com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler;
import com.android.dingtalk.share.ddsharemodule.IDDShareApi;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.BaseResp;
import tb.mm2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DDShareActivity extends Activity implements IDDAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private IDDShareApi a;

    public static void hideKeyboard(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519754307")) {
            ipChange.ipc$dispatch("519754307", new Object[]{view});
        } else if (view == null) {
        } else {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            inputMethodManager.showSoftInput(view, 2);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971083337")) {
            ipChange.ipc$dispatch("-1971083337", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        try {
            IDDShareApi createDDShareApi = DDShareApiFactory.createDDShareApi(this, mm2.b, false);
            this.a = createDDShareApi;
            createDDShareApi.handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1066854600")) {
            ipChange.ipc$dispatch("1066854600", new Object[]{this, baseReq});
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1300864124")) {
            ipChange.ipc$dispatch("-1300864124", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.mErrCode;
        hideKeyboard(getCurrentFocus());
        if (i == 0) {
            ToastUtil.a().e(this, "分享成功");
        }
        finish();
    }
}
