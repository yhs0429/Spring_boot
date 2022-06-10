package com.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.model.AddrDAO;
import com.study.model.AddrDTO;
import com.study.utility.Utility;

@Controller
public class AddrController {

  @Autowired
  private AddrDAO dao;
  

  @GetMapping("/addr/delete/{addressnum}")
  public String delete(@PathVariable int addressnum) {
    boolean flag = dao.delete(addressnum);
    if(!flag) return "error";
    return "redirect:/addr/list";
  }
  @PostMapping("/addr/update")
  public String update(AddrDTO dto) {
    boolean flag = false;
    flag = dao.update(dto);
      return "redirect:list";
  }
  @GetMapping("addr/update/{addressnum}")
  public String update(@PathVariable int addressnum,Model model) {
    model.addAttribute("dto",dao.read(addressnum));
    return "/update";
  }
  @GetMapping("/addr/read/{addressnum}")
  public String read(@PathVariable int addressnum, Model model) {
    model.addAttribute("dto", dao.read(addressnum));
    return "/read";
  }
  
  @PostMapping("/addr/create")
  public String create(AddrDTO dto) {
    boolean flag = dao.create(dto);
    if(!flag) return "error";
    return "redirect:list";
  }
  @GetMapping("/addr/create")
  public String create() {
    
    return "/create";
  }
  
  @GetMapping("/addr/list")
  public String list(HttpServletRequest request) {
    //검색
    String col = Utility.checkNull(request.getParameter("col"));
    String word = Utility.checkNull(request.getParameter("word"));
    
    if(col.equals("total"))word = "";
    //페이징
    int nowPage = 1;
    if(request.getParameter("nowPage") != null) {
      nowPage = Integer.parseInt(request.getParameter("nowPage"));
    }
    
    int recordPerPage = 5;
    
    int sno = ((nowPage -1) * recordPerPage);
    int eno = recordPerPage;
    
    Map map = new HashMap();
    map.put("sno", sno);
    map.put("eno", eno);
    map.put("col", col);
    map.put("word", word);
    
    List<AddrDTO> list = dao.list(map);
    int total = dao.total(map);
    String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
    
    request.setAttribute("list", list);
    request.setAttribute("paging", paging);
    request.setAttribute("col", col);
    request.setAttribute("word", word);
    request.setAttribute("nowPage", nowPage); 
    
    return "/list";
  }
  @GetMapping("/")
  public String home() {
    
    return "/home";
  }
}
