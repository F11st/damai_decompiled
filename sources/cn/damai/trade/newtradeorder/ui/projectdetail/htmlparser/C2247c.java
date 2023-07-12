package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c */
/* loaded from: classes16.dex */
public class C2247c {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_UNDEFINE = -1;
    public static final int DEC_LINE_THROUGH = 2;
    public static final int DEC_NONE = 0;
    public static final int DEC_UNDEFINE = -1;
    public static final int DEC_UNDERLINE = 1;
    public int a;
    public String b;
    public int c = -1;
    public C2248a d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.c$a */
    /* loaded from: classes16.dex */
    public static class C2248a {
        private static transient /* synthetic */ IpChange $ipChange;
        public String a;
        public String b;
        public int c = 1;
        public int d = -1;
        public int e = -1;
        public int f = -1;
        public int g = -1;
        public int h;
        public int i;
        public int j;
        public int k;

        public String toString() {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1326976724")) {
                return (String) ipChange.ipc$dispatch("1326976724", new Object[]{this});
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{color:");
            sb.append(this.c);
            String str2 = "";
            if (this.a == null) {
                str = "";
            } else {
                str = ", src:" + this.a;
            }
            sb.append(str);
            if (this.b != null) {
                str2 = ", href:" + this.b;
            }
            sb.append(str2);
            sb.append(", fontSize:");
            sb.append(this.d);
            sb.append(", textAlign:");
            sb.append(this.e);
            sb.append(", textDecoration:");
            sb.append(this.f);
            sb.append(", align:");
            sb.append(this.g);
            sb.append(", width:");
            sb.append(this.h);
            sb.append(", height:");
            sb.append(this.i);
            sb.append(", damaiWidth:");
            sb.append(this.j);
            sb.append(", damaiHeight:");
            sb.append(this.k);
            sb.append("}");
            return sb.toString();
        }
    }

    public C2247c(int i, String str, C2248a c2248a) {
        this.a = -1;
        this.a = i;
        this.b = str;
        this.d = c2248a;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205999022")) {
            return (String) ipChange.ipc$dispatch("-205999022", new Object[]{this});
        }
        return "name:" + this.b + ", type:" + this.a + ", attr:{" + this.d;
    }
}
