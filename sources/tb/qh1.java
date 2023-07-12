package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.phenix.loader.network.HttpLoader;
import java.util.Map;
import java.util.concurrent.Future;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qh1 implements HttpLoader {
    public static final String MTOP_EXTRA_CDN_IP_PORT = "mtop_extra_ip_port";
    public static final String MTOP_EXTRA_CONNECT_TYPE = "mtop_extra_connect_type";
    public static final String MTOP_EXTRA_FIRST_DATA = "mtop_extra_first_data";
    public static final String MTOP_EXTRA_HIT_CDN_CACHE = "mtop_extra_hit_cdn_cache";
    public static final String MTOP_EXTRA_RESPONSE_CODE = "mtop_extra_response_code";
    public static final String MTOP_EXTRA_SEND_BEFORE = "mtop_extra_send_before";
    public static final String MTOP_EXTRA_SERVER_RT = "mtop_extra_server_rt";
    public static final String MTOP_PREFIX = "MtopHttpLoader";
    private final Context a;
    private int b;
    private int c;

    public qh1(Context context) {
        this.a = context;
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void connectTimeout(int i) {
        this.b = i;
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public Future<?> load(String str, Map<String, String> map, HttpLoader.FinishCallback finishCallback) {
        String str2;
        String str3;
        xt2.l("Network", str, "%s async download image", MTOP_PREFIX);
        c22 c22Var = new c22(str);
        c22Var.setCookieEnabled(false);
        c22Var.setFollowRedirects(true);
        c22Var.setConnectTimeout(this.b);
        c22Var.setReadTimeout(this.c);
        c22Var.addHeader(HttpHeaderConstant.F_REFER, "picture");
        if (map != null) {
            str2 = map.get("f-traceId");
            if (str2 != null) {
                c22Var.setExtProperty("f-traceId", str2);
            }
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && xj2.a()) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("TBAndroid/Native");
            sb.append(" ");
            sb.append(str2);
            c22Var.addHeader(IRequestConst.USER_AGENT, sb.toString());
        } else {
            c22Var.addHeader(IRequestConst.USER_AGENT, "TBAndroid/Native");
        }
        if (map != null && (str3 = map.get("bundle_biz_code")) != null) {
            try {
                c22Var.setBizId(Integer.parseInt(str3));
            } catch (NumberFormatException e) {
                xt2.l("Network", str, "%s get biz code from extras error=%s", MTOP_PREFIX, e);
            }
        }
        return new k60(this.a).asyncSend(c22Var, null, null, new sh1(finishCallback, map));
    }

    @Override // com.taobao.phenix.loader.network.HttpLoader
    public void readTimeout(int i) {
        this.c = i;
    }
}
