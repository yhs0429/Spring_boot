package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.model.AddrDTO;
import com.study.model.AddrService;
import com.study.utility.Utility;

@Controller
public class AddrController {

  @Autowired
  @Qualifier("com.study.model.AddrServiceImpl")
  private AddrService dao;
  


  @GetMapping("addr/delete/{addressnum}")
  public String delete(@PathVariable int addressnum) {
    int flag = dao.delete(addressnum);
    if(flag != 1) return "error";
    else {
      return "redirect:/addr/list";
    }
  }
  @PostMapping("/addr/update")
  public String update(AddrDTO dto ) {
    int flag = dao.update(dto);
    if(flag==1) {
      return "redirect:list";
    }else {
      return "error";
    }
  }
  @GetMapping("/addr/update/{addressnum}")
  public String update(@PathVariable int addressnum,Model model) {
    model.addAttribute("dto",dao.read(addressnum));
    return "/update";
  }
  @GetMapping("/addr/read/{addressnum}")
  public String read(@PathVariable int addressnum, Model model) {
    model.addAttribute("dto", dao.read(addressnum));
    return "/read";
  }
  @PostMapping("addr/create")
  public String create(AddrDTO dto) {
    int flag = dao.create(dto);
    if(flag != 1) return "error";
    return "redirect:list";
  }
  @GetMapping("/addr/create")
  public String create() {
    return "/create";
  }
  @GetMapping("/addr/list")
  public String list(HttpServletRequest request) {
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));

    if(col.equals("total")){//전체출력 선택 후 검색누르면
      word = "";//검색어 없애기->그럼 dao에서 검색 if/else 통과해서 그냥 order by실행
    }

    //페이징 관련----------
    int nowPage = 1;//현재 보고 있는 페이지
    if(request.getParameter("nowPage") != null){
      nowPage = Integer.parseInt(request.getParameter("nowPage"));//현재 페이지 정보
    }

    int recordPerPage = 5;//한 페이지당 보여줄 레코드갯수

    int sno = ((nowPage-1)*recordPerPage);//디비에서 가져올 시작위치, 1을 빼는 이유: 첫번째 레코드부터 가져올수있도록(1페이지일경우 sno가 0이될수있게)
    int eno = recordPerPage;//가져올 갯수
    
    //1.model사용 - 객체를 생성해서 사용한다.
    Map map = new HashMap();
    map.put("col",col);
    map.put("word",word);
    map.put("sno",sno);
    map.put("eno",eno);

    List<AddrDTO> list = dao.list(map); 
    int total = dao.total(map);//전체페이지를 알기위해 전체레코드 필요
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
    
    //2.request결과저장(view페이지에서 사용할 내용을 저장)
    request.setAttribute("list", list);
    request.setAttribute("paging", paging);
    request.setAttribute("col", col);
    request.setAttribute("word", word);//col과 word는 list페이지에서 사용중이라
    request.setAttribute("nowPage", nowPage);//페이지유지위해
    
    return "/list";
  }
  @GetMapping("/")
  public String home() {
    
    return "/home";
  }
}
