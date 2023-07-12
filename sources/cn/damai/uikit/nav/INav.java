package cn.damai.uikit.nav;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class INav implements Serializable {
    public INav(Context context) {
    }

    public abstract INav disableTransition();

    public abstract INav forResult(int i);

    public abstract INav needLogin();

    public abstract INav skipHooker();

    public abstract INav skipPreprocess();

    public abstract INav skipPriorHooker();

    public abstract boolean toHost(String str);

    public abstract boolean toUri(Uri uri);

    public abstract boolean toUri(INavUri iNavUri);

    public abstract boolean toUri(String str);

    public abstract INav withExtras(Bundle bundle);

    public abstract INav withFlags(int i);
}
