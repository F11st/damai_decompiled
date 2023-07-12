package cn.damai.commonbusiness.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.R$style;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DMGiftDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private DMIconFontTextView f;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2144023645")) {
                ipChange.ipc$dispatch("2144023645", new Object[]{this, view});
            } else {
                DMGiftDialog.this.dismiss();
            }
        }
    }

    public DMGiftDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394807318")) {
            ipChange.ipc$dispatch("-1394807318", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.damai_gift_dialog, (ViewGroup) null);
        this.a = inflate.findViewById(R$id.damai_theme_dialog_top_image_bg);
        this.b = (TextView) inflate.findViewById(R$id.damai_theme_dialog_title);
        this.d = (TextView) inflate.findViewById(R$id.damai_theme_dialog_tip_content);
        this.c = (TextView) inflate.findViewById(R$id.damai_theme_dialog_gift_price);
        this.e = (TextView) inflate.findViewById(R$id.damai_theme_dialog_confirm_btn);
        this.f = (DMIconFontTextView) inflate.findViewById(R$id.damai_theme_dialog_close_btn);
        inflate.findViewById(R$id.damai_theme_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (DisplayMetrics.getheightPixels(q60.b(getContext())) * 0.05d)));
        setContentView(inflate);
        a aVar = new a();
        this.e.setOnClickListener(aVar);
        this.f.setOnClickListener(aVar);
    }

    public void b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253693266")) {
            ipChange.ipc$dispatch("1253693266", new Object[]{this, str});
        } else {
            this.d.setText(str);
        }
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252252562")) {
            ipChange.ipc$dispatch("252252562", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            if (str.length() >= 3) {
                this.c.setTextSize(1, 48.0f);
            } else {
                this.c.setTextSize(1, 54.0f);
            }
            this.c.setText(str);
        }
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527749149")) {
            ipChange.ipc$dispatch("-527749149", new Object[]{this, str});
        } else {
            this.b.setText(str);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562166527")) {
            ipChange.ipc$dispatch("-562166527", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1805507056")) {
            ipChange.ipc$dispatch("-1805507056", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "221098690")) {
            ipChange.ipc$dispatch("221098690", new Object[]{this});
        } else {
            super.show();
        }
    }

    public DMGiftDialog(@NonNull Context context, int i) {
        super(context, i);
        a();
    }
}
