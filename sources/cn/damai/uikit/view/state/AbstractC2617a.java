package cn.damai.uikit.view.state;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import cn.damai.uikit.view.state.AnimationStateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: cn.damai.uikit.view.state.a */
/* loaded from: classes8.dex */
public abstract class AbstractC2617a implements AnimationStateView.PhaseDrawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private Drawable a;

    public AbstractC2617a(Context context, int i) {
        try {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = resources.getDrawable(i, null);
            } else {
                this.a = resources.getDrawable(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964372170")) {
            ipChange.ipc$dispatch("-1964372170", new Object[]{this, drawable, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            i = 255;
        }
        drawable.setAlpha(i);
    }

    public abstract void b(@NonNull Drawable drawable, int i);

    @Override // cn.damai.uikit.view.state.AnimationStateView.PhaseDrawable
    public void draw(Canvas canvas, AnimationStateView animationStateView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-979049759")) {
            ipChange.ipc$dispatch("-979049759", new Object[]{this, canvas, animationStateView});
        } else if (this.a != null) {
            this.a.setBounds(0, 0, animationStateView.getWidth(), animationStateView.getHeight());
            this.a.draw(canvas);
        }
    }

    @Override // cn.damai.uikit.view.state.AnimationStateView.PhaseDrawable
    public void setPhase(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784606455")) {
            ipChange.ipc$dispatch("1784606455", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Drawable drawable = this.a;
        if (drawable != null) {
            b(drawable, i);
        }
    }
}
