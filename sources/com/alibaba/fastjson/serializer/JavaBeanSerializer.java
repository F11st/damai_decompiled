package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected final String typeKey;
    protected final String typeName;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0134 A[Catch: all -> 0x0097, Exception -> 0x009c, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x009c, all -> 0x0097, blocks: (B:41:0x008a, B:43:0x008e, B:44:0x0092, B:52:0x00ac, B:54:0x00b5, B:58:0x00c4, B:61:0x00cb, B:63:0x00d2, B:65:0x00d6, B:71:0x00e0, B:73:0x00e6, B:77:0x00ef, B:79:0x00f7, B:80:0x00ff, B:89:0x0111, B:90:0x0115, B:92:0x011b, B:100:0x0134, B:76:0x00eb), top: B:475:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0242 A[Catch: all -> 0x05a6, Exception -> 0x05ac, TryCatch #8 {Exception -> 0x05ac, all -> 0x05a6, blocks: (B:118:0x0166, B:120:0x0181, B:122:0x0185, B:125:0x018a, B:127:0x018e, B:131:0x0197, B:132:0x019b, B:134:0x01a1, B:142:0x01be, B:144:0x01c5, B:146:0x01c9, B:159:0x0215, B:161:0x021b, B:171:0x0238, B:172:0x023c, B:174:0x0242, B:185:0x026a, B:187:0x026e, B:189:0x0275, B:191:0x0279, B:192:0x027e, B:194:0x0282, B:195:0x0287, B:196:0x028e, B:198:0x0294, B:203:0x02ae, B:205:0x02b2, B:207:0x02b9, B:209:0x02bd, B:210:0x02c2, B:212:0x02c6, B:213:0x02cb, B:214:0x02d2, B:216:0x02d8, B:224:0x02fa, B:226:0x0308, B:228:0x0315, B:230:0x0319, B:233:0x031e, B:235:0x0321, B:294:0x03d2, B:296:0x03d6, B:298:0x03da, B:300:0x03de, B:302:0x03e2, B:304:0x03e6, B:311:0x03f8, B:313:0x03fc, B:315:0x0400, B:306:0x03ea, B:308:0x03ee, B:319:0x0410, B:321:0x0419, B:323:0x041d, B:324:0x0421, B:325:0x0425, B:327:0x0438, B:331:0x0442, B:332:0x0446, B:336:0x0450, B:337:0x0453, B:340:0x045b, B:342:0x0466, B:344:0x046a, B:346:0x046f, B:350:0x048b, B:351:0x0495, B:354:0x049c, B:358:0x04a6, B:363:0x04b2, B:365:0x04b8, B:367:0x04bc, B:368:0x04be, B:370:0x04c6, B:372:0x04ca, B:373:0x04ce, B:376:0x04dd, B:377:0x04e7, B:378:0x04ea, B:380:0x04ee, B:381:0x04f7, B:384:0x04fd, B:385:0x0508, B:388:0x0517, B:390:0x051e, B:392:0x0527, B:395:0x052b, B:396:0x0530, B:397:0x0537, B:399:0x053b, B:400:0x0540, B:401:0x0547, B:404:0x054f, B:406:0x0558, B:411:0x056c, B:412:0x0571, B:413:0x0576, B:414:0x0581, B:415:0x0586, B:416:0x058b, B:239:0x0328, B:243:0x0336, B:245:0x0343, B:247:0x0347, B:250:0x034c, B:252:0x034f, B:255:0x0357, B:257:0x0361, B:259:0x036c, B:261:0x0370, B:264:0x0377, B:266:0x037a, B:268:0x037f, B:269:0x0386, B:271:0x038e, B:273:0x0399, B:275:0x039d, B:278:0x03a4, B:280:0x03a7, B:282:0x03ac, B:284:0x03b3, B:286:0x03b7, B:163:0x0222, B:165:0x0226, B:166:0x022b, B:168:0x022f, B:147:0x01d9, B:149:0x01dd, B:150:0x01e9, B:152:0x01ed, B:153:0x01fd, B:154:0x0204, B:429:0x05c1, B:430:0x05c5, B:432:0x05cb, B:437:0x05dd, B:439:0x05e6, B:442:0x05f5, B:444:0x05f9, B:445:0x05fd), top: B:474:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0410 A[Catch: all -> 0x05a6, Exception -> 0x05ac, TryCatch #8 {Exception -> 0x05ac, all -> 0x05a6, blocks: (B:118:0x0166, B:120:0x0181, B:122:0x0185, B:125:0x018a, B:127:0x018e, B:131:0x0197, B:132:0x019b, B:134:0x01a1, B:142:0x01be, B:144:0x01c5, B:146:0x01c9, B:159:0x0215, B:161:0x021b, B:171:0x0238, B:172:0x023c, B:174:0x0242, B:185:0x026a, B:187:0x026e, B:189:0x0275, B:191:0x0279, B:192:0x027e, B:194:0x0282, B:195:0x0287, B:196:0x028e, B:198:0x0294, B:203:0x02ae, B:205:0x02b2, B:207:0x02b9, B:209:0x02bd, B:210:0x02c2, B:212:0x02c6, B:213:0x02cb, B:214:0x02d2, B:216:0x02d8, B:224:0x02fa, B:226:0x0308, B:228:0x0315, B:230:0x0319, B:233:0x031e, B:235:0x0321, B:294:0x03d2, B:296:0x03d6, B:298:0x03da, B:300:0x03de, B:302:0x03e2, B:304:0x03e6, B:311:0x03f8, B:313:0x03fc, B:315:0x0400, B:306:0x03ea, B:308:0x03ee, B:319:0x0410, B:321:0x0419, B:323:0x041d, B:324:0x0421, B:325:0x0425, B:327:0x0438, B:331:0x0442, B:332:0x0446, B:336:0x0450, B:337:0x0453, B:340:0x045b, B:342:0x0466, B:344:0x046a, B:346:0x046f, B:350:0x048b, B:351:0x0495, B:354:0x049c, B:358:0x04a6, B:363:0x04b2, B:365:0x04b8, B:367:0x04bc, B:368:0x04be, B:370:0x04c6, B:372:0x04ca, B:373:0x04ce, B:376:0x04dd, B:377:0x04e7, B:378:0x04ea, B:380:0x04ee, B:381:0x04f7, B:384:0x04fd, B:385:0x0508, B:388:0x0517, B:390:0x051e, B:392:0x0527, B:395:0x052b, B:396:0x0530, B:397:0x0537, B:399:0x053b, B:400:0x0540, B:401:0x0547, B:404:0x054f, B:406:0x0558, B:411:0x056c, B:412:0x0571, B:413:0x0576, B:414:0x0581, B:415:0x0586, B:416:0x058b, B:239:0x0328, B:243:0x0336, B:245:0x0343, B:247:0x0347, B:250:0x034c, B:252:0x034f, B:255:0x0357, B:257:0x0361, B:259:0x036c, B:261:0x0370, B:264:0x0377, B:266:0x037a, B:268:0x037f, B:269:0x0386, B:271:0x038e, B:273:0x0399, B:275:0x039d, B:278:0x03a4, B:280:0x03a7, B:282:0x03ac, B:284:0x03b3, B:286:0x03b7, B:163:0x0222, B:165:0x0226, B:166:0x022b, B:168:0x022f, B:147:0x01d9, B:149:0x01dd, B:150:0x01e9, B:152:0x01ed, B:153:0x01fd, B:154:0x0204, B:429:0x05c1, B:430:0x05c5, B:432:0x05cb, B:437:0x05dd, B:439:0x05e6, B:442:0x05f5, B:444:0x05f9, B:445:0x05fd), top: B:474:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x04dd A[Catch: all -> 0x05a6, Exception -> 0x05ac, TryCatch #8 {Exception -> 0x05ac, all -> 0x05a6, blocks: (B:118:0x0166, B:120:0x0181, B:122:0x0185, B:125:0x018a, B:127:0x018e, B:131:0x0197, B:132:0x019b, B:134:0x01a1, B:142:0x01be, B:144:0x01c5, B:146:0x01c9, B:159:0x0215, B:161:0x021b, B:171:0x0238, B:172:0x023c, B:174:0x0242, B:185:0x026a, B:187:0x026e, B:189:0x0275, B:191:0x0279, B:192:0x027e, B:194:0x0282, B:195:0x0287, B:196:0x028e, B:198:0x0294, B:203:0x02ae, B:205:0x02b2, B:207:0x02b9, B:209:0x02bd, B:210:0x02c2, B:212:0x02c6, B:213:0x02cb, B:214:0x02d2, B:216:0x02d8, B:224:0x02fa, B:226:0x0308, B:228:0x0315, B:230:0x0319, B:233:0x031e, B:235:0x0321, B:294:0x03d2, B:296:0x03d6, B:298:0x03da, B:300:0x03de, B:302:0x03e2, B:304:0x03e6, B:311:0x03f8, B:313:0x03fc, B:315:0x0400, B:306:0x03ea, B:308:0x03ee, B:319:0x0410, B:321:0x0419, B:323:0x041d, B:324:0x0421, B:325:0x0425, B:327:0x0438, B:331:0x0442, B:332:0x0446, B:336:0x0450, B:337:0x0453, B:340:0x045b, B:342:0x0466, B:344:0x046a, B:346:0x046f, B:350:0x048b, B:351:0x0495, B:354:0x049c, B:358:0x04a6, B:363:0x04b2, B:365:0x04b8, B:367:0x04bc, B:368:0x04be, B:370:0x04c6, B:372:0x04ca, B:373:0x04ce, B:376:0x04dd, B:377:0x04e7, B:378:0x04ea, B:380:0x04ee, B:381:0x04f7, B:384:0x04fd, B:385:0x0508, B:388:0x0517, B:390:0x051e, B:392:0x0527, B:395:0x052b, B:396:0x0530, B:397:0x0537, B:399:0x053b, B:400:0x0540, B:401:0x0547, B:404:0x054f, B:406:0x0558, B:411:0x056c, B:412:0x0571, B:413:0x0576, B:414:0x0581, B:415:0x0586, B:416:0x058b, B:239:0x0328, B:243:0x0336, B:245:0x0343, B:247:0x0347, B:250:0x034c, B:252:0x034f, B:255:0x0357, B:257:0x0361, B:259:0x036c, B:261:0x0370, B:264:0x0377, B:266:0x037a, B:268:0x037f, B:269:0x0386, B:271:0x038e, B:273:0x0399, B:275:0x039d, B:278:0x03a4, B:280:0x03a7, B:282:0x03ac, B:284:0x03b3, B:286:0x03b7, B:163:0x0222, B:165:0x0226, B:166:0x022b, B:168:0x022f, B:147:0x01d9, B:149:0x01dd, B:150:0x01e9, B:152:0x01ed, B:153:0x01fd, B:154:0x0204, B:429:0x05c1, B:430:0x05c5, B:432:0x05cb, B:437:0x05dd, B:439:0x05e6, B:442:0x05f5, B:444:0x05f9, B:445:0x05fd), top: B:474:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x05dd A[Catch: all -> 0x05a6, Exception -> 0x05ac, TRY_ENTER, TryCatch #8 {Exception -> 0x05ac, all -> 0x05a6, blocks: (B:118:0x0166, B:120:0x0181, B:122:0x0185, B:125:0x018a, B:127:0x018e, B:131:0x0197, B:132:0x019b, B:134:0x01a1, B:142:0x01be, B:144:0x01c5, B:146:0x01c9, B:159:0x0215, B:161:0x021b, B:171:0x0238, B:172:0x023c, B:174:0x0242, B:185:0x026a, B:187:0x026e, B:189:0x0275, B:191:0x0279, B:192:0x027e, B:194:0x0282, B:195:0x0287, B:196:0x028e, B:198:0x0294, B:203:0x02ae, B:205:0x02b2, B:207:0x02b9, B:209:0x02bd, B:210:0x02c2, B:212:0x02c6, B:213:0x02cb, B:214:0x02d2, B:216:0x02d8, B:224:0x02fa, B:226:0x0308, B:228:0x0315, B:230:0x0319, B:233:0x031e, B:235:0x0321, B:294:0x03d2, B:296:0x03d6, B:298:0x03da, B:300:0x03de, B:302:0x03e2, B:304:0x03e6, B:311:0x03f8, B:313:0x03fc, B:315:0x0400, B:306:0x03ea, B:308:0x03ee, B:319:0x0410, B:321:0x0419, B:323:0x041d, B:324:0x0421, B:325:0x0425, B:327:0x0438, B:331:0x0442, B:332:0x0446, B:336:0x0450, B:337:0x0453, B:340:0x045b, B:342:0x0466, B:344:0x046a, B:346:0x046f, B:350:0x048b, B:351:0x0495, B:354:0x049c, B:358:0x04a6, B:363:0x04b2, B:365:0x04b8, B:367:0x04bc, B:368:0x04be, B:370:0x04c6, B:372:0x04ca, B:373:0x04ce, B:376:0x04dd, B:377:0x04e7, B:378:0x04ea, B:380:0x04ee, B:381:0x04f7, B:384:0x04fd, B:385:0x0508, B:388:0x0517, B:390:0x051e, B:392:0x0527, B:395:0x052b, B:396:0x0530, B:397:0x0537, B:399:0x053b, B:400:0x0540, B:401:0x0547, B:404:0x054f, B:406:0x0558, B:411:0x056c, B:412:0x0571, B:413:0x0576, B:414:0x0581, B:415:0x0586, B:416:0x058b, B:239:0x0328, B:243:0x0336, B:245:0x0343, B:247:0x0347, B:250:0x034c, B:252:0x034f, B:255:0x0357, B:257:0x0361, B:259:0x036c, B:261:0x0370, B:264:0x0377, B:266:0x037a, B:268:0x037f, B:269:0x0386, B:271:0x038e, B:273:0x0399, B:275:0x039d, B:278:0x03a4, B:280:0x03a7, B:282:0x03ac, B:284:0x03b3, B:286:0x03b7, B:163:0x0222, B:165:0x0226, B:166:0x022b, B:168:0x022f, B:147:0x01d9, B:149:0x01dd, B:150:0x01e9, B:152:0x01ed, B:153:0x01fd, B:154:0x0204, B:429:0x05c1, B:430:0x05c5, B:432:0x05cb, B:437:0x05dd, B:439:0x05e6, B:442:0x05f5, B:444:0x05f9, B:445:0x05fd), top: B:474:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x05f5 A[Catch: all -> 0x05a6, Exception -> 0x05ac, TRY_ENTER, TryCatch #8 {Exception -> 0x05ac, all -> 0x05a6, blocks: (B:118:0x0166, B:120:0x0181, B:122:0x0185, B:125:0x018a, B:127:0x018e, B:131:0x0197, B:132:0x019b, B:134:0x01a1, B:142:0x01be, B:144:0x01c5, B:146:0x01c9, B:159:0x0215, B:161:0x021b, B:171:0x0238, B:172:0x023c, B:174:0x0242, B:185:0x026a, B:187:0x026e, B:189:0x0275, B:191:0x0279, B:192:0x027e, B:194:0x0282, B:195:0x0287, B:196:0x028e, B:198:0x0294, B:203:0x02ae, B:205:0x02b2, B:207:0x02b9, B:209:0x02bd, B:210:0x02c2, B:212:0x02c6, B:213:0x02cb, B:214:0x02d2, B:216:0x02d8, B:224:0x02fa, B:226:0x0308, B:228:0x0315, B:230:0x0319, B:233:0x031e, B:235:0x0321, B:294:0x03d2, B:296:0x03d6, B:298:0x03da, B:300:0x03de, B:302:0x03e2, B:304:0x03e6, B:311:0x03f8, B:313:0x03fc, B:315:0x0400, B:306:0x03ea, B:308:0x03ee, B:319:0x0410, B:321:0x0419, B:323:0x041d, B:324:0x0421, B:325:0x0425, B:327:0x0438, B:331:0x0442, B:332:0x0446, B:336:0x0450, B:337:0x0453, B:340:0x045b, B:342:0x0466, B:344:0x046a, B:346:0x046f, B:350:0x048b, B:351:0x0495, B:354:0x049c, B:358:0x04a6, B:363:0x04b2, B:365:0x04b8, B:367:0x04bc, B:368:0x04be, B:370:0x04c6, B:372:0x04ca, B:373:0x04ce, B:376:0x04dd, B:377:0x04e7, B:378:0x04ea, B:380:0x04ee, B:381:0x04f7, B:384:0x04fd, B:385:0x0508, B:388:0x0517, B:390:0x051e, B:392:0x0527, B:395:0x052b, B:396:0x0530, B:397:0x0537, B:399:0x053b, B:400:0x0540, B:401:0x0547, B:404:0x054f, B:406:0x0558, B:411:0x056c, B:412:0x0571, B:413:0x0576, B:414:0x0581, B:415:0x0586, B:416:0x058b, B:239:0x0328, B:243:0x0336, B:245:0x0343, B:247:0x0347, B:250:0x034c, B:252:0x034f, B:255:0x0357, B:257:0x0361, B:259:0x036c, B:261:0x0370, B:264:0x0377, B:266:0x037a, B:268:0x037f, B:269:0x0386, B:271:0x038e, B:273:0x0399, B:275:0x039d, B:278:0x03a4, B:280:0x03a7, B:282:0x03ac, B:284:0x03b3, B:286:0x03b7, B:163:0x0222, B:165:0x0226, B:166:0x022b, B:168:0x022f, B:147:0x01d9, B:149:0x01dd, B:150:0x01e9, B:152:0x01ed, B:153:0x01fd, B:154:0x0204, B:429:0x05c1, B:430:0x05c5, B:432:0x05cb, B:437:0x05dd, B:439:0x05e6, B:442:0x05f5, B:444:0x05f9, B:445:0x05fd), top: B:474:0x0166 }] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0625 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111 A[Catch: all -> 0x0097, Exception -> 0x009c, TRY_ENTER, TryCatch #7 {Exception -> 0x009c, all -> 0x0097, blocks: (B:41:0x008a, B:43:0x008e, B:44:0x0092, B:52:0x00ac, B:54:0x00b5, B:58:0x00c4, B:61:0x00cb, B:63:0x00d2, B:65:0x00d6, B:71:0x00e0, B:73:0x00e6, B:77:0x00ef, B:79:0x00f7, B:80:0x00ff, B:89:0x0111, B:90:0x0115, B:92:0x011b, B:100:0x0134, B:76:0x00eb), top: B:475:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012a  */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r38, java.lang.Object r39, java.lang.Object r40, java.lang.reflect.Type r41) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    public JavaBeanSerializer(Class<?> cls, int i, Map<String, String> map, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        String str2;
        PropertyNamingStrategy naming;
        this.features = 0;
        JSONType jSONType = z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.of(jSONType.serialzeFeatures());
            str = jSONType.typeName();
            if (str.length() == 0) {
                str = null;
                str2 = null;
            } else {
                str2 = null;
                for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str2 = jSONType2.typeKey();
                    if (str2.length() != 0) {
                        break;
                    }
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType3 != null) {
                        str2 = jSONType3.typeKey();
                        if (str2.length() != 0) {
                            break;
                        }
                    }
                }
                if (str2 != null && str2.length() == 0) {
                    str2 = null;
                }
            }
            propertyNamingStrategy2 = (propertyNamingStrategy != null || (naming = jSONType.naming()) == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            str = null;
            str2 = null;
        }
        this.typeName = str;
        this.typeKey = str2;
        List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, i, z, jSONType, map, false, z3, z4, propertyNamingStrategy2);
        ArrayList arrayList = new ArrayList();
        for (FieldInfo fieldInfo : computeGetters) {
            arrayList.add(new FieldSerializer(fieldInfo));
        }
        FieldSerializer[] fieldSerializerArr = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders != null && orders.length != 0) {
            List<FieldInfo> computeGetters2 = TypeUtils.computeGetters(cls, i, z, jSONType, map, true, z3, z4, propertyNamingStrategy2);
            ArrayList arrayList2 = new ArrayList();
            for (FieldInfo fieldInfo2 : computeGetters2) {
                arrayList2.add(new FieldSerializer(fieldInfo2));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
            return;
        }
        FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
        System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        Arrays.sort(fieldSerializerArr2);
        if (Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
            this.sortedGetters = fieldSerializerArr;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }
}
