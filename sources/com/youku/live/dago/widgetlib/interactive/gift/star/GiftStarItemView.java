package com.youku.live.dago.widgetlib.interactive.gift.star;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper;
import com.youku.live.dago.widgetlib.util.FastJsonTools;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetError;
import com.youku.live.dsl.network.INetResponse;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftStarItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int START_LOOP_GET_MAX = 3;
    private StarCountComputeHelper.IEventCallback mCounterEventCallback;
    ImageView mLoadingImageView;
    private StarCountComputeHelper mStarCountComputeHelper;
    private int mStarLoopGet;
    TextView mTvCount;
    TextView mTvSecond;
    TextView mTvStart;
    private Handler mWeakHandler;
    Animation scaleAnim;

    public GiftStarItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ int access$308(GiftStarItemView giftStarItemView) {
        int i = giftStarItemView.mStarLoopGet;
        giftStarItemView.mStarLoopGet = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void httpLoadStar(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550633231")) {
            ipChange.ipc$dispatch("-550633231", new Object[]{this, Boolean.valueOf(z)});
        } else {
            ActorStarApi.aquireStarRequest(null, new INetCallback() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-638730677")) {
                        ipChange2.ipc$dispatch("-638730677", new Object[]{this, iNetResponse});
                    } else if (iNetResponse == null) {
                    } else {
                        final StarModelNew starModelNew = (StarModelNew) FastJsonTools.deserialize(iNetResponse.getSource(), StarModelNew.class);
                        if (starModelNew != null) {
                            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "starInfo count = " + starModelNew.starAvail);
                            if (GiftStarItemView.this.mStarCountComputeHelper != null) {
                                GiftStarItemView.this.mStarCountComputeHelper.activateCounter(starModelNew);
                            } else if (GiftStarItemView.this.mStarCountComputeHelper == null) {
                                GiftStarItemView giftStarItemView = GiftStarItemView.this;
                                giftStarItemView.mStarCountComputeHelper = new StarCountComputeHelper((Activity) giftStarItemView.getContext());
                                GiftStarItemView.this.mStarCountComputeHelper.setEventCallback(GiftStarItemView.this.mCounterEventCallback);
                            }
                            GiftStarItemView.this.mWeakHandler.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.2.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "981065537")) {
                                        ipChange3.ipc$dispatch("981065537", new Object[]{this});
                                        return;
                                    }
                                    TextView textView = GiftStarItemView.this.mTvCount;
                                    textView.setText("" + starModelNew.starAvail);
                                    GiftStarItemView.this.mTvCount.setVisibility(0);
                                }
                            });
                            return;
                        }
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "starInfo == null");
                    }
                }
            }, new INetError() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetError
                public void onError(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-609245895")) {
                        ipChange2.ipc$dispatch("-609245895", new Object[]{this, str});
                        return;
                    }
                    if (!z) {
                        GiftStarItemView.this.mStarLoopGet = 0;
                    }
                    if (GiftStarItemView.this.mStarLoopGet < 3) {
                        GiftStarItemView.this.mWeakHandler.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.3.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1110148256")) {
                                    ipChange3.ipc$dispatch("1110148256", new Object[]{this});
                                } else {
                                    GiftStarItemView.this.httpLoadStar(false);
                                }
                            }
                        }, 3000L);
                    }
                    GiftStarItemView.access$308(GiftStarItemView.this);
                }
            });
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024187314")) {
            ipChange.ipc$dispatch("-2024187314", new Object[]{this});
            return;
        }
        this.mLoadingImageView = (ImageView) findViewById(R.id.id_gift_star_view);
        this.mTvSecond = (TextView) findViewById(R.id.tv_second);
        this.mTvCount = (TextView) findViewById(R.id.tv_count);
        this.mTvStart = (TextView) findViewById(R.id.tv_star_name);
        this.scaleAnim = AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_gift_item_selected_anim);
        StarCountComputeHelper starCountComputeHelper = new StarCountComputeHelper((Activity) getContext());
        this.mStarCountComputeHelper = starCountComputeHelper;
        starCountComputeHelper.setEventCallback(this.mCounterEventCallback);
    }

    public boolean isRealView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-189011206") ? ((Boolean) ipChange.ipc$dispatch("-189011206", new Object[]{this})).booleanValue() : this.mStarCountComputeHelper != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418620917")) {
            ipChange.ipc$dispatch("418620917", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        httpLoadStar(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953190872")) {
            ipChange.ipc$dispatch("1953190872", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        StarCountComputeHelper starCountComputeHelper = this.mStarCountComputeHelper;
        if (starCountComputeHelper != null) {
            starCountComputeHelper.destroy();
            this.mStarCountComputeHelper = null;
        }
    }

    public void sendStar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064173971")) {
            ipChange.ipc$dispatch("2064173971", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "mStarCountComputeHelper. sendStar;");
        if (this.mStarCountComputeHelper != null) {
            ((ILog) Dsl.getService(ILog.class)).i("liulei-star", "mStarCountComputeHelper.sendStar(1, ParseUtils.parse2Long(roomId));");
            this.mStarCountComputeHelper.sendStar(1, ParseUtils.parse2Long(str));
        }
    }

    public void upDateState(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2108021846")) {
            ipChange.ipc$dispatch("-2108021846", new Object[]{this, giftInfoBean});
        } else if (giftInfoBean.isChecked) {
            setBackgroundResource(R.drawable.dago_pgc_ykl_gift_item_bg);
            this.mLoadingImageView.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1524841969")) {
                        ipChange2.ipc$dispatch("-1524841969", new Object[]{this});
                        return;
                    }
                    GiftStarItemView giftStarItemView = GiftStarItemView.this;
                    giftStarItemView.mLoadingImageView.startAnimation(giftStarItemView.scaleAnim);
                }
            }, 300L);
        } else {
            setBackground(null);
            this.scaleAnim.cancel();
        }
    }

    public void updateSelectState(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806966118")) {
            ipChange.ipc$dispatch("1806966118", new Object[]{this, giftInfoBean});
        } else if (giftInfoBean.isChecked) {
            setBackgroundResource(R.drawable.dago_pgc_ykl_gift_item_bg);
            this.mLoadingImageView.startAnimation(this.scaleAnim);
        } else {
            setBackground(null);
            this.scaleAnim.cancel();
        }
    }

    public GiftStarItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStarLoopGet = 0;
        this.mWeakHandler = new Handler(Looper.getMainLooper());
        this.mCounterEventCallback = new StarCountComputeHelper.IEventCallback() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.IEventCallback
            public void onActorStarCountAquiredEvent(final long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1947067877")) {
                    ipChange.ipc$dispatch("1947067877", new Object[]{this, Long.valueOf(j)});
                } else {
                    GiftStarItemView.this.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.4.3
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "846203965")) {
                                ipChange2.ipc$dispatch("846203965", new Object[]{this});
                                return;
                            }
                            TextView textView = GiftStarItemView.this.mTvCount;
                            textView.setText("" + j);
                        }
                    });
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.IEventCallback
            public void onFullStarEvent() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "912552093")) {
                    ipChange.ipc$dispatch("912552093", new Object[]{this});
                } else {
                    GiftStarItemView.this.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.4.2
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1042717470")) {
                                ipChange2.ipc$dispatch("1042717470", new Object[]{this});
                            } else {
                                GiftStarItemView.this.mTvSecond.setText("免费");
                            }
                        }
                    });
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.IEventCallback
            public void onPlayStarEffect(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "340967590")) {
                    ipChange.ipc$dispatch("340967590", new Object[]{this, Integer.valueOf(i2)});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.IEventCallback
            public void onTimerStepForStarEvent(final long j, final long j2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1588657690")) {
                    ipChange.ipc$dispatch("-1588657690", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
                } else {
                    GiftStarItemView.this.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView.4.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1239230975")) {
                                ipChange2.ipc$dispatch("1239230975", new Object[]{this});
                                return;
                            }
                            GiftStarItemView.this.mTvSecond.setText("免费(" + ((j - j2) / 1000) + "s)");
                        }
                    });
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_lf_star_view, (ViewGroup) this, true);
        initView();
    }
}
