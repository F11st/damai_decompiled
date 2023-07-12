package cn.damai.rank.view;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class WantSeeIconUpdate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isFollow;
    @Nullable
    private View.OnClickListener listener;
    private boolean playAnimate;
    private boolean showWantSeeIcon;

    public WantSeeIconUpdate(boolean z, boolean z2, boolean z3, @Nullable View.OnClickListener onClickListener) {
        this.showWantSeeIcon = z;
        this.isFollow = z2;
        this.playAnimate = z3;
        this.listener = onClickListener;
    }

    @Nullable
    public final View.OnClickListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2060134737") ? (View.OnClickListener) ipChange.ipc$dispatch("2060134737", new Object[]{this}) : this.listener;
    }

    public final boolean getPlayAnimate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1329533883") ? ((Boolean) ipChange.ipc$dispatch("-1329533883", new Object[]{this})).booleanValue() : this.playAnimate;
    }

    public final boolean getShowWantSeeIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1364956269") ? ((Boolean) ipChange.ipc$dispatch("-1364956269", new Object[]{this})).booleanValue() : this.showWantSeeIcon;
    }

    public final boolean isFollow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "103607905") ? ((Boolean) ipChange.ipc$dispatch("103607905", new Object[]{this})).booleanValue() : this.isFollow;
    }

    public final void setFollow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902580043")) {
            ipChange.ipc$dispatch("-902580043", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isFollow = z;
        }
    }

    public final void setListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815808349")) {
            ipChange.ipc$dispatch("815808349", new Object[]{this, onClickListener});
        } else {
            this.listener = onClickListener;
        }
    }

    public final void setPlayAnimate(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640765401")) {
            ipChange.ipc$dispatch("-1640765401", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.playAnimate = z;
        }
    }

    public final void setShowWantSeeIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949202585")) {
            ipChange.ipc$dispatch("1949202585", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.showWantSeeIcon = z;
        }
    }

    public /* synthetic */ WantSeeIconUpdate(boolean z, boolean z2, boolean z3, View.OnClickListener onClickListener, int i, k50 k50Var) {
        this(z, z2, z3, (i & 8) != 0 ? null : onClickListener);
    }
}
