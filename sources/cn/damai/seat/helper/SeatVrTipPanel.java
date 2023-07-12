package cn.damai.seat.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.R$drawable;
import cn.damai.seat.R$id;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public abstract class SeatVrTipPanel implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private ImageView b;
    private View c;
    private int d;
    private int e;
    private boolean f;
    private String g;
    private ObjectAnimator h;
    private ObjectAnimator i;
    private VrThumbViewEventListener j;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface VrThumbViewEventListener {
        void onVrThumbViewHide();

        void onVrThumbViewShown();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.helper.SeatVrTipPanel$a */
    /* loaded from: classes16.dex */
    public class C1662a extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        C1662a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1443175181")) {
                ipChange.ipc$dispatch("1443175181", new Object[]{this, animator});
            } else if (SeatVrTipPanel.this.f) {
                if (SeatVrTipPanel.this.j != null) {
                    SeatVrTipPanel.this.j.onVrThumbViewShown();
                }
            } else {
                SeatVrTipPanel.this.g();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1827489498")) {
                ipChange.ipc$dispatch("-1827489498", new Object[]{this, animator});
                return;
            }
            super.onAnimationStart(animator);
            SeatVrTipPanel.this.c.setVisibility(0);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.helper.SeatVrTipPanel$b */
    /* loaded from: classes16.dex */
    public class C1663b extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        C1663b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435415822")) {
                ipChange.ipc$dispatch("1435415822", new Object[]{this, animator});
                return;
            }
            SeatVrTipPanel.this.c.setVisibility(8);
            if (SeatVrTipPanel.this.f) {
                SeatVrTipPanel.this.m();
            } else if (SeatVrTipPanel.this.j != null) {
                SeatVrTipPanel.this.j.onVrThumbViewHide();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.helper.SeatVrTipPanel$c */
    /* loaded from: classes7.dex */
    public class C1664c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1664c(SeatVrTipPanel seatVrTipPanel) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-590111989")) {
                ipChange.ipc$dispatch("-590111989", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.helper.SeatVrTipPanel$d */
    /* loaded from: classes7.dex */
    public class C1665d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        C1665d(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1853610080")) {
                ipChange.ipc$dispatch("1853610080", new Object[]{this, c0502e});
            } else if (!this.a.equals(SeatVrTipPanel.this.g) || c0502e == null || c0502e.b == null) {
            } else {
                SeatVrTipPanel.this.b.setImageBitmap(c0502e.b);
            }
        }
    }

    public SeatVrTipPanel(Activity activity, View view) {
        if (view == null || activity == null || activity.isFinishing()) {
            return;
        }
        this.a = activity;
        this.b = (ImageView) view.findViewById(R$id.iv_vr_thumb);
        i(view);
        this.c = view;
        view.setOnClickListener(this);
        this.d = ScreenUtil.dip2px(mu0.a(), 124.0f);
        this.e = ScreenUtil.dip2px(mu0.a(), 104.0f);
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471098944")) {
            ipChange.ipc$dispatch("-471098944", new Object[]{this});
            return;
        }
        ObjectAnimator a = AnimatorHelper.a(this.c, this.d, 0, this.e, 0, 1, 0, 400, new C1663b());
        this.i = a;
        a.setInterpolator(new DecelerateInterpolator());
    }

    private void i(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977829120")) {
            ipChange.ipc$dispatch("-1977829120", new Object[]{this, view});
            return;
        }
        try {
            RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.a.getResources(), BitmapFactory.decodeResource(this.a.getResources(), R$drawable.ic_vr_thumb_mask));
            create.setCornerRadius(m62.a(this.a, 6.0f));
            view.findViewById(R$id.iv_vr_thumb_mask).setBackground(create);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466283739")) {
            ipChange.ipc$dispatch("-1466283739", new Object[]{this});
            return;
        }
        ObjectAnimator a = AnimatorHelper.a(this.c, 0, this.d, 0, this.e, 0, 1, 400, new C1662a());
        this.h = a;
        a.setInterpolator(new DecelerateInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942178748")) {
            ipChange.ipc$dispatch("942178748", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view == null || view.isShown()) {
            return;
        }
        this.f = true;
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            ObjectAnimator objectAnimator2 = this.h;
            if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
                j();
                this.h.start();
            }
        }
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212492969")) {
            ipChange.ipc$dispatch("-212492969", new Object[]{this});
        } else if (this.c == null) {
        } else {
            this.f = false;
            ObjectAnimator objectAnimator = this.h;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                h();
                this.i.start();
            }
        }
    }

    public abstract void k();

    public void l(VrThumbViewEventListener vrThumbViewEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558103624")) {
            ipChange.ipc$dispatch("-1558103624", new Object[]{this, vrThumbViewEventListener});
        } else {
            this.j = vrThumbViewEventListener;
        }
    }

    public void n(SeatNew seatNew, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778708079")) {
            ipChange.ipc$dispatch("1778708079", new Object[]{this, seatNew, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.g = str;
            DMImageCreator c = C0504a.b().c(str);
            int i = R$drawable.bg_border_corner_6_solid_f5f5f5;
            c.i(i).c(i).k(new DMRoundedCornersBitmapProcessor(m62.a(this.a, 12.0f), 0)).n(new C1665d(str)).e(new C1664c(this)).f();
            m();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "945825994")) {
            ipChange.ipc$dispatch("945825994", new Object[]{this, view});
        } else {
            k();
        }
    }
}
