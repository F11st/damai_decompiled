package cn.damai.uikit.banner;

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
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.banner.listener.OnBannerClickListener;
import cn.damai.uikit.banner.listener.OnBannerListener;
import cn.damai.uikit.banner.loader.ImageLoaderInterface;
import cn.damai.uikit.banner.view.BannerViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import tb.gh1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private BannerPagerAdapter adapter;
    private OnBannerClickListener bannerListener;
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
    private List<View> imageViews;
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
    /* loaded from: classes8.dex */
    public class BannerPagerAdapter extends PagerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.banner.Banner$BannerPagerAdapter$a */
        /* loaded from: classes17.dex */
        public class View$OnClickListenerC2472a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ int a;

            View$OnClickListenerC2472a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1930743056")) {
                    ipChange.ipc$dispatch("-1930743056", new Object[]{this, view});
                    return;
                }
                Log.e(Banner.this.tag, "你正在使用旧版点击事件接口，下标是从1开始，为了体验请更换为setOnBannerListener，下标从0开始计算");
                Banner.this.bannerListener.OnBannerClick(this.a);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.banner.Banner$BannerPagerAdapter$b */
        /* loaded from: classes17.dex */
        public class View$OnClickListenerC2473b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ int a;

            View$OnClickListenerC2473b(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "180547313")) {
                    ipChange.ipc$dispatch("180547313", new Object[]{this, view});
                } else {
                    Banner.this.listener.OnBannerClick(Banner.this.toRealPosition(this.a));
                }
            }
        }

        BannerPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1938152427")) {
                ipChange.ipc$dispatch("-1938152427", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            } else {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1387129324") ? ((Integer) ipChange.ipc$dispatch("1387129324", new Object[]{this})).intValue() : Banner.this.imageViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1993017705")) {
                return ipChange.ipc$dispatch("1993017705", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            viewGroup.addView((View) Banner.this.imageViews.get(i));
            View view = (View) Banner.this.imageViews.get(i);
            if (Banner.this.bannerListener != null) {
                view.setOnClickListener(new View$OnClickListenerC2472a(i));
            }
            if (Banner.this.listener != null) {
                view.setOnClickListener(new View$OnClickListenerC2473b(i));
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "782763096") ? ((Boolean) ipChange.ipc$dispatch("782763096", new Object[]{this, view, obj})).booleanValue() : view == obj;
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void createIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096800421")) {
            ipChange.ipc$dispatch("-1096800421", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-69538709")) {
            ipChange.ipc$dispatch("-69538709", new Object[]{this, context, attributeSet});
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
        if (AndroidInstantRuntime.support(ipChange, "160945652")) {
            ipChange.ipc$dispatch("160945652", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "125089325")) {
            ipChange.ipc$dispatch("125089325", new Object[]{this, context, attributeSet});
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
    }

    private void initViewPagerScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685125363")) {
            ipChange.ipc$dispatch("1685125363", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-651265019")) {
            ipChange.ipc$dispatch("-651265019", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1744454402")) {
            ipChange.ipc$dispatch("1744454402", new Object[]{this});
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

    private void setImageList(List<?> list) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869890538")) {
            ipChange.ipc$dispatch("-869890538", new Object[]{this, list});
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
                        imageLoaderInterface2.displayImage(this.context, obj, createImageView);
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
        if (AndroidInstantRuntime.support(ipChange, "498726488")) {
            ipChange.ipc$dispatch("498726488", new Object[]{this, view});
        } else if (view instanceof ImageView) {
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
    }

    private void setTitleStyleUI() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-350250433")) {
            ipChange.ipc$dispatch("-350250433", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-384406496")) {
            return ((Boolean) ipChange.ipc$dispatch("-384406496", new Object[]{this, motionEvent})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "836491897")) {
            return (Banner) ipChange.ipc$dispatch("836491897", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isAutoPlay = z;
        return this;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119063333")) {
            ipChange.ipc$dispatch("119063333", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "1088636100")) {
            ipChange.ipc$dispatch("1088636100", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
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
        if (AndroidInstantRuntime.support(ipChange, "-294232912")) {
            ipChange.ipc$dispatch("-294232912", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "967877627")) {
            ipChange.ipc$dispatch("967877627", new Object[]{this});
        } else {
            this.handler.d(null);
        }
    }

    public Banner setBannerAnimation(Class<? extends ViewPager.PageTransformer> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932378969")) {
            return (Banner) ipChange.ipc$dispatch("-1932378969", new Object[]{this, cls});
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
        if (AndroidInstantRuntime.support(ipChange, "-649157484")) {
            return (Banner) ipChange.ipc$dispatch("-649157484", new Object[]{this, Integer.valueOf(i)});
        }
        this.bannerStyle = i;
        return this;
    }

    public Banner setBannerTitles(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536995832")) {
            return (Banner) ipChange.ipc$dispatch("-536995832", new Object[]{this, list});
        }
        this.titles = list;
        return this;
    }

    public Banner setDelayTime(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1550738647")) {
            return (Banner) ipChange.ipc$dispatch("-1550738647", new Object[]{this, Integer.valueOf(i)});
        }
        this.delayTime = i;
        return this;
    }

    public Banner setImageClipChildren(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855232958")) {
            return (Banner) ipChange.ipc$dispatch("1855232958", new Object[]{this, Boolean.valueOf(z)});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setClipChildren(z);
        }
        return this;
    }

    public Banner setImageLoader(ImageLoaderInterface imageLoaderInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447900761")) {
            return (Banner) ipChange.ipc$dispatch("1447900761", new Object[]{this, imageLoaderInterface});
        }
        this.imageLoader = imageLoaderInterface;
        return this;
    }

    public Banner setImages(List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202555943")) {
            return (Banner) ipChange.ipc$dispatch("-1202555943", new Object[]{this, list});
        }
        this.imageUrls = list;
        this.count = list.size();
        return this;
    }

    public Banner setIndicatorGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436352440")) {
            return (Banner) ipChange.ipc$dispatch("-1436352440", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1803134425")) {
            return (Banner) ipChange.ipc$dispatch("-1803134425", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
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
        if (AndroidInstantRuntime.support(ipChange, "1554547702")) {
            return (Banner) ipChange.ipc$dispatch("1554547702", new Object[]{this, Integer.valueOf(i)});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setOffscreenPageLimit(i);
        }
        return this;
    }

    @Deprecated
    public Banner setOnBannerClickListener(OnBannerClickListener onBannerClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-836246445")) {
            return (Banner) ipChange.ipc$dispatch("-836246445", new Object[]{this, onBannerClickListener});
        }
        this.bannerListener = onBannerClickListener;
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener onBannerListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1123493513")) {
            return (Banner) ipChange.ipc$dispatch("1123493513", new Object[]{this, onBannerListener});
        }
        this.listener = onBannerListener;
        return this;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508264387")) {
            ipChange.ipc$dispatch("-1508264387", new Object[]{this, onPageChangeListener});
        } else {
            this.mOnPageChangeListener = onPageChangeListener;
        }
    }

    public Banner setPageMargin(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45926762")) {
            return (Banner) ipChange.ipc$dispatch("45926762", new Object[]{this, Integer.valueOf(i)});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setPageMargin(i);
        }
        return this;
    }

    public Banner setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "661947789")) {
            return (Banner) ipChange.ipc$dispatch("661947789", new Object[]{this, Boolean.valueOf(z), pageTransformer});
        }
        this.viewPager.setPageTransformer(z, pageTransformer);
        return this;
    }

    public Banner setViewPagerIsScroll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332229453")) {
            return (Banner) ipChange.ipc$dispatch("-332229453", new Object[]{this, Boolean.valueOf(z)});
        }
        this.isScroll = z;
        return this;
    }

    public Banner setViewPagerLayoutParams(RelativeLayout.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51506546")) {
            return (Banner) ipChange.ipc$dispatch("51506546", new Object[]{this, layoutParams});
        }
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setLayoutParams(layoutParams);
        }
        return this;
    }

    public Banner start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-657277550")) {
            return (Banner) ipChange.ipc$dispatch("-657277550", new Object[]{this});
        }
        setBannerStyleUI();
        setImageList(this.imageUrls);
        setData();
        return this;
    }

    public void startAutoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160619319")) {
            ipChange.ipc$dispatch("-160619319", new Object[]{this});
            return;
        }
        this.handler.c(this.task);
        this.handler.b(this.task, this.delayTime);
    }

    public void stopAutoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616586007")) {
            ipChange.ipc$dispatch("616586007", new Object[]{this});
        } else {
            this.handler.c(this.task);
        }
    }

    public int toRealPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444060324")) {
            return ((Integer) ipChange.ipc$dispatch("-444060324", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = this.count;
        int i3 = (i - 1) % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    public void update(List<?> list, List<String> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37158037")) {
            ipChange.ipc$dispatch("37158037", new Object[]{this, list, list2});
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
        if (AndroidInstantRuntime.support(ipChange, "1446426033")) {
            ipChange.ipc$dispatch("1446426033", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1340457314")) {
            ipChange.ipc$dispatch("-1340457314", new Object[]{this, list, list2});
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
        this.task = new Runnable() { // from class: cn.damai.uikit.banner.Banner.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1574753942")) {
                    ipChange.ipc$dispatch("1574753942", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "868497316")) {
            ipChange.ipc$dispatch("868497316", new Object[]{this, list});
            return;
        }
        this.imageUrls.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        start();
    }
}
