package com.ufgov.zc.server.system.dao;import java.util.List;import com.ufgov.zc.common.system.dto.UserFuncDto;public interface IUserFuncDao {  List getUserGrantFunc(UserFuncDto userFuncDto);  List getUsedCompoFunc(String compoId);}