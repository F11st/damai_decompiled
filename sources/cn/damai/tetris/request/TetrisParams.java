package cn.damai.tetris.request;

import cn.damai.common.AppConfig;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public abstract class TetrisParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String comboDamaiCityId = z20.c();
    public String dmChannel = AppConfig.p();

    @JSONField(serialize = false)
    public abstract String getPatternName();

    @JSONField(serialize = false)
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1507159629") ? (String) ipChange.ipc$dispatch("-1507159629", new Object[]{this}) : "1.0";
    }
}
