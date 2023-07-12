package tb;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class o83 extends com.loc.bl {
    @Override // com.loc.bl
    public String m() {
        Uri.Builder buildUpon;
        String str;
        if (TextUtils.isEmpty(j())) {
            return j();
        }
        String j = j();
        Uri parse = Uri.parse(j);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return j;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            buildUpon = parse.buildUpon();
            str = "dualstack-arestapi.amap.com";
        } else {
            buildUpon = parse.buildUpon();
            str = "dualstack-" + parse.getAuthority();
        }
        return buildUpon.authority(str).build().toString();
    }
}
