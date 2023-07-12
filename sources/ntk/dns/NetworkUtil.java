package ntk.dns;

import android.content.Context;
import android.content.pm.PackageManager;
import anet.channel.status.NetworkStatusHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.core.context.YoukuContext;
import java.nio.charset.Charset;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkUtil {
    public static final int CELLULAR = 2;
    public static final int NO_NETWORK = -1;
    public static final int UNKNOWN = 0;
    public static final int WIFI = 1;

    /* compiled from: Taobao */
    /* renamed from: ntk.dns.NetworkUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements MtopCallback.MtopFinishListener {
        final /* synthetic */ NetworkUtil this$0;
        final /* synthetic */ RequestCallBack val$callBack;

        AnonymousClass1(NetworkUtil networkUtil, RequestCallBack requestCallBack) {
            this.val$callBack = requestCallBack;
        }

        @Override // mtopsdk.mtop.common.MtopCallback.MtopFinishListener
        public void onFinished(MtopFinishEvent mtopFinishEvent, Object obj) {
            if (NetworkUtil.b(this.this$0)) {
                return;
            }
            MtopResponse mtopResponse = mtopFinishEvent.getMtopResponse();
            if (!mtopResponse.isApiSuccess()) {
                RequestCallBack requestCallBack = this.val$callBack;
                if (requestCallBack != null) {
                    requestCallBack.onFailed(mtopResponse.getRetCode(), mtopResponse.getRetMsg());
                    return;
                }
                return;
            }
            try {
                JSONObject parseObject = JSON.parseObject(new String(mtopResponse.getBytedata(), Charset.forName("UTF-8")));
                if (parseObject.containsKey("data")) {
                    String string = parseObject.getString("data");
                    RequestCallBack requestCallBack2 = this.val$callBack;
                    if (requestCallBack2 != null) {
                        requestCallBack2.onSuccess(string);
                        return;
                    }
                    return;
                }
            } catch (Exception unused) {
            }
            RequestCallBack requestCallBack3 = this.val$callBack;
            if (requestCallBack3 != null) {
                requestCallBack3.onFailed("-1", "json format invalid");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface RequestCallBack {
        void onFailed(String str, String str2);

        void onSuccess(String str);
    }

    public static String a() {
        try {
            Context applicationContext = YoukuContext.getApplicationContext();
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | NoClassDefFoundError unused) {
            return "invalid_ver";
        }
    }

    static /* synthetic */ boolean b(NetworkUtil networkUtil) {
        throw null;
    }

    public static int c() {
        return -1;
    }

    public static int d() {
        if (NetworkStatusHelper.n()) {
            if (NetworkStatusHelper.i().isWifi()) {
                return 1;
            }
            return NetworkStatusHelper.i().isMobile() ? 2 : 0;
        }
        return -1;
    }
}
