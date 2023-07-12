package com.youku.live.livesdk.widgets.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.R;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class InterceptDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView bgImgView;
    private ImageView closeImageView;
    private View dialogView;
    private View dismissArea;
    private ImageView leftBtnImgView;
    private OnButtonClickListener listener;
    private ImageView rightBtnImgView;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnButtonClickListener {
        void onCloseButtonClick(boolean z);

        void onLeftButtonClick();

        void onRightButtonClick();
    }

    public InterceptDialog(@NonNull Context context) {
        super(context, R.C7961style.lfcontainer_DialogStyleCommon);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390951291")) {
            ipChange.ipc$dispatch("390951291", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.C7960layout.dago_dialog_intercept, (ViewGroup) null);
        this.dialogView = inflate;
        this.bgImgView = (ImageView) inflate.findViewById(R.id.dago_dialog_intercept_bg);
        this.leftBtnImgView = (ImageView) this.dialogView.findViewById(R.id.dago_dialog_intercept_left_btn);
        this.rightBtnImgView = (ImageView) this.dialogView.findViewById(R.id.dago_dialog_intercept_right_btn);
        this.closeImageView = (ImageView) this.dialogView.findViewById(R.id.dago_dialog_intercept_close_btn);
        this.dismissArea = this.dialogView.findViewById(R.id.dago_dialog_intercept_dismiss_area);
        this.leftBtnImgView.setOnClickListener(this);
        this.rightBtnImgView.setOnClickListener(this);
        this.closeImageView.setOnClickListener(this);
        this.dismissArea.setOnClickListener(this);
    }

    private void setDialogWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207593472")) {
            ipChange.ipc$dispatch("1207593472", new Object[]{this});
            return;
        }
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484748639")) {
            ipChange.ipc$dispatch("-484748639", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R.id.dago_dialog_intercept_left_btn) {
            OnButtonClickListener onButtonClickListener = this.listener;
            if (onButtonClickListener != null) {
                onButtonClickListener.onLeftButtonClick();
            }
        } else if (id == R.id.dago_dialog_intercept_right_btn) {
            OnButtonClickListener onButtonClickListener2 = this.listener;
            if (onButtonClickListener2 != null) {
                onButtonClickListener2.onRightButtonClick();
            }
        } else if (id == R.id.dago_dialog_intercept_close_btn) {
            OnButtonClickListener onButtonClickListener3 = this.listener;
            if (onButtonClickListener3 != null) {
                onButtonClickListener3.onCloseButtonClick(true);
            }
            dismiss();
        } else if (id == R.id.dago_dialog_intercept_dismiss_area) {
            OnButtonClickListener onButtonClickListener4 = this.listener;
            if (onButtonClickListener4 != null) {
                onButtonClickListener4.onCloseButtonClick(false);
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219547425")) {
            ipChange.ipc$dispatch("-1219547425", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setContentView(this.dialogView);
        setDialogWindow();
    }

    public void setData(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2057578188")) {
            ipChange.ipc$dispatch("2057578188", new Object[]{this, str, str2, str3});
            return;
        }
        if (this.bgImgView != null) {
            ur1.o().s(str).y(this.bgImgView);
        }
        if (this.leftBtnImgView != null) {
            ur1.o().s(str2).y(this.leftBtnImgView);
        }
        if (this.rightBtnImgView != null) {
            ur1.o().s(str3).y(this.rightBtnImgView);
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "511406496")) {
            ipChange.ipc$dispatch("511406496", new Object[]{this, onButtonClickListener});
        } else {
            this.listener = onButtonClickListener;
        }
    }
}
