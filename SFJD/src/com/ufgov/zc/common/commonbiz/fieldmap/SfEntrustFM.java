package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class SfEntrustFM {

  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);

    fieldMap.put("ACCEPTOR","acceptor");
    fieldMap.put("ACCEPT_DATE","acceptDate");
    fieldMap.put("BRIEF","brief");
    fieldMap.put("CODE","code");
    fieldMap.put("ENTRUSTOR_ID","entrustorId");
    fieldMap.put("ENTRUST_ID","entrustId");
    fieldMap.put("INPUTOR","inputor");
    fieldMap.put("INPUT_DATE","inputDate");
    fieldMap.put("IS_ACCEPT","isAccept");
    fieldMap.put("IS_CXJD","isCxjd");
    fieldMap.put("JD_COMPANY","jdCompany");
    fieldMap.put("JD_FZR","jdFzr");
    fieldMap.put("JD_HISTORY","jdHistory");
    fieldMap.put("JD_ORG","jdOrg");
    fieldMap.put("JD_REQUIRE","jdRequire");
    fieldMap.put("JD_TARGET_ID","jdTargetId");
    fieldMap.put("MAJOR_CODE","majorCode");
    fieldMap.put("NAME","name");
    fieldMap.put("ND","nd");
    fieldMap.put("NOT_ACCEPT_REASON","notAcceptReason");
    fieldMap.put("PROCESS_INST_ID","processInstId");
    fieldMap.put("REMARK","remark");
    fieldMap.put("SJR","sjr");
    fieldMap.put("SJR_TEL","sjrTel");
    fieldMap.put("SJR_ZJ_CODE","sjrZjCode");
    fieldMap.put("SJR_ZJ_TYPE","sjrZjType");
    fieldMap.put("STATUS","status");
    fieldMap.put("WT_DATE","wtDate");
    fieldMap.put("WT_ID_PARENT","wtIdParent");


  }
}
