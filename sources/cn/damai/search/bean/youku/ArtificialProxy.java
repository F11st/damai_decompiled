package cn.damai.search.bean.youku;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ArtificialProxy extends Serializable {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum Type {
        NOTE("note"),
        THEME("theme");
        
        public String utName;

        Type(String str) {
            this.utName = str;
        }
    }

    String getId();

    String getImgUrl();

    CharSequence getTitle();

    PageSpec getToPageSpec();

    Type getType();

    int index();

    boolean isShowVideoTag();

    boolean isValid();
}
