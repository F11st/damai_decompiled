package com.youku.arch.v3.page;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.util.Util;
import io.flutter.wpkbridge.WPKFactory;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR$\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&¨\u0006."}, d2 = {"Lcom/youku/arch/v3/page/RecycleViewSettings;", "Ljava/io/Serializable;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Ltb/wt2;", "setItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "itemAnimator", "setItemAnimator", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", Constants.CONFIG, "enableItemAnimator", "disableItemAnimator", "Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "layoutManager", "Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "getLayoutManager", "()Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "setLayoutManager", "(Lcom/alibaba/android/vlayout/VirtualLayoutManager;)V", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "adapter", "Lcom/youku/arch/v3/adapter/ContentAdapter;", "getAdapter", "()Lcom/youku/arch/v3/adapter/ContentAdapter;", "setAdapter", "(Lcom/youku/arch/v3/adapter/ContentAdapter;)V", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "", "<set-?>", "isItemAnimatorEnable", "Z", "()Z", "", "addDuration", "J", "removeDuration", "moveDuration", "changeDuration", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RecycleViewSettings implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ContentAdapter adapter;
    @Nullable
    private RecyclerView.ItemDecoration decoration;
    @Nullable
    private RecyclerView.ItemAnimator itemAnimator;
    @Nullable
    private VirtualLayoutManager layoutManager;
    private boolean isItemAnimatorEnable = true;
    private long addDuration = 120;
    private long removeDuration = 120;
    private long moveDuration = 250;
    private long changeDuration = 250;

    public RecycleViewSettings(@Nullable Context context) {
    }

    public final void config(@NotNull RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901496420")) {
            ipChange.ipc$dispatch("-901496420", new Object[]{this, recyclerView});
            return;
        }
        b41.i(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = this.itemAnimator;
        if (itemAnimator != null) {
            recyclerView.setItemAnimator(itemAnimator);
        }
        Util.throwIf(this.layoutManager == null);
        recyclerView.setLayoutManager(this.layoutManager);
        RecyclerView.ItemDecoration itemDecoration = this.decoration;
        if (itemDecoration != null) {
            b41.f(itemDecoration);
            recyclerView.addItemDecoration(itemDecoration);
        }
        Util.throwIf(this.adapter == null);
        recyclerView.setAdapter(this.adapter);
    }

    public final void disableItemAnimator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-505110517")) {
            ipChange.ipc$dispatch("-505110517", new Object[]{this});
            return;
        }
        RecyclerView.ItemAnimator itemAnimator = this.itemAnimator;
        if (itemAnimator != null && this.isItemAnimatorEnable) {
            b41.f(itemAnimator);
            this.addDuration = itemAnimator.getAddDuration();
            RecyclerView.ItemAnimator itemAnimator2 = this.itemAnimator;
            b41.f(itemAnimator2);
            this.removeDuration = itemAnimator2.getRemoveDuration();
            RecyclerView.ItemAnimator itemAnimator3 = this.itemAnimator;
            b41.f(itemAnimator3);
            this.changeDuration = itemAnimator3.getChangeDuration();
            RecyclerView.ItemAnimator itemAnimator4 = this.itemAnimator;
            b41.f(itemAnimator4);
            this.moveDuration = itemAnimator4.getMoveDuration();
            RecyclerView.ItemAnimator itemAnimator5 = this.itemAnimator;
            b41.f(itemAnimator5);
            itemAnimator5.setAddDuration(0L);
            RecyclerView.ItemAnimator itemAnimator6 = this.itemAnimator;
            b41.f(itemAnimator6);
            itemAnimator6.setRemoveDuration(0L);
            RecyclerView.ItemAnimator itemAnimator7 = this.itemAnimator;
            b41.f(itemAnimator7);
            itemAnimator7.setChangeDuration(0L);
            RecyclerView.ItemAnimator itemAnimator8 = this.itemAnimator;
            b41.f(itemAnimator8);
            itemAnimator8.setMoveDuration(0L);
        }
        this.isItemAnimatorEnable = false;
    }

    public final void enableItemAnimator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344385312")) {
            ipChange.ipc$dispatch("1344385312", new Object[]{this});
            return;
        }
        RecyclerView.ItemAnimator itemAnimator = this.itemAnimator;
        if (itemAnimator != null && !this.isItemAnimatorEnable) {
            b41.f(itemAnimator);
            itemAnimator.setAddDuration(this.addDuration);
            RecyclerView.ItemAnimator itemAnimator2 = this.itemAnimator;
            b41.f(itemAnimator2);
            itemAnimator2.setRemoveDuration(this.removeDuration);
            RecyclerView.ItemAnimator itemAnimator3 = this.itemAnimator;
            b41.f(itemAnimator3);
            itemAnimator3.setChangeDuration(this.changeDuration);
            RecyclerView.ItemAnimator itemAnimator4 = this.itemAnimator;
            b41.f(itemAnimator4);
            itemAnimator4.setMoveDuration(this.moveDuration);
        }
        this.isItemAnimatorEnable = true;
    }

    @Nullable
    public final ContentAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1266728318") ? (ContentAdapter) ipChange.ipc$dispatch("1266728318", new Object[]{this}) : this.adapter;
    }

    @Nullable
    public final VirtualLayoutManager getLayoutManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "965270093") ? (VirtualLayoutManager) ipChange.ipc$dispatch("965270093", new Object[]{this}) : this.layoutManager;
    }

    public final boolean isItemAnimatorEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1862788890") ? ((Boolean) ipChange.ipc$dispatch("1862788890", new Object[]{this})).booleanValue() : this.isItemAnimatorEnable;
    }

    public final void setAdapter(@Nullable ContentAdapter contentAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338496452")) {
            ipChange.ipc$dispatch("-1338496452", new Object[]{this, contentAdapter});
        } else {
            this.adapter = contentAdapter;
        }
    }

    public final void setItemAnimator(@Nullable RecyclerView.ItemAnimator itemAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "929088428")) {
            ipChange.ipc$dispatch("929088428", new Object[]{this, itemAnimator});
        } else {
            this.itemAnimator = itemAnimator;
        }
    }

    public final void setItemDecoration(@Nullable RecyclerView.ItemDecoration itemDecoration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124415130")) {
            ipChange.ipc$dispatch("2124415130", new Object[]{this, itemDecoration});
        } else {
            this.decoration = itemDecoration;
        }
    }

    public final void setLayoutManager(@Nullable VirtualLayoutManager virtualLayoutManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-819261405")) {
            ipChange.ipc$dispatch("-819261405", new Object[]{this, virtualLayoutManager});
        } else {
            this.layoutManager = virtualLayoutManager;
        }
    }
}
