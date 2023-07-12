package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class tl2 {
    @NonNull
    public static DXTemplateItem a(@NonNull kd0 kd0Var) {
        DXTemplateItem dXTemplateItem = new DXTemplateItem();
        if (kd0Var == null) {
            return dXTemplateItem;
        }
        dXTemplateItem.name = kd0Var.c;
        long j = -1;
        try {
            j = Long.parseLong(kd0Var.e);
        } catch (NumberFormatException unused) {
        }
        dXTemplateItem.version = j;
        dXTemplateItem.templateUrl = kd0Var.d;
        return dXTemplateItem;
    }

    @NonNull
    public static kd0 b(DXTemplateItem dXTemplateItem) {
        kd0 kd0Var = new kd0();
        if (dXTemplateItem == null) {
            return kd0Var;
        }
        kd0Var.c = dXTemplateItem.name;
        kd0Var.e = String.valueOf(dXTemplateItem.version);
        kd0Var.d = dXTemplateItem.templateUrl;
        return kd0Var;
    }
}
