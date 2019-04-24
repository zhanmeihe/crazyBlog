$(".sure-aubio").click(function () {
        // 查看视频大小(mb)
        // var fileObj = document.getElementById(n).files[0];
        // var relSize = parseInt(fileObj.size/1024/1024);
        // if(relSize > 10){ // 大于10mb
        //     alert('提示','视屏超过10MB,请重新上传！');
        //     return false;
        // }
        // 查看视频类型
        var tv_id =document.getElementsByClassName("s-scene").value;//根据id得到值
        var index= tv_id.indexOf(".");//得到"."在第几位
        tv_id=tv_id.substring(index).toLowerCase();//截断"."之前的，得到后缀
        if(tv_id!=".rb"&&tv_id!=".rmvb"&&tv_id!=".mp4"&&tv_id!=".flv"){  //根据后缀，判断是否符合格式
            alert("视频格式不正确，请重新上传");
            return false;
        }else {
            window.location.href = "index.html";
        }
});