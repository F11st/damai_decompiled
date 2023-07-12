package cn.damai.search.bean;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchSuggest {
    public String alg;
    public int index;
    public String keyword;
    public String sugWord;

    public SearchSuggest() {
    }

    public SearchSuggest(String str, String str2) {
        this.keyword = str;
        this.sugWord = str2;
    }
}
