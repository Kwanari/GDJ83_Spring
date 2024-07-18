/**
 * 
 */
 
 // let, const
 //함수 선언
 //function 함수명(매개변수 선언){return}
 
 const btn = document.getElementById("btn");
 const userName = document.getElementById("userName");
 const password = document.getElementById("password");
 const passwordCheck = document.getElementById("passwordCheck");
 const name = document.getElementById("name");
 const phone = document.getElementById("phone");
 const email = document.getElementById("email");
 const ch = document.getElementsByClassName("ch");//배열 형식
 const frm = document.getElementById("frm");
 const passwordError = document.getElementById("password-error");
 const passwordeqError = document.getElementById("password-eqError");


 passwordCheck.addEventListener("blur", function(){
    passwordeqError.innerText="";
    console.log("test1")
    if(password.value != passwordCheck.value){
        console.log("test2")
        passwordeqError.innerText="Password가 일치 하지 않음";
        passwordCheck.value="";
        return;
    }

 })
 
 btn.addEventListener("click", function(){
    passwordError.innerHTML="";
    if(userName.value ==""){
        alert('ID는 필수 입니다');
        userName.focus();
        return;
    }
    if(password.value=="" || password.value.length<6){

        passwordError.innerHTML="Password는 비어 있거나 6글자 이상이어야 함"
        password.focus();
        return;
    }
 })
 
 //for(데이터타입 변수명:collenction)
//  btn.addEventListener("click", function(){
//     const checks= [false, false, false, false, false];
//     for(let i=0;i<ch.length;i++){ 
//         if(ch[i].value !=""){
//             checks[i]=true;
//         }  
//     }  
//     let result=true;
//     for(let c of checks){
//         console.log(c);
//         if(!c){
            
//             result=false;
//         }
//     }
//     if(result){
//         alert('OK');
//         frm.submit();
//     }else {
//         alert('fail');
//     }

//  });