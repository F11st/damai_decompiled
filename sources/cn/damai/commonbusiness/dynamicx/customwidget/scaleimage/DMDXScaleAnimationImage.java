package cn.damai.commonbusiness.dynamicx.customwidget.scaleimage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMDXScaleAnimationImage extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private long duration;
    private c imageHandler;
    private List<String> imageList;
    private RoundImageView imageView;
    private int index;
    private long interval;
    private boolean isAttachedToWindow;
    private final HashMap<String, Drawable> mCacheDrawable;
    private final Runnable runTask;
    private AnimatorSet scaleInAnimation;
    private AnimatorSet scaleOutAnimation;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581837523")) {
                ipChange.ipc$dispatch("-581837523", new Object[]{this, eVar});
            } else if (eVar.a != null) {
                DMDXScaleAnimationImage.this.mCacheDrawable.put(this.a, eVar.a);
                DMDXScaleAnimationImage.this.imageView.setImageDrawable(eVar.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2022195558")) {
                ipChange.ipc$dispatch("-2022195558", new Object[]{this, dVar});
            } else {
                DMDXScaleAnimationImage.this.imageView.setImageResource(R$drawable.uikit_default_image_bg_gradient);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class c extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<DMDXScaleAnimationImage> a;

        public c(DMDXScaleAnimationImage dMDXScaleAnimationImage) {
            this.a = new WeakReference<>(dMDXScaleAnimationImage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1004758495")) {
                ipChange.ipc$dispatch("-1004758495", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            this.a.get().run(message.what);
        }
    }

    public DMDXScaleAnimationImage(@NonNull Context context) {
        super(context);
        this.imageHandler = new c(this);
        this.imageList = new ArrayList();
        this.interval = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.duration = 300L;
        this.isAttachedToWindow = false;
        this.runTask = new Runnable() { // from class: cn.damai.commonbusiness.dynamicx.customwidget.scaleimage.DMDXScaleAnimationImage.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1099301785")) {
                    ipChange.ipc$dispatch("-1099301785", new Object[]{this});
                } else if (DMDXScaleAnimationImage.this.isAttachedToWindow && cb2.a(DMDXScaleAnimationImage.this.imageList) > 1) {
                    DMDXScaleAnimationImage.this.index %= wh2.e(DMDXScaleAnimationImage.this.imageList);
                    DMDXScaleAnimationImage.this.imageHandler.sendEmptyMessage(DMDXScaleAnimationImage.this.index);
                    DMDXScaleAnimationImage.access$608(DMDXScaleAnimationImage.this);
                    DMDXScaleAnimationImage.this.startAnimationV2();
                }
            }
        };
        this.mCacheDrawable = new HashMap<>();
        initView(context);
    }

    static /* synthetic */ int access$608(DMDXScaleAnimationImage dMDXScaleAnimationImage) {
        int i = dMDXScaleAnimationImage.index;
        dMDXScaleAnimationImage.index = i + 1;
        return i;
    }

    private void initScaleInAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-912269981")) {
            ipChange.ipc$dispatch("-912269981", new Object[]{this});
            return;
        }
        this.scaleInAnimation = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imageView, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imageView, "scaleY", 1.0f, 0.0f);
        this.scaleInAnimation.setDuration(this.duration);
        this.scaleInAnimation.setInterpolator(new LinearInterpolator());
        this.scaleInAnimation.playTogether(ofFloat, ofFloat2);
    }

    private void initScaleOutAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830222674")) {
            ipChange.ipc$dispatch("1830222674", new Object[]{this});
            return;
        }
        this.scaleOutAnimation = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.imageView, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.imageView, "scaleY", 0.0f, 1.0f);
        this.scaleOutAnimation.setDuration(this.duration);
        this.scaleOutAnimation.setInterpolator(new LinearInterpolator());
        this.scaleOutAnimation.playTogether(ofFloat, ofFloat2);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114368949")) {
            ipChange.ipc$dispatch("2114368949", new Object[]{this, context});
            return;
        }
        RoundImageView roundImageView = new RoundImageView(context);
        this.imageView = roundImageView;
        roundImageView.setType(1);
        this.imageView.setBorderRadius(6);
        this.imageView.setImageResource(R$drawable.uikit_default_image_bg_gradient);
        addView(this.imageView, new FrameLayout.LayoutParams(-1, -1));
        initScaleInAnimation();
        initScaleOutAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623378092")) {
            ipChange.ipc$dispatch("623378092", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setImage(i);
        this.scaleInAnimation.start();
        this.imageView.postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.dynamicx.customwidget.scaleimage.DMDXScaleAnimationImage.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-509761270")) {
                    ipChange2.ipc$dispatch("-509761270", new Object[]{this});
                    return;
                }
                int i2 = i + 1;
                DMDXScaleAnimationImage.this.setImage(i2 < wh2.e(DMDXScaleAnimationImage.this.imageList) ? i2 : 0);
                DMDXScaleAnimationImage.this.scaleOutAnimation.start();
            }
        }, this.duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883631668")) {
            ipChange.ipc$dispatch("1883631668", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i >= wh2.e(this.imageList)) {
            i = 0;
        }
        String str = this.imageList.get(i);
        Drawable drawable = this.mCacheDrawable.get(str);
        if (drawable != null) {
            if (AppConfig.v()) {
                Log.e("DMDXScale", "use cache drawable " + str);
            }
            this.imageView.setImageDrawable(drawable);
            return;
        }
        this.imageView.setImageResource(R$drawable.uikit_default_image_bg_gradient);
        cn.damai.common.image.a.b().e(str).e(new b()).n(new a(str)).f();
    }

    public void delNoUseCache(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376682348")) {
            ipChange.ipc$dispatch("1376682348", new Object[]{this, list});
        } else if (cb2.d(list)) {
            this.mCacheDrawable.clear();
        } else {
            Iterator<String> it = this.mCacheDrawable.keySet().iterator();
            while (it.hasNext()) {
                if (!list.contains(it.next())) {
                    it.remove();
                }
            }
        }
    }

    public void destoryScaleImagView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344308221")) {
            ipChange.ipc$dispatch("-344308221", new Object[]{this});
        } else {
            stopAnimationV2();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468898086")) {
            ipChange.ipc$dispatch("-468898086", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        if (AppConfig.v()) {
            Log.e("DMDXScale", "onAttachedToWindow");
        }
        startAnimationV2();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549046403")) {
            ipChange.ipc$dispatch("-549046403", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        if (AppConfig.v()) {
            Log.e("DMDXScale", "onDetachedFromWindow");
        }
        stopAnimationV2();
    }

    public void setDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677087608")) {
            ipChange.ipc$dispatch("1677087608", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.duration = j;
        this.scaleInAnimation.setDuration(j);
        this.scaleOutAnimation.setDuration(j);
    }

    public void setImageList(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008141534")) {
            ipChange.ipc$dispatch("-2008141534", new Object[]{this, list});
            return;
        }
        this.imageList = list;
        delNoUseCache(list);
        if (wh2.e(list) > 0) {
            setImage(0);
        }
        startAnimationV2();
    }

    public void setInterval(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2042685993")) {
            ipChange.ipc$dispatch("2042685993", new Object[]{this, Long.valueOf(j)});
        } else {
            this.interval = j;
        }
    }

    @Deprecated
    public void startAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542979238")) {
            ipChange.ipc$dispatch("1542979238", new Object[]{this});
        } else {
            startAnimationV2();
        }
    }

    public void startAnimationV2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082037834")) {
            ipChange.ipc$dispatch("1082037834", new Object[]{this});
            return;
        }
        removeCallbacks(this.runTask);
        if (cb2.a(this.imageList) <= 1) {
            return;
        }
        postDelayed(this.runTask, this.interval + (this.duration * 2));
    }

    public void stopAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1770651776")) {
            ipChange.ipc$dispatch("1770651776", new Object[]{this});
        } else {
            stopAnimationV2();
        }
    }

    public void stopAnimationV2() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832014756")) {
            ipChange.ipc$dispatch("832014756", new Object[]{this});
        } else {
            removeCallbacks(this.runTask);
        }
    }

    public DMDXScaleAnimationImage(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imageHandler = new c(this);
        this.imageList = new ArrayList();
        this.interval = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.duration = 300L;
        this.isAttachedToWindow = false;
        this.runTask = new Runnable() { // from class: cn.damai.commonbusiness.dynamicx.customwidget.scaleimage.DMDXScaleAnimationImage.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1099301785")) {
                    ipChange.ipc$dispatch("-1099301785", new Object[]{this});
                } else if (DMDXScaleAnimationImage.this.isAttachedToWindow && cb2.a(DMDXScaleAnimationImage.this.imageList) > 1) {
                    DMDXScaleAnimationImage.this.index %= wh2.e(DMDXScaleAnimationImage.this.imageList);
                    DMDXScaleAnimationImage.this.imageHandler.sendEmptyMessage(DMDXScaleAnimationImage.this.index);
                    DMDXScaleAnimationImage.access$608(DMDXScaleAnimationImage.this);
                    DMDXScaleAnimationImage.this.startAnimationV2();
                }
            }
        };
        this.mCacheDrawable = new HashMap<>();
        initView(context);
    }

    public DMDXScaleAnimationImage(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imageHandler = new c(this);
        this.imageList = new ArrayList();
        this.interval = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.duration = 300L;
        this.isAttachedToWindow = false;
        this.runTask = new Runnable() { // from class: cn.damai.commonbusiness.dynamicx.customwidget.scaleimage.DMDXScaleAnimationImage.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1099301785")) {
                    ipChange.ipc$dispatch("-1099301785", new Object[]{this});
                } else if (DMDXScaleAnimationImage.this.isAttachedToWindow && cb2.a(DMDXScaleAnimationImage.this.imageList) > 1) {
                    DMDXScaleAnimationImage.this.index %= wh2.e(DMDXScaleAnimationImage.this.imageList);
                    DMDXScaleAnimationImage.this.imageHandler.sendEmptyMessage(DMDXScaleAnimationImage.this.index);
                    DMDXScaleAnimationImage.access$608(DMDXScaleAnimationImage.this);
                    DMDXScaleAnimationImage.this.startAnimationV2();
                }
            }
        };
        this.mCacheDrawable = new HashMap<>();
        initView(context);
    }
}
