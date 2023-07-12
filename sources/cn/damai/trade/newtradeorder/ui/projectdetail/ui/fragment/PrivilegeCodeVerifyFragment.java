package cn.damai.trade.newtradeorder.ui.projectdetail.ui.fragment;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuActivity;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.bean.PrivilegeVerifyBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.contract.PrivilegeCodeVerifyContract;
import cn.damai.trade.newtradeorder.ui.projectdetail.model.PrivilegeCodeVerifyModel;
import cn.damai.trade.newtradeorder.ui.projectdetail.presenter.PrivilegeCodeVerifyPresenter;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;
import tb.cb1;
import tb.o6;
import tb.pp2;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PrivilegeCodeVerifyFragment extends DamaiBaseMvpFragment<PrivilegeCodeVerifyPresenter, PrivilegeCodeVerifyModel> implements PrivilegeCodeVerifyContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = PrivilegeCodeVerifyFragment.class.getSimpleName();
    private int mBuyType;
    private EditText mEtPrivilegeCodeInput;
    private FrameLayout mFlBottomView;
    private String mInputPrivilegeCode;
    private View.OnClickListener mOnCompleteClickListener;
    private OnCompleteListener mOnCompleteListener;
    private View.OnClickListener mOnPrivilegeCodeVerifyClickListener;
    private OnPrivilegeCodeVerifyResultListener mOnPrivilegeCodeVerifyResultListener;
    private TextWatcher mPrivilegeCodeWatcher;
    private String mPrivilegeId;
    private long mProjectId;
    private View mShadowView;
    private TextView mTvPrivilegeCodeVerify;
    private DMIconFontTextView mTvPrivilegeComplete;
    private TextView mTvPrivilegeTitle;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnPrivilegeCodeVerifyResultListener {
        void onPrivilegeCodeVerifySuccess(int i, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1835563241")) {
                ipChange.ipc$dispatch("1835563241", new Object[]{this, view});
            } else if (PrivilegeCodeVerifyFragment.this.mOnCompleteListener != null) {
                PrivilegeCodeVerifyFragment.this.closeSoftKeyboard();
                PrivilegeCodeVerifyFragment.this.mOnCompleteListener.onComplete(4);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        private int b;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1542719187")) {
                ipChange.ipc$dispatch("-1542719187", new Object[]{this, editable});
                return;
            }
            String str = PrivilegeCodeVerifyFragment.TAG;
            cb1.b(str, "afterTextChanged: " + ((Object) editable));
            this.b = PrivilegeCodeVerifyFragment.this.mEtPrivilegeCodeInput.getSelectionEnd();
            String str2 = PrivilegeCodeVerifyFragment.TAG;
            cb1.b(str2, "afterTextChanged(), editStart = " + this.a + ", editEnd = " + this.b);
            PrivilegeCodeVerifyFragment.this.removedBlankForPrivilegeCode(editable, this.a, this.b);
            if (editable == null || editable.length() <= 0) {
                PrivilegeCodeVerifyFragment.this.mTvPrivilegeCodeVerify.setEnabled(false);
                PrivilegeCodeVerifyFragment.this.mShadowView.setVisibility(8);
                PrivilegeCodeVerifyFragment.this.mTvPrivilegeCodeVerify.setOnClickListener(null);
                return;
            }
            PrivilegeCodeVerifyFragment.this.mTvPrivilegeCodeVerify.setEnabled(true);
            PrivilegeCodeVerifyFragment.this.mShadowView.setVisibility(0);
            PrivilegeCodeVerifyFragment.this.mTvPrivilegeCodeVerify.setOnClickListener(PrivilegeCodeVerifyFragment.this.mOnPrivilegeCodeVerifyClickListener);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "992442166")) {
                ipChange.ipc$dispatch("992442166", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            String str = PrivilegeCodeVerifyFragment.TAG;
            cb1.b(str, "beforeTextChanged: s = " + ((Object) charSequence) + ", start = " + i + ", count = " + i2 + ", after = " + i3);
            this.a = i;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "455685846")) {
                ipChange.ipc$dispatch("455685846", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            String str = PrivilegeCodeVerifyFragment.TAG;
            cb1.b(str, "onTextChanged: s = " + ((Object) charSequence) + ", start = " + i + ", before = " + i2 + ", count = " + i3);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1763176683")) {
                ipChange.ipc$dispatch("1763176683", new Object[]{this, view});
                return;
            }
            PrivilegeCodeVerifyFragment.this.mTvPrivilegeCodeVerify.setClickable(false);
            if (TextUtils.isEmpty(PrivilegeCodeVerifyFragment.this.mEtPrivilegeCodeInput.getText().toString())) {
                return;
            }
            PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment = PrivilegeCodeVerifyFragment.this;
            privilegeCodeVerifyFragment.mInputPrivilegeCode = privilegeCodeVerifyFragment.mEtPrivilegeCodeInput.getText().toString().trim();
            if (TextUtils.isEmpty(PrivilegeCodeVerifyFragment.this.mPrivilegeId)) {
                cn.damai.common.user.c.e().x(pp2.u().T0(PrivilegeCodeVerifyFragment.this.mProjectId, wh2.j(PrivilegeCodeVerifyFragment.this.mInputPrivilegeCode) ? "" : PrivilegeCodeVerifyFragment.this.mInputPrivilegeCode));
            } else {
                cn.damai.common.user.c.e().x(pp2.u().I0(PrivilegeCodeVerifyFragment.this.mProjectId, PrivilegeCodeVerifyFragment.this.mPrivilegeId, wh2.j(PrivilegeCodeVerifyFragment.this.mInputPrivilegeCode) ? "" : PrivilegeCodeVerifyFragment.this.mInputPrivilegeCode));
            }
            if (wh2.j(PrivilegeCodeVerifyFragment.this.mInputPrivilegeCode)) {
                ToastUtil.i(PrivilegeCodeVerifyFragment.this.getString(R$string.choose_privilege_code));
                PrivilegeCodeVerifyFragment.this.mTvPrivilegeCodeVerify.setClickable(true);
                return;
            }
            PrivilegeCodeVerifyFragment.this.startProgressDialog();
            PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment2 = PrivilegeCodeVerifyFragment.this;
            privilegeCodeVerifyFragment2.executeVerifyAndSignPrivilegeCode(privilegeCodeVerifyFragment2.mInputPrivilegeCode);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ View b;

        d(PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment, View view, View view2) {
            this.a = view;
            this.b = view2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1358551985")) {
                ipChange.ipc$dispatch("-1358551985", new Object[]{this});
                return;
            }
            Rect rect = new Rect();
            this.a.getWindowVisibleDisplayFrame(rect);
            if (this.a.getRootView().getHeight() - rect.bottom > this.a.getRootView().getHeight() / 4) {
                int[] iArr = new int[2];
                this.b.getLocationInWindow(iArr);
                this.a.scrollBy(0, (iArr[1] + this.b.getHeight()) - rect.bottom);
                return;
            }
            this.a.scrollTo(0, 0);
        }
    }

    private void addLayoutListener(View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936609440")) {
            ipChange.ipc$dispatch("1936609440", new Object[]{this, view, view2});
        } else {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, view, view2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSoftKeyboard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972254634")) {
            ipChange.ipc$dispatch("-972254634", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing()) {
        } else {
            try {
                FragmentActivity activity = getActivity();
                getActivity();
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                if (!inputMethodManager.isActive() || getActivity().getCurrentFocus().getWindowToken() == null) {
                    return;
                }
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeVerifyAndSignPrivilegeCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214638193")) {
            ipChange.ipc$dispatch("1214638193", new Object[]{this, str});
            return;
        }
        ((PrivilegeCodeVerifyPresenter) this.mPresenter).verifyAndSignPrivilegeCode(z20.E(), o6.a(getContext()), 1, this.mProjectId, 0L, str);
        cb1.b(TAG, "executeVerifyAndSignPrivilegeCode()");
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469647568")) {
            ipChange.ipc$dispatch("1469647568", new Object[]{this});
            return;
        }
        this.mOnCompleteClickListener = new a();
        this.mPrivilegeCodeWatcher = new b();
        this.mOnPrivilegeCodeVerifyClickListener = new c();
    }

    private void initViews(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825430001")) {
            ipChange.ipc$dispatch("1825430001", new Object[]{this, view});
            return;
        }
        TextView textView = (TextView) this.rootView.findViewById(R$id.project_privilege_title_tv);
        this.mTvPrivilegeTitle = textView;
        textView.setText("请输入特权码");
        this.mTvPrivilegeComplete = (DMIconFontTextView) this.rootView.findViewById(R$id.project_privilege_complete_btn_tv);
        EditText editText = (EditText) view.findViewById(R$id.project_privilege_code_input_ex);
        this.mEtPrivilegeCodeInput = editText;
        editText.setFocusable(true);
        this.mEtPrivilegeCodeInput.setFocusableInTouchMode(true);
        this.mEtPrivilegeCodeInput.requestFocus();
        this.mFlBottomView = (FrameLayout) view.findViewById(R$id.project_privilege_verify_bottom_fl);
        View findViewById = view.findViewById(R$id.project_privilege_verify_shadow_view);
        this.mShadowView = findViewById;
        findViewById.setVisibility(8);
        TextView textView2 = (TextView) view.findViewById(R$id.project_privilege_verify_tv);
        this.mTvPrivilegeCodeVerify = textView2;
        textView2.setEnabled(false);
    }

    public static PrivilegeCodeVerifyFragment newInstance(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-114967732")) {
            return (PrivilegeCodeVerifyFragment) ipChange.ipc$dispatch("-114967732", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        }
        PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment = new PrivilegeCodeVerifyFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("projectId", j);
        bundle.putInt("buyType", i);
        privilegeCodeVerifyFragment.setArguments(bundle);
        return privilegeCodeVerifyFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removedBlankForPrivilegeCode(Editable editable, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301191239")) {
            ipChange.ipc$dispatch("-1301191239", new Object[]{this, editable, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (editable == null || editable.length() <= 0) {
        } else {
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            this.mEtPrivilegeCodeInput.removeTextChangedListener(this.mPrivilegeCodeWatcher);
            String replace = obj.replace(" ", "").replace("\t", "").replace(StringUtils.LF, "").replace("\f", "").replace(StringUtils.CR, "");
            this.mEtPrivilegeCodeInput.setText(replace);
            if (replace.length() != obj.length()) {
                this.mEtPrivilegeCodeInput.setSelection(replace.length());
            } else {
                this.mEtPrivilegeCodeInput.setSelection(i2);
            }
            this.mEtPrivilegeCodeInput.addTextChangedListener(this.mPrivilegeCodeWatcher);
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199522921")) {
            ipChange.ipc$dispatch("1199522921", new Object[]{this});
            return;
        }
        this.mTvPrivilegeComplete.setOnClickListener(this.mOnCompleteClickListener);
        this.mEtPrivilegeCodeInput.addTextChangedListener(this.mPrivilegeCodeWatcher);
    }

    public void forceOpenSoftKeyboard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589508057")) {
            ipChange.ipc$dispatch("589508057", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing()) {
        } else {
            try {
                FragmentActivity activity = getActivity();
                getActivity();
                ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(1, 2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1418064420") ? ((Integer) ipChange.ipc$dispatch("1418064420", new Object[]{this})).intValue() : R$layout.trade_project_detail_privilege_code_verify_fragment;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351401188")) {
            ipChange.ipc$dispatch("351401188", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620603961")) {
            ipChange.ipc$dispatch("-620603961", new Object[]{this});
        } else {
            ((PrivilegeCodeVerifyPresenter) this.mPresenter).setVM(this, (PrivilegeCodeVerifyContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48820342")) {
            ipChange.ipc$dispatch("48820342", new Object[]{this});
            return;
        }
        initViews(this.rootView);
        initListeners();
        setupListeners();
        addLayoutListener(this.rootView, this.mFlBottomView);
        forceOpenSoftKeyboard();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1728626513")) {
            ipChange.ipc$dispatch("-1728626513", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        setDamaiUTKeyBuilder(pp2.u().i0(this.mProjectId));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847085831")) {
            ipChange.ipc$dispatch("-1847085831", new Object[]{this, activity});
            return;
        }
        super.onAttach(activity);
        try {
            if (getParentFragment() != null) {
                this.mOnCompleteListener = (OnCompleteListener) getParentFragment();
                this.mOnPrivilegeCodeVerifyResultListener = (OnPrivilegeCodeVerifyResultListener) getParentFragment();
            }
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1071568676")) {
            ipChange.ipc$dispatch("-1071568676", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063867908")) {
            ipChange.ipc$dispatch("2063867908", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mProjectId = arguments.getLong("projectId");
            this.mPrivilegeId = arguments.getString(NcovSkuActivity.KEY_PRIVILEGEID);
            this.mBuyType = arguments.getInt("buyType");
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.PrivilegeCodeVerifyContract.View
    public void onReturnVerifyPrivilegeCodeResultError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783026602")) {
            ipChange.ipc$dispatch("783026602", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        String str3 = TAG;
        cb1.b(str3, "executeVerifyAndSignPrivilegeCode(), errorCode = " + str);
        ToastUtil.i(str2);
        this.mTvPrivilegeCodeVerify.setClickable(true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.PrivilegeCodeVerifyContract.View
    public void onReturnVerifyPrivilegeCodeResultSuccess(PrivilegeVerifyBean privilegeVerifyBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732000422")) {
            ipChange.ipc$dispatch("-732000422", new Object[]{this, privilegeVerifyBean});
            return;
        }
        stopProgressDialog();
        this.mTvPrivilegeCodeVerify.setClickable(true);
        if (privilegeVerifyBean != null) {
            if ("true".equals(privilegeVerifyBean.getVerifiedSuccess())) {
                OnPrivilegeCodeVerifyResultListener onPrivilegeCodeVerifyResultListener = this.mOnPrivilegeCodeVerifyResultListener;
                if (onPrivilegeCodeVerifyResultListener != null) {
                    onPrivilegeCodeVerifyResultListener.onPrivilegeCodeVerifySuccess(this.mBuyType, privilegeVerifyBean.getSuccessActivityId());
                    return;
                }
                return;
            }
            ToastUtil.a().j(getContext(), privilegeVerifyBean.getFailedMsg());
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1847726838")) {
            ipChange.ipc$dispatch("-1847726838", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1898011322")) {
            ipChange.ipc$dispatch("-1898011322", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051436886")) {
            ipChange.ipc$dispatch("-1051436886", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164275291")) {
            ipChange.ipc$dispatch("-1164275291", new Object[]{this});
        }
    }

    public static PrivilegeCodeVerifyFragment newInstance(long j, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900073666")) {
            return (PrivilegeCodeVerifyFragment) ipChange.ipc$dispatch("900073666", new Object[]{Long.valueOf(j), str, Integer.valueOf(i)});
        }
        PrivilegeCodeVerifyFragment privilegeCodeVerifyFragment = new PrivilegeCodeVerifyFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("projectId", j);
        bundle.putString(NcovSkuActivity.KEY_PRIVILEGEID, str);
        bundle.putInt("buyType", i);
        privilegeCodeVerifyFragment.setArguments(bundle);
        return privilegeCodeVerifyFragment;
    }
}
