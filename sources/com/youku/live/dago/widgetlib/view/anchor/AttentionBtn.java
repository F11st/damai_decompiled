package com.youku.live.dago.widgetlib.view.anchor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.youku.live.animation.SVGAAnimationView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AttentionBtn extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "AttentionBtn";
    private final String LaifengFollowedSVGAURL;
    private final String LaifengGuideFollowSVGAURL;
    private final String YoukuFollowedSVGAURL;
    private final String YoukuGuideFollowSVGAURL;
    private boolean isSupportAnim;
    private SVGAAnimationView mAnimationView;
    private int mBizType;
    private Handler mHandler;
    private SVGAVideoEntity mInitSVGAVideoEntity;

    public AttentionBtn(@NonNull Context context) {
        super(context);
        this.isSupportAnim = false;
        this.LaifengGuideFollowSVGAURL = "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip";
        this.YoukuGuideFollowSVGAURL = "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip";
        this.LaifengFollowedSVGAURL = "https://files.alicdn.com/tpsservice/c861a365460736c822214d1eb6f9a8f3.zip";
        this.YoukuFollowedSVGAURL = "https://files.alicdn.com/tpsservice/038f90eb888f5f91dcb2a0543be91e46.zip";
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                URL url;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1026443557")) {
                    ipChange.ipc$dispatch("1026443557", new Object[]{this, message});
                } else if (message.what == 1) {
                    try {
                        url = new URL(AttentionBtn.this.mBizType == 3 ? "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip" : "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        url = null;
                    }
                    AttentionBtn.this.playSVGAAnim(url, false);
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(1, 20000L);
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982895823")) {
            ipChange.ipc$dispatch("-1982895823", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_anchor_attention_btn, this);
        this.mAnimationView = (SVGAAnimationView) findViewById(R.id.id_attention_anim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSVGAAnim(URL url, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105353813")) {
            ipChange.ipc$dispatch("-2105353813", new Object[]{this, url, Boolean.valueOf(z)});
        } else if (this.isSupportAnim && url != null) {
            if (this.mAnimationView.isActivated()) {
                this.mAnimationView.stopAnimation(false);
            }
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "playAnim: " + url);
            new SVGAParser(getContext()).k(url, new SVGAParser.ParseCompletion() { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(@NonNull SVGAVideoEntity sVGAVideoEntity) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1860219411")) {
                        ipChange2.ipc$dispatch("1860219411", new Object[]{this, sVGAVideoEntity});
                        return;
                    }
                    AttentionBtn.this.mAnimationView.setVideoItem(sVGAVideoEntity);
                    AttentionBtn.this.mAnimationView.startAnimation();
                }

                @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2091100025")) {
                        ipChange2.ipc$dispatch("-2091100025", new Object[]{this});
                    } else if (z) {
                        AttentionBtn.this.setAttentionBtnVisiblityStatus(false, true);
                    }
                }
            });
            this.mAnimationView.setCallback(new SVGACallback() { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onFinished() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-881610390")) {
                        ipChange2.ipc$dispatch("-881610390", new Object[]{this});
                        return;
                    }
                    AttentionBtn.this.stepToFrame();
                    if (z) {
                        AttentionBtn.this.setAttentionBtnVisiblityStatus(false, true);
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onPause() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1575886712")) {
                        ipChange2.ipc$dispatch("1575886712", new Object[]{this});
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onRepeat() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "124421473")) {
                        ipChange2.ipc$dispatch("124421473", new Object[]{this});
                    }
                }

                @Override // com.opensource.svgaplayer.SVGACallback
                public void onStep(int i, double d) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2072705515")) {
                        ipChange2.ipc$dispatch("2072705515", new Object[]{this, Integer.valueOf(i), Double.valueOf(d)});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stepToFrame() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808026136")) {
            ipChange.ipc$dispatch("808026136", new Object[]{this});
            return;
        }
        SVGAVideoEntity sVGAVideoEntity = this.mInitSVGAVideoEntity;
        if (sVGAVideoEntity != null) {
            this.mAnimationView.setVideoItem(sVGAVideoEntity);
            this.mAnimationView.stepToFrame(1, false);
        }
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "523428919")) {
            ipChange.ipc$dispatch("523428919", new Object[]{this});
            return;
        }
        this.isSupportAnim = false;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        clearAnimation();
        setAttentionBtnVisiblityStatus(false, false);
    }

    public void setAttentionBtnVisiblityStatus(final boolean z, boolean z2) {
        int dip2px;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-475312257")) {
            ipChange.ipc$dispatch("-475312257", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("jiangzAtt", "setAttentionBtnVisiblityStatus " + z + ", isSmooth " + z2);
        if (!z2) {
            if (z) {
                getLayoutParams().width = UIUtil.dip2px(50);
                requestLayout();
                setVisibility(0);
                return;
            }
            getLayoutParams().width = 0;
            requestLayout();
            setVisibility(8);
            return;
        }
        if (z) {
            int dip2px2 = UIUtil.dip2px(50);
            setVisibility(0);
            i = dip2px2;
            dip2px = 0;
        } else {
            dip2px = UIUtil.dip2px(50);
            i = 0;
        }
        ValueAnimator duration = ValueAnimator.ofInt(dip2px, i).setDuration(100L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1217195020")) {
                    ipChange2.ipc$dispatch("-1217195020", new Object[]{this, valueAnimator});
                    return;
                }
                AttentionBtn.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                AttentionBtn.this.requestLayout();
            }
        });
        duration.start();
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-140850140")) {
                    ipChange2.ipc$dispatch("-140850140", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                AttentionBtn.this.setVisibility(8);
            }
        });
    }

    public void setAttentionVisibility(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583590238")) {
            ipChange.ipc$dispatch("1583590238", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (z) {
            setAttentionBtnVisiblityStatus(true, z2);
        } else if (this.isSupportAnim && z2) {
            URL url = null;
            try {
                url = new URL(this.mBizType == 3 ? "https://files.alicdn.com/tpsservice/c861a365460736c822214d1eb6f9a8f3.zip" : "https://files.alicdn.com/tpsservice/038f90eb888f5f91dcb2a0543be91e46.zip");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            playSVGAAnim(url, true);
        } else {
            setAttentionBtnVisiblityStatus(false, z2);
        }
    }

    public void setBizType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955821950")) {
            ipChange.ipc$dispatch("-1955821950", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mBizType = i;
        this.mAnimationView.setSize(UIUtil.dip2px(50), UIUtil.dip2px(36));
        this.mAnimationView.setLoops(1);
        try {
            new SVGAParser(getContext()).k(new URL(this.mBizType == 3 ? "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip" : "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip"), new SVGAParser.ParseCompletion() { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(@NonNull SVGAVideoEntity sVGAVideoEntity) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2031100017")) {
                        ipChange2.ipc$dispatch("-2031100017", new Object[]{this, sVGAVideoEntity});
                        return;
                    }
                    AttentionBtn.this.mInitSVGAVideoEntity = sVGAVideoEntity;
                    AttentionBtn.this.stepToFrame();
                }

                @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "181632771")) {
                        ipChange2.ipc$dispatch("181632771", new Object[]{this});
                    }
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setSupportAnim(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906372838")) {
            ipChange.ipc$dispatch("1906372838", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSupportAnim = z;
        if (z) {
            this.mHandler.sendEmptyMessageDelayed(1, 6000L);
        }
    }

    public AttentionBtn(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSupportAnim = false;
        this.LaifengGuideFollowSVGAURL = "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip";
        this.YoukuGuideFollowSVGAURL = "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip";
        this.LaifengFollowedSVGAURL = "https://files.alicdn.com/tpsservice/c861a365460736c822214d1eb6f9a8f3.zip";
        this.YoukuFollowedSVGAURL = "https://files.alicdn.com/tpsservice/038f90eb888f5f91dcb2a0543be91e46.zip";
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                URL url;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1026443557")) {
                    ipChange.ipc$dispatch("1026443557", new Object[]{this, message});
                } else if (message.what == 1) {
                    try {
                        url = new URL(AttentionBtn.this.mBizType == 3 ? "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip" : "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        url = null;
                    }
                    AttentionBtn.this.playSVGAAnim(url, false);
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(1, 20000L);
                }
            }
        };
        initView(context);
    }

    public AttentionBtn(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSupportAnim = false;
        this.LaifengGuideFollowSVGAURL = "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip";
        this.YoukuGuideFollowSVGAURL = "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip";
        this.LaifengFollowedSVGAURL = "https://files.alicdn.com/tpsservice/c861a365460736c822214d1eb6f9a8f3.zip";
        this.YoukuFollowedSVGAURL = "https://files.alicdn.com/tpsservice/038f90eb888f5f91dcb2a0543be91e46.zip";
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.view.anchor.AttentionBtn.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                URL url;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1026443557")) {
                    ipChange.ipc$dispatch("1026443557", new Object[]{this, message});
                } else if (message.what == 1) {
                    try {
                        url = new URL(AttentionBtn.this.mBizType == 3 ? "https://files.alicdn.com/tpsservice/3218d2cc33db0fb73fb24dffa51e65d5.zip" : "https://files.alicdn.com/tpsservice/6731c19d47aa94747650a73732acb0b7.zip");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        url = null;
                    }
                    AttentionBtn.this.playSVGAAnim(url, false);
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(1, 20000L);
                }
            }
        };
        initView(context);
    }
}
