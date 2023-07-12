package com.alibaba.pictures.bricks.selector.request;

import com.alibaba.pictures.bricks.base.DamaiBaseRequest;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptSelectRequest extends DamaiBaseRequest<ScriptSelectResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String keyword;
    private int pageIndex;
    private int pageSize;
    private int queryType;
    @Nullable
    private String selectedId;
    @Nullable
    private String targetId;

    public ScriptSelectRequest() {
        this.API_NAME = "mtop.damai.wireless.comment.baccount.search";
        this.VERSION = "1.0";
        this.NEED_ECODE = true;
        this.NEED_SESSION = true;
        this.pageSize = 20;
        this.pageIndex = 1;
    }

    @Nullable
    public final String getKeyword() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1195591838") ? (String) ipChange.ipc$dispatch("-1195591838", new Object[]{this}) : this.keyword;
    }

    public final int getPageIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2090777449") ? ((Integer) ipChange.ipc$dispatch("-2090777449", new Object[]{this})).intValue() : this.pageIndex;
    }

    public final int getPageSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1844909978") ? ((Integer) ipChange.ipc$dispatch("-1844909978", new Object[]{this})).intValue() : this.pageSize;
    }

    public final int getQueryType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "186002328") ? ((Integer) ipChange.ipc$dispatch("186002328", new Object[]{this})).intValue() : this.queryType;
    }

    @Nullable
    public final String getSelectedId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1416560909") ? (String) ipChange.ipc$dispatch("-1416560909", new Object[]{this}) : this.selectedId;
    }

    @Nullable
    public final String getTargetId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2035425815") ? (String) ipChange.ipc$dispatch("-2035425815", new Object[]{this}) : this.targetId;
    }

    public final void setKeyword(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24894892")) {
            ipChange.ipc$dispatch("-24894892", new Object[]{this, str});
        } else {
            this.keyword = str;
        }
    }

    public final void setPageIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2073962835")) {
            ipChange.ipc$dispatch("2073962835", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageIndex = i;
        }
    }

    public final void setPageSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446852100")) {
            ipChange.ipc$dispatch("-446852100", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pageSize = i;
        }
    }

    public final void setQueryType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360308110")) {
            ipChange.ipc$dispatch("-360308110", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.queryType = i;
        }
    }

    public final void setSelectedId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221368651")) {
            ipChange.ipc$dispatch("1221368651", new Object[]{this, str});
        } else {
            this.selectedId = str;
        }
    }

    public final void setTargetId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443981333")) {
            ipChange.ipc$dispatch("1443981333", new Object[]{this, str});
        } else {
            this.targetId = str;
        }
    }
}
