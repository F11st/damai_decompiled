package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YumFloating implements ITransition, Rebound {
    private static transient /* synthetic */ IpChange $ipChange;
    private WeakReference<View> mTargetViewWeakReference;

    public YumFloating(View view) {
        this.mTargetViewWeakReference = new WeakReference<>(view);
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1959752288")) {
            ipChange.ipc$dispatch("-1959752288", new Object[]{this});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            ViewParent parent = targetView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(targetView);
                this.mTargetViewWeakReference.clear();
            }
        }
    }

    public View getTargetView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1538315837") ? (View) ipChange.ipc$dispatch("-1538315837", new Object[]{this}) : this.mTargetViewWeakReference.get();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setAlpha(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295194783")) {
            ipChange.ipc$dispatch("1295194783", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setAlpha(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setRotation(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084376659")) {
            ipChange.ipc$dispatch("1084376659", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setRotation(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setRotationX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700600101")) {
            ipChange.ipc$dispatch("-700600101", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setRotationX(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setRotationY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-699676580")) {
            ipChange.ipc$dispatch("-699676580", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setRotationY(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setScaleX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381952419")) {
            ipChange.ipc$dispatch("381952419", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setScaleX(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setScaleY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "382875940")) {
            ipChange.ipc$dispatch("382875940", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setScaleY(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setScrollX(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760738223")) {
            ipChange.ipc$dispatch("1760738223", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setScaleX(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setScrollY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761661744")) {
            ipChange.ipc$dispatch("1761661744", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setScaleY(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setTranslationX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276430620")) {
            ipChange.ipc$dispatch("1276430620", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setTranslationX(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setTranslationY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277354141")) {
            ipChange.ipc$dispatch("1277354141", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setTranslationY(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343199303")) {
            ipChange.ipc$dispatch("-1343199303", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setX(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.ITransition
    public void setY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342275782")) {
            ipChange.ipc$dispatch("-1342275782", new Object[]{this, Float.valueOf(f)});
            return;
        }
        View targetView = getTargetView();
        if (targetView != null) {
            targetView.setY(f);
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.Rebound
    public float transition(double d, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-668361146")) {
            return ((Float) ipChange.ipc$dispatch("-668361146", new Object[]{this, Double.valueOf(d), Float.valueOf(f), Float.valueOf(f2)})).floatValue();
        }
        return 0.0f;
    }
}
