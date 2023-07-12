package com.taobao.weex.utils;

import androidx.annotation.NonNull;
import com.taobao.weex.utils.FunctionParser;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SingleFunctionParser<V> extends FunctionParser<String, List<V>> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface FlatMapper<V> {
        V map(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface NonUniformMapper<V> {
        List<V> map(List<String> list);
    }

    public SingleFunctionParser(@NonNull String str, @NonNull final FlatMapper<V> flatMapper) {
        super(str, new FunctionParser.Mapper<String, List<V>>() { // from class: com.taobao.weex.utils.SingleFunctionParser.1
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public Map<String, List<V>> map(String str2, List<String> list) {
                HashMap hashMap = new HashMap();
                LinkedList linkedList = new LinkedList();
                for (String str3 : list) {
                    linkedList.add(FlatMapper.this.map(str3));
                }
                hashMap.put(str2, linkedList);
                return hashMap;
            }
        });
    }

    public List<V> parse(String str) {
        LinkedHashMap<String, V> parse = parse();
        if (parse.containsKey(str)) {
            return (List) parse.get(str);
        }
        return null;
    }

    public SingleFunctionParser(@NonNull String str, @NonNull final NonUniformMapper<V> nonUniformMapper) {
        super(str, new FunctionParser.Mapper<String, List<V>>() { // from class: com.taobao.weex.utils.SingleFunctionParser.2
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public Map<String, List<V>> map(String str2, List<String> list) {
                HashMap hashMap = new HashMap();
                hashMap.put(str2, NonUniformMapper.this.map(list));
                return hashMap;
            }
        });
    }
}
