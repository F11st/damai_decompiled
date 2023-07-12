package tb;

import com.taobao.weex.font.FontListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yo0 {
    private List<FontListener> a = new CopyOnWriteArrayList();

    public void a(String str, String str2, String str3) {
        synchronized (this) {
            for (FontListener fontListener : this.a) {
                fontListener.onAddFontRule(str, str2, str3);
            }
        }
    }

    public void b(String str, String str2, String str3) {
        synchronized (this) {
            for (FontListener fontListener : this.a) {
                fontListener.onFontLoad(str, str2, str3);
            }
        }
    }
}
