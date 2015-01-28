package com.ufgov.zc.client.datacache;import java.util.Collections;import java.util.HashMap;import java.util.List;import java.util.Map;import com.ufgov.zc.client.common.AsOptionMeta;import com.ufgov.zc.client.common.WorkEnv;import com.ufgov.zc.common.commonbiz.model.BAcc;import com.ufgov.zc.common.commonbiz.model.Fund;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.constants.BusinessOptionConstants;import com.ufgov.zc.common.system.dto.ElementConditionDto;public class BAccDataCache {  private static List dataList;  private static Map dataMap;  private static String showType = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_CODE_NAME_SHOW_TYPE);  public static synchronized void refreshData() {    int nd = WorkEnv.getInstance().getTransNd();    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();    ElementConditionDto dto = new ElementConditionDto();    dto.setNd(nd);    dataList = Collections.unmodifiableList(Util.baseDataServiceDelegate.getBAcc(dto, requestMeta));    Map tempMap = new HashMap();    for (Object o : dataList) {      BAcc temp = (BAcc) o;      tempMap.put(temp.getCode(), temp);    }    dataMap = Collections.unmodifiableMap(tempMap);  }  private static void getData() {    if (dataList == null) {      refreshData();    }  }  public static List getBAcc() {    getData();    return dataList;  }  public static String getName(String code) {    getData();    BAcc value = (BAcc) dataMap.get(code);    if (value != null) {      if ("1".equals(showType)) {        return "[" + code + "]" + value.getName();      } else if ("2".equals(showType)) {        return value.getName() + "[" + code + "]";      } else {        return value.getName();      }    }    return code;  }  public static String getNameByCode(String code) {    getData();    BAcc value = (BAcc) dataMap.get(code);    if (value != null) {      return value.getName();    }    return code;  }  public static BAcc getBean(String code) {    getData();    BAcc value = (BAcc) dataMap.get(code);    return value;  }}