package com.youku.live.dago.widgetlib.wedome.adapter.animation;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.animate.AnimatedLoopListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.common.Constants;
import com.youku.alixplayer.AlixPlayer;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.PlayerView;
import com.youku.alixplayer.filter.BuiltInRenderFilter;
import com.youku.live.animation.AnimationError;
import com.youku.live.animation.AnimationView;
import com.youku.live.animation.IAnimationCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.doodle.RobotPainter;
import com.youku.live.dago.widgetlib.doodle.SplashItemParser;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import com.youku.live.dago.widgetlib.doodle.drawable.TUrlDrawable;
import com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashItemParser;
import com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashScheduler;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.MineLotteryData;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView;
import com.youku.live.dago.widgetlib.interactive.gift.view.BigGiftNumLayout;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol;
import com.youku.live.dago.widgetlib.util.OrangeUtil;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.playerservice.player.UrlMediaSource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLAnimationViewAdapter implements YKLAnimationViewProtocol {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_MP4 = "mp4";
    public static final String TYPE_MP4GIFT = "mp4gift";
    public static final String TYPE_WEBP = "webp";
    private AnimationView mAnimationView;
    private IAnimationCallback mCallback;
    private String mComboCount;
    private Context mContext;
    private AlixPlayer mGiftPlayer;
    private SquareLayout mGiftPlayerContainer;
    private PlayerView mGiftPlayerView;
    private SplashItemParser<String, String> mSplashItemParser;
    private SplashScheduler<String, String> mSplashScheduler;
    private int mViewWidth = -1;
    private int mViewHeight = -1;
    private int mWeexWidth = -1;
    private int mWeexHeight = -1;
    private final int WEEX_LENGTH = FeatureFactory.PRIORITY_ABOVE_NORMAL;

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter$10  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType;

        static {
            int[] iArr = new int[YKLAnimationViewProtocol.GiftType.values().length];
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType = iArr;
            try {
                iArr[YKLAnimationViewProtocol.GiftType.GRAFFITI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.MP4_GIFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.MP4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.LOTTIE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.SVGA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[YKLAnimationViewProtocol.GiftType.WEBP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "849029306")) {
                ipChange.ipc$dispatch("849029306", new Object[]{this});
                return;
            }
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300L);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.4.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-547484516")) {
                        ipChange2.ipc$dispatch("-547484516", new Object[]{this, animation});
                        return;
                    }
                    if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                    }
                    YKLAnimationViewAdapter.this.mAnimationView.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.4.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1220157984")) {
                                ipChange3.ipc$dispatch("1220157984", new Object[]{this});
                            } else {
                                YKLAnimationViewAdapter.this.mAnimationView.removeView(YKLAnimationViewAdapter.this.mSplashScheduler.getContentView());
                            }
                        }
                    }, 150L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1661967704")) {
                        ipChange2.ipc$dispatch("1661967704", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "643557621")) {
                        ipChange2.ipc$dispatch("643557621", new Object[]{this, animation});
                    }
                }
            });
            YKLAnimationViewAdapter.this.mSplashScheduler.getContentView().startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SquareLayout extends FrameLayout {
        public SquareLayout(@NonNull Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (size <= size2) {
                size = size2;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size, mode2));
        }
    }

    public YKLAnimationViewAdapter(Context context) {
        this.mContext = context;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNumView(AnimationView animationView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584807083")) {
            ipChange.ipc$dispatch("-584807083", new Object[]{this, animationView, str});
        } else if (ParseUtils.parse2Int(str) < 2) {
        } else {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-bignum", "addNumView comboNum = " + str);
            if (animationView == null || TextUtils.isEmpty(str)) {
                return;
            }
            BigGiftNumLayout bigGiftNumLayout = new BigGiftNumLayout(animationView.getContext());
            bigGiftNumLayout.setNum(str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            layoutParams.bottomMargin = DensityUtil.dip2px(this.mContext, 20.0f);
            animationView.addView(bigGiftNumLayout, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelGiftPlayer() {
        SquareLayout squareLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119637514")) {
            ipChange.ipc$dispatch("119637514", new Object[]{this});
            return;
        }
        AlixPlayer alixPlayer = this.mGiftPlayer;
        if (alixPlayer != null) {
            alixPlayer.stop();
            this.mGiftPlayer = null;
        }
        PlayerView playerView = this.mGiftPlayerView;
        if (playerView != null && this.mGiftPlayerContainer != null) {
            if (this.mGiftPlayerContainer.equals(playerView.getParent())) {
                this.mGiftPlayerContainer.removeView(this.mGiftPlayerView);
            }
            this.mGiftPlayerView = null;
        }
        if (this.mAnimationView == null || (squareLayout = this.mGiftPlayerContainer) == null) {
            return;
        }
        if (this.mAnimationView.equals(squareLayout.getParent())) {
            this.mAnimationView.removeView(this.mGiftPlayerContainer);
        }
        this.mGiftPlayerContainer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGestureGiftDisappearAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193632262")) {
            ipChange.ipc$dispatch("193632262", new Object[]{this});
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass4(), 1000L);
        }
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22538971")) {
            ipChange.ipc$dispatch("-22538971", new Object[]{this});
            return;
        }
        this.mAnimationView = new AnimationView(this.mContext);
        this.mAnimationView.useCache(OrangeUtil.isUseCacheInSVGAAnim());
        this.mAnimationView.setFocusable(false);
        this.mAnimationView.setClickable(false);
        this.mAnimationView.isWeex(true);
    }

    private void playGraffiti(String str, final String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1609885422")) {
            ipChange.ipc$dispatch("1609885422", new Object[]{this, str, str2, str3, map});
            return;
        }
        if (this.mSplashScheduler == null) {
            this.mSplashItemParser = LaifengSplashItemParser.getInstance();
            LaifengSplashScheduler laifengSplashScheduler = new LaifengSplashScheduler(this.mContext);
            this.mSplashScheduler = laifengSplashScheduler;
            laifengSplashScheduler.setParser(this.mSplashItemParser);
            this.mSplashScheduler.enableTouch(false);
            this.mSplashScheduler.setRenderScaleType(RobotPainter.ScaleType.CENTER_INSIDE);
            this.mSplashScheduler.addOnSplashUpdateListener(new SplashScheduler.OnSplashUpdateListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
                public void onPaintingEnd() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1538865999")) {
                        ipChange2.ipc$dispatch("1538865999", new Object[]{this});
                    } else {
                        YKLAnimationViewAdapter.this.doGestureGiftDisappearAnimation();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
                public void onPaintingStart() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1025715496")) {
                        ipChange2.ipc$dispatch("1025715496", new Object[]{this});
                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
                public void onSplashUpdate(float f, float f2, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-953439948")) {
                        ipChange2.ipc$dispatch("-953439948", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                    }
                }
            });
        }
        SplashScheduler.IconItem[] iconItemArr = new SplashScheduler.IconItem[map.size()];
        int dip2px = DensityUtil.dip2px(AppContextUtils.getApp(), 34.0f);
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            iconItemArr[i] = new SplashScheduler.IconItem();
            iconItemArr[i].icon = new TUrlDrawable(entry.getValue(), null);
            iconItemArr[i].icon.setBounds(0, 0, dip2px, dip2px);
            iconItemArr[i].stringId = entry.getKey();
            iconItemArr[i].iconIdentity = entry.getKey().hashCode();
            i++;
        }
        this.mSplashScheduler.setIcons(iconItemArr);
        this.mSplashScheduler.getSketchBoard().clear();
        this.mSplashScheduler.getContentView().setVisibility(0);
        this.mAnimationView.addView(this.mSplashScheduler.getContentView(), new ViewGroup.LayoutParams(-1, -1));
        this.mSplashScheduler.updateCanvasSize(str);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1045542811")) {
                    ipChange2.ipc$dispatch("1045542811", new Object[]{this});
                } else {
                    YKLAnimationViewAdapter.this.mSplashScheduler.render(str2);
                }
            }
        }, 500L);
    }

    private void playMp4Gift(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766443378")) {
            ipChange.ipc$dispatch("1766443378", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError());
            }
        } else {
            File file = new File(str);
            String str2 = null;
            if (!file.exists()) {
                IAnimationCallback iAnimationCallback2 = this.mCallback;
                if (iAnimationCallback2 != null) {
                    iAnimationCallback2.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "file.exists()");
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null && (file2.getAbsolutePath().endsWith(".mp4gift") || file2.getAbsolutePath().endsWith(".mp4"))) {
                            str2 = file2.getAbsolutePath();
                            break;
                        }
                    }
                } else {
                    IAnimationCallback iAnimationCallback3 = this.mCallback;
                    if (iAnimationCallback3 != null) {
                        iAnimationCallback3.onAnimationError(new AnimationError());
                        return;
                    }
                    return;
                }
            } else {
                str2 = file.getAbsolutePath();
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath = " + str2);
            this.mAnimationView.removeAllViews();
            AlixPlayer alixPlayer = new AlixPlayer(this.mContext);
            alixPlayer.addRenderFilter(new BuiltInRenderFilter(BuiltInRenderFilter.VideoFilter.ALPHA));
            alixPlayer.addOnPlayerStateListener(new OnStateChangeListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.OnStateChangeListener
                public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-870666114")) {
                        ipChange2.ipc$dispatch("-870666114", new Object[]{this, state, state2});
                        return;
                    }
                    if (state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
                        YKLAnimationViewAdapter.this.mGiftPlayer.prepareAsync();
                    }
                    if (state2 == IAlixPlayer.State.STATE_PREPARED) {
                        YKLAnimationViewAdapter.this.mGiftPlayer.start();
                        if (YKLAnimationViewAdapter.this.mAnimationView != null) {
                            YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.5.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "1643726636")) {
                                        ipChange3.ipc$dispatch("1643726636", new Object[]{this});
                                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                                        YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                                    }
                                }
                            });
                        }
                    }
                    if (state2 != IAlixPlayer.State.STATE_VIDEO_COMPLETED || YKLAnimationViewAdapter.this.mAnimationView == null) {
                        return;
                    }
                    YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.5.2
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1447213131")) {
                                ipChange3.ipc$dispatch("1447213131", new Object[]{this});
                                return;
                            }
                            YKLAnimationViewAdapter.this.cancelGiftPlayer();
                            if (YKLAnimationViewAdapter.this.mCallback != null) {
                                YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                            }
                        }
                    });
                }
            });
            alixPlayer.addOnInfoListener(new OnInfoListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.alixplayer.OnInfoListener
                public void onInfo(int i, int i2, int i3, Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-657878139")) {
                        ipChange2.ipc$dispatch("-657878139", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj});
                        return;
                    }
                    if (i != 503 && i != 1002 && i != 1023 && i != 2205 && i != 3002 && i != 70000 && i != 1110 && i != 1111 && i != 2004 && i != 2005 && i != 2200 && i != 2201 && i != 16005 && i != 16006 && i != 30000 && i != 30001) {
                        switch (i) {
                            case 1005:
                            case 1006:
                            case 1007:
                            case 1008:
                            case 1009:
                            case 1010:
                                break;
                            default:
                                return;
                        }
                    }
                    if (YKLAnimationViewAdapter.this.mCallback != null) {
                        ((ILog) Dsl.getService(ILog.class)).e("liulei-anim-mp4", "MP4 ANIM ERROR CODE = " + i);
                        final IAnimationCallback iAnimationCallback4 = YKLAnimationViewAdapter.this.mCallback;
                        WidgetSDKEngine.getInstance().getRenderMananger().postOnUiThread(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.6.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1772809355")) {
                                    ipChange3.ipc$dispatch("1772809355", new Object[]{this});
                                    return;
                                }
                                IAnimationCallback iAnimationCallback5 = iAnimationCallback4;
                                if (iAnimationCallback5 != null) {
                                    iAnimationCallback5.onAnimationError(new AnimationError());
                                }
                            }
                        });
                    }
                }
            });
            PlayerView playerView = new PlayerView(this.mContext);
            playerView.setPlayer(alixPlayer);
            playerView.setRenderDevice(PlayerView.RenderDeviceType.TEXTURE);
            playerView.setProportionRelation(PlayerView.ProportionRelation.FILL_SCREEN);
            this.mGiftPlayer = alixPlayer;
            this.mGiftPlayerView = playerView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            SquareLayout squareLayout = new SquareLayout(this.mContext);
            this.mGiftPlayerContainer = squareLayout;
            squareLayout.addView(this.mGiftPlayerView, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            this.mAnimationView.addView(this.mGiftPlayerContainer, layoutParams2);
            alixPlayer.setDataSource(new UrlMediaSource(str2));
        }
    }

    private void playWebPAnim(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1412930978")) {
            ipChange.ipc$dispatch("-1412930978", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "playWebPAnim");
        if (this.mAnimationView.getParent() != null) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "mAnimationView.getParent() = " + this.mAnimationView.getParent().getClass());
        }
        if (TextUtils.isEmpty(str)) {
            IAnimationCallback iAnimationCallback = this.mCallback;
            if (iAnimationCallback != null) {
                iAnimationCallback.onAnimationError(new AnimationError());
                return;
            }
            return;
        }
        File file = new File(str);
        String str2 = null;
        if (!file.exists()) {
            IAnimationCallback iAnimationCallback2 = this.mCallback;
            if (iAnimationCallback2 != null) {
                iAnimationCallback2.onAnimationError(new AnimationError());
                return;
            }
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "file.exists()");
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                while (true) {
                    if (i < listFiles.length) {
                        File file2 = listFiles[i];
                        if (file2 != null && file2.exists()) {
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation animFile 5555 = " + file2.getAbsolutePath());
                        }
                        if (file2 != null && file2.getAbsolutePath().endsWith(".webp")) {
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath 11111 = " + ((String) null));
                            str2 = file2.getAbsolutePath();
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            } else {
                IAnimationCallback iAnimationCallback3 = this.mCallback;
                if (iAnimationCallback3 != null) {
                    iAnimationCallback3.onAnimationError(new AnimationError());
                    return;
                }
                return;
            }
        } else {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath 2222 = " + ((String) null));
            str2 = file.getAbsolutePath();
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation resourcePath = " + str2);
        this.mAnimationView.removeAllViews();
        final TUrlImageView tUrlImageView = new TUrlImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mAnimationView.addView(tUrlImageView, layoutParams);
        DagoImageLoader.getInstance().load(this.mContext, str2, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-681230459")) {
                    ipChange2.ipc$dispatch("-681230459", new Object[]{this});
                } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                    YKLAnimationViewAdapter.this.mCallback.onAnimationError(new AnimationError());
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-618227751")) {
                    ipChange2.ipc$dispatch("-618227751", new Object[]{this, bitmapDrawable});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "PhenixTicket  ");
                if (bitmapDrawable instanceof AnimatedImageDrawable) {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) bitmapDrawable;
                    animatedImageDrawable.setMaxLoopCount(1);
                    animatedImageDrawable.setAnimatedLoopListener(new AnimatedLoopListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.taobao.phenix.animate.AnimatedLoopListener
                        public boolean onLoopCompleted(int i2, int i3) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "415026519")) {
                                return ((Boolean) ipChange3.ipc$dispatch("415026519", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
                            }
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onSuccess onLoopCompleted " + i2 + "         " + i3);
                            if (i2 == 1 && YKLAnimationViewAdapter.this.mCallback != null) {
                                YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                            }
                            return true;
                        }
                    });
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onSuccess AnimatedImageDrawable ");
                }
                if (YKLAnimationViewAdapter.this.mCallback != null) {
                    YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                }
                tUrlImageView.setImageDrawable(bitmapDrawable);
            }
        });
    }

    private void setViewLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-100496834")) {
            ipChange.ipc$dispatch("-100496834", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-anim", "WIDTH = " + this.mViewWidth + "   HEIGHT = " + this.mViewHeight);
        AnimationView animationView = this.mAnimationView;
        if (animationView == null || animationView.getParent() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mAnimationView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        } else {
            layoutParams.width = this.mViewWidth;
            layoutParams.height = this.mViewHeight;
        }
        layoutParams.gravity = 17;
        this.mAnimationView.setLayoutParams(layoutParams);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602123131")) {
            ipChange.ipc$dispatch("602123131", new Object[]{this});
            return;
        }
        cancelGiftPlayer();
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.cancel();
            this.mAnimationView.removeAllViews();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void defaultPlay(YKLAnimationViewProtocol.GiftAnimationItem giftAnimationItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118735017")) {
            ipChange.ipc$dispatch("118735017", new Object[]{this, giftAnimationItem});
        } else if (AnonymousClass10.$SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[giftAnimationItem.type.ordinal()] != 1) {
            if (!TextUtils.isEmpty(giftAnimationItem.localPath)) {
                defaultPlayByLocalPah(giftAnimationItem.type.getTypeString(), giftAnimationItem.localPath, giftAnimationItem.isZip, giftAnimationItem.autoPlay, giftAnimationItem.properties);
            } else if (TextUtils.isEmpty(giftAnimationItem.data)) {
                defaultPlayById(giftAnimationItem.type.getTypeString(), giftAnimationItem.id, giftAnimationItem.properties);
            } else {
                defaultPlayByUrl(giftAnimationItem.type.getTypeString(), giftAnimationItem.data, giftAnimationItem.isZip, giftAnimationItem.autoPlay, giftAnimationItem.properties);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void defaultPlayById(java.lang.String r8, java.lang.String r9, java.util.Map r10) {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.$ipChange
            java.lang.String r1 = "-114567581"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1d
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r7
            r2[r3] = r8
            r8 = 2
            r2[r8] = r9
            r8 = 3
            r2[r8] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L1d:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L32
            com.youku.live.animation.AnimationError r8 = new com.youku.live.animation.AnimationError
            r8.<init>()
            java.lang.String r9 = "id is null"
            r8.errorMessage = r9
            com.youku.live.animation.IAnimationCallback r9 = r7.mCallback
            r9.onAnimationError(r8)
            return
        L32:
            com.youku.live.animation.AnimationFileType r0 = com.youku.live.animation.AnimationFileType.TYPE_SVGA
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 != 0) goto L52
            java.lang.String r1 = r0.getFileName()
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L45
            goto L52
        L45:
            com.youku.live.animation.AnimationFileType r1 = com.youku.live.animation.AnimationFileType.TYPE_LOTTIE
            java.lang.String r2 = r1.getFileName()
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L52
            r0 = r1
        L52:
            r8 = 0
            if (r10 == 0) goto L71
            java.lang.String r1 = "loop"
            java.lang.Object r10 = r10.get(r1)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L71
            com.youku.live.animation.AnimationProperties r8 = new com.youku.live.animation.AnimationProperties
            r8.<init>()
            int r10 = java.lang.Integer.parseInt(r10)
            r8.loopCount = r10
            goto L72
        L71:
            r10 = 1
        L72:
            com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager r1 = com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager.getInstance()
            java.util.List r1 = r1.getResourcePath(r9)
            java.lang.Class<com.youku.live.dsl.log.ILog> r2 = com.youku.live.dsl.log.ILog.class
            java.lang.Object r2 = com.youku.live.dsl.Dsl.getService(r2)
            com.youku.live.dsl.log.ILog r2 = (com.youku.live.dsl.log.ILog) r2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "animation pathes is null = "
            r5.append(r6)
            if (r1 != 0) goto L8f
            goto L90
        L8f:
            r3 = 0
        L90:
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r5 = "liulei-anim"
            r2.d(r5, r3)
            if (r1 == 0) goto Lc8
            int r2 = r1.size()
            if (r2 <= 0) goto Lc8
            java.lang.Object r9 = r1.get(r4)
            java.lang.String r9 = (java.lang.String) r9
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto Lbd
            com.youku.live.animation.AnimationView r1 = r7.mAnimationView
            if (r1 == 0) goto Lc7
            r1.setLoopCount(r10)
            com.youku.live.animation.AnimationView r10 = r7.mAnimationView
            r10.play(r0, r9, r8)
            goto Lc7
        Lbd:
            com.youku.live.animation.IAnimationCallback r8 = r7.mCallback
            com.youku.live.animation.AnimationError r9 = new com.youku.live.animation.AnimationError
            r9.<init>()
            r8.onAnimationError(r9)
        Lc7:
            return
        Lc8:
            com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager r8 = com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager.getInstance()
            r8.getResourcePath(r9)
            com.youku.live.animation.IAnimationCallback r8 = r7.mCallback
            com.youku.live.animation.AnimationError r9 = new com.youku.live.animation.AnimationError
            r9.<init>()
            r8.onAnimationError(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.defaultPlayById(java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void defaultPlayByLocalPah(java.lang.String r11, java.lang.String r12, boolean r13, java.lang.String r14, java.util.Map r15) {
        /*
            r10 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.$ipChange
            java.lang.String r1 = "-1282116456"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            if (r2 == 0) goto L27
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            r2[r4] = r10
            r2[r3] = r11
            r11 = 2
            r2[r11] = r12
            r11 = 3
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r13)
            r2[r11] = r12
            r11 = 4
            r2[r11] = r14
            r11 = 5
            r2[r11] = r15
            r0.ipc$dispatch(r1, r2)
            return
        L27:
            java.lang.Class<com.youku.live.dsl.log.ILog> r13 = com.youku.live.dsl.log.ILog.class
            java.lang.Object r13 = com.youku.live.dsl.Dsl.getService(r13)
            com.youku.live.dsl.log.ILog r13 = (com.youku.live.dsl.log.ILog) r13
            java.lang.String r0 = "liulei-anim"
            java.lang.String r1 = "defaultPlayByUrl"
            r13.d(r0, r1)
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 == 0) goto L4b
            com.youku.live.animation.AnimationError r11 = new com.youku.live.animation.AnimationError
            r11.<init>()
            java.lang.String r12 = "localPath is null"
            r11.errorMessage = r12
            com.youku.live.animation.IAnimationCallback r12 = r10.mCallback
            r12.onAnimationError(r11)
            return
        L4b:
            com.youku.live.animation.AnimationFileType r13 = com.youku.live.animation.AnimationFileType.TYPE_SVGA
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L6c
            java.lang.String r0 = r13.getFileName()
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L5e
            goto L6c
        L5e:
            com.youku.live.animation.AnimationFileType r0 = com.youku.live.animation.AnimationFileType.TYPE_LOTTIE
            java.lang.String r1 = r0.getFileName()
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L6c
            r7 = r0
            goto L6d
        L6c:
            r7 = r13
        L6d:
            r11 = 0
            if (r15 == 0) goto L8b
            java.lang.String r13 = "loop"
            java.lang.Object r13 = r15.get(r13)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            boolean r15 = android.text.TextUtils.isEmpty(r13)
            if (r15 != 0) goto L8b
            com.youku.live.animation.AnimationProperties r11 = new com.youku.live.animation.AnimationProperties
            r11.<init>()
            int r3 = java.lang.Integer.parseInt(r13)
            r11.loopCount = r3
        L8b:
            r9 = r11
            com.youku.live.animation.AnimationView r11 = r10.mAnimationView
            if (r11 == 0) goto Lb6
            r11.setLoopCount(r3)
            java.lang.String r11 = "1"
            boolean r11 = r11.equals(r14)
            if (r11 == 0) goto La1
            com.youku.live.animation.AnimationView r11 = r10.mAnimationView
            r11.play(r7, r12, r9)
            goto Lb1
        La1:
            java.lang.String r11 = "0"
            boolean r11 = r11.equals(r14)
            if (r11 == 0) goto Lb1
            com.youku.live.animation.AnimationView r4 = r10.mAnimationView
            r5 = 1
            r6 = 0
            r8 = r12
            r4.stepFramePlay(r5, r6, r7, r8, r9)
        Lb1:
            com.youku.live.animation.IAnimationCallback r11 = r10.mCallback
            r11.onAnimationStart()
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.defaultPlayByLocalPah(java.lang.String, java.lang.String, boolean, java.lang.String, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void defaultPlayByUrl(final java.lang.String r19, final java.lang.String r20, final boolean r21, final java.lang.String r22, final java.util.Map r23) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.defaultPlayByUrl(java.lang.String, java.lang.String, boolean, java.lang.String, java.util.Map):void");
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-587445380") ? (View) ipChange.ipc$dispatch("-587445380", new Object[]{this}) : this.mAnimationView;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void play(YKLAnimationViewProtocol.GiftAnimationItem giftAnimationItem) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818291704")) {
            ipChange.ipc$dispatch("-818291704", new Object[]{this, giftAnimationItem});
            return;
        }
        int screenWidth = UIUtil.getScreenWidth(this.mContext);
        int screenHeight = UIUtil.getScreenHeight(this.mContext);
        if (screenWidth > screenHeight) {
            screenWidth = screenHeight;
        }
        int i2 = this.mWeexWidth;
        if (i2 > 0 && (i = this.mWeexHeight) > 0) {
            this.mViewHeight = (i * screenWidth) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
            this.mViewWidth = (i2 * screenWidth) / FeatureFactory.PRIORITY_ABOVE_NORMAL;
        } else {
            this.mViewHeight = -1;
            this.mViewWidth = -1;
        }
        setViewLayoutParams();
        switch (AnonymousClass10.$SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[giftAnimationItem.type.ordinal()]) {
            case 1:
                try {
                    ILog iLog = (ILog) Dsl.getService(ILog.class);
                    StringBuilder sb = new StringBuilder();
                    sb.append("animation playback:");
                    String str = giftAnimationItem.data;
                    if (str == null) {
                        str = "null";
                    }
                    sb.append(str);
                    iLog.d("GRAFFITI", sb.toString());
                    JSONObject parseObject = JSON.parseObject(giftAnimationItem.data);
                    if (parseObject != null) {
                        String string = parseObject.getString("canvas");
                        String string2 = parseObject.getString("points");
                        JSONArray jSONArray = parseObject.getJSONArray("iconUrls");
                        HashMap hashMap = new HashMap();
                        for (int i3 = 0; i3 < jSONArray.size(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            String next = jSONObject.keySet().iterator().next();
                            hashMap.put(next, jSONObject.getString(next));
                        }
                        playGraffiti(string, string2, parseObject.containsKey(Constants.Name.INTERVAL) ? parseObject.getString(Constants.Name.INTERVAL) : MessageService.MSG_DB_COMPLETE, hashMap);
                        return;
                    }
                    IAnimationCallback iAnimationCallback = this.mCallback;
                    if (iAnimationCallback != null) {
                        iAnimationCallback.onAnimationError(new AnimationError());
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.mCallback.onAnimationError(new AnimationError());
                    return;
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (TextUtils.isEmpty(giftAnimationItem.data)) {
                    playById(giftAnimationItem.type.getTypeString(), giftAnimationItem.id, giftAnimationItem.properties);
                    return;
                } else {
                    playByUrl(giftAnimationItem.type.getTypeString(), giftAnimationItem.data, giftAnimationItem.isZip, giftAnimationItem.properties);
                    return;
                }
            default:
                this.mCallback.onAnimationError(new AnimationError());
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void playById(java.lang.String r9, java.lang.String r10, java.util.Map r11) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.playById(java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117  */
    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void playByUrl(java.lang.String r22, java.lang.String r23, boolean r24, java.util.Map r25) {
        /*
            Method dump skipped, instructions count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.playByUrl(java.lang.String, java.lang.String, boolean, java.util.Map):void");
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void playLottery(List<MineLotteryData> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164182511")) {
            ipChange.ipc$dispatch("-164182511", new Object[]{this, list});
            return;
        }
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            if (animationView.getChildCount() != 0) {
                this.mAnimationView.removeAllViews();
            }
            MineLotteryView mineLotteryView = new MineLotteryView(this.mContext);
            mineLotteryView.setOnAnimationStateListener(new MineLotteryView.OnAnimationStateListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView.OnAnimationStateListener
                public void onEnd() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "726218917")) {
                        ipChange2.ipc$dispatch("726218917", new Object[]{this});
                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationEnd();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.gift.lottery.view.MineLotteryView.OnAnimationStateListener
                public void onStart() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1755917566")) {
                        ipChange2.ipc$dispatch("1755917566", new Object[]{this});
                    } else if (YKLAnimationViewAdapter.this.mCallback != null) {
                        YKLAnimationViewAdapter.this.mCallback.onAnimationStart();
                    }
                }
            });
            mineLotteryView.setData(list);
            this.mAnimationView.addView(mineLotteryView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void setAnimationCallback(final IAnimationCallback iAnimationCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-560621671")) {
            ipChange.ipc$dispatch("-560621671", new Object[]{this, iAnimationCallback});
            return;
        }
        IAnimationCallback iAnimationCallback2 = new IAnimationCallback() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationCancel() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "430529571")) {
                    ipChange2.ipc$dispatch("430529571", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationCancel ");
                IAnimationCallback iAnimationCallback3 = iAnimationCallback;
                if (iAnimationCallback3 != null) {
                    iAnimationCallback3.onAnimationCancel();
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationEnd() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2037112750")) {
                    ipChange2.ipc$dispatch("-2037112750", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationEnd ");
                if (YKLAnimationViewAdapter.this.mAnimationView != null && YKLAnimationViewAdapter.this.mAnimationView.getHandler() != null) {
                    YKLAnimationViewAdapter.this.mAnimationView.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.7.2
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1705378569")) {
                                ipChange3.ipc$dispatch("1705378569", new Object[]{this});
                            } else {
                                YKLAnimationViewAdapter.this.mAnimationView.removeAllViews();
                            }
                        }
                    }, 150L);
                }
                IAnimationCallback iAnimationCallback3 = iAnimationCallback;
                if (iAnimationCallback3 != null) {
                    iAnimationCallback3.onAnimationEnd();
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationError(AnimationError animationError) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1614431806")) {
                    ipChange2.ipc$dispatch("1614431806", new Object[]{this, animationError});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationError ");
                IAnimationCallback iAnimationCallback3 = iAnimationCallback;
                if (iAnimationCallback3 != null) {
                    iAnimationCallback3.onAnimationError(animationError);
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationStart() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "483974507")) {
                    ipChange2.ipc$dispatch("483974507", new Object[]{this});
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "onAnimationStart ");
                IAnimationCallback iAnimationCallback3 = iAnimationCallback;
                if (iAnimationCallback3 != null) {
                    iAnimationCallback3.onAnimationStart();
                }
                if (YKLAnimationViewAdapter.this.mAnimationView == null || YKLAnimationViewAdapter.this.mAnimationView.getHandler() == null) {
                    return;
                }
                YKLAnimationViewAdapter.this.mAnimationView.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter.7.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "1901892074")) {
                            ipChange3.ipc$dispatch("1901892074", new Object[]{this});
                            return;
                        }
                        YKLAnimationViewAdapter yKLAnimationViewAdapter = YKLAnimationViewAdapter.this;
                        yKLAnimationViewAdapter.addNumView(yKLAnimationViewAdapter.mAnimationView, YKLAnimationViewAdapter.this.mComboCount);
                    }
                });
            }
        };
        this.mCallback = iAnimationCallback2;
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.setAnimationCallback(iAnimationCallback2);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1418732494")) {
            ipChange.ipc$dispatch("-1418732494", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i != -1 && i2 != -1) {
            this.mWeexWidth = i;
            this.mWeexHeight = i2;
            ((ILog) Dsl.getService(ILog.class)).i("liulei-anim", "REAL size = " + this.mViewWidth + "    " + this.mViewHeight);
        } else {
            this.mWeexWidth = -1;
            this.mWeexHeight = -1;
            this.mViewWidth = -1;
            this.mViewHeight = -1;
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void stepToFrame(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485658656")) {
            ipChange.ipc$dispatch("1485658656", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.stepToFrame(i, z);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol
    public void stepToPercentge(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188591601")) {
            ipChange.ipc$dispatch("-1188591601", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
            return;
        }
        AnimationView animationView = this.mAnimationView;
        if (animationView != null) {
            animationView.stepToPercentage(d, z);
        }
    }
}
