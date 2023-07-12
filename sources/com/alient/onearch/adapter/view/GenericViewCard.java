package com.alient.onearch.adapter.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.util.MediaBrowserUtil;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.alimovie.popcorn.Popcorn;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0013\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00118V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0016\u0010(\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u0006."}, d2 = {"Lcom/alient/onearch/adapter/view/GenericViewCard;", "Lcom/alient/onearch/adapter/view/ViewCard;", "Ltb/wt2;", "bindAutoExposeTrack", "initTrackInfo", "Landroid/view/View;", "view", "onItemClick", "onItemLongClick", "", "isDegrade", "enableRankInAll", "enableAutoExposeTrack", "enableAutoClickTrack", "enableAutoAction", "", "key", "Lcom/alient/oneservice/nav/Action;", "getAction", "viewCard", "Lcom/alient/onearch/adapter/view/ViewCard;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "item", "Lcom/youku/arch/v3/IItem;", "", "actions", "Ljava/util/Map;", "Landroid/view/View;", "getItemAction", "()Lcom/alient/oneservice/nav/Action;", "itemAction", "", "getModuleRank", "()I", "moduleRank", "getRankInModule", "rankInModule", "getRankInAll", "rankInAll", "isOnlyChild", "()Z", "isFirstChild", "isLastChild", "<init>", "(Lcom/alient/onearch/adapter/view/ViewCard;Lcom/youku/arch/v3/IItem;Ljava/util/Map;Landroid/view/View;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class GenericViewCard implements ViewCard {
    @Nullable
    private final Map<String, Action> actions;
    @NotNull
    private final IItem<ItemValue> item;
    @Nullable
    private final View view;
    @NotNull
    private final ViewCard viewCard;

    /* JADX WARN: Multi-variable type inference failed */
    public GenericViewCard(@NotNull ViewCard viewCard, @NotNull IItem<ItemValue> iItem, @Nullable Map<String, ? extends Action> map, @Nullable View view) {
        b41.i(viewCard, "viewCard");
        b41.i(iItem, "item");
        this.viewCard = viewCard;
        this.item = iItem;
        this.actions = map;
        this.view = view;
        initTrackInfo();
        bindAutoExposeTrack();
    }

    private final void bindAutoExposeTrack() {
        Action itemAction;
        TrackInfo trackInfo;
        if (!enableAutoExposeTrack() || (itemAction = getItemAction()) == null || (trackInfo = itemAction.getTrackInfo()) == null) {
            return;
        }
        UserTrackProviderProxy.expose(this.view, trackInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0101 A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:49:0x00e6, B:71:0x0146, B:73:0x0163, B:74:0x016f, B:78:0x0176, B:79:0x018a, B:81:0x0198, B:86:0x01b2, B:88:0x01d6, B:89:0x01e6, B:91:0x0203, B:93:0x0217, B:95:0x025c, B:94:0x0237, B:85:0x019f, B:52:0x00ed, B:54:0x00f5, B:60:0x0101, B:62:0x011a, B:68:0x0126, B:70:0x012c), top: B:103:0x00e6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void initTrackInfo() {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.onearch.adapter.view.GenericViewCard.initTrackInfo():void");
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        return this.viewCard.enableAutoAction();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        return this.viewCard.enableAutoClickTrack();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        return this.viewCard.enableAutoExposeTrack();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean enableRankInAll() {
        return this.viewCard.enableRankInAll();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getAction(@Nullable String str) {
        Map<String, Action> map = this.actions;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    @Nullable
    public Action getItemAction() {
        Map<String, Action> map = this.actions;
        if (map == null) {
            return null;
        }
        return map.get("item");
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getModuleRank() {
        int i = 0;
        for (IComponent<ComponentValue> iComponent : this.item.getComponent().getModule().getComponents()) {
            if (iComponent.getType() == this.item.getComponent().getType()) {
                return i;
            }
            if (iComponent.getProperty().getData() != null) {
                JSONObject data = iComponent.getProperty().getData();
                b41.f(data);
                if (!data.isEmpty()) {
                    i++;
                }
            }
        }
        return -1;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInAll() {
        int index = this.item.getIndex();
        for (IModule<ModuleValue> iModule : this.item.getComponent().getModule().getContainer().getCurrentModules()) {
            for (IComponent<ComponentValue> iComponent : iModule.getComponents()) {
                index += iComponent.getChildCount();
                if (iComponent.getType() == this.item.getComponent().getType()) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public int getRankInModule() {
        return this.item.getIndex();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isDegrade() {
        return this.viewCard.isDegrade();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isFirstChild() {
        return this.item.getIndex() == 0;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isLastChild() {
        return !this.item.getComponent().hasNext() && this.item.getComponent().getChildCount() - 1 == this.item.getIndex();
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public boolean isOnlyChild() {
        return !this.item.getComponent().hasNext() && this.item.getComponent().getChildCount() == 1;
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemClick(@NotNull View view) {
        TrackInfo trackInfo;
        b41.i(view, "view");
        this.viewCard.onItemClick(view);
        Action itemAction = getItemAction();
        if (itemAction == null) {
            return;
        }
        if (enableAutoAction()) {
            if (itemAction.getActionType() == 4) {
                MediaBrowserUtil.INSTANCE.processMediaBrowserParams(this.item, itemAction);
            }
            NavProviderProxy.toUri(view.getContext(), itemAction);
        }
        if (!enableAutoClickTrack() || (trackInfo = itemAction.getTrackInfo()) == null) {
            return;
        }
        if (itemAction.getActionType() != 1 && itemAction.getActionType() != 2) {
            if (itemAction.getActionType() == 0 || itemAction.getActionType() == 3) {
                UserTrackProviderProxy.click(view, trackInfo, false);
                return;
            }
            return;
        }
        UserTrackProviderProxy.click(view, trackInfo, true);
    }

    @Override // com.alient.onearch.adapter.view.ViewCard
    public void onItemLongClick(@NotNull View view) {
        Activity activity;
        SharedPreferences sharedPreferences;
        b41.i(view, "view");
        this.viewCard.onItemLongClick(view);
        if (!AppInfoProviderProxy.isDebuggable() || (activity = this.item.getPageContext().getActivity()) == null || (sharedPreferences = activity.getSharedPreferences("mock_popcorn", 0)) == null || !sharedPreferences.getBoolean("enableItemJSON", false)) {
            return;
        }
        Context context = view.getContext();
        JSONObject rawJson = this.item.getProperty().getRawJson();
        Popcorn.showJsonView(context, rawJson == null ? null : rawJson.toJSONString());
    }
}
