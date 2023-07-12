package com.squareup.okhttp;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.n.C4250a;
import com.squareup.okhttp.internal.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FormEncodingBuilder {
    private static final MediaType CONTENT_TYPE = MediaType.parse(IRequestConst.CONTENT_TYPE_POST);
    private final StringBuilder content = new StringBuilder();

    public FormEncodingBuilder add(String str, String str2) {
        if (this.content.length() > 0) {
            this.content.append('&');
        }
        try {
            StringBuilder sb = this.content;
            sb.append(URLEncoder.encode(str, "UTF-8"));
            sb.append(C4250a.h);
            sb.append(URLEncoder.encode(str2, "UTF-8"));
            return this;
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public RequestBody build() {
        if (this.content.length() != 0) {
            return RequestBody.create(CONTENT_TYPE, this.content.toString().getBytes(Util.UTF_8));
        }
        throw new IllegalStateException("Form encoded body must have at least one part.");
    }
}
