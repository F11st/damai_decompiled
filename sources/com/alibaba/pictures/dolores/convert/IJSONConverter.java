package com.alibaba.pictures.dolores.convert;

import com.youku.live.livesdk.preloader.Preloader;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\nJ\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/dolores/convert/IJSONConverter;", "", "T", "", Preloader.KEY_JSON, "Ljava/lang/reflect/Type;", "type", "parseJson", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "", "([BLjava/lang/reflect/Type;)Ljava/lang/Object;", "obj", "toJsonString", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IJSONConverter {
    @Nullable
    <T> T parseJson(@Nullable String str, @Nullable Type type);

    @Nullable
    <T> T parseJson(@Nullable byte[] bArr, @Nullable Type type);

    @NotNull
    String toJsonString(@Nullable Object obj);
}
