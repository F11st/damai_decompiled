package cn.damai.uikit.irecycler.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$anim;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$string;
import cn.damai.uikit.irecycler.RefreshTrigger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullToRefreshArrowLoadingView extends FrameLayout implements RefreshTrigger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_HEADER_VIEW_HEIGHT = 70;
    private ImageView mArrow;
    private int mHeight;
    private ProgressBar mProgressBar;
    private TextView mRefreshText;
    private Animation mRotateDown;
    private Animation mRotateUp;
    private boolean mRotated;

    public PullToRefreshArrowLoadingView(Context context) {
        this(context, null);
    }

    public static PullToRefreshArrowLoadingView getInstance(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673618409")) {
            return (PullToRefreshArrowLoadingView) ipChange.ipc$dispatch("-673618409", new Object[]{context});
        }
        PullToRefreshArrowLoadingView pullToRefreshArrowLoadingView = new PullToRefreshArrowLoadingView(context);
        pullToRefreshArrowLoadingView.setLayoutParams(new LinearLayout.LayoutParams(-1, q60.a(context, 70.0f)));
        return pullToRefreshArrowLoadingView;
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978179228")) {
            ipChange.ipc$dispatch("978179228", new Object[]{this});
            return;
        }
        this.mRotated = false;
        this.mArrow.clearAnimation();
        this.mArrow.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mRefreshText.setText(getResources().getString(R$string.pull_to_refresh_text));
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onMove(boolean z, boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124990721")) {
            ipChange.ipc$dispatch("-2124990721", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
        } else if (z) {
        } else {
            this.mArrow.setVisibility(0);
            this.mProgressBar.setVisibility(8);
            if (i <= this.mHeight) {
                if (this.mRotated) {
                    this.mArrow.clearAnimation();
                    this.mArrow.startAnimation(this.mRotateDown);
                    this.mRotated = false;
                }
                this.mRefreshText.setText(getResources().getString(R$string.pull_to_refresh_text));
                return;
            }
            this.mRefreshText.setText(getResources().getString(R$string.release_to_refresh_text));
            if (this.mRotated) {
                return;
            }
            this.mArrow.clearAnimation();
            this.mArrow.startAnimation(this.mRotateUp);
            this.mRotated = true;
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389420474")) {
            ipChange.ipc$dispatch("389420474", new Object[]{this});
            return;
        }
        this.mArrow.clearAnimation();
        this.mArrow.setVisibility(8);
        this.mProgressBar.setVisibility(0);
        this.mRefreshText.setText(getResources().getString(R$string.loading_text));
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-805871346")) {
            ipChange.ipc$dispatch("-805871346", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1578711354")) {
            ipChange.ipc$dispatch("-1578711354", new Object[]{this});
            return;
        }
        this.mRotated = false;
        this.mArrow.clearAnimation();
        this.mArrow.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onStart(boolean z, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748301441")) {
            ipChange.ipc$dispatch("1748301441", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mHeight = i;
        this.mProgressBar.setIndeterminate(false);
    }

    public PullToRefreshArrowLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToRefreshArrowLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotated = false;
        FrameLayout.inflate(context, R$layout.pull_to_refresh_arrow_loading_layout, this);
        this.mArrow = (ImageView) findViewById(R$id.pull_to_refresh_arrow_icon);
        this.mProgressBar = (ProgressBar) findViewById(R$id.pull_to_refresh_arrow_loading_progress);
        this.mRefreshText = (TextView) findViewById(R$id.pull_to_refresh_status_text);
        this.mRotateUp = AnimationUtils.loadAnimation(context, R$anim.rotate_up);
        this.mRotateDown = AnimationUtils.loadAnimation(context, R$anim.rotate_down);
    }
}
