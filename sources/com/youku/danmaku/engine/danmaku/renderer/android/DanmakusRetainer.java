package com.youku.danmaku.engine.danmaku.renderer.android;

import android.text.TextUtils;
import com.youku.danmaku.engine.danmaku.model.BaseDanmaku;
import com.youku.danmaku.engine.danmaku.model.IDisplayer;
import com.youku.danmaku.engine.danmaku.model.danmaku.R2LDanmaku;
import com.youku.danmaku.plugin.IDanmakuLayoutPlugin;
import com.youku.danmaku.plugin.IDanmakuSettingPlugin;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DanmakusRetainer {
    private IDanmakusRetainer fbdrInstance;
    private IDanmakusRetainer ftdrInstance;
    private IDanmakusRetainer lrdrInstance;
    private IDanmakuLayoutPlugin mDanmakuLayoutPlugin;
    private IDanmakuSettingPlugin mDanmakuSettingPlugin;
    private IDanmakusRetainer rldrInstance;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    static class FixResult {
        int mLine = 0;
        boolean mWillHit = false;
        boolean mIsOutOfVerticalEdge = true;
        float mTopPos = 0.0f;
        boolean shown = false;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface IDanmakusRetainer {
        void clear();

        void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, Verifier verifier);
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class RetainerState {
        public int lines = 0;
        BaseDanmaku insertItem = null;
        BaseDanmaku firstItem = null;
        BaseDanmaku lastItem = null;
        BaseDanmaku minRightRow = null;
        BaseDanmaku removeItem = null;
        BaseDanmaku minBotttom = null;
        boolean overwriteInsert = false;
        boolean shown = false;
        boolean willHit = false;

        public String log() {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.LF);
            sb.append("lines:");
            sb.append(this.lines);
            sb.append(StringUtils.LF);
            sb.append("overwriteInsert:");
            sb.append(this.overwriteInsert);
            sb.append(StringUtils.LF);
            sb.append("shown:");
            sb.append(this.shown);
            sb.append(StringUtils.LF);
            sb.append("willHit:");
            sb.append(this.willHit);
            sb.append(StringUtils.LF);
            BaseDanmaku baseDanmaku = this.insertItem;
            if (baseDanmaku != null && !TextUtils.isEmpty(baseDanmaku.text)) {
                sb.append("insertItem:");
                sb.append(this.insertItem.text);
                sb.append(StringUtils.LF);
            } else {
                sb.append("insertItem:");
                sb.append("null");
                sb.append(StringUtils.LF);
            }
            BaseDanmaku baseDanmaku2 = this.firstItem;
            if (baseDanmaku2 != null && !TextUtils.isEmpty(baseDanmaku2.text)) {
                sb.append("firstItem:");
                sb.append(this.firstItem.text);
                sb.append(StringUtils.LF);
            } else {
                sb.append("firstItem:");
                sb.append("null");
                sb.append(StringUtils.LF);
            }
            BaseDanmaku baseDanmaku3 = this.lastItem;
            if (baseDanmaku3 != null && !TextUtils.isEmpty(baseDanmaku3.text)) {
                sb.append("lastItem:");
                sb.append(this.lastItem.text);
                sb.append(StringUtils.LF);
            } else {
                sb.append("lastItem:");
                sb.append("null");
                sb.append(StringUtils.LF);
            }
            BaseDanmaku baseDanmaku4 = this.minRightRow;
            if (baseDanmaku4 != null && !TextUtils.isEmpty(baseDanmaku4.text)) {
                sb.append("minRightRow:");
                sb.append(this.minRightRow.text);
                sb.append(StringUtils.LF);
            } else {
                sb.append("minRightRow:");
                sb.append("null");
                sb.append(StringUtils.LF);
            }
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Verifier {
        boolean skipLayout(BaseDanmaku baseDanmaku, float f, int i, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DanmakusRetainer(IDanmakuLayoutPlugin iDanmakuLayoutPlugin, IDanmakuSettingPlugin iDanmakuSettingPlugin) {
        this.rldrInstance = null;
        this.lrdrInstance = null;
        this.ftdrInstance = null;
        this.fbdrInstance = null;
        this.mDanmakuLayoutPlugin = iDanmakuLayoutPlugin;
        this.mDanmakuSettingPlugin = iDanmakuSettingPlugin;
        if (iDanmakuSettingPlugin != null && iDanmakuSettingPlugin.isNewTypesetting()) {
            this.rldrInstance = new RLDanmakusNewRetainer(this.mDanmakuSettingPlugin);
        } else {
            IDanmakuSettingPlugin iDanmakuSettingPlugin2 = this.mDanmakuSettingPlugin;
            if (iDanmakuSettingPlugin2 != null && iDanmakuSettingPlugin2.isNewCompose()) {
                this.rldrInstance = new RLDanmakusLineRetainer(this.mDanmakuSettingPlugin);
            } else {
                this.rldrInstance = new RLDanmakusRetainer();
            }
        }
        if (this.lrdrInstance == null) {
            this.lrdrInstance = new RLDanmakusRetainer();
        }
        if (this.ftdrInstance == null) {
            this.ftdrInstance = new FTDanmakusRetainer();
        }
        if (this.fbdrInstance == null) {
            this.fbdrInstance = new FBDanmakusRetainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeSpeed(float f, float f2) {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer instanceof RLDanmakusNewRetainer) {
            ((RLDanmakusNewRetainer) iDanmakusRetainer).changeSpeed(f, f2);
        } else if (iDanmakusRetainer instanceof RLDanmakusLineRetainer) {
            ((RLDanmakusLineRetainer) iDanmakusRetainer).changeSpeed(f, f2);
        }
    }

    public void clear() {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer != null) {
            iDanmakusRetainer.clear();
        }
        IDanmakusRetainer iDanmakusRetainer2 = this.lrdrInstance;
        if (iDanmakusRetainer2 != null) {
            iDanmakusRetainer2.clear();
        }
        IDanmakusRetainer iDanmakusRetainer3 = this.ftdrInstance;
        if (iDanmakusRetainer3 != null) {
            iDanmakusRetainer3.clear();
        }
        IDanmakusRetainer iDanmakusRetainer4 = this.fbdrInstance;
        if (iDanmakusRetainer4 != null) {
            iDanmakusRetainer4.clear();
        }
        IDanmakuLayoutPlugin iDanmakuLayoutPlugin = this.mDanmakuLayoutPlugin;
        if (iDanmakuLayoutPlugin != null) {
            iDanmakuLayoutPlugin.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fix(BaseDanmaku baseDanmaku, IDisplayer iDisplayer, Verifier verifier) {
        int type = baseDanmaku.getType();
        IDanmakuLayoutPlugin iDanmakuLayoutPlugin = this.mDanmakuLayoutPlugin;
        IDanmakusRetainer danmakuLayout = iDanmakuLayoutPlugin != null ? iDanmakuLayoutPlugin.getDanmakuLayout(baseDanmaku) : null;
        if (danmakuLayout != null) {
            danmakuLayout.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 1) {
            this.rldrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 4) {
            this.fbdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 5) {
            this.ftdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 6) {
            this.lrdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type != 7) {
        } else {
            baseDanmaku.layout(iDisplayer, 0.0f, 0.0f);
        }
    }

    public void release() {
        clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showVisibleDanmakuLog() {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer instanceof RLDanmakusNewRetainer) {
            ((RLDanmakusNewRetainer) iDanmakusRetainer).showVisibleDanmakuLog();
        } else if (iDanmakusRetainer instanceof RLDanmakusLineRetainer) {
            ((RLDanmakusLineRetainer) iDanmakusRetainer).showVisibleDanmakuLog();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeSpeed(R2LDanmaku r2LDanmaku) {
        IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer instanceof RLDanmakusNewRetainer) {
            ((RLDanmakusNewRetainer) iDanmakusRetainer).changeSpeed(r2LDanmaku);
        } else if (iDanmakusRetainer instanceof RLDanmakusLineRetainer) {
            ((RLDanmakusLineRetainer) iDanmakusRetainer).changeSpeed(r2LDanmaku);
        }
    }
}
