package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.a52;
import tb.b41;
import tb.d52;
import tb.n31;
import tb.q42;
import tb.wt2;
import tb.z42;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class SVGAVideoEntity {
    private boolean a;
    @NotNull
    private z42 b;
    private int c;
    private int d;
    @NotNull
    private List<d52> e;
    @NotNull
    private List<q42> f;
    @Nullable
    private SoundPool g;
    @NotNull
    private HashMap<String, Bitmap> h;
    private File i;
    @Nullable
    private MovieEntity j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.opensource.svgaplayer.SVGAVideoEntity$a */
    /* loaded from: classes10.dex */
    public static final class C6107a implements SoundPool.OnLoadCompleteListener {
        final /* synthetic */ Ref$IntRef a;
        final /* synthetic */ List b;
        final /* synthetic */ Function0 c;

        C6107a(Ref$IntRef ref$IntRef, List list, SVGAVideoEntity sVGAVideoEntity, Function0 function0, MovieEntity movieEntity) {
            this.a = ref$IntRef;
            this.b = list;
            this.c = function0;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
            Ref$IntRef ref$IntRef = this.a;
            int i3 = ref$IntRef.element + 1;
            ref$IntRef.element = i3;
            if (i3 >= this.b.size()) {
                this.c.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.opensource.svgaplayer.SVGAVideoEntity$b */
    /* loaded from: classes10.dex */
    public static final class C6108b<T, U> implements BiConsumer<String, byte[]> {
        final /* synthetic */ HashMap a;

        C6108b(HashMap hashMap) {
            this.a = hashMap;
        }

        @Override // java.util.function.BiConsumer
        /* renamed from: a */
        public final void accept(@NotNull String str, @NotNull byte[] bArr) {
            b41.j(str, "aKey");
            b41.j(bArr, "bytes");
            File createTempFile = File.createTempFile(str, ".mp3");
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            HashMap hashMap = this.a;
            b41.e(createTempFile, "tmpFile");
            hashMap.put(str, createTempFile);
        }
    }

    public SVGAVideoEntity(@NotNull JSONObject jSONObject, @NotNull File file) {
        List<d52> g;
        List<q42> g2;
        b41.j(jSONObject, "obj");
        b41.j(file, WXConfig.cacheDir);
        this.a = true;
        this.b = new z42(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = 15;
        g = C8214m.g();
        this.e = g;
        g2 = C8214m.g();
        this.f = g2;
        this.h = new HashMap<>();
        this.i = file;
        JSONObject optJSONObject = jSONObject.optJSONObject("movie");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("viewBox");
            if (optJSONObject2 != null) {
                this.b = new z42(0.0d, 0.0d, optJSONObject2.optDouble("width", 0.0d), optJSONObject2.optDouble("height", 0.0d));
            }
            this.c = optJSONObject.optInt("fps", 20);
            this.d = optJSONObject.optInt("frames", 0);
        }
        l(jSONObject);
        n(jSONObject);
    }

    private final void j(MovieEntity movieEntity, Function0<wt2> function0) {
        int q;
        HashMap hashMap;
        SoundPool soundPool;
        Set<Map.Entry<String, ByteString>> entrySet;
        List<Byte> N;
        List<AudioEntity> list = movieEntity.audios;
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            List<AudioEntity> list2 = list;
            if (list2 != null) {
                Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = 0;
                SoundPool soundPool2 = new SoundPool(Math.min(12, list2.size()), 2, 0);
                HashMap hashMap2 = new HashMap();
                soundPool2.setOnLoadCompleteListener(new C6107a(ref$IntRef, list2, this, function0, movieEntity));
                HashMap hashMap3 = new HashMap();
                Map<String, ByteString> map = movieEntity.images;
                if (map != null && (entrySet = map.entrySet()) != null) {
                    Iterator<T> it = entrySet.iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        String str = (String) entry.getKey();
                        byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                        if (byteArray.length >= 4) {
                            N = ArraysKt___ArraysKt.N(byteArray, new n31(0, 3));
                            if (N.get(0).byteValue() == 73 && N.get(1).byteValue() == 68 && N.get(2).byteValue() == 51 && N.get(3).byteValue() == 3) {
                                b41.e(str, "imageKey");
                                b41.e(byteArray, "byteArray");
                                hashMap3.put(str, byteArray);
                            }
                        }
                    }
                }
                if (hashMap3.size() > 0) {
                    hashMap3.forEach(new C6108b(hashMap2));
                }
                q = C8215n.q(list2, 10);
                ArrayList arrayList = new ArrayList(q);
                for (AudioEntity audioEntity : list2) {
                    b41.e(audioEntity, "audio");
                    q42 q42Var = new q42(audioEntity);
                    File file = (File) hashMap2.get(audioEntity.audioKey);
                    if (file != null) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileDescriptor fd = fileInputStream.getFD();
                        Integer num = audioEntity.startTime;
                        double intValue = num != null ? num.intValue() : 0;
                        Integer num2 = audioEntity.totalTime;
                        int intValue2 = num2 != null ? num2.intValue() : 0;
                        hashMap = hashMap2;
                        soundPool = soundPool2;
                        q42Var.f(Integer.valueOf(soundPool2.load(fd, (long) ((intValue / intValue2) * fileInputStream.available()), fileInputStream.available(), 1)));
                        fileInputStream.close();
                    } else {
                        hashMap = hashMap2;
                        soundPool = soundPool2;
                    }
                    arrayList.add(q42Var);
                    hashMap2 = hashMap;
                    soundPool2 = soundPool;
                }
                this.f = arrayList;
                this.g = soundPool2;
                return;
            }
        }
        function0.invoke();
    }

    private final void k(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        BitmapFactory.Options options;
        List<Byte> N;
        BitmapFactory.Options options2;
        Bitmap bitmap;
        BitmapFactory.Options options3;
        BitmapFactory.Options options4;
        Map<String, ByteString> map = movieEntity.images;
        if (map == null || (entrySet = map.entrySet()) == null) {
            return;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            options = a52.a;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
            if (byteArray.length >= 4) {
                N = ArraysKt___ArraysKt.N(byteArray, new n31(0, 3));
                if (N.get(0).byteValue() != 73 || N.get(1).byteValue() != 68 || N.get(2).byteValue() != 51 || N.get(3).byteValue() != 3) {
                    int length = byteArray.length;
                    options2 = a52.a;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, length, options2);
                    if (decodeByteArray != null) {
                        HashMap<String, Bitmap> hashMap = this.h;
                        b41.e(str, "imageKey");
                        hashMap.put(str, decodeByteArray);
                    } else {
                        String utf8 = ((ByteString) entry.getValue()).utf8();
                        if (utf8 != null) {
                            String str2 = this.i.getAbsolutePath() + "/" + utf8;
                            if (new File(str2).exists()) {
                                options4 = a52.a;
                                bitmap = BitmapFactory.decodeFile(str2, options4);
                            } else {
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                this.h.put(str, bitmap);
                            } else {
                                String str3 = this.i.getAbsolutePath() + "/" + str + ".png";
                                if (str3 != null) {
                                    String str4 = new File(str3).exists() ? str3 : null;
                                    if (str4 != null) {
                                        options3 = a52.a;
                                        Bitmap decodeFile = BitmapFactory.decodeFile(str4, options3);
                                        if (decodeFile != null) {
                                            this.h.put(str, decodeFile);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final void l(JSONObject jSONObject) {
        BitmapFactory.Options options;
        Bitmap bitmap;
        BitmapFactory.Options options2;
        BitmapFactory.Options options3;
        JSONObject optJSONObject = jSONObject.optJSONObject("images");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                options = a52.a;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                String str = this.i.getAbsolutePath() + "/" + optJSONObject.get(next);
                if (new File(str).exists()) {
                    options3 = a52.a;
                    bitmap = BitmapFactory.decodeFile(str, options3);
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    this.h.put(next, bitmap);
                } else {
                    String str2 = this.i.getAbsolutePath() + "/" + next + ".png";
                    if (str2 != null) {
                        String str3 = new File(str2).exists() ? str2 : null;
                        if (str3 != null) {
                            options2 = a52.a;
                            Bitmap decodeFile = BitmapFactory.decodeFile(str3, options2);
                            if (decodeFile != null) {
                                this.h.put(next, decodeFile);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void m(MovieEntity movieEntity) {
        List<d52> g;
        int q;
        List<SpriteEntity> list = movieEntity.sprites;
        if (list != null) {
            q = C8215n.q(list, 10);
            g = new ArrayList<>(q);
            for (SpriteEntity spriteEntity : list) {
                b41.e(spriteEntity, AdvanceSetting.NETWORK_TYPE);
                g.add(new d52(spriteEntity));
            }
        } else {
            g = C8214m.g();
        }
        this.e = g;
    }

    private final void n(JSONObject jSONObject) {
        List<d52> A0;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new d52(optJSONObject));
                }
            }
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        this.e = A0;
    }

    public final boolean a() {
        return this.a;
    }

    @NotNull
    public final List<q42> b() {
        return this.f;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    @NotNull
    public final HashMap<String, Bitmap> e() {
        return this.h;
    }

    @Nullable
    public final SoundPool f() {
        return this.g;
    }

    @NotNull
    public final List<d52> g() {
        return this.e;
    }

    @NotNull
    public final z42 h() {
        return this.b;
    }

    public final void i(@NotNull final Function0<wt2> function0) {
        b41.j(function0, WXBridgeManager.METHOD_CALLBACK);
        MovieEntity movieEntity = this.j;
        if (movieEntity != null) {
            j(movieEntity, new Function0<wt2>() { // from class: com.opensource.svgaplayer.SVGAVideoEntity$prepare$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                }
            });
        }
    }

    public final void o(boolean z) {
        this.a = z;
    }

    public SVGAVideoEntity(@NotNull MovieEntity movieEntity, @NotNull File file) {
        List<d52> g;
        List<q42> g2;
        Float f;
        b41.j(movieEntity, "obj");
        b41.j(file, WXConfig.cacheDir);
        this.a = true;
        this.b = new z42(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = 15;
        g = C8214m.g();
        this.e = g;
        g2 = C8214m.g();
        this.f = g2;
        this.h = new HashMap<>();
        this.j = movieEntity;
        this.i = file;
        MovieParams movieParams = movieEntity.params;
        if (movieParams != null) {
            Float f2 = movieParams.viewBoxWidth;
            this.b = new z42(0.0d, 0.0d, f2 != null ? f2.floatValue() : 0.0f, movieParams.viewBoxHeight != null ? f.floatValue() : 0.0f);
            Integer num = movieParams.fps;
            this.c = num != null ? num.intValue() : 20;
            Integer num2 = movieParams.frames;
            this.d = num2 != null ? num2.intValue() : 0;
        }
        try {
            k(movieEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m(movieEntity);
    }
}
