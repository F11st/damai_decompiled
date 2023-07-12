package cn.damai.trade.fab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ScrollView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.trade.R$color;
import cn.damai.trade.R$dimen;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$styleable;
import cn.damai.trade.fab.ObservableScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class FloatingActionButton extends ImageButton {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int TRANSLATE_DURATION_MILLIS = 200;
    public static final int TYPE_MINI = 1;
    public static final int TYPE_NORMAL = 0;
    private int mColorDisabled;
    private int mColorNormal;
    private int mColorPressed;
    private int mColorRipple;
    private final Interpolator mInterpolator;
    private boolean mMarginsSet;
    private int mScrollThreshold;
    private boolean mShadow;
    private int mShadowSize;
    private int mType;
    private boolean mVisible;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class AbsListViewScrollDetectorImpl extends AbsListViewScrollDetector {
        private static transient /* synthetic */ IpChange $ipChange;
        private AbsListView.OnScrollListener mOnScrollListener;
        private ScrollDirectionListener mScrollDirectionListener;

        private AbsListViewScrollDetectorImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScrollDirectionListener(ScrollDirectionListener scrollDirectionListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "945912560")) {
                ipChange.ipc$dispatch("945912560", new Object[]{this, scrollDirectionListener});
            } else {
                this.mScrollDirectionListener = scrollDirectionListener;
            }
        }

        @Override // cn.damai.trade.fab.AbsListViewScrollDetector, android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "631369517")) {
                ipChange.ipc$dispatch("631369517", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i, i2, i3);
            }
            super.onScroll(absListView, i, i2, i3);
        }

        @Override // cn.damai.trade.fab.AbsListViewScrollDetector
        public void onScrollDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "182013551")) {
                ipChange.ipc$dispatch("182013551", new Object[]{this});
                return;
            }
            FloatingActionButton.this.show();
            ScrollDirectionListener scrollDirectionListener = this.mScrollDirectionListener;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollDown();
            }
        }

        @Override // cn.damai.trade.fab.AbsListViewScrollDetector, android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1840520944")) {
                ipChange.ipc$dispatch("-1840520944", new Object[]{this, absListView, Integer.valueOf(i)});
                return;
            }
            AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
            super.onScrollStateChanged(absListView, i);
        }

        @Override // cn.damai.trade.fab.AbsListViewScrollDetector
        public void onScrollUp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1986788566")) {
                ipChange.ipc$dispatch("1986788566", new Object[]{this});
                return;
            }
            FloatingActionButton.this.hide();
            ScrollDirectionListener scrollDirectionListener = this.mScrollDirectionListener;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollUp();
            }
        }

        public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1878015708")) {
                ipChange.ipc$dispatch("1878015708", new Object[]{this, onScrollListener});
            } else {
                this.mOnScrollListener = onScrollListener;
            }
        }

        /* synthetic */ AbsListViewScrollDetectorImpl(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class RecyclerViewScrollDetectorImpl extends RecyclerViewScrollDetector {
        private static transient /* synthetic */ IpChange $ipChange;
        private ScrollDirectionListener b;
        private RecyclerView.OnScrollListener c;
        final /* synthetic */ FloatingActionButton d;

        @Override // cn.damai.trade.fab.RecyclerViewScrollDetector
        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1221773350")) {
                ipChange.ipc$dispatch("1221773350", new Object[]{this});
                return;
            }
            this.d.show();
            ScrollDirectionListener scrollDirectionListener = this.b;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollDown();
            }
        }

        @Override // cn.damai.trade.fab.RecyclerViewScrollDetector
        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1256818611")) {
                ipChange.ipc$dispatch("-1256818611", new Object[]{this});
                return;
            }
            this.d.hide();
            ScrollDirectionListener scrollDirectionListener = this.b;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollUp();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1652473649")) {
                ipChange.ipc$dispatch("1652473649", new Object[]{this, recyclerView, Integer.valueOf(i)});
                return;
            }
            RecyclerView.OnScrollListener onScrollListener = this.c;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(recyclerView, i);
            }
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // cn.damai.trade.fab.RecyclerViewScrollDetector, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "225062350")) {
                ipChange.ipc$dispatch("225062350", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            RecyclerView.OnScrollListener onScrollListener = this.c;
            if (onScrollListener != null) {
                onScrollListener.onScrolled(recyclerView, i, i2);
            }
            super.onScrolled(recyclerView, i, i2);
        }
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface TYPE {
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        a(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "160435872")) {
                return ((Boolean) ipChange.ipc$dispatch("160435872", new Object[]{this})).booleanValue();
            }
            ViewTreeObserver viewTreeObserver = FloatingActionButton.this.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
            FloatingActionButton.this.toggle(this.a, this.b, true);
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b extends cn.damai.trade.fab.a {
        private static transient /* synthetic */ IpChange $ipChange;
        private ScrollDirectionListener c;
        private ObservableScrollView.OnScrollChangedListener d;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(ScrollDirectionListener scrollDirectionListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1422722571")) {
                ipChange.ipc$dispatch("-1422722571", new Object[]{this, scrollDirectionListener});
            } else {
                this.c = scrollDirectionListener;
            }
        }

        @Override // cn.damai.trade.fab.a
        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2842036")) {
                ipChange.ipc$dispatch("2842036", new Object[]{this});
                return;
            }
            FloatingActionButton.this.show();
            ScrollDirectionListener scrollDirectionListener = this.c;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollDown();
            }
        }

        @Override // cn.damai.trade.fab.a
        public void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2031294811")) {
                ipChange.ipc$dispatch("2031294811", new Object[]{this});
                return;
            }
            FloatingActionButton.this.hide();
            ScrollDirectionListener scrollDirectionListener = this.c;
            if (scrollDirectionListener != null) {
                scrollDirectionListener.onScrollUp();
            }
        }

        public void e(ObservableScrollView.OnScrollChangedListener onScrollChangedListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1860057954")) {
                ipChange.ipc$dispatch("-1860057954", new Object[]{this, onScrollChangedListener});
            } else {
                this.d = onScrollChangedListener;
            }
        }

        @Override // cn.damai.trade.fab.a, cn.damai.trade.fab.ObservableScrollView.OnScrollChangedListener
        public void onScrollChanged(ScrollView scrollView, int i, int i2, int i3, int i4) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1751926428")) {
                ipChange.ipc$dispatch("-1751926428", new Object[]{this, scrollView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                return;
            }
            ObservableScrollView.OnScrollChangedListener onScrollChangedListener = this.d;
            if (onScrollChangedListener != null) {
                onScrollChangedListener.onScrollChanged(scrollView, i, i2, i3, i4);
            }
            super.onScrollChanged(scrollView, i, i2, i3, i4);
        }

        /* synthetic */ b(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private Drawable createDrawable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2109864618")) {
            return (Drawable) ipChange.ipc$dispatch("-2109864618", new Object[]{this, Integer.valueOf(i)});
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(i);
        if (!this.mShadow || hasLollipopApi()) {
            return shapeDrawable;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{getResources().getDrawable(this.mType == 0 ? R$drawable.fab_shadow : R$drawable.fab_shadow_mini), shapeDrawable});
        int i2 = this.mShadowSize;
        layerDrawable.setLayerInset(1, i2, i2, i2, i2);
        return layerDrawable;
    }

    private static int darkenColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420930217")) {
            return ((Integer) ipChange.ipc$dispatch("420930217", new Object[]{Integer.valueOf(i)})).intValue();
        }
        Color.colorToHSV(i, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 0.9f};
        return Color.HSVToColor(fArr);
    }

    private int getColor(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "695566666") ? ((Integer) ipChange.ipc$dispatch("695566666", new Object[]{this, Integer.valueOf(i)})).intValue() : getResources().getColor(i);
    }

    private int getDimension(@DimenRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2088963379") ? ((Integer) ipChange.ipc$dispatch("-2088963379", new Object[]{this, Integer.valueOf(i)})).intValue() : getResources().getDimensionPixelSize(i);
    }

    private int getMarginBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423734251")) {
            return ((Integer) ipChange.ipc$dispatch("-423734251", new Object[]{this})).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return 0;
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1161804815") ? (TypedArray) ipChange.ipc$dispatch("-1161804815", new Object[]{this, context, attributeSet, iArr}) : context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private boolean hasHoneycombApi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1455217661") ? ((Boolean) ipChange.ipc$dispatch("1455217661", new Object[]{this})).booleanValue() : Build.VERSION.SDK_INT >= 11;
    }

    private boolean hasJellyBeanApi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-457700753") ? ((Boolean) ipChange.ipc$dispatch("-457700753", new Object[]{this})).booleanValue() : Build.VERSION.SDK_INT >= 16;
    }

    private boolean hasLollipopApi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-429660216") ? ((Boolean) ipChange.ipc$dispatch("-429660216", new Object[]{this})).booleanValue() : Build.VERSION.SDK_INT >= 21;
    }

    @SuppressLint({"NewApi"})
    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622362543")) {
            ipChange.ipc$dispatch("622362543", new Object[]{this, context, attributeSet});
            return;
        }
        this.mVisible = true;
        int color = getColor(R$color.material_blue_500);
        this.mColorNormal = color;
        this.mColorPressed = darkenColor(color);
        this.mColorRipple = lightenColor(this.mColorNormal);
        this.mColorDisabled = getColor(17170432);
        this.mType = 0;
        this.mShadow = true;
        this.mScrollThreshold = getResources().getDimensionPixelOffset(R$dimen.margin_4dp);
        this.mShadowSize = getDimension(R$dimen.margin_12dp);
        if (attributeSet != null) {
            initAttributes(context, attributeSet);
        }
        updateBackground();
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287874904")) {
            ipChange.ipc$dispatch("287874904", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray typedArray = getTypedArray(context, attributeSet, R$styleable.FloatingActionButton);
        if (typedArray != null) {
            try {
                int color = typedArray.getColor(R$styleable.FloatingActionButton_fab_colorNormal, getColor(R$color.material_blue_500));
                this.mColorNormal = color;
                this.mColorPressed = typedArray.getColor(R$styleable.FloatingActionButton_fab_colorPressed, darkenColor(color));
                this.mColorRipple = typedArray.getColor(R$styleable.FloatingActionButton_fab_colorRipple, lightenColor(this.mColorNormal));
                this.mColorDisabled = typedArray.getColor(R$styleable.FloatingActionButton_fab_colorDisabled, this.mColorDisabled);
                this.mShadow = typedArray.getBoolean(R$styleable.FloatingActionButton_fab_shadow, true);
                this.mType = typedArray.getInt(R$styleable.FloatingActionButton_fab_type, 0);
            } finally {
                typedArray.recycle();
            }
        }
    }

    private static int lightenColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058614143")) {
            return ((Integer) ipChange.ipc$dispatch("-1058614143", new Object[]{Integer.valueOf(i)})).intValue();
        }
        Color.colorToHSV(i, r0);
        float[] fArr = {0.0f, 0.0f, fArr[2] * 1.1f};
        return Color.HSVToColor(fArr);
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173695485")) {
            ipChange.ipc$dispatch("-1173695485", new Object[]{this, drawable});
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void setMarginsWithoutShadow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165085516")) {
            ipChange.ipc$dispatch("165085516", new Object[]{this});
        } else if (this.mMarginsSet || !(getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int i = marginLayoutParams.leftMargin;
            int i2 = this.mShadowSize;
            marginLayoutParams.setMargins(i - i2, marginLayoutParams.topMargin - i2, marginLayoutParams.rightMargin - i2, marginLayoutParams.bottomMargin - i2);
            requestLayout();
            this.mMarginsSet = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggle(boolean z, boolean z2, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409528561")) {
            ipChange.ipc$dispatch("-1409528561", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
        } else if (this.mVisible != z || z3) {
            this.mVisible = z;
            int height = getHeight();
            if (height == 0 && !z3) {
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(new a(z, z2));
                    return;
                }
            }
            int marginBottom = z ? 0 : height + getMarginBottom();
            if (z2) {
                animate().setInterpolator(this.mInterpolator).setDuration(200L).translationY(marginBottom);
            } else {
                setTranslationY(marginBottom);
            }
            if (hasHoneycombApi()) {
                return;
            }
            setClickable(z);
        }
    }

    private void updateBackground() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35447358")) {
            ipChange.ipc$dispatch("-35447358", new Object[]{this});
        } else {
            setBackgroundCompat(new StateListDrawable());
        }
    }

    public void attachToListView(@NonNull AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892590917")) {
            ipChange.ipc$dispatch("-1892590917", new Object[]{this, absListView});
        } else {
            attachToListView(absListView, null, null);
        }
    }

    public void attachToScrollView(@NonNull ObservableScrollView observableScrollView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207658665")) {
            ipChange.ipc$dispatch("-1207658665", new Object[]{this, observableScrollView});
        } else {
            attachToScrollView(observableScrollView, null, null);
        }
    }

    public int getColorNormal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-582166664") ? ((Integer) ipChange.ipc$dispatch("-582166664", new Object[]{this})).intValue() : this.mColorNormal;
    }

    public int getColorPressed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2028717937") ? ((Integer) ipChange.ipc$dispatch("-2028717937", new Object[]{this})).intValue() : this.mColorPressed;
    }

    public int getColorRipple() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1526820239") ? ((Integer) ipChange.ipc$dispatch("1526820239", new Object[]{this})).intValue() : this.mColorRipple;
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1348868276") ? ((Integer) ipChange.ipc$dispatch("1348868276", new Object[]{this})).intValue() : this.mType;
    }

    public boolean hasShadow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-38212389") ? ((Boolean) ipChange.ipc$dispatch("-38212389", new Object[]{this})).booleanValue() : this.mShadow;
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554758793")) {
            ipChange.ipc$dispatch("-554758793", new Object[]{this});
        } else {
            hide(true);
        }
    }

    public boolean isVisible() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1454276979") ? ((Boolean) ipChange.ipc$dispatch("-1454276979", new Object[]{this})).booleanValue() : this.mVisible;
    }

    public void setColorNormal(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52766098")) {
            ipChange.ipc$dispatch("52766098", new Object[]{this, Integer.valueOf(i)});
        } else if (i != this.mColorNormal) {
            this.mColorNormal = i;
            updateBackground();
        }
    }

    public void setColorNormalResId(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842742149")) {
            ipChange.ipc$dispatch("842742149", new Object[]{this, Integer.valueOf(i)});
        } else {
            setColorNormal(getColor(i));
        }
    }

    public void setColorPressed(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9444621")) {
            ipChange.ipc$dispatch("-9444621", new Object[]{this, Integer.valueOf(i)});
        } else if (i != this.mColorPressed) {
            this.mColorPressed = i;
            updateBackground();
        }
    }

    public void setColorPressedResId(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107945156")) {
            ipChange.ipc$dispatch("2107945156", new Object[]{this, Integer.valueOf(i)});
        } else {
            setColorPressed(getColor(i));
        }
    }

    public void setColorRipple(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1006850651")) {
            ipChange.ipc$dispatch("1006850651", new Object[]{this, Integer.valueOf(i)});
        } else if (i != this.mColorRipple) {
            this.mColorRipple = i;
            updateBackground();
        }
    }

    public void setColorRippleResId(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1079419484")) {
            ipChange.ipc$dispatch("1079419484", new Object[]{this, Integer.valueOf(i)});
        } else {
            setColorRipple(getColor(i));
        }
    }

    public void setShadow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397624667")) {
            ipChange.ipc$dispatch("-1397624667", new Object[]{this, Boolean.valueOf(z)});
        } else if (z != this.mShadow) {
            this.mShadow = z;
            updateBackground();
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223306386")) {
            ipChange.ipc$dispatch("-1223306386", new Object[]{this, Integer.valueOf(i)});
        } else if (i != this.mType) {
            this.mType = i;
            updateBackground();
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599912924")) {
            ipChange.ipc$dispatch("599912924", new Object[]{this});
        } else {
            show(true);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        init(context, attributeSet);
    }

    public void attachToListView(@NonNull AbsListView absListView, ScrollDirectionListener scrollDirectionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "805974258")) {
            ipChange.ipc$dispatch("805974258", new Object[]{this, absListView, scrollDirectionListener});
        } else {
            attachToListView(absListView, scrollDirectionListener, null);
        }
    }

    public void attachToScrollView(@NonNull ObservableScrollView observableScrollView, ScrollDirectionListener scrollDirectionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880493170")) {
            ipChange.ipc$dispatch("-1880493170", new Object[]{this, observableScrollView, scrollDirectionListener});
        } else {
            attachToScrollView(observableScrollView, scrollDirectionListener, null);
        }
    }

    public void hide(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-17607619")) {
            ipChange.ipc$dispatch("-17607619", new Object[]{this, Boolean.valueOf(z)});
        } else {
            toggle(false, z, false);
        }
    }

    public void show(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417477240")) {
            ipChange.ipc$dispatch("1417477240", new Object[]{this, Boolean.valueOf(z)});
        } else {
            toggle(true, z, false);
        }
    }

    public void attachToListView(@NonNull AbsListView absListView, ScrollDirectionListener scrollDirectionListener, AbsListView.OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507571093")) {
            ipChange.ipc$dispatch("507571093", new Object[]{this, absListView, scrollDirectionListener, onScrollListener});
            return;
        }
        AbsListViewScrollDetectorImpl absListViewScrollDetectorImpl = new AbsListViewScrollDetectorImpl(this, null);
        absListViewScrollDetectorImpl.setScrollDirectionListener(scrollDirectionListener);
        absListViewScrollDetectorImpl.setOnScrollListener(onScrollListener);
        absListViewScrollDetectorImpl.setListView(absListView);
        absListViewScrollDetectorImpl.setScrollThreshold(this.mScrollThreshold);
        absListView.setOnScrollListener(absListViewScrollDetectorImpl);
    }

    public void attachToScrollView(@NonNull ObservableScrollView observableScrollView, ScrollDirectionListener scrollDirectionListener, ObservableScrollView.OnScrollChangedListener onScrollChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-977123336")) {
            ipChange.ipc$dispatch("-977123336", new Object[]{this, observableScrollView, scrollDirectionListener, onScrollChangedListener});
            return;
        }
        b bVar = new b(this, null);
        bVar.f(scrollDirectionListener);
        bVar.e(onScrollChangedListener);
        bVar.c(this.mScrollThreshold);
        observableScrollView.setOnScrollChangedListener(bVar);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        init(context, attributeSet);
    }
}
