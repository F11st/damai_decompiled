package cn.damai.trade.newtradeorder.ui.projectdetail.xflush;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public final class a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.xflush.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0086a {
        private static transient /* synthetic */ IpChange $ipChange;
        private StringBuilder a = new StringBuilder();

        public C0086a(a aVar) {
        }

        public C0086a a(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1942333227")) {
                return (C0086a) ipChange.ipc$dispatch("1942333227", new Object[]{this, str});
            }
            StringBuilder sb = this.a;
            sb.append("apiName: ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return this;
        }

        public C0086a b(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1640877027")) {
                return (C0086a) ipChange.ipc$dispatch("-1640877027", new Object[]{this, str});
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

        public C0086a d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-958859992")) {
                return (C0086a) ipChange.ipc$dispatch("-958859992", new Object[]{this});
            }
            this.a.append(" }");
            return this;
        }

        public C0086a e(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1992872123")) {
                return (C0086a) ipChange.ipc$dispatch("1992872123", new Object[]{this, str});
            }
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = this.a;
                sb.append("retCode: ");
                sb.append(str);
            }
            return this;
        }

        public C0086a f(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "804079215")) {
                return (C0086a) ipChange.ipc$dispatch("804079215", new Object[]{this, str});
            }
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = this.a;
                sb.append("retMsg: ");
                sb.append(str);
            }
            return this;
        }

        public C0086a g(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1767141306")) {
                return (C0086a) ipChange.ipc$dispatch("1767141306", new Object[]{this, str});
            }
            StringBuilder sb = this.a;
            sb.append("projectId:");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return this;
        }

        public C0086a h(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1664542678")) {
                return (C0086a) ipChange.ipc$dispatch("-1664542678", new Object[]{this, str});
            }
            StringBuilder sb = this.a;
            sb.append("projectName:");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            return this;
        }

        public C0086a i() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1179539375")) {
                return (C0086a) ipChange.ipc$dispatch("1179539375", new Object[]{this});
            }
            this.a.append("jsondata={ ");
            return this;
        }

        public C0086a j() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1919451951")) {
                return (C0086a) ipChange.ipc$dispatch("1919451951", new Object[]{this});
            }
            this.a.append(AVFSCacheConstants.COMMA_SEP);
            return this;
        }
    }

    private a() {
    }

    public static C0086a a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-312876428") ? (C0086a) ipChange.ipc$dispatch("-312876428", new Object[0]) : new a().b();
    }

    private C0086a b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2136922038") ? (C0086a) ipChange.ipc$dispatch("2136922038", new Object[]{this}) : new C0086a(this);
    }
}
