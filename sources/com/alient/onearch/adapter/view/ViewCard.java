package com.alient.onearch.adapter.view;

import android.view.View;
import com.alient.oneservice.nav.Action;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\u0007H&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006 "}, d2 = {"Lcom/alient/onearch/adapter/view/ViewCard;", "", "Landroid/view/View;", "view", "Ltb/wt2;", "onItemClick", "onItemLongClick", "", "isDegrade", "enableRankInAll", "enableAutoExposeTrack", "enableAutoClickTrack", "enableAutoAction", "", "key", "Lcom/alient/oneservice/nav/Action;", "getAction", "getItemAction", "()Lcom/alient/oneservice/nav/Action;", "itemAction", "", "getModuleRank", "()I", "moduleRank", "getRankInModule", "rankInModule", "getRankInAll", "rankInAll", "isOnlyChild", "()Z", "isFirstChild", "isLastChild", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public interface ViewCard {
    boolean enableAutoAction();

    boolean enableAutoClickTrack();

    boolean enableAutoExposeTrack();

    boolean enableRankInAll();

    @Nullable
    Action getAction(@Nullable String str);

    @Nullable
    Action getItemAction();

    int getModuleRank();

    int getRankInAll();

    int getRankInModule();

    boolean isDegrade();

    boolean isFirstChild();

    boolean isLastChild();

    boolean isOnlyChild();

    void onItemClick(@NotNull View view);

    void onItemLongClick(@NotNull View view);
}
