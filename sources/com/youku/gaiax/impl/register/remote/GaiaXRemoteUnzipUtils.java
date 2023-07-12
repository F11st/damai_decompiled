package com.youku.gaiax.impl.register.remote;

import android.os.Build;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.gaiax.impl.register.remote.GaiaXRemoteUnzipUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.collections.C8216o;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.oe;
import tb.rz0;
import tb.wt2;
import tb.xj;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteUnzipUtils;", "", "Ljava/io/File;", "src", "", "target", "Ltb/wt2;", "unzip", "<init>", "()V", "ZipIO", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXRemoteUnzipUtils {
    @NotNull
    public static final GaiaXRemoteUnzipUtils INSTANCE = new GaiaXRemoteUnzipUtils();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteUnzipUtils$ZipIO;", "", "Ljava/util/zip/ZipEntry;", "component1", "Ljava/io/File;", "component2", "entry", "output", rz0.ARG_COPY, "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/zip/ZipEntry;", "getEntry", "()Ljava/util/zip/ZipEntry;", "Ljava/io/File;", "getOutput", "()Ljava/io/File;", "<init>", "(Ljava/util/zip/ZipEntry;Ljava/io/File;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class ZipIO {
        @NotNull
        private final ZipEntry entry;
        @NotNull
        private final File output;

        public ZipIO(@NotNull ZipEntry zipEntry, @NotNull File file) {
            b41.i(zipEntry, "entry");
            b41.i(file, "output");
            this.entry = zipEntry;
            this.output = file;
        }

        public static /* synthetic */ ZipIO copy$default(ZipIO zipIO, ZipEntry zipEntry, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                zipEntry = zipIO.entry;
            }
            if ((i & 2) != 0) {
                file = zipIO.output;
            }
            return zipIO.copy(zipEntry, file);
        }

        @NotNull
        public final ZipEntry component1() {
            return this.entry;
        }

        @NotNull
        public final File component2() {
            return this.output;
        }

        @NotNull
        public final ZipIO copy(@NotNull ZipEntry zipEntry, @NotNull File file) {
            b41.i(zipEntry, "entry");
            b41.i(file, "output");
            return new ZipIO(zipEntry, file);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ZipIO) {
                ZipIO zipIO = (ZipIO) obj;
                return b41.d(this.entry, zipIO.entry) && b41.d(this.output, zipIO.output);
            }
            return false;
        }

        @NotNull
        public final ZipEntry getEntry() {
            return this.entry;
        }

        @NotNull
        public final File getOutput() {
            return this.output;
        }

        public int hashCode() {
            return (this.entry.hashCode() * 31) + this.output.hashCode();
        }

        @NotNull
        public String toString() {
            return "ZipIO(entry=" + this.entry + ", output=" + this.output + ')';
        }
    }

    private GaiaXRemoteUnzipUtils() {
    }

    public final void unzip(@NotNull File file, @NotNull final String str) {
        ZipFile zipFile;
        Iterator s;
        Sequence c;
        Sequence v;
        Sequence v2;
        Sequence<ZipIO> o;
        b41.i(file, "src");
        b41.i(str, "target");
        if (Build.VERSION.SDK_INT >= 24) {
            zipFile = new ZipFile(file, Charset.forName("GBK"));
        } else {
            zipFile = new ZipFile(file);
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        b41.h(entries, "zip.entries()");
        s = C8216o.s(entries);
        c = SequencesKt__SequencesKt.c(s);
        v = SequencesKt___SequencesKt.v(c, new Function1<ZipEntry, ZipIO>() { // from class: com.youku.gaiax.impl.register.remote.GaiaXRemoteUnzipUtils$unzip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GaiaXRemoteUnzipUtils.ZipIO invoke(ZipEntry zipEntry) {
                b41.h(zipEntry, AdvanceSetting.NETWORK_TYPE);
                return new GaiaXRemoteUnzipUtils.ZipIO(zipEntry, new File(str + ((Object) File.separator) + ((Object) zipEntry.getName())));
            }
        });
        v2 = SequencesKt___SequencesKt.v(v, new Function1<ZipIO, ZipIO>() { // from class: com.youku.gaiax.impl.register.remote.GaiaXRemoteUnzipUtils$unzip$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final GaiaXRemoteUnzipUtils.ZipIO invoke(@NotNull GaiaXRemoteUnzipUtils.ZipIO zipIO) {
                b41.i(zipIO, AdvanceSetting.NETWORK_TYPE);
                File parentFile = zipIO.getOutput().getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                return zipIO;
            }
        });
        o = SequencesKt___SequencesKt.o(v2, new Function1<ZipIO, Boolean>() { // from class: com.youku.gaiax.impl.register.remote.GaiaXRemoteUnzipUtils$unzip$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GaiaXRemoteUnzipUtils.ZipIO zipIO) {
                b41.i(zipIO, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(!zipIO.getEntry().isDirectory());
            }
        });
        for (ZipIO zipIO : o) {
            ZipEntry component1 = zipIO.component1();
            File component2 = zipIO.component2();
            InputStream inputStream = zipFile.getInputStream(component1);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(component2);
                b41.h(inputStream, "input");
                oe.b(inputStream, fileOutputStream, 0, 2, null);
                wt2 wt2Var = wt2.INSTANCE;
                xj.a(fileOutputStream, null);
                xj.a(inputStream, null);
            } finally {
            }
        }
    }
}
