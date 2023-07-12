package tb;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.view.OnItemClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class xy2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProgressBar a;
    private TextView b;
    private TextView c;
    private OnItemClickListener<VoteBean> d;
    private VoteBean e;
    private int f;
    private boolean g;
    private Drawable h;
    private Drawable i;
    private int j;
    private int k;

    /* compiled from: Taobao */
    /* renamed from: tb.xy2$a */
    /* loaded from: classes7.dex */
    public class C9939a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9939a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1963837157")) {
                ipChange.ipc$dispatch("-1963837157", new Object[]{this, valueAnimator});
            } else {
                xy2.this.a.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public xy2(ViewGroup viewGroup, OnItemClickListener<VoteBean> onItemClickListener) {
        this.a = (ProgressBar) viewGroup.findViewById(R$id.item_single_vote_progress);
        this.b = (TextView) viewGroup.findViewById(R$id.item_single_vote_text);
        this.c = (TextView) viewGroup.findViewById(R$id.item_single_vote_count);
        this.d = onItemClickListener;
        viewGroup.setOnClickListener(this);
    }

    private void c(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787102102")) {
            ipChange.ipc$dispatch("787102102", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        if (i <= 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        Object tag = this.a.getTag();
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
            this.a.setTag(null);
        }
        if (i > 0 && z) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, i);
            ofInt.addUpdateListener(new C9939a());
            ofInt.setDuration(300L);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.start();
            this.a.setTag(ofInt);
            return;
        }
        this.a.setProgress(i);
    }

    public void b(VoteBean voteBean, boolean z, int i, boolean z2) {
        Drawable drawable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869506963")) {
            ipChange.ipc$dispatch("-869506963", new Object[]{this, voteBean, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)});
        } else if (voteBean == null) {
        } else {
            this.e = voteBean;
            this.f = i;
            this.b.setText(voteBean.name);
            if (this.g) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                s60 s60Var = s60.INSTANCE;
                layoutParams.height = s60Var.b(AppInfoProviderProxy.getApplication().getApplicationContext(), 40);
                ((LinearLayout.LayoutParams) this.b.getLayoutParams()).leftMargin = s60Var.b(AppInfoProviderProxy.getApplication().getApplicationContext(), 6);
                this.b.setTextSize(14.0f);
                ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = s60Var.b(AppInfoProviderProxy.getApplication().getApplicationContext(), 6);
                this.c.setTextSize(14.0f);
            }
            if (z) {
                this.c.setText(voteBean.totalDesc);
                this.c.setVisibility(0);
                if (voteBean.hasVote) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable = AppInfoProviderProxy.getApplication().getDrawable(R$drawable.bricks_icon_vote_dui_gou_fuhao);
                    } else {
                        drawable = AppInfoProviderProxy.getApplication().getResources().getDrawable(R$drawable.bricks_icon_vote_dui_gou_fuhao);
                    }
                    s60 s60Var2 = s60.INSTANCE;
                    int b = s60Var2.b(AppInfoProviderProxy.getApplication(), 16);
                    drawable.setBounds(0, 0, b, b);
                    if (this.g) {
                        drawable.mutate();
                        DrawableCompat.setTint(drawable, this.k);
                        this.a.setProgressDrawable(this.h);
                        this.b.setTextColor(this.k);
                        this.c.setTextColor(this.k);
                    }
                    this.b.setCompoundDrawables(null, null, drawable, null);
                    this.b.setCompoundDrawablePadding(s60Var2.b(AppInfoProviderProxy.getApplication(), 3));
                } else {
                    if (this.g) {
                        this.a.setProgressDrawable(this.i);
                        this.b.setTextColor(this.j);
                        this.c.setTextColor(this.j);
                    }
                    this.b.setCompoundDrawables(null, null, null, null);
                }
            } else {
                this.b.setCompoundDrawables(null, null, null, null);
                if (this.g) {
                    this.a.setProgressDrawable(this.i);
                    this.b.setTextColor(this.j);
                }
                this.c.setVisibility(8);
            }
            if (z) {
                c(voteBean.progressInt, z2);
            } else {
                c(0, false);
            }
        }
    }

    public void d(Drawable drawable, Drawable drawable2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764038032")) {
            ipChange.ipc$dispatch("-1764038032", new Object[]{this, drawable, drawable2, str, str2});
            return;
        }
        this.g = true;
        this.h = drawable;
        this.i = drawable2;
        this.j = Color.parseColor(str2);
        this.k = Color.parseColor(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoteBean voteBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134982329")) {
            ipChange.ipc$dispatch("-2134982329", new Object[]{this, view});
            return;
        }
        OnItemClickListener<VoteBean> onItemClickListener = this.d;
        if (onItemClickListener == null || (voteBean = this.e) == null) {
            return;
        }
        onItemClickListener.onItemClick(voteBean, this.f);
    }
}
