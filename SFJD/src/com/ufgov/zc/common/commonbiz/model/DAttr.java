package com.ufgov.zc.common.commonbiz.model;import java.io.Serializable;import java.util.HashMap;import java.util.Map;public class DAttr extends BaseElement implements Serializable {  /**   *    */  private static final long serialVersionUID = -1580828026129488070L;  public static String D_ATTR1_TYPE = "01";  public static String D_ATTR2_TYPE = "02";  public static String D_ATTR3_TYPE = "03";  public static String D_ATTR4_TYPE = "04";  public static String D_ATTR5_TYPE = "05";  public static Map dAttrMap = new HashMap();  static {    dAttrMap.put(D_ATTR1_TYPE, "D_ATTR1");    dAttrMap.put(D_ATTR2_TYPE, "D_ATTR2");    dAttrMap.put(D_ATTR3_TYPE, "D_ATTR3");    dAttrMap.put(D_ATTR4_TYPE, "D_ATTR4");    dAttrMap.put(D_ATTR5_TYPE, "D_ATTR5");  }  private static Map dAttrTypeMap = new HashMap();  static {    dAttrTypeMap.put("D_ATTR1", D_ATTR1_TYPE);    dAttrTypeMap.put("D_ATTR2", D_ATTR2_TYPE);    dAttrTypeMap.put("D_ATTR3", D_ATTR3_TYPE);    dAttrTypeMap.put("D_ATTR4", D_ATTR4_TYPE);    dAttrTypeMap.put("D_ATTR5", D_ATTR5_TYPE);  }  /**   * type 01: d_attr1 ,02:d_attr2,03:d_attr3,04:d_attr4,05:d_attr5   */  private String type;  public String getType() {    return type;  }  public void setType(String type) {    this.type = type;  }  public static String getType(String dattrId) {    return (String) dAttrTypeMap.get(dattrId);  }}