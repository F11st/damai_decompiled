package tb;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$style;
import com.alibaba.pictures.bricks.view.TDialog;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class i80 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TDialog a;

        a(TDialog tDialog) {
            this.a = tDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-739090034")) {
                ipChange.ipc$dispatch("-739090034", new Object[]{this, view});
            } else {
                this.a.dismiss();
            }
        }
    }

    public static Dialog a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213663770")) {
            return (Dialog) ipChange.ipc$dispatch("-1213663770", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.bricks_dna_popup_window, (ViewGroup) null);
        TDialog tDialog = new TDialog(context, R$style.transparent_dialog_style);
        tDialog.setContentView(inflate);
        tDialog.setCanceledOnTouchOutside(false);
        tDialog.g(4);
        int a2 = xr2.a(context, Double.valueOf(xr2.b(context) * 0.75d).intValue(), 62, 105, 250);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, (a2 * 251) / SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.homepage_popup_window_dna);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new a(tDialog));
        return tDialog;
    }
}
