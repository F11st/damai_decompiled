package cn.damai.uikit.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BottomListDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnActionListener a;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnActionListener {
        void onCancelVoteClick();

        void onGiveUpClick();
    }

    public BottomListDialog(@NonNull Context context, OnActionListener onActionListener) {
        this(context, R$style.translucent_dialog_style, onActionListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "945372505")) {
            ipChange.ipc$dispatch("945372505", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.cancel_vote) {
            dismiss();
            this.a.onCancelVoteClick();
        } else if (id == R$id.not_cancel_vote) {
            dismiss();
            this.a.onGiveUpClick();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259039627")) {
            ipChange.ipc$dispatch("1259039627", new Object[]{this});
            return;
        }
        super.show();
        Window window = getWindow();
        Context context = getContext();
        if (context == null || window == null || window.getAttributes() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayMetrics.getwidthPixels(l62.b(context));
        window.setAttributes(attributes);
    }

    public BottomListDialog(@NonNull Context context, int i, OnActionListener onActionListener) {
        super(context, i);
        this.a = onActionListener;
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_bottom_list, (ViewGroup) null);
        setContentView(inflate);
        inflate.findViewById(R$id.cancel_vote).setOnClickListener(this);
        inflate.findViewById(R$id.not_cancel_vote).setOnClickListener(this);
    }
}
