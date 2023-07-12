package cn.damai.common.askpermission;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class PermissionPop extends PopupWindow {

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.askpermission.PermissionPop$a */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0484a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0484a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-213003571")) {
                ipChange.ipc$dispatch("-213003571", new Object[]{this, view});
            } else {
                PermissionPop.this.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.askpermission.PermissionPop$b */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0485b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        View$OnClickListenerC0485b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1898286798")) {
                ipChange.ipc$dispatch("1898286798", new Object[]{this, view});
                return;
            }
            PermissionPop.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.askpermission.PermissionPop$c */
    /* loaded from: classes13.dex */
    public class View$OnKeyListenerC0486c implements View.OnKeyListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnKeyListenerC0486c(PermissionPop permissionPop) {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1450118979") ? ((Boolean) ipChange.ipc$dispatch("1450118979", new Object[]{this, view, Integer.valueOf(i), keyEvent})).booleanValue() : i == 4;
        }
    }

    public PermissionPop(Context context, CharSequence charSequence, boolean z, View.OnClickListener onClickListener) {
        super(context);
        setWidth(-1);
        setHeight(-1);
        View inflate = LayoutInflater.from(context).inflate(R$layout.pop, (ViewGroup) null);
        setContentView(inflate);
        ((TextView) inflate.findViewById(R$id.pop_tv)).setText(charSequence);
        View findViewById = inflate.findViewById(R$id.close);
        View findViewById2 = inflate.findViewById(R$id.confirm);
        findViewById.setVisibility(z ? 0 : 8);
        findViewById.setOnClickListener(new View$OnClickListenerC0484a());
        findViewById2.setOnClickListener(new View$OnClickListenerC0485b(onClickListener));
        inflate.setOnKeyListener(new View$OnKeyListenerC0486c(this));
        setBackgroundDrawable(new ColorDrawable(1426063360));
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(-1);
    }
}
