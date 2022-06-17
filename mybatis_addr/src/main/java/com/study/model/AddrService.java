package com.study.model;

import java.util.List;
import java.util.Map;

public interface AddrService {

  List<AddrDTO> list(Map map);
  int total(Map map);
  int create(AddrDTO dto);
  AddrDTO read(int addressnum);
  int update(AddrDTO dto);
  int delete(int addressnum);



}
