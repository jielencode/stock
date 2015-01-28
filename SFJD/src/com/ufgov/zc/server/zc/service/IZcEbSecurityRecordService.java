package com.ufgov.zc.server.zc.service;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbSecurityRecord;import com.ufgov.zc.common.zc.model.ZcEbWaitingDecodeItem;import java.util.List;public interface IZcEbSecurityRecordService {  public List getZcEbSecurityRecords(ZcEbSecurityRecord sec);  public ZcEbSecurityRecord save(ZcEbSecurityRecord sec);  public List getZcEbSecurityRecordByBusinessIndex(ElementConditionDto dto);  public ZcEbSecurityRecord update(ZcEbSecurityRecord sec);  public void delete(ZcEbSecurityRecord sec);  public List getWaitingDecodingItems(ZcEbWaitingDecodeItem item);}