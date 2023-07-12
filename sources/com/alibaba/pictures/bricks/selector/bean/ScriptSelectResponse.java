package com.alibaba.pictures.bricks.selector.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptSelectResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Boolean hasNext;
    @Nullable
    private ArrayList<ScriptSelectMo> searchResultList;
    @Nullable
    private ScriptSelectMo selected;

    @Nullable
    public final Boolean getHasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "286494678") ? (Boolean) ipChange.ipc$dispatch("286494678", new Object[]{this}) : this.hasNext;
    }

    @Nullable
    public final ArrayList<ScriptSelectMo> getSearchResultList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1816797189") ? (ArrayList) ipChange.ipc$dispatch("-1816797189", new Object[]{this}) : this.searchResultList;
    }

    @Nullable
    public final ScriptSelectMo getSelected() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-869059520") ? (ScriptSelectMo) ipChange.ipc$dispatch("-869059520", new Object[]{this}) : this.selected;
    }

    public final void setHasNext(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "439884424")) {
            ipChange.ipc$dispatch("439884424", new Object[]{this, bool});
        } else {
            this.hasNext = bool;
        }
    }

    public final void setSearchResultList(@Nullable ArrayList<ScriptSelectMo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885894475")) {
            ipChange.ipc$dispatch("-885894475", new Object[]{this, arrayList});
        } else {
            this.searchResultList = arrayList;
        }
    }

    public final void setSelected(@Nullable ScriptSelectMo scriptSelectMo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625901456")) {
            ipChange.ipc$dispatch("625901456", new Object[]{this, scriptSelectMo});
        } else {
            this.selected = scriptSelectMo;
        }
    }
}
