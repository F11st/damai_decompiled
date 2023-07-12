package com.youku.live.dago.liveplayback.widget.plugins.verticalsmall;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
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
import com.youku.live.dago.liveplayback.widget.Constants;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils;
import com.youku.live.dago.liveplayback.widget.plugins.WeexWidget;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.PickTipsView;
import com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract;
import com.youku.live.dago.liveplayback.widget.view.CircleImageView;
import com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar;
import com.youku.vpm.constants.TableField;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class VerticalSmallControlView extends LazyInflatedView implements VerticalSmallControlContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout bottomContainer;
    private boolean isInTimeShift;
    private boolean isSeeking;
    private Activity mActivity;
    private float mAnimationY;
    private boolean mCastMode;
    private CircleImageView mControlButton;
    private View mDisplayButton;
    private CircleImageView mDlnaControlBtn;
    private long mEndTime;
    private Handler mHandler;
    private boolean mIsTimeShift;
    private TextView mLeftText;
    private long mLiveTime;
    private long mNowTime;
    private View mPickButton;
    private PickTipsView mPickTipsView;
    private VerticalSmallControlContract.Presenter mPresenter;
    private TextView mRightText;
    private PlayerSeekBar mSeekBar;
    private long mStartTime;
    private long mSumTime;
    private LinearLayout topContainer;
    private LinearLayout vrbContainer;
    private LinearLayout vrtContainer;
    private LinearLayout vrtContainer2;

    public VerticalSmallControlView(Context context, Activity activity, ILMLayerManager<ViewGroup> iLMLayerManager, String str, ViewPlaceholder viewPlaceholder) {
        super(context, iLMLayerManager, str, R.layout.player_vertical_smallscreen_plugin, viewPlaceholder);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.isInTimeShift = false;
        this.mAnimationY = 0.0f;
        this.mActivity = activity;
    }

    private void hideTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335966807")) {
            ipChange.ipc$dispatch("335966807", new Object[]{this});
        } else if (this.bottomContainer == null || this.mPickButton == null || !this.mPickTipsView.isShowing()) {
        } else {
            this.mPickTipsView.close();
        }
    }

    private void initView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558711062")) {
            ipChange.ipc$dispatch("1558711062", new Object[]{this, view});
            return;
        }
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.play_control_btn);
        this.mControlButton = circleImageView;
        circleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "626952626")) {
                    ipChange2.ipc$dispatch("626952626", new Object[]{this, view2});
                    return;
                }
                VerticalSmallControlView.this.mPresenter.onControlBtnClicked();
                VerticalSmallControlView.this.showControl();
            }
        });
        this.mSeekBar = (PlayerSeekBar) view.findViewById(R.id.player_seekbar);
        int dimension = (int) view.getContext().getResources().getDimension(R.dimen.resource_size_12);
        this.mSeekBar.setThumbSizeOnDragging(((int) view.getContext().getResources().getDimension(R.dimen.resource_size_40)) / 2);
        this.mSeekBar.setTrackPadding(dimension);
        int i = dimension * 2;
        this.mSeekBar.setPadding(0, i, 0, i);
        this.mSeekBar.setOnSeekBarChangeListener(new PlayerSeekBar.OnSeekBarChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onBackClicked(long j, long j2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "692550471")) {
                    ipChange2.ipc$dispatch("692550471", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
                    return;
                }
                VerticalSmallControlView.this.isSeeking = false;
                VerticalSmallControlView verticalSmallControlView = VerticalSmallControlView.this;
                verticalSmallControlView.dragEndForTimeShift(j, verticalSmallControlView.mLiveTime, true);
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onProgressChanged(PlayerSeekBar playerSeekBar, long j, boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1764900369")) {
                    ipChange2.ipc$dispatch("1764900369", new Object[]{this, playerSeekBar, Long.valueOf(j), Boolean.valueOf(z)});
                } else if (z) {
                    VerticalSmallControlView.this.mLeftText.setText(Utils.getFormathourTime(j));
                    VerticalSmallControlView.this.mSeekBar.setProgress((float) j);
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(PlayerSeekBar playerSeekBar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-415765954")) {
                    ipChange2.ipc$dispatch("-415765954", new Object[]{this, playerSeekBar});
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(PlayerSeekBar playerSeekBar, long j, boolean z, boolean z2, long j2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1590618814")) {
                    ipChange2.ipc$dispatch("-1590618814", new Object[]{this, playerSeekBar, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2)});
                    return;
                }
                VerticalSmallControlView.this.isSeeking = false;
                if (z) {
                    String str = LazyInflatedView.TAG;
                    Logger.d(str, "onStopTrackingTouch seekBar = " + playerSeekBar + " progress = " + j + " fromUser = " + z);
                    if (!z2) {
                        VerticalSmallControlView.this.mPresenter.seekTo(playerSeekBar.getProgress());
                    } else if (j >= VerticalSmallControlView.this.mLiveTime) {
                        VerticalSmallControlView.this.isInTimeShift = false;
                        VerticalSmallControlView verticalSmallControlView = VerticalSmallControlView.this;
                        verticalSmallControlView.dragEndForTimeShift(j, verticalSmallControlView.mLiveTime, true);
                    } else {
                        VerticalSmallControlView.this.isInTimeShift = true;
                        VerticalSmallControlView verticalSmallControlView2 = VerticalSmallControlView.this;
                        verticalSmallControlView2.dragEndForTimeShift(j, verticalSmallControlView2.mLiveTime, false);
                    }
                }
            }

            @Override // com.youku.live.dago.liveplayback.widget.view.PlayerSeekBar.OnSeekBarChangeListener
            public void onTrackingPressDown(PlayerSeekBar playerSeekBar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-498309734")) {
                    ipChange2.ipc$dispatch("-498309734", new Object[]{this, playerSeekBar});
                } else {
                    VerticalSmallControlView.this.isSeeking = true;
                }
            }
        });
        this.mLeftText = (TextView) view.findViewById(R.id.time_left);
        this.mRightText = (TextView) view.findViewById(R.id.time_right);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844536892")) {
            ipChange.ipc$dispatch("844536892", new Object[]{this});
        } else if (this.bottomContainer == null || this.mPickButton == null) {
        } else {
            this.mPickTipsView.show(getInflatedView(), 53, this.mPickButton.getRight(), this.bottomContainer.getTop());
        }
    }

    public void addView(List<WeexWidget> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54628740")) {
            ipChange.ipc$dispatch("54628740", new Object[]{this, list});
            return;
        }
        for (WeexWidget weexWidget : list) {
            String key = weexWidget.getKey();
            View view = weexWidget.getView();
            String area = weexWidget.getArea();
            LinearLayout.LayoutParams layoutParams = weexWidget.getLayoutParams();
            if ("unlimitScreen".equals(key)) {
                this.mPickButton = view;
                this.mPickTipsView.setText(weexWidget.getTip());
                this.mPickButton.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.8
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-120583514")) {
                            ipChange2.ipc$dispatch("-120583514", new Object[]{this, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
                        } else if ((i == i5 && i2 == i6 && i3 == i7 && i4 == i8) || VerticalSmallControlView.this.mPresenter.getPlayerContext().isLandScreen() || view2 != VerticalSmallControlView.this.mPickButton) {
                        } else {
                            VerticalSmallControlView.this.showTips();
                        }
                    }
                });
            }
            if (Constants.AREA_VRB.equals(area)) {
                this.vrbContainer.addView(view, layoutParams);
            } else if (Constants.AREA_VRT.equals(area)) {
                if ("share".equals(key)) {
                    this.vrtContainer2.addView(view, layoutParams);
                } else {
                    this.vrtContainer.addView(view, layoutParams);
                }
            }
        }
    }

    public void dragEndForTimeShift(long j, long j2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826454578")) {
            ipChange.ipc$dispatch("-1826454578", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)});
            return;
        }
        Logger.d("timeshift", "dragEndForTimeShift progress = " + j);
        IPlayerContainer playerContainer = this.mPresenter.getPlayerContext().getPlayerContainer();
        String liveId = playerContainer.getPlayVideoInfo().getLiveId();
        LiveInfo liveInfo = playerContainer.getVideoStream().getYoukuVideoInfo().getLiveInfo();
        if (liveInfo == null) {
            return;
        }
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
        return AndroidInstantRuntime.support(ipChange, "-726576258") ? ((Long) ipChange.ipc$dispatch("-726576258", new Object[]{this})).longValue() : this.mLiveTime;
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19088815")) {
            ipChange.ipc$dispatch("19088815", new Object[]{this});
        } else {
            hide(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideControl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2109900386")) {
            ipChange.ipc$dispatch("-2109900386", new Object[]{this});
        } else if (isShow()) {
            this.mControlButton.setVisibility(8);
            this.mLeftText.setVisibility(8);
            this.mSeekBar.setVisibility(8);
            this.mRightText.setVisibility(8);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.View
    public void onDlnaPlayerPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91288542")) {
            ipChange.ipc$dispatch("91288542", new Object[]{this});
            return;
        }
        CircleImageView circleImageView = this.mDlnaControlBtn;
        if (circleImageView != null) {
            circleImageView.setImageResource(R.drawable.btn_play_live);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.View
    public void onDlnaPlayerStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134393330")) {
            ipChange.ipc$dispatch("134393330", new Object[]{this});
            return;
        }
        CircleImageView circleImageView = this.mDlnaControlBtn;
        if (circleImageView != null) {
            circleImageView.setImageResource(R.drawable.btn_pause_live);
        }
        if (isInflated()) {
            showControl();
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView
    protected void onInflate(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-521179359")) {
            ipChange.ipc$dispatch("-521179359", new Object[]{this, view});
            return;
        }
        this.vrbContainer = (LinearLayout) view.findViewById(R.id.vrb_container);
        this.vrtContainer = (LinearLayout) view.findViewById(R.id.vrt_container);
        this.vrtContainer2 = (LinearLayout) view.findViewById(R.id.vrt_container2);
        this.topContainer = (LinearLayout) view.findViewById(R.id.top_container);
        View findViewById = view.findViewById(R.id.player_display_btn);
        this.mDisplayButton = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1411951185")) {
                    ipChange2.ipc$dispatch("-1411951185", new Object[]{this, view2});
                    return;
                }
                VerticalSmallControlView.this.mPresenter.onDisplayBtnClicked();
                if (VerticalSmallControlView.this.mPresenter.getPlayerContext().isDlnaMode()) {
                    VerticalSmallControlView.this.vrbContainer.setVisibility(0);
                } else {
                    VerticalSmallControlView.this.vrbContainer.setVisibility(8);
                }
            }
        });
        this.mDisplayButton.setVisibility(8);
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.play_control_btn_dlna);
        this.mDlnaControlBtn = circleImageView;
        circleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "699339184")) {
                    ipChange2.ipc$dispatch("699339184", new Object[]{this, view2});
                } else {
                    VerticalSmallControlView.this.mPresenter.onDlnaCtrlBtnClicked();
                }
            }
        });
        this.bottomContainer = (LinearLayout) view.findViewById(R.id.bottom_container);
        initView(view);
        this.mPresenter.addViewGroup(this.vrtContainer);
        this.mPresenter.addViewGroup(this.vrtContainer2);
        this.mPresenter.addViewGroup(this.vrbContainer);
        this.mPickTipsView = new PickTipsView(this.mActivity);
        this.bottomContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-673521333")) {
                    ipChange2.ipc$dispatch("-673521333", new Object[]{this, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)});
                } else if ((i == i5 && i2 == i6 && i3 == i7 && i4 == i8) || view2.getParent() == null || VerticalSmallControlView.this.mPresenter.getPlayerContext().isLandScreen()) {
                } else {
                    VerticalSmallControlView.this.mAnimationY = ((View) view2.getParent()).getHeight() - view2.getHeight();
                    VerticalSmallControlView.this.showTips();
                }
            }
        });
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.View
    public void setCastMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895884991")) {
            ipChange.ipc$dispatch("895884991", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mCastMode = z;
        }
    }

    public void setLiveTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138244218")) {
            ipChange.ipc$dispatch("-138244218", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "VSmall--setLiveTime liveTime = " + j);
        this.mLiveTime = j;
        PlayerSeekBar playerSeekBar = this.mSeekBar;
        if (playerSeekBar != null) {
            playerSeekBar.setSecondaryProgress(j);
        }
    }

    public void setNowTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511231284")) {
            ipChange.ipc$dispatch("1511231284", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "VSmall--setNowTime nowTime = " + j);
        this.mNowTime = j;
        PlayerSeekBar playerSeekBar = this.mSeekBar;
        if (playerSeekBar != null) {
            playerSeekBar.setProgress((float) j);
        }
    }

    public void setStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278108736")) {
            ipChange.ipc$dispatch("1278108736", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "VSmall--setStartTime startTime = " + j);
        this.mStartTime = j;
    }

    public void setSumTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832003497")) {
            ipChange.ipc$dispatch("832003497", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d("timeshift", "VSmall--setSumTime sumTime = " + j);
        this.mSumTime = j;
        PlayerSeekBar playerSeekBar = this.mSeekBar;
        if (playerSeekBar != null) {
            playerSeekBar.setMax(j);
        }
    }

    @Override // com.youku.alixplugin.view.LazyInflatedView, com.youku.alixplugin.view.BaseView
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173760532")) {
            ipChange.ipc$dispatch("1173760532", new Object[]{this});
        } else {
            show(true);
        }
    }

    void showControl() {
        LivePlayControl livePlayControl;
        BizSwitch bizSwitch;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351848857")) {
            ipChange.ipc$dispatch("351848857", new Object[]{this});
        } else if (this.topContainer == null || this.bottomContainer == null) {
        } else {
            AlixPlayerContext playerContext = this.mPresenter.getPlayerContext();
            IAlixPlayer.State currentState = playerContext.getPlayerContainer().getPlayer().getCurrentState();
            int duration = (int) playerContext.getPlayerContainer().getPlayer().getDuration();
            long currentPosition = playerContext.getPlayerContainer().getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL);
            if (playerContext.getPlayerContainer() != null) {
                PlayType playType = playerContext.getPlayerContainer().getPlayVideoInfo().getPlayType();
                this.topContainer.setVisibility(0);
                if (this.mCastMode) {
                    this.mDisplayButton.setVisibility(0);
                } else {
                    this.mDisplayButton.setVisibility(8);
                }
                if (playerContext.isDlnaMode()) {
                    this.mDlnaControlBtn.setVisibility(0);
                    this.mDisplayButton.setSelected(true);
                } else {
                    this.mDlnaControlBtn.setVisibility(8);
                    this.vrbContainer.setVisibility(0);
                    this.mDisplayButton.setSelected(false);
                }
                this.bottomContainer.setVisibility(0);
                if (playType == PlayType.VOD) {
                    if (playerContext.isLandVideo() && !playerContext.isLandScreen()) {
                        this.mControlButton.setVisibility(0);
                        this.mControlButton.setImageResource(currentState == IAlixPlayer.State.STATE_VIDEO_STARTED ? R.drawable.btn_pause_live : R.drawable.btn_play_live);
                        this.mLeftText.setVisibility(0);
                        this.mLeftText.setText(Utils.getFormathourTime(currentPosition));
                        this.mSeekBar.setVisibility(0);
                        this.mSeekBar.setLiveMode(false);
                        long j = duration;
                        this.mSeekBar.setMax(j);
                        this.mSeekBar.setProgress((float) currentPosition);
                        this.mSeekBar.setSecondaryProgress(0L);
                        this.mRightText.setVisibility(0);
                        this.mRightText.setText(Utils.getFormathourTime(j));
                        this.vrtContainer.setVisibility(0);
                    }
                } else if (playType == PlayType.LIVE && (livePlayControl = playerContext.getPlayerContainer().getPlayer().getVideoStream().getYoukuVideoInfo().getLivePlayControl()) != null && (bizSwitch = livePlayControl.bizSwitch) != null) {
                    boolean z = bizSwitch.timeShift == 1;
                    this.mIsTimeShift = z;
                    if (z) {
                        this.mControlButton.setVisibility(0);
                        this.mControlButton.setImageResource(currentState == IAlixPlayer.State.STATE_VIDEO_STARTED ? R.drawable.btn_pause_live : R.drawable.btn_play_live);
                        this.mLeftText.setVisibility(8);
                        this.mSeekBar.setLiveMode(true);
                        this.mSeekBar.setMax(this.mSumTime);
                        this.mSeekBar.setProgress((float) this.mNowTime);
                        this.mSeekBar.setSecondaryProgress(this.mLiveTime);
                        this.mSeekBar.setVisibility(0);
                        this.mRightText.setVisibility(8);
                    }
                }
                if (playerContext.isLandScreen() || !playerContext.isDlnaMode()) {
                    return;
                }
                this.mDlnaControlBtn.setVisibility(0);
                this.vrbContainer.setVisibility(8);
                this.mControlButton.setVisibility(8);
                this.mSeekBar.setVisibility(8);
                this.mLeftText.setVisibility(8);
                this.mRightText.setVisibility(8);
            }
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.View
    public void showDisplayButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1338211026")) {
            ipChange.ipc$dispatch("1338211026", new Object[]{this, Boolean.valueOf(z)});
        } else if (isInflated()) {
            this.mDisplayButton.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlContract.View
    public void updateProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063326472")) {
            ipChange.ipc$dispatch("2063326472", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mPresenter.getPlayerContext().getPlayerContainer().getPlayVideoInfo().getPlayType() == PlayType.VOD && isShow()) {
            this.mSeekBar.setProgress(i);
            this.mLeftText.setText(Utils.getFormathourTime(i));
        }
    }

    public void hide(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591799045")) {
            ipChange.ipc$dispatch("591799045", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.isSeeking) {
        } else {
            boolean isShow = isShow();
            if (this.mPresenter.getPlayerContext().isDlnaMode()) {
                LinearLayout linearLayout = this.vrbContainer;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                CircleImageView circleImageView = this.mControlButton;
                if (circleImageView != null) {
                    circleImageView.setVisibility(8);
                }
            } else if (isShow) {
                hideControl();
                if (z) {
                    PluginAnimationUtils.pluginTopHide(this.topContainer, null);
                    PluginAnimationUtils.pluginBottomHide(this.bottomContainer, new PluginAnimationUtils.AnimationActionListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.7
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnimationActionListener
                        public void onAnimationEnd() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1003091022")) {
                                ipChange2.ipc$dispatch("1003091022", new Object[]{this});
                            } else {
                                VerticalSmallControlView.super.hide();
                            }
                        }
                    });
                } else {
                    super.hide();
                }
                hideTips();
            }
        }
    }

    @Override // com.youku.alixplugin.view.BaseView
    public void setPresenter(VerticalSmallControlContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1342036333")) {
            ipChange.ipc$dispatch("1342036333", new Object[]{this, presenter});
        } else {
            this.mPresenter = presenter;
        }
    }

    public void show(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026883904")) {
            ipChange.ipc$dispatch("2026883904", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        AlixPlayerContext playerContext = this.mPresenter.getPlayerContext();
        if (!playerContext.isLandVideo() || playerContext.isLandScreen() || isShow()) {
            return;
        }
        super.show();
        showControl();
        if (this.mAnimationY <= 0.0f || !z) {
            return;
        }
        PluginAnimationUtils.pluginTopShow(this.topContainer, null);
        PluginAnimationUtils.pluginBottomShow(this.bottomContainer, new PluginAnimationUtils.AnimationActionListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallControlView.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.AnimationActionListener
            public void onAnimationEnd() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "791740109")) {
                    ipChange2.ipc$dispatch("791740109", new Object[]{this});
                } else {
                    VerticalSmallControlView.this.showTips();
                }
            }
        }, this.mAnimationY);
    }
}
