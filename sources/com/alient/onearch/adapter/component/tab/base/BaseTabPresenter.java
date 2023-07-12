package com.alient.onearch.adapter.component.tab.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.onearch.adapter.widget.RichTitle;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.Constants;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.IContract;
import com.youku.arch.v3.view.IContract.Model;
import com.youku.arch.v3.view.IContract.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\b\b\u0002\u0010\u0007*\u00020\u00062\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\bB3\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010&\u001a\u00020$\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010+\u001a\u0004\u0018\u00010$¢\u0006\u0004\b,\u0010-J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u0014\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\rH&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/alient/onearch/adapter/component/tab/base/BaseTabPresenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "I", "Lcom/youku/arch/v3/view/IContract$Model;", "M", "Lcom/youku/arch/v3/view/IContract$View;", "V", "Lcom/alient/onearch/adapter/view/AbsPresenter;", "item", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "(Lcom/youku/arch/v3/core/item/GenericItem;)V", "", "Lcom/alient/onearch/adapter/widget/RichTitle;", "childComponentTitles", "Lcom/alibaba/fastjson/JSONArray;", "childComponentBtns", "Lcom/youku/arch/v3/core/Node;", "childComponentNodes", "renderTabInView", "", "changed", "responsiveLayoutStateChanged", "", "Ljava/util/List;", "getChildComponentTitles", "()Ljava/util/List;", "setChildComponentTitles", "(Ljava/util/List;)V", "getChildComponentBtns", "setChildComponentBtns", "getChildComponentNodes", "setChildComponentNodes", "oldItem", "Lcom/youku/arch/v3/core/item/GenericItem;", "", "mClassName", "vClassName", "Landroid/view/View;", "renderView", "Lcom/youku/arch/v3/event/EventHandler;", "eventHandler", Constants.CONFIG, "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/youku/arch/v3/event/EventHandler;Ljava/lang/String;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BaseTabPresenter<I extends GenericItem<ItemValue>, M extends IContract.Model<I>, V extends IContract.View> extends AbsPresenter<I, M, V> {
    @NotNull
    private List<JSONArray> childComponentBtns;
    @NotNull
    private List<Node> childComponentNodes;
    @NotNull
    private List<RichTitle> childComponentTitles;
    @Nullable
    private GenericItem<ItemValue> oldItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTabPresenter(@NotNull String str, @NotNull String str2, @Nullable android.view.View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.childComponentTitles = new ArrayList();
        this.childComponentBtns = new ArrayList();
        this.childComponentNodes = new ArrayList();
    }

    @NotNull
    public List<JSONArray> getChildComponentBtns() {
        return this.childComponentBtns;
    }

    @NotNull
    public List<Node> getChildComponentNodes() {
        return this.childComponentNodes;
    }

    @NotNull
    public List<RichTitle> getChildComponentTitles() {
        return this.childComponentTitles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public /* bridge */ /* synthetic */ void init(IItem iItem) {
        init((BaseTabPresenter<I, M, V>) ((GenericItem) iItem));
    }

    public abstract void renderTabInView(@NotNull List<RichTitle> list, @NotNull List<? extends JSONArray> list2, @NotNull List<? extends Node> list3);

    @Override // com.alient.onearch.adapter.view.AbsPresenter
    public void responsiveLayoutStateChanged(boolean z) {
        if (z) {
            this.oldItem = null;
        }
    }

    public void setChildComponentBtns(@NotNull List<JSONArray> list) {
        b41.i(list, "<set-?>");
        this.childComponentBtns = list;
    }

    public void setChildComponentNodes(@NotNull List<Node> list) {
        b41.i(list, "<set-?>");
        this.childComponentNodes = list;
    }

    public void setChildComponentTitles(@NotNull List<RichTitle> list) {
        b41.i(list, "<set-?>");
        this.childComponentTitles = list;
    }

    public void init(@NotNull I i) {
        String string;
        b41.i(i, "item");
        super.init((BaseTabPresenter<I, M, V>) i);
        if (b41.d(this.oldItem, i)) {
            return;
        }
        this.oldItem = i;
        getChildComponentTitles().clear();
        getChildComponentBtns().clear();
        getChildComponentNodes().clear();
        List<Node> children = i.getProperty().getChildren();
        if (children == null) {
            return;
        }
        for (Node node : children) {
            JSONObject data = node.getData();
            if (data != null && (string = data.getString("title")) != null) {
                getChildComponentTitles().add(new RichTitle(string, Integer.valueOf(data.getIntValue(OneArchConstants.LayoutKey.TITLE_RIGHT_IMAGE_TYPE)), data.getString(OneArchConstants.LayoutKey.TITLE_RIGHT_IMAGE), null, 0, 24, null));
                getChildComponentNodes().add(node);
                JSONArray jSONArray = data.getJSONArray(OneArchConstants.LayoutKey.KEY_WORDS);
                if (jSONArray == null) {
                    getChildComponentBtns().add(new JSONArray());
                } else {
                    getChildComponentBtns().add(jSONArray);
                }
            }
        }
        renderTabInView(getChildComponentTitles(), getChildComponentBtns(), getChildComponentNodes());
    }
}
