<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.* , model.MemoDTO, utility.*" %>
<%
	//Action에서 저장한 model 결과 및 jsp에서 사용할 내용을 꺼내옴.
	String col = (String)request.getAttribute("col");
	String word = (String)request.getAttribute("word");
	int nowPage = (int)request.getAttribute("nowPage");
	List<MemoDTO> list = (List<MemoDTO>)request.getAttribute("list");
	String paging = (String)request.getAttribute("paging");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script>

  	function read(memono){
  		let url = "read.do?memono="+memono;
  		location.href = url;
  	}
  	
  </script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">메모</h1>
<form action="list.do" class="form-inline">
<div class="form-group">
	<select class='form-control' name='col'>
	<option value="wname" <%if(col.equals("wname")) out.print("selected");%>>작성자</option>
 	<option value="title" <%if(col.equals("title")) out.print("selected");%>>제목</option>
 	<option value="content" <%if(col.equals("content")) out.print("selected");%> >내용</option>
 	<option value="title_content" <%if(col.equals("title_content")) out.print("selected");%>>제목+내용</option>
 	<option value="total" <%if(col.equals("total")) out.print("selected");%>>전체출력</option>
	</select>
</div>
<div class="form-group">
	<input type='text' class='form-control' placeholder='검색어' name='word' value="<%=word %>">
</div>
<button class='btn btn-default'>검색</button>
<button class='btn btn-default' type='button' onclick="location.href='create.do'">등록</button>
</form>
<table class="table table-striped"> 
	<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록날짜</th>
					<th>grpno</th>
					<th>indent</th>
					<th>ansnum</th>
				</tr>
	</thead>
	<tbody>
	
<% 	if(list.size()==0){%>
		<tr>
			<td colspan='7'>등록된 메모가 없습니다.</td>
		</tr>
<% }else{
		for(int i=0; i<list.size(); i++){
			MemoDTO dto = list.get(i);
%>


<tr>
		<td><%=dto.getMemono()%></td>
			<td><%
					for(int j=0; j<dto.getIndent(); j++){
						out.print("&nbsp;&nbsp;");
					}//들여쓰기
					if(dto.getIndent() > 0) out.print("<img src='../images/re.jpg'>");//re이미지
				%>
			<a href="javascript:read('<%=dto.getMemono() %>')"><%=dto.getTitle() %></a>
			<% if(Utility.compareDay(dto.getWdate())){%>
				<img src="../images/new.gif">
			<% } %>
			</td>
			<td><%=dto.getWname() %></td>
			<td><%=dto.getWdate() %></td>
			<td><%=dto.getGrpno() %></td>
			<td><%=dto.getIndent() %></td>
			<td><%=dto.getAnsnum() %></td>	
</tr>
<%
		}
	}
%>


					

	</tbody>
</table>
</div>
<div>
	<%=paging %>
</div>
</body> 
</html> 