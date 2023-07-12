package cn.damai.tetris.component.online.mvp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$raw;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.discover.DMVideoPlayerDiscoverController;
import cn.damai.player.utils.network.NetworkType;
import cn.damai.tetris.component.online.bean.ArtistBean;
import cn.damai.tetris.component.online.bean.ArtistItemBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.view.DMLRLabelView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import tb.d13;
import tb.jo2;
import tb.m62;
import tb.m91;
import tb.mu0;
import tb.xr;
import tb.yj1;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeaderView extends AbsView<HeaderContract$Presenter> implements HeaderContract$View<HeaderContract$Presenter>, WeakRefCountDownTimer.OnTickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DAY = 86400000;
    private static final long HOUR = 3600000;
    private static final long MINUTE = 60000;
    private long endTime;
    private long intervalTime;
    private ArtistBean mBean;
    private ImageView mBgImageView;
    private View mBgView;
    private LottieAnimationView mBolangView;
    private TextView mBuyBtn;
    private Context mContext;
    private DMVideoPlayerDiscoverController mController;
    private ys mDMVideoPlayerManager;
    private LinearLayout mDaojishiLayout;
    private TextView mDayTipTv;
    private TextView mDayTv;
    private View mHeaderView;
    private TextView mHourTv;
    private DMLRLabelView mLabelView;
    private LottieAnimationView mLiwuView;
    private ImageView mLogoView;
    private TextView mMinuteTv;
    private HeadPicListView mPicListView;
    private String mSchemaUrl;
    private TextView mSecondTv;
    private TextView mShengyuFenTipTv;
    private TextView mShengyuFenTv;
    private TextView mShengyuHourTipTv;
    private TextView mShengyuHourTv;
    private View mShengyuLayout;
    private View mStarLayout;
    private TextView mStarNameTv;
    private TextView mTimeStartTv;
    private int mTimeStatus;
    private TextView mTimeTipTv;
    private d13 mTimer;
    private TextView mTitleTv;
    private ImageView mVideoIconView;
    private VideoInfo mVideoInfo;
    private DMVideoPlayer mVideoPlayerView;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-30142364")) {
                ipChange.ipc$dispatch("-30142364", new Object[]{this, view});
            } else if (TextUtils.isEmpty(HeaderView.this.mSchemaUrl)) {
            } else {
                HeaderView.this.getPresenter().btnClick(HeaderView.this.mSchemaUrl);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2081148005")) {
                ipChange.ipc$dispatch("2081148005", new Object[]{this, view});
            } else if (TextUtils.isEmpty(HeaderView.this.mSchemaUrl)) {
            } else {
                HeaderView.this.getPresenter().btnClick(HeaderView.this.mSchemaUrl);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "744950096")) {
                ipChange.ipc$dispatch("744950096", new Object[]{this, view});
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1238992435")) {
                ipChange.ipc$dispatch("-1238992435", new Object[]{this, view});
                return;
            }
            Object tag = HeaderView.this.mDaojishiLayout.getTag();
            if (tag instanceof d13) {
                ((d13) tag).cancel();
                HeaderView.this.mDaojishiLayout.setTag(null);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class d implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1714531119")) {
                ipChange.ipc$dispatch("1714531119", new Object[]{this, view});
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1479532564")) {
                ipChange.ipc$dispatch("-1479532564", new Object[]{this, view});
                return;
            }
            Object tag = HeaderView.this.mShengyuLayout.getTag();
            if (tag instanceof d13) {
                ((d13) tag).cancel();
                HeaderView.this.mShengyuLayout.setTag(null);
            }
        }
    }

    public HeaderView(View view) {
        super(view);
        this.mTimeStatus = 0;
        this.endTime = 0L;
        this.intervalTime = 0L;
        this.mContext = view.getContext();
        this.mHeaderView = view.findViewById(R$id.layout_header);
        this.mDMVideoPlayerManager = ys.d();
        this.mVideoPlayerView = (DMVideoPlayer) view.findViewById(R$id.player);
        DMVideoPlayerDiscoverController dMVideoPlayerDiscoverController = new DMVideoPlayerDiscoverController(this.mContext);
        this.mController = dMVideoPlayerDiscoverController;
        dMVideoPlayerDiscoverController.setAutoReport(true);
        this.mController.setSpmData("category_online", "video");
        this.mVideoPlayerView.setController(this.mController);
        try {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            this.mVideoPlayerView.setVideoPlayerSize(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - m62.a(this.mContext, 42.0f), m62.a(this.mContext, 188.0f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mDMVideoPlayerManager.k(this.mVideoPlayerView);
        this.mBgImageView = (ImageView) view.findViewById(R$id.image_bg);
        this.mBgView = view.findViewById(R$id.view_bg);
        this.mLogoView = (ImageView) view.findViewById(R$id.image_logo);
        this.mVideoIconView = (ImageView) view.findViewById(R$id.player_video_btn);
        this.mStarLayout = view.findViewById(R$id.layout_star);
        this.mPicListView = (HeadPicListView) view.findViewById(R$id.piclist_view);
        this.mStarNameTv = (TextView) view.findViewById(R$id.star_name_view);
        this.mLabelView = (DMLRLabelView) view.findViewById(R$id.star_label_view);
        this.mBolangView = (LottieAnimationView) view.findViewById(R$id.bolang_view);
        this.mLiwuView = (LottieAnimationView) view.findViewById(R$id.liwu_view);
        try {
            this.mBolangView.setAnimation(R$raw.lottie_red_sound_wave);
            this.mLiwuView.setAnimation(R$raw.lottie_liwu);
            this.mBolangView.cancelAnimation();
            this.mLiwuView.cancelAnimation();
        } catch (Exception unused) {
        }
        this.mTimeTipTv = (TextView) view.findViewById(R$id.tv_time_tip);
        this.mTimeStartTv = (TextView) view.findViewById(R$id.tv_time_start);
        this.mDaojishiLayout = (LinearLayout) view.findViewById(R$id.daojishi_layout);
        this.mDayTv = (TextView) view.findViewById(R$id.tv_day);
        this.mDayTipTv = (TextView) view.findViewById(R$id.tv_day_tip);
        this.mHourTv = (TextView) view.findViewById(R$id.tv_hour);
        this.mMinuteTv = (TextView) view.findViewById(R$id.tv_minute);
        this.mSecondTv = (TextView) view.findViewById(R$id.tv_second);
        this.mShengyuLayout = view.findViewById(R$id.shengyu_layout);
        this.mShengyuHourTv = (TextView) view.findViewById(R$id.tv_shengyu_xiaoshi);
        this.mShengyuHourTipTv = (TextView) view.findViewById(R$id.tv_shengyu_hour_tip);
        this.mShengyuFenTv = (TextView) view.findViewById(R$id.tv_shengyu_fen);
        this.mShengyuFenTipTv = (TextView) view.findViewById(R$id.tv_shengyu_fen_tip);
        this.mTitleTv = (TextView) view.findViewById(R$id.tv_title);
        this.mBuyBtn = (TextView) view.findViewById(R$id.btn_buy);
        this.mHeaderView.setOnClickListener(new a());
        this.mController.setOnClickListener(new b());
        this.mDaojishiLayout.addOnAttachStateChangeListener(new c());
        this.mShengyuLayout.addOnAttachStateChangeListener(new d());
    }

    private String getConcatText(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1178150281")) {
            return (String) ipChange.ipc$dispatch("1178150281", new Object[]{this, Long.valueOf(j)});
        }
        if (j < 10) {
            return "0" + j;
        }
        return "" + j;
    }

    private String getKaiyanTime(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-600616942")) {
            return (String) ipChange.ipc$dispatch("-600616942", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        }
        try {
            long j3 = j + this.intervalTime;
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
            calendar.setTimeInMillis(j3);
            calendar.set(10, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar2.setTimeInMillis(j2);
            calendar2.set(10, 0);
            calendar2.set(12, 0);
            calendar2.set(13, 0);
            int timeInMillis = (int) (((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) + DanmakuFactory.DEFAULT_DANMAKU_DURATION_V) / 86400000);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            String format = simpleDateFormat.format(Long.valueOf(j2));
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            String format2 = simpleDateFormat2.format(Long.valueOf(j2));
            if (timeInMillis == 0) {
                return "今天" + format2;
            } else if (timeInMillis == 1) {
                return "明天" + format2;
            } else {
                return format;
            }
        } catch (Exception unused) {
            return "";
        }
    }

    private void setAfterPerfrom(long j, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472019475")) {
            ipChange.ipc$dispatch("-472019475", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)});
            return;
        }
        this.mTimeStatus = 3;
        this.mBolangView.setVisibility(8);
        this.mLiwuView.setVisibility(8);
        this.mTimeTipTv.setText("精彩回放");
        this.mTimeTipTv.getPaint().setShader(new LinearGradient(0.0f, 0.0f, m62.a(this.mContext, 66.0f), 0.0f, Color.parseColor("#A045FF"), Color.parseColor("#5B90FF"), Shader.TileMode.CLAMP));
        this.mTimeTipTv.invalidate();
        this.mTimeStartTv.setVisibility(8);
        this.mDaojishiLayout.setVisibility(8);
        this.mShengyuLayout.setVisibility(8);
        this.mBuyBtn.setText("观看回放");
    }

    private void setBeforePerfrom(long j, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247660508")) {
            ipChange.ipc$dispatch("-1247660508", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)});
            return;
        }
        this.mTimeStatus = 1;
        this.mBolangView.setVisibility(8);
        this.mLiwuView.setVisibility(8);
        this.mTimeTipTv.setText("即将开演");
        this.mTimeTipTv.getPaint().setShader(new LinearGradient(0.0f, 0.0f, m62.a(this.mContext, 66.0f), 0.0f, Color.parseColor("#A045FF"), Color.parseColor("#5B90FF"), Shader.TileMode.CLAMP));
        this.mTimeTipTv.invalidate();
        this.mTimeStartTv.setVisibility(0);
        this.mTimeStartTv.setText(getKaiyanTime(j, j2));
        this.mDaojishiLayout.setVisibility(0);
        this.mShengyuLayout.setVisibility(8);
        d13 d13Var = new d13((j2 - j) - this.intervalTime, 1000L, this);
        this.mTimer = d13Var;
        d13Var.start();
        this.mDaojishiLayout.setTag(this.mTimer);
        this.mBuyBtn.setText("立即预约");
    }

    private void setPerfroming(long j, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064876061")) {
            ipChange.ipc$dispatch("2064876061", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)});
            return;
        }
        this.mTimeStatus = 2;
        this.mBolangView.setVisibility(0);
        this.mLiwuView.setVisibility(0);
        this.mBolangView.playAnimation();
        this.mLiwuView.playAnimation();
        this.mTimeTipTv.setText("正在演出");
        this.mTimeTipTv.getPaint().setShader(new LinearGradient(0.0f, 0.0f, m62.a(this.mContext, 66.0f), 0.0f, Color.parseColor("#FF2869"), Color.parseColor("#D963FF"), Shader.TileMode.CLAMP));
        this.mTimeTipTv.invalidate();
        this.mTimeStartTv.setVisibility(8);
        this.mDaojishiLayout.setVisibility(8);
        this.mShengyuLayout.setVisibility(0);
        d13 d13Var = new d13((j3 - j) - this.intervalTime, 1000L, this);
        this.mTimer = d13Var;
        d13Var.start();
        this.mShengyuLayout.setTag(this.mTimer);
        this.mBuyBtn.setText("立即观看");
    }

    private void setTimerData(long j, long j2, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234449963")) {
            ipChange.ipc$dispatch("1234449963", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)});
            return;
        }
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            setBeforePerfrom(j, j2, j3);
        } else if (i >= 0 && j <= j3) {
            setPerfroming(j, j2, j3);
        } else if (j > j3) {
            setAfterPerfrom(j, j2, j3);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1708593452")) {
            ipChange.ipc$dispatch("-1708593452", new Object[]{this});
            return;
        }
        int i = this.mTimeStatus;
        if (i == 1) {
            xr.c("refreshData", null);
        } else if (i == 2) {
            xr.c("refreshData", null);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030034938")) {
            ipChange.ipc$dispatch("1030034938", new Object[]{this, Long.valueOf(j)});
            return;
        }
        long j2 = j / 86400000;
        long j3 = j % 86400000;
        long j4 = j3 / 3600000;
        long j5 = j3 % 3600000;
        long j6 = j5 / 60000;
        String concatText = getConcatText(j2);
        String concatText2 = getConcatText(j4);
        String concatText3 = getConcatText(j6);
        String concatText4 = getConcatText((j5 % 60000) / 1000);
        int i = this.mTimeStatus;
        if (i == 1) {
            this.mDayTv.setText(concatText);
            if (j2 <= 0) {
                this.mDayTv.setVisibility(8);
                this.mDayTipTv.setVisibility(8);
            } else {
                this.mDayTv.setVisibility(0);
                this.mDayTipTv.setVisibility(0);
            }
            this.mHourTv.setText(concatText2);
            this.mMinuteTv.setText(concatText3);
            this.mSecondTv.setText(concatText4);
        } else if (i == 2) {
            if (j4 >= 1) {
                TextView textView = this.mShengyuHourTv;
                textView.setText(j4 + "");
                this.mShengyuHourTv.setVisibility(0);
                this.mShengyuHourTipTv.setVisibility(0);
            } else {
                TextView textView2 = this.mShengyuHourTv;
                textView2.setText(j6 + "");
                this.mShengyuHourTv.setVisibility(8);
                this.mShengyuHourTipTv.setVisibility(8);
            }
            TextView textView3 = this.mShengyuFenTv;
            textView3.setText(j6 + "");
        }
    }

    @Override // cn.damai.tetris.component.online.mvp.HeaderContract$View
    public void setData(ArtistBean artistBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "543430144")) {
            ipChange.ipc$dispatch("543430144", new Object[]{this, artistBean});
        } else if (artistBean == null) {
        } else {
            this.mBean = artistBean;
            this.mSchemaUrl = artistBean.jumpUrl;
            cn.damai.common.image.a.b().h(mu0.a()).e(this.mBean.contentPic).g(this.mBgImageView);
            if (!TextUtils.isEmpty(this.mBean.vid)) {
                if (yj1.b(this.mContext) == NetworkType.NETWORK_WIFI) {
                    this.mVideoIconView.setVisibility(8);
                    this.mVideoPlayerView.setVisibility(0);
                } else {
                    this.mVideoIconView.setVisibility(0);
                    this.mVideoPlayerView.setVisibility(8);
                }
                VideoInfo videoInfo = new VideoInfo();
                this.mVideoInfo = videoInfo;
                videoInfo.setPicUrl(this.mBean.contentPic);
                this.mVideoInfo.setVid(this.mBean.vid);
                this.mVideoInfo.setType(VideoInfo.VideoType.VIDEO_VID);
                this.mVideoPlayerView.setVideoData(this.mVideoInfo);
                this.mVideoPlayerView.mute(0);
                this.mDMVideoPlayerManager.a();
            } else {
                this.mVideoPlayerView.setVisibility(8);
            }
            this.mTitleTv.setText(this.mBean.itemName);
            if (this.mBean.pxmFlag) {
                this.mLogoView.setVisibility(0);
            } else {
                this.mLogoView.setVisibility(8);
            }
            if (m91.a(this.mBean.artistList)) {
                this.mStarLayout.setVisibility(8);
            } else {
                this.mStarLayout.setVisibility(0);
                this.mPicListView.setData(this.mBean.artistList);
                if (this.mBean.artistList.size() > 1) {
                    if (this.mBean.artistList.size() > 4) {
                        this.mPicListView.setVisibility(8);
                    } else {
                        this.mPicListView.setVisibility(0);
                    }
                    this.mStarNameTv.setVisibility(8);
                    this.mLabelView.setVisibility(8);
                } else {
                    ArtistItemBean artistItemBean = this.mBean.artistList.get(0);
                    if (artistItemBean != null) {
                        this.mStarNameTv.setVisibility(0);
                        this.mStarNameTv.setText(artistItemBean.artistName);
                        this.mLabelView.setVisibility(0);
                        this.mLabelView.setContent("V", null);
                        this.mLabelView.setColor(1);
                    }
                }
            }
            Object tag = this.mDaojishiLayout.getTag();
            if (tag instanceof d13) {
                ((d13) tag).cancel();
                this.mDaojishiLayout.setTag(null);
            }
            ArtistBean artistBean2 = this.mBean;
            if (artistBean2.startPerformTime <= 0 || artistBean2.endPerformTime <= 0 || artistBean2.currentTime <= 0) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.endTime = elapsedRealtime;
            this.intervalTime = elapsedRealtime - jo2.a;
            ArtistBean artistBean3 = this.mBean;
            setTimerData(artistBean3.currentTime, artistBean3.startPerformTime, artistBean3.endPerformTime);
        }
    }

    public void videoDestory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447856685")) {
            ipChange.ipc$dispatch("447856685", new Object[]{this});
            return;
        }
        ys ysVar = this.mDMVideoPlayerManager;
        if (ysVar != null) {
            ysVar.f();
            this.mDMVideoPlayerManager.j();
        }
        DMVideoPlayer dMVideoPlayer = this.mVideoPlayerView;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.release();
        }
    }

    public void videoPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031621365")) {
            ipChange.ipc$dispatch("2031621365", new Object[]{this});
            return;
        }
        ys ysVar = this.mDMVideoPlayerManager;
        if (ysVar != null) {
            ysVar.a();
            if (this.mDMVideoPlayerManager.b() != null) {
                this.mDMVideoPlayerManager.b().mute(0);
            }
        }
    }

    public void videoStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "640859495")) {
            ipChange.ipc$dispatch("640859495", new Object[]{this});
            return;
        }
        ys ysVar = this.mDMVideoPlayerManager;
        if (ysVar != null) {
            ysVar.f();
        }
        DMVideoPlayer dMVideoPlayer = this.mVideoPlayerView;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.pause(false);
        }
    }
}
