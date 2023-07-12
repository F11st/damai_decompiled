package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.doodle.SplashItemParser;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import com.youku.live.dago.widgetlib.doodle.drawable.TUrlDrawable;
import com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashItemParser;
import com.youku.live.dago.widgetlib.doodle.impl.LaifengSplashScheduler;
import com.youku.live.dago.widgetlib.interactive.gift.adapter.GestureGiftItemPagerAdapter;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.NumUtils;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import java.util.ArrayList;
import java.util.List;
import tb.h62;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GestureGiftWindow extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private GestureGiftItemPagerAdapter mAdapter;
    private ImageView mClearButton;
    private ImageView mCloseButton;
    private long mCoins;
    private GiftInfoBean mCurrentGiftInfoBean;
    private List<Coord> mDrewGifts;
    private FrameLayout mGestureContainer;
    private TUrlImageView mGestureIndicator;
    private LinearLayout mGestureIndicatorContainer;
    private List<GiftInfoBean> mGiftItems;
    private RecyclerView mGiftList;
    private TextView mGiftPriceLabel;
    private SplashItemParser<String, String> mItemParser;
    private OnLifecycleListener mOnLifecycleListener;
    private LinearPagerIndicator mPagerIndicator;
    private TextView mRechargeAmountLabel;
    private TextView mRechargeButton;
    private View mRootView;
    private TextView mSendGiftButton;
    private SplashScheduler<String, String> mSplashScheduler;
    private List<GiftTargetInfoBean> mTargetInfoBeans;
    private long mTotalCost;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class Coord {
        public GiftInfoBean giftInfoBean;
        public int iconIdentity;
        public float x;
        public float y;

        Coord(GiftInfoBean giftInfoBean, int i, float f, float f2) {
            this.giftInfoBean = giftInfoBean;
            this.iconIdentity = i;
            this.x = f;
            this.y = f2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnLifecycleListener {
        void onDismiss();

        void onGiftSent(int i, int i2, List<Coord> list, long j, List<GiftTargetInfoBean> list2);

        void onRechargeTriggered();
    }

    public GestureGiftWindow(@NonNull Context context) {
        this(context, null);
    }

    private boolean checkCost() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "549294068") ? ((Boolean) ipChange.ipc$dispatch("549294068", new Object[]{this})).booleanValue() : this.mTotalCost < this.mCoins;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686877995")) {
            ipChange.ipc$dispatch("-1686877995", new Object[]{this});
            return;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.dago_pgc_ykl_gesture_gift_board, this);
        this.mRootView = findViewById(R.id.root_view);
        this.mGestureContainer = (FrameLayout) findViewById(R.id.gesture_container);
        this.mGestureIndicatorContainer = (LinearLayout) findViewById(R.id.gesture_indicator_container);
        this.mGestureIndicator = (TUrlImageView) findViewById(R.id.gesture_gift_indicator);
        this.mGiftPriceLabel = (TextView) findViewById(R.id.gift_price);
        this.mClearButton = (ImageView) findViewById(R.id.clear_button);
        this.mCloseButton = (ImageView) findViewById(R.id.close_button);
        this.mRechargeAmountLabel = (TextView) findViewById(R.id.recharge_coin);
        this.mRechargeButton = (TextView) findViewById(R.id.recharge_button);
        this.mPagerIndicator = (LinearPagerIndicator) findViewById(R.id.indicator);
        TextView textView = (TextView) findViewById(R.id.gift_send_button);
        this.mSendGiftButton = textView;
        textView.setEnabled(false);
        ur1.o().s(h62.p("dago_pgc_ykl_gesture_movement_indicator")).y(this.mGestureIndicator);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.gift_list);
        this.mGiftList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        new PagerSnapHelper().attachToRecyclerView(this.mGiftList);
        this.mGiftList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1494021423")) {
                    ipChange2.ipc$dispatch("1494021423", new Object[]{this, recyclerView2, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView2, i);
                if (i == 0) {
                    GestureGiftWindow.this.mPagerIndicator.select(recyclerView2.getChildAdapterPosition(recyclerView2.findChildViewUnder(recyclerView2.getWidth() / 2, recyclerView2.getHeight() / 2)));
                }
            }
        });
        LaifengSplashScheduler laifengSplashScheduler = new LaifengSplashScheduler(getContext());
        this.mSplashScheduler = laifengSplashScheduler;
        laifengSplashScheduler.enableTouch(true);
        this.mSplashScheduler.setDrawLimit(100);
        this.mSplashScheduler.addOnSplashUpdateListener(new SplashScheduler.OnSplashUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
            public void onPaintingEnd() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1249846881")) {
                    ipChange2.ipc$dispatch("-1249846881", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
            public void onPaintingStart() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1132230520")) {
                    ipChange2.ipc$dispatch("1132230520", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.doodle.SplashScheduler.OnSplashUpdateListener
            public void onSplashUpdate(float f, float f2, int i, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1745191708")) {
                    ipChange2.ipc$dispatch("-1745191708", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                List list = GestureGiftWindow.this.mDrewGifts;
                GestureGiftWindow gestureGiftWindow = GestureGiftWindow.this;
                list.add(new Coord(gestureGiftWindow.mCurrentGiftInfoBean, i, f, f2));
                GestureGiftWindow.this.mTotalCost += Long.parseLong(GestureGiftWindow.this.mCurrentGiftInfoBean.coins);
                GestureGiftWindow.this.updateAppearance();
                if (i2 == 0) {
                    GestureGiftWindow.this.mGestureIndicatorContainer.setVisibility(0);
                } else {
                    GestureGiftWindow.this.mGestureIndicatorContainer.setVisibility(4);
                }
            }
        });
        SplashItemParser<String, String> laifengSplashItemParser = LaifengSplashItemParser.getInstance();
        this.mItemParser = laifengSplashItemParser;
        this.mSplashScheduler.setParser(laifengSplashItemParser);
        this.mGestureContainer.addView(this.mSplashScheduler.getContentView(), new ViewGroup.LayoutParams(-1, -1));
        this.mClearButton.setEnabled(false);
        this.mClearButton.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-875350171")) {
                    ipChange2.ipc$dispatch("-875350171", new Object[]{this, view});
                    return;
                }
                GestureGiftWindow.this.clear();
                GestureGiftWindow.this.updateAppearance();
            }
        });
        this.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1235940198")) {
                    ipChange2.ipc$dispatch("1235940198", new Object[]{this, view});
                } else if (GestureGiftWindow.this.mOnLifecycleListener != null) {
                    GestureGiftWindow.this.clear();
                    GestureGiftWindow.this.updateAppearance();
                    GestureGiftWindow.this.mOnLifecycleListener.onDismiss();
                }
            }
        });
        this.mRechargeButton.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-947736729")) {
                    ipChange2.ipc$dispatch("-947736729", new Object[]{this, view});
                } else if (GestureGiftWindow.this.mOnLifecycleListener != null) {
                    GestureGiftWindow.this.mOnLifecycleListener.onRechargeTriggered();
                }
            }
        });
        this.mSendGiftButton.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1163553640")) {
                    ipChange2.ipc$dispatch("1163553640", new Object[]{this, view});
                } else if (!GestureGiftWindow.this.mSendGiftButton.isEnabled() || GestureGiftWindow.this.mOnLifecycleListener == null) {
                } else {
                    GestureGiftWindow.this.mOnLifecycleListener.onGiftSent(GestureGiftWindow.this.mSplashScheduler.getSketchBoard().getBoardWidth(), GestureGiftWindow.this.mSplashScheduler.getSketchBoard().getBoardHeight(), GestureGiftWindow.this.mDrewGifts, 100L, GestureGiftWindow.this.mTargetInfoBeans);
                }
            }
        });
        updateAppearance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppearance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647238840")) {
            ipChange.ipc$dispatch("1647238840", new Object[]{this});
            return;
        }
        updateTotalCost();
        updateSendButton();
        updateClearButton();
    }

    private void updateClearButton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702495215")) {
            ipChange.ipc$dispatch("702495215", new Object[]{this});
        } else if (this.mTotalCost == 0) {
            this.mClearButton.setEnabled(false);
        } else {
            this.mClearButton.setEnabled(true);
        }
    }

    private void updateSendButton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-267705726")) {
            ipChange.ipc$dispatch("-267705726", new Object[]{this});
        } else if (this.mTotalCost == 0) {
            this.mSendGiftButton.setEnabled(false);
        } else {
            this.mSendGiftButton.setEnabled(true);
        }
    }

    private void updateTotalCost() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495439773")) {
            ipChange.ipc$dispatch("1495439773", new Object[]{this});
        } else if (GiftDataManager.getInstance().getUsingLaifengCoin()) {
            this.mGiftPriceLabel.setText(Html.fromHtml(getResources().getString(R.string.dago_pgc_laifeng_gift_cost, NumUtils.fixCoinsShow(this.mTotalCost))));
        } else {
            this.mGiftPriceLabel.setText(Html.fromHtml(getResources().getString(R.string.dago_pgc_other_gift_cost, NumUtils.fixCoinsShow(this.mTotalCost))));
        }
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230439016")) {
            ipChange.ipc$dispatch("-230439016", new Object[]{this});
            return;
        }
        this.mTotalCost = 0L;
        this.mDrewGifts.clear();
        this.mSplashScheduler.getSketchBoard().clear();
        this.mGestureIndicatorContainer.setVisibility(0);
    }

    public void selectGift(@NonNull GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-314799740")) {
            ipChange.ipc$dispatch("-314799740", new Object[]{this, giftInfoBean});
            return;
        }
        this.mCurrentGiftInfoBean = giftInfoBean;
        this.mSplashScheduler.selectIcon(giftInfoBean.id.hashCode());
    }

    public void setGiftItems(@NonNull List<GiftInfoBean> list, GiftInfoBean giftInfoBean, List<GiftTargetInfoBean> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000480636")) {
            ipChange.ipc$dispatch("-2000480636", new Object[]{this, list, giftInfoBean, list2});
            return;
        }
        this.mTargetInfoBeans = list2;
        this.mGiftItems = list;
        GestureGiftItemPagerAdapter gestureGiftItemPagerAdapter = this.mAdapter;
        if (gestureGiftItemPagerAdapter == null) {
            GestureGiftItemPagerAdapter gestureGiftItemPagerAdapter2 = new GestureGiftItemPagerAdapter(this, list, giftInfoBean);
            this.mAdapter = gestureGiftItemPagerAdapter2;
            this.mGiftList.setAdapter(gestureGiftItemPagerAdapter2);
        } else {
            gestureGiftItemPagerAdapter.updateGiftInfos(list, giftInfoBean);
        }
        this.mPagerIndicator.setIndicatorCount(this.mAdapter.getItemCount());
        ArrayList arrayList = new ArrayList();
        int dip2px = DensityUtil.dip2px(AppContextUtils.getApp(), 34.0f);
        for (GiftInfoBean giftInfoBean2 : list) {
            TUrlDrawable tUrlDrawable = new TUrlDrawable(giftInfoBean2.icon, getResources().getDrawable(R.drawable.dago_pgc_default_gift));
            SplashScheduler.IconItem iconItem = new SplashScheduler.IconItem();
            iconItem.icon = tUrlDrawable;
            tUrlDrawable.setBounds(0, 0, dip2px, dip2px);
            iconItem.iconIdentity = giftInfoBean2.id.hashCode();
            iconItem.stringId = giftInfoBean2.id;
            arrayList.add(iconItem);
        }
        this.mSplashScheduler.setIcons((SplashScheduler.IconItem[]) arrayList.toArray(new SplashScheduler.IconItem[arrayList.size()]));
        if (giftInfoBean != null) {
            selectGift(giftInfoBean);
            int indexOf = list.indexOf(giftInfoBean);
            if (indexOf == -1) {
                for (GiftInfoBean giftInfoBean3 : list) {
                    if (giftInfoBean3.id.equals(giftInfoBean.id)) {
                        indexOf = list.indexOf(giftInfoBean3);
                    }
                }
            }
            if (indexOf >= 0 && indexOf < list.size()) {
                int calculateRealPosition = this.mAdapter.calculateRealPosition(indexOf);
                this.mGiftList.getLayoutManager().scrollToPosition(calculateRealPosition);
                this.mPagerIndicator.select(calculateRealPosition);
            }
        }
        if (this.mAdapter.getItemCount() < 2) {
            this.mPagerIndicator.setVisibility(4);
        } else {
            this.mPagerIndicator.setVisibility(0);
        }
    }

    public void setIndicatorVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711606531")) {
            ipChange.ipc$dispatch("-711606531", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i == 0) {
            this.mRootView.setBackground(new ColorDrawable(1711276032));
        } else {
            this.mRootView.setBackground(null);
        }
        this.mGestureContainer.setVisibility(i);
    }

    public void setOnLifecycleListener(OnLifecycleListener onLifecycleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487410186")) {
            ipChange.ipc$dispatch("-487410186", new Object[]{this, onLifecycleListener});
        } else {
            this.mOnLifecycleListener = onLifecycleListener;
        }
    }

    public void updateCoins(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "29257846")) {
            ipChange.ipc$dispatch("29257846", new Object[]{this, str});
            return;
        }
        long parseLong = Long.parseLong(str);
        this.mCoins = parseLong;
        this.mRechargeAmountLabel.setText(NumUtils.fixCoinsShow(parseLong));
    }

    public void updateGiftTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1907865129")) {
            ipChange.ipc$dispatch("-1907865129", new Object[]{this, giftTheme});
            return;
        }
        TextView textView = this.mRechargeButton;
        if (textView != null) {
            textView.setTextColor(giftTheme.themeTextColor);
        }
        int dip2px = DensityUtil.dip2px(getContext(), 1.0f);
        int i = giftTheme.btnGiantStartColor;
        int i2 = giftTheme.btnGiantEndColor;
        int i3 = giftTheme.themeColor;
        StateListDrawable stateListDrawable = new StateListDrawable();
        float f = dip2px * 15;
        GradientDrawable drawable = ThemeUtils.getDrawable(i3, 0, 0, f);
        GradientDrawable gradientDrawable = ThemeUtils.getGradientDrawable(i, i2, GradientDrawable.Orientation.LEFT_RIGHT, i3, dip2px, f);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-10066330);
        gradientDrawable2.setCornerRadius(f);
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
        this.mSendGiftButton.setBackground(stateListDrawable);
    }

    public GestureGiftWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureGiftWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrewGifts = new ArrayList();
        this.mTotalCost = 0L;
        init();
    }
}
