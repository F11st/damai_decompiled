package tb;

import android.view.View;
import cn.damai.player.DMVideoPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.playerservice.axp.axpinterface.PlayerAction;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.youkuplayer.IYoukuPlayer;
import com.youku.youkuplayer.YKEventListener;
import com.youku.youkuplayer.YoukuPlayer;
import com.youku.youkuplayer.data.PlayParam;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class w01 extends YoukuPlayer {
    private static transient /* synthetic */ IpChange $ipChange;
    IYoukuPlayer a;
    private boolean b = false;

    public w01(IYoukuPlayer iYoukuPlayer) {
        this.a = iYoukuPlayer;
    }

    public boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-338617548") ? ((Boolean) ipChange.ipc$dispatch("-338617548", new Object[]{this})).booleanValue() : this.b;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void addPlayerEventListener(YKEventListener yKEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "56780301")) {
            ipChange.ipc$dispatch("56780301", new Object[]{this, yKEventListener});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.addPlayerEventListener(yKEventListener);
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public Object doAction(PlayerAction playerAction, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004681009")) {
            return ipChange.ipc$dispatch("1004681009", new Object[]{this, playerAction, map});
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.doAction(playerAction, map);
        }
        return null;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public long getCurrentPosition() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966019067")) {
            return ((Long) ipChange.ipc$dispatch("-966019067", new Object[]{this})).longValue();
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public Quality getCurrentQuality() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-859140052")) {
            return (Quality) ipChange.ipc$dispatch("-859140052", new Object[]{this});
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getCurrentQuality();
        }
        return null;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public int getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351752842")) {
            return ((Integer) ipChange.ipc$dispatch("-351752842", new Object[]{this})).intValue();
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getDuration();
        }
        return 0;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public PlayInfo getPlayInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102690236")) {
            return (PlayInfo) ipChange.ipc$dispatch("102690236", new Object[]{this});
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getPlayInfo();
        }
        return null;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public String getSessionId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175059262")) {
            return (String) ipChange.ipc$dispatch("175059262", new Object[]{this});
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getSessionId();
        }
        return null;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public int getVideoHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "933381956")) {
            return ((Integer) ipChange.ipc$dispatch("933381956", new Object[]{this})).intValue();
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public int getVideoWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-473705185")) {
            return ((Integer) ipChange.ipc$dispatch("-473705185", new Object[]{this})).intValue();
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286901140")) {
            return (View) ipChange.ipc$dispatch("286901140", new Object[]{this});
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.getView();
        }
        return null;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public boolean isMuted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227836720")) {
            return ((Boolean) ipChange.ipc$dispatch("-1227836720", new Object[]{this})).booleanValue();
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            return iYoukuPlayer.isMuted();
        }
        return false;
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public boolean isPaused() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "258923305") ? ((Boolean) ipChange.ipc$dispatch("258923305", new Object[]{this})).booleanValue() : this.a.isPaused();
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public boolean isStarted() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2086575238") ? ((Boolean) ipChange.ipc$dispatch("-2086575238", new Object[]{this})).booleanValue() : this.a.isStarted();
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558314263")) {
            ipChange.ipc$dispatch("1558314263", new Object[]{this});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.pause();
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void playVideo(PlayParam playParam) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308905336")) {
            ipChange.ipc$dispatch("-308905336", new Object[]{this, playParam});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            this.b = true;
            iYoukuPlayer.playVideo(playParam);
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474428774")) {
            ipChange.ipc$dispatch("1474428774", new Object[]{this});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.release();
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void seekTo(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522561317")) {
            ipChange.ipc$dispatch("-522561317", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.seekTo(i, z);
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void setMuted(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12411648")) {
            ipChange.ipc$dispatch("12411648", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.setMuted(z);
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void setPositionFrenquency(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843954151")) {
            ipChange.ipc$dispatch("-843954151", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601419051")) {
            ipChange.ipc$dispatch("1601419051", new Object[]{this});
        } else if (this.a != null) {
            cb1.c(DMVideoPlayer.TAG, "player start : getSessionId=" + this.a.getSessionId());
            this.a.start();
        } else {
            cb1.c(DMVideoPlayer.TAG, "player 为null");
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321017893")) {
            ipChange.ipc$dispatch("-1321017893", new Object[]{this});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.stop();
        }
    }

    @Override // com.youku.youkuplayer.YoukuPlayer, com.youku.youkuplayer.IYoukuPlayer
    public void switchQuality(Quality quality) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "503263305")) {
            ipChange.ipc$dispatch("503263305", new Object[]{this, quality});
            return;
        }
        IYoukuPlayer iYoukuPlayer = this.a;
        if (iYoukuPlayer != null) {
            iYoukuPlayer.switchQuality(quality);
        }
    }
}
