/**
 * 순수 자바스크립트 형식 작성해줄 수 있고, jquery 형식도 넣어줄 수 잇는 공간
 */

 /*
 <button onclick="btn()">연결테스트</button>
 를 클릭했을 때 나오는 기능
 */
 function btn(){
	alert("클릭되었습니다.");
 }
 
 /*
 <button id="btn">연결테스트</button>
 를 클릭했을 때 나오는 기능
 */
document.querySelector("#btn").addEventListener("click",btn);

 /*
 <button id="btn">연결테스트</button>
 를 제이쿼리 형식으로 변경하기
 */

$(document).ready(function(){
$("#btn").click(btn);
 
 });