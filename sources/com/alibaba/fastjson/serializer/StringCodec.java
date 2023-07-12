package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class StringCodec implements ObjectDeserializer, ObjectSerializer {
    public static StringCodec instance = new StringCodec();

    private StringCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) defaultJSONParser.parseString();
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String str = (String) obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (str == null) {
            serializeWriter.writeNull();
        } else {
            serializeWriter.writeString(str);
        }
    }
}
