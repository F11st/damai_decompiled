package cn.damai.common.app.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import cn.damai.uikit.util.TDialog;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class WantSeeGuideDialog extends TDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private Listener h;
    LottieAnimationView i;
    TextView j;
    TextView k;
    TextView l;
    View m;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface Listener {
        void onCloseBtnClick();

        void onWantSeeBtnClick();
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface WantGuidePageSource {
        String getButtonName();

        String getSubTitle();

        String getTitle();

        String lottieUrl();

        String schema();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.widget.WantSeeGuideDialog$a */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0481a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0481a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1496928464")) {
                ipChange.ipc$dispatch("1496928464", new Object[]{this, view});
                return;
            }
            WantSeeGuideDialog.this.dismiss();
            if (WantSeeGuideDialog.this.h != null) {
                WantSeeGuideDialog.this.h.onCloseBtnClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.widget.WantSeeGuideDialog$b */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0482b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0482b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-686748463")) {
                ipChange.ipc$dispatch("-686748463", new Object[]{this, view});
                return;
            }
            WantSeeGuideDialog.this.dismiss();
            if (WantSeeGuideDialog.this.h != null) {
                WantSeeGuideDialog.this.h.onWantSeeBtnClick();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.widget.WantSeeGuideDialog$c */
    /* loaded from: classes4.dex */
    public class C0483c implements LottieListener<Throwable> {
        private static transient /* synthetic */ IpChange $ipChange;

        C0483c() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1417442416")) {
                ipChange.ipc$dispatch("-1417442416", new Object[]{this, th});
            } else {
                WantSeeGuideDialog.this.i.setAnimation("wantseeguidelottie.zip");
            }
        }
    }

    public WantSeeGuideDialog(@NonNull Context context, Listener listener) {
        super(context, R$style.translucent_dialog_style);
        j(context);
        this.h = listener;
        this.i.setAnimation("wantseeguidelottie.zip");
        k();
    }

    private void j(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "254602379")) {
            ipChange.ipc$dispatch("254602379", new Object[]{this, context});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_want_see_pop, (ViewGroup) null);
        setContentView(inflate);
        setCanceledOnTouchOutside(false);
        this.i = (LottieAnimationView) inflate.findViewById(R$id.id_dialog_want_lottie);
        this.j = (TextView) inflate.findViewById(R$id.id_dialog_want_btn_tv);
        this.k = (TextView) inflate.findViewById(R$id.id_dialog_want_btn_title);
        this.l = (TextView) inflate.findViewById(R$id.id_dialog_want_btn_subtitle);
        this.m = inflate.findViewById(R$id.id_dialog_want_close_btn);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225155803")) {
            ipChange.ipc$dispatch("-1225155803", new Object[]{this});
            return;
        }
        this.m.setOnClickListener(new View$OnClickListenerC0481a());
        this.j.setOnClickListener(new View$OnClickListenerC0482b());
    }

    public WantSeeGuideDialog(@NonNull Context context, Listener listener, WantGuidePageSource wantGuidePageSource) {
        super(context, R$style.translucent_dialog_style);
        j(context);
        this.h = listener;
        if (wantGuidePageSource != null) {
            if (!TextUtils.isEmpty(wantGuidePageSource.lottieUrl())) {
                String lottieUrl = wantGuidePageSource.lottieUrl();
                this.i.setFailureListener(new C0483c());
                this.i.setAnimationFromUrl(lottieUrl);
            } else {
                this.i.setAnimation("wantseeguidelottie.zip");
            }
            if (!TextUtils.isEmpty(wantGuidePageSource.getTitle())) {
                this.k.setText(wantGuidePageSource.getTitle());
            }
            if (!TextUtils.isEmpty(wantGuidePageSource.getSubTitle())) {
                this.l.setText(wantGuidePageSource.getSubTitle());
            }
            if (!TextUtils.isEmpty(wantGuidePageSource.getButtonName())) {
                this.j.setText(wantGuidePageSource.getButtonName());
            }
        } else {
            this.i.setAnimation("wantseeguidelottie.zip");
        }
        k();
    }
}
