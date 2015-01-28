package com.ufgov.zc.server.zc.service;import java.util.List;import java.util.Map;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.system.model.AsFile;import com.ufgov.zc.common.system.model.User;import com.ufgov.zc.common.zc.model.ZcEbEcbjItem;import com.ufgov.zc.common.zc.model.ZcEbSupplier;public interface IZcEbSupplierService {  List getZcEbSupplier(ElementConditionDto dto, RequestMeta meta);  public List getZcEbSupplierBySupplierID(ElementConditionDto dto);  List getZcEbSupplierStatus(ElementConditionDto dto);  List getZcEbSupplierBd(ElementConditionDto dto);  List getZcEbSupplierFile(ElementConditionDto dto);  List getZcEbSecSupplierFile(ElementConditionDto dto);  List getZcEbScrollStatus(String providerCode);  List getZcEbSecSupplierAllFile(ElementConditionDto dto);  List getZcEbSupplierDetail(ElementConditionDto dto);  List getZcEbSupplierResult(ElementConditionDto dto);  List getZcEbSupplierForm(ElementConditionDto dto);  List getZcEbSup(ElementConditionDto dto);  boolean deleteSupplier(ZcEbSupplier supplier, RequestMeta requestMeta);  ZcEbSupplier getSupplierById(String code, RequestMeta requestMeta);  ZcEbSupplier save(ZcEbSupplier supplier, RequestMeta requestMeta);  ZcEbSupplier addSupplier(ZcEbSupplier supplier);    ZcEbSupplier addSupplier(ZcEbSupplier supplier,RequestMeta requestMeta);  void updateZcEbSupplier(ZcEbSupplier supplier, RequestMeta requestMeta);  ZcEbSupplier getZcEbSupplierDetailList(String code, RequestMeta requestMeta);  List getSimpleZcEbSupplier(ElementConditionDto dto);  List getSupplierPackList(ElementConditionDto dto, RequestMeta requestMeta);  List getZcEbSupplierDetailListByZcMerCode(String merCode);  String importSupplier(ZcEbSupplier supplier, RequestMeta requestMeta);  List getZcEbSupplierListByIDs(ElementConditionDto dto, RequestMeta meta);  public AsFile getLargeAsFileById(String fileId, RequestMeta meta);  public AsFile getPictureAsFileById(String fileId);  boolean checkAsUser(User user);  boolean checkDupleteSupplier(ZcEbSupplier supplier);  void insertAsFileDirectory(AsFile asFile, RequestMeta meta);  void insertZcEbEcbjItem(ZcEbEcbjItem ecbjItem, RequestMeta meta);  void updateAsFileDirectory(AsFile asFile, RequestMeta meta);  ZcEbEcbjItem getZcEbEcbjItem(ElementConditionDto dto, RequestMeta meta);  void createExchangeData(ZcEbSupplier supplier, RequestMeta requestMeta);  Integer getSupplierCount(Map parameterObject);  List getSupplier(Map parameterObject);  List getZcEbSupplierList();}