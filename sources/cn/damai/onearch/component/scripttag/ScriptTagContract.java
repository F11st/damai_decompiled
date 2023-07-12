package cn.damai.onearch.component.scripttag;

import com.alient.onearch.adapter.widget.RichTitle;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.IContract;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ScriptTagContract implements IContract {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Model extends IContract.Model<GenericItem<ItemValue>> {
        @NotNull
        String getTagValue(int i);

        @NotNull
        List<RichTitle> getTags();

        @NotNull
        String getTagsOption();

        @NotNull
        String getTargetComponentType();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Presenter extends IContract.Presenter<GenericItem<ItemValue>, ScriptTagModel> {
        void selectTag(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface View extends IContract.View {
        void renderTags(@NotNull List<RichTitle> list, int i);
    }
}
