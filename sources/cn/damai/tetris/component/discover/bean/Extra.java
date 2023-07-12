package cn.damai.tetris.component.discover.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Extra implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HW_RATIO = "hwRatio";
    public static final String POS = "pos";
    public static final String TYPE_MARKET = "3";
    public static final String TYPE_NOTE = "1";
    public static final String TYPE_THEME = "2";
    public String alg;
    public Object extra;
    private HashMap<String, Object> extraMap;
    public int pos;
    public String type;
    public VideoInfo videoInfo;
    public boolean highLight = false;
    @JSONField(name = "hwRatio")
    public float hwRatio = 1.0f;
    public int colorIndex = -1;

    public String getCardType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1825860093")) {
            return (String) ipChange.ipc$dispatch("1825860093", new Object[]{this});
        }
        if (TextUtils.equals("1", this.type)) {
            return "note";
        }
        if (TextUtils.equals("2", this.type)) {
            return "theme";
        }
        if (TextUtils.equals("3", this.type)) {
            return "营销";
        }
        return null;
    }

    @Nullable
    public Object getExtraObj(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861795682")) {
            return ipChange.ipc$dispatch("861795682", new Object[]{this, str});
        }
        if (cb2.f(this.extraMap)) {
            return null;
        }
        return this.extraMap.get(str);
    }

    public float getHwRatio() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-782886287") ? ((Float) ipChange.ipc$dispatch("-782886287", new Object[]{this})).floatValue() : this.hwRatio;
    }

    public String getVideoCoverUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102153130")) {
            return (String) ipChange.ipc$dispatch("-102153130", new Object[]{this});
        }
        VideoInfo videoInfo = this.videoInfo;
        if (videoInfo != null) {
            return videoInfo.coverUrl;
        }
        return null;
    }

    public boolean isShowVideoIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1866343750")) {
            return ((Boolean) ipChange.ipc$dispatch("-1866343750", new Object[]{this})).booleanValue();
        }
        VideoInfo videoInfo = this.videoInfo;
        return (videoInfo == null || TextUtils.isEmpty(videoInfo.coverUrl)) ? false : true;
    }

    public void putExtraObj2Map(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079685577")) {
            ipChange.ipc$dispatch("2079685577", new Object[]{this, str, obj});
            return;
        }
        if (this.extraMap == null) {
            this.extraMap = new HashMap<>();
        }
        this.extraMap.put(str, obj);
    }

    public void setHwRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271380269")) {
            ipChange.ipc$dispatch("-271380269", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f <= 0.0f) {
            f = 1.0f;
        }
        this.hwRatio = f;
    }
}
