package cn.damai.tetris.component.rank.bean;

import android.text.TextUtils;
import cn.damai.common.net.mtop.Util;
import cn.damai.tetris.request.TetrisParams;
import cn.damai.tetris.v2.common.ContainerArg;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankProjectParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String RANK_SQUARE_PATTERN_NAME = "dm_app_ranking";
    public static final String RANK_SQUARE_PATTERN_VERSION = "1.0";
    public String categoryId;
    public String cityId;
    public String currentCityId;
    public String latitude;
    public String longitude;
    @JSONField(serialize = false)
    public String pN;
    @JSONField(serialize = false)
    public String pV;
    public String subType;

    public RankProjectParams(String str, String str2) {
        this.pN = str;
        this.pV = str2;
        ensureLocation();
    }

    private void ensureLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351069780")) {
            ipChange.ipc$dispatch("1351069780", new Object[]{this});
            return;
        }
        double[] dMCoordinates = Util.getDMCoordinates();
        if (dMCoordinates != null) {
            this.longitude = String.valueOf(dMCoordinates[0]);
            this.latitude = String.valueOf(dMCoordinates[1]);
        }
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-255008578") ? (String) ipChange.ipc$dispatch("-255008578", new Object[]{this}) : this.pN;
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "456578779") ? (String) ipChange.ipc$dispatch("456578779", new Object[]{this}) : this.pV;
    }

    public RankProjectParams(ContainerArg containerArg) {
        if (containerArg != null) {
            if (!TextUtils.isEmpty(containerArg.patternName)) {
                this.pN = containerArg.patternName;
            }
            if (!TextUtils.isEmpty(containerArg.patternVersion)) {
                this.pV = containerArg.patternVersion;
            }
        }
        if (TextUtils.isEmpty(this.pN)) {
            this.pN = RANK_SQUARE_PATTERN_NAME;
        }
        if (TextUtils.isEmpty(this.pV)) {
            this.pV = "1.0";
        }
        ensureLocation();
    }
}
