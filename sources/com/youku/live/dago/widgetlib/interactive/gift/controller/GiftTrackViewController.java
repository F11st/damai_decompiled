package com.youku.live.dago.widgetlib.interactive.gift.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftTrackCallback;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.LotteryGiftOtherPersonViewController;
import com.youku.live.dago.widgetlib.interactive.gift.view.GiftTrackBoxView;
import com.youku.live.dago.widgetlib.interactive.gift.view.NumberTypeEvaluator;
import com.youku.live.dago.widgetlib.interactive.gift.view.frameanimation.AnimationsContainer;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftTrackViewController {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long APPEAR_TIME = 500;
    private static final long DISAPPEAR_TIME = 300;
    private static final int INDEX_BOTTOM = 0;
    private static final int INDEX_TOP = 1;
    private static final int ITEM_MARGIN = 40;
    private static final int MESSAGE_FORCE_INSERT = 258;
    private static final int MESSAGE_NEW_DATA = 256;
    private static final int MESSAGE_NEW_OWN_DATA = 260;
    private static final int MESSAGE_PLAY_OVER = 257;
    private static final int MESSAGE_PLAY_OWN_OVER = 259;
    private static final int NO_PATH = -1;
    private static final String TAG = "GiftTrackViewController";
    private LinearLayout mBottomShowLayout;
    private String mComboBottomKey;
    private String mComboTopKey;
    private FrameLayout mContainerLayout;
    private Context mContext;
    private IGiftTrackCallback mGiftTackCallback;
    private int mRoomType;
    private LinearLayout mTopShowLayout;
    private long TRACK_LIMIT = 10000;
    private int TRACK_COUNT = 2;
    private long mCurrentTrackCount = 0;
    private long mBottomPathTime = 0;
    private long mTopPathTime = 0;
    private boolean mLockTop = false;
    private Queue<GiftTrackBean> mMessageDataLinkedList = new ConcurrentLinkedQueue();
    private Queue<GiftTrackBean> mOwnDataLinkedList = new ConcurrentLinkedQueue();
    private int mPlayingCount = 0;
    private boolean mIsLiveing = true;
    private LotteryGiftOtherPersonViewController mLotteryOtherPersonViewController = new LotteryGiftOtherPersonViewController();
    private boolean isPrepearEnd = false;
    private Runnable mTrackEndRunnable = new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-639308317")) {
                ipChange.ipc$dispatch("-639308317", new Object[]{this});
                return;
            }
            Log.d(GiftTrackViewController.TAG, "release  mTrackEndRunnable run ");
            if (GiftTrackViewController.this.mGiftTackCallback == null || !GiftTrackViewController.this.isPrepearEnd) {
                return;
            }
            Log.d(GiftTrackViewController.TAG, "do animation end ");
            GiftTrackViewController.this.mGiftTackCallback.onEnd();
        }
    };
    private Handler mWeakHandler = new Handler(new Handler.Callback() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1751939237")) {
                return ((Boolean) ipChange.ipc$dispatch("1751939237", new Object[]{this, message})).booleanValue();
            }
            switch (message.what) {
                case 256:
                    GiftTrackViewController.this.getDataAndshowGiftBoxView();
                    break;
                case 257:
                    if (GiftTrackViewController.this.mPlayingCount < GiftTrackViewController.this.TRACK_COUNT) {
                        GiftTrackViewController.this.getDataAndshowGiftBoxView();
                        break;
                    }
                    break;
                case 258:
                    if (GiftTrackViewController.this.hasGiftMessageData(true)) {
                        GiftTrackBean giftTrackBean = (GiftTrackBean) GiftTrackViewController.this.mOwnDataLinkedList.peek();
                        if (GiftTrackViewController.this.mComboTopKey != null && !GiftTrackViewController.this.mComboTopKey.contains(giftTrackBean.userId)) {
                            Log.d(GiftTrackViewController.TAG, "is me  force remove top");
                            if (GiftTrackViewController.this.mTopShowLayout.getChildCount() > 0) {
                                GiftTrackViewController.this.mTopShowLayout.removeAllViews();
                            }
                            GiftTrackViewController.access$610(GiftTrackViewController.this);
                            GiftTrackViewController.this.mComboTopKey = null;
                            Log.d(GiftTrackViewController.TAG, "FORCE ComboTopKey , and show anim");
                            GiftTrackViewController.this.getOwnDatashowGiftBoxView();
                            break;
                        }
                    }
                    break;
                case 259:
                    GiftTrackViewController.this.getOwnDatashowGiftBoxView();
                    break;
                case 260:
                    if (!GiftTrackViewController.this.mLockTop) {
                        GiftTrackViewController.this.mLockTop = true;
                        GiftTrackViewController.this.getOwnDatashowGiftBoxView();
                        break;
                    }
                    break;
            }
            return false;
        }
    });

    public GiftTrackViewController(Context context, FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, int i) {
        this.mContext = context;
        this.mContainerLayout = frameLayout;
        this.mTopShowLayout = linearLayout;
        this.mBottomShowLayout = linearLayout2;
        this.mRoomType = i;
        init();
    }

    static /* synthetic */ int access$610(GiftTrackViewController giftTrackViewController) {
        int i = giftTrackViewController.mPlayingCount;
        giftTrackViewController.mPlayingCount = i - 1;
        return i;
    }

    private void appearAnim(final GiftTrackBoxView giftTrackBoxView, final GiftTrackBean giftTrackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025776918")) {
            ipChange.ipc$dispatch("-1025776918", new Object[]{this, giftTrackBoxView, giftTrackBean});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "appearAnim ");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(giftTrackBoxView, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        giftTrackBoxView.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1541084872")) {
                    ipChange2.ipc$dispatch("1541084872", new Object[]{this, animation});
                    return;
                }
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(giftTrackBoxView.getImageViewGiftIcon(), "alpha", 0.0f, 1.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofFloat2);
                animatorSet.setDuration(200L);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.3.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1594886286")) {
                            ipChange3.ipc$dispatch("-1594886286", new Object[]{this, animator});
                            return;
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        GiftTrackViewController giftTrackViewController = GiftTrackViewController.this;
                        GiftTrackBoxView giftTrackBoxView2 = giftTrackBoxView;
                        GiftTrackBean giftTrackBean2 = giftTrackBean;
                        giftTrackViewController.showComboAnimation(giftTrackBoxView2, giftTrackBean2.key, giftTrackBean2.pathIndex, giftTrackBean2.comboCount, ParseUtils.parse2Int(giftTrackBean2.giftNum), giftTrackBean.isMe);
                    }
                });
                animatorSet.start();
                if (giftTrackBean.isLottery) {
                    LotteryGiftOtherPersonViewController lotteryGiftOtherPersonViewController = GiftTrackViewController.this.mLotteryOtherPersonViewController;
                    Context context = GiftTrackViewController.this.mContext;
                    GiftTrackBoxView giftTrackBoxView2 = giftTrackBoxView;
                    GiftTrackBean giftTrackBean2 = giftTrackBean;
                    lotteryGiftOtherPersonViewController.addSmallLotteryView(context, giftTrackBoxView2, giftTrackBean2.lotteryTimes, giftTrackBean2.lotteryCount);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1041388460")) {
                    ipChange2.ipc$dispatch("1041388460", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2009012257")) {
                    ipChange2.ipc$dispatch("2009012257", new Object[]{this, animation});
                } else {
                    giftTrackBoxView.getImageViewGiftIcon().setAlpha(0.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disappearAnim(final View view, final int i, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647066500")) {
            ipChange.ipc$dispatch("-1647066500", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f, -DensityUtil.dip2px(this.mContext, 40.0f)).setDuration(300L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f).setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1983633701")) {
                    ipChange2.ipc$dispatch("1983633701", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1619491882")) {
                    ipChange2.ipc$dispatch("1619491882", new Object[]{this, animator});
                    return;
                }
                int i2 = i;
                if (i2 == 0) {
                    GiftTrackViewController.this.mBottomShowLayout.removeView(view);
                    GiftTrackViewController.this.mComboBottomKey = null;
                    GiftTrackViewController.access$610(GiftTrackViewController.this);
                } else if (i2 == 1) {
                    GiftTrackViewController.this.mTopShowLayout.removeView(view);
                    GiftTrackViewController.this.mComboTopKey = null;
                    GiftTrackViewController.access$610(GiftTrackViewController.this);
                }
                if (z) {
                    GiftTrackViewController.this.mWeakHandler.sendEmptyMessageDelayed(259, 100L);
                } else {
                    GiftTrackViewController.this.mWeakHandler.sendEmptyMessageDelayed(257, 100L);
                }
                GiftTrackBoxView giftTrackBoxView = (GiftTrackBoxView) view;
                if (giftTrackBoxView == null || giftTrackBoxView.getImageViewGiftIcon() == null) {
                    return;
                }
                giftTrackBoxView.cancelScaleAnim();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2242020")) {
                    ipChange2.ipc$dispatch("2242020", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "109135619")) {
                    ipChange2.ipc$dispatch("109135619", new Object[]{this, animator});
                }
            }
        });
    }

    private void doBroadcastStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1315558179")) {
            ipChange.ipc$dispatch("1315558179", new Object[]{this});
            return;
        }
        Log.d(TAG, "release  remove all runnable");
        AnimationsContainer.getInstance(this.mContext).clear();
        this.mWeakHandler.removeCallbacks(this.mTrackEndRunnable);
        this.mWeakHandler.removeCallbacksAndMessages(null);
        removeAllGiftBoxViews();
        clearGiftMessage();
        this.mLockTop = false;
        this.mComboBottomKey = null;
        this.mCurrentTrackCount = 0L;
        this.mComboTopKey = null;
        this.mPlayingCount = 0;
        this.mTopPathTime = 0L;
        this.mBottomPathTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWhenAnimEnd(int i, GiftTrackBoxView giftTrackBoxView, int i2, String str, int i3, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411337608")) {
            ipChange.ipc$dispatch("-411337608", new Object[]{this, Integer.valueOf(i), giftTrackBoxView, Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)});
        } else if (i > 1) {
            showNumberAnim(giftTrackBoxView, i, getShowTime(i), i2, z);
        } else {
            GiftTrackBean stickComboMessageDataByKey = getStickComboMessageDataByKey(str, i3, z);
            if (stickComboMessageDataByKey == null) {
                disappearAnim(giftTrackBoxView, i2, z);
                return;
            }
            String str2 = TAG;
            Log.d(str2, "showStickComboAnim update key = " + str + ",pathIndex = " + i2);
            if (stickComboMessageDataByKey.isLottery) {
                this.mLotteryOtherPersonViewController.addSmallLotteryView(this.mContext, giftTrackBoxView, stickComboMessageDataByKey.lotteryTimes, stickComboMessageDataByKey.lotteryCount);
            }
            showComboAnimation(giftTrackBoxView, str, i2, stickComboMessageDataByKey.comboCount, i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getAppearTime(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124392684")) {
            return ((Long) ipChange.ipc$dispatch("-124392684", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        if (i < 10 || i >= 100) {
            return (i < 100 || i >= 1000) ? 800L : 600L;
        }
        return 550L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDataAndshowGiftBoxView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166714193")) {
            ipChange.ipc$dispatch("-1166714193", new Object[]{this});
        } else if (hasGiftMessageData(false)) {
            String lockKey = getLockKey(false);
            ((ILog) Dsl.getService(ILog.class)).d("liulie-track", "getDataAndshowGiftBoxView  =" + lockKey);
            GiftTrackBean firstGiftMessageData = getFirstGiftMessageData(false, lockKey);
            if (firstGiftMessageData != null) {
                ((ILog) Dsl.getService(ILog.class)).d("liulie-track", "getDataAndshowGiftBoxView");
                if ((!TextUtils.isEmpty(this.mComboBottomKey) && !TextUtils.isEmpty(this.mComboTopKey)) || firstGiftMessageData.key.equals(this.mComboBottomKey) || firstGiftMessageData.key.equals(this.mComboTopKey)) {
                    return;
                }
                remove(firstGiftMessageData);
                showGiftBoxView(firstGiftMessageData);
            }
        } else {
            this.mBottomPathTime = 0L;
            this.mTopPathTime = 0L;
            this.isPrepearEnd = true;
            this.mWeakHandler.postDelayed(this.mTrackEndRunnable, 10000L);
        }
    }

    private GiftTrackBean getFirstGiftMessageData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153719332")) {
            return (GiftTrackBean) ipChange.ipc$dispatch("-1153719332", new Object[]{this, Boolean.valueOf(z)});
        }
        if (z) {
            return this.mOwnDataLinkedList.peek();
        }
        return this.mMessageDataLinkedList.peek();
    }

    private int getIdlePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267104959")) {
            return ((Integer) ipChange.ipc$dispatch("1267104959", new Object[]{this})).intValue();
        }
        if (this.mPlayingCount > this.TRACK_COUNT) {
            return -1;
        }
        if (this.mComboBottomKey == null && this.mBottomShowLayout.getChildCount() == 0) {
            return 0;
        }
        return (this.mComboTopKey == null && this.mTopShowLayout.getChildCount() == 0) ? 1 : -1;
    }

    private String getLockKey(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1315018685")) {
            return (String) ipChange.ipc$dispatch("1315018685", new Object[]{this, Boolean.valueOf(z)});
        }
        String str = TAG;
        Log.d(str, "mComboTopKey = " + this.mComboTopKey + ",mComboBottomKey = " + this.mComboBottomKey);
        if (z) {
            return this.mComboTopKey;
        }
        if (this.mLockTop) {
            return this.mComboBottomKey;
        }
        String str2 = this.mComboTopKey;
        if (str2 == null && this.mComboBottomKey == null) {
            return null;
        }
        if (str2 == null || this.mComboBottomKey == null) {
            if (str2 == null) {
                return this.mComboBottomKey;
            }
            if (this.mComboBottomKey == null) {
                return str2;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOwnDatashowGiftBoxView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371158926")) {
            ipChange.ipc$dispatch("-1371158926", new Object[]{this});
        } else if (hasGiftMessageData(true)) {
            GiftTrackBean firstGiftMessageData = getFirstGiftMessageData(true, getLockKey(true));
            if (firstGiftMessageData != null) {
                String str = this.mComboTopKey;
                if (str == null || !str.contains(firstGiftMessageData.userId)) {
                    remove(firstGiftMessageData);
                    showGiftBoxView(firstGiftMessageData);
                }
            }
        } else {
            this.mLockTop = false;
            if (this.mPlayingCount < this.TRACK_COUNT) {
                getDataAndshowGiftBoxView();
            }
        }
    }

    private long getShowTime(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242778748")) {
            return ((Long) ipChange.ipc$dispatch("1242778748", new Object[]{this, Integer.valueOf(i)})).longValue();
        }
        if (i < 10 || i >= 100) {
            return (i < 100 || i >= 1000) ? 900L : 600L;
        }
        return 400L;
    }

    private GiftTrackBean getStickComboMessageDataByKey(String str, int i, boolean z) {
        Iterator<GiftTrackBean> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524388697")) {
            return (GiftTrackBean) ipChange.ipc$dispatch("-1524388697", new Object[]{this, str, Integer.valueOf(i), Boolean.valueOf(z)});
        }
        GiftTrackBean giftTrackBean = null;
        if (z) {
            it = this.mOwnDataLinkedList.iterator();
        } else {
            it = this.mMessageDataLinkedList.iterator();
        }
        while (true) {
            if (it == null || !it.hasNext()) {
                break;
            }
            GiftTrackBean next = it.next();
            next.isComboGift = isComboGift(0, ParseUtils.parse2Int(next.giftNum));
            if (str.equals(next.key) && next.isComboGift) {
                int i2 = next.comboCount - i;
                String str2 = TAG;
                Log.d(str2, "detal = " + i2);
                if (i2 <= 1) {
                    if (i2 < 1) {
                        it.remove();
                        this.mCurrentTrackCount--;
                    } else {
                        Log.d(str2, "next comboCount = " + next.comboCount);
                        giftTrackBean = next;
                        break;
                    }
                } else {
                    GiftTrackBean giftTrackBean2 = new GiftTrackBean();
                    giftTrackBean2.comboCount = i + 1;
                    giftTrackBean2.userName = next.userName;
                    giftTrackBean2.giftName = next.giftName;
                    giftTrackBean2.key = next.key;
                    giftTrackBean2.userIcon = next.userIcon;
                    giftTrackBean2.userId = next.userId;
                    giftTrackBean2.comboLevel = next.comboLevel;
                    giftTrackBean2.pathIndex = next.pathIndex;
                    giftTrackBean2.giftNum = next.giftNum;
                    giftTrackBean2.giftIcon = next.giftIcon;
                    giftTrackBean2.isComboGift = next.isComboGift;
                    giftTrackBean2.isMe = next.isMe;
                    return giftTrackBean2;
                }
            }
        }
        if (giftTrackBean != null) {
            remove(giftTrackBean);
        }
        return giftTrackBean;
    }

    private boolean isComboGift(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1799459061") ? ((Boolean) ipChange.ipc$dispatch("-1799459061", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue() : isShowComboAnimation(i2);
    }

    private boolean isShowComboAnimation(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-995528651") ? ((Boolean) ipChange.ipc$dispatch("-995528651", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i == 1;
    }

    private void remove(GiftTrackBean giftTrackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540816641")) {
            ipChange.ipc$dispatch("540816641", new Object[]{this, giftTrackBean});
        } else if (giftTrackBean.isMe) {
            this.mOwnDataLinkedList.remove(giftTrackBean);
        } else {
            this.mCurrentTrackCount--;
            this.mMessageDataLinkedList.remove(giftTrackBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showComboAnimation(final GiftTrackBoxView giftTrackBoxView, final String str, final int i, final int i2, final int i3, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316892592")) {
            ipChange.ipc$dispatch("1316892592", new Object[]{this, giftTrackBoxView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)});
            return;
        }
        final TextView giftNumberTextView = giftTrackBoxView.getGiftNumberTextView();
        if (i3 <= 1 && i2 != 0) {
            giftTrackBoxView.setGiftNumber(i2);
        } else {
            giftTrackBoxView.setGiftNumber(1);
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "  giftBoxView.setGiftNumber(comboCount);; ");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(giftNumberTextView, "scaleX", 2.0f, 0.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(giftNumberTextView, "scaleY", 2.0f, 0.5f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(120L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1635010600")) {
                    ipChange2.ipc$dispatch("1635010600", new Object[]{this, animator});
                    return;
                }
                GiftTrackViewController.this.showEffectImageViewAnim(giftTrackBoxView, str, i, i3, i2, z);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(giftNumberTextView, "scaleX", 0.5f, 1.2f);
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(giftNumberTextView, "scaleY", 0.5f, 1.2f);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ofFloat3, ofFloat4);
                animatorSet2.setDuration(120L);
                animatorSet2.start();
                animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.6.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "1804685493")) {
                            ipChange3.ipc$dispatch("1804685493", new Object[]{this, animator2});
                            return;
                        }
                        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(giftNumberTextView, "scaleX", 1.2f, 1.0f);
                        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(giftNumberTextView, "scaleY", 1.2f, 1.0f);
                        AnimatorSet animatorSet3 = new AnimatorSet();
                        animatorSet3.playTogether(ofFloat5, ofFloat6);
                        animatorSet3.setDuration(120L);
                        animatorSet3.start();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEffectImageViewAnim(final GiftTrackBoxView giftTrackBoxView, final String str, final int i, final int i2, final int i3, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213880468")) {
            ipChange.ipc$dispatch("-213880468", new Object[]{this, giftTrackBoxView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)});
            return;
        }
        ImageView giftEffectImageView = giftTrackBoxView.getGiftEffectImageView();
        final TextView giftNumberTextView = giftTrackBoxView.getGiftNumberTextView();
        giftEffectImageView.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(giftEffectImageView, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(giftEffectImageView, "scaleX", 1.0f, 5.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(giftEffectImageView, "scaleY", 1.0f, 5.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(300L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1627251241")) {
                    ipChange2.ipc$dispatch("1627251241", new Object[]{this, animator});
                    return;
                }
                ObjectAnimator duration = ObjectAnimator.ofFloat(giftNumberTextView, "alpha", 0.9f, 1.0f).setDuration(i2 > 1 ? 1L : 500L);
                duration.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.7.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1357091210")) {
                            ipChange3.ipc$dispatch("-1357091210", new Object[]{this, animator2});
                            return;
                        }
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        GiftTrackViewController.this.doWhenAnimEnd(i2, giftTrackBoxView, i, str, i3, z);
                    }
                });
                duration.start();
            }
        });
    }

    private void showGiftBoxView(GiftTrackBean giftTrackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693410036")) {
            ipChange.ipc$dispatch("1693410036", new Object[]{this, giftTrackBean});
        } else if (this.mContext == null || giftTrackBean == null) {
        } else {
            GiftTrackBoxView giftTrackBoxView = new GiftTrackBoxView(this.mContext, giftTrackBean);
            if (giftTrackBean.isMe) {
                giftTrackBean.pathIndex = 1;
                String str = this.mComboTopKey;
                if (str != null && str.contains(giftTrackBean.userId)) {
                    return;
                }
                this.mTopShowLayout.removeAllViews();
                this.mComboTopKey = giftTrackBean.key;
                this.mPlayingCount++;
                this.mTopShowLayout.addView(giftTrackBoxView);
            } else {
                if (this.mLockTop) {
                    ((ILog) Dsl.getService(ILog.class)).d("liulie-track", "mLockTop");
                    giftTrackBean.pathIndex = 0;
                } else {
                    ((ILog) Dsl.getService(ILog.class)).d("liulie-track", "else mLockTop");
                    if (giftTrackBean.pathIndex == 0) {
                        int childCount = this.mBottomShowLayout.getChildCount();
                        int childCount2 = this.mTopShowLayout.getChildCount();
                        if (childCount > 0 && childCount2 == 0) {
                            giftTrackBean.pathIndex = 1;
                        }
                    } else {
                        int childCount3 = this.mBottomShowLayout.getChildCount();
                        if (this.mTopShowLayout.getChildCount() > 0 && childCount3 == 0) {
                            giftTrackBean.pathIndex = 0;
                        }
                    }
                }
                if (this.TRACK_COUNT == 1) {
                    giftTrackBean.pathIndex = 1;
                }
                if (giftTrackBean.key.equals(this.mComboBottomKey) || giftTrackBean.key.equals(this.mComboTopKey)) {
                    return;
                }
                int i = giftTrackBean.pathIndex;
                if (i == 0) {
                    if (this.mBottomShowLayout.getChildCount() > 0) {
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "TRACK INDEX =  bottom ");
                    this.mBottomShowLayout.addView(giftTrackBoxView);
                    this.mPlayingCount++;
                    this.mComboBottomKey = giftTrackBean.key;
                } else if (i == 1) {
                    if (this.mTopShowLayout.getChildCount() > 0) {
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "TRACK INDEX =  top ");
                    this.mPlayingCount++;
                    this.mComboTopKey = giftTrackBean.key;
                    this.mTopShowLayout.addView(giftTrackBoxView);
                }
            }
            appearAnim(giftTrackBoxView, giftTrackBean);
        }
    }

    private void showNumberAnim(final GiftTrackBoxView giftTrackBoxView, final int i, long j, final int i2, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359838019")) {
            ipChange.ipc$dispatch("1359838019", new Object[]{this, giftTrackBoxView, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(1, i).setDuration(j);
        duration.setInterpolator(new AccelerateInterpolator());
        duration.setEvaluator(new NumberTypeEvaluator());
        duration.setTarget(giftTrackBoxView);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1650529318")) {
                    ipChange2.ipc$dispatch("1650529318", new Object[]{this, animator});
                    return;
                }
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(giftTrackBoxView.getGiftNumberTextView(), "alpha", 0.9f, 1.0f).setDuration(GiftTrackViewController.this.getAppearTime(i));
                duration2.start();
                duration2.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.4.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-461695693")) {
                            ipChange3.ipc$dispatch("-461695693", new Object[]{this, animator2});
                            return;
                        }
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        GiftTrackViewController.this.disappearAnim(giftTrackBoxView, i2, z);
                    }
                });
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.controller.GiftTrackViewController.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1356706824")) {
                    ipChange2.ipc$dispatch("-1356706824", new Object[]{this, valueAnimator});
                } else {
                    giftTrackBoxView.setGiftNumber(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        duration.start();
    }

    public void addNewGiftMessage(GiftTrackBean giftTrackBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1054899753")) {
            ipChange.ipc$dispatch("1054899753", new Object[]{this, giftTrackBean});
        } else if (giftTrackBean == null) {
        } else {
            if (this.isPrepearEnd) {
                this.isPrepearEnd = false;
                this.mWeakHandler.removeCallbacks(this.mTrackEndRunnable);
            }
            long showTime = getShowTime(ParseUtils.parse2Int(giftTrackBean.giftNum));
            long j = this.mTopPathTime;
            long j2 = this.mBottomPathTime;
            if (j <= j2) {
                this.mTopPathTime = j + showTime;
                i = 1;
            } else {
                this.mBottomPathTime = j2 + showTime;
            }
            if (this.TRACK_COUNT == 1) {
                i = 1;
            }
            giftTrackBean.pathIndex = i;
            giftTrackBean.comboLevel = 1;
            giftTrackBean.key = giftTrackBean.anchorId + "-" + giftTrackBean.giftName + "-" + giftTrackBean.userId;
            StringBuilder sb = new StringBuilder();
            sb.append("TRACK KEY = ");
            sb.append(giftTrackBean.key);
            ((ILog) Dsl.getService(ILog.class)).i("liulei-track", sb.toString());
            if (giftTrackBean.isMe) {
                this.mOwnDataLinkedList.add(giftTrackBean);
                if (this.mLockTop) {
                    return;
                }
                String str = this.mComboTopKey;
                if (str == null || !str.contains(giftTrackBean.userId)) {
                    this.mTopShowLayout.removeAllViews();
                    this.mPlayingCount--;
                    this.mComboTopKey = null;
                    Log.d(TAG, "FORCE ComboTopKey , and show anim");
                    this.mWeakHandler.sendEmptyMessage(260);
                    return;
                }
                return;
            }
            long j3 = this.mCurrentTrackCount;
            if (j3 >= this.TRACK_LIMIT) {
                return;
            }
            this.mCurrentTrackCount = j3 + 1;
            this.mMessageDataLinkedList.add(giftTrackBean);
            if (this.mPlayingCount < this.TRACK_COUNT) {
                Log.d(TAG, "add playing task");
                this.mWeakHandler.sendEmptyMessage(256);
            }
        }
    }

    public void clearGiftMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "364010373")) {
            ipChange.ipc$dispatch("364010373", new Object[]{this});
            return;
        }
        this.mMessageDataLinkedList.clear();
        this.mOwnDataLinkedList.clear();
    }

    public boolean hasGiftMessageData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57862448")) {
            return ((Boolean) ipChange.ipc$dispatch("-57862448", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        if (z) {
            Queue<GiftTrackBean> queue = this.mOwnDataLinkedList;
            return (queue == null || queue.isEmpty()) ? false : true;
        }
        Queue<GiftTrackBean> queue2 = this.mMessageDataLinkedList;
        return (queue2 == null || queue2.isEmpty()) ? false : true;
    }

    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018811359")) {
            ipChange.ipc$dispatch("1018811359", new Object[]{this});
        }
    }

    public void onClearScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145969985")) {
            ipChange.ipc$dispatch("1145969985", new Object[]{this});
        } else {
            this.mContainerLayout.setVisibility(8);
        }
    }

    public void onResumeScreen() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697159945")) {
            ipChange.ipc$dispatch("-1697159945", new Object[]{this});
        } else {
            this.mContainerLayout.setVisibility(0);
        }
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599586220")) {
            ipChange.ipc$dispatch("-1599586220", new Object[]{this});
        } else {
            doBroadcastStop();
        }
    }

    public void removeAllGiftBoxViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196734827")) {
            ipChange.ipc$dispatch("1196734827", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = this.mTopShowLayout;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            this.mTopShowLayout.removeAllViews();
        }
        LinearLayout linearLayout2 = this.mBottomShowLayout;
        if (linearLayout2 == null || linearLayout2.getChildCount() <= 0) {
            return;
        }
        this.mBottomShowLayout.removeAllViews();
    }

    public void setGiftTackCallback(IGiftTrackCallback iGiftTrackCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195737062")) {
            ipChange.ipc$dispatch("1195737062", new Object[]{this, iGiftTrackCallback});
        } else {
            this.mGiftTackCallback = iGiftTrackCallback;
        }
    }

    public void setTrackCount(GiftTrackCount giftTrackCount) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76761670")) {
            ipChange.ipc$dispatch("76761670", new Object[]{this, giftTrackCount});
        } else if (giftTrackCount == GiftTrackCount.SINGLE) {
            this.TRACK_COUNT = 1;
            this.mComboBottomKey = "useless";
        } else {
            this.TRACK_COUNT = 2;
            this.mComboBottomKey = null;
        }
    }

    public void setVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260786628")) {
            ipChange.ipc$dispatch("-1260786628", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        FrameLayout frameLayout = this.mContainerLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    private GiftTrackBean getFirstGiftMessageData(boolean z, String str) {
        Iterator<GiftTrackBean> it;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915010778")) {
            return (GiftTrackBean) ipChange.ipc$dispatch("-915010778", new Object[]{this, Boolean.valueOf(z), str});
        }
        if (str == null) {
            ((ILog) Dsl.getService(ILog.class)).d("liulie-track", "key == null  =");
            return getFirstGiftMessageData(z);
        }
        if (z) {
            it = this.mOwnDataLinkedList.iterator();
        } else {
            it = this.mMessageDataLinkedList.iterator();
        }
        while (it != null && it.hasNext()) {
            GiftTrackBean next = it.next();
            if (!z) {
                ((ILog) Dsl.getService(ILog.class)).d("liulie-track", " if (!isMe)");
                if (ParseUtils.parse2Int(next.giftNum) > 1 || !str.equals(next.key)) {
                    ((ILog) Dsl.getService(ILog.class)).d("liulie-track", "giftMessageData = data;");
                    return next;
                }
            } else if (!str.contains(next.userId)) {
                return next;
            }
        }
        return null;
    }
}
