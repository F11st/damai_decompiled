package cn.damai.commonbusiness.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.util.Utils;
import com.alipay.share.sdk.openapi.APAPIFactory;
import com.alipay.share.sdk.openapi.APMediaMessage;
import com.alipay.share.sdk.openapi.APWebPageObject;
import com.alipay.share.sdk.openapi.BaseReq;
import com.alipay.share.sdk.openapi.BaseResp;
import com.alipay.share.sdk.openapi.IAPAPIEventHandler;
import com.alipay.share.sdk.openapi.IAPApi;
import com.alipay.share.sdk.openapi.SendMessageToZFB;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cm2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AlipayEntryActivity extends DamaiBaseActivity implements IAPAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private IAPApi api;
    private Bundle bundle;
    Handler handler = new a();
    private String imageurl;
    private String message;
    private String producturl;
    private String title;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "849475158")) {
                ipChange.ipc$dispatch("849475158", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            AlipayEntryActivity.this.shareMessage();
        }
    }

    private void initExtras(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1839305125")) {
            ipChange.ipc$dispatch("1839305125", new Object[]{this, intent});
            return;
        }
        Bundle extras = intent.getExtras();
        this.bundle = extras;
        if (extras == null) {
            return;
        }
        this.title = extras.getString("title", "大麦");
        this.message = this.bundle.getString("message", "买票上大麦");
        this.imageurl = this.bundle.getString("imageurl");
        this.producturl = this.bundle.getString("producturl", "https://m.damai.cn");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1510624259")) {
            ipChange.ipc$dispatch("1510624259", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504008697")) {
            return ((Integer) ipChange.ipc$dispatch("-504008697", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306399148")) {
            ipChange.ipc$dispatch("-306399148", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "462422103")) {
            ipChange.ipc$dispatch("462422103", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385805286")) {
            ipChange.ipc$dispatch("385805286", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514250676")) {
            ipChange.ipc$dispatch("-514250676", new Object[]{this, view});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134110572")) {
            ipChange.ipc$dispatch("-2134110572", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.api = APAPIFactory.createZFBApi(getApplicationContext(), "2015092200310865", false);
        if (getIntent() != null) {
            this.api.handleIntent(getIntent(), this);
        }
        initExtras(getIntent());
        this.handler.sendEmptyMessage(0);
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "936151427")) {
            ipChange.ipc$dispatch("936151427", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581627342")) {
            ipChange.ipc$dispatch("-1581627342", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690508625")) {
            ipChange.ipc$dispatch("-690508625", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    @Override // com.alipay.share.sdk.openapi.IAPAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-296740691")) {
            ipChange.ipc$dispatch("-296740691", new Object[]{this, baseReq});
        }
    }

    @Override // com.alipay.share.sdk.openapi.IAPAPIEventHandler
    public void onResp(BaseResp baseResp) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1193991143")) {
            ipChange.ipc$dispatch("-1193991143", new Object[]{this, baseResp});
            return;
        }
        int i2 = baseResp.errCode;
        if (i2 == -4) {
            i = R$string.errcode_deny;
        } else if (i2 == -3) {
            i = R$string.errcode_send_fail;
        } else if (i2 == -2) {
            i = R$string.errcode_cancel;
        } else if (i2 != 0) {
            i = R$string.errcode_unknown;
        } else {
            i = R$string.errcode_success;
        }
        Toast.makeText(this, i, 1).show();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1969438267")) {
            return (String) ipChange.ipc$dispatch("1969438267", new Object[]{this});
        }
        return null;
    }

    public void share() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348653936")) {
            ipChange.ipc$dispatch("-1348653936", new Object[]{this});
            return;
        }
        try {
            IAPApi createZFBApi = APAPIFactory.createZFBApi(getApplicationContext(), "2015092200310865", false);
            APWebPageObject aPWebPageObject = new APWebPageObject();
            aPWebPageObject.webpageUrl = this.producturl;
            APMediaMessage aPMediaMessage = new APMediaMessage();
            aPMediaMessage.mediaObject = aPWebPageObject;
            aPMediaMessage.title = this.title;
            aPMediaMessage.description = this.message;
            aPMediaMessage.thumbUrl = this.imageurl;
            SendMessageToZFB.Req req = new SendMessageToZFB.Req();
            req.message = aPMediaMessage;
            req.transaction = "WebShare" + String.valueOf(System.currentTimeMillis());
            createZFBApi.sendReq(req);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            Toast.makeText(this, cm2.b(this, R$string.data_string_009), 0).show();
        }
    }

    public void shareMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511567539")) {
            ipChange.ipc$dispatch("1511567539", new Object[]{this});
            return;
        }
        try {
            if (Utils.a(this, true)) {
                share();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
