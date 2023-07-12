package tb;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class qw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private View b;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(qw0 qw0Var, View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-226648251")) {
                ipChange.ipc$dispatch("-226648251", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = intValue;
            this.a.setLayoutParams(layoutParams);
        }
    }

    private qw0(Context context, View view, int i) {
        this.b = view;
        this.a = i;
    }

    private ValueAnimator a(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24376375")) {
            return (ValueAnimator) ipChange.ipc$dispatch("-24376375", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new a(this, view));
        return ofInt;
    }

    public static qw0 b(Context context, View view, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-576400968") ? (qw0) ipChange.ipc$dispatch("-576400968", new Object[]{context, view, Integer.valueOf(i)}) : new qw0(context, view, i);
    }

    private void c(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251049643")) {
            ipChange.ipc$dispatch("-251049643", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        view.setVisibility(0);
        ValueAnimator a2 = a(view, 0, this.a);
        a2.setDuration(i);
        a2.start();
    }

    public void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179941670")) {
            ipChange.ipc$dispatch("-1179941670", new Object[]{this, Integer.valueOf(i)});
        } else {
            c(this.b, i);
        }
    }
}
