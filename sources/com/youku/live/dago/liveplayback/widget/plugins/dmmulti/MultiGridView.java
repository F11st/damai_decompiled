package com.youku.live.dago.liveplayback.widget.plugins.dmmulti;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MultiGridView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "MultiGridView";
    private Context mContext;
    private String mCurrentSceneId;
    private double mHeight;
    private List<GridViewLayoutBean> mLayoutBeans;
    private MultiGridViewClickListener mListener;
    private Paint mPaint;
    private List<RectBean> mRectList;
    private double mWidth;
    private boolean pointInRect;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class RectBean {
        public int pos;
        public Rect rect;
        public long secenId;

        public RectBean(int i, long j, Rect rect) {
            this.pos = i;
            this.secenId = j;
            this.rect = rect;
        }
    }

    public MultiGridView(Context context) {
        super(context);
        this.mLayoutBeans = new ArrayList();
        this.mRectList = new ArrayList();
        this.mContext = context;
        init();
    }

    private void calRect() {
        double[] dArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122889987")) {
            ipChange.ipc$dispatch("1122889987", new Object[]{this});
            return;
        }
        double[] wHFor16bi9 = MultiGridViewUtil.getWHFor16bi9(getContext());
        this.mWidth = wHFor16bi9[0];
        this.mHeight = wHFor16bi9[1];
        this.mRectList.clear();
        for (int i = 0; i < this.mLayoutBeans.size(); i++) {
            GridViewLayoutBean gridViewLayoutBean = this.mLayoutBeans.get(i);
            if (gridViewLayoutBean != null && (dArr = gridViewLayoutBean.positionNormalizeds) != null && dArr.length == 2) {
                double d = dArr[0];
                double d2 = this.mWidth;
                int i2 = (int) (d * d2);
                double d3 = dArr[1];
                double d4 = this.mHeight;
                int i3 = (int) (d3 * d4);
                this.mRectList.add(new RectBean(i, gridViewLayoutBean.sceneId, new Rect(i2, i3, ((int) (gridViewLayoutBean.widthNormalized * d2)) + i2, ((int) (gridViewLayoutBean.heightNormalized * d4)) + i3)));
            }
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969231163")) {
            ipChange.ipc$dispatch("-1969231163", new Object[]{this});
            return;
        }
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(16777215);
        this.mPaint.setAntiAlias(true);
    }

    private boolean pointInRect(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026266336")) {
            return ((Boolean) ipChange.ipc$dispatch("-2026266336", new Object[]{this, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        if (this.mRectList == null) {
            return false;
        }
        for (int i = 0; i < this.mRectList.size(); i++) {
            RectBean rectBean = this.mRectList.get(i);
            Rect rect = rectBean.rect;
            if (f > rect.left && f < rect.right && f2 > rect.top && f2 < rect.bottom) {
                long j = rectBean.secenId;
                MultiGridViewClickListener multiGridViewClickListener = this.mListener;
                if (multiGridViewClickListener != null) {
                    multiGridViewClickListener.onClick(rectBean.pos, j);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102502285")) {
            ipChange.ipc$dispatch("-1102502285", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        calRect();
        if (this.mRectList == null) {
            return;
        }
        for (int i = 0; i < this.mRectList.size(); i++) {
            canvas.drawRect(this.mRectList.get(i).rect, this.mPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638529004")) {
            return ((Boolean) ipChange.ipc$dispatch("-1638529004", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.pointInRect = pointInRect(motionEvent.getX(), motionEvent.getY());
        }
        return this.pointInRect;
    }

    public void setGridViewData(GridViewBean gridViewBean, MultiGridViewClickListener multiGridViewClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996485039")) {
            ipChange.ipc$dispatch("-1996485039", new Object[]{this, gridViewBean, multiGridViewClickListener});
            return;
        }
        this.mLayoutBeans = gridViewBean.gridViewLayout;
        this.mListener = multiGridViewClickListener;
        invalidate();
    }

    public MultiGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLayoutBeans = new ArrayList();
        this.mRectList = new ArrayList();
        this.mContext = context;
        init();
    }

    public MultiGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLayoutBeans = new ArrayList();
        this.mRectList = new ArrayList();
        this.mContext = context;
        init();
    }
}
