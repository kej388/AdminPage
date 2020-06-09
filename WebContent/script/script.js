function productCheck() {
	if (document.frm.name.value.length == 0) {
		alert("상품명을 써주세요");
		frm.name.focus();
		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	if (isNaN(document.frm.price.value)) {
		alert("숫자를 입력해야 합니다.");
		frm.price.select();
		return false;
	}
	let ben = ["원숭이", "이발소", "소방차", "차승원", "원빈", "빈수레", "레코드", "드라마", "마스크", "크레용"];
	for(var i = 0; i < ben.length; i++) {
		if(document.frm.title.value == ben[i]) {
			alert("금칙어를 사용하였습니다. 다시 입력해주세요");
			return false;
		}
		if(document.frm.content.value == ben[i]) {
			alert("금칙어를 사용하였습니다. 다시 입력해주세요");
			return false;
		}
	}
}

function deleteCheck() {
	var check = confirm("삭제하시겠습니까?");
	if(check == false) {
		return false;
	}
}