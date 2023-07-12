package tb;

import com.taobao.tcommon.log.FormatLog;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class wh0 implements FormatLog {
    public static final int COMMON_TOTAL_LENGTH = 250;
    private final Object a = new Object();
    private StringBuilder b;
    private Formatter c;

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, Object... objArr) {
        String substring;
        synchronized (this.a) {
            StringBuilder sb = this.b;
            if (sb == null) {
                this.b = new StringBuilder(250);
            } else {
                sb.setLength(0);
            }
            if (this.c == null) {
                this.c = new Formatter(this.b, Locale.getDefault());
            }
            this.c.format(str, objArr);
            substring = this.b.substring(0);
        }
        return substring;
    }
}
