package com.alibaba.pictures.bricks.view;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BottomListDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnActionListener a;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
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
        if (AndroidInstantRuntime.support(ipChange, "-1430382747")) {
            ipChange.ipc$dispatch("-1430382747", new Object[]{this, view});
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
        if (AndroidInstantRuntime.support(ipChange, "665802391")) {
            ipChange.ipc$dispatch("665802391", new Object[]{this});
            return;
        }
        super.show();
        Window window = getWindow();
        Context context = getContext();
        if (window == null || window.getAttributes() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        DisplayMetrics d = s60.INSTANCE.d(context);
        if (d != null) {
            attributes.width = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(d);
        }
        window.setAttributes(attributes);
    }

    public BottomListDialog(@NonNull Context context, int i, OnActionListener onActionListener) {
        super(context, i);
        this.a = onActionListener;
        View inflate = LayoutInflater.from(context).inflate(R$layout.bricks_dialog_bottom_list, (ViewGroup) null);
        setContentView(inflate);
        inflate.findViewById(R$id.cancel_vote).setOnClickListener(this);
        inflate.findViewById(R$id.not_cancel_vote).setOnClickListener(this);
    }
}
