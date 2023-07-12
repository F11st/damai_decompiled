package com.youku.live.dago.liveplayback.widget.plugins.horizontalfull;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.live.LiveInfo;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.view.LazyInflatedView;
import com.youku.android.liveservice.bean.BizSwitch;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.live.dago.liveplayback.R;
import com.youku.live.dago.liveplayback.UIUtils;
import com.youku.live.dago.liveplayback.widget.ClientType;
import com.youku.live.dago.liveplayback.widget.Constants;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils;
import com.youku.live.dago.liveplayback.widget.plugins.WeexWidget;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact;
import com.youku.live.dago.liveplayback.widget.view.CircleImageView;
import com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar;
import com.youku.vpm.constants.TableField;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HorizontalFullControlView extends LazyInflatedView implements View.OnClickListener, HorizontalFullControlContact.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout fullBottomContainer;
    private ViewGroup hlbContainer;
    private ViewGroup hltContainer;
    private ViewGroup hmbContainer;
    private ViewGroup hmtContainer;
    private ViewGroup hrbContainer;
    private ViewGroup hrtContainer;
    private ViewGroup hrtContainer2;
    private boolean isInTimeShift;
    private boolean isSeeking;
    private float mAnimationY;
    private boolean mCastMode;
    private ClientType mClientType;
    private CircleImageView mControlButton;
    private long mEndTime;
    private boolean mIsTimeShift;
    private TextView mLeftText;
    private long mLiveTime;
    private MultiDevTipsView mMultiDevTipsView;
    private long mNowTime;
    private HorizontalFullControlContact.Presenter mPresenter;
    private String mQualityText;
    private String mQualityTip;
    private TextView mRightText;
    private PlayerSeekBar mSeekBar;
    private boolean mShowQuality;
    private boolean mShowTip;
    private long mStartTime;
    private long mSumTime;
    private View playerDisplayBtn;
    private View playerMultiBtn;
    private TextView qualityTipView;
    private TextView qualityView;
    private ViewGroup topContainer;

    public HorizontalFullControlView(Context context, ILMLayerManager<ViewGroup> iLMLayerManager, String str, ViewPlaceholder viewPlaceholder) {
        super(context, iLMLayerManager, str, R.C7935layout.player_horizontal_fullscreen_plugin, viewPlaceholder);
        this.isInTimeShift = false;
        this.mAnimationY = 0.0f;
    }

    private void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-808292270")) {
            ipChange.ipc$dispatch("-808292270", new Object[]{this, view});
            return;
        }
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.play_control_btn);
        this.mControlButton = circleImageView;
        circleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1919383561")) {
                    ipChange2.ipc$dispatch("-1919383561", new Object[]{this, view2});
                } else {
                    HorizontalFullControlView.this.mPresenter.onControlBtnClicked();
                }
            }
        });
        this.mSeekBar = (PlayerSeekBar) view.findViewById(R.id.player_seekbar);
        int dimension = (int) view.getContext().getResources().getDimension(R.dimen.resource_size_16);
        this.mSeekBar.setThumbSizeOnDragging(((int) view.getContext().getResources().getDimension(R.dimen.resource_size_40)) / 2);
        this.mSeekBar.setTrackPadding(dimension);
        int i = dimension * 2;
        this.mSeekBar.setPadding(0, i, 0, i);
        this.mSeekBar.setOnSeekBarChangeListener(new PlayerSeekBar.OnSeekBarChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onBackClicked(long j, long j2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "264091170")) {
                    ipChange2.ipc$dispatch("264091170", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
                    return;
                }
                HorizontalFullControlView.this.isSeeking = false;
                HorizontalFullControlView horizontalFullControlView = HorizontalFullControlView.this;
                horizontalFullControlView.dragEndForTimeShift(j, horizontalFullControlView.mLiveTime, true);
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onProgressChanged(PlayerSeekBar playerSeekBar, long j, boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2086395668")) {
                    ipChange2.ipc$dispatch("-2086395668", new Object[]{this, playerSeekBar, Long.valueOf(j), Boolean.valueOf(z)});
                } else if (z) {
                    HorizontalFullControlView.this.mLeftText.setText(Utils.getFormathourTime(j));
                    HorizontalFullControlView.this.mSeekBar.setProgress((float) j);
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(PlayerSeekBar playerSeekBar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "453141187")) {
                    ipChange2.ipc$dispatch("453141187", new Object[]{this, playerSeekBar});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(PlayerSeekBar playerSeekBar, long j, boolean z, boolean z2, long j2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1745874275")) {
                    ipChange2.ipc$dispatch("-1745874275", new Object[]{this, playerSeekBar, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)});
                    return;
                }
                HorizontalFullControlView.this.isSeeking = false;
                if (z) {
                    String str = LazyInflatedView.TAG;
                    Logger.d(str, "onStopTrackingTouch seekBar = " + playerSeekBar + " progress = " + j + " fromUser = " + z);
                    if (!z2) {
                        HorizontalFullControlView.this.mPresenter.seekTo(playerSeekBar.getProgress());
                    } else if (j >= HorizontalFullControlView.this.mLiveTime) {
                        HorizontalFullControlView.this.isInTimeShift = false;
                        HorizontalFullControlView horizontalFullControlView = HorizontalFullControlView.this;
                        horizontalFullControlView.dragEndForTimeShift(j, horizontalFullControlView.mLiveTime, true);
                    } else {
                        HorizontalFullControlView.this.isInTimeShift = true;
                        HorizontalFullControlView horizontalFullControlView2 = HorizontalFullControlView.this;
                        horizontalFullControlView2.dragEndForTimeShift(j, horizontalFullControlView2.mLiveTime, false);
                    }
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onTrackingPressDown(PlayerSeekBar playerSeekBar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-54638475")) {
                    ipChange2.ipc$dispatch("-54638475", new Object[]{this, playerSeekBar});
                } else {
                    HorizontalFullControlView.this.isSeeking = true;
                }
            }
        });
        this.mLeftText = (TextView) view.findViewById(R.id.time_left);
        this.mRightText = (TextView) view.findViewById(R.id.time_right);
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.View
    public void addView(View view, LinearLayout.LayoutParams layoutParams, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558653346")) {
            ipChange.ipc$dispatch("1558653346", new Object[]{this, view, layoutParams, str});
        } else if (Constants.AREA_HRB.equals(str)) {
            this.hrbContainer.addView(view, layoutParams);
        } else if (Constants.AREA_HLT.equals(str)) {
            this.hltContainer.addView(view, layoutParams);
        } else if (Constants.AREA_HRT.equals(str)) {
            this.hrtContainer.addView(view, layoutParams);
        } else if (Constants.AREA_HRT2.equals(str)) {
            this.hrtContainer2.addView(view, layoutParams);
        } else if (Constants.AREA_HMT.equals(str)) {
            this.hmtContainer.addView(view, layoutParams);
        }
    }

    public void dragEndForTimeShift(long j, long j2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078591250")) {
            ipChange.ipc$dispatch("2078591250", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)});
            return;
        }
        Logger.d("timeshift", "dragEndForTimeShift progress = " + j);
        IPlayerContainer playerContainer = this.mPresenter.getPlayerContext().getPlayerContainer();
        String liveId = playerContainer.getPlayVideoInfo().getLiveId();
        LiveInfo liveInfo = playerContainer.getVideoStream().getYoukuVideoInfo().getLiveInfo();
        PlayVideoInfo playVideoInfo = new PlayVideoInfo(liveId);
        playVideoInfo.setPlayType(PlayType.LIVE);
        playVideoInfo.setTag("liveInfo", liveInfo);
        playVideoInfo.putString("timeShift", z ? "0" : "1");
        playVideoInfo.putString("timeShiftPoint", UIUtils.stampToDate(this.mStartTime + j));
        playVideoInfo.putString(TableField.PLAY_FROM, "timeShift");
        if (j >= j2) {
            liveInfo.timeshift = -1L;
            setNowTime(j2);
        } else {
            liveInfo.timeshift = j;
            setNowTime(j);
        }
        playerContainer.play(playVideoInfo);
    }

    public long getLiveTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "304459962") ? ((Long) ipChange.ipc$dispatch("304459962", new Object[]{this})).longValue() : this.mLiveTime;
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051337229")) {
            ipChange.ipc$dispatch("-2051337229", new Object[]{this});
        } else {
            hide(true);
        }
    }

    void hideControl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078864166")) {
            ipChange.ipc$dispatch("-1078864166", new Object[]{this});
        } else if (isShow()) {
            this.mControlButton.setVisibility(8);
            this.mLeftText.setVisibility(8);
            this.mSeekBar.setVisibility(8);
            this.mRightText.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740130202")) {
            ipChange.ipc$dispatch("-740130202", new Object[]{this, view});
        } else if (view == this.playerMultiBtn) {
            this.mMultiDevTipsView.close();
            this.mPresenter.showMultiList();
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    protected void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883838619")) {
            ipChange.ipc$dispatch("-883838619", new Object[]{this, view});
            return;
        }
        this.mClientType = Utils.getClientType(this.mContext);
        this.hlbContainer = (ViewGroup) view.findViewById(R.id.hlb_container);
        this.hmbContainer = (ViewGroup) view.findViewById(R.id.hmb_container);
        this.hrbContainer = (ViewGroup) view.findViewById(R.id.hrb_container);
        this.mPresenter.addViewGroup(this.hmbContainer);
        this.mPresenter.addViewGroup(this.hlbContainer);
        this.mPresenter.addViewGroup(this.hrbContainer);
        this.hltContainer = (ViewGroup) view.findViewById(R.id.hlt_container);
        this.hmtContainer = (ViewGroup) view.findViewById(R.id.hmt_container);
        this.hrtContainer = (ViewGroup) view.findViewById(R.id.hrt_container);
        this.hrtContainer2 = (ViewGroup) view.findViewById(R.id.hrt_container2);
        this.topContainer = (ViewGroup) view.findViewById(R.id.top_container);
        this.fullBottomContainer = (LinearLayout) view.findViewById(R.id.full_bottom_container);
        this.mPresenter.addViewGroup(this.hltContainer);
        this.mPresenter.addViewGroup(this.hmtContainer);
        this.mPresenter.addViewGroup(this.hrtContainer);
        this.mPresenter.addViewGroup(this.hrtContainer2);
        View findViewById = view.findViewById(R.id.player_display_btn);
        this.playerDisplayBtn = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1774610445")) {
                    ipChange2.ipc$dispatch("-1774610445", new Object[]{this, view2});
                } else {
                    HorizontalFullControlView.this.mPresenter.onDisplayBtnClicked();
                }
            }
        });
        if (!Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            this.playerDisplayBtn.setVisibility(8);
        }
        View findViewById2 = view.findViewById(R.id.btn_multi);
        this.playerMultiBtn = findViewById2;
        findViewById2.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.player_quality_btn);
        this.qualityView = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "336679924")) {
                    ipChange2.ipc$dispatch("336679924", new Object[]{this, view2});
                } else {
                    HorizontalFullControlView.this.mPresenter.showQuality(view2);
                }
            }
        });
        this.qualityView.setVisibility(8);
        TextView textView2 = (TextView) view.findViewById(R.id.definition_auto_real_btn);
        this.qualityTipView = textView2;
        textView2.setVisibility(4);
        initView(view);
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "590040711")) {
                    ipChange2.ipc$dispatch("590040711", new Object[]{this, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
                } else if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
                } else {
                    HorizontalFullControlView.this.show();
                }
            }
        });
        this.mMultiDevTipsView = new MultiDevTipsView(this.mPresenter.getPlayerContext().getActivity());
        this.fullBottomContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1559621734")) {
                    ipChange2.ipc$dispatch("1559621734", new Object[]{this, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
                } else if ((i == i5 && i2 == i6 && i3 == i7 && i4 == i8) || view2.getParent() == null || !HorizontalFullControlView.this.mPresenter.getPlayerContext().isLandScreen()) {
                } else {
                    HorizontalFullControlView.this.mAnimationY = ((View) view2.getParent()).getHeight() - view2.getHeight();
                }
            }
        });
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.View
    public void setCastMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501730557")) {
            ipChange.ipc$dispatch("-1501730557", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mCastMode = z;
        }
    }

    public void setLiveTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759107530")) {
            ipChange.ipc$dispatch("1759107530", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "HFull--setLiveTime liveTime = " + j);
        this.mLiveTime = j;
        PlayerSeekBar playerSeekBar = this.mSeekBar;
        if (playerSeekBar != null) {
            playerSeekBar.setSecondaryProgress(j);
        }
    }

    public void setNowTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752699792")) {
            ipChange.ipc$dispatch("-1752699792", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "HFull--setNowTime nowTime = " + j);
        this.mNowTime = j;
        PlayerSeekBar playerSeekBar = this.mSeekBar;
        if (playerSeekBar != null) {
            playerSeekBar.setProgress((float) j);
        }
    }

    public void setStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33529220")) {
            ipChange.ipc$dispatch("-33529220", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "HFull--setStartTime startTime = " + j);
        this.mStartTime = j;
    }

    public void setSumTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863039717")) {
            ipChange.ipc$dispatch("1863039717", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "HFull--setSumTime sumTime = " + j);
        this.mSumTime = j;
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896665512")) {
            ipChange.ipc$dispatch("-896665512", new Object[]{this});
        } else {
            show(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showControl() {
        LivePlayControl livePlayControl;
        BizSwitch bizSwitch;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1382885077")) {
            ipChange.ipc$dispatch("1382885077", new Object[]{this});
            return;
        }
        AlixPlayerContext playerContext = this.mPresenter.getPlayerContext();
        PlayType playType = playerContext.getPlayerContainer().getPlayVideoInfo().getPlayType();
        IAlixPlayer.State currentState = playerContext.getPlayerContainer().getPlayer().getCurrentState();
        int duration = (int) playerContext.getPlayerContainer().getPlayer().getDuration();
        long currentPosition = playerContext.getPlayerContainer().getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL);
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            if (this.mCastMode) {
                this.playerDisplayBtn.setVisibility(0);
            } else {
                this.playerDisplayBtn.setVisibility(8);
            }
        }
        this.playerMultiBtn.setVisibility(this.mPresenter.getMode() == 2 ? 0 : 8);
        if (this.mShowQuality) {
            this.qualityView.setVisibility(0);
            this.qualityView.setText(this.mQualityText);
            if (this.mShowTip) {
                this.qualityTipView.setVisibility(0);
                this.qualityTipView.setText(this.mQualityTip);
            } else {
                this.qualityTipView.setVisibility(8);
            }
        } else {
            this.qualityView.setVisibility(8);
            this.qualityTipView.setVisibility(8);
        }
        this.hrbContainer.setVisibility(0);
        if (playType == PlayType.VOD) {
            if (playerContext.isLandVideo() && playerContext.isLandScreen()) {
                this.mControlButton.setVisibility(0);
                this.mControlButton.setImageResource(currentState == IAlixPlayer.State.STATE_VIDEO_STARTED ? R.C7933drawable.btn_pause_live : R.C7933drawable.btn_play_live);
                this.mLeftText.setVisibility(0);
                this.mLeftText.setText(Utils.getFormathourTime(currentPosition));
                this.mSeekBar.setLiveMode(false);
                long j = duration;
                this.mSeekBar.setMax(j);
                this.mSeekBar.setProgress((float) currentPosition);
                this.mSeekBar.setSecondaryProgress(0L);
                this.mSeekBar.setVisibility(0);
                this.mRightText.setVisibility(0);
                this.mRightText.setText(Utils.getFormathourTime(j));
            }
        } else if (playType != PlayType.LIVE || (livePlayControl = playerContext.getPlayerContainer().getPlayer().getVideoStream().getYoukuVideoInfo().getLivePlayControl()) == null || (bizSwitch = livePlayControl.bizSwitch) == null) {
        } else {
            boolean z = bizSwitch.timeShift == 1;
            this.mIsTimeShift = z;
            if (z) {
                this.mControlButton.setVisibility(0);
                this.mControlButton.setImageResource(currentState == IAlixPlayer.State.STATE_VIDEO_STARTED ? R.C7933drawable.btn_pause_live : R.C7933drawable.btn_play_live);
                this.mLeftText.setVisibility(8);
                this.mSeekBar.setLiveMode(true);
                this.mSeekBar.setMax(this.mSumTime);
                this.mSeekBar.setProgress((float) this.mNowTime);
                this.mSeekBar.setSecondaryProgress(this.mLiveTime);
                this.mSeekBar.setVisibility(0);
                this.mRightText.setVisibility(8);
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.View
    public void showDisplayButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303889898")) {
            ipChange.ipc$dispatch("-303889898", new Object[]{this, Boolean.valueOf(z)});
        } else if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && isShow()) {
            this.playerDisplayBtn.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.View
    public void showQualityTip(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-300017086")) {
            ipChange.ipc$dispatch("-300017086", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.mShowTip = z;
        this.mQualityTip = str;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.View
    public void showQualityView(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443336912")) {
            ipChange.ipc$dispatch("443336912", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.mShowQuality = z;
        this.mQualityText = str;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlContact.View
    public void updateProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4668484")) {
            ipChange.ipc$dispatch("4668484", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mPresenter.getPlayerContext().getPlayerContainer().getPlayVideoInfo().getPlayType() == PlayType.VOD && isShow()) {
            this.mSeekBar.setProgress(i);
            this.mLeftText.setText(Utils.getFormathourTime(i));
        }
    }

    public void hide(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "833101121")) {
            ipChange.ipc$dispatch("833101121", new Object[]{this, Boolean.valueOf(z)});
        } else if (!this.isSeeking && isShow()) {
            hideControl();
            this.mMultiDevTipsView.close();
            if (z) {
                PluginAnimationUtils.pluginTopHide(this.topContainer, null);
                PluginAnimationUtils.pluginBottomHide(this.fullBottomContainer, new PluginAnimationUtils.AnimationActionListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.8
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnimationActionListener
                    public void onAnimationEnd() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1820553747")) {
                            ipChange2.ipc$dispatch("1820553747", new Object[]{this});
                        } else {
                            HorizontalFullControlView.super.hide();
                        }
                    }
                });
                return;
            }
            super.hide();
        }
    }

    @Override // com.youku.alixplugin.view.BaseView
    public void setPresenter(HorizontalFullControlContact.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318384649")) {
            ipChange.ipc$dispatch("318384649", new Object[]{this, presenter});
        } else {
            this.mPresenter = presenter;
        }
    }

    public void show(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026781316")) {
            ipChange.ipc$dispatch("-2026781316", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        AlixPlayerContext playerContext = this.mPresenter.getPlayerContext();
        if (playerContext.isLandVideo() && playerContext.isLandScreen() && !isShow()) {
            super.show();
            showControl();
            if (this.mAnimationY <= 0.0f || !z) {
                return;
            }
            PluginAnimationUtils.pluginTopShow(this.topContainer, new PluginAnimationUtils.AnimationActionListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullControlView.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnimationActionListener
                public void onAnimationEnd() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1609202834")) {
                        ipChange2.ipc$dispatch("1609202834", new Object[]{this});
                    } else if (HorizontalFullControlView.this.mPresenter.getMode() == 2) {
                        HorizontalFullControlView.this.mMultiDevTipsView.show(HorizontalFullControlView.this.playerMultiBtn, null);
                    }
                }
            });
            PluginAnimationUtils.pluginBottomShow(this.fullBottomContainer, null, this.mAnimationY);
        }
    }

    public void addView(List<WeexWidget> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "851965120")) {
            ipChange.ipc$dispatch("851965120", new Object[]{this, list});
            return;
        }
        for (WeexWidget weexWidget : list) {
            weexWidget.getKey();
            View view = weexWidget.getView();
            String area = weexWidget.getArea();
            LinearLayout.LayoutParams layoutParams = weexWidget.getLayoutParams();
            if (Constants.AREA_HLB.equals(area)) {
                this.hlbContainer.addView(view, layoutParams);
            } else if (Constants.AREA_HMB.equals(area)) {
                this.hmbContainer.addView(view, layoutParams);
            } else if (Constants.AREA_HRB.equals(area)) {
                this.hrbContainer.addView(view, layoutParams);
            } else if (Constants.AREA_HLT.equals(area)) {
                this.hltContainer.addView(view, layoutParams);
            } else if (Constants.AREA_HRT.equals(area)) {
                this.hrtContainer.addView(view, layoutParams);
            } else if (Constants.AREA_HRT2.equals(area)) {
                this.hrtContainer2.addView(view, layoutParams);
            } else if (Constants.AREA_HMT.equals(area)) {
                this.hmtContainer.addView(view, layoutParams);
            }
        }
    }
}
