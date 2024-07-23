const addwish = document.getElementById("addwish");
const wishResult = document.getElementById("wishResult");



addwish.addEventListener("click", (e)=>{
    let id =addwish.getAttribute("data-product-id");
    //e.target.getAttribute("data-product-id"); 위와 같다

    console.log(id);

    fetch("./addWish?item_id="+id, {
        method:"GET"
    })

    // 위의 fetch 이후 응답 개체가 들어옴
    .then((res)=>{return res.text()})

    .then((res)=>{
        if(res>0){
            let check = confirm("wishlist 확인?")

            if(check){
                location.href="./wishList";
            }
        } else {
            alert("wishlist 추가 실패")
        }
    }).catch(()=>{
    alert("오류발생");
    })
})


// addwish.addEventListener("click", function(){
//     fetch("./addWish?num=15&name=aa", {
//         method:"GET"
//     })
// })23