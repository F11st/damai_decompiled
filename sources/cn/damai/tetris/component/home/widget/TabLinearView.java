package cn.damai.tetris.component.home.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TabLinearView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context mContext;
    protected int mDaSize;
    protected boolean mFakeBoldText;
    protected int mHeight;
    protected HomeTabScrollView mHorScrollView;
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

    public TabLinearView(Context context) {
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
        return AndroidInstantRuntime.support(ipChange, "1318792910") ? ((Integer) ipChange.ipc$dispatch("1318792910", new Object[]{this, Float.valueOf(f)})).intValue() : (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002192767")) {
            ipChange.ipc$dispatch("2002192767", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977623564")) {
            ipChange.ipc$dispatch("-1977623564", new Object[]{this, canvas});
        } else {
            super.onDraw(canvas);
        }
    }

    public void setDefaultPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032738815")) {
            ipChange.ipc$dispatch("1032738815", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109315454")) {
            ipChange.ipc$dispatch("-109315454", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
    }

    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1188358943")) {
            ipChange.ipc$dispatch("1188358943", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setFontSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815548988")) {
            ipChange.ipc$dispatch("-1815548988", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mXiaoSize = i;
        this.mDaSize = i2;
    }

    public void setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1999827990")) {
            ipChange.ipc$dispatch("1999827990", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHeight = i;
        }
    }

    public void setIsEqual(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674592008")) {
            ipChange.ipc$dispatch("674592008", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsEqual = z;
        }
    }

    public void setLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132166300")) {
            ipChange.ipc$dispatch("132166300", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void setLineShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15890065")) {
            ipChange.ipc$dispatch("15890065", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsShowLine = z;
        }
    }

    public void setParentView(HomeTabScrollView homeTabScrollView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740050724")) {
            ipChange.ipc$dispatch("-740050724", new Object[]{this, homeTabScrollView});
        } else {
            this.mHorScrollView = homeTabScrollView;
        }
    }

    public void setSelectTextFakeBold(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125068835")) {
            ipChange.ipc$dispatch("2125068835", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mFakeBoldText = z;
        }
    }

    public void setSpace(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938758189")) {
            ipChange.ipc$dispatch("-938758189", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mSpace = i;
        }
    }

    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129822282")) {
            ipChange.ipc$dispatch("129822282", new Object[]{this, list, onClickListener});
        }
    }

    public void startAnim(int i, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016939904")) {
            ipChange.ipc$dispatch("-2016939904", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
    }

    public void updateFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117989163")) {
            ipChange.ipc$dispatch("2117989163", new Object[]{this});
        }
    }

    public TabLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsShowLine = true;
        this.mSelectIndex = -1;
        this.mIsMove = false;
        this.mContext = context;
        initView();
    }
}
