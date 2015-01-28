package com.ufgov.zc.server.system.dao;import java.util.List;import com.ufgov.zc.common.system.model.AsFile;public interface IAsFileDao {  void insertAsFile(AsFile asFile);  void insertLargeAsFile(AsFile asFile);  void insertAsFileDirectory(AsFile asFile);  AsFile getAsFileById(String fileId);  AsFile getLargeAsFileById(String fileId);  List getLargeAsFile(List fileIdList);  void deleteAsFileById(String fileId);  void updateAsFileById(AsFile asFile);  AsFile getAsFileNoContentById(String fileId);}