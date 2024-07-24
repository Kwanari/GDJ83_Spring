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
 const passworderror = document.getElementById("password-error");
 const passwordeqError = document.getElementById("password-eqError");
 const idfail = document.getElementById("idfail");

 userName.addEventListener("blur", ()=>{
    fetch("./idCheck?member_id="+userName.value,{
        method:"GET"
    })
    // .then((res)=>{res.text})
    // .then((res)=>{
    //     res.trim();

    //     if(res==0){
    //         userName.value="";
    //         idfail.innerText="ID가 중복됩니다.";
    //     } 
    // })
 })


 passwordCheck.addEventListener("change", function(){
    if(password.value != passwordCheck.value){
        passwordCheck.value="";
        passwordCheck.focus();
        pserror.innerHTML="password가 틀립니다.";
    } else {
        pserror.innerHTML="";
        passworderror.innerHTML="";
    }
 })

 password.addEventListener("change", function(){
    if(password.value != passwordCheck.value){
        pserror.innerHTML="password가 틀립니다.";
        passwordCheck.focus();
    } else {
        pserror.innerHTML="";
        passworderror.innerHTML="";
    }
 })


 
 btn.addEventListener("click", function (){

    if(userName.value==''){
        alert('ID를 입력하세요.');
        userName.focus();
        return;
    }

    if(password.value==''){
        passworderror.innerHTML="password는 필수입니다.";
        password.focus();
        return;
    } else if (password.value.length<8) {
        passworderror.innerHTML="password는 8자가 넘어야합니다.";
        password.focus();
        return;
    }

    if(name.value==''){
        nameer.innerHTML="이름 입력 하세요.";
        name.focus();
        return;
    }

    if(email.value==''){
        emailer.innerHTML="email 입력 하세요.";
        email.focus();
        return;
    }

    if(phone.value==''){
        phoneer.innerHTML="phone 입력 하세요.";
        phone.focus();
        return;
    }

    if(address.value==''){
        addresser.innerHTML="address 입력 하세요.";
        address.focus();
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