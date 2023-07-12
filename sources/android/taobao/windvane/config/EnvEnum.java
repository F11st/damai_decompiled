package android.taobao.windvane.config;

import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum EnvEnum {
    ONLINE(0, WXComponent.PROP_FS_MATCH_PARENT),
    PRE(1, "wapa"),
    DAILY(2, "waptest");
    
    private int key;
    private String value;

    EnvEnum(int i, String str) {
        this.key = i;
        this.value = str;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
