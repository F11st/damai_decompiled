package cn.damai.onearch.component.scripttag;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ScriptTagBean implements Serializable {
    public String componentType;
    public List<Tag> lineItem;
    public String name;
    public String option;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class Tag implements Serializable {
        public String name;
        public String value;
    }
}
