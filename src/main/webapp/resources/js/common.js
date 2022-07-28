/**
 * 
 */
window.onload = function(){
    var money = document.querySelectorAll(".money")
	
	for (let i = 0; i < money.length; i++){
    var moneyStr = money[i].innerText.toString()
    money[i].innerText = moneyStr.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
}

  function inputNumberFormat(obj) {
     obj.value = comma(uncomma(obj.value));
 }

 function comma(str) {
     str = String(str);
     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
 }

 function uncomma(str) {
     str = String(str);
     return str.replace(/[^\d]+/g, '');
 }
 
 const autoHyphen2 = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

 const autoHyphenSsn2 = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
  .replace(/^(\d{0,6})(\d{0,8})$/g, "$1-$2").replace(/(\-{1,2})$/g, "");
}