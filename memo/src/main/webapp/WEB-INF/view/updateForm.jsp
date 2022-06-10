<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "model.*" %> 
<%  
	MemoDTO dto = (MemoDTO)request.getAttribute("dto");
%>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">메모 수정</h1>
<form class="form-horizontal" 
      action="updateProc.do"
      method="post"
      >
 <!-- bbsno를 사용자에게 보여주지 않은채(hidden)값만 전달 -->
 <input type="hidden" name="memono" value="<%=dto.getMemono()%>">
   <div class="form-group">
    <label class="control-label col-sm-2" for="wname">작성자</label>
    <div class="col-sm-6">
      <input type="text" name="wname" id="wname" class="form-control" value="<%=dto.getWname()%>">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="title">제목</label>
    <div class="col-sm-6">
      <input type="text" name="title" id="title" class="form-control" value="<%=dto.getTitle()%>">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="content">내용</label>
    <div class="col-sm-6">
    <textarea rows="5" cols="5" id="content" name="content" class="form-control"><%= dto.getContent()%></textarea>
    </div>
  </div>

   <div class="form-group">
    <label class="control-label col-sm-2" for="passwd">비밀번호</label>
    <div class="col-sm-6">
      <input type="password" name="passwd" id="passwd" class="form-control">
    </div>
  </div>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">수정</button>
    <button type="reset" class="btn" onclick="location.href='list.do'">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 