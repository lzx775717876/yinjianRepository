function commonGetUserInfo() {
    let param = {
        token: localStorage.getItem('token')
    }
    $.ajax({
        url: 'http://47.114.43.71:8080/user/getUserInfo',
        type: "POST",
        data: JSON.stringify(param),
        async: false,
        cache: false,
        contentType: 'application/json;charset=utf-8',
        beforeSend: function (request) {
            request.setRequestHeader('token', localStorage.getItem('token'));
        },
        success: function(result) {
            $('#top-user-name').text(result.userInfo.name);
        },
        error: function(xMLHttpRequest, textStatus, errorThrown) {
            $('#top-user-name').text("未登录");
        }
    });
}

function logout() {
    localStorage.setItem('token', null);
    window.location.reload();
}

setTimeout(function (){
    commonGetUserInfo();
},0)