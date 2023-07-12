package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001eJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001a\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017¨\u0006 "}, d2 = {"Lcom/youku/arch/v3/core/Coordinate;", "", "other", "", "equals", "", "toString", "", "hashCode", "moduleIndex", "I", "getModuleIndex", "()I", "setModuleIndex", "(I)V", "componentIndex", "getComponentIndex", "setComponentIndex", "itemIndex", "getItemIndex", "setItemIndex", "isModuleCoordinate", "Z", "()Z", "isComponentCoordinate", "isItemCoordinate", "isContainerCoordinate", "<init>", "(III)V", "coordinate", "(Lcom/youku/arch/v3/core/Coordinate;)V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Coordinate {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int FLAG_NONE = -2;
    public static final int FLAG_UNDEFINE = -1;
    private int componentIndex;
    private final boolean isComponentCoordinate;
    private final boolean isContainerCoordinate;
    private final boolean isItemCoordinate;
    private final boolean isModuleCoordinate;
    private int itemIndex;
    private int moduleIndex;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/youku/arch/v3/core/Coordinate$Companion;", "", "", "FLAG_NONE", "I", "FLAG_UNDEFINE", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public Coordinate(int i, int i2, int i3) {
        this.moduleIndex = i;
        this.componentIndex = i2;
        this.itemIndex = i3;
        boolean z = true;
        this.isModuleCoordinate = (i == -2 || i == -1 || (i2 != -2 && i2 != -1) || (i3 != -2 && i3 != -1)) ? false : true;
        this.isComponentCoordinate = (i == -2 || i == -1 || i2 == -2 || i == -1 || (i3 != -2 && i3 != -1)) ? false : true;
        this.isItemCoordinate = (i == -2 || i == -1 || i2 == -2 || i == -1 || i3 == -2 || i3 == -1) ? false : true;
        if ((i != -2 && i != -1) || ((i2 != -2 && i2 != -1) || (i3 != -2 && i3 != -1))) {
            z = false;
        }
        this.isContainerCoordinate = z;
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902478215")) {
            return ((Boolean) ipChange.ipc$dispatch("-902478215", new Object[]{this, obj})).booleanValue();
        }
        Coordinate coordinate = (Coordinate) obj;
        if (coordinate != null) {
            if (this == obj) {
                return true;
            }
            if (this.moduleIndex == coordinate.moduleIndex && this.componentIndex == coordinate.componentIndex && this.itemIndex == coordinate.itemIndex) {
                return true;
            }
        }
        return false;
    }

    public final int getComponentIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1532623194") ? ((Integer) ipChange.ipc$dispatch("1532623194", new Object[]{this})).intValue() : this.componentIndex;
    }

    public final int getItemIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "133436738") ? ((Integer) ipChange.ipc$dispatch("133436738", new Object[]{this})).intValue() : this.itemIndex;
    }

    public final int getModuleIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1375259995") ? ((Integer) ipChange.ipc$dispatch("1375259995", new Object[]{this})).intValue() : this.moduleIndex;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1747405872") ? ((Integer) ipChange.ipc$dispatch("1747405872", new Object[]{this})).intValue() : (((this.moduleIndex * 31) + this.componentIndex) * 31) + this.itemIndex;
    }

    public final boolean isComponentCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-651541269") ? ((Boolean) ipChange.ipc$dispatch("-651541269", new Object[]{this})).booleanValue() : this.isComponentCoordinate;
    }

    public final boolean isContainerCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1512543257") ? ((Boolean) ipChange.ipc$dispatch("-1512543257", new Object[]{this})).booleanValue() : this.isContainerCoordinate;
    }

    public final boolean isItemCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1186976153") ? ((Boolean) ipChange.ipc$dispatch("-1186976153", new Object[]{this})).booleanValue() : this.isItemCoordinate;
    }

    public final boolean isModuleCoordinate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "844755310") ? ((Boolean) ipChange.ipc$dispatch("844755310", new Object[]{this})).booleanValue() : this.isModuleCoordinate;
    }

    public final void setComponentIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492047736")) {
            ipChange.ipc$dispatch("-1492047736", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.componentIndex = i;
        }
    }

    public final void setItemIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989841400")) {
            ipChange.ipc$dispatch("-1989841400", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.itemIndex = i;
        }
    }

    public final void setModuleIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603450383")) {
            ipChange.ipc$dispatch("603450383", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.moduleIndex = i;
        }
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095344684")) {
            return (String) ipChange.ipc$dispatch("-1095344684", new Object[]{this});
        }
        return "pos@[" + this.moduleIndex + AVFSCacheConstants.COMMA_SEP + this.componentIndex + AVFSCacheConstants.COMMA_SEP + this.itemIndex + jn1.ARRAY_END;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Coordinate(@NotNull Coordinate coordinate) {
        this(coordinate.moduleIndex, coordinate.componentIndex, coordinate.itemIndex);
        b41.i(coordinate, "coordinate");
    }
}
