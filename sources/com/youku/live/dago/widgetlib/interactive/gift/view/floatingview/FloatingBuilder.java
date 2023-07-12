package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.ScaleFloatingTransition;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingTransition;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FloatingBuilder {
    private static transient /* synthetic */ IpChange $ipChange;
    private FloatingElement mFloatingElement;

    public FloatingBuilder() {
        FloatingElement floatingElement = new FloatingElement();
        this.mFloatingElement = floatingElement;
        floatingElement.targetViewLayoutResId = -1;
    }

    public FloatingBuilder anchorView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502706418")) {
            return (FloatingBuilder) ipChange.ipc$dispatch("-502706418", new Object[]{this, view});
        }
        this.mFloatingElement.anchorView = view;
        return this;
    }

    public FloatingElement build() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124008509")) {
            return (FloatingElement) ipChange.ipc$dispatch("2124008509", new Object[]{this});
        }
        FloatingElement floatingElement = this.mFloatingElement;
        if (floatingElement.targetView == null && floatingElement.targetViewLayoutResId == -1) {
            throw new NullPointerException("TargetView should not be null");
        }
        Objects.requireNonNull(floatingElement.anchorView, "AnchorView should not be null");
        if (floatingElement.floatingTransition == null) {
            floatingElement.floatingTransition = new ScaleFloatingTransition();
        }
        return this.mFloatingElement;
    }

    public FloatingBuilder floatingTransition(FloatingTransition floatingTransition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055317174")) {
            return (FloatingBuilder) ipChange.ipc$dispatch("-1055317174", new Object[]{this, floatingTransition});
        }
        this.mFloatingElement.floatingTransition = floatingTransition;
        return this;
    }

    public FloatingBuilder offsetX(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "463231630")) {
            return (FloatingBuilder) ipChange.ipc$dispatch("463231630", new Object[]{this, Integer.valueOf(i)});
        }
        this.mFloatingElement.offsetX = i;
        return this;
    }

    public FloatingBuilder offsetY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1631427885")) {
            return (FloatingBuilder) ipChange.ipc$dispatch("1631427885", new Object[]{this, Integer.valueOf(i)});
        }
        this.mFloatingElement.offsetY = i;
        return this;
    }

    public FloatingBuilder targetView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476597938")) {
            return (FloatingBuilder) ipChange.ipc$dispatch("476597938", new Object[]{this, view});
        }
        this.mFloatingElement.targetView = view;
        return this;
    }

    public FloatingBuilder targetView(@LayoutRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29802783")) {
            return (FloatingBuilder) ipChange.ipc$dispatch("-29802783", new Object[]{this, Integer.valueOf(i)});
        }
        this.mFloatingElement.targetViewLayoutResId = i;
        return this;
    }
}
