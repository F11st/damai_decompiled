package cn.damai.ticklet.utils;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Collection;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Utils {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    @RequiresApi(api = 14)
    /* loaded from: classes7.dex */
    public static class AnimationWrap extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        public boolean showOrHide;
        public View target;

        public AnimationWrap(boolean z, View view, int i, int i2) {
            this.showOrHide = z;
            this.target = view;
            setIntValues(i, i2);
            addUpdateListener(this);
            setDuration(300L);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1734390914")) {
                ipChange.ipc$dispatch("-1734390914", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int width = this.target.getWidth();
            float f = width > 0 ? (intValue / width) + 1.0f : 1.0f;
            float f2 = f < 1.0f ? f : 1.0f;
            if (f2 <= 0.5f) {
                f2 = 0.5f;
            }
            this.target.setAlpha(f2);
            this.target.setScrollX(intValue);
        }
    }

    public static boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1612197390")) {
            return ((Boolean) ipChange.ipc$dispatch("1612197390", new Object[0])).booleanValue();
        }
        String B = z20.B("calendar_open_by_user");
        return !TextUtils.isEmpty(B) && B.equals("true");
    }

    public static boolean b(Collection collection) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-150899684") ? ((Boolean) ipChange.ipc$dispatch("-150899684", new Object[]{collection})).booleanValue() : collection == null || collection.size() == 0;
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055287011")) {
            ipChange.ipc$dispatch("-2055287011", new Object[0]);
        } else {
            z20.T("calendar_open_by_user", "true");
        }
    }
}
