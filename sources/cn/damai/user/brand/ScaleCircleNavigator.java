package cn.damai.user.brand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.NavigatorHelper;
import net.lucode.hackware.magicindicator.abs.IPagerNavigator;
import tb.wr2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ScaleCircleNavigator extends View implements NavigatorHelper.OnNavigatorScrollListener, IPagerNavigator {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCircleClickListener mCircleClickListener;
    private int mCircleCount;
    private List<PointF> mCirclePoints;
    private SparseArray<Float> mCircleRadiusArray;
    private int mCircleSpacing;
    private float mDownX;
    private float mDownY;
    private boolean mFollowTouch;
    private int mMaxRadius;
    private int mMinRadius;
    private NavigatorHelper mNavigatorHelper;
    private int mNormalCircleColor;
    private Paint mPaint;
    private int mSelectedCircleColor;
    private Interpolator mStartInterpolator;
    private int mTouchSlop;
    private boolean mTouchable;
    private int selectIndex;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnCircleClickListener {
        void onClick(int i);
    }

    public ScaleCircleNavigator(Context context) {
        super(context);
        this.mNormalCircleColor = -3355444;
        this.mSelectedCircleColor = -7829368;
        this.mPaint = new Paint(1);
        this.mCirclePoints = new ArrayList();
        this.mCircleRadiusArray = new SparseArray<>();
        this.selectIndex = 0;
        this.mFollowTouch = true;
        this.mNavigatorHelper = new NavigatorHelper();
        this.mStartInterpolator = new LinearInterpolator();
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711600267")) {
            ipChange.ipc$dispatch("-1711600267", new Object[]{this, context});
            return;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMinRadius = wr2.a(context, 3.0d);
        this.mMaxRadius = wr2.a(context, 3.0d);
        this.mCircleSpacing = wr2.a(context, 4.0d);
        this.mNavigatorHelper.k(this);
        this.mNavigatorHelper.l(true);
    }

    private int measureHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837805972")) {
            return ((Integer) ipChange.ipc$dispatch("837805972", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.mMaxRadius * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int measureWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865776027")) {
            return ((Integer) ipChange.ipc$dispatch("1865776027", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        int i2 = this.mCircleCount;
        if (i2 <= 0) {
            return getPaddingLeft() + getPaddingRight();
        }
        return ((i2 - 1) * this.mMinRadius * 2) + (this.mMaxRadius * 2) + ((i2 - 1) * this.mCircleSpacing) + getPaddingLeft() + getPaddingRight();
    }

    private void prepareCirclePoints() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194867629")) {
            ipChange.ipc$dispatch("194867629", new Object[]{this});
            return;
        }
        this.mCirclePoints.clear();
        if (this.mCircleCount > 0) {
            int round = Math.round(getHeight() / 2.0f);
            int i = (this.mMinRadius * 2) + this.mCircleSpacing;
            int paddingLeft = this.mMaxRadius + getPaddingLeft();
            for (int i2 = 0; i2 < this.mCircleCount; i2++) {
                this.mCirclePoints.add(new PointF(paddingLeft, round));
                paddingLeft += i;
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044717634")) {
            ipChange.ipc$dispatch("-1044717634", new Object[]{this});
            return;
        }
        prepareCirclePoints();
        requestLayout();
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onAttachToMagicIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886428354")) {
            ipChange.ipc$dispatch("886428354", new Object[]{this});
        }
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onDeselected(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873551896")) {
            ipChange.ipc$dispatch("-1873551896", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mFollowTouch) {
        } else {
            this.mCircleRadiusArray.put(i, Float.valueOf(this.mMinRadius));
            invalidate();
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onDetachFromMagicIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035761563")) {
            ipChange.ipc$dispatch("-2035761563", new Object[]{this});
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149122757")) {
            ipChange.ipc$dispatch("149122757", new Object[]{this, canvas});
            return;
        }
        int size = this.mCirclePoints.size();
        for (int i = 0; i < size; i++) {
            PointF pointF = this.mCirclePoints.get(i);
            float floatValue = this.mCircleRadiusArray.get(i, Float.valueOf(this.mMinRadius)).floatValue();
            if (i == this.selectIndex) {
                this.mPaint.setColor(this.mSelectedCircleColor);
            } else {
                this.mPaint.setColor(this.mNormalCircleColor);
            }
            canvas.drawCircle(pointF.x, getHeight() / 2.0f, floatValue, this.mPaint);
        }
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onEnter(int i, int i2, float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844523266")) {
            ipChange.ipc$dispatch("1844523266", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)});
        } else if (this.mFollowTouch) {
            int i3 = this.mMinRadius;
            float interpolation = i3 + ((this.mMaxRadius - i3) * this.mStartInterpolator.getInterpolation(f));
            this.mCircleRadiusArray.put(i, Float.valueOf(interpolation));
            if (interpolation == this.mMaxRadius) {
                this.selectIndex = i;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025038694")) {
            ipChange.ipc$dispatch("-1025038694", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            prepareCirclePoints();
        }
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onLeave(int i, int i2, float f, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664068029")) {
            ipChange.ipc$dispatch("-664068029", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)});
        } else if (this.mFollowTouch) {
            int i3 = this.mMaxRadius;
            float interpolation = i3 + ((this.mMinRadius - i3) * this.mStartInterpolator.getInterpolation(f));
            this.mCircleRadiusArray.put(i, Float.valueOf(interpolation));
            if (interpolation == this.mMaxRadius) {
                this.selectIndex = i;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434581096")) {
            ipChange.ipc$dispatch("434581096", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            setMeasuredDimension(measureWidth(i), measureHeight(i2));
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274934430")) {
            ipChange.ipc$dispatch("1274934430", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mNavigatorHelper.h(i);
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20316355")) {
            ipChange.ipc$dispatch("-20316355", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        } else {
            this.mNavigatorHelper.i(i, f, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "495673705")) {
            ipChange.ipc$dispatch("495673705", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mNavigatorHelper.j(i);
        }
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onSelected(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956314999")) {
            ipChange.ipc$dispatch("-1956314999", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mFollowTouch) {
        } else {
            this.mCircleRadiusArray.put(i, Float.valueOf(this.mMaxRadius));
            this.selectIndex = i;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388634238")) {
            return ((Boolean) ipChange.ipc$dispatch("-1388634238", new Object[]{this, motionEvent})).booleanValue();
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.mCircleClickListener != null && Math.abs(x - this.mDownX) <= this.mTouchSlop && Math.abs(y - this.mDownY) <= this.mTouchSlop) {
                float f = Float.MAX_VALUE;
                int i = 0;
                for (int i2 = 0; i2 < this.mCirclePoints.size(); i2++) {
                    float abs = Math.abs(this.mCirclePoints.get(i2).x - x);
                    if (abs < f) {
                        i = i2;
                        f = abs;
                    }
                }
                this.mCircleClickListener.onClick(i);
            }
        } else if (this.mTouchable) {
            this.mDownX = x;
            this.mDownY = y;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(OnCircleClickListener onCircleClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "569163697")) {
            ipChange.ipc$dispatch("569163697", new Object[]{this, onCircleClickListener});
            return;
        }
        if (!this.mTouchable) {
            this.mTouchable = true;
        }
        this.mCircleClickListener = onCircleClickListener;
    }

    public void setCircleCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1124232707")) {
            ipChange.ipc$dispatch("-1124232707", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mCircleCount = i;
        this.mNavigatorHelper.m(i);
    }

    public void setCircleSpacing(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576398543")) {
            ipChange.ipc$dispatch("-576398543", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mCircleSpacing = i;
        prepareCirclePoints();
        invalidate();
    }

    public void setFollowTouch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1961129533")) {
            ipChange.ipc$dispatch("1961129533", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mFollowTouch = z;
        }
    }

    public void setMaxRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530853516")) {
            ipChange.ipc$dispatch("-1530853516", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mMaxRadius = i;
        prepareCirclePoints();
        invalidate();
    }

    public void setMinRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291452642")) {
            ipChange.ipc$dispatch("291452642", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mMinRadius = i;
        prepareCirclePoints();
        invalidate();
    }

    public void setNormalCircleColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265159574")) {
            ipChange.ipc$dispatch("-1265159574", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mNormalCircleColor = i;
        invalidate();
    }

    public void setSelectedCircleColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1011756490")) {
            ipChange.ipc$dispatch("-1011756490", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSelectedCircleColor = i;
        invalidate();
    }

    public void setSkimOver(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026455745")) {
            ipChange.ipc$dispatch("-1026455745", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mNavigatorHelper.l(z);
        }
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380919113")) {
            ipChange.ipc$dispatch("380919113", new Object[]{this, interpolator});
            return;
        }
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setTouchable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1678698440")) {
            ipChange.ipc$dispatch("1678698440", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mTouchable = z;
        }
    }
}
