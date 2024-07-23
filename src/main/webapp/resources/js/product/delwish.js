const delBtn = document.getElementsByClassName("btn btn-danger");

let id;

for(let i =0;i<delBtn.length;i++){
    delBtn[i].addEventListener("click",(e)=>{
       id = e.target.getAttribute("data-del-id");
        
       //부모 엘리먼트 삭제
       document.getElementById("parentrow "+id).remove();

        //DB에서 삭제
       fetch("./delWish?item_id="+id,{
        method:"GET"
        })
    
    })
}


