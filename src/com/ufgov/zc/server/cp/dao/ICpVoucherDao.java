package com.ufgov.zc.server.cp.dao;import java.math.BigDecimal;import java.util.Date;import java.util.List;import java.util.Map;import com.ufgov.zc.common.commonbiz.model.BankAccount;import com.ufgov.zc.common.cp.model.CpVoucher;import com.ufgov.zc.common.system.dto.ElementConditionDto;public interface ICpVoucherDao {  List getCpVoucherByIdList(List cpVoucherIdList);  public List getAvCpVoucherByVouNoList(String cpVoucherVouNo);  public List getDvCpVoucherByVouNoList(String cpVoucherVouNo);  void setSumCpVoucherIdNull(List sumCpVoucherIdList);  List getCpVoucherBySumCpVoucherId(String sumCpVoucherId);  public List getCpVoucherBySumCpVoucherIdForPrint(String sumCpVoucherId);  public List getCpVoucherBySumCpVoucherIdListForPrint(List sumCpVoucherIdList);  List getCpVoucherForCpAvSum(ElementConditionDto eleConditionDto);  List getCpVoucherForCpAvNewSum(ElementConditionDto eleConditionDto);  List getCpVoucherForCpDvSum(ElementConditionDto eleConditionDto);  List getCpVoucherForCpDvNewSum(ElementConditionDto eleConditionDto);  List getCpVoucherForCpAv(ElementConditionDto eleConditionDto);  List getCpVoucherForCpAvBiEdit(ElementConditionDto eleConditionDto);  public List getCpVoucherForRefund(ElementConditionDto eleConditionDto);  List getCpVoucherForCpDvEdit(ElementConditionDto eleConditionDto);  List getCpVoucher(ElementConditionDto eleConditionDto);  List getCpVoucherForCpDv(int nd, String a_status_code, String co_code);  List getCpVoucherForCpDv(ElementConditionDto eleConditionDto);  List getCpVoucherForCpDtzd(ElementConditionDto elementDto);  List getCpVoucherForCpDtzdPrint(ElementConditionDto elementDto);  List getCpVoucherForCpDtzdDealStateQuery(ElementConditionDto elementDto);  List getCpVoucherForCpDzCzBank(ElementConditionDto elementDto);  List getCpVoucherForCpDVou(ElementConditionDto eleConditionDto);  List getCpVoucherForCpAVou(ElementConditionDto eleConditionDto);  List getAuditedForCpVoucher(ElementConditionDto elementDto);  List getCpVoucherInfo(String dpBalanceId, String paytypeCode, int nd);  void insertCpVoucher(CpVoucher cpVoucher);  void updateCpApply(CpVoucher cpVoucher, String cpApplyId);  void insertCpVoucher(List cpVoucherList);  void auditForCpDvApplyAudit(CpVoucher cpVoucher);  void auditForCpAvEdit(CpVoucher cpVoucher);  void depassForCpDvApplyAudit(CpVoucher cpVoucher);  int updateCpVoucher(CpVoucher cpVoucher);  void updateSumCpVoucherId(List cpVoucherList);  void updateCpVoucherForCpDzCzBank(final List cpVoucherList);  CpVoucher getCpVoucherById(String cpVoucherId);  int updateDpCdUseMoney(BigDecimal cdmoney, String cpVoucherId, int nd);  int updateCpAdjustCodeForRefund(String cpAdjustCode, String cpVoucherId);  int deleteCpVoucherById(String cpVoucherId);  void deleteCpVoucher(List cpVoucherIdList);  String cpApplyToCpVoucher(String cpApplyIds, String cpVoucherIds, String vouNos, String inputGroupIds,  String userId, String userName, String aStatusCode, String useVouBak, BankAccount payBankAccount,  Date payDate);  String revoCpVoucher(String cpVoucherIds);  void increasePrintTimes(List cpVoucherIdList);  public void updatePrintTimes(List cpVoucherIdList, int printTimes);  List getCpVoucherForBbBalDtzd(ElementConditionDto eleConditionDto);  List getCpVoucherForBbAdrDtzd(ElementConditionDto eleConditionDto);  List getCpVoucherForBbAmveDtzd(ElementConditionDto eleConditionDto);  List getCpVoucherForBbDmveDtzd(ElementConditionDto eleConditionDto);  void unauditForCpVoucherAudit(CpVoucher cpVoucher);  void untreadForCpAvAudit(CpVoucher cpVoucher);  int updateCpVoucherForUndo(String isValid, String cpVoucherId);  void auditForCpVoucherAudit(CpVoucher cpVoucher);  List getCpVoucherForCpAvAudit(ElementConditionDto eleConditionDto);  List getCpVoucherForCpAvBiAudit(ElementConditionDto eleConditionDto);  List getCpVoucherForRefundAudit(ElementConditionDto eleConditionDto);  List getCpVoucherForBbAvc(CpVoucher cpVoucher);  String updateCpVoucherForBbAvc(CpVoucher cpVoucher);  BigDecimal getCurMonthMoney(CpVoucher cpVoucher);  BigDecimal getCurDayMoney(CpVoucher cpVoucher);  public BigDecimal getCurMoneyAvailableForRefund(String cpVoucherId);  String sendBankForBb(List cpVoucherList, String transType);  String sendBankForBa(List cpVoucherList, String transType);  List getCpVoucherSplitByCpVoucherId(String id);  void updateCpVoucherSplit(List updatList);  void insertCpVoucherSplit(List iList);  void deleteCpVoucherSplit(String id);  void updateCpVoucherForIsSplit(String id);  void cancelSplit(List idList);  void deleteCpVoucherSplitForCancel(List idList);  List getCpVoucherForBbReturn(CpVoucher cpVoucher);  BigDecimal getRequestSeri();  void updateVoucherGroupDealState(Map params);  List getCpVoucherForBbReturn(ElementConditionDto eleConditionDto);  String updateCpVoucherForBbReturn(CpVoucher cpVoucher);  void updateCpVoucherByPayClearBillId(String payClearBillId, String billNo, List idList);  void updateCpVoucherPayInfo(List cpVoucherList);  int getUnHXCpVoucher(String coCode);  int getVoucherIsSum(List cpVoucherIdList);  void editRemarkForCpVoucher(List idList, String remark);  List getCpVoucherByIdListForSumDetail(List idList);  List getCpVoucherForCpAvtList(ElementConditionDto eleConditionDto);  List getCpVoucherForCpDvtList(ElementConditionDto eleConditionDto);  void cpAvtSend(List cpVoucherList);  void cpAvtCancelSend(List cpVoucherList);  void cpDvtCheckIn(List cpVoucherList);  void cpDvtCancelCheckIn(List cpVoucherList);  List getSubCpVoucherForSumVouNo(List vouList);  void saveCpImpRecord(List list);  List getCpImpRecordList(ElementConditionDto eleConditionDto);}