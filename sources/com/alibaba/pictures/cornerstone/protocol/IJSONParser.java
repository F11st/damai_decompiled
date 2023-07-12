package com.alibaba.pictures.cornerstone.protocol;

import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0016\u0010\u0017J:\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001a\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u001f"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/IJSONParser;", "", "T", "", "str", "Ljava/lang/Class;", "cls", "parseJson", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "type", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "", "parseStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "", "parseIntArray", "(Ljava/lang/String;)[Ljava/lang/Integer;", "", "parseBooleanArray", "(Ljava/lang/String;)[Ljava/lang/Boolean;", "", "parseLongArray", "(Ljava/lang/String;)[Ljava/lang/Long;", "clz", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parseArrayList", "parseJsonObject", "obj", "toJsonString", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IJSONParser {
    @Nullable
    <T> ArrayList<T> parseArrayList(@Nullable String str, @NotNull Class<T> cls);

    @Nullable
    Boolean[] parseBooleanArray(@Nullable String str);

    @Nullable
    Integer[] parseIntArray(@Nullable String str);

    @Nullable
    <T> T parseJson(@Nullable String str, @NotNull Class<T> cls);

    @Nullable
    <T> T parseJson(@Nullable String str, @NotNull Type type);

    @Nullable
    Object parseJsonObject(@Nullable String str);

    @Nullable
    Long[] parseLongArray(@Nullable String str);

    @Nullable
    String[] parseStringArray(@Nullable String str);

    @Nullable
    String toJsonString(@Nullable Object obj);
}
