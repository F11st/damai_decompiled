package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.SmartScrollView;
import cn.damai.uikit.R$style;
import cn.damai.uikit.view.MaxHeightLinearLayout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDialog extends Dialog implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView arrow;
    private TextView confirmButton;
    private SmartScrollView contentLayout;
    ObjectAnimator downAnim;
    int first;
    private boolean isScorllBottom;
    private CharSequence mConfirmText;
    private Handler mCountDownHandler;
    private int mCountTime;
    private MaxHeightLinearLayout mMaxHeightLayout;
    private TextView tipConetnt;
    private TextView titleText;
    ObjectAnimator upAnim;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements SmartScrollView.ISmartScrollChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.SmartScrollView.ISmartScrollChangedListener
        public void onScrolledToBottom() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532664956")) {
                ipChange.ipc$dispatch("-532664956", new Object[]{this});
            } else {
                ProjectDialog.this.enableClickConfirm();
            }
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.SmartScrollView.ISmartScrollChangedListener
        public void onScrolledToTop() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-225344474")) {
                ipChange.ipc$dispatch("-225344474", new Object[]{this});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-54059574")) {
                ipChange.ipc$dispatch("-54059574", new Object[]{this});
            } else if (ProjectDialog.this.contentLayout.canScrollVertically(1)) {
            } else {
                ProjectDialog.this.enableClickConfirm();
                ProjectDialog.this.confirmButton.setText(ProjectDialog.this.mConfirmText);
                ProjectDialog.this.mCountTime = 0;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "763294")) {
                ipChange.ipc$dispatch("763294", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            ProjectDialog.this.upAnim.start();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-6996065")) {
                ipChange.ipc$dispatch("-6996065", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            ProjectDialog.this.downAnim.start();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DialogInterface.OnClickListener a;

        e(DialogInterface.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "410941930")) {
                ipChange.ipc$dispatch("410941930", new Object[]{this, view});
                return;
            }
            DialogInterface.OnClickListener onClickListener = this.a;
            if (onClickListener != null) {
                onClickListener.onClick(ProjectDialog.this, -1);
            }
        }
    }

    public ProjectDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private void disEnableClickConfirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "402986201")) {
            ipChange.ipc$dispatch("402986201", new Object[]{this});
            return;
        }
        this.isScorllBottom = false;
        this.confirmButton.setBackgroundResource(R$drawable.bg_border_corner_nat_grey);
        this.downAnim = ObjectAnimator.ofFloat(this.arrow, "translationY", 0.0f, 10.0f, 0.0f);
        this.upAnim = ObjectAnimator.ofFloat(this.arrow, "translationY", 0.0f, -10.0f, 0.0f);
        this.downAnim.setDuration(1000L);
        this.upAnim.setDuration(1000L);
        this.downAnim.setInterpolator(new LinearInterpolator());
        this.upAnim.setInterpolator(new LinearInterpolator());
        this.downAnim.addListener(new c());
        this.upAnim.addListener(new d());
        this.downAnim.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableClickConfirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2142108429")) {
            ipChange.ipc$dispatch("2142108429", new Object[]{this});
            return;
        }
        this.isScorllBottom = true;
        this.confirmButton.setBackgroundResource(R$drawable.bg_border_corner_nat_red);
        this.arrow.setVisibility(4);
        ObjectAnimator objectAnimator = this.downAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.upAnim;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934450189")) {
            ipChange.ipc$dispatch("-1934450189", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.layout_project_dialog, (ViewGroup) null);
        this.mMaxHeightLayout = (MaxHeightLinearLayout) inflate.findViewById(R$id.damai_theme_dialog_layout);
        this.titleText = (TextView) inflate.findViewById(R$id.damai_theme_dialog_title);
        SmartScrollView smartScrollView = (SmartScrollView) inflate.findViewById(R$id.damai_theme_dialog_content_layout);
        this.contentLayout = smartScrollView;
        smartScrollView.setScanScrollChangedListener(new a());
        this.contentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.tipConetnt = (TextView) inflate.findViewById(R$id.damai_theme_dialog_tip_content);
        this.arrow = (ImageView) inflate.findViewById(R$id.damai_theme_dialog_img_btn);
        this.confirmButton = (TextView) inflate.findViewById(R$id.damai_theme_dialog_confirm_btn);
        inflate.findViewById(R$id.damai_theme_dialog_bottom_space).setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (DisplayMetrics.getheightPixels(q60.b(getContext())) * 0.05d)));
        setContentView(inflate);
        disEnableClickConfirm();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082993624")) {
            ipChange.ipc$dispatch("1082993624", new Object[]{this});
        } else if (isShowing()) {
            super.dismiss();
        }
    }

    public boolean isScrollBottom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1113814326") ? ((Boolean) ipChange.ipc$dispatch("-1113814326", new Object[]{this})).booleanValue() : this.isScorllBottom;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1579648153")) {
            ipChange.ipc$dispatch("-1579648153", new Object[]{this, bundle});
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

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264713911")) {
            ipChange.ipc$dispatch("264713911", new Object[]{this});
            return;
        }
        TextView textView = this.confirmButton;
        if (textView == null) {
            return;
        }
        int i = this.mCountTime;
        if (i >= 0) {
            this.mCountTime = i - 1;
            this.mCountDownHandler.postDelayed(this, 1000L);
            return;
        }
        textView.setText(this.mConfirmText);
        enableClickConfirm();
    }

    public ProjectDialog setDMThemeDialogCancelable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1594783092")) {
            return (ProjectDialog) ipChange.ipc$dispatch("-1594783092", new Object[]{this, Boolean.valueOf(z)});
        }
        setCancelable(z);
        setCanceledOnTouchOutside(z);
        return this;
    }

    public ProjectDialog setDMThemeDialogConfirmButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-767034279")) {
            return (ProjectDialog) ipChange.ipc$dispatch("-767034279", new Object[]{this, charSequence, onClickListener});
        }
        setDMThemeDialogConfirmButton(charSequence, 0, onClickListener);
        return this;
    }

    public ProjectDialog setDMThemeDialogContent(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "730550649")) {
            return (ProjectDialog) ipChange.ipc$dispatch("730550649", new Object[]{this, charSequence});
        }
        if (this.contentLayout != null && this.tipConetnt != null && !TextUtils.isEmpty(charSequence)) {
            this.tipConetnt.setText(charSequence);
            this.contentLayout.setVisibility(0);
        }
        return this;
    }

    public ProjectDialog setDMThemeDialogTitle(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-356386246")) {
            return (ProjectDialog) ipChange.ipc$dispatch("-356386246", new Object[]{this, charSequence});
        }
        if (this.titleText != null && !TextUtils.isEmpty(charSequence)) {
            this.titleText.setText(charSequence);
            this.titleText.setVisibility(0);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134796107")) {
            ipChange.ipc$dispatch("134796107", new Object[]{this});
            return;
        }
        super.show();
        this.mCountDownHandler.post(this);
    }

    public ProjectDialog(@NonNull Context context, int i) {
        super(context, i);
        this.mCountDownHandler = new Handler(Looper.getMainLooper());
        this.mCountTime = 6;
        this.first = 0;
        initView();
    }

    public ProjectDialog setDMThemeDialogConfirmButton(CharSequence charSequence, int i, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777675798")) {
            return (ProjectDialog) ipChange.ipc$dispatch("-1777675798", new Object[]{this, charSequence, Integer.valueOf(i), onClickListener});
        }
        if (this.confirmButton != null && !TextUtils.isEmpty(charSequence)) {
            this.confirmButton.setText(charSequence);
            if (i != 0) {
                this.confirmButton.setTextColor(i);
            }
            this.confirmButton.setOnClickListener(new e(onClickListener));
        }
        this.mConfirmText = charSequence;
        return this;
    }
}
