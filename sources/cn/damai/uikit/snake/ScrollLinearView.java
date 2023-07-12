package cn.damai.uikit.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScrollLinearView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context mContext;
    protected int mDaSize;
    protected boolean mFakeBoldText;
    protected int mHeight;
    protected HorScrollView mHorScrollView;
    protected boolean mIsEqual;
    protected boolean mIsMove;
    protected boolean mIsShowLine;
    public int mSelectIndex;
    protected int mSelectedFontColor;
    protected int mSpace;
    public boolean mSrcollStart;
    protected List<ScrollTitleBean> mTitleList;
    protected int mUnSelectedFontColor;
    protected int mXiaoSize;

    public ScrollLinearView(Context context) {
        super(context);
        this.mIsShowLine = true;
        this.mSelectIndex = -1;
        this.mIsMove = false;
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1791205815") ? ((Integer) ipChange.ipc$dispatch("1791205815", new Object[]{this, Float.valueOf(f)})).intValue() : (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-532876362")) {
            ipChange.ipc$dispatch("-532876362", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138545187")) {
            ipChange.ipc$dispatch("-2138545187", new Object[]{this, canvas});
        } else {
            super.onDraw(canvas);
        }
    }

    public void setDefaultPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1799739018")) {
            ipChange.ipc$dispatch("-1799739018", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843128697")) {
            ipChange.ipc$dispatch("843128697", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
    }

    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715674666")) {
            ipChange.ipc$dispatch("-1715674666", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setFontSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646277651")) {
            ipChange.ipc$dispatch("-1646277651", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mXiaoSize = i;
        this.mDaSize = i2;
    }

    public void setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1044851853")) {
            ipChange.ipc$dispatch("1044851853", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHeight = i;
        }
    }

    public void setIsEqual(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135102833")) {
            ipChange.ipc$dispatch("1135102833", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsEqual = z;
        }
    }

    public void setLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301437637")) {
            ipChange.ipc$dispatch("301437637", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setLineShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406823752")) {
            ipChange.ipc$dispatch("1406823752", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsShowLine = z;
        }
    }

    public void setParentView(HorScrollView horScrollView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660938583")) {
            ipChange.ipc$dispatch("1660938583", new Object[]{this, horScrollView});
        } else {
            this.mHorScrollView = horScrollView;
        }
    }

    public void setSelectTextFakeBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804112358")) {
            ipChange.ipc$dispatch("-804112358", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mFakeBoldText = z;
        }
    }

    public void setSpace(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078477436")) {
            ipChange.ipc$dispatch("2078477436", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mSpace = i;
        }
    }

    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923354957")) {
            ipChange.ipc$dispatch("-1923354957", new Object[]{this, list, onClickListener});
        }
    }

    public void startAnim(int i, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064495753")) {
            ipChange.ipc$dispatch("-1064495753", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
    }

    public void updateFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578986772")) {
            ipChange.ipc$dispatch("1578986772", new Object[]{this});
        }
    }

    public ScrollLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsShowLine = true;
        this.mSelectIndex = -1;
        this.mIsMove = false;
        this.mContext = context;
        initView();
    }
}
