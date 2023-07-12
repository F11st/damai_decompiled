package cn.damai.uikit.view;

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
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.uplayer.AliMediaPlayer;
import tb.bm2;
import tb.q60;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMThemeDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private RoundImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private FrameLayout f;
    private ScrollView g;
    private TextView h;
    private TextView i;
    private DMIconFontTextView j;
    private LinearLayout k;
    private MaxHeightLinearLayout l;
    private int m;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
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
    /* renamed from: cn.damai.uikit.view.DMThemeDialog$a */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2578a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        View$OnClickListenerC2578a(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-217947327")) {
                ipChange.ipc$dispatch("-217947327", new Object[]{this, view});
                return;
            }
            DMThemeDialog.this.dismiss();
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(DMThemeDialog.this, -2);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMThemeDialog$b */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2579b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        View$OnClickListenerC2579b(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1893343042")) {
                ipChange.ipc$dispatch("1893343042", new Object[]{this, view});
                return;
            }
            DMThemeDialog.this.dismiss();
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(DMThemeDialog.this, -1);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.DMThemeDialog$c */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2580c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        View$OnClickListenerC2580c(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1820956484")) {
                ipChange.ipc$dispatch("1820956484", new Object[]{this, view});
                return;
            }
            DMThemeDialog.this.dismiss();
            View.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(DMThemeDialog.this.i);
            }
        }
    }

    public DMThemeDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922206002")) {
            ipChange.ipc$dispatch("-1922206002", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.damai_theme_dialog, (ViewGroup) null);
        this.l = (MaxHeightLinearLayout) inflate.findViewById(R$id.damai_theme_dialog_layout);
        this.a = yr2.c(getContext(), (int) (this.l.getMaxHeight() * 0.5d), 50, 220, GridBean.TYPE_PIC_URL);
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
        this.k = linearLayout;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams3.width = this.a;
        this.k.setLayoutParams(layoutParams3);
        this.d = (TextView) inflate.findViewById(R$id.damai_theme_dialog_title);
        this.g = (ScrollView) inflate.findViewById(R$id.damai_theme_dialog_content_layout);
        this.f = (FrameLayout) inflate.findViewById(R$id.damai_theme_dialog_content_container);
        this.e = (TextView) inflate.findViewById(R$id.damai_theme_dialog_tip_content);
        this.i = (TextView) inflate.findViewById(R$id.damai_theme_dialog_cancel_btn);
        this.h = (TextView) inflate.findViewById(R$id.damai_theme_dialog_confirm_btn);
        this.j = (DMIconFontTextView) inflate.findViewById(R$id.damai_theme_dialog_close_btn);
        inflate.findViewById(R$id.damai_theme_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (DisplayMetrics.getheightPixels(q60.b(getContext())) * 0.05d)));
        setContentView(inflate);
    }

    public DMThemeDialog c(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141289751")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-1141289751", new Object[]{this, Integer.valueOf(i)});
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setBackgroundResource(i);
        }
        return this;
    }

    public DMThemeDialog d(CharSequence charSequence, int i, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865250550")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-865250550", new Object[]{this, charSequence, Integer.valueOf(i), onClickListener});
        }
        if (this.i != null && !TextUtils.isEmpty(charSequence)) {
            this.i.setText(charSequence);
            if (i != 0) {
                this.i.setTextColor(i);
            }
            this.i.setVisibility(0);
            this.m++;
            TextView textView = this.i;
            if (textView != null) {
                textView.setOnClickListener(new View$OnClickListenerC2578a(onClickListener));
            }
        }
        return this;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252104605")) {
            ipChange.ipc$dispatch("252104605", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
        }
    }

    public DMThemeDialog e(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221658141")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-1221658141", new Object[]{this, charSequence, onClickListener});
        }
        d(charSequence, 0, onClickListener);
        return this;
    }

    public DMThemeDialog f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218065366")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("1218065366", new Object[]{this, Boolean.valueOf(z)});
        }
        setCancelable(z);
        setCanceledOnTouchOutside(z);
        return this;
    }

    public DMThemeDialog g(boolean z, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466871647")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-1466871647", new Object[]{this, Boolean.valueOf(z), onClickListener});
        }
        DMIconFontTextView dMIconFontTextView = this.j;
        if (dMIconFontTextView == null) {
            return this;
        }
        if (z) {
            dMIconFontTextView.setVisibility(0);
            this.j.setOnClickListener(new View$OnClickListenerC2580c(onClickListener));
        } else {
            dMIconFontTextView.setVisibility(8);
        }
        return this;
    }

    public DMThemeDialog h(CharSequence charSequence, int i, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19580596")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("19580596", new Object[]{this, charSequence, Integer.valueOf(i), onClickListener});
        }
        if (this.h != null && !TextUtils.isEmpty(charSequence)) {
            this.h.setText(charSequence);
            if (i != 0) {
                this.h.setTextColor(i);
            }
            this.h.setVisibility(0);
            this.m++;
            this.h.setOnClickListener(new View$OnClickListenerC2579b(onClickListener));
        }
        return this;
    }

    public DMThemeDialog i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746547449")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("746547449", new Object[]{this, charSequence, onClickListener});
        }
        h(charSequence, 0, onClickListener);
        return this;
    }

    public DMThemeDialog j(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025236705")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("1025236705", new Object[]{this, spannableString});
        }
        if (this.g != null && this.e != null && !TextUtils.isEmpty(spannableString)) {
            this.e.setText(spannableString);
            this.g.setVisibility(0);
        }
        return this;
    }

    public DMThemeDialog k(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814803139")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("1814803139", new Object[]{this, charSequence});
        }
        if (this.g != null && this.e != null && !TextUtils.isEmpty(charSequence)) {
            this.e.setText(charSequence);
            this.g.setVisibility(0);
        }
        return this;
    }

    public DMThemeDialog l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885004358")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("885004358", new Object[]{this, Integer.valueOf(i)});
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setGravity(i);
        }
        return this;
    }

    public DMThemeDialog m(View view) {
        FrameLayout frameLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950899634")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-1950899634", new Object[]{this, view});
        }
        if (this.g != null && (frameLayout = this.f) != null && view != null) {
            frameLayout.removeAllViews();
            this.f.addView(view);
            this.g.setVisibility(0);
        }
        return this;
    }

    public DMThemeDialog n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995480935")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-1995480935", new Object[]{this, Integer.valueOf(i)});
        }
        return o(i == 0 ? "" : bm2.a(getContext(), i));
    }

    public DMThemeDialog o(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565745852")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-565745852", new Object[]{this, charSequence});
        }
        if (this.d != null && !TextUtils.isEmpty(charSequence)) {
            this.d.setText(charSequence);
            this.d.setVisibility(0);
        }
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881699668")) {
            ipChange.ipc$dispatch("-1881699668", new Object[]{this, bundle});
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

    public DMThemeDialog p(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303030737")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-303030737", new Object[]{this, Integer.valueOf(i)});
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        return this;
    }

    public DMThemeDialog q(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322421891")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("-1322421891", new Object[]{this, Integer.valueOf(i)});
        }
        RoundImageView roundImageView = this.b;
        if (roundImageView != null) {
            roundImageView.setImageResource(i);
        }
        return this;
    }

    public DMThemeDialog r(DMDialogTheme dMDialogTheme) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1833629296")) {
            return (DMThemeDialog) ipChange.ipc$dispatch("1833629296", new Object[]{this, dMDialogTheme});
        }
        int i2 = R$drawable.damai_theme_dialog_image_award_bg;
        int i3 = R$drawable.damai_theme_dialog_image_award;
        if (dMDialogTheme != DMDialogTheme.THEME_REWARD) {
            if (dMDialogTheme == DMDialogTheme.THEME_COMMENT) {
                i2 = R$drawable.damai_theme_dialog_image_comment_bg;
                i = R$drawable.damai_theme_dialog_image_comment;
            } else if (dMDialogTheme == DMDialogTheme.THEME_SYS_UPDATE) {
                i2 = R$drawable.damai_theme_dialog_image_sys_update_bg;
                i = R$drawable.damai_theme_dialog_image_sys_update;
            } else if (dMDialogTheme == DMDialogTheme.THEME_LOCATION) {
                i2 = R$drawable.damai_theme_dialog_image_location_bg;
                i = R$drawable.damai_theme_dialog_image_location;
            } else if (dMDialogTheme == DMDialogTheme.THEME_NOTIFICATION) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_notification;
            } else if (dMDialogTheme == DMDialogTheme.THEME_ORDER_FAILURE) {
                i2 = R$drawable.damai_theme_dialog_image_order_failure_bg;
                i = R$drawable.damai_theme_dialog_image_order_failure;
            } else if (dMDialogTheme == DMDialogTheme.THEME_PERMISSION_ALBUM) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_album;
            } else if (dMDialogTheme == DMDialogTheme.THEME_PERMISSION_CAMERA) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_camera;
            } else if (dMDialogTheme == DMDialogTheme.THEME_PERMISSION_CALENDAR) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_calendar;
            } else if (dMDialogTheme == DMDialogTheme.THEME_PERMISSION_CONTACTS) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_contacts;
            } else if (dMDialogTheme == DMDialogTheme.THEME_REAL_NAME) {
                i2 = R$drawable.damai_theme_dialog_image_sys_update_bg;
                i = R$drawable.damai_theme_dialog_image_real_name;
            } else if (dMDialogTheme == DMDialogTheme.THEME_TAOBAO_LOGIN) {
                i2 = R$drawable.damai_theme_dialog_image_taobao_login_bg;
                c(R$drawable.bg_submit_button_ff7d28_ff9532);
            } else if (dMDialogTheme == DMDialogTheme.THEME_GUARD_SUCCESS) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_guard;
            } else if (dMDialogTheme == DMDialogTheme.THEME_YOUKU_LIVE) {
                i2 = R$drawable.damai_theme_dialog_youku_bg;
            } else if (dMDialogTheme == DMDialogTheme.THEME_SUPPORT_WANNA) {
                i2 = R$drawable.damai_theme_dialog_image_notification_bg;
                i = R$drawable.damai_theme_dialog_image_support;
            }
            q(i2);
            p(i);
            return this;
        }
        i = i3;
        q(i2);
        p(i);
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460555174")) {
            ipChange.ipc$dispatch("1460555174", new Object[]{this});
        } else {
            super.show();
        }
    }

    public DMThemeDialog(@NonNull Context context, int i) {
        super(context, i);
        b();
    }
}
