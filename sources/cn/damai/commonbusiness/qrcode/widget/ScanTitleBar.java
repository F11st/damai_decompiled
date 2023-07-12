package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.qrcode.QRCodeActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScanTitleBar extends RelativeLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mAlbumBtn;
    private OnScanTitleBarClickListener mOnScanTitleBarClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnScanTitleBarClickListener {
        void onAlbumClicked();
    }

    public ScanTitleBar(Context context) {
        this(context, null);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936616752")) {
            ipChange.ipc$dispatch("1936616752", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R$layout.scan_title_bar, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R$id.btn_album);
        this.mAlbumBtn = textView;
        textView.setOnClickListener(this);
        findViewById(R$id.show_qrcode).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38247439")) {
            ipChange.ipc$dispatch("-38247439", new Object[]{this, view});
        } else if (view.getId() == R$id.btn_album) {
            OnScanTitleBarClickListener onScanTitleBarClickListener = this.mOnScanTitleBarClickListener;
            if (onScanTitleBarClickListener != null) {
                onScanTitleBarClickListener.onAlbumClicked();
            }
        } else if (view.getId() == R$id.show_qrcode) {
            Intent intent = new Intent();
            intent.setClass(getContext(), QRCodeActivity.class);
            getContext().startActivity(intent);
        }
    }

    public void setOnScanTitleBarClickListener(OnScanTitleBarClickListener onScanTitleBarClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336017184")) {
            ipChange.ipc$dispatch("336017184", new Object[]{this, onScanTitleBarClickListener});
        } else {
            this.mOnScanTitleBarClickListener = onScanTitleBarClickListener;
        }
    }

    public ScanTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
