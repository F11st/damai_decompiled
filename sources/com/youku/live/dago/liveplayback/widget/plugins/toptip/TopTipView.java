package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TopTipView extends LazyInflatedView implements TopTipContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TopTipView";
    private boolean mEnableTipBg;
    private int mOffset;
    TopTipContract.Presenter mPresenter;
    private ImageView mTopTipBgImg;
    private RelativeLayout mToptipContainer;
    public TextView mToptipContent;
    private FrameLayout mToptipLayout;
    private View.OnTouchListener onSpanTextViewTouchListener;

    public TopTipView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str, ViewPlaceholder viewPlaceholder) {
        super(alixPlayerContext, iLMLayerManager, str, R.C7935layout.dago_plugin_toptip_view, viewPlaceholder);
        this.mEnableTipBg = true;
        this.onSpanTextViewTouchListener = new View.OnTouchListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ClickableSpan[] clickableSpanArr;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-723516398")) {
                    return ((Boolean) ipChange.ipc$dispatch("-723516398", new Object[]{this, view, motionEvent})).booleanValue();
                }
                try {
                    int action = motionEvent.getAction();
                    TextView textView = (TextView) view;
                    CharSequence text = textView.getText();
                    if (((text instanceof SpannedString) || (text instanceof SpannableString)) && action == 1) {
                        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                        int scrollX = x + textView.getScrollX();
                        int scrollY = y + textView.getScrollY();
                        Layout layout = textView.getLayout();
                        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                        if (text instanceof SpannedString) {
                            clickableSpanArr = (ClickableSpan[]) ((SpannedString) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        } else {
                            clickableSpanArr = (ClickableSpan[]) ((SpannableString) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        }
                        if (clickableSpanArr.length != 0) {
                            clickableSpanArr[0].onClick(textView);
                        } else {
                            textView.performClick();
                        }
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract.View
    public void enableTipBg(boolean z) {
        RelativeLayout relativeLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1514862027")) {
            ipChange.ipc$dispatch("1514862027", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mEnableTipBg = z;
        if (z || (relativeLayout = this.mToptipContainer) == null) {
            return;
        }
        relativeLayout.setBackgroundResource(0);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract.View
    public void hideTopTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290479332")) {
            ipChange.ipc$dispatch("-290479332", new Object[]{this});
        } else if (isInflated()) {
            this.mInflatedView.clearAnimation();
            FrameLayout frameLayout = this.mToptipLayout;
            if (frameLayout != null) {
                this.mOffset = frameLayout.getHeight();
            }
            if (this.mOffset < 1) {
                this.mOffset = (int) Utils.dp2px(getContext(), 50.0f);
            }
            hide();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract.View
    public void hideTopTipQuickly() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969455724")) {
            ipChange.ipc$dispatch("-969455724", new Object[]{this});
        } else if (isInflated()) {
            this.mInflatedView.clearAnimation();
            hide();
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    protected void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227342388")) {
            ipChange.ipc$dispatch("1227342388", new Object[]{this, view});
            return;
        }
        this.mToptipContainer = (RelativeLayout) view.findViewById(R.id.rl_toptip_container);
        this.mToptipLayout = (FrameLayout) view.findViewById(R.id.ll_toptip_layout);
        this.mToptipContent = (TextView) view.findViewById(R.id.tv_toptip_content);
        this.mTopTipBgImg = (ImageView) view.findViewById(R.id.top_tip_bg_img);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract.View
    public void setLayout(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483626426")) {
            ipChange.ipc$dispatch("483626426", new Object[]{this, Boolean.valueOf(z)});
        } else if (isInflated()) {
            if (z) {
                ((ViewGroup.MarginLayoutParams) this.mToptipLayout.getLayoutParams()).topMargin = UIUtils.dp2px(5.0f);
                ((ViewGroup.MarginLayoutParams) this.mToptipLayout.getLayoutParams()).rightMargin = UIUtils.dp2px(20.0f);
                ((ViewGroup.MarginLayoutParams) this.mToptipLayout.getLayoutParams()).leftMargin = UIUtils.dp2px(20.0f);
                this.mToptipContent.setMaxEms(12);
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.mToptipLayout.getLayoutParams()).topMargin = UIUtils.dp2px(10.0f);
            this.mToptipContent.setMaxEms(33);
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1314077145")) {
            ipChange.ipc$dispatch("-1314077145", new Object[]{this});
            return;
        }
        if (isInflated()) {
            this.mInflatedView.clearAnimation();
            FrameLayout frameLayout = this.mToptipLayout;
            if (frameLayout != null) {
                this.mOffset = frameLayout.getHeight();
            }
            if (this.mOffset < 1) {
                this.mOffset = (int) Utils.dp2px(getContext(), 50.0f);
            }
            this.mInflatedView.getLocationOnScreen(new int[2]);
        }
        super.show();
    }

    public void showDirectly() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1714752239")) {
            ipChange.ipc$dispatch("-1714752239", new Object[]{this});
            return;
        }
        show();
        setLayout(this.mPresenter.isSmallScreen());
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipContract.View
    public void showTopTip(TopTipInfo topTipInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555587568")) {
            ipChange.ipc$dispatch("-1555587568", new Object[]{this, topTipInfo});
        } else if (topTipInfo == null || TextUtils.isEmpty(topTipInfo.text)) {
        } else {
            if (!this.isInflated) {
                inflate();
            }
            int i = topTipInfo.style;
            if (i == 4) {
                this.mTopTipBgImg.setImageResource(R.C7933drawable.dago_toptip_vip_backround);
                this.mTopTipBgImg.setVisibility(0);
                String charSequence = topTipInfo.text.toString();
                if (!TextUtils.isEmpty(charSequence) && !charSequence.contains("</font>")) {
                    topTipInfo.text = Html.fromHtml("<font color=#F7C3A7>" + charSequence + "</font>");
                }
            } else if (i == 5) {
                this.mTopTipBgImg.setImageResource(0);
                this.mTopTipBgImg.setVisibility(8);
                this.mToptipContent.setTextColor(getContext().getResources().getColor(R.C7932color.zpd_subscribe_tip_color));
                float px2sp = Utils.px2sp(getContext(), getContext().getResources().getDimension(R.dimen.dago_player_28px));
                if (topTipInfo.textSize > 0) {
                    px2sp = Utils.px2sp(getContext(), topTipInfo.textSize);
                }
                this.mToptipContent.setTextSize(px2sp);
            } else if (i == 6) {
                this.mTopTipBgImg.setImageResource(R.C7933drawable.dago_toptip_custom_backround);
                this.mTopTipBgImg.setVisibility(0);
            }
            this.mToptipContent.setText(topTipInfo.text);
            this.mToptipContent.setOnTouchListener(this.onSpanTextViewTouchListener);
            if (topTipInfo.needFullScreen) {
                ViewGroup.LayoutParams layoutParams = this.mToptipContainer.getLayoutParams();
                layoutParams.height = -1;
                this.mToptipContainer.setLayoutParams(layoutParams);
                this.mToptipContainer.setBackgroundResource(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.mToptipContainer.getLayoutParams();
                layoutParams2.height = UIUtils.dp2px(100.0f);
                this.mToptipContainer.setLayoutParams(layoutParams2);
                if (this.mEnableTipBg) {
                    this.mToptipContainer.setBackgroundResource(R.C7933drawable.fullscreen_topmask);
                } else {
                    this.mToptipContainer.setBackgroundResource(0);
                }
            }
            View.OnClickListener onClickListener = topTipInfo.onClickListener;
            if (onClickListener != null) {
                this.mToptipContainer.setOnClickListener(onClickListener);
                this.mToptipContent.setOnClickListener(topTipInfo.onClickListener);
            }
            showDirectly();
        }
    }

    @Override // com.youku.alixplugin.view.BaseView
    public void setPresenter(TopTipContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1090005493")) {
            ipChange.ipc$dispatch("-1090005493", new Object[]{this, presenter});
        } else {
            this.mPresenter = presenter;
        }
    }
}
