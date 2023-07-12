package com.alibaba.pictures.piclocation.mtop;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0019\u0010\u001aB\u0019\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/alibaba/pictures/piclocation/mtop/RegionPicMo;", "Ljava/io/Serializable;", "", "id", "J", "getId", "()J", "setId", "(J)V", "parentId", "getParentId", "setParentId", "", "regionName", "Ljava/lang/String;", "getRegionName", "()Ljava/lang/String;", "setRegionName", "(Ljava/lang/String;)V", "cityCode", "getCityCode", "setCityCode", "pinYin", "getPinYin", "setPinYin", "<init>", "()V", "name", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "location_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class RegionPicMo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String cityCode;
    private long id;
    private long parentId;
    @Nullable
    private String pinYin;
    @Nullable
    private String regionName;

    public RegionPicMo() {
        this.regionName = "";
        this.cityCode = "-1";
    }

    @Nullable
    public final String getCityCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1008669573") ? (String) ipChange.ipc$dispatch("-1008669573", new Object[]{this}) : this.cityCode;
    }

    public final long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "16951990") ? ((Long) ipChange.ipc$dispatch("16951990", new Object[]{this})).longValue() : this.id;
    }

    public final long getParentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-620644820") ? ((Long) ipChange.ipc$dispatch("-620644820", new Object[]{this})).longValue() : this.parentId;
    }

    @Nullable
    public final String getPinYin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "546635660") ? (String) ipChange.ipc$dispatch("546635660", new Object[]{this}) : this.pinYin;
    }

    @Nullable
    public final String getRegionName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-678448478") ? (String) ipChange.ipc$dispatch("-678448478", new Object[]{this}) : this.regionName;
    }

    public final void setCityCode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086313533")) {
            ipChange.ipc$dispatch("-1086313533", new Object[]{this, str});
        } else {
            this.cityCode = str;
        }
    }

    public final void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310925390")) {
            ipChange.ipc$dispatch("310925390", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    public final void setParentId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149336936")) {
            ipChange.ipc$dispatch("-1149336936", new Object[]{this, Long.valueOf(j)});
        } else {
            this.parentId = j;
        }
    }

    public final void setPinYin(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1629255726")) {
            ipChange.ipc$dispatch("-1629255726", new Object[]{this, str});
        } else {
            this.pinYin = str;
        }
    }

    public final void setRegionName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666949764")) {
            ipChange.ipc$dispatch("-1666949764", new Object[]{this, str});
        } else {
            this.regionName = str;
        }
    }

    public RegionPicMo(@NotNull String str, @NotNull String str2) {
        b41.i(str, "name");
        b41.i(str2, "code");
        this.regionName = str;
        this.cityCode = str2;
    }
}
