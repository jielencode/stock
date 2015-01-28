package com.ufgov.zc.common.commonbiz.util;public class DpBalanceViewGetter {  public static String getRightQueryView(int month) {    String result = null;    result = "V_QUERY_DP_BALANCE" + month;    return result;  }  /**   * 返回拨款月份累加字符串   * @param monthId   * @return   */  public static String getBalanceMonth(int monthId) {    final StringBuffer result = new StringBuffer("dp_cd_money");    for (int i = 1; i <= monthId; i++) {      result.append("+DP_MONEY");      result.append(i);    }    return result.toString();  }  /**   * 返回拨款月份累加字符串,不带"dp_cd_money"   * @param monthId   * @return   */  public static String getStrByMonth(int monthId) {    StringBuffer result = new StringBuffer();    for (int i = 1; i <= monthId; i++) {      result.append("+DP_MONEY");      result.append(i);    }    return result.deleteCharAt(0).toString();  }  /**   * 返回月份累加字符串   * @param tableName 表别名   * @param monthId 月份(1...12)   * @return   */  public static String getBalanceString(String tableName, int monthId) {    tableName = (tableName == null ? "" : (tableName + "."));    final StringBuffer result = new StringBuffer();    result.append(tableName);    result.append("dp_cd_money");    for (int i = 1; i <= monthId; i++) {      result.append("+");      result.append(tableName);      result.append("DP_MONEY");      result.append(i);    }    return result.toString();  }  /**   * 根据月份参数返回DpBalanceMonthView视图   * @param monthId   * @return   格式：(SELECT A.DP_BALANCE_ID,   A.ND,   A.DP_CD_MONEY +A.DP_MONEY1 + A.DP_MONEY2 + A.DP_MONEY3 + A.DP_MONEY4 + A.DP_MONEY5 +   A.DP_MONEY6 + A.DP_MONEY7 + A.DP_MONEY8 + A.DP_MONEY9 + A.DP_MONEY10 +   A.DP_MONEY11 + A.DP_MONEY12 AS DP_MONEY,   A.AM_MONEY + A.CP_MONEY AS DP_PAYSUM,   A.DP_CD_MONEY + A.DP_MONEY1 + A.DP_MONEY2 + A.DP_MONEY3 +   A.DP_MONEY4 + A.DP_MONEY5 + A.DP_MONEY6 + A.DP_MONEY7 + A.DP_MONEY8 +   A.DP_MONEY9 + A.DP_MONEY10 + A.DP_MONEY11 + A.DP_MONEY12 -   A.AM_MONEY - A.CP_MONEY - A.FREEZE_MONEY - A.CD_MONEY AS DP_BALANCE   FROM DP_BALANCE A)   */  public static String getMonthView(int monthId) {    final StringBuffer result = new StringBuffer("(SELECT A.DP_BALANCE_ID,A.ND,");    result.append(getBalanceString("A", monthId));    result.append(" AS dp_money, A.AM_MONEY + A.CP_MONEY AS dp_paysum,");    result.append(getBalanceString("A", monthId));    result.append(" -A.AM_MONEY-A.CP_MONEY-A.FREEZE_MONEY-A.CD_MONEY");    result.append(" AS dp_balance FROM DP_BALANCE A )");    return result.toString();  }  /*   * 不考虑系统选项的情况，直接返回视图的名称；   */  public static String getNoAsOptionRightQueryView(String sysDate) {    String result = null;    int month = Integer.parseInt(sysDate.substring(5, 7));    String curDay = sysDate.substring(8, 10);    result = "V_QUERY_DP_BALANCE" + month;    return result;  }  public static void main(String[] args) {    System.out.println(getStrByMonth(6));  }}