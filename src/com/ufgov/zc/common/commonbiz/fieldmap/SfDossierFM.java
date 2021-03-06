package com.ufgov.zc.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

public class SfDossierFM {

  public static Map fieldMap = new HashMap();

  static {

    fieldMap.putAll(ZcBaseBillFM.fieldMap);
    
    fieldMap.put("DOSSIER_ID","dossierId");
    fieldMap.put("DOSSIER_TYPE","dossierType");
    fieldMap.put("ENTRUST_CODE","entrustCode");
    fieldMap.put("ENTRUST_ID","entrustId");
    fieldMap.put("INPUTOR","inputor");
    fieldMap.put("INPUT_DATE","inputDate");
    fieldMap.put("NAME","name");
    fieldMap.put("ND","nd");
    fieldMap.put("PROCESS_INST_ID","processInstId");
    fieldMap.put("REMARK","remark");
    fieldMap.put("STATUS","status");
    fieldMap.put("FILE_ID","fileId");

  }
}
