package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.C6368e;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class c90 {
    @NonNull
    public static String a(C6368e c6368e) {
        StringBuilder sb = new StringBuilder();
        if (c6368e == null) {
            sb.append("dxError is null");
            return sb.toString();
        }
        for (C6368e.C6369a c6369a : c6368e.c) {
            sb.append(c6369a.toString());
        }
        return sb.toString();
    }
}
