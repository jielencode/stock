/**   * @(#) project: GK* @(#) file: IZcEbEvalService.java* * Copyright 2010 UFGOV, Inc. All rights reserved.* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.* */package com.ufgov.zc.server.zc.service;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.dto.PrintObject;import com.ufgov.zc.common.zc.model.ZcEbEvalBidTeamMember;import com.ufgov.zc.common.zc.model.ZcEbEvalPack;import com.ufgov.zc.common.zc.model.ZcEbEvalReport;import com.ufgov.zc.common.zc.model.ZcEbExpertChengNuo;import com.ufgov.zc.common.zc.model.ZcEbExpertOpinion;import com.ufgov.zc.common.zc.model.ZcEbPack;import java.util.List;import java.util.Map;/*** @ClassName: IZcEbEvalService* @Description: 评标模块业务处理接口类。* @date: 2010-4-21 下午03:48:04* @version: V1.0 * @since: 1.0* @author: fanpl* @modify: */public interface IZcEbEvalService {  List getZcEbEvalExpertList(ElementConditionDto dto);  List getZcEbEvalReportList(ElementConditionDto dto, RequestMeta meta);  public List getZcEbEvalPackList(ElementConditionDto dto, RequestMeta meta);  /**   *   * @Description: 取评标指标项结果对象列表。  * @return List 评标指标项结果对象列表，如果存在符合条件的对象；否则返回空。  * @since 1.0   */  public List getZcEbEvalItemResultList(Map map);  /**   *   * @Description: 取评标指标项对象列表。  * @return List 评标指标项对象列表，如果存在符合条件的对象；否则返回空。  * @since 1.0   */  public List getZcEbEvalFormulaItemList(Map map);  public void saveEvalitemResultList(List list);  List getListEvalPackProvider(Map map);  List getProviderList(Map map);  /**   *   * @Description:取评标参数结果列表。  * @return List ZcEbEvalParam对象列表。  * @since 1.0   */  List getEvalParamResultList(Map map);  /**   *   * @Description:取评标参数列表。  * @return List ZcEbEvalParam对象列表。  * @since 1.0   */  List getEvalParamList(Map map);  /**   *   * @Description: 插入评标参数对象列表。  * @return void   * @since 1.0   */  void insertEvalParamResultList(List list);  /**   *   * @Description: 更新评标参数对象列表。  * @return void   * @since 1.0   */  void updateEvalParamResultList(List list);  /**   *   * @Description: 读取专家评审结果明细。  * @return List 专家评审得出的指标明细项结果列表。  * @since 1.0   */  List getZcEbExpertEvalResultList(ElementConditionDto dto, RequestMeta meta);  public List getZcEbPackEvalList(ElementConditionDto dto);  public ZcEbEvalReport saveZcEbEvalReport(ZcEbEvalReport zcEbEvalReport);  public ZcEbEvalReport insertZcEbEvalReport(ZcEbEvalReport zcEbEvalReport);  public ZcEbEvalReport getZcEbEvalReport(String reportCode);  public void createWfDraft(ZcEbEvalReport zcEbEvalReport, RequestMeta meta);  public ZcEbEvalReport updateZcEbEvalReport(ZcEbEvalReport zcEbEvalReport);  int deleteZcEbEvalReport(ZcEbEvalReport zcEbEvalReport);  ZcEbEvalReport newCommit(ZcEbEvalReport zcEbEvalReport, RequestMeta meta);//送审  ZcEbEvalReport audit(ZcEbEvalReport zcEbEvalReport, RequestMeta meta);//审核  ZcEbEvalReport unaudit(ZcEbEvalReport zcEbEvalReport, RequestMeta meta);//销审  ZcEbEvalReport untread(ZcEbEvalReport zcEbEvalReport, RequestMeta meta);//退回  ZcEbEvalReport callbackZcEbEvalReport(ZcEbEvalReport zcEbEvalReport, RequestMeta meta);//收回  ZcEbEvalReport updateZcEbEvalStatus(ZcEbEvalReport zcEbEvalReport);  void updateZcEbEvalStatus(List zcEbEvalReportList);  public List getZcEbPackEvalResult(Map map);  /**   *    * @Description: 根据专家评审的分包明细结果生成专家评审分包汇总结果。  * @return String 空則表示成功，否則返回错误信息。  * @since 1.0   */  String genExpertSumResult(Map map);  /**   *   * @Description:取专家评审分包汇总结果列表。  * @return List 专家评审的分包汇总结果对象列表。  * @since 1.0   */  List getExpertEvalPackResList(Map map);  /**   *   * @Description: 汇总专家评审结果为最终结果。  * @return String 汇总操作成功则空，否则返回相关提示信息。  * @since 1.0   */  List genPackFinalSumResult(Map map, List list);  /**   *   * @Description: 更新供应商分包评审汇总结果。  * @return void 返回类型  * @since 1.0   */  void updateZcEbPackEvalFinalSumResultFN(List list);  void deleteZcEbPackEvalFinalSumResult(Map map);  List getZcEbEvalPackSumResult(Map map, RequestMeta meta);  void deleteEvalitemResultList(Map map);  void insertEvalItemResultList(List list);  public String getProviderEvalResult(Map map);  List getZcEbEvalResult(Map map);  List getZcEbEvalFormulaItemReportList(Map map);  PrintObject genZcEbEvalReportPrintObject(ZcEbEvalReport zcEbEvalReport);  List getEbExpertOpinionList(Map map);  ZcEbExpertOpinion getZcEbExpertOpinion(Map map);  void SaveZcEbExpertOpinion(ZcEbExpertOpinion zcEbExpertOpinion);  ZcEbEvalBidTeamMember getZcEbEvalMember(ZcEbEvalPack evalPack);  ZcEbEvalReport sendToProcurementUnit(ZcEbEvalReport bill, RequestMeta requestMeta);  void insertProEvalItemResultList(Map map, List providerList, RequestMeta meta);  void saveZcExpertChengNuo(ZcEbExpertChengNuo bill, RequestMeta meta);  void deleteZcExpertChengNuo(ZcEbExpertChengNuo bill, RequestMeta meta);  ZcEbExpertChengNuo getZcExpertChengNuo(Map map, RequestMeta meta);  List queryExportsDatas(ElementConditionDto dto, RequestMeta meta);  String importTransDatasFN(ZcEbEvalReport bill, RequestMeta meta);  String saveOffLineEvalBidFN(List packLst, RequestMeta requestMeta);}