package com.meizu.cloud.pushsdk.d.f;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.f.a */
/* loaded from: classes10.dex */
public class C6028a {
    private static final String a = "a";

    public static Map a(String str, Context context) {
        try {
            String str2 = a;
            C6030c.b(str2, "Attempting to retrieve map from: %s", str);
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            C6030c.b(str2, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            C6030c.a(a, " + Exception getting vars map: %s", e.getMessage());
            return null;
        }
    }

    public static boolean a(String str, Map map, Context context) {
        try {
            String str2 = a;
            C6030c.b(str2, "Attempting to save: %s", map);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            C6030c.b(str2, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (IOException e) {
            C6030c.a(a, " + Exception saving vars map: %s", e.getMessage());
            return false;
        }
    }
}
