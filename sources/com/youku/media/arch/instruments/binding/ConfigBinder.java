package com.youku.media.arch.instruments.binding;

import com.youku.media.arch.instruments.ConfigFetcher;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ConfigBinder {
    private static final Map<ConfigFetcher, UpdateHolder> sConfigUpdateListeners = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class FieldHolder {
        String defaultValue;
        Field field;
        String key;
        Object target;

        private FieldHolder() {
        }

        void update(String str) {
            try {
                Field field = this.field;
                Object obj = this.target;
                if (str == null) {
                    str = this.defaultValue;
                }
                ConfigBinder.updateField(field, obj, str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class UpdateHolder {
        Map<String, Map<String, List<FieldHolder>>> mNamespaceMap;
        ConfigFetcher.OnConfigUpdatedListener mUpdatedListener = new ConfigFetcher.OnConfigUpdatedListener() { // from class: com.youku.media.arch.instruments.binding.ConfigBinder.UpdateHolder.1
            @Override // com.youku.media.arch.instruments.ConfigFetcher.OnConfigUpdatedListener
            public void onBatchConfigsUpdate(String str, Map<String, String> map) {
                Map<String, List<FieldHolder>> map2;
                if (str == null || map == null || (map2 = UpdateHolder.this.mNamespaceMap.get(str)) == null) {
                    return;
                }
                for (String str2 : map.keySet()) {
                    List<FieldHolder> list = map2.get(str2);
                    if (list != null) {
                        String str3 = map.get(str2);
                        for (FieldHolder fieldHolder : list) {
                            fieldHolder.update(str3);
                        }
                    }
                }
            }

            @Override // com.youku.media.arch.instruments.ConfigFetcher.OnConfigUpdatedListener
            public void onConfigUpdate(String str, String str2, String str3) {
                List<FieldHolder> list;
                Map<String, List<FieldHolder>> map = UpdateHolder.this.mNamespaceMap.get(str);
                if (map == null || (list = map.get(str2)) == null) {
                    return;
                }
                for (FieldHolder fieldHolder : list) {
                    fieldHolder.update(str3);
                }
            }
        };

        UpdateHolder() {
        }
    }

    public static void acquireLock(String str) {
    }

    private static void addFieldUpdateListener(ConfigFetcher configFetcher, Object obj, Field field, String str, String str2, String str3) {
        UpdateHolder updateHolder;
        Map<ConfigFetcher, UpdateHolder> map = sConfigUpdateListeners;
        if (map.containsKey(configFetcher)) {
            updateHolder = map.get(configFetcher);
        } else {
            updateHolder = new UpdateHolder();
            updateHolder.mNamespaceMap = new HashMap();
            configFetcher.setOnConfigUpdatedListener(updateHolder.mUpdatedListener);
            map.put(configFetcher, updateHolder);
        }
        if (!updateHolder.mNamespaceMap.containsKey(str)) {
            updateHolder.mNamespaceMap.put(str, new HashMap());
        }
        FieldHolder fieldHolder = new FieldHolder();
        fieldHolder.target = obj;
        fieldHolder.field = field;
        fieldHolder.key = str2;
        fieldHolder.defaultValue = str3;
        List<FieldHolder> list = updateHolder.mNamespaceMap.get(str).get(str2);
        if (list == null) {
            list = new ArrayList<>();
            updateHolder.mNamespaceMap.get(str).put(str2, list);
        }
        list.add(fieldHolder);
    }

    public static void bind(ConfigFetcher configFetcher, Object obj) {
        bind(configFetcher, obj, null);
    }

    public static void bind(ConfigFetcher configFetcher, Object obj, String str) {
        if (str == null && obj != null) {
            Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
            if (!cls.isAnnotationPresent(BindNamespace.class)) {
                throw new IllegalArgumentException("target class isn't annotation decorated");
            }
            str = ((BindNamespace) cls.getAnnotation(BindNamespace.class)).name();
        }
        if (configFetcher == null || obj == null || str == null) {
            return;
        }
        if (obj instanceof Class) {
            bindInner(configFetcher, (Class) obj, null, str);
        } else {
            bindInner(configFetcher, obj.getClass(), obj, str);
        }
    }

    private static void bindInner(ConfigFetcher configFetcher, Class<?> cls, Object obj, String str) {
        Field[] declaredFields;
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(BindValue.class)) {
                    BindValue bindValue = (BindValue) field.getAnnotation(BindValue.class);
                    try {
                        updateField(field, obj, configFetcher.getConfig(str, bindValue.key(), bindValue.defaultValue()));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    addFieldUpdateListener(configFetcher, obj, field, str, bindValue.key(), bindValue.defaultValue());
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static void releaseLock(String str) {
    }

    public static void unbind(ConfigFetcher configFetcher, Object obj, String str) {
        UpdateHolder updateHolder;
        if (str == null) {
            Class cls = (Class) obj;
            if (!cls.isAnnotationPresent(BindNamespace.class)) {
                throw new IllegalArgumentException("target class isn't annotation decorated");
            }
            str = ((BindNamespace) cls.getAnnotation(BindNamespace.class)).name();
        }
        if (configFetcher == null || obj == null || str == null || (updateHolder = sConfigUpdateListeners.get(configFetcher)) == null) {
            return;
        }
        if (updateHolder.mNamespaceMap.containsKey(str)) {
            Map<String, List<FieldHolder>> map = updateHolder.mNamespaceMap.get(str);
            Iterator<Map.Entry<String, List<FieldHolder>>> it = map.entrySet().iterator();
            while (true) {
                Map.Entry<String, List<FieldHolder>> next = it.next();
                if (!it.hasNext()) {
                    break;
                }
                List<FieldHolder> value = next.getValue();
                for (int size = value.size() - 1; size >= 0; size--) {
                    FieldHolder fieldHolder = value.get(size);
                    if (fieldHolder.target == obj) {
                        value.remove(fieldHolder);
                    }
                }
                if (value.size() == 0) {
                    it.remove();
                }
            }
            if (map.size() == 0) {
                updateHolder.mNamespaceMap.remove(str);
            }
        }
        if (updateHolder.mNamespaceMap.size() == 0) {
            sConfigUpdateListeners.remove(configFetcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateField(Field field, Object obj, String str) {
        Byte b;
        field.setAccessible(true);
        Class<?> type = field.getType();
        if (type == Boolean.TYPE || type == Boolean.class) {
            if ("true".equals(str) || "false".equals(str)) {
                b = Boolean.valueOf(str);
            } else {
                b = Boolean.valueOf(str.charAt(0) == '1');
            }
        } else if (type == Integer.TYPE || type == Integer.class) {
            b = Integer.valueOf(str);
        } else if (type == Long.TYPE || type == Long.class) {
            b = Long.valueOf(str);
        } else if (type == Short.TYPE || type == Short.class) {
            b = Short.valueOf(str);
        } else if (type == Float.TYPE || type == Float.class) {
            b = Float.valueOf(str);
        } else if (type == Double.TYPE || type == Double.class) {
            b = Double.valueOf(str);
        } else if (type == Character.TYPE || type == Character.class) {
            b = Character.valueOf(str.charAt(0));
        } else if (type == Byte.TYPE || type == Byte.class) {
            b = Byte.valueOf(str);
        } else {
            b = str;
            if (type != String.class) {
                b = null;
            }
        }
        field.set(obj, b);
    }
}
