package com.alibaba.pictures.bricks.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.discover.bean.GridBean;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BricksThemeDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private RoundImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private FrameLayout g;
    private ScrollView h;
    private TextView i;
    private TextView j;
    private BricksIconFontTextView k;
    private LinearLayout l;
    private MaxHeightLinearLayout m;
    private int n;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum DMDialogTheme {
        THEME_REWARD,
        THEME_COMMENT,
        THEME_SYS_UPDATE,
        THEME_LOCATION,
        THEME_NOTIFICATION,
        THEME_ORDER_FAILURE,
        THEME_PERMISSION_ALBUM,
        THEME_PERMISSION_CAMERA,
        THEME_PERMISSION_CALENDAR,
        THEME_PERMISSION_CONTACTS,
        THEME_REAL_NAME,
        THEME_TAOBAO_LOGIN,
        THEME_GUARD_SUCCESS,
        THEME_YOUKU_LIVE,
        THEME_SUPPORT_WANNA
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.BricksThemeDialog$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC3566a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        View$OnClickListenerC3566a(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-343521428")) {
                ipChange.ipc$dispatch("-343521428", new Object[]{this, view});
                return;
            }
            BricksThemeDialog.this.dismiss();
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(BricksThemeDialog.this, -2);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.BricksThemeDialog$b */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC3567b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        View$OnClickListenerC3567b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-415907986")) {
                ipChange.ipc$dispatch("-415907986", new Object[]{this, view});
                return;
            }
            BricksThemeDialog.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(BricksThemeDialog.this.i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.BricksThemeDialog$c */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC3568c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        View$OnClickListenerC3568c(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1695382383")) {
                ipChange.ipc$dispatch("1695382383", new Object[]{this, view});
                return;
            }
            BricksThemeDialog.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(BricksThemeDialog.this.j);
            }
        }
    }

    public BricksThemeDialog(@NonNull Context context) {
        this(context, R$style.BricksThemeDialogTheme);
    }

    public static int c(Context context, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809298040")) {
            return ((Integer) ipChange.ipc$dispatch("809298040", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
        }
        if (i3 == 0 || i4 == 0) {
            return 0;
        }
        s60 s60Var = s60.INSTANCE;
        int b = DisplayMetrics.getwidthPixels(s60Var.d(context)) - s60Var.b(context, i2 + i2);
        return (b * i3) / i4 >= i ? (i * i4) / i3 : b;
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132387961")) {
            ipChange.ipc$dispatch("1132387961", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.bricks_theme_dialog, (ViewGroup) null);
        this.m = (MaxHeightLinearLayout) inflate.findViewById(R$id.damai_theme_dialog_layout);
        this.a = c(getContext(), (int) (this.m.getMaxHeight() * 0.5d), 50, 220, GridBean.TYPE_PIC_URL);
        RoundImageView roundImageView = (RoundImageView) inflate.findViewById(R$id.damai_theme_dialog_top_image_bg);
        this.b = roundImageView;
        int i = (this.a * AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER) / GridBean.TYPE_PIC_URL;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) roundImageView.getLayoutParams();
        layoutParams.width = this.a;
        layoutParams.height = i;
        this.b.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) inflate.findViewById(R$id.damai_theme_dialog_top_image);
        this.c = imageView;
        int i2 = (this.a * 220) / GridBean.TYPE_PIC_URL;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = this.a;
        layoutParams2.height = i2;
        this.c.setLayoutParams(layoutParams2);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.damai_theme_dialog_container);
        this.l = linearLayout;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams3.width = this.a;
        this.l.setLayoutParams(layoutParams3);
        this.d = (TextView) inflate.findViewById(R$id.damai_theme_dialog_title);
        this.e = (TextView) inflate.findViewById(R$id.damai_theme_dialog_subtitle);
        this.h = (ScrollView) inflate.findViewById(R$id.damai_theme_dialog_content_layout);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.damai_theme_dialog_content_container);
        this.g = (FrameLayout) inflate.findViewById(R$id.additional_container);
        this.f = (TextView) inflate.findViewById(R$id.damai_theme_dialog_tip_content);
        this.j = (TextView) inflate.findViewById(R$id.damai_theme_dialog_cancel_btn);
        this.i = (TextView) inflate.findViewById(R$id.damai_theme_dialog_confirm_btn);
        this.k = (BricksIconFontTextView) inflate.findViewById(R$id.damai_theme_dialog_close_btn);
        inflate.findViewById(R$id.damai_theme_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (DisplayMetrics.getheightPixels(s60.INSTANCE.d(getContext())) * 0.05d)));
        setContentView(inflate);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212092562")) {
            ipChange.ipc$dispatch("212092562", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
        }
    }

    public BricksThemeDialog e(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693177496")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-693177496", new Object[]{this, view});
        }
        FrameLayout frameLayout = this.g;
        if (frameLayout != null) {
            frameLayout.addView(view);
        }
        return this;
    }

    public BricksThemeDialog f(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931499817")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("931499817", new Object[]{this, Integer.valueOf(i)});
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.setBackgroundResource(i);
        }
        return this;
    }

    public BricksThemeDialog g(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865257465")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1865257465", new Object[]{this, Integer.valueOf(i)});
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setBackgroundResource(i);
        }
        return this;
    }

    public BricksThemeDialog h(CharSequence charSequence, int i, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1056883266")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1056883266", new Object[]{this, charSequence, Integer.valueOf(i), onClickListener});
        }
        if (this.j != null && !TextUtils.isEmpty(charSequence)) {
            this.j.setText(charSequence);
            if (i != 0) {
                this.j.setTextColor(i);
            }
            this.j.setVisibility(0);
            this.n++;
            TextView textView = this.j;
            if (textView != null) {
                textView.setOnClickListener(new View$OnClickListenerC3566a(onClickListener));
            }
        }
        return this;
    }

    public BricksThemeDialog i(boolean z, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777389055")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-1777389055", new Object[]{this, Boolean.valueOf(z), onClickListener});
        }
        BricksIconFontTextView bricksIconFontTextView = this.k;
        if (bricksIconFontTextView == null) {
            return this;
        }
        if (z) {
            bricksIconFontTextView.setVisibility(0);
            this.k.setOnClickListener(new View$OnClickListenerC3568c(onClickListener));
        } else {
            bricksIconFontTextView.setVisibility(8);
        }
        return this;
    }

    public BricksThemeDialog j(CharSequence charSequence, int i, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1974391154")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-1974391154", new Object[]{this, charSequence, Integer.valueOf(i), onClickListener});
        }
        if (this.i != null && !TextUtils.isEmpty(charSequence)) {
            this.i.setText(charSequence);
            if (i != 0) {
                this.i.setTextColor(i);
            }
            this.i.setVisibility(0);
            this.n++;
            this.i.setOnClickListener(new View$OnClickListenerC3567b(onClickListener));
        }
        return this;
    }

    public BricksThemeDialog k(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936617281")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1936617281", new Object[]{this, spannableString});
        }
        if (this.h != null && this.f != null && !TextUtils.isEmpty(spannableString)) {
            this.f.setText(spannableString);
            this.h.setVisibility(0);
        }
        return this;
    }

    public BricksThemeDialog l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657432252")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("657432252", new Object[]{this, Integer.valueOf(i)});
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setGravity(i);
        }
        return this;
    }

    public BricksThemeDialog m(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084797818")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1084797818", new Object[]{this, spannableString});
        }
        if (spannableString != null) {
            this.e.setText(spannableString);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        return this;
    }

    public BricksThemeDialog n(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180054590")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("1180054590", new Object[]{this, charSequence});
        }
        if (this.d != null && !TextUtils.isEmpty(charSequence)) {
            this.d.setText(charSequence);
            this.d.setVisibility(0);
        }
        return this;
    }

    public BricksThemeDialog o(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968497667")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-968497667", new Object[]{this, Integer.valueOf(i)});
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746648865")) {
            ipChange.ipc$dispatch("746648865", new Object[]{this, bundle});
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

    public BricksThemeDialog p(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510711249")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("-510711249", new Object[]{this, Integer.valueOf(i)});
        }
        RoundImageView roundImageView = this.b;
        if (roundImageView != null) {
            roundImageView.setImageResource(i);
        }
        return this;
    }

    public BricksThemeDialog q(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001157330")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("2001157330", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i > 0 && i2 > 0) {
            int i3 = (this.a * i2) / i;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.width = this.a;
            layoutParams.height = i3;
            this.b.setLayoutParams(layoutParams);
        }
        return this;
    }

    public BricksThemeDialog r(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973694496")) {
            return (BricksThemeDialog) ipChange.ipc$dispatch("973694496", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i > 0 && i2 > 0) {
            this.c.setLayoutParams(new FrameLayout.LayoutParams(this.a, (this.a * i2) / i));
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1891910353")) {
            ipChange.ipc$dispatch("1891910353", new Object[]{this});
        } else {
            super.show();
        }
    }

    public BricksThemeDialog(@NonNull Context context, int i) {
        super(context, i);
        d();
    }
}
