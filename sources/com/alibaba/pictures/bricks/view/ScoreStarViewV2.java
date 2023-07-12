package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ScoreStarViewV2 extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int WHITE_TYPE = 2;
    public static final int YELLOW_TYPE = 1;
    private int[] mDrawable;
    private int[] mDrawableWhite;
    private int[] mDrawableYellow;
    private List<View> mIconList;
    private int mType;
    private int starHeight;
    private int starWidth;

    public ScoreStarViewV2(Context context) {
        super(context);
        this.mIconList = new ArrayList();
        this.mDrawableYellow = new int[]{R$drawable.bricks_score_yellow_star1, R$drawable.bricks_score_yellow_star2, R$drawable.bricks_score_yellow_star3};
        this.mDrawableWhite = new int[]{R$drawable.bricks_score_white_star1, R$drawable.bricks_score_white_star2, R$drawable.bricks_score_white_star3};
        this.mDrawable = new int[3];
        this.mType = 1;
        this.starWidth = 0;
        this.starHeight = 0;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664745505")) {
            ipChange.ipc$dispatch("-664745505", new Object[]{this});
            return;
        }
        setOrientation(0);
        removeAllViews();
        int i = this.mType;
        if (i == 1) {
            this.mDrawable = this.mDrawableYellow;
        } else if (i == 2) {
            this.mDrawable = this.mDrawableWhite;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R$layout.bricks_common_score_star_layoutv, (ViewGroup) null, false);
        if (this.mIconList == null) {
            this.mIconList = new ArrayList();
        }
        this.mIconList.clear();
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (this.starWidth > 0) {
                linearLayout.getChildAt(i2).getLayoutParams().width = this.starWidth;
            }
            if (this.starHeight > 0) {
                linearLayout.getChildAt(i2).getLayoutParams().height = this.starHeight;
            }
            this.mIconList.add(linearLayout.getChildAt(i2));
        }
        addView(linearLayout);
    }

    public void updateView(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678265016")) {
            ipChange.ipc$dispatch("678265016", new Object[]{this, Double.valueOf(d)});
            return;
        }
        List<View> list = this.mIconList;
        if (list == null || list.size() != 5) {
            return;
        }
        if (d <= 0.9d) {
            for (int i = 0; i < this.mIconList.size(); i++) {
                this.mIconList.get(i).setBackgroundResource(this.mDrawable[2]);
            }
        } else if (d > 0.9d && d <= 1.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[1]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 1.9d && d <= 2.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 2.9d && d <= 3.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[1]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 3.9d && d <= 4.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 4.9d && d <= 5.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[1]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 5.9d && d <= 6.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[2]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 6.9d && d <= 7.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[1]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 7.9d && d <= 8.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[2]);
        } else if (d > 8.9d && d <= 9.9d) {
            this.mIconList.get(0).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(1).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(2).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(3).setBackgroundResource(this.mDrawable[0]);
            this.mIconList.get(4).setBackgroundResource(this.mDrawable[1]);
        } else if (d > 9.9d) {
            for (int i2 = 0; i2 < this.mIconList.size(); i2++) {
                this.mIconList.get(i2).setBackgroundResource(this.mDrawable[0]);
            }
        }
    }

    public ScoreStarViewV2(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIconList = new ArrayList();
        this.mDrawableYellow = new int[]{R$drawable.bricks_score_yellow_star1, R$drawable.bricks_score_yellow_star2, R$drawable.bricks_score_yellow_star3};
        this.mDrawableWhite = new int[]{R$drawable.bricks_score_white_star1, R$drawable.bricks_score_white_star2, R$drawable.bricks_score_white_star3};
        this.mDrawable = new int[3];
        this.mType = 1;
        this.starWidth = 0;
        this.starHeight = 0;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ScoreStarView);
        this.mType = obtainStyledAttributes.getInt(R$styleable.ScoreStarView_colorType, 1);
        this.starWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScoreStarView_star_width, 0);
        this.starHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScoreStarView_star_height, 0);
        obtainStyledAttributes.recycle();
        initView();
    }
}
