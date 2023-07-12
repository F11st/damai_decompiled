package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.mine.userinfo.bean.UserBanner;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class yf1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b;
    private RoundImageView c;
    private int d = 50;
    private int e = 350;
    private int f;
    private int g;

    /* compiled from: Taobao */
    /* renamed from: tb.yf1$a */
    /* loaded from: classes6.dex */
    public class C9983a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9983a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1074427369")) {
                ipChange.ipc$dispatch("1074427369", new Object[]{this, c0501d});
            } else {
                yf1.this.h();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf1$b */
    /* loaded from: classes6.dex */
    public class C9984b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9984b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-11627330")) {
                ipChange.ipc$dispatch("-11627330", new Object[]{this, c0502e});
            } else if (c0502e == null || (drawable = c0502e.a) == null) {
                yf1.this.h();
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = c0502e.a.getIntrinsicHeight();
                yf1 yf1Var = yf1.this;
                yf1Var.g = (int) (((intrinsicHeight * yf1Var.f) * 1.0f) / intrinsicWidth);
                yf1.this.c.getLayoutParams().width = yf1.this.f;
                yf1.this.c.getLayoutParams().height = yf1.this.g;
                yf1.this.c.setImageDrawable(c0502e.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf1$c */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC9985c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserBanner a;

        View$OnClickListenerC9985c(UserBanner userBanner) {
            this.a = userBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1982814521")) {
                ipChange.ipc$dispatch("1982814521", new Object[]{this, view});
            } else if (TextUtils.isEmpty(this.a.url)) {
            } else {
                C0529c.e().x(vf1.x().K());
                DMNav.from(yf1.this.a).toUri(this.a.url);
            }
        }
    }

    public yf1(Context context, View view) {
        this.a = context;
        this.b = (FrameLayout) view.findViewById(R$id.ll_mine_olympic);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.iv_olympic);
        this.c = roundImageView;
        roundImageView.setType(1);
        this.c.setBorderRadius(12);
        this.f = DisplayMetrics.getwidthPixels(m62.b(context)) - m62.a(context, 24.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1701475339")) {
            ipChange.ipc$dispatch("1701475339", new Object[]{this});
            return;
        }
        this.c.setImageResource(R$drawable.bg_olympic_banner);
        this.g = (int) (((this.d * this.f) * 1.0f) / this.e);
        this.c.getLayoutParams().width = this.f;
        this.c.getLayoutParams().height = this.g;
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749974435")) {
            ipChange.ipc$dispatch("1749974435", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void i(UserBanner userBanner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722259818")) {
            ipChange.ipc$dispatch("722259818", new Object[]{this, userBanner});
        } else if (userBanner != null && !TextUtils.isEmpty(userBanner.bannerPic)) {
            DMImageCreator e = C0504a.b().e(userBanner.bannerPic);
            int i = R$drawable.bg_olympic_banner;
            e.i(i).c(i).n(new C9984b()).e(new C9983a()).f();
            this.b.setVisibility(0);
            vf1.x().L(this.b);
            this.c.setOnClickListener(new View$OnClickListenerC9985c(userBanner));
        } else {
            this.b.setVisibility(8);
        }
    }
}
