function confirmEdit(){
	if(window.confirm('編集を行います。よろしいですか？')){
		return true;
	}
	else {
		return false;
	}
}

function confirmLogout(){
	if(window.confirm('ログアウトします。よろしいですか？')){
		return true;
	}
	else {
		return false;
	}
}

function confirmBackToMainMenu(){
	if(window.confirm('メインメニューへ戻ります。よろしいですか？')){
		return true;
	}
	else {
		return false;
	}
}

function setCommonWindowSize(){
	resizeTo(850, 500);
}