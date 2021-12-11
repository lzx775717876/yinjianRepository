$(document).ready(function () {
    $('#user-regist').click(function () {
        Swal.fire(
            {
                title: "你以为有注册功能吗？",
                text: '想多了系列',
                icon: 'error',
                confirmButtonColor: '#5438dc'
            }
        )
    });
    $(document).keypress(function(event){
        if (event.keyCode == 13) {
            userLogin();
        }
    })
})

function userLogin() {
    console.log("haha");
    let param = {
        userName: $('#username').val(),
        password: $('#userpassword').val()
    }
    $.ajax({
        url: 'http://47.114.43.71:8080/user/login',
        type: "POST",
        data: JSON.stringify(param),
        async: false,
        cache: false,
        contentType: 'application/json;charset=utf-8',
        success: function(result) {
            console.log(result);
            if (result.error == 'error') {
                Swal.fire(
                    {
                        title: "脑瘫啊，没上去！",
                        text: '用户名和密码也不对啊，你来这干得儿来了???',
                        icon: 'error',
                        confirmButtonColor: '#5438dc'
                    }
                )
                return;
            }
            localStorage.setItem("token", result.token);
            window.location.href = "/index.html"
        },
        error: function(xMLHttpRequest, textStatus, errorThrown) {
            Swal.fire(
                {
                    title: "服务器故障",
                    text: '肯定是出了点什么问题，至于这个问题是什么，那就需要经过一系列的探究才能发现了，然后至于这个问题该怎么解决，就得考虑这个问题是如何发生的，然后再进行相应的修改，修改完后还需要进行相应的测试，只有确定没有任何问题了以后，诶，就可以把这个不知道是什么问题的问题改好了，真是简单呢！',
                    icon: 'error',
                    confirmButtonColor: '#5438dc'
                }
            )
        }
    });
}


