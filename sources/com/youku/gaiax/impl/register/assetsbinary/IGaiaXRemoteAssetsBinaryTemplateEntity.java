package com.youku.gaiax.impl.register.assetsbinary;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/impl/register/assetsbinary/IGaiaXRemoteAssetsBinaryTemplateEntity;", "", "", "getTemplateId", "getTemplateBiz", "getTemplateLocalPath", "", "getTemplateAppVersion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IGaiaXRemoteAssetsBinaryTemplateEntity {
    long getTemplateAppVersion();

    @NotNull
    String getTemplateBiz();

    @NotNull
    String getTemplateId();

    @NotNull
    String getTemplateLocalPath();
}
