package cn.damai.player.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.soloader.C0522a;
import cn.damai.common.soloader.reporter.SoLoadMonitor;
import cn.damai.player.base.IVideoController;
import cn.damai.player.base.IVideoPlayer;
import cn.damai.videoplayer.R$id;
import cn.damai.videoplayer.R$layout;
import cn.damai.videoplayer.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ef0;
import tb.xs;
import tb.ys;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DMVideoPlayerDefaultErrorView extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private FragmentActivity mActivity;
    private IVideoController mController;
    private xs mDataHolder;
    private TextView mErrorTips;
    private IVideoPlayer mPlayer;
    private TextView mRefreshBtn;

    public DMVideoPlayerDefaultErrorView(FragmentActivity fragmentActivity, IVideoPlayer iVideoPlayer) {
        super(fragmentActivity);
        this.mActivity = fragmentActivity;
        this.mPlayer = iVideoPlayer;
        this.mDataHolder = ys.d().c();
        initErrorView();
    }

    private void handleErrorBtnClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "231087338")) {
            ipChange.ipc$dispatch("231087338", new Object[]{this});
            return;
        }
        int a = this.mDataHolder.c().a();
        if (a != 17 || C0522a.a().b()) {
            if (a == 8) {
                this.mPlayer.play();
            } else {
                this.mPlayer.play();
            }
        }
    }

    private void initErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "73005017")) {
            ipChange.ipc$dispatch("73005017", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R$layout.yk_player_error_view, this);
        this.mErrorTips = (TextView) inflate.findViewById(R$id.yk_player_error_tips);
        TextView textView = (TextView) inflate.findViewById(R$id.yk_player_error_refresh);
        this.mRefreshBtn = textView;
        textView.setOnClickListener(this);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365697509")) {
            ipChange.ipc$dispatch("1365697509", new Object[]{this, view});
        } else if (view.getId() == R$id.yk_player_error_refresh) {
            handleErrorBtnClick();
        }
    }

    public void onGetVideoInfoFailed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580506469")) {
            ipChange.ipc$dispatch("580506469", new Object[]{this});
            return;
        }
        this.mErrorTips.setText(ef0.b(this.mActivity));
        setVisibility(0);
    }

    public void onPlayerError() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606047410")) {
            ipChange.ipc$dispatch("-1606047410", new Object[]{this});
            return;
        }
        this.mErrorTips.setText(ef0.a(this.mActivity, 0));
        this.mRefreshBtn.setText("点击刷新");
        setVisibility(0);
    }

    public void onSoLoadFailed(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9491042")) {
            ipChange.ipc$dispatch("-9491042", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            SoLoadMonitor.a(SoLoadMonitor.MonitorType.PLAYER_RETRY_FAILED);
        } else {
            SoLoadMonitor.a(SoLoadMonitor.MonitorType.PLAYER_PLAY_FAILED);
        }
        if (this.mDataHolder.c().a() == 17 || this.mDataHolder.c().a() == 20) {
            this.mErrorTips.setText(this.mActivity.getString(R$string.error_tips));
            this.mRefreshBtn.setText("重新加载");
        }
        setVisibility(0);
    }

    public void setIVideoController(IVideoController iVideoController) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1442486718")) {
            ipChange.ipc$dispatch("-1442486718", new Object[]{this, iVideoController});
        } else {
            this.mController = iVideoController;
        }
    }
}
