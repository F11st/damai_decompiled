package cn.damai.commonbusiness.address.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.address.bean.AddAddressResultBean;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.address.bean.DivisionBean;
import cn.damai.commonbusiness.address.bean.DivisionListBean;
import cn.damai.commonbusiness.address.bean.PhoneAllowableBean;
import cn.damai.commonbusiness.address.bean.PhoneAllowableResult;
import cn.damai.commonbusiness.address.contract.AddAddressContract;
import cn.damai.commonbusiness.address.model.AddAddressModel;
import cn.damai.commonbusiness.address.presenter.AddAddressPresenter;
import cn.damai.commonbusiness.address.view.AddressDivisionSelectView;
import cn.damai.commonbusiness.address.view.AddressStreetSelectView;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.util.SystemContactsUtil;
import cn.damai.login.LoginManager;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tb.cb1;
import tb.e80;
import tb.ir1;
import tb.jn1;
import tb.kg2;
import tb.wh2;
import tb.y3;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class AddAddressActivity extends DamaiBaseActivity<AddAddressPresenter, AddAddressModel> implements AddAddressContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CODE_REQUEST_CONTACT = 17;
    private static final int CODE_REQUEST_LOGIN = 18;
    private static final int CODE_REQUEST_SELECT_AREA_CODE = 19;
    private static final String DEFAULT_AREA_CODE = "86";
    public static final String KEY_MODIFIED_ADDRESS_DATA = "key_modified_address";
    public static final String KEY_OPERATION_ADDRESS = "key_operation";
    private static final int LEVEL_CITY = 3;
    private static final int LEVEL_COUNTY = 4;
    private static final int LEVEL_PROVINCE = 2;
    private static final int LEVEL_STREET = 5;
    private static final String NON_DIVISION_CODE = "-1";
    public static final int TYPE_OPERATION_ADD = 1;
    public static final int TYPE_OPERATION_MODIFY = 2;
    private static final int TYPE_SELECT_PROVINCE_CITY_COUNTY = 1;
    private static final int TYPE_SELECT_STREET = 2;
    private PopupWindow mAddressDivisionSelectPopupWindow;
    private AddressStreetSelectView mAddressStreetSelectView;
    private List<DivisionBean> mCityDivisionList;
    private TextWatcher mConsigneeDetailAddressTextWatcher;
    private TextWatcher mConsigneeNameTextWatcher;
    private TextWatcher mConsigneePhoneTextWatcher;
    private List<DivisionBean> mCountyDivisionList;
    private DivisionBean mCurCityDivisionBean;
    private DivisionBean mCurCountyDivisionBean;
    private DivisionBean mCurProvinceDivisionBean;
    private DivisionBean mCurStreetDivisionBean;
    private EditText mEtConsigneeDetailAddress;
    private EditText mEtConsigneeName;
    private EditText mEtConsigneePhone;
    private LinearLayout mHeaderTitleView;
    private DMIconFontTextView mIvClearConsigneeDetailAddress;
    private DMIconFontTextView mIvClearConsigneeName;
    private DMIconFontTextView mIvClearConsigneePhone;
    private LinearLayout mLvAddAddressRootView;
    private LinearLayout mLvAreaCodeContainer;
    private AddressBean mModifyAddressBean;
    private View.OnClickListener mOnAddContactClickListener;
    private View.OnClickListener mOnAreaCodeClickListener;
    private View.OnClickListener mOnClearConsigneeNameListener;
    private View.OnClickListener mOnClearConsigneePhoneListener;
    private View.OnClickListener mOnClearDetailAddressListener;
    private View.OnClickListener mOnConsigneeRegionClickListener;
    private View.OnClickListener mOnConsigneeStreetClickListener;
    private View.OnClickListener mOnSaveAddressClickListener;
    private View.OnClickListener mOnTitleBackClickListener;
    private int mOperationType;
    private ArrayList<PhoneAllowableBean> mPhoneAllowableBeanList;
    private List<DivisionBean> mProvinceDivisionList;
    private AddressDivisionSelectView mSelectAddressDivisionView;
    private String mSelectedAreaCode;
    private DivisionBean mSelectedCityBean;
    private DivisionBean mSelectedCountyBean;
    private DivisionBean mSelectedProvinceBean;
    private DivisionBean mSelectedStreetBean;
    private List<DivisionBean> mStreetDivisionList;
    private TextView mTvAreaCode;
    private DMIconFontTextView mTvChooseConsignee;
    private TextView mTvConsigneeRegion;
    private TextView mTvConsigneeStreet;
    private DMIconFontTextView mTvTitleBack;
    private TextView mTvTitleMain;
    private TextView mTvTitleSaveAddress;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$a */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0544a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$a$a */
        /* loaded from: classes4.dex */
        public class C0545a implements OnGrantListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0545a() {
            }

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1038280578")) {
                    ipChange.ipc$dispatch("1038280578", new Object[]{this});
                } else {
                    AddAddressActivity.this.startSystemContactActivity(17);
                }
            }
        }

        View$OnClickListenerC0544a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-694372336")) {
                ipChange.ipc$dispatch("-694372336", new Object[]{this, view});
            } else {
                ir1.a(AddAddressActivity.this, false, "android.permission.READ_CONTACTS", "方便您快速填写手机号", new C0545a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$b */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0546b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0546b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1416918033")) {
                ipChange.ipc$dispatch("1416918033", new Object[]{this, view});
            } else {
                AddAddressActivity.this.showSelectAddressDivisionsView();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$c */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0547c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0547c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-766758894")) {
                ipChange.ipc$dispatch("-766758894", new Object[]{this, view});
            } else if (AddAddressActivity.this.mSelectedProvinceBean != null) {
                if (AddAddressActivity.this.mSelectedCountyBean != null) {
                    AddAddressActivity.this.showSelectAddressStreetDivisionView();
                }
            } else {
                ToastUtil.a().j(AddAddressActivity.this, "请选择区域");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$d */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0548d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0548d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-839145452")) {
                ipChange.ipc$dispatch("-839145452", new Object[]{this, view});
            } else {
                AddAddressActivity.this.hideAddressSelectPopupWindow();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$e */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0549e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0549e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1272144917")) {
                ipChange.ipc$dispatch("1272144917", new Object[]{this, view});
            } else {
                AddAddressActivity.this.hideAddressSelectPopupWindow();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$f */
    /* loaded from: classes4.dex */
    public class C0550f implements AddressDivisionSelectView.OnProvinceDivisionChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0550f() {
        }

        @Override // cn.damai.commonbusiness.address.view.AddressDivisionSelectView.OnProvinceDivisionChangedListener
        public void onProvinceDivisionChanged(DivisionBean divisionBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1431904700")) {
                ipChange.ipc$dispatch("1431904700", new Object[]{this, divisionBean});
            } else if (divisionBean != null) {
                AddAddressActivity.this.updateSelectedProvinceDivision(divisionBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$g */
    /* loaded from: classes4.dex */
    public class C0551g implements AddressDivisionSelectView.OnCityDivisionChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0551g() {
        }

        @Override // cn.damai.commonbusiness.address.view.AddressDivisionSelectView.OnCityDivisionChangedListener
        public void onCityDivisionChanged(DivisionBean divisionBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1922616098")) {
                ipChange.ipc$dispatch("1922616098", new Object[]{this, divisionBean});
            } else if (divisionBean != null) {
                AddAddressActivity.this.updateSelectedCityDivision(divisionBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$h */
    /* loaded from: classes4.dex */
    public class C0552h implements AddressDivisionSelectView.OnCountyDivisionChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0552h() {
        }

        @Override // cn.damai.commonbusiness.address.view.AddressDivisionSelectView.OnCountyDivisionChangedListener
        public void onCountyDivisionChanged(DivisionBean divisionBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "396249124")) {
                ipChange.ipc$dispatch("396249124", new Object[]{this, divisionBean});
            } else if (divisionBean == null) {
                AddAddressActivity.this.updateSelectedCountyDivision(divisionBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$i */
    /* loaded from: classes4.dex */
    public class C0553i implements AddressDivisionSelectView.OnProvinceCityCountySelectedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0553i() {
        }

        @Override // cn.damai.commonbusiness.address.view.AddressDivisionSelectView.OnProvinceCityCountySelectedListener
        public void onDivisionsSelected(DivisionBean divisionBean, DivisionBean divisionBean2, DivisionBean divisionBean3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1981138103")) {
                ipChange.ipc$dispatch("-1981138103", new Object[]{this, divisionBean, divisionBean2, divisionBean3});
            } else if (divisionBean == null || divisionBean2 == null || !AddAddressActivity.this.isValidProvinceCity(divisionBean, divisionBean2)) {
            } else {
                if (divisionBean3 == null || AddAddressActivity.this.isValidCityCounty(divisionBean2, divisionBean3)) {
                    AddAddressActivity.this.updateStreetBySelectedCounty(divisionBean3);
                    AddAddressActivity.this.updateSelectedProvinceCityCounty(divisionBean, divisionBean2, divisionBean3);
                    AddAddressActivity.this.hideAddressSelectPopupWindow();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$j */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0554j implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0554j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1310736684")) {
                ipChange.ipc$dispatch("-1310736684", new Object[]{this, view});
            } else {
                AddAddressActivity.this.onBackPressed();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$k */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0555k implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0555k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "331119663")) {
                ipChange.ipc$dispatch("331119663", new Object[]{this, view});
            } else {
                AddAddressActivity.this.hideAddressSelectPopupWindow();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$l */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0556l implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0556l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1852557264")) {
                ipChange.ipc$dispatch("-1852557264", new Object[]{this, view});
            } else {
                AddAddressActivity.this.hideAddressSelectPopupWindow();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$m */
    /* loaded from: classes4.dex */
    public class C0557m implements AddressStreetSelectView.OnStreetDivisionSelectedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0557m() {
        }

        @Override // cn.damai.commonbusiness.address.view.AddressStreetSelectView.OnStreetDivisionSelectedListener
        public void onStreetDivisionSelected(DivisionBean divisionBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1814692947")) {
                ipChange.ipc$dispatch("1814692947", new Object[]{this, divisionBean});
            } else if (divisionBean != null) {
                String parentId = divisionBean.getParentId();
                if (TextUtils.isEmpty(parentId) || !parentId.equals(AddAddressActivity.this.mSelectedCountyBean.getDivisionId())) {
                    return;
                }
                AddAddressActivity.this.mSelectedStreetBean = divisionBean;
                String divisionName = AddAddressActivity.this.mSelectedStreetBean.getDivisionName();
                if (!TextUtils.isEmpty(divisionName)) {
                    AddAddressActivity.this.mTvConsigneeStreet.setText(divisionName);
                } else {
                    AddAddressActivity.this.mTvConsigneeStreet.setText("");
                }
                AddAddressActivity.this.hideAddressSelectPopupWindow();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$n */
    /* loaded from: classes4.dex */
    public class C0558n implements AddressStreetSelectView.OnStreetDivisionChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0558n() {
        }

        @Override // cn.damai.commonbusiness.address.view.AddressStreetSelectView.OnStreetDivisionChangedListener
        public void onStreetDivisionChanged(DivisionBean divisionBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1297291557")) {
                ipChange.ipc$dispatch("1297291557", new Object[]{this, divisionBean});
            } else {
                AddAddressActivity.this.mCurStreetDivisionBean = divisionBean;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$o */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0559o implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0559o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "800553685")) {
                ipChange.ipc$dispatch("800553685", new Object[]{this, view});
                return;
            }
            AddAddressActivity.this.executeSaveShippingAddressRequest();
            e80.f(AddAddressActivity.this);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$p */
    /* loaded from: classes14.dex */
    public class C0560p implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0560p() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1885107905")) {
                ipChange.ipc$dispatch("1885107905", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                AddAddressActivity.this.mIvClearConsigneeName.setVisibility(0);
            } else {
                AddAddressActivity.this.mIvClearConsigneeName.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-349546974")) {
                ipChange.ipc$dispatch("-349546974", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-655856702")) {
                ipChange.ipc$dispatch("-655856702", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$q */
    /* loaded from: classes14.dex */
    public class C0561q implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0561q() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "701760608")) {
                ipChange.ipc$dispatch("701760608", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                AddAddressActivity.this.mIvClearConsigneePhone.setVisibility(0);
            } else {
                AddAddressActivity.this.mIvClearConsigneePhone.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "783643619")) {
                ipChange.ipc$dispatch("783643619", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1315082755")) {
                ipChange.ipc$dispatch("1315082755", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$r */
    /* loaded from: classes14.dex */
    public class C0562r implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        C0562r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-481586689")) {
                ipChange.ipc$dispatch("-481586689", new Object[]{this, editable});
            } else if (editable.length() > 0) {
                AddAddressActivity.this.mIvClearConsigneeDetailAddress.setVisibility(0);
            } else {
                AddAddressActivity.this.mIvClearConsigneeDetailAddress.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1916834212")) {
                ipChange.ipc$dispatch("1916834212", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1008945084")) {
                ipChange.ipc$dispatch("-1008945084", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$s */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0563s implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0563s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "655780569")) {
                ipChange.ipc$dispatch("655780569", new Object[]{this, view});
            } else {
                AddAddressActivity.this.mEtConsigneeName.setText("");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$t */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0564t implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0564t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1527896358")) {
                ipChange.ipc$dispatch("-1527896358", new Object[]{this, view});
            } else {
                AddAddressActivity.this.mEtConsigneePhone.setText("");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$u */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0565u implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0565u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "583394011")) {
                ipChange.ipc$dispatch("583394011", new Object[]{this, view});
                return;
            }
            e80.f(AddAddressActivity.this);
            AddAddressActivity.this.openAreaCodeListPage();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.address.ui.AddAddressActivity$v */
    /* loaded from: classes14.dex */
    public class View$OnClickListenerC0566v implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0566v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1600282916")) {
                ipChange.ipc$dispatch("-1600282916", new Object[]{this, view});
            } else {
                AddAddressActivity.this.mEtConsigneeDetailAddress.setText("");
            }
        }
    }

    private void executeAddShippingAddressRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229828391")) {
            ipChange.ipc$dispatch("-1229828391", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12});
            return;
        }
        startProgressDialog();
        ((AddAddressPresenter) this.mPresenter).addShippingAddress(z20.q(), str2, str, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    private void executeDivisionDataRequest(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "690786650")) {
            ipChange.ipc$dispatch("690786650", new Object[]{this, Integer.valueOf(i), str});
        } else {
            ((AddAddressPresenter) this.mPresenter).getDivisionChildren(i, str);
        }
    }

    private void executeModifyShippingAddressRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764645886")) {
            ipChange.ipc$dispatch("764645886", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13});
            return;
        }
        startProgressDialog();
        ((AddAddressPresenter) this.mPresenter).modifyShippingAddress(z20.q(), str2, str, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeSaveShippingAddressRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019722279")) {
            ipChange.ipc$dispatch("-2019722279", new Object[]{this});
        } else if (LoginManager.k().q()) {
            validateInputAddressData();
        } else {
            startLoginActivityForResult();
        }
    }

    private int getPopupWindowOffsetY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "559070695") ? ((Integer) ipChange.ipc$dispatch("559070695", new Object[]{this})).intValue() : DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAddressSelectPopupWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807285672")) {
            ipChange.ipc$dispatch("1807285672", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.mAddressDivisionSelectPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mAddressDivisionSelectPopupWindow.dismiss();
    }

    private void initAddressSelectPopupWindow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798377769")) {
            ipChange.ipc$dispatch("1798377769", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mAddressDivisionSelectPopupWindow == null) {
            PopupWindow popupWindow = new PopupWindow(-1, -1);
            this.mAddressDivisionSelectPopupWindow = popupWindow;
            popupWindow.setFocusable(true);
            this.mAddressDivisionSelectPopupWindow.setTouchable(true);
            this.mAddressDivisionSelectPopupWindow.setOutsideTouchable(true);
            this.mAddressDivisionSelectPopupWindow.setBackgroundDrawable(new ColorDrawable(Integer.MIN_VALUE));
            this.mAddressDivisionSelectPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: cn.damai.commonbusiness.address.ui.AddAddressActivity.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-556768867")) {
                        ipChange2.ipc$dispatch("-556768867", new Object[]{this});
                    } else {
                        AddAddressActivity.this.resetCurDivisions();
                    }
                }
            });
        }
        if (i == 1) {
            initProvinceCityCountySelectView();
            this.mAddressDivisionSelectPopupWindow.setContentView(this.mSelectAddressDivisionView);
        } else if (i != 2) {
        } else {
            initStreetSelectView();
            this.mAddressDivisionSelectPopupWindow.setContentView(this.mAddressStreetSelectView);
        }
    }

    private void initIntentData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882598976")) {
            ipChange.ipc$dispatch("-882598976", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mOperationType = extras.getInt(KEY_OPERATION_ADDRESS, 0);
            this.mModifyAddressBean = (AddressBean) extras.getParcelable(KEY_MODIFIED_ADDRESS_DATA);
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478809157")) {
            ipChange.ipc$dispatch("478809157", new Object[]{this});
            return;
        }
        this.mOnTitleBackClickListener = new View$OnClickListenerC0554j();
        this.mOnSaveAddressClickListener = new View$OnClickListenerC0559o();
        this.mConsigneeNameTextWatcher = new C0560p();
        this.mConsigneePhoneTextWatcher = new C0561q();
        this.mConsigneeDetailAddressTextWatcher = new C0562r();
        this.mOnClearConsigneeNameListener = new View$OnClickListenerC0563s();
        this.mOnClearConsigneePhoneListener = new View$OnClickListenerC0564t();
        this.mOnAreaCodeClickListener = new View$OnClickListenerC0565u();
        this.mOnClearDetailAddressListener = new View$OnClickListenerC0566v();
        this.mOnAddContactClickListener = new View$OnClickListenerC0544a();
        this.mOnConsigneeRegionClickListener = new View$OnClickListenerC0546b();
        this.mOnConsigneeStreetClickListener = new View$OnClickListenerC0547c();
    }

    private void initModifyAddressData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760582976")) {
            ipChange.ipc$dispatch("-760582976", new Object[]{this});
            return;
        }
        AddressBean addressBean = this.mModifyAddressBean;
        if (addressBean != null) {
            String consigneeName = addressBean.getConsigneeName();
            if (!TextUtils.isEmpty(consigneeName)) {
                this.mEtConsigneeName.setText(consigneeName);
                this.mEtConsigneeName.setSelection(consigneeName.length());
            } else {
                this.mEtConsigneeName.setText("");
            }
            String mobile = this.mModifyAddressBean.getMobile();
            if (!TextUtils.isEmpty(mobile)) {
                this.mEtConsigneePhone.setText(mobile);
            } else {
                this.mEtConsigneePhone.setText("");
            }
            setAreaCode(this.mModifyAddressBean.getNationPrefix());
            if (!"true".equals(this.mModifyAddressBean.getMatch())) {
                initModifyUnMatchedAddressData();
                return;
            } else {
                initModifyMatchedAddressData();
                return;
            }
        }
        resetViewData();
    }

    private void initModifyMatchedAddressData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1299865426")) {
            ipChange.ipc$dispatch("1299865426", new Object[]{this});
            return;
        }
        StringBuilder sb = new StringBuilder();
        String province = this.mModifyAddressBean.getProvince();
        String provinceCode = this.mModifyAddressBean.getProvinceCode();
        if (!TextUtils.isEmpty(province) && !TextUtils.isEmpty(provinceCode)) {
            sb.append(province);
            DivisionBean divisionBean = new DivisionBean();
            this.mSelectedProvinceBean = divisionBean;
            divisionBean.setDivisionName(province);
            this.mSelectedProvinceBean.setDivisionId(provinceCode);
            this.mSelectedProvinceBean.setDamaiDivisionId(this.mModifyAddressBean.getDmProvinceCode());
            this.mSelectedProvinceBean.setDamaiDivisionName(this.mModifyAddressBean.getDmProvince());
        } else {
            sb.append("");
        }
        String city = this.mModifyAddressBean.getCity();
        String cityCode = this.mModifyAddressBean.getCityCode();
        if (!TextUtils.isEmpty(city) && !TextUtils.isEmpty(cityCode)) {
            sb.append(city);
            DivisionBean divisionBean2 = new DivisionBean();
            this.mSelectedCityBean = divisionBean2;
            divisionBean2.setDivisionId(cityCode);
            this.mSelectedCityBean.setDivisionName(city);
            this.mSelectedCityBean.setDamaiDivisionId(this.mModifyAddressBean.getDmCityCode());
            this.mSelectedCityBean.setDamaiDivisionName(this.mModifyAddressBean.getDmCity());
        } else {
            sb.append("");
        }
        String county = this.mModifyAddressBean.getCounty();
        String countyCode = this.mModifyAddressBean.getCountyCode();
        if (!TextUtils.isEmpty(county) && !wh2.j(countyCode) && !"-1".equals(countyCode) && !county.equals(city)) {
            sb.append(county);
            DivisionBean divisionBean3 = new DivisionBean();
            this.mSelectedCountyBean = divisionBean3;
            divisionBean3.setDivisionId(countyCode);
            this.mSelectedCountyBean.setDivisionName(county);
            this.mSelectedCountyBean.setDamaiDivisionId(this.mModifyAddressBean.getDmCountyCode());
            this.mSelectedCountyBean.setDamaiDivisionName(this.mModifyAddressBean.getDmCounty());
        } else {
            sb.append("");
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            this.mTvConsigneeRegion.setText(sb2);
        } else {
            this.mTvConsigneeRegion.setText("");
        }
        String street = this.mModifyAddressBean.getStreet();
        String streetCode = this.mModifyAddressBean.getStreetCode();
        if (this.mSelectedCountyBean != null && !TextUtils.isEmpty(street)) {
            DivisionBean divisionBean4 = new DivisionBean();
            this.mSelectedStreetBean = divisionBean4;
            divisionBean4.setDivisionId(streetCode);
            this.mSelectedStreetBean.setDivisionName(street);
            this.mTvConsigneeStreet.setText(street);
        } else {
            this.mTvConsigneeStreet.setText("");
        }
        String addressDetail = this.mModifyAddressBean.getAddressDetail();
        if (!TextUtils.isEmpty(addressDetail)) {
            this.mEtConsigneeDetailAddress.setText(addressDetail);
        } else {
            this.mEtConsigneeDetailAddress.setText("");
        }
    }

    private void initModifyUnMatchedAddressData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345260153")) {
            ipChange.ipc$dispatch("345260153", new Object[]{this});
            return;
        }
        StringBuilder sb = new StringBuilder();
        String province = this.mModifyAddressBean.getProvince();
        String provinceCode = this.mModifyAddressBean.getProvinceCode();
        if (!TextUtils.isEmpty(province) && !TextUtils.isEmpty(provinceCode)) {
            sb.append(province);
        } else {
            sb.append("");
        }
        String city = this.mModifyAddressBean.getCity();
        String cityCode = this.mModifyAddressBean.getCityCode();
        if (!TextUtils.isEmpty(city) && !TextUtils.isEmpty(cityCode)) {
            sb.append(city);
        } else {
            sb.append("");
        }
        String county = this.mModifyAddressBean.getCounty();
        String countyCode = this.mModifyAddressBean.getCountyCode();
        if (!TextUtils.isEmpty(county) && !wh2.j(countyCode) && !"-1".equals(countyCode) && !county.equals(city)) {
            sb.append(county);
        } else {
            sb.append("");
        }
        String street = this.mModifyAddressBean.getStreet();
        String streetCode = this.mModifyAddressBean.getStreetCode();
        if (!TextUtils.isEmpty(street) && !wh2.j(streetCode) && !"-1".equals(streetCode)) {
            sb.append(street);
        } else {
            sb.append("");
        }
        String addressDetail = this.mModifyAddressBean.getAddressDetail();
        if (!TextUtils.isEmpty(addressDetail)) {
            sb.append(addressDetail);
        }
        this.mEtConsigneeDetailAddress.setText(sb.toString());
    }

    private void initProvinceCityCountySelectView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "26831968")) {
            ipChange.ipc$dispatch("26831968", new Object[]{this});
        } else if (this.mSelectAddressDivisionView == null) {
            AddressDivisionSelectView addressDivisionSelectView = new AddressDivisionSelectView(this);
            this.mSelectAddressDivisionView = addressDivisionSelectView;
            addressDivisionSelectView.setOnClickListener(new View$OnClickListenerC0548d());
            this.mSelectAddressDivisionView.setOnCancelClickListener(new View$OnClickListenerC0549e());
            this.mSelectAddressDivisionView.setOnProvinceDivisionChangedListener(new C0550f());
            this.mSelectAddressDivisionView.setOnCityDivisionChangedListener(new C0551g());
            this.mSelectAddressDivisionView.setOnCountyDivisionChangedListener(new C0552h());
            this.mSelectAddressDivisionView.setOnDivisionsSelectedListener(new C0553i());
        }
    }

    private void initStreetSelectView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857613442")) {
            ipChange.ipc$dispatch("857613442", new Object[]{this});
        } else if (this.mAddressStreetSelectView == null) {
            AddressStreetSelectView addressStreetSelectView = new AddressStreetSelectView(this);
            this.mAddressStreetSelectView = addressStreetSelectView;
            addressStreetSelectView.setOnClickListener(new View$OnClickListenerC0555k());
            this.mAddressStreetSelectView.setOnCancelClickListener(new View$OnClickListenerC0556l());
            this.mAddressStreetSelectView.setOnStreetDivisionSelectedListener(new C0557m());
            this.mAddressStreetSelectView.setOnStreetDivisionChangedListener(new C0558n());
        }
    }

    private void initViewData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857762857")) {
            ipChange.ipc$dispatch("-857762857", new Object[]{this});
            return;
        }
        int i = this.mOperationType;
        if (i == 1) {
            this.mTvTitleMain.setText("新增收货地址");
            resetViewData();
        } else if (i == 2) {
            this.mTvTitleMain.setText("修改收货地址");
            initModifyAddressData();
        } else {
            this.mTvTitleMain.setText("");
            resetViewData();
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367002826")) {
            ipChange.ipc$dispatch("-1367002826", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mLvAddAddressRootView = (LinearLayout) findViewById(R$id.add_address_root_lv);
        this.mHeaderTitleView = (LinearLayout) findViewById(R$id.common_business_add_address_title_lv);
        this.mTvTitleBack = (DMIconFontTextView) findViewById(R$id.common_business_add_address_title_left_tv);
        this.mTvTitleMain = (TextView) findViewById(R$id.common_business_add_address_title_main_tv);
        this.mTvTitleSaveAddress = (TextView) findViewById(R$id.common_business_add_address_title_right_tv);
        this.mEtConsigneeName = (EditText) findViewById(R$id.common_business_consignee_name_et);
        this.mTvChooseConsignee = (DMIconFontTextView) findViewById(R$id.common_business_choose_consignee_tv);
        EditText editText = (EditText) findViewById(R$id.common_business_consignee_phone_et);
        this.mEtConsigneePhone = editText;
        editText.setInputType(3);
        this.mLvAreaCodeContainer = (LinearLayout) findViewById(R$id.common_business_area_code_container_lv);
        this.mTvAreaCode = (TextView) findViewById(R$id.common_business_area_code_tv);
        this.mTvConsigneeRegion = (TextView) findViewById(R$id.common_business_consignee_region_tv);
        this.mTvConsigneeStreet = (TextView) findViewById(R$id.common_business_consignee_street_tv);
        this.mEtConsigneeDetailAddress = (EditText) findViewById(R$id.common_business_consignee_detail_address_et);
        this.mIvClearConsigneeName = (DMIconFontTextView) findViewById(R$id.common_business_clear_consignee_name_iv);
        this.mIvClearConsigneePhone = (DMIconFontTextView) findViewById(R$id.common_business_clear_consignee_phone_iv);
        this.mIvClearConsigneeDetailAddress = (DMIconFontTextView) findViewById(R$id.common_business_clear_consignee_detail_address_iv);
        this.mIvClearConsigneeName.setVisibility(4);
        this.mIvClearConsigneePhone.setVisibility(4);
        this.mIvClearConsigneeDetailAddress.setVisibility(4);
        setStatusBar();
    }

    private boolean isBlankStr(String str) {
        int length;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "614837437")) {
            return ((Boolean) ipChange.ipc$dispatch("614837437", new Object[]{this, str})).booleanValue();
        }
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSameDivision(DivisionBean divisionBean, DivisionBean divisionBean2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834887453")) {
            return ((Boolean) ipChange.ipc$dispatch("1834887453", new Object[]{this, divisionBean, divisionBean2})).booleanValue();
        }
        if (divisionBean != null) {
            String divisionId = divisionBean.getDivisionId();
            if (!TextUtils.isEmpty(divisionId) && divisionId.equals(divisionBean2.getDivisionId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidCityCounty(DivisionBean divisionBean, DivisionBean divisionBean2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942354769")) {
            return ((Boolean) ipChange.ipc$dispatch("1942354769", new Object[]{this, divisionBean, divisionBean2})).booleanValue();
        }
        String divisionId = divisionBean.getDivisionId();
        String divisionId2 = divisionBean2.getDivisionId();
        String parentId = divisionBean2.getParentId();
        return (TextUtils.isEmpty(divisionId) || TextUtils.isEmpty(divisionId2) || TextUtils.isEmpty(parentId) || !parentId.equals(divisionId)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidProvinceCity(DivisionBean divisionBean, DivisionBean divisionBean2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "611348651")) {
            return ((Boolean) ipChange.ipc$dispatch("611348651", new Object[]{this, divisionBean, divisionBean2})).booleanValue();
        }
        String divisionId = divisionBean.getDivisionId();
        String divisionId2 = divisionBean2.getDivisionId();
        String parentId = divisionBean2.getParentId();
        return (TextUtils.isEmpty(divisionId) || TextUtils.isEmpty(divisionId2) || TextUtils.isEmpty(parentId) || !parentId.equals(divisionId)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAreaCodeListPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798736325")) {
            ipChange.ipc$dispatch("1798736325", new Object[]{this});
            return;
        }
        ArrayList<PhoneAllowableBean> arrayList = this.mPhoneAllowableBeanList;
        if (arrayList != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString("selected_area_code", this.mSelectedAreaCode);
            bundle.putParcelableArrayList("phone_allowable_list", this.mPhoneAllowableBeanList);
            DMNav.from(this).withExtras(bundle).forResult(19).toUri(NavUri.b("area_code_choose"));
            return;
        }
        retrievePhoneAllowable();
    }

    private void processAddModifyAddressSuccess(AddAddressResultBean addAddressResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "728393803")) {
            ipChange.ipc$dispatch("728393803", new Object[]{this, addAddressResultBean});
        } else if (addAddressResultBean == null || addAddressResultBean.getAddress() == null) {
        } else {
            Intent intent = new Intent();
            intent.putExtra("added_address", addAddressResultBean.getAddress());
            if (addAddressResultBean.getAddress() != null) {
                intent.putExtra("addressId", addAddressResultBean.getAddress().getAddressId());
            }
            setResult(-1, intent);
            finish();
        }
    }

    private void processRetrievedDivisionData(int i, List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1688304658")) {
            ipChange.ipc$dispatch("-1688304658", new Object[]{this, Integer.valueOf(i), list});
        } else if (i == 2) {
            updatePopWindowProvinceDivisionList(list);
        } else if (i == 3) {
            updatePopWindowCityDivisionList(list);
        } else if (i == 4) {
            updatePopWindowCountyDivisionList(list);
        } else if (i != 5) {
        } else {
            updatePopWindowStreetDivisionList(list);
        }
    }

    private String removePhoneNumPrefix(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142957820")) {
            return (String) ipChange.ipc$dispatch("-142957820", new Object[]{this, str, str2});
        }
        if (TextUtils.isEmpty(str2) || str == null || str.length() == 0) {
            return str;
        }
        return str.startsWith(str2) ? removePhoneNumPrefix(str.substring(str2.length(), str.length()), str2) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCurDivisions() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "609936415")) {
            ipChange.ipc$dispatch("609936415", new Object[]{this});
            return;
        }
        this.mCurProvinceDivisionBean = null;
        this.mCurCityDivisionBean = null;
        this.mCurCountyDivisionBean = null;
        this.mCurStreetDivisionBean = null;
    }

    private void resetStreetDivisionData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800650507")) {
            ipChange.ipc$dispatch("800650507", new Object[]{this});
            return;
        }
        this.mTvConsigneeStreet.setText("");
        ArrayList arrayList = new ArrayList();
        this.mStreetDivisionList = arrayList;
        this.mSelectedStreetBean = null;
        AddressStreetSelectView addressStreetSelectView = this.mAddressStreetSelectView;
        if (addressStreetSelectView != null) {
            addressStreetSelectView.setStreetDivisionList(arrayList, null);
        }
    }

    private void resetViewData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076383382")) {
            ipChange.ipc$dispatch("1076383382", new Object[]{this});
            return;
        }
        this.mEtConsigneeName.setText("");
        this.mEtConsigneePhone.setText("");
        this.mTvConsigneeRegion.setText("");
        this.mTvConsigneeStreet.setText("");
        this.mEtConsigneeDetailAddress.setText("");
        setAreaCode(DEFAULT_AREA_CODE);
    }

    private void retrievePhoneAllowable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389546693")) {
            ipChange.ipc$dispatch("1389546693", new Object[]{this});
            return;
        }
        startProgressDialog();
        ((AddAddressPresenter) this.mPresenter).retrievePhoneAllowable();
    }

    private void setAreaCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042558174")) {
            ipChange.ipc$dispatch("-2042558174", new Object[]{this, str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_AREA_CODE;
        }
        this.mSelectedAreaCode = str;
        this.mLvAreaCodeContainer.setVisibility(0);
        TextView textView = this.mTvAreaCode;
        textView.setText(jn1.PLUS + this.mSelectedAreaCode);
    }

    private void setSelectAreaCode(PhoneAllowableBean phoneAllowableBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452461797")) {
            ipChange.ipc$dispatch("452461797", new Object[]{this, phoneAllowableBean});
        } else if (phoneAllowableBean != null) {
            setAreaCode(phoneAllowableBean.code);
            String obj = this.mEtConsigneePhone.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            String b = SystemContactsUtil.b(obj, this.mSelectedAreaCode);
            EditText editText = this.mEtConsigneePhone;
            if (TextUtils.isEmpty(b)) {
                b = "";
            }
            editText.setText(b);
        }
    }

    private void setSelectedContact(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-222459852")) {
            ipChange.ipc$dispatch("-222459852", new Object[]{this, uri});
            return;
        }
        SystemContactsUtil.ContactInfo d = SystemContactsUtil.d(this, uri);
        if (d != null) {
            String b = SystemContactsUtil.b(d.getPhoneNum(), this.mSelectedAreaCode);
            String contactName = d.getContactName();
            if (!TextUtils.isEmpty(contactName)) {
                this.mEtConsigneeName.setText(contactName);
                this.mEtConsigneeName.setSelection(contactName.length());
            }
            if (TextUtils.isEmpty(b)) {
                return;
            }
            this.mEtConsigneePhone.setText(b);
            this.mEtConsigneePhone.setSelection(b.length());
        }
    }

    private void setStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780350345")) {
            ipChange.ipc$dispatch("-780350345", new Object[]{this});
            return;
        }
        View findViewById = this.mHeaderTitleView.findViewById(R$id.top_status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, kg2.a(this)));
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

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548303252")) {
            ipChange.ipc$dispatch("548303252", new Object[]{this});
            return;
        }
        this.mTvTitleBack.setOnClickListener(this.mOnTitleBackClickListener);
        this.mTvTitleSaveAddress.setOnClickListener(this.mOnSaveAddressClickListener);
        this.mEtConsigneeName.addTextChangedListener(this.mConsigneeNameTextWatcher);
        this.mEtConsigneePhone.addTextChangedListener(this.mConsigneePhoneTextWatcher);
        this.mEtConsigneeDetailAddress.addTextChangedListener(this.mConsigneeDetailAddressTextWatcher);
        this.mIvClearConsigneeName.setOnClickListener(this.mOnClearConsigneeNameListener);
        this.mIvClearConsigneePhone.setOnClickListener(this.mOnClearConsigneePhoneListener);
        this.mIvClearConsigneeDetailAddress.setOnClickListener(this.mOnClearDetailAddressListener);
        this.mTvChooseConsignee.setOnClickListener(this.mOnAddContactClickListener);
        this.mTvConsigneeRegion.setOnClickListener(this.mOnConsigneeRegionClickListener);
        this.mTvConsigneeStreet.setOnClickListener(this.mOnConsigneeStreetClickListener);
        this.mLvAreaCodeContainer.setOnClickListener(this.mOnAreaCodeClickListener);
    }

    private void showAddressSelectPopupWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103695117")) {
            ipChange.ipc$dispatch("103695117", new Object[]{this});
            return;
        }
        e80.f(this);
        int[] iArr = new int[2];
        this.mLvAddAddressRootView.getLocationOnScreen(iArr);
        this.mAddressDivisionSelectPopupWindow.showAtLocation(this.mLvAddAddressRootView, 81, iArr[0], iArr[1] - getPopupWindowOffsetY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectAddressDivisionsView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207024006")) {
            ipChange.ipc$dispatch("207024006", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.mAddressDivisionSelectPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            this.mCurProvinceDivisionBean = this.mSelectedProvinceBean;
            this.mCurCityDivisionBean = this.mSelectedCityBean;
            this.mCurCountyDivisionBean = this.mSelectedCountyBean;
            initAddressSelectPopupWindow(1);
            List<DivisionBean> list = this.mProvinceDivisionList;
            if (list != null && list.size() > 0) {
                this.mSelectAddressDivisionView.setProvinceList(this.mProvinceDivisionList, this.mSelectedProvinceBean);
            } else {
                executeDivisionDataRequest(2, "1");
            }
            showAddressSelectPopupWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSelectAddressStreetDivisionView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526355748")) {
            ipChange.ipc$dispatch("1526355748", new Object[]{this});
            return;
        }
        PopupWindow popupWindow = this.mAddressDivisionSelectPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            this.mCurStreetDivisionBean = this.mSelectedStreetBean;
            initAddressSelectPopupWindow(2);
            List<DivisionBean> list = this.mStreetDivisionList;
            if (list != null && list.size() > 0) {
                this.mAddressStreetSelectView.setStreetDivisionList(this.mStreetDivisionList, this.mCurStreetDivisionBean);
            } else {
                executeDivisionDataRequest(5, this.mSelectedCountyBean.getDivisionId());
            }
            showAddressSelectPopupWindow();
        }
    }

    private void startLoginActivityForResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436432100")) {
            ipChange.ipc$dispatch("1436432100", new Object[]{this});
        } else {
            LoginManager.k().x(this, new Intent(), 18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSystemContactActivity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "633578763")) {
            ipChange.ipc$dispatch("633578763", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        try {
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, i);
            }
        } catch (ActivityNotFoundException e) {
            cb1.b("contract", e.getMessage() + "");
        }
    }

    private void updatePopWindowCityDivisionList(List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534918967")) {
            ipChange.ipc$dispatch("534918967", new Object[]{this, list});
            return;
        }
        this.mCityDivisionList = list;
        AddressDivisionSelectView addressDivisionSelectView = this.mSelectAddressDivisionView;
        if (addressDivisionSelectView != null) {
            addressDivisionSelectView.setCityList(list, this.mCurCityDivisionBean);
        }
    }

    private void updatePopWindowCountyDivisionList(List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1511277128")) {
            ipChange.ipc$dispatch("-1511277128", new Object[]{this, list});
            return;
        }
        this.mCountyDivisionList = list;
        AddressDivisionSelectView addressDivisionSelectView = this.mSelectAddressDivisionView;
        if (addressDivisionSelectView != null) {
            addressDivisionSelectView.setCountyList(list, this.mCurCountyDivisionBean);
        }
    }

    private void updatePopWindowProvinceDivisionList(List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905965230")) {
            ipChange.ipc$dispatch("-905965230", new Object[]{this, list});
            return;
        }
        this.mProvinceDivisionList = list;
        AddressDivisionSelectView addressDivisionSelectView = this.mSelectAddressDivisionView;
        if (addressDivisionSelectView != null) {
            addressDivisionSelectView.setProvinceList(list, this.mCurProvinceDivisionBean);
        }
    }

    private void updatePopWindowStreetDivisionList(List<DivisionBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033394209")) {
            ipChange.ipc$dispatch("-1033394209", new Object[]{this, list});
            return;
        }
        this.mStreetDivisionList = list;
        AddressStreetSelectView addressStreetSelectView = this.mAddressStreetSelectView;
        if (addressStreetSelectView != null) {
            addressStreetSelectView.setStreetDivisionList(list, this.mCurStreetDivisionBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedCityDivision(DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969188593")) {
            ipChange.ipc$dispatch("-969188593", new Object[]{this, divisionBean});
        } else if (!isSameDivision(this.mCurCityDivisionBean, divisionBean)) {
            this.mCurCityDivisionBean = divisionBean;
            this.mCurCountyDivisionBean = null;
            ArrayList arrayList = new ArrayList();
            this.mCountyDivisionList = arrayList;
            this.mSelectAddressDivisionView.setCountyList(arrayList, this.mCurCountyDivisionBean);
            executeDivisionDataRequest(4, this.mCurCityDivisionBean.getDivisionId());
        } else {
            List<DivisionBean> list = this.mCountyDivisionList;
            if (list == null || list.isEmpty()) {
                executeDivisionDataRequest(4, this.mCurCityDivisionBean.getDivisionId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedCountyDivision(DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334174702")) {
            ipChange.ipc$dispatch("334174702", new Object[]{this, divisionBean});
        } else if (isSameDivision(this.mCurCountyDivisionBean, divisionBean)) {
        } else {
            this.mCurCountyDivisionBean = divisionBean;
            this.mCurStreetDivisionBean = null;
            this.mStreetDivisionList = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedProvinceCityCounty(DivisionBean divisionBean, DivisionBean divisionBean2, DivisionBean divisionBean3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-890502116")) {
            ipChange.ipc$dispatch("-890502116", new Object[]{this, divisionBean, divisionBean2, divisionBean3});
            return;
        }
        this.mSelectedProvinceBean = divisionBean;
        this.mSelectedCityBean = divisionBean2;
        this.mSelectedCountyBean = divisionBean3;
        if (divisionBean != null && divisionBean2 != null) {
            String divisionName = divisionBean.getDivisionName();
            String divisionName2 = this.mSelectedCityBean.getDivisionName();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(divisionName)) {
                sb.append(divisionName);
            } else {
                sb.append("");
            }
            if (!TextUtils.isEmpty(divisionName2)) {
                sb.append(divisionName2);
            } else {
                sb.append("");
            }
            DivisionBean divisionBean4 = this.mSelectedCountyBean;
            if (divisionBean4 != null) {
                String divisionName3 = divisionBean4.getDivisionName();
                if (!TextUtils.isEmpty(divisionName3)) {
                    if (!divisionName3.equals(divisionName2)) {
                        sb.append(divisionName3);
                    } else {
                        sb.append("");
                    }
                } else {
                    sb.append("");
                }
            } else {
                sb.append("");
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                this.mTvConsigneeRegion.setText(sb2);
                return;
            } else {
                this.mTvConsigneeRegion.setText("");
                return;
            }
        }
        this.mTvConsigneeRegion.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedProvinceDivision(DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319637652")) {
            ipChange.ipc$dispatch("319637652", new Object[]{this, divisionBean});
        } else if (!isSameDivision(this.mCurProvinceDivisionBean, divisionBean)) {
            this.mCurProvinceDivisionBean = divisionBean;
            this.mCurCityDivisionBean = null;
            this.mCurCountyDivisionBean = null;
            this.mCityDivisionList = new ArrayList();
            this.mCountyDivisionList = new ArrayList();
            this.mSelectAddressDivisionView.setCityList(this.mCityDivisionList, this.mCurCityDivisionBean);
            this.mSelectAddressDivisionView.setCountyList(this.mCountyDivisionList, this.mCurCountyDivisionBean);
            executeDivisionDataRequest(3, this.mCurProvinceDivisionBean.getDivisionId());
        } else {
            List<DivisionBean> list = this.mCityDivisionList;
            if (list == null || list.isEmpty()) {
                executeDivisionDataRequest(3, this.mCurProvinceDivisionBean.getDivisionId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateStreetBySelectedCounty(DivisionBean divisionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564954437")) {
            ipChange.ipc$dispatch("-1564954437", new Object[]{this, divisionBean});
        } else if (divisionBean == null) {
            resetStreetDivisionData();
            ToastUtil.a().j(this, "暂无街道地址");
        } else {
            DivisionBean divisionBean2 = this.mSelectedCountyBean;
            if (divisionBean2 == null || !divisionBean2.getDivisionId().equals(divisionBean.getDivisionId())) {
                resetStreetDivisionData();
            }
        }
    }

    private void validateInputAddressData() {
        String str;
        String str2;
        String str3;
        String str4;
        AddressBean addressBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893198644")) {
            ipChange.ipc$dispatch("-893198644", new Object[]{this});
            return;
        }
        String str5 = this.mSelectedAreaCode;
        String obj = this.mEtConsigneeName.getText().toString();
        if (!TextUtils.isEmpty(obj) && !isBlankStr(obj) && !TextUtils.isEmpty(obj.trim())) {
            String obj2 = this.mEtConsigneePhone.getText().toString();
            if (!TextUtils.isEmpty(obj2) && !isBlankStr(obj2) && !TextUtils.isEmpty(obj2.trim())) {
                String charSequence = this.mTvConsigneeRegion.getText().toString();
                if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence.trim())) {
                    DivisionBean divisionBean = this.mSelectedProvinceBean;
                    if (divisionBean != null && this.mSelectedCityBean != null) {
                        String divisionId = divisionBean.getDivisionId();
                        String divisionName = this.mSelectedProvinceBean.getDivisionName();
                        String divisionId2 = this.mSelectedCityBean.getDivisionId();
                        String divisionName2 = this.mSelectedCityBean.getDivisionName();
                        DivisionBean divisionBean2 = this.mSelectedCountyBean;
                        if (divisionBean2 != null) {
                            String divisionId3 = divisionBean2.getDivisionId();
                            str2 = this.mSelectedCountyBean.getDivisionName();
                            str = divisionId3;
                        } else {
                            str = "";
                            str2 = str;
                        }
                        DivisionBean divisionBean3 = this.mSelectedStreetBean;
                        if (divisionBean3 != null) {
                            str3 = divisionBean3.getDivisionId();
                            str4 = this.mSelectedStreetBean.getDivisionName();
                        } else {
                            str3 = "";
                            str4 = str3;
                        }
                        String obj3 = this.mEtConsigneeDetailAddress.getText().toString();
                        if (!TextUtils.isEmpty(obj3) && !TextUtils.isEmpty(obj3.trim())) {
                            int i = this.mOperationType;
                            if (i == 1) {
                                executeAddShippingAddressRequest(obj, str5, obj2, divisionId, divisionName, divisionId2, divisionName2, str, str2, str3, str4, obj3);
                                return;
                            } else if (i != 2 || (addressBean = this.mModifyAddressBean) == null) {
                                return;
                            } else {
                                executeModifyShippingAddressRequest(addressBean.getAddressId(), str5, obj, obj2, divisionId, divisionName, divisionId2, divisionName2, str, str2, str3, str4, obj3);
                                return;
                            }
                        }
                        ToastUtil.a().j(this, getResources().getString(R$string.common_business_str_hint_detail_address));
                        return;
                    }
                    ToastUtil.a().j(this, getResources().getString(R$string.common_business_str_hint_input_division));
                    return;
                }
                ToastUtil.a().j(this, getResources().getString(R$string.common_business_str_hint_input_division));
                return;
            }
            ToastUtil.a().j(this, getResources().getString(R$string.common_business_str_hint_input_phone_num));
            return;
        }
        ToastUtil.a().j(this, getResources().getString(R$string.common_business_str_hint_input_consignee_name));
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118602494")) {
            ipChange.ipc$dispatch("2118602494", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2023439404") ? ((Integer) ipChange.ipc$dispatch("2023439404", new Object[]{this})).intValue() : R$layout.commonbusiness_activity_add_modify_address;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735080655")) {
            ipChange.ipc$dispatch("735080655", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1611442372")) {
            ipChange.ipc$dispatch("-1611442372", new Object[]{this});
        } else {
            ((AddAddressPresenter) this.mPresenter).setVM(this, (AddAddressContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94378465")) {
            ipChange.ipc$dispatch("94378465", new Object[]{this});
            return;
        }
        initIntentData();
        initViews();
        initListeners();
        setupListeners();
        initViewData();
        executeDivisionDataRequest(2, "1");
    }

    public boolean isNumeric(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1991445665") ? ((Boolean) ipChange.ipc$dispatch("-1991445665", new Object[]{this, str})).booleanValue() : Pattern.compile("[0-9]*").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Parcelable parcelableExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19334776")) {
            ipChange.ipc$dispatch("-19334776", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 17) {
                if (intent != null) {
                    setSelectedContact(intent.getData());
                }
            } else if (i != 19) {
                if (i == 18) {
                    executeSaveShippingAddressRequest();
                }
            } else if (intent == null || (parcelableExtra = intent.getParcelableExtra("selected_phone_allowable")) == null) {
            } else {
                setSelectAreaCode((PhoneAllowableBean) parcelableExtra);
            }
        }
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onAddShippingAddressError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "905347364")) {
            ipChange.ipc$dispatch("905347364", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        y3.f().h(false);
        ToastUtil.a().j(this, str2);
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onAddShippingAddressSuccess(AddAddressResultBean addAddressResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "441153073")) {
            ipChange.ipc$dispatch("441153073", new Object[]{this, addAddressResultBean});
            return;
        }
        stopProgressDialog();
        y3.f().h(true);
        processAddModifyAddressSuccess(addAddressResultBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853995705")) {
            ipChange.ipc$dispatch("853995705", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(y3.f().g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29960647")) {
            ipChange.ipc$dispatch("-29960647", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977631230")) {
            ipChange.ipc$dispatch("1977631230", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "945820759")) {
            ipChange.ipc$dispatch("945820759", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onModifyShippingAddressError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-161492817")) {
            ipChange.ipc$dispatch("-161492817", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        y3.f().h(false);
        ToastUtil.a().j(this, str2);
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onModifyShippingAddressSuccess(AddAddressResultBean addAddressResultBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086065914")) {
            ipChange.ipc$dispatch("-2086065914", new Object[]{this, addAddressResultBean});
            return;
        }
        stopProgressDialog();
        y3.f().h(true);
        processAddModifyAddressSuccess(addAddressResultBean);
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onRetrieveDivisionChildrenError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344674617")) {
            ipChange.ipc$dispatch("-1344674617", new Object[]{this, str, str2});
        } else {
            ToastUtil.a().j(this, str2);
        }
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onRetrieveDivisionChildrenSuccess(int i, DivisionListBean divisionListBean) {
        List<DivisionBean> model;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "638172672")) {
            ipChange.ipc$dispatch("638172672", new Object[]{this, Integer.valueOf(i), divisionListBean});
        } else if (divisionListBean == null || (model = divisionListBean.getModel()) == null || model.size() <= 0) {
        } else {
            processRetrievedDivisionData(i, model);
        }
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onRetrievePhoneAllowableError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146778704")) {
            ipChange.ipc$dispatch("2146778704", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        ToastUtil.a().j(this, str2);
    }

    @Override // cn.damai.commonbusiness.address.contract.AddAddressContract.View
    public void onRetrievePhoneAllowableSuccess(PhoneAllowableResult phoneAllowableResult) {
        ArrayList<PhoneAllowableBean> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635058093")) {
            ipChange.ipc$dispatch("-635058093", new Object[]{this, phoneAllowableResult});
            return;
        }
        stopProgressDialog();
        if (phoneAllowableResult == null || (arrayList = phoneAllowableResult.result) == null || arrayList.isEmpty()) {
            return;
        }
        this.mPhoneAllowableBeanList = phoneAllowableResult.result;
        openAreaCodeListPage();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592812640")) {
            return (String) ipChange.ipc$dispatch("-592812640", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456402047")) {
            ipChange.ipc$dispatch("1456402047", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47190907")) {
            ipChange.ipc$dispatch("47190907", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197513247")) {
            ipChange.ipc$dispatch("197513247", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151898534")) {
            ipChange.ipc$dispatch("-1151898534", new Object[]{this});
        }
    }
}
