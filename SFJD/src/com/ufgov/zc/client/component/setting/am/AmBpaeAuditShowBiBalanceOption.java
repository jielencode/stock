package com.ufgov.zc.client.component.setting.am;import com.ufgov.zc.client.component.setting.CheckBoxOption;import com.ufgov.zc.common.system.constants.BusinessOptionConstants;public class AmBpaeAuditShowBiBalanceOption extends CheckBoxOption {  /**   *    */  private static final long serialVersionUID = 1L;  public AmBpaeAuditShowBiBalanceOption() {    this.init(BusinessOptionConstants.OPT_AM_BPAE_AUDIT_SHOW_BIBALANCE, "\"指标控制拨款审核\"是否显示指标余额：", "1", "0");  }}