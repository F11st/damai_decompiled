package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class TorchView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnTorchClickListener onTorchClickListener;
    private TextView torchIv;
    private TextView torchTv;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnTorchClickListener {
        void onTorchStateSwitch();
    }

    public TorchView(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852631973")) {
            ipChange.ipc$dispatch("-1852631973", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.torch_layout, (ViewGroup) this, true);
        this.torchIv = (TextView) findViewById(R$id.torch_image_view);
        this.torchTv = (TextView) findViewById(R$id.torch_tips_view);
    }

    private void switchTorch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128585879")) {
            ipChange.ipc$dispatch("2128585879", new Object[]{this});
            return;
        }
        OnTorchClickListener onTorchClickListener = this.onTorchClickListener;
        if (onTorchClickListener != null) {
            onTorchClickListener.onTorchStateSwitch();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-97875748")) {
            ipChange.ipc$dispatch("-97875748", new Object[]{this, view});
        } else {
            switchTorch();
        }
    }

    public void resetState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773679913")) {
            ipChange.ipc$dispatch("773679913", new Object[]{this});
        } else {
            setVisibility(8);
        }
    }

    public void setOnTorchClickListener(OnTorchClickListener onTorchClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "938022232")) {
            ipChange.ipc$dispatch("938022232", new Object[]{this, onTorchClickListener});
        } else {
            this.onTorchClickListener = onTorchClickListener;
        }
    }

    public void showTorch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72402464")) {
            ipChange.ipc$dispatch("-72402464", new Object[]{this});
        } else {
            setVisibility(0);
        }
    }

    public void showTorchState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822385691")) {
            ipChange.ipc$dispatch("822385691", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.torchIv.setText(getResources().getString(R$string.iconfont_shoudiantong24));
        } else {
            this.torchIv.setText(getResources().getString(R$string.iconfont_shoudiantongkai24));
        }
    }

    public TorchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setOnClickListener(this);
        setGravity(1);
        init();
    }
}
