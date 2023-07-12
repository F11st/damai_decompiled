package cn.damai.user.star.view;

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
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.BannerScroller;
import cn.damai.user.star.bean.Banner;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import tb.vf2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class XunYanBanner extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int FLIP_INTERVAL = 3000;
    private static final int FLIP_SIZE = 1000;
    private String bizId;
    private int bizType;
    private boolean isAttachedToWindow;
    private boolean isFlipping;
    private boolean isSelf;
    private BannerAdapter mAdapter;
    private OnBannerClickListener mClickListener;
    private Runnable mFlipRunnable;
    private WeakReference<OnBannerPageChangedListener> mListenerWeal;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class BannerAdapter extends PagerAdapter implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private List<Banner> b;
        private Pools.SimplePool<View> c = new Pools.SimplePool<>(4);
        private int d = -1;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.star.view.XunYanBanner$BannerAdapter$a */
        /* loaded from: classes9.dex */
        public class C2710a implements DMImageCreator.DMImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C2710a(BannerAdapter bannerAdapter, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.C0502e c0502e) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1710739697")) {
                    ipChange.ipc$dispatch("-1710739697", new Object[]{this, c0502e});
                } else {
                    this.a.setImageDrawable(c0502e.a);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.user.star.view.XunYanBanner$BannerAdapter$b */
        /* loaded from: classes9.dex */
        public class C2711b implements DMImageCreator.DMImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C2711b(BannerAdapter bannerAdapter, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.C0501d c0501d) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1480696316")) {
                    ipChange.ipc$dispatch("1480696316", new Object[]{this, c0501d});
                } else {
                    this.a.setImageResource(R$drawable.uikit_default_image_bg_grey);
                }
            }
        }

        public BannerAdapter(Context context) {
            this.a = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-715112530")) {
                ipChange.ipc$dispatch("-715112530", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            View view = (View) obj;
            viewGroup.removeView(view);
            this.c.release(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "429848901")) {
                return ((Integer) ipChange.ipc$dispatch("429848901", new Object[]{this})).intValue();
            }
            List<Banner> list = this.b;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.b.size() == 1 ? 1 : 1000;
        }

        public int getRealCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2060799229")) {
                return ((Integer) ipChange.ipc$dispatch("-2060799229", new Object[]{this})).intValue();
            }
            List<Banner> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-927950032")) {
                return ipChange.ipc$dispatch("-927950032", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            int size = i % this.b.size();
            View acquire = this.c.acquire();
            if (acquire == null) {
                acquire = LayoutInflater.from(this.a).inflate(R$layout.mine_starindex_xunyan_banner_item, viewGroup, false);
            }
            Banner banner = this.b.get(size);
            ImageView imageView = (ImageView) acquire.findViewById(R$id.banner_img);
            C0504a.b().e(banner.pic).i(R$drawable.uikit_default_image_bg_grey).e(new C2711b(this, imageView)).n(new C2710a(this, imageView)).f();
            imageView.setTag(new C2712a(banner, size));
            imageView.setOnClickListener(this);
            viewGroup.addView(acquire);
            return acquire;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-147615329") ? ((Boolean) ipChange.ipc$dispatch("-147615329", new Object[]{this, view, obj})).booleanValue() : view == obj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-739245124")) {
                ipChange.ipc$dispatch("-739245124", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (!(tag instanceof C2712a) || XunYanBanner.this.mClickListener == null) {
                return;
            }
            C2712a c2712a = (C2712a) tag;
            XunYanBanner.this.mClickListener.onBannerClick(c2712a.a, c2712a.b);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1961943288")) {
                ipChange.ipc$dispatch("-1961943288", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            try {
                if (i != this.d) {
                    this.d = i;
                    int size = i % this.b.size();
                    vf2.f().g((View) obj, size, XunYanBanner.this.bizId, XunYanBanner.this.bizType, XunYanBanner.this.isSelf, this.b.get(size).url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnBannerClickListener {
        void onBannerClick(Banner banner, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnBannerPageChangedListener {
        void onChanged(int i, int i2);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.view.XunYanBanner$a */
    /* loaded from: classes17.dex */
    public static class C2712a {
        public final Banner a;
        public final int b;

        public C2712a(Banner banner, int i) {
            this.a = banner;
            this.b = i;
        }
    }

    public XunYanBanner(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OnBannerPageChangedListener getListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535417712")) {
            return (OnBannerPageChangedListener) ipChange.ipc$dispatch("-535417712", new Object[]{this});
        }
        WeakReference<OnBannerPageChangedListener> weakReference = this.mListenerWeal;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2144587838")) {
            ipChange.ipc$dispatch("-2144587838", new Object[]{this, context, attributeSet});
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
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.user.star.view.XunYanBanner.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-467811865")) {
                    ipChange2.ipc$dispatch("-467811865", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1760306566")) {
                    ipChange2.ipc$dispatch("1760306566", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "426018290")) {
                    ipChange2.ipc$dispatch("426018290", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                OnBannerPageChangedListener listener = XunYanBanner.this.getListener();
                if (listener == null || XunYanBanner.this.mAdapter == null) {
                    return;
                }
                int realCount = XunYanBanner.this.mAdapter.getRealCount();
                listener.onChanged(realCount, i % realCount);
            }
        });
        setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanAnimation() {
        BannerAdapter bannerAdapter;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1682174002") ? ((Boolean) ipChange.ipc$dispatch("1682174002", new Object[]{this})).booleanValue() : this.isAttachedToWindow && getVisibility() == 0 && (bannerAdapter = this.mAdapter) != null && bannerAdapter.getRealCount() > 1;
    }

    public void addUTParams(String str, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-594794861")) {
            ipChange.ipc$dispatch("-594794861", new Object[]{this, str, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        this.bizId = str;
        this.bizType = i;
        this.isSelf = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778942416")) {
            return ((Boolean) ipChange.ipc$dispatch("1778942416", new Object[]{this, motionEvent})).booleanValue();
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
        return AndroidInstantRuntime.support(ipChange, "-689927929") ? ((Boolean) ipChange.ipc$dispatch("-689927929", new Object[]{this})).booleanValue() : this.isFlipping;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951189378")) {
            ipChange.ipc$dispatch("-1951189378", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "898164257")) {
            ipChange.ipc$dispatch("898164257", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        stopAnimation();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37109612")) {
            ipChange.ipc$dispatch("37109612", new Object[]{this, view, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "1781701592")) {
            ipChange.ipc$dispatch("1781701592", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-959626871")) {
            ipChange.ipc$dispatch("-959626871", new Object[]{this, onBannerClickListener});
        } else {
            this.mClickListener = onBannerClickListener;
        }
    }

    public void setListener(OnBannerPageChangedListener onBannerPageChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884651562")) {
            ipChange.ipc$dispatch("-1884651562", new Object[]{this, onBannerPageChangedListener});
        } else if (onBannerPageChangedListener != null) {
            this.mListenerWeal = new WeakReference<>(onBannerPageChangedListener);
        } else {
            this.mListenerWeal = null;
        }
    }

    public void startAnimationIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1097698359")) {
            ipChange.ipc$dispatch("1097698359", new Object[]{this});
        } else if (isCanAnimation()) {
            removeCallbacks(this.mFlipRunnable);
            this.isFlipping = true;
            postDelayed(this.mFlipRunnable, 3000L);
        }
    }

    public void stopAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390493092")) {
            ipChange.ipc$dispatch("-1390493092", new Object[]{this});
            return;
        }
        this.isFlipping = false;
        removeCallbacks(this.mFlipRunnable);
    }

    public void update(List<Banner> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904769876")) {
            ipChange.ipc$dispatch("904769876", new Object[]{this, list});
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

    public XunYanBanner(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlipRunnable = new Runnable() { // from class: cn.damai.user.star.view.XunYanBanner.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                int currentItem;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1880098534")) {
                    ipChange.ipc$dispatch("1880098534", new Object[]{this});
                } else if (!XunYanBanner.this.isCanAnimation() || (currentItem = XunYanBanner.this.getCurrentItem() + 1) > XunYanBanner.this.mAdapter.getCount() - 1) {
                } else {
                    XunYanBanner.this.setCurrentItem(currentItem, true);
                    XunYanBanner.this.isFlipping = true;
                    XunYanBanner.this.postDelayed(this, 3000L);
                }
            }
        };
        this.isFlipping = false;
        this.isAttachedToWindow = false;
        init(context, attributeSet);
    }
}
