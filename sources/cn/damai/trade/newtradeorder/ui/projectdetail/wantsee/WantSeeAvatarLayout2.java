package cn.damai.trade.newtradeorder.ui.projectdetail.wantsee;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class WantSeeAvatarLayout2 extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int ANIMATION_DURATION = 1000;
    private static final int MAX_AVATAR_COUNT = 5;
    static boolean isNeedDeleteLast;
    private List<String> mAllUris;
    private List<View> mAllViews;
    private int mAnimXOffset;
    private ValueAnimator mAnimator;
    private Context mContext;
    private float mImageOffset;
    private boolean mIsReverse;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ View b;

        a(ImageView imageView, View view) {
            this.a = imageView;
            this.b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "195828615")) {
                ipChange.ipc$dispatch("195828615", new Object[]{this, valueAnimator});
                return;
            }
            WantSeeAvatarLayout2.this.mAnimXOffset = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float currentPlayTime = ((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration());
            this.a.setAlpha(currentPlayTime);
            if (WantSeeAvatarLayout2.isNeedDeleteLast && (view = this.b) != null) {
                view.setAlpha(1.0f - currentPlayTime);
            }
            WantSeeAvatarLayout2.this.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "661788343")) {
                ipChange.ipc$dispatch("661788343", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            WantSeeAvatarLayout2.this.mAnimXOffset = 0;
            int childCount = WantSeeAvatarLayout2.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WantSeeAvatarLayout2.this.getChildAt(i).setAlpha(1.0f);
            }
            if (WantSeeAvatarLayout2.isNeedDeleteLast) {
                WantSeeAvatarLayout2.this.removeViewAt(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1120964016")) {
                ipChange.ipc$dispatch("-1120964016", new Object[]{this, animator});
            } else {
                super.onAnimationStart(animator);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1456745865")) {
                ipChange.ipc$dispatch("1456745865", new Object[]{this, valueAnimator});
                return;
            }
            WantSeeAvatarLayout2.this.mAnimXOffset = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.a.setAlpha(1.0f - (((float) valueAnimator.getCurrentPlayTime()) / ((float) valueAnimator.getDuration())));
            WantSeeAvatarLayout2.this.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d extends AnimatorListenerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "646269625")) {
                ipChange.ipc$dispatch("646269625", new Object[]{this, animator});
                return;
            }
            super.onAnimationEnd(animator);
            WantSeeAvatarLayout2.this.mAnimXOffset = 0;
            int childCount = WantSeeAvatarLayout2.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WantSeeAvatarLayout2.this.getChildAt(i).setAlpha(1.0f);
            }
            WantSeeAvatarLayout2.this.removeViewAt(this.a - 1);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1145417170")) {
                ipChange.ipc$dispatch("1145417170", new Object[]{this, animator});
            } else {
                super.onAnimationStart(animator);
            }
        }
    }

    public WantSeeAvatarLayout2(Context context) {
        super(context);
        this.mAllUris = new ArrayList();
        this.mAllViews = new ArrayList();
        this.mIsReverse = false;
        this.mImageOffset = 0.3f;
        this.mAnimXOffset = 0;
        this.mContext = context;
    }

    private void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303698803")) {
            ipChange.ipc$dispatch("-1303698803", new Object[]{this});
            return;
        }
        removeAllViews();
        for (int i = 0; i < this.mAllUris.size() && i < 5; i++) {
            ImageView imageView = (ImageView) LayoutInflater.from(this.mContext).inflate(R$layout.want_see_avatarlist_item, (ViewGroup) this, false);
            DMImageCreator c2 = cn.damai.common.image.a.b().h(this.mContext).c(this.mAllUris.get(i));
            int i2 = R$drawable.uikit_user_default_icon;
            c2.i(i2).c(i2).k(new yq()).g(imageView);
            addView(imageView);
        }
    }

    public void append(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826092466")) {
            ipChange.ipc$dispatch("826092466", new Object[]{this, str});
            return;
        }
        this.mAllUris.add(str);
        refresh();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-464479234") ? (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-464479234", new Object[]{this, attributeSet}) : new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void initData(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880268839")) {
            ipChange.ipc$dispatch("-1880268839", new Object[]{this, list});
        } else if (list == null || list.size() == 0) {
        } else {
            this.mAllUris = list;
            refresh();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605774917")) {
            ipChange.ipc$dispatch("-1605774917", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.mAllViews.clear();
        getWidth();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            childAt.getMeasuredWidth();
            int i7 = ((ViewGroup.MarginLayoutParams) childAt.getLayoutParams()).leftMargin;
            this.mAllViews.add(childAt);
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        Collections.reverse(this.mAllViews);
        if (this.mIsReverse) {
            Collections.reverse(this.mAllViews);
        }
        for (int i8 = 0; i8 < this.mAllViews.size(); i8++) {
            View view = this.mAllViews.get(i8);
            if (view.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (i8 == 0) {
                    i5 = marginLayoutParams.leftMargin;
                } else {
                    i5 = marginLayoutParams.leftMargin;
                }
                int i9 = i5 + paddingLeft;
                int i10 = marginLayoutParams.topMargin + paddingTop;
                view.layout(i9, i10, view.getMeasuredWidth() + i9, view.getMeasuredHeight() + i10);
                paddingLeft = (int) (paddingLeft + (((view.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) - (this.mImageOffset * view.getWidth())));
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        int i3 = 0;
        if (AndroidInstantRuntime.support(ipChange, "210513353")) {
            ipChange.ipc$dispatch("210513353", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i8 = size2;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i9 = i4 + measuredWidth;
            if (i9 > (size - getPaddingLeft()) - getPaddingRight()) {
                i7 += i6;
                i5 = Math.max(i5, i4);
                i6 = measuredHeight;
                i4 = measuredWidth;
            } else {
                i6 = Math.max(i6, measuredHeight);
                i4 = i9;
            }
            if (i3 == childCount - 1) {
                i7 += i6;
                i5 = Math.max(i4, i5);
            }
            i3++;
            size2 = i8;
        }
        int i10 = size2;
        if (mode != 1073741824) {
            size = i5;
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i10 : i7);
    }

    public void remove(String str, WantSeeAvatarListListener wantSeeAvatarListListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649040404")) {
            ipChange.ipc$dispatch("-649040404", new Object[]{this, str, wantSeeAvatarListListener});
        } else if (TextUtils.isEmpty(str) || !this.mAllUris.contains(str)) {
        } else {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            int measuredWidth = childAt.getMeasuredWidth();
            this.mAllUris.remove(str);
            ValueAnimator ofInt = ValueAnimator.ofInt((int) (measuredWidth * this.mImageOffset), 0);
            this.mAnimator = ofInt;
            ofInt.setDuration(1000L);
            this.mAnimator.addUpdateListener(new c(childAt));
            this.mAnimator.addListener(new d(childCount));
            this.mAnimator.start();
        }
    }

    public void setReverse(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073033842")) {
            ipChange.ipc$dispatch("2073033842", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsReverse = z;
        }
    }

    public void setSpWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1478455208")) {
            ipChange.ipc$dispatch("1478455208", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @SuppressLint({"NewApi"})
    public void append(String str, WantSeeAvatarListListener wantSeeAvatarListListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "422507522")) {
            ipChange.ipc$dispatch("422507522", new Object[]{this, str, wantSeeAvatarListListener});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mAllUris.add(str);
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (getChildCount() >= 5) {
                isNeedDeleteLast = true;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(this.mContext).inflate(R$layout.want_see_avatarlist_item, (ViewGroup) this, false);
            DMImageCreator c2 = cn.damai.common.image.a.b().h(this.mContext).c(str);
            int i = R$drawable.uikit_user_default_icon;
            c2.i(i).c(i).k(new yq()).g(imageView);
            addView(imageView);
            View childAt = getChildAt(0);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) (childAt.getMeasuredWidth() * (1.0f - this.mImageOffset)));
            this.mAnimator = ofInt;
            ofInt.setDuration(1000L);
            this.mAnimator.addUpdateListener(new a(imageView, childAt));
            this.mAnimator.addListener(new b());
            this.mAnimator.start();
        }
    }

    public WantSeeAvatarLayout2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAllUris = new ArrayList();
        this.mAllViews = new ArrayList();
        this.mIsReverse = false;
        this.mImageOffset = 0.3f;
        this.mAnimXOffset = 0;
        this.mContext = context;
    }

    public void remove(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249161864")) {
            ipChange.ipc$dispatch("249161864", new Object[]{this, str});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mAllUris.remove(str);
        refresh();
    }

    public WantSeeAvatarLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAllUris = new ArrayList();
        this.mAllViews = new ArrayList();
        this.mIsReverse = false;
        this.mImageOffset = 0.3f;
        this.mAnimXOffset = 0;
        this.mContext = context;
    }
}
