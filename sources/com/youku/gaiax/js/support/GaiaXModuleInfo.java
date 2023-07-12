package com.youku.gaiax.js.support;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.rz0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXModuleInfo;", "", "", "component1", "", "component2", "component3", "name", "id", "simpleName", rz0.ARG_COPY, "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "J", "getId", "()J", "getSimpleName", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXModuleInfo {
    private final long id;
    @NotNull
    private final String name;
    @NotNull
    private final String simpleName;

    public GaiaXModuleInfo(@NotNull String str, long j, @NotNull String str2) {
        b41.i(str, "name");
        b41.i(str2, "simpleName");
        this.name = str;
        this.id = j;
        this.simpleName = str2;
    }

    public static /* synthetic */ GaiaXModuleInfo copy$default(GaiaXModuleInfo gaiaXModuleInfo, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gaiaXModuleInfo.name;
        }
        if ((i & 2) != 0) {
            j = gaiaXModuleInfo.id;
        }
        if ((i & 4) != 0) {
            str2 = gaiaXModuleInfo.simpleName;
        }
        return gaiaXModuleInfo.copy(str, j, str2);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final long component2() {
        return this.id;
    }

    @NotNull
    public final String component3() {
        return this.simpleName;
    }

    @NotNull
    public final GaiaXModuleInfo copy(@NotNull String str, long j, @NotNull String str2) {
        b41.i(str, "name");
        b41.i(str2, "simpleName");
        return new GaiaXModuleInfo(str, j, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GaiaXModuleInfo) {
            GaiaXModuleInfo gaiaXModuleInfo = (GaiaXModuleInfo) obj;
            return b41.d(this.name, gaiaXModuleInfo.name) && this.id == gaiaXModuleInfo.id && b41.d(this.simpleName, gaiaXModuleInfo.simpleName);
        }
        return false;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getSimpleName() {
        return this.simpleName;
    }

    public int hashCode() {
        long j = this.id;
        return (((this.name.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.simpleName.hashCode();
    }

    @NotNull
    public String toString() {
        return "GaiaXModuleInfo(name=" + this.name + ", id=" + this.id + ", simpleName=" + this.simpleName + ')';
    }
}
