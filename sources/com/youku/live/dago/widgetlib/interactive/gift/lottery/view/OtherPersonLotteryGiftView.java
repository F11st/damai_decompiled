package com.youku.live.dago.widgetlib.interactive.gift.lottery.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class OtherPersonLotteryGiftView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private AnimationDrawable mBgAnimDrawable;
    private Context mContext;
    private ImageView mLotteryBg;
    private LotteryCountSmallView mLotteryCountView;
    private ImageView mLotteryStar;
    private ImageView mLotteryTimesTitleView;
    private ImageView mLotteryTimesView;
    private AnimationDrawable mStarAnimDrawable;

    public OtherPersonLotteryGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894639404")) {
            ipChange.ipc$dispatch("-1894639404", new Object[]{this});
            return;
        }
        LayoutInflater.from(this.mContext).inflate(R.C7942layout.dago_pgc_gift_lottery_other_person_layout, this);
        this.mLotteryBg = (ImageView) findViewById(R.id.slash_background);
        this.mLotteryStar = (ImageView) findViewById(R.id.slash_star);
        this.mLotteryTimesTitleView = (ImageView) findViewById(R.id.lottery_title);
        this.mLotteryTimesView = (ImageView) findViewById(R.id.lottery_times);
        this.mLotteryCountView = (LotteryCountSmallView) findViewById(R.id.lottery_count);
    }

    public void displayEffect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "624816558")) {
            ipChange.ipc$dispatch("624816558", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mLotteryBg.setImageResource(R.C7941drawable.fivehundred_anim);
        this.mLotteryStar.setImageResource(R.C7941drawable.fivehundred_star_anim);
        this.mStarAnimDrawable = (AnimationDrawable) this.mLotteryStar.getDrawable();
        this.mBgAnimDrawable = (AnimationDrawable) this.mLotteryBg.getDrawable();
        this.mLotteryTimesTitleView.setImageResource(R.C7941drawable.five_hundred_title);
        this.mLotteryTimesView.setImageResource(R.C7941drawable.five_hundred_count);
        if (i2 != 0) {
            this.mLotteryCountView.setVisibility(0);
            LotteryCountSmallView lotteryCountSmallView = this.mLotteryCountView;
            lotteryCountSmallView.displayCount(i2 + "");
        } else {
            this.mLotteryCountView.setVisibility(8);
        }
        AnimationDrawable animationDrawable = this.mBgAnimDrawable;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        AnimationDrawable animationDrawable2 = this.mStarAnimDrawable;
        if (animationDrawable2 != null) {
            animationDrawable2.start();
        }
    }

    public OtherPersonLotteryGiftView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }
}
