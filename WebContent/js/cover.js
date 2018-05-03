// 验证中文名称
function isChinaName(name) {
    var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
    return pattern.test(name);
}
// 验证手机号
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}
// 验证身份证
function isCardNo(card) {
    var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    return pattern.test(card);
}
function formValidate() {
    // 判断名称
    if ($.trim($('.name').val()).length == 0) {
        alert('名称没有输入');
        $('.name').focus();
        return false;
    } else if (isChinaName($.trim($('.name').val())) == false) {
        alert('名称不合法');
        $('.name').focus();
        return false;
    }
    
	//xingbie
    else if($('input:radio[name="identity"]:checked').val()==null){
		alert("请选择性别!");
		return false;
	}
    //判断手机号
    else if ($.trim($('.phone').val()).length == 0) {
        alert("请输入手机号");
        $('.phone').focus();
        return false;
    } else if (isPhoneNo($.trim($('.phone').val()) == false)) {
        alert("手机号码不正确");
        $('.phone').focus();
        return false;
    }
    // 验证身份证
    else if ($.trim($('.identity').val()).length == 0) {
        alert('身份证号码没有输入');
        $('.identity').focus();
        return false;
    } else if (isCardNo($.trim($('.identity').val())) == false) {
        alert('身份证号不正确；');
        $('.identity').focus();
        return false;
    }
    /**
     * 公种
     */
    else if ($('input:checkbox[name="WorkType"]:checked').val()==null){
		alert("请选择工种!");
		return false;
		 
	}
    //xingbie
    else if($('input:radio[name="identity"]:checked').val()==null){
        alert("请选择性别!");
        return false;
    }else {
        window.location.href = "/APP/Userinfo/Idcard.shtml";
    }
    // 如果没有错误则提交 
}

function formValidatemodify() {
    // 判断名称
    if ($.trim($('.name').val()).length == 0) {
        alert('名称没有输入');
        $('.name').focus();
        return false;
    } else if (isChinaName($.trim($('.name').val())) == false) {
        alert('名称不合法');
        $('.name').focus();
        return false;
    }
    
	//xingbie
    else if($('input:radio[name="identity"]:checked').val()==null){
		alert("请选择性别!");
		return false;
	}
    //判断手机号
    else if ($.trim($('.phone').val()).length == 0) {
        alert("请输入手机号");
        $('.phone').focus();
        return false;
    } else if (isPhoneNo($.trim($('.phone').val()) == false)) {
        alert("手机号码不正确");
        $('.phone').focus();
        return false;
    }
    //xingbie
    else if($('input:radio[name="identity"]:checked').val()==null){
        alert("请选择性别!");
        return false;
    }else {
        window.location.href = "/Userinfo/Idcard.shtml";
    }
    // 如果没有错误则提交
    
    
}
//function Validateimg() {
//	 if ($.trim($('.headPic').val()).length == 0) {
//		alert('请选择图片上传！');
//		$('.headPic').focus();
//		return false;
//	}else {
//		 window.location.href = "index.jsp";
//	}
//	
//}
function formValidaPic() {
    // 判断名称
	var ff = document.getElementsByName("'headPic");
	alert(ff[1].value);
}
