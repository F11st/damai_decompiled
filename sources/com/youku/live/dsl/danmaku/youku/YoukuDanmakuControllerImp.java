package com.youku.live.dsl.danmaku.youku;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.config.LoginSwitch;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.Duration;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;
import com.youku.danmaku.engine.ui.widget.DanmakuView;
import com.youku.live.arch.Arch;
import com.youku.live.arch.utils.ContextUtils;
import com.youku.live.dsl.danmaku.DanmakuControllerConfig;
import com.youku.live.dsl.danmaku.DanmakuItem;
import com.youku.live.dsl.danmaku.IDanmakuController;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuDanmakuControllerImp implements IDanmakuController {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile AtomicInteger indexCached;
    private BaseCacheStuffer.Proxy mCacheStufferAdapter;
    private Context mContext;
    private DanmakuContext mDanmakuContext;
    private IDanmakuView mDanmakuInstance;
    private DrawHandlerCallback mDrawHandlerCallback;
    private volatile Duration mDuration;
    private Handler mHandler;
    private boolean mIsPause = false;
    private int POST_DELAY_TIME = 300;
    private int DANMU_OFFSET = 300;
    private int DANMU_DURATION = LoginSwitch.LOGOUT_POST_DEFAULT;
    private long timeCache = 0;
    private long lastDanmakuTime = 0;

    public YoukuDanmakuControllerImp(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private synchronized void addDanmuImp(IDanmakuData iDanmakuData) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "629032844")) {
            ipChange.ipc$dispatch("629032844", new Object[]{this, iDanmakuData});
            return;
        }
        if (iDanmakuData != null && this.mHandler != null) {
            BaseDanmaku createDanmaku = this.mDanmakuContext.mDanmakuFactory.createDanmaku(1);
            IDanmakuView iDanmakuView = this.mDanmakuInstance;
            if (createDanmaku != null && iDanmakuView != null) {
                createDanmaku.index = getItemIndexInc();
                createDanmaku.tag = iDanmakuData;
                createDanmaku.text = iDanmakuData.getText();
                if (!iDanmakuData.isShowImmediately()) {
                    i = 0;
                }
                createDanmaku.priority = (byte) i;
                createDanmaku.isLive = false;
                long currentTime = iDanmakuView.getCurrentTime();
                createDanmaku.time = currentTime;
                long j = this.lastDanmakuTime;
                int i2 = this.DANMU_OFFSET;
                if (currentTime - j < i2) {
                    createDanmaku.time = j + i2;
                }
                long j2 = createDanmaku.time;
                this.timeCache = j2;
                if (!iDanmakuData.isShowImmediately()) {
                    if (this.timeCache - this.DANMU_DURATION > this.mDrawHandlerCallback.getTimeShown()) {
                        return;
                    }
                } else {
                    createDanmaku.setDanmakuLine(createDanmaku.index % 3);
                }
                this.lastDanmakuTime = j2;
                createDanmaku.textSize = ContextUtils.dip2px(Arch.getApp(), iDanmakuData.getFontSize());
                createDanmaku.textColor = iDanmakuData.getFontColor();
                createDanmaku.textShadowColor = iDanmakuData.getFontBorderColor();
                createDanmaku.duration = getDuration();
                Message obtainMessage = this.mHandler.obtainMessage();
                obtainMessage.obj = createDanmaku;
                this.mHandler.sendMessageDelayed(obtainMessage, this.POST_DELAY_TIME);
            }
        }
    }

    private void addDanmuInternal(IDanmakuData iDanmakuData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83560327")) {
            ipChange.ipc$dispatch("83560327", new Object[]{this, iDanmakuData});
            return;
        }
        try {
            addDanmuImp(iDanmakuData);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private synchronized Duration getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494317670")) {
            return (Duration) ipChange.ipc$dispatch("1494317670", new Object[]{this});
        }
        if (this.mDuration == null) {
            this.mDuration = new Duration(this.DANMU_DURATION);
        }
        return this.mDuration;
    }

    private int getItemIndexInc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1877251824")) {
            return ((Integer) ipChange.ipc$dispatch("-1877251824", new Object[]{this})).intValue();
        }
        if (this.indexCached == null) {
            synchronized (this) {
                if (this.indexCached == null) {
                    this.indexCached = new AtomicInteger(0);
                }
            }
        }
        return this.indexCached.incrementAndGet();
    }

    private void initDanmaku(DanmakuControllerConfig danmakuControllerConfig) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495131114")) {
            ipChange.ipc$dispatch("-1495131114", new Object[]{this, danmakuControllerConfig});
            return;
        }
        int intValue = (danmakuControllerConfig == null || (num = danmakuControllerConfig.maxLines) == null) ? 3 : num.intValue();
        HashMap hashMap = new HashMap(1);
        hashMap.put(1, Integer.valueOf(intValue));
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put(1, Boolean.TRUE);
        this.mCacheStufferAdapter = new BaseCacheStufferProxy();
        this.mDanmakuContext = DanmakuContext.create().setDanmakuStyle(2, 3.0f).setDanmakuBold(false).setDuplicateMergingEnabled(false).setScrollSpeedFactor(1.2f).setScaleTextSize(1.0f).setCacheStuffer(new BackgroundCacheStufferNew(this.mContext.getResources().getDisplayMetrics().density, true), this.mCacheStufferAdapter).setMaximumLines(hashMap).preventOverlapping(hashMap2);
    }

    private void initDanmakuView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915765266")) {
            ipChange.ipc$dispatch("-1915765266", new Object[]{this});
            return;
        }
        DanmakuView danmakuView = new DanmakuView(this.mContext);
        this.mDanmakuInstance = danmakuView;
        danmakuView.prepare(new DanmakuParser(), this.mDanmakuContext);
        this.mDanmakuInstance.enableDanmakuDrawingCache(true);
        DrawHandlerCallback drawHandlerCallback = new DrawHandlerCallback(this.mDanmakuInstance);
        this.mDrawHandlerCallback = drawHandlerCallback;
        this.mDanmakuInstance.setCallback(drawHandlerCallback);
    }

    private void initHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096225208")) {
            ipChange.ipc$dispatch("1096225208", new Object[]{this});
        } else {
            this.mHandler = new DanmakuHandler(this.mDanmakuInstance);
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void addDanmu(DanmakuItem danmakuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713116718")) {
            ipChange.ipc$dispatch("1713116718", new Object[]{this, danmakuItem});
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void addDanmu(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1460805787")) {
            ipChange.ipc$dispatch("-1460805787", new Object[]{this, map});
        } else {
            addDanmuInternal(new DanmakuData(map));
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void addDanmuOld(DanmakuItem danmakuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790702225")) {
            ipChange.ipc$dispatch("1790702225", new Object[]{this, danmakuItem});
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void clearDanmu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "694187276")) {
            ipChange.ipc$dispatch("694187276", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView != null) {
            iDanmakuView.clearDanmakusOnScreen();
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687967144")) {
            ipChange.ipc$dispatch("-687967144", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView != null) {
            iDanmakuView.release();
            this.mDanmakuInstance = null;
            this.mIsPause = false;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public View getView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785958937")) {
            return (View) ipChange.ipc$dispatch("1785958937", new Object[]{this});
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView != null) {
            return iDanmakuView.getView();
        }
        return null;
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942831370")) {
            ipChange.ipc$dispatch("-942831370", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView != null) {
            iDanmakuView.hide();
        }
    }

    public YoukuDanmakuControllerImp initWithControllerConfig(DanmakuControllerConfig danmakuControllerConfig) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377824571")) {
            return (YoukuDanmakuControllerImp) ipChange.ipc$dispatch("377824571", new Object[]{this, danmakuControllerConfig});
        }
        initDanmaku(danmakuControllerConfig);
        initDanmakuView();
        initHandler();
        return this;
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409042916")) {
            ipChange.ipc$dispatch("-409042916", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView == null || !iDanmakuView.isPrepared()) {
            return;
        }
        iDanmakuView.pause();
        iDanmakuView.removeAllDanmakus();
        this.mIsPause = true;
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1852357995")) {
            ipChange.ipc$dispatch("1852357995", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView == null || !iDanmakuView.isPrepared()) {
            return;
        }
        if (iDanmakuView.isPaused() || this.mIsPause) {
            iDanmakuView.resume();
            this.mIsPause = false;
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void setMaximumLines(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082899086")) {
            ipChange.ipc$dispatch("-1082899086", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211840347")) {
            ipChange.ipc$dispatch("211840347", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView != null) {
            iDanmakuView.show();
        }
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555181622")) {
            ipChange.ipc$dispatch("555181622", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuInstance;
        if (iDanmakuView == null || !iDanmakuView.isPrepared()) {
            return;
        }
        iDanmakuView.stop();
    }
}
