package com.ufgov.zc.common.commonbiz.publish;import java.math.BigDecimal;import java.util.List;import com.ufgov.zc.common.commonbiz.model.DpBalance;import com.ufgov.zc.common.system.Publishable;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;/** * dpbalance service; * @author ufwangfei * */public interface IDpBalanceServiceDelegate extends Publishable {  List getDpBalance(RequestMeta requestMeta);  List getDpBalanceForDpAdjust(ElementConditionDto balanceelementConditionDto, RequestMeta requestMeta);  DpBalance getDpBalanceById(String id, String dpBalanceView, RequestMeta requestMeta);  List getDpBalanceForCpAv(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  List getDpBalanceForCpDa(ElementConditionDto dto, RequestMeta requestMeta);  List getDpBalanceForCpDv(ElementConditionDto dto, RequestMeta requestMeta);  List getDpBalanceForAm(ElementConditionDto dto, RequestMeta requestMeta);  int updateDpBalance(String instanceId, String montyField, String dpBalanceId, String businessTableName,  String policy, RequestMeta requestMeta);  int updateDpBalanceForDpAdjustDecreaseSave(String balmoneyField, BigDecimal adjustMoney, String moneyField,  String dpBalanceId, RequestMeta requestMeta);  int updateDpBalanceForDpAdjustFreezeSave(BigDecimal adjustMoney, String moneyField, String dpBalanceId,  RequestMeta requestMeta);  int updateDpBalanceForDpAdjustFreezeAudit(BigDecimal adjustMoney, String moneyField, String dpBalanceId,  RequestMeta requestMeta);  int updateDpBalanceForDpAdjustunFreezeAudit(BigDecimal adjustMoney, String moneyField, String dpBalanceId,  RequestMeta requestMeta);  void insertDpBalance(DpBalance dpBalance);  List getDpBalanceForDpCarry(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  String handleDpBalanceForCarry(String dpBalanceIds, int nd, String inputor, String procDate,  RequestMeta requestMeta);  String handleDpBalanceForUpdate(List dpDetailList, RequestMeta requestMeta);  void handleDpBalanceForUnUpdate(List dpDetailList, RequestMeta requestMeta);  String handleDpBalanceForCarryCancel(String dpBalanceIds, RequestMeta requestMeta);  DpBalance getDpBalanceForJjPlan(String dpBalanceId, RequestMeta requestMeta);}