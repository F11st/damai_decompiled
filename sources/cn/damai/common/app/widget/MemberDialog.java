package cn.damai.common.app.widget;

import android.view.View;
import android.widget.TextView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$string;
import cn.damai.uikit.util.TDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class MemberDialog extends TDialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView h;
    private ActionListener i;
    private boolean j;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface ActionListener extends TDialog.OnDialogShowTimeListener {
        void onAgreeClick(boolean z);

        @Deprecated
        void onCloseClick();

        void onProtocolCheckChanged(boolean z);

        void onProtocolClick(String str);

        void onRejectClick();
    }

    private boolean i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "845888286") ? ((Boolean) ipChange.ipc$dispatch("845888286", new Object[]{this})).booleanValue() : this.j;
    }

    private void j(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1124581543")) {
            ipChange.ipc$dispatch("1124581543", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.j = z;
        if (z) {
            this.h.setText(R$string.iconfont_danxuanxuanzhong16);
        } else {
            this.h.setText(R$string.iconfont_weixuan16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490563012")) {
            ipChange.ipc$dispatch("490563012", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == R$id.dma_protocol_check_click_btn) {
            j(!i());
            this.i.onProtocolCheckChanged(i());
        } else if (id == R$id.dma_agree_btn) {
            if (i()) {
                dismiss();
            }
            this.i.onAgreeClick(i());
        } else if (id == R$id.dma_reject_btn) {
            dismiss();
            this.i.onRejectClick();
        }
    }
}
