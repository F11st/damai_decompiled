package com.youku.arch.v3.adapter;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.ReflectionUtil;
import com.youku.arch.v3.util.ViewUtil;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b^\u0010_J*\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0006\u0010\u0007\u001a\u00020\u0003R\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\b8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R6\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e8V@VX\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R$\u0010)\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014R$\u0010,\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012\"\u0004\b.\u0010\u0014R$\u0010/\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R$\u00102\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0010\u001a\u0004\b<\u0010\u0012\"\u0004\b=\u0010\u0014R$\u0010>\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0010\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R$\u0010A\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0010\u001a\u0004\bB\u0010\u0012\"\u0004\bC\u0010\u0014R$\u0010D\u001a\u0004\u0018\u00010\b8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0016\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010\u001aR$\u0010G\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0010\u001a\u0004\bH\u0010\u0012\"\u0004\bI\u0010\u0014R\"\u0010J\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u0010\n\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR(\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bM\u0010!\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\"\u0010Q\u001a\u00020P8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bQ\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020P8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010R\u001a\u0004\bV\u0010S\"\u0004\bW\u0010UR$\u0010X\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0010\u001a\u0004\bY\u0010\u0012\"\u0004\bZ\u0010\u0014R6\u0010[\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001e8V@VX\u0096\u000e¢\u0006\u0012\n\u0004\b[\u0010!\u001a\u0004\b\\\u0010#\"\u0004\b]\u0010%¨\u0006`"}, d2 = {"Lcom/youku/arch/v3/adapter/ViewTypeConfig;", "", "Ljava/util/HashMap;", "", "map", "wrapParams", "toString", "toLogString", "", "viewType", "I", "getViewType", "()I", "setViewType", "(I)V", "layoutHelper", "Ljava/lang/String;", "getLayoutHelper", "()Ljava/lang/String;", "setLayoutHelper", "(Ljava/lang/String;)V", "layoutResId", "Ljava/lang/Integer;", "getLayoutResId", "()Ljava/lang/Integer;", "setLayoutResId", "(Ljava/lang/Integer;)V", "layoutResString", "getLayoutResString", "setLayoutResString", "Ljava/lang/Class;", "value", "viewHolderClass", "Ljava/lang/Class;", "getViewHolderClass", "()Ljava/lang/Class;", "setViewHolderClass", "(Ljava/lang/Class;)V", "viewHolderClassName", "getViewHolderClassName", "setViewHolderClassName", "renderPluginFactory", "getRenderPluginFactory", "setRenderPluginFactory", "model", "getModel", "setModel", "presenter", "getPresenter", "setPresenter", "view", "getView", "setView", "params", "Ljava/util/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "modelOpt", "getModelOpt", "setModelOpt", "presenterOpt", "getPresenterOpt", "setPresenterOpt", "viewOpt", "getViewOpt", "setViewOpt", "layoutResIdOpt", "getLayoutResIdOpt", "setLayoutResIdOpt", "layoutResStringOpt", "getLayoutResStringOpt", "setLayoutResStringOpt", "defaultLayoutResId", "getDefaultLayoutResId", "setDefaultLayoutResId", "defaultHolderClass", "getDefaultHolderClass", "setDefaultHolderClass", "", "isInitViewHolderClass", "Z", "()Z", "setInitViewHolderClass", "(Z)V", "isInitPreRenderClass", "setInitPreRenderClass", "preRenderClassName", "getPreRenderClassName", "setPreRenderClassName", "preRenderClass", "getPreRenderClass", "setPreRenderClass", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ViewTypeConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Class<?> defaultHolderClass;
    private int defaultLayoutResId;
    private boolean isInitPreRenderClass;
    private boolean isInitViewHolderClass;
    @Nullable
    private String layoutHelper;
    @Nullable
    private Integer layoutResId;
    @Nullable
    private Integer layoutResIdOpt;
    @Nullable
    private String layoutResString;
    @Nullable
    private String layoutResStringOpt;
    @Nullable
    private String model;
    @Nullable
    private String modelOpt;
    @Nullable
    private HashMap<String, Object> params;
    @Nullable
    private Class<?> preRenderClass;
    @Nullable
    private String preRenderClassName;
    @Nullable
    private String presenter;
    @Nullable
    private String presenterOpt;
    @Nullable
    private String renderPluginFactory;
    @Nullable
    private String view;
    @Nullable
    private Class<?> viewHolderClass;
    @Nullable
    private String viewHolderClassName;
    @Nullable
    private String viewOpt;
    private int viewType;

    @Nullable
    public Class<?> getDefaultHolderClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "706251859") ? (Class) ipChange.ipc$dispatch("706251859", new Object[]{this}) : this.defaultHolderClass;
    }

    public int getDefaultLayoutResId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1358993452") ? ((Integer) ipChange.ipc$dispatch("-1358993452", new Object[]{this})).intValue() : this.defaultLayoutResId;
    }

    @Nullable
    public String getLayoutHelper() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1291440519") ? (String) ipChange.ipc$dispatch("1291440519", new Object[]{this}) : this.layoutHelper;
    }

    @Nullable
    public Integer getLayoutResId() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "479307631")) {
            return (Integer) ipChange.ipc$dispatch("479307631", new Object[]{this});
        }
        if (this.layoutResId == null) {
            this.layoutResId = Integer.valueOf(getDefaultLayoutResId());
            String layoutResString = getLayoutResString();
            if (!((layoutResString == null || layoutResString.length() == 0) ? true : true)) {
                this.layoutResId = Integer.valueOf(ViewUtil.getIdentifier(AppInfoProviderProxy.getApplication(), getLayoutResString(), "layout"));
            }
        }
        return this.layoutResId;
    }

    @Nullable
    public Integer getLayoutResIdOpt() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "183369142")) {
            return (Integer) ipChange.ipc$dispatch("183369142", new Object[]{this});
        }
        if (this.layoutResIdOpt == null) {
            this.layoutResIdOpt = Integer.valueOf(getDefaultLayoutResId());
            String layoutResStringOpt = getLayoutResStringOpt();
            if (!((layoutResStringOpt == null || layoutResStringOpt.length() == 0) ? true : true)) {
                this.layoutResIdOpt = Integer.valueOf(ViewUtil.getIdentifier(AppInfoProviderProxy.getApplication(), getLayoutResStringOpt(), "layout"));
            }
        }
        return this.layoutResIdOpt;
    }

    @Nullable
    public String getLayoutResString() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1853011534") ? (String) ipChange.ipc$dispatch("1853011534", new Object[]{this}) : this.layoutResString;
    }

    @Nullable
    public String getLayoutResStringOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "305375611") ? (String) ipChange.ipc$dispatch("305375611", new Object[]{this}) : this.layoutResStringOpt;
    }

    @Nullable
    public String getModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1040275792") ? (String) ipChange.ipc$dispatch("-1040275792", new Object[]{this}) : this.model;
    }

    @Nullable
    public String getModelOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2081310169") ? (String) ipChange.ipc$dispatch("2081310169", new Object[]{this}) : this.modelOpt;
    }

    @Nullable
    public HashMap<String, Object> getParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1959084786") ? (HashMap) ipChange.ipc$dispatch("-1959084786", new Object[]{this}) : this.params;
    }

    @Nullable
    public Class<?> getPreRenderClass() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "942957855")) {
            return (Class) ipChange.ipc$dispatch("942957855", new Object[]{this});
        }
        if (!isInitPreRenderClass()) {
            String preRenderClassName = getPreRenderClassName();
            if (!((preRenderClassName == null || preRenderClassName.length() == 0) ? true : true)) {
                this.preRenderClass = ReflectionUtil.INSTANCE.tryGetClassForName(getPreRenderClassName());
            }
        }
        return this.preRenderClass;
    }

    @Nullable
    public String getPreRenderClassName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2527257") ? (String) ipChange.ipc$dispatch("2527257", new Object[]{this}) : this.preRenderClassName;
    }

    @Nullable
    public String getPresenter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-554124625") ? (String) ipChange.ipc$dispatch("-554124625", new Object[]{this}) : this.presenter;
    }

    @Nullable
    public String getPresenterOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1913963142") ? (String) ipChange.ipc$dispatch("-1913963142", new Object[]{this}) : this.presenterOpt;
    }

    @Nullable
    public String getRenderPluginFactory() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1808014616") ? (String) ipChange.ipc$dispatch("-1808014616", new Object[]{this}) : this.renderPluginFactory;
    }

    @Nullable
    public String getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1316735028") ? (String) ipChange.ipc$dispatch("1316735028", new Object[]{this}) : this.view;
    }

    @Nullable
    public Class<?> getViewHolderClass() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1279158593")) {
            return (Class) ipChange.ipc$dispatch("-1279158593", new Object[]{this});
        }
        if (!isInitViewHolderClass()) {
            this.viewHolderClass = getDefaultHolderClass();
            String viewHolderClassName = getViewHolderClassName();
            if (!((viewHolderClassName == null || viewHolderClassName.length() == 0) ? true : true)) {
                this.viewHolderClass = ReflectionUtil.INSTANCE.tryGetClassForName(getViewHolderClassName());
            }
        }
        return this.viewHolderClass;
    }

    @Nullable
    public String getViewHolderClassName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1664574073") ? (String) ipChange.ipc$dispatch("1664574073", new Object[]{this}) : this.viewHolderClassName;
    }

    @Nullable
    public String getViewOpt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1370326485") ? (String) ipChange.ipc$dispatch("1370326485", new Object[]{this}) : this.viewOpt;
    }

    public int getViewType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "261928133") ? ((Integer) ipChange.ipc$dispatch("261928133", new Object[]{this})).intValue() : this.viewType;
    }

    public boolean isInitPreRenderClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1823152078") ? ((Boolean) ipChange.ipc$dispatch("1823152078", new Object[]{this})).booleanValue() : this.isInitPreRenderClass;
    }

    public boolean isInitViewHolderClass() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1090598334") ? ((Boolean) ipChange.ipc$dispatch("1090598334", new Object[]{this})).booleanValue() : this.isInitViewHolderClass;
    }

    public void setDefaultHolderClass(@Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2121520227")) {
            ipChange.ipc$dispatch("2121520227", new Object[]{this, cls});
        } else {
            this.defaultHolderClass = cls;
        }
    }

    public void setDefaultLayoutResId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1664197454")) {
            ipChange.ipc$dispatch("1664197454", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.defaultLayoutResId = i;
        }
    }

    public void setInitPreRenderClass(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107435486")) {
            ipChange.ipc$dispatch("1107435486", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isInitPreRenderClass = z;
        }
    }

    public void setInitViewHolderClass(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284288186")) {
            ipChange.ipc$dispatch("-284288186", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isInitViewHolderClass = z;
        }
    }

    public void setLayoutHelper(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777831479")) {
            ipChange.ipc$dispatch("1777831479", new Object[]{this, str});
        } else {
            this.layoutHelper = str;
        }
    }

    public void setLayoutResId(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1627177053")) {
            ipChange.ipc$dispatch("-1627177053", new Object[]{this, num});
        } else {
            this.layoutResId = num;
        }
    }

    public void setLayoutResIdOpt(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1967563988")) {
            ipChange.ipc$dispatch("1967563988", new Object[]{this, num});
        } else {
            this.layoutResIdOpt = num;
        }
    }

    public void setLayoutResString(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890596072")) {
            ipChange.ipc$dispatch("1890596072", new Object[]{this, str});
        } else {
            this.layoutResString = str;
        }
    }

    public void setLayoutResStringOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834702787")) {
            ipChange.ipc$dispatch("834702787", new Object[]{this, str});
        } else {
            this.layoutResStringOpt = str;
        }
    }

    public void setModel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307589062")) {
            ipChange.ipc$dispatch("307589062", new Object[]{this, str});
        } else {
            this.model = str;
        }
    }

    public void setModelOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213777957")) {
            ipChange.ipc$dispatch("213777957", new Object[]{this, str});
        } else {
            this.modelOpt = str;
        }
    }

    public void setParams(@Nullable HashMap<String, Object> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727933556")) {
            ipChange.ipc$dispatch("727933556", new Object[]{this, hashMap});
        } else {
            this.params = hashMap;
        }
    }

    public void setPreRenderClass(@Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010186985")) {
            ipChange.ipc$dispatch("-2010186985", new Object[]{this, cls});
            return;
        }
        setInitPreRenderClass(true);
        this.preRenderClass = cls;
    }

    public void setPreRenderClassName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36338405")) {
            ipChange.ipc$dispatch("36338405", new Object[]{this, str});
        } else {
            this.preRenderClassName = str;
        }
    }

    public void setPresenter(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963199065")) {
            ipChange.ipc$dispatch("-1963199065", new Object[]{this, str});
        } else {
            this.presenter = str;
        }
    }

    public void setPresenterOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1194565796")) {
            ipChange.ipc$dispatch("1194565796", new Object[]{this, str});
        } else {
            this.presenterOpt = str;
        }
    }

    public void setRenderPluginFactory(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460811150")) {
            ipChange.ipc$dispatch("1460811150", new Object[]{this, str});
        } else {
            this.renderPluginFactory = str;
        }
    }

    public void setView(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871323434")) {
            ipChange.ipc$dispatch("1871323434", new Object[]{this, str});
        } else {
            this.view = str;
        }
    }

    public void setViewHolderClass(@Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575236831")) {
            ipChange.ipc$dispatch("575236831", new Object[]{this, cls});
            return;
        }
        setInitViewHolderClass(true);
        this.viewHolderClass = cls;
    }

    public void setViewHolderClassName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736878109")) {
            ipChange.ipc$dispatch("1736878109", new Object[]{this, str});
        } else {
            this.viewHolderClassName = str;
        }
    }

    public void setViewOpt(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085805503")) {
            ipChange.ipc$dispatch("-2085805503", new Object[]{this, str});
        } else {
            this.viewOpt = str;
        }
    }

    public void setViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440619901")) {
            ipChange.ipc$dispatch("440619901", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.viewType = i;
        }
    }

    @NotNull
    public final String toLogString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358503725")) {
            return (String) ipChange.ipc$dispatch("-1358503725", new Object[]{this});
        }
        return "ViewTypeConfig{viewType=" + getViewType() + ", layoutResId=" + getLayoutResId() + ", viewHolderClass=" + getViewHolderClass() + ", layoutHelper='" + ((Object) getLayoutHelper()) + "', renderPluginFactory='" + ((Object) getRenderPluginFactory()) + "', modelClass='" + ((Object) getModel()) + "', presenterClass='" + ((Object) getPresenter()) + "', viewClass='" + ((Object) getView()) + "'}";
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47325481")) {
            return (String) ipChange.ipc$dispatch("47325481", new Object[]{this});
        }
        if (!AppInfoProviderProxy.isDebuggable()) {
            return super.toString();
        }
        return toLogString();
    }

    @Nullable
    public final HashMap<String, Object> wrapParams(@Nullable HashMap<String, Object> hashMap) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1948194333")) {
            return (HashMap) ipChange.ipc$dispatch("-1948194333", new Object[]{this, hashMap});
        }
        HashMap<String, Object> params = getParams();
        if (params != null && !params.isEmpty()) {
            z = false;
        }
        if (z) {
            return hashMap;
        }
        if (hashMap == null) {
            hashMap = new HashMap<>(4);
        }
        HashMap<String, Object> params2 = getParams();
        if (params2 != null) {
            hashMap.put("param", params2);
            if (params2.containsKey("span")) {
                Object obj = params2.get("span");
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
                hashMap.put("span", Integer.valueOf(((Integer) obj).intValue()));
            }
        }
        return hashMap;
    }
}
