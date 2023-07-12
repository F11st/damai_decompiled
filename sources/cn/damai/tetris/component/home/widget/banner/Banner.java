package cn.damai.tetris.component.home.widget.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$styleable;
import cn.damai.tetris.component.home.widget.banner.listener.OnBannerListener;
import cn.damai.tetris.component.home.widget.banner.listener.OnTagListener;
import cn.damai.tetris.component.home.widget.banner.loader.ImageLoaderInterface;
import cn.damai.uikit.banner.view.BannerViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.gh1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private BannerPagerAdapter adapter;
    private int bannerStyle;
    private TextView bannerTitle;
    private Context context;
    private int count;
    private int currentItem;
    private int delayTime;
    private DisplayMetrics dm;
    private int gravity;
    private WeakHandler handler;
    private ImageLoaderInterface imageLoader;
    private List imageUrls;
    public List<View> imageViews;
    private LinearLayout indicator;
    private List<ImageView> indicatorImages;
    private LinearLayout indicatorInside;
    private RelativeLayout indicatorLayout;
    private int indicatorSize;
    private boolean isAutoPlay;
    private boolean isScroll;
    private int lastPosition;
    private OnBannerListener listener;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorSelectedResId;
    private int mIndicatorUnselectedResId;
    private int mIndicatorWidth;
    private int mLayoutResId;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private BannerScroller mScroller;
    private TextView numIndicator;
    private TextView numIndicatorInside;
    private OnTagListener onTagListener;
    private int scaleType;
    private int scrollTime;
    public String tag;
    private final Runnable task;
    private int titleBackground;
    private int titleHeight;
    private int titleTextColor;
    private int titleTextSize;
    private LinearLayout titleView;
    private List<String> titles;
    private List<Boolean> videoList;
    private BannerViewPager viewPager;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class BannerPagerAdapter extends PagerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.home.widget.banner.Banner$BannerPagerAdapter$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC1887a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ int a;

            View$OnClickListenerC1887a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "867367432")) {
                    ipChange.ipc$dispatch("867367432", new Object[]{this, view});
                } else {
                    Banner.this.listener.OnBannerClick(Banner.this.toRealPosition(this.a));
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.tetris.component.home.widget.banner.Banner$BannerPagerAdapter$b */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC1888b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1888b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1316309495")) {
                    ipChange.ipc$dispatch("-1316309495", new Object[]{this, view});
                } else {
                    Banner.this.onTagListener.OnTagClick();
                }
            }
        }

        BannerPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "471907629")) {
                ipChange.ipc$dispatch("471907629", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            } else {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1159844604") ? ((Integer) ipChange.ipc$dispatch("-1159844604", new Object[]{this})).intValue() : Banner.this.imageViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1123858769")) {
                return ipChange.ipc$dispatch("1123858769", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            viewGroup.addView(Banner.this.imageViews.get(i));
            View view = Banner.this.imageViews.get(i);
            if (Banner.this.listener != null) {
                view.setOnClickListener(new View$OnClickListenerC1887a(i));
            }
            if (Banner.this.onTagListener != null) {
                try {
                    ViewGroup viewGroup2 = (ViewGroup) view;
                    if (viewGroup2 != null && viewGroup2.getChildCount() > 1) {
                        if (i != 0 && i != 1) {
                            viewGroup2.getChildAt(1).setVisibility(8);
                        }
                        viewGroup2.getChildAt(1).setVisibility(0);
                        viewGroup2.getChildAt(1).setOnClickListener(new View$OnClickListenerC1888b());
                    }
                } catch (Exception unused) {
                }
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "29222976") ? ((Boolean) ipChange.ipc$dispatch("29222976", new Object[]{this, view, obj})).booleanValue() : view == obj;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.widget.banner.Banner$a */
    /* loaded from: classes16.dex */
    public class View$OnAttachStateChangeListenerC1889a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC1889a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-539380748")) {
                ipChange.ipc$dispatch("-539380748", new Object[]{this, view});
            } else {
                Banner.this.startAutoPlay();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1469647729")) {
                ipChange.ipc$dispatch("1469647729", new Object[]{this, view});
            } else {
                Banner.this.stopAutoPlay();
            }
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void createIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477475213")) {
            ipChange.ipc$dispatch("-477475213", new Object[]{this});
            return;
        }
        this.indicatorImages.clear();
        this.indicator.removeAllViews();
        this.indicatorInside.removeAllViews();
        for (int i = 0; i < this.count; i++) {
            ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mIndicatorWidth, this.mIndicatorHeight);
            int i2 = this.mIndicatorMargin;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            if (i == 0) {
                imageView.setImageResource(this.mIndicatorSelectedResId);
            } else {
                imageView.setImageResource(this.mIndicatorUnselectedResId);
            }
            this.indicatorImages.add(imageView);
            int i3 = this.bannerStyle;
            if (i3 == 1 || i3 == 4) {
                this.indicator.addView(imageView, layoutParams);
            } else if (i3 == 5) {
                this.indicatorInside.addView(imageView, layoutParams);
            }
        }
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206975405")) {
            ipChange.ipc$dispatch("-1206975405", new Object[]{this, context, attributeSet});
        } else if (attributeSet == null) {
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Banner);
            this.mIndicatorWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_indicator_width, this.indicatorSize);
            this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_indicator_height, this.indicatorSize);
            this.mIndicatorMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_indicator_margin, 5);
            this.mIndicatorSelectedResId = obtainStyledAttributes.getResourceId(R$styleable.Banner_indicator_drawable_selected, R$drawable.gray_radius);
            this.mIndicatorUnselectedResId = obtainStyledAttributes.getResourceId(R$styleable.Banner_indicator_drawable_unselected, R$drawable.white_radius);
            this.scaleType = obtainStyledAttributes.getInt(R$styleable.Banner_image_scale_type, this.scaleType);
            this.delayTime = obtainStyledAttributes.getInt(R$styleable.Banner_delay_time, 2000);
            this.scrollTime = obtainStyledAttributes.getInt(R$styleable.Banner_scroll_time, 800);
            this.isAutoPlay = obtainStyledAttributes.getBoolean(R$styleable.Banner_is_auto_play, true);
            this.titleBackground = obtainStyledAttributes.getColor(R$styleable.Banner_title_background, -1);
            this.titleHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_title_height, -1);
            this.titleTextColor = obtainStyledAttributes.getColor(R$styleable.Banner_title_textcolor, -1);
            this.titleTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.Banner_title_textsize, -1);
            this.mLayoutResId = obtainStyledAttributes.getResourceId(R$styleable.Banner_layout_id, this.mLayoutResId);
            obtainStyledAttributes.recycle();
        }
    }

    private void initImages() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677221924")) {
            ipChange.ipc$dispatch("-1677221924", new Object[]{this});
            return;
        }
        this.imageViews.clear();
        int i = this.bannerStyle;
        if (i == 1 || i == 4 || i == 5) {
            createIndicator();
        } else if (i == 3) {
            TextView textView = this.numIndicatorInside;
            textView.setText("1/" + this.count);
        } else if (i == 2) {
            TextView textView2 = this.numIndicator;
            textView2.setText("1/" + this.count);
        }
    }

    private void initView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888695829")) {
            ipChange.ipc$dispatch("1888695829", new Object[]{this, context, attributeSet});
            return;
        }
        this.imageViews.clear();
        handleTypedArray(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(this.mLayoutResId, (ViewGroup) this, true);
        this.viewPager = (BannerViewPager) inflate.findViewById(R$id.bannerViewPager);
        this.titleView = (LinearLayout) inflate.findViewById(R$id.titleView);
        this.indicatorLayout = (RelativeLayout) inflate.findViewById(R$id.indicator_layout);
        this.indicator = (LinearLayout) inflate.findViewById(R$id.circleIndicator);
        this.indicatorInside = (LinearLayout) inflate.findViewById(R$id.indicatorInside);
        this.bannerTitle = (TextView) inflate.findViewById(R$id.bannerTitle);
        this.numIndicator = (TextView) inflate.findViewById(R$id.numIndicator);
        this.numIndicatorInside = (TextView) inflate.findViewById(R$id.numIndicatorInside);
        initViewPagerScroll();
        if (getTag() != null) {
            removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) getTag());
        }
        View$OnAttachStateChangeListenerC1889a view$OnAttachStateChangeListenerC1889a = new View$OnAttachStateChangeListenerC1889a();
        addOnAttachStateChangeListener(view$OnAttachStateChangeListenerC1889a);
        setTag(view$OnAttachStateChangeListenerC1889a);
    }

    private void initViewPagerScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725734411")) {
            ipChange.ipc$dispatch("725734411", new Object[]{this});
            return;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            BannerScroller bannerScroller = new BannerScroller(this.viewPager.getContext());
            this.mScroller = bannerScroller;
            bannerScroller.setDuration(this.scrollTime);
            declaredField.set(this.viewPager, this.mScroller);
        } catch (Exception e) {
            Log.e(this.tag, e.getMessage());
        }
    }

    private void setBannerStyleUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367947245")) {
            ipChange.ipc$dispatch("1367947245", new Object[]{this});
            return;
        }
        int i = this.count <= 1 ? 8 : 0;
        int i2 = this.bannerStyle;
        if (i2 == 1) {
            this.indicator.setVisibility(i);
        } else if (i2 == 2) {
            this.numIndicator.setVisibility(i);
        } else if (i2 == 3) {
            this.numIndicatorInside.setVisibility(i);
            setTitleStyleUI();
        } else if (i2 == 4) {
            this.indicator.setVisibility(i);
            setTitleStyleUI();
        } else if (i2 != 5) {
        } else {
            this.indicatorInside.setVisibility(i);
            setTitleStyleUI();
        }
    }

    private void setData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631833114")) {
            ipChange.ipc$dispatch("631833114", new Object[]{this});
            return;
        }
        this.currentItem = 1;
        if (this.adapter == null) {
            this.adapter = new BannerPagerAdapter();
            this.viewPager.addOnPageChangeListener(this);
        }
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setFocusable(true);
        this.viewPager.setCurrentItem(1);
        int i = this.gravity;
        if (i != -1) {
            this.indicator.setGravity(i);
        }
        if (this.isScroll && this.count > 1) {
            this.viewPager.setScrollable(true);
        } else {
            this.viewPager.setScrollable(false);
        }
        if (this.isAutoPlay) {
            startAutoPlay();
        }
    }

    @SuppressLint({"NewApi"})
    private void setImageList(List<?> list) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778296318")) {
            ipChange.ipc$dispatch("1778296318", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            List<Boolean> list2 = this.videoList;
            if (list2 == null || list2.size() == list.size()) {
                initImages();
                for (int i = 0; i <= this.count + 1; i++) {
                    ImageLoaderInterface imageLoaderInterface = this.imageLoader;
                    View createImageView = imageLoaderInterface != null ? imageLoaderInterface.createImageView(this.context) : null;
                    if (createImageView == null) {
                        createImageView = new ImageView(this.context);
                    }
                    setScaleType(createImageView);
                    if (i == 0) {
                        obj = list.get(this.count - 1);
                        List<Boolean> list3 = this.videoList;
                        if (list3 != null) {
                            createImageView.setTag(R$id.bannervideo, list3.get(this.count - 1));
                        }
                    } else if (i == this.count + 1) {
                        obj = list.get(0);
                        List<Boolean> list4 = this.videoList;
                        if (list4 != null) {
                            createImageView.setTag(R$id.bannervideo, list4.get(0));
                        }
                    } else {
                        int i2 = i - 1;
                        Object obj2 = list.get(i2);
                        List<Boolean> list5 = this.videoList;
                        if (list5 != null) {
                            createImageView.setTag(R$id.bannervideo, list5.get(i2));
                        }
                        obj = obj2;
                    }
                    this.imageViews.add(createImageView);
                    ImageLoaderInterface imageLoaderInterface2 = this.imageLoader;
                    if (imageLoaderInterface2 != null) {
                        imageLoaderInterface2.displayImage(this.context, i, obj, createImageView);
                    } else {
                        Log.e(this.tag, "Please set images loader.");
                    }
                }
            }
        } else {
            Log.e(this.tag, "Please set the images data.");
        }
    }

    private void setScaleType(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1620906640")) {
            ipChange.ipc$dispatch("-1620906640", new Object[]{this, view});
            return;
        }
        if (!(view instanceof ImageView)) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        if (view == null || !(view instanceof ImageView)) {
            return;
        }
        ImageView imageView = (ImageView) view;
        switch (this.scaleType) {
            case 0:
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                return;
            case 1:
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return;
            case 2:
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                return;
            case 3:
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            case 4:
                imageView.setScaleType(ImageView.ScaleType.FIT_END);
                return;
            case 5:
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
                return;
            case 6:
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return;
            case 7:
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                return;
            default:
                return;
        }
    }

    private void setTitleStyleUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269074775")) {
            ipChange.ipc$dispatch("269074775", new Object[]{this});
        } else if (this.titles.size() == this.imageUrls.size()) {
            int i = this.titleBackground;
            if (i != -1) {
                this.titleView.setBackgroundColor(i);
            }
            if (this.titleHeight != -1) {
                this.titleView.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.titleHeight));
            }
            int i2 = this.titleTextColor;
            if (i2 != -1) {
                this.bannerTitle.setTextColor(i2);
            }
            int i3 = this.titleTextSize;
            if (i3 != -1) {
                this.bannerTitle.setTextSize(0, i3);
            }
            List<String> list = this.titles;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.bannerTitle.setText(this.titles.get(0));
            this.bannerTitle.setVisibility(0);
            this.titleView.setVisibility(0);
        } else {
            throw new RuntimeException("[Banner] --> The number of titles and images is different");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101232632")) {
            return ((Boolean) ipChange.ipc$dispatch("-2101232632", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.isAutoPlay) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startAutoPlay();
            } else if (action == 0) {
                stopAutoPlay();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Banner isAutoPlay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657727961")) {
            return (Banner) ipChange.ipc$dispatch("-1657727961", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isAutoPlay = z;
        return this;
    }

    public boolean isSameImageList(List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635852370")) {
            return ((Boolean) ipChange.ipc$dispatch("1635852370", new Object[]{this, list})).booleanValue();
        }
        int a = cb2.a(this.imageUrls);
        if (a == cb2.a(list)) {
            for (int i = 0; i < a; i++) {
                Object obj = this.imageUrls.get(i);
                Object obj2 = list.get(i);
                if (!(obj == obj2 || (obj != null && obj.equals(obj2)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546579005")) {
            ipChange.ipc$dispatch("1546579005", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        int currentItem = this.viewPager.getCurrentItem();
        this.currentItem = currentItem;
        if (i == 0) {
            if (currentItem == 0) {
                this.viewPager.setCurrentItem(this.count, false);
            } else if (currentItem == this.count + 1) {
                this.viewPager.setCurrentItem(1, false);
            }
        } else if (i != 1) {
        } else {
            int i2 = this.count;
            if (currentItem == i2 + 1) {
                this.viewPager.setCurrentItem(1, false);
            } else if (currentItem == 0) {
                this.viewPager.setCurrentItem(i2, false);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740293156")) {
            ipChange.ipc$dispatch("-740293156", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325092296")) {
            ipChange.ipc$dispatch("325092296", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(toRealPosition(i));
        }
        int i2 = this.bannerStyle;
        if (i2 == 1 || i2 == 4 || i2 == 5) {
            List<ImageView> list = this.indicatorImages;
            int i3 = this.count;
            list.get(((this.lastPosition - 1) + i3) % i3).setImageResource(this.mIndicatorUnselectedResId);
            List<ImageView> list2 = this.indicatorImages;
            int i4 = this.count;
            list2.get(((i - 1) + i4) % i4).setImageResource(this.mIndicatorSelectedResId);
            this.lastPosition = i;
        }
        if (i == 0) {
            i = this.count;
        }
        if (i > this.count) {
            i = 1;
        }
        int i5 = this.bannerStyle;
        if (i5 == 2) {
            TextView textView = this.numIndicator;
            textView.setText(i + "/" + this.count);
        } else if (i5 != 3) {
            if (i5 == 4) {
                this.bannerTitle.setText(this.titles.get(i - 1));
            } else if (i5 != 5) {
            } else {
                this.bannerTitle.setText(this.titles.get(i - 1));
            }
        } else {
            TextView textView2 = this.numIndicatorInside;
            textView2.setText(i + "/" + this.count);
            this.bannerTitle.setText(this.titles.get(i - 1));
        }
    }

    public void releaseBanner() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950645011")) {
            ipChange.ipc$dispatch("950645011", new Object[]{this});
        } else {
            this.handler.d(null);
        }
    }

    public Banner setBannerAnimation(Class<? extends ViewPager.PageTransformer> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "510023225")) {
            return (Banner) ipChange.ipc$dispatch("510023225", new Object[]{this, cls});
        }
        try {
            setPageTransformer(true, cls.newInstance());
        } catch (Exception unused) {
            Log.e(this.tag, "Please set the PageTransformer class");
        }
        return this;
    }

    public Banner setBannerStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116983212")) {
            return (Banner) ipChange.ipc$dispatch("1116983212", new Object[]{this, Integer.valueOf(i)});
        }
        this.bannerStyle = i;
        return this;
    }

    public Banner setBannerTitles(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723613256")) {
            return (Banner) ipChange.ipc$dispatch("-723613256", new Object[]{this, list});
        }
        this.titles = list;
        return this;
    }

    public Banner setDelayTime(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2066995337")) {
            return (Banner) ipChange.ipc$dispatch("-2066995337", new Object[]{this, Integer.valueOf(i)});
        }
        this.delayTime = i;
        return this;
    }

    public Banner setImageClipChildren(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710929730")) {
            return (Banner) ipChange.ipc$dispatch("1710929730", new Object[]{this, Boolean.valueOf(z)});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setClipChildren(z);
        }
        return this;
    }

    public Banner setImageLoader(ImageLoaderInterface imageLoaderInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239812773")) {
            return (Banner) ipChange.ipc$dispatch("1239812773", new Object[]{this, imageLoaderInterface});
        }
        this.imageLoader = imageLoaderInterface;
        return this;
    }

    public Banner setImages(List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035178297")) {
            return (Banner) ipChange.ipc$dispatch("-2035178297", new Object[]{this, list});
        }
        this.imageUrls = list;
        this.count = list.size();
        return this;
    }

    public Banner setIndicatorGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055348808")) {
            return (Banner) ipChange.ipc$dispatch("2055348808", new Object[]{this, Integer.valueOf(i)});
        }
        if (i == 5) {
            this.gravity = 19;
        } else if (i == 6) {
            this.gravity = 17;
        } else if (i == 7) {
            this.gravity = 21;
        }
        return this;
    }

    public Banner setIndicatorLayoutMargin(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "276280713")) {
            return (Banner) ipChange.ipc$dispatch("276280713", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        RelativeLayout relativeLayout = this.indicatorLayout;
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.leftMargin = i;
            layoutParams.topMargin = i2;
            layoutParams.rightMargin = i3;
            layoutParams.bottomMargin = i4;
            this.indicatorLayout.setLayoutParams(layoutParams);
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310785318")) {
            return (Banner) ipChange.ipc$dispatch("-1310785318", new Object[]{this, Integer.valueOf(i)});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setOffscreenPageLimit(i);
        }
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener onBannerListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "820687871")) {
            return (Banner) ipChange.ipc$dispatch("820687871", new Object[]{this, onBannerListener});
        }
        this.listener = onBannerListener;
        return this;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58607787")) {
            ipChange.ipc$dispatch("-58607787", new Object[]{this, onPageChangeListener});
        } else {
            this.mOnPageChangeListener = onPageChangeListener;
        }
    }

    public Banner setOnTagListener(OnTagListener onTagListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817657115")) {
            return (Banner) ipChange.ipc$dispatch("-1817657115", new Object[]{this, onTagListener});
        }
        this.onTagListener = onTagListener;
        return this;
    }

    public Banner setPageMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862156518")) {
            return (Banner) ipChange.ipc$dispatch("1862156518", new Object[]{this, Integer.valueOf(i)});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setPageMargin(i);
        }
        return this;
    }

    public Banner setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1374954653")) {
            return (Banner) ipChange.ipc$dispatch("-1374954653", new Object[]{this, Boolean.valueOf(z), pageTransformer});
        }
        this.viewPager.setPageTransformer(z, pageTransformer);
        return this;
    }

    public Banner setViewPagerIsScroll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1750893907")) {
            return (Banner) ipChange.ipc$dispatch("-1750893907", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isScroll = z;
        return this;
    }

    public Banner setViewPagerLayoutParams(RelativeLayout.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104909790")) {
            return (Banner) ipChange.ipc$dispatch("1104909790", new Object[]{this, layoutParams});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setLayoutParams(layoutParams);
        }
        return this;
    }

    public Banner start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2122909970")) {
            return (Banner) ipChange.ipc$dispatch("-2122909970", new Object[]{this});
        }
        setBannerStyleUI();
        setImageList(this.imageUrls);
        setData();
        return this;
    }

    public void startAutoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177851935")) {
            ipChange.ipc$dispatch("-177851935", new Object[]{this});
            return;
        }
        this.handler.c(this.task);
        this.handler.b(this.task, this.delayTime);
    }

    public void stopAutoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-630895873")) {
            ipChange.ipc$dispatch("-630895873", new Object[]{this});
        } else {
            this.handler.c(this.task);
        }
    }

    public int toRealPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175264884")) {
            return ((Integer) ipChange.ipc$dispatch("175264884", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = this.count;
        int i3 = (i - 1) % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    public void update(List<?> list, List<String> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-755606915")) {
            ipChange.ipc$dispatch("-755606915", new Object[]{this, list, list2});
            return;
        }
        this.imageUrls.clear();
        this.titles.clear();
        this.imageUrls.addAll(list);
        this.titles.addAll(list2);
        this.count = this.imageUrls.size();
        start();
    }

    public void updateBannerStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "584193945")) {
            ipChange.ipc$dispatch("584193945", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.indicator.setVisibility(8);
        this.numIndicator.setVisibility(8);
        this.numIndicatorInside.setVisibility(8);
        this.indicatorInside.setVisibility(8);
        this.bannerTitle.setVisibility(8);
        this.titleView.setVisibility(8);
        this.bannerStyle = i;
        start();
    }

    public void updateVideo(List<?> list, List<Boolean> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118744138")) {
            ipChange.ipc$dispatch("-1118744138", new Object[]{this, list, list2});
            return;
        }
        this.videoList = list2;
        this.imageUrls.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        start();
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tag = gh1.MODULE_BANNER;
        this.mIndicatorMargin = 5;
        this.bannerStyle = 1;
        this.delayTime = 2000;
        this.scrollTime = 800;
        this.isAutoPlay = true;
        this.isScroll = true;
        this.mIndicatorSelectedResId = R$drawable.gray_radius;
        this.mIndicatorUnselectedResId = R$drawable.white_radius;
        this.mLayoutResId = R$layout.banner;
        this.count = 0;
        this.gravity = -1;
        this.lastPosition = 1;
        this.scaleType = 3;
        this.handler = new WeakHandler();
        this.task = new Runnable() { // from class: cn.damai.tetris.component.home.widget.banner.Banner.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "36302029")) {
                    ipChange.ipc$dispatch("36302029", new Object[]{this});
                } else if (Banner.this.count <= 1 || !Banner.this.isAutoPlay) {
                } else {
                    Banner banner = Banner.this;
                    banner.currentItem = (banner.currentItem % (Banner.this.count + 1)) + 1;
                    if (Banner.this.currentItem == 1) {
                        Banner.this.viewPager.setCurrentItem(Banner.this.currentItem, false);
                        Banner.this.handler.a(Banner.this.task);
                        return;
                    }
                    Banner.this.viewPager.setCurrentItem(Banner.this.currentItem);
                    Banner.this.handler.b(Banner.this.task, Banner.this.delayTime);
                }
            }
        };
        this.context = context;
        this.titles = new ArrayList();
        this.imageUrls = new ArrayList();
        this.imageViews = new ArrayList();
        this.indicatorImages = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.dm = displayMetrics;
        this.indicatorSize = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / 80;
        initView(context, attributeSet);
    }

    public void update(List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634966132")) {
            ipChange.ipc$dispatch("-1634966132", new Object[]{this, list});
            return;
        }
        this.imageUrls.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        start();
    }
}
