<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import = "com.study.model.*" %> 
<%  
	AddrDTO dto = (AddrDTO)request.getAttribute("dto");
%>
<!DOCTYPE html> 
<html> 
<head>
  <title>homepage</title>
  <meta charset="utf-8">
</head>
<body> 
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">주소록 수정</h1>
<form class="form-horizontal" 
      action="/addr/update"
      method="post"
      >
 <!-- bbsno를 사용자에게 보여주지 않은채(hidden)값만 전달 -->
 <input type="hidden" name="addressnum" value="<%=dto.getAddressnum()%>">
   <div class="form-group">
    <label class="control-label col-sm-2" for="name">이름</label>
    <div class="col-sm-6">
      <input type="text" name="name" id="name" class="form-control" value="<%=dto.getName()%>">
    </div>
  </div>
  
   <div class="form-group">
    <label class="control-label col-sm-2" for="handphone">전화번호</label>
    <div class="col-sm-6">
      <input type="text" name="handphone" id="handphone" class="form-control" value="<%=dto.getHandphone()%>">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="zipcode">우편번호</label>
    <div class="col-sm-6">
    <input type="text" id="zipcode" name="zipcode" class="form-control" value=<%= dto.getZipcode()%>>
    </div>
  </div>

   <div class="form-group">
    <label class="control-label col-sm-2" for="address">주소</label>
    <div class="col-sm-6">
      <input type="text" name="address" id="address" class="form-control" value=<%=dto.getAddress() %>>
    </div>
  </div>
  
  <div class="from-group">
   <label class="control-label col-sm-2" for="address2">상세주소</label>
   <div class="col-sm-6">
	<input type="text" id="address2" name="address2" class="form-control" value=<%=dto.getAddress2() %>>
   </div>
  </div>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">수정</button>
    <button type="reset" class="btn" onclick="location.href='list'">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 