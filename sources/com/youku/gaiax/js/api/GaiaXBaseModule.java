package com.youku.gaiax.js.api;

import androidx.annotation.Keep;
import com.youku.gaiax.js.utils.IdGenerator;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Lcom/youku/gaiax/js/api/IGaiaXModule;", "", "_id$delegate", "Lkotlin/Lazy;", "get_id", "()J", "_id", "getId", "id", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class GaiaXBaseModule implements IGaiaXModule {
    @NotNull
    private final Lazy _id$delegate;

    public GaiaXBaseModule() {
        Lazy b;
        b = C8177b.b(new Function0<Long>() { // from class: com.youku.gaiax.js.api.GaiaXBaseModule$_id$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(IdGenerator.INSTANCE.genLongId());
            }
        });
        this._id$delegate = b;
    }

    private final long get_id() {
        return ((Number) this._id$delegate.getValue()).longValue();
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    public long getId() {
        return get_id();
    }
}
