package cn.damai.uikit.banner.sub;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.banner.BannerScroller;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class XBanner extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int FLIP_INTERVAL = 3000;
    private static final int FLIP_SIZE = 1000;
    private boolean isAttachedToWindow;
    private boolean isFlipping;
    private BannerAdapter mAdapter;
    private OnBannerClickListener mClickListener;
    private Runnable mFlipRunnable;
    private WeakReference<OnBannerPageChangedListener> mListenerWeal;
    private BannerItemViewCreator mViewCreator;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class BannerAdapter extends PagerAdapter implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private List<? extends BannerItem> b;
        private Pools.SimplePool<View> c = new Pools.SimplePool<>(4);
        private int d = -1;

        public BannerAdapter(Context context) {
            this.a = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1110265625")) {
                ipChange.ipc$dispatch("1110265625", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            View view = (View) obj;
            viewGroup.removeView(view);
            this.c.release(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "424147952")) {
                return ((Integer) ipChange.ipc$dispatch("424147952", new Object[]{this})).intValue();
            }
            List<? extends BannerItem> list = this.b;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.b.size() == 1 ? 1 : 1000;
        }

        public int getRealCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1377015762")) {
                return ((Integer) ipChange.ipc$dispatch("-1377015762", new Object[]{this})).intValue();
            }
            List<? extends BannerItem> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "331730917")) {
                return ipChange.ipc$dispatch("331730917", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            int size = i % this.b.size();
            View acquire = this.c.acquire();
            if (acquire == null) {
                acquire = XBanner.this.mViewCreator.inflateItemView(this.a, viewGroup);
            }
            BannerItem bannerItem = this.b.get(size);
            XBanner.this.mViewCreator.bindItemView(bannerItem, acquire, size);
            acquire.setTag(new C2479b(bannerItem, size));
            acquire.setOnClickListener(this);
            viewGroup.addView(acquire);
            return acquire;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1474205484") ? ((Boolean) ipChange.ipc$dispatch("-1474205484", new Object[]{this, view, obj})).booleanValue() : view == obj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1357631911")) {
                ipChange.ipc$dispatch("1357631911", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (!(tag instanceof C2479b) || XBanner.this.mClickListener == null) {
                return;
            }
            C2479b c2479b = (C2479b) tag;
            XBanner.this.mClickListener.onBannerClick(c2479b.a, c2479b.b);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-702262339")) {
                ipChange.ipc$dispatch("-702262339", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            try {
                if (i != this.d) {
                    this.d = i;
                    this.b.get(i % this.b.size());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface BannerItemViewCreator {
        void bindItemView(BannerItem bannerItem, View view, int i);

        View inflateItemView(Context context, ViewGroup viewGroup);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnBannerClickListener {
        void onBannerClick(BannerItem bannerItem, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnBannerPageChangedListener {
        void onChanged(int i, int i2);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.banner.sub.XBanner$a */
    /* loaded from: classes8.dex */
    public static class C2476a implements BannerItemViewCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.banner.sub.XBanner$a$a */
        /* loaded from: classes8.dex */
        public class C2477a implements IImageLoader.IImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C2477a(C2476a c2476a, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.C2496b c2496b) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1113900712")) {
                    ipChange.ipc$dispatch("1113900712", new Object[]{this, c2496b});
                } else {
                    this.a.setImageDrawable(c2496b.a);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.banner.sub.XBanner$a$b */
        /* loaded from: classes8.dex */
        public class C2478b implements IImageLoader.IImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C2478b(C2476a c2476a, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.C2495a c2495a) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-705321711")) {
                    ipChange.ipc$dispatch("-705321711", new Object[]{this, c2495a});
                } else {
                    this.a.setImageResource(R$drawable.uikit_default_image_bg_grey);
                }
            }
        }

        @Override // cn.damai.uikit.banner.sub.XBanner.BannerItemViewCreator
        public void bindItemView(BannerItem bannerItem, View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-316150200")) {
                ipChange.ipc$dispatch("-316150200", new Object[]{this, bannerItem, view, Integer.valueOf(i)});
                return;
            }
            ImageView imageView = (ImageView) view.findViewById(R$id.banner_img);
            C2497a.a().load(bannerItem.bannerPicUrl(), R$drawable.uikit_default_image_bg_grey, 0, 0, new C2477a(this, imageView), new C2478b(this, imageView));
        }

        @Override // cn.damai.uikit.banner.sub.XBanner.BannerItemViewCreator
        public View inflateItemView(Context context, ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1007681540") ? (View) ipChange.ipc$dispatch("1007681540", new Object[]{this, context, viewGroup}) : LayoutInflater.from(context).inflate(R$layout.x_banner_item, viewGroup, false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.banner.sub.XBanner$b */
    /* loaded from: classes17.dex */
    public static class C2479b {
        public final BannerItem a;
        public final int b;

        public C2479b(BannerItem bannerItem, int i) {
            this.a = bannerItem;
            this.b = i;
        }
    }

    public XBanner(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OnBannerPageChangedListener getListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2406410")) {
            return (OnBannerPageChangedListener) ipChange.ipc$dispatch("-2406410", new Object[]{this});
        }
        WeakReference<OnBannerPageChangedListener> weakReference = this.mListenerWeal;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176713299")) {
            ipChange.ipc$dispatch("-1176713299", new Object[]{this, context, attributeSet});
            return;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            BannerScroller bannerScroller = new BannerScroller(context);
            bannerScroller.setDuration(800);
            declaredField.set(this, bannerScroller);
        } catch (Exception e) {
            Log.e("XunYanBanner", e.getMessage());
        }
        this.mAdapter = new BannerAdapter(context);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.uikit.banner.sub.XBanner.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-745360868")) {
                    ipChange2.ipc$dispatch("-745360868", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "368777915")) {
                    ipChange2.ipc$dispatch("368777915", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2069281689")) {
                    ipChange2.ipc$dispatch("-2069281689", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                OnBannerPageChangedListener listener = XBanner.this.getListener();
                if (listener == null || XBanner.this.mAdapter == null) {
                    return;
                }
                int realCount = XBanner.this.mAdapter.getRealCount();
                listener.onChanged(realCount, i % realCount);
            }
        });
        setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanAnimation() {
        BannerAdapter bannerAdapter;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-714879523") ? ((Boolean) ipChange.ipc$dispatch("-714879523", new Object[]{this})).booleanValue() : this.isAttachedToWindow && getVisibility() == 0 && (bannerAdapter = this.mAdapter) != null && bannerAdapter.getRealCount() > 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195729467")) {
            return ((Boolean) ipChange.ipc$dispatch("1195729467", new Object[]{this, motionEvent})).booleanValue();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (dispatchTouchEvent && action == 0) {
            stopAnimation();
        } else if (action == 1 || action == 3) {
            startAnimationIfNeed();
        }
        return dispatchTouchEvent;
    }

    public boolean isFlipping() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "827323442") ? ((Boolean) ipChange.ipc$dispatch("827323442", new Object[]{this})).booleanValue() : this.isFlipping;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996077399")) {
            ipChange.ipc$dispatch("-1996077399", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        startAnimationIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "710449036")) {
            ipChange.ipc$dispatch("710449036", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        stopAnimation();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696364511")) {
            ipChange.ipc$dispatch("-1696364511", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            startAnimationIfNeed();
        } else {
            stopAnimation();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829482237")) {
            ipChange.ipc$dispatch("-1829482237", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAnimationIfNeed();
        } else {
            stopAnimation();
        }
    }

    public void setBannerClickListener(OnBannerClickListener onBannerClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-798794447")) {
            ipChange.ipc$dispatch("-798794447", new Object[]{this, onBannerClickListener});
        } else {
            this.mClickListener = onBannerClickListener;
        }
    }

    public void setListener(OnBannerPageChangedListener onBannerPageChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614520672")) {
            ipChange.ipc$dispatch("1614520672", new Object[]{this, onBannerPageChangedListener});
        } else if (onBannerPageChangedListener != null) {
            this.mListenerWeal = new WeakReference<>(onBannerPageChangedListener);
        } else {
            this.mListenerWeal = null;
        }
    }

    public void setViewCreator(BannerItemViewCreator bannerItemViewCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214672593")) {
            ipChange.ipc$dispatch("1214672593", new Object[]{this, bannerItemViewCreator});
            return;
        }
        if (bannerItemViewCreator == null) {
            bannerItemViewCreator = new C2476a();
        }
        this.mViewCreator = bannerItemViewCreator;
    }

    public void startAnimationIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "909983138")) {
            ipChange.ipc$dispatch("909983138", new Object[]{this});
        } else if (isCanAnimation()) {
            removeCallbacks(this.mFlipRunnable);
            this.isFlipping = true;
            postDelayed(this.mFlipRunnable, 3000L);
        }
    }

    public void stopAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190722735")) {
            ipChange.ipc$dispatch("-1190722735", new Object[]{this});
            return;
        }
        this.isFlipping = false;
        removeCallbacks(this.mFlipRunnable);
    }

    public void update(List<? extends BannerItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899068927")) {
            ipChange.ipc$dispatch("899068927", new Object[]{this, list});
            return;
        }
        this.mAdapter.b = list;
        this.mAdapter.notifyDataSetChanged();
        startAnimationIfNeed();
        if (list != null) {
            if (list.size() == 1) {
                setCurrentItem(0);
            } else if (list.size() > 1) {
                setCurrentItem(list.size() * 5);
            }
        }
    }

    public XBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlipRunnable = new Runnable() { // from class: cn.damai.uikit.banner.sub.XBanner.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-280032037")) {
                    ipChange.ipc$dispatch("-280032037", new Object[]{this});
                } else if (!XBanner.this.isCanAnimation() || (currentItem = XBanner.this.getCurrentItem() + 1) > XBanner.this.mAdapter.getCount() - 1) {
                } else {
                    XBanner.this.setCurrentItem(currentItem, true);
                    XBanner.this.isFlipping = true;
                    XBanner.this.postDelayed(this, 3000L);
                }
            }
        };
        this.isFlipping = false;
        this.isAttachedToWindow = false;
        this.mViewCreator = new C2476a();
        init(context, attributeSet);
    }
}
