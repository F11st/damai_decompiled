package cn.damai.push.model;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PushMessageBean implements Serializable {
    private static final long serialVersionUID = -1;
    public String channel;
    public Exts exts;
    public String text;
    public String title;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class Exts implements Serializable {
        private static final long serialVersionUID = -1;
        public String tag;
        public String type;
        public String url;
        public String value;

        public Exts() {
        }
    }
}
