package com.youku.arch.v3.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import com.youku.arch.v3.Addressable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0016\u0010\f\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/youku/arch/v3/core/ChildIndexUpdater;", "Lcom/youku/arch/v3/Addressable;", "T", "Lcom/youku/arch/v3/core/OnChildAttachStateChangeListener;", "", "hasChanged", "addressable", "Ltb/wt2;", "onChildAdded", "onChildRemoved", "", RichTextNode.CHILDREN, "updateChildIndex", "changed", "Z", "getChanged", "()Z", "setChanged", "(Z)V", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ChildIndexUpdater<T extends Addressable> implements OnChildAttachStateChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean changed = true;

    public final boolean getChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-390685365") ? ((Boolean) ipChange.ipc$dispatch("-390685365", new Object[]{this})).booleanValue() : this.changed;
    }

    public final boolean hasChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "596532111") ? ((Boolean) ipChange.ipc$dispatch("596532111", new Object[]{this})).booleanValue() : this.changed;
    }

    @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
    public void onChildAdded(@NotNull Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117167070")) {
            ipChange.ipc$dispatch("117167070", new Object[]{this, addressable});
            return;
        }
        b41.i(addressable, "addressable");
        this.changed = true;
    }

    @Override // com.youku.arch.v3.core.OnChildAttachStateChangeListener
    public void onChildRemoved(@NotNull Addressable addressable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733694078")) {
            ipChange.ipc$dispatch("1733694078", new Object[]{this, addressable});
            return;
        }
        b41.i(addressable, "addressable");
        this.changed = true;
    }

    public final void setChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998034975")) {
            ipChange.ipc$dispatch("-998034975", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.changed = z;
        }
    }

    public final void updateChildIndex(@Nullable List<? extends T> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "268483159")) {
            ipChange.ipc$dispatch("268483159", new Object[]{this, list});
        } else if (this.changed) {
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
            int size = list.size() - 1;
            if (size >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    list.get(i).setIndex(i);
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                }
            }
            this.changed = false;
        }
    }
}
