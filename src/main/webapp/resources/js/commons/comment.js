const commentList = document.getElementById("commentList");
const commentAdd = document.getElementById("commentAdd");
const boardContents = document.getElementById("boardContents");
const commentClose = document.getElementById("commentClose");
const addWish = document.getElementById("addwish");

getList();

function getList(){
    fetch("commentList?item_id="+addWish.getAttribute("data-product-id"),{
        method:"GET"
    })
    .then((res)=>res.text())
    .then((res)=>commentList.innerHTML=res)
}

commentAdd.addEventListener("click", ()=>{
    commentClose.click();
    let contents = boardContents.value;

    fetch("commentAdd",{
        method:"post",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
            },
        body:"boardcontents="+contents+"&item_id="+addWish.getAttribute("data-product-id")
    })
    .then((res)=>{res.text()})
    .then((res)=>{
        res=res.trim();
        if(res>0){
            alert("성공")
        } else {
            alert("실패")
        }
    }).catch(()=>{alert("실패")})

    boardContents.value="";


})