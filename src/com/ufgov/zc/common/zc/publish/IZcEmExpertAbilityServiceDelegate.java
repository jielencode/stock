/**   
* @(#) project: zc_xa
* @(#) file: IZcBdZbpcServiceDelegate.java
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.zc.common.zc.publish;
import java.sql.SQLException;
public interface IZcEmExpertAbilityServiceDelegate extends Publishable {
  public EmExpertAbility updateByPrimaryKey(EmExpertAbility bean, RequestMeta meta) throws SQLException;

}