package com.taobao.ma.qr.parser;

import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.parser.MaParSer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaGen3ParSer extends MaParSer {
    @Override // com.taobao.ma.parser.MaParSer
    public MaResult decode(MaWapperResult maWapperResult) {
        if (MaAnalyzeHelper.isGen3Code(maWapperResult.type, maWapperResult.maType, maWapperResult.subType)) {
            return new MaResult(maWapperResult.maType, maWapperResult.strCode);
        }
        return null;
    }
}
