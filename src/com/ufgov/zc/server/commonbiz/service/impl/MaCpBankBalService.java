package com.ufgov.zc.server.commonbiz.service.impl;import java.util.List;import com.ufgov.zc.server.commonbiz.dao.IMaCpBankBalDao;import com.ufgov.zc.server.commonbiz.service.IMaCpBankBalService;public class MaCpBankBalService implements IMaCpBankBalService {  private IMaCpBankBalDao maCpBankBalDao;  public IMaCpBankBalDao getMaCpBankBalDao() {    return maCpBankBalDao;  }  public void setMaCpBankBalDao(IMaCpBankBalDao maCpBankBalDao) {    this.maCpBankBalDao = maCpBankBalDao;  }  public List getMaCpBankBal(int nd, String bankCode, String fundCode) {    return maCpBankBalDao.getMaCpBankBal(nd, bankCode, fundCode);  }  public List getMaCpBankBalByView(int nd, String bankCode, String fundCode, String maCpBankBalView) {    return maCpBankBalDao.getMaCpBankBalByView(nd, bankCode, fundCode, maCpBankBalView);  }  public List getMaCpBankBalList(int nd) {    return maCpBankBalDao.getMaCpBankBalList(nd);  }}