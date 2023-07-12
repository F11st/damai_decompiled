package com.youku.arch.v3.typeconvert;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/youku/arch/v3/typeconvert/ITypeConvertRule;", "T", ExifInterface.LATITUDE_SOUTH, "", "t", "s", "", "isConvert", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", "convertType", "(Ljava/lang/Object;Ljava/lang/Object;)I", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ITypeConvertRule<T, S> {
    int convertType(T t, S s);

    boolean isConvert(T t, S s);
}
