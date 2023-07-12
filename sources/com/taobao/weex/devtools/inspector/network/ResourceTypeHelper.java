package com.taobao.weex.devtools.inspector.network;

import com.taobao.weex.devtools.inspector.protocol.module.Page;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ResourceTypeHelper {
    private final MimeMatcher<Page.ResourceType> mMimeMatcher;

    public ResourceTypeHelper() {
        MimeMatcher<Page.ResourceType> mimeMatcher = new MimeMatcher<>();
        this.mMimeMatcher = mimeMatcher;
        mimeMatcher.addRule("text/css", Page.ResourceType.STYLESHEET);
        mimeMatcher.addRule("image/*", Page.ResourceType.IMAGE);
        Page.ResourceType resourceType = Page.ResourceType.SCRIPT;
        mimeMatcher.addRule("application/x-javascript", resourceType);
        mimeMatcher.addRule("application/javascript", resourceType);
        Page.ResourceType resourceType2 = Page.ResourceType.XHR;
        mimeMatcher.addRule("text/javascript", resourceType2);
        mimeMatcher.addRule("application/json", resourceType2);
        mimeMatcher.addRule("text/*", Page.ResourceType.DOCUMENT);
        mimeMatcher.addRule(jn1.MUL, Page.ResourceType.OTHER);
    }

    public Page.ResourceType determineResourceType(String str) {
        return this.mMimeMatcher.match(stripContentExtras(str));
    }

    public String stripContentExtras(String str) {
        int indexOf = str.indexOf(59);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }
}
