package tb;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.AbstractC3683b;
import com.alibaba.poplayer.trigger.C3685d;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.page.PageConfigItem;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class gq1 extends AbstractC3683b<Event, PageConfigItem, tp1> {
    public static final String PAGE_SCHEME = "poplayer://";
    public static final String TAG = "gq1";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.gq1$a */
    /* loaded from: classes8.dex */
    public static class C9183a {
        private static gq1 a = new gq1();
    }

    public static gq1 A() {
        return C9183a.a;
    }

    private Event z(String str, String str2, String str3) {
        String str4;
        Event event = new Event(2, str, str2, str3, 2);
        int indexOf = event.uri.indexOf(63);
        boolean z = -1 == indexOf;
        String substring = z ? event.uri : event.uri.substring(0, indexOf);
        int i = event.uri.startsWith(PAGE_SCHEME) ? 1 : 2;
        boolean z2 = i == event.source;
        if (z && z2) {
            str4 = str;
        } else {
            if (z2) {
                substring = event.uri;
            }
            str4 = str;
            event = new Event(2, substring, event.param, str3, i);
        }
        event.originUri = str4;
        return event;
    }

    public void B() {
        x(this.g, this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.AbstractC3683b
    public void a(Event event) {
        if (TextUtils.isEmpty(event.attachActivityKeyCode) || !event.attachActivityKeyCode.equals(this.f)) {
            dt1.b("%s activeAccept Useless event,eventKeyCode:%s,curKeyCode:%s.", TAG, event.attachActivityKeyCode, this.f);
            return;
        }
        vw2<PageConfigItem> g = ((tp1) this.a).g(event);
        dt1.b(TAG + " findValidConfigs:started Count:{%s},unstarted Count:{%s}.", Integer.valueOf(g.a.size()), Integer.valueOf(g.b.size()));
        if (!g.a.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<PageConfigItem> it = g.a.iterator();
            while (it.hasNext()) {
                arrayList.add(new t01(2, event, it.next(), PopLayer.getReference().internalGetCurrentActivity(), this));
            }
            t(this.f, arrayList);
        }
        if (2 != event.source || g.b.isEmpty()) {
            return;
        }
        this.b.c(event, g.b);
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3683b
    protected void j() {
        this.a = new tp1(PopLayer.getReference().getConfigAdapter(2));
        this.c = new ArrayList();
        this.b = new C3685d(this);
    }

    @Override // com.alibaba.poplayer.trigger.AbstractC3683b
    public void n(Activity activity, String str) {
        this.b.b(-1);
        c(false, str, false);
    }

    public void x(String str, String str2) {
        Event z = z(str, str2, this.f);
        dt1.b(TAG + " create Event:{%s}.", z.toString());
        if (z.source == 1) {
            this.c.add(z);
        } else {
            this.c.clear();
            this.c.add(z);
        }
        a(z);
    }

    public void y(String str) {
        this.d.remove(str);
    }
}
