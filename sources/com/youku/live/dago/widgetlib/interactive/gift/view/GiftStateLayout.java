package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.ThemeUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftStateLayout extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "GiftStateLayout";
    private OnGiftStateClickListener listener;
    private ImageView mArrow;
    private TextView mChargeBtn;
    private long mCoins;
    private LinearLayout mFirstChargeImage;
    private ImageView mIvCoin;
    private RelativeLayout mNumShowLayout;
    private RelativeLayout mPropNumShowLayout;
    private TextView mPropTips;
    private TextView mSendBtn;
    private LinearLayout mSendBtnLayout;
    private RelativeLayout mSendGiftLayout;
    private long mSendNum;
    private TextView mSendPropBtn;
    private RelativeLayout mSendPropLayout;
    private TextView mTvCoin;
    private TextView mTvNum;
    private TextView mTvPropNum;
    private OnPropClickListener propListener;
    private StateListDrawable sendPropBtnBg;
    private StateListDrawable sendPropHalfBtnBg;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnGiftStateClickListener {
        void onRechargeClick(boolean z);

        void onSendGiftClick(long j);

        void onShowGiftNumConfig();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnPropClickListener {
        void onPropMissionClick();

        void onSendPropClick(int i);

        void onShowNumKeyBoard();
    }

    public GiftStateLayout(Context context) {
        this(context, null);
    }

    private String formatNumber(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589734141")) {
            return (String) ipChange.ipc$dispatch("-1589734141", new Object[]{this, Long.valueOf(j)});
        }
        if (j <= 0) {
            return "0";
        }
        if (j < 100000) {
            return j + "";
        } else if (j < 100000000) {
            double doubleValue = new BigDecimal(j / 10000.0d).setScale(2, 1).doubleValue();
            return doubleValue + "万";
        } else {
            double doubleValue2 = new BigDecimal(j / 1.0E8d).setScale(2, 1).doubleValue();
            return doubleValue2 + "亿";
        }
    }

    private void initGiftLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118919709")) {
            ipChange.ipc$dispatch("118919709", new Object[]{this});
            return;
        }
        this.mSendGiftLayout = (RelativeLayout) findViewById(R.id.send_gift_layout);
        this.mTvCoin = (TextView) findViewById(R.id.id_coin);
        this.mIvCoin = (ImageView) findViewById(R.id.id_coin_icon);
        this.mTvNum = (TextView) findViewById(R.id.id_tv_selected_num);
        this.mNumShowLayout = (RelativeLayout) findViewById(R.id.id_sel_num_layout);
        this.mSendBtnLayout = (LinearLayout) findViewById(R.id.send_layout);
        this.mNumShowLayout.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1170318329")) {
                    ipChange2.ipc$dispatch("-1170318329", new Object[]{this, view});
                } else if (GiftStateLayout.this.listener != null) {
                    GiftStateLayout.this.listener.onShowGiftNumConfig();
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.id_charge);
        this.mChargeBtn = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "940972040")) {
                    ipChange2.ipc$dispatch("940972040", new Object[]{this, view});
                } else if (GiftStateLayout.this.listener != null) {
                    GiftStateLayout.this.listener.onRechargeClick(false);
                }
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.id_gift_send_btn);
        this.mSendBtn = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1242704887")) {
                    ipChange2.ipc$dispatch("-1242704887", new Object[]{this, view});
                } else if (GiftStateLayout.this.listener != null) {
                    GiftStateLayout.this.listener.onSendGiftClick(GiftStateLayout.this.mSendNum);
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.id_first_charge);
        this.mFirstChargeImage = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "868585482")) {
                    ipChange2.ipc$dispatch("868585482", new Object[]{this, view});
                } else if (GiftStateLayout.this.listener != null) {
                    GiftStateLayout.this.listener.onRechargeClick(true);
                }
            }
        });
    }

    private void initPropLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "433398090")) {
            ipChange.ipc$dispatch("433398090", new Object[]{this});
            return;
        }
        this.mSendPropLayout = (RelativeLayout) findViewById(R.id.send_prop_layout);
        this.mPropTips = (TextView) findViewById(R.id.id_prop_tips);
        this.mSendPropBtn = (TextView) findViewById(R.id.send_prop_bt);
        this.mArrow = (ImageView) findViewById(R.id.id_iv_selected_arr);
        this.mSendPropBtn.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1097931771")) {
                    ipChange2.ipc$dispatch("-1097931771", new Object[]{this, view});
                } else if (GiftStateLayout.this.propListener != null) {
                    GiftStateLayout.this.propListener.onSendPropClick(ParseUtils.parse2Int(GiftStateLayout.this.mTvPropNum.getText().toString()));
                }
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.id_sel_prop_num_layout);
        this.mPropNumShowLayout = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.GiftStateLayout.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1013358598")) {
                    ipChange2.ipc$dispatch("1013358598", new Object[]{this, view});
                } else {
                    GiftStateLayout.this.propListener.onShowNumKeyBoard();
                }
            }
        });
        this.mTvPropNum = (TextView) findViewById(R.id.id_tv_prop_selected_num);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2046361198")) {
            ipChange.ipc$dispatch("-2046361198", new Object[]{this});
            return;
        }
        initGiftLayout();
        initPropLayout();
    }

    public long getCoins() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1836620719") ? ((Long) ipChange.ipc$dispatch("1836620719", new Object[]{this})).longValue() : this.mCoins;
    }

    public View getSendBtn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "582809291") ? (View) ipChange.ipc$dispatch("582809291", new Object[]{this}) : this.mSendBtn;
    }

    public long getTvNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744484659")) {
            return ((Long) ipChange.ipc$dispatch("-1744484659", new Object[]{this})).longValue();
        }
        long j = this.mSendNum;
        if (j > 1) {
            return j;
        }
        return 1L;
    }

    public void hideAll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921612228")) {
            ipChange.ipc$dispatch("1921612228", new Object[]{this});
            return;
        }
        this.mSendGiftLayout.setVisibility(8);
        this.mSendPropLayout.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1415301860")) {
            ipChange.ipc$dispatch("-1415301860", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    public void setArrOrientation(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "386373314")) {
            ipChange.ipc$dispatch("386373314", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mArrow.setRotation(90.0f);
        } else {
            this.mArrow.setRotation(-90.0f);
        }
    }

    public void setChargeBtnState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421352828")) {
            ipChange.ipc$dispatch("1421352828", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mChargeBtn.setVisibility(8);
            this.mFirstChargeImage.setVisibility(0);
        } else {
            this.mChargeBtn.setVisibility(0);
            this.mFirstChargeImage.setVisibility(8);
        }
    }

    public void setChildLayoutParams(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-294769545")) {
            ipChange.ipc$dispatch("-294769545", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mSendPropLayout.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mSendGiftLayout.getLayoutParams();
        if (z) {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams2.setMargins(0, 0, 0, 0);
        }
        this.mSendPropLayout.setLayoutParams(layoutParams);
        this.mSendGiftLayout.setLayoutParams(layoutParams2);
    }

    public void setCoinIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059784319")) {
            ipChange.ipc$dispatch("-1059784319", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-gift", "coin url = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DagoImageLoader.getInstance().showDefault(getContext(), str, this.mIvCoin);
    }

    public void setOnGiftStateClickListener(OnGiftStateClickListener onGiftStateClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833188002")) {
            ipChange.ipc$dispatch("833188002", new Object[]{this, onGiftStateClickListener});
        } else {
            this.listener = onGiftStateClickListener;
        }
    }

    public void setOnPropClickListener(OnPropClickListener onPropClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856674414")) {
            ipChange.ipc$dispatch("-856674414", new Object[]{this, onPropClickListener});
        } else {
            this.propListener = onPropClickListener;
        }
    }

    public void setSelNum(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004612687")) {
            ipChange.ipc$dispatch("1004612687", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mSendNum = j;
        this.mTvNum.setText(String.valueOf(j));
        this.mNumShowLayout.setEnabled(true);
        this.mNumShowLayout.setAlpha(1.0f);
        this.mTvNum.setTextColor(-1);
    }

    public void setSelPropNum(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684745108")) {
            ipChange.ipc$dispatch("-684745108", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.mTvPropNum.setText(String.valueOf(j));
        this.mPropNumShowLayout.setEnabled(true);
        this.mPropNumShowLayout.setAlpha(1.0f);
        this.mTvPropNum.setTextColor(-1);
    }

    public void setSendBtnVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565377359")) {
            ipChange.ipc$dispatch("-565377359", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mSendBtnLayout.setVisibility(z ? 0 : 8);
        }
    }

    public void setSendText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1656241206")) {
            ipChange.ipc$dispatch("1656241206", new Object[]{this, str});
            return;
        }
        TextView textView = this.mSendBtn;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void switchPropLayout(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124373614")) {
            ipChange.ipc$dispatch("124373614", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mSendPropLayout.setVisibility(0);
            this.mSendGiftLayout.setVisibility(8);
        } else {
            this.mSendGiftLayout.setVisibility(0);
            this.mSendPropLayout.setVisibility(8);
        }
    }

    public void switchPropSendButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350284190")) {
            ipChange.ipc$dispatch("350284190", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-prop", "Prop is Gift=  " + z);
        setSelPropNum(1L);
        if (z) {
            this.mPropNumShowLayout.setVisibility(0);
            this.mSendPropBtn.setBackground(this.sendPropHalfBtnBg);
            return;
        }
        this.mPropNumShowLayout.setVisibility(8);
        this.mSendPropBtn.setBackground(this.sendPropBtnBg);
    }

    public void switchSendButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896631205")) {
            ipChange.ipc$dispatch("-1896631205", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mNumShowLayout.setVisibility(0);
        } else {
            this.mNumShowLayout.setVisibility(8);
        }
    }

    public void updateCoins(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524820460")) {
            ipChange.ipc$dispatch("-524820460", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "updateCoins = " + str);
        long parse2Long = ParseUtils.parse2Long(str);
        this.mCoins = parse2Long;
        this.mTvCoin.setText(formatNumber(parse2Long));
    }

    public void updatePropTip(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235009364")) {
            ipChange.ipc$dispatch("235009364", new Object[]{this, Boolean.valueOf(z), str, str2});
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mPropTips.setText(str);
            this.mPropTips.setVisibility(0);
        } else {
            this.mPropTips.setVisibility(8);
        }
        if (this.mSendPropBtn.getVisibility() == 8) {
            this.mSendPropBtn.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mSendPropBtn.setText(str2);
        }
        switchPropSendButton(z);
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1209303369")) {
            ipChange.ipc$dispatch("1209303369", new Object[]{this, giftTheme});
            return;
        }
        int dip2px = DensityUtil.dip2px(getContext(), 1.0f);
        this.mChargeBtn.setTextColor(giftTheme.themeTextColor);
        float f = dip2px * 15;
        GradientDrawable radiusDrawable = ThemeUtils.getRadiusDrawable(0, giftTheme.themeColor, dip2px, f, 0.0f, 0.0f, f);
        GradientDrawable radiusDrawable2 = ThemeUtils.getRadiusDrawable(0, giftTheme.themeColor, dip2px, f, 0.0f, 0.0f, f);
        int i = giftTheme.btnGiantStartColor;
        int i2 = giftTheme.btnGiantEndColor;
        int i3 = giftTheme.themeColor;
        this.sendPropBtnBg = new StateListDrawable();
        this.sendPropHalfBtnBg = new StateListDrawable();
        GradientDrawable drawable = ThemeUtils.getDrawable(i3, 0, 0, f);
        GradientDrawable gradientDrawable = ThemeUtils.getGradientDrawable(i, i2, GradientDrawable.Orientation.LEFT_RIGHT, i3, dip2px, f);
        this.sendPropBtnBg.addState(new int[]{16842919}, drawable);
        this.sendPropBtnBg.addState(new int[0], gradientDrawable);
        GradientDrawable gradientDrawable2 = ThemeUtils.getGradientDrawable(i, i2, GradientDrawable.Orientation.LEFT_RIGHT, i3, dip2px, 0.0f, f, f, 0.0f);
        this.sendPropHalfBtnBg.addState(new int[]{16842919}, gradientDrawable2);
        this.sendPropHalfBtnBg.addState(new int[0], gradientDrawable2);
        this.mNumShowLayout.setBackground(radiusDrawable);
        this.mPropNumShowLayout.setBackground(radiusDrawable2);
        this.mSendPropBtn.setBackground(this.sendPropBtnBg);
    }

    public GiftStateLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftStateLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSendNum = 1L;
        this.mCoins = 0L;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_coin_layout, (ViewGroup) this, true);
        initView();
        setSelNum(-1L);
    }
}
