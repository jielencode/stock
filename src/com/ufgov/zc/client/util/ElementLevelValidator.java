package com.ufgov.zc.client.util;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;import com.ufgov.zc.client.common.LangTransMeta;import com.ufgov.zc.client.datacache.BAccDataCache;import com.ufgov.zc.client.datacache.CompanyDataCache;import com.ufgov.zc.client.datacache.DAttrDataCache;import com.ufgov.zc.client.datacache.FundDataCache;import com.ufgov.zc.client.datacache.OriginDataCache;import com.ufgov.zc.client.datacache.OutlayDataCache;import com.ufgov.zc.client.datacache.PaytypeDataCache;import com.ufgov.zc.client.datacache.ProjectDataCache;import com.ufgov.zc.common.commonbiz.model.BaseElement;import com.ufgov.zc.common.commonbiz.model.DAttr;public class ElementLevelValidator {  private static Map<String, String> nameMap = new HashMap<String, String>();  static {    nameMap.put("CO_CODE", "单位");    nameMap.put("PROJECT_CODE", "项目");    nameMap.put("FUND_CODE", "资金性质");    nameMap.put("ORIGIN_CODE", "指标来源");    nameMap.put("B_ACC_CODE", "功能分类");    nameMap.put("OUTLAY_CODE", "经济分类");    nameMap.put("PAYTYPE_CODE", "支付方式");    nameMap.put("D_ATTR1", LangTransMeta.translate("DP_FIELD_D_ATTR1_NAME"));    nameMap.put("D_ATTR2", LangTransMeta.translate("DP_FIELD_D_ATTR2_NAME"));    nameMap.put("D_ATTR3", LangTransMeta.translate("DP_FIELD_D_ATTR3_NAME"));    nameMap.put("D_ATTR4", LangTransMeta.translate("DP_FIELD_D_ATTR4_NAME"));    nameMap.put("D_ATTR5", LangTransMeta.translate("DP_FIELD_D_ATTR5_NAME"));  }  private static List<String> elementList = new ArrayList<String>();  static {    elementList.add("CO_CODE");    elementList.add("PROJECT_CODE");    elementList.add("B_ACC_CODE");    elementList.add("FUND_CODE");    elementList.add("ORIGIN_CODE");    elementList.add("OUTLAY_CODE");    elementList.add("PAYTYPE_CODE");    elementList.add("D_ATTR1");    elementList.add("D_ATTR2");    elementList.add("D_ATTR3");    elementList.add("D_ATTR4");    elementList.add("D_ATTR5");  }  public static boolean isLeaf(String elementCode, String elementValue) {    boolean isLeaf = true;    if ("FUND_CODE".equals(elementCode)) {      List list = FundDataCache.getFund();      isLeaf = isLeaf(elementValue, list);    } else if ("ORIGIN_CODE".equals(elementCode)) {      List list = OriginDataCache.getOrigin();      isLeaf = isLeaf(elementValue, list);    } else if ("PROJECT_CODE".equals(elementCode)) {      List list = ProjectDataCache.getProject();      isLeaf = isLeaf(elementValue, list);    } else if ("B_ACC_CODE".equals(elementCode)) {      List list = BAccDataCache.getBAcc();      isLeaf = isLeaf(elementValue, list);    } else if ("CO_CODE".equals(elementCode)) {      List list = CompanyDataCache.getCompany();      isLeaf = isLeaf(elementValue, list);    } else if ("OUTLAY_CODE".equals(elementCode)) {      List list = OutlayDataCache.getOutlay();      isLeaf = isLeaf(elementValue, list);    } else if ("D_ATTR1".equals(elementCode)) {      List list = DAttrDataCache.getDAttr(DAttr.D_ATTR1_TYPE);      isLeaf = isLeaf(elementValue, list);    } else if ("D_ATTR2".equals(elementCode)) {      List list = DAttrDataCache.getDAttr(DAttr.D_ATTR2_TYPE);      isLeaf = isLeaf(elementValue, list);    } else if ("D_ATTR3".equals(elementCode)) {      List list = DAttrDataCache.getDAttr(DAttr.D_ATTR3_TYPE);      isLeaf = isLeaf(elementValue, list);    } else if ("D_ATTR4".equals(elementCode)) {      List list = DAttrDataCache.getDAttr(DAttr.D_ATTR4_TYPE);      isLeaf = isLeaf(elementValue, list);    } else if ("D_ATTR5".equals(elementCode)) {      List list = DAttrDataCache.getDAttr(DAttr.D_ATTR5_TYPE);      isLeaf = isLeaf(elementValue, list);    } else if ("PAYTYPE_CODE".equals(elementCode)) {      List list = PaytypeDataCache.getPaytype();      isLeaf = isLeaf(elementValue, list);    }    return isLeaf;  }  private static boolean isLeaf(String elementValue, List list) {    boolean isLeaf = true;    for (Object o : list) {      BaseElement be = (BaseElement) o;      if (be.getParentCode() != null && be.getParentCode().equals(elementValue)) {        isLeaf = false;        break;      }    }    return isLeaf;  }}