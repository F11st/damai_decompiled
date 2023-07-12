package com.youku.live.dago.widgetlib.interactive.gift.lottery.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.nav.Nav;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.MineLotteryData;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MineLotteryView extends RelativeLayout implements View.OnClickListener, Animation.AnimationListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int ANIM_OUT_TIME_OFFSET = 1500;
    private static int NUM_ANIM_OUT_TIME_OFFSET = 150;
    private Animation inAnim;
    private boolean isCancel;
    private boolean isStop;
    private boolean isThirdView;
    private Context mContext;
    private List<MineLotteryData> mData;
    private ImageView mIvBigShot;
    private ImageView mIvBigShotBg;
    private ImageView mLightImage;
    private OnAnimationStateListener mListener;
    private LinearLayout mLotteryContainer;
    private LotteryCountLargeView mLotteryCount;
    private ImageView mLotteryImage;
    private TextView mLotteryText;
    private ImageView mLotteryTitle;
    private ImageView mStartImage;
    private Animation numInAnim;
    private Animation numOutAnim;
    private Animation outAnim;
    private int step;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnAnimationStateListener {
        void onEnd();

        void onStart();
    }

    public MineLotteryView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909899128")) {
            ipChange.ipc$dispatch("-1909899128", new Object[]{this});
            return;
        }
        LayoutInflater.from(this.mContext).inflate(R.layout.dago_pgc_mine_lottery_view, this);
        this.mLightImage = (ImageView) findViewById(R.id.lottery_bg_light);
        this.mLotteryContainer = (LinearLayout) findViewById(R.id.lottery_num_container);
        this.mLotteryImage = (ImageView) findViewById(R.id.lottery_img);
        this.mStartImage = (ImageView) findViewById(R.id.lottery_bg_start);
        this.mLotteryTitle = (ImageView) findViewById(R.id.lottery_title);
        this.mLotteryCount = (LotteryCountLargeView) findViewById(R.id.mine_lottery_count);
        this.mLotteryText = (TextView) findViewById(R.id.lottery_info_text);
        this.mIvBigShot = (ImageView) findViewById(R.id.iv_big_shot);
        this.mIvBigShotBg = (ImageView) findViewById(R.id.iv_big_shot_bg);
        Context context = getContext();
        int i = R.anim.dago_laifeng_lottery_in;
        this.inAnim = AnimationUtils.loadAnimation(context, i);
        this.numInAnim = AnimationUtils.loadAnimation(getContext(), i);
        Context context2 = getContext();
        int i2 = R.anim.dago_laifeng_lottery_out;
        this.outAnim = AnimationUtils.loadAnimation(context2, i2);
        this.numOutAnim = AnimationUtils.loadAnimation(getContext(), i2);
        this.inAnim.setAnimationListener(this);
        this.numInAnim.setAnimationListener(this);
        this.outAnim.setAnimationListener(this);
        this.numOutAnim.setAnimationListener(this);
        this.outAnim.setStartOffset(ANIM_OUT_TIME_OFFSET);
        this.numOutAnim.setStartOffset(NUM_ANIM_OUT_TIME_OFFSET);
        this.mLotteryText.setOnClickListener(this);
    }

    private void setLotteryImage() {
        List<MineLotteryData> list;
        MineLotteryData mineLotteryData;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "41420761")) {
            ipChange.ipc$dispatch("41420761", new Object[]{this});
        } else if (this.step > this.mData.size()) {
        } else {
            MineLotteryData mineLotteryData2 = this.mData.get(this.step - 1);
            if (mineLotteryData2.isPushMsg()) {
                setThirdView();
                setLotteryText(Html.fromHtml(String.format(this.mContext.getString(R.string.dago_pgc__gift_lottery_other_person_info), mineLotteryData2.getViwerName(), mineLotteryData2.getActorName())));
            } else if (mineLotteryData2.isViewer()) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#ffb800"));
                SpannableString spannableString = new SpannableString(mineLotteryData2.getViwerName());
                spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                setLotteryText(spannableStringBuilder);
            }
            this.mIvBigShot.setVisibility(4);
            this.mIvBigShotBg.setVisibility(4);
            this.mLotteryTitle.setVisibility(0);
            this.mLotteryContainer.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLightImage.getLayoutParams();
            layoutParams.width = DensityUtil.dip2px(getContext(), 300.0f);
            layoutParams.height = DensityUtil.dip2px(getContext(), 300.0f);
            ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "data.getLotteryTimes() = " + mineLotteryData2.getLotteryTimes());
            int lotteryTimes = mineLotteryData2.getLotteryTimes();
            if (lotteryTimes == 10) {
                i = R.drawable.mine_lottery_ten;
            } else if (lotteryTimes == 100) {
                i = R.drawable.mine_lottery_one_hundred;
            } else if (lotteryTimes == 500) {
                i = R.drawable.mine_lottery_five_hundred;
            } else if (lotteryTimes == 5000) {
                i = R.drawable.mine_lottery_five_thousand;
            } else if (lotteryTimes == 10000) {
                this.mLotteryTitle.setVisibility(4);
                this.mLotteryContainer.setVisibility(4);
                this.mIvBigShot.setVisibility(0);
                this.mIvBigShotBg.setVisibility(0);
                this.mStartImage.setVisibility(0);
                layoutParams.width = DensityUtil.dip2px(getContext(), 318.0f);
                layoutParams.height = DensityUtil.dip2px(getContext(), 318.0f);
            }
            this.mLightImage.setLayoutParams(layoutParams);
            if (mineLotteryData2.getLotteryTimes() != 10000) {
                this.mLotteryImage.setImageResource(i);
                int i2 = this.step - 1;
                if (this.mLotteryCount == null || (list = this.mData) == null || list.size() <= 0 || i2 < 0 || (mineLotteryData = this.mData.get(i2)) == null) {
                    return;
                }
                this.mLotteryCount.displayCount(String.valueOf(mineLotteryData.lotteryCount));
            }
        }
    }

    private void startNextStepAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408121957")) {
            ipChange.ipc$dispatch("-408121957", new Object[]{this});
        } else if (this.mData.size() <= this.step) {
            startAnimation(this.outAnim);
        } else {
            this.mLotteryContainer.startAnimation(this.numOutAnim);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197469305")) {
            ipChange.ipc$dispatch("-1197469305", new Object[]{this, animation});
        } else if (this.inAnim == animation && !this.isCancel) {
            startNextStepAnim();
        } else if (this.outAnim == animation) {
            OnAnimationStateListener onAnimationStateListener = this.mListener;
            if (onAnimationStateListener != null) {
                onAnimationStateListener.onEnd();
            }
            this.mLightImage.setImageDrawable(null);
            this.mStartImage.setImageDrawable(null);
            this.isStop = true;
        } else if (this.numInAnim == animation && !this.isCancel) {
            startNextStepAnim();
        } else if (this.numOutAnim != animation || this.isCancel) {
        } else {
            this.step++;
            setLotteryImage();
            this.mLotteryContainer.startAnimation(this.numInAnim);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322311027")) {
            ipChange.ipc$dispatch("-322311027", new Object[]{this, animation});
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221566688")) {
            ipChange.ipc$dispatch("-1221566688", new Object[]{this, animation});
            return;
        }
        OnAnimationStateListener onAnimationStateListener = this.mListener;
        if (onAnimationStateListener == null || animation != this.inAnim) {
            return;
        }
        onAnimationStateListener.onStart();
        this.isStop = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MineLotteryData mineLotteryData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343727506")) {
            ipChange.ipc$dispatch("-1343727506", new Object[]{this, view});
            return;
        }
        List<MineLotteryData> list = this.mData;
        if (list == null || list.size() == 0 || (mineLotteryData = this.mData.get(0)) == null || !mineLotteryData.isPushMsg() || !mineLotteryData.isViewer()) {
            return;
        }
        Nav.from(getContext()).toUri(Uri.parse("laifeng://room/" + mineLotteryData.getRoomId()));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2118234898")) {
            ipChange.ipc$dispatch("2118234898", new Object[]{this});
            return;
        }
        if (!this.isStop) {
            this.mLightImage.setImageDrawable(null);
            this.mStartImage.setImageDrawable(null);
        }
        super.onDetachedFromWindow();
    }

    public void setData(List<MineLotteryData> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-238188110")) {
            ipChange.ipc$dispatch("-238188110", new Object[]{this, list});
            return;
        }
        this.mData = list;
        this.isCancel = false;
        if (list == null) {
            return;
        }
        this.mStartImage.setImageResource(R.drawable.dagp_pgc_lottery_star_bg);
        this.mLightImage.setImageResource(R.drawable.dago_pgc_lottery_light_bg);
        ((AnimationDrawable) this.mLightImage.getDrawable()).start();
        ((AnimationDrawable) this.mStartImage.getDrawable()).start();
        this.step = 1;
        setLotteryImage();
        startAnimation(this.inAnim);
    }

    public void setLotteryText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340779699")) {
            ipChange.ipc$dispatch("-340779699", new Object[]{this, charSequence});
        } else if (TextUtils.isEmpty(charSequence)) {
        } else {
            this.mLotteryText.setText(charSequence);
            this.mLotteryText.setVisibility(0);
        }
    }

    public void setOnAnimationStateListener(OnAnimationStateListener onAnimationStateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476201110")) {
            ipChange.ipc$dispatch("476201110", new Object[]{this, onAnimationStateListener});
        } else {
            this.mListener = onAnimationStateListener;
        }
    }

    public void setThirdView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206624301")) {
            ipChange.ipc$dispatch("-206624301", new Object[]{this});
            return;
        }
        ImageView imageView = this.mLotteryTitle;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.dago_third_view_lottery_title);
        }
    }

    public void stopAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530922390")) {
            ipChange.ipc$dispatch("-1530922390", new Object[]{this});
            return;
        }
        this.isCancel = true;
        clearAnimation();
        this.mLotteryContainer.clearAnimation();
    }

    public MineLotteryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MineLotteryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.step = 0;
        this.mContext = context;
        initView();
    }
}
