package tb;

import cn.damai.comment.bean.CommentsItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class al {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REPLY_TYPE = 1;
    public static final int SUBREPLY_TYPE = 2;
    private int a;
    private CommentsItemBean b;
    private String c;
    private boolean d;
    private int h;
    private long i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private boolean e = true;
    private boolean f = false;
    private int g = 0;
    public boolean o = false;

    public al() {
    }

    public void A(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885294218")) {
            ipChange.ipc$dispatch("885294218", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.g = i;
        }
    }

    public void B(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1191514314")) {
            ipChange.ipc$dispatch("-1191514314", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.n = z;
        }
    }

    public CommentsItemBean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1266465608") ? (CommentsItemBean) ipChange.ipc$dispatch("1266465608", new Object[]{this}) : this.b;
    }

    public String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1201208619") ? (String) ipChange.ipc$dispatch("1201208619", new Object[]{this}) : this.c;
    }

    public int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1766764979") ? ((Integer) ipChange.ipc$dispatch("1766764979", new Object[]{this})).intValue() : this.h;
    }

    public String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2125501955") ? (String) ipChange.ipc$dispatch("2125501955", new Object[]{this}) : this.m;
    }

    public long e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-178825407") ? ((Long) ipChange.ipc$dispatch("-178825407", new Object[]{this})).longValue() : this.i;
    }

    public String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-813073671") ? (String) ipChange.ipc$dispatch("-813073671", new Object[]{this}) : this.k;
    }

    public String g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1469687587") ? (String) ipChange.ipc$dispatch("1469687587", new Object[]{this}) : this.j;
    }

    public String h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1859138971") ? (String) ipChange.ipc$dispatch("-1859138971", new Object[]{this}) : this.l;
    }

    public int i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-60192744") ? ((Integer) ipChange.ipc$dispatch("-60192744", new Object[]{this})).intValue() : this.g;
    }

    public int j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-26746878") ? ((Integer) ipChange.ipc$dispatch("-26746878", new Object[]{this})).intValue() : this.a;
    }

    public boolean k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1446491622") ? ((Boolean) ipChange.ipc$dispatch("1446491622", new Object[]{this})).booleanValue() : this.d;
    }

    public boolean l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-176778863") ? ((Boolean) ipChange.ipc$dispatch("-176778863", new Object[]{this})).booleanValue() : this.f;
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1142546571") ? ((Boolean) ipChange.ipc$dispatch("1142546571", new Object[]{this})).booleanValue() : this.e;
    }

    public boolean n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2129368577") ? ((Boolean) ipChange.ipc$dispatch("2129368577", new Object[]{this})).booleanValue() : i() == 1 || i() == 2;
    }

    public boolean o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1947781762") ? ((Boolean) ipChange.ipc$dispatch("-1947781762", new Object[]{this})).booleanValue() : this.n;
    }

    public void p(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-729014322")) {
            ipChange.ipc$dispatch("-729014322", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.d = z;
        }
    }

    public void q(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1997644470")) {
            ipChange.ipc$dispatch("-1997644470", new Object[]{this, commentsItemBean});
        } else {
            this.b = commentsItemBean;
        }
    }

    public void r(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577777579")) {
            ipChange.ipc$dispatch("577777579", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    public void s(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154078129")) {
            ipChange.ipc$dispatch("-154078129", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.h = i;
        }
    }

    public void t(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833900077")) {
            ipChange.ipc$dispatch("-833900077", new Object[]{this, str});
        } else {
            this.m = str;
        }
    }

    public void u(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430493309")) {
            ipChange.ipc$dispatch("-1430493309", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.f = z;
        }
    }

    public void v(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214934923")) {
            ipChange.ipc$dispatch("1214934923", new Object[]{this, Long.valueOf(j)});
        } else {
            this.i = j;
        }
    }

    public void w(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "962401029")) {
            ipChange.ipc$dispatch("962401029", new Object[]{this, str});
        } else {
            this.k = str;
        }
    }

    public void x(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310690995")) {
            ipChange.ipc$dispatch("310690995", new Object[]{this, str});
        } else {
            this.j = str;
        }
    }

    public void y(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196282801")) {
            ipChange.ipc$dispatch("196282801", new Object[]{this, str});
        } else {
            this.l = str;
        }
    }

    public void z(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210276663")) {
            ipChange.ipc$dispatch("-210276663", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.e = z;
        }
    }

    public al(int i) {
        this.a = i;
    }
}
