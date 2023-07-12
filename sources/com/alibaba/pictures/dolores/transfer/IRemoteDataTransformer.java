package com.alibaba.pictures.dolores.transfer;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tb.dc0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J4\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/dolores/transfer/IRemoteDataTransformer;", "BizResponse", "", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "request", "Lorg/json/JSONObject;", "responseStr", "Ljava/lang/reflect/Type;", "clsType", "Ltb/dc0;", "transform", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IRemoteDataTransformer<BizResponse> {
    @Nullable
    dc0<BizResponse> transform(@Nullable DoloresRequest<BizResponse> doloresRequest, @Nullable JSONObject jSONObject, @Nullable Type type);
}
