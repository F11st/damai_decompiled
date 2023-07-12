package com.youku.arch.v3.core;

import android.util.SparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.ICreator;
import com.youku.arch.v3.IPresenterCreator;
import com.youku.arch.v3.IViewCreator;
import com.youku.arch.v3.IViewDataBinder;
import com.youku.arch.v3.core.parser.IParser;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0007¢\u0006\u0004\b+\u0010,J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR0\u0010\u001e\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/youku/arch/v3/core/ConfigManager;", "Ljava/io/Serializable;", "", "key", "value", "Ltb/wt2;", "setPathConfig", "getPathConfig", "", "type", "Lcom/youku/arch/v3/core/ConfigManager$CreatorConfig;", "getCreatorConfig", "tag", "Lcom/youku/arch/v3/core/ConfigManager$ParserConfig;", "getParserConfig", "Landroid/util/SparseArray;", "creatorConfigs", "Landroid/util/SparseArray;", "parserConfigs", "Ljava/util/HashMap;", "pathConfigs", "Ljava/util/HashMap;", "Lcom/youku/arch/v3/IViewCreator;", "viewCreator", "Lcom/youku/arch/v3/IViewCreator;", "getViewCreator", "()Lcom/youku/arch/v3/IViewCreator;", "setViewCreator", "(Lcom/youku/arch/v3/IViewCreator;)V", "Lcom/youku/arch/v3/IPresenterCreator;", "presenterCreator", "Lcom/youku/arch/v3/IPresenterCreator;", "getPresenterCreator", "()Lcom/youku/arch/v3/IPresenterCreator;", "setPresenterCreator", "(Lcom/youku/arch/v3/IPresenterCreator;)V", "Lcom/youku/arch/v3/IViewDataBinder;", "viewDataBinder", "Lcom/youku/arch/v3/IViewDataBinder;", "getViewDataBinder", "()Lcom/youku/arch/v3/IViewDataBinder;", "setViewDataBinder", "(Lcom/youku/arch/v3/IViewDataBinder;)V", "<init>", "()V", "Companion", "CreatorConfig", "ParserConfig", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ConfigManager implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String COMPONENT_CONFIG_FILE = "component_config_file";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SparseArray<CreatorConfig> creatorConfigs = new SparseArray<>();
    @NotNull
    private final SparseArray<ParserConfig> parserConfigs = new SparseArray<>();
    @NotNull
    private final HashMap<String, String> pathConfigs = new HashMap<>();
    @Nullable
    private IPresenterCreator<?, ?, ?> presenterCreator;
    @Nullable
    private IViewCreator viewCreator;
    @Nullable
    private IViewDataBinder viewDataBinder;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/core/ConfigManager$Companion;", "", "", "COMPONENT_CONFIG_FILE", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/core/ConfigManager$CreatorConfig;", "Ljava/io/Serializable;", "", "type", "Lcom/youku/arch/v3/ICreator;", "creator", "Ltb/wt2;", "addCreator", "removeCreator", "Landroid/util/SparseArray;", "creators", "Landroid/util/SparseArray;", "getCreators", "()Landroid/util/SparseArray;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class CreatorConfig implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final SparseArray<ICreator<?, ?>> creators = new SparseArray<>();

        public final void addCreator(int i, @NotNull ICreator<?, ?> iCreator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-120335930")) {
                ipChange.ipc$dispatch("-120335930", new Object[]{this, Integer.valueOf(i), iCreator});
                return;
            }
            b41.i(iCreator, "creator");
            this.creators.put(i, iCreator);
        }

        @NotNull
        public final SparseArray<ICreator<?, ?>> getCreators() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1532176013") ? (SparseArray) ipChange.ipc$dispatch("-1532176013", new Object[]{this}) : this.creators;
        }

        public final void removeCreator(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1664752952")) {
                ipChange.ipc$dispatch("-1664752952", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.creators.delete(i);
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/core/ConfigManager$ParserConfig;", "Ljava/io/Serializable;", "", "type", "Lcom/youku/arch/v3/core/parser/IParser;", "parser", "Ltb/wt2;", "addParser", "removeParser", "Landroid/util/SparseArray;", "parsers", "Landroid/util/SparseArray;", "getParsers", "()Landroid/util/SparseArray;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ParserConfig implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final SparseArray<IParser<?, ?>> parsers = new SparseArray<>();

        public final void addParser(int i, @NotNull IParser<?, ?> iParser) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1863440045")) {
                ipChange.ipc$dispatch("-1863440045", new Object[]{this, Integer.valueOf(i), iParser});
                return;
            }
            b41.i(iParser, "parser");
            this.parsers.put(i, iParser);
        }

        @NotNull
        public final SparseArray<IParser<?, ?>> getParsers() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-939810467") ? (SparseArray) ipChange.ipc$dispatch("-939810467", new Object[]{this}) : this.parsers;
        }

        public final void removeParser(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1496801428")) {
                ipChange.ipc$dispatch("-1496801428", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.parsers.remove(i);
            }
        }
    }

    @NotNull
    public final CreatorConfig getCreatorConfig(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518268459")) {
            return (CreatorConfig) ipChange.ipc$dispatch("-518268459", new Object[]{this, Integer.valueOf(i)});
        }
        CreatorConfig creatorConfig = this.creatorConfigs.get(i);
        if (creatorConfig == null) {
            CreatorConfig creatorConfig2 = new CreatorConfig();
            this.creatorConfigs.put(i, creatorConfig2);
            return creatorConfig2;
        }
        return creatorConfig;
    }

    @NotNull
    public final ParserConfig getParserConfig(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297082849")) {
            return (ParserConfig) ipChange.ipc$dispatch("297082849", new Object[]{this, Integer.valueOf(i)});
        }
        ParserConfig parserConfig = this.parserConfigs.get(i);
        if (parserConfig == null) {
            ParserConfig parserConfig2 = new ParserConfig();
            this.parserConfigs.put(i, parserConfig2);
            return parserConfig2;
        }
        return parserConfig;
    }

    @Nullable
    public final String getPathConfig(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643188922")) {
            return (String) ipChange.ipc$dispatch("-1643188922", new Object[]{this, str});
        }
        b41.i(str, "key");
        return this.pathConfigs.get(str);
    }

    @Nullable
    public final IPresenterCreator<?, ?, ?> getPresenterCreator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1469565244") ? (IPresenterCreator) ipChange.ipc$dispatch("-1469565244", new Object[]{this}) : this.presenterCreator;
    }

    @Nullable
    public final IViewCreator getViewCreator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "936630574") ? (IViewCreator) ipChange.ipc$dispatch("936630574", new Object[]{this}) : this.viewCreator;
    }

    @Nullable
    public final IViewDataBinder getViewDataBinder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-30939622") ? (IViewDataBinder) ipChange.ipc$dispatch("-30939622", new Object[]{this}) : this.viewDataBinder;
    }

    public final void setPathConfig(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-290028968")) {
            ipChange.ipc$dispatch("-290028968", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "key");
        b41.i(str2, "value");
        this.pathConfigs.put(str, str2);
    }

    public final void setPresenterCreator(@Nullable IPresenterCreator<?, ?, ?> iPresenterCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540116506")) {
            ipChange.ipc$dispatch("1540116506", new Object[]{this, iPresenterCreator});
        } else {
            this.presenterCreator = iPresenterCreator;
        }
    }

    public final void setViewCreator(@Nullable IViewCreator iViewCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388320956")) {
            ipChange.ipc$dispatch("388320956", new Object[]{this, iViewCreator});
        } else {
            this.viewCreator = iViewCreator;
        }
    }

    public final void setViewDataBinder(@Nullable IViewDataBinder iViewDataBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1367598138")) {
            ipChange.ipc$dispatch("1367598138", new Object[]{this, iViewDataBinder});
        } else {
            this.viewDataBinder = iViewDataBinder;
        }
    }
}
