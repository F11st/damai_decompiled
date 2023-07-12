package cn.damai.onearch.component.evaluate;

import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.evaluate.ui.item.EvaluateItemViewHolder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface OneEvaluate {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Model {
        @NotNull
        CommentsItemBean getEvaluate();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface View {
        @NotNull
        EvaluateItemViewHolder getEvaluateHolder();
    }
}
