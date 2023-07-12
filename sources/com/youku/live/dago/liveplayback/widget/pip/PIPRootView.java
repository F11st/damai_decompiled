package com.youku.live.dago.liveplayback.widget.pip;

import android.content.Context;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
@RequiresApi(api = 26)
/* loaded from: classes2.dex */
public class PIPRootView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout mFrameLayout;
    private TextView mPIPErrorView;
    private Rational mRational;
    private int mReferenceCount;

    public PIPRootView(@NonNull Context context) {
        super(context);
        this.mRational = new Rational(100, 100);
        LayoutInflater.from(context).inflate(R.layout.dago_pip_root_layout, this);
        TextView textView = (TextView) findViewById(R.id.tv_pip);
        this.mPIPErrorView = textView;
        textView.setContentDescription("显示PIP信息的布局");
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        this.mFrameLayout = frameLayout;
        frameLayout.setContentDescription("用来放播放器的布局");
    }

    public void addPlayerView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1671705164")) {
            ipChange.ipc$dispatch("-1671705164", new Object[]{this, view});
        } else {
            this.mFrameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void addReferenceCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "956774080")) {
            ipChange.ipc$dispatch("956774080", new Object[]{this});
        } else {
            this.mReferenceCount++;
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164008712")) {
            ipChange.ipc$dispatch("-1164008712", new Object[]{this});
            return;
        }
        this.mFrameLayout.removeAllViews();
        this.mPIPErrorView.setVisibility(8);
    }

    public void clearParentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725328969")) {
            ipChange.ipc$dispatch("1725328969", new Object[]{this});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public Rational getRational() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-104116617") ? (Rational) ipChange.ipc$dispatch("-104116617", new Object[]{this}) : this.mRational;
    }

    public int getReferenceCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1113931618") ? ((Integer) ipChange.ipc$dispatch("-1113931618", new Object[]{this})).intValue() : this.mReferenceCount;
    }

    public void hideText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930851478")) {
            ipChange.ipc$dispatch("1930851478", new Object[]{this});
        } else {
            post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.pip.PIPRootView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "253584428")) {
                        ipChange2.ipc$dispatch("253584428", new Object[]{this});
                    } else {
                        PIPRootView.this.mPIPErrorView.setVisibility(8);
                    }
                }
            });
        }
    }

    public void removeReferenceCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1122334371")) {
            ipChange.ipc$dispatch("-1122334371", new Object[]{this});
        } else {
            this.mReferenceCount--;
        }
    }

    public void setRational(Rational rational) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "295938481")) {
            ipChange.ipc$dispatch("295938481", new Object[]{this, rational});
        } else {
            this.mRational = rational;
        }
    }

    public void showText(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076019323")) {
            ipChange.ipc$dispatch("-1076019323", new Object[]{this, str});
        } else {
            post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.pip.PIPRootView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "450097933")) {
                        ipChange2.ipc$dispatch("450097933", new Object[]{this});
                        return;
                    }
                    PIPRootView.this.mPIPErrorView.setText(str);
                    PIPRootView.this.mPIPErrorView.setVisibility(0);
                }
            });
        }
    }
}
