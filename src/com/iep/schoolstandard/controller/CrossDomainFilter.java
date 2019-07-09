package com.iep.schoolstandard.controller;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.context.annotation.Configuration;

/*
 * 閺夆晜鐟ょ粭浣圭▔椤忓懏鏆堥悷娆欑悼濞堟垶鎷呭鍛殢缂佹稑顦幃鎾寸鎼粹剝韬瑆eb.xml濞戞搩鍙冮崢銈囩磾椤旇法绠栨繝濞垮�栧Σ褏浜搁崟鍓佺濞戞挶鍊楅～鎺楀棘鐟欏嫮銆婇柛娆樺灟娴滄帗绂嶅畝鍕舵嫹婢跺顏遍柨娑虫嫹
 *@WebFilter婵炲鍔忚闁烩偓鍔嬬花顒備焊閸℃洜顏卞☉鎿冧簽鐞氼偅绔熼悧鍫燁潠濞戞捇缂氱换鍐煥閵堝懏鐝ら柨娑樼焷椤曟艾鈻旈妸銊愭帞浜搁崱鏇犵獥闁革负鍔戦崕瀵哥磾閸欏顦ч悶姘煎亜椤旀劙宕抽妸銉П闁荤偛妫寸槐婵堬拷鍦嚀濞呮帞浜搁崱妯煎闁硅鍠栭崣鎸庢媴閹捐埖鐣遍悘鐐靛仦閿熺獤鍥у赋缂傚喚鍠栭惃銏ゅ传瀹ュ懐瀹夐柣銊ュ鐞氼偆鏁崘鈺冩殨濞戞捇缂氱换鍐煥閵堝懏鐝ら柕鍡嫹
 *@Order婵炲鍔忚濞戞挻妲掗々锕傛偨閵婏附闄嶉柟璨夊啫鐓戦梺鏉跨С缁狅絿鐚鹃懡銈嗙暠闁告梻濮惧ù鍥ㄣ亜閸濆嫮纰嶉柨娑樿嫰缂嶅alue闁哄嫷鍨遍婊堝极閻楀牊顦ч柨娑樿嫰閿熷�熷缁夎櫣浜歌箛鏃�绠掑ù鍏济崢娑欐償閿曚胶楔濡ゅ偊鎷�
 *@Config閻犲洢鍎查弫鐐垫喆閿濆洦鏆忓ù婊冮閻ｇ偓绋婃径鎰赋缂傚喚鍠氱悮锟�
 */
//@WebFilter(filterName = "crossDomainFilter", urlPatterns = { "/*" })
//@Order(value = 1)
//@Configuration
public class CrossDomainFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("过滤了");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 闁告繂绉寸花鏌ュ冀閸パ佷粓闁圭娲ら悾楣冩晬鐏炴儳鐦归悗瑙勮壘瑜板弶绂掗妷顭戝晱闂傚偆鍠涚粊顐⑩攦閹邦喗鐣眜rl閻犱警鍨扮欢锟�
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

		// 闁告繂绉寸花鏌ュ冀閸パ佷粓闁圭娲ら悾楣冩晬鐏炶姤鎯欓幖瀛樻煥缁ㄨ尙鎷嬮崸妤侊紪闁圭鎷烽弶鈺傚缁侇偄鈹冮幇顒�鐓傞弶鍫㈠亾濡炲倿鏁嶇仦钘夊笒閻犱礁鎽滃▓鎴炵▔閿熺晫绮斿鍡楃仐闁哄嫷鍨伴ˇ璺ㄧ矓瀹ュ棙鐓欐繛澶嬫穿缁辨瑧鎷犻柨瀣勾闁哄倽顫夌涵鍫曟晬閿燂拷
		response.setHeader("Access-Control-Allow-Method", "*");

		// 閻犱礁澧介悿锟� 缂傚倹鎸搁悺銊╁矗椤栨瑤绨伴柣銏㈠枎閻°劑鎯冮崟顒佷粯濠㈠爢鍜佹健闁轰緤鎷�
		response.setHeader("Access-Control-Max-Age", "3600");

		// 閻犱礁澧介悿锟� 闁告瑦顨嗛弫顕�骞愭担绛嬪殲婵懓鍊归悥锝嗗緞鏉堝墽绀勯柤濂変簻婵晜鎯旈弬鍙ョ鞍 闁告瑯鍨禍鎺旀媼閸ф锛栭柣銊ュ椤曨剙效閸屾哎浠堥柨娑虫嫹
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");

		// 闁煎浜滈悾鐐▕閿燂拷 闁告瑯鍨禍鎺旀偖椤愩儺鍟忛梻鍌ゅ枤濞堟垿宕鍛畨濠㈣鎷�
		response.setHeader("Access-Control-Expose-Headers", "checkTokenResult");

		// 闁圭娲ㄩ妵姘舵儍閸曨噮鍤炴慨鐟板�诲▓鎴﹀传瀹ュ懐瀹夐柡鍕靛灠閹線宕ｉ娆庣鞍闁哄棙鎸冲﹢鑸电鎼淬値鍤夊銈囨暬濞间即濡撮崒姘辩Ъ閺夆晜鏌ㄥú鏉ue闁哄啯婀圭划顒勫矗椤栨瑤绨伴悶姘煎亝濮ｆ岸妫侀敓锟�
		response.setHeader("Access-Control-Allow-Credentilas", "true");

		response.setHeader("Cache-Control", "no-cache");

		// 闁硅泛锕ㄩ顒�效閸屾瑧鐐婇柛銉у仩缁诲啫顭ㄩ妶澶嬫嚑
		filterChain.doFilter(servletRequest, servletResponse);
	}

}
