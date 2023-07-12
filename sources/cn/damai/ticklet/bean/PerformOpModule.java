package cn.damai.ticklet.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PerformOpModule implements Serializable {
    private static final long serialVersionUID = 1;
    public ExtAttr extAttr;
    public String performOpDesc;
    public String performOpType;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class ExtAttr implements Serializable {
        private static final long serialVersionUID = 1;
        public String commentURI;
        public String projectDetailH5Url;
        public String targetUrl;
        public String userNick;
    }
}
