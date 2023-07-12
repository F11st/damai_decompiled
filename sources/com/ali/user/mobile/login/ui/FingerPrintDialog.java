package com.ali.user.mobile.login.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.callback.FingerCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.login.service.impl.FingerprintLoginServiceImpl;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.ali.user.mobile.verify.VerifyApi;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FingerPrintDialog extends DialogFragment {
    public static final int ERROR_CANCEL = 4002;
    public static final int ERROR_EXCEPTION = 4001;
    public static final int ERROR_OTHER = 4023;
    public static final int STATUS_IV = 3;
    public static final int STATUS_LOGIN = 1;
    public static final int STATUS_SET = 2;
    protected TextView mCancelButton;
    public CommonCallback mCommonCallback;
    protected TextView mMessage;
    protected TextView mOKButton;
    protected View mSplitLine;
    public String TAG = "login.finger";
    protected boolean transparent = false;
    protected int status = 2;

    public FingerPrintDialog(CommonCallback commonCallback) {
        this.mCommonCallback = commonCallback;
    }

    protected void afterAuthenticatedSucceed() {
        close();
        CommonCallback commonCallback = this.mCommonCallback;
        if (commonCallback != null) {
            commonCallback.onSuccess();
        }
    }

    protected void changeStatus(int i) {
        this.status = i;
        if (i == 1) {
            startListen();
            this.mCancelButton.setText(R.string.aliuser_confirm_cancel);
            this.mMessage.setText(getActivity().getString(R.string.aliuser_fingerprint_login_tips));
            this.mSplitLine.setVisibility(8);
            this.mOKButton.setVisibility(8);
        } else if (i == 2) {
            startListen();
            this.mCancelButton.setText(R.string.aliuser_confirm_cancel);
            this.mMessage.setText(R.string.aliuser_fingerprint_check);
            this.mSplitLine.setVisibility(8);
            this.mOKButton.setVisibility(8);
        } else if (i != 3) {
        } else {
            startListen();
            this.mCancelButton.setText(R.string.aliuser_confirm_cancel);
            this.mMessage.setText(getActivity().getString(R.string.ali_fingerprint_iv));
            this.mSplitLine.setVisibility(8);
            this.mOKButton.setVisibility(8);
        }
    }

    protected void close() {
        try {
            dismissAllowingStateLoss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    protected int getLayoutContent() {
        return R.layout.aliuser_fragment_fingerprint_dialog;
    }

    public String getPageName() {
        return "";
    }

    public String getPageSpm() {
        return "";
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        onCancelClick();
    }

    protected void onCancelClick() {
        CommonCallback commonCallback = this.mCommonCallback;
        if (commonCallback != null) {
            commonCallback.onFail(4002, "指纹验证取消");
        }
        close();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        try {
            View inflate = layoutInflater.inflate(getLayoutContent(), viewGroup);
            this.mSplitLine = inflate.findViewById(R.id.passport_button_split_line);
            this.mOKButton = (TextView) inflate.findViewById(R.id.passport_button_ok);
            this.mCancelButton = (TextView) inflate.findViewById(R.id.passport_button_cancel);
            this.mMessage = (TextView) inflate.findViewById(R.id.passport_dialog_message);
            this.mCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.FingerPrintDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FingerPrintDialog.this.onCancelClick();
                }
            });
            this.mOKButton.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.FingerPrintDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new HashMap().put("spm", "a2h21.12566855.1.2");
                    FingerPrintDialog.this.changeStatus(2);
                }
            });
            try {
                if (getArguments() != null) {
                    this.status = getArguments().getInt("status");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            changeStatus(this.status);
            return inflate;
        } catch (Throwable th2) {
            String str = this.TAG;
            TLogAdapter.e(str, getPageName() + " inflate layout error", th2);
            UserTrackAdapter.sendUT(getPageName(), "Inflate_Layout_Error", "ERROR", "", null);
            FingerprintLoginServiceImpl.getInstance().disableFingerprintLogin();
            CommonCallback commonCallback = this.mCommonCallback;
            if (commonCallback != null) {
                commonCallback.onFail(4001, "创建指纹识别框失败");
            }
            return null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 17;
        getDialog().getWindow().setAttributes(attributes);
        if (this.transparent) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.aliuser_half_transparent_background)));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        if (this.transparent) {
            getView().setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.aliuser_menu_out));
        }
        super.onStop();
        stopListen();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException unused) {
        }
    }

    public void showOther() {
        if (this.status == 3) {
            try {
                this.mSplitLine.setVisibility(0);
                this.mOKButton.setVisibility(0);
                this.mOKButton.setText(getActivity().getString(R.string.ali_fingerprint_other_iv));
                this.mOKButton.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.mobile.login.ui.FingerPrintDialog.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FingerPrintDialog fingerPrintDialog = FingerPrintDialog.this;
                        CommonCallback commonCallback = fingerPrintDialog.mCommonCallback;
                        if (commonCallback != null) {
                            commonCallback.onFail(FingerPrintDialog.ERROR_OTHER, fingerPrintDialog.getActivity().getString(R.string.ali_fingerprint_other_iv));
                        }
                        FingerPrintDialog.this.close();
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @TargetApi(23)
    public void startListen() {
        new CoordinatorWrapper().execute(new Runnable() { // from class: com.ali.user.mobile.login.ui.FingerPrintDialog.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintStart", "startListen", String.valueOf(FingerPrintDialog.this.status), null);
                    ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).authenticate(new FingerCallback() { // from class: com.ali.user.mobile.login.ui.FingerPrintDialog.4.1
                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationError(int i, CharSequence charSequence) {
                            FingerPrintDialog.this.showOther();
                            if (5 == i || i >= 7) {
                                if (7 == i) {
                                    FingerPrintDialog.this.mMessage.setText(R.string.aliuser_fingerprint_try_later);
                                } else if (100 == i) {
                                    FingerPrintDialog fingerPrintDialog = FingerPrintDialog.this;
                                    int i2 = fingerPrintDialog.status;
                                    if (i2 == 2) {
                                        fingerPrintDialog.mMessage.setText(R.string.aliuser_fingerprint_open_error);
                                    } else if (i2 == 1) {
                                        fingerPrintDialog.mMessage.setText(R.string.aliuser_finger_login_changed);
                                    } else {
                                        fingerPrintDialog.mMessage.setText(R.string.aliuser_finger_iv_changed);
                                    }
                                    VerifyApi.invalidAll();
                                }
                            } else if (charSequence != null) {
                                FingerPrintDialog.this.mMessage.setText(charSequence.toString());
                            }
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintFailed", "onAuthenticationError", String.valueOf(FingerPrintDialog.this.status), null);
                        }

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationFailed() {
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintFailed", "onAuthenticationFailed", String.valueOf(FingerPrintDialog.this.status), null);
                            FingerPrintDialog.this.mMessage.setText(R.string.aliuser_fingerprint_not_match);
                        }

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationHelp(int i, CharSequence charSequence) {
                            if (i < 1000 && !TextUtils.isEmpty(charSequence)) {
                                FingerPrintDialog.this.mMessage.setText(charSequence.toString());
                            }
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintFailed", "onAuthenticationHelp", String.valueOf(FingerPrintDialog.this.status), null);
                        }

                        @Override // com.ali.user.mobile.callback.FingerCallback
                        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintSuccess", "onAuthenticationSucceeded", String.valueOf(FingerPrintDialog.this.status), null);
                            FingerPrintDialog.this.afterAuthenticatedSucceed();
                        }
                    });
                } catch (Throwable th) {
                    th.printStackTrace();
                    MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.login.ui.FingerPrintDialog.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FingerPrintDialog fingerPrintDialog = FingerPrintDialog.this;
                            int i = fingerPrintDialog.status;
                            if (i == 2) {
                                fingerPrintDialog.mMessage.setText(R.string.aliuser_fingerprint_open_error);
                            } else if (i == 1) {
                                fingerPrintDialog.mMessage.setText(R.string.aliuser_fingerprint_try_other);
                            } else {
                                fingerPrintDialog.mMessage.setText(R.string.aliuser_fingerprint_iv_try_other);
                            }
                            FingerPrintDialog.this.showOther();
                        }
                    });
                    try {
                        UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "FingerPrintException", th.getLocalizedMessage(), String.valueOf(FingerPrintDialog.this.status), null);
                        TLogAdapter.e(FingerPrintDialog.this.TAG, th);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        UserTrackAdapter.sendUT("FingerPrintException", th.getLocalizedMessage());
                        TLogAdapter.e(FingerPrintDialog.this.TAG, th);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        });
    }

    public void stopListen() {
        ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).cancelIdentify();
    }
}
