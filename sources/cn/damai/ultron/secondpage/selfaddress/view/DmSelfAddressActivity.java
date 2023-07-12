package cn.damai.ultron.secondpage.selfaddress.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.scriptmurder.venuedetail.VenueDetailFragment;
import cn.damai.ticklet.bean.TicketServiceFacility;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ultron.secondpage.selfaddress.bean.DmSelfAddressListBean;
import cn.damai.ultron.secondpage.selfaddress.net.DmSelfAddressRequest;
import cn.damai.ultron.view.activity.DmPopWindowBaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.passport.result.AbsResult;
import tb.kb0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmSelfAddressActivity extends DmPopWindowBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    String mSelfTip = "";
    private String performId;
    private String venueId;

    private void getData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099817930")) {
            ipChange.ipc$dispatch("-1099817930", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.performId = extras.getString(TicketDetailExtFragment.PERFORM_ID);
            this.venueId = extras.getString(VenueDetailFragment.VENUE_ID);
        }
        if (TextUtils.isEmpty(this.performId)) {
            finishActivity();
        } else {
            requestSelfAddressData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949093401")) {
            ipChange.ipc$dispatch("1949093401", new Object[]{this, str, str2});
            return;
        }
        addErrorView(str, str2, "mtop.damai.wireless.order.querySelfMachineAddress");
        updateTitleBottomView(true, "");
    }

    private void requestSelfAddressData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156766033")) {
            ipChange.ipc$dispatch("1156766033", new Object[]{this});
            return;
        }
        startProgressDialog();
        DmSelfAddressRequest dmSelfAddressRequest = new DmSelfAddressRequest();
        dmSelfAddressRequest.performId = this.performId;
        dmSelfAddressRequest.venueId = this.venueId;
        dmSelfAddressRequest.request(new DMMtopRequestListener<DmSelfAddressListBean>(DmSelfAddressListBean.class) { // from class: cn.damai.ultron.secondpage.selfaddress.view.DmSelfAddressActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-680478440")) {
                    ipChange2.ipc$dispatch("-680478440", new Object[]{this, str, str2});
                    return;
                }
                DmSelfAddressActivity.this.stopProgressDialog();
                DmSelfAddressActivity.this.loadErrorPage(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(DmSelfAddressListBean dmSelfAddressListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "420525979")) {
                    ipChange2.ipc$dispatch("420525979", new Object[]{this, dmSelfAddressListBean});
                    return;
                }
                DmSelfAddressActivity.this.stopProgressDialog();
                DmSelfAddressActivity.this.onResponseSuccess();
                if (dmSelfAddressListBean == null) {
                    DmSelfAddressActivity.this.loadErrorPage(AbsResult.MSG_SUCCESS, "麦麦开小差了，请稍后重试");
                    return;
                }
                DmSelfAddressActivity.this.updateTitleBottomView(false, "取票地址在演出前可能有调整，最终地址请在下单后查看票夹");
                RecyclerView recyclerView = DmSelfAddressActivity.this.getRecyclerView();
                if (wh2.e(dmSelfAddressListBean.list) > 0) {
                    if (recyclerView != null) {
                        recyclerView.setAdapter(new DmSelfAddressAdapter(DmSelfAddressActivity.this, dmSelfAddressListBean.list, null, 0));
                    }
                } else if (TextUtils.isEmpty(dmSelfAddressListBean.tip)) {
                    DmSelfAddressActivity.this.loadErrorPage(AbsResult.MSG_SUCCESS, "麦麦开小差了，请稍后重试");
                } else {
                    DmSelfAddressActivity dmSelfAddressActivity = DmSelfAddressActivity.this;
                    String str = dmSelfAddressListBean.tip;
                    dmSelfAddressActivity.mSelfTip = str;
                    if (recyclerView != null) {
                        recyclerView.setAdapter(new DmSelfAddressAdapter(dmSelfAddressActivity, null, str, 1));
                    }
                }
            }
        });
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572510066")) {
            ipChange.ipc$dispatch("572510066", new Object[]{this});
            return;
        }
        C0529c.e().x(kb0.u().w(this, this.mSelfTip));
        super.finishActivity();
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean getRightTextVis() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805475277")) {
            return ((Boolean) ipChange.ipc$dispatch("805475277", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public String getTitleContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1152033791") ? (String) ipChange.ipc$dispatch("-1152033791", new Object[]{this}) : TicketServiceFacility.EXCHANGE_SITE;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101283155")) {
            ipChange.ipc$dispatch("-101283155", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.handleError(i);
        requestSelfAddressData();
    }

    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity
    public boolean isLoadUt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041493911")) {
            return ((Boolean) ipChange.ipc$dispatch("-1041493911", new Object[]{this})).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ultron.view.activity.DmPopWindowBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865031451")) {
            ipChange.ipc$dispatch("1865031451", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        getData();
    }
}
