package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
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
    /* loaded from: classes6.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1074427369")) {
                ipChange.ipc$dispatch("1074427369", new Object[]{this, dVar});
            } else {
                yf1.this.h();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-11627330")) {
                ipChange.ipc$dispatch("-11627330", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
                yf1.this.h();
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = eVar.a.getIntrinsicHeight();
                yf1 yf1Var = yf1.this;
                yf1Var.g = (int) (((intrinsicHeight * yf1Var.f) * 1.0f) / intrinsicWidth);
                yf1.this.c.getLayoutParams().width = yf1.this.f;
                yf1.this.c.getLayoutParams().height = yf1.this.g;
                yf1.this.c.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserBanner a;

        c(UserBanner userBanner) {
            this.a = userBanner;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1982814521")) {
                ipChange.ipc$dispatch("1982814521", new Object[]{this, view});
            } else if (TextUtils.isEmpty(this.a.url)) {
            } else {
                cn.damai.common.user.c.e().x(vf1.x().K());
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
            DMImageCreator e = cn.damai.common.image.a.b().e(userBanner.bannerPic);
            int i = R$drawable.bg_olympic_banner;
            e.i(i).c(i).n(new b()).e(new a()).f();
            this.b.setVisibility(0);
            vf1.x().L(this.b);
            this.c.setOnClickListener(new c(userBanner));
        } else {
            this.b.setVisibility(8);
        }
    }
}
