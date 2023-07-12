package cn.damai.commonbusiness.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$array;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cm2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ShareActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity context;
    private View dingdingBtn;
    String fromWhere;
    private View mShare2QQBtn;
    private View mShare2SinaBtn;
    private View mShare2WechatBtn;
    private View mShare2WechatCircleBtn;
    private View mShareCancelArea;
    private View mShareCancelBtn;
    String message;
    String producturl;
    String result;
    ShareUtil shareUtil;
    private String[] share_title;
    String starwxshareurl;
    String title;
    String imageurl = null;
    String sinaSharePath = "";

    private void initExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141448")) {
            ipChange.ipc$dispatch("-1141448", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            toast(cm2.b(this, R$string.damai_sharesina_parameter_error_toast));
            finish();
            return;
        }
        this.title = extras.getString("title");
        this.message = extras.getString("message");
        this.imageurl = extras.getString("imageurl");
        this.producturl = extras.getString("producturl");
        this.fromWhere = extras.getString("fromWhere");
        if (extras.containsKey("sinaSharePath")) {
            this.sinaSharePath = extras.getString("sinaSharePath");
        }
        if (extras.containsKey("starwxshareurl")) {
            this.starwxshareurl = extras.getString("starwxshareurl");
        }
        if (this.message.contains(this.producturl)) {
            String str = this.message;
            this.message = str.substring(0, str.indexOf(this.producturl));
        }
        wxInit();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1703252582")) {
            ipChange.ipc$dispatch("-1703252582", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1356960752")) {
            return ((Integer) ipChange.ipc$dispatch("-1356960752", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978109077")) {
            ipChange.ipc$dispatch("-978109077", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114250784")) {
            ipChange.ipc$dispatch("1114250784", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-734423939")) {
            ipChange.ipc$dispatch("-734423939", new Object[]{this});
            return;
        }
        this.mShare2WechatBtn = findViewById(R$id.share_wechat_btn);
        this.mShare2WechatCircleBtn = findViewById(R$id.share_wechat_circle_btn);
        this.dingdingBtn = findViewById(R$id.share_dingding_circle_btn);
        this.mShare2SinaBtn = findViewById(R$id.share_sina_btn);
        this.mShare2QQBtn = findViewById(R$id.share_qq_btn);
        this.mShareCancelBtn = findViewById(R$id.share_cancel_btn);
        this.mShareCancelArea = findViewById(R$id.share_cancel_area);
        this.mShare2WechatBtn.setOnClickListener(this);
        this.mShare2WechatCircleBtn.setOnClickListener(this);
        this.dingdingBtn.setOnClickListener(this);
        this.mShare2SinaBtn.setOnClickListener(this);
        this.mShare2QQBtn.setOnClickListener(this);
        this.mShareCancelBtn.setOnClickListener(this);
        this.mShareCancelArea.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559362780")) {
            ipChange.ipc$dispatch("-559362780", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        ShareManager.E().r0(i, i2, intent);
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548125917")) {
            ipChange.ipc$dispatch("-1548125917", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.share_sina_btn) {
            this.shareUtil.shareByWay(this.share_title[0]);
        } else if (id == R$id.share_wechat_btn) {
            this.shareUtil.shareByWay(this.share_title[1]);
        } else if (id == R$id.share_qq_btn) {
            this.shareUtil.shareByWay(this.share_title[5]);
        } else if (id == R$id.share_wechat_circle_btn) {
            if (Utils.b(this, false)) {
                if (this.shareUtil.checkSharetype()) {
                    this.shareUtil.shareByWay(this.share_title[4]);
                } else {
                    toast(cm2.b(this, R$string.damai_share_circle_load_toast));
                }
                finish();
            }
        } else if (id == R$id.share_dingding_circle_btn) {
            this.shareUtil.shareByWay(this.share_title[2]);
        } else if (id == R$id.share_cancel_area || id == R$id.share_cancel_btn) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175495325")) {
            ipChange.ipc$dispatch("175495325", new Object[]{this, bundle});
            return;
        }
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R$layout.share_activity);
        this.share_title = cm2.a(this, R$array.share_title);
        this.context = this;
        initExtra();
        initView();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264441498")) {
            ipChange.ipc$dispatch("264441498", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860387899")) {
            ipChange.ipc$dispatch("1860387899", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104803460")) {
            return (String) ipChange.ipc$dispatch("1104803460", new Object[]{this});
        }
        return null;
    }

    public void toast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685539429")) {
            ipChange.ipc$dispatch("-685539429", new Object[]{this, str});
        } else {
            ToastUtil.a().j(this, str);
        }
    }

    public void wxInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927515265")) {
            ipChange.ipc$dispatch("927515265", new Object[]{this});
            return;
        }
        this.shareUtil = new ShareUtil(this.context, this.fromWhere);
        if (!TextUtils.isEmpty(this.starwxshareurl)) {
            this.shareUtil.initShareData(this.title, this.message, this.imageurl, this.producturl, this.sinaSharePath, this.starwxshareurl);
        } else {
            this.shareUtil.initShareData(this.title, this.message, this.imageurl, this.producturl, this.sinaSharePath);
        }
    }
}
