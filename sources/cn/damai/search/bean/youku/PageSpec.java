package cn.damai.search.bean.youku;

import android.os.Bundle;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class PageSpec implements Serializable {
    public final Bundle mBundle;
    public final String url;

    public PageSpec(String str, Bundle bundle) {
        this.url = str;
        this.mBundle = bundle;
    }
}
