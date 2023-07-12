package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.e;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class c90 {
    @NonNull
    public static String a(com.taobao.android.dinamicx.e eVar) {
        StringBuilder sb = new StringBuilder();
        if (eVar == null) {
            sb.append("dxError is null");
            return sb.toString();
        }
        for (e.a aVar : eVar.c) {
            sb.append(aVar.toString());
        }
        return sb.toString();
    }
}
