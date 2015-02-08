/**
 * 
 */
package com.ufgov.zc.client.sf.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ufgov.zc.client.common.ServiceFactory;
import com.ufgov.zc.client.common.WorkEnv;
import com.ufgov.zc.common.sf.model.SfEntrust;
import com.ufgov.zc.common.system.RequestMeta;
import com.ufgov.zc.common.system.constants.SfElementConstants;
import com.ufgov.zc.common.system.dto.ElementConditionDto;
import com.ufgov.zc.common.zc.publish.IZcEbBaseServiceDelegate;

/**
 * @author Administrator
 *
 */
public class SfUtil {

  static IZcEbBaseServiceDelegate baseDataServiceDelegate = (IZcEbBaseServiceDelegate) ServiceFactory.create(IZcEbBaseServiceDelegate.class,
    "zcEbBaseServiceDelegate");

  static RequestMeta meta = WorkEnv.getInstance().getRequestMeta();

  static List<HashMap<String, String>> userFuncs = new ArrayList<HashMap<String, String>>();

  /**
   * 判断当前用户对当前部件是否有新增权限
   * @param compoId
   * @param entrust
   * @return
   */
  public static boolean canNew(String compoId, SfEntrust entrust) {
    // TODO Auto-generated method stub
    boolean rtn = haveFunc(compoId, entrust, SfElementConstants.FUNC_NEW);
    if (rtn)
      return rtn;
    return haveFunc(compoId, entrust, SfElementConstants.FUNC_ADD);
  }

  /**
   * 判断当前用户对当前部件是否有对应权限
   * @param compoId
   * @param entrust
   * @param func
   * @return
   */
  public static boolean haveFunc(String compoId, SfEntrust entrust, String func) {
    if (compoId == null || compoId.trim().length() == 0 || func == null || func.trim().length() == 0) {
      return false;
    }
    // TODO Auto-generated method stub
    if (!haveInitCompoFunc(compoId)) {
      ElementConditionDto dto = new ElementConditionDto();
      dto.setUserId(meta.getSvUserID());
      dto.setCompoId(compoId);
      List rtn = baseDataServiceDelegate.queryDataForList("com.ufgov.zc.server.sf.dao.SfEntrustMapper.selectUserFunc", dto, meta);
      if (rtn != null) {
        userFuncs.addAll(rtn);
      }
    }
    if (userFuncs == null)
      return false;
    for (HashMap<String, String> funcMap : userFuncs) {
      if (funcMap.containsValue(func)) {
        return true;
      }
    }
    return false;
  }

  private static boolean haveInitCompoFunc(String compoId) {
    if (compoId == null || compoId.trim().length() == 0 || userFuncs == null || userFuncs.size() == 0)
      return false;

    for (HashMap<String, String> funcMap : userFuncs) {
      if (funcMap.containsValue(compoId)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 将数据转换为字符，有小数时，转换时带有小数，没有小数时，转换为整数字符串
   * @param d
   * @return
   */
  public static String getDecimalStr(BigDecimal d) {
    String rtn = "";
    if (d == null)
      return null;
    int intVal = d.intValue();
    double douVal = d.doubleValue();
    double nd = Double.parseDouble("" + intVal);
    if (douVal > nd) {
      rtn = "" + douVal;
    } else {
      rtn = "" + intVal;
    }
    return rtn;
  }
}
