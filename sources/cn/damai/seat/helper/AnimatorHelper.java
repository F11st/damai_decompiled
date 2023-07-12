package cn.damai.seat.helper;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.r92;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AnimatorHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ObjectAnimator a(@NonNull View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, AnimatorListenerAdapter animatorListenerAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888814001")) {
            return (ObjectAnimator) ipChange.ipc$dispatch("-1888814001", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), animatorListenerAdapter});
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(new DimensWrap(view, i, i2, i3, i4, i5, i6), "Fraction", 1.0f, 0.0f);
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(i7);
        return ofFloat;
    }

    public static ObjectAnimator b(@NonNull View view, int i, int i2, int i3, int i4, AnimatorListenerAdapter animatorListenerAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927075438")) {
            return (ObjectAnimator) ipChange.ipc$dispatch("-1927075438", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), animatorListenerAdapter});
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(new DimensWrap(view, i, i2, i3, i4), "Fraction", 1.0f, 0.0f);
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.start();
        return ofFloat;
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class DimensWrap implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private float endAlpha;
        public final int endHeight;
        public final int endWidth;
        private final int mOffsetHeight;
        private final int mOffsetWidth;
        private float startAlpha;
        public final int startHeight;
        public final int startWidth;
        public final View target;

        public DimensWrap(View view, int i, int i2, int i3, int i4) {
            this.startAlpha = 1.0f;
            this.endAlpha = 1.0f;
            this.target = view;
            this.startWidth = i;
            this.endWidth = i2;
            this.startHeight = i3;
            this.endHeight = i4;
            this.mOffsetWidth = i - i2;
            this.mOffsetHeight = i3 - i4;
        }

        public void setFraction(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1655767784")) {
                ipChange.ipc$dispatch("-1655767784", new Object[]{this, Float.valueOf(f)});
                return;
            }
            View view = this.target;
            if (view == null || view.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.target.getLayoutParams();
            layoutParams.width = (int) (this.endWidth + (this.mOffsetWidth * f));
            layoutParams.height = (int) (this.endHeight + (this.mOffsetHeight * f));
            this.target.setLayoutParams(layoutParams);
            View view2 = this.target;
            float f2 = this.endAlpha;
            view2.setAlpha(f2 + ((this.startAlpha - f2) * f));
            r92.f("animator : fraction = " + f + " , startHeight = " + this.startHeight + " , endHeight = " + this.endHeight + " , startAlpha = " + this.startAlpha + " ,endAlpha = " + this.endAlpha);
            StringBuilder sb = new StringBuilder();
            sb.append("layout : width = ");
            sb.append(layoutParams.width);
            sb.append(" , Height = ");
            sb.append(layoutParams.height);
            sb.append(" , alpha = ");
            float f3 = this.endAlpha;
            sb.append(f3 + (f * (this.startAlpha - f3)));
            r92.f(sb.toString());
        }

        public DimensWrap(View view, int i, int i2, int i3, int i4, int i5, int i6) {
            this.startAlpha = 1.0f;
            this.endAlpha = 1.0f;
            this.target = view;
            this.startWidth = i;
            this.endWidth = i2;
            this.startHeight = i3;
            this.endHeight = i4;
            this.mOffsetWidth = i - i2;
            this.mOffsetHeight = i3 - i4;
            this.startAlpha = i5;
            this.endAlpha = i6;
        }
    }
}
