<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	
	.container {
		position: relative;
    min-width: 1100px;
	}
	
	.header {
	
	}
	
	.logo {
	    float: left;
	}
	
	.advertisement {
    height: 240px;
    margin: 20px 20px 40px 20px;
    border-bottom: 1px solid;
	}
	
	.promotion{
		width:65%;
		margin:auto;
		height: 200px;
    position: relative;
    overflow:hidden;
	}
	
	.promotion_img {
    width: 100%;
    height: 200px;
    position: absolute;
    transition: transform 2s;
		left:100%;
	}
	
	.container_body {
		overflow: hidden;
    position: relative;
    width: 1300px;
    margin: auto;
	}
	
	.recruit_wrap {
		width: 950px;
    position: relative;
    margin: auto;
    float: left;
    padding-left: 50px;
    box-sizing: border-box;
	}
	
	.item {
		display: inline-block;
    width: 200px;
    height: 200px;
    border: 1px solid #00000042;
    margin-bottom:6px;
	}
	
	.item_link {
		display: block;
		text-decoration:none;
		color: black;
	}
	
	.company_tx {
		display: inline-block;
    margin: auto;
    width: 200px;
    text-align: center;
    height: 50px;
    padding-top: 35px;
    line-height: 55px;
    font-size: 28px;
	}
	
	.title_tx {
    padding: 20px;
    display: block;
    overflow: hidden;
	}
	
	.login_wrap {
		width: 300px;
    height: 200px;
    position: relative;
    float: right;
	}
	
	.btn_box {
    width: 150px;
    height: 45px;
    display: block;
    margin: auto;
    text-align: center;
	}
	
	.btn_box a {
		width: 150px;
    height: 40px;
    display: block;
    line-height: 40px;
    background: #00adffde;
    color: white;
    font-weight: 700;
    text-decoration: none;
	}
	
	.myInfo {
		background: #0000001f;
	}
	
	.myInfo>a {
		display: block;
    padding: 20px 0 20px 0;
	}
	
	.myInfo .btn_box {
		width: 100%;
    height: 45px;
	}
	
	.myInfo .btn_box ul {
		list-style: none;
    padding: 2px 0 0 0;
    overflow: auto;
	}
	
	.myInfo .btn_box ul li {
		float: left;
    box-sizing: border-box;
    position: relative;
    margin: 0 2px;
    width:96px;
	}
	
	.myInfo .btn_box ul li a{
    width: 100%;
    height: 40px;
    line-height: 40px;
    background: white;
    color: black;
    text-decoration: none;
	}
	
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="logo">
				<img src="/test/img/mainlogo.jpg"/>
			</div>
			
			<div class="advertisement">
				<div class="promotion">
					<img src="/test/img/promotion1.jpg" class="promotion_img">
					<img src="/test/img/promotion2.jpg" class="promotion_img">
					<img src="/test/img/promotion3.jpg" class="promotion_img">
					<img src="/test/img/promotion4.jpg" class="promotion_img">
				</div>
			</div>
		</div>
		<div class="container_body">
			<div class="login_wrap">
				<c:if test="${loginInfo==null}">
				
				<div class="btn_box">
					<a href="loginForm">로그인</a>
				</div>
				<div class="btn_box">
					<a href="signupForm">회원가입</a>
				</div>
				<div>
					<a href="">아이디 찾기</a>/
					<a href="">비밀번호 찾기</a>
				</div>
				</c:if>
				
				<c:if test="${loginInfo!=null}">
				<div class="myInfo">
					${loginInfo.name}님 안녕하세요. 
					<button type="button" onclick="location.href='logout'">로그아웃</button>
					<a href="mypage">내 정보 ></a>
					<div class="btn_box">
						<ul>
							<c:if test="${loginInfo.role=='employee'}">
							<li><a href="resume/myResume">이력서관리</a></li>
							</c:if>
							<c:if test="${loginInfo.role=='employer'}">
							<li><a href="recruit/myRecruitList">채용공고관리</a></li>
							</c:if>
							<li><a href="contract/myContractList">계약서 보기</a></li>
							<li><a href="user/scrap">스크랩</a></li>
						</ul>
					</div>
				</div>
				</c:if>
			</div>
			
			
			<div class="recruit_wrap">
				<!-- <div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?recnum={recruit_id}" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?recnum={recruit_id}" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div>
				<div class="item">
					<a href="http://localhost:8080/test/recruit/detailView?" class="item_link">
						<span class="company_tx">company</span>
						<span class="title_tx">title</span>
					</a>
				</div> -->
			</div>
		</div>
		
	</div>
	
	<script type="recruitItem-template" id="recruitItem">
		<div class="item">
			<a href="http://localhost:8080/test/recruit/detailView?recnum={recruit_id}" target="_blank" class="item_link">
				<span class="company_tx">{company}</span>
				<span class="title_tx">{title}</span>
			</a>
		</div>
	</script>
	
	<script>
		var promotionBefore=-1;
		var promotionNow=0;
		var promotionNext=1;
		
		var loadRecruitStartSpot=0;
		
		document.addEventListener("DOMContentLoaded",function(){
			init_promotion();
			loadRecruit();
		});
		
		function init_promotion() {			
			promotions = document.querySelectorAll(".promotion .promotion_img");
			promotions_length = promotions.length;
			if(promotions!="undefined" && promotions.length!=0){
				promotions[0].style.transform = "translate(-100%)";
				setTimeout(()=>{
					animate_promotion();	
				},2000);
			}
		}
		
		/*     Promotion 애니매이션  */
		function animate_promotion(){
						
			promotions[promotionNext].style.zIndex = 0;
			promotions[promotionNow].style.transform = "translate(-200%)";
			promotions[promotionNext].style.transform = "translate(-100%)";
			
			if(promotionBefore!="undefined" && promotionBefore!=-1){
				promotions[promotionBefore].style.zIndex = -1;
				promotions[promotionBefore].style.transform = "translate(0%)";
			}	
			
			setTimeout(()=> {
		
				promotionBefore++;
				promotionNow++;
				promotionNext++;
				
				if(promotionNext==promotions_length)
					promotionNext = 0;
				if(promotionNow==promotions_length)
					promotionNow = 0;
				if(promotionBefore==promotions_length)
					promotionBefore = 0;
				
				animate_promotion();
			},3000);
		
		}
		
		function loadRecruit(){
			let url = "recruit/loadAllRecruit?start="+loadRecruitStartSpot;
			sendAjax(url,"recruit");
			loadRecruitStartSpot+=8;
		}
		
		function sendAjax(url,what){
			var oReq = new XMLHttpRequest();
			oReq.addEventListener("load", function () {
				var data = JSON.parse(oReq.responseText);	
        makeTemplate(data, what);
      });
			
			oReq.open("GET", url);
	    oReq.send();
		}
		
		function makeTemplate(data, what) {
			let html;
			let resultHtml="";
			
			if(data.result==="success"){
				let items = data.items;
				if(what==="recruit"){
					html = document.querySelector("#recruitItem").innerHTML;
					console.log(html);
					for(let item of items){
						console.log(item);
						resultHtml += html.replace("{recruit_id}",item._id).replace("{company}",item.company).replace("{title}",item.title);	
					}
				}
			}else {
				resultHtml+="<div><h2>채용공고가 없습니다.</h2></div>"
			}
			
			document.querySelector(".recruit_wrap").innerHTML += resultHtml;
		}
	</script>
</body>
</html>