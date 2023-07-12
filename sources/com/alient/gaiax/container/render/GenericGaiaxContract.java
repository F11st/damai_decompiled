package com.alient.gaiax.container.render;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import com.youku.css.constraint.CssConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hh1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxContract;", "", "<init>", "()V", ExifInterface.TAG_MODEL, "Presenter", CssConst.CssScenes.VIEW, "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class GenericGaiaxContract {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxContract$Model;", "Lcom/youku/arch/v3/view/IContract$Model;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public interface Model extends IContract.Model<GenericItem<ItemValue>> {
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001J$\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\r"}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxContract$Presenter;", "Lcom/youku/arch/v3/view/IContract$Presenter;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/gaiax/container/render/GenericGaiaxModel;", "Landroid/view/View;", "view", "", "eventName", "Lcom/alibaba/fastjson/JSONObject;", "params", "Ltb/wt2;", "processEvent", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public interface Presenter extends IContract.Presenter<GenericItem<ItemValue>, GenericGaiaxModel> {
        void processEvent(@Nullable android.view.View view, @NotNull String str, @Nullable JSONObject jSONObject);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxContract$View;", "Lcom/youku/arch/v3/view/IContract$View;", "", hh1.DIMEN_BIZ, "templateId", "version", "", "width", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "renderGaiax", "viewVisible", "viewInvisible", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public interface View extends IContract.View {
        void renderGaiax(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull JSONObject jSONObject);

        void viewInvisible();

        void viewVisible();
    }
}
