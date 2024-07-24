const delBtn = document.getElementsByClassName("btndel");
const chAll = document.getElementById("chAll");
const ch = document.getElementsByClassName("ch");
const delAll = document.getElementById("delAll");

delAll.addEventListener("click", ()=>{
    let pm="";
    let i = 0;
    const e = [];

    for(let c of ch){
        if(c.checked){
            if(i==0){
                pm = pm+"?item_id="+c.id
                i++;
                e.push(c.id)
            } else {
                pm = pm+"&item_id="+c.id
                e.push(c.id)
            }
        }
    }

    console.log(pm);

    fetch("delWish"+pm,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>{
        res.trim();

        if(res>0){

            // for(let ele of e){
            //     document.getElementById("parentrow "+ele).remove();
            // }


            for(let c of ch){
                if(c.checked){
                    document.getElementById("parentrow "+c.id).remove();
                }
            } 

        }else {
            alert("전체삭제 실패")
        }
    }).catch(()=>{alert("전체삭제 실패")})
})

chAll.addEventListener("click",()=>{
    for(check of ch){
        check.checked = chAll.checked;
    }
})


for(check of ch){
    check.addEventListener("click",()=>{
        for(check of ch){
            if(!check.checked){
                chAll.checked  = false;

                break;
            } else {
                chAll.checked = true;
            }
        }
    })
}


for(let i =0;i<delBtn.length;i++){
    delBtn[i].addEventListener("click",(e)=>{
        
        let id = e.target.getAttribute("data-del-id");
        
        //DB에서 삭제
        fetch("./delWish?item_id="+id,{
            method:"GET"
        }).then((res)=>{return res.text()})
        .then((res)=>{
            res=res.trim();
            
            if(res>0){
                //부모 엘리먼트 삭제
                document.getElementById("parentrow "+id).remove();
            } else {
                alert("삭제 실패")
            }


        }).catch(()=>{alert("삭제 실패")});
    })
}


