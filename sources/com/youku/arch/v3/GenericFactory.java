package com.youku.arch.v3;

import android.util.SparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.Config;
import com.youku.arch.v3.core.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import mtopsdk.mtop.intf.Mtop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\b\u0007\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n¢\u0006\u0004\b\u0018\u0010\u0014J\u001d\u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bR0\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/youku/arch/v3/GenericFactory;", Mtop.Id.PRODUCT, "CONFIG", "", "Lcom/youku/arch/v3/core/Config;", Constants.CONFIG, "create", "(Lcom/youku/arch/v3/core/Config;)Ljava/lang/Object;", "", "key", "Lcom/youku/arch/v3/ICreator;", "creator", "Ltb/wt2;", "addExtendedCreator", "removeExtendedCreator", "defaultCreator", "Lcom/youku/arch/v3/ICreator;", "getDefaultCreator", "()Lcom/youku/arch/v3/ICreator;", "setDefaultCreator", "(Lcom/youku/arch/v3/ICreator;)V", "Landroid/util/SparseArray;", "creators", "Landroid/util/SparseArray;", "<init>", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericFactory<PRODUCT, CONFIG> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final SparseArray<ICreator<PRODUCT, CONFIG>> creators;
    @Nullable
    private ICreator<PRODUCT, CONFIG> defaultCreator;

    @JvmOverloads
    public GenericFactory() {
        this(null, 1, null);
    }

    @JvmOverloads
    public GenericFactory(@Nullable ICreator<PRODUCT, CONFIG> iCreator) {
        this.defaultCreator = iCreator;
        this.creators = new SparseArray<>();
    }

    public final void addExtendedCreator(int i, @NotNull ICreator<PRODUCT, CONFIG> iCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-803396737")) {
            ipChange.ipc$dispatch("-803396737", new Object[]{this, Integer.valueOf(i), iCreator});
            return;
        }
        b41.i(iCreator, "creator");
        this.creators.put(i, iCreator);
    }

    @Nullable
    public final PRODUCT create(@NotNull Config<CONFIG> config) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98659153")) {
            return (PRODUCT) ipChange.ipc$dispatch("-98659153", new Object[]{this, config});
        }
        b41.i(config, Constants.CONFIG);
        ICreator<PRODUCT, CONFIG> iCreator = this.creators.get(config.getType());
        if (iCreator != null) {
            return iCreator.create(config);
        }
        ICreator<PRODUCT, CONFIG> iCreator2 = this.defaultCreator;
        if (iCreator2 == null) {
            return null;
        }
        return iCreator2.create(config);
    }

    @Nullable
    public final ICreator<PRODUCT, CONFIG> getDefaultCreator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1196521057") ? (ICreator) ipChange.ipc$dispatch("1196521057", new Object[]{this}) : this.defaultCreator;
    }

    public final void removeExtendedCreator(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411185501")) {
            ipChange.ipc$dispatch("1411185501", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.creators.remove(i);
        }
    }

    public final void setDefaultCreator(@Nullable ICreator<PRODUCT, CONFIG> iCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786511143")) {
            ipChange.ipc$dispatch("786511143", new Object[]{this, iCreator});
        } else {
            this.defaultCreator = iCreator;
        }
    }

    public /* synthetic */ GenericFactory(ICreator iCreator, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : iCreator);
    }
}
