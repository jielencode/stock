/** * IZcEbOpenBidTeamService.java * com.ufgov.gk.server.zc.service * Administrator * 2010-5-26 */package com.ufgov.zc.server.zc.service;import java.util.List;import com.ufgov.zc.common.system.RequestMeta;import com.ufgov.zc.common.system.dto.ElementConditionDto;import com.ufgov.zc.common.zc.model.ZcEbEvalBidTeam;import com.ufgov.zc.common.zc.model.ZcEbEvalBidTeamMember;/** * @author Administrator * */public interface IZcEbEvalBidTeamService {  List getEvalBidTeam(ElementConditionDto elementConditionDto, RequestMeta requestMeta);  List getEvalBidTeamMembers(ZcEbEvalBidTeam team, RequestMeta requestMeta);  ZcEbEvalBidTeam save(ZcEbEvalBidTeam team, RequestMeta requestMeta);  ZcEbEvalBidTeam saveSt(ZcEbEvalBidTeam team, RequestMeta requestMeta) throws Exception;  int deleteSt(ZcEbEvalBidTeam team, RequestMeta requestMeta);  void updateEvalBidTeamMemberEvalProgress(final ZcEbEvalBidTeamMember record);  public boolean checkExpertExists(ZcEbEvalBidTeamMember member);}