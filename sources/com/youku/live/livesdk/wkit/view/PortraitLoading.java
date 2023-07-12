package com.youku.live.livesdk.wkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.R;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PortraitLoading extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Runnable actionStart;
    private Runnable actionStop;
    RotateAnimation rotateAnim;

    public PortraitLoading(Context context) {
        super(context);
        this.rotateAnim = null;
        this.actionStart = new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-244133626")) {
                    ipChange.ipc$dispatch("-244133626", new Object[]{this});
                } else {
                    PortraitLoading.this.initAnim();
                }
            }
        };
        this.actionStop = new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-440647131")) {
                    ipChange.ipc$dispatch("-440647131", new Object[]{this});
                    return;
                }
                RotateAnimation rotateAnimation = PortraitLoading.this.rotateAnim;
                if (rotateAnimation == null || !rotateAnimation.hasStarted()) {
                    return;
                }
                PortraitLoading.this.rotateAnim.cancel();
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1947597557")) {
            ipChange.ipc$dispatch("-1947597557", new Object[]{this});
        } else if (this.rotateAnim == null) {
            setImageResource(R.C7959drawable.dago_container_buffering_circle);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.rotateAnim = rotateAnimation;
            rotateAnimation.setRepeatCount(-1);
            this.rotateAnim.setDuration(600L);
            this.rotateAnim.setInterpolator(new LinearInterpolator());
            setAnimation(this.rotateAnim);
        }
    }

    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769556388")) {
            ipChange.ipc$dispatch("-769556388", new Object[]{this});
        } else {
            startAnimation(false);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921089140")) {
            ipChange.ipc$dispatch("-1921089140", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        super.onVisibilityChanged(view, i);
        if (i == 8 || i == 4) {
            stop();
        }
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331740996")) {
            ipChange.ipc$dispatch("-1331740996", new Object[]{this});
            return;
        }
        removeCallbacks(this.actionStop);
        post(this.actionStart);
    }

    public void startAnimation(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795627542")) {
            ipChange.ipc$dispatch("-1795627542", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            post(new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-637160636")) {
                        ipChange2.ipc$dispatch("-637160636", new Object[]{this});
                    } else {
                        PortraitLoading.this.start();
                    }
                }
            });
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307257302")) {
            ipChange.ipc$dispatch("-307257302", new Object[]{this});
            return;
        }
        removeCallbacks(this.actionStart);
        post(this.actionStop);
    }

    public PortraitLoading(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rotateAnim = null;
        this.actionStart = new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-244133626")) {
                    ipChange.ipc$dispatch("-244133626", new Object[]{this});
                } else {
                    PortraitLoading.this.initAnim();
                }
            }
        };
        this.actionStop = new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-440647131")) {
                    ipChange.ipc$dispatch("-440647131", new Object[]{this});
                    return;
                }
                RotateAnimation rotateAnimation = PortraitLoading.this.rotateAnim;
                if (rotateAnimation == null || !rotateAnimation.hasStarted()) {
                    return;
                }
                PortraitLoading.this.rotateAnim.cancel();
            }
        };
        init();
    }

    public PortraitLoading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rotateAnim = null;
        this.actionStart = new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-244133626")) {
                    ipChange.ipc$dispatch("-244133626", new Object[]{this});
                } else {
                    PortraitLoading.this.initAnim();
                }
            }
        };
        this.actionStop = new Runnable() { // from class: com.youku.live.livesdk.wkit.view.PortraitLoading.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-440647131")) {
                    ipChange.ipc$dispatch("-440647131", new Object[]{this});
                    return;
                }
                RotateAnimation rotateAnimation = PortraitLoading.this.rotateAnim;
                if (rotateAnimation == null || !rotateAnimation.hasStarted()) {
                    return;
                }
                PortraitLoading.this.rotateAnim.cancel();
            }
        };
        init();
    }
}
