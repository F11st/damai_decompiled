package cn.damai.search.bean;

import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public enum SearchResultTabEnum {
    ALL(0, "全部"),
    PERFORMANCE(1, ErrControlViewInfo.TYPE_PROJECT),
    SCRIPT(2, ErrControlViewInfo.TYPE_SCRIPT),
    ARTIST(3, ErrControlViewInfo.TYPE_ARTIST),
    BRAND(4, ErrControlViewInfo.TYPE_BRAND_IP),
    VENUE(5, ErrControlViewInfo.TYPE_VENUE),
    INFORMATION(6, ErrControlViewInfo.TYPE_FEED);
    
    public static final Map<String, SearchResultTabEnum> MAP = new HashMap();
    public String content;
    public int index;

    static {
        SearchResultTabEnum[] values;
        for (SearchResultTabEnum searchResultTabEnum : values()) {
            MAP.put(searchResultTabEnum.content, searchResultTabEnum);
        }
    }

    SearchResultTabEnum(int i, String str) {
        this.index = i;
        this.content = str;
    }

    public static SearchResultTabEnum valueOfContent(String str) {
        return MAP.get(str);
    }
}
