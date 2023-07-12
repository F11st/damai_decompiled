package com.taobao.weex.adapter;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.weex.WXSDKInstance;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultUriAdapter implements URIAdapter {
    private Uri.Builder buildRelativeURI(Uri.Builder builder, Uri uri, Uri uri2) {
        if (uri2.getAuthority() != null) {
            return builder.scheme(uri.getScheme());
        }
        builder.encodedAuthority(uri.getEncodedAuthority()).scheme(uri.getScheme()).path(null);
        if (uri2.getPath().startsWith("/")) {
            builder.appendEncodedPath(uri2.getEncodedPath().substring(1));
        } else {
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size() - (!uri.getPath().endsWith("/"));
            for (int i = 0; i < size; i++) {
                builder.appendEncodedPath(pathSegments.get(i));
            }
            builder.appendEncodedPath(uri2.getEncodedPath());
        }
        return builder;
    }

    @Override // com.taobao.weex.adapter.URIAdapter
    @NonNull
    public Uri rewrite(WXSDKInstance wXSDKInstance, String str, Uri uri) {
        return rewrite(wXSDKInstance.getBundleUrl(), str, uri);
    }

    @Override // com.taobao.weex.adapter.URIAdapter
    @NonNull
    public Uri rewrite(String str, String str2, Uri uri) {
        if (TextUtils.isEmpty(str)) {
            return uri;
        }
        Uri parse = Uri.parse(str);
        Uri.Builder buildUpon = uri.buildUpon();
        if (uri.isRelative()) {
            if (uri.getEncodedPath().length() == 0) {
                return ("image".equals(str2) && TextUtils.isEmpty(uri.toString())) ? uri : parse;
            }
            return buildRelativeURI(buildUpon, parse, uri).build();
        }
        return uri;
    }
}
