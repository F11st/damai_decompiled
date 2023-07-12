package cn.damai.evaluate.ui;

import android.view.View;
import cn.damai.comment.bean.CommentContentLabelBean;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public interface EvaluateListCallBack {
    void labelClick(CommentContentLabelBean commentContentLabelBean);

    void resetLabel(CommentContentLabelBean commentContentLabelBean);

    void setChooseLabel(CommentContentLabelBean commentContentLabelBean);

    void setItemExposure(View view, int i, String str);
}
