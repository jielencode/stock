package com.ufgov.zc.server.cp.service;import java.util.List;public interface ICpPlanAgentRelationService {  public List getCpPlanAgentRelation(String planAgentBillId);  public List getCpPlanAgentRelationForVouNo(String vouNo);}