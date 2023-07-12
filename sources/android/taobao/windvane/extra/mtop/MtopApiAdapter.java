package android.taobao.windvane.extra.mtop;

import android.content.ContextWrapper;
import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.IApiAdapter;
import android.taobao.windvane.extra.security.SecurityManager;
import android.taobao.windvane.extra.security.TaoApiSign;
import android.taobao.windvane.util.TaoLog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MtopApiAdapter implements IApiAdapter {
    private ApiRequest request;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0099, code lost:
        if (r2 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkParams() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.mtop.MtopApiAdapter.checkParams():void");
    }

    private String getSecBodyData(ContextWrapper contextWrapper) {
        return SecurityManager.getInstance().getSecBody(contextWrapper, this.request.getParam("t"), this.request.getParam("appKey"));
    }

    private String getSign() {
        String sign = SecurityManager.getInstance().getSign(0, this.request.getParams(), this.request.getParam("appKey"));
        if (TaoLog.getLogStatus()) {
            TaoLog.d("MtopApiAdapter", "appkey: " + this.request.getParam("appKey") + " params: " + this.request.getParams());
        }
        if (sign == null) {
            TaoLog.w("MtopApiAdapter", "SecurityManager.getSign failed, execute TaoApiSign.getSign");
            return TaoApiSign.getSign(this.request.getParams());
        }
        return sign;
    }

    private String wrapBody() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, String> entry : this.request.getParams().entrySet()) {
            if (z) {
                sb.append("&");
            } else {
                z = true;
            }
            sb.append(Uri.encode(entry.getKey()));
            sb.append("=");
            sb.append(Uri.encode(entry.getValue()));
        }
        return sb.toString();
    }

    private String wrapUrl(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        Uri parse = Uri.parse(str);
        Uri.Builder buildUpon = parse.buildUpon();
        String path = parse.getPath();
        if (path == null || path.length() == 0) {
            buildUpon.appendPath("");
        }
        for (Map.Entry<String, String> entry : this.request.getParams().entrySet()) {
            buildUpon = buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.toString();
    }

    @Override // android.taobao.windvane.connect.api.IApiAdapter
    public String formatBody(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        checkParams();
        return wrapBody();
    }

    @Override // android.taobao.windvane.connect.api.IApiAdapter
    public String formatUrl(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        checkParams();
        return wrapUrl(GlobalConfig.getMtopUrl());
    }
}
