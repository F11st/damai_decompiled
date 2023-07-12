package com.youku.live.dsl.danmaku.laifeng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.danmaku.engine.controller.DrawHandler;
import com.youku.danmaku.engine.controller.IDanmakuView;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.DanmakuTimer;
import com.youku.danmaku.engine.danmaku.model.android.AndroidDisplayer;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuContext;
import com.youku.danmaku.engine.danmaku.model.android.Danmakus;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer;
import com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer;
import com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser;
import com.youku.live.dsl.danmaku.DanmakuItem;
import com.youku.live.dsl.danmaku.IDanmakuController;
import java.util.HashMap;
import java.util.Map;
import tb.cq;
import tb.nh0;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IDanmaControllerImp implements DrawHandler.Callback, IDanmakuController {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DanmaController";
    private static int mDanmuBgColor = 1291845632;
    private long lastDanmuTime;
    private Context mContext;
    private DanmakuContext mDanmakuContext;
    private IDanmakuView mDanmakuView;
    private int mDanmuRows = 3;
    private Handler mHandler = new Handler();
    private BaseCacheStuffer.Proxy mCacheStufferAdapter = new BaseCacheStuffer.Proxy() { // from class: com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp.4
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer.Proxy
        public void prepareDrawing(BaseDanmaku baseDanmaku, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1916220698")) {
                ipChange.ipc$dispatch("-1916220698", new Object[]{this, baseDanmaku, Boolean.valueOf(z)});
            }
        }

        @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer.Proxy
        public void releaseResource(BaseDanmaku baseDanmaku) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2112859024")) {
                ipChange.ipc$dispatch("2112859024", new Object[]{this, baseDanmaku});
            } else if (baseDanmaku.text instanceof Spanned) {
                baseDanmaku.text = "";
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class BackgroundCacheStuffer extends SpannedCacheStuffer {
        private static transient /* synthetic */ IpChange $ipChange;
        int DANMU_PADDING_INNER;
        int DANMU_RADIUS;
        private Context mContext;

        BackgroundCacheStuffer(Context context) {
            this.mContext = context;
            this.DANMU_RADIUS = IDanmaControllerImp.dip2px(context, 12);
            this.DANMU_PADDING_INNER = IDanmaControllerImp.dip2px(this.mContext, 3);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
        public void drawBackground(BaseDanmaku baseDanmaku, Canvas canvas, float f, float f2, AndroidDisplayer.DisplayConfig displayConfig) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-81233767")) {
                ipChange.ipc$dispatch("-81233767", new Object[]{this, baseDanmaku, canvas, Float.valueOf(f), Float.valueOf(f2), displayConfig});
                return;
            }
            super.drawBackground(baseDanmaku, canvas, f, f2, displayConfig);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(this.DANMU_RADIUS);
            gradientDrawable.setColor(IDanmaControllerImp.mDanmuBgColor);
            gradientDrawable.setBounds(new Rect(0, 0, (int) baseDanmaku.paintWidth, (int) baseDanmaku.paintHeight));
            gradientDrawable.draw(canvas);
        }

        @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer
        public void drawStroke(BaseDanmaku baseDanmaku, String str, Canvas canvas, float f, float f2, Paint paint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-590459234")) {
                ipChange.ipc$dispatch("-590459234", new Object[]{this, baseDanmaku, str, canvas, Float.valueOf(f), Float.valueOf(f2), paint});
            }
        }

        @Override // com.youku.danmaku.engine.danmaku.model.android.stuffer.SpannedCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.SimpleTextCacheStuffer, com.youku.danmaku.engine.danmaku.model.android.stuffer.BaseCacheStuffer
        public void measure(BaseDanmaku baseDanmaku, TextPaint textPaint, boolean z, AndroidDisplayer.DisplayConfig displayConfig) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1430842612")) {
                ipChange.ipc$dispatch("-1430842612", new Object[]{this, baseDanmaku, textPaint, Boolean.valueOf(z), displayConfig});
            } else {
                super.measure(baseDanmaku, textPaint, z, displayConfig);
            }
        }
    }

    public IDanmaControllerImp(Context context) {
        this.mContext = context.getApplicationContext();
        initDanmuConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder createSpannable(Drawable drawable, DanmakuItem danmakuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790936536")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("1790936536", new Object[]{this, drawable, danmakuItem});
        }
        String str = danmakuItem.nickName;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("bitmap");
        spannableStringBuilder.setSpan(new CenteredImageSpan(drawable, dip2px(this.mContext, 23)), 0, 6, 33);
        if (!TextUtils.isEmpty(danmakuItem.content)) {
            spannableStringBuilder.append((CharSequence) " ");
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#fff7c0")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.append(danmakuItem.content);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dip2px(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-705984252")) {
            return ((Integer) ipChange.ipc$dispatch("-705984252", new Object[]{context, Integer.valueOf(i)})).intValue();
        }
        if (context == null) {
            return 0;
        }
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initDanmuConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655421798")) {
            ipChange.ipc$dispatch("-655421798", new Object[]{this});
        } else {
            this.mDanmakuContext = DanmakuContext.create().setDanmakuStyle(0, new float[0]).setDuplicateMergingEnabled(false).setScrollSpeedFactor(2.0f).setScaleTextSize(1.0f).setCacheStuffer(new BackgroundCacheStuffer(this.mContext), this.mCacheStufferAdapter).setMaximumLines(new HashMap<Integer, Integer>() { // from class: com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp.2
                {
                    put(1, Integer.valueOf(IDanmaControllerImp.this.mDanmuRows));
                }
            }).preventOverlapping(new HashMap<Integer, Boolean>() { // from class: com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp.1
                {
                    put(1, Boolean.FALSE);
                }
            });
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void addDanmu(DanmakuItem danmakuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453700805")) {
            ipChange.ipc$dispatch("-1453700805", new Object[]{this, danmakuItem});
            return;
        }
        BaseDanmaku createDanmaku = this.mDanmakuContext.mDanmakuFactory.createDanmaku(1);
        try {
            createDanmaku.priority = (byte) 1;
            createDanmaku.isLive = false;
            createDanmaku.isGuest = danmakuItem.isGuest;
            createDanmaku.text = danmakuItem.content;
            int i = danmakuItem.danmuConfig.textSize;
            if (i <= 0) {
                i = dip2px(this.mContext, 9);
            }
            createDanmaku.textSize = i;
            createDanmaku.padding = dip2px(this.mContext, 3);
            createDanmaku.textColor = -1;
            createDanmaku.borderColor = 0;
            mDanmuBgColor = danmakuItem.danmuConfig.danmuBg;
            IDanmakuView iDanmakuView = this.mDanmakuView;
            if (iDanmakuView != null) {
                long currentTime = iDanmakuView.getCurrentTime() + 500;
                createDanmaku.time = currentTime;
                long j = this.lastDanmuTime;
                if (currentTime - j < 3000) {
                    createDanmaku.time = j + 3000;
                }
                this.lastDanmuTime = createDanmaku.time;
                this.mDanmakuView.addDanmaku(createDanmaku);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void addDanmu(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396517448")) {
            ipChange.ipc$dispatch("-396517448", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void addDanmuOld(final DanmakuItem danmakuItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913468828")) {
            ipChange.ipc$dispatch("-1913468828", new Object[]{this, danmakuItem});
            return;
        }
        final BaseDanmaku createDanmaku = this.mDanmakuContext.mDanmakuFactory.createDanmaku(1);
        createDanmaku.isGuest = danmakuItem.isGuest;
        final SpannableStringBuilder[] spannableStringBuilderArr = new SpannableStringBuilder[1];
        ur1.o().s(danmakuItem.avatarUrl).h(new cq()).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(ui2 ui2Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-418897118")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-418897118", new Object[]{this, ui2Var})).booleanValue();
                }
                try {
                    BitmapDrawable f = ui2Var.f();
                    f.setBounds(0, 0, IDanmaControllerImp.dip2px(IDanmaControllerImp.this.mContext, 23), IDanmaControllerImp.dip2px(IDanmaControllerImp.this.mContext, 23));
                    spannableStringBuilderArr[0] = IDanmaControllerImp.this.createSpannable(f, danmakuItem);
                    BaseDanmaku baseDanmaku = createDanmaku;
                    baseDanmaku.text = spannableStringBuilderArr[0];
                    baseDanmaku.padding = IDanmaControllerImp.dip2px(IDanmaControllerImp.this.mContext, 8);
                    BaseDanmaku baseDanmaku2 = createDanmaku;
                    baseDanmaku2.priority = (byte) 1;
                    baseDanmaku2.isLive = false;
                    baseDanmaku2.textSize = IDanmaControllerImp.dip2px(IDanmaControllerImp.this.mContext, 13);
                    BaseDanmaku baseDanmaku3 = createDanmaku;
                    baseDanmaku3.textColor = -1;
                    baseDanmaku3.textShadowColor = 0;
                    if (IDanmaControllerImp.this.mDanmakuView != null) {
                        createDanmaku.time = IDanmaControllerImp.this.mDanmakuView.getCurrentTime() + 500;
                        if (createDanmaku.time - IDanmaControllerImp.this.lastDanmuTime < 3000) {
                            createDanmaku.time = IDanmaControllerImp.this.lastDanmuTime + 3000;
                        }
                        IDanmaControllerImp.this.lastDanmuTime = createDanmaku.time;
                        IDanmaControllerImp.this.mDanmakuView.addDanmaku(createDanmaku);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        }).m(new IPhenixListener<nh0>() { // from class: com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(nh0 nh0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1443274365")) {
                    return ((Boolean) ipChange2.ipc$dispatch("1443274365", new Object[]{this, nh0Var})).booleanValue();
                }
                return false;
            }
        }).n();
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void clearDanmu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467642841")) {
            ipChange.ipc$dispatch("467642841", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null) {
            iDanmakuView.clearDanmakusOnScreen();
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void danmakuShown(BaseDanmaku baseDanmaku) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11082861")) {
            ipChange.ipc$dispatch("-11082861", new Object[]{this, baseDanmaku});
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576243029")) {
            ipChange.ipc$dispatch("-576243029", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null) {
            iDanmakuView.release();
            this.mDanmakuView = null;
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void drawingFinished() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859343925")) {
            ipChange.ipc$dispatch("859343925", new Object[]{this});
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1930131028") ? (View) ipChange.ipc$dispatch("-1930131028", new Object[]{this}) : this.mDanmakuView.getView();
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64199555")) {
            ipChange.ipc$dispatch("64199555", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null) {
            iDanmakuView.hide();
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744144687")) {
            ipChange.ipc$dispatch("744144687", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView == null || !iDanmakuView.isPrepared()) {
            return;
        }
        this.mDanmakuView.pause();
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void prepared() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12159320")) {
            ipChange.ipc$dispatch("-12159320", new Object[]{this});
        } else {
            this.mDanmakuView.start();
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053531976")) {
            ipChange.ipc$dispatch("-1053531976", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null && iDanmakuView.isPrepared() && this.mDanmakuView.isPaused()) {
            this.mDanmakuView.resume();
        }
    }

    public void setDanmakuView(IDanmakuView iDanmakuView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "837421405")) {
            ipChange.ipc$dispatch("837421405", new Object[]{this, iDanmakuView});
            return;
        }
        this.mDanmakuView = iDanmakuView;
        if (iDanmakuView != null) {
            iDanmakuView.setCallback(this);
            this.mDanmakuView.prepare(new BaseDanmakuParser() { // from class: com.youku.live.dsl.danmaku.laifeng.IDanmaControllerImp.3
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.youku.danmaku.engine.danmaku.parser.BaseDanmakuParser
                public Danmakus parse() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-2033480527") ? (Danmakus) ipChange2.ipc$dispatch("-2033480527", new Object[]{this}) : new Danmakus();
                }
            }, this.mDanmakuContext);
            this.mDanmakuView.enableDanmakuDrawingCache(true);
            this.mDanmakuView.show();
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void setMaximumLines(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1223037825")) {
            ipChange.ipc$dispatch("-1223037825", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDanmuRows = i;
        }
    }

    @Override // com.youku.live.dsl.danmaku.IDanmakuController
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218871272")) {
            ipChange.ipc$dispatch("1218871272", new Object[]{this});
            return;
        }
        IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null) {
            iDanmakuView.show();
        }
    }

    @Override // com.youku.danmaku.engine.controller.DrawHandler.Callback
    public void updateTimer(DanmakuTimer danmakuTimer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080165885")) {
            ipChange.ipc$dispatch("-1080165885", new Object[]{this, danmakuTimer});
        }
    }
}
