package tb;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xml.sax.XMLReader;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class yz0 implements Html.TagHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private int b = 0;
    private int c = 0;
    final HashMap d = new HashMap();
    private Context e;

    public yz0(String str, Context context) {
        this.a = str;
        this.e = context;
    }

    private void b(XMLReader xMLReader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531658992")) {
            ipChange.ipc$dispatch("-1531658992", new Object[]{this, xMLReader});
            return;
        }
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("data");
            declaredField3.setAccessible(true);
            String[] strArr = (String[]) declaredField3.get(obj2);
            Field declaredField4 = obj2.getClass().getDeclaredField("length");
            declaredField4.setAccessible(true);
            int intValue = ((Integer) declaredField4.get(obj2)).intValue();
            for (int i = 0; i < intValue; i++) {
                int i2 = i * 5;
                this.d.put(strArr[i2 + 1], strArr[i2 + 4]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, Editable editable, XMLReader xMLReader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489328555")) {
            ipChange.ipc$dispatch("-489328555", new Object[]{this, str, editable, xMLReader});
            return;
        }
        this.c = editable.length();
        String str2 = (String) this.d.get("color");
        String str3 = (String) this.d.get("size");
        if (str3 != null) {
            str3 = str3.split("px")[0];
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                editable.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), this.b, this.c, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            editable.setSpan(new AbsoluteSizeSpan(s60.INSTANCE.b(this.e, Integer.parseInt(str3))), this.b, this.c, 33);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, Editable editable, XMLReader xMLReader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-827668017")) {
            ipChange.ipc$dispatch("-827668017", new Object[]{this, str, editable, xMLReader});
        } else {
            this.b = editable.length();
        }
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694586299")) {
            ipChange.ipc$dispatch("1694586299", new Object[]{this, Boolean.valueOf(z), str, editable, xMLReader});
        } else if (str.equalsIgnoreCase(this.a)) {
            b(xMLReader);
            if (z) {
                c(str, editable, xMLReader);
            } else {
                a(str, editable, xMLReader);
            }
        }
    }
}
