package com.youku.arch.v3.view.render;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bRB\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010(j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u0001`*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "Lcom/youku/arch/v3/view/render/RenderConfig;", "", "pClassName", "Ljava/lang/String;", "getPClassName", "()Ljava/lang/String;", "setPClassName", "(Ljava/lang/String;)V", "vClassName", "getVClassName", "setVClassName", "mClassName", "getMClassName", "setMClassName", "", "layoutId", "Ljava/lang/Integer;", "getLayoutId", "()Ljava/lang/Integer;", "setLayoutId", "(Ljava/lang/Integer;)V", "layoutStr", "getLayoutStr", "setLayoutStr", "pClassNameOpt", "getPClassNameOpt", "setPClassNameOpt", "vClassNameOpt", "getVClassNameOpt", "setVClassNameOpt", "mClassNameOpt", "getMClassNameOpt", "setMClassNameOpt", "layoutIdOpt", "getLayoutIdOpt", "setLayoutIdOpt", "layoutStrOpt", "getLayoutStrOpt", "setLayoutStrOpt", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extra", "Ljava/util/HashMap;", "getExtra", "()Ljava/util/HashMap;", "setExtra", "(Ljava/util/HashMap;)V", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericRenderConfig extends RenderConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private HashMap<String, Object> extra;
    @Nullable
    private Integer layoutId = 0;
    @Nullable
    private Integer layoutIdOpt = 0;
    @Nullable
    private String layoutStr;
    @Nullable
    private String layoutStrOpt;
    @Nullable
    private String mClassName;
    @Nullable
    private String mClassNameOpt;
    @Nullable
    private String pClassName;
    @Nullable
    private String pClassNameOpt;
    @Nullable
    private String vClassName;
    @Nullable
    private String vClassNameOpt;

    @Nullable
    public final HashMap<String, Object> getExtra() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "287385337") ? (HashMap) ipChange.ipc$dispatch("287385337", new Object[]{this}) : this.extra;
    }

    @Nullable
    public final Integer getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1517126022") ? (Integer) ipChange.ipc$dispatch("1517126022", new Object[]{this}) : this.layoutId;
    }

    @Nullable
    public final Integer getLayoutIdOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1638508481") ? (Integer) ipChange.ipc$dispatch("-1638508481", new Object[]{this}) : this.layoutIdOpt;
    }

    @Nullable
    public final String getLayoutStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-74095135") ? (String) ipChange.ipc$dispatch("-74095135", new Object[]{this}) : this.layoutStr;
    }

    @Nullable
    public final String getLayoutStrOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "698445064") ? (String) ipChange.ipc$dispatch("698445064", new Object[]{this}) : this.layoutStrOpt;
    }

    @Nullable
    public final String getMClassName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "322565106") ? (String) ipChange.ipc$dispatch("322565106", new Object[]{this}) : this.mClassName;
    }

    @Nullable
    public final String getMClassNameOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2146313897") ? (String) ipChange.ipc$dispatch("-2146313897", new Object[]{this}) : this.mClassNameOpt;
    }

    @Nullable
    public final String getPClassName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "356513487") ? (String) ipChange.ipc$dispatch("356513487", new Object[]{this}) : this.pClassName;
    }

    @Nullable
    public final String getPClassNameOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-107410086") ? (String) ipChange.ipc$dispatch("-107410086", new Object[]{this}) : this.pClassNameOpt;
    }

    @Nullable
    public final String getVClassName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "424410249") ? (String) ipChange.ipc$dispatch("424410249", new Object[]{this}) : this.vClassName;
    }

    @Nullable
    public final String getVClassNameOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-324569760") ? (String) ipChange.ipc$dispatch("-324569760", new Object[]{this}) : this.vClassNameOpt;
    }

    public final void setExtra(@Nullable HashMap<String, Object> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870192209")) {
            ipChange.ipc$dispatch("1870192209", new Object[]{this, hashMap});
        } else {
            this.extra = hashMap;
        }
    }

    public final void setLayoutId(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882663932")) {
            ipChange.ipc$dispatch("-1882663932", new Object[]{this, num});
        } else {
            this.layoutId = num;
        }
    }

    public final void setLayoutIdOpt(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440000211")) {
            ipChange.ipc$dispatch("1440000211", new Object[]{this, num});
        } else {
            this.layoutIdOpt = num;
        }
    }

    public final void setLayoutStr(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "32813237")) {
            ipChange.ipc$dispatch("32813237", new Object[]{this, str});
        } else {
            this.layoutStr = str;
        }
    }

    public final void setLayoutStrOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574841558")) {
            ipChange.ipc$dispatch("574841558", new Object[]{this, str});
        } else {
            this.layoutStrOpt = str;
        }
    }

    public final void setMClassName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700299732")) {
            ipChange.ipc$dispatch("-700299732", new Object[]{this, str});
        } else {
            this.mClassName = str;
        }
    }

    public final void setMClassNameOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "315082239")) {
            ipChange.ipc$dispatch("315082239", new Object[]{this, str});
        } else {
            this.mClassNameOpt = str;
        }
    }

    public final void setPClassName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352100079")) {
            ipChange.ipc$dispatch("352100079", new Object[]{this, str});
        } else {
            this.pClassName = str;
        }
    }

    public final void setPClassNameOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-903409060")) {
            ipChange.ipc$dispatch("-903409060", new Object[]{this, str});
        } else {
            this.pClassNameOpt = str;
        }
    }

    public final void setVClassName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1838067595")) {
            ipChange.ipc$dispatch("-1838067595", new Object[]{this, str});
        } else {
            this.vClassName = str;
        }
    }

    public final void setVClassNameOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954575638")) {
            ipChange.ipc$dispatch("954575638", new Object[]{this, str});
        } else {
            this.vClassNameOpt = str;
        }
    }
}
