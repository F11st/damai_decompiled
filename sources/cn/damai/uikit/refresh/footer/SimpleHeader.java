package cn.damai.uikit.refresh.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import tb.df2;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class SimpleHeader extends InternalAbstract implements RefreshHeader {
    private static transient /* synthetic */ IpChange $ipChange;
    private PullToRefreshHeaderView headerView;
    private int mBackgroundColor;
    private int mPaddingBottom;
    private int mPaddingTop;
    private RefreshKernel mRefreshKernel;
    private String pullDownToRefreshText;
    private String refreshingText;
    private String releaseToRefreshText;
    private String releaseToTwoLevelText;
    private TextView title;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.ReleaseToTwoLevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SimpleHeader(Context context) {
        this(context, null);
        this.mSpinnerStyle = df2.Translate;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1257726881")) {
            ipChange.ipc$dispatch("1257726881", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.headerView.onRelease();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25642504")) {
            return ((Integer) ipChange.ipc$dispatch("-25642504", new Object[]{this, refreshLayout, Boolean.valueOf(z)})).intValue();
        }
        this.headerView.onRelease();
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073873461")) {
            ipChange.ipc$dispatch("-2073873461", new Object[]{this, refreshKernel, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRefreshKernel = refreshKernel;
        refreshKernel.requestDrawBackgroundFor(this, this.mBackgroundColor);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158616065")) {
            ipChange.ipc$dispatch("-1158616065", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.mPaddingTop, getPaddingRight(), this.mPaddingBottom);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1718917560")) {
            ipChange.ipc$dispatch("1718917560", new Object[]{this, Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.headerView.onMove(false, false, i);
        super.onMoving(z, f, i, i2, i3);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848355995")) {
            ipChange.ipc$dispatch("-848355995", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359382839")) {
            ipChange.ipc$dispatch("-359382839", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.headerView.onStart(false, i, 0);
        this.headerView.onRefresh();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532686873")) {
            ipChange.ipc$dispatch("-532686873", new Object[]{this, refreshLayout, refreshState, refreshState2});
            return;
        }
        int i = a.a[refreshState2.ordinal()];
        if (i == 1) {
            this.headerView.onRefresh();
            this.title.setText(this.pullDownToRefreshText);
        } else if (i == 2) {
            this.headerView.onRefresh();
            this.title.setText(this.releaseToRefreshText);
        } else if (i == 3) {
            this.headerView.onComplete();
            this.title.setText(this.releaseToTwoLevelText);
        } else if (i != 4) {
        } else {
            this.title.setText(this.refreshingText);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1273312842")) {
            ipChange.ipc$dispatch("1273312842", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBackgroundColor = i;
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestDrawBackgroundFor(this, i);
        }
    }

    public void setPullDownToRefreshText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772512206")) {
            ipChange.ipc$dispatch("-772512206", new Object[]{this, str});
        } else {
            this.pullDownToRefreshText = str;
        }
    }

    public void setRefreshingText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1147048110")) {
            ipChange.ipc$dispatch("-1147048110", new Object[]{this, str});
        } else {
            this.refreshingText = str;
        }
    }

    public void setReleaseToRefreshText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909973984")) {
            ipChange.ipc$dispatch("909973984", new Object[]{this, str});
        } else {
            this.releaseToRefreshText = str;
        }
    }

    public void setReleaseToTwoLevelText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289439023")) {
            ipChange.ipc$dispatch("-1289439023", new Object[]{this, str});
        } else {
            this.releaseToTwoLevelText = str;
        }
    }

    public SimpleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mBackgroundColor = 16777215;
        this.mPaddingTop = 10;
        this.mPaddingBottom = 10;
        this.mSpinnerStyle = df2.Translate;
        View.inflate(context, R$layout.simple_refresh_header, this);
        this.headerView = (PullToRefreshHeaderView) findViewById(R$id.header_view);
        this.title = (TextView) findViewById(R$id.title);
        this.headerView.getLayoutParams().height = q60.a(context, 50.0f) + this.headerView.getStatusHeight();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a2 = q60.a(context, this.mPaddingTop);
                this.mPaddingTop = a2;
                int paddingRight = getPaddingRight();
                int a3 = q60.a(context, this.mPaddingBottom);
                this.mPaddingBottom = a3;
                setPadding(paddingLeft, a2, paddingRight, a3);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int a4 = q60.a(context, this.mPaddingTop);
                this.mPaddingTop = a4;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.mPaddingBottom = paddingBottom;
                setPadding(paddingLeft2, a4, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mPaddingTop = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a5 = q60.a(context, this.mPaddingBottom);
            this.mPaddingBottom = a5;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a5);
        } else {
            this.mPaddingTop = getPaddingTop();
            this.mPaddingBottom = getPaddingBottom();
        }
        this.headerView.onReset();
    }
}
