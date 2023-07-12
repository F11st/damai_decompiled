package tb;

import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dy2 {
    private static Queue<dy2> i = new LinkedList();
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public static dy2 a(View view, View view2) {
        dy2 poll = i.poll();
        if (poll == null) {
            poll = new dy2();
        }
        int[] b = ry2.b(view, view2);
        boolean z = view instanceof TextView;
        int max = Math.max(0, b[0]);
        int min = Math.min(ry2.screenWidth, b[0] + view.getWidth());
        int max2 = Math.max(0, b[1]);
        int min2 = Math.min(ry2.screenHeight, b[1] + view.getHeight());
        poll.c = max;
        poll.d = min;
        poll.a = max2;
        poll.b = min2;
        poll.e = 10;
        poll.f = 10;
        poll.g = 10;
        poll.h = 10;
        return poll;
    }

    public static dy2 b(View view, View view2) {
        dy2 poll = i.poll();
        if (poll == null) {
            poll = new dy2();
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view3 = (View) parent;
            int[] b = ry2.b(view3, view2);
            int max = Math.max(0, b[1]);
            int i2 = ry2.screenHeight;
            int min = Math.min(i2, b[1] + view3.getHeight());
            int max2 = Math.max(0, b[0]);
            int i3 = ry2.screenWidth;
            int min2 = Math.min(i3, b[0] + view3.getWidth());
            int[] b2 = ry2.b(view, view2);
            boolean z = view instanceof TextView;
            int max3 = Math.max(0, b2[0]);
            int min3 = Math.min(i3, b2[0] + view.getWidth());
            int max4 = Math.max(0, b2[1]);
            int min4 = Math.min(i2, b2[1] + view.getHeight());
            poll.c = Math.max(max3, max2);
            poll.d = Math.min(min3, min2);
            poll.a = Math.max(max4, max);
            poll.b = Math.min(min4, min);
            poll.e = 10;
            poll.f = 10;
            poll.g = 10;
            poll.h = 10;
            if (min3 - max3 <= 0 || min4 - max4 <= 0) {
                poll.c = 0;
                poll.d = 0;
                poll.a = 0;
                poll.b = 0;
                poll.e = 0;
                poll.f = 0;
                poll.g = 0;
                poll.h = 0;
            }
            return poll;
        }
        return poll;
    }

    public void c() {
        if (i.size() < 100) {
            i.add(this);
        }
    }

    public String toString() {
        return "ViewInfo{top=" + this.a + ", bottom=" + this.b + ", left=" + this.c + ", right=" + this.d + '}';
    }
}
