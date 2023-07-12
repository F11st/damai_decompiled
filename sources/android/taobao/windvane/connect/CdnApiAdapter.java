package android.taobao.windvane.connect;

import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.IApiAdapter;
import com.youku.arch.v3.core.Constants;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CdnApiAdapter implements IApiAdapter {
    private ApiRequest request;

    private String wrapUrl(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendPath(this.request.getParam("biztype"));
        buildUpon.appendPath("windvane");
        buildUpon.appendPath(Constants.CONFIG);
        if (this.request.getParam("api").contains(ApiConstants.H5APP_API)) {
            buildUpon.appendPath(this.request.getParam(ApiConstants.H5APP_GROUPID));
            buildUpon.appendPath(this.request.getParam(ApiConstants.H5APP_GROUPVERSION));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(GlobalConfig.getInstance().getAppKey());
        sb.append("-");
        sb.append(GlobalConfig.getInstance().getTtid());
        sb.append("-");
        sb.append(GlobalConfig.VERSION);
        int size = this.request.getDataParams().size();
        for (int i = 0; i < size; i++) {
            sb.append("-");
            sb.append(this.request.getDataParam(String.valueOf(i)));
        }
        buildUpon.appendPath(sb.toString());
        if (this.request.getParam("api").contains(ApiConstants.H5APP_API)) {
            buildUpon.appendPath(this.request.getParam(ApiConstants.H5APP_ABT));
        }
        buildUpon.appendPath(this.request.getParam("api"));
        return buildUpon.toString();
    }

    @Override // android.taobao.windvane.connect.api.IApiAdapter
    public String formatBody(ApiRequest apiRequest) {
        return "";
    }

    @Override // android.taobao.windvane.connect.api.IApiAdapter
    public String formatUrl(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        return wrapUrl(GlobalConfig.getCdnConfigUrlPre());
    }
}
