package cn.damai.commonbusiness.wannasee;

import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class WantSeeRecommendRequest extends DamaiBaseRequest<RecommendProjects> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private String cityId;
    private int pageNo;
    private int pageSize;
    private int recommendType;

    public WantSeeRecommendRequest() {
        this.API_NAME = "mtop.damai.wireless.discovery.home.wanna.getRecommendInfo";
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
        this.recommendType = 1;
        this.pageSize = 4;
        this.pageNo = 1;
        String c = z20.c();
        b41.h(c, "getCityId()");
        this.cityId = c;
    }

    @NotNull
    public final String getCityId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "183597011") ? (String) ipChange.ipc$dispatch("183597011", new Object[]{this}) : this.cityId;
    }

    public final int getPageNo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "975177558") ? ((Integer) ipChange.ipc$dispatch("975177558", new Object[]{this})).intValue() : this.pageNo;
    }

    public final int getPageSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "891024726") ? ((Integer) ipChange.ipc$dispatch("891024726", new Object[]{this})).intValue() : this.pageSize;
    }

    public final int getRecommendType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "968984884") ? ((Integer) ipChange.ipc$dispatch("968984884", new Object[]{this})).intValue() : this.recommendType;
    }

    public final void setCityId(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448043")) {
            ipChange.ipc$dispatch("1448043", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.cityId = str;
    }

    public final void setPageNo(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939894284")) {
            ipChange.ipc$dispatch("939894284", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageNo = i;
        }
    }

    public final void setPageSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532222196")) {
            ipChange.ipc$dispatch("-1532222196", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageSize = i;
        }
    }

    public final void setRecommendType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637133226")) {
            ipChange.ipc$dispatch("-637133226", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.recommendType = i;
        }
    }
}
