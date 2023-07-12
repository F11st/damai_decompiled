package cn.damai.ticklet.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketPerformTransferAcceptResult;
import cn.damai.ticklet.bean.TicketTable;
import cn.damai.ticklet.bean.TicketTransferTicketPersonMapping;
import cn.damai.ticklet.bean.TickletContractResponse;
import cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil;
import cn.damai.ticklet.net.TickletGetContactListRequest;
import cn.damai.ticklet.ui.adapter.TickletAttendanceAdapter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.view.DMActionButtonBgView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cb1;
import tb.cs;
import tb.kg2;
import tb.un2;
import tb.wh2;
import tb.xn2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletAttendanceActivity extends TickletBaseActivity implements DamaiConstants, TickletDetailConfirmAcceptUtil.TickletTransferConfirmAcceptCallBack, TickletAttendanceAdapter.OnSelectIdTypeChanged {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ORDER_ADD_CONTACTS = 666;
    private LinearLayout acceptListLayout;
    private TickletAttendanceAdapter adapter;
    private LinearLayout attendanceTipAdd;
    private DMActionButtonBgView btnTicketTransferConfirm;
    private TicketPerformTransferAcceptResult.TicketPerformTransferData confirmAcceptData;
    private LinearLayout errorPageView;
    private DMIconFontTextView ivTitleBack;
    private TextView mAddContactsBtn;
    private int mContactsCount;
    private TextView mContactsCountText;
    private IRecyclerView mRecyclerView;
    private View mViewStatusBarSpace;
    private LinearLayout ticklet_accept_button;
    private View titleBottomLine;
    private TextView tvRule;
    private TextView tvTitle;
    private ArrayList<TickletContractResponse.IdInfosEntity> orderContacts = new ArrayList<>();
    private TickletDetailConfirmAcceptUtil confirmAcceptRequest = new TickletDetailConfirmAcceptUtil(this);

    private ArrayList<TicketTable> acceptLeftData(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6194301")) {
            return (ArrayList) ipChange.ipc$dispatch("-6194301", new Object[]{this, arrayList});
        }
        ArrayList<TicketTable> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.confirmAcceptData.ticketInfoVOs.size()) {
                    break;
                } else if (arrayList.get(i).equals(this.confirmAcceptData.ticketInfoVOs.get(i2).tranferRecordId)) {
                    arrayList2.add(this.confirmAcceptData.ticketInfoVOs.get(i2));
                    break;
                } else {
                    i2++;
                }
            }
        }
        return arrayList2;
    }

    private void confirmAccept(ArrayList<TickletContractResponse.IdInfosEntity> arrayList) {
        TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData;
        ArrayList<TicketTable> arrayList2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268042878")) {
            ipChange.ipc$dispatch("-1268042878", new Object[]{this, arrayList});
        } else if (arrayList != null && arrayList.size() != 0 && arrayList.size() == this.mContactsCount && (ticketPerformTransferData = this.confirmAcceptData) != null && (arrayList2 = ticketPerformTransferData.ticketInfoVOs) != null && arrayList2.size() > 0) {
            ArrayList<TicketTransferTicketPersonMapping> arrayList3 = new ArrayList<>();
            for (int i = 0; i < this.confirmAcceptData.ticketInfoVOs.size(); i++) {
                TicketTable ticketTable = this.confirmAcceptData.ticketInfoVOs.get(i);
                TicketTransferTicketPersonMapping ticketTransferTicketPersonMapping = new TicketTransferTicketPersonMapping();
                ticketTransferTicketPersonMapping.transferRecordId = ticketTable.tranferRecordId;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.mContactsCount) {
                        break;
                    }
                    if (i == getRealNameNum(this.confirmAcceptData).get(i2).intValue() && "3".equals(ticketTable.acceptVoucherType)) {
                        ticketTransferTicketPersonMapping.certNoHash = arrayList.get(i2).getIdentityHash();
                        break;
                    }
                    i2++;
                }
                arrayList3.add(ticketTransferTicketPersonMapping);
            }
            this.confirmAcceptRequest.setTransferNum(arrayList3.size());
            this.confirmAcceptRequest.requestAcceptTransferData(arrayList3, this.confirmAcceptData.performId);
        }
    }

    private ArrayList<Integer> getRealNameNum(TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData) {
        ArrayList<TicketTable> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1581487632")) {
            return (ArrayList) ipChange.ipc$dispatch("1581487632", new Object[]{this, ticketPerformTransferData});
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (ticketPerformTransferData != null && (arrayList = ticketPerformTransferData.ticketInfoVOs) != null && arrayList.size() > 0) {
            for (int i = 0; i < ticketPerformTransferData.ticketInfoVOs.size(); i++) {
                if (ticketPerformTransferData.ticketInfoVOs.get(i) != null && "3".equals(ticketPerformTransferData.ticketInfoVOs.get(i).acceptVoucherType)) {
                    arrayList2.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList2;
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981355539")) {
            ipChange.ipc$dispatch("1981355539", new Object[]{this});
            return;
        }
        TickletAttendanceAdapter tickletAttendanceAdapter = new TickletAttendanceAdapter(this, this.orderContacts);
        this.adapter = tickletAttendanceAdapter;
        tickletAttendanceAdapter.d(this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.setAdapter(this.adapter);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    private void onBackPress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772300595")) {
            ipChange.ipc$dispatch("1772300595", new Object[]{this});
            return;
        }
        setResult(-1);
        finish();
    }

    private void reportContactListXFlushError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646147396")) {
            ipChange.ipc$dispatch("-646147396", new Object[]{this, str, str2});
        } else {
            xn2.d(xn2.f(xn2.TICKLET_CONTACT_INTERFACE_LIST_API, "mtop.damai.wireless.user.customerlist.get", str, str2, ""), xn2.TICKLET_CONTACT_INTERFACE_ERROR_CODE, str, xn2.TICKLET_CONTACT_INTERFACE_ERROR_MSG);
        }
    }

    private void requestContactsList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048015856")) {
            ipChange.ipc$dispatch("-1048015856", new Object[]{this});
            return;
        }
        TickletGetContactListRequest tickletGetContactListRequest = new TickletGetContactListRequest();
        tickletGetContactListRequest.loginkey = z20.q();
        tickletGetContactListRequest.request(new DMMtopRequestListener<TickletContractResponse>(TickletContractResponse.class) { // from class: cn.damai.ticklet.ui.activity.TickletAttendanceActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-873376418")) {
                    ipChange2.ipc$dispatch("-873376418", new Object[]{this, str, str2});
                    return;
                }
                TickletAttendanceActivity.this.stopProgressDialog();
                TickletAttendanceActivity.this.contactsError(str, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TickletContractResponse tickletContractResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1002733372")) {
                    ipChange2.ipc$dispatch("-1002733372", new Object[]{this, tickletContractResponse});
                    return;
                }
                TickletAttendanceActivity.this.stopProgressDialog();
                TickletAttendanceActivity.this.returnContactsList(tickletContractResponse);
            }
        });
        startProgressDialog();
    }

    private void setImmersionStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985235464")) {
            ipChange.ipc$dispatch("1985235464", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.mViewStatusBarSpace;
            if (view != null) {
                view.getLayoutParams().height = kg2.a(this);
                this.mViewStatusBarSpace.setVisibility(0);
            }
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
            View view2 = this.mViewStatusBarSpace;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-410567503")) {
            ipChange.ipc$dispatch("-410567503", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.acceptListLayout.setVisibility(8);
        showView(true);
        onResponseError(3, getString(R$string.ticklet_person_no_data), "", "", this.errorPageView, true);
    }

    private void showErrorPage(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849894486")) {
            ipChange.ipc$dispatch("-1849894486", new Object[]{this, str, str2});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.acceptListLayout.setVisibility(8);
        onResponseError(str, str2, "mtop.damai.wireless.user.customerlist.get", this.errorPageView, true);
    }

    private void showView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62919260")) {
            ipChange.ipc$dispatch("62919260", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.ticklet_accept_button.setVisibility(0);
            this.attendanceTipAdd.setVisibility(0);
        } else {
            this.ticklet_accept_button.setVisibility(8);
            this.attendanceTipAdd.setVisibility(8);
        }
    }

    @Override // cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil.TickletTransferConfirmAcceptCallBack
    public void confirmAcceptSecondFail(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52077804")) {
            ipChange.ipc$dispatch("-52077804", new Object[]{this, arrayList});
            return;
        }
        if (wh2.e(arrayList) > 0) {
            this.confirmAcceptData.ticketInfoVOs = acceptLeftData(arrayList);
            this.mContactsCount = getRealNameNum(this.confirmAcceptData).size();
        } else {
            this.mContactsCount = 0;
        }
        int i = this.mContactsCount;
        if (i > 0) {
            this.mContactsCountText.setText(String.format("选择%1$s位接收人", String.valueOf(i)));
            return;
        }
        setResult(-1);
        finish();
    }

    public void contactsError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1754232335")) {
            ipChange.ipc$dispatch("1754232335", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        reportContactListXFlushError(str, str2);
        showView(false);
        showErrorPage(str2, str);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94049502")) {
            ipChange.ipc$dispatch("-94049502", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1083336312") ? ((Integer) ipChange.ipc$dispatch("-1083336312", new Object[]{this})).intValue() : R$layout.ticklet_attendance_layout;
    }

    public ArrayList<TickletContractResponse.IdInfosEntity> getSelectContactsList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "419120359")) {
            return (ArrayList) ipChange.ipc$dispatch("419120359", new Object[]{this});
        }
        ArrayList<TickletContractResponse.IdInfosEntity> arrayList = new ArrayList<>();
        for (int i = 0; i < this.orderContacts.size(); i++) {
            if (this.orderContacts.get(i).isSelected()) {
                arrayList.add(this.orderContacts.get(i));
            }
        }
        return arrayList;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085686029")) {
            ipChange.ipc$dispatch("-1085686029", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.errorPageView.setVisibility(8);
        this.acceptListLayout.setVisibility(0);
        requestContactsList();
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102636037")) {
            ipChange.ipc$dispatch("102636037", new Object[]{this});
            return;
        }
        this.ticklet_accept_button = (LinearLayout) findViewById(R$id.ticklet_accept_button);
        this.btnTicketTransferConfirm = (DMActionButtonBgView) findViewById(R$id.ticklet_attendance_confirm);
        this.attendanceTipAdd = (LinearLayout) findViewById(R$id.ticklet_attendance_tip_add);
        this.mContactsCountText = (TextView) findViewById(R$id.tickelt_create_list_authen_select_count);
        this.mAddContactsBtn = (TextView) findViewById(R$id.ticklet_create_list_authen_add_contacts_btn);
        int i = R$id.errorPageView;
        this.errorPageView = (LinearLayout) findViewById(i);
        this.mViewStatusBarSpace = findViewById(R$id.ticklet_title_bar_space_view);
        this.ivTitleBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        View findViewById = findViewById(R$id.ticklet_bottom_line);
        this.titleBottomLine = findViewById;
        findViewById.setVisibility(8);
        this.tvRule.setVisibility(8);
        this.tvTitle.setText(getString(R$string.ticklet_attendance_title));
        setImmersionStyle();
        this.acceptListLayout = (LinearLayout) findViewById(R$id.ticklet_accept_list_layout);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.ticklet_addendance_list);
        this.errorPageView = (LinearLayout) findViewById(i);
        initIRecyclerView();
        this.ivTitleBack.setOnClickListener(this);
        this.mAddContactsBtn.setOnClickListener(this);
        this.btnTicketTransferConfirm.setOnClickListener(this);
        this.btnTicketTransferConfirm.setBackground(true);
        this.btnTicketTransferConfirm.update(getResources().getString(R$string.Ensure));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-699273044")) {
            ipChange.ipc$dispatch("-699273044", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && 666 == i) {
            this.orderContacts.clear();
            this.adapter.clear();
            requestContactsList();
        }
    }

    @Override // cn.damai.ticklet.ui.adapter.TickletAttendanceAdapter.OnSelectIdTypeChanged
    public void onChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251557176")) {
            ipChange.ipc$dispatch("-1251557176", new Object[]{this, Integer.valueOf(i)});
        } else if (this.orderContacts.get(i) != null) {
            if (this.orderContacts.get(i).isSelected()) {
                this.orderContacts.get(i).setSelected(false);
                this.adapter.notifyDataSetChanged();
                return;
            }
            int size = getSelectContactsList().size();
            int i2 = this.mContactsCount;
            if (size < i2) {
                this.orderContacts.get(i).setSelected(true);
                this.adapter.notifyDataSetChanged();
            } else if (size == i2 && i2 == 1) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.orderContacts.size()) {
                        break;
                    } else if (this.orderContacts.get(i3).isSelected()) {
                        this.orderContacts.get(i3).setSelected(false);
                        break;
                    } else {
                        i3++;
                    }
                }
                this.orderContacts.get(i).setSelected(true);
                this.adapter.notifyDataSetChanged();
            } else {
                ToastUtil.i(getResources().getString(R$string.ticklet_person_limit));
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1810541739")) {
            ipChange.ipc$dispatch("1810541739", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPress();
        } else if (view.getId() == R$id.ticklet_create_list_authen_add_contacts_btn) {
            ArrayList arrayList = new ArrayList();
            IdCardTypes idCardTypes = new IdCardTypes();
            idCardTypes.id = 1;
            idCardTypes.name = "身份证";
            arrayList.add(idCardTypes);
            Bundle bundle = new Bundle();
            bundle.putSerializable("contacts", arrayList);
            bundle.putString("bundleName", "member");
            DMNav.from(this.mContext).forResult(ORDER_ADD_CONTACTS).withExtras(bundle).toUri(NavUri.b(cs.z));
        } else if (view.getId() == R$id.ticklet_attendance_confirm) {
            c.e().x(b.getInstance().e(un2.TICKLET_TRANSFER_TABLE_PAGE, "bottom", "submitbtn", null, Boolean.FALSE));
            ArrayList<TickletContractResponse.IdInfosEntity> selectContactsList = getSelectContactsList();
            if (selectContactsList == null || selectContactsList.size() <= 0 || selectContactsList.size() != this.mContactsCount) {
                ToastUtil.f(getResources().getString(R$string.ticklet_person_num_tip, String.valueOf(this.mContactsCount)));
            } else {
                confirmAccept(selectContactsList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214977557")) {
            ipChange.ipc$dispatch("1214977557", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            TicketPerformTransferAcceptResult.TicketPerformTransferData ticketPerformTransferData = (TicketPerformTransferAcceptResult.TicketPerformTransferData) getIntent().getSerializableExtra("confirmAcceptData");
            this.confirmAcceptData = ticketPerformTransferData;
            if (ticketPerformTransferData == null) {
                finish();
                return;
            }
            this.mContactsCount = getRealNameNum(ticketPerformTransferData).size();
            hideBaseLayout();
            requestContactsList();
            this.confirmAcceptRequest.setCallBack(this);
            this.tvTitle.setText(getResources().getString(R$string.ticklet_attendance_title));
            this.mContactsCountText.setText(String.format("需选择%1$s位", String.valueOf(this.mContactsCount)));
            setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_TRANSFER_TABLE_PAGE));
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226024085")) {
            ipChange.ipc$dispatch("226024085", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942182379")) {
            return ((Boolean) ipChange.ipc$dispatch("1942182379", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            onBackPress();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "620471088")) {
            ipChange.ipc$dispatch("620471088", new Object[]{this, intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720940647")) {
            ipChange.ipc$dispatch("-720940647", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773462926")) {
            ipChange.ipc$dispatch("773462926", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018975076")) {
            ipChange.ipc$dispatch("2018975076", new Object[]{this, bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    public void returnContactsList(TickletContractResponse tickletContractResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643862966")) {
            ipChange.ipc$dispatch("-1643862966", new Object[]{this, tickletContractResponse});
            return;
        }
        stopProgressDialog();
        this.errorPageView.setVisibility(8);
        if (tickletContractResponse != null && tickletContractResponse.getResult() != null) {
            for (int i = 0; i < tickletContractResponse.getResult().size(); i++) {
                try {
                    TickletContractResponse.IdInfosEntity idInfosEntity = tickletContractResponse.getResult().get(i);
                    if (idInfosEntity != null && 1 == idInfosEntity.getIdentityType()) {
                        this.orderContacts.add(idInfosEntity);
                    }
                } catch (Exception e) {
                    cb1.b("TickletAttendance", e.getMessage());
                }
            }
            if (this.orderContacts.size() > 0) {
                showView(true);
                this.acceptListLayout.setVisibility(0);
                this.adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        showEmptyPage();
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865062404")) {
            return (String) ipChange.ipc$dispatch("-865062404", new Object[]{this});
        }
        return null;
    }
}
