package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SearchScriptCouponBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<String> highlightWord;
    @Nullable
    private String priceLow;
    @Nullable
    private String projectId;
    @Nullable
    private String projectName;
    @Nullable
    private String projectPic;
    @Nullable
    private String schema;
    @Nullable
    private ArrayList<String> scriptNameList;
    private final long serialVersionUID = 1;
    @Nullable
    private String storeName;

    @Nullable
    public final String buildDesc() {
        String str;
        String sb;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-797180586")) {
            return (String) ipChange.ipc$dispatch("-797180586", new Object[]{this});
        }
        ArrayList<String> arrayList = this.scriptNameList;
        if (arrayList == null || arrayList.isEmpty()) {
            return this.storeName;
        }
        ArrayList<String> arrayList2 = this.scriptNameList;
        if (arrayList2 != null && (str = arrayList2.get(0)) != null) {
            String str2 = this.storeName;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                sb = (char) 12298 + str + (char) 12299;
            } else {
                StringBuilder sb2 = new StringBuilder((char) 12298 + str + (char) 12299);
                sb2.append("/ ");
                sb2.append(this.storeName);
                sb = sb2.toString();
                b41.h(sb, "{\n                String….toString()\n            }");
            }
            if (sb != null) {
                return sb;
            }
        }
        return this.storeName;
    }

    @Nullable
    public final ArrayList<String> getHighlightWord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1063150483") ? (ArrayList) ipChange.ipc$dispatch("1063150483", new Object[]{this}) : this.highlightWord;
    }

    @Nullable
    public final String getPriceLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1095057912") ? (String) ipChange.ipc$dispatch("1095057912", new Object[]{this}) : this.priceLow;
    }

    @Nullable
    public final String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1865759811") ? (String) ipChange.ipc$dispatch("-1865759811", new Object[]{this}) : this.projectId;
    }

    @Nullable
    public final String getProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1922932883") ? (String) ipChange.ipc$dispatch("-1922932883", new Object[]{this}) : this.projectName;
    }

    @Nullable
    public final String getProjectPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2103993566") ? (String) ipChange.ipc$dispatch("2103993566", new Object[]{this}) : this.projectPic;
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2047797298") ? (String) ipChange.ipc$dispatch("-2047797298", new Object[]{this}) : this.schema;
    }

    @Nullable
    public final ArrayList<String> getScriptNameList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1385136249") ? (ArrayList) ipChange.ipc$dispatch("1385136249", new Object[]{this}) : this.scriptNameList;
    }

    @Nullable
    public final String getStoreName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-960547659") ? (String) ipChange.ipc$dispatch("-960547659", new Object[]{this}) : this.storeName;
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353346683")) {
            ipChange.ipc$dispatch("-353346683", new Object[]{this, arrayList});
        } else {
            this.highlightWord = arrayList;
        }
    }

    public final void setPriceLow(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-295270938")) {
            ipChange.ipc$dispatch("-295270938", new Object[]{this, str});
        } else {
            this.priceLow = str;
        }
    }

    public final void setProjectId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325783129")) {
            ipChange.ipc$dispatch("325783129", new Object[]{this, str});
        } else {
            this.projectId = str;
        }
    }

    public final void setProjectName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1781328471")) {
            ipChange.ipc$dispatch("-1781328471", new Object[]{this, str});
        } else {
            this.projectName = str;
        }
    }

    public final void setProjectPic(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1310592320")) {
            ipChange.ipc$dispatch("-1310592320", new Object[]{this, str});
        } else {
            this.projectPic = str;
        }
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-452298800")) {
            ipChange.ipc$dispatch("-452298800", new Object[]{this, str});
        } else {
            this.schema = str;
        }
    }

    public final void setScriptNameList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1073900297")) {
            ipChange.ipc$dispatch("-1073900297", new Object[]{this, arrayList});
        } else {
            this.scriptNameList = arrayList;
        }
    }

    public final void setStoreName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677411231")) {
            ipChange.ipc$dispatch("-1677411231", new Object[]{this, str});
        } else {
            this.storeName = str;
        }
    }
}
