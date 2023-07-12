package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wy {
    public static final byte BranchBlock = 5;
    public static final byte Const = 3;
    public static final byte Event = 6;
    public static final byte Method = 1;
    public static final byte None = 0;
    public static final byte Script = 7;
    public static final byte SerialBlock = 4;
    public static final byte Var = 2;
    public List<wy> a;
    public long b;
    private short c;
    public String d;

    public void a(wy wyVar) {
        if (wyVar == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(wyVar);
    }

    public Object b(@Nullable hy hyVar, DXRuntimeContext dXRuntimeContext) {
        return this.d;
    }

    public short c() {
        return this.c;
    }

    public void d(short s) {
        this.c = s;
    }

    public String toString() {
        Iterator<wy> it;
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(this.d) ? Long.valueOf(this.b) : this.d);
        sb.append(":");
        String sb2 = sb.toString();
        List<wy> list = this.a;
        if (list != null) {
            while (list.iterator().hasNext()) {
                sb2 = sb2 + it.next().toString();
            }
        }
        return sb2;
    }
}
