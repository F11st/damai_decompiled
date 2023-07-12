package cn.damai.trade.newtradeorder.ui.projectdetail.xflush;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.xflush.a */
/* loaded from: classes16.dex */
public final class C2446a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.xflush.a$a */
    /* loaded from: classes16.dex */
    public class C2447a {
        private static transient /* synthetic */ IpChange $ipChange;
        private StringBuilder a = new StringBuilder();

        public C2447a(C2446a c2446a) {
        }

        public C2447a a(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1942333227")) {
                return (C2447a) ipChange.ipc$dispatch("1942333227", new Object[]{this, str});
            }
            StringBuilder sb = this.a;
            sb.append("apiName: ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return this;
        }

        public C2447a b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1640877027")) {
                return (C2447a) ipChange.ipc$dispatch("-1640877027", new Object[]{this, str});
            }
            this.a.append("branchName: ");
            return this;
        }

        public String c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "496135124")) {
                return (String) ipChange.ipc$dispatch("496135124", new Object[]{this});
            }
            StringBuilder sb = this.a;
            return sb != null ? sb.toString() : "";
        }

        public C2447a d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-958859992")) {
                return (C2447a) ipChange.ipc$dispatch("-958859992", new Object[]{this});
            }
            this.a.append(" }");
            return this;
        }

        public C2447a e(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1992872123")) {
                return (C2447a) ipChange.ipc$dispatch("1992872123", new Object[]{this, str});
            }
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = this.a;
                sb.append("retCode: ");
                sb.append(str);
            }
            return this;
        }

        public C2447a f(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "804079215")) {
                return (C2447a) ipChange.ipc$dispatch("804079215", new Object[]{this, str});
            }
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = this.a;
                sb.append("retMsg: ");
                sb.append(str);
            }
            return this;
        }

        public C2447a g(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1767141306")) {
                return (C2447a) ipChange.ipc$dispatch("1767141306", new Object[]{this, str});
            }
            StringBuilder sb = this.a;
            sb.append("projectId:");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return this;
        }

        public C2447a h(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1664542678")) {
                return (C2447a) ipChange.ipc$dispatch("-1664542678", new Object[]{this, str});
            }
            StringBuilder sb = this.a;
            sb.append("projectName:");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return this;
        }

        public C2447a i() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1179539375")) {
                return (C2447a) ipChange.ipc$dispatch("1179539375", new Object[]{this});
            }
            this.a.append("jsondata={ ");
            return this;
        }

        public C2447a j() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1919451951")) {
                return (C2447a) ipChange.ipc$dispatch("1919451951", new Object[]{this});
            }
            this.a.append(AVFSCacheConstants.COMMA_SEP);
            return this;
        }
    }

    private C2446a() {
    }

    public static C2447a a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-312876428") ? (C2447a) ipChange.ipc$dispatch("-312876428", new Object[0]) : new C2446a().b();
    }

    private C2447a b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2136922038") ? (C2447a) ipChange.ipc$dispatch("2136922038", new Object[]{this}) : new C2447a(this);
    }
}
