package com.taobao.login4android.scan;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.BaseLogonFragment;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.scan.impl.ScanServiceImpl;
import com.ali.user.mobile.scan.model.CommonScanParam;
import com.ali.user.mobile.scan.model.CommonScanResponse;
import com.ali.user.mobile.scan.model.CommonScanResult;
import com.ali.user.mobile.utils.BundleUtil;
import com.ali.user.mobile.utils.LoadImageTask;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.login4android.Login;
import com.taobao.login4android.sdk.R;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class QrScanFragment extends BaseLogonFragment implements View.OnClickListener {
    public static final String TAG = "login.qrScanFragment";
    protected FragmentActivity mAttachedActivity;
    protected Button mCancelButton;
    protected Button mConfirmButton;
    protected String mConfirmMsg;
    protected ImageView mHintImageView;
    protected String mScanKey;
    protected TextView mScanSubTitleView;
    protected TextView mScanTitleTextView;
    protected int mSessionExpiredCount = 0;
    protected String mUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements RpcRequestCallback {
        a() {
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse rpcResponse) {
            QrScanFragment.this.onRequestError(rpcResponse);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse rpcResponse) {
            FragmentActivity fragmentActivity = QrScanFragment.this.mAttachedActivity;
            if (fragmentActivity == null || fragmentActivity.isFinishing() || rpcResponse == null) {
                return;
            }
            CommonScanResponse commonScanResponse = (CommonScanResponse) rpcResponse;
            int i = commonScanResponse.code;
            if (i != 3000) {
                if (i == 14034) {
                    QrScanFragment.this.handleSessionExpired();
                    return;
                } else if ("H5".equals(commonScanResponse.actionType)) {
                    QrScanFragment.this.handleH5(commonScanResponse);
                    return;
                } else if (QrScanFragment.this.handleIntercept(commonScanResponse)) {
                    return;
                } else {
                    if (!TextUtils.isEmpty(commonScanResponse.message)) {
                        QrScanFragment.this.alertMessage(commonScanResponse);
                        return;
                    }
                    QrScanFragment qrScanFragment = QrScanFragment.this;
                    qrScanFragment.toast(qrScanFragment.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
                    return;
                }
            }
            T t = commonScanResponse.returnValue;
            if (t != 0) {
                String str = ((CommonScanResult) t).titleMsg;
                String str2 = ((CommonScanResult) t).subTitleMsg;
                QrScanFragment.this.mConfirmMsg = ((CommonScanResult) t).confirmMsg;
                if (!TextUtils.isEmpty(str)) {
                    QrScanFragment.this.mScanTitleTextView.setText(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    QrScanFragment.this.mScanSubTitleView.setText(str2);
                }
                QrScanFragment qrScanFragment2 = QrScanFragment.this;
                TextView textView = qrScanFragment2.mScanSubTitleView;
                Resources resources = qrScanFragment2.mAttachedActivity.getResources();
                QrScanFragment qrScanFragment3 = QrScanFragment.this;
                textView.setTextColor(resources.getColor(qrScanFragment3.getSubTitleTextColor(!TextUtils.isEmpty(qrScanFragment3.mConfirmMsg))));
                QrScanFragment.this.updateLogo(((CommonScanResult) commonScanResponse.returnValue).logoUrl);
                return;
            }
            QrScanFragment qrScanFragment4 = QrScanFragment.this;
            qrScanFragment4.toast(qrScanFragment4.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse rpcResponse) {
            onError(rpcResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            QrScanFragment.this.mAttachedActivity.finish();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            QrScanFragment.this.handleConfirm();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            QrScanFragment.this.dismissAlertDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class e implements RpcRequestCallback {
        e() {
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse rpcResponse) {
            QrScanFragment.this.onRequestError(rpcResponse);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse rpcResponse) {
            FragmentActivity fragmentActivity = QrScanFragment.this.mAttachedActivity;
            if (fragmentActivity == null || fragmentActivity.isFinishing() || rpcResponse == null) {
                return;
            }
            CommonScanResponse commonScanResponse = (CommonScanResponse) rpcResponse;
            int i = commonScanResponse.code;
            if (i == 3000) {
                QrScanFragment.this.mAttachedActivity.setResult(-1);
                QrScanFragment.this.mAttachedActivity.finish();
            } else if (i == 14034) {
                QrScanFragment.this.handleSessionExpired();
            } else if ("H5".equals(commonScanResponse.actionType)) {
                QrScanFragment.this.handleH5(commonScanResponse);
            } else if (QrScanFragment.this.handleIntercept(commonScanResponse)) {
            } else {
                if (!TextUtils.isEmpty(commonScanResponse.message)) {
                    QrScanFragment.this.alertMessage(commonScanResponse);
                    return;
                }
                QrScanFragment qrScanFragment = QrScanFragment.this;
                qrScanFragment.toast(qrScanFragment.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
            }
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse rpcResponse) {
            onError(rpcResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class f implements RpcRequestCallback {
        f() {
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse rpcResponse) {
            onSuccess(rpcResponse);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse rpcResponse) {
            FragmentActivity fragmentActivity = QrScanFragment.this.mAttachedActivity;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                return;
            }
            QrScanFragment.this.mAttachedActivity.finish();
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse rpcResponse) {
            onSuccess(rpcResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alertMessage(CommonScanResponse commonScanResponse) {
        if (commonScanResponse == null || TextUtils.isEmpty(commonScanResponse.message)) {
            return;
        }
        alertMessage(commonScanResponse.message);
    }

    private CommonScanParam getCommonScanParam() {
        Bundle serialBundle;
        CommonScanParam commonScanParam = new CommonScanParam();
        commonScanParam.appName = DataProviderFactory.getDataProvider().getAppkey();
        commonScanParam.havanaId = Login.getUserId();
        commonScanParam.sid = Login.getSid();
        commonScanParam.currentSite = Login.getLoginSite();
        if (TextUtils.isEmpty(this.mUrl)) {
            return null;
        }
        if (TextUtils.isEmpty(this.mScanKey) && (serialBundle = BundleUtil.serialBundle(Uri.parse(this.mUrl).getQuery())) != null) {
            this.mScanKey = serialBundle.getString("lgToken");
        }
        commonScanParam.key = this.mScanKey;
        return commonScanParam;
    }

    @Override // com.ali.user.mobile.base.BaseLogonFragment
    protected void doWhenReceiveSuccess() {
        drawView();
    }

    protected void drawView() {
        this.mHintImageView.setImageResource(getHitImageResource());
        if (this.mUrl != null) {
            ScanServiceImpl.getInstance().commonScanWithRemoteBiz(getCommonScanParam(), new a());
        }
    }

    protected int getHitImageResource() {
        return R.drawable.aliuser_scan_default_bg;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    protected int getLayoutContent() {
        return R.layout.ali_user_scan_fragment;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, com.ali.user.mobile.login.ui.BaseLoginView
    public String getPageName() {
        return "Page_LoginConfirm";
    }

    protected int getSubTitleTextColor(boolean z) {
        if (z) {
            return R.color.aliuser_cancel_red;
        }
        return R.color.aliuser_color_ccc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBack() {
        ScanServiceImpl.getInstance().commonCancelWithRemoteBiz(getCommonScanParam(), new f());
    }

    protected void handleConfirm() {
        ScanServiceImpl.getInstance().commonConfirmWithRemoteBiz(getCommonScanParam(), new e());
    }

    protected void handleH5(CommonScanResponse commonScanResponse) {
        T t = commonScanResponse.returnValue;
        if (t != 0) {
            if (!TextUtils.isEmpty(((CommonScanResult) t).h5Url)) {
                Login.openUrl(this.mAttachedActivity, ((CommonScanResult) commonScanResponse.returnValue).h5Url);
                this.mAttachedActivity.finish();
                return;
            } else if (!TextUtils.isEmpty(commonScanResponse.message)) {
                alertMessage(commonScanResponse);
                return;
            } else {
                toast(this.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
                return;
            }
        }
        toast(this.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
    }

    protected boolean handleIntercept(CommonScanResponse commonScanResponse) {
        return false;
    }

    protected void handleSessionExpired() {
        int i = this.mSessionExpiredCount + 1;
        this.mSessionExpiredCount = i;
        if (i <= 20) {
            Login.login(true);
        } else {
            alertMessage(this.mAttachedActivity.getResources().getString(R.string.aliuser_login_exception));
        }
    }

    protected void initParams() {
        FragmentActivity fragmentActivity;
        try {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mUrl = (String) arguments.get(LoginConstant.SCAN_KEY);
            }
            if (!TextUtils.isEmpty(this.mUrl) || (fragmentActivity = this.mAttachedActivity) == null) {
                return;
            }
            fragmentActivity.finish();
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public void initViews(View view) {
        TLogAdapter.d(TAG, "initViews");
        Button button = (Button) view.findViewById(R.id.aliuser_scan_confirmButton);
        this.mConfirmButton = button;
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.aliuser_scan_cancelButton);
        this.mCancelButton = button2;
        button2.setOnClickListener(this);
        this.mHintImageView = (ImageView) view.findViewById(R.id.aliuser_scan_bg_imageview);
        this.mScanTitleTextView = (TextView) view.findViewById(R.id.aliuser_scan_textview);
        this.mScanSubTitleView = (TextView) view.findViewById(R.id.aliuser_scan_subTitleTextView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        TLogAdapter.d(TAG, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
        super.onActivityCreated(bundle);
        drawView();
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        TLogAdapter.d(TAG, "onAttach");
        super.onAttach(activity);
        this.mAttachedActivity = (QrScanActivity) activity;
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment
    public boolean onBackPressed() {
        handleBack();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.aliuser_scan_confirmButton) {
            UserTrackAdapter.sendControlUT(getPageName(), "Confirm_Click");
            if (TextUtils.isEmpty(this.mConfirmMsg)) {
                handleConfirm();
            } else {
                alert("", this.mConfirmMsg, this.mAttachedActivity.getResources().getString(R.string.aliuser_confirm), new c(), this.mAttachedActivity.getResources().getString(R.string.aliuser_cancel), new d());
            }
        } else if (id == R.id.aliuser_scan_cancelButton) {
            UserTrackAdapter.sendControlUT(getPageName(), "Cancel_Click");
            handleBack();
        }
    }

    @Override // com.ali.user.mobile.base.BaseLogonFragment, com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Login.checkSessionValid()) {
            return;
        }
        Login.login(true);
    }

    @Override // com.ali.user.mobile.base.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutContent(), viewGroup, false);
        initViews(inflate);
        initParams();
        return inflate;
    }

    @Override // com.ali.user.mobile.base.BaseLogonFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHintImageView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        UserTrackAdapter.pageDisAppear(getActivity());
    }

    protected void onRequestError(RpcResponse rpcResponse) {
        FragmentActivity fragmentActivity = this.mAttachedActivity;
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return;
        }
        if (rpcResponse instanceof CommonScanResponse) {
            CommonScanResponse commonScanResponse = (CommonScanResponse) rpcResponse;
            if (!TextUtils.isEmpty(commonScanResponse.message)) {
                alertMessage(commonScanResponse);
                return;
            } else {
                toast(this.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
                return;
            }
        }
        toast(this.mAttachedActivity.getResources().getString(R.string.aliuser_network_error), 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(getActivity(), getPageName());
    }

    protected void updateLogo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new LoadImageTask(this.mAttachedActivity.getApplicationContext(), this.mHintImageView, "LogoImages", 800).execute(str);
    }

    private void alertMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        alert("", str, this.mAttachedActivity.getResources().getString(R.string.aliuser_confirm), new b(), null, null);
    }
}
