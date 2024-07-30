const commentList = document.getElementById("commentList");
const commentAdd = document.getElementById("commentAdd");
const boardContents = document.getElementById("boardContents");
const commentClose = document.getElementById("commentClose");
const addWish = document.getElementById("addwish");
const delbtn = document.getElementsByClassName("delbtn");
const openModal = document.getElementById("openModal");

let flag=true;
let boardnum=0;

openModal.addEventListener("click",()=>{
    flag=true;
    boardContents.value="";
    commentAdd.innerHTML="댓글 등록";
})

let productid=addWish.getAttribute("data-product-id");

commentList.addEventListener("click", (e)=>{
    
    //commentList 내 엘리먼트의 a태그, submit 등 기본 이벤트 동작 막음
    e.preventDefault();

    //page관련 버튼들 class에 pn을 넣어놨다.
    //e.target으로 해당 범위에 있는 엘리먼트 class에 pn이 포함된 경우
    if(e.target.classList.contains("pn")){
        //선택한 범위의 엘리먼트 속성 중 data-page-num 의 값을 가져온다
        //java에서 pager이용하여 jsp에 model로 넘겨준 값이 온다.
        let p = e.target.getAttribute("data-page-num");

        getList(p);
    }

    if(e.target.classList.contains("delbtn")){
        boardnum = e.target.getAttribute("data-del-id")
        

        alert("상품번호: "+productid+", 댓글번호: "+boardnum)

        delComment(boardnum);
    }

    if(e.target.classList.contains("ups")){
        flag=false;
        
        boardnum = e.target.getAttribute("data-del-id")
        
        let c = e.target.getAttribute("data-update-con")

        c = document.getElementById(c).innerHTML

        boardContents.value = c

        commentAdd.innerHTML="댓글 수정";


    }

})

function delComment(boardnum){
    fetch("commentDelete",{
        method:"post",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
            },
        body:"item_id="+productid+"&boardnum="+boardnum
    })
    .then((res)=>{return res.text()})
    .then((res)=>{
        res=res.trim();
        if(res>0){
            getList(1);
            alert("삭제 성공");
        } else {
            alert("삭제 실패");
        }

    }).catch(()=>{alert("삭제실패");})
}

getList(1);

function getList(page){

    fetch("commentList?item_id="+productid+"&page="+page,{
        method:"GET"
    })
    .then((res)=>res.text())
    .then((res)=>commentList.innerHTML=res)
}

commentAdd.addEventListener("click", ()=>{
    let contents = boardContents.value;
    let url="commentAdd";

    const form = new FormData();

    form.append("boardcontents",contents)
    form.append("item_id", productid)
    form.append("boardnum", boardnum)

    // let param="boardcontents="+contents+"&item_id="+productid;

    if(contents==null||contents==""){
        alert("내용 필요함")
        return;
    }

    console.log(flag)
    
    if(!flag){
        url="commentUpdate";
        // param="boardcontents="+contents+"&boardnum="+boardnum;
    }

    console.log(url)
    // console.log(param)
    
    commentClose.click();

        fetch(url,{
            method:"post",
            body:form
        })
        .then((res)=>{return res.text()})
        .then((res)=>{
            res=res.trim();
            if(res>0){
                alert(res)
                getList(1);
            } else {
                alert("실패")
            }
        }).catch(()=>{alert("실패")})

        boardContents.value="";
    

})