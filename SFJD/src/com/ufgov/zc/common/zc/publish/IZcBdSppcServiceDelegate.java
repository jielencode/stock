/**   * @(#) project: zc_xa* @(#) file: IZcBdZbpcServiceDelegate.java* Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.common.zc.publish;import java.sql.SQLException;import java.util.List;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcBdSppc;public interface IZcBdSppcServiceDelegate extends Publishable {  public List getZcBdSppcList(ElementConditionDto dto, RequestMeta meta) throws SQLException;  public ZcBdSppc selectByPrimaryKey(String zcPrimKey, RequestMeta requestMeta) throws SQLException;  public void deleteByPrimaryKey(String zcPrimKey, RequestMeta requestMeta) throws SQLException;  public ZcBdSppc updateZcBdSppcByPrimaryKey(ZcBdSppc zcBdSppc, RequestMeta meta) throws SQLException;}