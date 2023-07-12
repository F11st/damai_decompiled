package cn.damai.mine.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.contacts.bean.AddContactsBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.adapter.CustomerListAdapter;
import cn.damai.mine.bean.AddCustomerCheckBean;
import cn.damai.mine.bean.CustomerBean;
import cn.damai.mine.bean.CustomerListBean;
import cn.damai.mine.net.AddCheckRequest;
import cn.damai.mine.net.CustomerListRequest;
import cn.damai.mine.net.CustomerRemoveRequest;
import cn.damai.mine.net.CustomerRemoveResponse;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cs;
import tb.kg2;
import tb.t60;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CustomersActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private View add_contacts_tip;
    private TextView mAddBtn;
    private String mCardHash;
    private CustomerListAdapter mCustomerListAdapter;
    private IRecyclerView mIrecyclerView;
    private final int ADDCUSTOMER_RESULT = 1009;
    boolean showTip = false;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(CustomersActivity customersActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1077405932")) {
                ipChange.ipc$dispatch("-1077405932", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-107824909")) {
                ipChange.ipc$dispatch("-107824909", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            CustomersActivity.this.deleteCustomer(this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AlertDialog a;

        c(CustomersActivity customersActivity, AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-159667203")) {
                ipChange.ipc$dispatch("-159667203", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AlertDialog a;

        d(CustomersActivity customersActivity, AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1951623166")) {
                ipChange.ipc$dispatch("1951623166", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteCustomer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31451515")) {
            ipChange.ipc$dispatch("31451515", new Object[]{this, str});
            return;
        }
        startProgressDialog();
        this.mCardHash = str;
        CustomerRemoveRequest customerRemoveRequest = new CustomerRemoveRequest();
        customerRemoveRequest.loginKey = z20.q();
        customerRemoveRequest.identityHash = str;
        customerRemoveRequest.request(new DMMtopRequestListener<CustomerRemoveResponse>(CustomerRemoveResponse.class) { // from class: cn.damai.mine.activity.CustomersActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-862763936")) {
                    ipChange2.ipc$dispatch("-862763936", new Object[]{this, str2, str3});
                } else {
                    CustomersActivity.this.deleteCustomerFailed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CustomerRemoveResponse customerRemoveResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1332183350")) {
                    ipChange2.ipc$dispatch("1332183350", new Object[]{this, customerRemoveResponse});
                } else {
                    CustomersActivity.this.deleteCustomerSuccess();
                }
            }
        });
    }

    private View getBottomDivider() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030042116")) {
            return (View) ipChange.ipc$dispatch("1030042116", new Object[]{this});
        }
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(this, 30.0f)));
        view.setBackgroundColor(getResources().getColor(R$color.color_F5F5F5));
        return view;
    }

    private View getTopDivider() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542793320")) {
            return (View) ipChange.ipc$dispatch("-542793320", new Object[]{this});
        }
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(this, 10.0f)));
        view.setBackgroundColor(getResources().getColor(R$color.color_F5F5F5));
        return view;
    }

    private void gotoAddContactPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757227881")) {
            ipChange.ipc$dispatch("757227881", new Object[]{this});
            return;
        }
        Bundle bundle = new Bundle();
        if (getIntent() != null && getIntent().getExtras() != null) {
            bundle.putAll(getIntent().getExtras());
        }
        bundle.putString("bundleName", "mine");
        DMNav.from(this).forResult(1009).withExtras(bundle).toUri(NavUri.b(cs.z));
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32130966")) {
            ipChange.ipc$dispatch("-32130966", new Object[]{this});
            return;
        }
        this.mIrecyclerView = (IRecyclerView) findViewById(R$id.customer_irecyclerview);
        int i = R$id.add_customer_btn;
        this.mAddBtn = (TextView) findViewById(i);
        this.mCustomerListAdapter = new CustomerListAdapter(this);
        this.add_contacts_tip = findViewById(R$id.add_contacts_tip);
        findViewById(R$id.mine_add_address_title_left_icon).setOnClickListener(this);
        findViewById(i).setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mIrecyclerView.setLayoutManager(linearLayoutManager);
        this.mIrecyclerView.setRefreshEnabled(false);
        this.mIrecyclerView.setLoadMoreEnabled(false);
        this.mIrecyclerView.setIsAutoToDefault(false);
        this.mIrecyclerView.getLoadMoreFooterView().setVisibility(8);
        this.mIrecyclerView.setAdapter(this.mCustomerListAdapter);
    }

    private void requestAddCheck() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514412538")) {
            ipChange.ipc$dispatch("1514412538", new Object[]{this});
            return;
        }
        startProgressDialog();
        AddCheckRequest addCheckRequest = new AddCheckRequest();
        addCheckRequest.loginkey = z20.q();
        addCheckRequest.request(new DMMtopRequestListener<AddCustomerCheckBean>(AddCustomerCheckBean.class) { // from class: cn.damai.mine.activity.CustomersActivity.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-855004577")) {
                    ipChange2.ipc$dispatch("-855004577", new Object[]{this, str, str2});
                } else {
                    CustomersActivity.this.returnAddCheckFailed(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(AddCustomerCheckBean addCustomerCheckBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1815259764")) {
                    ipChange2.ipc$dispatch("-1815259764", new Object[]{this, addCustomerCheckBean});
                } else {
                    CustomersActivity.this.returnAddCheckSuccess(addCustomerCheckBean);
                }
            }
        });
    }

    private void requestCustomerList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1072443611")) {
            ipChange.ipc$dispatch("-1072443611", new Object[]{this});
            return;
        }
        startProgressDialog();
        CustomerListRequest customerListRequest = new CustomerListRequest();
        customerListRequest.loginkey = z20.q();
        customerListRequest.request(new DMMtopRequestListener<CustomerListBean>(CustomerListBean.class) { // from class: cn.damai.mine.activity.CustomersActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-847245218")) {
                    ipChange2.ipc$dispatch("-847245218", new Object[]{this, str, str2});
                } else {
                    CustomersActivity.this.requestCustomerFailed(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CustomerListBean customerListBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "217063992")) {
                    ipChange2.ipc$dispatch("217063992", new Object[]{this, customerListBean});
                } else {
                    CustomersActivity.this.returnCustomerList(customerListBean);
                }
            }
        });
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315541240")) {
            ipChange.ipc$dispatch("-1315541240", new Object[]{this});
            return;
        }
        View findViewById = findViewById(R$id.title_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private void showLimitDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1900254954")) {
            ipChange.ipc$dispatch("1900254954", new Object[]{this});
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this).create();
        View inflate = LayoutInflater.from(this).inflate(R$layout.delete_customer_alert, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.tips)).setText(getString(R$string.addcustomer_limit_tips));
        ((TextView) inflate.findViewById(R$id.delete_customer_cancle)).setOnClickListener(new c(this, create));
        ((TextView) inflate.findViewById(R$id.delete_customer_confirm)).setOnClickListener(new d(this, create));
        create.setView(inflate);
        create.show();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339073502")) {
            ipChange.ipc$dispatch("-339073502", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void deleteCustomerFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286752392")) {
            ipChange.ipc$dispatch("286752392", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.i(str2);
    }

    public void deleteCustomerSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1174549174")) {
            ipChange.ipc$dispatch("1174549174", new Object[]{this});
            return;
        }
        stopProgressDialog();
        ToastUtil.i("删除成功");
        List<CustomerBean> data = this.mCustomerListAdapter.getData();
        if (data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                if (this.mCardHash.equals(data.get(i).getIdentityHash())) {
                    data.remove(i);
                }
            }
        }
        this.mCustomerListAdapter.setData(data);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1938850168") ? ((Integer) ipChange.ipc$dispatch("-1938850168", new Object[]{this})).intValue() : R$layout.mine_customers_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836811789")) {
            ipChange.ipc$dispatch("-1836811789", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264270488")) {
            ipChange.ipc$dispatch("264270488", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32396549")) {
            ipChange.ipc$dispatch("32396549", new Object[]{this});
            return;
        }
        hideBaseLayout();
        init();
        setImmersionStyle();
        requestCustomerList();
        if (getIntent() != null && "true".equals(getIntent().getStringExtra("showtip"))) {
            this.add_contacts_tip.setVisibility(0);
            this.showTip = true;
            return;
        }
        this.add_contacts_tip.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        AddContactsBean addContactsBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766284884")) {
            ipChange.ipc$dispatch("-766284884", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1009 && (addContactsBean = (AddContactsBean) intent.getParcelableExtra("contacts")) != null) {
            CustomerBean customerBean = new CustomerBean();
            customerBean.setIdentityHash(addContactsBean.getIdentityHash());
            customerBean.setMaskedIdentityNo(addContactsBean.getMaskedIdentityNo());
            customerBean.setIdentityTypeName(addContactsBean.getIdentityTypeName());
            customerBean.setMaskedName(addContactsBean.getMaskedName());
            customerBean.setIdentityType(addContactsBean.getIdentityType());
            List<CustomerBean> data = this.mCustomerListAdapter.getData();
            if (data != null) {
                data.add(0, customerBean);
            }
            this.mCustomerListAdapter.setData(data);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1480730539")) {
            ipChange.ipc$dispatch("1480730539", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.mine_add_address_title_left_icon) {
            finish();
        } else if (id == R$id.add_customer_btn) {
            requestAddCheck();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594261214")) {
            ipChange.ipc$dispatch("-594261214", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278498483")) {
            ipChange.ipc$dispatch("1278498483", new Object[]{this});
        }
    }

    public void requestCustomerFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15212986")) {
            ipChange.ipc$dispatch("15212986", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.i(str2);
    }

    public void returnAddCheckFailed(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366011462")) {
            ipChange.ipc$dispatch("-1366011462", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.i(str2);
    }

    public void returnAddCheckSuccess(AddCustomerCheckBean addCustomerCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403177370")) {
            ipChange.ipc$dispatch("-403177370", new Object[]{this, addCustomerCheckBean});
            return;
        }
        stopProgressDialog();
        if (addCustomerCheckBean == null || TextUtils.isEmpty(addCustomerCheckBean.getTouchLimit())) {
            return;
        }
        if (Boolean.parseBoolean(addCustomerCheckBean.getTouchLimit())) {
            showLimitDialog();
        } else {
            gotoAddContactPage();
        }
    }

    public void returnCustomerList(CustomerListBean customerListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1460585911")) {
            ipChange.ipc$dispatch("-1460585911", new Object[]{this, customerListBean});
            return;
        }
        stopProgressDialog();
        if ((customerListBean == null || customerListBean.getResult() == null || customerListBean.getResult().size() == 0) && this.showTip) {
            gotoAddContactPage();
            finish();
        } else if (customerListBean == null || customerListBean.getResult() == null) {
        } else {
            this.mCustomerListAdapter.setData(customerListBean.getResult());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1984080132")) {
            return (String) ipChange.ipc$dispatch("-1984080132", new Object[]{this});
        }
        return null;
    }

    public void showDeleteCustomerDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854753046")) {
            ipChange.ipc$dispatch("854753046", new Object[]{this, str});
            return;
        }
        DMDialog dMDialog = new DMDialog(this);
        dMDialog.p(R$string.customer_delete_tips);
        dMDialog.i("取消", new a(this));
        dMDialog.n("确定", new b(str));
        dMDialog.show();
    }
}
