package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper;

import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RichTextModule;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IRichTextManager extends IRichTextMoreListener {
    void clear();

    String combineRichText(List<String> list);

    ProjectDataHolder geTitle();

    List<ProjectDataHolder> getDisplayRichItems();

    int getItemCount();

    LinkedHashMap<String, Integer> getItemImages();

    int getItemTypePrevious(int i);

    ProjectDataHolder getShrinkRichItem();

    int getStartIndex();

    boolean hasExpanded();

    boolean hasMoreRichItems();

    boolean overLimitedHeight();

    void parseRichText(RichTextModule richTextModule);

    void parseRichText(String str, String str2);

    void setHasMore(boolean z);

    void setOverLimitedHeight(boolean z);

    void setRichType(int i);

    void setStartIndex(int i);

    boolean showAllRichText();
}
