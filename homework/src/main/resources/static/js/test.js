$(function(){
   $("#login_btn").click(function(){
      let id = document.getElementById('id').value;
      let pw = document.getElementById('pw').value;
		alert(id + pw)

	let url = "http://localhost:8000/login?id=" + id + "&passwd=" + pw;

	fetch(url)
		.then((response) => response.json())
		.then((data) => alert(data.name + " login ok Status Success"))	


   })
   
});
