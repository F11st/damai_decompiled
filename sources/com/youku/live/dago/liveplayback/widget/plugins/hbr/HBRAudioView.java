package com.youku.live.dago.liveplayback.widget.plugins.hbr;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HBRAudioView extends LazyInflatedView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "HBRAudioView";
    private LottieAnimationView mLottieAudioChangedView;
    private HBRAudioPlugin mPresenter;

    public HBRAudioView(Context context, ILMLayerManager iLMLayerManager, String str) {
        super(context, iLMLayerManager, str, R.C7935layout.dago_hbr_audio_view);
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    public void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1393606612")) {
            ipChange.ipc$dispatch("-1393606612", new Object[]{this, view});
            return;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.dago_hbr_audio);
        this.mLottieAudioChangedView = lottieAnimationView;
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.hbr.HBRAudioView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-940637921")) {
                    ipChange2.ipc$dispatch("-940637921", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1503913584")) {
                    ipChange2.ipc$dispatch("1503913584", new Object[]{this, animator});
                } else {
                    HBRAudioView.this.hide();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1372937694")) {
                    ipChange2.ipc$dispatch("1372937694", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "707540937")) {
                    ipChange2.ipc$dispatch("707540937", new Object[]{this, animator});
                }
            }
        });
    }

    public void setPresenter(HBRAudioPlugin hBRAudioPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624593872")) {
            ipChange.ipc$dispatch("-1624593872", new Object[]{this, hBRAudioPlugin});
        } else {
            this.mPresenter = hBRAudioPlugin;
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295471585")) {
            ipChange.ipc$dispatch("-1295471585", new Object[]{this});
            return;
        }
        super.show();
        this.mLottieAudioChangedView.playAnimation();
    }
}
