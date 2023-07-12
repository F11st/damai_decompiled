package cn.damai.search.component.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
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
        if (AndroidInstantRuntime.support(ipChange, "2087274780")) {
            return (String) ipChange.ipc$dispatch("2087274780", new Object[]{this});
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
        return AndroidInstantRuntime.support(ipChange, "-800313383") ? (ArrayList) ipChange.ipc$dispatch("-800313383", new Object[]{this}) : this.highlightWord;
    }

    @Nullable
    public final String getPriceLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1492208578") ? (String) ipChange.ipc$dispatch("-1492208578", new Object[]{this}) : this.priceLow;
    }

    @Nullable
    public final String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-466642377") ? (String) ipChange.ipc$dispatch("-466642377", new Object[]{this}) : this.projectId;
    }

    @Nullable
    public final String getProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1695842457") ? (String) ipChange.ipc$dispatch("-1695842457", new Object[]{this}) : this.projectName;
    }

    @Nullable
    public final String getProjectPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1768006236") ? (String) ipChange.ipc$dispatch("-1768006236", new Object[]{this}) : this.projectPic;
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "836658068") ? (String) ipChange.ipc$dispatch("836658068", new Object[]{this}) : this.schema;
    }

    @Nullable
    public final ArrayList<String> getScriptNameList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-547668749") ? (ArrayList) ipChange.ipc$dispatch("-547668749", new Object[]{this}) : this.scriptNameList;
    }

    @Nullable
    public final String getStoreName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "438569775") ? (String) ipChange.ipc$dispatch("438569775", new Object[]{this}) : this.storeName;
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008815615")) {
            ipChange.ipc$dispatch("2008815615", new Object[]{this, arrayList});
        } else {
            this.highlightWord = arrayList;
        }
    }

    public final void setPriceLow(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103846496")) {
            ipChange.ipc$dispatch("1103846496", new Object[]{this, str});
        } else {
            this.priceLow = str;
        }
    }

    public final void setProjectId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "748750623")) {
            ipChange.ipc$dispatch("748750623", new Object[]{this, str});
        } else {
            this.projectId = str;
        }
    }

    public final void setProjectName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963507439")) {
            ipChange.ipc$dispatch("963507439", new Object[]{this, str});
        } else {
            this.projectName = str;
        }
    }

    public final void setProjectPic(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083501894")) {
            ipChange.ipc$dispatch("-1083501894", new Object[]{this, str});
        } else {
            this.projectPic = str;
        }
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1228495670")) {
            ipChange.ipc$dispatch("-1228495670", new Object[]{this, str});
        } else {
            this.schema = str;
        }
    }

    public final void setScriptNameList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861313091")) {
            ipChange.ipc$dispatch("-861313091", new Object[]{this, arrayList});
        } else {
            this.scriptNameList = arrayList;
        }
    }

    public final void setStoreName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254443737")) {
            ipChange.ipc$dispatch("-1254443737", new Object[]{this, str});
        } else {
            this.storeName = str;
        }
    }
}
