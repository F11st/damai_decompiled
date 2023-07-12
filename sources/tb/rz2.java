package tb;

import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class rz2 {
    @Nullable
    public static WXComponent a(@Nullable String str, @Nullable String str2) {
        return WXSDKManager.v().G().getWXComponent(str, str2);
    }

    @Nullable
    public static View b(@Nullable String str, @Nullable String str2) {
        WXComponent a = a(str, str2);
        if (a == null) {
            return null;
        }
        return a.getHostView();
    }
}
