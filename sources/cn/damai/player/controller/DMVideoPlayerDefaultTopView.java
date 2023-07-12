package cn.damai.player.controller;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import cn.damai.message.observer.Action;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import tb.xr;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMVideoPlayerDefaultTopView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private xr dmMessage;
    private FragmentActivity mActivity;
    private IVideoController mController;
    private xs mDataHolder;
    private HandlerC1502e mHandler;
    private IVideoPlayer mPlayer;
    private DMIconFontTextView mToSmallScreen;
    private OnPlayerUTReportListener mUTReportListener;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.controller.DMVideoPlayerDefaultTopView$a */
    /* loaded from: classes6.dex */
    public class C1498a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1498a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "498994764")) {
                ipChange.ipc$dispatch("498994764", new Object[]{this, obj});
            } else {
                DMVideoPlayerDefaultTopView.this.showTopBar();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.controller.DMVideoPlayerDefaultTopView$b */
    /* loaded from: classes6.dex */
    public class C1499b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1499b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1192096461")) {
                ipChange.ipc$dispatch("1192096461", new Object[]{this, obj});
            } else {
                DMVideoPlayerDefaultTopView.this.hideTopBar();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.controller.DMVideoPlayerDefaultTopView$c */
    /* loaded from: classes6.dex */
    public class C1500c implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1500c() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1885198158")) {
                ipChange.ipc$dispatch("1885198158", new Object[]{this, obj});
            } else {
                DMVideoPlayerDefaultTopView.this.removeMessage();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.controller.DMVideoPlayerDefaultTopView$d */
    /* loaded from: classes6.dex */
    public class C1501d implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1501d() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1716667441")) {
                ipChange.ipc$dispatch("-1716667441", new Object[]{this, obj});
            } else {
                DMVideoPlayerDefaultTopView.this.topBarDelayHide();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.player.controller.DMVideoPlayerDefaultTopView$e */
    /* loaded from: classes15.dex */
    public class HandlerC1502e extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC1502e() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "586448361")) {
                ipChange.ipc$dispatch("586448361", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            DMVideoPlayerDefaultTopView.this.setVisibility(8);
        }
    }

    public DMVideoPlayerDefaultTopView(FragmentActivity fragmentActivity, IVideoPlayer iVideoPlayer) {
        super(fragmentActivity);
        this.mActivity = fragmentActivity;
        this.mPlayer = iVideoPlayer;
        this.mDataHolder = ys.d().c();
        initTopBar();
    }

    private void initTopBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852737069")) {
            ipChange.ipc$dispatch("-852737069", new Object[]{this});
            return;
        }
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) LayoutInflater.from(this.mActivity).inflate(R$layout.yk_player_topbar, this).findViewById(R$id.yk_player_back_btn);
        this.mToSmallScreen = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(this);
        setVisibility(8);
        this.mHandler = new HandlerC1502e();
        registerDMMessage();
    }

    private void registerDMMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280167602")) {
            ipChange.ipc$dispatch("-1280167602", new Object[]{this});
            return;
        }
        xr xrVar = new xr();
        this.dmMessage = xrVar;
        xrVar.b("topbar_show", new C1498a());
        this.dmMessage.b("topbar_hide", new C1499b());
        this.dmMessage.b("remove_show_message", new C1500c());
        this.dmMessage.b("topbar_delay_hide", new C1501d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773502106")) {
            ipChange.ipc$dispatch("-773502106", new Object[]{this});
        } else {
            this.mHandler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTopBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247357062")) {
            ipChange.ipc$dispatch("1247357062", new Object[]{this});
        } else if (this.mDataHolder.c().b()) {
            setVisibility(0);
            topBarDelayHide();
        }
    }

    private void smallScreen() {
        xs xsVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841913590")) {
            ipChange.ipc$dispatch("841913590", new Object[]{this});
            return;
        }
        if (this.mUTReportListener != null && (xsVar = this.mDataHolder) != null && xsVar.e() != null) {
            this.mUTReportListener.returnSmallScreen(this.mDataHolder.e().getVid());
        }
        this.mController.onScreenModeChanged(false);
        this.mPlayer.exitFullScreen();
    }

    public void hideTopBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2137777121")) {
            ipChange.ipc$dispatch("2137777121", new Object[]{this});
        } else {
            setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412673586")) {
            ipChange.ipc$dispatch("1412673586", new Object[]{this, view});
        } else if (view.getId() == R$id.yk_player_back_btn) {
            smallScreen();
        }
    }

    public void registerUTPlayerListener(OnPlayerUTReportListener onPlayerUTReportListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579626152")) {
            ipChange.ipc$dispatch("1579626152", new Object[]{this, onPlayerUTReportListener});
        } else {
            this.mUTReportListener = onPlayerUTReportListener;
        }
    }

    public void setIVideoController(IVideoController iVideoController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1082506895")) {
            ipChange.ipc$dispatch("1082506895", new Object[]{this, iVideoController});
        } else {
            this.mController = iVideoController;
        }
    }

    public void setVisibilityByScreenMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122347983")) {
            ipChange.ipc$dispatch("122347983", new Object[]{this});
        } else if (this.mDataHolder.c().b()) {
            removeMessage();
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void topBarDelayHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193332802")) {
            ipChange.ipc$dispatch("193332802", new Object[]{this});
            return;
        }
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }
}
