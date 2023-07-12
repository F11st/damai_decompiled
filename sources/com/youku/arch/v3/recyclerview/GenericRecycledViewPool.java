package com.youku.arch.v3.recyclerview;

import android.os.Looper;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/youku/arch/v3/recyclerview/GenericRecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "", "viewType", "max", "Ltb/wt2;", "setMaxRecycledViews", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "putRecycledView", "getRecycledViewCount", "getViewHolderMaxSize", Constants.TAG_CLEAR_STRING, "Landroid/util/SparseIntArray;", "maxScrap", "Landroid/util/SparseIntArray;", "scrapLength", "<init>", "()V", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class GenericRecycledViewPool extends RecyclerView.RecycledViewPool {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_MAX_SIZE = 5;
    @NotNull
    private final SparseIntArray maxScrap = new SparseIntArray();
    @NotNull
    private final SparseIntArray scrapLength = new SparseIntArray();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/recyclerview/GenericRecycledViewPool$Companion;", "", "", "DEFAULT_MAX_SIZE", "I", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389770691")) {
            ipChange.ipc$dispatch("-389770691", new Object[]{this});
            return;
        }
        this.maxScrap.clear();
        this.scrapLength.clear();
        super.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public int getRecycledViewCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687462489")) {
            return ((Integer) ipChange.ipc$dispatch("1687462489", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = this.scrapLength.get(i);
        return i2 <= 0 ? super.getRecycledViewCount(i) : i2;
    }

    public final int getViewHolderMaxSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420327988")) {
            return ((Integer) ipChange.ipc$dispatch("420327988", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = this.maxScrap.get(i);
        if (i2 <= 0) {
            return 5;
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(@NotNull RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119150071")) {
            ipChange.ipc$dispatch("-1119150071", new Object[]{this, viewHolder});
            return;
        }
        b41.i(viewHolder, "viewHolder");
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            int itemViewType = viewHolder.getItemViewType();
            if (this.maxScrap.indexOfKey(itemViewType) < 0) {
                this.maxScrap.put(itemViewType, 5);
                setMaxRecycledViews(itemViewType, 5);
            }
            int i = this.scrapLength.indexOfKey(itemViewType) >= 0 ? this.scrapLength.get(itemViewType) : 0;
            if (this.maxScrap.get(itemViewType) > i) {
                this.scrapLength.put(itemViewType, i + 1);
            }
            super.putRecycledView(viewHolder);
            return;
        }
        throw new IllegalStateException("can not call putRecycledView() outside main thread".toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void setMaxRecycledViews(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905029777")) {
            ipChange.ipc$dispatch("-905029777", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.maxScrap.put(i, i2);
        super.setMaxRecycledViews(i, i2);
    }
}
