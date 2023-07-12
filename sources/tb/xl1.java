package tb;

import cn.damai.common.user.C0529c;
import cn.damai.push.model.PushMessageBean;
import com.alibaba.pictures.accs.AgooMessage;
import com.alibaba.pictures.accs.DecodeOverListener;
import com.alibaba.pictures.accs.INotifyActionHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class xl1 implements INotifyActionHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String CHANNEL_NAME = "大麦应用通知";
    @NotNull
    public static final C9933a Companion = new C9933a(null);
    @NotNull
    public static final String DEFAULT_CHANNEL_ID = "default_channel";
    @NotNull
    public static final String KEY_DMNAV_PUSH_FLAT = "KEY_DMNAV_PUSH_FLAT";
    @NotNull
    public static final String TYPE = "typestatus";

    /* compiled from: Taobao */
    /* renamed from: tb.xl1$a */
    /* loaded from: classes6.dex */
    public static final class C9933a {
        private C9933a() {
        }

        public /* synthetic */ C9933a(k50 k50Var) {
            this();
        }
    }

    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public boolean onInterceptAlarmMsg(@NotNull AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388362462")) {
            return ((Boolean) ipChange.ipc$dispatch("-388362462", new Object[]{this, agooMessage})).booleanValue();
        }
        b41.i(agooMessage, "agooMsg");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0112, code lost:
        if (tb.b41.d((r3 == null || (r3 = r3.topActivity) == null) ? null : r3.getPackageName(), tb.mu0.a().getPackageName()) == false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0152  */
    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onNotifyCLick(@org.jetbrains.annotations.NotNull com.alibaba.pictures.accs.AgooMessage r10) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.xl1.onNotifyCLick(com.alibaba.pictures.accs.AgooMessage):void");
    }

    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public void onNotifyDelete(@NotNull AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997281210")) {
            ipChange.ipc$dispatch("-997281210", new Object[]{this, agooMessage});
            return;
        }
        b41.i(agooMessage, "agooMsg");
        try {
            Object extObj = agooMessage.getExtObj();
            PushMessageBean.Exts exts = extObj instanceof PushMessageBean.Exts ? (PushMessageBean.Exts) extObj : null;
            if (exts != null) {
                C0529c.e().A(ml.g().h(exts.tag, exts.type, exts.value), "recitem", py0.PUSH_PAGE);
            }
        } catch (Exception e) {
            cb1.d(e);
        }
    }

    @Override // com.alibaba.pictures.accs.INotifyActionHandler
    public void onNotifyImgResDecode(@Nullable String[] strArr, @NotNull DecodeOverListener decodeOverListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203504682")) {
            ipChange.ipc$dispatch("-1203504682", new Object[]{this, strArr, decodeOverListener});
        } else {
            b41.i(decodeOverListener, "decodeOverListener");
        }
    }
}
