package app.visly.stretch;

import androidx.annotation.Keep;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.k80;
import tb.ld2;
import tb.lz1;
import tb.rz0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b6\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\bb\b\u0087\b\u0018\u0000 Û\u00012\u00020\u0001:\u0002Ü\u0001B\u0087\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020L\u0012\b\b\u0002\u0010\t\u001a\u00020N\u0012\b\b\u0002\u0010\n\u001a\u00020P\u0012\b\b\u0002\u0010\u000b\u001a\u00020R\u0012\b\b\u0002\u0010\f\u001a\u00020T\u0012\b\b\u0002\u0010\r\u001a\u00020V\u0012\b\b\u0002\u0010\u000e\u001a\u00020X\u0012\b\b\u0002\u0010\u000f\u001a\u00020Z\u0012\b\b\u0002\u0010\u0010\u001a\u00020\\\u0012\b\b\u0002\u0010\u0011\u001a\u00020^\u0012\u000e\b\u0002\u0010o\u001a\b\u0012\u0004\u0012\u00020a0`\u0012\u000e\b\u0002\u0010p\u001a\b\u0012\u0004\u0012\u00020a0`\u0012\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020a0`\u0012\u000e\b\u0002\u0010r\u001a\b\u0012\u0004\u0012\u00020a0`\u0012\b\b\u0002\u00103\u001a\u00020\u0013\u0012\b\b\u0002\u00104\u001a\u00020\u0013\u0012\b\b\u0002\u0010s\u001a\u00020a\u0012\u000e\b\u0002\u0010t\u001a\b\u0012\u0004\u0012\u00020a0i\u0012\u000e\b\u0002\u0010u\u001a\b\u0012\u0004\u0012\u00020a0i\u0012\u000e\b\u0002\u0010v\u001a\b\u0012\u0004\u0012\u00020a0i\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0013¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 Já\u0003\u0010D\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u0013H\u0082 J\u000f\u0010G\u001a\u00020\u0002H\u0000¢\u0006\u0004\bE\u0010FJ\u0006\u0010H\u001a\u00020\u0002J\u0006\u0010I\u001a\u00020\u0002J\b\u0010K\u001a\u00020JH\u0016J\t\u0010M\u001a\u00020LHÆ\u0003J\t\u0010O\u001a\u00020NHÆ\u0003J\t\u0010Q\u001a\u00020PHÆ\u0003J\t\u0010S\u001a\u00020RHÆ\u0003J\t\u0010U\u001a\u00020THÆ\u0003J\t\u0010W\u001a\u00020VHÆ\u0003J\t\u0010Y\u001a\u00020XHÆ\u0003J\t\u0010[\u001a\u00020ZHÆ\u0003J\t\u0010]\u001a\u00020\\HÆ\u0003J\t\u0010_\u001a\u00020^HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020a0`HÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020a0`HÆ\u0003J\u000f\u0010e\u001a\b\u0012\u0004\u0012\u00020a0`HÆ\u0003J\t\u0010f\u001a\u00020\u0013HÆ\u0003J\t\u0010g\u001a\u00020\u0013HÆ\u0003J\t\u0010h\u001a\u00020aHÆ\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020a0iHÆ\u0003J\u000f\u0010k\u001a\b\u0012\u0004\u0012\u00020a0iHÆ\u0003J\u000f\u0010l\u001a\b\u0012\u0004\u0012\u00020a0iHÆ\u0003J\u0012\u0010m\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bm\u0010nJ\u008e\u0002\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020L2\b\b\u0002\u0010\t\u001a\u00020N2\b\b\u0002\u0010\n\u001a\u00020P2\b\b\u0002\u0010\u000b\u001a\u00020R2\b\b\u0002\u0010\f\u001a\u00020T2\b\b\u0002\u0010\r\u001a\u00020V2\b\b\u0002\u0010\u000e\u001a\u00020X2\b\b\u0002\u0010\u000f\u001a\u00020Z2\b\b\u0002\u0010\u0010\u001a\u00020\\2\b\b\u0002\u0010\u0011\u001a\u00020^2\u000e\b\u0002\u0010o\u001a\b\u0012\u0004\u0012\u00020a0`2\u000e\b\u0002\u0010p\u001a\b\u0012\u0004\u0012\u00020a0`2\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020a0`2\u000e\b\u0002\u0010r\u001a\b\u0012\u0004\u0012\u00020a0`2\b\b\u0002\u00103\u001a\u00020\u00132\b\b\u0002\u00104\u001a\u00020\u00132\b\b\u0002\u0010s\u001a\u00020a2\u000e\b\u0002\u0010t\u001a\b\u0012\u0004\u0012\u00020a0i2\u000e\b\u0002\u0010u\u001a\b\u0012\u0004\u0012\u00020a0i2\u000e\b\u0002\u0010v\u001a\b\u0012\u0004\u0012\u00020a0i2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\bw\u0010xJ\t\u0010y\u001a\u00020\u0007HÖ\u0001J\u0013\u0010|\u001a\u00020{2\b\u0010z\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\b\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\b\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\t\u001a\u00020N8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\t\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010\n\u001a\u00020P8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\n\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R'\u0010\u000b\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000b\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R'\u0010\f\u001a\u00020T8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\f\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R'\u0010\r\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\r\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R'\u0010\u000e\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000e\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R'\u0010\u000f\u001a\u00020Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u000f\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R'\u0010\u0010\u001a\u00020\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0010\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R'\u0010\u0011\u001a\u00020^8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0011\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R'\u00103\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b3\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R'\u00104\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b4\u0010¯\u0001\u001a\u0006\b´\u0001\u0010±\u0001\"\u0006\bµ\u0001\u0010³\u0001R(\u0010C\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bC\u0010¶\u0001\u001a\u0005\b·\u0001\u0010n\"\u0006\b¸\u0001\u0010¹\u0001R)\u0010º\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R-\u0010o\u001a\b\u0012\u0004\u0012\u00020a0`8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bo\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R-\u0010p\u001a\b\u0012\u0004\u0012\u00020a0`8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bp\u0010À\u0001\u001a\u0006\bÅ\u0001\u0010Â\u0001\"\u0006\bÆ\u0001\u0010Ä\u0001R-\u0010q\u001a\b\u0012\u0004\u0012\u00020a0`8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bq\u0010À\u0001\u001a\u0006\bÇ\u0001\u0010Â\u0001\"\u0006\bÈ\u0001\u0010Ä\u0001R-\u0010r\u001a\b\u0012\u0004\u0012\u00020a0`8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\br\u0010À\u0001\u001a\u0006\bÉ\u0001\u0010Â\u0001\"\u0006\bÊ\u0001\u0010Ä\u0001R'\u0010s\u001a\u00020a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bs\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R-\u0010t\u001a\b\u0012\u0004\u0012\u00020a0i8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bt\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R-\u0010u\u001a\b\u0012\u0004\u0012\u00020a0i8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bu\u0010Ð\u0001\u001a\u0006\bÕ\u0001\u0010Ò\u0001\"\u0006\bÖ\u0001\u0010Ô\u0001R-\u0010v\u001a\b\u0012\u0004\u0012\u00020a0i8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bv\u0010Ð\u0001\u001a\u0006\b×\u0001\u0010Ò\u0001\"\u0006\bØ\u0001\u0010Ô\u0001¨\u0006Ý\u0001"}, d2 = {"Lapp/visly/stretch/Style;", "", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "", "ptr", "nFree", "", "display", "positionType", "direction", Constants.Name.FLEX_DIRECTION, Constants.Name.FLEX_WRAP, Constants.Name.OVERFLOW, Constants.Name.ALIGN_ITEMS, Constants.Name.ALIGN_SELF, "alignContent", Constants.Name.JUSTIFY_CONTENT, "positionStartType", "", "positionStartValue", "positionEndType", "positionEndValue", "positionTopType", "positionTopValue", "positionBottomType", "positionBottomValue", "marginStartType", "marginStartValue", "marginEndType", "marginEndValue", "marginTopType", "marginTopValue", "marginBottomType", "marginBottomValue", "paddingStartType", "paddingStartValue", "paddingEndType", "paddingEndValue", "paddingTopType", "paddingTopValue", "paddingBottomType", "paddingBottomValue", "borderStartType", "borderStartValue", "borderEndType", "borderEndValue", "borderTopType", "borderTopValue", "borderBottomType", "borderBottomValue", "flexGrow", "flexShrink", "flexBasisType", "flexBasisValue", "widthType", "widthValue", "heightType", "heightValue", "minWidthType", "minWidthValue", "minHeightType", "minHeightValue", "maxWidthType", "maxWidthValue", "maxHeightType", "maxHeightValue", "aspectRatio", "nConstruct", "free$GaiaX", "()V", "free", "safeFree", "safeInit", "", "toString", "Lapp/visly/stretch/Display;", "component1", "Lapp/visly/stretch/PositionType;", "component2", "Lapp/visly/stretch/Direction;", "component3", "Lapp/visly/stretch/FlexDirection;", "component4", "Lapp/visly/stretch/FlexWrap;", "component5", "Lapp/visly/stretch/Overflow;", "component6", "Lapp/visly/stretch/AlignItems;", "component7", "Lapp/visly/stretch/AlignSelf;", "component8", "Lapp/visly/stretch/AlignContent;", "component9", "Lapp/visly/stretch/JustifyContent;", "component10", "Ltb/lz1;", "Ltb/k80;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "Ltb/ld2;", "component18", "component19", "component20", "component21", "()Ljava/lang/Float;", "position", Constants.Name.MARGIN, Constants.Name.PADDING, "border", "flexBasis", "size", "minSize", "maxSize", rz0.ARG_COPY, "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Ltb/lz1;Ltb/lz1;Ltb/lz1;Ltb/lz1;FFLtb/k80;Ltb/ld2;Ltb/ld2;Ltb/ld2;Ljava/lang/Float;)Lapp/visly/stretch/Style;", "hashCode", "other", "", "equals", "Lapp/visly/stretch/Display;", "getDisplay", "()Lapp/visly/stretch/Display;", "setDisplay", "(Lapp/visly/stretch/Display;)V", "Lapp/visly/stretch/PositionType;", "getPositionType", "()Lapp/visly/stretch/PositionType;", "setPositionType", "(Lapp/visly/stretch/PositionType;)V", "Lapp/visly/stretch/Direction;", "getDirection", "()Lapp/visly/stretch/Direction;", "setDirection", "(Lapp/visly/stretch/Direction;)V", "Lapp/visly/stretch/FlexDirection;", "getFlexDirection", "()Lapp/visly/stretch/FlexDirection;", "setFlexDirection", "(Lapp/visly/stretch/FlexDirection;)V", "Lapp/visly/stretch/FlexWrap;", "getFlexWrap", "()Lapp/visly/stretch/FlexWrap;", "setFlexWrap", "(Lapp/visly/stretch/FlexWrap;)V", "Lapp/visly/stretch/Overflow;", "getOverflow", "()Lapp/visly/stretch/Overflow;", "setOverflow", "(Lapp/visly/stretch/Overflow;)V", "Lapp/visly/stretch/AlignItems;", "getAlignItems", "()Lapp/visly/stretch/AlignItems;", "setAlignItems", "(Lapp/visly/stretch/AlignItems;)V", "Lapp/visly/stretch/AlignSelf;", "getAlignSelf", "()Lapp/visly/stretch/AlignSelf;", "setAlignSelf", "(Lapp/visly/stretch/AlignSelf;)V", "Lapp/visly/stretch/AlignContent;", "getAlignContent", "()Lapp/visly/stretch/AlignContent;", "setAlignContent", "(Lapp/visly/stretch/AlignContent;)V", "Lapp/visly/stretch/JustifyContent;", "getJustifyContent", "()Lapp/visly/stretch/JustifyContent;", "setJustifyContent", "(Lapp/visly/stretch/JustifyContent;)V", UTConstant.Args.UT_SUCCESS_F, "getFlexGrow", "()F", "setFlexGrow", "(F)V", "getFlexShrink", "setFlexShrink", "Ljava/lang/Float;", "getAspectRatio", "setAspectRatio", "(Ljava/lang/Float;)V", "rustptr", "J", "getRustptr", "()J", "setRustptr", "(J)V", "Ltb/lz1;", "getPosition", "()Ltb/lz1;", "setPosition", "(Ltb/lz1;)V", "getMargin", "setMargin", "getPadding", "setPadding", "getBorder", "setBorder", "Ltb/k80;", "getFlexBasis", "()Ltb/k80;", "setFlexBasis", "(Ltb/k80;)V", "Ltb/ld2;", "getSize", "()Ltb/ld2;", "setSize", "(Ltb/ld2;)V", "getMinSize", "setMinSize", "getMaxSize", "setMaxSize", "<init>", "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Ltb/lz1;Ltb/lz1;Ltb/lz1;Ltb/lz1;FFLtb/k80;Ltb/ld2;Ltb/ld2;Ltb/ld2;Ljava/lang/Float;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Style {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private AlignContent alignContent;
    @NotNull
    private AlignItems alignItems;
    @NotNull
    private AlignSelf alignSelf;
    @Nullable
    private Float aspectRatio;
    @NotNull
    private lz1<k80> border;
    @NotNull
    private Direction direction;
    @NotNull
    private Display display;
    @NotNull
    private k80 flexBasis;
    @NotNull
    private FlexDirection flexDirection;
    private float flexGrow;
    private float flexShrink;
    @NotNull
    private FlexWrap flexWrap;
    @NotNull
    private JustifyContent justifyContent;
    @NotNull
    private lz1<k80> margin;
    @NotNull
    private ld2<k80> maxSize;
    @NotNull
    private ld2<k80> minSize;
    @NotNull
    private Overflow overflow;
    @NotNull
    private lz1<k80> padding;
    @NotNull
    private lz1<k80> position;
    @NotNull
    private PositionType positionType;
    private long rustptr;
    @NotNull
    private ld2<k80> size;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        Stretch.Companion.b();
    }

    public Style() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, 2097151, null);
    }

    public Style(@NotNull Display display, @NotNull PositionType positionType, @NotNull Direction direction, @NotNull FlexDirection flexDirection, @NotNull FlexWrap flexWrap, @NotNull Overflow overflow, @NotNull AlignItems alignItems, @NotNull AlignSelf alignSelf, @NotNull AlignContent alignContent, @NotNull JustifyContent justifyContent, @NotNull lz1<k80> lz1Var, @NotNull lz1<k80> lz1Var2, @NotNull lz1<k80> lz1Var3, @NotNull lz1<k80> lz1Var4, float f, float f2, @NotNull k80 k80Var, @NotNull ld2<k80> ld2Var, @NotNull ld2<k80> ld2Var2, @NotNull ld2<k80> ld2Var3, @Nullable Float f3) {
        b41.i(display, "display");
        b41.i(positionType, "positionType");
        b41.i(direction, "direction");
        b41.i(flexDirection, Constants.Name.FLEX_DIRECTION);
        b41.i(flexWrap, Constants.Name.FLEX_WRAP);
        b41.i(overflow, Constants.Name.OVERFLOW);
        b41.i(alignItems, Constants.Name.ALIGN_ITEMS);
        b41.i(alignSelf, Constants.Name.ALIGN_SELF);
        b41.i(alignContent, "alignContent");
        b41.i(justifyContent, Constants.Name.JUSTIFY_CONTENT);
        b41.i(lz1Var, "position");
        b41.i(lz1Var2, Constants.Name.MARGIN);
        b41.i(lz1Var3, Constants.Name.PADDING);
        b41.i(lz1Var4, "border");
        b41.i(k80Var, "flexBasis");
        b41.i(ld2Var, "size");
        b41.i(ld2Var2, "minSize");
        b41.i(ld2Var3, "maxSize");
        this.display = display;
        this.positionType = positionType;
        this.direction = direction;
        this.flexDirection = flexDirection;
        this.flexWrap = flexWrap;
        this.overflow = overflow;
        this.alignItems = alignItems;
        this.alignSelf = alignSelf;
        this.alignContent = alignContent;
        this.justifyContent = justifyContent;
        this.position = lz1Var;
        this.margin = lz1Var2;
        this.padding = lz1Var3;
        this.border = lz1Var4;
        this.flexGrow = f;
        this.flexShrink = f2;
        this.flexBasis = k80Var;
        this.size = ld2Var;
        this.minSize = ld2Var2;
        this.maxSize = ld2Var3;
        this.aspectRatio = f3;
        this.rustptr = -1L;
    }

    private final void init() {
        int ordinal = this.display.ordinal();
        int ordinal2 = this.positionType.ordinal();
        int ordinal3 = this.direction.ordinal();
        int ordinal4 = this.flexDirection.ordinal();
        int ordinal5 = this.flexWrap.ordinal();
        int ordinal6 = this.overflow.ordinal();
        int ordinal7 = this.alignItems.ordinal();
        int ordinal8 = this.alignSelf.ordinal();
        int ordinal9 = this.alignContent.ordinal();
        int ordinal10 = this.justifyContent.ordinal();
        int a2 = this.position.c().a();
        float b = this.position.c().b();
        int a3 = this.position.b().a();
        float b2 = this.position.b().b();
        int a4 = this.position.d().a();
        float b3 = this.position.d().b();
        int a5 = this.position.a().a();
        float b4 = this.position.a().b();
        int a6 = this.margin.c().a();
        float b5 = this.margin.c().b();
        int a7 = this.margin.b().a();
        float b6 = this.margin.b().b();
        int a8 = this.margin.d().a();
        float b7 = this.margin.d().b();
        int a9 = this.margin.a().a();
        float b8 = this.margin.a().b();
        int a10 = this.padding.c().a();
        float b9 = this.padding.c().b();
        int a11 = this.padding.b().a();
        float b10 = this.padding.b().b();
        int a12 = this.padding.d().a();
        float b11 = this.padding.d().b();
        int a13 = this.padding.a().a();
        float b12 = this.padding.a().b();
        int a14 = this.border.c().a();
        float b13 = this.border.c().b();
        int a15 = this.border.b().a();
        float b14 = this.border.b().b();
        int a16 = this.border.d().a();
        float b15 = this.border.d().b();
        int a17 = this.border.a().a();
        float b16 = this.border.a().b();
        float f = this.flexGrow;
        float f2 = this.flexShrink;
        int a18 = this.flexBasis.a();
        float b17 = this.flexBasis.b();
        int a19 = this.size.b().a();
        float b18 = this.size.b().b();
        int a20 = this.size.a().a();
        float b19 = this.size.a().b();
        int a21 = this.minSize.b().a();
        float b20 = this.minSize.b().b();
        int a22 = this.minSize.a().a();
        float b21 = this.minSize.a().b();
        int a23 = this.maxSize.b().a();
        float b22 = this.maxSize.b().b();
        int a24 = this.maxSize.a().a();
        float b23 = this.maxSize.a().b();
        Float f3 = this.aspectRatio;
        this.rustptr = nConstruct(ordinal, ordinal2, ordinal3, ordinal4, ordinal5, ordinal6, ordinal7, ordinal8, ordinal9, ordinal10, a2, b, a3, b2, a4, b3, a5, b4, a6, b5, a7, b6, a8, b7, a9, b8, a10, b9, a11, b10, a12, b11, a13, b12, a14, b13, a15, b14, a16, b15, a17, b16, f, f2, a18, b17, a19, b18, a20, b19, a21, b20, a22, b21, a23, b22, a24, b23, f3 == null ? Float.NaN : f3.floatValue());
    }

    private final native long nConstruct(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f, int i12, float f2, int i13, float f3, int i14, float f4, int i15, float f5, int i16, float f6, int i17, float f7, int i18, float f8, int i19, float f9, int i20, float f10, int i21, float f11, int i22, float f12, int i23, float f13, int i24, float f14, int i25, float f15, int i26, float f16, float f17, float f18, int i27, float f19, int i28, float f20, int i29, float f21, int i30, float f22, int i31, float f23, int i32, float f24, int i33, float f25, float f26);

    private final native void nFree(long j);

    @NotNull
    public final Display component1() {
        return this.display;
    }

    @NotNull
    public final JustifyContent component10() {
        return this.justifyContent;
    }

    @NotNull
    public final lz1<k80> component11() {
        return this.position;
    }

    @NotNull
    public final lz1<k80> component12() {
        return this.margin;
    }

    @NotNull
    public final lz1<k80> component13() {
        return this.padding;
    }

    @NotNull
    public final lz1<k80> component14() {
        return this.border;
    }

    public final float component15() {
        return this.flexGrow;
    }

    public final float component16() {
        return this.flexShrink;
    }

    @NotNull
    public final k80 component17() {
        return this.flexBasis;
    }

    @NotNull
    public final ld2<k80> component18() {
        return this.size;
    }

    @NotNull
    public final ld2<k80> component19() {
        return this.minSize;
    }

    @NotNull
    public final PositionType component2() {
        return this.positionType;
    }

    @NotNull
    public final ld2<k80> component20() {
        return this.maxSize;
    }

    @Nullable
    public final Float component21() {
        return this.aspectRatio;
    }

    @NotNull
    public final Direction component3() {
        return this.direction;
    }

    @NotNull
    public final FlexDirection component4() {
        return this.flexDirection;
    }

    @NotNull
    public final FlexWrap component5() {
        return this.flexWrap;
    }

    @NotNull
    public final Overflow component6() {
        return this.overflow;
    }

    @NotNull
    public final AlignItems component7() {
        return this.alignItems;
    }

    @NotNull
    public final AlignSelf component8() {
        return this.alignSelf;
    }

    @NotNull
    public final AlignContent component9() {
        return this.alignContent;
    }

    @NotNull
    public final Style copy(@NotNull Display display, @NotNull PositionType positionType, @NotNull Direction direction, @NotNull FlexDirection flexDirection, @NotNull FlexWrap flexWrap, @NotNull Overflow overflow, @NotNull AlignItems alignItems, @NotNull AlignSelf alignSelf, @NotNull AlignContent alignContent, @NotNull JustifyContent justifyContent, @NotNull lz1<k80> lz1Var, @NotNull lz1<k80> lz1Var2, @NotNull lz1<k80> lz1Var3, @NotNull lz1<k80> lz1Var4, float f, float f2, @NotNull k80 k80Var, @NotNull ld2<k80> ld2Var, @NotNull ld2<k80> ld2Var2, @NotNull ld2<k80> ld2Var3, @Nullable Float f3) {
        b41.i(display, "display");
        b41.i(positionType, "positionType");
        b41.i(direction, "direction");
        b41.i(flexDirection, Constants.Name.FLEX_DIRECTION);
        b41.i(flexWrap, Constants.Name.FLEX_WRAP);
        b41.i(overflow, Constants.Name.OVERFLOW);
        b41.i(alignItems, Constants.Name.ALIGN_ITEMS);
        b41.i(alignSelf, Constants.Name.ALIGN_SELF);
        b41.i(alignContent, "alignContent");
        b41.i(justifyContent, Constants.Name.JUSTIFY_CONTENT);
        b41.i(lz1Var, "position");
        b41.i(lz1Var2, Constants.Name.MARGIN);
        b41.i(lz1Var3, Constants.Name.PADDING);
        b41.i(lz1Var4, "border");
        b41.i(k80Var, "flexBasis");
        b41.i(ld2Var, "size");
        b41.i(ld2Var2, "minSize");
        b41.i(ld2Var3, "maxSize");
        return new Style(display, positionType, direction, flexDirection, flexWrap, overflow, alignItems, alignSelf, alignContent, justifyContent, lz1Var, lz1Var2, lz1Var3, lz1Var4, f, f2, k80Var, ld2Var, ld2Var2, ld2Var3, f3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Style) {
            Style style = (Style) obj;
            return this.display == style.display && this.positionType == style.positionType && this.direction == style.direction && this.flexDirection == style.flexDirection && this.flexWrap == style.flexWrap && this.overflow == style.overflow && this.alignItems == style.alignItems && this.alignSelf == style.alignSelf && this.alignContent == style.alignContent && this.justifyContent == style.justifyContent && b41.d(this.position, style.position) && b41.d(this.margin, style.margin) && b41.d(this.padding, style.padding) && b41.d(this.border, style.border) && b41.d(Float.valueOf(this.flexGrow), Float.valueOf(style.flexGrow)) && b41.d(Float.valueOf(this.flexShrink), Float.valueOf(style.flexShrink)) && b41.d(this.flexBasis, style.flexBasis) && b41.d(this.size, style.size) && b41.d(this.minSize, style.minSize) && b41.d(this.maxSize, style.maxSize) && b41.d(this.aspectRatio, style.aspectRatio);
        }
        return false;
    }

    public final void free$GaiaX() {
        long j = this.rustptr;
        if (j != -1) {
            nFree(j);
            this.rustptr = -1L;
        }
    }

    @NotNull
    public final AlignContent getAlignContent() {
        return this.alignContent;
    }

    @NotNull
    public final AlignItems getAlignItems() {
        return this.alignItems;
    }

    @NotNull
    public final AlignSelf getAlignSelf() {
        return this.alignSelf;
    }

    @Nullable
    public final Float getAspectRatio() {
        return this.aspectRatio;
    }

    @NotNull
    public final lz1<k80> getBorder() {
        return this.border;
    }

    @NotNull
    public final Direction getDirection() {
        return this.direction;
    }

    @NotNull
    public final Display getDisplay() {
        return this.display;
    }

    @NotNull
    public final k80 getFlexBasis() {
        return this.flexBasis;
    }

    @NotNull
    public final FlexDirection getFlexDirection() {
        return this.flexDirection;
    }

    public final float getFlexGrow() {
        return this.flexGrow;
    }

    public final float getFlexShrink() {
        return this.flexShrink;
    }

    @NotNull
    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    @NotNull
    public final JustifyContent getJustifyContent() {
        return this.justifyContent;
    }

    @NotNull
    public final lz1<k80> getMargin() {
        return this.margin;
    }

    @NotNull
    public final ld2<k80> getMaxSize() {
        return this.maxSize;
    }

    @NotNull
    public final ld2<k80> getMinSize() {
        return this.minSize;
    }

    @NotNull
    public final Overflow getOverflow() {
        return this.overflow;
    }

    @NotNull
    public final lz1<k80> getPadding() {
        return this.padding;
    }

    @NotNull
    public final lz1<k80> getPosition() {
        return this.position;
    }

    @NotNull
    public final PositionType getPositionType() {
        return this.positionType;
    }

    public final long getRustptr() {
        return this.rustptr;
    }

    @NotNull
    public final ld2<k80> getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((this.display.hashCode() * 31) + this.positionType.hashCode()) * 31) + this.direction.hashCode()) * 31) + this.flexDirection.hashCode()) * 31) + this.flexWrap.hashCode()) * 31) + this.overflow.hashCode()) * 31) + this.alignItems.hashCode()) * 31) + this.alignSelf.hashCode()) * 31) + this.alignContent.hashCode()) * 31) + this.justifyContent.hashCode()) * 31) + this.position.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.border.hashCode()) * 31) + Float.floatToIntBits(this.flexGrow)) * 31) + Float.floatToIntBits(this.flexShrink)) * 31) + this.flexBasis.hashCode()) * 31) + this.size.hashCode()) * 31) + this.minSize.hashCode()) * 31) + this.maxSize.hashCode()) * 31;
        Float f = this.aspectRatio;
        return hashCode + (f == null ? 0 : f.hashCode());
    }

    public final void safeFree() {
        synchronized (Stretch.class) {
            free$GaiaX();
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void safeInit() {
        synchronized (Stretch.class) {
            init();
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void setAlignContent(@NotNull AlignContent alignContent) {
        b41.i(alignContent, "<set-?>");
        this.alignContent = alignContent;
    }

    public final void setAlignItems(@NotNull AlignItems alignItems) {
        b41.i(alignItems, "<set-?>");
        this.alignItems = alignItems;
    }

    public final void setAlignSelf(@NotNull AlignSelf alignSelf) {
        b41.i(alignSelf, "<set-?>");
        this.alignSelf = alignSelf;
    }

    public final void setAspectRatio(@Nullable Float f) {
        this.aspectRatio = f;
    }

    public final void setBorder(@NotNull lz1<k80> lz1Var) {
        b41.i(lz1Var, "<set-?>");
        this.border = lz1Var;
    }

    public final void setDirection(@NotNull Direction direction) {
        b41.i(direction, "<set-?>");
        this.direction = direction;
    }

    public final void setDisplay(@NotNull Display display) {
        b41.i(display, "<set-?>");
        this.display = display;
    }

    public final void setFlexBasis(@NotNull k80 k80Var) {
        b41.i(k80Var, "<set-?>");
        this.flexBasis = k80Var;
    }

    public final void setFlexDirection(@NotNull FlexDirection flexDirection) {
        b41.i(flexDirection, "<set-?>");
        this.flexDirection = flexDirection;
    }

    public final void setFlexGrow(float f) {
        this.flexGrow = f;
    }

    public final void setFlexShrink(float f) {
        this.flexShrink = f;
    }

    public final void setFlexWrap(@NotNull FlexWrap flexWrap) {
        b41.i(flexWrap, "<set-?>");
        this.flexWrap = flexWrap;
    }

    public final void setJustifyContent(@NotNull JustifyContent justifyContent) {
        b41.i(justifyContent, "<set-?>");
        this.justifyContent = justifyContent;
    }

    public final void setMargin(@NotNull lz1<k80> lz1Var) {
        b41.i(lz1Var, "<set-?>");
        this.margin = lz1Var;
    }

    public final void setMaxSize(@NotNull ld2<k80> ld2Var) {
        b41.i(ld2Var, "<set-?>");
        this.maxSize = ld2Var;
    }

    public final void setMinSize(@NotNull ld2<k80> ld2Var) {
        b41.i(ld2Var, "<set-?>");
        this.minSize = ld2Var;
    }

    public final void setOverflow(@NotNull Overflow overflow) {
        b41.i(overflow, "<set-?>");
        this.overflow = overflow;
    }

    public final void setPadding(@NotNull lz1<k80> lz1Var) {
        b41.i(lz1Var, "<set-?>");
        this.padding = lz1Var;
    }

    public final void setPosition(@NotNull lz1<k80> lz1Var) {
        b41.i(lz1Var, "<set-?>");
        this.position = lz1Var;
    }

    public final void setPositionType(@NotNull PositionType positionType) {
        b41.i(positionType, "<set-?>");
        this.positionType = positionType;
    }

    public final void setRustptr(long j) {
        this.rustptr = j;
    }

    public final void setSize(@NotNull ld2<k80> ld2Var) {
        b41.i(ld2Var, "<set-?>");
        this.size = ld2Var;
    }

    @NotNull
    public String toString() {
        return "Style(display=" + this.display + ", positionType=" + this.positionType + ", direction=" + this.direction + ", flexDirection=" + this.flexDirection + ", flexWrap=" + this.flexWrap + ", overflow=" + this.overflow + ", alignItems=" + this.alignItems + ", alignSelf=" + this.alignSelf + ", alignContent=" + this.alignContent + ", justifyContent=" + this.justifyContent + ", position=" + this.position + ", margin=" + this.margin + ", padding=" + this.padding + ", border=" + this.border + ", flexGrow=" + this.flexGrow + ", flexShrink=" + this.flexShrink + ", flexBasis=" + this.flexBasis + ", size=" + this.size + ", minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", aspectRatio=" + this.aspectRatio + ", rustptr=" + this.rustptr + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Style(app.visly.stretch.Display r22, app.visly.stretch.PositionType r23, app.visly.stretch.Direction r24, app.visly.stretch.FlexDirection r25, app.visly.stretch.FlexWrap r26, app.visly.stretch.Overflow r27, app.visly.stretch.AlignItems r28, app.visly.stretch.AlignSelf r29, app.visly.stretch.AlignContent r30, app.visly.stretch.JustifyContent r31, tb.lz1 r32, tb.lz1 r33, tb.lz1 r34, tb.lz1 r35, float r36, float r37, tb.k80 r38, tb.ld2 r39, tb.ld2 r40, tb.ld2 r41, java.lang.Float r42, int r43, tb.k50 r44) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: app.visly.stretch.Style.<init>(app.visly.stretch.Display, app.visly.stretch.PositionType, app.visly.stretch.Direction, app.visly.stretch.FlexDirection, app.visly.stretch.FlexWrap, app.visly.stretch.Overflow, app.visly.stretch.AlignItems, app.visly.stretch.AlignSelf, app.visly.stretch.AlignContent, app.visly.stretch.JustifyContent, tb.lz1, tb.lz1, tb.lz1, tb.lz1, float, float, tb.k80, tb.ld2, tb.ld2, tb.ld2, java.lang.Float, int, tb.k50):void");
    }
}
