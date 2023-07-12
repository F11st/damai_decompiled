package cn.damai.uikit.irecycler.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.irecycler.RefreshTrigger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PullToRefreshHeaderView extends FrameLayout implements RefreshTrigger {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_HEADER_VIEW_HEIGHT = 70;
    private static boolean mIsImmersion;
    private static int mRefreshViweHeightUnitDp;
    private ImageView mAnimView;
    private AnimationDrawable mAnimationDrawable;
    private AnimationDrawable mAnimationStartDrawable;
    private boolean mCanAnimate;
    private ImageView mDefaultView;
    private int mHeight;
    private PullToRefreshListener mListener;
    private int statusHeight;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface PullToRefreshListener {
        void onComplete();

        void onMove(boolean z, boolean z2, int i, boolean z3);
    }

    public PullToRefreshHeaderView(Context context) {
        this(context, null);
    }

    public static PullToRefreshHeaderView getInstance(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2040491031") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("2040491031", new Object[]{context}) : getInstance(context, false);
    }

    private void initStatuBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688200862")) {
            ipChange.ipc$dispatch("1688200862", new Object[]{this, activity});
        } else if (mIsImmersion) {
            View findViewById = findViewById(R$id.status_bar_space);
            if (Build.VERSION.SDK_INT < 23) {
                this.statusHeight = 0;
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            } else if (findViewById != null) {
                this.statusHeight = kg2.a(activity);
                findViewById.getLayoutParams().height = this.statusHeight;
                findViewById.setVisibility(0);
            }
        }
    }

    public void clearLoadingDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404908129")) {
            ipChange.ipc$dispatch("404908129", new Object[]{this});
            return;
        }
        this.mAnimationDrawable = null;
        ImageView imageView = this.mAnimView;
        int i = R$drawable.transparent_bg;
        imageView.setBackgroundResource(i);
        this.mDefaultView.setImageResource(i);
        setBackgroundResource(i);
        this.mCanAnimate = false;
    }

    public int getRefreshLayoutHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1833926955") ? ((Integer) ipChange.ipc$dispatch("1833926955", new Object[]{this})).intValue() : getMeasuredHeight();
    }

    public int getStatusHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1212090176") ? ((Integer) ipChange.ipc$dispatch("1212090176", new Object[]{this})).intValue() : this.statusHeight;
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1740478602")) {
            ipChange.ipc$dispatch("-1740478602", new Object[]{this});
            return;
        }
        this.mDefaultView.setVisibility(0);
        this.mAnimView.setVisibility(4);
        PullToRefreshListener pullToRefreshListener = this.mListener;
        if (pullToRefreshListener != null) {
            pullToRefreshListener.onComplete();
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onMove(boolean z, boolean z2, int i) {
        PullToRefreshListener pullToRefreshListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411574043")) {
            ipChange.ipc$dispatch("-411574043", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)});
            return;
        }
        int i2 = this.mHeight;
        float f = (i / i2) * 25.0f;
        if (i >= i2) {
            this.mDefaultView.setVisibility(4);
            this.mAnimView.setVisibility(0);
            if (this.mCanAnimate && !this.mAnimationDrawable.isRunning()) {
                this.mAnimationDrawable.start();
            }
        } else {
            this.mDefaultView.setVisibility(0);
            this.mDefaultView.setImageDrawable(this.mAnimationStartDrawable.getFrame(Math.min(Math.round(f), 25)));
            this.mAnimView.setVisibility(4);
            if (this.mCanAnimate && this.mAnimationDrawable.isRunning()) {
                this.mAnimationDrawable.stop();
            }
        }
        if (z) {
            return;
        }
        if (i >= this.mHeight && (pullToRefreshListener = this.mListener) != null) {
            pullToRefreshListener.onMove(z, z2, i, true);
            return;
        }
        PullToRefreshListener pullToRefreshListener2 = this.mListener;
        if (pullToRefreshListener2 != null) {
            pullToRefreshListener2.onMove(z, z2, i, false);
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102837152")) {
            ipChange.ipc$dispatch("2102837152", new Object[]{this});
            return;
        }
        this.mDefaultView.setVisibility(4);
        this.mAnimView.setVisibility(0);
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onRelease() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907545332")) {
            ipChange.ipc$dispatch("907545332", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onReset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-875253204")) {
            ipChange.ipc$dispatch("-875253204", new Object[]{this});
            return;
        }
        this.mDefaultView.setVisibility(0);
        this.mAnimView.setVisibility(4);
        if (this.mCanAnimate && this.mAnimationDrawable.isRunning()) {
            this.mAnimationDrawable.stop();
        }
    }

    @Override // cn.damai.uikit.irecycler.RefreshTrigger
    public void onStart(boolean z, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970356389")) {
            ipChange.ipc$dispatch("-970356389", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.mHeight = i;
        }
    }

    public void setBackgroundColorBg(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622188813")) {
            ipChange.ipc$dispatch("1622188813", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mAnimView.setBackgroundColor(i);
        this.mAnimView.setImageDrawable(null);
        this.mDefaultView.setBackgroundColor(i);
        this.mDefaultView.setImageDrawable(null);
        setBackgroundColor(i);
    }

    public void setImmersion(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864468145")) {
            ipChange.ipc$dispatch("-864468145", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        mIsImmersion = z;
        initStatuBar((Activity) getContext());
    }

    public void setPullToRefreshListener(PullToRefreshListener pullToRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496623836")) {
            ipChange.ipc$dispatch("-496623836", new Object[]{this, pullToRefreshListener});
        } else {
            this.mListener = pullToRefreshListener;
        }
    }

    public PullToRefreshHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static PullToRefreshHeaderView getInstance(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-82979619") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("-82979619", new Object[]{context, Boolean.valueOf(z)}) : getInstance(context, z, R$color.transparent);
    }

    public PullToRefreshHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.statusHeight = 0;
        FrameLayout.inflate(context, R$layout.pull_to_refresh_layout, this);
        this.mDefaultView = (ImageView) findViewById(R$id.pull_to_refresh_default_view);
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.pull_to_refresh_view_layout);
        ImageView imageView = (ImageView) findViewById(R$id.pull_to_refresh_anim_view);
        this.mAnimView = imageView;
        imageView.setBackgroundResource(R$drawable.uikit_pull_to_refresh_loading);
        this.mDefaultView.setBackgroundResource(R$drawable.uikit_pull_to_refresh_starting);
        this.mAnimationStartDrawable = (AnimationDrawable) this.mDefaultView.getBackground();
        AnimationDrawable animationDrawable = (AnimationDrawable) this.mAnimView.getBackground();
        this.mAnimationDrawable = animationDrawable;
        animationDrawable.setOneShot(false);
        this.mCanAnimate = true;
        initStatuBar((Activity) context);
        if (mRefreshViweHeightUnitDp != 0) {
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, q60.a(context, mRefreshViweHeightUnitDp)));
        }
    }

    public static PullToRefreshHeaderView getInstance(Context context, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-553960436") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("-553960436", new Object[]{context, Integer.valueOf(i)}) : getInstance(context, false, i);
    }

    public static PullToRefreshHeaderView getInstance(Context context, boolean z, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1957041146") ? (PullToRefreshHeaderView) ipChange.ipc$dispatch("-1957041146", new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) : getInstance(context, 70, z, i);
    }

    public static PullToRefreshHeaderView getInstance(Context context, int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151098043")) {
            return (PullToRefreshHeaderView) ipChange.ipc$dispatch("151098043", new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        mIsImmersion = z;
        mRefreshViweHeightUnitDp = i;
        PullToRefreshHeaderView pullToRefreshHeaderView = new PullToRefreshHeaderView(context);
        pullToRefreshHeaderView.setBackgroundResource(i2);
        return pullToRefreshHeaderView;
    }
}
